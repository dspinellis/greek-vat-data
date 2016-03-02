
package gr.gsis.rgwspublic.rgwspublic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RgWsPublicInputRtUser complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RgWsPublicInputRtUser">
 *   &lt;complexContent>
 *     &lt;extension base="{http://gr/gsis/rgwspublic/RgWsPublic.wsdl}RgWsPublicInputRtBase">
 *       &lt;sequence>
 *         &lt;element name="afmCalledBy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="afmCalledFor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RgWsPublicInputRtUser", propOrder = {
    "afmCalledBy",
    "afmCalledFor"
})
public class RgWsPublicInputRtUser
    extends RgWsPublicInputRtBase
{

    @XmlElement(required = true, nillable = true)
    protected String afmCalledBy;
    @XmlElement(required = true, nillable = true)
    protected String afmCalledFor;

    /**
     * Gets the value of the afmCalledBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAfmCalledBy() {
        return afmCalledBy;
    }

    /**
     * Sets the value of the afmCalledBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAfmCalledBy(String value) {
        this.afmCalledBy = value;
    }

    /**
     * Gets the value of the afmCalledFor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAfmCalledFor() {
        return afmCalledFor;
    }

    /**
     * Sets the value of the afmCalledFor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAfmCalledFor(String value) {
        this.afmCalledFor = value;
    }

}
