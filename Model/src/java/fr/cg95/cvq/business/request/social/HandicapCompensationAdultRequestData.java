
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
 *  table="handicap_compensation_adult_request"
 *  lazy="false"
 */
public class HandicapCompensationAdultRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public HandicapCompensationAdultRequestData() {
      
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
      
        familyFamilyDependents = Boolean.valueOf(false);
      
        foldersCdes = Boolean.valueOf(false);
      
        foldersCotorep = Boolean.valueOf(false);
      
        foldersMdph = Boolean.valueOf(false);
      
        foldersOtherFolders = Boolean.valueOf(false);
      
        healthFollowedByDoctor = Boolean.valueOf(false);
      
        healthFollowedByHospital = Boolean.valueOf(false);
      
        healthFollowedByProfessional = Boolean.valueOf(false);
      
        homeInterventionHomeIntervenant = Boolean.valueOf(false);
      
        isFamilyAssistance = Boolean.valueOf(false);
      
        legalAccessPresence = Boolean.valueOf(false);
      
        professionalStatusElectiveFunction = Boolean.valueOf(false);
      
        professionalStatusIndemnified = Boolean.valueOf(false);
      
        professionalStatusRegisterAsUnemployed = Boolean.valueOf(false);
      
        professionalSupportDealsWithSameProfessional = Boolean.valueOf(false);
      
        professionalSupportProfessionals = Boolean.valueOf(false);
      
        professionalSupportSocialServiceSupport = Boolean.valueOf(false);
      
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
      
        studiesAssistanceUnderDisability = Boolean.valueOf(false);
      
        studiesHighSchool = Boolean.valueOf(false);
      
    }

    @Override
    public HandicapCompensationAdultRequestData clone() {
        HandicapCompensationAdultRequestData result = new HandicapCompensationAdultRequestData();
        
          
            
        List<fr.cg95.cvq.business.request.social.HcarAdditionalFee> additionalFeeList = new ArrayList<fr.cg95.cvq.business.request.social.HcarAdditionalFee>();
        for (HcarAdditionalFee object : additionalFee) {
            additionalFeeList.add(object.clone());
        }
        result.setAdditionalFee(additionalFeeList);
      
          
        
          
            
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
      
          
        
          
            
        List<fr.cg95.cvq.business.request.social.HcarCareService> careServicesList = new ArrayList<fr.cg95.cvq.business.request.social.HcarCareService>();
        for (HcarCareService object : careServices) {
            careServicesList.add(object.clone());
        }
        result.setCareServices(careServicesList);
      
          
        
          
            
        result.setDwellingEstablishmentReception(dwellingEstablishmentReception);
      
          
        
          
            
        if (dwellingKind != null)
            result.setDwellingKind(dwellingKind);
        else
            result.setDwellingKind(fr.cg95.cvq.business.request.social.HcarDwellingKindType.getDefaultHcarDwellingKindType());
      
          
        
          
            
        result.setDwellingPrecision(dwellingPrecision);
      
          
        
          
            
        if (dwellingReceptionAddress != null)
            result.setDwellingReceptionAddress(dwellingReceptionAddress.clone());
      
          
        
          
            
        result.setDwellingReceptionNaming(dwellingReceptionNaming);
      
          
        
          
            
        if (dwellingReceptionType != null)
            result.setDwellingReceptionType(dwellingReceptionType);
        else
            result.setDwellingReceptionType(fr.cg95.cvq.business.request.social.HcarDwellingReceptionKindType.getDefaultHcarDwellingReceptionKindType());
      
          
        
          
            
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
      
          
        
          
            
        List<fr.cg95.cvq.business.request.social.HcarFamilyAssistanceMember> familyAssistanceMembersList = new ArrayList<fr.cg95.cvq.business.request.social.HcarFamilyAssistanceMember>();
        for (HcarFamilyAssistanceMember object : familyAssistanceMembers) {
            familyAssistanceMembersList.add(object.clone());
        }
        result.setFamilyAssistanceMembers(familyAssistanceMembersList);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.social.HcarFamilyDependent> familyDependentsList = new ArrayList<fr.cg95.cvq.business.request.social.HcarFamilyDependent>();
        for (HcarFamilyDependent object : familyDependents) {
            familyDependentsList.add(object.clone());
        }
        result.setFamilyDependents(familyDependentsList);
      
          
        
          
            
        result.setFamilyFamilyDependents(familyFamilyDependents);
      
          
        
          
            
        if (familyStatus != null)
            result.setFamilyStatus(familyStatus);
        else
            result.setFamilyStatus(fr.cg95.cvq.business.users.FamilyStatusType.getDefaultFamilyStatusType());
      
          
        
          
            
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
      
          
        
          
            
        List<fr.cg95.cvq.business.request.social.HcarHomeIntervenant> homeIntervenantsList = new ArrayList<fr.cg95.cvq.business.request.social.HcarHomeIntervenant>();
        for (HcarHomeIntervenant object : homeIntervenants) {
            homeIntervenantsList.add(object.clone());
        }
        result.setHomeIntervenants(homeIntervenantsList);
      
          
        
          
            
        result.setHomeInterventionHomeIntervenant(homeInterventionHomeIntervenant);
      
          
        
          
            
        result.setIsFamilyAssistance(isFamilyAssistance);
      
          
        
          
            
        if (legalAccessKind != null)
            result.setLegalAccessKind(legalAccessKind);
        else
            result.setLegalAccessKind(fr.cg95.cvq.business.request.social.HcarLegalAccessKindType.getDefaultHcarLegalAccessKindType());
      
          
        
          
            
        result.setLegalAccessPresence(legalAccessPresence);
      
          
        
          
            
        result.setLegalAccessRepresentativeFirstName(legalAccessRepresentativeFirstName);
      
          
        
          
            
        if (legalAccessRepresentativeKind != null)
            result.setLegalAccessRepresentativeKind(legalAccessRepresentativeKind);
        else
            result.setLegalAccessRepresentativeKind(fr.cg95.cvq.business.request.social.HcarLegalAccessRepresentativeKindType.getDefaultHcarLegalAccessRepresentativeKindType());
      
          
        
          
            
        result.setLegalAccessRepresentativeKindDetail(legalAccessRepresentativeKindDetail);
      
          
        
          
            
        result.setLegalAccessRepresentativeName(legalAccessRepresentativeName);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.social.HcarOtherBenefit> otherBenefitsList = new ArrayList<fr.cg95.cvq.business.request.social.HcarOtherBenefit>();
        for (HcarOtherBenefit object : otherBenefits) {
            otherBenefitsList.add(object.clone());
        }
        result.setOtherBenefits(otherBenefitsList);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.social.HcarOtherFolder> otherFoldersList = new ArrayList<fr.cg95.cvq.business.request.social.HcarOtherFolder>();
        for (HcarOtherFolder object : otherFolders) {
            otherFoldersList.add(object.clone());
        }
        result.setOtherFolders(otherFoldersList);
      
          
        
          
            
        if (paymentAgencyAddress != null)
            result.setPaymentAgencyAddress(paymentAgencyAddress.clone());
      
          
        
          
            
        if (paymentAgencyBeneficiary != null)
            result.setPaymentAgencyBeneficiary(paymentAgencyBeneficiary);
        else
            result.setPaymentAgencyBeneficiary(fr.cg95.cvq.business.request.social.HcarPaymentAgencyBeneficiaryType.getDefaultHcarPaymentAgencyBeneficiaryType());
      
          
        
          
            
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
            result.setProfessionalStatusEnvironment(fr.cg95.cvq.business.request.social.HcarProfessionalStatusEnvironmentType.getDefaultHcarProfessionalStatusEnvironmentType());
      
          
        
          
            
        result.setProfessionalStatusIndemnified(professionalStatusIndemnified);
      
          
        
          
            
        result.setProfessionalStatusIndemnifiedDate(professionalStatusIndemnifiedDate);
      
          
        
          
            
        if (professionalStatusKind != null)
            result.setProfessionalStatusKind(professionalStatusKind);
        else
            result.setProfessionalStatusKind(fr.cg95.cvq.business.request.social.HcarProfessionalStatusKindType.getDefaultHcarProfessionalStatusKindType());
      
          
        
          
            
        result.setProfessionalStatusProfession(professionalStatusProfession);
      
          
        
          
            
        result.setProfessionalStatusRegisterAsUnemployed(professionalStatusRegisterAsUnemployed);
      
          
        
          
            
        result.setProfessionalStatusRegisterAsUnemployedDate(professionalStatusRegisterAsUnemployedDate);
      
          
        
          
            
        result.setProfessionalSupportDealsWithSameProfessional(professionalSupportDealsWithSameProfessional);
      
          
        
          
            
        result.setProfessionalSupportProfessionals(professionalSupportProfessionals);
      
          
        
          
            
        if (professionalSupportSocialServiceAddress != null)
            result.setProfessionalSupportSocialServiceAddress(professionalSupportSocialServiceAddress.clone());
      
          
        
          
            
        result.setProfessionalSupportSocialServiceName(professionalSupportSocialServiceName);
      
          
        
          
            
        result.setProfessionalSupportSocialServiceSupport(professionalSupportSocialServiceSupport);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.social.HcarProfessional> professionalsList = new ArrayList<fr.cg95.cvq.business.request.social.HcarProfessional>();
        for (HcarProfessional object : professionals) {
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
      
          
        
          
            
        if (socialSecurityAgencyAddress != null)
            result.setSocialSecurityAgencyAddress(socialSecurityAgencyAddress.clone());
      
          
        
          
            
        result.setSocialSecurityAgencyName(socialSecurityAgencyName);
      
          
        
          
            
        if (socialSecurityMemberShipKind != null)
            result.setSocialSecurityMemberShipKind(socialSecurityMemberShipKind);
        else
            result.setSocialSecurityMemberShipKind(fr.cg95.cvq.business.request.social.HcarSocialSecurityMemberShipKindType.getDefaultHcarSocialSecurityMemberShipKindType());
      
          
        
          
            
        result.setSocialSecurityNumber(socialSecurityNumber);
      
          
        
          
            
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
      
          
        
          
            
        result.setSubjectMaidenName(subjectMaidenName);
      
          
        
          
            
        if (subjectTitle != null)
            result.setSubjectTitle(subjectTitle);
        else
            result.setSubjectTitle(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
      
          
        
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

  
    
      @AssertValid(
        
        
        profiles = {"benefits"},
        message = "additionalFee"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"dwelling"},
        message = "dwellingKind"
      )
    
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
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dwellingEstablishmentReception'].test(_this.dwellingEstablishmentReception.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"dwelling"},
        message = "dwellingReceptionType"
      )
    
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
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['familyFamilyDependents'].test(_this.familyFamilyDependents.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "familyDependents"
      )
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['familyFamilyDependents'].test(_this.familyFamilyDependents.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "familyDependents"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "familyFamilyDependents"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "familyStatus"
      )
    
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
  
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['homeInterventionHomeIntervenant'].test(_this.homeInterventionHomeIntervenant.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "homeIntervenants"
      )
    
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
          
            "active &= _this.conditions['legalAccessPresence'].test(_this.legalAccessPresence.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "legalAccessKind"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "legalAccessPresence"
      )
    
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
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['legalAccessPresence'].test(_this.legalAccessPresence.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "legalAccessRepresentativeFirstName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['legalAccessPresence'].test(_this.legalAccessPresence.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "legalAccessRepresentativeFirstName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['legalAccessPresence'].test(_this.legalAccessPresence.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "legalAccessRepresentativeFirstName"
      )
    
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
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['legalAccessPresence'].test(_this.legalAccessPresence.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "legalAccessRepresentativeKind"
      )
    
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
  
    
      @MaxLength(
        
          value = 80,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['legalAccessRepresentativeKind'].test(_this.legalAccessRepresentativeKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "legalAccessRepresentativeKindDetail"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['legalAccessRepresentativeKind'].test(_this.legalAccessRepresentativeKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "legalAccessRepresentativeKindDetail"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['legalAccessRepresentativeKind'].test(_this.legalAccessRepresentativeKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "legalAccessRepresentativeKindDetail"
      )
    
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
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['legalAccessPresence'].test(_this.legalAccessPresence.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "legalAccessRepresentativeName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['legalAccessPresence'].test(_this.legalAccessPresence.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "legalAccessRepresentativeName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['legalAccessPresence'].test(_this.legalAccessPresence.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "legalAccessRepresentativeName"
      )
    
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
  
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['benefitsOtherBenefits'].test(_this.benefitsOtherBenefits.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"benefits"},
        message = "otherBenefits"
      )
    
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
  
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['foldersOtherFolders'].test(_this.foldersOtherFolders.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"folders"},
        message = "otherFolders"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"socialSecurityAndPaymentAgency"},
        message = "paymentAgencyBeneficiary"
      )
    
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
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalStatusKind'].test(_this.professionalStatusKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusEnvironment"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"occupationnalAndSchoolStatus"},
        message = "professionalStatusKind"
      )
    
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
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalSupportSocialServiceSupport'].test(_this.professionalSupportSocialServiceSupport.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "professionalSupportSocialServiceAddress"
      )
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalSupportSocialServiceSupport'].test(_this.professionalSupportSocialServiceSupport.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "professionalSupportSocialServiceAddress"
      )
    
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
  
    
      @MaxLength(
        
          value = 60,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalSupportSocialServiceSupport'].test(_this.professionalSupportSocialServiceSupport.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "professionalSupportSocialServiceName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalSupportSocialServiceSupport'].test(_this.professionalSupportSocialServiceSupport.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "professionalSupportSocialServiceName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalSupportSocialServiceSupport'].test(_this.professionalSupportSocialServiceSupport.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "professionalSupportSocialServiceName"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"aid"},
        message = "professionalSupportSocialServiceSupport"
      )
    
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
  
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['professionalSupportProfessionals'].test(_this.professionalSupportProfessionals.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"aid"},
        message = "professionals"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"socialSecurityAndPaymentAgency"},
        message = "socialSecurityMemberShipKind"
      )
    
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
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['subjectTitle'].test(_this.subjectTitle.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "subjectMaidenName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['subjectTitle'].test(_this.subjectTitle.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "subjectMaidenName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['subjectTitle'].test(_this.subjectTitle.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "subjectMaidenName"
      )
    
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
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "subjectTitle"
      )
    
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
  
}
