
package ca.bcit.comp3656.a00742038.assignment1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for anonymous complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="foundResult" type="{http://www.bcit.ca/comp3656/a00742038/assignment1/types/}employee"/&amp;gt;
 *         &amp;lt;element name="responseCode" type="{http://www.bcit.ca/comp3656/a00742038/assignment1/types/}responseCode"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "foundResult",
    "responseCode"
})
@XmlRootElement(name = "findEmployeeResponse")
public class FindEmployeeResponse {

    @XmlElement(required = true)
    protected Employee foundResult;
    @XmlElement(required = true)
    protected ResponseCode responseCode;

    /**
     * Gets the value of the foundResult property.
     * 
     * @return
     *     possible object is
     *     {@link Employee }
     *     
     */
    public Employee getFoundResult() {
        return foundResult;
    }

    /**
     * Sets the value of the foundResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Employee }
     *     
     */
    public void setFoundResult(Employee value) {
        this.foundResult = value;
    }

    /**
     * Gets the value of the responseCode property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseCode }
     *     
     */
    public ResponseCode getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the value of the responseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseCode }
     *     
     */
    public void setResponseCode(ResponseCode value) {
        this.responseCode = value;
    }

}
