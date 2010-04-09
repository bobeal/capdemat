
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

import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;

import net.sf.oval.constraint.*;
import fr.cg95.cvq.service.request.LocalReferential;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.class
 *  table="domestic_help_request"
 *  lazy="false"
 */
public class DomesticHelpRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public DomesticHelpRequestData() {
      
        dhrIsSpouseRetired = Boolean.valueOf(false);
      
        dhrRequesterIsFrenchResident = Boolean.valueOf(false);
      
        dhrRequesterHaveGuardian = Boolean.valueOf(false);
      
        dhrRequestKind = fr.cg95.cvq.business.request.social.DhrRequestKindType.INDIVIDUAL;
      
        dhrSpouseIsFrenchResident = Boolean.valueOf(false);
      
        dhrHaveFamilyReferent = Boolean.valueOf(false);
      
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
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrIsSpouseRetired'].test(_this.dhrIsSpouseRetired.toString());" +
                
              
            
            "active &= _this.conditions['dhrRequestKind'].test(_this.dhrRequestKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrSpousePrincipalPensionPlan"
      )
    
    private fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlanType dhrSpousePrincipalPensionPlan;

    public final void setDhrSpousePrincipalPensionPlan(final fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlanType dhrSpousePrincipalPensionPlan) {
        this.dhrSpousePrincipalPensionPlan = dhrSpousePrincipalPensionPlan;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_principal_pension_plan"
        
      
    */
    public final fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlanType getDhrSpousePrincipalPensionPlan() {
        return this.dhrSpousePrincipalPensionPlan;
    }
  
    
      @AssertValid(
        
        
        profiles = {"resources"},
        message = "dhrRealAsset"
      )
    
      @MinSize(
        
          value = 1,
        
        
        profiles = {"resources"},
        message = "dhrRealAsset"
      )
    
    private List<fr.cg95.cvq.business.request.social.DhrRealAsset> dhrRealAsset;

    public final void setDhrRealAsset(final List<fr.cg95.cvq.business.request.social.DhrRealAsset> dhrRealAsset) {
        this.dhrRealAsset = dhrRealAsset;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="domestic_help_request_id"
        * @hibernate.list-index
        *  column="dhr_real_asset_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.social.DhrRealAsset"
      
    */
    public final List<fr.cg95.cvq.business.request.social.DhrRealAsset> getDhrRealAsset() {
        return this.dhrRealAsset;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['dhrIsSpouseRetired'].test(_this.dhrIsSpouseRetired.toString());" +
                
              
            
            "active &= _this.conditions['dhrRequestKind'].test(_this.dhrRequestKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrSpouseProfession"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['dhrIsSpouseRetired'].test(_this.dhrIsSpouseRetired.toString());" +
                
              
            
            "active &= _this.conditions['dhrRequestKind'].test(_this.dhrRequestKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrSpouseProfession"
      )
    
    private String dhrSpouseProfession;

    public final void setDhrSpouseProfession(final String dhrSpouseProfession) {
        this.dhrSpouseProfession = dhrSpouseProfession;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_profession"
        
      
    */
    public final String getDhrSpouseProfession() {
        return this.dhrSpouseProfession;
    }
  
    
    private java.math.BigInteger dhrNetIncome;

    public final void setDhrNetIncome(final java.math.BigInteger dhrNetIncome) {
        this.dhrNetIncome = dhrNetIncome;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_net_income"
        *  type="serializable"
        
      
    */
    public final java.math.BigInteger getDhrNetIncome() {
        return this.dhrNetIncome;
    }
  
    
    private java.math.BigInteger professionalTaxes;

    public final void setProfessionalTaxes(final java.math.BigInteger professionalTaxes) {
        this.professionalTaxes = professionalTaxes;
    }

    /**
 
        * @hibernate.property
        *  column="professional_taxes"
        *  type="serializable"
        
      
    */
    public final java.math.BigInteger getProfessionalTaxes() {
        return this.professionalTaxes;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['dhrRequestKind'].test(_this.dhrRequestKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrIsSpouseRetired"
      )
    
    private Boolean dhrIsSpouseRetired;

    public final void setDhrIsSpouseRetired(final Boolean dhrIsSpouseRetired) {
        this.dhrIsSpouseRetired = dhrIsSpouseRetired;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_is_spouse_retired"
        
      
    */
    public final Boolean getDhrIsSpouseRetired() {
        return this.dhrIsSpouseRetired;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrRequestKind'].test(_this.dhrRequestKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrSpouseTitle"
      )
    
    private fr.cg95.cvq.business.users.TitleType dhrSpouseTitle;

    public final void setDhrSpouseTitle(final fr.cg95.cvq.business.users.TitleType dhrSpouseTitle) {
        this.dhrSpouseTitle = dhrSpouseTitle;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_title"
        
      
    */
    public final fr.cg95.cvq.business.users.TitleType getDhrSpouseTitle() {
        return this.dhrSpouseTitle;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "dhrRequesterBirthDate"
      )
    
    private java.util.Date dhrRequesterBirthDate;

    public final void setDhrRequesterBirthDate(final java.util.Date dhrRequesterBirthDate) {
        this.dhrRequesterBirthDate = dhrRequesterBirthDate;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_requester_birth_date"
        
      
    */
    public final java.util.Date getDhrRequesterBirthDate() {
        return this.dhrRequesterBirthDate;
    }
  
    
    private java.math.BigInteger dhrRealEstateInvestmentIncome;

    public final void setDhrRealEstateInvestmentIncome(final java.math.BigInteger dhrRealEstateInvestmentIncome) {
        this.dhrRealEstateInvestmentIncome = dhrRealEstateInvestmentIncome;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_real_estate_investment_income"
        *  type="serializable"
        
      
    */
    public final java.math.BigInteger getDhrRealEstateInvestmentIncome() {
        return this.dhrRealEstateInvestmentIncome;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrRequesterNationality'].test(_this.dhrRequesterNationality.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "dhrRequesterIsFrenchResident"
      )
    
    private Boolean dhrRequesterIsFrenchResident;

    public final void setDhrRequesterIsFrenchResident(final Boolean dhrRequesterIsFrenchResident) {
        this.dhrRequesterIsFrenchResident = dhrRequesterIsFrenchResident;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_requester_is_french_resident"
        
      
    */
    public final Boolean getDhrRequesterIsFrenchResident() {
        return this.dhrRequesterIsFrenchResident;
    }
  
    
      @NotNull(
        
        
        profiles = {"dwelling"},
        message = "dhrCurrentDwellingAddress"
      )
    
      @AssertValid(
        
        
        profiles = {"dwelling"},
        message = "dhrCurrentDwellingAddress"
      )
    
    private fr.cg95.cvq.business.users.Address dhrCurrentDwellingAddress;

    public final void setDhrCurrentDwellingAddress(final fr.cg95.cvq.business.users.Address dhrCurrentDwellingAddress) {
        this.dhrCurrentDwellingAddress = dhrCurrentDwellingAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="dhr_current_dwelling_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getDhrCurrentDwellingAddress() {
        return this.dhrCurrentDwellingAddress;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrSpouseNationality'].test(_this.dhrSpouseNationality.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrSpouseFranceArrivalDate"
      )
    
    private java.util.Date dhrSpouseFranceArrivalDate;

    public final void setDhrSpouseFranceArrivalDate(final java.util.Date dhrSpouseFranceArrivalDate) {
        this.dhrSpouseFranceArrivalDate = dhrSpouseFranceArrivalDate;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_france_arrival_date"
        
      
    */
    public final java.util.Date getDhrSpouseFranceArrivalDate() {
        return this.dhrSpouseFranceArrivalDate;
    }
  
    
      @AssertValid(
        
        
        profiles = {"resources"},
        message = "dhrNotRealAsset"
      )
    
      @MinSize(
        
          value = 1,
        
        
        profiles = {"resources"},
        message = "dhrNotRealAsset"
      )
    
    private List<fr.cg95.cvq.business.request.social.DhrNotRealAsset> dhrNotRealAsset;

    public final void setDhrNotRealAsset(final List<fr.cg95.cvq.business.request.social.DhrNotRealAsset> dhrNotRealAsset) {
        this.dhrNotRealAsset = dhrNotRealAsset;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="domestic_help_request_id"
        * @hibernate.list-index
        *  column="dhr_not_real_asset_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.social.DhrNotRealAsset"
      
    */
    public final List<fr.cg95.cvq.business.request.social.DhrNotRealAsset> getDhrNotRealAsset() {
        return this.dhrNotRealAsset;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "dhrRequesterNationality"
      )
    
    private fr.cg95.cvq.business.users.NationalityType dhrRequesterNationality;

    public final void setDhrRequesterNationality(final fr.cg95.cvq.business.users.NationalityType dhrRequesterNationality) {
        this.dhrRequesterNationality = dhrRequesterNationality;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_requester_nationality"
        *  length="32"
      
    */
    public final fr.cg95.cvq.business.users.NationalityType getDhrRequesterNationality() {
        return this.dhrRequesterNationality;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrCurrentDwellingKind'].test(_this.dhrCurrentDwellingKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"dwelling"},
        message = "dhrCurrentDwellingArrivalDate"
      )
    
    private java.util.Date dhrCurrentDwellingArrivalDate;

    public final void setDhrCurrentDwellingArrivalDate(final java.util.Date dhrCurrentDwellingArrivalDate) {
        this.dhrCurrentDwellingArrivalDate = dhrCurrentDwellingArrivalDate;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_current_dwelling_arrival_date"
        
      
    */
    public final java.util.Date getDhrCurrentDwellingArrivalDate() {
        return this.dhrCurrentDwellingArrivalDate;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrHaveFamilyReferent'].test(_this.dhrHaveFamilyReferent.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"familyReferent"},
        message = "dhrReferentFirstName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrHaveFamilyReferent'].test(_this.dhrHaveFamilyReferent.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"familyReferent"},
        message = "dhrReferentFirstName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrHaveFamilyReferent'].test(_this.dhrHaveFamilyReferent.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"familyReferent"},
        message = "dhrReferentFirstName"
      )
    
    private String dhrReferentFirstName;

    public final void setDhrReferentFirstName(final String dhrReferentFirstName) {
        this.dhrReferentFirstName = dhrReferentFirstName;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_referent_first_name"
        *  length="38"
      
    */
    public final String getDhrReferentFirstName() {
        return this.dhrReferentFirstName;
    }
  
    
      @NotNull(
        
        
        profiles = {"resources"},
        message = "dhrIncomesAnnualTotal"
      )
    
    private java.math.BigInteger dhrIncomesAnnualTotal;

    public final void setDhrIncomesAnnualTotal(final java.math.BigInteger dhrIncomesAnnualTotal) {
        this.dhrIncomesAnnualTotal = dhrIncomesAnnualTotal;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_incomes_annual_total"
        *  type="serializable"
        
      
    */
    public final java.math.BigInteger getDhrIncomesAnnualTotal() {
        return this.dhrIncomesAnnualTotal;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "dhrRequesterHaveGuardian"
      )
    
    private Boolean dhrRequesterHaveGuardian;

    public final void setDhrRequesterHaveGuardian(final Boolean dhrRequesterHaveGuardian) {
        this.dhrRequesterHaveGuardian = dhrRequesterHaveGuardian;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_requester_have_guardian"
        
      
    */
    public final Boolean getDhrRequesterHaveGuardian() {
        return this.dhrRequesterHaveGuardian;
    }
  
    
    private java.math.BigInteger dhrIncomeTax;

    public final void setDhrIncomeTax(final java.math.BigInteger dhrIncomeTax) {
        this.dhrIncomeTax = dhrIncomeTax;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_income_tax"
        *  type="serializable"
        
      
    */
    public final java.math.BigInteger getDhrIncomeTax() {
        return this.dhrIncomeTax;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrRequestKind'].test(_this.dhrRequestKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrSpouseBirthPlace"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrRequestKind'].test(_this.dhrRequestKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrSpouseBirthPlace"
      )
    
    private String dhrSpouseBirthPlace;

    public final void setDhrSpouseBirthPlace(final String dhrSpouseBirthPlace) {
        this.dhrSpouseBirthPlace = dhrSpouseBirthPlace;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_birth_place"
        
      
    */
    public final String getDhrSpouseBirthPlace() {
        return this.dhrSpouseBirthPlace;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrRequestKind'].test(_this.dhrRequestKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrSpouseBirthDate"
      )
    
    private java.util.Date dhrSpouseBirthDate;

    public final void setDhrSpouseBirthDate(final java.util.Date dhrSpouseBirthDate) {
        this.dhrSpouseBirthDate = dhrSpouseBirthDate;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_birth_date"
        
      
    */
    public final java.util.Date getDhrSpouseBirthDate() {
        return this.dhrSpouseBirthDate;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrCurrentDwellingKind'].test(_this.dhrCurrentDwellingKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"dwelling"},
        message = "dhrCurrentDwellingNetArea"
      )
    
      @MatchPattern(
        
          pattern = "^[1-9]$|^[1-9][0-9]$|^[1-4][0-9][0-9]$|^500$",
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrCurrentDwellingKind'].test(_this.dhrCurrentDwellingKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"dwelling"},
        message = "dhrCurrentDwellingNetArea"
      )
    
    private Short dhrCurrentDwellingNetArea;

    public final void setDhrCurrentDwellingNetArea(final Short dhrCurrentDwellingNetArea) {
        this.dhrCurrentDwellingNetArea = dhrCurrentDwellingNetArea;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_current_dwelling_net_area"
        
      
    */
    public final Short getDhrCurrentDwellingNetArea() {
        return this.dhrCurrentDwellingNetArea;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrRequesterNationality'].test(_this.dhrRequesterNationality.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "dhrRequesterFranceArrivalDate"
      )
    
    private java.util.Date dhrRequesterFranceArrivalDate;

    public final void setDhrRequesterFranceArrivalDate(final java.util.Date dhrRequesterFranceArrivalDate) {
        this.dhrRequesterFranceArrivalDate = dhrRequesterFranceArrivalDate;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_requester_france_arrival_date"
        
      
    */
    public final java.util.Date getDhrRequesterFranceArrivalDate() {
        return this.dhrRequesterFranceArrivalDate;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrCurrentDwellingKind'].test(_this.dhrCurrentDwellingKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"dwelling"},
        message = "dhrCurrentDwellingStatus"
      )
    
    private fr.cg95.cvq.business.request.social.DhrDwellingStatusType dhrCurrentDwellingStatus;

    public final void setDhrCurrentDwellingStatus(final fr.cg95.cvq.business.request.social.DhrDwellingStatusType dhrCurrentDwellingStatus) {
        this.dhrCurrentDwellingStatus = dhrCurrentDwellingStatus;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_current_dwelling_status"
        
      
    */
    public final fr.cg95.cvq.business.request.social.DhrDwellingStatusType getDhrCurrentDwellingStatus() {
        return this.dhrCurrentDwellingStatus;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrRequestKind'].test(_this.dhrRequestKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrSpouseFirstName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrRequestKind'].test(_this.dhrRequestKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrSpouseFirstName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrRequestKind'].test(_this.dhrRequestKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrSpouseFirstName"
      )
    
    private String dhrSpouseFirstName;

    public final void setDhrSpouseFirstName(final String dhrSpouseFirstName) {
        this.dhrSpouseFirstName = dhrSpouseFirstName;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_first_name"
        *  length="38"
      
    */
    public final String getDhrSpouseFirstName() {
        return this.dhrSpouseFirstName;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrRequestKind'].test(_this.dhrRequestKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrSpouseFamilyStatus"
      )
    
    private fr.cg95.cvq.business.users.FamilyStatusType dhrSpouseFamilyStatus;

    public final void setDhrSpouseFamilyStatus(final fr.cg95.cvq.business.users.FamilyStatusType dhrSpouseFamilyStatus) {
        this.dhrSpouseFamilyStatus = dhrSpouseFamilyStatus;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_family_status"
        
      
    */
    public final fr.cg95.cvq.business.users.FamilyStatusType getDhrSpouseFamilyStatus() {
        return this.dhrSpouseFamilyStatus;
    }
  
    
    private java.math.BigInteger dhrFurnitureInvestmentIncome;

    public final void setDhrFurnitureInvestmentIncome(final java.math.BigInteger dhrFurnitureInvestmentIncome) {
        this.dhrFurnitureInvestmentIncome = dhrFurnitureInvestmentIncome;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_furniture_investment_income"
        *  type="serializable"
        
      
    */
    public final java.math.BigInteger getDhrFurnitureInvestmentIncome() {
        return this.dhrFurnitureInvestmentIncome;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrRequesterHaveGuardian'].test(_this.dhrRequesterHaveGuardian.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "dhrGuardianAddress"
      )
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrRequesterHaveGuardian'].test(_this.dhrRequesterHaveGuardian.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "dhrGuardianAddress"
      )
    
    private fr.cg95.cvq.business.users.Address dhrGuardianAddress;

    public final void setDhrGuardianAddress(final fr.cg95.cvq.business.users.Address dhrGuardianAddress) {
        this.dhrGuardianAddress = dhrGuardianAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="dhr_guardian_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getDhrGuardianAddress() {
        return this.dhrGuardianAddress;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrHaveFamilyReferent'].test(_this.dhrHaveFamilyReferent.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"familyReferent"},
        message = "dhrReferentName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrHaveFamilyReferent'].test(_this.dhrHaveFamilyReferent.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"familyReferent"},
        message = "dhrReferentName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrHaveFamilyReferent'].test(_this.dhrHaveFamilyReferent.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"familyReferent"},
        message = "dhrReferentName"
      )
    
    private String dhrReferentName;

    public final void setDhrReferentName(final String dhrReferentName) {
        this.dhrReferentName = dhrReferentName;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_referent_name"
        *  length="38"
      
    */
    public final String getDhrReferentName() {
        return this.dhrReferentName;
    }
  
    
    private java.math.BigInteger localRate;

    public final void setLocalRate(final java.math.BigInteger localRate) {
        this.localRate = localRate;
    }

    /**
 
        * @hibernate.property
        *  column="local_rate"
        *  type="serializable"
        
      
    */
    public final java.math.BigInteger getLocalRate() {
        return this.localRate;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['dhrIsSpouseRetired'].test(_this.dhrIsSpouseRetired.toString());" +
                
              
            
            "active &= _this.conditions['dhrRequestKind'].test(_this.dhrRequestKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrSpouseEmployer"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['dhrIsSpouseRetired'].test(_this.dhrIsSpouseRetired.toString());" +
                
              
            
            "active &= _this.conditions['dhrRequestKind'].test(_this.dhrRequestKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrSpouseEmployer"
      )
    
    private String dhrSpouseEmployer;

    public final void setDhrSpouseEmployer(final String dhrSpouseEmployer) {
        this.dhrSpouseEmployer = dhrSpouseEmployer;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_employer"
        
      
    */
    public final String getDhrSpouseEmployer() {
        return this.dhrSpouseEmployer;
    }
  
    
      @NotNull(
        
        
        profiles = {"spouse"},
        message = "dhrRequestKind"
      )
    
    private fr.cg95.cvq.business.request.social.DhrRequestKindType dhrRequestKind;

    public final void setDhrRequestKind(final fr.cg95.cvq.business.request.social.DhrRequestKindType dhrRequestKind) {
        this.dhrRequestKind = dhrRequestKind;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_request_kind"
        
      
    */
    public final fr.cg95.cvq.business.request.social.DhrRequestKindType getDhrRequestKind() {
        return this.dhrRequestKind;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "dhrPrincipalPensionPlan"
      )
    
    private fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlanType dhrPrincipalPensionPlan;

    public final void setDhrPrincipalPensionPlan(final fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlanType dhrPrincipalPensionPlan) {
        this.dhrPrincipalPensionPlan = dhrPrincipalPensionPlan;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_principal_pension_plan"
        
      
    */
    public final fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlanType getDhrPrincipalPensionPlan() {
        return this.dhrPrincipalPensionPlan;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "dhrComplementaryPensionPlan"
      )
    
      @NotBlank(
        
        
        profiles = {"subject"},
        message = "dhrComplementaryPensionPlan"
      )
    
    private String dhrComplementaryPensionPlan;

    public final void setDhrComplementaryPensionPlan(final String dhrComplementaryPensionPlan) {
        this.dhrComplementaryPensionPlan = dhrComplementaryPensionPlan;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_complementary_pension_plan"
        
      
    */
    public final String getDhrComplementaryPensionPlan() {
        return this.dhrComplementaryPensionPlan;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrHaveFamilyReferent'].test(_this.dhrHaveFamilyReferent.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"familyReferent"},
        message = "dhrReferentAddress"
      )
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrHaveFamilyReferent'].test(_this.dhrHaveFamilyReferent.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"familyReferent"},
        message = "dhrReferentAddress"
      )
    
    private fr.cg95.cvq.business.users.Address dhrReferentAddress;

    public final void setDhrReferentAddress(final fr.cg95.cvq.business.users.Address dhrReferentAddress) {
        this.dhrReferentAddress = dhrReferentAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="dhr_referent_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getDhrReferentAddress() {
        return this.dhrReferentAddress;
    }
  
    
    private java.math.BigInteger propertyTaxes;

    public final void setPropertyTaxes(final java.math.BigInteger propertyTaxes) {
        this.propertyTaxes = propertyTaxes;
    }

    /**
 
        * @hibernate.property
        *  column="property_taxes"
        *  type="serializable"
        
      
    */
    public final java.math.BigInteger getPropertyTaxes() {
        return this.propertyTaxes;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrRequesterHaveGuardian'].test(_this.dhrRequesterHaveGuardian.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "dhrGuardianName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrRequesterHaveGuardian'].test(_this.dhrRequesterHaveGuardian.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "dhrGuardianName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrRequesterHaveGuardian'].test(_this.dhrRequesterHaveGuardian.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "dhrGuardianName"
      )
    
    private String dhrGuardianName;

    public final void setDhrGuardianName(final String dhrGuardianName) {
        this.dhrGuardianName = dhrGuardianName;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_guardian_name"
        *  length="38"
      
    */
    public final String getDhrGuardianName() {
        return this.dhrGuardianName;
    }
  
    
    private java.math.BigInteger pensions;

    public final void setPensions(final java.math.BigInteger pensions) {
        this.pensions = pensions;
    }

    /**
 
        * @hibernate.property
        *  column="pensions"
        *  type="serializable"
        
      
    */
    public final java.math.BigInteger getPensions() {
        return this.pensions;
    }
  
    
      @NotNull(
        
        
        profiles = {"dwelling"},
        message = "dhrCurrentDwellingKind"
      )
    
    private fr.cg95.cvq.business.request.social.DhrDwellingKindType dhrCurrentDwellingKind;

    public final void setDhrCurrentDwellingKind(final fr.cg95.cvq.business.request.social.DhrDwellingKindType dhrCurrentDwellingKind) {
        this.dhrCurrentDwellingKind = dhrCurrentDwellingKind;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_current_dwelling_kind"
        
      
    */
    public final fr.cg95.cvq.business.request.social.DhrDwellingKindType getDhrCurrentDwellingKind() {
        return this.dhrCurrentDwellingKind;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrCurrentDwellingKind'].test(_this.dhrCurrentDwellingKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"dwelling"},
        message = "dhrCurrentDwellingNumberOfRoom"
      )
    
    private Short dhrCurrentDwellingNumberOfRoom;

    public final void setDhrCurrentDwellingNumberOfRoom(final Short dhrCurrentDwellingNumberOfRoom) {
        this.dhrCurrentDwellingNumberOfRoom = dhrCurrentDwellingNumberOfRoom;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_current_dwelling_number_of_room"
        
      
    */
    public final Short getDhrCurrentDwellingNumberOfRoom() {
        return this.dhrCurrentDwellingNumberOfRoom;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrRequesterHaveGuardian'].test(_this.dhrRequesterHaveGuardian.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "dhrGuardianMeasure"
      )
    
    private fr.cg95.cvq.business.request.social.DhrGuardianMeasureType dhrGuardianMeasure;

    public final void setDhrGuardianMeasure(final fr.cg95.cvq.business.request.social.DhrGuardianMeasureType dhrGuardianMeasure) {
        this.dhrGuardianMeasure = dhrGuardianMeasure;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_guardian_measure"
        
      
    */
    public final fr.cg95.cvq.business.request.social.DhrGuardianMeasureType getDhrGuardianMeasure() {
        return this.dhrGuardianMeasure;
    }
  
    
      @MaxLength(
        
          value = 10,
        
        
        profiles = {"dwelling"},
        message = "dhrCurrentDwellingPhone"
      )
    
    private String dhrCurrentDwellingPhone;

    public final void setDhrCurrentDwellingPhone(final String dhrCurrentDwellingPhone) {
        this.dhrCurrentDwellingPhone = dhrCurrentDwellingPhone;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_current_dwelling_phone"
        *  length="10"
      
    */
    public final String getDhrCurrentDwellingPhone() {
        return this.dhrCurrentDwellingPhone;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrSpouseNationality'].test(_this.dhrSpouseNationality.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrSpouseIsFrenchResident"
      )
    
    private Boolean dhrSpouseIsFrenchResident;

    public final void setDhrSpouseIsFrenchResident(final Boolean dhrSpouseIsFrenchResident) {
        this.dhrSpouseIsFrenchResident = dhrSpouseIsFrenchResident;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_is_french_resident"
        
      
    */
    public final Boolean getDhrSpouseIsFrenchResident() {
        return this.dhrSpouseIsFrenchResident;
    }
  
    
    private java.math.BigInteger dhrAllowances;

    public final void setDhrAllowances(final java.math.BigInteger dhrAllowances) {
        this.dhrAllowances = dhrAllowances;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_allowances"
        *  type="serializable"
        
      
    */
    public final java.math.BigInteger getDhrAllowances() {
        return this.dhrAllowances;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrRequestKind'].test(_this.dhrRequestKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrSpouseNationality"
      )
    
    private fr.cg95.cvq.business.users.NationalityType dhrSpouseNationality;

    public final void setDhrSpouseNationality(final fr.cg95.cvq.business.users.NationalityType dhrSpouseNationality) {
        this.dhrSpouseNationality = dhrSpouseNationality;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_nationality"
        *  length="32"
      
    */
    public final fr.cg95.cvq.business.users.NationalityType getDhrSpouseNationality() {
        return this.dhrSpouseNationality;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrSpouseTitle'].test(_this.dhrSpouseTitle.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrSpouseMaidenName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrSpouseTitle'].test(_this.dhrSpouseTitle.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrSpouseMaidenName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrSpouseTitle'].test(_this.dhrSpouseTitle.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrSpouseMaidenName"
      )
    
    private String dhrSpouseMaidenName;

    public final void setDhrSpouseMaidenName(final String dhrSpouseMaidenName) {
        this.dhrSpouseMaidenName = dhrSpouseMaidenName;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_maiden_name"
        *  length="38"
      
    */
    public final String getDhrSpouseMaidenName() {
        return this.dhrSpouseMaidenName;
    }
  
    
      @AssertValid(
        
        
        profiles = {"dwelling"},
        message = "dhrPreviousDwelling"
      )
    
      @MinSize(
        
          value = 1,
        
        
        profiles = {"dwelling"},
        message = "dhrPreviousDwelling"
      )
    
    private List<fr.cg95.cvq.business.request.social.DhrPreviousDwelling> dhrPreviousDwelling;

    public final void setDhrPreviousDwelling(final List<fr.cg95.cvq.business.request.social.DhrPreviousDwelling> dhrPreviousDwelling) {
        this.dhrPreviousDwelling = dhrPreviousDwelling;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="domestic_help_request_id"
        * @hibernate.list-index
        *  column="dhr_previous_dwelling_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.social.DhrPreviousDwelling"
      
    */
    public final List<fr.cg95.cvq.business.request.social.DhrPreviousDwelling> getDhrPreviousDwelling() {
        return this.dhrPreviousDwelling;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrRequestKind'].test(_this.dhrRequestKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrSpouseName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrRequestKind'].test(_this.dhrRequestKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrSpouseName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrRequestKind'].test(_this.dhrRequestKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrSpouseName"
      )
    
    private String dhrSpouseName;

    public final void setDhrSpouseName(final String dhrSpouseName) {
        this.dhrSpouseName = dhrSpouseName;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_name"
        *  length="38"
      
    */
    public final String getDhrSpouseName() {
        return this.dhrSpouseName;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrSpousePrincipalPensionPlan'].test(_this.dhrSpousePrincipalPensionPlan.toString());" +
                
              
            
            "active &= _this.conditions['dhrRequestKind'].test(_this.dhrRequestKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrSpousePensionPlanDetail"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrSpousePrincipalPensionPlan'].test(_this.dhrSpousePrincipalPensionPlan.toString());" +
                
              
            
            "active &= _this.conditions['dhrRequestKind'].test(_this.dhrRequestKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrSpousePensionPlanDetail"
      )
    
    private String dhrSpousePensionPlanDetail;

    public final void setDhrSpousePensionPlanDetail(final String dhrSpousePensionPlanDetail) {
        this.dhrSpousePensionPlanDetail = dhrSpousePensionPlanDetail;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_pension_plan_detail"
        
      
    */
    public final String getDhrSpousePensionPlanDetail() {
        return this.dhrSpousePensionPlanDetail;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "dhrRequesterBirthPlace"
      )
    
      @NotBlank(
        
        
        profiles = {"subject"},
        message = "dhrRequesterBirthPlace"
      )
    
    private String dhrRequesterBirthPlace;

    public final void setDhrRequesterBirthPlace(final String dhrRequesterBirthPlace) {
        this.dhrRequesterBirthPlace = dhrRequesterBirthPlace;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_requester_birth_place"
        
      
    */
    public final String getDhrRequesterBirthPlace() {
        return this.dhrRequesterBirthPlace;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['dhrIsSpouseRetired'].test(_this.dhrIsSpouseRetired.toString());" +
                
              
            
            "active &= _this.conditions['dhrRequestKind'].test(_this.dhrRequestKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrSpouseAddress"
      )
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['dhrIsSpouseRetired'].test(_this.dhrIsSpouseRetired.toString());" +
                
              
            
            "active &= _this.conditions['dhrRequestKind'].test(_this.dhrRequestKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrSpouseAddress"
      )
    
    private fr.cg95.cvq.business.users.Address dhrSpouseAddress;

    public final void setDhrSpouseAddress(final fr.cg95.cvq.business.users.Address dhrSpouseAddress) {
        this.dhrSpouseAddress = dhrSpouseAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="dhr_spouse_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getDhrSpouseAddress() {
        return this.dhrSpouseAddress;
    }
  
    
      @NotNull(
        
        
        profiles = {"familyReferent"},
        message = "dhrHaveFamilyReferent"
      )
    
    private Boolean dhrHaveFamilyReferent;

    public final void setDhrHaveFamilyReferent(final Boolean dhrHaveFamilyReferent) {
        this.dhrHaveFamilyReferent = dhrHaveFamilyReferent;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_have_family_referent"
        
      
    */
    public final Boolean getDhrHaveFamilyReferent() {
        return this.dhrHaveFamilyReferent;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrPrincipalPensionPlan'].test(_this.dhrPrincipalPensionPlan.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "dhrPensionPlanDetail"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrPrincipalPensionPlan'].test(_this.dhrPrincipalPensionPlan.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "dhrPensionPlanDetail"
      )
    
    private String dhrPensionPlanDetail;

    public final void setDhrPensionPlanDetail(final String dhrPensionPlanDetail) {
        this.dhrPensionPlanDetail = dhrPensionPlanDetail;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_pension_plan_detail"
        
      
    */
    public final String getDhrPensionPlanDetail() {
        return this.dhrPensionPlanDetail;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrIsSpouseRetired'].test(_this.dhrIsSpouseRetired.toString());" +
                
              
            
            "active &= _this.conditions['dhrRequestKind'].test(_this.dhrRequestKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrSpouseComplementaryPensionPlan"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrIsSpouseRetired'].test(_this.dhrIsSpouseRetired.toString());" +
                
              
            
            "active &= _this.conditions['dhrRequestKind'].test(_this.dhrRequestKind.toString());" +
                
              
            
            "return active",
        
        profiles = {"spouse"},
        message = "dhrSpouseComplementaryPensionPlan"
      )
    
    private String dhrSpouseComplementaryPensionPlan;

    public final void setDhrSpouseComplementaryPensionPlan(final String dhrSpouseComplementaryPensionPlan) {
        this.dhrSpouseComplementaryPensionPlan = dhrSpouseComplementaryPensionPlan;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_complementary_pension_plan"
        
      
    */
    public final String getDhrSpouseComplementaryPensionPlan() {
        return this.dhrSpouseComplementaryPensionPlan;
    }
  
}
