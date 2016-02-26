
package gr.gsis.rgwspublic.rgwspublic;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RgWsPublicFirmActRtUser complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RgWsPublicFirmActRtUser">
 *   &lt;complexContent>
 *     &lt;extension base="{http://gr/gsis/rgwspublic/RgWsPublic.wsdl}RgWsPublicFirmActRtBase">
 *       &lt;sequence>
 *         &lt;element name="firmActDescr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="firmActKind" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="firmActKindDescr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="firmActCode" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RgWsPublicFirmActRtUser", propOrder = {
    "firmActDescr",
    "firmActKind",
    "firmActKindDescr",
    "firmActCode"
})
public class RgWsPublicFirmActRtUser
    extends RgWsPublicFirmActRtBase
{

    @XmlElement(required = true, nillable = true)
    protected String firmActDescr;
    @XmlElement(required = true, nillable = true)
    protected String firmActKind;
    @XmlElement(required = true, nillable = true)
    protected String firmActKindDescr;
    @XmlElement(required = true, nillable = true)
    protected BigDecimal firmActCode;

    /**
     * Gets the value of the firmActDescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirmActDescr() {
        return firmActDescr;
    }

    /**
     * Sets the value of the firmActDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirmActDescr(String value) {
        this.firmActDescr = value;
    }

    /**
     * Gets the value of the firmActKind property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirmActKind() {
        return firmActKind;
    }

    /**
     * Sets the value of the firmActKind property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirmActKind(String value) {
        this.firmActKind = value;
    }

    /**
     * Gets the value of the firmActKindDescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirmActKindDescr() {
        return firmActKindDescr;
    }

    /**
     * Sets the value of the firmActKindDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirmActKindDescr(String value) {
        this.firmActKindDescr = value;
    }

    /**
     * Gets the value of the firmActCode property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFirmActCode() {
        return firmActCode;
    }

    /**
     * Sets the value of the firmActCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFirmActCode(BigDecimal value) {
        this.firmActCode = value;
    }

}
