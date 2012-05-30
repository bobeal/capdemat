package fr.capwebct.capdemat.plugins.externalservices.interconnexiondila.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigInteger;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LieuActeType", propOrder = {
    "pointRemise",
    "numeroVoie",
    "extensionIndiceRepetition",
    "voie",
    "ligneAdresse",
    "mentionsAdresseParticulieres",
    "codePostal",
    "codeCedex",
    "ville",
    "pays"
})
public class LieuActeType {

    @XmlElement(name = "PointRemise")
    protected String pointRemise;
    @XmlElement(name = "NumeroVoie")
    protected String numeroVoie;
    @XmlElement(name = "ExtensionIndiceRepetition")
    protected String extensionIndiceRepetition;
    @XmlElement(name = "Voie")
    protected VoieType voie;
    @XmlElement(name = "LigneAdresse")
    protected String ligneAdresse;
    @XmlElement(name = "MentionsAdresseParticulieres")
    protected String mentionsAdresseParticulieres;
    @XmlElement(name = "CodePostal")
    protected BigInteger codePostal;
    @XmlElement(name = "CodeCedex")
    protected BigInteger codeCedex;
    @XmlElement(name = "Ville")
    protected String ville;
    @XmlElement(name = "Pays")
    protected String pays;

    /**
     * Gets the value of the pointRemise property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPointRemise() {
        return pointRemise;
    }

    /**
     * Sets the value of the pointRemise property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPointRemise(String value) {
        this.pointRemise = value;
    }

    /**
     * Gets the value of the numeroVoie property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroVoie() {
        return numeroVoie;
    }

    /**
     * Sets the value of the numeroVoie property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroVoie(String value) {
        this.numeroVoie = value;
    }

    /**
     * Gets the value of the extensionIndiceRepetition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtensionIndiceRepetition() {
        return extensionIndiceRepetition;
    }

    /**
     * Sets the value of the extensionIndiceRepetition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtensionIndiceRepetition(String value) {
        this.extensionIndiceRepetition = value;
    }

    /**
     * Gets the value of the voie property.
     * 
     * @return
     *     possible object is
     *     {@link VoieType }
     *     
     */
    public VoieType getVoie() {
        return voie;
    }

    /**
     * Sets the value of the voie property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoieType }
     *     
     */
    public void setVoie(VoieType value) {
        this.voie = value;
    }

    /**
     * Gets the value of the ligneAdresse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLigneAdresse() {
        return ligneAdresse;
    }

    /**
     * Sets the value of the ligneAdresse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLigneAdresse(String value) {
        this.ligneAdresse = value;
    }

    /**
     * Gets the value of the mentionsAdresseParticulieres property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMentionsAdresseParticulieres() {
        return mentionsAdresseParticulieres;
    }

    /**
     * Sets the value of the mentionsAdresseParticulieres property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMentionsAdresseParticulieres(String value) {
        this.mentionsAdresseParticulieres = value;
    }

    /**
     * Gets the value of the codePostal property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCodePostal() {
        return codePostal;
    }

    /**
     * Sets the value of the codePostal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCodePostal(BigInteger value) {
        this.codePostal = value;
    }

    /**
     * Gets the value of the codeCedex property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCodeCedex() {
        return codeCedex;
    }

    /**
     * Sets the value of the codeCedex property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCodeCedex(BigInteger value) {
        this.codeCedex = value;
    }

    /**
     * Gets the value of the ville property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVille() {
        return ville;
    }

    /**
     * Sets the value of the ville property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVille(String value) {
        this.ville = value;
    }

    /**
     * Gets the value of the pays property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPays() {
        return pays;
    }

    /**
     * Sets the value of the pays property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPays(String value) {
        this.pays = value;
    }

}