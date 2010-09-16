
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

/**
 * Generated class file, do not edit !
 *
 * @hibernate.class
 *  table="b_a_f_a_grant_request"
 *  lazy="false"
 */
public class BAFAGrantRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public BAFAGrantRequestData() {
      
        isSubjectAccountHolder = Boolean.valueOf(true);
      
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

  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['isSubjectAccountHolder'].test(_this.isSubjectAccountHolder.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"bankReference"},
        message = "accountHolderFirstName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['isSubjectAccountHolder'].test(_this.isSubjectAccountHolder.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"bankReference"},
        message = "accountHolderFirstName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['isSubjectAccountHolder'].test(_this.isSubjectAccountHolder.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"bankReference"},
        message = "accountHolderFirstName"
      )
    
    private String accountHolderFirstName;

    public final void setAccountHolderFirstName(final String accountHolderFirstName) {
        this.accountHolderFirstName = accountHolderFirstName;
    }

    /**
 
        * @hibernate.property
        *  column="account_holder_first_name"
        *  length="38"
      
    */
    public final String getAccountHolderFirstName() {
        return this.accountHolderFirstName;
    }
  
    
      @NotNull(
        
        
        profiles = {"administration"},
        message = "accountHolderEdemandeId"
      )
    
      @NotBlank(
        
        
        profiles = {"administration"},
        message = "accountHolderEdemandeId"
      )
    
    private String accountHolderEdemandeId;

    public final void setAccountHolderEdemandeId(final String accountHolderEdemandeId) {
        this.accountHolderEdemandeId = accountHolderEdemandeId;
    }

    /**
 
        * @hibernate.property
        *  column="account_holder_edemande_id"
        
      
    */
    public final String getAccountHolderEdemandeId() {
        return this.accountHolderEdemandeId;
    }
  
    
      @NotNull(
        
        
        profiles = {"internship"},
        message = "internshipInstituteAddress"
      )
    
      @AssertValid(
        
        
        profiles = {"internship"},
        message = "internshipInstituteAddress"
      )
    
    private fr.cg95.cvq.business.users.Address internshipInstituteAddress;

    public final void setInternshipInstituteAddress(final fr.cg95.cvq.business.users.Address internshipInstituteAddress) {
        this.internshipInstituteAddress = internshipInstituteAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="internship_institute_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getInternshipInstituteAddress() {
        return this.internshipInstituteAddress;
    }
  
    
      @NotNull(
        
        
        profiles = {"administration"},
        message = "edemandeId"
      )
    
      @NotBlank(
        
        
        profiles = {"administration"},
        message = "edemandeId"
      )
    
    private String edemandeId;

    public final void setEdemandeId(final String edemandeId) {
        this.edemandeId = edemandeId;
    }

    /**
 
        * @hibernate.property
        *  column="edemande_id"
        
      
    */
    public final String getEdemandeId() {
        return this.edemandeId;
    }
  
    
      @NotNull(
        
        
        profiles = {"internship"},
        message = "internshipStartDate"
      )
    
    private java.util.Date internshipStartDate;

    public final void setInternshipStartDate(final java.util.Date internshipStartDate) {
        this.internshipStartDate = internshipStartDate;
    }

    /**
 
        * @hibernate.property
        *  column="internship_start_date"
        
      
    */
    public final java.util.Date getInternshipStartDate() {
        return this.internshipStartDate;
    }
  
    
      @NotNull(
        
        
        profiles = {"internship"},
        message = "internshipEndDate"
      )
    
    private java.util.Date internshipEndDate;

    public final void setInternshipEndDate(final java.util.Date internshipEndDate) {
        this.internshipEndDate = internshipEndDate;
    }

    /**
 
        * @hibernate.property
        *  column="internship_end_date"
        
      
    */
    public final java.util.Date getInternshipEndDate() {
        return this.internshipEndDate;
    }
  
    
      @NotNull(
        
        
        profiles = {"bankReference"},
        message = "isSubjectAccountHolder"
      )
    
    private Boolean isSubjectAccountHolder;

    public final void setIsSubjectAccountHolder(final Boolean isSubjectAccountHolder) {
        this.isSubjectAccountHolder = isSubjectAccountHolder;
    }

    /**
 
        * @hibernate.property
        *  column="is_subject_account_holder"
        
      
    */
    public final Boolean getIsSubjectAccountHolder() {
        return this.isSubjectAccountHolder;
    }
  
    
      @NotNull(
        
        
        profiles = {"bankReference"},
        message = "frenchRIB"
      )
    
      @AssertValid(
        
        
        profiles = {"bankReference"},
        message = "frenchRIB"
      )
    
    private fr.cg95.cvq.business.users.FrenchRIB frenchRIB;

    public final void setFrenchRIB(final fr.cg95.cvq.business.users.FrenchRIB frenchRIB) {
        this.frenchRIB = frenchRIB;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="french_r_i_b_id"
        *  class="fr.cg95.cvq.business.users.FrenchRIB"
      
    */
    public final fr.cg95.cvq.business.users.FrenchRIB getFrenchRIB() {
        return this.frenchRIB;
    }
  
    
      @MaxLength(
        
          value = 32,
        
        
        profiles = {"subject"},
        message = "subjectBirthCity"
      )
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "subjectBirthCity"
      )
    
      @NotBlank(
        
        
        profiles = {"subject"},
        message = "subjectBirthCity"
      )
    
    private String subjectBirthCity;

    public final void setSubjectBirthCity(final String subjectBirthCity) {
        this.subjectBirthCity = subjectBirthCity;
    }

    /**
 
        * @hibernate.property
        *  column="subject_birth_city"
        *  length="32"
      
    */
    public final String getSubjectBirthCity() {
        return this.subjectBirthCity;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['isSubjectAccountHolder'].test(_this.isSubjectAccountHolder.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"bankReference"},
        message = "accountHolderBirthDate"
      )
    
    private java.util.Date accountHolderBirthDate;

    public final void setAccountHolderBirthDate(final java.util.Date accountHolderBirthDate) {
        this.accountHolderBirthDate = accountHolderBirthDate;
    }

    /**
 
        * @hibernate.property
        *  column="account_holder_birth_date"
        
      
    */
    public final java.util.Date getAccountHolderBirthDate() {
        return this.accountHolderBirthDate;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "subjectBirthDate"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"internship"},
        message = "internshipInstituteName"
      )
    
      @NotBlank(
        
        
        profiles = {"internship"},
        message = "internshipInstituteName"
      )
    
    private String internshipInstituteName;

    public final void setInternshipInstituteName(final String internshipInstituteName) {
        this.internshipInstituteName = internshipInstituteName;
    }

    /**
 
        * @hibernate.property
        *  column="internship_institute_name"
        
      
    */
    public final String getInternshipInstituteName() {
        return this.internshipInstituteName;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "subjectAddress"
      )
    
      @AssertValid(
        
        
        profiles = {"subject"},
        message = "subjectAddress"
      )
    
    private fr.cg95.cvq.business.users.Address subjectAddress;

    public final void setSubjectAddress(final fr.cg95.cvq.business.users.Address subjectAddress) {
        this.subjectAddress = subjectAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="subject_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getSubjectAddress() {
        return this.subjectAddress;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['isSubjectAccountHolder'].test(_this.isSubjectAccountHolder.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"bankReference"},
        message = "accountHolderLastName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['isSubjectAccountHolder'].test(_this.isSubjectAccountHolder.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"bankReference"},
        message = "accountHolderLastName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['isSubjectAccountHolder'].test(_this.isSubjectAccountHolder.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"bankReference"},
        message = "accountHolderLastName"
      )
    
    private String accountHolderLastName;

    public final void setAccountHolderLastName(final String accountHolderLastName) {
        this.accountHolderLastName = accountHolderLastName;
    }

    /**
 
        * @hibernate.property
        *  column="account_holder_last_name"
        *  length="38"
      
    */
    public final String getAccountHolderLastName() {
        return this.accountHolderLastName;
    }
  
    
      @MaxLength(
        
          value = 10,
        
        
        profiles = {"subject"},
        message = "subjectPhone"
      )
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "subjectPhone"
      )
    
      @NotBlank(
        
        
        profiles = {"subject"},
        message = "subjectPhone"
      )
    
    private String subjectPhone;

    public final void setSubjectPhone(final String subjectPhone) {
        this.subjectPhone = subjectPhone;
    }

    /**
 
        * @hibernate.property
        *  column="subject_phone"
        *  length="10"
      
    */
    public final String getSubjectPhone() {
        return this.subjectPhone;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "subjectEmail"
      )
    
      @NotBlank(
        
        
        profiles = {"subject"},
        message = "subjectEmail"
      )
    
    private String subjectEmail;

    public final void setSubjectEmail(final String subjectEmail) {
        this.subjectEmail = subjectEmail;
    }

    /**
 
        * @hibernate.property
        *  column="subject_email"
        
      
    */
    public final String getSubjectEmail() {
        return this.subjectEmail;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['isSubjectAccountHolder'].test(_this.isSubjectAccountHolder.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"bankReference"},
        message = "accountHolderTitle"
      )
    
    private fr.cg95.cvq.business.users.TitleType accountHolderTitle;

    public final void setAccountHolderTitle(final fr.cg95.cvq.business.users.TitleType accountHolderTitle) {
        this.accountHolderTitle = accountHolderTitle;
    }

    /**
 
        * @hibernate.property
        *  column="account_holder_title"
        
      
    */
    public final fr.cg95.cvq.business.users.TitleType getAccountHolderTitle() {
        return this.accountHolderTitle;
    }
  
}
