package fr.cg95.cvq.business.civil;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.civil.*;

import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlObject;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.*;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.joined-subclass
 *  table="personal_details_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class PersonalDetailsRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public PersonalDetailsRequest() {
        super();
        relationship = fr.cg95.cvq.business.civil.RelationshipType.HUSBAND;
    }


    public final String modelToXmlString() {

        PersonalDetailsRequestDocument object = (PersonalDetailsRequestDocument) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final XmlObject modelToXml() {

        Calendar calendar = Calendar.getInstance();
        Date date = null;
        PersonalDetailsRequestDocument personalDetailsRequestDoc = PersonalDetailsRequestDocument.Factory.newInstance();
        PersonalDetailsRequestDocument.PersonalDetailsRequest personalDetailsRequest = personalDetailsRequestDoc.addNewPersonalDetailsRequest();
        super.fillCommonXmlInfo(personalDetailsRequest);
        personalDetailsRequest.setBirthLastName(this.birthLastName);
        personalDetailsRequest.setDeathFirstNames(this.deathFirstNames);
        personalDetailsRequest.setRequesterQualityPrecision(this.requesterQualityPrecision);
        if (this.relationship != null)
            personalDetailsRequest.setRelationship(fr.cg95.cvq.xml.civil.RelationshipType.Enum.forString(this.relationship.toString()));
        personalDetailsRequest.setMarriagePostalCode(this.marriagePostalCode);
        date = this.birthDate;
        if (date != null) {
            calendar.setTime(date);
            personalDetailsRequest.setBirthDate(calendar);
        }
        personalDetailsRequest.setMarriageWifeFirstNames(this.marriageWifeFirstNames);
        personalDetailsRequest.setMarriageHusbandLastName(this.marriageHusbandLastName);
        personalDetailsRequest.setFatherFirstNames(this.fatherFirstNames);
        if (this.format != null)
            personalDetailsRequest.setFormat(fr.cg95.cvq.xml.civil.CertificateFormatType.Enum.forString(this.format.toString()));
        if (this.copies != null)
            personalDetailsRequest.setCopies(new BigInteger(this.copies.toString()));
        if (this.certificate != null)
            personalDetailsRequest.setCertificate(fr.cg95.cvq.xml.civil.CertificateType.Enum.forString(this.certificate.toString()));
        personalDetailsRequest.setMarriageCity(this.marriageCity);
        personalDetailsRequest.setUsage(this.usage);
        if (this.requesterQuality != null)
            personalDetailsRequest.setRequesterQuality(fr.cg95.cvq.xml.civil.RequesterQualityType.Enum.forString(this.requesterQuality.toString()));
        personalDetailsRequest.setFatherLastName(this.fatherLastName);
        personalDetailsRequest.setBirthCity(this.birthCity);
        personalDetailsRequest.setMotherMaidenName(this.motherMaidenName);
        personalDetailsRequest.setBirthFirstNames(this.birthFirstNames);
        date = this.deathDate;
        if (date != null) {
            calendar.setTime(date);
            personalDetailsRequest.setDeathDate(calendar);
        }
        personalDetailsRequest.setBirthPostalCode(this.birthPostalCode);
        personalDetailsRequest.setDeathPostalCode(this.deathPostalCode);
        personalDetailsRequest.setMarriageWifeLastName(this.marriageWifeLastName);
        personalDetailsRequest.setMotherFirstNames(this.motherFirstNames);
        personalDetailsRequest.setDeathCity(this.deathCity);
        personalDetailsRequest.setDeathLastName(this.deathLastName);
        date = this.marriageDate;
        if (date != null) {
            calendar.setTime(date);
            personalDetailsRequest.setMarriageDate(calendar);
        }
        personalDetailsRequest.setMarriageHusbandFirstNames(this.marriageHusbandFirstNames);
        return personalDetailsRequestDoc;
    }

    public static PersonalDetailsRequest xmlToModel(PersonalDetailsRequestDocument personalDetailsRequestDoc) {

        PersonalDetailsRequestDocument.PersonalDetailsRequest personalDetailsRequestXml = personalDetailsRequestDoc.getPersonalDetailsRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        PersonalDetailsRequest personalDetailsRequest = new PersonalDetailsRequest();
        personalDetailsRequest.fillCommonModelInfo(personalDetailsRequest,personalDetailsRequestXml);
        personalDetailsRequest.setBirthLastName(personalDetailsRequestXml.getBirthLastName());
        personalDetailsRequest.setDeathFirstNames(personalDetailsRequestXml.getDeathFirstNames());
        personalDetailsRequest.setRequesterQualityPrecision(personalDetailsRequestXml.getRequesterQualityPrecision());
        if (personalDetailsRequestXml.getRelationship() != null)
            personalDetailsRequest.setRelationship(fr.cg95.cvq.business.civil.RelationshipType.forString(personalDetailsRequestXml.getRelationship().toString()));
        else
            personalDetailsRequest.setRelationship(fr.cg95.cvq.business.civil.RelationshipType.getDefaultRelationshipType());
        personalDetailsRequest.setMarriagePostalCode(personalDetailsRequestXml.getMarriagePostalCode());
        calendar = personalDetailsRequestXml.getBirthDate();
        if (calendar != null) {
            personalDetailsRequest.setBirthDate(calendar.getTime());
        }
        personalDetailsRequest.setMarriageWifeFirstNames(personalDetailsRequestXml.getMarriageWifeFirstNames());
        personalDetailsRequest.setMarriageHusbandLastName(personalDetailsRequestXml.getMarriageHusbandLastName());
        personalDetailsRequest.setFatherFirstNames(personalDetailsRequestXml.getFatherFirstNames());
        if (personalDetailsRequestXml.getFormat() != null)
            personalDetailsRequest.setFormat(fr.cg95.cvq.business.civil.CertificateFormatType.forString(personalDetailsRequestXml.getFormat().toString()));
        else
            personalDetailsRequest.setFormat(fr.cg95.cvq.business.civil.CertificateFormatType.getDefaultCertificateFormatType());
        personalDetailsRequest.setCopies(personalDetailsRequestXml.getCopies());
        if (personalDetailsRequestXml.getCertificate() != null)
            personalDetailsRequest.setCertificate(fr.cg95.cvq.business.civil.CertificateType.forString(personalDetailsRequestXml.getCertificate().toString()));
        else
            personalDetailsRequest.setCertificate(fr.cg95.cvq.business.civil.CertificateType.getDefaultCertificateType());
        personalDetailsRequest.setMarriageCity(personalDetailsRequestXml.getMarriageCity());
        personalDetailsRequest.setUsage(personalDetailsRequestXml.getUsage());
        if (personalDetailsRequestXml.getRequesterQuality() != null)
            personalDetailsRequest.setRequesterQuality(fr.cg95.cvq.business.civil.RequesterQualityType.forString(personalDetailsRequestXml.getRequesterQuality().toString()));
        else
            personalDetailsRequest.setRequesterQuality(fr.cg95.cvq.business.civil.RequesterQualityType.getDefaultRequesterQualityType());
        personalDetailsRequest.setFatherLastName(personalDetailsRequestXml.getFatherLastName());
        personalDetailsRequest.setBirthCity(personalDetailsRequestXml.getBirthCity());
        personalDetailsRequest.setMotherMaidenName(personalDetailsRequestXml.getMotherMaidenName());
        personalDetailsRequest.setBirthFirstNames(personalDetailsRequestXml.getBirthFirstNames());
        calendar = personalDetailsRequestXml.getDeathDate();
        if (calendar != null) {
            personalDetailsRequest.setDeathDate(calendar.getTime());
        }
        personalDetailsRequest.setBirthPostalCode(personalDetailsRequestXml.getBirthPostalCode());
        personalDetailsRequest.setDeathPostalCode(personalDetailsRequestXml.getDeathPostalCode());
        personalDetailsRequest.setMarriageWifeLastName(personalDetailsRequestXml.getMarriageWifeLastName());
        personalDetailsRequest.setMotherFirstNames(personalDetailsRequestXml.getMotherFirstNames());
        personalDetailsRequest.setDeathCity(personalDetailsRequestXml.getDeathCity());
        personalDetailsRequest.setDeathLastName(personalDetailsRequestXml.getDeathLastName());
        calendar = personalDetailsRequestXml.getMarriageDate();
        if (calendar != null) {
            personalDetailsRequest.setMarriageDate(calendar.getTime());
        }
        personalDetailsRequest.setMarriageHusbandFirstNames(personalDetailsRequestXml.getMarriageHusbandFirstNames());
        return personalDetailsRequest;
    }

    private String birthLastName;

    public final void setBirthLastName(final String birthLastName) {
        this.birthLastName = birthLastName;
    }


    /**
     * @hibernate.property
     *  column="birth_last_name"
     *  length="38"
     */
    public final String getBirthLastName() {
        return this.birthLastName;
    }

    private String deathFirstNames;

    public final void setDeathFirstNames(final String deathFirstNames) {
        this.deathFirstNames = deathFirstNames;
    }


    /**
     * @hibernate.property
     *  column="death_first_names"
     */
    public final String getDeathFirstNames() {
        return this.deathFirstNames;
    }

    private String requesterQualityPrecision;

    public final void setRequesterQualityPrecision(final String requesterQualityPrecision) {
        this.requesterQualityPrecision = requesterQualityPrecision;
    }


    /**
     * @hibernate.property
     *  column="requester_quality_precision"
     */
    public final String getRequesterQualityPrecision() {
        return this.requesterQualityPrecision;
    }

    private fr.cg95.cvq.business.civil.RelationshipType relationship;

    public final void setRelationship(final fr.cg95.cvq.business.civil.RelationshipType relationship) {
        this.relationship = relationship;
    }


    /**
     * @hibernate.property
     *  column="relationship"
     */
    public final fr.cg95.cvq.business.civil.RelationshipType getRelationship() {
        return this.relationship;
    }

    private String marriagePostalCode;

    public final void setMarriagePostalCode(final String marriagePostalCode) {
        this.marriagePostalCode = marriagePostalCode;
    }


    /**
     * @hibernate.property
     *  column="marriage_postal_code"
     *  length="2"
     */
    public final String getMarriagePostalCode() {
        return this.marriagePostalCode;
    }

    private java.util.Date birthDate;

    public final void setBirthDate(final java.util.Date birthDate) {
        this.birthDate = birthDate;
    }


    /**
     * @hibernate.property
     *  column="birth_date"
     */
    public final java.util.Date getBirthDate() {
        return this.birthDate;
    }

    private String marriageWifeFirstNames;

    public final void setMarriageWifeFirstNames(final String marriageWifeFirstNames) {
        this.marriageWifeFirstNames = marriageWifeFirstNames;
    }


    /**
     * @hibernate.property
     *  column="marriage_wife_first_names"
     */
    public final String getMarriageWifeFirstNames() {
        return this.marriageWifeFirstNames;
    }

    private String marriageHusbandLastName;

    public final void setMarriageHusbandLastName(final String marriageHusbandLastName) {
        this.marriageHusbandLastName = marriageHusbandLastName;
    }


    /**
     * @hibernate.property
     *  column="marriage_husband_last_name"
     *  length="38"
     */
    public final String getMarriageHusbandLastName() {
        return this.marriageHusbandLastName;
    }

    private String fatherFirstNames;

    public final void setFatherFirstNames(final String fatherFirstNames) {
        this.fatherFirstNames = fatherFirstNames;
    }


    /**
     * @hibernate.property
     *  column="father_first_names"
     */
    public final String getFatherFirstNames() {
        return this.fatherFirstNames;
    }

    private fr.cg95.cvq.business.civil.CertificateFormatType format;

    public final void setFormat(final fr.cg95.cvq.business.civil.CertificateFormatType format) {
        this.format = format;
    }


    /**
     * @hibernate.property
     *  column="format"
     */
    public final fr.cg95.cvq.business.civil.CertificateFormatType getFormat() {
        return this.format;
    }

    private java.math.BigInteger copies;

    public final void setCopies(final java.math.BigInteger copies) {
        this.copies = copies;
    }


    /**
     * @hibernate.property
     *  column="copies"
     *  type="serializable"
     */
    public final java.math.BigInteger getCopies() {
        return this.copies;
    }

    private fr.cg95.cvq.business.civil.CertificateType certificate;

    public final void setCertificate(final fr.cg95.cvq.business.civil.CertificateType certificate) {
        this.certificate = certificate;
    }


    /**
     * @hibernate.property
     *  column="certificate"
     */
    public final fr.cg95.cvq.business.civil.CertificateType getCertificate() {
        return this.certificate;
    }

    private String marriageCity;

    public final void setMarriageCity(final String marriageCity) {
        this.marriageCity = marriageCity;
    }


    /**
     * @hibernate.property
     *  column="marriage_city"
     *  length="32"
     */
    public final String getMarriageCity() {
        return this.marriageCity;
    }

    private String usage;

    public final void setUsage(final String usage) {
        this.usage = usage;
    }


    /**
     * @hibernate.property
     *  column="usage"
     */
    public final String getUsage() {
        return this.usage;
    }

    private fr.cg95.cvq.business.civil.RequesterQualityType requesterQuality;

    public final void setRequesterQuality(final fr.cg95.cvq.business.civil.RequesterQualityType requesterQuality) {
        this.requesterQuality = requesterQuality;
    }


    /**
     * @hibernate.property
     *  column="requester_quality"
     */
    public final fr.cg95.cvq.business.civil.RequesterQualityType getRequesterQuality() {
        return this.requesterQuality;
    }

    private String fatherLastName;

    public final void setFatherLastName(final String fatherLastName) {
        this.fatherLastName = fatherLastName;
    }


    /**
     * @hibernate.property
     *  column="father_last_name"
     *  length="38"
     */
    public final String getFatherLastName() {
        return this.fatherLastName;
    }

    private String birthCity;

    public final void setBirthCity(final String birthCity) {
        this.birthCity = birthCity;
    }


    /**
     * @hibernate.property
     *  column="birth_city"
     *  length="32"
     */
    public final String getBirthCity() {
        return this.birthCity;
    }

    private String motherMaidenName;

    public final void setMotherMaidenName(final String motherMaidenName) {
        this.motherMaidenName = motherMaidenName;
    }


    /**
     * @hibernate.property
     *  column="mother_maiden_name"
     *  length="38"
     */
    public final String getMotherMaidenName() {
        return this.motherMaidenName;
    }

    private String birthFirstNames;

    public final void setBirthFirstNames(final String birthFirstNames) {
        this.birthFirstNames = birthFirstNames;
    }


    /**
     * @hibernate.property
     *  column="birth_first_names"
     */
    public final String getBirthFirstNames() {
        return this.birthFirstNames;
    }

    private java.util.Date deathDate;

    public final void setDeathDate(final java.util.Date deathDate) {
        this.deathDate = deathDate;
    }


    /**
     * @hibernate.property
     *  column="death_date"
     */
    public final java.util.Date getDeathDate() {
        return this.deathDate;
    }

    private String birthPostalCode;

    public final void setBirthPostalCode(final String birthPostalCode) {
        this.birthPostalCode = birthPostalCode;
    }


    /**
     * @hibernate.property
     *  column="birth_postal_code"
     *  length="2"
     */
    public final String getBirthPostalCode() {
        return this.birthPostalCode;
    }

    private String deathPostalCode;

    public final void setDeathPostalCode(final String deathPostalCode) {
        this.deathPostalCode = deathPostalCode;
    }


    /**
     * @hibernate.property
     *  column="death_postal_code"
     *  length="2"
     */
    public final String getDeathPostalCode() {
        return this.deathPostalCode;
    }

    private String marriageWifeLastName;

    public final void setMarriageWifeLastName(final String marriageWifeLastName) {
        this.marriageWifeLastName = marriageWifeLastName;
    }


    /**
     * @hibernate.property
     *  column="marriage_wife_last_name"
     *  length="38"
     */
    public final String getMarriageWifeLastName() {
        return this.marriageWifeLastName;
    }

    private String motherFirstNames;

    public final void setMotherFirstNames(final String motherFirstNames) {
        this.motherFirstNames = motherFirstNames;
    }


    /**
     * @hibernate.property
     *  column="mother_first_names"
     */
    public final String getMotherFirstNames() {
        return this.motherFirstNames;
    }

    private String deathCity;

    public final void setDeathCity(final String deathCity) {
        this.deathCity = deathCity;
    }


    /**
     * @hibernate.property
     *  column="death_city"
     *  length="32"
     */
    public final String getDeathCity() {
        return this.deathCity;
    }

    private String deathLastName;

    public final void setDeathLastName(final String deathLastName) {
        this.deathLastName = deathLastName;
    }


    /**
     * @hibernate.property
     *  column="death_last_name"
     *  length="38"
     */
    public final String getDeathLastName() {
        return this.deathLastName;
    }

    private java.util.Date marriageDate;

    public final void setMarriageDate(final java.util.Date marriageDate) {
        this.marriageDate = marriageDate;
    }


    /**
     * @hibernate.property
     *  column="marriage_date"
     */
    public final java.util.Date getMarriageDate() {
        return this.marriageDate;
    }

    private String marriageHusbandFirstNames;

    public final void setMarriageHusbandFirstNames(final String marriageHusbandFirstNames) {
        this.marriageHusbandFirstNames = marriageHusbandFirstNames;
    }


    /**
     * @hibernate.property
     *  column="marriage_husband_first_names"
     */
    public final String getMarriageHusbandFirstNames() {
        return this.marriageHusbandFirstNames;
    }

}
