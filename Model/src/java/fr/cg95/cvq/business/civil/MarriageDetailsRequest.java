package fr.cg95.cvq.business.civil;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.civil.*;

import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlObject;

import fr.cg95.cvq.xml.common.RequestType;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.*;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.joined-subclass
 *  table="marriage_details_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class MarriageDetailsRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public MarriageDetailsRequest() {
        super();
        relationship = fr.cg95.cvq.business.civil.MarriageRelationshipType.HUSBAND;
    }


    public final String modelToXmlString() {

        MarriageDetailsRequestDocument object = (MarriageDetailsRequestDocument) this.modelToXml();
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
        MarriageDetailsRequestDocument marriageDetailsRequestDoc = MarriageDetailsRequestDocument.Factory.newInstance();
        MarriageDetailsRequestDocument.MarriageDetailsRequest marriageDetailsRequest = marriageDetailsRequestDoc.addNewMarriageDetailsRequest();
        super.fillCommonXmlInfo(marriageDetailsRequest);
        if (this.copies != null)
            marriageDetailsRequest.setCopies(new BigInteger(this.copies.toString()));
        marriageDetailsRequest.setMotherFirstNames(this.motherFirstNames);
        marriageDetailsRequest.setComment(this.comment);
        marriageDetailsRequest.setRequesterQualityPrecision(this.requesterQualityPrecision);
        marriageDetailsRequest.setMarriageCity(this.marriageCity);
        if (this.relationship != null)
            marriageDetailsRequest.setRelationship(fr.cg95.cvq.xml.civil.MarriageRelationshipType.Enum.forString(this.relationship.toString()));
        marriageDetailsRequest.setMarriagePostalCode(this.marriagePostalCode);
        if (this.motive != null)
            marriageDetailsRequest.setMotive(fr.cg95.cvq.xml.civil.MarriageCertificateMotiveType.Enum.forString(this.motive.toString()));
        if (this.requesterQuality != null)
            marriageDetailsRequest.setRequesterQuality(fr.cg95.cvq.xml.civil.MarriageRequesterQualityType.Enum.forString(this.requesterQuality.toString()));
        marriageDetailsRequest.setFatherLastName(this.fatherLastName);
        marriageDetailsRequest.setMotherMaidenName(this.motherMaidenName);
        date = this.marriageDate;
        if (date != null) {
            calendar.setTime(date);
            marriageDetailsRequest.setMarriageDate(calendar);
        }
        marriageDetailsRequest.setMarriageWifeFirstNames(this.marriageWifeFirstNames);
        marriageDetailsRequest.setMarriageWifeLastName(this.marriageWifeLastName);
        marriageDetailsRequest.setMarriageHusbandLastName(this.marriageHusbandLastName);
        marriageDetailsRequest.setFatherFirstNames(this.fatherFirstNames);
        marriageDetailsRequest.setMarriageHusbandFirstNames(this.marriageHusbandFirstNames);
        if (this.format != null)
            marriageDetailsRequest.setFormat(fr.cg95.cvq.xml.civil.MarriageCertificateFormatType.Enum.forString(this.format.toString()));
        return marriageDetailsRequestDoc;
    }

    @Override
    public RequestType modelToXmlRequest() {
        MarriageDetailsRequestDocument marriageDetailsRequestDoc =
            (MarriageDetailsRequestDocument) modelToXml();
        return marriageDetailsRequestDoc.getMarriageDetailsRequest();
    }

    public static MarriageDetailsRequest xmlToModel(MarriageDetailsRequestDocument marriageDetailsRequestDoc) {

        MarriageDetailsRequestDocument.MarriageDetailsRequest marriageDetailsRequestXml = marriageDetailsRequestDoc.getMarriageDetailsRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        MarriageDetailsRequest marriageDetailsRequest = new MarriageDetailsRequest();
        marriageDetailsRequest.fillCommonModelInfo(marriageDetailsRequest,marriageDetailsRequestXml);
        marriageDetailsRequest.setCopies(marriageDetailsRequestXml.getCopies());
        marriageDetailsRequest.setMotherFirstNames(marriageDetailsRequestXml.getMotherFirstNames());
        marriageDetailsRequest.setComment(marriageDetailsRequestXml.getComment());
        marriageDetailsRequest.setRequesterQualityPrecision(marriageDetailsRequestXml.getRequesterQualityPrecision());
        marriageDetailsRequest.setMarriageCity(marriageDetailsRequestXml.getMarriageCity());
        if (marriageDetailsRequestXml.getRelationship() != null)
            marriageDetailsRequest.setRelationship(fr.cg95.cvq.business.civil.MarriageRelationshipType.forString(marriageDetailsRequestXml.getRelationship().toString()));
        else
            marriageDetailsRequest.setRelationship(fr.cg95.cvq.business.civil.MarriageRelationshipType.getDefaultMarriageRelationshipType());
        marriageDetailsRequest.setMarriagePostalCode(marriageDetailsRequestXml.getMarriagePostalCode());
        if (marriageDetailsRequestXml.getMotive() != null)
            marriageDetailsRequest.setMotive(fr.cg95.cvq.business.civil.MarriageCertificateMotiveType.forString(marriageDetailsRequestXml.getMotive().toString()));
        else
            marriageDetailsRequest.setMotive(fr.cg95.cvq.business.civil.MarriageCertificateMotiveType.getDefaultMarriageCertificateMotiveType());
        if (marriageDetailsRequestXml.getRequesterQuality() != null)
            marriageDetailsRequest.setRequesterQuality(fr.cg95.cvq.business.civil.MarriageRequesterQualityType.forString(marriageDetailsRequestXml.getRequesterQuality().toString()));
        else
            marriageDetailsRequest.setRequesterQuality(fr.cg95.cvq.business.civil.MarriageRequesterQualityType.getDefaultMarriageRequesterQualityType());
        marriageDetailsRequest.setFatherLastName(marriageDetailsRequestXml.getFatherLastName());
        marriageDetailsRequest.setMotherMaidenName(marriageDetailsRequestXml.getMotherMaidenName());
        calendar = marriageDetailsRequestXml.getMarriageDate();
        if (calendar != null) {
            marriageDetailsRequest.setMarriageDate(calendar.getTime());
        }
        marriageDetailsRequest.setMarriageWifeFirstNames(marriageDetailsRequestXml.getMarriageWifeFirstNames());
        marriageDetailsRequest.setMarriageWifeLastName(marriageDetailsRequestXml.getMarriageWifeLastName());
        marriageDetailsRequest.setMarriageHusbandLastName(marriageDetailsRequestXml.getMarriageHusbandLastName());
        marriageDetailsRequest.setFatherFirstNames(marriageDetailsRequestXml.getFatherFirstNames());
        marriageDetailsRequest.setMarriageHusbandFirstNames(marriageDetailsRequestXml.getMarriageHusbandFirstNames());
        if (marriageDetailsRequestXml.getFormat() != null)
            marriageDetailsRequest.setFormat(fr.cg95.cvq.business.civil.MarriageCertificateFormatType.forString(marriageDetailsRequestXml.getFormat().toString()));
        else
            marriageDetailsRequest.setFormat(fr.cg95.cvq.business.civil.MarriageCertificateFormatType.getDefaultMarriageCertificateFormatType());
        return marriageDetailsRequest;
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

    private String comment;

    public final void setComment(final String comment) {
        this.comment = comment;
    }


    /**
     * @hibernate.property
     *  column="comment"
     */
    public final String getComment() {
        return this.comment;
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

    private fr.cg95.cvq.business.civil.MarriageRelationshipType relationship;

    public final void setRelationship(final fr.cg95.cvq.business.civil.MarriageRelationshipType relationship) {
        this.relationship = relationship;
    }


    /**
     * @hibernate.property
     *  column="relationship"
     */
    public final fr.cg95.cvq.business.civil.MarriageRelationshipType getRelationship() {
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

    private fr.cg95.cvq.business.civil.MarriageCertificateMotiveType motive;

    public final void setMotive(final fr.cg95.cvq.business.civil.MarriageCertificateMotiveType motive) {
        this.motive = motive;
    }


    /**
     * @hibernate.property
     *  column="motive"
     */
    public final fr.cg95.cvq.business.civil.MarriageCertificateMotiveType getMotive() {
        return this.motive;
    }

    private fr.cg95.cvq.business.civil.MarriageRequesterQualityType requesterQuality;

    public final void setRequesterQuality(final fr.cg95.cvq.business.civil.MarriageRequesterQualityType requesterQuality) {
        this.requesterQuality = requesterQuality;
    }


    /**
     * @hibernate.property
     *  column="requester_quality"
     */
    public final fr.cg95.cvq.business.civil.MarriageRequesterQualityType getRequesterQuality() {
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

    private fr.cg95.cvq.business.civil.MarriageCertificateFormatType format;

    public final void setFormat(final fr.cg95.cvq.business.civil.MarriageCertificateFormatType format) {
        this.format = format;
    }


    /**
     * @hibernate.property
     *  column="format"
     */
    public final fr.cg95.cvq.business.civil.MarriageCertificateFormatType getFormat() {
        return this.format;
    }

}
