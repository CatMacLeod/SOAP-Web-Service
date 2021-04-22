/**
 * 
 */
package ca.bcit.comp3656.a00742038.assignment1.jaxws.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;

import ca.bcit.comp3656.a00742038.assignment1.data.Employee;
import ca.bcit.comp3656.a00742038.assignment1.data.EmployeeDAO;
import ca.bcit.comp3656.a00742038.assignment1.data.EmployeeDAOImpl;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO dao;
	private EntityManager entityManager;
	
	public EmployeeServiceImpl() {
		dao = new EmployeeDAOImpl();
		this.entityManager = Persistence.createEntityManagerFactory("EmployeePU").createEntityManager();
	}

	@Override
	public List<Employee> listEmployees() throws  EmployeeServiceException  {
			try {
				return dao.listEmployees(entityManager);
			} catch (Exception e) {
				throw new EmployeeServiceException(e.getMessage());
			}
	}

	@Override
	public void add(Employee employee)throws EmployeeServiceException {
		
		try {
			dao.add(entityManager, employee);
		} catch (Exception e) {
			throw new EmployeeServiceException( e.getMessage());
		}
	}

	@Override
	public void delete(String inputId) throws EmployeeServiceException {

			try {
				dao.delete(entityManager, inputId);
			} catch (Exception e) {
				throw new EmployeeServiceException( e.getMessage());
			}

	};

	@Override
	public Employee findEmployee(String inputId) throws EmployeeServiceException{
		
		try {
			return dao.findEmployee(entityManager, inputId);
		} catch (Exception e) {
			throw new EmployeeServiceException(e.getMessage());
		}
	};
}
