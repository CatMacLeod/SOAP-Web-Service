/**
 * 
 */
package ca.bcit.comp3656.a00742038.assignment1.jaxws.service;
import java.util.List;

import ca.bcit.comp3656.a00742038.assignment1.data.Employee;

public interface EmployeeService {

	public List<Employee> listEmployees() throws EmployeeServiceException ;
	
	public void add(Employee employee)  throws EmployeeServiceException;
	
	public void delete(String inputId) throws EmployeeServiceException;
	
	public Employee findEmployee(String inputId) throws EmployeeServiceException;
}
