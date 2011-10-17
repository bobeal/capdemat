

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
@Table(name="handicap_compensation_child_request")
public class HandicapCompensationChildRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public HandicapCompensationChildRequestData() {
      
        benefitsCompensatoryAllowanceForExpenses = Boolean.valueOf(false);
      
        benefitsDailyAllowances = Boolean.valueOf(false);
      
        benefitsDisabilityCard = Boolean.valueOf(false);
      
        benefitsDisabilityCompensation = Boolean.valueOf(false);
      
        benefitsDisabilityPension = Boolean.valueOf(false);
      
        benefitsDisabilityRecognition = Boolean.valueOf(false);
      
        benefitsDisabledAdultAllocation = Boolean.valueOf(false);
      
        benefitsDisabledWorkerRecognition = Boolean.valueOf(false);
      
        benefitsEducationAllocationOfDisabledChildren = Boolean.valueOf(false);
      
        benefitsEducationOfDisabledChildren = Boolean.valueOf(false);
      
        benefitsIncreaseForIndependentLiving = Boolean.valueOf(false);
      
        benefitsOtherBenefits = Boolean.valueOf(false);
      
        benefitsPainfulStandingCard = Boolean.valueOf(false);
      
        benefitsParkingCard = Boolean.valueOf(false);
      
        benefitsProfessionalOrientation = Boolean.valueOf(false);
      
        benefitsSocialWelfare = Boolean.valueOf(false);
      
        benefitsSupplementForSingleParents = Boolean.valueOf(false);
      
        benefitsSupportedByAnInstitution = Boolean.valueOf(false);
      
        benefitsThirdPartyCompensatoryAllowance = Boolean.valueOf(false);
      
        benefitsThirdPartySupplement = Boolean.valueOf(false);
      
        benefitsThirdPersonCompensatoryAllowance = Boolean.valueOf(false);
      
        benefitsUnemploymentBenefits = Boolean.valueOf(false);
      
        benefitsWorkAccidentAnnuity = Boolean.valueOf(false);
      
        careCareServices = Boolean.valueOf(false);
      
        dwellingEstablishmentReception = Boolean.valueOf(false);
      
        dwellingSocialReception = Boolean.valueOf(false);
      
        facilitiesAnimalAid = Boolean.valueOf(false);
      
        facilitiesCustomCar = Boolean.valueOf(false);
      
        facilitiesHousing = Boolean.valueOf(false);
      
        facilitiesSpecializedTransport = Boolean.valueOf(false);
      
        facilitiesTechnicalAssistance = Boolean.valueOf(false);
      
        fatherActivityReduction = Boolean.valueOf(false);
      
        foldersCdes = Boolean.valueOf(false);
      
        foldersCotorep = Boolean.valueOf(false);
      
        foldersMdph = Boolean.valueOf(false);
      
        foldersOtherFolders = Boolean.valueOf(false);
      
        healthFollowedByDoctor = Boolean.valueOf(false);
      
        healthFollowedByHospital = Boolean.valueOf(false);
      
        healthFollowedByProfessional = Boolean.valueOf(false);
      
        homeInterventionHomeIntervenant = Boolean.valueOf(false);
      
        isFamilyAssistance = Boolean.valueOf(false);
      
        motherActivityReduction = Boolean.valueOf(false);
      
        professionalStatusElectiveFunction = Boolean.valueOf(false);
      
        professionalStatusIndemnified = Boolean.valueOf(false);
      
        professionalStatusRegisterAsUnemployed = Boolean.valueOf(false);
      
        professionalSupportDealsWithSameProfessional = Boolean.valueOf(false);
      
        professionalSupportProfessionals = Boolean.valueOf(false);
      
        projectRequestsACTPRenewal = Boolean.valueOf(false);
      
        projectRequestsAssistance = Boolean.valueOf(false);
      
        projectRequestsCustomCar = Boolean.valueOf(false);
      
        projectRequestsDisabilityCard = Boolean.valueOf(false);
      
        projectRequestsDisabilityCostAllocation = Boolean.valueOf(false);
      
        projectRequestsDisabledAdultAllowance = Boolean.valueOf(false);
      
        projectRequestsDisabledPriorityCard = Boolean.valueOf(false);
      
        projectRequestsDisabledWorkerRecognition = Boolean.valueOf(false);
      
        projectRequestsEducationAllocationOfDisabledChildren = Boolean.valueOf(false);
      
        projectRequestsEuropeanParkingCard = Boolean.valueOf(false);
      
        projectRequestsFreePensionMembership = Boolean.valueOf(false);
      
        projectRequestsHandicapRecognition = Boolean.valueOf(false);
      
        projectRequestsHousingFacilities = Boolean.valueOf(false);
      
        projectRequestsIncreaseForIndependentLiving = Boolean.valueOf(false);
      
        projectRequestsInstitutionSupport = Boolean.valueOf(false);
      
        projectRequestsOrdinaryWorking = Boolean.valueOf(false);
      
        projectRequestsOther = Boolean.valueOf(false);
      
        projectRequestsProfessionalOrientation = Boolean.valueOf(false);
      
        projectRequestsShelteredWork = Boolean.valueOf(false);
      
        projectRequestsTechnicalHelp = Boolean.valueOf(false);
      
        projectRequestsThirdPartyHelp = Boolean.valueOf(false);
      
        projectRequestsTransportCostAllocation = Boolean.valueOf(false);
      
        projectRequestsVocationalTraining = Boolean.valueOf(false);
      
        referentFamilyDependents = Boolean.valueOf(false);
      
        schoolingEnrolment = Boolean.valueOf(false);
      
        schoolingExtraCurricular = Boolean.valueOf(false);
      
        schoolingHomeSchooling = Boolean.valueOf(false);
      
        schoolingPersonalizedSchoolingPlan = Boolean.valueOf(false);
      
        schoolingSendToSchool = Boolean.valueOf(false);
      
        schoolingSpecializedGrade = Boolean.valueOf(false);
      
        socialServiceSupport = Boolean.valueOf(false);
      
        studiesAssistanceUnderDisability = Boolean.valueOf(false);
      
        studiesHighSchool = Boolean.valueOf(false);
      
    }

    @Override
    public HandicapCompensationChildRequestData clone() {
        HandicapCompensationChildRequestData result = new HandicapCompensationChildRequestData();
        
          
            
        List<fr.cg95.cvq.business.request.social.HccrAdditionalFee> additionalFeeList = new ArrayList<fr.cg95.cvq.business.request.social.HccrAdditionalFee>();
        for (HccrAdditionalFee object : additionalFee) {
            additionalFeeList.add(object.clone());
        }
        result.setAdditionalFee(additionalFeeList);
      
          
        
          
            
        result.setAseReferentDepartment(aseReferentDepartment);
      
          
        
          
            
        result.setAseReferentLastName(aseReferentLastName);
      
          
        
          
            
        result.setBenefitsCompensatoryAllowanceForExpenses(benefitsCompensatoryAllowanceForExpenses);
      
          
        
          
            
        result.setBenefitsDailyAllowances(benefitsDailyAllowances);
      
          
        
          
            
        result.setBenefitsDisabilityCard(benefitsDisabilityCard);
      
          
        
          
            
        result.setBenefitsDisabilityCompensation(benefitsDisabilityCompensation);
      
          
        
          
            
        result.setBenefitsDisabilityPension(benefitsDisabilityPension);
      
          
        
          
            
        result.setBenefitsDisabilityPensionCategory(benefitsDisabilityPensionCategory);
      
          
        
          
            
        result.setBenefitsDisabilityRatio(benefitsDisabilityRatio);
      
          
        
          
            
        result.setBenefitsDisabilityRecognition(benefitsDisabilityRecognition);
      
          
        
          
            
        result.setBenefitsDisabledAdultAllocation(benefitsDisabledAdultAllocation);
      
          
        
          
            
        result.setBenefitsDisabledWorkerRecognition(benefitsDisabledWorkerRecognition);
      
          
        
          
            
        result.setBenefitsEducationAllocationOfDisabledChildren(benefitsEducationAllocationOfDisabledChildren);
      
          
        
          
            
        result.setBenefitsEducationOfDisabledChildren(benefitsEducationOfDisabledChildren);
      
          
        
          
            
        result.setBenefitsEducationOfDisabledChildrenDetails(benefitsEducationOfDisabledChildrenDetails);
      
          
        
          
            
        result.setBenefitsIncreaseForIndependentLiving(benefitsIncreaseForIndependentLiving);
      
          
        
          
            
        result.setBenefitsOtherBenefits(benefitsOtherBenefits);
      
          
        
          
            
        result.setBenefitsPainfulStandingCard(benefitsPainfulStandingCard);
      
          
        
          
            
        result.setBenefitsParkingCard(benefitsParkingCard);
      
          
        
          
            
        result.setBenefitsProfessionalOrientation(benefitsProfessionalOrientation);
      
          
        
          
            
        result.setBenefitsProfessionalOrientationDetails(benefitsProfessionalOrientationDetails);
      
          
        
          
            
        result.setBenefitsSocialWelfare(benefitsSocialWelfare);
      
          
        
          
            
        result.setBenefitsSupplementForSingleParents(benefitsSupplementForSingleParents);
      
          
        
          
            
        result.setBenefitsSupportedByAnInstitution(benefitsSupportedByAnInstitution);
      
          
        
          
            
        result.setBenefitsSupportedByAnInstitutionDetails(benefitsSupportedByAnInstitutionDetails);
      
          
        
          
            
        result.setBenefitsThirdPartyCompensatoryAllowance(benefitsThirdPartyCompensatoryAllowance);
      
          
        
          
            
        result.setBenefitsThirdPartySupplement(benefitsThirdPartySupplement);
      
          
        
          
            
        result.setBenefitsThirdPersonCompensatoryAllowance(benefitsThirdPersonCompensatoryAllowance);
      
          
        
          
            
        result.setBenefitsUnemploymentBenefits(benefitsUnemploymentBenefits);
      
          
        
          
            
        result.setBenefitsWorkAccidentAnnuity(benefitsWorkAccidentAnnuity);
      
          
        
          
            
        result.setBenefitsWorkAccidentAnnuityRatio(benefitsWorkAccidentAnnuityRatio);
      
          
        
          
            
        result.setCareCareServices(careCareServices);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.social.HccrCareService> careServicesList = new ArrayList<fr.cg95.cvq.business.request.social.HccrCareService>();
        for (HccrCareService object : careServices) {
            careServicesList.add(object.clone());
        }
        result.setCareServices(careServicesList);
      
          
        
          
            
        result.setDwellingEstablishmentReception(dwellingEstablishmentReception);
      
          
        
          
            
        if (dwellingKind != null)
            result.setDwellingKind(dwellingKind);
        else
            result.setDwellingKind(fr.cg95.cvq.business.request.social.HccrDwellingKindType.getDefaultHccrDwellingKindType());
      
          
        
          
            
        result.setDwellingPrecision(dwellingPrecision);
      
          
        
          
            
        if (dwellingReceptionAddress != null)
            result.setDwellingReceptionAddress(dwellingReceptionAddress.clone());
      
          
        
          
            
        result.setDwellingReceptionNaming(dwellingReceptionNaming);
      
          
        
          
            
        if (dwellingReceptionType != null)
            result.setDwellingReceptionType(dwellingReceptionType);
        else
            result.setDwellingReceptionType(fr.cg95.cvq.business.request.social.HccrDwellingReceptionKindType.getDefaultHccrDwellingReceptionKindType());
      
          
        
          
            
        result.setDwellingSocialReception(dwellingSocialReception);
      
          
        
          
            
        if (dwellingSocialReceptionAddress != null)
            result.setDwellingSocialReceptionAddress(dwellingSocialReceptionAddress.clone());
      
          
        
          
            
        result.setDwellingSocialReceptionNaming(dwellingSocialReceptionNaming);
      
          
        
          
            
        result.setFacilitiesAnimalAid(facilitiesAnimalAid);
      
          
        
          
            
        result.setFacilitiesAnimalAidDetails(facilitiesAnimalAidDetails);
      
          
        
          
            
        result.setFacilitiesCustomCar(facilitiesCustomCar);
      
          
        
          
            
        result.setFacilitiesCustomCarDetails(facilitiesCustomCarDetails);
      
          
        
          
            
        result.setFacilitiesHousing(facilitiesHousing);
      
          
        
          
            
        result.setFacilitiesHousingDetails(facilitiesHousingDetails);
      
          
        
          
            
        result.setFacilitiesSpecializedTransport(facilitiesSpecializedTransport);
      
          
        
          
            
        result.setFacilitiesSpecializedTransportDetails(facilitiesSpecializedTransportDetails);
      
          
        
          
            
        result.setFacilitiesTechnicalAssistance(facilitiesTechnicalAssistance);
      
          
        
          
            
        result.setFacilitiesTechnicalAssistanceDetails(facilitiesTechnicalAssistanceDetails);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.social.HccrFamilyAssistanceMember> familyAssistanceMembersList = new ArrayList<fr.cg95.cvq.business.request.social.HccrFamilyAssistanceMember>();
        for (HccrFamilyAssistanceMember object : familyAssistanceMembers) {
            familyAssistanceMembersList.add(object.clone());
        }
        result.setFamilyAssistanceMembers(familyAssistanceMembersList);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.social.HccrFamilyDependent> familyDependentsList = new ArrayList<fr.cg95.cvq.business.request.social.HccrFamilyDependent>();
        for (HccrFamilyDependent object : familyDependents) {
            familyDependentsList.add(object.clone());
        }
        result.setFamilyDependents(familyDependentsList);
      
          
        
          
            
        result.setFatherActivityReduction(fatherActivityReduction);
      
          
        
          
            
        result.setFatherActivityReductionRatio(fatherActivityReductionRatio);
      
          
        
          
            
        result.setFatherFirstName(fatherFirstName);
      
          
        
          
            
        result.setFatherJob(fatherJob);
      
          
        
          
            
        result.setFatherLastName(fatherLastName);
      
          
        
          
            
        result.setFoldersCdes(foldersCdes);
      
          
        
          
            
        result.setFoldersCdesDepartment(foldersCdesDepartment);
      
          
        
          
            
        result.setFoldersCdesNumber(foldersCdesNumber);
      
          
        
          
            
        result.setFoldersCotorep(foldersCotorep);
      
          
        
          
            
        result.setFoldersCotorepDepartment(foldersCotorepDepartment);
      
          
        
          
            
        result.setFoldersCotorepNumber(foldersCotorepNumber);
      
          
        
          
            
        result.setFoldersMdph(foldersMdph);
      
          
        
          
            
        result.setFoldersMdphDepartment(foldersMdphDepartment);
      
          
        
          
            
        result.setFoldersMdphNumber(foldersMdphNumber);
      
          
        
          
            
        result.setFoldersOtherFolders(foldersOtherFolders);
      
          
        
          
            
        result.setFormationCurrentFormation(formationCurrentFormation);
      
          
        
          
            
        result.setFormationDiploma(formationDiploma);
      
          
        
          
            
        result.setFormationPreviousFormation(formationPreviousFormation);
      
          
        
          
            
        result.setFormationStudiesLevel(formationStudiesLevel);
      
          
        
          
            
        result.setHealthDoctorFirstName(healthDoctorFirstName);
      
          
        
          
            
        result.setHealthDoctorLastName(healthDoctorLastName);
      
          
        
          
            
        result.setHealthFollowedByDoctor(healthFollowedByDoctor);
      
          
        
          
            
        result.setHealthFollowedByHospital(healthFollowedByHospital);
      
          
        
          
            
        result.setHealthFollowedByProfessional(healthFollowedByProfessional);
      
          
        
          
            
        result.setHealthHospitalName(healthHospitalName);
      
          
        
          
            
        result.setHealthProfessionalFirstName(healthProfessionalFirstName);
      
          
        
          
            
        result.setHealthProfessionalLastName(healthProfessionalLastName);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.social.HccrHomeIntervenant> homeIntervenantsList = new ArrayList<fr.cg95.cvq.business.request.social.HccrHomeIntervenant>();
        for (HccrHomeIntervenant object : homeIntervenants) {
            homeIntervenantsList.add(object.clone());
        }
        result.setHomeIntervenants(homeIntervenantsList);
      
          
        
          
            
        result.setHomeInterventionHomeIntervenant(homeInterventionHomeIntervenant);
      
          
        
          
            
        result.setIsFamilyAssistance(isFamilyAssistance);
      
          
        
          
            
        result.setMotherActivityReduction(motherActivityReduction);
      
          
        
          
            
        result.setMotherActivityReductionRatio(motherActivityReductionRatio);
      
          
        
          
            
        result.setMotherFirstName(motherFirstName);
      
          
        
          
            
        result.setMotherJob(motherJob);
      
          
        
          
            
        result.setMotherLastName(motherLastName);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.social.HccrOtherBenefit> otherBenefitsList = new ArrayList<fr.cg95.cvq.business.request.social.HccrOtherBenefit>();
        for (HccrOtherBenefit object : otherBenefits) {
            otherBenefitsList.add(object.clone());
        }
        result.setOtherBenefits(otherBenefitsList);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.social.HccrOtherFolder> otherFoldersList = new ArrayList<fr.cg95.cvq.business.request.social.HccrOtherFolder>();
        for (HccrOtherFolder object : otherFolders) {
            otherFoldersList.add(object.clone());
        }
        result.setOtherFolders(otherFoldersList);
      
          
        
          
            
        if (paymentAgencyAddress != null)
            result.setPaymentAgencyAddress(paymentAgencyAddress.clone());
      
          
        
          
            
        if (paymentAgencyBeneficiary != null)
            result.setPaymentAgencyBeneficiary(paymentAgencyBeneficiary);
        else
            result.setPaymentAgencyBeneficiary(fr.cg95.cvq.business.request.social.HccrPaymentAgencyBeneficiaryType.getDefaultHccrPaymentAgencyBeneficiaryType());
      
          
        
          
            
        result.setPaymentAgencyBeneficiaryNumber(paymentAgencyBeneficiaryNumber);
      
          
        
          
            
        result.setPaymentAgencyName(paymentAgencyName);
      
          
        
          
            
        if (professionalStatusAddress != null)
            result.setProfessionalStatusAddress(professionalStatusAddress.clone());
      
          
        
          
            
        result.setProfessionalStatusDate(professionalStatusDate);
      
          
        
          
            
        result.setProfessionalStatusElectiveFunction(professionalStatusElectiveFunction);
      
          
        
          
            
        result.setProfessionalStatusElectiveFunctionDetails(professionalStatusElectiveFunctionDetails);
      
          
        
          
            
        result.setProfessionalStatusEmployerName(professionalStatusEmployerName);
      
          
        
          
            
        if (professionalStatusEnvironment != null)
            result.setProfessionalStatusEnvironment(professionalStatusEnvironment);
        else
            result.setProfessionalStatusEnvironment(fr.cg95.cvq.business.request.social.HccrProfessionalStatusEnvironmentType.getDefaultHccrProfessionalStatusEnvironmentType());
      
          
        
          
            
        result.setProfessionalStatusIndemnified(professionalStatusIndemnified);
      
          
        
          
            
        result.setProfessionalStatusIndemnifiedDate(professionalStatusIndemnifiedDate);
      
          
        
          
            
        if (professionalStatusKind != null)
            result.setProfessionalStatusKind(professionalStatusKind);
        else
            result.setProfessionalStatusKind(fr.cg95.cvq.business.request.social.HccrProfessionalStatusKindType.getDefaultHccrProfessionalStatusKindType());
      
          
        
          
            
        result.setProfessionalStatusProfession(professionalStatusProfession);
      
          
        
          
            
        result.setProfessionalStatusRegisterAsUnemployed(professionalStatusRegisterAsUnemployed);
      
          
        
          
            
        result.setProfessionalStatusRegisterAsUnemployedDate(professionalStatusRegisterAsUnemployedDate);
      
          
        
          
            
        result.setProfessionalSupportDealsWithSameProfessional(professionalSupportDealsWithSameProfessional);
      
          
        
          
            
        result.setProfessionalSupportProfessionals(professionalSupportProfessionals);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.social.HccrProfessional> professionalsList = new ArrayList<fr.cg95.cvq.business.request.social.HccrProfessional>();
        for (HccrProfessional object : professionals) {
            professionalsList.add(object.clone());
        }
        result.setProfessionals(professionalsList);
      
          
        
          
            
        result.setProjectComments(projectComments);
      
          
        
          
            
        result.setProjectNeeds(projectNeeds);
      
          
        
          
            
        result.setProjectRequestsACTPRenewal(projectRequestsACTPRenewal);
      
          
        
          
            
        result.setProjectRequestsAssistance(projectRequestsAssistance);
      
          
        
          
            
        result.setProjectRequestsCustomCar(projectRequestsCustomCar);
      
          
        
          
            
        result.setProjectRequestsDisabilityCard(projectRequestsDisabilityCard);
      
          
        
          
            
        result.setProjectRequestsDisabilityCostAllocation(projectRequestsDisabilityCostAllocation);
      
          
        
          
            
        result.setProjectRequestsDisabledAdultAllowance(projectRequestsDisabledAdultAllowance);
      
          
        
          
            
        result.setProjectRequestsDisabledPriorityCard(projectRequestsDisabledPriorityCard);
      
          
        
          
            
        result.setProjectRequestsDisabledWorkerRecognition(projectRequestsDisabledWorkerRecognition);
      
          
        
          
            
        result.setProjectRequestsEducationAllocationOfDisabledChildren(projectRequestsEducationAllocationOfDisabledChildren);
      
          
        
          
            
        result.setProjectRequestsEuropeanParkingCard(projectRequestsEuropeanParkingCard);
      
          
        
          
            
        result.setProjectRequestsFreePensionMembership(projectRequestsFreePensionMembership);
      
          
        
          
            
        result.setProjectRequestsHandicapRecognition(projectRequestsHandicapRecognition);
      
          
        
          
            
        result.setProjectRequestsHousingFacilities(projectRequestsHousingFacilities);
      
          
        
          
            
        result.setProjectRequestsIncreaseForIndependentLiving(projectRequestsIncreaseForIndependentLiving);
      
          
        
          
            
        result.setProjectRequestsInstitutionSupport(projectRequestsInstitutionSupport);
      
          
        
          
            
        result.setProjectRequestsOrdinaryWorking(projectRequestsOrdinaryWorking);
      
          
        
          
            
        result.setProjectRequestsOther(projectRequestsOther);
      
          
        
          
            
        result.setProjectRequestsOtherDetails(projectRequestsOtherDetails);
      
          
        
          
            
        result.setProjectRequestsProfessionalOrientation(projectRequestsProfessionalOrientation);
      
          
        
          
            
        result.setProjectRequestsShelteredWork(projectRequestsShelteredWork);
      
          
        
          
            
        result.setProjectRequestsTechnicalHelp(projectRequestsTechnicalHelp);
      
          
        
          
            
        result.setProjectRequestsThirdPartyHelp(projectRequestsThirdPartyHelp);
      
          
        
          
            
        result.setProjectRequestsTransportCostAllocation(projectRequestsTransportCostAllocation);
      
          
        
          
            
        result.setProjectRequestsVocationalTraining(projectRequestsVocationalTraining);
      
          
        
          
            
        result.setProjectWish(projectWish);
      
          
        
          
            
        result.setReferentBirthCity(referentBirthCity);
      
          
        
          
            
        result.setReferentBirthCountry(referentBirthCountry);
      
          
        
          
            
        result.setReferentBirthDate(referentBirthDate);
      
          
        
          
            
        result.setReferentFamilyDependents(referentFamilyDependents);
      
          
        
          
            
        if (referentFamilyStatus != null)
            result.setReferentFamilyStatus(referentFamilyStatus);
        else
            result.setReferentFamilyStatus(fr.cg95.cvq.business.users.FamilyStatusType.getDefaultFamilyStatusType());
      
          
        
          
            
        result.setReferentFirstName(referentFirstName);
      
          
        
          
            
        result.setReferentLastName(referentLastName);
      
          
        
          
            
        result.setReferentMaidenName(referentMaidenName);
      
          
        
          
            
        if (referentTitle != null)
            result.setReferentTitle(referentTitle);
        else
            result.setReferentTitle(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
      
          
        
          
            
        if (schoolingAttendedGrade != null)
            result.setSchoolingAttendedGrade(schoolingAttendedGrade);
        else
            result.setSchoolingAttendedGrade(fr.cg95.cvq.business.users.SectionType.getDefaultSectionType());
      
          
        
          
            
        result.setSchoolingEnrolment(schoolingEnrolment);
      
          
        
          
            
        result.setSchoolingExtraCurricular(schoolingExtraCurricular);
      
          
        
          
            
        result.setSchoolingExtraCurricularDetails(schoolingExtraCurricularDetails);
      
          
        
          
            
        result.setSchoolingHomeSchooling(schoolingHomeSchooling);
      
          
        
          
            
        if (schoolingHomeSchoolingAccompanistAddress != null)
            result.setSchoolingHomeSchoolingAccompanistAddress(schoolingHomeSchoolingAccompanistAddress.clone());
      
          
        
          
            
        result.setSchoolingHomeSchoolingAccompanistFirstName(schoolingHomeSchoolingAccompanistFirstName);
      
          
        
          
            
        result.setSchoolingHomeSchoolingAccompanistLastName(schoolingHomeSchoolingAccompanistLastName);
      
          
        
          
            
        if (schoolingHomeSchoolingKind != null)
            result.setSchoolingHomeSchoolingKind(schoolingHomeSchoolingKind);
        else
            result.setSchoolingHomeSchoolingKind(fr.cg95.cvq.business.request.social.HccrHomeSchoolingKindType.getDefaultHccrHomeSchoolingKindType());
      
          
        
          
            
        result.setSchoolingPersonalizedSchoolingPlan(schoolingPersonalizedSchoolingPlan);
      
          
        
          
            
        if (schoolingSchoolAddress != null)
            result.setSchoolingSchoolAddress(schoolingSchoolAddress.clone());
      
          
        
          
            
        result.setSchoolingSchoolName(schoolingSchoolName);
      
          
        
          
            
        if (schoolingSchoolingKind != null)
            result.setSchoolingSchoolingKind(schoolingSchoolingKind);
        else
            result.setSchoolingSchoolingKind(fr.cg95.cvq.business.request.social.HccrSchoolingKindType.getDefaultHccrSchoolingKindType());
      
          
        
          
            
        result.setSchoolingSendToSchool(schoolingSendToSchool);
      
          
        
          
            
        result.setSchoolingSpecializedGrade(schoolingSpecializedGrade);
      
          
        
          
            
        result.setSchoolingSpecializedGradeDetails(schoolingSpecializedGradeDetails);
      
          
        
          
            
        result.setSchoolingTime(schoolingTime);
      
          
        
          
            
        if (socialSecurityAgencyAddress != null)
            result.setSocialSecurityAgencyAddress(socialSecurityAgencyAddress.clone());
      
          
        
          
            
        result.setSocialSecurityAgencyName(socialSecurityAgencyName);
      
          
        
          
            
        if (socialSecurityMemberShipKind != null)
            result.setSocialSecurityMemberShipKind(socialSecurityMemberShipKind);
        else
            result.setSocialSecurityMemberShipKind(fr.cg95.cvq.business.request.social.HccrSocialSecurityMemberShipKindType.getDefaultHccrSocialSecurityMemberShipKindType());
      
          
        
          
            
        result.setSocialSecurityNumber(socialSecurityNumber);
      
          
        
          
            
        if (socialServiceAddress != null)
            result.setSocialServiceAddress(socialServiceAddress.clone());
      
          
        
          
            
        result.setSocialServiceName(socialServiceName);
      
          
        
          
            
        result.setSocialServiceSupport(socialServiceSupport);
      
          
        
          
            
        result.setStudiesAssistanceUnderDisability(studiesAssistanceUnderDisability);
      
          
        
          
            
        result.setStudiesAssistanceUnderDisabilityDetails(studiesAssistanceUnderDisabilityDetails);
      
          
        
          
            
        result.setStudiesHighSchool(studiesHighSchool);
      
          
        
          
            
        if (studiesHighSchoolAddress != null)
            result.setStudiesHighSchoolAddress(studiesHighSchoolAddress.clone());
      
          
        
          
            
        result.setStudiesHighSchoolGrade(studiesHighSchoolGrade);
      
          
        
          
            
        result.setStudiesHighSchoolName(studiesHighSchoolName);
      
          
        
          
            
        result.setSubjectBirthCity(subjectBirthCity);
      
          
        
          
            
        result.setSubjectBirthCountry(subjectBirthCountry);
      
          
        
          
            
        result.setSubjectBirthDate(subjectBirthDate);
      
          
        
          
            
        if (subjectParentalAuthorityHolder != null)
            result.setSubjectParentalAuthorityHolder(subjectParentalAuthorityHolder);
        else
            result.setSubjectParentalAuthorityHolder(fr.cg95.cvq.business.request.social.HccrSubjectParentalAuthorityHolderType.getDefaultHccrSubjectParentalAuthorityHolderType());
      
          
        
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

  
    
      @AssertValid(
        
        
        profiles = {"benefits"},
        message = "additionalFee"
      )
    
    private List<fr.cg95.cvq.business.request.social.HccrAdditionalFee> additionalFee;

    public void setAdditionalFee(final List<fr.cg95.cvq.business.request.social.HccrAdditionalFee> additionalFee) {
        this.additionalFee = additionalFee;
    }

 
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @OrderColumn(name="additional_fee_index")
    @JoinColumn(name="handicap_compensation_child_request_id")
      
    public List<fr.cg95.cvq.business.request.social.HccrAdditionalFee> getAdditionalFee() {
        return this.additionalFee;
    }
  
    
      @MaxLength(
        
          value = 2,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['subjectBirthDate'].test(_this.subjectBirthDate.toString());" +
                
              
            
            "return active",
        
        profiles = {"subject"},
        message = "aseReferentDepartment"
      )
    
    private String aseReferentDepartment;

    public void setAseReferentDepartment(final String aseReferentDepartment) {
        this.aseReferentDepartment = aseReferentDepartment;
    }

 
    @Column(name="ase_referent_department" , length=2 )
      
    public String getAseReferentDepartment() {
        return this.aseReferentDepartment;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['subjectBirthDate'].test(_this.subjectBirthDate.toString());" +
                
              
            
            "return active",
        
        profiles = {"subject"},
        message = "aseReferentLastName"
      )
    
    private String aseReferentLastName;

    public void setAseReferentLastName(final String aseReferentLastName) {
        this.aseReferentLastName = aseReferentLastName;
    }

 
    @Column(name="ase_referent_last_name" , length=38 )
      
    public String getAseReferentLastName() {
        return this.aseReferentLastName;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsCompensatoryAllowanceForExpenses"
      )
    
    private Boolean benefitsCompensatoryAllowanceForExpenses;

    public void setBenefitsCompensatoryAllowanceForExpenses(final Boolean benefitsCompensatoryAllowanceForExpenses) {
        this.benefitsCompensatoryAllowanceForExpenses = benefitsCompensatoryAllowanceForExpenses;
    }

 
    @Column(name="benefits_compensatory_allowance_for_expenses"  )
      
    public Boolean getBenefitsCompensatoryAllowanceForExpenses() {
        return this.benefitsCompensatoryAllowanceForExpenses;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsDailyAllowances"
      )
    
    private Boolean benefitsDailyAllowances;

    public void setBenefitsDailyAllowances(final Boolean benefitsDailyAllowances) {
        this.benefitsDailyAllowances = benefitsDailyAllowances;
    }

 
    @Column(name="benefits_daily_allowances"  )
      
    public Boolean getBenefitsDailyAllowances() {
        return this.benefitsDailyAllowances;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsDisabilityCard"
      )
    
    private Boolean benefitsDisabilityCard;

    public void setBenefitsDisabilityCard(final Boolean benefitsDisabilityCard) {
        this.benefitsDisabilityCard = benefitsDisabilityCard;
    }

 
    @Column(name="benefits_disability_card"  )
      
    public Boolean getBenefitsDisabilityCard() {
        return this.benefitsDisabilityCard;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsDisabilityCompensation"
      )
    
    private Boolean benefitsDisabilityCompensation;

    public void setBenefitsDisabilityCompensation(final Boolean benefitsDisabilityCompensation) {
        this.benefitsDisabilityCompensation = benefitsDisabilityCompensation;
    }

 
    @Column(name="benefits_disability_compensation"  )
      
    public Boolean getBenefitsDisabilityCompensation() {
        return this.benefitsDisabilityCompensation;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsDisabilityPension"
      )
    
    private Boolean benefitsDisabilityPension;

    public void setBenefitsDisabilityPension(final Boolean benefitsDisabilityPension) {
        this.benefitsDisabilityPension = benefitsDisabilityPension;
    }

 
    @Column(name="benefits_disability_pension"  )
      
    public Boolean getBenefitsDisabilityPension() {
        return this.benefitsDisabilityPension;
    }
  
    
      @MaxLength(
        
          value = 60,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['benefitsDisabilityPension'].test(_this.benefitsDisabilityPension.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"benefits"},
        message = "benefitsDisabilityPensionCategory"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['benefitsDisabilityPension'].test(_this.benefitsDisabilityPension.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"benefits"},
        message = "benefitsDisabilityPensionCategory"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['benefitsDisabilityPension'].test(_this.benefitsDisabilityPension.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"benefits"},
        message = "benefitsDisabilityPensionCategory"
      )
    
    private String benefitsDisabilityPensionCategory;

    public void setBenefitsDisabilityPensionCategory(final String benefitsDisabilityPensionCategory) {
        this.benefitsDisabilityPensionCategory = benefitsDisabilityPensionCategory;
    }

 
    @Column(name="benefits_disability_pension_category" , length=60 )
      
    public String getBenefitsDisabilityPensionCategory() {
        return this.benefitsDisabilityPensionCategory;
    }
  
    
      @MaxLength(
        
          value = 3,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['benefitsDisabilityRecognition'].test(_this.benefitsDisabilityRecognition.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"benefits"},
        message = "benefitsDisabilityRatio"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['benefitsDisabilityRecognition'].test(_this.benefitsDisabilityRecognition.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"benefits"},
        message = "benefitsDisabilityRatio"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['benefitsDisabilityRecognition'].test(_this.benefitsDisabilityRecognition.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"benefits"},
        message = "benefitsDisabilityRatio"
      )
    
    private String benefitsDisabilityRatio;

    public void setBenefitsDisabilityRatio(final String benefitsDisabilityRatio) {
        this.benefitsDisabilityRatio = benefitsDisabilityRatio;
    }

 
    @Column(name="benefits_disability_ratio" , length=3 )
      
    public String getBenefitsDisabilityRatio() {
        return this.benefitsDisabilityRatio;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsDisabilityRecognition"
      )
    
    private Boolean benefitsDisabilityRecognition;

    public void setBenefitsDisabilityRecognition(final Boolean benefitsDisabilityRecognition) {
        this.benefitsDisabilityRecognition = benefitsDisabilityRecognition;
    }

 
    @Column(name="benefits_disability_recognition"  )
      
    public Boolean getBenefitsDisabilityRecognition() {
        return this.benefitsDisabilityRecognition;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsDisabledAdultAllocation"
      )
    
    private Boolean benefitsDisabledAdultAllocation;

    public void setBenefitsDisabledAdultAllocation(final Boolean benefitsDisabledAdultAllocation) {
        this.benefitsDisabledAdultAllocation = benefitsDisabledAdultAllocation;
    }

 
    @Column(name="benefits_disabled_adult_allocation"  )
      
    public Boolean getBenefitsDisabledAdultAllocation() {
        return this.benefitsDisabledAdultAllocation;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsDisabledWorkerRecognition"
      )
    
    private Boolean benefitsDisabledWorkerRecognition;

    public void setBenefitsDisabledWorkerRecognition(final Boolean benefitsDisabledWorkerRecognition) {
        this.benefitsDisabledWorkerRecognition = benefitsDisabledWorkerRecognition;
    }

 
    @Column(name="benefits_disabled_worker_recognition"  )
      
    public Boolean getBenefitsDisabledWorkerRecognition() {
        return this.benefitsDisabledWorkerRecognition;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsEducationAllocationOfDisabledChildren"
      )
    
    private Boolean benefitsEducationAllocationOfDisabledChildren;

    public void setBenefitsEducationAllocationOfDisabledChildren(final Boolean benefitsEducationAllocationOfDisabledChildren) {
        this.benefitsEducationAllocationOfDisabledChildren = benefitsEducationAllocationOfDisabledChildren;
    }

 
    @Column(name="benefits_education_allocation_of_disabled_children"  )
      
    public Boolean getBenefitsEducationAllocationOfDisabledChildren() {
        return this.benefitsEducationAllocationOfDisabledChildren;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsEducationOfDisabledChildren"
      )
    
    private Boolean benefitsEducationOfDisabledChildren;

    public void setBenefitsEducationOfDisabledChildren(final Boolean benefitsEducationOfDisabledChildren) {
        this.benefitsEducationOfDisabledChildren = benefitsEducationOfDisabledChildren;
    }

 
    @Column(name="benefits_education_of_disabled_children"  )
      
    public Boolean getBenefitsEducationOfDisabledChildren() {
        return this.benefitsEducationOfDisabledChildren;
    }
  
    
      @MaxLength(
        
          value = 60,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['benefitsEducationOfDisabledChildren'].test(_this.benefitsEducationOfDisabledChildren.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"benefits"},
        message = "benefitsEducationOfDisabledChildrenDetails"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['benefitsEducationOfDisabledChildren'].test(_this.benefitsEducationOfDisabledChildren.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"benefits"},
        message = "benefitsEducationOfDisabledChildrenDetails"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['benefitsEducationOfDisabledChildren'].test(_this.benefitsEducationOfDisabledChildren.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"benefits"},
        message = "benefitsEducationOfDisabledChildrenDetails"
      )
    
    private String benefitsEducationOfDisabledChildrenDetails;

    public void setBenefitsEducationOfDisabledChildrenDetails(final String benefitsEducationOfDisabledChildrenDetails) {
        this.benefitsEducationOfDisabledChildrenDetails = benefitsEducationOfDisabledChildrenDetails;
    }

 
    @Column(name="benefits_education_of_disabled_children_details" , length=60 )
      
    public String getBenefitsEducationOfDisabledChildrenDetails() {
        return this.benefitsEducationOfDisabledChildrenDetails;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsIncreaseForIndependentLiving"
      )
    
    private Boolean benefitsIncreaseForIndependentLiving;

    public void setBenefitsIncreaseForIndependentLiving(final Boolean benefitsIncreaseForIndependentLiving) {
        this.benefitsIncreaseForIndependentLiving = benefitsIncreaseForIndependentLiving;
    }

 
    @Column(name="benefits_increase_for_independent_living"  )
      
    public Boolean getBenefitsIncreaseForIndependentLiving() {
        return this.benefitsIncreaseForIndependentLiving;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsOtherBenefits"
      )
    
    private Boolean benefitsOtherBenefits;

    public void setBenefitsOtherBenefits(final Boolean benefitsOtherBenefits) {
        this.benefitsOtherBenefits = benefitsOtherBenefits;
    }

 
    @Column(name="benefits_other_benefits"  )
      
    public Boolean getBenefitsOtherBenefits() {
        return this.benefitsOtherBenefits;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsPainfulStandingCard"
      )
    
    private Boolean benefitsPainfulStandingCard;

    public void setBenefitsPainfulStandingCard(final Boolean benefitsPainfulStandingCard) {
        this.benefitsPainfulStandingCard = benefitsPainfulStandingCard;
    }

 
    @Column(name="benefits_painful_standing_card"  )
      
    public Boolean getBenefitsPainfulStandingCard() {
        return this.benefitsPainfulStandingCard;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsParkingCard"
      )
    
    private Boolean benefitsParkingCard;

    public void setBenefitsParkingCard(final Boolean benefitsParkingCard) {
        this.benefitsParkingCard = benefitsParkingCard;
    }

 
    @Column(name="benefits_parking_card"  )
      
    public Boolean getBenefitsParkingCard() {
        return this.benefitsParkingCard;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsProfessionalOrientation"
      )
    
    private Boolean benefitsProfessionalOrientation;

    public void setBenefitsProfessionalOrientation(final Boolean benefitsProfessionalOrientation) {
        this.benefitsProfessionalOrientation = benefitsProfessionalOrientation;
    }

 
    @Column(name="benefits_professional_orientation"  )
      
    public Boolean getBenefitsProfessionalOrientation() {
        return this.benefitsProfessionalOrientation;
    }
  
    
      @MaxLength(
        
          value = 60,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['benefitsProfessionalOrientation'].test(_this.benefitsProfessionalOrientation.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"benefits"},
        message = "benefitsProfessionalOrientationDetails"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['benefitsProfessionalOrientation'].test(_this.benefitsProfessionalOrientation.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"benefits"},
        message = "benefitsProfessionalOrientationDetails"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['benefitsProfessionalOrientation'].test(_this.benefitsProfessionalOrientation.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"benefits"},
        message = "benefitsProfessionalOrientationDetails"
      )
    
    private String benefitsProfessionalOrientationDetails;

    public void setBenefitsProfessionalOrientationDetails(final String benefitsProfessionalOrientationDetails) {
        this.benefitsProfessionalOrientationDetails = benefitsProfessionalOrientationDetails;
    }

 
    @Column(name="benefits_professional_orientation_details" , length=60 )
      
    public String getBenefitsProfessionalOrientationDetails() {
        return this.benefitsProfessionalOrientationDetails;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsSocialWelfare"
      )
    
    private Boolean benefitsSocialWelfare;

    public void setBenefitsSocialWelfare(final Boolean benefitsSocialWelfare) {
        this.benefitsSocialWelfare = benefitsSocialWelfare;
    }

 
    @Column(name="benefits_social_welfare"  )
      
    public Boolean getBenefitsSocialWelfare() {
        return this.benefitsSocialWelfare;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsSupplementForSingleParents"
      )
    
    private Boolean benefitsSupplementForSingleParents;

    public void setBenefitsSupplementForSingleParents(final Boolean benefitsSupplementForSingleParents) {
        this.benefitsSupplementForSingleParents = benefitsSupplementForSingleParents;
    }

 
    @Column(name="benefits_supplement_for_single_parents"  )
      
    public Boolean getBenefitsSupplementForSingleParents() {
        return this.benefitsSupplementForSingleParents;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsSupportedByAnInstitution"
      )
    
    private Boolean benefitsSupportedByAnInstitution;

    public void setBenefitsSupportedByAnInstitution(final Boolean benefitsSupportedByAnInstitution) {
        this.benefitsSupportedByAnInstitution = benefitsSupportedByAnInstitution;
    }

 
    @Column(name="benefits_supported_by_an_institution"  )
      
    public Boolean getBenefitsSupportedByAnInstitution() {
        return this.benefitsSupportedByAnInstitution;
    }
  
    
      @MaxLength(
        
          value = 60,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['benefitsSupportedByAnInstitution'].test(_this.benefitsSupportedByAnInstitution.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"benefits"},
        message = "benefitsSupportedByAnInstitutionDetails"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['benefitsSupportedByAnInstitution'].test(_this.benefitsSupportedByAnInstitution.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"benefits"},
        message = "benefitsSupportedByAnInstitutionDetails"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['benefitsSupportedByAnInstitution'].test(_this.benefitsSupportedByAnInstitution.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"benefits"},
        message = "benefitsSupportedByAnInstitutionDetails"
      )
    
    private String benefitsSupportedByAnInstitutionDetails;

    public void setBenefitsSupportedByAnInstitutionDetails(final String benefitsSupportedByAnInstitutionDetails) {
        this.benefitsSupportedByAnInstitutionDetails = benefitsSupportedByAnInstitutionDetails;
    }

 
    @Column(name="benefits_supported_by_an_institution_details" , length=60 )
      
    public String getBenefitsSupportedByAnInstitutionDetails() {
        return this.benefitsSupportedByAnInstitutionDetails;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsThirdPartyCompensatoryAllowance"
      )
    
    private Boolean benefitsThirdPartyCompensatoryAllowance;

    public void setBenefitsThirdPartyCompensatoryAllowance(final Boolean benefitsThirdPartyCompensatoryAllowance) {
        this.benefitsThirdPartyCompensatoryAllowance = benefitsThirdPartyCompensatoryAllowance;
    }

 
    @Column(name="benefits_third_party_compensatory_allowance"  )
      
    public Boolean getBenefitsThirdPartyCompensatoryAllowance() {
        return this.benefitsThirdPartyCompensatoryAllowance;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsThirdPartySupplement"
      )
    
    private Boolean benefitsThirdPartySupplement;

    public void setBenefitsThirdPartySupplement(final Boolean benefitsThirdPartySupplement) {
        this.benefitsThirdPartySupplement = benefitsThirdPartySupplement;
    }

 
    @Column(name="benefits_third_party_supplement"  )
      
    public Boolean getBenefitsThirdPartySupplement() {
        return this.benefitsThirdPartySupplement;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsThirdPersonCompensatoryAllowance"
      )
    
    private Boolean benefitsThirdPersonCompensatoryAllowance;

    public void setBenefitsThirdPersonCompensatoryAllowance(final Boolean benefitsThirdPersonCompensatoryAllowance) {
        this.benefitsThirdPersonCompensatoryAllowance = benefitsThirdPersonCompensatoryAllowance;
    }

 
    @Column(name="benefits_third_person_compensatory_allowance"  )
      
    public Boolean getBenefitsThirdPersonCompensatoryAllowance() {
        return this.benefitsThirdPersonCompensatoryAllowance;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsUnemploymentBenefits"
      )
    
    private Boolean benefitsUnemploymentBenefits;

    public void setBenefitsUnemploymentBenefits(final Boolean benefitsUnemploymentBenefits) {
        this.benefitsUnemploymentBenefits = benefitsUnemploymentBenefits;
    }

 
    @Column(name="benefits_unemployment_benefits"  )
      
    public Boolean getBenefitsUnemploymentBenefits() {
        return this.benefitsUnemploymentBenefits;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsWorkAccidentAnnuity"
      )
    
    private Boolean benefitsWorkAccidentAnnuity;

    public void setBenefitsWorkAccidentAnnuity(final Boolean benefitsWorkAccidentAnnuity) {
        this.benefitsWorkAccidentAnnuity = benefitsWorkAccidentAnnuity;
    }

 
    @Column(name="benefits_work_accident_annuity"  )
      
    public Boolean getBenefitsWorkAccidentAnnuity() {
        return this.benefitsWorkAccidentAnnuity;
    }
  
    
      @MaxLength(
        
          value = 3,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['benefitsWorkAccidentAnnuity'].test(_this.benefitsWorkAccidentAnnuity.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"benefits"},
        message = "benefitsWorkAccidentAnnuityRatio"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['benefitsWorkAccidentAnnuity'].test(_this.benefitsWorkAccidentAnnuity.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"benefits"},
        message = "benefitsWorkAccidentAnnuityRatio"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['benefitsWorkAccidentAnnuity'].test(_this.benefitsWorkAccidentAnnuity.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"benefits"},
        message = "benefitsWorkAccidentAnnuityRatio"
      )
    
    private String benefitsWorkAccidentAnnuityRatio;

    public void setBenefitsWorkAccidentAnnuityRatio(final String benefitsWorkAccidentAnnuityRatio) {
        this.benefitsWorkAccidentAnnuityRatio = benefitsWorkAccidentAnnuityRatio;
    }

 
    @Column(name="benefits_work_accident_annuity_ratio" , length=3 )
      
    public String getBenefitsWorkAccidentAnnuityRatio() {
        return this.benefitsWorkAccidentAnnuityRatio;
    }
  
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "careCareServices"
      )
    
    private Boolean careCareServices;

    public void setCareCareServices(final Boolean careCareServices) {
        this.careCareServices = careCareServices;
    }

 
    @Column(name="care_care_services"  )
      
    public Boolean getCareCareServices() {
        return this.careCareServices;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['careCareServices'].test(_this.careCareServices.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "careServices"
      )
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['careCareServices'].test(_this.careCareServices.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "careServices"
      )
    
    private List<fr.cg95.cvq.business.request.social.HccrCareService> careServices;

    public void setCareServices(final List<fr.cg95.cvq.business.request.social.HccrCareService> careServices) {
        this.careServices = careServices;
    }

 
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @OrderColumn(name="care_services_index")
    @JoinColumn(name="handicap_compensation_child_request_id")
      
    public List<fr.cg95.cvq.business.request.social.HccrCareService> getCareServices() {
        return this.careServices;
    }
  
    
      @NotNull(
        
        
        profiles = {"dwelling"},
        message = "dwellingEstablishmentReception"
      )
    
    private Boolean dwellingEstablishmentReception;

    public void setDwellingEstablishmentReception(final Boolean dwellingEstablishmentReception) {
        this.dwellingEstablishmentReception = dwellingEstablishmentReception;
    }

 
    @Column(name="dwelling_establishment_reception"  )
      
    public Boolean getDwellingEstablishmentReception() {
        return this.dwellingEstablishmentReception;
    }
  
    
      @NotNull(
        
        
        profiles = {"dwelling"},
        message = "dwellingKind"
      )
    
    private fr.cg95.cvq.business.request.social.HccrDwellingKindType dwellingKind;

    public void setDwellingKind(final fr.cg95.cvq.business.request.social.HccrDwellingKindType dwellingKind) {
        this.dwellingKind = dwellingKind;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="dwelling_kind"  )
      
    public fr.cg95.cvq.business.request.social.HccrDwellingKindType getDwellingKind() {
        return this.dwellingKind;
    }
  
    
      @MaxLength(
        
          value = 120,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dwellingKind'].test(_this.dwellingKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"dwelling"},
        message = "dwellingPrecision"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dwellingKind'].test(_this.dwellingKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"dwelling"},
        message = "dwellingPrecision"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dwellingKind'].test(_this.dwellingKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"dwelling"},
        message = "dwellingPrecision"
      )
    
    private String dwellingPrecision;

    public void setDwellingPrecision(final String dwellingPrecision) {
        this.dwellingPrecision = dwellingPrecision;
    }

 
    @Column(name="dwelling_precision" , length=120 )
      
    public String getDwellingPrecision() {
        return this.dwellingPrecision;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dwellingEstablishmentReception'].test(_this.dwellingEstablishmentReception.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"dwelling"},
        message = "dwellingReceptionAddress"
      )
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dwellingEstablishmentReception'].test(_this.dwellingEstablishmentReception.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"dwelling"},
        message = "dwellingReceptionAddress"
      )
    
    private fr.cg95.cvq.business.users.Address dwellingReceptionAddress;

    public void setDwellingReceptionAddress(final fr.cg95.cvq.business.users.Address dwellingReceptionAddress) {
        this.dwellingReceptionAddress = dwellingReceptionAddress;
    }

 
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="dwelling_reception_address_id")
      
    public fr.cg95.cvq.business.users.Address getDwellingReceptionAddress() {
        return this.dwellingReceptionAddress;
    }
  
    
      @MaxLength(
        
          value = 80,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dwellingEstablishmentReception'].test(_this.dwellingEstablishmentReception.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"dwelling"},
        message = "dwellingReceptionNaming"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dwellingEstablishmentReception'].test(_this.dwellingEstablishmentReception.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"dwelling"},
        message = "dwellingReceptionNaming"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dwellingEstablishmentReception'].test(_this.dwellingEstablishmentReception.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"dwelling"},
        message = "dwellingReceptionNaming"
      )
    
    private String dwellingReceptionNaming;

    public void setDwellingReceptionNaming(final String dwellingReceptionNaming) {
        this.dwellingReceptionNaming = dwellingReceptionNaming;
    }

 
    @Column(name="dwelling_reception_naming" , length=80 )
      
    public String getDwellingReceptionNaming() {
        return this.dwellingReceptionNaming;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dwellingEstablishmentReception'].test(_this.dwellingEstablishmentReception.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"dwelling"},
        message = "dwellingReceptionType"
      )
    
    private fr.cg95.cvq.business.request.social.HccrDwellingReceptionKindType dwellingReceptionType;

    public void setDwellingReceptionType(final fr.cg95.cvq.business.request.social.HccrDwellingReceptionKindType dwellingReceptionType) {
        this.dwellingReceptionType = dwellingReceptionType;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="dwelling_reception_type"  )
      
    public fr.cg95.cvq.business.request.social.HccrDwellingReceptionKindType getDwellingReceptionType() {
        return this.dwellingReceptionType;
    }
  
    
      @NotNull(
        
        
        profiles = {"dwelling"},
        message = "dwellingSocialReception"
      )
    
    private Boolean dwellingSocialReception;

    public void setDwellingSocialReception(final Boolean dwellingSocialReception) {
        this.dwellingSocialReception = dwellingSocialReception;
    }

 
    @Column(name="dwelling_social_reception"  )
      
    public Boolean getDwellingSocialReception() {
        return this.dwellingSocialReception;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dwellingSocialReception'].test(_this.dwellingSocialReception.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"dwelling"},
        message = "dwellingSocialReceptionAddress"
      )
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dwellingSocialReception'].test(_this.dwellingSocialReception.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"dwelling"},
        message = "dwellingSocialReceptionAddress"
      )
    
    private fr.cg95.cvq.business.users.Address dwellingSocialReceptionAddress;

    public void setDwellingSocialReceptionAddress(final fr.cg95.cvq.business.users.Address dwellingSocialReceptionAddress) {
        this.dwellingSocialReceptionAddress = dwellingSocialReceptionAddress;
    }

 
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="dwelling_social_reception_address_id")
      
    public fr.cg95.cvq.business.users.Address getDwellingSocialReceptionAddress() {
        return this.dwellingSocialReceptionAddress;
    }
  
    
      @MaxLength(
        
          value = 80,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dwellingSocialReception'].test(_this.dwellingSocialReception.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"dwelling"},
        message = "dwellingSocialReceptionNaming"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dwellingSocialReception'].test(_this.dwellingSocialReception.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"dwelling"},
        message = "dwellingSocialReceptionNaming"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dwellingSocialReception'].test(_this.dwellingSocialReception.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"dwelling"},
        message = "dwellingSocialReceptionNaming"
      )
    
    private String dwellingSocialReceptionNaming;

    public void setDwellingSocialReceptionNaming(final String dwellingSocialReceptionNaming) {
        this.dwellingSocialReceptionNaming = dwellingSocialReceptionNaming;
    }

 
    @Column(name="dwelling_social_reception_naming" , length=80 )
      
    public String getDwellingSocialReceptionNaming() {
        return this.dwellingSocialReceptionNaming;
    }
  
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "facilitiesAnimalAid"
      )
    
    private Boolean facilitiesAnimalAid;

    public void setFacilitiesAnimalAid(final Boolean facilitiesAnimalAid) {
        this.facilitiesAnimalAid = facilitiesAnimalAid;
    }

 
    @Column(name="facilities_animal_aid"  )
      
    public Boolean getFacilitiesAnimalAid() {
        return this.facilitiesAnimalAid;
    }
  
    
      @MaxLength(
        
          value = 60,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['facilitiesAnimalAid'].test(_this.facilitiesAnimalAid.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "facilitiesAnimalAidDetails"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['facilitiesAnimalAid'].test(_this.facilitiesAnimalAid.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "facilitiesAnimalAidDetails"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['facilitiesAnimalAid'].test(_this.facilitiesAnimalAid.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "facilitiesAnimalAidDetails"
      )
    
    private String facilitiesAnimalAidDetails;

    public void setFacilitiesAnimalAidDetails(final String facilitiesAnimalAidDetails) {
        this.facilitiesAnimalAidDetails = facilitiesAnimalAidDetails;
    }

 
    @Column(name="facilities_animal_aid_details" , length=60 )
      
    public String getFacilitiesAnimalAidDetails() {
        return this.facilitiesAnimalAidDetails;
    }
  
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "facilitiesCustomCar"
      )
    
    private Boolean facilitiesCustomCar;

    public void setFacilitiesCustomCar(final Boolean facilitiesCustomCar) {
        this.facilitiesCustomCar = facilitiesCustomCar;
    }

 
    @Column(name="facilities_custom_car"  )
      
    public Boolean getFacilitiesCustomCar() {
        return this.facilitiesCustomCar;
    }
  
    
      @MaxLength(
        
          value = 60,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['facilitiesCustomCar'].test(_this.facilitiesCustomCar.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "facilitiesCustomCarDetails"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['facilitiesCustomCar'].test(_this.facilitiesCustomCar.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "facilitiesCustomCarDetails"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['facilitiesCustomCar'].test(_this.facilitiesCustomCar.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "facilitiesCustomCarDetails"
      )
    
    private String facilitiesCustomCarDetails;

    public void setFacilitiesCustomCarDetails(final String facilitiesCustomCarDetails) {
        this.facilitiesCustomCarDetails = facilitiesCustomCarDetails;
    }

 
    @Column(name="facilities_custom_car_details" , length=60 )
      
    public String getFacilitiesCustomCarDetails() {
        return this.facilitiesCustomCarDetails;
    }
  
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "facilitiesHousing"
      )
    
    private Boolean facilitiesHousing;

    public void setFacilitiesHousing(final Boolean facilitiesHousing) {
        this.facilitiesHousing = facilitiesHousing;
    }

 
    @Column(name="facilities_housing"  )
      
    public Boolean getFacilitiesHousing() {
        return this.facilitiesHousing;
    }
  
    
      @MaxLength(
        
          value = 60,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['facilitiesHousing'].test(_this.facilitiesHousing.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "facilitiesHousingDetails"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['facilitiesHousing'].test(_this.facilitiesHousing.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "facilitiesHousingDetails"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['facilitiesHousing'].test(_this.facilitiesHousing.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "facilitiesHousingDetails"
      )
    
    private String facilitiesHousingDetails;

    public void setFacilitiesHousingDetails(final String facilitiesHousingDetails) {
        this.facilitiesHousingDetails = facilitiesHousingDetails;
    }

 
    @Column(name="facilities_housing_details" , length=60 )
      
    public String getFacilitiesHousingDetails() {
        return this.facilitiesHousingDetails;
    }
  
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "facilitiesSpecializedTransport"
      )
    
    private Boolean facilitiesSpecializedTransport;

    public void setFacilitiesSpecializedTransport(final Boolean facilitiesSpecializedTransport) {
        this.facilitiesSpecializedTransport = facilitiesSpecializedTransport;
    }

 
    @Column(name="facilities_specialized_transport"  )
      
    public Boolean getFacilitiesSpecializedTransport() {
        return this.facilitiesSpecializedTransport;
    }
  
    
      @MaxLength(
        
          value = 60,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['facilitiesSpecializedTransport'].test(_this.facilitiesSpecializedTransport.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "facilitiesSpecializedTransportDetails"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['facilitiesSpecializedTransport'].test(_this.facilitiesSpecializedTransport.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "facilitiesSpecializedTransportDetails"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['facilitiesSpecializedTransport'].test(_this.facilitiesSpecializedTransport.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "facilitiesSpecializedTransportDetails"
      )
    
    private String facilitiesSpecializedTransportDetails;

    public void setFacilitiesSpecializedTransportDetails(final String facilitiesSpecializedTransportDetails) {
        this.facilitiesSpecializedTransportDetails = facilitiesSpecializedTransportDetails;
    }

 
    @Column(name="facilities_specialized_transport_details" , length=60 )
      
    public String getFacilitiesSpecializedTransportDetails() {
        return this.facilitiesSpecializedTransportDetails;
    }
  
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "facilitiesTechnicalAssistance"
      )
    
    private Boolean facilitiesTechnicalAssistance;

    public void setFacilitiesTechnicalAssistance(final Boolean facilitiesTechnicalAssistance) {
        this.facilitiesTechnicalAssistance = facilitiesTechnicalAssistance;
    }

 
    @Column(name="facilities_technical_assistance"  )
      
    public Boolean getFacilitiesTechnicalAssistance() {
        return this.facilitiesTechnicalAssistance;
    }
  
    
      @MaxLength(
        
          value = 60,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['facilitiesTechnicalAssistance'].test(_this.facilitiesTechnicalAssistance.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "facilitiesTechnicalAssistanceDetails"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['facilitiesTechnicalAssistance'].test(_this.facilitiesTechnicalAssistance.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "facilitiesTechnicalAssistanceDetails"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['facilitiesTechnicalAssistance'].test(_this.facilitiesTechnicalAssistance.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "facilitiesTechnicalAssistanceDetails"
      )
    
    private String facilitiesTechnicalAssistanceDetails;

    public void setFacilitiesTechnicalAssistanceDetails(final String facilitiesTechnicalAssistanceDetails) {
        this.facilitiesTechnicalAssistanceDetails = facilitiesTechnicalAssistanceDetails;
    }

 
    @Column(name="facilities_technical_assistance_details" , length=60 )
      
    public String getFacilitiesTechnicalAssistanceDetails() {
        return this.facilitiesTechnicalAssistanceDetails;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['isFamilyAssistance'].test(_this.isFamilyAssistance.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "familyAssistanceMembers"
      )
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['isFamilyAssistance'].test(_this.isFamilyAssistance.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "familyAssistanceMembers"
      )
    
    private List<fr.cg95.cvq.business.request.social.HccrFamilyAssistanceMember> familyAssistanceMembers;

    public void setFamilyAssistanceMembers(final List<fr.cg95.cvq.business.request.social.HccrFamilyAssistanceMember> familyAssistanceMembers) {
        this.familyAssistanceMembers = familyAssistanceMembers;
    }

 
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @OrderColumn(name="family_assistance_members_index")
    @JoinColumn(name="handicap_compensation_child_request_id")
      
    public List<fr.cg95.cvq.business.request.social.HccrFamilyAssistanceMember> getFamilyAssistanceMembers() {
        return this.familyAssistanceMembers;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['referentFamilyDependents'].test(_this.referentFamilyDependents.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "familyDependents"
      )
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['referentFamilyDependents'].test(_this.referentFamilyDependents.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "familyDependents"
      )
    
    private List<fr.cg95.cvq.business.request.social.HccrFamilyDependent> familyDependents;

    public void setFamilyDependents(final List<fr.cg95.cvq.business.request.social.HccrFamilyDependent> familyDependents) {
        this.familyDependents = familyDependents;
    }

 
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @OrderColumn(name="family_dependents_index")
    @JoinColumn(name="handicap_compensation_child_request_id")
      
    public List<fr.cg95.cvq.business.request.social.HccrFamilyDependent> getFamilyDependents() {
        return this.familyDependents;
    }
  
    
    private Boolean fatherActivityReduction;

    public void setFatherActivityReduction(final Boolean fatherActivityReduction) {
        this.fatherActivityReduction = fatherActivityReduction;
    }

 
    @Column(name="father_activity_reduction"  )
      
    public Boolean getFatherActivityReduction() {
        return this.fatherActivityReduction;
    }
  
    
    private java.math.BigInteger fatherActivityReductionRatio;

    public void setFatherActivityReductionRatio(final java.math.BigInteger fatherActivityReductionRatio) {
        this.fatherActivityReductionRatio = fatherActivityReductionRatio;
    }

 
    @Column(name="father_activity_reduction_ratio" , columnDefinition="bytea" )
    @Type(type="serializable") //Hack see http://capdemat.capwebct.fr/ticket/338
      
    public java.math.BigInteger getFatherActivityReductionRatio() {
        return this.fatherActivityReductionRatio;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['subjectBirthDate'].test(_this.subjectBirthDate.toString());" +
                
              
            
            "return active",
        
        profiles = {"subject"},
        message = "fatherFirstName"
      )
    
    private String fatherFirstName;

    public void setFatherFirstName(final String fatherFirstName) {
        this.fatherFirstName = fatherFirstName;
    }

 
    @Column(name="father_first_name" , length=38 )
      
    public String getFatherFirstName() {
        return this.fatherFirstName;
    }
  
    
      @MaxLength(
        
          value = 60,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['subjectBirthDate'].test(_this.subjectBirthDate.toString());" +
                
              
            
            "return active",
        
        profiles = {"subject"},
        message = "fatherJob"
      )
    
    private String fatherJob;

    public void setFatherJob(final String fatherJob) {
        this.fatherJob = fatherJob;
    }

 
    @Column(name="father_job" , length=60 )
      
    public String getFatherJob() {
        return this.fatherJob;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['subjectBirthDate'].test(_this.subjectBirthDate.toString());" +
                
              
            
            "return active",
        
        profiles = {"subject"},
        message = "fatherLastName"
      )
    
    private String fatherLastName;

    public void setFatherLastName(final String fatherLastName) {
        this.fatherLastName = fatherLastName;
    }

 
    @Column(name="father_last_name" , length=38 )
      
    public String getFatherLastName() {
        return this.fatherLastName;
    }
  
    
      @NotNull(
        
        
        profiles = {"folders"},
        message = "foldersCdes"
      )
    
    private Boolean foldersCdes;

    public void setFoldersCdes(final Boolean foldersCdes) {
        this.foldersCdes = foldersCdes;
    }

 
    @Column(name="folders_cdes"  )
      
    public Boolean getFoldersCdes() {
        return this.foldersCdes;
    }
  
    
      @MaxLength(
        
          value = 2,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['foldersCdes'].test(_this.foldersCdes.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"folders"},
        message = "foldersCdesDepartment"
      )
    
    private String foldersCdesDepartment;

    public void setFoldersCdesDepartment(final String foldersCdesDepartment) {
        this.foldersCdesDepartment = foldersCdesDepartment;
    }

 
    @Column(name="folders_cdes_department" , length=2 )
      
    public String getFoldersCdesDepartment() {
        return this.foldersCdesDepartment;
    }
  
    
      @MaxLength(
        
          value = 30,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['foldersCdes'].test(_this.foldersCdes.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"folders"},
        message = "foldersCdesNumber"
      )
    
    private String foldersCdesNumber;

    public void setFoldersCdesNumber(final String foldersCdesNumber) {
        this.foldersCdesNumber = foldersCdesNumber;
    }

 
    @Column(name="folders_cdes_number" , length=30 )
      
    public String getFoldersCdesNumber() {
        return this.foldersCdesNumber;
    }
  
    
      @NotNull(
        
        
        profiles = {"folders"},
        message = "foldersCotorep"
      )
    
    private Boolean foldersCotorep;

    public void setFoldersCotorep(final Boolean foldersCotorep) {
        this.foldersCotorep = foldersCotorep;
    }

 
    @Column(name="folders_cotorep"  )
      
    public Boolean getFoldersCotorep() {
        return this.foldersCotorep;
    }
  
    
      @MaxLength(
        
          value = 2,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['foldersCotorep'].test(_this.foldersCotorep.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"folders"},
        message = "foldersCotorepDepartment"
      )
    
    private String foldersCotorepDepartment;

    public void setFoldersCotorepDepartment(final String foldersCotorepDepartment) {
        this.foldersCotorepDepartment = foldersCotorepDepartment;
    }

 
    @Column(name="folders_cotorep_department" , length=2 )
      
    public String getFoldersCotorepDepartment() {
        return this.foldersCotorepDepartment;
    }
  
    
      @MaxLength(
        
          value = 30,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['foldersCotorep'].test(_this.foldersCotorep.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"folders"},
        message = "foldersCotorepNumber"
      )
    
    private String foldersCotorepNumber;

    public void setFoldersCotorepNumber(final String foldersCotorepNumber) {
        this.foldersCotorepNumber = foldersCotorepNumber;
    }

 
    @Column(name="folders_cotorep_number" , length=30 )
      
    public String getFoldersCotorepNumber() {
        return this.foldersCotorepNumber;
    }
  
    
      @NotNull(
        
        
        profiles = {"folders"},
        message = "foldersMdph"
      )
    
    private Boolean foldersMdph;

    public void setFoldersMdph(final Boolean foldersMdph) {
        this.foldersMdph = foldersMdph;
    }

 
    @Column(name="folders_mdph"  )
      
    public Boolean getFoldersMdph() {
        return this.foldersMdph;
    }
  
    
      @MaxLength(
        
          value = 2,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['foldersMdph'].test(_this.foldersMdph.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"folders"},
        message = "foldersMdphDepartment"
      )
    
    private String foldersMdphDepartment;

    public void setFoldersMdphDepartment(final String foldersMdphDepartment) {
        this.foldersMdphDepartment = foldersMdphDepartment;
    }

 
    @Column(name="folders_mdph_department" , length=2 )
      
    public String getFoldersMdphDepartment() {
        return this.foldersMdphDepartment;
    }
  
    
      @MaxLength(
        
          value = 30,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['foldersMdph'].test(_this.foldersMdph.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"folders"},
        message = "foldersMdphNumber"
      )
    
    private String foldersMdphNumber;

    public void setFoldersMdphNumber(final String foldersMdphNumber) {
        this.foldersMdphNumber = foldersMdphNumber;
    }

 
    @Column(name="folders_mdph_number" , length=30 )
      
    public String getFoldersMdphNumber() {
        return this.foldersMdphNumber;
    }
  
    
      @NotNull(
        
        
        profiles = {"folders"},
        message = "foldersOtherFolders"
      )
    
    private Boolean foldersOtherFolders;

    public void setFoldersOtherFolders(final Boolean foldersOtherFolders) {
        this.foldersOtherFolders = foldersOtherFolders;
    }

 
    @Column(name="folders_other_folders"  )
      
    public Boolean getFoldersOtherFolders() {
        return this.foldersOtherFolders;
    }
  
    
      @MaxLength(
        
          value = 120,
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "formationCurrentFormation"
      )
    
    private String formationCurrentFormation;

    public void setFormationCurrentFormation(final String formationCurrentFormation) {
        this.formationCurrentFormation = formationCurrentFormation;
    }

 
    @Column(name="formation_current_formation" , length=120 )
      
    public String getFormationCurrentFormation() {
        return this.formationCurrentFormation;
    }
  
    
      @MaxLength(
        
          value = 120,
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "formationDiploma"
      )
    
    private String formationDiploma;

    public void setFormationDiploma(final String formationDiploma) {
        this.formationDiploma = formationDiploma;
    }

 
    @Column(name="formation_diploma" , length=120 )
      
    public String getFormationDiploma() {
        return this.formationDiploma;
    }
  
    
      @MaxLength(
        
          value = 180,
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "formationPreviousFormation"
      )
    
    private String formationPreviousFormation;

    public void setFormationPreviousFormation(final String formationPreviousFormation) {
        this.formationPreviousFormation = formationPreviousFormation;
    }

 
    @Column(name="formation_previous_formation" , length=180 )
      
    public String getFormationPreviousFormation() {
        return this.formationPreviousFormation;
    }
  
    
      @MaxLength(
        
          value = 30,
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "formationStudiesLevel"
      )
    
    private String formationStudiesLevel;

    public void setFormationStudiesLevel(final String formationStudiesLevel) {
        this.formationStudiesLevel = formationStudiesLevel;
    }

 
    @Column(name="formation_studies_level" , length=30 )
      
    public String getFormationStudiesLevel() {
        return this.formationStudiesLevel;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['healthFollowedByDoctor'].test(_this.healthFollowedByDoctor.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"health"},
        message = "healthDoctorFirstName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['healthFollowedByDoctor'].test(_this.healthFollowedByDoctor.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"health"},
        message = "healthDoctorFirstName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['healthFollowedByDoctor'].test(_this.healthFollowedByDoctor.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"health"},
        message = "healthDoctorFirstName"
      )
    
    private String healthDoctorFirstName;

    public void setHealthDoctorFirstName(final String healthDoctorFirstName) {
        this.healthDoctorFirstName = healthDoctorFirstName;
    }

 
    @Column(name="health_doctor_first_name" , length=38 )
      
    public String getHealthDoctorFirstName() {
        return this.healthDoctorFirstName;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['healthFollowedByDoctor'].test(_this.healthFollowedByDoctor.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"health"},
        message = "healthDoctorLastName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['healthFollowedByDoctor'].test(_this.healthFollowedByDoctor.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"health"},
        message = "healthDoctorLastName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['healthFollowedByDoctor'].test(_this.healthFollowedByDoctor.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"health"},
        message = "healthDoctorLastName"
      )
    
    private String healthDoctorLastName;

    public void setHealthDoctorLastName(final String healthDoctorLastName) {
        this.healthDoctorLastName = healthDoctorLastName;
    }

 
    @Column(name="health_doctor_last_name" , length=38 )
      
    public String getHealthDoctorLastName() {
        return this.healthDoctorLastName;
    }
  
    
      @NotNull(
        
        
        profiles = {"health"},
        message = "healthFollowedByDoctor"
      )
    
    private Boolean healthFollowedByDoctor;

    public void setHealthFollowedByDoctor(final Boolean healthFollowedByDoctor) {
        this.healthFollowedByDoctor = healthFollowedByDoctor;
    }

 
    @Column(name="health_followed_by_doctor"  )
      
    public Boolean getHealthFollowedByDoctor() {
        return this.healthFollowedByDoctor;
    }
  
    
      @NotNull(
        
        
        profiles = {"health"},
        message = "healthFollowedByHospital"
      )
    
    private Boolean healthFollowedByHospital;

    public void setHealthFollowedByHospital(final Boolean healthFollowedByHospital) {
        this.healthFollowedByHospital = healthFollowedByHospital;
    }

 
    @Column(name="health_followed_by_hospital"  )
      
    public Boolean getHealthFollowedByHospital() {
        return this.healthFollowedByHospital;
    }
  
    
      @NotNull(
        
        
        profiles = {"health"},
        message = "healthFollowedByProfessional"
      )
    
    private Boolean healthFollowedByProfessional;

    public void setHealthFollowedByProfessional(final Boolean healthFollowedByProfessional) {
        this.healthFollowedByProfessional = healthFollowedByProfessional;
    }

 
    @Column(name="health_followed_by_professional"  )
      
    public Boolean getHealthFollowedByProfessional() {
        return this.healthFollowedByProfessional;
    }
  
    
      @MaxLength(
        
          value = 60,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['healthFollowedByHospital'].test(_this.healthFollowedByHospital.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"health"},
        message = "healthHospitalName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['healthFollowedByHospital'].test(_this.healthFollowedByHospital.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"health"},
        message = "healthHospitalName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['healthFollowedByHospital'].test(_this.healthFollowedByHospital.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"health"},
        message = "healthHospitalName"
      )
    
    private String healthHospitalName;

    public void setHealthHospitalName(final String healthHospitalName) {
        this.healthHospitalName = healthHospitalName;
    }

 
    @Column(name="health_hospital_name" , length=60 )
      
    public String getHealthHospitalName() {
        return this.healthHospitalName;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['healthFollowedByProfessional'].test(_this.healthFollowedByProfessional.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"health"},
        message = "healthProfessionalFirstName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['healthFollowedByProfessional'].test(_this.healthFollowedByProfessional.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"health"},
        message = "healthProfessionalFirstName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['healthFollowedByProfessional'].test(_this.healthFollowedByProfessional.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"health"},
        message = "healthProfessionalFirstName"
      )
    
    private String healthProfessionalFirstName;

    public void setHealthProfessionalFirstName(final String healthProfessionalFirstName) {
        this.healthProfessionalFirstName = healthProfessionalFirstName;
    }

 
    @Column(name="health_professional_first_name" , length=38 )
      
    public String getHealthProfessionalFirstName() {
        return this.healthProfessionalFirstName;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['healthFollowedByProfessional'].test(_this.healthFollowedByProfessional.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"health"},
        message = "healthProfessionalLastName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['healthFollowedByProfessional'].test(_this.healthFollowedByProfessional.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"health"},
        message = "healthProfessionalLastName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['healthFollowedByProfessional'].test(_this.healthFollowedByProfessional.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"health"},
        message = "healthProfessionalLastName"
      )
    
    private String healthProfessionalLastName;

    public void setHealthProfessionalLastName(final String healthProfessionalLastName) {
        this.healthProfessionalLastName = healthProfessionalLastName;
    }

 
    @Column(name="health_professional_last_name" , length=38 )
      
    public String getHealthProfessionalLastName() {
        return this.healthProfessionalLastName;
    }
  
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['homeInterventionHomeIntervenant'].test(_this.homeInterventionHomeIntervenant.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "homeIntervenants"
      )
    
    private List<fr.cg95.cvq.business.request.social.HccrHomeIntervenant> homeIntervenants;

    public void setHomeIntervenants(final List<fr.cg95.cvq.business.request.social.HccrHomeIntervenant> homeIntervenants) {
        this.homeIntervenants = homeIntervenants;
    }

 
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @OrderColumn(name="home_intervenants_index")
    @JoinColumn(name="handicap_compensation_child_request_id")
      
    public List<fr.cg95.cvq.business.request.social.HccrHomeIntervenant> getHomeIntervenants() {
        return this.homeIntervenants;
    }
  
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "homeInterventionHomeIntervenant"
      )
    
    private Boolean homeInterventionHomeIntervenant;

    public void setHomeInterventionHomeIntervenant(final Boolean homeInterventionHomeIntervenant) {
        this.homeInterventionHomeIntervenant = homeInterventionHomeIntervenant;
    }

 
    @Column(name="home_intervention_home_intervenant"  )
      
    public Boolean getHomeInterventionHomeIntervenant() {
        return this.homeInterventionHomeIntervenant;
    }
  
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "isFamilyAssistance"
      )
    
    private Boolean isFamilyAssistance;

    public void setIsFamilyAssistance(final Boolean isFamilyAssistance) {
        this.isFamilyAssistance = isFamilyAssistance;
    }

 
    @Column(name="is_family_assistance"  )
      
    public Boolean getIsFamilyAssistance() {
        return this.isFamilyAssistance;
    }
  
    
    private Boolean motherActivityReduction;

    public void setMotherActivityReduction(final Boolean motherActivityReduction) {
        this.motherActivityReduction = motherActivityReduction;
    }

 
    @Column(name="mother_activity_reduction"  )
      
    public Boolean getMotherActivityReduction() {
        return this.motherActivityReduction;
    }
  
    
    private java.math.BigInteger motherActivityReductionRatio;

    public void setMotherActivityReductionRatio(final java.math.BigInteger motherActivityReductionRatio) {
        this.motherActivityReductionRatio = motherActivityReductionRatio;
    }

 
    @Column(name="mother_activity_reduction_ratio" , columnDefinition="bytea" )
    @Type(type="serializable") //Hack see http://capdemat.capwebct.fr/ticket/338
      
    public java.math.BigInteger getMotherActivityReductionRatio() {
        return this.motherActivityReductionRatio;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['subjectBirthDate'].test(_this.subjectBirthDate.toString());" +
                
              
            
            "return active",
        
        profiles = {"subject"},
        message = "motherFirstName"
      )
    
    private String motherFirstName;

    public void setMotherFirstName(final String motherFirstName) {
        this.motherFirstName = motherFirstName;
    }

 
    @Column(name="mother_first_name" , length=38 )
      
    public String getMotherFirstName() {
        return this.motherFirstName;
    }
  
    
      @MaxLength(
        
          value = 60,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['subjectBirthDate'].test(_this.subjectBirthDate.toString());" +
                
              
            
            "return active",
        
        profiles = {"subject"},
        message = "motherJob"
      )
    
    private String motherJob;

    public void setMotherJob(final String motherJob) {
        this.motherJob = motherJob;
    }

 
    @Column(name="mother_job" , length=60 )
      
    public String getMotherJob() {
        return this.motherJob;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['subjectBirthDate'].test(_this.subjectBirthDate.toString());" +
                
              
            
            "return active",
        
        profiles = {"subject"},
        message = "motherLastName"
      )
    
    private String motherLastName;

    public void setMotherLastName(final String motherLastName) {
        this.motherLastName = motherLastName;
    }

 
    @Column(name="mother_last_name" , length=38 )
      
    public String getMotherLastName() {
        return this.motherLastName;
    }
  
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['benefitsOtherBenefits'].test(_this.benefitsOtherBenefits.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"benefits"},
        message = "otherBenefits"
      )
    
    private List<fr.cg95.cvq.business.request.social.HccrOtherBenefit> otherBenefits;

    public void setOtherBenefits(final List<fr.cg95.cvq.business.request.social.HccrOtherBenefit> otherBenefits) {
        this.otherBenefits = otherBenefits;
    }

 
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @OrderColumn(name="other_benefits_index")
    @JoinColumn(name="handicap_compensation_child_request_id")
      
    public List<fr.cg95.cvq.business.request.social.HccrOtherBenefit> getOtherBenefits() {
        return this.otherBenefits;
    }
  
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['foldersOtherFolders'].test(_this.foldersOtherFolders.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"folders"},
        message = "otherFolders"
      )
    
    private List<fr.cg95.cvq.business.request.social.HccrOtherFolder> otherFolders;

    public void setOtherFolders(final List<fr.cg95.cvq.business.request.social.HccrOtherFolder> otherFolders) {
        this.otherFolders = otherFolders;
    }

 
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @OrderColumn(name="other_folders_index")
    @JoinColumn(name="handicap_compensation_child_request_id")
      
    public List<fr.cg95.cvq.business.request.social.HccrOtherFolder> getOtherFolders() {
        return this.otherFolders;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['paymentAgencyBeneficiary'].test(_this.paymentAgencyBeneficiary.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"socialSecurityAndPaymentAgency"},
        message = "paymentAgencyAddress"
      )
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['paymentAgencyBeneficiary'].test(_this.paymentAgencyBeneficiary.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"socialSecurityAndPaymentAgency"},
        message = "paymentAgencyAddress"
      )
    
    private fr.cg95.cvq.business.users.Address paymentAgencyAddress;

    public void setPaymentAgencyAddress(final fr.cg95.cvq.business.users.Address paymentAgencyAddress) {
        this.paymentAgencyAddress = paymentAgencyAddress;
    }

 
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="payment_agency_address_id")
      
    public fr.cg95.cvq.business.users.Address getPaymentAgencyAddress() {
        return this.paymentAgencyAddress;
    }
  
    
      @NotNull(
        
        
        profiles = {"socialSecurityAndPaymentAgency"},
        message = "paymentAgencyBeneficiary"
      )
    
    private fr.cg95.cvq.business.request.social.HccrPaymentAgencyBeneficiaryType paymentAgencyBeneficiary;

    public void setPaymentAgencyBeneficiary(final fr.cg95.cvq.business.request.social.HccrPaymentAgencyBeneficiaryType paymentAgencyBeneficiary) {
        this.paymentAgencyBeneficiary = paymentAgencyBeneficiary;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="payment_agency_beneficiary"  )
      
    public fr.cg95.cvq.business.request.social.HccrPaymentAgencyBeneficiaryType getPaymentAgencyBeneficiary() {
        return this.paymentAgencyBeneficiary;
    }
  
    
      @MaxLength(
        
          value = 20,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['paymentAgencyBeneficiary'].test(_this.paymentAgencyBeneficiary.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"socialSecurityAndPaymentAgency"},
        message = "paymentAgencyBeneficiaryNumber"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['paymentAgencyBeneficiary'].test(_this.paymentAgencyBeneficiary.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"socialSecurityAndPaymentAgency"},
        message = "paymentAgencyBeneficiaryNumber"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['paymentAgencyBeneficiary'].test(_this.paymentAgencyBeneficiary.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"socialSecurityAndPaymentAgency"},
        message = "paymentAgencyBeneficiaryNumber"
      )
    
    private String paymentAgencyBeneficiaryNumber;

    public void setPaymentAgencyBeneficiaryNumber(final String paymentAgencyBeneficiaryNumber) {
        this.paymentAgencyBeneficiaryNumber = paymentAgencyBeneficiaryNumber;
    }

 
    @Column(name="payment_agency_beneficiary_number" , length=20 )
      
    public String getPaymentAgencyBeneficiaryNumber() {
        return this.paymentAgencyBeneficiaryNumber;
    }
  
    
      @MaxLength(
        
          value = 50,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['paymentAgencyBeneficiary'].test(_this.paymentAgencyBeneficiary.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"socialSecurityAndPaymentAgency"},
        message = "paymentAgencyName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['paymentAgencyBeneficiary'].test(_this.paymentAgencyBeneficiary.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"socialSecurityAndPaymentAgency"},
        message = "paymentAgencyName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['paymentAgencyBeneficiary'].test(_this.paymentAgencyBeneficiary.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"socialSecurityAndPaymentAgency"},
        message = "paymentAgencyName"
      )
    
    private String paymentAgencyName;

    public void setPaymentAgencyName(final String paymentAgencyName) {
        this.paymentAgencyName = paymentAgencyName;
    }

 
    @Column(name="payment_agency_name" , length=50 )
      
    public String getPaymentAgencyName() {
        return this.paymentAgencyName;
    }
  
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalStatusKind'].test('isEmployed='+_this.professionalStatusKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusAddress"
      )
    
    private fr.cg95.cvq.business.users.Address professionalStatusAddress;

    public void setProfessionalStatusAddress(final fr.cg95.cvq.business.users.Address professionalStatusAddress) {
        this.professionalStatusAddress = professionalStatusAddress;
    }

 
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="professional_status_address_id")
      
    public fr.cg95.cvq.business.users.Address getProfessionalStatusAddress() {
        return this.professionalStatusAddress;
    }
  
    
      @NotNull(
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusDate"
      )
    
    private java.util.Date professionalStatusDate;

    public void setProfessionalStatusDate(final java.util.Date professionalStatusDate) {
        this.professionalStatusDate = professionalStatusDate;
    }

 
    @Column(name="professional_status_date"  )
      
    public java.util.Date getProfessionalStatusDate() {
        return this.professionalStatusDate;
    }
  
    
      @NotNull(
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusElectiveFunction"
      )
    
    private Boolean professionalStatusElectiveFunction;

    public void setProfessionalStatusElectiveFunction(final Boolean professionalStatusElectiveFunction) {
        this.professionalStatusElectiveFunction = professionalStatusElectiveFunction;
    }

 
    @Column(name="professional_status_elective_function"  )
      
    public Boolean getProfessionalStatusElectiveFunction() {
        return this.professionalStatusElectiveFunction;
    }
  
    
      @MaxLength(
        
          value = 60,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalStatusElectiveFunction'].test(_this.professionalStatusElectiveFunction.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusElectiveFunctionDetails"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalStatusElectiveFunction'].test(_this.professionalStatusElectiveFunction.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusElectiveFunctionDetails"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalStatusElectiveFunction'].test(_this.professionalStatusElectiveFunction.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusElectiveFunctionDetails"
      )
    
    private String professionalStatusElectiveFunctionDetails;

    public void setProfessionalStatusElectiveFunctionDetails(final String professionalStatusElectiveFunctionDetails) {
        this.professionalStatusElectiveFunctionDetails = professionalStatusElectiveFunctionDetails;
    }

 
    @Column(name="professional_status_elective_function_details" , length=60 )
      
    public String getProfessionalStatusElectiveFunctionDetails() {
        return this.professionalStatusElectiveFunctionDetails;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalStatusKind'].test('isEmployed='+_this.professionalStatusKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusEmployerName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalStatusKind'].test('isEmployed='+_this.professionalStatusKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusEmployerName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalStatusKind'].test('isEmployed='+_this.professionalStatusKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusEmployerName"
      )
    
    private String professionalStatusEmployerName;

    public void setProfessionalStatusEmployerName(final String professionalStatusEmployerName) {
        this.professionalStatusEmployerName = professionalStatusEmployerName;
    }

 
    @Column(name="professional_status_employer_name" , length=38 )
      
    public String getProfessionalStatusEmployerName() {
        return this.professionalStatusEmployerName;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalStatusKind'].test('isEmployed='+_this.professionalStatusKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusEnvironment"
      )
    
    private fr.cg95.cvq.business.request.social.HccrProfessionalStatusEnvironmentType professionalStatusEnvironment;

    public void setProfessionalStatusEnvironment(final fr.cg95.cvq.business.request.social.HccrProfessionalStatusEnvironmentType professionalStatusEnvironment) {
        this.professionalStatusEnvironment = professionalStatusEnvironment;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="professional_status_environment"  )
      
    public fr.cg95.cvq.business.request.social.HccrProfessionalStatusEnvironmentType getProfessionalStatusEnvironment() {
        return this.professionalStatusEnvironment;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalStatusKind'].test('isUnemployed='+_this.professionalStatusKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusIndemnified"
      )
    
    private Boolean professionalStatusIndemnified;

    public void setProfessionalStatusIndemnified(final Boolean professionalStatusIndemnified) {
        this.professionalStatusIndemnified = professionalStatusIndemnified;
    }

 
    @Column(name="professional_status_indemnified"  )
      
    public Boolean getProfessionalStatusIndemnified() {
        return this.professionalStatusIndemnified;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalStatusIndemnified'].test(_this.professionalStatusIndemnified.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusIndemnifiedDate"
      )
    
    private java.util.Date professionalStatusIndemnifiedDate;

    public void setProfessionalStatusIndemnifiedDate(final java.util.Date professionalStatusIndemnifiedDate) {
        this.professionalStatusIndemnifiedDate = professionalStatusIndemnifiedDate;
    }

 
    @Column(name="professional_status_indemnified_date"  )
      
    public java.util.Date getProfessionalStatusIndemnifiedDate() {
        return this.professionalStatusIndemnifiedDate;
    }
  
    
      @NotNull(
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusKind"
      )
    
    private fr.cg95.cvq.business.request.social.HccrProfessionalStatusKindType professionalStatusKind;

    public void setProfessionalStatusKind(final fr.cg95.cvq.business.request.social.HccrProfessionalStatusKindType professionalStatusKind) {
        this.professionalStatusKind = professionalStatusKind;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="professional_status_kind"  )
      
    public fr.cg95.cvq.business.request.social.HccrProfessionalStatusKindType getProfessionalStatusKind() {
        return this.professionalStatusKind;
    }
  
    
      @MaxLength(
        
          value = 60,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalStatusKind'].test('isEmployed='+_this.professionalStatusKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusProfession"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalStatusKind'].test('isEmployed='+_this.professionalStatusKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusProfession"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalStatusKind'].test('isEmployed='+_this.professionalStatusKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusProfession"
      )
    
    private String professionalStatusProfession;

    public void setProfessionalStatusProfession(final String professionalStatusProfession) {
        this.professionalStatusProfession = professionalStatusProfession;
    }

 
    @Column(name="professional_status_profession" , length=60 )
      
    public String getProfessionalStatusProfession() {
        return this.professionalStatusProfession;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalStatusKind'].test('isUnemployed='+_this.professionalStatusKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusRegisterAsUnemployed"
      )
    
    private Boolean professionalStatusRegisterAsUnemployed;

    public void setProfessionalStatusRegisterAsUnemployed(final Boolean professionalStatusRegisterAsUnemployed) {
        this.professionalStatusRegisterAsUnemployed = professionalStatusRegisterAsUnemployed;
    }

 
    @Column(name="professional_status_register_as_unemployed"  )
      
    public Boolean getProfessionalStatusRegisterAsUnemployed() {
        return this.professionalStatusRegisterAsUnemployed;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalStatusRegisterAsUnemployed'].test(_this.professionalStatusRegisterAsUnemployed.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusRegisterAsUnemployedDate"
      )
    
    private java.util.Date professionalStatusRegisterAsUnemployedDate;

    public void setProfessionalStatusRegisterAsUnemployedDate(final java.util.Date professionalStatusRegisterAsUnemployedDate) {
        this.professionalStatusRegisterAsUnemployedDate = professionalStatusRegisterAsUnemployedDate;
    }

 
    @Column(name="professional_status_register_as_unemployed_date"  )
      
    public java.util.Date getProfessionalStatusRegisterAsUnemployedDate() {
        return this.professionalStatusRegisterAsUnemployedDate;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalSupportProfessionals'].test(_this.professionalSupportProfessionals.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "professionalSupportDealsWithSameProfessional"
      )
    
    private Boolean professionalSupportDealsWithSameProfessional;

    public void setProfessionalSupportDealsWithSameProfessional(final Boolean professionalSupportDealsWithSameProfessional) {
        this.professionalSupportDealsWithSameProfessional = professionalSupportDealsWithSameProfessional;
    }

 
    @Column(name="professional_support_deals_with_same_professional"  )
      
    public Boolean getProfessionalSupportDealsWithSameProfessional() {
        return this.professionalSupportDealsWithSameProfessional;
    }
  
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "professionalSupportProfessionals"
      )
    
    private Boolean professionalSupportProfessionals;

    public void setProfessionalSupportProfessionals(final Boolean professionalSupportProfessionals) {
        this.professionalSupportProfessionals = professionalSupportProfessionals;
    }

 
    @Column(name="professional_support_professionals"  )
      
    public Boolean getProfessionalSupportProfessionals() {
        return this.professionalSupportProfessionals;
    }
  
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalSupportProfessionals'].test(_this.professionalSupportProfessionals.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "professionals"
      )
    
    private List<fr.cg95.cvq.business.request.social.HccrProfessional> professionals;

    public void setProfessionals(final List<fr.cg95.cvq.business.request.social.HccrProfessional> professionals) {
        this.professionals = professionals;
    }

 
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @OrderColumn(name="professionals_index")
    @JoinColumn(name="handicap_compensation_child_request_id")
      
    public List<fr.cg95.cvq.business.request.social.HccrProfessional> getProfessionals() {
        return this.professionals;
    }
  
    
      @MaxLength(
        
          value = 600,
        
        
        profiles = {"project"},
        message = "projectComments"
      )
    
    private String projectComments;

    public void setProjectComments(final String projectComments) {
        this.projectComments = projectComments;
    }

 
    @Column(name="project_comments" , length=600 )
      
    public String getProjectComments() {
        return this.projectComments;
    }
  
    
      @MaxLength(
        
          value = 600,
        
        
        profiles = {"project"},
        message = "projectNeeds"
      )
    
    private String projectNeeds;

    public void setProjectNeeds(final String projectNeeds) {
        this.projectNeeds = projectNeeds;
    }

 
    @Column(name="project_needs" , length=600 )
      
    public String getProjectNeeds() {
        return this.projectNeeds;
    }
  
    
    private Boolean projectRequestsACTPRenewal;

    public void setProjectRequestsACTPRenewal(final Boolean projectRequestsACTPRenewal) {
        this.projectRequestsACTPRenewal = projectRequestsACTPRenewal;
    }

 
    @Column(name="project_requests_a_c_t_p_renewal"  )
      
    public Boolean getProjectRequestsACTPRenewal() {
        return this.projectRequestsACTPRenewal;
    }
  
    
    private Boolean projectRequestsAssistance;

    public void setProjectRequestsAssistance(final Boolean projectRequestsAssistance) {
        this.projectRequestsAssistance = projectRequestsAssistance;
    }

 
    @Column(name="project_requests_assistance"  )
      
    public Boolean getProjectRequestsAssistance() {
        return this.projectRequestsAssistance;
    }
  
    
    private Boolean projectRequestsCustomCar;

    public void setProjectRequestsCustomCar(final Boolean projectRequestsCustomCar) {
        this.projectRequestsCustomCar = projectRequestsCustomCar;
    }

 
    @Column(name="project_requests_custom_car"  )
      
    public Boolean getProjectRequestsCustomCar() {
        return this.projectRequestsCustomCar;
    }
  
    
    private Boolean projectRequestsDisabilityCard;

    public void setProjectRequestsDisabilityCard(final Boolean projectRequestsDisabilityCard) {
        this.projectRequestsDisabilityCard = projectRequestsDisabilityCard;
    }

 
    @Column(name="project_requests_disability_card"  )
      
    public Boolean getProjectRequestsDisabilityCard() {
        return this.projectRequestsDisabilityCard;
    }
  
    
    private Boolean projectRequestsDisabilityCostAllocation;

    public void setProjectRequestsDisabilityCostAllocation(final Boolean projectRequestsDisabilityCostAllocation) {
        this.projectRequestsDisabilityCostAllocation = projectRequestsDisabilityCostAllocation;
    }

 
    @Column(name="project_requests_disability_cost_allocation"  )
      
    public Boolean getProjectRequestsDisabilityCostAllocation() {
        return this.projectRequestsDisabilityCostAllocation;
    }
  
    
    private Boolean projectRequestsDisabledAdultAllowance;

    public void setProjectRequestsDisabledAdultAllowance(final Boolean projectRequestsDisabledAdultAllowance) {
        this.projectRequestsDisabledAdultAllowance = projectRequestsDisabledAdultAllowance;
    }

 
    @Column(name="project_requests_disabled_adult_allowance"  )
      
    public Boolean getProjectRequestsDisabledAdultAllowance() {
        return this.projectRequestsDisabledAdultAllowance;
    }
  
    
    private Boolean projectRequestsDisabledPriorityCard;

    public void setProjectRequestsDisabledPriorityCard(final Boolean projectRequestsDisabledPriorityCard) {
        this.projectRequestsDisabledPriorityCard = projectRequestsDisabledPriorityCard;
    }

 
    @Column(name="project_requests_disabled_priority_card"  )
      
    public Boolean getProjectRequestsDisabledPriorityCard() {
        return this.projectRequestsDisabledPriorityCard;
    }
  
    
    private Boolean projectRequestsDisabledWorkerRecognition;

    public void setProjectRequestsDisabledWorkerRecognition(final Boolean projectRequestsDisabledWorkerRecognition) {
        this.projectRequestsDisabledWorkerRecognition = projectRequestsDisabledWorkerRecognition;
    }

 
    @Column(name="project_requests_disabled_worker_recognition"  )
      
    public Boolean getProjectRequestsDisabledWorkerRecognition() {
        return this.projectRequestsDisabledWorkerRecognition;
    }
  
    
    private Boolean projectRequestsEducationAllocationOfDisabledChildren;

    public void setProjectRequestsEducationAllocationOfDisabledChildren(final Boolean projectRequestsEducationAllocationOfDisabledChildren) {
        this.projectRequestsEducationAllocationOfDisabledChildren = projectRequestsEducationAllocationOfDisabledChildren;
    }

 
    @Column(name="project_requests_education_allocation_of_disabled_children"  )
      
    public Boolean getProjectRequestsEducationAllocationOfDisabledChildren() {
        return this.projectRequestsEducationAllocationOfDisabledChildren;
    }
  
    
    private Boolean projectRequestsEuropeanParkingCard;

    public void setProjectRequestsEuropeanParkingCard(final Boolean projectRequestsEuropeanParkingCard) {
        this.projectRequestsEuropeanParkingCard = projectRequestsEuropeanParkingCard;
    }

 
    @Column(name="project_requests_european_parking_card"  )
      
    public Boolean getProjectRequestsEuropeanParkingCard() {
        return this.projectRequestsEuropeanParkingCard;
    }
  
    
    private Boolean projectRequestsFreePensionMembership;

    public void setProjectRequestsFreePensionMembership(final Boolean projectRequestsFreePensionMembership) {
        this.projectRequestsFreePensionMembership = projectRequestsFreePensionMembership;
    }

 
    @Column(name="project_requests_free_pension_membership"  )
      
    public Boolean getProjectRequestsFreePensionMembership() {
        return this.projectRequestsFreePensionMembership;
    }
  
    
    private Boolean projectRequestsHandicapRecognition;

    public void setProjectRequestsHandicapRecognition(final Boolean projectRequestsHandicapRecognition) {
        this.projectRequestsHandicapRecognition = projectRequestsHandicapRecognition;
    }

 
    @Column(name="project_requests_handicap_recognition"  )
      
    public Boolean getProjectRequestsHandicapRecognition() {
        return this.projectRequestsHandicapRecognition;
    }
  
    
    private Boolean projectRequestsHousingFacilities;

    public void setProjectRequestsHousingFacilities(final Boolean projectRequestsHousingFacilities) {
        this.projectRequestsHousingFacilities = projectRequestsHousingFacilities;
    }

 
    @Column(name="project_requests_housing_facilities"  )
      
    public Boolean getProjectRequestsHousingFacilities() {
        return this.projectRequestsHousingFacilities;
    }
  
    
    private Boolean projectRequestsIncreaseForIndependentLiving;

    public void setProjectRequestsIncreaseForIndependentLiving(final Boolean projectRequestsIncreaseForIndependentLiving) {
        this.projectRequestsIncreaseForIndependentLiving = projectRequestsIncreaseForIndependentLiving;
    }

 
    @Column(name="project_requests_increase_for_independent_living"  )
      
    public Boolean getProjectRequestsIncreaseForIndependentLiving() {
        return this.projectRequestsIncreaseForIndependentLiving;
    }
  
    
    private Boolean projectRequestsInstitutionSupport;

    public void setProjectRequestsInstitutionSupport(final Boolean projectRequestsInstitutionSupport) {
        this.projectRequestsInstitutionSupport = projectRequestsInstitutionSupport;
    }

 
    @Column(name="project_requests_institution_support"  )
      
    public Boolean getProjectRequestsInstitutionSupport() {
        return this.projectRequestsInstitutionSupport;
    }
  
    
    private Boolean projectRequestsOrdinaryWorking;

    public void setProjectRequestsOrdinaryWorking(final Boolean projectRequestsOrdinaryWorking) {
        this.projectRequestsOrdinaryWorking = projectRequestsOrdinaryWorking;
    }

 
    @Column(name="project_requests_ordinary_working"  )
      
    public Boolean getProjectRequestsOrdinaryWorking() {
        return this.projectRequestsOrdinaryWorking;
    }
  
    
    private Boolean projectRequestsOther;

    public void setProjectRequestsOther(final Boolean projectRequestsOther) {
        this.projectRequestsOther = projectRequestsOther;
    }

 
    @Column(name="project_requests_other"  )
      
    public Boolean getProjectRequestsOther() {
        return this.projectRequestsOther;
    }
  
    
      @MaxLength(
        
          value = 60,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['projectRequestsOther'].test(_this.projectRequestsOther.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"project"},
        message = "projectRequestsOtherDetails"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['projectRequestsOther'].test(_this.projectRequestsOther.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"project"},
        message = "projectRequestsOtherDetails"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['projectRequestsOther'].test(_this.projectRequestsOther.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"project"},
        message = "projectRequestsOtherDetails"
      )
    
    private String projectRequestsOtherDetails;

    public void setProjectRequestsOtherDetails(final String projectRequestsOtherDetails) {
        this.projectRequestsOtherDetails = projectRequestsOtherDetails;
    }

 
    @Column(name="project_requests_other_details" , length=60 )
      
    public String getProjectRequestsOtherDetails() {
        return this.projectRequestsOtherDetails;
    }
  
    
    private Boolean projectRequestsProfessionalOrientation;

    public void setProjectRequestsProfessionalOrientation(final Boolean projectRequestsProfessionalOrientation) {
        this.projectRequestsProfessionalOrientation = projectRequestsProfessionalOrientation;
    }

 
    @Column(name="project_requests_professional_orientation"  )
      
    public Boolean getProjectRequestsProfessionalOrientation() {
        return this.projectRequestsProfessionalOrientation;
    }
  
    
    private Boolean projectRequestsShelteredWork;

    public void setProjectRequestsShelteredWork(final Boolean projectRequestsShelteredWork) {
        this.projectRequestsShelteredWork = projectRequestsShelteredWork;
    }

 
    @Column(name="project_requests_sheltered_work"  )
      
    public Boolean getProjectRequestsShelteredWork() {
        return this.projectRequestsShelteredWork;
    }
  
    
    private Boolean projectRequestsTechnicalHelp;

    public void setProjectRequestsTechnicalHelp(final Boolean projectRequestsTechnicalHelp) {
        this.projectRequestsTechnicalHelp = projectRequestsTechnicalHelp;
    }

 
    @Column(name="project_requests_technical_help"  )
      
    public Boolean getProjectRequestsTechnicalHelp() {
        return this.projectRequestsTechnicalHelp;
    }
  
    
    private Boolean projectRequestsThirdPartyHelp;

    public void setProjectRequestsThirdPartyHelp(final Boolean projectRequestsThirdPartyHelp) {
        this.projectRequestsThirdPartyHelp = projectRequestsThirdPartyHelp;
    }

 
    @Column(name="project_requests_third_party_help"  )
      
    public Boolean getProjectRequestsThirdPartyHelp() {
        return this.projectRequestsThirdPartyHelp;
    }
  
    
    private Boolean projectRequestsTransportCostAllocation;

    public void setProjectRequestsTransportCostAllocation(final Boolean projectRequestsTransportCostAllocation) {
        this.projectRequestsTransportCostAllocation = projectRequestsTransportCostAllocation;
    }

 
    @Column(name="project_requests_transport_cost_allocation"  )
      
    public Boolean getProjectRequestsTransportCostAllocation() {
        return this.projectRequestsTransportCostAllocation;
    }
  
    
    private Boolean projectRequestsVocationalTraining;

    public void setProjectRequestsVocationalTraining(final Boolean projectRequestsVocationalTraining) {
        this.projectRequestsVocationalTraining = projectRequestsVocationalTraining;
    }

 
    @Column(name="project_requests_vocational_training"  )
      
    public Boolean getProjectRequestsVocationalTraining() {
        return this.projectRequestsVocationalTraining;
    }
  
    
      @MaxLength(
        
          value = 600,
        
        
        profiles = {"project"},
        message = "projectWish"
      )
    
    private String projectWish;

    public void setProjectWish(final String projectWish) {
        this.projectWish = projectWish;
    }

 
    @Column(name="project_wish" , length=600 )
      
    public String getProjectWish() {
        return this.projectWish;
    }
  
    
      @MaxLength(
        
          value = 32,
        
        
        profiles = {"subject"},
        message = "referentBirthCity"
      )
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "referentBirthCity"
      )
    
      @NotBlank(
        
        
        profiles = {"subject"},
        message = "referentBirthCity"
      )
    
    private String referentBirthCity;

    public void setReferentBirthCity(final String referentBirthCity) {
        this.referentBirthCity = referentBirthCity;
    }

 
    @Column(name="referent_birth_city" , length=32 )
      
    public String getReferentBirthCity() {
        return this.referentBirthCity;
    }
  
    
      @MaxLength(
        
          value = 50,
        
        
        profiles = {"subject"},
        message = "referentBirthCountry"
      )
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "referentBirthCountry"
      )
    
      @NotBlank(
        
        
        profiles = {"subject"},
        message = "referentBirthCountry"
      )
    
    private String referentBirthCountry;

    public void setReferentBirthCountry(final String referentBirthCountry) {
        this.referentBirthCountry = referentBirthCountry;
    }

 
    @Column(name="referent_birth_country" , length=50 )
      
    public String getReferentBirthCountry() {
        return this.referentBirthCountry;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "referentBirthDate"
      )
    
    private java.util.Date referentBirthDate;

    public void setReferentBirthDate(final java.util.Date referentBirthDate) {
        this.referentBirthDate = referentBirthDate;
    }

 
    @Column(name="referent_birth_date"  )
      
    public java.util.Date getReferentBirthDate() {
        return this.referentBirthDate;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "referentFamilyDependents"
      )
    
    private Boolean referentFamilyDependents;

    public void setReferentFamilyDependents(final Boolean referentFamilyDependents) {
        this.referentFamilyDependents = referentFamilyDependents;
    }

 
    @Column(name="referent_family_dependents"  )
      
    public Boolean getReferentFamilyDependents() {
        return this.referentFamilyDependents;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "referentFamilyStatus"
      )
    
    private fr.cg95.cvq.business.users.FamilyStatusType referentFamilyStatus;

    public void setReferentFamilyStatus(final fr.cg95.cvq.business.users.FamilyStatusType referentFamilyStatus) {
        this.referentFamilyStatus = referentFamilyStatus;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="referent_family_status"  )
      
    public fr.cg95.cvq.business.users.FamilyStatusType getReferentFamilyStatus() {
        return this.referentFamilyStatus;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"subject"},
        message = "referentFirstName"
      )
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "referentFirstName"
      )
    
      @NotBlank(
        
        
        profiles = {"subject"},
        message = "referentFirstName"
      )
    
    private String referentFirstName;

    public void setReferentFirstName(final String referentFirstName) {
        this.referentFirstName = referentFirstName;
    }

 
    @Column(name="referent_first_name" , length=38 )
      
    public String getReferentFirstName() {
        return this.referentFirstName;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"subject"},
        message = "referentLastName"
      )
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "referentLastName"
      )
    
      @NotBlank(
        
        
        profiles = {"subject"},
        message = "referentLastName"
      )
    
    private String referentLastName;

    public void setReferentLastName(final String referentLastName) {
        this.referentLastName = referentLastName;
    }

 
    @Column(name="referent_last_name" , length=38 )
      
    public String getReferentLastName() {
        return this.referentLastName;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['referentTitle'].test(_this.referentTitle.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "referentMaidenName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['referentTitle'].test(_this.referentTitle.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "referentMaidenName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['referentTitle'].test(_this.referentTitle.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "referentMaidenName"
      )
    
    private String referentMaidenName;

    public void setReferentMaidenName(final String referentMaidenName) {
        this.referentMaidenName = referentMaidenName;
    }

 
    @Column(name="referent_maiden_name" , length=38 )
      
    public String getReferentMaidenName() {
        return this.referentMaidenName;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "referentTitle"
      )
    
    private fr.cg95.cvq.business.users.TitleType referentTitle;

    public void setReferentTitle(final fr.cg95.cvq.business.users.TitleType referentTitle) {
        this.referentTitle = referentTitle;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="referent_title"  )
      
    public fr.cg95.cvq.business.users.TitleType getReferentTitle() {
        return this.referentTitle;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['schoolingSendToSchool'].test(_this.schoolingSendToSchool.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingAttendedGrade"
      )
    
    private fr.cg95.cvq.business.users.SectionType schoolingAttendedGrade;

    public void setSchoolingAttendedGrade(final fr.cg95.cvq.business.users.SectionType schoolingAttendedGrade) {
        this.schoolingAttendedGrade = schoolingAttendedGrade;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="schooling_attended_grade" , length=32 )
      
    public fr.cg95.cvq.business.users.SectionType getSchoolingAttendedGrade() {
        return this.schoolingAttendedGrade;
    }
  
    
      @NotNull(
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingEnrolment"
      )
    
    private Boolean schoolingEnrolment;

    public void setSchoolingEnrolment(final Boolean schoolingEnrolment) {
        this.schoolingEnrolment = schoolingEnrolment;
    }

 
    @Column(name="schooling_enrolment"  )
      
    public Boolean getSchoolingEnrolment() {
        return this.schoolingEnrolment;
    }
  
    
      @NotNull(
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingExtraCurricular"
      )
    
    private Boolean schoolingExtraCurricular;

    public void setSchoolingExtraCurricular(final Boolean schoolingExtraCurricular) {
        this.schoolingExtraCurricular = schoolingExtraCurricular;
    }

 
    @Column(name="schooling_extra_curricular"  )
      
    public Boolean getSchoolingExtraCurricular() {
        return this.schoolingExtraCurricular;
    }
  
    
      @MaxLength(
        
          value = 50,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['schoolingExtraCurricular'].test(_this.schoolingExtraCurricular.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingExtraCurricularDetails"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['schoolingExtraCurricular'].test(_this.schoolingExtraCurricular.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingExtraCurricularDetails"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['schoolingExtraCurricular'].test(_this.schoolingExtraCurricular.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingExtraCurricularDetails"
      )
    
    private String schoolingExtraCurricularDetails;

    public void setSchoolingExtraCurricularDetails(final String schoolingExtraCurricularDetails) {
        this.schoolingExtraCurricularDetails = schoolingExtraCurricularDetails;
    }

 
    @Column(name="schooling_extra_curricular_details" , length=50 )
      
    public String getSchoolingExtraCurricularDetails() {
        return this.schoolingExtraCurricularDetails;
    }
  
    
      @NotNull(
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingHomeSchooling"
      )
    
    private Boolean schoolingHomeSchooling;

    public void setSchoolingHomeSchooling(final Boolean schoolingHomeSchooling) {
        this.schoolingHomeSchooling = schoolingHomeSchooling;
    }

 
    @Column(name="schooling_home_schooling"  )
      
    public Boolean getSchoolingHomeSchooling() {
        return this.schoolingHomeSchooling;
    }
  
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['schoolingHomeSchoolingKind'].test(_this.schoolingHomeSchoolingKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingHomeSchoolingAccompanistAddress"
      )
    
    private fr.cg95.cvq.business.users.Address schoolingHomeSchoolingAccompanistAddress;

    public void setSchoolingHomeSchoolingAccompanistAddress(final fr.cg95.cvq.business.users.Address schoolingHomeSchoolingAccompanistAddress) {
        this.schoolingHomeSchoolingAccompanistAddress = schoolingHomeSchoolingAccompanistAddress;
    }

 
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="schooling_home_schooling_accompanist_address_id")
      
    public fr.cg95.cvq.business.users.Address getSchoolingHomeSchoolingAccompanistAddress() {
        return this.schoolingHomeSchoolingAccompanistAddress;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['schoolingHomeSchoolingKind'].test(_this.schoolingHomeSchoolingKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingHomeSchoolingAccompanistFirstName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['schoolingHomeSchoolingKind'].test(_this.schoolingHomeSchoolingKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingHomeSchoolingAccompanistFirstName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['schoolingHomeSchoolingKind'].test(_this.schoolingHomeSchoolingKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingHomeSchoolingAccompanistFirstName"
      )
    
    private String schoolingHomeSchoolingAccompanistFirstName;

    public void setSchoolingHomeSchoolingAccompanistFirstName(final String schoolingHomeSchoolingAccompanistFirstName) {
        this.schoolingHomeSchoolingAccompanistFirstName = schoolingHomeSchoolingAccompanistFirstName;
    }

 
    @Column(name="schooling_home_schooling_accompanist_first_name" , length=38 )
      
    public String getSchoolingHomeSchoolingAccompanistFirstName() {
        return this.schoolingHomeSchoolingAccompanistFirstName;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['schoolingHomeSchoolingKind'].test(_this.schoolingHomeSchoolingKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingHomeSchoolingAccompanistLastName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['schoolingHomeSchoolingKind'].test(_this.schoolingHomeSchoolingKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingHomeSchoolingAccompanistLastName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['schoolingHomeSchoolingKind'].test(_this.schoolingHomeSchoolingKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingHomeSchoolingAccompanistLastName"
      )
    
    private String schoolingHomeSchoolingAccompanistLastName;

    public void setSchoolingHomeSchoolingAccompanistLastName(final String schoolingHomeSchoolingAccompanistLastName) {
        this.schoolingHomeSchoolingAccompanistLastName = schoolingHomeSchoolingAccompanistLastName;
    }

 
    @Column(name="schooling_home_schooling_accompanist_last_name" , length=38 )
      
    public String getSchoolingHomeSchoolingAccompanistLastName() {
        return this.schoolingHomeSchoolingAccompanistLastName;
    }
  
    
      @NotNull(
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingHomeSchoolingKind"
      )
    
    private fr.cg95.cvq.business.request.social.HccrHomeSchoolingKindType schoolingHomeSchoolingKind;

    public void setSchoolingHomeSchoolingKind(final fr.cg95.cvq.business.request.social.HccrHomeSchoolingKindType schoolingHomeSchoolingKind) {
        this.schoolingHomeSchoolingKind = schoolingHomeSchoolingKind;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="schooling_home_schooling_kind"  )
      
    public fr.cg95.cvq.business.request.social.HccrHomeSchoolingKindType getSchoolingHomeSchoolingKind() {
        return this.schoolingHomeSchoolingKind;
    }
  
    
      @NotNull(
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingPersonalizedSchoolingPlan"
      )
    
    private Boolean schoolingPersonalizedSchoolingPlan;

    public void setSchoolingPersonalizedSchoolingPlan(final Boolean schoolingPersonalizedSchoolingPlan) {
        this.schoolingPersonalizedSchoolingPlan = schoolingPersonalizedSchoolingPlan;
    }

 
    @Column(name="schooling_personalized_schooling_plan"  )
      
    public Boolean getSchoolingPersonalizedSchoolingPlan() {
        return this.schoolingPersonalizedSchoolingPlan;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['schoolingEnrolment'].test(_this.schoolingEnrolment.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingSchoolAddress"
      )
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['schoolingEnrolment'].test(_this.schoolingEnrolment.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingSchoolAddress"
      )
    
    private fr.cg95.cvq.business.users.Address schoolingSchoolAddress;

    public void setSchoolingSchoolAddress(final fr.cg95.cvq.business.users.Address schoolingSchoolAddress) {
        this.schoolingSchoolAddress = schoolingSchoolAddress;
    }

 
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="schooling_school_address_id")
      
    public fr.cg95.cvq.business.users.Address getSchoolingSchoolAddress() {
        return this.schoolingSchoolAddress;
    }
  
    
      @MaxLength(
        
          value = 80,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['schoolingEnrolment'].test(_this.schoolingEnrolment.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingSchoolName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['schoolingEnrolment'].test(_this.schoolingEnrolment.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingSchoolName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['schoolingEnrolment'].test(_this.schoolingEnrolment.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingSchoolName"
      )
    
    private String schoolingSchoolName;

    public void setSchoolingSchoolName(final String schoolingSchoolName) {
        this.schoolingSchoolName = schoolingSchoolName;
    }

 
    @Column(name="schooling_school_name" , length=80 )
      
    public String getSchoolingSchoolName() {
        return this.schoolingSchoolName;
    }
  
    
      @NotNull(
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingSchoolingKind"
      )
    
    private fr.cg95.cvq.business.request.social.HccrSchoolingKindType schoolingSchoolingKind;

    public void setSchoolingSchoolingKind(final fr.cg95.cvq.business.request.social.HccrSchoolingKindType schoolingSchoolingKind) {
        this.schoolingSchoolingKind = schoolingSchoolingKind;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="schooling_schooling_kind"  )
      
    public fr.cg95.cvq.business.request.social.HccrSchoolingKindType getSchoolingSchoolingKind() {
        return this.schoolingSchoolingKind;
    }
  
    
      @NotNull(
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingSendToSchool"
      )
    
    private Boolean schoolingSendToSchool;

    public void setSchoolingSendToSchool(final Boolean schoolingSendToSchool) {
        this.schoolingSendToSchool = schoolingSendToSchool;
    }

 
    @Column(name="schooling_send_to_school"  )
      
    public Boolean getSchoolingSendToSchool() {
        return this.schoolingSendToSchool;
    }
  
    
      @NotNull(
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingSpecializedGrade"
      )
    
    private Boolean schoolingSpecializedGrade;

    public void setSchoolingSpecializedGrade(final Boolean schoolingSpecializedGrade) {
        this.schoolingSpecializedGrade = schoolingSpecializedGrade;
    }

 
    @Column(name="schooling_specialized_grade"  )
      
    public Boolean getSchoolingSpecializedGrade() {
        return this.schoolingSpecializedGrade;
    }
  
    
      @MaxLength(
        
          value = 30,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['schoolingSpecializedGrade'].test(_this.schoolingSpecializedGrade.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingSpecializedGradeDetails"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['schoolingSpecializedGrade'].test(_this.schoolingSpecializedGrade.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingSpecializedGradeDetails"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['schoolingSpecializedGrade'].test(_this.schoolingSpecializedGrade.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingSpecializedGradeDetails"
      )
    
    private String schoolingSpecializedGradeDetails;

    public void setSchoolingSpecializedGradeDetails(final String schoolingSpecializedGradeDetails) {
        this.schoolingSpecializedGradeDetails = schoolingSpecializedGradeDetails;
    }

 
    @Column(name="schooling_specialized_grade_details" , length=30 )
      
    public String getSchoolingSpecializedGradeDetails() {
        return this.schoolingSpecializedGradeDetails;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['schoolingSchoolingKind'].test(_this.schoolingSchoolingKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingTime"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['schoolingSchoolingKind'].test(_this.schoolingSchoolingKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingTime"
      )
    
    private String schoolingTime;

    public void setSchoolingTime(final String schoolingTime) {
        this.schoolingTime = schoolingTime;
    }

 
    @Column(name="schooling_time" , length=4 )
      
    public String getSchoolingTime() {
        return this.schoolingTime;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['socialSecurityMemberShipKind'].test(_this.socialSecurityMemberShipKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"socialSecurityAndPaymentAgency"},
        message = "socialSecurityAgencyAddress"
      )
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['socialSecurityMemberShipKind'].test(_this.socialSecurityMemberShipKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"socialSecurityAndPaymentAgency"},
        message = "socialSecurityAgencyAddress"
      )
    
    private fr.cg95.cvq.business.users.Address socialSecurityAgencyAddress;

    public void setSocialSecurityAgencyAddress(final fr.cg95.cvq.business.users.Address socialSecurityAgencyAddress) {
        this.socialSecurityAgencyAddress = socialSecurityAgencyAddress;
    }

 
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="social_security_agency_address_id")
      
    public fr.cg95.cvq.business.users.Address getSocialSecurityAgencyAddress() {
        return this.socialSecurityAgencyAddress;
    }
  
    
      @MaxLength(
        
          value = 50,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['socialSecurityMemberShipKind'].test(_this.socialSecurityMemberShipKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"socialSecurityAndPaymentAgency"},
        message = "socialSecurityAgencyName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['socialSecurityMemberShipKind'].test(_this.socialSecurityMemberShipKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"socialSecurityAndPaymentAgency"},
        message = "socialSecurityAgencyName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['socialSecurityMemberShipKind'].test(_this.socialSecurityMemberShipKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"socialSecurityAndPaymentAgency"},
        message = "socialSecurityAgencyName"
      )
    
    private String socialSecurityAgencyName;

    public void setSocialSecurityAgencyName(final String socialSecurityAgencyName) {
        this.socialSecurityAgencyName = socialSecurityAgencyName;
    }

 
    @Column(name="social_security_agency_name" , length=50 )
      
    public String getSocialSecurityAgencyName() {
        return this.socialSecurityAgencyName;
    }
  
    
      @NotNull(
        
        
        profiles = {"socialSecurityAndPaymentAgency"},
        message = "socialSecurityMemberShipKind"
      )
    
    private fr.cg95.cvq.business.request.social.HccrSocialSecurityMemberShipKindType socialSecurityMemberShipKind;

    public void setSocialSecurityMemberShipKind(final fr.cg95.cvq.business.request.social.HccrSocialSecurityMemberShipKindType socialSecurityMemberShipKind) {
        this.socialSecurityMemberShipKind = socialSecurityMemberShipKind;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="social_security_member_ship_kind"  )
      
    public fr.cg95.cvq.business.request.social.HccrSocialSecurityMemberShipKindType getSocialSecurityMemberShipKind() {
        return this.socialSecurityMemberShipKind;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['socialSecurityMemberShipKind'].test(_this.socialSecurityMemberShipKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"socialSecurityAndPaymentAgency"},
        message = "socialSecurityNumber"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['socialSecurityMemberShipKind'].test(_this.socialSecurityMemberShipKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"socialSecurityAndPaymentAgency"},
        message = "socialSecurityNumber"
      )
    
    private String socialSecurityNumber;

    public void setSocialSecurityNumber(final String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

 
    @Column(name="social_security_number" , length=13 )
      
    public String getSocialSecurityNumber() {
        return this.socialSecurityNumber;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['socialServiceSupport'].test(_this.socialServiceSupport.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "socialServiceAddress"
      )
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['socialServiceSupport'].test(_this.socialServiceSupport.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "socialServiceAddress"
      )
    
    private fr.cg95.cvq.business.users.Address socialServiceAddress;

    public void setSocialServiceAddress(final fr.cg95.cvq.business.users.Address socialServiceAddress) {
        this.socialServiceAddress = socialServiceAddress;
    }

 
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="social_service_address_id")
      
    public fr.cg95.cvq.business.users.Address getSocialServiceAddress() {
        return this.socialServiceAddress;
    }
  
    
      @MaxLength(
        
          value = 60,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['socialServiceSupport'].test(_this.socialServiceSupport.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "socialServiceName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['socialServiceSupport'].test(_this.socialServiceSupport.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "socialServiceName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['socialServiceSupport'].test(_this.socialServiceSupport.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "socialServiceName"
      )
    
    private String socialServiceName;

    public void setSocialServiceName(final String socialServiceName) {
        this.socialServiceName = socialServiceName;
    }

 
    @Column(name="social_service_name" , length=60 )
      
    public String getSocialServiceName() {
        return this.socialServiceName;
    }
  
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "socialServiceSupport"
      )
    
    private Boolean socialServiceSupport;

    public void setSocialServiceSupport(final Boolean socialServiceSupport) {
        this.socialServiceSupport = socialServiceSupport;
    }

 
    @Column(name="social_service_support"  )
      
    public Boolean getSocialServiceSupport() {
        return this.socialServiceSupport;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['studiesHighSchool'].test(_this.studiesHighSchool.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "studiesAssistanceUnderDisability"
      )
    
    private Boolean studiesAssistanceUnderDisability;

    public void setStudiesAssistanceUnderDisability(final Boolean studiesAssistanceUnderDisability) {
        this.studiesAssistanceUnderDisability = studiesAssistanceUnderDisability;
    }

 
    @Column(name="studies_assistance_under_disability"  )
      
    public Boolean getStudiesAssistanceUnderDisability() {
        return this.studiesAssistanceUnderDisability;
    }
  
    
      @MaxLength(
        
          value = 60,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['studiesAssistanceUnderDisability'].test(_this.studiesAssistanceUnderDisability.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "studiesAssistanceUnderDisabilityDetails"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['studiesAssistanceUnderDisability'].test(_this.studiesAssistanceUnderDisability.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "studiesAssistanceUnderDisabilityDetails"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['studiesAssistanceUnderDisability'].test(_this.studiesAssistanceUnderDisability.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "studiesAssistanceUnderDisabilityDetails"
      )
    
    private String studiesAssistanceUnderDisabilityDetails;

    public void setStudiesAssistanceUnderDisabilityDetails(final String studiesAssistanceUnderDisabilityDetails) {
        this.studiesAssistanceUnderDisabilityDetails = studiesAssistanceUnderDisabilityDetails;
    }

 
    @Column(name="studies_assistance_under_disability_details" , length=60 )
      
    public String getStudiesAssistanceUnderDisabilityDetails() {
        return this.studiesAssistanceUnderDisabilityDetails;
    }
  
    
      @NotNull(
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "studiesHighSchool"
      )
    
    private Boolean studiesHighSchool;

    public void setStudiesHighSchool(final Boolean studiesHighSchool) {
        this.studiesHighSchool = studiesHighSchool;
    }

 
    @Column(name="studies_high_school"  )
      
    public Boolean getStudiesHighSchool() {
        return this.studiesHighSchool;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['studiesHighSchool'].test(_this.studiesHighSchool.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "studiesHighSchoolAddress"
      )
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['studiesHighSchool'].test(_this.studiesHighSchool.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "studiesHighSchoolAddress"
      )
    
    private fr.cg95.cvq.business.users.Address studiesHighSchoolAddress;

    public void setStudiesHighSchoolAddress(final fr.cg95.cvq.business.users.Address studiesHighSchoolAddress) {
        this.studiesHighSchoolAddress = studiesHighSchoolAddress;
    }

 
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="studies_high_school_address_id")
      
    public fr.cg95.cvq.business.users.Address getStudiesHighSchoolAddress() {
        return this.studiesHighSchoolAddress;
    }
  
    
      @MaxLength(
        
          value = 60,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['studiesHighSchool'].test(_this.studiesHighSchool.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "studiesHighSchoolGrade"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['studiesHighSchool'].test(_this.studiesHighSchool.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "studiesHighSchoolGrade"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['studiesHighSchool'].test(_this.studiesHighSchool.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "studiesHighSchoolGrade"
      )
    
    private String studiesHighSchoolGrade;

    public void setStudiesHighSchoolGrade(final String studiesHighSchoolGrade) {
        this.studiesHighSchoolGrade = studiesHighSchoolGrade;
    }

 
    @Column(name="studies_high_school_grade" , length=60 )
      
    public String getStudiesHighSchoolGrade() {
        return this.studiesHighSchoolGrade;
    }
  
    
      @MaxLength(
        
          value = 60,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['studiesHighSchool'].test(_this.studiesHighSchool.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "studiesHighSchoolName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['studiesHighSchool'].test(_this.studiesHighSchool.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "studiesHighSchoolName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['studiesHighSchool'].test(_this.studiesHighSchool.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "studiesHighSchoolName"
      )
    
    private String studiesHighSchoolName;

    public void setStudiesHighSchoolName(final String studiesHighSchoolName) {
        this.studiesHighSchoolName = studiesHighSchoolName;
    }

 
    @Column(name="studies_high_school_name" , length=60 )
      
    public String getStudiesHighSchoolName() {
        return this.studiesHighSchoolName;
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

    public void setSubjectBirthCity(final String subjectBirthCity) {
        this.subjectBirthCity = subjectBirthCity;
    }

 
    @Column(name="subject_birth_city" , length=32 )
      
    public String getSubjectBirthCity() {
        return this.subjectBirthCity;
    }
  
    
      @MaxLength(
        
          value = 50,
        
        
        profiles = {"subject"},
        message = "subjectBirthCountry"
      )
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "subjectBirthCountry"
      )
    
      @NotBlank(
        
        
        profiles = {"subject"},
        message = "subjectBirthCountry"
      )
    
    private String subjectBirthCountry;

    public void setSubjectBirthCountry(final String subjectBirthCountry) {
        this.subjectBirthCountry = subjectBirthCountry;
    }

 
    @Column(name="subject_birth_country" , length=50 )
      
    public String getSubjectBirthCountry() {
        return this.subjectBirthCountry;
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
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['subjectBirthDate'].test(_this.subjectBirthDate.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "subjectParentalAuthorityHolder"
      )
    
    private fr.cg95.cvq.business.request.social.HccrSubjectParentalAuthorityHolderType subjectParentalAuthorityHolder;

    public void setSubjectParentalAuthorityHolder(final fr.cg95.cvq.business.request.social.HccrSubjectParentalAuthorityHolderType subjectParentalAuthorityHolder) {
        this.subjectParentalAuthorityHolder = subjectParentalAuthorityHolder;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="subject_parental_authority_holder"  )
      
    public fr.cg95.cvq.business.request.social.HccrSubjectParentalAuthorityHolderType getSubjectParentalAuthorityHolder() {
        return this.subjectParentalAuthorityHolder;
    }
  
}
