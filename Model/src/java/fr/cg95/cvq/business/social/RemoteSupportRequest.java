package fr.cg95.cvq.business.social;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;

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
 *  table="remote_support_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class RemoteSupportRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public RemoteSupportRequest() {
        super();
    }


    public final String modelToXmlString() {

        RemoteSupportRequestDocument object = (RemoteSupportRequestDocument) this.modelToXml();
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
        RemoteSupportRequestDocument remoteSupportRequestDoc = RemoteSupportRequestDocument.Factory.newInstance();
        RemoteSupportRequestDocument.RemoteSupportRequest remoteSupportRequest = remoteSupportRequestDoc.addNewRemoteSupportRequest();
        super.fillCommonXmlInfo(remoteSupportRequest);
        remoteSupportRequest.setTrusteePhone(this.trusteePhone);
        if (this.emergency != null)
            remoteSupportRequest.setEmergency(this.emergency.booleanValue());
        remoteSupportRequest.setTrusteeName(this.trusteeName);
        if (this.appartmentNumber != null)
            remoteSupportRequest.setAppartmentNumber(new BigInteger(this.appartmentNumber.toString()));
        if (this.trustee != null)
            remoteSupportRequest.setTrustee(fr.cg95.cvq.xml.social.TrusteeType.Enum.forString(this.trustee.toString()));
        remoteSupportRequest.setContactPhone(this.contactPhone);
        if (this.floor != null)
            remoteSupportRequest.setFloor(new BigInteger(this.floor.toString()));
        if (this.dwelling != null)
            remoteSupportRequest.setDwelling(fr.cg95.cvq.xml.social.RsrDwellingType.Enum.forString(this.dwelling.toString()));
        remoteSupportRequest.setContactFirstName(this.contactFirstName);
        remoteSupportRequest.setTrusteeFirstName(this.trusteeFirstName);
        if (this.taxable != null)
            remoteSupportRequest.setTaxable(this.taxable.booleanValue());
        if (this.seniorAssitanceBeneficiary != null)
            remoteSupportRequest.setSeniorAssitanceBeneficiary(this.seniorAssitanceBeneficiary.booleanValue());
        remoteSupportRequest.setContactName(this.contactName);
        if (this.contact != null)
            remoteSupportRequest.setContact(fr.cg95.cvq.xml.social.RsrContactType.Enum.forString(this.contact.toString()));
        return remoteSupportRequestDoc;
    }

    @Override
    public RequestType modelToXmlRequest() {
        RemoteSupportRequestDocument remoteSupportRequestDoc =
            (RemoteSupportRequestDocument) modelToXml();
        return remoteSupportRequestDoc.getRemoteSupportRequest();
    }

    public static RemoteSupportRequest xmlToModel(RemoteSupportRequestDocument remoteSupportRequestDoc) {

        RemoteSupportRequestDocument.RemoteSupportRequest remoteSupportRequestXml = remoteSupportRequestDoc.getRemoteSupportRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        RemoteSupportRequest remoteSupportRequest = new RemoteSupportRequest();
        remoteSupportRequest.fillCommonModelInfo(remoteSupportRequest,remoteSupportRequestXml);
        remoteSupportRequest.setTrusteePhone(remoteSupportRequestXml.getTrusteePhone());
        remoteSupportRequest.setEmergency(Boolean.valueOf(remoteSupportRequestXml.getEmergency()));
        remoteSupportRequest.setTrusteeName(remoteSupportRequestXml.getTrusteeName());
        remoteSupportRequest.setAppartmentNumber(remoteSupportRequestXml.getAppartmentNumber());
        if (remoteSupportRequestXml.getTrustee() != null)
            remoteSupportRequest.setTrustee(fr.cg95.cvq.business.social.TrusteeType.forString(remoteSupportRequestXml.getTrustee().toString()));
        else
            remoteSupportRequest.setTrustee(fr.cg95.cvq.business.social.TrusteeType.getDefaultTrusteeType());
        remoteSupportRequest.setContactPhone(remoteSupportRequestXml.getContactPhone());
        remoteSupportRequest.setFloor(remoteSupportRequestXml.getFloor());
        if (remoteSupportRequestXml.getDwelling() != null)
            remoteSupportRequest.setDwelling(fr.cg95.cvq.business.social.RsrDwellingType.forString(remoteSupportRequestXml.getDwelling().toString()));
        else
            remoteSupportRequest.setDwelling(fr.cg95.cvq.business.social.RsrDwellingType.getDefaultRsrDwellingType());
        remoteSupportRequest.setContactFirstName(remoteSupportRequestXml.getContactFirstName());
        remoteSupportRequest.setTrusteeFirstName(remoteSupportRequestXml.getTrusteeFirstName());
        remoteSupportRequest.setTaxable(Boolean.valueOf(remoteSupportRequestXml.getTaxable()));
        remoteSupportRequest.setSeniorAssitanceBeneficiary(Boolean.valueOf(remoteSupportRequestXml.getSeniorAssitanceBeneficiary()));
        remoteSupportRequest.setContactName(remoteSupportRequestXml.getContactName());
        if (remoteSupportRequestXml.getContact() != null)
            remoteSupportRequest.setContact(fr.cg95.cvq.business.social.RsrContactType.forString(remoteSupportRequestXml.getContact().toString()));
        else
            remoteSupportRequest.setContact(fr.cg95.cvq.business.social.RsrContactType.getDefaultRsrContactType());
        return remoteSupportRequest;
    }

    private String trusteePhone;

    public final void setTrusteePhone(final String trusteePhone) {
        this.trusteePhone = trusteePhone;
    }


    /**
     * @hibernate.property
     *  column="trustee_phone"
     *  length="10"
     */
    public final String getTrusteePhone() {
        return this.trusteePhone;
    }

    private Boolean emergency;

    public final void setEmergency(final Boolean emergency) {
        this.emergency = emergency;
    }


    /**
     * @hibernate.property
     *  column="emergency"
     */
    public final Boolean getEmergency() {
        return this.emergency;
    }

    private String trusteeName;

    public final void setTrusteeName(final String trusteeName) {
        this.trusteeName = trusteeName;
    }


    /**
     * @hibernate.property
     *  column="trustee_name"
     *  length="38"
     */
    public final String getTrusteeName() {
        return this.trusteeName;
    }

    private java.math.BigInteger appartmentNumber;

    public final void setAppartmentNumber(final java.math.BigInteger appartmentNumber) {
        this.appartmentNumber = appartmentNumber;
    }


    /**
     * @hibernate.property
     *  column="appartment_number"
     *  type="serializable"
     */
    public final java.math.BigInteger getAppartmentNumber() {
        return this.appartmentNumber;
    }

    private fr.cg95.cvq.business.social.TrusteeType trustee;

    public final void setTrustee(final fr.cg95.cvq.business.social.TrusteeType trustee) {
        this.trustee = trustee;
    }


    /**
     * @hibernate.property
     *  column="trustee"
     */
    public final fr.cg95.cvq.business.social.TrusteeType getTrustee() {
        return this.trustee;
    }

    private String contactPhone;

    public final void setContactPhone(final String contactPhone) {
        this.contactPhone = contactPhone;
    }


    /**
     * @hibernate.property
     *  column="contact_phone"
     *  length="10"
     */
    public final String getContactPhone() {
        return this.contactPhone;
    }

    private java.math.BigInteger floor;

    public final void setFloor(final java.math.BigInteger floor) {
        this.floor = floor;
    }


    /**
     * @hibernate.property
     *  column="floor"
     *  type="serializable"
     */
    public final java.math.BigInteger getFloor() {
        return this.floor;
    }

    private fr.cg95.cvq.business.social.RsrDwellingType dwelling;

    public final void setDwelling(final fr.cg95.cvq.business.social.RsrDwellingType dwelling) {
        this.dwelling = dwelling;
    }


    /**
     * @hibernate.property
     *  column="dwelling"
     */
    public final fr.cg95.cvq.business.social.RsrDwellingType getDwelling() {
        return this.dwelling;
    }

    private String contactFirstName;

    public final void setContactFirstName(final String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }


    /**
     * @hibernate.property
     *  column="contact_first_name"
     *  length="38"
     */
    public final String getContactFirstName() {
        return this.contactFirstName;
    }

    private String trusteeFirstName;

    public final void setTrusteeFirstName(final String trusteeFirstName) {
        this.trusteeFirstName = trusteeFirstName;
    }


    /**
     * @hibernate.property
     *  column="trustee_first_name"
     *  length="38"
     */
    public final String getTrusteeFirstName() {
        return this.trusteeFirstName;
    }

    private Boolean taxable;

    public final void setTaxable(final Boolean taxable) {
        this.taxable = taxable;
    }


    /**
     * @hibernate.property
     *  column="taxable"
     */
    public final Boolean getTaxable() {
        return this.taxable;
    }

    private Boolean seniorAssitanceBeneficiary;

    public final void setSeniorAssitanceBeneficiary(final Boolean seniorAssitanceBeneficiary) {
        this.seniorAssitanceBeneficiary = seniorAssitanceBeneficiary;
    }


    /**
     * @hibernate.property
     *  column="senior_assitance_beneficiary"
     */
    public final Boolean getSeniorAssitanceBeneficiary() {
        return this.seniorAssitanceBeneficiary;
    }

    private String contactName;

    public final void setContactName(final String contactName) {
        this.contactName = contactName;
    }


    /**
     * @hibernate.property
     *  column="contact_name"
     *  length="38"
     */
    public final String getContactName() {
        return this.contactName;
    }

    private fr.cg95.cvq.business.social.RsrContactType contact;

    public final void setContact(final fr.cg95.cvq.business.social.RsrContactType contact) {
        this.contact = contact;
    }


    /**
     * @hibernate.property
     *  column="contact"
     */
    public final fr.cg95.cvq.business.social.RsrContactType getContact() {
        return this.contact;
    }

}
