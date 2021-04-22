package ca.bcit.comp3656.a00742038.assignment1.jaxws.service;

import javax.annotation.PostConstruct;
import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;

import ca.bcit.comp3656.a00742038.assignment1.data.Employee;
import ca.bcit.comp3656.a00742038.assignment1.types.AddEmployeeRequest;
import ca.bcit.comp3656.a00742038.assignment1.types.AddEmployeeResponse;
import ca.bcit.comp3656.a00742038.assignment1.types.DeleteEmployeeRequest;
import ca.bcit.comp3656.a00742038.assignment1.types.DeleteEmployeeResponse;
import ca.bcit.comp3656.a00742038.assignment1.types.FindEmployeeRequest;
import ca.bcit.comp3656.a00742038.assignment1.types.FindEmployeeResponse;
import ca.bcit.comp3656.a00742038.assignment1.types.ListEmployeeResponse;
import ca.bcit.comp3656.a00742038.assignment1.types.ObjectFactory;
import ca.bcit.comp3656.a00742038.assignment1.types.ResponseCode;
import ca.bcit.comp3656.a00742038.assignment1.xml.AddError;
import ca.bcit.comp3656.a00742038.assignment1.xml.DeleteError;
import ca.bcit.comp3656.a00742038.assignment1.xml.EmployeeServicesPortAPI;
import ca.bcit.comp3656.a00742038.assignment1.xml.FindError;
import ca.bcit.comp3656.a00742038.assignment1.xml.ListError;

@WebService(endpointInterface = "ca.bcit.comp3656.a00742038.assignment1.xml.EmployeeServicesPortAPI")
public class EmployeeAccess implements EmployeeServicesPortAPI {
	
	private EmployeeService empService;
	private ObjectFactory factory;
	
	@PostConstruct
	public void initConstruct() {
		empService = new EmployeeServiceImpl();
		factory = new ObjectFactory();

	}

	@Override
	public ListEmployeeResponse listEmployees() throws ListError {
		
		ListEmployeeResponse response = factory.createListEmployeeResponse();
		ResponseCode responseCode = factory.createResponseCode();
		
		try {
			for(Employee employee : empService.listEmployees()) {
			response.getResult().add(employee.toEmployeeAccess());
			}
		} catch (EmployeeServiceException | DatatypeConfigurationException e) {
			responseCode.setCode(404);
			responseCode.setDesc("System Error!");
			response.setResponseCode(responseCode);
		}
		
		return response;
	}

	@Override
	public AddEmployeeResponse add(AddEmployeeRequest addReq) throws AddError {

		AddEmployeeResponse response = factory.createAddEmployeeResponse();
		ResponseCode responseCode = factory.createResponseCode();
	
		Employee emp = Employee.fromEmployeeAccess(addReq.getEmployee());
		try {
			
			empService.add(Employee.fromEmployeeAccess(addReq.getEmployee()));
			
			responseCode.setCode(200);
			responseCode.setDesc("Employee: " + emp.getFirstName() + " " + emp.getLastName() + " added successfully!");
			response.setResponseCode(responseCode);
		} catch (EmployeeServiceException e) {
			System.out.println(e.getLocalizedMessage());
			responseCode.setCode(503);
			responseCode.setDesc("Failed to add Employee: " + emp.getFirstName() + " " + emp.getLastName());
			response.setResponseCode(responseCode);
		}
		return response;
	}

	@Override
	public DeleteEmployeeResponse delete(DeleteEmployeeRequest deleteReq) throws DeleteError {
		
		DeleteEmployeeResponse response = factory.createDeleteEmployeeResponse();
		ResponseCode responseCode = factory.createResponseCode();
		
		try {
			empService.delete(deleteReq.getEmpID());
			responseCode.setCode(200);
			responseCode.setDesc("Employee with ID: " + deleteReq.getEmpID() + " has been removed successfully");
			response.setResponseCode(responseCode);
		} catch (EmployeeServiceException e) {
			responseCode.setCode(504);
			responseCode.setDesc("Failed to remove employee with ID : " + deleteReq.getEmpID());
			response.setResponseCode(responseCode);
		}		
		return response;
	}

	@Override
	public FindEmployeeResponse findEmployee(FindEmployeeRequest findEmpReq) throws FindError {

		FindEmployeeResponse response = factory.createFindEmployeeResponse();
		ResponseCode responseCode = factory.createResponseCode();
		try {
			Employee employee = empService.findEmployee(findEmpReq.getEmpID());
			responseCode.setCode(200);
			responseCode.setDesc("Found: " + employee.getFirstName()
										   + " " 
										   +  employee.getLastName() 
										   + ", ID: " 
										   + employee.getId());
			response.setResponseCode(responseCode);
			response.setFoundResult(employee.toEmployeeAccess());
		} catch (EmployeeServiceException | DatatypeConfigurationException e) {
			
			responseCode.setCode(505);
			responseCode.setDesc("No match found for ID: " + findEmpReq.getEmpID());
			response.setResponseCode(responseCode);;
		}
		
		return response;
	}

}
