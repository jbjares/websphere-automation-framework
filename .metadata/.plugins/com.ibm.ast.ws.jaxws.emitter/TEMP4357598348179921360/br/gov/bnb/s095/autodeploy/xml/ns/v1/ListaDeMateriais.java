//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.03 at 04:35:39 PM GMT-03:00 
//


package br.gov.bnb.s095.autodeploy.xml.ns.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://autodeploy.s095.bnb.gov.br/xml/ns/v1}aplicacao"/>
 *         &lt;element ref="{http://autodeploy.s095.bnb.gov.br/xml/ns/v1}seguranca-j2C" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "aplicacao",
    "segurancaJ2C"
})
@XmlRootElement(name = "lista-de-materiais")
public class ListaDeMateriais {

    @XmlElement(required = true)
    protected Aplicacao aplicacao;
    @XmlElement(name = "seguranca-j2C", required = true)
    protected List<SegurancaJ2C> segurancaJ2C;
    @XmlAttribute
    protected String version;
    @XmlAttribute
    protected String id;

    /**
     * Gets the value of the aplicacao property.
     * 
     * @return
     *     possible object is
     *     {@link Aplicacao }
     *     
     */
    public Aplicacao getAplicacao() {
        return aplicacao;
    }

    /**
     * Sets the value of the aplicacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link Aplicacao }
     *     
     */
    public void setAplicacao(Aplicacao value) {
        this.aplicacao = value;
    }

    /**
     * Gets the value of the segurancaJ2C property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the segurancaJ2C property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSegurancaJ2C().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SegurancaJ2C }
     * 
     * 
     */
    public List<SegurancaJ2C> getSegurancaJ2C() {
        if (segurancaJ2C == null) {
            segurancaJ2C = new ArrayList<SegurancaJ2C>();
        }
        return this.segurancaJ2C;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
