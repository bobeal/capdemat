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
        rsrSpouseIsDisabledPerson = Boolean.valueOf(false);
        rsrIsEmergency = Boolean.valueOf(false);
        rsrRequesterIsAPABeneficiary = Boolean.valueOf(false);
        rsrRequesterIsTaxable = Boolean.valueOf(false);
        rsrRequesterIsDisabledPerson = Boolean.valueOf(false);
        rsrRequestKind = fr.cg95.cvq.business.request.social.RsrRequestKindType.INDIVIDUAL;
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
        RsrRequesterType rsrRequesterTypeRsrRequester = remoteSupportRequest.addNewRsrRequester();
        date = this.rsrRequesterBirthDate;
        if (date != null) {
            calendar.setTime(date);
            rsrRequesterTypeRsrRequester.setRsrRequesterBirthDate(calendar);
        }
        RsrSpouseType rsrSpouseTypeRsrSpouse = remoteSupportRequest.addNewRsrSpouse();
        if (this.rsrSpouseIsDisabledPerson != null)
            rsrSpouseTypeRsrSpouse.setRsrSpouseIsDisabledPerson(this.rsrSpouseIsDisabledPerson.booleanValue());
        RsrContactType rsrContactTypeRsrFirstContact = remoteSupportRequest.addNewRsrFirstContact();
        rsrContactTypeRsrFirstContact.setRsrContactPhone(this.rsrContactPhone);
        rsrSpouseTypeRsrSpouse.setRsrSpouseName(this.rsrSpouseName);
        RsrSecondContactType rsrSecondContactTypeRsrSecondContact = remoteSupportRequest.addNewRsrSecondContact();
        rsrSecondContactTypeRsrSecondContact.setRsrSecondContactFirstName(this.rsrSecondContactFirstName);
        rsrContactTypeRsrFirstContact.setRsrContactName(this.rsrContactName);
        if (this.rsrRequesterAddress != null)
            rsrRequesterTypeRsrRequester.setRsrRequesterAddress(Address.modelToXml(this.rsrRequesterAddress));
        RsrEmergencyType rsrEmergencyTypeRsrEmergency = remoteSupportRequest.addNewRsrEmergency();
        if (this.rsrIsEmergency != null)
            rsrEmergencyTypeRsrEmergency.setRsrIsEmergency(this.rsrIsEmergency.booleanValue());
        RsrTrusteeType rsrTrusteeTypeRsrTrustee = remoteSupportRequest.addNewRsrTrustee();
        rsrTrusteeTypeRsrTrustee.setRsrTrusteeName(this.rsrTrusteeName);
        if (this.rsrContactKind != null)
            remoteSupportRequest.setRsrContactKind(fr.cg95.cvq.xml.request.social.RsrContactKindType.Enum.forString(this.rsrContactKind.toString()));
        rsrRequesterTypeRsrRequester.setRsrSecondRequesterFirstName(this.rsrSecondRequesterFirstName);
        rsrTrusteeTypeRsrTrustee.setRsrTrusteePhone(this.rsrTrusteePhone);
        if (this.rsrRequesterFloor != null)
            rsrRequesterTypeRsrRequester.setRsrRequesterFloor(new BigInteger(this.rsrRequesterFloor.toString()));
        if (this.rsrRequesterFlatNumber != null)
            rsrRequesterTypeRsrRequester.setRsrRequesterFlatNumber(new BigInteger(this.rsrRequesterFlatNumber.toString()));
        rsrSecondContactTypeRsrSecondContact.setRsrSecondContactName(this.rsrSecondContactName);
        rsrSpouseTypeRsrSpouse.setRsrSecondSpouseFirstName(this.rsrSecondSpouseFirstName);
        rsrRequesterTypeRsrRequester.setRsrRequesterFirstName(this.rsrRequesterFirstName);
        if (this.rsrSpouseGender != null)
            rsrSpouseTypeRsrSpouse.setRsrSpouseGender(fr.cg95.cvq.xml.common.SexType.Enum.forString(this.rsrSpouseGender.toString()));
        if (this.rsrRequesterIsAPABeneficiary != null)
            rsrRequesterTypeRsrRequester.setRsrRequesterIsAPABeneficiary(this.rsrRequesterIsAPABeneficiary.booleanValue());
        rsrContactTypeRsrFirstContact.setRsrContactFirstName(this.rsrContactFirstName);
        if (this.rsrRequesterIsTaxable != null)
            rsrRequesterTypeRsrRequester.setRsrRequesterIsTaxable(this.rsrRequesterIsTaxable.booleanValue());
        if (this.rsrRequesterMaritalStatus != null)
            rsrRequesterTypeRsrRequester.setRsrRequesterMaritalStatus(fr.cg95.cvq.xml.request.social.RsrMaritalStatusType.Enum.forString(this.rsrRequesterMaritalStatus.toString()));
        rsrRequesterTypeRsrRequester.setRsrRequesterName(this.rsrRequesterName);
        rsrRequesterTypeRsrRequester.setRsrRequesterPersonalPhone(this.rsrRequesterPersonalPhone);
        rsrTrusteeTypeRsrTrustee.setRsrTrusteeFirstName(this.rsrTrusteeFirstName);
        rsrSecondContactTypeRsrSecondContact.setRsrSecondContactPhone(this.rsrSecondContactPhone);
        rsrEmergencyTypeRsrEmergency.setRsrEmergencyMotive(this.rsrEmergencyMotive);
        if (this.rsrRequesterIsDisabledPerson != null)
            rsrRequesterTypeRsrRequester.setRsrRequesterIsDisabledPerson(this.rsrRequesterIsDisabledPerson.booleanValue());
        rsrSpouseTypeRsrSpouse.setRsrSpouseFirstName(this.rsrSpouseFirstName);
        date = this.rsrSpouseBirthDate;
        if (date != null) {
            calendar.setTime(date);
            rsrSpouseTypeRsrSpouse.setRsrSpouseBirthDate(calendar);
        }
        if (this.rsrRequestKind != null)
            remoteSupportRequest.setRsrRequestKind(fr.cg95.cvq.xml.request.social.RsrRequestKindType.Enum.forString(this.rsrRequestKind.toString()));
        if (this.rsrRequesterResidenceKind != null)
            rsrRequesterTypeRsrRequester.setRsrRequesterResidenceKind(fr.cg95.cvq.xml.request.social.RsrResidenceKindType.Enum.forString(this.rsrRequesterResidenceKind.toString()));
        if (this.rsrRequesterGender != null)
            rsrRequesterTypeRsrRequester.setRsrRequesterGender(fr.cg95.cvq.xml.common.SexType.Enum.forString(this.rsrRequesterGender.toString()));
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
        calendar = remoteSupportRequestXml.getRsrRequester().getRsrRequesterBirthDate();
        if (calendar != null) {
            remoteSupportRequest.setRsrRequesterBirthDate(calendar.getTime());
        }
        remoteSupportRequest.setRsrSpouseIsDisabledPerson(Boolean.valueOf(remoteSupportRequestXml.getRsrSpouse().getRsrSpouseIsDisabledPerson()));
        remoteSupportRequest.setRsrContactPhone(remoteSupportRequestXml.getRsrFirstContact().getRsrContactPhone());
        remoteSupportRequest.setRsrSpouseName(remoteSupportRequestXml.getRsrSpouse().getRsrSpouseName());
        remoteSupportRequest.setRsrSecondContactFirstName(remoteSupportRequestXml.getRsrSecondContact().getRsrSecondContactFirstName());
        remoteSupportRequest.setRsrContactName(remoteSupportRequestXml.getRsrFirstContact().getRsrContactName());
        if (remoteSupportRequestXml.getRsrRequester().getRsrRequesterAddress() != null)
            remoteSupportRequest.setRsrRequesterAddress(Address.xmlToModel(remoteSupportRequestXml.getRsrRequester().getRsrRequesterAddress()));
        remoteSupportRequest.setRsrIsEmergency(Boolean.valueOf(remoteSupportRequestXml.getRsrEmergency().getRsrIsEmergency()));
        remoteSupportRequest.setRsrTrusteeName(remoteSupportRequestXml.getRsrTrustee().getRsrTrusteeName());
        if (remoteSupportRequestXml.getRsrContactKind() != null)
            remoteSupportRequest.setRsrContactKind(fr.cg95.cvq.business.request.social.RsrContactKindType.forString(remoteSupportRequestXml.getRsrContactKind().toString()));
        else
            remoteSupportRequest.setRsrContactKind(fr.cg95.cvq.business.request.social.RsrContactKindType.getDefaultRsrContactKindType());
        remoteSupportRequest.setRsrSecondRequesterFirstName(remoteSupportRequestXml.getRsrRequester().getRsrSecondRequesterFirstName());
        remoteSupportRequest.setRsrTrusteePhone(remoteSupportRequestXml.getRsrTrustee().getRsrTrusteePhone());
        remoteSupportRequest.setRsrRequesterFloor(remoteSupportRequestXml.getRsrRequester().getRsrRequesterFloor());
        remoteSupportRequest.setRsrRequesterFlatNumber(remoteSupportRequestXml.getRsrRequester().getRsrRequesterFlatNumber());
        remoteSupportRequest.setRsrSecondContactName(remoteSupportRequestXml.getRsrSecondContact().getRsrSecondContactName());
        remoteSupportRequest.setRsrSecondSpouseFirstName(remoteSupportRequestXml.getRsrSpouse().getRsrSecondSpouseFirstName());
        remoteSupportRequest.setRsrRequesterFirstName(remoteSupportRequestXml.getRsrRequester().getRsrRequesterFirstName());
        if (remoteSupportRequestXml.getRsrSpouse().getRsrSpouseGender() != null)
            remoteSupportRequest.setRsrSpouseGender(fr.cg95.cvq.business.users.SexType.forString(remoteSupportRequestXml.getRsrSpouse().getRsrSpouseGender().toString()));
        else
            remoteSupportRequest.setRsrSpouseGender(fr.cg95.cvq.business.users.SexType.getDefaultSexType());
        remoteSupportRequest.setRsrRequesterIsAPABeneficiary(Boolean.valueOf(remoteSupportRequestXml.getRsrRequester().getRsrRequesterIsAPABeneficiary()));
        remoteSupportRequest.setRsrContactFirstName(remoteSupportRequestXml.getRsrFirstContact().getRsrContactFirstName());
        remoteSupportRequest.setRsrRequesterIsTaxable(Boolean.valueOf(remoteSupportRequestXml.getRsrRequester().getRsrRequesterIsTaxable()));
        if (remoteSupportRequestXml.getRsrRequester().getRsrRequesterMaritalStatus() != null)
            remoteSupportRequest.setRsrRequesterMaritalStatus(fr.cg95.cvq.business.request.social.RsrMaritalStatusType.forString(remoteSupportRequestXml.getRsrRequester().getRsrRequesterMaritalStatus().toString()));
        else
            remoteSupportRequest.setRsrRequesterMaritalStatus(fr.cg95.cvq.business.request.social.RsrMaritalStatusType.getDefaultRsrMaritalStatusType());
        remoteSupportRequest.setRsrRequesterName(remoteSupportRequestXml.getRsrRequester().getRsrRequesterName());
        remoteSupportRequest.setRsrRequesterPersonalPhone(remoteSupportRequestXml.getRsrRequester().getRsrRequesterPersonalPhone());
        remoteSupportRequest.setRsrTrusteeFirstName(remoteSupportRequestXml.getRsrTrustee().getRsrTrusteeFirstName());
        remoteSupportRequest.setRsrSecondContactPhone(remoteSupportRequestXml.getRsrSecondContact().getRsrSecondContactPhone());
        remoteSupportRequest.setRsrEmergencyMotive(remoteSupportRequestXml.getRsrEmergency().getRsrEmergencyMotive());
        remoteSupportRequest.setRsrRequesterIsDisabledPerson(Boolean.valueOf(remoteSupportRequestXml.getRsrRequester().getRsrRequesterIsDisabledPerson()));
        remoteSupportRequest.setRsrSpouseFirstName(remoteSupportRequestXml.getRsrSpouse().getRsrSpouseFirstName());
        calendar = remoteSupportRequestXml.getRsrSpouse().getRsrSpouseBirthDate();
        if (calendar != null) {
            remoteSupportRequest.setRsrSpouseBirthDate(calendar.getTime());
        }
        if (remoteSupportRequestXml.getRsrRequestKind() != null)
            remoteSupportRequest.setRsrRequestKind(fr.cg95.cvq.business.request.social.RsrRequestKindType.forString(remoteSupportRequestXml.getRsrRequestKind().toString()));
        else
            remoteSupportRequest.setRsrRequestKind(fr.cg95.cvq.business.request.social.RsrRequestKindType.getDefaultRsrRequestKindType());
        if (remoteSupportRequestXml.getRsrRequester().getRsrRequesterResidenceKind() != null)
            remoteSupportRequest.setRsrRequesterResidenceKind(fr.cg95.cvq.business.request.social.RsrResidenceKindType.forString(remoteSupportRequestXml.getRsrRequester().getRsrRequesterResidenceKind().toString()));
        else
            remoteSupportRequest.setRsrRequesterResidenceKind(fr.cg95.cvq.business.request.social.RsrResidenceKindType.getDefaultRsrResidenceKindType());
        if (remoteSupportRequestXml.getRsrRequester().getRsrRequesterGender() != null)
            remoteSupportRequest.setRsrRequesterGender(fr.cg95.cvq.business.users.SexType.forString(remoteSupportRequestXml.getRsrRequester().getRsrRequesterGender().toString()));
        else
            remoteSupportRequest.setRsrRequesterGender(fr.cg95.cvq.business.users.SexType.getDefaultSexType());
        return remoteSupportRequest;
    }

    private java.util.Date rsrRequesterBirthDate;

    public final void setRsrRequesterBirthDate(final java.util.Date rsrRequesterBirthDate) {
        this.rsrRequesterBirthDate = rsrRequesterBirthDate;
    }


    /**
     * @hibernate.property
     *  column="rsr_requester_birth_date"
     */
    public final java.util.Date getRsrRequesterBirthDate() {
        return this.rsrRequesterBirthDate;
    }

    private Boolean rsrSpouseIsDisabledPerson;

    public final void setRsrSpouseIsDisabledPerson(final Boolean rsrSpouseIsDisabledPerson) {
        this.rsrSpouseIsDisabledPerson = rsrSpouseIsDisabledPerson;
    }


    /**
     * @hibernate.property
     *  column="rsr_spouse_is_disabled_person"
     */
    public final Boolean getRsrSpouseIsDisabledPerson() {
        return this.rsrSpouseIsDisabledPerson;
    }

    private String rsrContactPhone;

    public final void setRsrContactPhone(final String rsrContactPhone) {
        this.rsrContactPhone = rsrContactPhone;
    }


    /**
     * @hibernate.property
     *  column="rsr_contact_phone"
     *  length="10"
     */
    public final String getRsrContactPhone() {
        return this.rsrContactPhone;
    }

    private String rsrSpouseName;

    public final void setRsrSpouseName(final String rsrSpouseName) {
        this.rsrSpouseName = rsrSpouseName;
    }


    /**
     * @hibernate.property
     *  column="rsr_spouse_name"
     *  length="38"
     */
    public final String getRsrSpouseName() {
        return this.rsrSpouseName;
    }

    private String rsrSecondContactFirstName;

    public final void setRsrSecondContactFirstName(final String rsrSecondContactFirstName) {
        this.rsrSecondContactFirstName = rsrSecondContactFirstName;
    }


    /**
     * @hibernate.property
     *  column="rsr_second_contact_first_name"
     *  length="38"
     */
    public final String getRsrSecondContactFirstName() {
        return this.rsrSecondContactFirstName;
    }

    private String rsrContactName;

    public final void setRsrContactName(final String rsrContactName) {
        this.rsrContactName = rsrContactName;
    }


    /**
     * @hibernate.property
     *  column="rsr_contact_name"
     *  length="38"
     */
    public final String getRsrContactName() {
        return this.rsrContactName;
    }

    private fr.cg95.cvq.business.users.Address rsrRequesterAddress;

    public final void setRsrRequesterAddress(final fr.cg95.cvq.business.users.Address rsrRequesterAddress) {
        this.rsrRequesterAddress = rsrRequesterAddress;
    }


    /**
     * @hibernate.many-to-one
     *  column="rsr_requester_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getRsrRequesterAddress() {
        return this.rsrRequesterAddress;
    }

    private Boolean rsrIsEmergency;

    public final void setRsrIsEmergency(final Boolean rsrIsEmergency) {
        this.rsrIsEmergency = rsrIsEmergency;
    }


    /**
     * @hibernate.property
     *  column="rsr_is_emergency"
     */
    public final Boolean getRsrIsEmergency() {
        return this.rsrIsEmergency;
    }

    private String rsrTrusteeName;

    public final void setRsrTrusteeName(final String rsrTrusteeName) {
        this.rsrTrusteeName = rsrTrusteeName;
    }


    /**
     * @hibernate.property
     *  column="rsr_trustee_name"
     *  length="38"
     */
    public final String getRsrTrusteeName() {
        return this.rsrTrusteeName;
    }

    private fr.cg95.cvq.business.request.social.RsrContactKindType rsrContactKind;

    public final void setRsrContactKind(final fr.cg95.cvq.business.request.social.RsrContactKindType rsrContactKind) {
        this.rsrContactKind = rsrContactKind;
    }


    /**
     * @hibernate.property
     *  column="rsr_contact_kind"
     */
    public final fr.cg95.cvq.business.request.social.RsrContactKindType getRsrContactKind() {
        return this.rsrContactKind;
    }

    private String rsrSecondRequesterFirstName;

    public final void setRsrSecondRequesterFirstName(final String rsrSecondRequesterFirstName) {
        this.rsrSecondRequesterFirstName = rsrSecondRequesterFirstName;
    }


    /**
     * @hibernate.property
     *  column="rsr_second_requester_first_name"
     *  length="38"
     */
    public final String getRsrSecondRequesterFirstName() {
        return this.rsrSecondRequesterFirstName;
    }

    private String rsrTrusteePhone;

    public final void setRsrTrusteePhone(final String rsrTrusteePhone) {
        this.rsrTrusteePhone = rsrTrusteePhone;
    }


    /**
     * @hibernate.property
     *  column="rsr_trustee_phone"
     *  length="10"
     */
    public final String getRsrTrusteePhone() {
        return this.rsrTrusteePhone;
    }

    private java.math.BigInteger rsrRequesterFloor;

    public final void setRsrRequesterFloor(final java.math.BigInteger rsrRequesterFloor) {
        this.rsrRequesterFloor = rsrRequesterFloor;
    }


    /**
     * @hibernate.property
     *  column="rsr_requester_floor"
     *  type="serializable"
     */
    public final java.math.BigInteger getRsrRequesterFloor() {
        return this.rsrRequesterFloor;
    }

    private java.math.BigInteger rsrRequesterFlatNumber;

    public final void setRsrRequesterFlatNumber(final java.math.BigInteger rsrRequesterFlatNumber) {
        this.rsrRequesterFlatNumber = rsrRequesterFlatNumber;
    }


    /**
     * @hibernate.property
     *  column="rsr_requester_flat_number"
     *  type="serializable"
     */
    public final java.math.BigInteger getRsrRequesterFlatNumber() {
        return this.rsrRequesterFlatNumber;
    }

    private String rsrSecondContactName;

    public final void setRsrSecondContactName(final String rsrSecondContactName) {
        this.rsrSecondContactName = rsrSecondContactName;
    }


    /**
     * @hibernate.property
     *  column="rsr_second_contact_name"
     *  length="38"
     */
    public final String getRsrSecondContactName() {
        return this.rsrSecondContactName;
    }

    private String rsrSecondSpouseFirstName;

    public final void setRsrSecondSpouseFirstName(final String rsrSecondSpouseFirstName) {
        this.rsrSecondSpouseFirstName = rsrSecondSpouseFirstName;
    }


    /**
     * @hibernate.property
     *  column="rsr_second_spouse_first_name"
     *  length="38"
     */
    public final String getRsrSecondSpouseFirstName() {
        return this.rsrSecondSpouseFirstName;
    }

    private String rsrRequesterFirstName;

    public final void setRsrRequesterFirstName(final String rsrRequesterFirstName) {
        this.rsrRequesterFirstName = rsrRequesterFirstName;
    }


    /**
     * @hibernate.property
     *  column="rsr_requester_first_name"
     *  length="38"
     */
    public final String getRsrRequesterFirstName() {
        return this.rsrRequesterFirstName;
    }

    private fr.cg95.cvq.business.users.SexType rsrSpouseGender;

    public final void setRsrSpouseGender(final fr.cg95.cvq.business.users.SexType rsrSpouseGender) {
        this.rsrSpouseGender = rsrSpouseGender;
    }


    /**
     * @hibernate.property
     *  column="rsr_spouse_gender"
     */
    public final fr.cg95.cvq.business.users.SexType getRsrSpouseGender() {
        return this.rsrSpouseGender;
    }

    private Boolean rsrRequesterIsAPABeneficiary;

    public final void setRsrRequesterIsAPABeneficiary(final Boolean rsrRequesterIsAPABeneficiary) {
        this.rsrRequesterIsAPABeneficiary = rsrRequesterIsAPABeneficiary;
    }


    /**
     * @hibernate.property
     *  column="rsr_requester_is_a_p_a_beneficiary"
     */
    public final Boolean getRsrRequesterIsAPABeneficiary() {
        return this.rsrRequesterIsAPABeneficiary;
    }

    private String rsrContactFirstName;

    public final void setRsrContactFirstName(final String rsrContactFirstName) {
        this.rsrContactFirstName = rsrContactFirstName;
    }


    /**
     * @hibernate.property
     *  column="rsr_contact_first_name"
     *  length="38"
     */
    public final String getRsrContactFirstName() {
        return this.rsrContactFirstName;
    }

    private Boolean rsrRequesterIsTaxable;

    public final void setRsrRequesterIsTaxable(final Boolean rsrRequesterIsTaxable) {
        this.rsrRequesterIsTaxable = rsrRequesterIsTaxable;
    }


    /**
     * @hibernate.property
     *  column="rsr_requester_is_taxable"
     */
    public final Boolean getRsrRequesterIsTaxable() {
        return this.rsrRequesterIsTaxable;
    }

    private fr.cg95.cvq.business.request.social.RsrMaritalStatusType rsrRequesterMaritalStatus;

    public final void setRsrRequesterMaritalStatus(final fr.cg95.cvq.business.request.social.RsrMaritalStatusType rsrRequesterMaritalStatus) {
        this.rsrRequesterMaritalStatus = rsrRequesterMaritalStatus;
    }


    /**
     * @hibernate.property
     *  column="rsr_requester_marital_status"
     */
    public final fr.cg95.cvq.business.request.social.RsrMaritalStatusType getRsrRequesterMaritalStatus() {
        return this.rsrRequesterMaritalStatus;
    }

    private String rsrRequesterName;

    public final void setRsrRequesterName(final String rsrRequesterName) {
        this.rsrRequesterName = rsrRequesterName;
    }


    /**
     * @hibernate.property
     *  column="rsr_requester_name"
     *  length="38"
     */
    public final String getRsrRequesterName() {
        return this.rsrRequesterName;
    }

    private String rsrRequesterPersonalPhone;

    public final void setRsrRequesterPersonalPhone(final String rsrRequesterPersonalPhone) {
        this.rsrRequesterPersonalPhone = rsrRequesterPersonalPhone;
    }


    /**
     * @hibernate.property
     *  column="rsr_requester_personal_phone"
     *  length="10"
     */
    public final String getRsrRequesterPersonalPhone() {
        return this.rsrRequesterPersonalPhone;
    }

    private String rsrTrusteeFirstName;

    public final void setRsrTrusteeFirstName(final String rsrTrusteeFirstName) {
        this.rsrTrusteeFirstName = rsrTrusteeFirstName;
    }


    /**
     * @hibernate.property
     *  column="rsr_trustee_first_name"
     *  length="38"
     */
    public final String getRsrTrusteeFirstName() {
        return this.rsrTrusteeFirstName;
    }

    private String rsrSecondContactPhone;

    public final void setRsrSecondContactPhone(final String rsrSecondContactPhone) {
        this.rsrSecondContactPhone = rsrSecondContactPhone;
    }


    /**
     * @hibernate.property
     *  column="rsr_second_contact_phone"
     *  length="10"
     */
    public final String getRsrSecondContactPhone() {
        return this.rsrSecondContactPhone;
    }

    private String rsrEmergencyMotive;

    public final void setRsrEmergencyMotive(final String rsrEmergencyMotive) {
        this.rsrEmergencyMotive = rsrEmergencyMotive;
    }


    /**
     * @hibernate.property
     *  column="rsr_emergency_motive"
     */
    public final String getRsrEmergencyMotive() {
        return this.rsrEmergencyMotive;
    }

    private Boolean rsrRequesterIsDisabledPerson;

    public final void setRsrRequesterIsDisabledPerson(final Boolean rsrRequesterIsDisabledPerson) {
        this.rsrRequesterIsDisabledPerson = rsrRequesterIsDisabledPerson;
    }


    /**
     * @hibernate.property
     *  column="rsr_requester_is_disabled_person"
     */
    public final Boolean getRsrRequesterIsDisabledPerson() {
        return this.rsrRequesterIsDisabledPerson;
    }

    private String rsrSpouseFirstName;

    public final void setRsrSpouseFirstName(final String rsrSpouseFirstName) {
        this.rsrSpouseFirstName = rsrSpouseFirstName;
    }


    /**
     * @hibernate.property
     *  column="rsr_spouse_first_name"
     *  length="38"
     */
    public final String getRsrSpouseFirstName() {
        return this.rsrSpouseFirstName;
    }

    private java.util.Date rsrSpouseBirthDate;

    public final void setRsrSpouseBirthDate(final java.util.Date rsrSpouseBirthDate) {
        this.rsrSpouseBirthDate = rsrSpouseBirthDate;
    }


    /**
     * @hibernate.property
     *  column="rsr_spouse_birth_date"
     */
    public final java.util.Date getRsrSpouseBirthDate() {
        return this.rsrSpouseBirthDate;
    }

    private fr.cg95.cvq.business.request.social.RsrRequestKindType rsrRequestKind;

    public final void setRsrRequestKind(final fr.cg95.cvq.business.request.social.RsrRequestKindType rsrRequestKind) {
        this.rsrRequestKind = rsrRequestKind;
    }


    /**
     * @hibernate.property
     *  column="rsr_request_kind"
     */
    public final fr.cg95.cvq.business.request.social.RsrRequestKindType getRsrRequestKind() {
        return this.rsrRequestKind;
    }

    private fr.cg95.cvq.business.request.social.RsrResidenceKindType rsrRequesterResidenceKind;

    public final void setRsrRequesterResidenceKind(final fr.cg95.cvq.business.request.social.RsrResidenceKindType rsrRequesterResidenceKind) {
        this.rsrRequesterResidenceKind = rsrRequesterResidenceKind;
    }


    /**
     * @hibernate.property
     *  column="rsr_requester_residence_kind"
     */
    public final fr.cg95.cvq.business.request.social.RsrResidenceKindType getRsrRequesterResidenceKind() {
        return this.rsrRequesterResidenceKind;
    }

    private fr.cg95.cvq.business.users.SexType rsrRequesterGender;

    public final void setRsrRequesterGender(final fr.cg95.cvq.business.users.SexType rsrRequesterGender) {
        this.rsrRequesterGender = rsrRequesterGender;
    }


    /**
     * @hibernate.property
     *  column="rsr_requester_gender"
     */
    public final fr.cg95.cvq.business.users.SexType getRsrRequesterGender() {
        return this.rsrRequesterGender;
    }

}
