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
 *  table="death_details_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class DeathDetailsRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public DeathDetailsRequest() {
        super();
        format = fr.cg95.cvq.business.request.civil.DeathCertificateFormatType.FULL_COPY;
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
        deathDetailsRequest.setDeathFirstNames(this.deathFirstNames);
        deathDetailsRequest.setDeathCity(this.deathCity);
        if (this.format != null)
            deathDetailsRequest.setFormat(fr.cg95.cvq.xml.request.civil.DeathCertificateFormatType.Enum.forString(this.format.toString()));
        if (this.copies != null)
            deathDetailsRequest.setCopies(new BigInteger(this.copies.toString()));
        deathDetailsRequest.setComment(this.comment);
        if (this.motive != null)
            deathDetailsRequest.setMotive(fr.cg95.cvq.xml.request.civil.DeathCertificateMotiveType.Enum.forString(this.motive.toString()));
        deathDetailsRequest.setDeathPostalCode(this.deathPostalCode);
        deathDetailsRequest.setDeathLastName(this.deathLastName);
        date = this.deathDate;
        if (date != null) {
            calendar.setTime(date);
            deathDetailsRequest.setDeathDate(calendar);
        }
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
        deathDetailsRequest.setDeathFirstNames(deathDetailsRequestXml.getDeathFirstNames());
        deathDetailsRequest.setDeathCity(deathDetailsRequestXml.getDeathCity());
        if (deathDetailsRequestXml.getFormat() != null)
            deathDetailsRequest.setFormat(fr.cg95.cvq.business.request.civil.DeathCertificateFormatType.forString(deathDetailsRequestXml.getFormat().toString()));
        else
            deathDetailsRequest.setFormat(fr.cg95.cvq.business.request.civil.DeathCertificateFormatType.getDefaultDeathCertificateFormatType());
        deathDetailsRequest.setCopies(deathDetailsRequestXml.getCopies());
        deathDetailsRequest.setComment(deathDetailsRequestXml.getComment());
        if (deathDetailsRequestXml.getMotive() != null)
            deathDetailsRequest.setMotive(fr.cg95.cvq.business.request.civil.DeathCertificateMotiveType.forString(deathDetailsRequestXml.getMotive().toString()));
        else
            deathDetailsRequest.setMotive(fr.cg95.cvq.business.request.civil.DeathCertificateMotiveType.getDefaultDeathCertificateMotiveType());
        deathDetailsRequest.setDeathPostalCode(deathDetailsRequestXml.getDeathPostalCode());
        deathDetailsRequest.setDeathLastName(deathDetailsRequestXml.getDeathLastName());
        calendar = deathDetailsRequestXml.getDeathDate();
        if (calendar != null) {
            deathDetailsRequest.setDeathDate(calendar.getTime());
        }
        return deathDetailsRequest;
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

    private fr.cg95.cvq.business.request.civil.DeathCertificateFormatType format;

    public final void setFormat(final fr.cg95.cvq.business.request.civil.DeathCertificateFormatType format) {
        this.format = format;
    }


    /**
     * @hibernate.property
     *  column="format"
     */
    public final fr.cg95.cvq.business.request.civil.DeathCertificateFormatType getFormat() {
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

    private fr.cg95.cvq.business.request.civil.DeathCertificateMotiveType motive;

    public final void setMotive(final fr.cg95.cvq.business.request.civil.DeathCertificateMotiveType motive) {
        this.motive = motive;
    }


    /**
     * @hibernate.property
     *  column="motive"
     */
    public final fr.cg95.cvq.business.request.civil.DeathCertificateMotiveType getMotive() {
        return this.motive;
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

}
