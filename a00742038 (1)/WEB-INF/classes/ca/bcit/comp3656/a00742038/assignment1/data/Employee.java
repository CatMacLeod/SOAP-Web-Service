
package ca.bcit.comp3656.a00742038.assignment1.data;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import ca.bcit.comp3656.a00742038.assignment1.types.ObjectFactory;


@Entity
@NamedQueries( {
	@NamedQuery( name = "Employee.getEmployeeList" , query = "SELECT e FROM Employee e"),
	@NamedQuery( name = "Employee.findEmployeeById" , query = "SELECT e FROM Employee e WHERE e.id = :id"),
	@NamedQuery( name = "Employee.delete" , query = "DELETE FROM Employee e WHERE e.id = :id")
} )
@Table(name = "A00742038_Employees")
public class Employee {
	
	@Id
	@Pattern(message = "ID must begin with A0*******", regexp = "^A0[0-9]{7}$" )
	@NotNull(message = "ID cannot be empty")
	@Column(unique = true)
	private String id;
	
	
	@NotNull(message = "First name cannot be empty")
	@Size(min = 2, max = 100, message = "First name must be between 2 and 100 characters long")
	@Column
	private String firstName;
	
	@NotNull(message = "Last name cannot be empty")
	@Size(min = 2, max = 100, message = "Last name must be between 2 and 100 characters long")
	@Column
	private String lastName;
	
	@NotNull(message = "Date of birth cannot be empty")
	@Column
	private Date dob;
	
	public Employee (String id, String firstName, String lastName, Date dob) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}

	public Employee () {
		
	}
	
	//Map API Employee to employee entity
	public static Employee fromEmployeeAccess(ca.bcit.comp3656.a00742038.assignment1.types.Employee apiEmployee) {
		return new Employee(apiEmployee.getId(), 
							apiEmployee.getFirstName(), 
							apiEmployee.getLastName(), 
							apiEmployee.getDob().toGregorianCalendar().getTime());
	}
	
	//Convert Date to XMLGregorianCalendar - map employee entity to API employee
	public ca.bcit.comp3656.a00742038.assignment1.types.Employee toEmployeeAccess() throws DatatypeConfigurationException {
		
		GregorianCalendar gregory = new GregorianCalendar();
		gregory.setTime(dob);
		
		XMLGregorianCalendar calendar = DatatypeFactory.newInstance()
		        .newXMLGregorianCalendar(
		            gregory);
		
		ObjectFactory factory = new ObjectFactory();
		ca.bcit.comp3656.a00742038.assignment1.types.Employee apiEmployee = factory.createEmployee();
		apiEmployee.setId(id);
		apiEmployee.setFirstName(firstName);
		apiEmployee.setLastName(lastName);
		apiEmployee.setDob(calendar);
		return apiEmployee;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	

}
