

package fr.cg95.cvq.business.request.social;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.oval.constraint.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.service.request.LocalReferential;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

import javax.persistence.*;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Type;

/**
 * Generated class file, do not edit !
 */
@Entity
@Table(name="remote_support_request")
public class RemoteSupportRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public RemoteSupportRequestData() {
      
        contactKind = fr.cg95.cvq.business.request.social.RsrContactKindType.REQUESTER;
      
        requestInformationEmergency = Boolean.valueOf(false);
      
        requestInformationRequestKind = fr.cg95.cvq.business.request.social.RsrRequestInformationRequestKindType.INDIVIDUAL;
      
        spouseIsDisabledPerson = Boolean.valueOf(false);
      
        subjectIsAPABeneficiary = Boolean.valueOf(false);
      
        subjectIsDisabledPerson = Boolean.valueOf(false);
      
        subjectIsTaxable = Boolean.valueOf(false);
      
        subjectResideWith = fr.cg95.cvq.business.request.social.RsrSubjectResideWithType.ALONE;
      
    }

    @Override
    public RemoteSupportRequestData clone() {
        RemoteSupportRequestData result = new RemoteSupportRequestData();
        
          
            
        result.setContactFirstName(contactFirstName);
      
          
        
          
            
        if (contactKind != null)
            result.setContactKind(contactKind);
        else
            result.setContactKind(fr.cg95.cvq.business.request.social.RsrContactKindType.getDefaultRsrContactKindType());
      
          
        
          
            
        result.setContactLastName(contactLastName);
      
          
        
          
            
        result.setContactPhone(contactPhone);
      
          
        
          
            
        result.setRequestInformationEmergency(requestInformationEmergency);
      
          
        
          
            
        result.setRequestInformationEmergencyMotive(requestInformationEmergencyMotive);
      
          
        
          
            
        if (requestInformationRequestKind != null)
            result.setRequestInformationRequestKind(requestInformationRequestKind);
        else
            result.setRequestInformationRequestKind(fr.cg95.cvq.business.request.social.RsrRequestInformationRequestKindType.getDefaultRsrRequestInformationRequestKindType());
      
          
        
          
            
        result.setSecondContactFirstName(secondContactFirstName);
      
          
        
          
            
        result.setSecondContactLastName(secondContactLastName);
      
          
        
          
            
        result.setSecondContactPhone(secondContactPhone);
      
          
        
          
            
        result.setSpouseBirthDate(spouseBirthDate);
      
          
        
          
            
        result.setSpouseFirstName(spouseFirstName);
      
          
        
          
            
        result.setSpouseIsDisabledPerson(spouseIsDisabledPerson);
      
          
        
          
            
        result.setSpouseLastName(spouseLastName);
      
          
        
          
            
        if (spouseTitle != null)
            result.setSpouseTitle(spouseTitle);
        else
            result.setSpouseTitle(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
      
          
        
          
            
        result.setSubjectBirthDate(subjectBirthDate);
      
          
        
          
            
        result.setSubjectIsAPABeneficiary(subjectIsAPABeneficiary);
      
          
        
          
            
        result.setSubjectIsDisabledPerson(subjectIsDisabledPerson);
      
          
        
          
            
        result.setSubjectIsTaxable(subjectIsTaxable);
      
          
        
          
            
        if (subjectResideWith != null)
            result.setSubjectResideWith(subjectResideWith);
        else
            result.setSubjectResideWith(fr.cg95.cvq.business.request.social.RsrSubjectResideWithType.getDefaultRsrSubjectResideWithType());
      
          
        
          
            
        if (subjectTitle != null)
            result.setSubjectTitle(subjectTitle);
        else
            result.setSubjectTitle(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
      
          
        
          
            
        result.setTrusteeFirstName(trusteeFirstName);
      
          
        
          
            
        result.setTrusteeLastName(trusteeLastName);
      
          
        
          
            
        result.setTrusteePhone(trusteePhone);
      
          
        
        return result;
    }

    public final void setId(final Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    public final Long getId() {
        return this.id;
    }

  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['contactKind'].test(_this.contactKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"contact"},
        message = "contactFirstName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['contactKind'].test(_this.contactKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"contact"},
        message = "contactFirstName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['contactKind'].test(_this.contactKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"contact"},
        message = "contactFirstName"
      )
    
    private String contactFirstName;

    public void setContactFirstName(final String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

 
    @Column(name="contact_first_name" , length=38 )
      
    public String getContactFirstName() {
        return this.contactFirstName;
    }
  
    
      @NotNull(
        
        
        profiles = {"contact"},
        message = "contactKind"
      )
    
    private fr.cg95.cvq.business.request.social.RsrContactKindType contactKind;

    public void setContactKind(final fr.cg95.cvq.business.request.social.RsrContactKindType contactKind) {
        this.contactKind = contactKind;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="contact_kind"  )
      
    public fr.cg95.cvq.business.request.social.RsrContactKindType getContactKind() {
        return this.contactKind;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['contactKind'].test(_this.contactKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"contact"},
        message = "contactLastName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['contactKind'].test(_this.contactKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"contact"},
        message = "contactLastName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['contactKind'].test(_this.contactKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"contact"},
        message = "contactLastName"
      )
    
    private String contactLastName;

    public void setContactLastName(final String contactLastName) {
        this.contactLastName = contactLastName;
    }

 
    @Column(name="contact_last_name" , length=38 )
      
    public String getContactLastName() {
        return this.contactLastName;
    }
  
    
      @MaxLength(
        
          value = 10,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['contactKind'].test(_this.contactKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"contact"},
        message = "contactPhone"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['contactKind'].test(_this.contactKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"contact"},
        message = "contactPhone"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['contactKind'].test(_this.contactKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"contact"},
        message = "contactPhone"
      )
    
    private String contactPhone;

    public void setContactPhone(final String contactPhone) {
        this.contactPhone = contactPhone;
    }

 
    @Column(name="contact_phone" , length=10 )
      
    public String getContactPhone() {
        return this.contactPhone;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "requestInformationEmergency"
      )
    
    private Boolean requestInformationEmergency;

    public void setRequestInformationEmergency(final Boolean requestInformationEmergency) {
        this.requestInformationEmergency = requestInformationEmergency;
    }

 
    @Column(name="request_information_emergency"  )
      
    public Boolean getRequestInformationEmergency() {
        return this.requestInformationEmergency;
    }
  
    
      @MaxLength(
        
          value = 180,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requestInformationEmergency'].test(_this.requestInformationEmergency.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "requestInformationEmergencyMotive"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requestInformationEmergency'].test(_this.requestInformationEmergency.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "requestInformationEmergencyMotive"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requestInformationEmergency'].test(_this.requestInformationEmergency.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "requestInformationEmergencyMotive"
      )
    
    private String requestInformationEmergencyMotive;

    public void setRequestInformationEmergencyMotive(final String requestInformationEmergencyMotive) {
        this.requestInformationEmergencyMotive = requestInformationEmergencyMotive;
    }

 
    @Column(name="request_information_emergency_motive" , length=180 )
      
    public String getRequestInformationEmergencyMotive() {
        return this.requestInformationEmergencyMotive;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "requestInformationRequestKind"
      )
    
    private fr.cg95.cvq.business.request.social.RsrRequestInformationRequestKindType requestInformationRequestKind;

    public void setRequestInformationRequestKind(final fr.cg95.cvq.business.request.social.RsrRequestInformationRequestKindType requestInformationRequestKind) {
        this.requestInformationRequestKind = requestInformationRequestKind;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="request_information_request_kind"  )
      
    public fr.cg95.cvq.business.request.social.RsrRequestInformationRequestKindType getRequestInformationRequestKind() {
        return this.requestInformationRequestKind;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['contactKind'].test(_this.contactKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"contact"},
        message = "secondContactFirstName"
      )
    
    private String secondContactFirstName;

    public void setSecondContactFirstName(final String secondContactFirstName) {
        this.secondContactFirstName = secondContactFirstName;
    }

 
    @Column(name="second_contact_first_name" , length=38 )
      
    public String getSecondContactFirstName() {
        return this.secondContactFirstName;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['contactKind'].test(_this.contactKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"contact"},
        message = "secondContactLastName"
      )
    
    private String secondContactLastName;

    public void setSecondContactLastName(final String secondContactLastName) {
        this.secondContactLastName = secondContactLastName;
    }

 
    @Column(name="second_contact_last_name" , length=38 )
      
    public String getSecondContactLastName() {
        return this.secondContactLastName;
    }
  
    
      @MaxLength(
        
          value = 10,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['contactKind'].test(_this.contactKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"contact"},
        message = "secondContactPhone"
      )
    
    private String secondContactPhone;

    public void setSecondContactPhone(final String secondContactPhone) {
        this.secondContactPhone = secondContactPhone;
    }

 
    @Column(name="second_contact_phone" , length=10 )
      
    public String getSecondContactPhone() {
        return this.secondContactPhone;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['requestInformationRequestKind'].test(_this.requestInformationRequestKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"subject"},
        message = "spouseBirthDate"
      )
    
    private java.util.Date spouseBirthDate;

    public void setSpouseBirthDate(final java.util.Date spouseBirthDate) {
        this.spouseBirthDate = spouseBirthDate;
    }

 
    @Column(name="spouse_birth_date"  )
      
    public java.util.Date getSpouseBirthDate() {
        return this.spouseBirthDate;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['requestInformationRequestKind'].test(_this.requestInformationRequestKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"subject"},
        message = "spouseFirstName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['requestInformationRequestKind'].test(_this.requestInformationRequestKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"subject"},
        message = "spouseFirstName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['requestInformationRequestKind'].test(_this.requestInformationRequestKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"subject"},
        message = "spouseFirstName"
      )
    
    private String spouseFirstName;

    public void setSpouseFirstName(final String spouseFirstName) {
        this.spouseFirstName = spouseFirstName;
    }

 
    @Column(name="spouse_first_name" , length=38 )
      
    public String getSpouseFirstName() {
        return this.spouseFirstName;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['requestInformationRequestKind'].test(_this.requestInformationRequestKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"subject"},
        message = "spouseIsDisabledPerson"
      )
    
    private Boolean spouseIsDisabledPerson;

    public void setSpouseIsDisabledPerson(final Boolean spouseIsDisabledPerson) {
        this.spouseIsDisabledPerson = spouseIsDisabledPerson;
    }

 
    @Column(name="spouse_is_disabled_person"  )
      
    public Boolean getSpouseIsDisabledPerson() {
        return this.spouseIsDisabledPerson;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['requestInformationRequestKind'].test(_this.requestInformationRequestKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"subject"},
        message = "spouseLastName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['requestInformationRequestKind'].test(_this.requestInformationRequestKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"subject"},
        message = "spouseLastName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['requestInformationRequestKind'].test(_this.requestInformationRequestKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"subject"},
        message = "spouseLastName"
      )
    
    private String spouseLastName;

    public void setSpouseLastName(final String spouseLastName) {
        this.spouseLastName = spouseLastName;
    }

 
    @Column(name="spouse_last_name" , length=38 )
      
    public String getSpouseLastName() {
        return this.spouseLastName;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['requestInformationRequestKind'].test(_this.requestInformationRequestKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"subject"},
        message = "spouseTitle"
      )
    
    private fr.cg95.cvq.business.users.TitleType spouseTitle;

    public void setSpouseTitle(final fr.cg95.cvq.business.users.TitleType spouseTitle) {
        this.spouseTitle = spouseTitle;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="spouse_title"  )
      
    public fr.cg95.cvq.business.users.TitleType getSpouseTitle() {
        return this.spouseTitle;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "subjectBirthDate"
      )
    
    private java.util.Date subjectBirthDate;

    public void setSubjectBirthDate(final java.util.Date subjectBirthDate) {
        this.subjectBirthDate = subjectBirthDate;
    }

 
    @Column(name="subject_birth_date"  )
      
    public java.util.Date getSubjectBirthDate() {
        return this.subjectBirthDate;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "subjectIsAPABeneficiary"
      )
    
    private Boolean subjectIsAPABeneficiary;

    public void setSubjectIsAPABeneficiary(final Boolean subjectIsAPABeneficiary) {
        this.subjectIsAPABeneficiary = subjectIsAPABeneficiary;
    }

 
    @Column(name="subject_is_a_p_a_beneficiary"  )
      
    public Boolean getSubjectIsAPABeneficiary() {
        return this.subjectIsAPABeneficiary;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "subjectIsDisabledPerson"
      )
    
    private Boolean subjectIsDisabledPerson;

    public void setSubjectIsDisabledPerson(final Boolean subjectIsDisabledPerson) {
        this.subjectIsDisabledPerson = subjectIsDisabledPerson;
    }

 
    @Column(name="subject_is_disabled_person"  )
      
    public Boolean getSubjectIsDisabledPerson() {
        return this.subjectIsDisabledPerson;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "subjectIsTaxable"
      )
    
    private Boolean subjectIsTaxable;

    public void setSubjectIsTaxable(final Boolean subjectIsTaxable) {
        this.subjectIsTaxable = subjectIsTaxable;
    }

 
    @Column(name="subject_is_taxable"  )
      
    public Boolean getSubjectIsTaxable() {
        return this.subjectIsTaxable;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "subjectResideWith"
      )
    
    private fr.cg95.cvq.business.request.social.RsrSubjectResideWithType subjectResideWith;

    public void setSubjectResideWith(final fr.cg95.cvq.business.request.social.RsrSubjectResideWithType subjectResideWith) {
        this.subjectResideWith = subjectResideWith;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="subject_reside_with"  )
      
    public fr.cg95.cvq.business.request.social.RsrSubjectResideWithType getSubjectResideWith() {
        return this.subjectResideWith;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "subjectTitle"
      )
    
    private fr.cg95.cvq.business.users.TitleType subjectTitle;

    public void setSubjectTitle(final fr.cg95.cvq.business.users.TitleType subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="subject_title"  )
      
    public fr.cg95.cvq.business.users.TitleType getSubjectTitle() {
        return this.subjectTitle;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"contact"},
        message = "trusteeFirstName"
      )
    
    private String trusteeFirstName;

    public void setTrusteeFirstName(final String trusteeFirstName) {
        this.trusteeFirstName = trusteeFirstName;
    }

 
    @Column(name="trustee_first_name" , length=38 )
      
    public String getTrusteeFirstName() {
        return this.trusteeFirstName;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"contact"},
        message = "trusteeLastName"
      )
    
    private String trusteeLastName;

    public void setTrusteeLastName(final String trusteeLastName) {
        this.trusteeLastName = trusteeLastName;
    }

 
    @Column(name="trustee_last_name" , length=38 )
      
    public String getTrusteeLastName() {
        return this.trusteeLastName;
    }
  
    
      @MaxLength(
        
          value = 10,
        
        
        profiles = {"contact"},
        message = "trusteePhone"
      )
    
    private String trusteePhone;

    public void setTrusteePhone(final String trusteePhone) {
        this.trusteePhone = trusteePhone;
    }

 
    @Column(name="trustee_phone" , length=10 )
      
    public String getTrusteePhone() {
        return this.trusteePhone;
    }
  
}
