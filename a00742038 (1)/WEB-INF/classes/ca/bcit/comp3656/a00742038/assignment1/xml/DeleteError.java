
package ca.bcit.comp3656.a00742038.assignment1.xml;

import javax.xml.ws.WebFault;
import ca.bcit.comp3656.a00742038.assignment1.types.DeleteEmployeeFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.3-b01
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "deleteEmployeeFault", targetNamespace = "http://www.bcit.ca/comp3656/a00742038/assignment1/types/")
public class DeleteError
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private DeleteEmployeeFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public DeleteError(String message, DeleteEmployeeFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public DeleteError(String message, DeleteEmployeeFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: ca.bcit.comp3656.a00742038.assignment1.types.DeleteEmployeeFault
     */
    public DeleteEmployeeFault getFaultInfo() {
        return faultInfo;
    }

}
