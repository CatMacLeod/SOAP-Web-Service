/**
 * 
 */
package ca.bcit.comp3656.a00742038.assignment1.data;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 * @author catmac
 *
 */
public interface EmployeeDAO {
	
	
	public List<Employee> listEmployees(EntityManager entityManager) throws SQLException; 
	
	public void add(EntityManager entityManager, Employee employee) throws
					SQLException, 
					NotSupportedException, 
					SystemException, 
					SecurityException, 
					IllegalStateException, 
					RollbackException, 
					HeuristicMixedException, 
					HeuristicRollbackException;	

	public void delete(EntityManager entityManager, String inputId) throws 
					SQLException,
					NotSupportedException,
					SystemException, SecurityException,
					IllegalStateException,
					RollbackException,
					HeuristicMixedException,
					HeuristicRollbackException;
	
	public Employee findEmployee(EntityManager entityManager, String inputId) throws SQLException; 
}
