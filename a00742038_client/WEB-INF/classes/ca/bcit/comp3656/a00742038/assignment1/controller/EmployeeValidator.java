package ca.bcit.comp3656.a00742038.assignment1.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import ca.bcit.comp3656.a00742038.assignment1.exceptions.EmployeeServiceValidationException;
import ca.bcit.comp3656.a00742038.assignment1.types.Employee;

public final class EmployeeValidator {

	private static final SimpleDateFormat SLASH_DATE = new SimpleDateFormat("yyyy/MM/dd");
	private static final SimpleDateFormat DASH_DATE = new SimpleDateFormat("yyyy-MM-dd");

	
	
	public static XMLGregorianCalendar convertDate(Date inputDate) throws DatatypeConfigurationException {
		GregorianCalendar gregory = new GregorianCalendar();
		gregory.setTime(inputDate);

		XMLGregorianCalendar calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
		return calendar;
	}

	public static boolean validateEmployeeBean(HttpServletRequest req, Employee employee) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Employee>> violations = validator.validate(employee);

		for (ConstraintViolation<Employee> violation : violations) {
			req.setAttribute(violation.getPropertyPath().toString() + "_violation", violation.getMessage());
		}
		return violations.isEmpty();
	}

	public static boolean validateDeleteID(HttpServletRequest request, String id) {
		boolean isValid = true;
		
		if (request.getParameter("deleteID").isEmpty()) {
			request.setAttribute("delete_violation", "ID cannot be empty");
			isValid = false;
			
		} else if (!Pattern.matches("^A0[0-9]{7}$", request.getParameter("deleteID"))) {
			request.setAttribute("delete_violation", "ID must begin with A0******* and have 9 character length");
			isValid = false;
		}
		return isValid;	
	}
	
	public static void validateEmployeeInput(HttpServletRequest request, Employee employee) {

		// First name
		if (request.getParameter("firstName").isEmpty()) {
			request.setAttribute("firstName_violation", "First name cannot be empty");
		} else if (request.getParameter("firstName").length() < 2 || request.getParameter("firstName").length() > 100) {
			request.setAttribute("firstName_violation", "First name must be between 2 and 100 characters long");
		}

		// Last name
		if (request.getParameter("lastName").isEmpty()) {
			request.setAttribute("lastName_violation", "Last name cannot be empty");
		} else if (request.getParameter("lastName").length() < 2 || request.getParameter("lastName").length() > 100) {
			request.setAttribute("lastName_violation", "Last name must be between 2 and 100 characters long");
		}

		// ID
		if (request.getParameter("id").isEmpty()) {
			request.setAttribute("id_violation", "ID cannot be empty");
		} else if (!Pattern.matches("^A0[0-9]{7}$", request.getParameter("id"))) {
			request.setAttribute("id_violation", "ID must begin with A0*******");
		}
		
	}
	
	

	public static Date parseDateString(String dateString) throws ParseException {
		if (dateString == null || dateString.isEmpty()) {
			return null;
		}

		try {
			return SLASH_DATE.parse(dateString);
		} catch (ParseException e1) {
			return DASH_DATE.parse(dateString);
		}
	}

	public static Employee createEmployee(HttpServletRequest req) throws EmployeeServiceValidationException {

		boolean isValid = true;

		Date dateDOB = null;
		try {
			dateDOB = EmployeeValidator.parseDateString(req.getParameter("dob"));
		} catch (ParseException e) {
			isValid = false;
			dateDOB = new Date();// If provided dob isn't valid there must still be data provided for validation
									// to continue
			req.setAttribute("dob_violation", "Incompatible date format");
		}

		Employee emp = new Employee();

		try {

			emp.setId(req.getParameter("id"));
			emp.setFirstName(req.getParameter("firstName"));
			emp.setLastName(req.getParameter("lastName"));
			emp.setDob(EmployeeValidator.convertDate(dateDOB));

			EmployeeValidator.validateEmployeeInput(req, emp);
		} catch (DatatypeConfigurationException e) {

			e.getMessage();
		}

		if (!EmployeeValidator.validateEmployeeBean(req, emp) || !isValid) {// If there are JBViolations or the dob is still
															// incorrect, no add happens
			throw new EmployeeServiceValidationException("Cannot create Employee");
		}
		return emp;
	}

}
