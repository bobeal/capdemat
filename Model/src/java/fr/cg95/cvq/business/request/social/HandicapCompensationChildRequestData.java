
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
 *  table="handicap_compensation_child_request"
 *  lazy="false"
 */
public class HandicapCompensationChildRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public HandicapCompensationChildRequestData() {
      
        healthFollowedByProfessional = Boolean.valueOf(false);
      
        professionalSupportProfessionals = Boolean.valueOf(false);
      
        referentFamilyDependents = Boolean.valueOf(false);
      
        isFamilyAssistance = Boolean.valueOf(false);
      
        foldersCdes = Boolean.valueOf(false);
      
        homeInterventionHomeIntervenant = Boolean.valueOf(false);
      
        benefitsEducationAllocationOfDisabledChildren = Boolean.valueOf(false);
      
        projectRequestsHousingFacilities = Boolean.valueOf(false);
      
        schoolingHomeSchooling = Boolean.valueOf(false);
      
        schoolingSpecializedGrade = Boolean.valueOf(false);
      
        benefitsDisabilityPension = Boolean.valueOf(false);
      
        projectRequestsDisabledWorkerRecognition = Boolean.valueOf(false);
      
        benefitsUnemploymentBenefits = Boolean.valueOf(false);
      
        projectRequestsVocationalTraining = Boolean.valueOf(false);
      
        facilitiesCustomCar = Boolean.valueOf(false);
      
        benefitsDisabledAdultAllocation = Boolean.valueOf(false);
      
        professionalStatusIndemnified = Boolean.valueOf(false);
      
        schoolingEnrolment = Boolean.valueOf(false);
      
        benefitsThirdPartyCompensatoryAllowance = Boolean.valueOf(false);
      
        projectRequestsTransportCostAllocation = Boolean.valueOf(false);
      
        benefitsProfessionalOrientation = Boolean.valueOf(false);
      
        benefitsDisabilityRecognition = Boolean.valueOf(false);
      
        professionalStatusRegisterAsUnemployed = Boolean.valueOf(false);
      
        benefitsPainfulStandingCard = Boolean.valueOf(false);
      
        facilitiesSpecializedTransport = Boolean.valueOf(false);
      
        benefitsParkingCard = Boolean.valueOf(false);
      
        benefitsWorkAccidentAnnuity = Boolean.valueOf(false);
      
        careCareServices = Boolean.valueOf(false);
      
        benefitsDailyAllowances = Boolean.valueOf(false);
      
        projectRequestsCustomCar = Boolean.valueOf(false);
      
        projectRequestsACTPRenewal = Boolean.valueOf(false);
      
        foldersMdph = Boolean.valueOf(false);
      
        professionalSupportDealsWithSameProfessional = Boolean.valueOf(false);
      
        dwellingEstablishmentReception = Boolean.valueOf(false);
      
        projectRequestsOrdinaryWorking = Boolean.valueOf(false);
      
        benefitsDisabledWorkerRecognition = Boolean.valueOf(false);
      
        dwellingSocialReception = Boolean.valueOf(false);
      
        projectRequestsEuropeanParkingCard = Boolean.valueOf(false);
      
        healthFollowedByDoctor = Boolean.valueOf(false);
      
        projectRequestsFreePensionMembership = Boolean.valueOf(false);
      
        healthFollowedByHospital = Boolean.valueOf(false);
      
        projectRequestsInstitutionSupport = Boolean.valueOf(false);
      
        benefitsSocialWelfare = Boolean.valueOf(false);
      
        projectRequestsHandicapRecognition = Boolean.valueOf(false);
      
        schoolingExtraCurricular = Boolean.valueOf(false);
      
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
      
        foldersCotorep = Boolean.valueOf(false);
      
        professionalStatusElectiveFunction = Boolean.valueOf(false);
      
        benefitsIncreaseForIndependentLiving = Boolean.valueOf(false);
      
        fatherActivityReduction = Boolean.valueOf(false);
      
        projectRequestsDisabilityCard = Boolean.valueOf(false);
      
        schoolingSendToSchool = Boolean.valueOf(false);
      
        benefitsEducationOfDisabledChildren = Boolean.valueOf(false);
      
        benefitsOtherBenefits = Boolean.valueOf(false);
      
        benefitsDisabilityCompensation = Boolean.valueOf(false);
      
        projectRequestsTechnicalHelp = Boolean.valueOf(false);
      
        facilitiesTechnicalAssistance = Boolean.valueOf(false);
      
        benefitsCompensatoryAllowanceForExpenses = Boolean.valueOf(false);
      
        facilitiesHousing = Boolean.valueOf(false);
      
        projectRequestsDisabledPriorityCard = Boolean.valueOf(false);
      
        projectRequestsEducationAllocationOfDisabledChildren = Boolean.valueOf(false);
      
        socialServiceSupport = Boolean.valueOf(false);
      
        projectRequestsShelteredWork = Boolean.valueOf(false);
      
        studiesAssistanceUnderDisability = Boolean.valueOf(false);
      
        studiesHighSchool = Boolean.valueOf(false);
      
        motherActivityReduction = Boolean.valueOf(false);
      
        schoolingPersonalizedSchoolingPlan = Boolean.valueOf(false);
      
        benefitsDisabilityCard = Boolean.valueOf(false);
      
        facilitiesAnimalAid = Boolean.valueOf(false);
      
    }

    @Override
    public HandicapCompensationChildRequestData clone() {
        HandicapCompensationChildRequestData result = new HandicapCompensationChildRequestData();
        
          
            
        result.setHealthFollowedByProfessional(healthFollowedByProfessional);
      
          
        
          
            
        result.setProfessionalSupportProfessionals(professionalSupportProfessionals);
      
          
        
          
            
        result.setReferentFamilyDependents(referentFamilyDependents);
      
          
        
          
            
        result.setIsFamilyAssistance(isFamilyAssistance);
      
          
        
          
            
        if (schoolingAttendedGrade != null)
            result.setSchoolingAttendedGrade(schoolingAttendedGrade);
        else
            result.setSchoolingAttendedGrade(fr.cg95.cvq.business.users.SectionType.getDefaultSectionType());
      
          
        
          
            
        List<fr.cg95.cvq.business.request.social.HccrFamilyDependent> familyDependentsList = new ArrayList<fr.cg95.cvq.business.request.social.HccrFamilyDependent>();
        for (HccrFamilyDependent object : familyDependents) {
            familyDependentsList.add(object.clone());
        }
        result.setFamilyDependents(familyDependentsList);
      
          
        
          
            
        if (referentTitle != null)
            result.setReferentTitle(referentTitle);
        else
            result.setReferentTitle(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
      
          
        
          
            
        result.setProjectComments(projectComments);
      
          
        
          
            
        result.setFoldersCdes(foldersCdes);
      
          
        
          
            
        result.setFoldersMdphDepartment(foldersMdphDepartment);
      
          
        
          
            
        result.setProjectNeeds(projectNeeds);
      
          
        
          
            
        result.setHomeInterventionHomeIntervenant(homeInterventionHomeIntervenant);
      
          
        
          
            
        result.setBenefitsEducationAllocationOfDisabledChildren(benefitsEducationAllocationOfDisabledChildren);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.social.HccrOtherFolder> otherFoldersList = new ArrayList<fr.cg95.cvq.business.request.social.HccrOtherFolder>();
        for (HccrOtherFolder object : otherFolders) {
            otherFoldersList.add(object.clone());
        }
        result.setOtherFolders(otherFoldersList);
      
          
        
          
            
        result.setFoldersMdphNumber(foldersMdphNumber);
      
          
        
          
            
        if (subjectParentalAuthorityHolder != null)
            result.setSubjectParentalAuthorityHolder(subjectParentalAuthorityHolder);
        else
            result.setSubjectParentalAuthorityHolder(fr.cg95.cvq.business.request.social.HccrSubjectParentalAuthorityHolderType.getDefaultHccrSubjectParentalAuthorityHolderType());
      
          
        
          
            
        result.setProjectRequestsHousingFacilities(projectRequestsHousingFacilities);
      
          
        
          
            
        result.setSchoolingHomeSchooling(schoolingHomeSchooling);
      
          
        
          
            
        result.setFatherActivityReductionRatio(fatherActivityReductionRatio);
      
          
        
          
            
        result.setSubjectBirthDate(subjectBirthDate);
      
          
        
          
            
        result.setSchoolingExtraCurricularDetails(schoolingExtraCurricularDetails);
      
          
        
          
            
        result.setSchoolingSpecializedGrade(schoolingSpecializedGrade);
      
          
        
          
            
        result.setBenefitsDisabilityPension(benefitsDisabilityPension);
      
          
        
          
            
        result.setReferentMaidenName(referentMaidenName);
      
          
        
          
            
        result.setProjectRequestsDisabledWorkerRecognition(projectRequestsDisabledWorkerRecognition);
      
          
        
          
            
        result.setBenefitsUnemploymentBenefits(benefitsUnemploymentBenefits);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.social.HccrHomeIntervenant> homeIntervenantsList = new ArrayList<fr.cg95.cvq.business.request.social.HccrHomeIntervenant>();
        for (HccrHomeIntervenant object : homeIntervenants) {
            homeIntervenantsList.add(object.clone());
        }
        result.setHomeIntervenants(homeIntervenantsList);
      
          
        
          
            
        if (professionalStatusKind != null)
            result.setProfessionalStatusKind(professionalStatusKind);
        else
            result.setProfessionalStatusKind(fr.cg95.cvq.business.request.social.HccrProfessionalStatusKindType.getDefaultHccrProfessionalStatusKindType());
      
          
        
          
            
        if (schoolingHomeSchoolingKind != null)
            result.setSchoolingHomeSchoolingKind(schoolingHomeSchoolingKind);
        else
            result.setSchoolingHomeSchoolingKind(fr.cg95.cvq.business.request.social.HccrHomeSchoolingKindType.getDefaultHccrHomeSchoolingKindType());
      
          
        
          
            
        result.setBenefitsEducationOfDisabledChildrenDetails(benefitsEducationOfDisabledChildrenDetails);
      
          
        
          
            
        result.setFormationPreviousFormation(formationPreviousFormation);
      
          
        
          
            
        result.setProjectRequestsVocationalTraining(projectRequestsVocationalTraining);
      
          
        
          
            
        result.setFacilitiesCustomCar(facilitiesCustomCar);
      
          
        
          
            
        result.setBenefitsDisabledAdultAllocation(benefitsDisabledAdultAllocation);
      
          
        
          
            
        result.setProfessionalStatusIndemnified(professionalStatusIndemnified);
      
          
        
          
            
        result.setSchoolingEnrolment(schoolingEnrolment);
      
          
        
          
            
        result.setBenefitsThirdPartyCompensatoryAllowance(benefitsThirdPartyCompensatoryAllowance);
      
          
        
          
            
        result.setReferentBirthDate(referentBirthDate);
      
          
        
          
            
        result.setProfessionalStatusDate(professionalStatusDate);
      
          
        
          
            
        result.setProjectRequestsTransportCostAllocation(projectRequestsTransportCostAllocation);
      
          
        
          
            
        result.setBenefitsProfessionalOrientation(benefitsProfessionalOrientation);
      
          
        
          
            
        result.setSchoolingHomeSchoolingAccompanistLastName(schoolingHomeSchoolingAccompanistLastName);
      
          
        
          
            
        result.setBenefitsDisabilityRecognition(benefitsDisabilityRecognition);
      
          
        
          
            
        result.setProfessionalStatusRegisterAsUnemployed(professionalStatusRegisterAsUnemployed);
      
          
        
          
            
        result.setProfessionalStatusIndemnifiedDate(professionalStatusIndemnifiedDate);
      
          
        
          
            
        result.setDwellingSocialReceptionNaming(dwellingSocialReceptionNaming);
      
          
        
          
            
        result.setBenefitsProfessionalOrientationDetails(benefitsProfessionalOrientationDetails);
      
          
        
          
            
        result.setBenefitsPainfulStandingCard(benefitsPainfulStandingCard);
      
          
        
          
            
        result.setFoldersCdesDepartment(foldersCdesDepartment);
      
          
        
          
            
        result.setFacilitiesSpecializedTransport(facilitiesSpecializedTransport);
      
          
        
          
            
        result.setBenefitsParkingCard(benefitsParkingCard);
      
          
        
          
            
        result.setFacilitiesSpecializedTransportDetails(facilitiesSpecializedTransportDetails);
      
          
        
          
            
        result.setBenefitsWorkAccidentAnnuityRatio(benefitsWorkAccidentAnnuityRatio);
      
          
        
          
            
        result.setSocialSecurityNumber(socialSecurityNumber);
      
          
        
          
            
        result.setBenefitsWorkAccidentAnnuity(benefitsWorkAccidentAnnuity);
      
          
        
          
            
        result.setCareCareServices(careCareServices);
      
          
        
          
            
        result.setBenefitsDailyAllowances(benefitsDailyAllowances);
      
          
        
          
            
        result.setBenefitsDisabilityRatio(benefitsDisabilityRatio);
      
          
        
          
            
        result.setFatherFirstName(fatherFirstName);
      
          
        
          
            
        if (schoolingHomeSchoolingAccompanistAddress != null)
            result.setSchoolingHomeSchoolingAccompanistAddress(schoolingHomeSchoolingAccompanistAddress.clone());
      
          
        
          
            
        result.setProjectRequestsCustomCar(projectRequestsCustomCar);
      
          
        
          
            
        result.setPaymentAgencyBeneficiaryNumber(paymentAgencyBeneficiaryNumber);
      
          
        
          
            
        result.setFoldersCotorepNumber(foldersCotorepNumber);
      
          
        
          
            
        result.setProjectRequestsACTPRenewal(projectRequestsACTPRenewal);
      
          
        
          
            
        if (referentFamilyStatus != null)
            result.setReferentFamilyStatus(referentFamilyStatus);
        else
            result.setReferentFamilyStatus(fr.cg95.cvq.business.users.FamilyStatusType.getDefaultFamilyStatusType());
      
          
        
          
            
        result.setSchoolingSchoolName(schoolingSchoolName);
      
          
        
          
            
        if (dwellingSocialReceptionAddress != null)
            result.setDwellingSocialReceptionAddress(dwellingSocialReceptionAddress.clone());
      
          
        
          
            
        result.setBenefitsSupportedByAnInstitutionDetails(benefitsSupportedByAnInstitutionDetails);
      
          
        
          
            
        result.setFoldersMdph(foldersMdph);
      
          
        
          
            
        result.setMotherJob(motherJob);
      
          
        
          
            
        if (schoolingSchoolAddress != null)
            result.setSchoolingSchoolAddress(schoolingSchoolAddress.clone());
      
          
        
          
            
        result.setSchoolingTime(schoolingTime);
      
          
        
          
            
        result.setProfessionalSupportDealsWithSameProfessional(professionalSupportDealsWithSameProfessional);
      
          
        
          
            
        result.setAseReferentDepartment(aseReferentDepartment);
      
          
        
          
            
        result.setFoldersCotorepDepartment(foldersCotorepDepartment);
      
          
        
          
            
        result.setDwellingEstablishmentReception(dwellingEstablishmentReception);
      
          
        
          
            
        result.setMotherFirstName(motherFirstName);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.social.HccrAdditionalFee> additionalFeeList = new ArrayList<fr.cg95.cvq.business.request.social.HccrAdditionalFee>();
        for (HccrAdditionalFee object : additionalFee) {
            additionalFeeList.add(object.clone());
        }
        result.setAdditionalFee(additionalFeeList);
      
          
        
          
            
        result.setProjectRequestsOrdinaryWorking(projectRequestsOrdinaryWorking);
      
          
        
          
            
        result.setBenefitsDisabledWorkerRecognition(benefitsDisabledWorkerRecognition);
      
          
        
          
            
        result.setDwellingSocialReception(dwellingSocialReception);
      
          
        
          
            
        result.setProjectRequestsEuropeanParkingCard(projectRequestsEuropeanParkingCard);
      
          
        
          
            
        result.setHealthFollowedByDoctor(healthFollowedByDoctor);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.social.HccrFamilyAssistanceMember> familyAssistanceMembersList = new ArrayList<fr.cg95.cvq.business.request.social.HccrFamilyAssistanceMember>();
        for (HccrFamilyAssistanceMember object : familyAssistanceMembers) {
            familyAssistanceMembersList.add(object.clone());
        }
        result.setFamilyAssistanceMembers(familyAssistanceMembersList);
      
          
        
          
            
        result.setSchoolingHomeSchoolingAccompanistFirstName(schoolingHomeSchoolingAccompanistFirstName);
      
          
        
          
            
        result.setReferentBirthCity(referentBirthCity);
      
          
        
          
            
        result.setProjectRequestsFreePensionMembership(projectRequestsFreePensionMembership);
      
          
        
          
            
        result.setSchoolingSpecializedGradeDetails(schoolingSpecializedGradeDetails);
      
          
        
          
            
        result.setReferentBirthCountry(referentBirthCountry);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.social.HccrProfessional> professionalsList = new ArrayList<fr.cg95.cvq.business.request.social.HccrProfessional>();
        for (HccrProfessional object : professionals) {
            professionalsList.add(object.clone());
        }
        result.setProfessionals(professionalsList);
      
          
        
          
            
        result.setHealthFollowedByHospital(healthFollowedByHospital);
      
          
        
          
            
        result.setProfessionalStatusEmployerName(professionalStatusEmployerName);
      
          
        
          
            
        result.setProjectRequestsInstitutionSupport(projectRequestsInstitutionSupport);
      
          
        
          
            
        result.setBenefitsSocialWelfare(benefitsSocialWelfare);
      
          
        
          
            
        result.setProjectRequestsHandicapRecognition(projectRequestsHandicapRecognition);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.social.HccrCareService> careServicesList = new ArrayList<fr.cg95.cvq.business.request.social.HccrCareService>();
        for (HccrCareService object : careServices) {
            careServicesList.add(object.clone());
        }
        result.setCareServices(careServicesList);
      
          
        
          
            
        result.setSchoolingExtraCurricular(schoolingExtraCurricular);
      
          
        
          
            
        result.setProjectWish(projectWish);
      
          
        
          
            
        if (dwellingKind != null)
            result.setDwellingKind(dwellingKind);
        else
            result.setDwellingKind(fr.cg95.cvq.business.request.social.HccrDwellingKindType.getDefaultHccrDwellingKindType());
      
          
        
          
            
        result.setHealthProfessionalLastName(healthProfessionalLastName);
      
          
        
          
            
        result.setFormationStudiesLevel(formationStudiesLevel);
      
          
        
          
            
        result.setProjectRequestsProfessionalOrientation(projectRequestsProfessionalOrientation);
      
          
        
          
            
        result.setHealthDoctorLastName(healthDoctorLastName);
      
          
        
          
            
        if (socialServiceAddress != null)
            result.setSocialServiceAddress(socialServiceAddress.clone());
      
          
        
          
            
        result.setFacilitiesHousingDetails(facilitiesHousingDetails);
      
          
        
          
            
        result.setBenefitsSupplementForSingleParents(benefitsSupplementForSingleParents);
      
          
        
          
            
        result.setProjectRequestsIncreaseForIndependentLiving(projectRequestsIncreaseForIndependentLiving);
      
          
        
          
            
        result.setBenefitsThirdPartySupplement(benefitsThirdPartySupplement);
      
          
        
          
            
        result.setBenefitsDisabilityPensionCategory(benefitsDisabilityPensionCategory);
      
          
        
          
            
        result.setStudiesHighSchoolGrade(studiesHighSchoolGrade);
      
          
        
          
            
        result.setReferentLastName(referentLastName);
      
          
        
          
            
        result.setSubjectBirthCity(subjectBirthCity);
      
          
        
          
            
        result.setProjectRequestsAssistance(projectRequestsAssistance);
      
          
        
          
            
        result.setBenefitsSupportedByAnInstitution(benefitsSupportedByAnInstitution);
      
          
        
          
            
        if (professionalStatusEnvironment != null)
            result.setProfessionalStatusEnvironment(professionalStatusEnvironment);
        else
            result.setProfessionalStatusEnvironment(fr.cg95.cvq.business.request.social.HccrProfessionalStatusEnvironmentType.getDefaultHccrProfessionalStatusEnvironmentType());
      
          
        
          
            
        result.setProjectRequestsThirdPartyHelp(projectRequestsThirdPartyHelp);
      
          
        
          
            
        result.setProjectRequestsDisabledAdultAllowance(projectRequestsDisabledAdultAllowance);
      
          
        
          
            
        result.setFoldersOtherFolders(foldersOtherFolders);
      
          
        
          
            
        if (paymentAgencyBeneficiary != null)
            result.setPaymentAgencyBeneficiary(paymentAgencyBeneficiary);
        else
            result.setPaymentAgencyBeneficiary(fr.cg95.cvq.business.request.social.HccrPaymentAgencyBeneficiaryType.getDefaultHccrPaymentAgencyBeneficiaryType());
      
          
        
          
            
        result.setFatherJob(fatherJob);
      
          
        
          
            
        result.setFacilitiesAnimalAidDetails(facilitiesAnimalAidDetails);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.social.HccrOtherBenefit> otherBenefitsList = new ArrayList<fr.cg95.cvq.business.request.social.HccrOtherBenefit>();
        for (HccrOtherBenefit object : otherBenefits) {
            otherBenefitsList.add(object.clone());
        }
        result.setOtherBenefits(otherBenefitsList);
      
          
        
          
            
        result.setStudiesAssistanceUnderDisabilityDetails(studiesAssistanceUnderDisabilityDetails);
      
          
        
          
            
        if (paymentAgencyAddress != null)
            result.setPaymentAgencyAddress(paymentAgencyAddress.clone());
      
          
        
          
            
        result.setProjectRequestsOther(projectRequestsOther);
      
          
        
          
            
        result.setBenefitsThirdPersonCompensatoryAllowance(benefitsThirdPersonCompensatoryAllowance);
      
          
        
          
            
        result.setProjectRequestsDisabilityCostAllocation(projectRequestsDisabilityCostAllocation);
      
          
        
          
            
        if (socialSecurityAgencyAddress != null)
            result.setSocialSecurityAgencyAddress(socialSecurityAgencyAddress.clone());
      
          
        
          
            
        if (professionalStatusAddress != null)
            result.setProfessionalStatusAddress(professionalStatusAddress.clone());
      
          
        
          
            
        result.setProfessionalStatusProfession(professionalStatusProfession);
      
          
        
          
            
        if (dwellingReceptionAddress != null)
            result.setDwellingReceptionAddress(dwellingReceptionAddress.clone());
      
          
        
          
            
        result.setFormationDiploma(formationDiploma);
      
          
        
          
            
        result.setMotherLastName(motherLastName);
      
          
        
          
            
        result.setFoldersCotorep(foldersCotorep);
      
          
        
          
            
        result.setProfessionalStatusElectiveFunction(professionalStatusElectiveFunction);
      
          
        
          
            
        result.setBenefitsIncreaseForIndependentLiving(benefitsIncreaseForIndependentLiving);
      
          
        
          
            
        result.setSubjectBirthCountry(subjectBirthCountry);
      
          
        
          
            
        result.setFatherActivityReduction(fatherActivityReduction);
      
          
        
          
            
        result.setProjectRequestsDisabilityCard(projectRequestsDisabilityCard);
      
          
        
          
            
        result.setStudiesHighSchoolName(studiesHighSchoolName);
      
          
        
          
            
        if (dwellingReceptionType != null)
            result.setDwellingReceptionType(dwellingReceptionType);
        else
            result.setDwellingReceptionType(fr.cg95.cvq.business.request.social.HccrDwellingReceptionKindType.getDefaultHccrDwellingReceptionKindType());
      
          
        
          
            
        result.setFatherLastName(fatherLastName);
      
          
        
          
            
        result.setMotherActivityReductionRatio(motherActivityReductionRatio);
      
          
        
          
            
        result.setProfessionalStatusRegisterAsUnemployedDate(professionalStatusRegisterAsUnemployedDate);
      
          
        
          
            
        result.setPaymentAgencyName(paymentAgencyName);
      
          
        
          
            
        result.setSocialSecurityAgencyName(socialSecurityAgencyName);
      
          
        
          
            
        result.setDwellingReceptionNaming(dwellingReceptionNaming);
      
          
        
          
            
        result.setSchoolingSendToSchool(schoolingSendToSchool);
      
          
        
          
            
        result.setBenefitsEducationOfDisabledChildren(benefitsEducationOfDisabledChildren);
      
          
        
          
            
        result.setReferentFirstName(referentFirstName);
      
          
        
          
            
        result.setFacilitiesTechnicalAssistanceDetails(facilitiesTechnicalAssistanceDetails);
      
          
        
          
            
        result.setBenefitsOtherBenefits(benefitsOtherBenefits);
      
          
        
          
            
        result.setFoldersCdesNumber(foldersCdesNumber);
      
          
        
          
            
        result.setSocialServiceName(socialServiceName);
      
          
        
          
            
        result.setBenefitsDisabilityCompensation(benefitsDisabilityCompensation);
      
          
        
          
            
        result.setHealthDoctorFirstName(healthDoctorFirstName);
      
          
        
          
            
        result.setProjectRequestsTechnicalHelp(projectRequestsTechnicalHelp);
      
          
        
          
            
        result.setFacilitiesTechnicalAssistance(facilitiesTechnicalAssistance);
      
          
        
          
            
        result.setBenefitsCompensatoryAllowanceForExpenses(benefitsCompensatoryAllowanceForExpenses);
      
          
        
          
            
        result.setFacilitiesHousing(facilitiesHousing);
      
          
        
          
            
        result.setHealthHospitalName(healthHospitalName);
      
          
        
          
            
        result.setProjectRequestsDisabledPriorityCard(projectRequestsDisabledPriorityCard);
      
          
        
          
            
        result.setProjectRequestsEducationAllocationOfDisabledChildren(projectRequestsEducationAllocationOfDisabledChildren);
      
          
        
          
            
        result.setProjectRequestsOtherDetails(projectRequestsOtherDetails);
      
          
        
          
            
        result.setSocialServiceSupport(socialServiceSupport);
      
          
        
          
            
        result.setProjectRequestsShelteredWork(projectRequestsShelteredWork);
      
          
        
          
            
        result.setFormationCurrentFormation(formationCurrentFormation);
      
          
        
          
            
        if (schoolingSchoolingKind != null)
            result.setSchoolingSchoolingKind(schoolingSchoolingKind);
        else
            result.setSchoolingSchoolingKind(fr.cg95.cvq.business.request.social.HccrSchoolingKindType.getDefaultHccrSchoolingKindType());
      
          
        
          
            
        result.setStudiesAssistanceUnderDisability(studiesAssistanceUnderDisability);
      
          
        
          
            
        result.setStudiesHighSchool(studiesHighSchool);
      
          
        
          
            
        result.setHealthProfessionalFirstName(healthProfessionalFirstName);
      
          
        
          
            
        result.setMotherActivityReduction(motherActivityReduction);
      
          
        
          
            
        result.setFacilitiesCustomCarDetails(facilitiesCustomCarDetails);
      
          
        
          
            
        result.setSchoolingPersonalizedSchoolingPlan(schoolingPersonalizedSchoolingPlan);
      
          
        
          
            
        result.setDwellingPrecision(dwellingPrecision);
      
          
        
          
            
        result.setBenefitsDisabilityCard(benefitsDisabilityCard);
      
          
        
          
            
        if (socialSecurityMemberShipKind != null)
            result.setSocialSecurityMemberShipKind(socialSecurityMemberShipKind);
        else
            result.setSocialSecurityMemberShipKind(fr.cg95.cvq.business.request.social.HccrSocialSecurityMemberShipKindType.getDefaultHccrSocialSecurityMemberShipKindType());
      
          
        
          
            
        result.setAseReferentLastName(aseReferentLastName);
      
          
        
          
            
        result.setProfessionalStatusElectiveFunctionDetails(professionalStatusElectiveFunctionDetails);
      
          
        
          
            
        result.setFacilitiesAnimalAid(facilitiesAnimalAid);
      
          
        
          
            
        if (studiesHighSchoolAddress != null)
            result.setStudiesHighSchoolAddress(studiesHighSchoolAddress.clone());
      
          
        
        return result;
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
        
        
        profiles = {"health"},
        message = "healthFollowedByProfessional"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "professionalSupportProfessionals"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "referentFamilyDependents"
      )
    
    private Boolean referentFamilyDependents;

    public final void setReferentFamilyDependents(final Boolean referentFamilyDependents) {
        this.referentFamilyDependents = referentFamilyDependents;
    }

    /**
 
        * @hibernate.property
        *  column="referent_family_dependents"
        
      
    */
    public final Boolean getReferentFamilyDependents() {
        return this.referentFamilyDependents;
    }
  
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "isFamilyAssistance"
      )
    
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
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['schoolingSendToSchool'].test(_this.schoolingSendToSchool.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingAttendedGrade"
      )
    
    private fr.cg95.cvq.business.users.SectionType schoolingAttendedGrade;

    public final void setSchoolingAttendedGrade(final fr.cg95.cvq.business.users.SectionType schoolingAttendedGrade) {
        this.schoolingAttendedGrade = schoolingAttendedGrade;
    }

    /**
 
        * @hibernate.property
        *  column="schooling_attended_grade"
        *  length="32"
      
    */
    public final fr.cg95.cvq.business.users.SectionType getSchoolingAttendedGrade() {
        return this.schoolingAttendedGrade;
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

    public final void setFamilyDependents(final List<fr.cg95.cvq.business.request.social.HccrFamilyDependent> familyDependents) {
        this.familyDependents = familyDependents;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="handicap_compensation_child_request_id"
        * @hibernate.list-index
        *  column="family_dependents_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.social.HccrFamilyDependent"
      
    */
    public final List<fr.cg95.cvq.business.request.social.HccrFamilyDependent> getFamilyDependents() {
        return this.familyDependents;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "referentTitle"
      )
    
    private fr.cg95.cvq.business.users.TitleType referentTitle;

    public final void setReferentTitle(final fr.cg95.cvq.business.users.TitleType referentTitle) {
        this.referentTitle = referentTitle;
    }

    /**
 
        * @hibernate.property
        *  column="referent_title"
        
      
    */
    public final fr.cg95.cvq.business.users.TitleType getReferentTitle() {
        return this.referentTitle;
    }
  
    
      @MaxLength(
        
          value = 600,
        
        
        profiles = {"project"},
        message = "projectComments"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"folders"},
        message = "foldersCdes"
      )
    
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
  
    
      @MaxLength(
        
          value = 2,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['foldersMdph'].test(_this.foldersMdph.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"folders"},
        message = "foldersMdphDepartment"
      )
    
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
  
    
      @MaxLength(
        
          value = 600,
        
        
        profiles = {"project"},
        message = "projectNeeds"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "homeInterventionHomeIntervenant"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsEducationAllocationOfDisabledChildren"
      )
    
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
  
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['foldersOtherFolders'].test(_this.foldersOtherFolders.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"folders"},
        message = "otherFolders"
      )
    
    private List<fr.cg95.cvq.business.request.social.HccrOtherFolder> otherFolders;

    public final void setOtherFolders(final List<fr.cg95.cvq.business.request.social.HccrOtherFolder> otherFolders) {
        this.otherFolders = otherFolders;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="handicap_compensation_child_request_id"
        * @hibernate.list-index
        *  column="other_folders_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.social.HccrOtherFolder"
      
    */
    public final List<fr.cg95.cvq.business.request.social.HccrOtherFolder> getOtherFolders() {
        return this.otherFolders;
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
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['subjectBirthDate'].test(_this.subjectBirthDate.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "subjectParentalAuthorityHolder"
      )
    
    private fr.cg95.cvq.business.request.social.HccrSubjectParentalAuthorityHolderType subjectParentalAuthorityHolder;

    public final void setSubjectParentalAuthorityHolder(final fr.cg95.cvq.business.request.social.HccrSubjectParentalAuthorityHolderType subjectParentalAuthorityHolder) {
        this.subjectParentalAuthorityHolder = subjectParentalAuthorityHolder;
    }

    /**
 
        * @hibernate.property
        *  column="subject_parental_authority_holder"
        
      
    */
    public final fr.cg95.cvq.business.request.social.HccrSubjectParentalAuthorityHolderType getSubjectParentalAuthorityHolder() {
        return this.subjectParentalAuthorityHolder;
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
  
    
      @NotNull(
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingHomeSchooling"
      )
    
    private Boolean schoolingHomeSchooling;

    public final void setSchoolingHomeSchooling(final Boolean schoolingHomeSchooling) {
        this.schoolingHomeSchooling = schoolingHomeSchooling;
    }

    /**
 
        * @hibernate.property
        *  column="schooling_home_schooling"
        
      
    */
    public final Boolean getSchoolingHomeSchooling() {
        return this.schoolingHomeSchooling;
    }
  
    
    private java.math.BigInteger fatherActivityReductionRatio;

    public final void setFatherActivityReductionRatio(final java.math.BigInteger fatherActivityReductionRatio) {
        this.fatherActivityReductionRatio = fatherActivityReductionRatio;
    }

    /**
 
        * @hibernate.property
        *  column="father_activity_reduction_ratio"
        *  type="serializable"
        
      
    */
    public final java.math.BigInteger getFatherActivityReductionRatio() {
        return this.fatherActivityReductionRatio;
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

    public final void setSchoolingExtraCurricularDetails(final String schoolingExtraCurricularDetails) {
        this.schoolingExtraCurricularDetails = schoolingExtraCurricularDetails;
    }

    /**
 
        * @hibernate.property
        *  column="schooling_extra_curricular_details"
        *  length="50"
      
    */
    public final String getSchoolingExtraCurricularDetails() {
        return this.schoolingExtraCurricularDetails;
    }
  
    
      @NotNull(
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingSpecializedGrade"
      )
    
    private Boolean schoolingSpecializedGrade;

    public final void setSchoolingSpecializedGrade(final Boolean schoolingSpecializedGrade) {
        this.schoolingSpecializedGrade = schoolingSpecializedGrade;
    }

    /**
 
        * @hibernate.property
        *  column="schooling_specialized_grade"
        
      
    */
    public final Boolean getSchoolingSpecializedGrade() {
        return this.schoolingSpecializedGrade;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsDisabilityPension"
      )
    
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

    public final void setReferentMaidenName(final String referentMaidenName) {
        this.referentMaidenName = referentMaidenName;
    }

    /**
 
        * @hibernate.property
        *  column="referent_maiden_name"
        *  length="38"
      
    */
    public final String getReferentMaidenName() {
        return this.referentMaidenName;
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
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsUnemploymentBenefits"
      )
    
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
  
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['homeInterventionHomeIntervenant'].test(_this.homeInterventionHomeIntervenant.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "homeIntervenants"
      )
    
    private List<fr.cg95.cvq.business.request.social.HccrHomeIntervenant> homeIntervenants;

    public final void setHomeIntervenants(final List<fr.cg95.cvq.business.request.social.HccrHomeIntervenant> homeIntervenants) {
        this.homeIntervenants = homeIntervenants;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="handicap_compensation_child_request_id"
        * @hibernate.list-index
        *  column="home_intervenants_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.social.HccrHomeIntervenant"
      
    */
    public final List<fr.cg95.cvq.business.request.social.HccrHomeIntervenant> getHomeIntervenants() {
        return this.homeIntervenants;
    }
  
    
      @NotNull(
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusKind"
      )
    
    private fr.cg95.cvq.business.request.social.HccrProfessionalStatusKindType professionalStatusKind;

    public final void setProfessionalStatusKind(final fr.cg95.cvq.business.request.social.HccrProfessionalStatusKindType professionalStatusKind) {
        this.professionalStatusKind = professionalStatusKind;
    }

    /**
 
        * @hibernate.property
        *  column="professional_status_kind"
        
      
    */
    public final fr.cg95.cvq.business.request.social.HccrProfessionalStatusKindType getProfessionalStatusKind() {
        return this.professionalStatusKind;
    }
  
    
      @NotNull(
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingHomeSchoolingKind"
      )
    
    private fr.cg95.cvq.business.request.social.HccrHomeSchoolingKindType schoolingHomeSchoolingKind;

    public final void setSchoolingHomeSchoolingKind(final fr.cg95.cvq.business.request.social.HccrHomeSchoolingKindType schoolingHomeSchoolingKind) {
        this.schoolingHomeSchoolingKind = schoolingHomeSchoolingKind;
    }

    /**
 
        * @hibernate.property
        *  column="schooling_home_schooling_kind"
        
      
    */
    public final fr.cg95.cvq.business.request.social.HccrHomeSchoolingKindType getSchoolingHomeSchoolingKind() {
        return this.schoolingHomeSchoolingKind;
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
  
    
      @MaxLength(
        
          value = 180,
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "formationPreviousFormation"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "facilitiesCustomCar"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsDisabledAdultAllocation"
      )
    
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
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalStatusKind'].test(_this.professionalStatusKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusIndemnified"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingEnrolment"
      )
    
    private Boolean schoolingEnrolment;

    public final void setSchoolingEnrolment(final Boolean schoolingEnrolment) {
        this.schoolingEnrolment = schoolingEnrolment;
    }

    /**
 
        * @hibernate.property
        *  column="schooling_enrolment"
        
      
    */
    public final Boolean getSchoolingEnrolment() {
        return this.schoolingEnrolment;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsThirdPartyCompensatoryAllowance"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "referentBirthDate"
      )
    
    private java.util.Date referentBirthDate;

    public final void setReferentBirthDate(final java.util.Date referentBirthDate) {
        this.referentBirthDate = referentBirthDate;
    }

    /**
 
        * @hibernate.property
        *  column="referent_birth_date"
        
      
    */
    public final java.util.Date getReferentBirthDate() {
        return this.referentBirthDate;
    }
  
    
      @NotNull(
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusDate"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsProfessionalOrientation"
      )
    
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

    public final void setSchoolingHomeSchoolingAccompanistLastName(final String schoolingHomeSchoolingAccompanistLastName) {
        this.schoolingHomeSchoolingAccompanistLastName = schoolingHomeSchoolingAccompanistLastName;
    }

    /**
 
        * @hibernate.property
        *  column="schooling_home_schooling_accompanist_last_name"
        *  length="38"
      
    */
    public final String getSchoolingHomeSchoolingAccompanistLastName() {
        return this.schoolingHomeSchoolingAccompanistLastName;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsDisabilityRecognition"
      )
    
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
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalStatusKind'].test(_this.professionalStatusKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusRegisterAsUnemployed"
      )
    
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
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalStatusIndemnified'].test(_this.professionalStatusIndemnified.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusIndemnifiedDate"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsPainfulStandingCard"
      )
    
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
  
    
      @MaxLength(
        
          value = 2,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['foldersCdes'].test(_this.foldersCdes.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"folders"},
        message = "foldersCdesDepartment"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "facilitiesSpecializedTransport"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsParkingCard"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsWorkAccidentAnnuity"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "careCareServices"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsDailyAllowances"
      )
    
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
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['subjectBirthDate'].test(_this.subjectBirthDate.toString());" +
                
              
            
            "return active",
        
        profiles = {"subject"},
        message = "fatherFirstName"
      )
    
    private String fatherFirstName;

    public final void setFatherFirstName(final String fatherFirstName) {
        this.fatherFirstName = fatherFirstName;
    }

    /**
 
        * @hibernate.property
        *  column="father_first_name"
        *  length="38"
      
    */
    public final String getFatherFirstName() {
        return this.fatherFirstName;
    }
  
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['schoolingHomeSchoolingKind'].test(_this.schoolingHomeSchoolingKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingHomeSchoolingAccompanistAddress"
      )
    
    private fr.cg95.cvq.business.users.Address schoolingHomeSchoolingAccompanistAddress;

    public final void setSchoolingHomeSchoolingAccompanistAddress(final fr.cg95.cvq.business.users.Address schoolingHomeSchoolingAccompanistAddress) {
        this.schoolingHomeSchoolingAccompanistAddress = schoolingHomeSchoolingAccompanistAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="schooling_home_schooling_accompanist_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getSchoolingHomeSchoolingAccompanistAddress() {
        return this.schoolingHomeSchoolingAccompanistAddress;
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
  
    
      @MaxLength(
        
          value = 30,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['foldersCotorep'].test(_this.foldersCotorep.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"folders"},
        message = "foldersCotorepNumber"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "referentFamilyStatus"
      )
    
    private fr.cg95.cvq.business.users.FamilyStatusType referentFamilyStatus;

    public final void setReferentFamilyStatus(final fr.cg95.cvq.business.users.FamilyStatusType referentFamilyStatus) {
        this.referentFamilyStatus = referentFamilyStatus;
    }

    /**
 
        * @hibernate.property
        *  column="referent_family_status"
        
      
    */
    public final fr.cg95.cvq.business.users.FamilyStatusType getReferentFamilyStatus() {
        return this.referentFamilyStatus;
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

    public final void setSchoolingSchoolName(final String schoolingSchoolName) {
        this.schoolingSchoolName = schoolingSchoolName;
    }

    /**
 
        * @hibernate.property
        *  column="schooling_school_name"
        *  length="80"
      
    */
    public final String getSchoolingSchoolName() {
        return this.schoolingSchoolName;
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
  
    
      @NotNull(
        
        
        profiles = {"folders"},
        message = "foldersMdph"
      )
    
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
  
    
      @MaxLength(
        
          value = 60,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['subjectBirthDate'].test(_this.subjectBirthDate.toString());" +
                
              
            
            "return active",
        
        profiles = {"subject"},
        message = "motherJob"
      )
    
    private String motherJob;

    public final void setMotherJob(final String motherJob) {
        this.motherJob = motherJob;
    }

    /**
 
        * @hibernate.property
        *  column="mother_job"
        *  length="60"
      
    */
    public final String getMotherJob() {
        return this.motherJob;
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

    public final void setSchoolingSchoolAddress(final fr.cg95.cvq.business.users.Address schoolingSchoolAddress) {
        this.schoolingSchoolAddress = schoolingSchoolAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="schooling_school_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getSchoolingSchoolAddress() {
        return this.schoolingSchoolAddress;
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

    public final void setSchoolingTime(final String schoolingTime) {
        this.schoolingTime = schoolingTime;
    }

    /**
 
        * @hibernate.property
        *  column="schooling_time"
        *  length="4"
      
    */
    public final String getSchoolingTime() {
        return this.schoolingTime;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalSupportProfessionals'].test(_this.professionalSupportProfessionals.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "professionalSupportDealsWithSameProfessional"
      )
    
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
  
    
      @MaxLength(
        
          value = 2,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['subjectBirthDate'].test(_this.subjectBirthDate.toString());" +
                
              
            
            "return active",
        
        profiles = {"subject"},
        message = "aseReferentDepartment"
      )
    
    private String aseReferentDepartment;

    public final void setAseReferentDepartment(final String aseReferentDepartment) {
        this.aseReferentDepartment = aseReferentDepartment;
    }

    /**
 
        * @hibernate.property
        *  column="ase_referent_department"
        *  length="2"
      
    */
    public final String getAseReferentDepartment() {
        return this.aseReferentDepartment;
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
  
    
      @NotNull(
        
        
        profiles = {"dwelling"},
        message = "dwellingEstablishmentReception"
      )
    
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
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['subjectBirthDate'].test(_this.subjectBirthDate.toString());" +
                
              
            
            "return active",
        
        profiles = {"subject"},
        message = "motherFirstName"
      )
    
    private String motherFirstName;

    public final void setMotherFirstName(final String motherFirstName) {
        this.motherFirstName = motherFirstName;
    }

    /**
 
        * @hibernate.property
        *  column="mother_first_name"
        *  length="38"
      
    */
    public final String getMotherFirstName() {
        return this.motherFirstName;
    }
  
    
      @AssertValid(
        
        
        profiles = {"benefits"},
        message = "additionalFee"
      )
    
    private List<fr.cg95.cvq.business.request.social.HccrAdditionalFee> additionalFee;

    public final void setAdditionalFee(final List<fr.cg95.cvq.business.request.social.HccrAdditionalFee> additionalFee) {
        this.additionalFee = additionalFee;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="handicap_compensation_child_request_id"
        * @hibernate.list-index
        *  column="additional_fee_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.social.HccrAdditionalFee"
      
    */
    public final List<fr.cg95.cvq.business.request.social.HccrAdditionalFee> getAdditionalFee() {
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
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsDisabledWorkerRecognition"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"dwelling"},
        message = "dwellingSocialReception"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"health"},
        message = "healthFollowedByDoctor"
      )
    
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

    public final void setFamilyAssistanceMembers(final List<fr.cg95.cvq.business.request.social.HccrFamilyAssistanceMember> familyAssistanceMembers) {
        this.familyAssistanceMembers = familyAssistanceMembers;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="handicap_compensation_child_request_id"
        * @hibernate.list-index
        *  column="family_assistance_members_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.social.HccrFamilyAssistanceMember"
      
    */
    public final List<fr.cg95.cvq.business.request.social.HccrFamilyAssistanceMember> getFamilyAssistanceMembers() {
        return this.familyAssistanceMembers;
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

    public final void setSchoolingHomeSchoolingAccompanistFirstName(final String schoolingHomeSchoolingAccompanistFirstName) {
        this.schoolingHomeSchoolingAccompanistFirstName = schoolingHomeSchoolingAccompanistFirstName;
    }

    /**
 
        * @hibernate.property
        *  column="schooling_home_schooling_accompanist_first_name"
        *  length="38"
      
    */
    public final String getSchoolingHomeSchoolingAccompanistFirstName() {
        return this.schoolingHomeSchoolingAccompanistFirstName;
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

    public final void setReferentBirthCity(final String referentBirthCity) {
        this.referentBirthCity = referentBirthCity;
    }

    /**
 
        * @hibernate.property
        *  column="referent_birth_city"
        *  length="32"
      
    */
    public final String getReferentBirthCity() {
        return this.referentBirthCity;
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

    public final void setSchoolingSpecializedGradeDetails(final String schoolingSpecializedGradeDetails) {
        this.schoolingSpecializedGradeDetails = schoolingSpecializedGradeDetails;
    }

    /**
 
        * @hibernate.property
        *  column="schooling_specialized_grade_details"
        *  length="30"
      
    */
    public final String getSchoolingSpecializedGradeDetails() {
        return this.schoolingSpecializedGradeDetails;
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

    public final void setReferentBirthCountry(final String referentBirthCountry) {
        this.referentBirthCountry = referentBirthCountry;
    }

    /**
 
        * @hibernate.property
        *  column="referent_birth_country"
        *  length="50"
      
    */
    public final String getReferentBirthCountry() {
        return this.referentBirthCountry;
    }
  
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalSupportProfessionals'].test(_this.professionalSupportProfessionals.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "professionals"
      )
    
    private List<fr.cg95.cvq.business.request.social.HccrProfessional> professionals;

    public final void setProfessionals(final List<fr.cg95.cvq.business.request.social.HccrProfessional> professionals) {
        this.professionals = professionals;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="handicap_compensation_child_request_id"
        * @hibernate.list-index
        *  column="professionals_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.social.HccrProfessional"
      
    */
    public final List<fr.cg95.cvq.business.request.social.HccrProfessional> getProfessionals() {
        return this.professionals;
    }
  
    
      @NotNull(
        
        
        profiles = {"health"},
        message = "healthFollowedByHospital"
      )
    
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
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalStatusKind'].test(_this.professionalStatusKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusEmployerName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalStatusKind'].test(_this.professionalStatusKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusEmployerName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalStatusKind'].test(_this.professionalStatusKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusEmployerName"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsSocialWelfare"
      )
    
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

    public final void setCareServices(final List<fr.cg95.cvq.business.request.social.HccrCareService> careServices) {
        this.careServices = careServices;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="handicap_compensation_child_request_id"
        * @hibernate.list-index
        *  column="care_services_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.social.HccrCareService"
      
    */
    public final List<fr.cg95.cvq.business.request.social.HccrCareService> getCareServices() {
        return this.careServices;
    }
  
    
      @NotNull(
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingExtraCurricular"
      )
    
    private Boolean schoolingExtraCurricular;

    public final void setSchoolingExtraCurricular(final Boolean schoolingExtraCurricular) {
        this.schoolingExtraCurricular = schoolingExtraCurricular;
    }

    /**
 
        * @hibernate.property
        *  column="schooling_extra_curricular"
        
      
    */
    public final Boolean getSchoolingExtraCurricular() {
        return this.schoolingExtraCurricular;
    }
  
    
      @MaxLength(
        
          value = 600,
        
        
        profiles = {"project"},
        message = "projectWish"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"dwelling"},
        message = "dwellingKind"
      )
    
    private fr.cg95.cvq.business.request.social.HccrDwellingKindType dwellingKind;

    public final void setDwellingKind(final fr.cg95.cvq.business.request.social.HccrDwellingKindType dwellingKind) {
        this.dwellingKind = dwellingKind;
    }

    /**
 
        * @hibernate.property
        *  column="dwelling_kind"
        
      
    */
    public final fr.cg95.cvq.business.request.social.HccrDwellingKindType getDwellingKind() {
        return this.dwellingKind;
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
  
    
      @MaxLength(
        
          value = 30,
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "formationStudiesLevel"
      )
    
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

    public final void setSocialServiceAddress(final fr.cg95.cvq.business.users.Address socialServiceAddress) {
        this.socialServiceAddress = socialServiceAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="social_service_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getSocialServiceAddress() {
        return this.socialServiceAddress;
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
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsSupplementForSingleParents"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsThirdPartySupplement"
      )
    
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

    public final void setReferentLastName(final String referentLastName) {
        this.referentLastName = referentLastName;
    }

    /**
 
        * @hibernate.property
        *  column="referent_last_name"
        *  length="38"
      
    */
    public final String getReferentLastName() {
        return this.referentLastName;
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
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsSupportedByAnInstitution"
      )
    
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
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalStatusKind'].test(_this.professionalStatusKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusEnvironment"
      )
    
    private fr.cg95.cvq.business.request.social.HccrProfessionalStatusEnvironmentType professionalStatusEnvironment;

    public final void setProfessionalStatusEnvironment(final fr.cg95.cvq.business.request.social.HccrProfessionalStatusEnvironmentType professionalStatusEnvironment) {
        this.professionalStatusEnvironment = professionalStatusEnvironment;
    }

    /**
 
        * @hibernate.property
        *  column="professional_status_environment"
        
      
    */
    public final fr.cg95.cvq.business.request.social.HccrProfessionalStatusEnvironmentType getProfessionalStatusEnvironment() {
        return this.professionalStatusEnvironment;
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
  
    
      @NotNull(
        
        
        profiles = {"folders"},
        message = "foldersOtherFolders"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"socialSecurityAndPaymentAgency"},
        message = "paymentAgencyBeneficiary"
      )
    
    private fr.cg95.cvq.business.request.social.HccrPaymentAgencyBeneficiaryType paymentAgencyBeneficiary;

    public final void setPaymentAgencyBeneficiary(final fr.cg95.cvq.business.request.social.HccrPaymentAgencyBeneficiaryType paymentAgencyBeneficiary) {
        this.paymentAgencyBeneficiary = paymentAgencyBeneficiary;
    }

    /**
 
        * @hibernate.property
        *  column="payment_agency_beneficiary"
        
      
    */
    public final fr.cg95.cvq.business.request.social.HccrPaymentAgencyBeneficiaryType getPaymentAgencyBeneficiary() {
        return this.paymentAgencyBeneficiary;
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

    public final void setFatherJob(final String fatherJob) {
        this.fatherJob = fatherJob;
    }

    /**
 
        * @hibernate.property
        *  column="father_job"
        *  length="60"
      
    */
    public final String getFatherJob() {
        return this.fatherJob;
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
  
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['benefitsOtherBenefits'].test(_this.benefitsOtherBenefits.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"benefits"},
        message = "otherBenefits"
      )
    
    private List<fr.cg95.cvq.business.request.social.HccrOtherBenefit> otherBenefits;

    public final void setOtherBenefits(final List<fr.cg95.cvq.business.request.social.HccrOtherBenefit> otherBenefits) {
        this.otherBenefits = otherBenefits;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="handicap_compensation_child_request_id"
        * @hibernate.list-index
        *  column="other_benefits_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.social.HccrOtherBenefit"
      
    */
    public final List<fr.cg95.cvq.business.request.social.HccrOtherBenefit> getOtherBenefits() {
        return this.otherBenefits;
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
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsThirdPersonCompensatoryAllowance"
      )
    
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
  
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalStatusKind'].test(_this.professionalStatusKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusAddress"
      )
    
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
  
    
      @MaxLength(
        
          value = 60,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalStatusKind'].test(_this.professionalStatusKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusProfession"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalStatusKind'].test(_this.professionalStatusKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusProfession"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalStatusKind'].test(_this.professionalStatusKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusProfession"
      )
    
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
  
    
      @MaxLength(
        
          value = 120,
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "formationDiploma"
      )
    
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
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            
            "active &= _this.conditions['subjectBirthDate'].test(_this.subjectBirthDate.toString());" +
                
              
            
            "return active",
        
        profiles = {"subject"},
        message = "motherLastName"
      )
    
    private String motherLastName;

    public final void setMotherLastName(final String motherLastName) {
        this.motherLastName = motherLastName;
    }

    /**
 
        * @hibernate.property
        *  column="mother_last_name"
        *  length="38"
      
    */
    public final String getMotherLastName() {
        return this.motherLastName;
    }
  
    
      @NotNull(
        
        
        profiles = {"folders"},
        message = "foldersCotorep"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusElectiveFunction"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsIncreaseForIndependentLiving"
      )
    
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
  
    
    private Boolean fatherActivityReduction;

    public final void setFatherActivityReduction(final Boolean fatherActivityReduction) {
        this.fatherActivityReduction = fatherActivityReduction;
    }

    /**
 
        * @hibernate.property
        *  column="father_activity_reduction"
        
      
    */
    public final Boolean getFatherActivityReduction() {
        return this.fatherActivityReduction;
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
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dwellingEstablishmentReception'].test(_this.dwellingEstablishmentReception.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"dwelling"},
        message = "dwellingReceptionType"
      )
    
    private fr.cg95.cvq.business.request.social.HccrDwellingReceptionKindType dwellingReceptionType;

    public final void setDwellingReceptionType(final fr.cg95.cvq.business.request.social.HccrDwellingReceptionKindType dwellingReceptionType) {
        this.dwellingReceptionType = dwellingReceptionType;
    }

    /**
 
        * @hibernate.property
        *  column="dwelling_reception_type"
        
      
    */
    public final fr.cg95.cvq.business.request.social.HccrDwellingReceptionKindType getDwellingReceptionType() {
        return this.dwellingReceptionType;
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

    public final void setFatherLastName(final String fatherLastName) {
        this.fatherLastName = fatherLastName;
    }

    /**
 
        * @hibernate.property
        *  column="father_last_name"
        *  length="38"
      
    */
    public final String getFatherLastName() {
        return this.fatherLastName;
    }
  
    
    private java.math.BigInteger motherActivityReductionRatio;

    public final void setMotherActivityReductionRatio(final java.math.BigInteger motherActivityReductionRatio) {
        this.motherActivityReductionRatio = motherActivityReductionRatio;
    }

    /**
 
        * @hibernate.property
        *  column="mother_activity_reduction_ratio"
        *  type="serializable"
        
      
    */
    public final java.math.BigInteger getMotherActivityReductionRatio() {
        return this.motherActivityReductionRatio;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalStatusRegisterAsUnemployed'].test(_this.professionalStatusRegisterAsUnemployed.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusRegisterAsUnemployedDate"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingSendToSchool"
      )
    
    private Boolean schoolingSendToSchool;

    public final void setSchoolingSendToSchool(final Boolean schoolingSendToSchool) {
        this.schoolingSendToSchool = schoolingSendToSchool;
    }

    /**
 
        * @hibernate.property
        *  column="schooling_send_to_school"
        
      
    */
    public final Boolean getSchoolingSendToSchool() {
        return this.schoolingSendToSchool;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsEducationOfDisabledChildren"
      )
    
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

    public final void setReferentFirstName(final String referentFirstName) {
        this.referentFirstName = referentFirstName;
    }

    /**
 
        * @hibernate.property
        *  column="referent_first_name"
        *  length="38"
      
    */
    public final String getReferentFirstName() {
        return this.referentFirstName;
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
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsOtherBenefits"
      )
    
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
  
    
      @MaxLength(
        
          value = 30,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['foldersCdes'].test(_this.foldersCdes.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"folders"},
        message = "foldersCdesNumber"
      )
    
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

    public final void setSocialServiceName(final String socialServiceName) {
        this.socialServiceName = socialServiceName;
    }

    /**
 
        * @hibernate.property
        *  column="social_service_name"
        *  length="60"
      
    */
    public final String getSocialServiceName() {
        return this.socialServiceName;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsDisabilityCompensation"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "facilitiesTechnicalAssistance"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsCompensatoryAllowanceForExpenses"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "facilitiesHousing"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "socialServiceSupport"
      )
    
    private Boolean socialServiceSupport;

    public final void setSocialServiceSupport(final Boolean socialServiceSupport) {
        this.socialServiceSupport = socialServiceSupport;
    }

    /**
 
        * @hibernate.property
        *  column="social_service_support"
        
      
    */
    public final Boolean getSocialServiceSupport() {
        return this.socialServiceSupport;
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
  
    
      @MaxLength(
        
          value = 120,
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "formationCurrentFormation"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingSchoolingKind"
      )
    
    private fr.cg95.cvq.business.request.social.HccrSchoolingKindType schoolingSchoolingKind;

    public final void setSchoolingSchoolingKind(final fr.cg95.cvq.business.request.social.HccrSchoolingKindType schoolingSchoolingKind) {
        this.schoolingSchoolingKind = schoolingSchoolingKind;
    }

    /**
 
        * @hibernate.property
        *  column="schooling_schooling_kind"
        
      
    */
    public final fr.cg95.cvq.business.request.social.HccrSchoolingKindType getSchoolingSchoolingKind() {
        return this.schoolingSchoolingKind;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['studiesHighSchool'].test(_this.studiesHighSchool.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "studiesAssistanceUnderDisability"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "studiesHighSchool"
      )
    
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
  
    
    private Boolean motherActivityReduction;

    public final void setMotherActivityReduction(final Boolean motherActivityReduction) {
        this.motherActivityReduction = motherActivityReduction;
    }

    /**
 
        * @hibernate.property
        *  column="mother_activity_reduction"
        
      
    */
    public final Boolean getMotherActivityReduction() {
        return this.motherActivityReduction;
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
  
    
      @NotNull(
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "schoolingPersonalizedSchoolingPlan"
      )
    
    private Boolean schoolingPersonalizedSchoolingPlan;

    public final void setSchoolingPersonalizedSchoolingPlan(final Boolean schoolingPersonalizedSchoolingPlan) {
        this.schoolingPersonalizedSchoolingPlan = schoolingPersonalizedSchoolingPlan;
    }

    /**
 
        * @hibernate.property
        *  column="schooling_personalized_schooling_plan"
        
      
    */
    public final Boolean getSchoolingPersonalizedSchoolingPlan() {
        return this.schoolingPersonalizedSchoolingPlan;
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
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "benefitsDisabilityCard"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"socialSecurityAndPaymentAgency"},
        message = "socialSecurityMemberShipKind"
      )
    
    private fr.cg95.cvq.business.request.social.HccrSocialSecurityMemberShipKindType socialSecurityMemberShipKind;

    public final void setSocialSecurityMemberShipKind(final fr.cg95.cvq.business.request.social.HccrSocialSecurityMemberShipKindType socialSecurityMemberShipKind) {
        this.socialSecurityMemberShipKind = socialSecurityMemberShipKind;
    }

    /**
 
        * @hibernate.property
        *  column="social_security_member_ship_kind"
        
      
    */
    public final fr.cg95.cvq.business.request.social.HccrSocialSecurityMemberShipKindType getSocialSecurityMemberShipKind() {
        return this.socialSecurityMemberShipKind;
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

    public final void setAseReferentLastName(final String aseReferentLastName) {
        this.aseReferentLastName = aseReferentLastName;
    }

    /**
 
        * @hibernate.property
        *  column="ase_referent_last_name"
        *  length="38"
      
    */
    public final String getAseReferentLastName() {
        return this.aseReferentLastName;
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
  
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "facilitiesAnimalAid"
      )
    
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
