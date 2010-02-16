
package fr.cg95.cvq.business.request.school;

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
 *  table="study_grant_request"
 *  lazy="false"
 */
public class StudyGrantRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    public StudyGrantRequestData() {
      
        subjectFirstRequest = Boolean.valueOf(true);
      
        isSubjectAccountHolder = Boolean.valueOf(true);
      
        currentSchoolCountry = fr.cg95.cvq.business.users.CountryType.FR;
      
        sandwichCourses = Boolean.valueOf(false);
      
        abroadInternship = Boolean.valueOf(false);
      
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
  
    private String counterCode;

    public final void setCounterCode(final String counterCode) {
        this.counterCode = counterCode;
    }

    /**
 
        * @hibernate.property
        *  column="counter_code"
        *  length="5"
      
    */
    public final String getCounterCode() {
        return this.counterCode;
    }
  
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
  
    private String accountKey;

    public final void setAccountKey(final String accountKey) {
        this.accountKey = accountKey;
    }

    /**
 
        * @hibernate.property
        *  column="account_key"
        *  length="2"
      
    */
    public final String getAccountKey() {
        return this.accountKey;
    }
  
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
  
    private String accountNumber;

    public final void setAccountNumber(final String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
 
        * @hibernate.property
        *  column="account_number"
        *  length="11"
      
    */
    public final String getAccountNumber() {
        return this.accountNumber;
    }
  
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
  
    private String bankCode;

    public final void setBankCode(final String bankCode) {
        this.bankCode = bankCode;
    }

    /**
 
        * @hibernate.property
        *  column="bank_code"
        *  length="5"
      
    */
    public final String getBankCode() {
        return this.bankCode;
    }
  
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
  
}
