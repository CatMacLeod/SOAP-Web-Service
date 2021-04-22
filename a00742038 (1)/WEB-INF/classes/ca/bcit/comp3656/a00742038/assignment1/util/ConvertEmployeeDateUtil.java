package ca.bcit.comp3656.a00742038.assignment1.util;

import ca.bcit.comp3656.a00742038.assignment1.data.Employee;

public class ConvertEmployeeDateUtil {

	// Map API Employee to employee entity
	public static Employee fromEmployeeAccess(ca.bcit.comp3656.a00742038.assignment1.types.Employee apiEmployee) {
		return new Employee(apiEmployee.getId(),
							apiEmployee.getFirstName(),
							apiEmployee.getLastName(),
							apiEmployee.getDob().toGregorianCalendar().getTime());
	}

}
