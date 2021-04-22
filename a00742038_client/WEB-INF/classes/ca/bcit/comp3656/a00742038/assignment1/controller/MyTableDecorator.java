package ca.bcit.comp3656.a00742038.assignment1.controller;

import java.text.SimpleDateFormat;

import org.displaytag.decorator.TableDecorator;

import ca.bcit.comp3656.a00742038.assignment1.types.Employee;


public class MyTableDecorator extends TableDecorator {
	
	public String getDob() {
		Employee employee = (Employee) this.getCurrentRowObject();
		return new SimpleDateFormat("yyyy-MM-dd").format(employee.getDob().toGregorianCalendar().getTime());
	}
}
