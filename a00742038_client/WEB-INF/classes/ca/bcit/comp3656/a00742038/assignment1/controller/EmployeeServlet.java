package ca.bcit.comp3656.a00742038.assignment1.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceRef;

import ca.bcit.comp3656.a00742038.assignment1.types.AddEmployeeRequest;
import ca.bcit.comp3656.a00742038.assignment1.types.AddEmployeeResponse;
import ca.bcit.comp3656.a00742038.assignment1.types.DeleteEmployeeRequest;
import ca.bcit.comp3656.a00742038.assignment1.types.DeleteEmployeeResponse;
import ca.bcit.comp3656.a00742038.assignment1.types.Employee;
import ca.bcit.comp3656.a00742038.assignment1.types.FindEmployeeRequest;
import ca.bcit.comp3656.a00742038.assignment1.types.FindEmployeeResponse;
import ca.bcit.comp3656.a00742038.assignment1.exceptions.EmployeeServiceValidationException;
import ca.bcit.comp3656.a00742038.assignment1.jaxws.service.AddError;
import ca.bcit.comp3656.a00742038.assignment1.jaxws.service.DeleteError;
import ca.bcit.comp3656.a00742038.assignment1.jaxws.service.EmployeeAccessService;
import ca.bcit.comp3656.a00742038.assignment1.jaxws.service.EmployeeServicesPortAPI;
import ca.bcit.comp3656.a00742038.assignment1.jaxws.service.FindError;
import ca.bcit.comp3656.a00742038.assignment1.jaxws.service.ListError;
import ca.bcit.comp3656.a00742038.assignment1.types.ListEmployeeResponse;
import ca.bcit.comp3656.a00742038.assignment1.types.ObjectFactory;

/**
 * Servlet implementation class EmployeeService
 */
@WebServlet("EmployeeServlet")
public class EmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private EmployeeServicesPortAPI port;
	private ObjectFactory factory;

	private static final String MESSAGE_ATTRIBUTE = "message";

	public void init(ServletConfig config) throws ServletException {
		port = new EmployeeAccessService().getEmployeeAccessPort();
		factory = new ObjectFactory();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("empList", listEmployees(request));

		
		String URI = "/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(URI);
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("add") != null) {
			addEmployee(request);

		} else if (request.getParameter("delete") != null) {
			deleteEmployee(request);

		} else if (request.getParameter("find") != null) {
			findEmployee(request);
		}

		doGet(request, response);

	}

	private List<Employee> listEmployees(HttpServletRequest request) {

		try {
			ListEmployeeResponse responseResult = port.listEmployees();
			
			return responseResult.getResult();

		} catch (ListError e) {

			request.setAttribute(MESSAGE_ATTRIBUTE, e.getFaultInfo());
		}

		return Collections.emptyList();
	}

	private void deleteEmployee(HttpServletRequest request) {

		DeleteEmployeeRequest deleteRequest = factory.createDeleteEmployeeRequest();
		deleteRequest.setEmpID((request.getParameter("deleteID")));
		DeleteEmployeeResponse deleteResult;

		try {
			
			if(EmployeeValidator.validateDeleteID(request,deleteRequest.getEmpID())) {
				deleteResult = port.delete(deleteRequest);
				deleteResult.getResult();
				request.setAttribute("delete_code", deleteResult.getResponseCode().getCode());
				request.setAttribute("delete_desc", deleteResult.getResponseCode().getDesc());
			}
			
		} catch (DeleteError e) {

			request.setAttribute("delete_desc", e.getFaultInfo());
			request.setAttribute("delete_code", "504");

		}
	}

	private void findEmployee(HttpServletRequest request) {

		FindEmployeeRequest findRequest = factory.createFindEmployeeRequest();
		findRequest.setEmpID(request.getParameter("searchID"));
		
		try {
			
			FindEmployeeResponse findResult = port.findEmployee(findRequest);
			Employee emp = findResult.getFoundResult();

	
			
			request.setAttribute("find_code", findResult.getResponseCode().getCode());
			request.setAttribute("find_desc", findResult.getResponseCode().getDesc());
			
			if(emp != null) {
				request.setAttribute("find_name", "Found: " + emp.getFirstName());
			}

		} catch (FindError e) {

			request.setAttribute("find_desc", e.getFaultInfo());
			request.setAttribute("find_code", "505");
		}
	}

	private void addEmployee(HttpServletRequest request) {

		AddEmployeeRequest addRequest = factory.createAddEmployeeRequest();
		AddEmployeeResponse addResult;
		
		try {
			addRequest.setEmployee(EmployeeValidator.createEmployee(request));
			addResult = port.add(addRequest);
			request.setAttribute("add_code", addResult.getResponseCode().getCode());
			request.setAttribute("add_desc", addResult.getResponseCode().getDesc());

		} catch ( AddError | EmployeeServiceValidationException e) {
			request.setAttribute("add_desc", e.getMessage());
			request.setAttribute("add_code", "503");
		}
	}

	

}
