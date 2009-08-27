package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

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
        spouseIsDisabledPerson = Boolean.valueOf(false);
        subjectIsAPABeneficiary = Boolean.valueOf(false);
        subjectResideWith = fr.cg95.cvq.business.request.social.RsrSubjectResideWithType.ALONE;
        requestInformationEmergency = Boolean.valueOf(false);
        requestInformationRequestKind = fr.cg95.cvq.business.request.social.RsrRequestInformationRequestKindType.INDIVIDUAL;
        subjectIsDisabledPerson = Boolean.valueOf(false);
        contactKind = fr.cg95.cvq.business.request.social.RsrContactKindType.REQUESTER;
        subjectIsTaxable = Boolean.valueOf(false);
    }


    @Override
    public final String modelToXmlString() {

        RemoteSupportRequestDocument object = (RemoteSupportRequestDocument) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final XmlObject modelToXml() {

        Calendar calendar = Calendar.getInstance();
        Date date = null;
        RemoteSupportRequestDocument remoteSupportRequestDoc = RemoteSupportRequestDocument.Factory.newInstance();
        RemoteSupportRequestDocument.RemoteSupportRequest remoteSupportRequest = remoteSupportRequestDoc.addNewRemoteSupportRequest();
        super.fillCommonXmlInfo(remoteSupportRequest);
        RsrTrusteeType rsrTrusteeTypeTrustee = remoteSupportRequest.addNewTrustee();
        rsrTrusteeTypeTrustee.setTrusteePhone(this.trusteePhone);
        RsrSpouseType rsrSpouseTypeSpouse = remoteSupportRequest.addNewSpouse();
        if (this.spouseIsDisabledPerson != null)
            rsrSpouseTypeSpouse.setSpouseIsDisabledPerson(this.spouseIsDisabledPerson.booleanValue());
        RsrSubjectType rsrSubjectTypeRsrSubject = remoteSupportRequest.addNewRsrSubject();
        date = this.subjectBirthDate;
        if (date != null) {
            calendar.setTime(date);
            rsrSubjectTypeRsrSubject.setSubjectBirthDate(calendar);
        }
        if (this.subjectIsAPABeneficiary != null)
            rsrSubjectTypeRsrSubject.setSubjectIsAPABeneficiary(this.subjectIsAPABeneficiary.booleanValue());
        if (this.subjectResideWith != null)
            rsrSubjectTypeRsrSubject.setSubjectResideWith(fr.cg95.cvq.xml.request.social.RsrSubjectResideWithType.Enum.forString(this.subjectResideWith.toString()));
        date = this.spouseBirthDate;
        if (date != null) {
            calendar.setTime(date);
            rsrSpouseTypeSpouse.setSpouseBirthDate(calendar);
        }
        RsrContactType rsrContactTypeFirstContact = remoteSupportRequest.addNewFirstContact();
        rsrContactTypeFirstContact.setContactPhone(this.contactPhone);
        rsrSpouseTypeSpouse.setSpouseLastName(this.spouseLastName);
        RsrRequestInformationType rsrRequestInformationTypeRequestInformation = remoteSupportRequest.addNewRequestInformation();
        if (this.requestInformationEmergency != null)
            rsrRequestInformationTypeRequestInformation.setRequestInformationEmergency(this.requestInformationEmergency.booleanValue());
        if (this.requestInformationRequestKind != null)
            rsrRequestInformationTypeRequestInformation.setRequestInformationRequestKind(fr.cg95.cvq.xml.request.social.RsrRequestInformationRequestKindType.Enum.forString(this.requestInformationRequestKind.toString()));
        if (this.subjectIsDisabledPerson != null)
            rsrSubjectTypeRsrSubject.setSubjectIsDisabledPerson(this.subjectIsDisabledPerson.booleanValue());
        RsrSecondContactType rsrSecondContactTypeSecondContact = remoteSupportRequest.addNewSecondContact();
        rsrSecondContactTypeSecondContact.setSecondContactLastName(this.secondContactLastName);
        rsrRequestInformationTypeRequestInformation.setRequestInformationEmergencyMotive(this.requestInformationEmergencyMotive);
        rsrContactTypeFirstContact.setContactLastName(this.contactLastName);
        if (this.spouseTitle != null)
            rsrSpouseTypeSpouse.setSpouseTitle(fr.cg95.cvq.xml.common.TitleType.Enum.forString(this.spouseTitle.toString()));
        if (this.subjectTitle != null)
            rsrSubjectTypeRsrSubject.setSubjectTitle(fr.cg95.cvq.xml.common.TitleType.Enum.forString(this.subjectTitle.toString()));
        rsrSpouseTypeSpouse.setSpouseFirstName(this.spouseFirstName);
        rsrContactTypeFirstContact.setContactFirstName(this.contactFirstName);
        rsrTrusteeTypeTrustee.setTrusteeFirstName(this.trusteeFirstName);
        if (this.contactKind != null)
            remoteSupportRequest.setContactKind(fr.cg95.cvq.xml.request.social.RsrContactKindType.Enum.forString(this.contactKind.toString()));
        rsrSecondContactTypeSecondContact.setSecondContactFirstName(this.secondContactFirstName);
        if (this.subjectIsTaxable != null)
            rsrSubjectTypeRsrSubject.setSubjectIsTaxable(this.subjectIsTaxable.booleanValue());
        rsrTrusteeTypeTrustee.setTrusteeLastName(this.trusteeLastName);
        rsrSecondContactTypeSecondContact.setSecondContactPhone(this.secondContactPhone);
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
        remoteSupportRequest.setTrusteePhone(remoteSupportRequestXml.getTrustee().getTrusteePhone());
        remoteSupportRequest.setSpouseIsDisabledPerson(Boolean.valueOf(remoteSupportRequestXml.getSpouse().getSpouseIsDisabledPerson()));
        calendar = remoteSupportRequestXml.getRsrSubject().getSubjectBirthDate();
        if (calendar != null) {
            remoteSupportRequest.setSubjectBirthDate(calendar.getTime());
        }
        remoteSupportRequest.setSubjectIsAPABeneficiary(Boolean.valueOf(remoteSupportRequestXml.getRsrSubject().getSubjectIsAPABeneficiary()));
        if (remoteSupportRequestXml.getRsrSubject().getSubjectResideWith() != null)
            remoteSupportRequest.setSubjectResideWith(fr.cg95.cvq.business.request.social.RsrSubjectResideWithType.forString(remoteSupportRequestXml.getRsrSubject().getSubjectResideWith().toString()));
        else
            remoteSupportRequest.setSubjectResideWith(fr.cg95.cvq.business.request.social.RsrSubjectResideWithType.getDefaultRsrSubjectResideWithType());
        calendar = remoteSupportRequestXml.getSpouse().getSpouseBirthDate();
        if (calendar != null) {
            remoteSupportRequest.setSpouseBirthDate(calendar.getTime());
        }
        remoteSupportRequest.setContactPhone(remoteSupportRequestXml.getFirstContact().getContactPhone());
        remoteSupportRequest.setSpouseLastName(remoteSupportRequestXml.getSpouse().getSpouseLastName());
        remoteSupportRequest.setRequestInformationEmergency(Boolean.valueOf(remoteSupportRequestXml.getRequestInformation().getRequestInformationEmergency()));
        if (remoteSupportRequestXml.getRequestInformation().getRequestInformationRequestKind() != null)
            remoteSupportRequest.setRequestInformationRequestKind(fr.cg95.cvq.business.request.social.RsrRequestInformationRequestKindType.forString(remoteSupportRequestXml.getRequestInformation().getRequestInformationRequestKind().toString()));
        else
            remoteSupportRequest.setRequestInformationRequestKind(fr.cg95.cvq.business.request.social.RsrRequestInformationRequestKindType.getDefaultRsrRequestInformationRequestKindType());
        remoteSupportRequest.setSubjectIsDisabledPerson(Boolean.valueOf(remoteSupportRequestXml.getRsrSubject().getSubjectIsDisabledPerson()));
        remoteSupportRequest.setSecondContactLastName(remoteSupportRequestXml.getSecondContact().getSecondContactLastName());
        remoteSupportRequest.setRequestInformationEmergencyMotive(remoteSupportRequestXml.getRequestInformation().getRequestInformationEmergencyMotive());
        remoteSupportRequest.setContactLastName(remoteSupportRequestXml.getFirstContact().getContactLastName());
        if (remoteSupportRequestXml.getSpouse().getSpouseTitle() != null)
            remoteSupportRequest.setSpouseTitle(fr.cg95.cvq.business.users.TitleType.forString(remoteSupportRequestXml.getSpouse().getSpouseTitle().toString()));
        else
            remoteSupportRequest.setSpouseTitle(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
        if (remoteSupportRequestXml.getRsrSubject().getSubjectTitle() != null)
            remoteSupportRequest.setSubjectTitle(fr.cg95.cvq.business.users.TitleType.forString(remoteSupportRequestXml.getRsrSubject().getSubjectTitle().toString()));
        else
            remoteSupportRequest.setSubjectTitle(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
        remoteSupportRequest.setSpouseFirstName(remoteSupportRequestXml.getSpouse().getSpouseFirstName());
        remoteSupportRequest.setContactFirstName(remoteSupportRequestXml.getFirstContact().getContactFirstName());
        remoteSupportRequest.setTrusteeFirstName(remoteSupportRequestXml.getTrustee().getTrusteeFirstName());
        if (remoteSupportRequestXml.getContactKind() != null)
            remoteSupportRequest.setContactKind(fr.cg95.cvq.business.request.social.RsrContactKindType.forString(remoteSupportRequestXml.getContactKind().toString()));
        else
            remoteSupportRequest.setContactKind(fr.cg95.cvq.business.request.social.RsrContactKindType.getDefaultRsrContactKindType());
        remoteSupportRequest.setSecondContactFirstName(remoteSupportRequestXml.getSecondContact().getSecondContactFirstName());
        remoteSupportRequest.setSubjectIsTaxable(Boolean.valueOf(remoteSupportRequestXml.getRsrSubject().getSubjectIsTaxable()));
        remoteSupportRequest.setTrusteeLastName(remoteSupportRequestXml.getTrustee().getTrusteeLastName());
        remoteSupportRequest.setSecondContactPhone(remoteSupportRequestXml.getSecondContact().getSecondContactPhone());
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

    private Boolean spouseIsDisabledPerson;

    public final void setSpouseIsDisabledPerson(final Boolean spouseIsDisabledPerson) {
        this.spouseIsDisabledPerson = spouseIsDisabledPerson;
    }


    /**
     * @hibernate.property
     *  column="spouse_is_disabled_person"
     */
    public final Boolean getSpouseIsDisabledPerson() {
        return this.spouseIsDisabledPerson;
    }

    private java.util.Date subjectBirthDate;

    public final void setSubjectBirthDate(final java.util.Date subjectBirthDate) {
        this.subjectBirthDate = subjectBirthDate;
    }


    /**
     * @hibernate.property
     *  column="subject_birth_date"
     */
    public final java.util.Date getSubjectBirthDate() {
        return this.subjectBirthDate;
    }

    private Boolean subjectIsAPABeneficiary;

    public final void setSubjectIsAPABeneficiary(final Boolean subjectIsAPABeneficiary) {
        this.subjectIsAPABeneficiary = subjectIsAPABeneficiary;
    }


    /**
     * @hibernate.property
     *  column="subject_is_a_p_a_beneficiary"
     */
    public final Boolean getSubjectIsAPABeneficiary() {
        return this.subjectIsAPABeneficiary;
    }

    private fr.cg95.cvq.business.request.social.RsrSubjectResideWithType subjectResideWith;

    public final void setSubjectResideWith(final fr.cg95.cvq.business.request.social.RsrSubjectResideWithType subjectResideWith) {
        this.subjectResideWith = subjectResideWith;
    }


    /**
     * @hibernate.property
     *  column="subject_reside_with"
     */
    public final fr.cg95.cvq.business.request.social.RsrSubjectResideWithType getSubjectResideWith() {
        return this.subjectResideWith;
    }

    private java.util.Date spouseBirthDate;

    public final void setSpouseBirthDate(final java.util.Date spouseBirthDate) {
        this.spouseBirthDate = spouseBirthDate;
    }


    /**
     * @hibernate.property
     *  column="spouse_birth_date"
     */
    public final java.util.Date getSpouseBirthDate() {
        return this.spouseBirthDate;
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

    private String spouseLastName;

    public final void setSpouseLastName(final String spouseLastName) {
        this.spouseLastName = spouseLastName;
    }


    /**
     * @hibernate.property
     *  column="spouse_last_name"
     *  length="38"
     */
    public final String getSpouseLastName() {
        return this.spouseLastName;
    }

    private Boolean requestInformationEmergency;

    public final void setRequestInformationEmergency(final Boolean requestInformationEmergency) {
        this.requestInformationEmergency = requestInformationEmergency;
    }


    /**
     * @hibernate.property
     *  column="request_information_emergency"
     */
    public final Boolean getRequestInformationEmergency() {
        return this.requestInformationEmergency;
    }

    private fr.cg95.cvq.business.request.social.RsrRequestInformationRequestKindType requestInformationRequestKind;

    public final void setRequestInformationRequestKind(final fr.cg95.cvq.business.request.social.RsrRequestInformationRequestKindType requestInformationRequestKind) {
        this.requestInformationRequestKind = requestInformationRequestKind;
    }


    /**
     * @hibernate.property
     *  column="request_information_request_kind"
     */
    public final fr.cg95.cvq.business.request.social.RsrRequestInformationRequestKindType getRequestInformationRequestKind() {
        return this.requestInformationRequestKind;
    }

    private Boolean subjectIsDisabledPerson;

    public final void setSubjectIsDisabledPerson(final Boolean subjectIsDisabledPerson) {
        this.subjectIsDisabledPerson = subjectIsDisabledPerson;
    }


    /**
     * @hibernate.property
     *  column="subject_is_disabled_person"
     */
    public final Boolean getSubjectIsDisabledPerson() {
        return this.subjectIsDisabledPerson;
    }

    private String secondContactLastName;

    public final void setSecondContactLastName(final String secondContactLastName) {
        this.secondContactLastName = secondContactLastName;
    }


    /**
     * @hibernate.property
     *  column="second_contact_last_name"
     *  length="38"
     */
    public final String getSecondContactLastName() {
        return this.secondContactLastName;
    }

    private String requestInformationEmergencyMotive;

    public final void setRequestInformationEmergencyMotive(final String requestInformationEmergencyMotive) {
        this.requestInformationEmergencyMotive = requestInformationEmergencyMotive;
    }


    /**
     * @hibernate.property
     *  column="request_information_emergency_motive"
     *  length="180"
     */
    public final String getRequestInformationEmergencyMotive() {
        return this.requestInformationEmergencyMotive;
    }

    private String contactLastName;

    public final void setContactLastName(final String contactLastName) {
        this.contactLastName = contactLastName;
    }


    /**
     * @hibernate.property
     *  column="contact_last_name"
     *  length="38"
     */
    public final String getContactLastName() {
        return this.contactLastName;
    }

    private fr.cg95.cvq.business.users.TitleType spouseTitle;

    public final void setSpouseTitle(final fr.cg95.cvq.business.users.TitleType spouseTitle) {
        this.spouseTitle = spouseTitle;
    }


    /**
     * @hibernate.property
     *  column="spouse_title"
     */
    public final fr.cg95.cvq.business.users.TitleType getSpouseTitle() {
        return this.spouseTitle;
    }

    private fr.cg95.cvq.business.users.TitleType subjectTitle;

    public final void setSubjectTitle(final fr.cg95.cvq.business.users.TitleType subjectTitle) {
        this.subjectTitle = subjectTitle;
    }


    /**
     * @hibernate.property
     *  column="subject_title"
     */
    public final fr.cg95.cvq.business.users.TitleType getSubjectTitle() {
        return this.subjectTitle;
    }

    private String spouseFirstName;

    public final void setSpouseFirstName(final String spouseFirstName) {
        this.spouseFirstName = spouseFirstName;
    }


    /**
     * @hibernate.property
     *  column="spouse_first_name"
     *  length="38"
     */
    public final String getSpouseFirstName() {
        return this.spouseFirstName;
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

    private fr.cg95.cvq.business.request.social.RsrContactKindType contactKind;

    public final void setContactKind(final fr.cg95.cvq.business.request.social.RsrContactKindType contactKind) {
        this.contactKind = contactKind;
    }


    /**
     * @hibernate.property
     *  column="contact_kind"
     */
    public final fr.cg95.cvq.business.request.social.RsrContactKindType getContactKind() {
        return this.contactKind;
    }

    private String secondContactFirstName;

    public final void setSecondContactFirstName(final String secondContactFirstName) {
        this.secondContactFirstName = secondContactFirstName;
    }


    /**
     * @hibernate.property
     *  column="second_contact_first_name"
     *  length="38"
     */
    public final String getSecondContactFirstName() {
        return this.secondContactFirstName;
    }

    private Boolean subjectIsTaxable;

    public final void setSubjectIsTaxable(final Boolean subjectIsTaxable) {
        this.subjectIsTaxable = subjectIsTaxable;
    }


    /**
     * @hibernate.property
     *  column="subject_is_taxable"
     */
    public final Boolean getSubjectIsTaxable() {
        return this.subjectIsTaxable;
    }

    private String trusteeLastName;

    public final void setTrusteeLastName(final String trusteeLastName) {
        this.trusteeLastName = trusteeLastName;
    }


    /**
     * @hibernate.property
     *  column="trustee_last_name"
     *  length="38"
     */
    public final String getTrusteeLastName() {
        return this.trusteeLastName;
    }

    private String secondContactPhone;

    public final void setSecondContactPhone(final String secondContactPhone) {
        this.secondContactPhone = secondContactPhone;
    }


    /**
     * @hibernate.property
     *  column="second_contact_phone"
     *  length="10"
     */
    public final String getSecondContactPhone() {
        return this.secondContactPhone;
    }

}
