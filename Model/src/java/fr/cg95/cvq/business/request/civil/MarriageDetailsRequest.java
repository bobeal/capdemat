package fr.cg95.cvq.business.request.civil;

import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.civil.*;

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
        format = fr.cg95.cvq.business.request.civil.MarriageCertificateFormatType.FULL_COPY;
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
        if (this.format != null)
            marriageDetailsRequest.setFormat(fr.cg95.cvq.xml.request.civil.MarriageCertificateFormatType.Enum.forString(this.format.toString()));
        if (this.copies != null)
            marriageDetailsRequest.setCopies(new BigInteger(this.copies.toString()));
        MarriageHusbandInformationType marriageHusbandInformationTypeMarriageHusband = marriageDetailsRequest.addNewMarriageHusband();
        marriageHusbandInformationTypeMarriageHusband.setMarriageHusbandLastName(this.marriageHusbandLastName);
        MarriageWifeInformationType marriageWifeInformationTypeMarriageWife = marriageDetailsRequest.addNewMarriageWife();
        marriageWifeInformationTypeMarriageWife.setMarriageWifeFirstNames(this.marriageWifeFirstNames);
        marriageDetailsRequest.setComment(this.comment);
        marriageDetailsRequest.setRequesterQualityPrecision(this.requesterQualityPrecision);
        MarriageFatherInformationType marriageFatherInformationTypeFatherInformation = marriageDetailsRequest.addNewFatherInformation();
        marriageFatherInformationTypeFatherInformation.setFatherFirstNames(this.fatherFirstNames);
        MarriageInformationType marriageInformationTypeMarriage = marriageDetailsRequest.addNewMarriage();
        marriageInformationTypeMarriage.setMarriagePostalCode(this.marriagePostalCode);
        MarriageMotherInformationType marriageMotherInformationTypeMotherInformation = marriageDetailsRequest.addNewMotherInformation();
        marriageMotherInformationTypeMotherInformation.setMotherMaidenName(this.motherMaidenName);
        marriageHusbandInformationTypeMarriageHusband.setMarriageHusbandFirstNames(this.marriageHusbandFirstNames);
        if (this.requesterQuality != null)
            marriageDetailsRequest.setRequesterQuality(fr.cg95.cvq.xml.request.civil.MarriageRequesterQualityType.Enum.forString(this.requesterQuality.toString()));
        marriageInformationTypeMarriage.setMarriageCity(this.marriageCity);
        marriageWifeInformationTypeMarriageWife.setMarriageWifeLastName(this.marriageWifeLastName);
        date = this.marriageDate;
        if (date != null) {
            calendar.setTime(date);
            marriageInformationTypeMarriage.setMarriageDate(calendar);
        }
        marriageFatherInformationTypeFatherInformation.setFatherLastName(this.fatherLastName);
        if (this.relationship != null)
            marriageDetailsRequest.setRelationship(fr.cg95.cvq.xml.request.civil.MarriageRelationshipType.Enum.forString(this.relationship.toString()));
        marriageMotherInformationTypeMotherInformation.setMotherFirstNames(this.motherFirstNames);
        if (this.motive != null)
            marriageDetailsRequest.setMotive(fr.cg95.cvq.xml.request.civil.MarriageCertificateMotiveType.Enum.forString(this.motive.toString()));
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
        if (marriageDetailsRequestXml.getFormat() != null)
            marriageDetailsRequest.setFormat(fr.cg95.cvq.business.request.civil.MarriageCertificateFormatType.forString(marriageDetailsRequestXml.getFormat().toString()));
        else
            marriageDetailsRequest.setFormat(fr.cg95.cvq.business.request.civil.MarriageCertificateFormatType.getDefaultMarriageCertificateFormatType());
        marriageDetailsRequest.setCopies(marriageDetailsRequestXml.getCopies());
        marriageDetailsRequest.setMarriageHusbandLastName(marriageDetailsRequestXml.getMarriageHusband().getMarriageHusbandLastName());
        marriageDetailsRequest.setMarriageWifeFirstNames(marriageDetailsRequestXml.getMarriageWife().getMarriageWifeFirstNames());
        marriageDetailsRequest.setComment(marriageDetailsRequestXml.getComment());
        marriageDetailsRequest.setRequesterQualityPrecision(marriageDetailsRequestXml.getRequesterQualityPrecision());
        marriageDetailsRequest.setFatherFirstNames(marriageDetailsRequestXml.getFatherInformation().getFatherFirstNames());
        marriageDetailsRequest.setMarriagePostalCode(marriageDetailsRequestXml.getMarriage().getMarriagePostalCode());
        marriageDetailsRequest.setMotherMaidenName(marriageDetailsRequestXml.getMotherInformation().getMotherMaidenName());
        marriageDetailsRequest.setMarriageHusbandFirstNames(marriageDetailsRequestXml.getMarriageHusband().getMarriageHusbandFirstNames());
        if (marriageDetailsRequestXml.getRequesterQuality() != null)
            marriageDetailsRequest.setRequesterQuality(fr.cg95.cvq.business.request.civil.MarriageRequesterQualityType.forString(marriageDetailsRequestXml.getRequesterQuality().toString()));
        else
            marriageDetailsRequest.setRequesterQuality(fr.cg95.cvq.business.request.civil.MarriageRequesterQualityType.getDefaultMarriageRequesterQualityType());
        marriageDetailsRequest.setMarriageCity(marriageDetailsRequestXml.getMarriage().getMarriageCity());
        marriageDetailsRequest.setMarriageWifeLastName(marriageDetailsRequestXml.getMarriageWife().getMarriageWifeLastName());
        calendar = marriageDetailsRequestXml.getMarriage().getMarriageDate();
        if (calendar != null) {
            marriageDetailsRequest.setMarriageDate(calendar.getTime());
        }
        marriageDetailsRequest.setFatherLastName(marriageDetailsRequestXml.getFatherInformation().getFatherLastName());
        if (marriageDetailsRequestXml.getRelationship() != null)
            marriageDetailsRequest.setRelationship(fr.cg95.cvq.business.request.civil.MarriageRelationshipType.forString(marriageDetailsRequestXml.getRelationship().toString()));
        else
            marriageDetailsRequest.setRelationship(fr.cg95.cvq.business.request.civil.MarriageRelationshipType.getDefaultMarriageRelationshipType());
        marriageDetailsRequest.setMotherFirstNames(marriageDetailsRequestXml.getMotherInformation().getMotherFirstNames());
        if (marriageDetailsRequestXml.getMotive() != null)
            marriageDetailsRequest.setMotive(fr.cg95.cvq.business.request.civil.MarriageCertificateMotiveType.forString(marriageDetailsRequestXml.getMotive().toString()));
        else
            marriageDetailsRequest.setMotive(fr.cg95.cvq.business.request.civil.MarriageCertificateMotiveType.getDefaultMarriageCertificateMotiveType());
        return marriageDetailsRequest;
    }

    private fr.cg95.cvq.business.request.civil.MarriageCertificateFormatType format;

    public final void setFormat(final fr.cg95.cvq.business.request.civil.MarriageCertificateFormatType format) {
        this.format = format;
    }


    /**
     * @hibernate.property
     *  column="format"
     */
    public final fr.cg95.cvq.business.request.civil.MarriageCertificateFormatType getFormat() {
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

    private fr.cg95.cvq.business.request.civil.MarriageRequesterQualityType requesterQuality;

    public final void setRequesterQuality(final fr.cg95.cvq.business.request.civil.MarriageRequesterQualityType requesterQuality) {
        this.requesterQuality = requesterQuality;
    }


    /**
     * @hibernate.property
     *  column="requester_quality"
     */
    public final fr.cg95.cvq.business.request.civil.MarriageRequesterQualityType getRequesterQuality() {
        return this.requesterQuality;
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

    private fr.cg95.cvq.business.request.civil.MarriageRelationshipType relationship;

    public final void setRelationship(final fr.cg95.cvq.business.request.civil.MarriageRelationshipType relationship) {
        this.relationship = relationship;
    }


    /**
     * @hibernate.property
     *  column="relationship"
     */
    public final fr.cg95.cvq.business.request.civil.MarriageRelationshipType getRelationship() {
        return this.relationship;
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

    private fr.cg95.cvq.business.request.civil.MarriageCertificateMotiveType motive;

    public final void setMotive(final fr.cg95.cvq.business.request.civil.MarriageCertificateMotiveType motive) {
        this.motive = motive;
    }


    /**
     * @hibernate.property
     *  column="motive"
     */
    public final fr.cg95.cvq.business.request.civil.MarriageCertificateMotiveType getMotive() {
        return this.motive;
    }

}
