/**
 * 
 */
package ca.bcit.comp3656.a00742038.assignment1.exceptions;

/**
 * @author catmac
 *
 */
public class EmployeeServiceException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public EmployeeServiceException(String message) {
		super(message);
	}
	public EmployeeServiceException(String message, Exception e) {
		super(message, e);
	}

}
