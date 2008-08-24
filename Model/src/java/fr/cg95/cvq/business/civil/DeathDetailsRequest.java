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
 *  table="death_details_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class DeathDetailsRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public DeathDetailsRequest() {
        super();
        relationship = fr.cg95.cvq.business.civil.DeathRelationshipType.HUSBAND;
    }


    public final String modelToXmlString() {

        DeathDetailsRequestDocument object = (DeathDetailsRequestDocument) this.modelToXml();
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
        DeathDetailsRequestDocument deathDetailsRequestDoc = DeathDetailsRequestDocument.Factory.newInstance();
        DeathDetailsRequestDocument.DeathDetailsRequest deathDetailsRequest = deathDetailsRequestDoc.addNewDeathDetailsRequest();
        super.fillCommonXmlInfo(deathDetailsRequest);
        if (this.copies != null)
            deathDetailsRequest.setCopies(new BigInteger(this.copies.toString()));
        deathDetailsRequest.setMotherFirstNames(this.motherFirstNames);
        deathDetailsRequest.setDeathFirstNames(this.deathFirstNames);
        deathDetailsRequest.setRequesterQualityPrecision(this.requesterQualityPrecision);
        if (this.relationship != null)
            deathDetailsRequest.setRelationship(fr.cg95.cvq.xml.civil.DeathRelationshipType.Enum.forString(this.relationship.toString()));
        deathDetailsRequest.setUsage(this.usage);
        if (this.requesterQuality != null)
            deathDetailsRequest.setRequesterQuality(fr.cg95.cvq.xml.civil.DeathRequesterQualityType.Enum.forString(this.requesterQuality.toString()));
        deathDetailsRequest.setFatherLastName(this.fatherLastName);
        date = this.deathDate;
        if (date != null) {
            calendar.setTime(date);
            deathDetailsRequest.setDeathDate(calendar);
        }
        deathDetailsRequest.setDeathCity(this.deathCity);
        deathDetailsRequest.setDeathPostalCode(this.deathPostalCode);
        deathDetailsRequest.setMotherMaidenName(this.motherMaidenName);
        deathDetailsRequest.setDeathLastName(this.deathLastName);
        deathDetailsRequest.setFatherFirstNames(this.fatherFirstNames);
        if (this.format != null)
            deathDetailsRequest.setFormat(fr.cg95.cvq.xml.civil.DeathCertificateFormatType.Enum.forString(this.format.toString()));
        return deathDetailsRequestDoc;
    }

    public static DeathDetailsRequest xmlToModel(DeathDetailsRequestDocument deathDetailsRequestDoc) {

        DeathDetailsRequestDocument.DeathDetailsRequest deathDetailsRequestXml = deathDetailsRequestDoc.getDeathDetailsRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        DeathDetailsRequest deathDetailsRequest = new DeathDetailsRequest();
        deathDetailsRequest.fillCommonModelInfo(deathDetailsRequest,deathDetailsRequestXml);
        deathDetailsRequest.setCopies(deathDetailsRequestXml.getCopies());
        deathDetailsRequest.setMotherFirstNames(deathDetailsRequestXml.getMotherFirstNames());
        deathDetailsRequest.setDeathFirstNames(deathDetailsRequestXml.getDeathFirstNames());
        deathDetailsRequest.setRequesterQualityPrecision(deathDetailsRequestXml.getRequesterQualityPrecision());
        if (deathDetailsRequestXml.getRelationship() != null)
            deathDetailsRequest.setRelationship(fr.cg95.cvq.business.civil.DeathRelationshipType.forString(deathDetailsRequestXml.getRelationship().toString()));
        else
            deathDetailsRequest.setRelationship(fr.cg95.cvq.business.civil.DeathRelationshipType.getDefaultDeathRelationshipType());
        deathDetailsRequest.setUsage(deathDetailsRequestXml.getUsage());
        if (deathDetailsRequestXml.getRequesterQuality() != null)
            deathDetailsRequest.setRequesterQuality(fr.cg95.cvq.business.civil.DeathRequesterQualityType.forString(deathDetailsRequestXml.getRequesterQuality().toString()));
        else
            deathDetailsRequest.setRequesterQuality(fr.cg95.cvq.business.civil.DeathRequesterQualityType.getDefaultDeathRequesterQualityType());
        deathDetailsRequest.setFatherLastName(deathDetailsRequestXml.getFatherLastName());
        calendar = deathDetailsRequestXml.getDeathDate();
        if (calendar != null) {
            deathDetailsRequest.setDeathDate(calendar.getTime());
        }
        deathDetailsRequest.setDeathCity(deathDetailsRequestXml.getDeathCity());
        deathDetailsRequest.setDeathPostalCode(deathDetailsRequestXml.getDeathPostalCode());
        deathDetailsRequest.setMotherMaidenName(deathDetailsRequestXml.getMotherMaidenName());
        deathDetailsRequest.setDeathLastName(deathDetailsRequestXml.getDeathLastName());
        deathDetailsRequest.setFatherFirstNames(deathDetailsRequestXml.getFatherFirstNames());
        if (deathDetailsRequestXml.getFormat() != null)
            deathDetailsRequest.setFormat(fr.cg95.cvq.business.civil.DeathCertificateFormatType.forString(deathDetailsRequestXml.getFormat().toString()));
        else
            deathDetailsRequest.setFormat(fr.cg95.cvq.business.civil.DeathCertificateFormatType.getDefaultDeathCertificateFormatType());
        return deathDetailsRequest;
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

    private fr.cg95.cvq.business.civil.DeathRelationshipType relationship;

    public final void setRelationship(final fr.cg95.cvq.business.civil.DeathRelationshipType relationship) {
        this.relationship = relationship;
    }


    /**
     * @hibernate.property
     *  column="relationship"
     */
    public final fr.cg95.cvq.business.civil.DeathRelationshipType getRelationship() {
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

    private fr.cg95.cvq.business.civil.DeathRequesterQualityType requesterQuality;

    public final void setRequesterQuality(final fr.cg95.cvq.business.civil.DeathRequesterQualityType requesterQuality) {
        this.requesterQuality = requesterQuality;
    }


    /**
     * @hibernate.property
     *  column="requester_quality"
     */
    public final fr.cg95.cvq.business.civil.DeathRequesterQualityType getRequesterQuality() {
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

    private fr.cg95.cvq.business.civil.DeathCertificateFormatType format;

    public final void setFormat(final fr.cg95.cvq.business.civil.DeathCertificateFormatType format) {
        this.format = format;
    }


    /**
     * @hibernate.property
     *  column="format"
     */
    public final fr.cg95.cvq.business.civil.DeathCertificateFormatType getFormat() {
        return this.format;
    }

}
