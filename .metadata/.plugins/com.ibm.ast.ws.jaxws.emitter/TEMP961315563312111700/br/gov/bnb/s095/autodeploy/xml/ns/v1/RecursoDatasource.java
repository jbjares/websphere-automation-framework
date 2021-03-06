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
 *         &lt;element ref="{http://autodeploy.s095.bnb.gov.br/xml/ns/v1}nome-origem"/>
 *         &lt;element ref="{http://autodeploy.s095.bnb.gov.br/xml/ns/v1}nome-jndi"/>
 *         &lt;element ref="{http://autodeploy.s095.bnb.gov.br/xml/ns/v1}alias-autenticacao"/>
 *         &lt;element ref="{http://autodeploy.s095.bnb.gov.br/xml/ns/v1}nome-bancodedados"/>
 *         &lt;element ref="{http://autodeploy.s095.bnb.gov.br/xml/ns/v1}nome-servidor"/>
 *         &lt;element ref="{http://autodeploy.s095.bnb.gov.br/xml/ns/v1}porta-servidor"/>
 *         &lt;element ref="{http://autodeploy.s095.bnb.gov.br/xml/ns/v1}utilizar-cmp"/>
 *         &lt;element ref="{http://autodeploy.s095.bnb.gov.br/xml/ns/v1}escopo-provedor"/>
 *         &lt;element ref="{http://autodeploy.s095.bnb.gov.br/xml/ns/v1}nome-provedor"/>
 *         &lt;element ref="{http://autodeploy.s095.bnb.gov.br/xml/ns/v1}nome-classe-helper"/>
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
    "nomeOrigem",
    "nomeJndi",
    "aliasAutenticacao",
    "nomeBancodedados",
    "nomeServidor",
    "portaServidor",
    "utilizarCmp",
    "escopoProvedor",
    "nomeProvedor",
    "nomeClasseHelper"
})
@XmlRootElement(name = "recurso-datasource")
public class RecursoDatasource {

    @XmlElement(name = "nome-origem", required = true)
    protected NomeOrigem nomeOrigem;
    @XmlElement(name = "nome-jndi", required = true)
    protected NomeJndi nomeJndi;
    @XmlElement(name = "alias-autenticacao", required = true)
    protected AliasAutenticacao aliasAutenticacao;
    @XmlElement(name = "nome-bancodedados", required = true)
    protected NomeBancodedados nomeBancodedados;
    @XmlElement(name = "nome-servidor", required = true)
    protected NomeServidor nomeServidor;
    @XmlElement(name = "porta-servidor", required = true)
    protected PortaServidor portaServidor;
    @XmlElement(name = "utilizar-cmp", required = true)
    protected UtilizarCmp utilizarCmp;
    @XmlElement(name = "escopo-provedor", required = true)
    protected EscopoProvedor escopoProvedor;
    @XmlElement(name = "nome-provedor", required = true)
    protected NomeProvedor nomeProvedor;
    @XmlElement(name = "nome-classe-helper", required = true)
    protected NomeClasseHelper nomeClasseHelper;

    /**
     * Gets the value of the nomeOrigem property.
     * 
     * @return
     *     possible object is
     *     {@link NomeOrigem }
     *     
     */
    public NomeOrigem getNomeOrigem() {
        return nomeOrigem;
    }

    /**
     * Sets the value of the nomeOrigem property.
     * 
     * @param value
     *     allowed object is
     *     {@link NomeOrigem }
     *     
     */
    public void setNomeOrigem(NomeOrigem value) {
        this.nomeOrigem = value;
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
     * Gets the value of the aliasAutenticacao property.
     * 
     * @return
     *     possible object is
     *     {@link AliasAutenticacao }
     *     
     */
    public AliasAutenticacao getAliasAutenticacao() {
        return aliasAutenticacao;
    }

    /**
     * Sets the value of the aliasAutenticacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link AliasAutenticacao }
     *     
     */
    public void setAliasAutenticacao(AliasAutenticacao value) {
        this.aliasAutenticacao = value;
    }

    /**
     * Gets the value of the nomeBancodedados property.
     * 
     * @return
     *     possible object is
     *     {@link NomeBancodedados }
     *     
     */
    public NomeBancodedados getNomeBancodedados() {
        return nomeBancodedados;
    }

    /**
     * Sets the value of the nomeBancodedados property.
     * 
     * @param value
     *     allowed object is
     *     {@link NomeBancodedados }
     *     
     */
    public void setNomeBancodedados(NomeBancodedados value) {
        this.nomeBancodedados = value;
    }

    /**
     * Gets the value of the nomeServidor property.
     * 
     * @return
     *     possible object is
     *     {@link NomeServidor }
     *     
     */
    public NomeServidor getNomeServidor() {
        return nomeServidor;
    }

    /**
     * Sets the value of the nomeServidor property.
     * 
     * @param value
     *     allowed object is
     *     {@link NomeServidor }
     *     
     */
    public void setNomeServidor(NomeServidor value) {
        this.nomeServidor = value;
    }

    /**
     * Gets the value of the portaServidor property.
     * 
     * @return
     *     possible object is
     *     {@link PortaServidor }
     *     
     */
    public PortaServidor getPortaServidor() {
        return portaServidor;
    }

    /**
     * Sets the value of the portaServidor property.
     * 
     * @param value
     *     allowed object is
     *     {@link PortaServidor }
     *     
     */
    public void setPortaServidor(PortaServidor value) {
        this.portaServidor = value;
    }

    /**
     * Gets the value of the utilizarCmp property.
     * 
     * @return
     *     possible object is
     *     {@link UtilizarCmp }
     *     
     */
    public UtilizarCmp getUtilizarCmp() {
        return utilizarCmp;
    }

    /**
     * Sets the value of the utilizarCmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link UtilizarCmp }
     *     
     */
    public void setUtilizarCmp(UtilizarCmp value) {
        this.utilizarCmp = value;
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

    /**
     * Gets the value of the nomeClasseHelper property.
     * 
     * @return
     *     possible object is
     *     {@link NomeClasseHelper }
     *     
     */
    public NomeClasseHelper getNomeClasseHelper() {
        return nomeClasseHelper;
    }

    /**
     * Sets the value of the nomeClasseHelper property.
     * 
     * @param value
     *     allowed object is
     *     {@link NomeClasseHelper }
     *     
     */
    public void setNomeClasseHelper(NomeClasseHelper value) {
        this.nomeClasseHelper = value;
    }

}
