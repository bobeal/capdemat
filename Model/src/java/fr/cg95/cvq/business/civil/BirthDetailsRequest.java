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
 *  table="birth_details_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class BirthDetailsRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public BirthDetailsRequest() {
        super();
        relationship = fr.cg95.cvq.business.civil.BirthRelationshipType.HUSBAND;
    }


    public final String modelToXmlString() {

        BirthDetailsRequestDocument object = (BirthDetailsRequestDocument) this.modelToXml();
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
        BirthDetailsRequestDocument birthDetailsRequestDoc = BirthDetailsRequestDocument.Factory.newInstance();
        BirthDetailsRequestDocument.BirthDetailsRequest birthDetailsRequest = birthDetailsRequestDoc.addNewBirthDetailsRequest();
        super.fillCommonXmlInfo(birthDetailsRequest);
        birthDetailsRequest.setBirthFirstNames(this.birthFirstNames);
        if (this.copies != null)
            birthDetailsRequest.setCopies(new BigInteger(this.copies.toString()));
        birthDetailsRequest.setMotherFirstNames(this.motherFirstNames);
        birthDetailsRequest.setBirthLastName(this.birthLastName);
        birthDetailsRequest.setRequesterQualityPrecision(this.requesterQualityPrecision);
        if (this.relationship != null)
            birthDetailsRequest.setRelationship(fr.cg95.cvq.xml.civil.BirthRelationshipType.Enum.forString(this.relationship.toString()));
        birthDetailsRequest.setUsage(this.usage);
        if (this.requesterQuality != null)
            birthDetailsRequest.setRequesterQuality(fr.cg95.cvq.xml.civil.BirthRequesterQualityType.Enum.forString(this.requesterQuality.toString()));
        birthDetailsRequest.setFatherLastName(this.fatherLastName);
        birthDetailsRequest.setBirthPostalCode(this.birthPostalCode);
        birthDetailsRequest.setBirthCity(this.birthCity);
        date = this.birthDate;
        if (date != null) {
            calendar.setTime(date);
            birthDetailsRequest.setBirthDate(calendar);
        }
        birthDetailsRequest.setMotherMaidenName(this.motherMaidenName);
        birthDetailsRequest.setFatherFirstNames(this.fatherFirstNames);
        if (this.format != null)
            birthDetailsRequest.setFormat(fr.cg95.cvq.xml.civil.BirthCertificateFormatType.Enum.forString(this.format.toString()));
        return birthDetailsRequestDoc;
    }

    public static BirthDetailsRequest xmlToModel(BirthDetailsRequestDocument birthDetailsRequestDoc) {

        BirthDetailsRequestDocument.BirthDetailsRequest birthDetailsRequestXml = birthDetailsRequestDoc.getBirthDetailsRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        BirthDetailsRequest birthDetailsRequest = new BirthDetailsRequest();
        birthDetailsRequest.fillCommonModelInfo(birthDetailsRequest,birthDetailsRequestXml);
        birthDetailsRequest.setBirthFirstNames(birthDetailsRequestXml.getBirthFirstNames());
        birthDetailsRequest.setCopies(birthDetailsRequestXml.getCopies());
        birthDetailsRequest.setMotherFirstNames(birthDetailsRequestXml.getMotherFirstNames());
        birthDetailsRequest.setBirthLastName(birthDetailsRequestXml.getBirthLastName());
        birthDetailsRequest.setRequesterQualityPrecision(birthDetailsRequestXml.getRequesterQualityPrecision());
        if (birthDetailsRequestXml.getRelationship() != null)
            birthDetailsRequest.setRelationship(fr.cg95.cvq.business.civil.BirthRelationshipType.forString(birthDetailsRequestXml.getRelationship().toString()));
        else
            birthDetailsRequest.setRelationship(fr.cg95.cvq.business.civil.BirthRelationshipType.getDefaultBirthRelationshipType());
        birthDetailsRequest.setUsage(birthDetailsRequestXml.getUsage());
        if (birthDetailsRequestXml.getRequesterQuality() != null)
            birthDetailsRequest.setRequesterQuality(fr.cg95.cvq.business.civil.BirthRequesterQualityType.forString(birthDetailsRequestXml.getRequesterQuality().toString()));
        else
            birthDetailsRequest.setRequesterQuality(fr.cg95.cvq.business.civil.BirthRequesterQualityType.getDefaultBirthRequesterQualityType());
        birthDetailsRequest.setFatherLastName(birthDetailsRequestXml.getFatherLastName());
        birthDetailsRequest.setBirthPostalCode(birthDetailsRequestXml.getBirthPostalCode());
        birthDetailsRequest.setBirthCity(birthDetailsRequestXml.getBirthCity());
        calendar = birthDetailsRequestXml.getBirthDate();
        if (calendar != null) {
            birthDetailsRequest.setBirthDate(calendar.getTime());
        }
        birthDetailsRequest.setMotherMaidenName(birthDetailsRequestXml.getMotherMaidenName());
        birthDetailsRequest.setFatherFirstNames(birthDetailsRequestXml.getFatherFirstNames());
        if (birthDetailsRequestXml.getFormat() != null)
            birthDetailsRequest.setFormat(fr.cg95.cvq.business.civil.BirthCertificateFormatType.forString(birthDetailsRequestXml.getFormat().toString()));
        else
            birthDetailsRequest.setFormat(fr.cg95.cvq.business.civil.BirthCertificateFormatType.getDefaultBirthCertificateFormatType());
        return birthDetailsRequest;
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

    private fr.cg95.cvq.business.civil.BirthRelationshipType relationship;

    public final void setRelationship(final fr.cg95.cvq.business.civil.BirthRelationshipType relationship) {
        this.relationship = relationship;
    }


    /**
     * @hibernate.property
     *  column="relationship"
     */
    public final fr.cg95.cvq.business.civil.BirthRelationshipType getRelationship() {
        return this.relationship;
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

    private fr.cg95.cvq.business.civil.BirthRequesterQualityType requesterQuality;

    public final void setRequesterQuality(final fr.cg95.cvq.business.civil.BirthRequesterQualityType requesterQuality) {
        this.requesterQuality = requesterQuality;
    }


    /**
     * @hibernate.property
     *  column="requester_quality"
     */
    public final fr.cg95.cvq.business.civil.BirthRequesterQualityType getRequesterQuality() {
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

    private fr.cg95.cvq.business.civil.BirthCertificateFormatType format;

    public final void setFormat(final fr.cg95.cvq.business.civil.BirthCertificateFormatType format) {
        this.format = format;
    }


    /**
     * @hibernate.property
     *  column="format"
     */
    public final fr.cg95.cvq.business.civil.BirthCertificateFormatType getFormat() {
        return this.format;
    }

}
