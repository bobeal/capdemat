
package fr.cg95.cvq.business.request.school;

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
 *  table="study_grant_request"
 *  lazy="false"
 */
public class StudyGrantRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public StudyGrantRequestData() {
      
        abroadInternship = Boolean.valueOf(false);
      
        currentSchoolCountry = fr.cg95.cvq.business.users.CountryType.FR;
      
        isSubjectAccountHolder = Boolean.valueOf(true);
      
        sandwichCourses = Boolean.valueOf(false);
      
        subjectFirstRequest = Boolean.valueOf(true);
      
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

  
    
      @NotNull(
        
        
        profiles = {"currentStudies"},
        message = "abroadInternship"
      )
    
    private Boolean abroadInternship;

    public final void setAbroadInternship(final Boolean abroadInternship) {
        this.abroadInternship = abroadInternship;
    }

    /**
 
        * @hibernate.property
        *  column="abroad_internship"
        
      
    */
    public final Boolean getAbroadInternship() {
        return this.abroadInternship;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['abroadInternship'].test(_this.abroadInternship.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"currentStudies"},
        message = "abroadInternshipEndDate"
      )
    
    private java.util.Date abroadInternshipEndDate;

    public final void setAbroadInternshipEndDate(final java.util.Date abroadInternshipEndDate) {
        this.abroadInternshipEndDate = abroadInternshipEndDate;
    }

    /**
 
        * @hibernate.property
        *  column="abroad_internship_end_date"
        
      
    */
    public final java.util.Date getAbroadInternshipEndDate() {
        return this.abroadInternshipEndDate;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['abroadInternship'].test(_this.abroadInternship.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"currentStudies"},
        message = "abroadInternshipSchoolCountry"
      )
    
    private fr.cg95.cvq.business.users.CountryType abroadInternshipSchoolCountry;

    public final void setAbroadInternshipSchoolCountry(final fr.cg95.cvq.business.users.CountryType abroadInternshipSchoolCountry) {
        this.abroadInternshipSchoolCountry = abroadInternshipSchoolCountry;
    }

    /**
 
        * @hibernate.property
        *  column="abroad_internship_school_country"
        
      
    */
    public final fr.cg95.cvq.business.users.CountryType getAbroadInternshipSchoolCountry() {
        return this.abroadInternshipSchoolCountry;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['abroadInternship'].test(_this.abroadInternship.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"currentStudies"},
        message = "abroadInternshipSchoolName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['abroadInternship'].test(_this.abroadInternship.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"currentStudies"},
        message = "abroadInternshipSchoolName"
      )
    
    private String abroadInternshipSchoolName;

    public final void setAbroadInternshipSchoolName(final String abroadInternshipSchoolName) {
        this.abroadInternshipSchoolName = abroadInternshipSchoolName;
    }

    /**
 
        * @hibernate.property
        *  column="abroad_internship_school_name"
        
      
    */
    public final String getAbroadInternshipSchoolName() {
        return this.abroadInternshipSchoolName;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['abroadInternship'].test(_this.abroadInternship.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"currentStudies"},
        message = "abroadInternshipStartDate"
      )
    
    private java.util.Date abroadInternshipStartDate;

    public final void setAbroadInternshipStartDate(final java.util.Date abroadInternshipStartDate) {
        this.abroadInternshipStartDate = abroadInternshipStartDate;
    }

    /**
 
        * @hibernate.property
        *  column="abroad_internship_start_date"
        
      
    */
    public final java.util.Date getAbroadInternshipStartDate() {
        return this.abroadInternshipStartDate;
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
  
    
      @NotNull(
        
        
        profiles = {"currentStudies"},
        message = "alevels"
      )
    
    private fr.cg95.cvq.business.request.school.ALevelsType alevels;

    public final void setAlevels(final fr.cg95.cvq.business.request.school.ALevelsType alevels) {
        this.alevels = alevels;
    }

    /**
 
        * @hibernate.property
        *  column="alevels"
        
      
    */
    public final fr.cg95.cvq.business.request.school.ALevelsType getAlevels() {
        return this.alevels;
    }
  
    
      @MaxLength(
        
          value = 4,
        
        
        profiles = {"currentStudies"},
        message = "alevelsDate"
      )
    
      @NotNull(
        
        
        profiles = {"currentStudies"},
        message = "alevelsDate"
      )
    
      @MatchPattern(
        
          pattern = "^\\d{2,4}$",
        
        
        profiles = {"currentStudies"},
        message = "alevelsDate"
      )
    
      @NotBlank(
        
        
        profiles = {"currentStudies"},
        message = "alevelsDate"
      )
    
    private String alevelsDate;

    public final void setAlevelsDate(final String alevelsDate) {
        this.alevelsDate = alevelsDate;
    }

    /**
 
        * @hibernate.property
        *  column="alevels_date"
        *  length="4"
      
    */
    public final String getAlevelsDate() {
        return this.alevelsDate;
    }
  
    
      @MaxLength(
        
          value = 32,
        
        
        profiles = {"currentStudies"},
        message = "currentSchoolCity"
      )
    
      @NotNull(
        
        
        profiles = {"currentStudies"},
        message = "currentSchoolCity"
      )
    
      @NotBlank(
        
        
        profiles = {"currentStudies"},
        message = "currentSchoolCity"
      )
    
    private String currentSchoolCity;

    public final void setCurrentSchoolCity(final String currentSchoolCity) {
        this.currentSchoolCity = currentSchoolCity;
    }

    /**
 
        * @hibernate.property
        *  column="current_school_city"
        *  length="32"
      
    */
    public final String getCurrentSchoolCity() {
        return this.currentSchoolCity;
    }
  
    
      @NotNull(
        
        
        profiles = {"currentStudies"},
        message = "currentSchoolCountry"
      )
    
    private fr.cg95.cvq.business.users.CountryType currentSchoolCountry;

    public final void setCurrentSchoolCountry(final fr.cg95.cvq.business.users.CountryType currentSchoolCountry) {
        this.currentSchoolCountry = currentSchoolCountry;
    }

    /**
 
        * @hibernate.property
        *  column="current_school_country"
        
      
    */
    public final fr.cg95.cvq.business.users.CountryType getCurrentSchoolCountry() {
        return this.currentSchoolCountry;
    }
  
    
      @LocalReferential(
        
        
        profiles = {"currentStudies"},
        message = "currentSchoolName"
      )
    
      @MinSize(
        
          value = 1,
        
        
        profiles = {"currentStudies"},
        message = "currentSchoolName"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> currentSchoolName;

    public final void setCurrentSchoolName(final List<fr.cg95.cvq.business.request.LocalReferentialData> currentSchoolName) {
        this.currentSchoolName = currentSchoolName;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        *  table="study_grant_request_current_school_name"
        * @hibernate.key
        *  column="study_grant_request_id"
        * @hibernate.list-index
        *  column="current_school_name_index"
        * @hibernate.many-to-many
        *  column="current_school_name_id"
        *  class="fr.cg95.cvq.business.request.LocalReferentialData"
      
    */
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getCurrentSchoolName() {
        return this.currentSchoolName;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "if (_this.currentSchoolName == null || _this.currentSchoolName.isEmpty()) return false; _this.currentSchoolName.each { active &= _this.conditions['currentSchoolName'].test(it.name) };" +
                
              
            
            
            "return active",
        
        profiles = {"currentStudies"},
        message = "currentSchoolNamePrecision"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "if (_this.currentSchoolName == null || _this.currentSchoolName.isEmpty()) return false; _this.currentSchoolName.each { active &= _this.conditions['currentSchoolName'].test(it.name) };" +
                
              
            
            
            "return active",
        
        profiles = {"currentStudies"},
        message = "currentSchoolNamePrecision"
      )
    
    private String currentSchoolNamePrecision;

    public final void setCurrentSchoolNamePrecision(final String currentSchoolNamePrecision) {
        this.currentSchoolNamePrecision = currentSchoolNamePrecision;
    }

    /**
 
        * @hibernate.property
        *  column="current_school_name_precision"
        
      
    */
    public final String getCurrentSchoolNamePrecision() {
        return this.currentSchoolNamePrecision;
    }
  
    
      @MaxLength(
        
          value = 5,
        
        
        profiles = {"currentStudies"},
        message = "currentSchoolPostalCode"
      )
    
      @NotNull(
        
        
        profiles = {"currentStudies"},
        message = "currentSchoolPostalCode"
      )
    
      @NotBlank(
        
        
        profiles = {"currentStudies"},
        message = "currentSchoolPostalCode"
      )
    
    private String currentSchoolPostalCode;

    public final void setCurrentSchoolPostalCode(final String currentSchoolPostalCode) {
        this.currentSchoolPostalCode = currentSchoolPostalCode;
    }

    /**
 
        * @hibernate.property
        *  column="current_school_postal_code"
        *  length="5"
      
    */
    public final String getCurrentSchoolPostalCode() {
        return this.currentSchoolPostalCode;
    }
  
    
      @NotNull(
        
        
        profiles = {"currentStudies"},
        message = "currentStudiesDiploma"
      )
    
    private fr.cg95.cvq.business.request.school.CurrentStudiesType currentStudiesDiploma;

    public final void setCurrentStudiesDiploma(final fr.cg95.cvq.business.request.school.CurrentStudiesType currentStudiesDiploma) {
        this.currentStudiesDiploma = currentStudiesDiploma;
    }

    /**
 
        * @hibernate.property
        *  column="current_studies_diploma"
        
      
    */
    public final fr.cg95.cvq.business.request.school.CurrentStudiesType getCurrentStudiesDiploma() {
        return this.currentStudiesDiploma;
    }
  
    
      @NotNull(
        
        
        profiles = {"currentStudies"},
        message = "currentStudiesLevel"
      )
    
    private fr.cg95.cvq.business.request.school.CurrentStudiesLevelType currentStudiesLevel;

    public final void setCurrentStudiesLevel(final fr.cg95.cvq.business.request.school.CurrentStudiesLevelType currentStudiesLevel) {
        this.currentStudiesLevel = currentStudiesLevel;
    }

    /**
 
        * @hibernate.property
        *  column="current_studies_level"
        
      
    */
    public final fr.cg95.cvq.business.request.school.CurrentStudiesLevelType getCurrentStudiesLevel() {
        return this.currentStudiesLevel;
    }
  
    
      @NotNull(
        
        
        profiles = {"calculationElements"},
        message = "distance"
      )
    
    private fr.cg95.cvq.business.request.school.DistanceType distance;

    public final void setDistance(final fr.cg95.cvq.business.request.school.DistanceType distance) {
        this.distance = distance;
    }

    /**
 
        * @hibernate.property
        *  column="distance"
        
      
    */
    public final fr.cg95.cvq.business.request.school.DistanceType getDistance() {
        return this.distance;
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
  
    
      @NotNull(
        
        
        profiles = {"otherHelps"},
        message = "hasCROUSHelp"
      )
    
    private Boolean hasCROUSHelp;

    public final void setHasCROUSHelp(final Boolean hasCROUSHelp) {
        this.hasCROUSHelp = hasCROUSHelp;
    }

    /**
 
        * @hibernate.property
        *  column="has_c_r_o_u_s_help"
        
      
    */
    public final Boolean getHasCROUSHelp() {
        return this.hasCROUSHelp;
    }
  
    
      @NotNull(
        
        
        profiles = {"otherHelps"},
        message = "hasEuropeHelp"
      )
    
    private Boolean hasEuropeHelp;

    public final void setHasEuropeHelp(final Boolean hasEuropeHelp) {
        this.hasEuropeHelp = hasEuropeHelp;
    }

    /**
 
        * @hibernate.property
        *  column="has_europe_help"
        
      
    */
    public final Boolean getHasEuropeHelp() {
        return this.hasEuropeHelp;
    }
  
    
      @NotNull(
        
        
        profiles = {"otherHelps"},
        message = "hasOtherHelp"
      )
    
    private Boolean hasOtherHelp;

    public final void setHasOtherHelp(final Boolean hasOtherHelp) {
        this.hasOtherHelp = hasOtherHelp;
    }

    /**
 
        * @hibernate.property
        *  column="has_other_help"
        
      
    */
    public final Boolean getHasOtherHelp() {
        return this.hasOtherHelp;
    }
  
    
      @NotNull(
        
        
        profiles = {"otherHelps"},
        message = "hasRegionalCouncilHelp"
      )
    
    private Boolean hasRegionalCouncilHelp;

    public final void setHasRegionalCouncilHelp(final Boolean hasRegionalCouncilHelp) {
        this.hasRegionalCouncilHelp = hasRegionalCouncilHelp;
    }

    /**
 
        * @hibernate.property
        *  column="has_regional_council_help"
        
      
    */
    public final Boolean getHasRegionalCouncilHelp() {
        return this.hasRegionalCouncilHelp;
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
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['currentStudiesDiploma'].test(_this.currentStudiesDiploma.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"currentStudies"},
        message = "otherStudiesLabel"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['currentStudiesDiploma'].test(_this.currentStudiesDiploma.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"currentStudies"},
        message = "otherStudiesLabel"
      )
    
    private String otherStudiesLabel;

    public final void setOtherStudiesLabel(final String otherStudiesLabel) {
        this.otherStudiesLabel = otherStudiesLabel;
    }

    /**
 
        * @hibernate.property
        *  column="other_studies_label"
        
      
    */
    public final String getOtherStudiesLabel() {
        return this.otherStudiesLabel;
    }
  
    
      @NotNull(
        
        
        profiles = {"currentStudies"},
        message = "sandwichCourses"
      )
    
    private Boolean sandwichCourses;

    public final void setSandwichCourses(final Boolean sandwichCourses) {
        this.sandwichCourses = sandwichCourses;
    }

    /**
 
        * @hibernate.property
        *  column="sandwich_courses"
        
      
    */
    public final Boolean getSandwichCourses() {
        return this.sandwichCourses;
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
        
        
        profiles = {"subject"},
        message = "subjectFirstRequest"
      )
    
    private Boolean subjectFirstRequest;

    public final void setSubjectFirstRequest(final Boolean subjectFirstRequest) {
        this.subjectFirstRequest = subjectFirstRequest;
    }

    /**
 
        * @hibernate.property
        *  column="subject_first_request"
        
      
    */
    public final Boolean getSubjectFirstRequest() {
        return this.subjectFirstRequest;
    }
  
    
      @MaxLength(
        
          value = 10,
        
        
        profiles = {"subject"},
        message = "subjectMobilePhone"
      )
    
    private String subjectMobilePhone;

    public final void setSubjectMobilePhone(final String subjectMobilePhone) {
        this.subjectMobilePhone = subjectMobilePhone;
    }

    /**
 
        * @hibernate.property
        *  column="subject_mobile_phone"
        *  length="10"
      
    */
    public final String getSubjectMobilePhone() {
        return this.subjectMobilePhone;
    }
  
    
      @MaxLength(
        
          value = 10,
        
        
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
  
    
      @LocalReferential(
        
        
        profiles = {"taxHousehold"},
        message = "taxHouseholdCity"
      )
    
      @MinSize(
        
          value = 1,
        
        
        profiles = {"taxHousehold"},
        message = "taxHouseholdCity"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> taxHouseholdCity;

    public final void setTaxHouseholdCity(final List<fr.cg95.cvq.business.request.LocalReferentialData> taxHouseholdCity) {
        this.taxHouseholdCity = taxHouseholdCity;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        *  table="study_grant_request_tax_household_city"
        * @hibernate.key
        *  column="study_grant_request_id"
        * @hibernate.list-index
        *  column="tax_household_city_index"
        * @hibernate.many-to-many
        *  column="tax_household_city_id"
        *  class="fr.cg95.cvq.business.request.LocalReferentialData"
      
    */
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getTaxHouseholdCity() {
        return this.taxHouseholdCity;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "if (_this.taxHouseholdCity == null || _this.taxHouseholdCity.isEmpty()) return false; _this.taxHouseholdCity.each { active &= _this.conditions['taxHouseholdCity'].test(it.name) };" +
                
              
            
            
            "return active",
        
        profiles = {"taxHousehold"},
        message = "taxHouseholdCityPrecision"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "if (_this.taxHouseholdCity == null || _this.taxHouseholdCity.isEmpty()) return false; _this.taxHouseholdCity.each { active &= _this.conditions['taxHouseholdCity'].test(it.name) };" +
                
              
            
            
            "return active",
        
        profiles = {"taxHousehold"},
        message = "taxHouseholdCityPrecision"
      )
    
    private String taxHouseholdCityPrecision;

    public final void setTaxHouseholdCityPrecision(final String taxHouseholdCityPrecision) {
        this.taxHouseholdCityPrecision = taxHouseholdCityPrecision;
    }

    /**
 
        * @hibernate.property
        *  column="tax_household_city_precision"
        
      
    */
    public final String getTaxHouseholdCityPrecision() {
        return this.taxHouseholdCityPrecision;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"taxHousehold"},
        message = "taxHouseholdFirstName"
      )
    
      @NotNull(
        
        
        profiles = {"taxHousehold"},
        message = "taxHouseholdFirstName"
      )
    
      @NotBlank(
        
        
        profiles = {"taxHousehold"},
        message = "taxHouseholdFirstName"
      )
    
    private String taxHouseholdFirstName;

    public final void setTaxHouseholdFirstName(final String taxHouseholdFirstName) {
        this.taxHouseholdFirstName = taxHouseholdFirstName;
    }

    /**
 
        * @hibernate.property
        *  column="tax_household_first_name"
        *  length="38"
      
    */
    public final String getTaxHouseholdFirstName() {
        return this.taxHouseholdFirstName;
    }
  
    
      @NotNull(
        
        
        profiles = {"taxHousehold"},
        message = "taxHouseholdIncome"
      )
    
      @MatchPattern(
        
          pattern = "^\\d+(?:\\.\\d{1,2})?$",
        
        
        profiles = {"taxHousehold"},
        message = "taxHouseholdIncome"
      )
    
    private Double taxHouseholdIncome;

    public final void setTaxHouseholdIncome(final Double taxHouseholdIncome) {
        this.taxHouseholdIncome = taxHouseholdIncome;
    }

    /**
 
        * @hibernate.property
        *  column="tax_household_income"
        
      
    */
    public final Double getTaxHouseholdIncome() {
        return this.taxHouseholdIncome;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"taxHousehold"},
        message = "taxHouseholdLastName"
      )
    
      @NotNull(
        
        
        profiles = {"taxHousehold"},
        message = "taxHouseholdLastName"
      )
    
      @NotBlank(
        
        
        profiles = {"taxHousehold"},
        message = "taxHouseholdLastName"
      )
    
    private String taxHouseholdLastName;

    public final void setTaxHouseholdLastName(final String taxHouseholdLastName) {
        this.taxHouseholdLastName = taxHouseholdLastName;
    }

    /**
 
        * @hibernate.property
        *  column="tax_household_last_name"
        *  length="38"
      
    */
    public final String getTaxHouseholdLastName() {
        return this.taxHouseholdLastName;
    }
  
}
