
package gr.gsis.rgwspublic.rgwspublic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RgWsPublicFirmActRtUserArray complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RgWsPublicFirmActRtUserArray">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RgWsPublicFirmActRtUser" type="{http://gr/gsis/rgwspublic/RgWsPublic.wsdl}RgWsPublicFirmActRtUser" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RgWsPublicFirmActRtUserArray", propOrder = {
    "rgWsPublicFirmActRtUser"
})
public class RgWsPublicFirmActRtUserArray {

    @XmlElement(name = "RgWsPublicFirmActRtUser", nillable = true)
    protected List<RgWsPublicFirmActRtUser> rgWsPublicFirmActRtUser;

    /**
     * Gets the value of the rgWsPublicFirmActRtUser property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rgWsPublicFirmActRtUser property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRgWsPublicFirmActRtUser().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RgWsPublicFirmActRtUser }
     * 
     * 
     */
    public List<RgWsPublicFirmActRtUser> getRgWsPublicFirmActRtUser() {
        if (rgWsPublicFirmActRtUser == null) {
            rgWsPublicFirmActRtUser = new ArrayList<RgWsPublicFirmActRtUser>();
        }
        return this.rgWsPublicFirmActRtUser;
    }

}
