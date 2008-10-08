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
 *  table="death_details_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class DeathDetailsRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public DeathDetailsRequest() {
        super();
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
        deathDetailsRequest.setComment(this.comment);
        deathDetailsRequest.setDeathFirstNames(this.deathFirstNames);
        if (this.motive != null)
            deathDetailsRequest.setMotive(fr.cg95.cvq.xml.civil.DeathCertificateMotiveType.Enum.forString(this.motive.toString()));
        date = this.deathDate;
        if (date != null) {
            calendar.setTime(date);
            deathDetailsRequest.setDeathDate(calendar);
        }
        deathDetailsRequest.setDeathCity(this.deathCity);
        deathDetailsRequest.setDeathPostalCode(this.deathPostalCode);
        deathDetailsRequest.setDeathLastName(this.deathLastName);
        if (this.format != null)
            deathDetailsRequest.setFormat(fr.cg95.cvq.xml.civil.DeathCertificateFormatType.Enum.forString(this.format.toString()));
        return deathDetailsRequestDoc;
    }

    @Override
    public RequestType modelToXmlRequest() {
        DeathDetailsRequestDocument deathDetailsRequestDoc =
            (DeathDetailsRequestDocument) modelToXml();
        return deathDetailsRequestDoc.getDeathDetailsRequest();
    }

    public static DeathDetailsRequest xmlToModel(DeathDetailsRequestDocument deathDetailsRequestDoc) {

        DeathDetailsRequestDocument.DeathDetailsRequest deathDetailsRequestXml = deathDetailsRequestDoc.getDeathDetailsRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        DeathDetailsRequest deathDetailsRequest = new DeathDetailsRequest();
        deathDetailsRequest.fillCommonModelInfo(deathDetailsRequest,deathDetailsRequestXml);
        deathDetailsRequest.setCopies(deathDetailsRequestXml.getCopies());
        deathDetailsRequest.setComment(deathDetailsRequestXml.getComment());
        deathDetailsRequest.setDeathFirstNames(deathDetailsRequestXml.getDeathFirstNames());
        if (deathDetailsRequestXml.getMotive() != null)
            deathDetailsRequest.setMotive(fr.cg95.cvq.business.civil.DeathCertificateMotiveType.forString(deathDetailsRequestXml.getMotive().toString()));
        else
            deathDetailsRequest.setMotive(fr.cg95.cvq.business.civil.DeathCertificateMotiveType.getDefaultDeathCertificateMotiveType());
        calendar = deathDetailsRequestXml.getDeathDate();
        if (calendar != null) {
            deathDetailsRequest.setDeathDate(calendar.getTime());
        }
        deathDetailsRequest.setDeathCity(deathDetailsRequestXml.getDeathCity());
        deathDetailsRequest.setDeathPostalCode(deathDetailsRequestXml.getDeathPostalCode());
        deathDetailsRequest.setDeathLastName(deathDetailsRequestXml.getDeathLastName());
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

    private fr.cg95.cvq.business.civil.DeathCertificateMotiveType motive;

    public final void setMotive(final fr.cg95.cvq.business.civil.DeathCertificateMotiveType motive) {
        this.motive = motive;
    }


    /**
     * @hibernate.property
     *  column="motive"
     */
    public final fr.cg95.cvq.business.civil.DeathCertificateMotiveType getMotive() {
        return this.motive;
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
