//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.07 at 06:36:45 PM GMT-03:00 
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
 *         &lt;element ref="{http://autodeploy.s095.bnb.gov.br/xml/ns/v1}alias"/>
 *         &lt;element ref="{http://autodeploy.s095.bnb.gov.br/xml/ns/v1}usuario"/>
 *         &lt;element ref="{http://autodeploy.s095.bnb.gov.br/xml/ns/v1}senha"/>
 *         &lt;element ref="{http://autodeploy.s095.bnb.gov.br/xml/ns/v1}descricao"/>
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
    "alias",
    "usuario",
    "senha",
    "descricao"
})
@XmlRootElement(name = "seguranca-j2C")
public class SegurancaJ2C {

    @XmlElement(required = true)
    protected Alias alias;
    @XmlElement(required = true)
    protected Usuario usuario;
    @XmlElement(required = true)
    protected Senha senha;
    @XmlElement(required = true)
    protected Descricao descricao;

    /**
     * Gets the value of the alias property.
     * 
     * @return
     *     possible object is
     *     {@link Alias }
     *     
     */
    public Alias getAlias() {
        return alias;
    }

    /**
     * Sets the value of the alias property.
     * 
     * @param value
     *     allowed object is
     *     {@link Alias }
     *     
     */
    public void setAlias(Alias value) {
        this.alias = value;
    }

    /**
     * Gets the value of the usuario property.
     * 
     * @return
     *     possible object is
     *     {@link Usuario }
     *     
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Sets the value of the usuario property.
     * 
     * @param value
     *     allowed object is
     *     {@link Usuario }
     *     
     */
    public void setUsuario(Usuario value) {
        this.usuario = value;
    }

    /**
     * Gets the value of the senha property.
     * 
     * @return
     *     possible object is
     *     {@link Senha }
     *     
     */
    public Senha getSenha() {
        return senha;
    }

    /**
     * Sets the value of the senha property.
     * 
     * @param value
     *     allowed object is
     *     {@link Senha }
     *     
     */
    public void setSenha(Senha value) {
        this.senha = value;
    }

    /**
     * Gets the value of the descricao property.
     * 
     * @return
     *     possible object is
     *     {@link Descricao }
     *     
     */
    public Descricao getDescricao() {
        return descricao;
    }

    /**
     * Sets the value of the descricao property.
     * 
     * @param value
     *     allowed object is
     *     {@link Descricao }
     *     
     */
    public void setDescricao(Descricao value) {
        this.descricao = value;
    }

}