
package ca.bcit.comp3656.a00742038.assignment1.jaxws.service;

import javax.xml.ws.WebFault;
import ca.bcit.comp3656.a00742038.assignment1.types.ListEmployeeFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.3-b01
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "listEmployeeFault", targetNamespace = "http://www.bcit.ca/comp3656/a00742038/assignment1/types/")
public class ListError
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ListEmployeeFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ListError(String message, ListEmployeeFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ListError(String message, ListEmployeeFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: ca.bcit.comp3656.a00742038.assignment1.types.ListEmployeeFault
     */
    public ListEmployeeFault getFaultInfo() {
        return faultInfo;
    }

}
