
package ca.bcit.comp3656.a00742038.assignment1.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ca.bcit.comp3656.a00742038.assignment1.types package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ListEmployeeRequest_QNAME = new QName("http://www.bcit.ca/comp3656/a00742038/assignment1/types/", "listEmployeeRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ca.bcit.comp3656.a00742038.assignment1.types
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddEmployeeFault }
     * 
     */
    public AddEmployeeFault createAddEmployeeFault() {
        return new AddEmployeeFault();
    }

    /**
     * Create an instance of {@link AddEmployeeRequest }
     * 
     */
    public AddEmployeeRequest createAddEmployeeRequest() {
        return new AddEmployeeRequest();
    }

    /**
     * Create an instance of {@link Employee }
     * 
     */
    public Employee createEmployee() {
        return new Employee();
    }

    /**
     * Create an instance of {@link AddEmployeeResponse }
     * 
     */
    public AddEmployeeResponse createAddEmployeeResponse() {
        return new AddEmployeeResponse();
    }

    /**
     * Create an instance of {@link ResponseCode }
     * 
     */
    public ResponseCode createResponseCode() {
        return new ResponseCode();
    }

    /**
     * Create an instance of {@link DeleteEmployeeFault }
     * 
     */
    public DeleteEmployeeFault createDeleteEmployeeFault() {
        return new DeleteEmployeeFault();
    }

    /**
     * Create an instance of {@link DeleteEmployeeRequest }
     * 
     */
    public DeleteEmployeeRequest createDeleteEmployeeRequest() {
        return new DeleteEmployeeRequest();
    }

    /**
     * Create an instance of {@link DeleteEmployeeResponse }
     * 
     */
    public DeleteEmployeeResponse createDeleteEmployeeResponse() {
        return new DeleteEmployeeResponse();
    }

    /**
     * Create an instance of {@link FindEmployeeFault }
     * 
     */
    public FindEmployeeFault createFindEmployeeFault() {
        return new FindEmployeeFault();
    }

    /**
     * Create an instance of {@link FindEmployeeRequest }
     * 
     */
    public FindEmployeeRequest createFindEmployeeRequest() {
        return new FindEmployeeRequest();
    }

    /**
     * Create an instance of {@link FindEmployeeResponse }
     * 
     */
    public FindEmployeeResponse createFindEmployeeResponse() {
        return new FindEmployeeResponse();
    }

    /**
     * Create an instance of {@link ListEmployeeFault }
     * 
     */
    public ListEmployeeFault createListEmployeeFault() {
        return new ListEmployeeFault();
    }

    /**
     * Create an instance of {@link ListEmployeeResponse }
     * 
     */
    public ListEmployeeResponse createListEmployeeResponse() {
        return new ListEmployeeResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.bcit.ca/comp3656/a00742038/assignment1/types/", name = "listEmployeeRequest")
    public JAXBElement<Object> createListEmployeeRequest(Object value) {
        return new JAXBElement<Object>(_ListEmployeeRequest_QNAME, Object.class, null, value);
    }

}
