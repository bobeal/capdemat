
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
 *  table="domestic_help_request"
 *  lazy="false"
 */
public class DomesticHelpRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

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
