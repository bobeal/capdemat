
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
 *  table="handicap_compensation_adult_request"
 *  lazy="false"
 */
public class HandicapCompensationAdultRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    public HandicapCompensationAdultRequestData() {
      
        healthFollowedByProfessional = Boolean.valueOf(false);
      
        professionalSupportProfessionals = Boolean.valueOf(false);
      
        isFamilyAssistance = Boolean.valueOf(false);
      
        foldersCdes = Boolean.valueOf(false);
      
        benefitsEducationAllocationOfDisabledChildren = Boolean.valueOf(false);
      
        homeInterventionHomeIntervenant = Boolean.valueOf(false);
      
        projectRequestsHousingFacilities = Boolean.valueOf(false);
      
        benefitsDisabilityPension = Boolean.valueOf(false);
      
        legalAccessPresence = Boolean.valueOf(false);
      
        projectRequestsDisabledWorkerRecognition = Boolean.valueOf(false);
      
        benefitsUnemploymentBenefits = Boolean.valueOf(false);
      
        familyFamilyDependents = Boolean.valueOf(false);
      
        projectRequestsVocationalTraining = Boolean.valueOf(false);
      
        facilitiesCustomCar = Boolean.valueOf(false);
      
        professionalStatusIndemnified = Boolean.valueOf(false);
      
        benefitsDisabledAdultAllocation = Boolean.valueOf(false);
      
        benefitsThirdPartyCompensatoryAllowance = Boolean.valueOf(false);
      
        projectRequestsTransportCostAllocation = Boolean.valueOf(false);
      
        benefitsProfessionalOrientation = Boolean.valueOf(false);
      
        benefitsDisabilityRecognition = Boolean.valueOf(false);
      
        professionalStatusRegisterAsUnemployed = Boolean.valueOf(false);
      
        benefitsPainfulStandingCard = Boolean.valueOf(false);
      
        facilitiesSpecializedTransport = Boolean.valueOf(false);
      
        benefitsParkingCard = Boolean.valueOf(false);
      
        professionalSupportSocialServiceSupport = Boolean.valueOf(false);
      
        benefitsWorkAccidentAnnuity = Boolean.valueOf(false);
      
        careCareServices = Boolean.valueOf(false);
      
        benefitsDailyAllowances = Boolean.valueOf(false);
      
        projectRequestsCustomCar = Boolean.valueOf(false);
      
        projectRequestsACTPRenewal = Boolean.valueOf(false);
      
        foldersMdph = Boolean.valueOf(false);
      
        professionalSupportDealsWithSameProfessional = Boolean.valueOf(false);
      
        dwellingEstablishmentReception = Boolean.valueOf(false);
      
        projectRequestsOrdinaryWorking = Boolean.valueOf(false);
      
        dwellingSocialReception = Boolean.valueOf(false);
      
        benefitsDisabledWorkerRecognition = Boolean.valueOf(false);
      
        projectRequestsEuropeanParkingCard = Boolean.valueOf(false);
      
        healthFollowedByDoctor = Boolean.valueOf(false);
      
        projectRequestsFreePensionMembership = Boolean.valueOf(false);
      
        healthFollowedByHospital = Boolean.valueOf(false);
      
        projectRequestsInstitutionSupport = Boolean.valueOf(false);
      
        benefitsSocialWelfare = Boolean.valueOf(false);
      
        projectRequestsHandicapRecognition = Boolean.valueOf(false);
      
        projectRequestsProfessionalOrientation = Boolean.valueOf(false);
      
        benefitsSupplementForSingleParents = Boolean.valueOf(false);
      
        projectRequestsIncreaseForIndependentLiving = Boolean.valueOf(false);
      
        benefitsThirdPartySupplement = Boolean.valueOf(false);
      
        projectRequestsAssistance = Boolean.valueOf(false);
      
        benefitsSupportedByAnInstitution = Boolean.valueOf(false);
      
        projectRequestsThirdPartyHelp = Boolean.valueOf(false);
      
        projectRequestsDisabledAdultAllowance = Boolean.valueOf(false);
      
        foldersOtherFolders = Boolean.valueOf(false);
      
        projectRequestsOther = Boolean.valueOf(false);
      
        benefitsThirdPersonCompensatoryAllowance = Boolean.valueOf(false);
      
        projectRequestsDisabilityCostAllocation = Boolean.valueOf(false);
      
        professionalStatusElectiveFunction = Boolean.valueOf(false);
      
        foldersCotorep = Boolean.valueOf(false);
      
        benefitsIncreaseForIndependentLiving = Boolean.valueOf(false);
      
        projectRequestsDisabilityCard = Boolean.valueOf(false);
      
        benefitsEducationOfDisabledChildren = Boolean.valueOf(false);
      
        benefitsOtherBenefits = Boolean.valueOf(false);
      
        benefitsDisabilityCompensation = Boolean.valueOf(false);
      
        projectRequestsTechnicalHelp = Boolean.valueOf(false);
      
        facilitiesTechnicalAssistance = Boolean.valueOf(false);
      
        benefitsCompensatoryAllowanceForExpenses = Boolean.valueOf(false);
      
        facilitiesHousing = Boolean.valueOf(false);
      
        projectRequestsDisabledPriorityCard = Boolean.valueOf(false);
      
        projectRequestsEducationAllocationOfDisabledChildren = Boolean.valueOf(false);
      
        projectRequestsShelteredWork = Boolean.valueOf(false);
      
        studiesAssistanceUnderDisability = Boolean.valueOf(false);
      
        studiesHighSchool = Boolean.valueOf(false);
      
        benefitsDisabilityCard = Boolean.valueOf(false);
      
        facilitiesAnimalAid = Boolean.valueOf(false);
      
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

  
    private Boolean healthFollowedByProfessional;

    public final void setHealthFollowedByProfessional(final Boolean healthFollowedByProfessional) {
        this.healthFollowedByProfessional = healthFollowedByProfessional;
    }

    /**
 
        * @hibernate.property
        *  column="health_followed_by_professional"
        
      
    */
    public final Boolean getHealthFollowedByProfessional() {
        return this.healthFollowedByProfessional;
    }
  
    private Boolean professionalSupportProfessionals;

    public final void setProfessionalSupportProfessionals(final Boolean professionalSupportProfessionals) {
        this.professionalSupportProfessionals = professionalSupportProfessionals;
    }

    /**
 
        * @hibernate.property
        *  column="professional_support_professionals"
        
      
    */
    public final Boolean getProfessionalSupportProfessionals() {
        return this.professionalSupportProfessionals;
    }
  
    private List<fr.cg95.cvq.business.request.social.HcarFamilyDependent> familyDependents;

    public final void setFamilyDependents(final List<fr.cg95.cvq.business.request.social.HcarFamilyDependent> familyDependents) {
        this.familyDependents = familyDependents;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="handicap_compensation_adult_request_id"
        * @hibernate.list-index
        *  column="family_dependents_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.social.HcarFamilyDependent"
      
    */
    public final List<fr.cg95.cvq.business.request.social.HcarFamilyDependent> getFamilyDependents() {
        return this.familyDependents;
    }
  
    private Boolean isFamilyAssistance;

    public final void setIsFamilyAssistance(final Boolean isFamilyAssistance) {
        this.isFamilyAssistance = isFamilyAssistance;
    }

    /**
 
        * @hibernate.property
        *  column="is_family_assistance"
        
      
    */
    public final Boolean getIsFamilyAssistance() {
        return this.isFamilyAssistance;
    }
  
    private String projectComments;

    public final void setProjectComments(final String projectComments) {
        this.projectComments = projectComments;
    }

    /**
 
        * @hibernate.property
        *  column="project_comments"
        *  length="600"
      
    */
    public final String getProjectComments() {
        return this.projectComments;
    }
  
    private String foldersMdphDepartment;

    public final void setFoldersMdphDepartment(final String foldersMdphDepartment) {
        this.foldersMdphDepartment = foldersMdphDepartment;
    }

    /**
 
        * @hibernate.property
        *  column="folders_mdph_department"
        *  length="2"
      
    */
    public final String getFoldersMdphDepartment() {
        return this.foldersMdphDepartment;
    }
  
    private Boolean foldersCdes;

    public final void setFoldersCdes(final Boolean foldersCdes) {
        this.foldersCdes = foldersCdes;
    }

    /**
 
        * @hibernate.property
        *  column="folders_cdes"
        
      
    */
    public final Boolean getFoldersCdes() {
        return this.foldersCdes;
    }
  
    private String projectNeeds;

    public final void setProjectNeeds(final String projectNeeds) {
        this.projectNeeds = projectNeeds;
    }

    /**
 
        * @hibernate.property
        *  column="project_needs"
        *  length="600"
      
    */
    public final String getProjectNeeds() {
        return this.projectNeeds;
    }
  
    private Boolean benefitsEducationAllocationOfDisabledChildren;

    public final void setBenefitsEducationAllocationOfDisabledChildren(final Boolean benefitsEducationAllocationOfDisabledChildren) {
        this.benefitsEducationAllocationOfDisabledChildren = benefitsEducationAllocationOfDisabledChildren;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_education_allocation_of_disabled_children"
        
      
    */
    public final Boolean getBenefitsEducationAllocationOfDisabledChildren() {
        return this.benefitsEducationAllocationOfDisabledChildren;
    }
  
    private Boolean homeInterventionHomeIntervenant;

    public final void setHomeInterventionHomeIntervenant(final Boolean homeInterventionHomeIntervenant) {
        this.homeInterventionHomeIntervenant = homeInterventionHomeIntervenant;
    }

    /**
 
        * @hibernate.property
        *  column="home_intervention_home_intervenant"
        
      
    */
    public final Boolean getHomeInterventionHomeIntervenant() {
        return this.homeInterventionHomeIntervenant;
    }
  
    private List<fr.cg95.cvq.business.request.social.HcarOtherFolder> otherFolders;

    public final void setOtherFolders(final List<fr.cg95.cvq.business.request.social.HcarOtherFolder> otherFolders) {
        this.otherFolders = otherFolders;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="handicap_compensation_adult_request_id"
        * @hibernate.list-index
        *  column="other_folders_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.social.HcarOtherFolder"
      
    */
    public final List<fr.cg95.cvq.business.request.social.HcarOtherFolder> getOtherFolders() {
        return this.otherFolders;
    }
  
    private String foldersMdphNumber;

    public final void setFoldersMdphNumber(final String foldersMdphNumber) {
        this.foldersMdphNumber = foldersMdphNumber;
    }

    /**
 
        * @hibernate.property
        *  column="folders_mdph_number"
        *  length="30"
      
    */
    public final String getFoldersMdphNumber() {
        return this.foldersMdphNumber;
    }
  
    private Boolean projectRequestsHousingFacilities;

    public final void setProjectRequestsHousingFacilities(final Boolean projectRequestsHousingFacilities) {
        this.projectRequestsHousingFacilities = projectRequestsHousingFacilities;
    }

    /**
 
        * @hibernate.property
        *  column="project_requests_housing_facilities"
        
      
    */
    public final Boolean getProjectRequestsHousingFacilities() {
        return this.projectRequestsHousingFacilities;
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
  
    private Boolean benefitsDisabilityPension;

    public final void setBenefitsDisabilityPension(final Boolean benefitsDisabilityPension) {
        this.benefitsDisabilityPension = benefitsDisabilityPension;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_disability_pension"
        
      
    */
    public final Boolean getBenefitsDisabilityPension() {
        return this.benefitsDisabilityPension;
    }
  
    private Boolean legalAccessPresence;

    public final void setLegalAccessPresence(final Boolean legalAccessPresence) {
        this.legalAccessPresence = legalAccessPresence;
    }

    /**
 
        * @hibernate.property
        *  column="legal_access_presence"
        
      
    */
    public final Boolean getLegalAccessPresence() {
        return this.legalAccessPresence;
    }
  
    private String subjectMaidenName;

    public final void setSubjectMaidenName(final String subjectMaidenName) {
        this.subjectMaidenName = subjectMaidenName;
    }

    /**
 
        * @hibernate.property
        *  column="subject_maiden_name"
        *  length="38"
      
    */
    public final String getSubjectMaidenName() {
        return this.subjectMaidenName;
    }
  
    private Boolean projectRequestsDisabledWorkerRecognition;

    public final void setProjectRequestsDisabledWorkerRecognition(final Boolean projectRequestsDisabledWorkerRecognition) {
        this.projectRequestsDisabledWorkerRecognition = projectRequestsDisabledWorkerRecognition;
    }

    /**
 
        * @hibernate.property
        *  column="project_requests_disabled_worker_recognition"
        
      
    */
    public final Boolean getProjectRequestsDisabledWorkerRecognition() {
        return this.projectRequestsDisabledWorkerRecognition;
    }
  
    private Boolean benefitsUnemploymentBenefits;

    public final void setBenefitsUnemploymentBenefits(final Boolean benefitsUnemploymentBenefits) {
        this.benefitsUnemploymentBenefits = benefitsUnemploymentBenefits;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_unemployment_benefits"
        
      
    */
    public final Boolean getBenefitsUnemploymentBenefits() {
        return this.benefitsUnemploymentBenefits;
    }
  
    private List<fr.cg95.cvq.business.request.social.HcarHomeIntervenant> homeIntervenants;

    public final void setHomeIntervenants(final List<fr.cg95.cvq.business.request.social.HcarHomeIntervenant> homeIntervenants) {
        this.homeIntervenants = homeIntervenants;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="handicap_compensation_adult_request_id"
        * @hibernate.list-index
        *  column="home_intervenants_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.social.HcarHomeIntervenant"
      
    */
    public final List<fr.cg95.cvq.business.request.social.HcarHomeIntervenant> getHomeIntervenants() {
        return this.homeIntervenants;
    }
  
    private fr.cg95.cvq.business.request.social.HcarProfessionalStatusKindType professionalStatusKind;

    public final void setProfessionalStatusKind(final fr.cg95.cvq.business.request.social.HcarProfessionalStatusKindType professionalStatusKind) {
        this.professionalStatusKind = professionalStatusKind;
    }

    /**
 
        * @hibernate.property
        *  column="professional_status_kind"
        
      
    */
    public final fr.cg95.cvq.business.request.social.HcarProfessionalStatusKindType getProfessionalStatusKind() {
        return this.professionalStatusKind;
    }
  
    private Boolean familyFamilyDependents;

    public final void setFamilyFamilyDependents(final Boolean familyFamilyDependents) {
        this.familyFamilyDependents = familyFamilyDependents;
    }

    /**
 
        * @hibernate.property
        *  column="family_family_dependents"
        
      
    */
    public final Boolean getFamilyFamilyDependents() {
        return this.familyFamilyDependents;
    }
  
    private String formationPreviousFormation;

    public final void setFormationPreviousFormation(final String formationPreviousFormation) {
        this.formationPreviousFormation = formationPreviousFormation;
    }

    /**
 
        * @hibernate.property
        *  column="formation_previous_formation"
        *  length="180"
      
    */
    public final String getFormationPreviousFormation() {
        return this.formationPreviousFormation;
    }
  
    private String benefitsEducationOfDisabledChildrenDetails;

    public final void setBenefitsEducationOfDisabledChildrenDetails(final String benefitsEducationOfDisabledChildrenDetails) {
        this.benefitsEducationOfDisabledChildrenDetails = benefitsEducationOfDisabledChildrenDetails;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_education_of_disabled_children_details"
        *  length="60"
      
    */
    public final String getBenefitsEducationOfDisabledChildrenDetails() {
        return this.benefitsEducationOfDisabledChildrenDetails;
    }
  
    private Boolean projectRequestsVocationalTraining;

    public final void setProjectRequestsVocationalTraining(final Boolean projectRequestsVocationalTraining) {
        this.projectRequestsVocationalTraining = projectRequestsVocationalTraining;
    }

    /**
 
        * @hibernate.property
        *  column="project_requests_vocational_training"
        
      
    */
    public final Boolean getProjectRequestsVocationalTraining() {
        return this.projectRequestsVocationalTraining;
    }
  
    private Boolean facilitiesCustomCar;

    public final void setFacilitiesCustomCar(final Boolean facilitiesCustomCar) {
        this.facilitiesCustomCar = facilitiesCustomCar;
    }

    /**
 
        * @hibernate.property
        *  column="facilities_custom_car"
        
      
    */
    public final Boolean getFacilitiesCustomCar() {
        return this.facilitiesCustomCar;
    }
  
    private String legalAccessRepresentativeKindDetail;

    public final void setLegalAccessRepresentativeKindDetail(final String legalAccessRepresentativeKindDetail) {
        this.legalAccessRepresentativeKindDetail = legalAccessRepresentativeKindDetail;
    }

    /**
 
        * @hibernate.property
        *  column="legal_access_representative_kind_detail"
        *  length="80"
      
    */
    public final String getLegalAccessRepresentativeKindDetail() {
        return this.legalAccessRepresentativeKindDetail;
    }
  
    private Boolean professionalStatusIndemnified;

    public final void setProfessionalStatusIndemnified(final Boolean professionalStatusIndemnified) {
        this.professionalStatusIndemnified = professionalStatusIndemnified;
    }

    /**
 
        * @hibernate.property
        *  column="professional_status_indemnified"
        
      
    */
    public final Boolean getProfessionalStatusIndemnified() {
        return this.professionalStatusIndemnified;
    }
  
    private Boolean benefitsDisabledAdultAllocation;

    public final void setBenefitsDisabledAdultAllocation(final Boolean benefitsDisabledAdultAllocation) {
        this.benefitsDisabledAdultAllocation = benefitsDisabledAdultAllocation;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_disabled_adult_allocation"
        
      
    */
    public final Boolean getBenefitsDisabledAdultAllocation() {
        return this.benefitsDisabledAdultAllocation;
    }
  
    private Boolean benefitsThirdPartyCompensatoryAllowance;

    public final void setBenefitsThirdPartyCompensatoryAllowance(final Boolean benefitsThirdPartyCompensatoryAllowance) {
        this.benefitsThirdPartyCompensatoryAllowance = benefitsThirdPartyCompensatoryAllowance;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_third_party_compensatory_allowance"
        
      
    */
    public final Boolean getBenefitsThirdPartyCompensatoryAllowance() {
        return this.benefitsThirdPartyCompensatoryAllowance;
    }
  
    private java.util.Date professionalStatusDate;

    public final void setProfessionalStatusDate(final java.util.Date professionalStatusDate) {
        this.professionalStatusDate = professionalStatusDate;
    }

    /**
 
        * @hibernate.property
        *  column="professional_status_date"
        
      
    */
    public final java.util.Date getProfessionalStatusDate() {
        return this.professionalStatusDate;
    }
  
    private Boolean projectRequestsTransportCostAllocation;

    public final void setProjectRequestsTransportCostAllocation(final Boolean projectRequestsTransportCostAllocation) {
        this.projectRequestsTransportCostAllocation = projectRequestsTransportCostAllocation;
    }

    /**
 
        * @hibernate.property
        *  column="project_requests_transport_cost_allocation"
        
      
    */
    public final Boolean getProjectRequestsTransportCostAllocation() {
        return this.projectRequestsTransportCostAllocation;
    }
  
    private Boolean benefitsProfessionalOrientation;

    public final void setBenefitsProfessionalOrientation(final Boolean benefitsProfessionalOrientation) {
        this.benefitsProfessionalOrientation = benefitsProfessionalOrientation;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_professional_orientation"
        
      
    */
    public final Boolean getBenefitsProfessionalOrientation() {
        return this.benefitsProfessionalOrientation;
    }
  
    private Boolean benefitsDisabilityRecognition;

    public final void setBenefitsDisabilityRecognition(final Boolean benefitsDisabilityRecognition) {
        this.benefitsDisabilityRecognition = benefitsDisabilityRecognition;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_disability_recognition"
        
      
    */
    public final Boolean getBenefitsDisabilityRecognition() {
        return this.benefitsDisabilityRecognition;
    }
  
    private Boolean professionalStatusRegisterAsUnemployed;

    public final void setProfessionalStatusRegisterAsUnemployed(final Boolean professionalStatusRegisterAsUnemployed) {
        this.professionalStatusRegisterAsUnemployed = professionalStatusRegisterAsUnemployed;
    }

    /**
 
        * @hibernate.property
        *  column="professional_status_register_as_unemployed"
        
      
    */
    public final Boolean getProfessionalStatusRegisterAsUnemployed() {
        return this.professionalStatusRegisterAsUnemployed;
    }
  
    private String dwellingSocialReceptionNaming;

    public final void setDwellingSocialReceptionNaming(final String dwellingSocialReceptionNaming) {
        this.dwellingSocialReceptionNaming = dwellingSocialReceptionNaming;
    }

    /**
 
        * @hibernate.property
        *  column="dwelling_social_reception_naming"
        *  length="80"
      
    */
    public final String getDwellingSocialReceptionNaming() {
        return this.dwellingSocialReceptionNaming;
    }
  
    private java.util.Date professionalStatusIndemnifiedDate;

    public final void setProfessionalStatusIndemnifiedDate(final java.util.Date professionalStatusIndemnifiedDate) {
        this.professionalStatusIndemnifiedDate = professionalStatusIndemnifiedDate;
    }

    /**
 
        * @hibernate.property
        *  column="professional_status_indemnified_date"
        
      
    */
    public final java.util.Date getProfessionalStatusIndemnifiedDate() {
        return this.professionalStatusIndemnifiedDate;
    }
  
    private fr.cg95.cvq.business.users.FamilyStatusType familyStatus;

    public final void setFamilyStatus(final fr.cg95.cvq.business.users.FamilyStatusType familyStatus) {
        this.familyStatus = familyStatus;
    }

    /**
 
        * @hibernate.property
        *  column="family_status"
        
      
    */
    public final fr.cg95.cvq.business.users.FamilyStatusType getFamilyStatus() {
        return this.familyStatus;
    }
  
    private Boolean benefitsPainfulStandingCard;

    public final void setBenefitsPainfulStandingCard(final Boolean benefitsPainfulStandingCard) {
        this.benefitsPainfulStandingCard = benefitsPainfulStandingCard;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_painful_standing_card"
        
      
    */
    public final Boolean getBenefitsPainfulStandingCard() {
        return this.benefitsPainfulStandingCard;
    }
  
    private String benefitsProfessionalOrientationDetails;

    public final void setBenefitsProfessionalOrientationDetails(final String benefitsProfessionalOrientationDetails) {
        this.benefitsProfessionalOrientationDetails = benefitsProfessionalOrientationDetails;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_professional_orientation_details"
        *  length="60"
      
    */
    public final String getBenefitsProfessionalOrientationDetails() {
        return this.benefitsProfessionalOrientationDetails;
    }
  
    private String foldersCdesDepartment;

    public final void setFoldersCdesDepartment(final String foldersCdesDepartment) {
        this.foldersCdesDepartment = foldersCdesDepartment;
    }

    /**
 
        * @hibernate.property
        *  column="folders_cdes_department"
        *  length="2"
      
    */
    public final String getFoldersCdesDepartment() {
        return this.foldersCdesDepartment;
    }
  
    private Boolean facilitiesSpecializedTransport;

    public final void setFacilitiesSpecializedTransport(final Boolean facilitiesSpecializedTransport) {
        this.facilitiesSpecializedTransport = facilitiesSpecializedTransport;
    }

    /**
 
        * @hibernate.property
        *  column="facilities_specialized_transport"
        
      
    */
    public final Boolean getFacilitiesSpecializedTransport() {
        return this.facilitiesSpecializedTransport;
    }
  
    private Boolean benefitsParkingCard;

    public final void setBenefitsParkingCard(final Boolean benefitsParkingCard) {
        this.benefitsParkingCard = benefitsParkingCard;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_parking_card"
        
      
    */
    public final Boolean getBenefitsParkingCard() {
        return this.benefitsParkingCard;
    }
  
    private String facilitiesSpecializedTransportDetails;

    public final void setFacilitiesSpecializedTransportDetails(final String facilitiesSpecializedTransportDetails) {
        this.facilitiesSpecializedTransportDetails = facilitiesSpecializedTransportDetails;
    }

    /**
 
        * @hibernate.property
        *  column="facilities_specialized_transport_details"
        *  length="60"
      
    */
    public final String getFacilitiesSpecializedTransportDetails() {
        return this.facilitiesSpecializedTransportDetails;
    }
  
    private Boolean professionalSupportSocialServiceSupport;

    public final void setProfessionalSupportSocialServiceSupport(final Boolean professionalSupportSocialServiceSupport) {
        this.professionalSupportSocialServiceSupport = professionalSupportSocialServiceSupport;
    }

    /**
 
        * @hibernate.property
        *  column="professional_support_social_service_support"
        
      
    */
    public final Boolean getProfessionalSupportSocialServiceSupport() {
        return this.professionalSupportSocialServiceSupport;
    }
  
    private String socialSecurityNumber;

    public final void setSocialSecurityNumber(final String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    /**
 
        * @hibernate.property
        *  column="social_security_number"
        *  length="13"
      
    */
    public final String getSocialSecurityNumber() {
        return this.socialSecurityNumber;
    }
  
    private String benefitsWorkAccidentAnnuityRatio;

    public final void setBenefitsWorkAccidentAnnuityRatio(final String benefitsWorkAccidentAnnuityRatio) {
        this.benefitsWorkAccidentAnnuityRatio = benefitsWorkAccidentAnnuityRatio;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_work_accident_annuity_ratio"
        *  length="3"
      
    */
    public final String getBenefitsWorkAccidentAnnuityRatio() {
        return this.benefitsWorkAccidentAnnuityRatio;
    }
  
    private Boolean benefitsWorkAccidentAnnuity;

    public final void setBenefitsWorkAccidentAnnuity(final Boolean benefitsWorkAccidentAnnuity) {
        this.benefitsWorkAccidentAnnuity = benefitsWorkAccidentAnnuity;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_work_accident_annuity"
        
      
    */
    public final Boolean getBenefitsWorkAccidentAnnuity() {
        return this.benefitsWorkAccidentAnnuity;
    }
  
    private Boolean careCareServices;

    public final void setCareCareServices(final Boolean careCareServices) {
        this.careCareServices = careCareServices;
    }

    /**
 
        * @hibernate.property
        *  column="care_care_services"
        
      
    */
    public final Boolean getCareCareServices() {
        return this.careCareServices;
    }
  
    private String benefitsDisabilityRatio;

    public final void setBenefitsDisabilityRatio(final String benefitsDisabilityRatio) {
        this.benefitsDisabilityRatio = benefitsDisabilityRatio;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_disability_ratio"
        *  length="3"
      
    */
    public final String getBenefitsDisabilityRatio() {
        return this.benefitsDisabilityRatio;
    }
  
    private Boolean benefitsDailyAllowances;

    public final void setBenefitsDailyAllowances(final Boolean benefitsDailyAllowances) {
        this.benefitsDailyAllowances = benefitsDailyAllowances;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_daily_allowances"
        
      
    */
    public final Boolean getBenefitsDailyAllowances() {
        return this.benefitsDailyAllowances;
    }
  
    private Boolean projectRequestsCustomCar;

    public final void setProjectRequestsCustomCar(final Boolean projectRequestsCustomCar) {
        this.projectRequestsCustomCar = projectRequestsCustomCar;
    }

    /**
 
        * @hibernate.property
        *  column="project_requests_custom_car"
        
      
    */
    public final Boolean getProjectRequestsCustomCar() {
        return this.projectRequestsCustomCar;
    }
  
    private String paymentAgencyBeneficiaryNumber;

    public final void setPaymentAgencyBeneficiaryNumber(final String paymentAgencyBeneficiaryNumber) {
        this.paymentAgencyBeneficiaryNumber = paymentAgencyBeneficiaryNumber;
    }

    /**
 
        * @hibernate.property
        *  column="payment_agency_beneficiary_number"
        *  length="20"
      
    */
    public final String getPaymentAgencyBeneficiaryNumber() {
        return this.paymentAgencyBeneficiaryNumber;
    }
  
    private String foldersCotorepNumber;

    public final void setFoldersCotorepNumber(final String foldersCotorepNumber) {
        this.foldersCotorepNumber = foldersCotorepNumber;
    }

    /**
 
        * @hibernate.property
        *  column="folders_cotorep_number"
        *  length="30"
      
    */
    public final String getFoldersCotorepNumber() {
        return this.foldersCotorepNumber;
    }
  
    private Boolean projectRequestsACTPRenewal;

    public final void setProjectRequestsACTPRenewal(final Boolean projectRequestsACTPRenewal) {
        this.projectRequestsACTPRenewal = projectRequestsACTPRenewal;
    }

    /**
 
        * @hibernate.property
        *  column="project_requests_a_c_t_p_renewal"
        
      
    */
    public final Boolean getProjectRequestsACTPRenewal() {
        return this.projectRequestsACTPRenewal;
    }
  
    private fr.cg95.cvq.business.users.Address dwellingSocialReceptionAddress;

    public final void setDwellingSocialReceptionAddress(final fr.cg95.cvq.business.users.Address dwellingSocialReceptionAddress) {
        this.dwellingSocialReceptionAddress = dwellingSocialReceptionAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="dwelling_social_reception_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getDwellingSocialReceptionAddress() {
        return this.dwellingSocialReceptionAddress;
    }
  
    private Boolean foldersMdph;

    public final void setFoldersMdph(final Boolean foldersMdph) {
        this.foldersMdph = foldersMdph;
    }

    /**
 
        * @hibernate.property
        *  column="folders_mdph"
        
      
    */
    public final Boolean getFoldersMdph() {
        return this.foldersMdph;
    }
  
    private String benefitsSupportedByAnInstitutionDetails;

    public final void setBenefitsSupportedByAnInstitutionDetails(final String benefitsSupportedByAnInstitutionDetails) {
        this.benefitsSupportedByAnInstitutionDetails = benefitsSupportedByAnInstitutionDetails;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_supported_by_an_institution_details"
        *  length="60"
      
    */
    public final String getBenefitsSupportedByAnInstitutionDetails() {
        return this.benefitsSupportedByAnInstitutionDetails;
    }
  
    private Boolean professionalSupportDealsWithSameProfessional;

    public final void setProfessionalSupportDealsWithSameProfessional(final Boolean professionalSupportDealsWithSameProfessional) {
        this.professionalSupportDealsWithSameProfessional = professionalSupportDealsWithSameProfessional;
    }

    /**
 
        * @hibernate.property
        *  column="professional_support_deals_with_same_professional"
        
      
    */
    public final Boolean getProfessionalSupportDealsWithSameProfessional() {
        return this.professionalSupportDealsWithSameProfessional;
    }
  
    private Boolean dwellingEstablishmentReception;

    public final void setDwellingEstablishmentReception(final Boolean dwellingEstablishmentReception) {
        this.dwellingEstablishmentReception = dwellingEstablishmentReception;
    }

    /**
 
        * @hibernate.property
        *  column="dwelling_establishment_reception"
        
      
    */
    public final Boolean getDwellingEstablishmentReception() {
        return this.dwellingEstablishmentReception;
    }
  
    private String foldersCotorepDepartment;

    public final void setFoldersCotorepDepartment(final String foldersCotorepDepartment) {
        this.foldersCotorepDepartment = foldersCotorepDepartment;
    }

    /**
 
        * @hibernate.property
        *  column="folders_cotorep_department"
        *  length="2"
      
    */
    public final String getFoldersCotorepDepartment() {
        return this.foldersCotorepDepartment;
    }
  
    private List<fr.cg95.cvq.business.request.social.HcarAdditionalFee> additionalFee;

    public final void setAdditionalFee(final List<fr.cg95.cvq.business.request.social.HcarAdditionalFee> additionalFee) {
        this.additionalFee = additionalFee;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="handicap_compensation_adult_request_id"
        * @hibernate.list-index
        *  column="additional_fee_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.social.HcarAdditionalFee"
      
    */
    public final List<fr.cg95.cvq.business.request.social.HcarAdditionalFee> getAdditionalFee() {
        return this.additionalFee;
    }
  
    private Boolean projectRequestsOrdinaryWorking;

    public final void setProjectRequestsOrdinaryWorking(final Boolean projectRequestsOrdinaryWorking) {
        this.projectRequestsOrdinaryWorking = projectRequestsOrdinaryWorking;
    }

    /**
 
        * @hibernate.property
        *  column="project_requests_ordinary_working"
        
      
    */
    public final Boolean getProjectRequestsOrdinaryWorking() {
        return this.projectRequestsOrdinaryWorking;
    }
  
    private String legalAccessRepresentativeFirstName;

    public final void setLegalAccessRepresentativeFirstName(final String legalAccessRepresentativeFirstName) {
        this.legalAccessRepresentativeFirstName = legalAccessRepresentativeFirstName;
    }

    /**
 
        * @hibernate.property
        *  column="legal_access_representative_first_name"
        *  length="38"
      
    */
    public final String getLegalAccessRepresentativeFirstName() {
        return this.legalAccessRepresentativeFirstName;
    }
  
    private Boolean dwellingSocialReception;

    public final void setDwellingSocialReception(final Boolean dwellingSocialReception) {
        this.dwellingSocialReception = dwellingSocialReception;
    }

    /**
 
        * @hibernate.property
        *  column="dwelling_social_reception"
        
      
    */
    public final Boolean getDwellingSocialReception() {
        return this.dwellingSocialReception;
    }
  
    private Boolean benefitsDisabledWorkerRecognition;

    public final void setBenefitsDisabledWorkerRecognition(final Boolean benefitsDisabledWorkerRecognition) {
        this.benefitsDisabledWorkerRecognition = benefitsDisabledWorkerRecognition;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_disabled_worker_recognition"
        
      
    */
    public final Boolean getBenefitsDisabledWorkerRecognition() {
        return this.benefitsDisabledWorkerRecognition;
    }
  
    private Boolean projectRequestsEuropeanParkingCard;

    public final void setProjectRequestsEuropeanParkingCard(final Boolean projectRequestsEuropeanParkingCard) {
        this.projectRequestsEuropeanParkingCard = projectRequestsEuropeanParkingCard;
    }

    /**
 
        * @hibernate.property
        *  column="project_requests_european_parking_card"
        
      
    */
    public final Boolean getProjectRequestsEuropeanParkingCard() {
        return this.projectRequestsEuropeanParkingCard;
    }
  
    private Boolean healthFollowedByDoctor;

    public final void setHealthFollowedByDoctor(final Boolean healthFollowedByDoctor) {
        this.healthFollowedByDoctor = healthFollowedByDoctor;
    }

    /**
 
        * @hibernate.property
        *  column="health_followed_by_doctor"
        
      
    */
    public final Boolean getHealthFollowedByDoctor() {
        return this.healthFollowedByDoctor;
    }
  
    private List<fr.cg95.cvq.business.request.social.HcarFamilyAssistanceMember> familyAssistanceMembers;

    public final void setFamilyAssistanceMembers(final List<fr.cg95.cvq.business.request.social.HcarFamilyAssistanceMember> familyAssistanceMembers) {
        this.familyAssistanceMembers = familyAssistanceMembers;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="handicap_compensation_adult_request_id"
        * @hibernate.list-index
        *  column="family_assistance_members_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.social.HcarFamilyAssistanceMember"
      
    */
    public final List<fr.cg95.cvq.business.request.social.HcarFamilyAssistanceMember> getFamilyAssistanceMembers() {
        return this.familyAssistanceMembers;
    }
  
    private Boolean projectRequestsFreePensionMembership;

    public final void setProjectRequestsFreePensionMembership(final Boolean projectRequestsFreePensionMembership) {
        this.projectRequestsFreePensionMembership = projectRequestsFreePensionMembership;
    }

    /**
 
        * @hibernate.property
        *  column="project_requests_free_pension_membership"
        
      
    */
    public final Boolean getProjectRequestsFreePensionMembership() {
        return this.projectRequestsFreePensionMembership;
    }
  
    private List<fr.cg95.cvq.business.request.social.HcarProfessional> professionals;

    public final void setProfessionals(final List<fr.cg95.cvq.business.request.social.HcarProfessional> professionals) {
        this.professionals = professionals;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="handicap_compensation_adult_request_id"
        * @hibernate.list-index
        *  column="professionals_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.social.HcarProfessional"
      
    */
    public final List<fr.cg95.cvq.business.request.social.HcarProfessional> getProfessionals() {
        return this.professionals;
    }
  
    private Boolean healthFollowedByHospital;

    public final void setHealthFollowedByHospital(final Boolean healthFollowedByHospital) {
        this.healthFollowedByHospital = healthFollowedByHospital;
    }

    /**
 
        * @hibernate.property
        *  column="health_followed_by_hospital"
        
      
    */
    public final Boolean getHealthFollowedByHospital() {
        return this.healthFollowedByHospital;
    }
  
    private String professionalStatusEmployerName;

    public final void setProfessionalStatusEmployerName(final String professionalStatusEmployerName) {
        this.professionalStatusEmployerName = professionalStatusEmployerName;
    }

    /**
 
        * @hibernate.property
        *  column="professional_status_employer_name"
        *  length="38"
      
    */
    public final String getProfessionalStatusEmployerName() {
        return this.professionalStatusEmployerName;
    }
  
    private Boolean projectRequestsInstitutionSupport;

    public final void setProjectRequestsInstitutionSupport(final Boolean projectRequestsInstitutionSupport) {
        this.projectRequestsInstitutionSupport = projectRequestsInstitutionSupport;
    }

    /**
 
        * @hibernate.property
        *  column="project_requests_institution_support"
        
      
    */
    public final Boolean getProjectRequestsInstitutionSupport() {
        return this.projectRequestsInstitutionSupport;
    }
  
    private Boolean benefitsSocialWelfare;

    public final void setBenefitsSocialWelfare(final Boolean benefitsSocialWelfare) {
        this.benefitsSocialWelfare = benefitsSocialWelfare;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_social_welfare"
        
      
    */
    public final Boolean getBenefitsSocialWelfare() {
        return this.benefitsSocialWelfare;
    }
  
    private Boolean projectRequestsHandicapRecognition;

    public final void setProjectRequestsHandicapRecognition(final Boolean projectRequestsHandicapRecognition) {
        this.projectRequestsHandicapRecognition = projectRequestsHandicapRecognition;
    }

    /**
 
        * @hibernate.property
        *  column="project_requests_handicap_recognition"
        
      
    */
    public final Boolean getProjectRequestsHandicapRecognition() {
        return this.projectRequestsHandicapRecognition;
    }
  
    private List<fr.cg95.cvq.business.request.social.HcarCareService> careServices;

    public final void setCareServices(final List<fr.cg95.cvq.business.request.social.HcarCareService> careServices) {
        this.careServices = careServices;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="handicap_compensation_adult_request_id"
        * @hibernate.list-index
        *  column="care_services_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.social.HcarCareService"
      
    */
    public final List<fr.cg95.cvq.business.request.social.HcarCareService> getCareServices() {
        return this.careServices;
    }
  
    private String projectWish;

    public final void setProjectWish(final String projectWish) {
        this.projectWish = projectWish;
    }

    /**
 
        * @hibernate.property
        *  column="project_wish"
        *  length="600"
      
    */
    public final String getProjectWish() {
        return this.projectWish;
    }
  
    private fr.cg95.cvq.business.request.social.HcarDwellingKindType dwellingKind;

    public final void setDwellingKind(final fr.cg95.cvq.business.request.social.HcarDwellingKindType dwellingKind) {
        this.dwellingKind = dwellingKind;
    }

    /**
 
        * @hibernate.property
        *  column="dwelling_kind"
        
      
    */
    public final fr.cg95.cvq.business.request.social.HcarDwellingKindType getDwellingKind() {
        return this.dwellingKind;
    }
  
    private String healthProfessionalLastName;

    public final void setHealthProfessionalLastName(final String healthProfessionalLastName) {
        this.healthProfessionalLastName = healthProfessionalLastName;
    }

    /**
 
        * @hibernate.property
        *  column="health_professional_last_name"
        *  length="38"
      
    */
    public final String getHealthProfessionalLastName() {
        return this.healthProfessionalLastName;
    }
  
    private String formationStudiesLevel;

    public final void setFormationStudiesLevel(final String formationStudiesLevel) {
        this.formationStudiesLevel = formationStudiesLevel;
    }

    /**
 
        * @hibernate.property
        *  column="formation_studies_level"
        *  length="30"
      
    */
    public final String getFormationStudiesLevel() {
        return this.formationStudiesLevel;
    }
  
    private Boolean projectRequestsProfessionalOrientation;

    public final void setProjectRequestsProfessionalOrientation(final Boolean projectRequestsProfessionalOrientation) {
        this.projectRequestsProfessionalOrientation = projectRequestsProfessionalOrientation;
    }

    /**
 
        * @hibernate.property
        *  column="project_requests_professional_orientation"
        
      
    */
    public final Boolean getProjectRequestsProfessionalOrientation() {
        return this.projectRequestsProfessionalOrientation;
    }
  
    private String healthDoctorLastName;

    public final void setHealthDoctorLastName(final String healthDoctorLastName) {
        this.healthDoctorLastName = healthDoctorLastName;
    }

    /**
 
        * @hibernate.property
        *  column="health_doctor_last_name"
        *  length="38"
      
    */
    public final String getHealthDoctorLastName() {
        return this.healthDoctorLastName;
    }
  
    private fr.cg95.cvq.business.request.social.HcarLegalAccessKindType legalAccessKind;

    public final void setLegalAccessKind(final fr.cg95.cvq.business.request.social.HcarLegalAccessKindType legalAccessKind) {
        this.legalAccessKind = legalAccessKind;
    }

    /**
 
        * @hibernate.property
        *  column="legal_access_kind"
        
      
    */
    public final fr.cg95.cvq.business.request.social.HcarLegalAccessKindType getLegalAccessKind() {
        return this.legalAccessKind;
    }
  
    private String facilitiesHousingDetails;

    public final void setFacilitiesHousingDetails(final String facilitiesHousingDetails) {
        this.facilitiesHousingDetails = facilitiesHousingDetails;
    }

    /**
 
        * @hibernate.property
        *  column="facilities_housing_details"
        *  length="60"
      
    */
    public final String getFacilitiesHousingDetails() {
        return this.facilitiesHousingDetails;
    }
  
    private Boolean benefitsSupplementForSingleParents;

    public final void setBenefitsSupplementForSingleParents(final Boolean benefitsSupplementForSingleParents) {
        this.benefitsSupplementForSingleParents = benefitsSupplementForSingleParents;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_supplement_for_single_parents"
        
      
    */
    public final Boolean getBenefitsSupplementForSingleParents() {
        return this.benefitsSupplementForSingleParents;
    }
  
    private Boolean projectRequestsIncreaseForIndependentLiving;

    public final void setProjectRequestsIncreaseForIndependentLiving(final Boolean projectRequestsIncreaseForIndependentLiving) {
        this.projectRequestsIncreaseForIndependentLiving = projectRequestsIncreaseForIndependentLiving;
    }

    /**
 
        * @hibernate.property
        *  column="project_requests_increase_for_independent_living"
        
      
    */
    public final Boolean getProjectRequestsIncreaseForIndependentLiving() {
        return this.projectRequestsIncreaseForIndependentLiving;
    }
  
    private String benefitsDisabilityPensionCategory;

    public final void setBenefitsDisabilityPensionCategory(final String benefitsDisabilityPensionCategory) {
        this.benefitsDisabilityPensionCategory = benefitsDisabilityPensionCategory;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_disability_pension_category"
        *  length="60"
      
    */
    public final String getBenefitsDisabilityPensionCategory() {
        return this.benefitsDisabilityPensionCategory;
    }
  
    private Boolean benefitsThirdPartySupplement;

    public final void setBenefitsThirdPartySupplement(final Boolean benefitsThirdPartySupplement) {
        this.benefitsThirdPartySupplement = benefitsThirdPartySupplement;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_third_party_supplement"
        
      
    */
    public final Boolean getBenefitsThirdPartySupplement() {
        return this.benefitsThirdPartySupplement;
    }
  
    private String studiesHighSchoolGrade;

    public final void setStudiesHighSchoolGrade(final String studiesHighSchoolGrade) {
        this.studiesHighSchoolGrade = studiesHighSchoolGrade;
    }

    /**
 
        * @hibernate.property
        *  column="studies_high_school_grade"
        *  length="60"
      
    */
    public final String getStudiesHighSchoolGrade() {
        return this.studiesHighSchoolGrade;
    }
  
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
  
    private String legalAccessRepresentativeName;

    public final void setLegalAccessRepresentativeName(final String legalAccessRepresentativeName) {
        this.legalAccessRepresentativeName = legalAccessRepresentativeName;
    }

    /**
 
        * @hibernate.property
        *  column="legal_access_representative_name"
        *  length="38"
      
    */
    public final String getLegalAccessRepresentativeName() {
        return this.legalAccessRepresentativeName;
    }
  
    private Boolean projectRequestsAssistance;

    public final void setProjectRequestsAssistance(final Boolean projectRequestsAssistance) {
        this.projectRequestsAssistance = projectRequestsAssistance;
    }

    /**
 
        * @hibernate.property
        *  column="project_requests_assistance"
        
      
    */
    public final Boolean getProjectRequestsAssistance() {
        return this.projectRequestsAssistance;
    }
  
    private fr.cg95.cvq.business.request.social.HcarProfessionalStatusEnvironmentType professionalStatusEnvironment;

    public final void setProfessionalStatusEnvironment(final fr.cg95.cvq.business.request.social.HcarProfessionalStatusEnvironmentType professionalStatusEnvironment) {
        this.professionalStatusEnvironment = professionalStatusEnvironment;
    }

    /**
 
        * @hibernate.property
        *  column="professional_status_environment"
        
      
    */
    public final fr.cg95.cvq.business.request.social.HcarProfessionalStatusEnvironmentType getProfessionalStatusEnvironment() {
        return this.professionalStatusEnvironment;
    }
  
    private Boolean benefitsSupportedByAnInstitution;

    public final void setBenefitsSupportedByAnInstitution(final Boolean benefitsSupportedByAnInstitution) {
        this.benefitsSupportedByAnInstitution = benefitsSupportedByAnInstitution;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_supported_by_an_institution"
        
      
    */
    public final Boolean getBenefitsSupportedByAnInstitution() {
        return this.benefitsSupportedByAnInstitution;
    }
  
    private Boolean projectRequestsThirdPartyHelp;

    public final void setProjectRequestsThirdPartyHelp(final Boolean projectRequestsThirdPartyHelp) {
        this.projectRequestsThirdPartyHelp = projectRequestsThirdPartyHelp;
    }

    /**
 
        * @hibernate.property
        *  column="project_requests_third_party_help"
        
      
    */
    public final Boolean getProjectRequestsThirdPartyHelp() {
        return this.projectRequestsThirdPartyHelp;
    }
  
    private Boolean projectRequestsDisabledAdultAllowance;

    public final void setProjectRequestsDisabledAdultAllowance(final Boolean projectRequestsDisabledAdultAllowance) {
        this.projectRequestsDisabledAdultAllowance = projectRequestsDisabledAdultAllowance;
    }

    /**
 
        * @hibernate.property
        *  column="project_requests_disabled_adult_allowance"
        
      
    */
    public final Boolean getProjectRequestsDisabledAdultAllowance() {
        return this.projectRequestsDisabledAdultAllowance;
    }
  
    private fr.cg95.cvq.business.request.social.HcarPaymentAgencyBeneficiaryType paymentAgencyBeneficiary;

    public final void setPaymentAgencyBeneficiary(final fr.cg95.cvq.business.request.social.HcarPaymentAgencyBeneficiaryType paymentAgencyBeneficiary) {
        this.paymentAgencyBeneficiary = paymentAgencyBeneficiary;
    }

    /**
 
        * @hibernate.property
        *  column="payment_agency_beneficiary"
        
      
    */
    public final fr.cg95.cvq.business.request.social.HcarPaymentAgencyBeneficiaryType getPaymentAgencyBeneficiary() {
        return this.paymentAgencyBeneficiary;
    }
  
    private Boolean foldersOtherFolders;

    public final void setFoldersOtherFolders(final Boolean foldersOtherFolders) {
        this.foldersOtherFolders = foldersOtherFolders;
    }

    /**
 
        * @hibernate.property
        *  column="folders_other_folders"
        
      
    */
    public final Boolean getFoldersOtherFolders() {
        return this.foldersOtherFolders;
    }
  
    private String facilitiesAnimalAidDetails;

    public final void setFacilitiesAnimalAidDetails(final String facilitiesAnimalAidDetails) {
        this.facilitiesAnimalAidDetails = facilitiesAnimalAidDetails;
    }

    /**
 
        * @hibernate.property
        *  column="facilities_animal_aid_details"
        *  length="60"
      
    */
    public final String getFacilitiesAnimalAidDetails() {
        return this.facilitiesAnimalAidDetails;
    }
  
    private String studiesAssistanceUnderDisabilityDetails;

    public final void setStudiesAssistanceUnderDisabilityDetails(final String studiesAssistanceUnderDisabilityDetails) {
        this.studiesAssistanceUnderDisabilityDetails = studiesAssistanceUnderDisabilityDetails;
    }

    /**
 
        * @hibernate.property
        *  column="studies_assistance_under_disability_details"
        *  length="60"
      
    */
    public final String getStudiesAssistanceUnderDisabilityDetails() {
        return this.studiesAssistanceUnderDisabilityDetails;
    }
  
    private List<fr.cg95.cvq.business.request.social.HcarOtherBenefit> otherBenefits;

    public final void setOtherBenefits(final List<fr.cg95.cvq.business.request.social.HcarOtherBenefit> otherBenefits) {
        this.otherBenefits = otherBenefits;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="handicap_compensation_adult_request_id"
        * @hibernate.list-index
        *  column="other_benefits_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.social.HcarOtherBenefit"
      
    */
    public final List<fr.cg95.cvq.business.request.social.HcarOtherBenefit> getOtherBenefits() {
        return this.otherBenefits;
    }
  
    private fr.cg95.cvq.business.users.Address paymentAgencyAddress;

    public final void setPaymentAgencyAddress(final fr.cg95.cvq.business.users.Address paymentAgencyAddress) {
        this.paymentAgencyAddress = paymentAgencyAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="payment_agency_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getPaymentAgencyAddress() {
        return this.paymentAgencyAddress;
    }
  
    private Boolean projectRequestsOther;

    public final void setProjectRequestsOther(final Boolean projectRequestsOther) {
        this.projectRequestsOther = projectRequestsOther;
    }

    /**
 
        * @hibernate.property
        *  column="project_requests_other"
        
      
    */
    public final Boolean getProjectRequestsOther() {
        return this.projectRequestsOther;
    }
  
    private Boolean benefitsThirdPersonCompensatoryAllowance;

    public final void setBenefitsThirdPersonCompensatoryAllowance(final Boolean benefitsThirdPersonCompensatoryAllowance) {
        this.benefitsThirdPersonCompensatoryAllowance = benefitsThirdPersonCompensatoryAllowance;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_third_person_compensatory_allowance"
        
      
    */
    public final Boolean getBenefitsThirdPersonCompensatoryAllowance() {
        return this.benefitsThirdPersonCompensatoryAllowance;
    }
  
    private Boolean projectRequestsDisabilityCostAllocation;

    public final void setProjectRequestsDisabilityCostAllocation(final Boolean projectRequestsDisabilityCostAllocation) {
        this.projectRequestsDisabilityCostAllocation = projectRequestsDisabilityCostAllocation;
    }

    /**
 
        * @hibernate.property
        *  column="project_requests_disability_cost_allocation"
        
      
    */
    public final Boolean getProjectRequestsDisabilityCostAllocation() {
        return this.projectRequestsDisabilityCostAllocation;
    }
  
    private fr.cg95.cvq.business.users.Address socialSecurityAgencyAddress;

    public final void setSocialSecurityAgencyAddress(final fr.cg95.cvq.business.users.Address socialSecurityAgencyAddress) {
        this.socialSecurityAgencyAddress = socialSecurityAgencyAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="social_security_agency_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getSocialSecurityAgencyAddress() {
        return this.socialSecurityAgencyAddress;
    }
  
    private fr.cg95.cvq.business.users.Address dwellingReceptionAddress;

    public final void setDwellingReceptionAddress(final fr.cg95.cvq.business.users.Address dwellingReceptionAddress) {
        this.dwellingReceptionAddress = dwellingReceptionAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="dwelling_reception_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getDwellingReceptionAddress() {
        return this.dwellingReceptionAddress;
    }
  
    private String professionalStatusProfession;

    public final void setProfessionalStatusProfession(final String professionalStatusProfession) {
        this.professionalStatusProfession = professionalStatusProfession;
    }

    /**
 
        * @hibernate.property
        *  column="professional_status_profession"
        *  length="60"
      
    */
    public final String getProfessionalStatusProfession() {
        return this.professionalStatusProfession;
    }
  
    private fr.cg95.cvq.business.users.Address professionalStatusAddress;

    public final void setProfessionalStatusAddress(final fr.cg95.cvq.business.users.Address professionalStatusAddress) {
        this.professionalStatusAddress = professionalStatusAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="professional_status_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getProfessionalStatusAddress() {
        return this.professionalStatusAddress;
    }
  
    private String formationDiploma;

    public final void setFormationDiploma(final String formationDiploma) {
        this.formationDiploma = formationDiploma;
    }

    /**
 
        * @hibernate.property
        *  column="formation_diploma"
        *  length="120"
      
    */
    public final String getFormationDiploma() {
        return this.formationDiploma;
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
  
    private Boolean professionalStatusElectiveFunction;

    public final void setProfessionalStatusElectiveFunction(final Boolean professionalStatusElectiveFunction) {
        this.professionalStatusElectiveFunction = professionalStatusElectiveFunction;
    }

    /**
 
        * @hibernate.property
        *  column="professional_status_elective_function"
        
      
    */
    public final Boolean getProfessionalStatusElectiveFunction() {
        return this.professionalStatusElectiveFunction;
    }
  
    private Boolean foldersCotorep;

    public final void setFoldersCotorep(final Boolean foldersCotorep) {
        this.foldersCotorep = foldersCotorep;
    }

    /**
 
        * @hibernate.property
        *  column="folders_cotorep"
        
      
    */
    public final Boolean getFoldersCotorep() {
        return this.foldersCotorep;
    }
  
    private Boolean benefitsIncreaseForIndependentLiving;

    public final void setBenefitsIncreaseForIndependentLiving(final Boolean benefitsIncreaseForIndependentLiving) {
        this.benefitsIncreaseForIndependentLiving = benefitsIncreaseForIndependentLiving;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_increase_for_independent_living"
        
      
    */
    public final Boolean getBenefitsIncreaseForIndependentLiving() {
        return this.benefitsIncreaseForIndependentLiving;
    }
  
    private String subjectBirthCountry;

    public final void setSubjectBirthCountry(final String subjectBirthCountry) {
        this.subjectBirthCountry = subjectBirthCountry;
    }

    /**
 
        * @hibernate.property
        *  column="subject_birth_country"
        *  length="50"
      
    */
    public final String getSubjectBirthCountry() {
        return this.subjectBirthCountry;
    }
  
    private Boolean projectRequestsDisabilityCard;

    public final void setProjectRequestsDisabilityCard(final Boolean projectRequestsDisabilityCard) {
        this.projectRequestsDisabilityCard = projectRequestsDisabilityCard;
    }

    /**
 
        * @hibernate.property
        *  column="project_requests_disability_card"
        
      
    */
    public final Boolean getProjectRequestsDisabilityCard() {
        return this.projectRequestsDisabilityCard;
    }
  
    private String studiesHighSchoolName;

    public final void setStudiesHighSchoolName(final String studiesHighSchoolName) {
        this.studiesHighSchoolName = studiesHighSchoolName;
    }

    /**
 
        * @hibernate.property
        *  column="studies_high_school_name"
        *  length="60"
      
    */
    public final String getStudiesHighSchoolName() {
        return this.studiesHighSchoolName;
    }
  
    private fr.cg95.cvq.business.request.social.HcarDwellingReceptionKindType dwellingReceptionType;

    public final void setDwellingReceptionType(final fr.cg95.cvq.business.request.social.HcarDwellingReceptionKindType dwellingReceptionType) {
        this.dwellingReceptionType = dwellingReceptionType;
    }

    /**
 
        * @hibernate.property
        *  column="dwelling_reception_type"
        
      
    */
    public final fr.cg95.cvq.business.request.social.HcarDwellingReceptionKindType getDwellingReceptionType() {
        return this.dwellingReceptionType;
    }
  
    private java.util.Date professionalStatusRegisterAsUnemployedDate;

    public final void setProfessionalStatusRegisterAsUnemployedDate(final java.util.Date professionalStatusRegisterAsUnemployedDate) {
        this.professionalStatusRegisterAsUnemployedDate = professionalStatusRegisterAsUnemployedDate;
    }

    /**
 
        * @hibernate.property
        *  column="professional_status_register_as_unemployed_date"
        
      
    */
    public final java.util.Date getProfessionalStatusRegisterAsUnemployedDate() {
        return this.professionalStatusRegisterAsUnemployedDate;
    }
  
    private String paymentAgencyName;

    public final void setPaymentAgencyName(final String paymentAgencyName) {
        this.paymentAgencyName = paymentAgencyName;
    }

    /**
 
        * @hibernate.property
        *  column="payment_agency_name"
        *  length="50"
      
    */
    public final String getPaymentAgencyName() {
        return this.paymentAgencyName;
    }
  
    private String dwellingReceptionNaming;

    public final void setDwellingReceptionNaming(final String dwellingReceptionNaming) {
        this.dwellingReceptionNaming = dwellingReceptionNaming;
    }

    /**
 
        * @hibernate.property
        *  column="dwelling_reception_naming"
        *  length="80"
      
    */
    public final String getDwellingReceptionNaming() {
        return this.dwellingReceptionNaming;
    }
  
    private String socialSecurityAgencyName;

    public final void setSocialSecurityAgencyName(final String socialSecurityAgencyName) {
        this.socialSecurityAgencyName = socialSecurityAgencyName;
    }

    /**
 
        * @hibernate.property
        *  column="social_security_agency_name"
        *  length="50"
      
    */
    public final String getSocialSecurityAgencyName() {
        return this.socialSecurityAgencyName;
    }
  
    private Boolean benefitsEducationOfDisabledChildren;

    public final void setBenefitsEducationOfDisabledChildren(final Boolean benefitsEducationOfDisabledChildren) {
        this.benefitsEducationOfDisabledChildren = benefitsEducationOfDisabledChildren;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_education_of_disabled_children"
        
      
    */
    public final Boolean getBenefitsEducationOfDisabledChildren() {
        return this.benefitsEducationOfDisabledChildren;
    }
  
    private String facilitiesTechnicalAssistanceDetails;

    public final void setFacilitiesTechnicalAssistanceDetails(final String facilitiesTechnicalAssistanceDetails) {
        this.facilitiesTechnicalAssistanceDetails = facilitiesTechnicalAssistanceDetails;
    }

    /**
 
        * @hibernate.property
        *  column="facilities_technical_assistance_details"
        *  length="60"
      
    */
    public final String getFacilitiesTechnicalAssistanceDetails() {
        return this.facilitiesTechnicalAssistanceDetails;
    }
  
    private Boolean benefitsOtherBenefits;

    public final void setBenefitsOtherBenefits(final Boolean benefitsOtherBenefits) {
        this.benefitsOtherBenefits = benefitsOtherBenefits;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_other_benefits"
        
      
    */
    public final Boolean getBenefitsOtherBenefits() {
        return this.benefitsOtherBenefits;
    }
  
    private String foldersCdesNumber;

    public final void setFoldersCdesNumber(final String foldersCdesNumber) {
        this.foldersCdesNumber = foldersCdesNumber;
    }

    /**
 
        * @hibernate.property
        *  column="folders_cdes_number"
        *  length="30"
      
    */
    public final String getFoldersCdesNumber() {
        return this.foldersCdesNumber;
    }
  
    private Boolean benefitsDisabilityCompensation;

    public final void setBenefitsDisabilityCompensation(final Boolean benefitsDisabilityCompensation) {
        this.benefitsDisabilityCompensation = benefitsDisabilityCompensation;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_disability_compensation"
        
      
    */
    public final Boolean getBenefitsDisabilityCompensation() {
        return this.benefitsDisabilityCompensation;
    }
  
    private String healthDoctorFirstName;

    public final void setHealthDoctorFirstName(final String healthDoctorFirstName) {
        this.healthDoctorFirstName = healthDoctorFirstName;
    }

    /**
 
        * @hibernate.property
        *  column="health_doctor_first_name"
        *  length="38"
      
    */
    public final String getHealthDoctorFirstName() {
        return this.healthDoctorFirstName;
    }
  
    private Boolean projectRequestsTechnicalHelp;

    public final void setProjectRequestsTechnicalHelp(final Boolean projectRequestsTechnicalHelp) {
        this.projectRequestsTechnicalHelp = projectRequestsTechnicalHelp;
    }

    /**
 
        * @hibernate.property
        *  column="project_requests_technical_help"
        
      
    */
    public final Boolean getProjectRequestsTechnicalHelp() {
        return this.projectRequestsTechnicalHelp;
    }
  
    private Boolean facilitiesTechnicalAssistance;

    public final void setFacilitiesTechnicalAssistance(final Boolean facilitiesTechnicalAssistance) {
        this.facilitiesTechnicalAssistance = facilitiesTechnicalAssistance;
    }

    /**
 
        * @hibernate.property
        *  column="facilities_technical_assistance"
        
      
    */
    public final Boolean getFacilitiesTechnicalAssistance() {
        return this.facilitiesTechnicalAssistance;
    }
  
    private Boolean benefitsCompensatoryAllowanceForExpenses;

    public final void setBenefitsCompensatoryAllowanceForExpenses(final Boolean benefitsCompensatoryAllowanceForExpenses) {
        this.benefitsCompensatoryAllowanceForExpenses = benefitsCompensatoryAllowanceForExpenses;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_compensatory_allowance_for_expenses"
        
      
    */
    public final Boolean getBenefitsCompensatoryAllowanceForExpenses() {
        return this.benefitsCompensatoryAllowanceForExpenses;
    }
  
    private Boolean facilitiesHousing;

    public final void setFacilitiesHousing(final Boolean facilitiesHousing) {
        this.facilitiesHousing = facilitiesHousing;
    }

    /**
 
        * @hibernate.property
        *  column="facilities_housing"
        
      
    */
    public final Boolean getFacilitiesHousing() {
        return this.facilitiesHousing;
    }
  
    private String healthHospitalName;

    public final void setHealthHospitalName(final String healthHospitalName) {
        this.healthHospitalName = healthHospitalName;
    }

    /**
 
        * @hibernate.property
        *  column="health_hospital_name"
        *  length="60"
      
    */
    public final String getHealthHospitalName() {
        return this.healthHospitalName;
    }
  
    private Boolean projectRequestsDisabledPriorityCard;

    public final void setProjectRequestsDisabledPriorityCard(final Boolean projectRequestsDisabledPriorityCard) {
        this.projectRequestsDisabledPriorityCard = projectRequestsDisabledPriorityCard;
    }

    /**
 
        * @hibernate.property
        *  column="project_requests_disabled_priority_card"
        
      
    */
    public final Boolean getProjectRequestsDisabledPriorityCard() {
        return this.projectRequestsDisabledPriorityCard;
    }
  
    private Boolean projectRequestsEducationAllocationOfDisabledChildren;

    public final void setProjectRequestsEducationAllocationOfDisabledChildren(final Boolean projectRequestsEducationAllocationOfDisabledChildren) {
        this.projectRequestsEducationAllocationOfDisabledChildren = projectRequestsEducationAllocationOfDisabledChildren;
    }

    /**
 
        * @hibernate.property
        *  column="project_requests_education_allocation_of_disabled_children"
        
      
    */
    public final Boolean getProjectRequestsEducationAllocationOfDisabledChildren() {
        return this.projectRequestsEducationAllocationOfDisabledChildren;
    }
  
    private String projectRequestsOtherDetails;

    public final void setProjectRequestsOtherDetails(final String projectRequestsOtherDetails) {
        this.projectRequestsOtherDetails = projectRequestsOtherDetails;
    }

    /**
 
        * @hibernate.property
        *  column="project_requests_other_details"
        *  length="60"
      
    */
    public final String getProjectRequestsOtherDetails() {
        return this.projectRequestsOtherDetails;
    }
  
    private fr.cg95.cvq.business.request.social.HcarLegalAccessRepresentativeKindType legalAccessRepresentativeKind;

    public final void setLegalAccessRepresentativeKind(final fr.cg95.cvq.business.request.social.HcarLegalAccessRepresentativeKindType legalAccessRepresentativeKind) {
        this.legalAccessRepresentativeKind = legalAccessRepresentativeKind;
    }

    /**
 
        * @hibernate.property
        *  column="legal_access_representative_kind"
        
      
    */
    public final fr.cg95.cvq.business.request.social.HcarLegalAccessRepresentativeKindType getLegalAccessRepresentativeKind() {
        return this.legalAccessRepresentativeKind;
    }
  
    private Boolean projectRequestsShelteredWork;

    public final void setProjectRequestsShelteredWork(final Boolean projectRequestsShelteredWork) {
        this.projectRequestsShelteredWork = projectRequestsShelteredWork;
    }

    /**
 
        * @hibernate.property
        *  column="project_requests_sheltered_work"
        
      
    */
    public final Boolean getProjectRequestsShelteredWork() {
        return this.projectRequestsShelteredWork;
    }
  
    private String formationCurrentFormation;

    public final void setFormationCurrentFormation(final String formationCurrentFormation) {
        this.formationCurrentFormation = formationCurrentFormation;
    }

    /**
 
        * @hibernate.property
        *  column="formation_current_formation"
        *  length="120"
      
    */
    public final String getFormationCurrentFormation() {
        return this.formationCurrentFormation;
    }
  
    private Boolean studiesAssistanceUnderDisability;

    public final void setStudiesAssistanceUnderDisability(final Boolean studiesAssistanceUnderDisability) {
        this.studiesAssistanceUnderDisability = studiesAssistanceUnderDisability;
    }

    /**
 
        * @hibernate.property
        *  column="studies_assistance_under_disability"
        
      
    */
    public final Boolean getStudiesAssistanceUnderDisability() {
        return this.studiesAssistanceUnderDisability;
    }
  
    private fr.cg95.cvq.business.users.Address professionalSupportSocialServiceAddress;

    public final void setProfessionalSupportSocialServiceAddress(final fr.cg95.cvq.business.users.Address professionalSupportSocialServiceAddress) {
        this.professionalSupportSocialServiceAddress = professionalSupportSocialServiceAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="professional_support_social_service_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getProfessionalSupportSocialServiceAddress() {
        return this.professionalSupportSocialServiceAddress;
    }
  
    private Boolean studiesHighSchool;

    public final void setStudiesHighSchool(final Boolean studiesHighSchool) {
        this.studiesHighSchool = studiesHighSchool;
    }

    /**
 
        * @hibernate.property
        *  column="studies_high_school"
        
      
    */
    public final Boolean getStudiesHighSchool() {
        return this.studiesHighSchool;
    }
  
    private String healthProfessionalFirstName;

    public final void setHealthProfessionalFirstName(final String healthProfessionalFirstName) {
        this.healthProfessionalFirstName = healthProfessionalFirstName;
    }

    /**
 
        * @hibernate.property
        *  column="health_professional_first_name"
        *  length="38"
      
    */
    public final String getHealthProfessionalFirstName() {
        return this.healthProfessionalFirstName;
    }
  
    private String professionalSupportSocialServiceName;

    public final void setProfessionalSupportSocialServiceName(final String professionalSupportSocialServiceName) {
        this.professionalSupportSocialServiceName = professionalSupportSocialServiceName;
    }

    /**
 
        * @hibernate.property
        *  column="professional_support_social_service_name"
        *  length="60"
      
    */
    public final String getProfessionalSupportSocialServiceName() {
        return this.professionalSupportSocialServiceName;
    }
  
    private String facilitiesCustomCarDetails;

    public final void setFacilitiesCustomCarDetails(final String facilitiesCustomCarDetails) {
        this.facilitiesCustomCarDetails = facilitiesCustomCarDetails;
    }

    /**
 
        * @hibernate.property
        *  column="facilities_custom_car_details"
        *  length="60"
      
    */
    public final String getFacilitiesCustomCarDetails() {
        return this.facilitiesCustomCarDetails;
    }
  
    private String dwellingPrecision;

    public final void setDwellingPrecision(final String dwellingPrecision) {
        this.dwellingPrecision = dwellingPrecision;
    }

    /**
 
        * @hibernate.property
        *  column="dwelling_precision"
        *  length="120"
      
    */
    public final String getDwellingPrecision() {
        return this.dwellingPrecision;
    }
  
    private Boolean benefitsDisabilityCard;

    public final void setBenefitsDisabilityCard(final Boolean benefitsDisabilityCard) {
        this.benefitsDisabilityCard = benefitsDisabilityCard;
    }

    /**
 
        * @hibernate.property
        *  column="benefits_disability_card"
        
      
    */
    public final Boolean getBenefitsDisabilityCard() {
        return this.benefitsDisabilityCard;
    }
  
    private fr.cg95.cvq.business.request.social.HcarSocialSecurityMemberShipKindType socialSecurityMemberShipKind;

    public final void setSocialSecurityMemberShipKind(final fr.cg95.cvq.business.request.social.HcarSocialSecurityMemberShipKindType socialSecurityMemberShipKind) {
        this.socialSecurityMemberShipKind = socialSecurityMemberShipKind;
    }

    /**
 
        * @hibernate.property
        *  column="social_security_member_ship_kind"
        
      
    */
    public final fr.cg95.cvq.business.request.social.HcarSocialSecurityMemberShipKindType getSocialSecurityMemberShipKind() {
        return this.socialSecurityMemberShipKind;
    }
  
    private String professionalStatusElectiveFunctionDetails;

    public final void setProfessionalStatusElectiveFunctionDetails(final String professionalStatusElectiveFunctionDetails) {
        this.professionalStatusElectiveFunctionDetails = professionalStatusElectiveFunctionDetails;
    }

    /**
 
        * @hibernate.property
        *  column="professional_status_elective_function_details"
        *  length="60"
      
    */
    public final String getProfessionalStatusElectiveFunctionDetails() {
        return this.professionalStatusElectiveFunctionDetails;
    }
  
    private Boolean facilitiesAnimalAid;

    public final void setFacilitiesAnimalAid(final Boolean facilitiesAnimalAid) {
        this.facilitiesAnimalAid = facilitiesAnimalAid;
    }

    /**
 
        * @hibernate.property
        *  column="facilities_animal_aid"
        
      
    */
    public final Boolean getFacilitiesAnimalAid() {
        return this.facilitiesAnimalAid;
    }
  
    private fr.cg95.cvq.business.users.Address studiesHighSchoolAddress;

    public final void setStudiesHighSchoolAddress(final fr.cg95.cvq.business.users.Address studiesHighSchoolAddress) {
        this.studiesHighSchoolAddress = studiesHighSchoolAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="studies_high_school_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getStudiesHighSchoolAddress() {
        return this.studiesHighSchoolAddress;
    }
  
}
