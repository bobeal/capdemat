//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.23 at 04:10:50 PM CEST 
//


package fr.capwebct.capdemat.plugins.externalservices.interconnexiondila.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FiliationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FiliationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Pere" type="{http://www.message.interconnexiondila.externalservices.plugins.capdemat.capwebct.fr}ParentType"/>
 *         &lt;element name="Mere" type="{http://www.message.interconnexiondila.externalservices.plugins.capdemat.capwebct.fr}ParentType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FiliationType", propOrder = {
    "pere",
    "mere"
})
public class FiliationType {

    @XmlElement(name = "Pere", required = true)
    protected ParentType pere;
    @XmlElement(name = "Mere", required = true)
    protected ParentType mere;

    /**
     * Gets the value of the pere property.
     * 
     * @return
     *     possible object is
     *     {@link ParentType }
     *     
     */
    public ParentType getPere() {
        return pere;
    }

    /**
     * Sets the value of the pere property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParentType }
     *     
     */
    public void setPere(ParentType value) {
        this.pere = value;
    }

    /**
     * Gets the value of the mere property.
     * 
     * @return
     *     possible object is
     *     {@link ParentType }
     *     
     */
    public ParentType getMere() {
        return mere;
    }

    /**
     * Sets the value of the mere property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParentType }
     *     
     */
    public void setMere(ParentType value) {
        this.mere = value;
    }

}