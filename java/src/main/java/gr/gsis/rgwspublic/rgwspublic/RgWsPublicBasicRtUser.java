
package gr.gsis.rgwspublic.rgwspublic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for RgWsPublicBasicRtUser complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RgWsPublicBasicRtUser">
 *   &lt;complexContent>
 *     &lt;extension base="{http://gr/gsis/rgwspublic/RgWsPublic.wsdl}RgWsPublicBasicRtBase">
 *       &lt;sequence>
 *         &lt;element name="afm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stopDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="postalAddressNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="doyDescr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="doy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="onomasia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="legalStatusDescr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="registDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="deactivationFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deactivationFlagDescr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="postalAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="firmFlagDescr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="commerTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="postalAreaDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="INiFlagDescr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="postalZipCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RgWsPublicBasicRtUser", propOrder = {
    "afm",
    "stopDate",
    "postalAddressNo",
    "doyDescr",
    "doy",
    "onomasia",
    "legalStatusDescr",
    "registDate",
    "deactivationFlag",
    "deactivationFlagDescr",
    "postalAddress",
    "firmFlagDescr",
    "commerTitle",
    "postalAreaDescription",
    "iNiFlagDescr",
    "postalZipCode"
})
public class RgWsPublicBasicRtUser
    extends RgWsPublicBasicRtBase
{

    @XmlElement(required = true, nillable = true)
    protected String afm;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar stopDate;
    @XmlElement(required = true, nillable = true)
    protected String postalAddressNo;
    @XmlElement(required = true, nillable = true)
    protected String doyDescr;
    @XmlElement(required = true, nillable = true)
    protected String doy;
    @XmlElement(required = true, nillable = true)
    protected String onomasia;
    @XmlElement(required = true, nillable = true)
    protected String legalStatusDescr;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar registDate;
    @XmlElement(required = true, nillable = true)
    protected String deactivationFlag;
    @XmlElement(required = true, nillable = true)
    protected String deactivationFlagDescr;
    @XmlElement(required = true, nillable = true)
    protected String postalAddress;
    @XmlElement(required = true, nillable = true)
    protected String firmFlagDescr;
    @XmlElement(required = true, nillable = true)
    protected String commerTitle;
    @XmlElement(required = true, nillable = true)
    protected String postalAreaDescription;
    @XmlElement(name = "INiFlagDescr", required = true, nillable = true)
    protected String iNiFlagDescr;
    @XmlElement(required = true, nillable = true)
    protected String postalZipCode;

    /**
     * Gets the value of the afm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAfm() {
        return afm;
    }

    /**
     * Sets the value of the afm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAfm(String value) {
        this.afm = value;
    }

    /**
     * Gets the value of the stopDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStopDate() {
        return stopDate;
    }

    /**
     * Sets the value of the stopDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStopDate(XMLGregorianCalendar value) {
        this.stopDate = value;
    }

    /**
     * Gets the value of the postalAddressNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalAddressNo() {
        return postalAddressNo;
    }

    /**
     * Sets the value of the postalAddressNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalAddressNo(String value) {
        this.postalAddressNo = value;
    }

    /**
     * Gets the value of the doyDescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoyDescr() {
        return doyDescr;
    }

    /**
     * Sets the value of the doyDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoyDescr(String value) {
        this.doyDescr = value;
    }

    /**
     * Gets the value of the doy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoy() {
        return doy;
    }

    /**
     * Sets the value of the doy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoy(String value) {
        this.doy = value;
    }

    /**
     * Gets the value of the onomasia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnomasia() {
        return onomasia;
    }

    /**
     * Sets the value of the onomasia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnomasia(String value) {
        this.onomasia = value;
    }

    /**
     * Gets the value of the legalStatusDescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegalStatusDescr() {
        return legalStatusDescr;
    }

    /**
     * Sets the value of the legalStatusDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegalStatusDescr(String value) {
        this.legalStatusDescr = value;
    }

    /**
     * Gets the value of the registDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRegistDate() {
        return registDate;
    }

    /**
     * Sets the value of the registDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRegistDate(XMLGregorianCalendar value) {
        this.registDate = value;
    }

    /**
     * Gets the value of the deactivationFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeactivationFlag() {
        return deactivationFlag;
    }

    /**
     * Sets the value of the deactivationFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeactivationFlag(String value) {
        this.deactivationFlag = value;
    }

    /**
     * Gets the value of the deactivationFlagDescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeactivationFlagDescr() {
        return deactivationFlagDescr;
    }

    /**
     * Sets the value of the deactivationFlagDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeactivationFlagDescr(String value) {
        this.deactivationFlagDescr = value;
    }

    /**
     * Gets the value of the postalAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalAddress() {
        return postalAddress;
    }

    /**
     * Sets the value of the postalAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalAddress(String value) {
        this.postalAddress = value;
    }

    /**
     * Gets the value of the firmFlagDescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirmFlagDescr() {
        return firmFlagDescr;
    }

    /**
     * Sets the value of the firmFlagDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirmFlagDescr(String value) {
        this.firmFlagDescr = value;
    }

    /**
     * Gets the value of the commerTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommerTitle() {
        return commerTitle;
    }

    /**
     * Sets the value of the commerTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommerTitle(String value) {
        this.commerTitle = value;
    }

    /**
     * Gets the value of the postalAreaDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalAreaDescription() {
        return postalAreaDescription;
    }

    /**
     * Sets the value of the postalAreaDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalAreaDescription(String value) {
        this.postalAreaDescription = value;
    }

    /**
     * Gets the value of the iNiFlagDescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINiFlagDescr() {
        return iNiFlagDescr;
    }

    /**
     * Sets the value of the iNiFlagDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINiFlagDescr(String value) {
        this.iNiFlagDescr = value;
    }

    /**
     * Gets the value of the postalZipCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalZipCode() {
        return postalZipCode;
    }

    /**
     * Sets the value of the postalZipCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalZipCode(String value) {
        this.postalZipCode = value;
    }

}
