
package fr.cg95.cvq.business.request.election;

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
 *  table="multi_cerfa_electoral_roll_registration_request"
 *  lazy="false"
 */
public class MultiCerfaElectoralRollRegistrationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public MultiCerfaElectoralRollRegistrationRequestData() {
      
        motive = fr.cg95.cvq.business.request.election.ElectoralSituationType.FIRST_SUBSCRIPTION;
      
        choiceNationality = fr.cg95.cvq.business.request.election.NationalityChoiceType.FRENCH_NATIONALITY;
      
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
        
          value = 2,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['motive'].test(_this.motive.toString());" +
                
              
            
            "return active",
        
        profiles = {"situation"},
        message = "oldDepartment"
      )
    
    private String oldDepartment;

    public final void setOldDepartment(final String oldDepartment) {
        this.oldDepartment = oldDepartment;
    }

    /**
 
        * @hibernate.property
        *  column="old_department"
        *  length="2"
      
    */
    public final String getOldDepartment() {
        return this.oldDepartment;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['electionChoice'].test(_this.electionChoice.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"situation"},
        message = "externalDistrictAECT"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['electionChoice'].test(_this.electionChoice.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"situation"},
        message = "externalDistrictAECT"
      )
    
    private String externalDistrictAECT;

    public final void setExternalDistrictAECT(final String externalDistrictAECT) {
        this.externalDistrictAECT = externalDistrictAECT;
    }

    /**
 
        * @hibernate.property
        *  column="external_district_a_e_c_t"
        
      
    */
    public final String getExternalDistrictAECT() {
        return this.externalDistrictAECT;
    }
  
    
      @NotNull(
        
        
        profiles = {"situation"},
        message = "motive"
      )
    
    private fr.cg95.cvq.business.request.election.ElectoralSituationType motive;

    public final void setMotive(final fr.cg95.cvq.business.request.election.ElectoralSituationType motive) {
        this.motive = motive;
    }

    /**
 
        * @hibernate.property
        *  column="motive"
        
      
    */
    public final fr.cg95.cvq.business.request.election.ElectoralSituationType getMotive() {
        return this.motive;
    }
  
    
      @NotNull(
        
        
        profiles = {"situation"},
        message = "choiceNationality"
      )
    
    private fr.cg95.cvq.business.request.election.NationalityChoiceType choiceNationality;

    public final void setChoiceNationality(final fr.cg95.cvq.business.request.election.NationalityChoiceType choiceNationality) {
        this.choiceNationality = choiceNationality;
    }

    /**
 
        * @hibernate.property
        *  column="choice_nationality"
        
      
    */
    public final fr.cg95.cvq.business.request.election.NationalityChoiceType getChoiceNationality() {
        return this.choiceNationality;
    }
  
    
      @MaxLength(
        
          value = 32,
        
        
        profiles = {"registration"},
        message = "registrationCity"
      )
    
      @NotNull(
        
        
        profiles = {"registration"},
        message = "registrationCity"
      )
    
      @NotBlank(
        
        
        profiles = {"registration"},
        message = "registrationCity"
      )
    
    private String registrationCity;

    public final void setRegistrationCity(final String registrationCity) {
        this.registrationCity = registrationCity;
    }

    /**
 
        * @hibernate.property
        *  column="registration_city"
        *  length="32"
      
    */
    public final String getRegistrationCity() {
        return this.registrationCity;
    }
  
    
      @NotNull(
        
        
        profiles = {"registration"},
        message = "subjectChoiceBirthDate"
      )
    
    private java.util.Date subjectChoiceBirthDate;

    public final void setSubjectChoiceBirthDate(final java.util.Date subjectChoiceBirthDate) {
        this.subjectChoiceBirthDate = subjectChoiceBirthDate;
    }

    /**
 
        * @hibernate.property
        *  column="subject_choice_birth_date"
        
      
    */
    public final java.util.Date getSubjectChoiceBirthDate() {
        return this.subjectChoiceBirthDate;
    }
  
    
    private String ambassyOrConsulateAFCT;

    public final void setAmbassyOrConsulateAFCT(final String ambassyOrConsulateAFCT) {
        this.ambassyOrConsulateAFCT = ambassyOrConsulateAFCT;
    }

    /**
 
        * @hibernate.property
        *  column="ambassy_or_consulate_a_f_c_t"
        
      
    */
    public final String getAmbassyOrConsulateAFCT() {
        return this.ambassyOrConsulateAFCT;
    }
  
    
    private String subjectChoiceEmail;

    public final void setSubjectChoiceEmail(final String subjectChoiceEmail) {
        this.subjectChoiceEmail = subjectChoiceEmail;
    }

    /**
 
        * @hibernate.property
        *  column="subject_choice_email"
        
      
    */
    public final String getSubjectChoiceEmail() {
        return this.subjectChoiceEmail;
    }
  
    
      @MaxLength(
        
          value = 2,
        
        
        profiles = {"registration"},
        message = "registrationPostalCode"
      )
    
      @NotNull(
        
        
        profiles = {"registration"},
        message = "registrationPostalCode"
      )
    
      @NotBlank(
        
        
        profiles = {"registration"},
        message = "registrationPostalCode"
      )
    
    private String registrationPostalCode;

    public final void setRegistrationPostalCode(final String registrationPostalCode) {
        this.registrationPostalCode = registrationPostalCode;
    }

    /**
 
        * @hibernate.property
        *  column="registration_postal_code"
        *  length="2"
      
    */
    public final String getRegistrationPostalCode() {
        return this.registrationPostalCode;
    }
  
    
      @NotNull(
        
        
        profiles = {"registration"},
        message = "subjectChoiceTitle"
      )
    
    private fr.cg95.cvq.business.users.TitleType subjectChoiceTitle;

    public final void setSubjectChoiceTitle(final fr.cg95.cvq.business.users.TitleType subjectChoiceTitle) {
        this.subjectChoiceTitle = subjectChoiceTitle;
    }

    /**
 
        * @hibernate.property
        *  column="subject_choice_title"
        
      
    */
    public final fr.cg95.cvq.business.users.TitleType getSubjectChoiceTitle() {
        return this.subjectChoiceTitle;
    }
  
    
      @MaxLength(
        
          value = 10,
        
        
        profiles = {"registration"},
        message = "subjectChoiceMobilPhone"
      )
    
    private String subjectChoiceMobilPhone;

    public final void setSubjectChoiceMobilPhone(final String subjectChoiceMobilPhone) {
        this.subjectChoiceMobilPhone = subjectChoiceMobilPhone;
    }

    /**
 
        * @hibernate.property
        *  column="subject_choice_mobil_phone"
        *  length="10"
      
    */
    public final String getSubjectChoiceMobilPhone() {
        return this.subjectChoiceMobilPhone;
    }
  
    
      @MaxLength(
        
          value = 10,
        
        
        profiles = {"registration"},
        message = "subjectChoiceProPhone"
      )
    
    private String subjectChoiceProPhone;

    public final void setSubjectChoiceProPhone(final String subjectChoiceProPhone) {
        this.subjectChoiceProPhone = subjectChoiceProPhone;
    }

    /**
 
        * @hibernate.property
        *  column="subject_choice_pro_phone"
        *  length="10"
      
    */
    public final String getSubjectChoiceProPhone() {
        return this.subjectChoiceProPhone;
    }
  
    
      @NotNull(
        
        
        profiles = {"registration"},
        message = "subjectChoiceFirstName"
      )
    
      @NotBlank(
        
        
        profiles = {"registration"},
        message = "subjectChoiceFirstName"
      )
    
    private String subjectChoiceFirstName;

    public final void setSubjectChoiceFirstName(final String subjectChoiceFirstName) {
        this.subjectChoiceFirstName = subjectChoiceFirstName;
    }

    /**
 
        * @hibernate.property
        *  column="subject_choice_first_name"
        
      
    */
    public final String getSubjectChoiceFirstName() {
        return this.subjectChoiceFirstName;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['choiceNationality'].test(_this.choiceNationality.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"situation"},
        message = "europeanNationality"
      )
    
    private fr.cg95.cvq.business.request.election.EuropeanNationalityType europeanNationality;

    public final void setEuropeanNationality(final fr.cg95.cvq.business.request.election.EuropeanNationalityType europeanNationality) {
        this.europeanNationality = europeanNationality;
    }

    /**
 
        * @hibernate.property
        *  column="european_nationality"
        
      
    */
    public final fr.cg95.cvq.business.request.election.EuropeanNationalityType getEuropeanNationality() {
        return this.europeanNationality;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['electionChoice'].test(_this.electionChoice.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"situation"},
        message = "externalCityAECT"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['electionChoice'].test(_this.electionChoice.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"situation"},
        message = "externalCityAECT"
      )
    
    private String externalCityAECT;

    public final void setExternalCityAECT(final String externalCityAECT) {
        this.externalCityAECT = externalCityAECT;
    }

    /**
 
        * @hibernate.property
        *  column="external_city_a_e_c_t"
        
      
    */
    public final String getExternalCityAECT() {
        return this.externalCityAECT;
    }
  
    
      @MaxLength(
        
          value = 32,
        
        
        profiles = {"registration"},
        message = "subjectChoiceBirthCity"
      )
    
      @NotNull(
        
        
        profiles = {"registration"},
        message = "subjectChoiceBirthCity"
      )
    
      @NotBlank(
        
        
        profiles = {"registration"},
        message = "subjectChoiceBirthCity"
      )
    
    private String subjectChoiceBirthCity;

    public final void setSubjectChoiceBirthCity(final String subjectChoiceBirthCity) {
        this.subjectChoiceBirthCity = subjectChoiceBirthCity;
    }

    /**
 
        * @hibernate.property
        *  column="subject_choice_birth_city"
        *  length="32"
      
    */
    public final String getSubjectChoiceBirthCity() {
        return this.subjectChoiceBirthCity;
    }
  
    
      @NotNull(
        
        
        profiles = {"registration"},
        message = "subjectChoiceLastName"
      )
    
      @NotBlank(
        
        
        profiles = {"registration"},
        message = "subjectChoiceLastName"
      )
    
    private String subjectChoiceLastName;

    public final void setSubjectChoiceLastName(final String subjectChoiceLastName) {
        this.subjectChoiceLastName = subjectChoiceLastName;
    }

    /**
 
        * @hibernate.property
        *  column="subject_choice_last_name"
        
      
    */
    public final String getSubjectChoiceLastName() {
        return this.subjectChoiceLastName;
    }
  
    
      @MaxLength(
        
          value = 5,
        
        
        profiles = {"registration"},
        message = "subjectChoiceBirthPostalCode"
      )
    
      @NotNull(
        
        
        profiles = {"registration"},
        message = "subjectChoiceBirthPostalCode"
      )
    
      @NotBlank(
        
        
        profiles = {"registration"},
        message = "subjectChoiceBirthPostalCode"
      )
    
    private String subjectChoiceBirthPostalCode;

    public final void setSubjectChoiceBirthPostalCode(final String subjectChoiceBirthPostalCode) {
        this.subjectChoiceBirthPostalCode = subjectChoiceBirthPostalCode;
    }

    /**
 
        * @hibernate.property
        *  column="subject_choice_birth_postal_code"
        *  length="5"
      
    */
    public final String getSubjectChoiceBirthPostalCode() {
        return this.subjectChoiceBirthPostalCode;
    }
  
    
      @MaxLength(
        
          value = 10,
        
        
        profiles = {"registration"},
        message = "subjectChoiceHomePhone"
      )
    
    private String subjectChoiceHomePhone;

    public final void setSubjectChoiceHomePhone(final String subjectChoiceHomePhone) {
        this.subjectChoiceHomePhone = subjectChoiceHomePhone;
    }

    /**
 
        * @hibernate.property
        *  column="subject_choice_home_phone"
        *  length="10"
      
    */
    public final String getSubjectChoiceHomePhone() {
        return this.subjectChoiceHomePhone;
    }
  
    
    private String oldCity;

    public final void setOldCity(final String oldCity) {
        this.oldCity = oldCity;
    }

    /**
 
        * @hibernate.property
        *  column="old_city"
        
      
    */
    public final String getOldCity() {
        return this.oldCity;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['electionChoice'].test(_this.electionChoice.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"situation"},
        message = "externalCountryAECT"
      )
    
    private fr.cg95.cvq.business.request.election.EuropeanNationalityType externalCountryAECT;

    public final void setExternalCountryAECT(final fr.cg95.cvq.business.request.election.EuropeanNationalityType externalCountryAECT) {
        this.externalCountryAECT = externalCountryAECT;
    }

    /**
 
        * @hibernate.property
        *  column="external_country_a_e_c_t"
        
      
    */
    public final fr.cg95.cvq.business.request.election.EuropeanNationalityType getExternalCountryAECT() {
        return this.externalCountryAECT;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['subjectChoiceTitle'].test(_this.subjectChoiceTitle.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"registration"},
        message = "subjectChoiceMaidenName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['subjectChoiceTitle'].test(_this.subjectChoiceTitle.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"registration"},
        message = "subjectChoiceMaidenName"
      )
    
    private String subjectChoiceMaidenName;

    public final void setSubjectChoiceMaidenName(final String subjectChoiceMaidenName) {
        this.subjectChoiceMaidenName = subjectChoiceMaidenName;
    }

    /**
 
        * @hibernate.property
        *  column="subject_choice_maiden_name"
        
      
    */
    public final String getSubjectChoiceMaidenName() {
        return this.subjectChoiceMaidenName;
    }
  
    
    private fr.cg95.cvq.business.users.CountryType externalCountryAFCT;

    public final void setExternalCountryAFCT(final fr.cg95.cvq.business.users.CountryType externalCountryAFCT) {
        this.externalCountryAFCT = externalCountryAFCT;
    }

    /**
 
        * @hibernate.property
        *  column="external_country_a_f_c_t"
        
      
    */
    public final fr.cg95.cvq.business.users.CountryType getExternalCountryAFCT() {
        return this.externalCountryAFCT;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['choiceNationality'].test(_this.choiceNationality.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"situation"},
        message = "electionChoice"
      )
    
    private fr.cg95.cvq.business.request.election.ElectoralChoiceEuropeanType electionChoice;

    public final void setElectionChoice(final fr.cg95.cvq.business.request.election.ElectoralChoiceEuropeanType electionChoice) {
        this.electionChoice = electionChoice;
    }

    /**
 
        * @hibernate.property
        *  column="election_choice"
        
      
    */
    public final fr.cg95.cvq.business.request.election.ElectoralChoiceEuropeanType getElectionChoice() {
        return this.electionChoice;
    }
  
    
    private String oldOverseas;

    public final void setOldOverseas(final String oldOverseas) {
        this.oldOverseas = oldOverseas;
    }

    /**
 
        * @hibernate.property
        *  column="old_overseas"
        
      
    */
    public final String getOldOverseas() {
        return this.oldOverseas;
    }
  
    
      @AssertValid(
        
        
        profiles = {"registration"},
        message = "subjectChoiceAddress"
      )
    
    private fr.cg95.cvq.business.users.Address subjectChoiceAddress;

    public final void setSubjectChoiceAddress(final fr.cg95.cvq.business.users.Address subjectChoiceAddress) {
        this.subjectChoiceAddress = subjectChoiceAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="subject_choice_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getSubjectChoiceAddress() {
        return this.subjectChoiceAddress;
    }
  
    
      @NotNull(
        
        
        profiles = {"registration"},
        message = "subjectChoiceBirthCountry"
      )
    
    private fr.cg95.cvq.business.users.CountryType subjectChoiceBirthCountry;

    public final void setSubjectChoiceBirthCountry(final fr.cg95.cvq.business.users.CountryType subjectChoiceBirthCountry) {
        this.subjectChoiceBirthCountry = subjectChoiceBirthCountry;
    }

    /**
 
        * @hibernate.property
        *  column="subject_choice_birth_country"
        
      
    */
    public final fr.cg95.cvq.business.users.CountryType getSubjectChoiceBirthCountry() {
        return this.subjectChoiceBirthCountry;
    }
  
}
