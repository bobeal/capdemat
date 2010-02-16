
package fr.cg95.cvq.business.request.social;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.class
 *  table="remote_support_request"
 *  lazy="false"
 */
public class RemoteSupportRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    public RemoteSupportRequestData() {
      
        spouseIsDisabledPerson = Boolean.valueOf(false);
      
        subjectIsAPABeneficiary = Boolean.valueOf(false);
      
        subjectResideWith = fr.cg95.cvq.business.request.social.RsrSubjectResideWithType.ALONE;
      
        requestInformationEmergency = Boolean.valueOf(false);
      
        requestInformationRequestKind = fr.cg95.cvq.business.request.social.RsrRequestInformationRequestKindType.INDIVIDUAL;
      
        subjectIsDisabledPerson = Boolean.valueOf(false);
      
        contactKind = fr.cg95.cvq.business.request.social.RsrContactKindType.REQUESTER;
      
        subjectIsTaxable = Boolean.valueOf(false);
      
    }

    public final void setId(final Long id) {
        this.id = id;
    }

    /**
     * @hibernate.id
     *  column="id"
     *  generator-class="sequence"
     */
    public final Long getId() {
        return this.id;
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
