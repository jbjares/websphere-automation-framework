//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.06 at 10:56:41 AM GMT-03:00 
//


package br.gov.bnb.s095.autodeploy.xml.ns.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{http://autodeploy.s095.bnb.gov.br/xml/ns/v1}nome"/>
 *         &lt;element ref="{http://autodeploy.s095.bnb.gov.br/xml/ns/v1}nome-jndi"/>
 *         &lt;element ref="{http://autodeploy.s095.bnb.gov.br/xml/ns/v1}specification"/>
 *         &lt;element ref="{http://autodeploy.s095.bnb.gov.br/xml/ns/v1}escopo-provedor"/>
 *         &lt;element ref="{http://autodeploy.s095.bnb.gov.br/xml/ns/v1}nome-provedor"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nome",
    "nomeJndi",
    "specification",
    "escopoProvedor",
    "nomeProvedor"
})
@XmlRootElement(name = "recurso-url")
public class RecursoUrl {

    @XmlElement(required = true)
    protected Nome nome;
    @XmlElement(name = "nome-jndi", required = true)
    protected NomeJndi nomeJndi;
    @XmlElement(required = true)
    protected Specification specification;
    @XmlElement(name = "escopo-provedor", required = true)
    protected EscopoProvedor escopoProvedor;
    @XmlElement(name = "nome-provedor", required = true)
    protected NomeProvedor nomeProvedor;

    /**
     * Gets the value of the nome property.
     * 
     * @return
     *     possible object is
     *     {@link Nome }
     *     
     */
    public Nome getNome() {
        return nome;
    }

    /**
     * Sets the value of the nome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Nome }
     *     
     */
    public void setNome(Nome value) {
        this.nome = value;
    }

    /**
     * Gets the value of the nomeJndi property.
     * 
     * @return
     *     possible object is
     *     {@link NomeJndi }
     *     
     */
    public NomeJndi getNomeJndi() {
        return nomeJndi;
    }

    /**
     * Sets the value of the nomeJndi property.
     * 
     * @param value
     *     allowed object is
     *     {@link NomeJndi }
     *     
     */
    public void setNomeJndi(NomeJndi value) {
        this.nomeJndi = value;
    }

    /**
     * Gets the value of the specification property.
     * 
     * @return
     *     possible object is
     *     {@link Specification }
     *     
     */
    public Specification getSpecification() {
        return specification;
    }

    /**
     * Sets the value of the specification property.
     * 
     * @param value
     *     allowed object is
     *     {@link Specification }
     *     
     */
    public void setSpecification(Specification value) {
        this.specification = value;
    }

    /**
     * Gets the value of the escopoProvedor property.
     * 
     * @return
     *     possible object is
     *     {@link EscopoProvedor }
     *     
     */
    public EscopoProvedor getEscopoProvedor() {
        return escopoProvedor;
    }

    /**
     * Sets the value of the escopoProvedor property.
     * 
     * @param value
     *     allowed object is
     *     {@link EscopoProvedor }
     *     
     */
    public void setEscopoProvedor(EscopoProvedor value) {
        this.escopoProvedor = value;
    }

    /**
     * Gets the value of the nomeProvedor property.
     * 
     * @return
     *     possible object is
     *     {@link NomeProvedor }
     *     
     */
    public NomeProvedor getNomeProvedor() {
        return nomeProvedor;
    }

    /**
     * Sets the value of the nomeProvedor property.
     * 
     * @param value
     *     allowed object is
     *     {@link NomeProvedor }
     *     
     */
    public void setNomeProvedor(NomeProvedor value) {
        this.nomeProvedor = value;
    }

}
