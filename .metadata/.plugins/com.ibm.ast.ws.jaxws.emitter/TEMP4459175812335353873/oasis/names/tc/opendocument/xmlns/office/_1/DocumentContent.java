//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.06.01 at 10:38:59 AM GMT-03:00 
//


package oasis.names.tc.opendocument.xmlns.office._1;

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
 *         &lt;element ref="{urn:oasis:names:tc:opendocument:xmlns:office:1.0}font-face-decls"/>
 *         &lt;element ref="{urn:oasis:names:tc:opendocument:xmlns:office:1.0}automatic-styles"/>
 *         &lt;element ref="{urn:oasis:names:tc:opendocument:xmlns:office:1.0}body"/>
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
    "fontFaceDecls",
    "automaticStyles",
    "body"
})
@XmlRootElement(name = "document-content")
public class DocumentContent {

    @XmlElement(name = "font-face-decls", required = true)
    protected FontFaceDecls fontFaceDecls;
    @XmlElement(name = "automatic-styles", required = true)
    protected AutomaticStyles automaticStyles;
    @XmlElement(required = true)
    protected Body body;

    /**
     * Gets the value of the fontFaceDecls property.
     * 
     * @return
     *     possible object is
     *     {@link FontFaceDecls }
     *     
     */
    public FontFaceDecls getFontFaceDecls() {
        return fontFaceDecls;
    }

    /**
     * Sets the value of the fontFaceDecls property.
     * 
     * @param value
     *     allowed object is
     *     {@link FontFaceDecls }
     *     
     */
    public void setFontFaceDecls(FontFaceDecls value) {
        this.fontFaceDecls = value;
    }

    /**
     * Gets the value of the automaticStyles property.
     * 
     * @return
     *     possible object is
     *     {@link AutomaticStyles }
     *     
     */
    public AutomaticStyles getAutomaticStyles() {
        return automaticStyles;
    }

    /**
     * Sets the value of the automaticStyles property.
     * 
     * @param value
     *     allowed object is
     *     {@link AutomaticStyles }
     *     
     */
    public void setAutomaticStyles(AutomaticStyles value) {
        this.automaticStyles = value;
    }

    /**
     * Gets the value of the body property.
     * 
     * @return
     *     possible object is
     *     {@link Body }
     *     
     */
    public Body getBody() {
        return body;
    }

    /**
     * Sets the value of the body property.
     * 
     * @param value
     *     allowed object is
     *     {@link Body }
     *     
     */
    public void setBody(Body value) {
        this.body = value;
    }

}
