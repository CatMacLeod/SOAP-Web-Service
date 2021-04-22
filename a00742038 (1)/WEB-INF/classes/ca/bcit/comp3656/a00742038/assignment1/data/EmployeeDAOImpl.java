/**
 * 
 */
package ca.bcit.comp3656.a00742038.assignment1.data;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.hibernate.Session;


/**
 * @author catmac
 *
 */
public class EmployeeDAOImpl implements EmployeeDAO{

	
	
	@Override
	public List<Employee> listEmployees(EntityManager entityManager) throws SQLException {
		
		return entityManager.createNamedQuery("Employee.getEmployeeList", Employee.class).getResultList();
	}
	
	
	@Override
	public void add(EntityManager entityManager, Employee employee) throws
					SQLException,
					NotSupportedException,
					SystemException,
					SecurityException,
					IllegalStateException,
					RollbackException,
					HeuristicMixedException,
					HeuristicRollbackException  {
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
	}
	
	
	
	@Override
	public void delete(EntityManager entityManager, String inputId) throws
					SQLException,
					NotSupportedException,
					SystemException, 
					SecurityException, 
					IllegalStateException, 
					RollbackException, 
					HeuristicMixedException, 
					HeuristicRollbackException {
		
		entityManager.getTransaction().begin();
		entityManager.createNamedQuery("Employee.delete")
		.setParameter("id", inputId)
		.executeUpdate();
		entityManager.getTransaction().commit();
		entityManager.unwrap(Session.class).clear();
	}
	
	@Override
	public Employee findEmployee(EntityManager entityManager,String inputId) throws SQLException {
		
		TypedQuery<Employee> query = entityManager.createNamedQuery( "Employee.findEmployeeById", Employee.class);
		query.setParameter("id", inputId);
		return query.getSingleResult();
	}
}
