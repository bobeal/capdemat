package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlObject;

import fr.cg95.cvq.xml.common.RequestType;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.*;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.joined-subclass
 *  table="handicap_compensation_adult_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class HandicapCompensationAdultRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public HandicapCompensationAdultRequest() {
        super();
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


    public final String modelToXmlString() {

        HandicapCompensationAdultRequestDocument object = (HandicapCompensationAdultRequestDocument) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final XmlObject modelToXml() {

        Calendar calendar = Calendar.getInstance();
        Date date = null;
        HandicapCompensationAdultRequestDocument handicapCompensationAdultRequestDoc = HandicapCompensationAdultRequestDocument.Factory.newInstance();
        HandicapCompensationAdultRequestDocument.HandicapCompensationAdultRequest handicapCompensationAdultRequest = handicapCompensationAdultRequestDoc.addNewHandicapCompensationAdultRequest();
        super.fillCommonXmlInfo(handicapCompensationAdultRequest);
        HcarHealthType hcarHealthTypeHealth = handicapCompensationAdultRequest.addNewHealth();
        if (this.healthFollowedByProfessional != null)
            hcarHealthTypeHealth.setHealthFollowedByProfessional(this.healthFollowedByProfessional.booleanValue());
        HcarProfessionalSupportType hcarProfessionalSupportTypeProfessionalSupport = handicapCompensationAdultRequest.addNewProfessionalSupport();
        if (this.professionalSupportProfessionals != null)
            hcarProfessionalSupportTypeProfessionalSupport.setProfessionalSupportProfessionals(this.professionalSupportProfessionals.booleanValue());
        int i = 0;
        if (familyDependents != null) {
            fr.cg95.cvq.xml.request.social.HcarFamilyDependentType[] familyDependentsTypeTab = new fr.cg95.cvq.xml.request.social.HcarFamilyDependentType[familyDependents.size()];
            Iterator familyDependentsIt = familyDependents.iterator();
            while (familyDependentsIt.hasNext()) {
                HcarFamilyDependent object = (HcarFamilyDependent) familyDependentsIt.next();
                familyDependentsTypeTab[i] = (HcarFamilyDependentType) object.modelToXml();
                i = i + 1;
            }
            handicapCompensationAdultRequest.setFamilyDependentsArray(familyDependentsTypeTab);
        }
        HcarFamilyAssistanceType hcarFamilyAssistanceTypeFamilyAssistance = handicapCompensationAdultRequest.addNewFamilyAssistance();
        if (this.isFamilyAssistance != null)
            hcarFamilyAssistanceTypeFamilyAssistance.setIsFamilyAssistance(this.isFamilyAssistance.booleanValue());
        handicapCompensationAdultRequest.setProjectComments(this.projectComments);
        HcarFoldersType hcarFoldersTypeFolders = handicapCompensationAdultRequest.addNewFolders();
        hcarFoldersTypeFolders.setFoldersMdphDepartment(this.foldersMdphDepartment);
        if (this.foldersCdes != null)
            hcarFoldersTypeFolders.setFoldersCdes(this.foldersCdes.booleanValue());
        handicapCompensationAdultRequest.setProjectNeeds(this.projectNeeds);
        HcarBenefitsType hcarBenefitsTypeBenefits = handicapCompensationAdultRequest.addNewBenefits();
        if (this.benefitsEducationAllocationOfDisabledChildren != null)
            hcarBenefitsTypeBenefits.setBenefitsEducationAllocationOfDisabledChildren(this.benefitsEducationAllocationOfDisabledChildren.booleanValue());
        HcarHomeInterventionType hcarHomeInterventionTypeHomeIntervention = handicapCompensationAdultRequest.addNewHomeIntervention();
        if (this.homeInterventionHomeIntervenant != null)
            hcarHomeInterventionTypeHomeIntervention.setHomeInterventionHomeIntervenant(this.homeInterventionHomeIntervenant.booleanValue());
        i = 0;
        if (otherFolders != null) {
            fr.cg95.cvq.xml.request.social.HcarOtherFolderType[] otherFoldersTypeTab = new fr.cg95.cvq.xml.request.social.HcarOtherFolderType[otherFolders.size()];
            Iterator otherFoldersIt = otherFolders.iterator();
            while (otherFoldersIt.hasNext()) {
                HcarOtherFolder object = (HcarOtherFolder) otherFoldersIt.next();
                otherFoldersTypeTab[i] = (HcarOtherFolderType) object.modelToXml();
                i = i + 1;
            }
            handicapCompensationAdultRequest.setOtherFoldersArray(otherFoldersTypeTab);
        }
        hcarFoldersTypeFolders.setFoldersMdphNumber(this.foldersMdphNumber);
        HcarProjectRequestsType hcarProjectRequestsTypeProjectRequests = handicapCompensationAdultRequest.addNewProjectRequests();
        if (this.projectRequestsHousingFacilities != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsHousingFacilities(this.projectRequestsHousingFacilities.booleanValue());
        HcarSubjectType hcarSubjectTypeHcarSubject = handicapCompensationAdultRequest.addNewHcarSubject();
        date = this.subjectBirthDate;
        if (date != null) {
            calendar.setTime(date);
            hcarSubjectTypeHcarSubject.setSubjectBirthDate(calendar);
        }
        if (this.benefitsDisabilityPension != null)
            hcarBenefitsTypeBenefits.setBenefitsDisabilityPension(this.benefitsDisabilityPension.booleanValue());
        HcarLegalAccessType hcarLegalAccessTypeLegalAccess = handicapCompensationAdultRequest.addNewLegalAccess();
        if (this.legalAccessPresence != null)
            hcarLegalAccessTypeLegalAccess.setLegalAccessPresence(this.legalAccessPresence.booleanValue());
        hcarSubjectTypeHcarSubject.setSubjectMaidenName(this.subjectMaidenName);
        if (this.projectRequestsDisabledWorkerRecognition != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsDisabledWorkerRecognition(this.projectRequestsDisabledWorkerRecognition.booleanValue());
        if (this.benefitsUnemploymentBenefits != null)
            hcarBenefitsTypeBenefits.setBenefitsUnemploymentBenefits(this.benefitsUnemploymentBenefits.booleanValue());
        i = 0;
        if (homeIntervenants != null) {
            fr.cg95.cvq.xml.request.social.HcarHomeIntervenantType[] homeIntervenantsTypeTab = new fr.cg95.cvq.xml.request.social.HcarHomeIntervenantType[homeIntervenants.size()];
            Iterator homeIntervenantsIt = homeIntervenants.iterator();
            while (homeIntervenantsIt.hasNext()) {
                HcarHomeIntervenant object = (HcarHomeIntervenant) homeIntervenantsIt.next();
                homeIntervenantsTypeTab[i] = (HcarHomeIntervenantType) object.modelToXml();
                i = i + 1;
            }
            handicapCompensationAdultRequest.setHomeIntervenantsArray(homeIntervenantsTypeTab);
        }
        HcarProfessionalStatusType hcarProfessionalStatusTypeProfessionalStatus = handicapCompensationAdultRequest.addNewProfessionalStatus();
        if (this.professionalStatusKind != null)
            hcarProfessionalStatusTypeProfessionalStatus.setProfessionalStatusKind(fr.cg95.cvq.xml.request.social.HcarProfessionalStatusKindType.Enum.forString(this.professionalStatusKind.toString()));
        HcarFamilyType hcarFamilyTypeFamily = handicapCompensationAdultRequest.addNewFamily();
        if (this.familyFamilyDependents != null)
            hcarFamilyTypeFamily.setFamilyFamilyDependents(this.familyFamilyDependents.booleanValue());
        HcarFormationType hcarFormationTypeFormation = handicapCompensationAdultRequest.addNewFormation();
        hcarFormationTypeFormation.setFormationPreviousFormation(this.formationPreviousFormation);
        hcarBenefitsTypeBenefits.setBenefitsEducationOfDisabledChildrenDetails(this.benefitsEducationOfDisabledChildrenDetails);
        if (this.projectRequestsVocationalTraining != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsVocationalTraining(this.projectRequestsVocationalTraining.booleanValue());
        HcarFacilitiesType hcarFacilitiesTypeFacilities = handicapCompensationAdultRequest.addNewFacilities();
        if (this.facilitiesCustomCar != null)
            hcarFacilitiesTypeFacilities.setFacilitiesCustomCar(this.facilitiesCustomCar.booleanValue());
        hcarLegalAccessTypeLegalAccess.setLegalAccessRepresentativeKindDetail(this.legalAccessRepresentativeKindDetail);
        if (this.professionalStatusIndemnified != null)
            hcarProfessionalStatusTypeProfessionalStatus.setProfessionalStatusIndemnified(this.professionalStatusIndemnified.booleanValue());
        if (this.benefitsDisabledAdultAllocation != null)
            hcarBenefitsTypeBenefits.setBenefitsDisabledAdultAllocation(this.benefitsDisabledAdultAllocation.booleanValue());
        if (this.benefitsThirdPartyCompensatoryAllowance != null)
            hcarBenefitsTypeBenefits.setBenefitsThirdPartyCompensatoryAllowance(this.benefitsThirdPartyCompensatoryAllowance.booleanValue());
        date = this.professionalStatusDate;
        if (date != null) {
            calendar.setTime(date);
            hcarProfessionalStatusTypeProfessionalStatus.setProfessionalStatusDate(calendar);
        }
        if (this.projectRequestsTransportCostAllocation != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsTransportCostAllocation(this.projectRequestsTransportCostAllocation.booleanValue());
        if (this.benefitsProfessionalOrientation != null)
            hcarBenefitsTypeBenefits.setBenefitsProfessionalOrientation(this.benefitsProfessionalOrientation.booleanValue());
        if (this.benefitsDisabilityRecognition != null)
            hcarBenefitsTypeBenefits.setBenefitsDisabilityRecognition(this.benefitsDisabilityRecognition.booleanValue());
        if (this.professionalStatusRegisterAsUnemployed != null)
            hcarProfessionalStatusTypeProfessionalStatus.setProfessionalStatusRegisterAsUnemployed(this.professionalStatusRegisterAsUnemployed.booleanValue());
        HcarDwellingType hcarDwellingTypeDwelling = handicapCompensationAdultRequest.addNewDwelling();
        hcarDwellingTypeDwelling.setDwellingSocialReceptionNaming(this.dwellingSocialReceptionNaming);
        date = this.professionalStatusIndemnifiedDate;
        if (date != null) {
            calendar.setTime(date);
            hcarProfessionalStatusTypeProfessionalStatus.setProfessionalStatusIndemnifiedDate(calendar);
        }
        if (this.familyStatus != null)
            hcarFamilyTypeFamily.setFamilyStatus(fr.cg95.cvq.xml.common.FamilyStatusType.Enum.forString(this.familyStatus.toString()));
        if (this.benefitsPainfulStandingCard != null)
            hcarBenefitsTypeBenefits.setBenefitsPainfulStandingCard(this.benefitsPainfulStandingCard.booleanValue());
        hcarBenefitsTypeBenefits.setBenefitsProfessionalOrientationDetails(this.benefitsProfessionalOrientationDetails);
        hcarFoldersTypeFolders.setFoldersCdesDepartment(this.foldersCdesDepartment);
        if (this.facilitiesSpecializedTransport != null)
            hcarFacilitiesTypeFacilities.setFacilitiesSpecializedTransport(this.facilitiesSpecializedTransport.booleanValue());
        if (this.benefitsParkingCard != null)
            hcarBenefitsTypeBenefits.setBenefitsParkingCard(this.benefitsParkingCard.booleanValue());
        hcarFacilitiesTypeFacilities.setFacilitiesSpecializedTransportDetails(this.facilitiesSpecializedTransportDetails);
        HcarSocialServiceType hcarSocialServiceTypeSocialService = handicapCompensationAdultRequest.addNewSocialService();
        if (this.professionalSupportSocialServiceSupport != null)
            hcarSocialServiceTypeSocialService.setProfessionalSupportSocialServiceSupport(this.professionalSupportSocialServiceSupport.booleanValue());
        HcarSocialSecurityType hcarSocialSecurityTypeSocialSecurity = handicapCompensationAdultRequest.addNewSocialSecurity();
        hcarSocialSecurityTypeSocialSecurity.setSocialSecurityNumber(this.socialSecurityNumber);
        hcarBenefitsTypeBenefits.setBenefitsWorkAccidentAnnuityRatio(this.benefitsWorkAccidentAnnuityRatio);
        if (this.benefitsWorkAccidentAnnuity != null)
            hcarBenefitsTypeBenefits.setBenefitsWorkAccidentAnnuity(this.benefitsWorkAccidentAnnuity.booleanValue());
        HcarCareType hcarCareTypeCare = handicapCompensationAdultRequest.addNewCare();
        if (this.careCareServices != null)
            hcarCareTypeCare.setCareCareServices(this.careCareServices.booleanValue());
        hcarBenefitsTypeBenefits.setBenefitsDisabilityRatio(this.benefitsDisabilityRatio);
        if (this.benefitsDailyAllowances != null)
            hcarBenefitsTypeBenefits.setBenefitsDailyAllowances(this.benefitsDailyAllowances.booleanValue());
        if (this.projectRequestsCustomCar != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsCustomCar(this.projectRequestsCustomCar.booleanValue());
        HcarPaymentAgencyType hcarPaymentAgencyTypePaymentAgency = handicapCompensationAdultRequest.addNewPaymentAgency();
        hcarPaymentAgencyTypePaymentAgency.setPaymentAgencyBeneficiaryNumber(this.paymentAgencyBeneficiaryNumber);
        hcarFoldersTypeFolders.setFoldersCotorepNumber(this.foldersCotorepNumber);
        if (this.projectRequestsACTPRenewal != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsACTPRenewal(this.projectRequestsACTPRenewal.booleanValue());
        if (this.dwellingSocialReceptionAddress != null)
            hcarDwellingTypeDwelling.setDwellingSocialReceptionAddress(Address.modelToXml(this.dwellingSocialReceptionAddress));
        if (this.foldersMdph != null)
            hcarFoldersTypeFolders.setFoldersMdph(this.foldersMdph.booleanValue());
        hcarBenefitsTypeBenefits.setBenefitsSupportedByAnInstitutionDetails(this.benefitsSupportedByAnInstitutionDetails);
        if (this.professionalSupportDealsWithSameProfessional != null)
            hcarProfessionalSupportTypeProfessionalSupport.setProfessionalSupportDealsWithSameProfessional(this.professionalSupportDealsWithSameProfessional.booleanValue());
        if (this.dwellingEstablishmentReception != null)
            hcarDwellingTypeDwelling.setDwellingEstablishmentReception(this.dwellingEstablishmentReception.booleanValue());
        hcarFoldersTypeFolders.setFoldersCotorepDepartment(this.foldersCotorepDepartment);
        i = 0;
        if (additionalFee != null) {
            fr.cg95.cvq.xml.request.social.HcarAdditionalFeeType[] additionalFeeTypeTab = new fr.cg95.cvq.xml.request.social.HcarAdditionalFeeType[additionalFee.size()];
            Iterator additionalFeeIt = additionalFee.iterator();
            while (additionalFeeIt.hasNext()) {
                HcarAdditionalFee object = (HcarAdditionalFee) additionalFeeIt.next();
                additionalFeeTypeTab[i] = (HcarAdditionalFeeType) object.modelToXml();
                i = i + 1;
            }
            handicapCompensationAdultRequest.setAdditionalFeeArray(additionalFeeTypeTab);
        }
        if (this.projectRequestsOrdinaryWorking != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsOrdinaryWorking(this.projectRequestsOrdinaryWorking.booleanValue());
        hcarLegalAccessTypeLegalAccess.setLegalAccessRepresentativeFirstName(this.legalAccessRepresentativeFirstName);
        if (this.dwellingSocialReception != null)
            hcarDwellingTypeDwelling.setDwellingSocialReception(this.dwellingSocialReception.booleanValue());
        if (this.benefitsDisabledWorkerRecognition != null)
            hcarBenefitsTypeBenefits.setBenefitsDisabledWorkerRecognition(this.benefitsDisabledWorkerRecognition.booleanValue());
        if (this.projectRequestsEuropeanParkingCard != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsEuropeanParkingCard(this.projectRequestsEuropeanParkingCard.booleanValue());
        if (this.healthFollowedByDoctor != null)
            hcarHealthTypeHealth.setHealthFollowedByDoctor(this.healthFollowedByDoctor.booleanValue());
        i = 0;
        if (familyAssistanceMembers != null) {
            fr.cg95.cvq.xml.request.social.HcarFamilyAssistanceMemberType[] familyAssistanceMembersTypeTab = new fr.cg95.cvq.xml.request.social.HcarFamilyAssistanceMemberType[familyAssistanceMembers.size()];
            Iterator familyAssistanceMembersIt = familyAssistanceMembers.iterator();
            while (familyAssistanceMembersIt.hasNext()) {
                HcarFamilyAssistanceMember object = (HcarFamilyAssistanceMember) familyAssistanceMembersIt.next();
                familyAssistanceMembersTypeTab[i] = (HcarFamilyAssistanceMemberType) object.modelToXml();
                i = i + 1;
            }
            handicapCompensationAdultRequest.setFamilyAssistanceMembersArray(familyAssistanceMembersTypeTab);
        }
        if (this.projectRequestsFreePensionMembership != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsFreePensionMembership(this.projectRequestsFreePensionMembership.booleanValue());
        i = 0;
        if (professionals != null) {
            fr.cg95.cvq.xml.request.social.HcarProfessionalType[] professionalsTypeTab = new fr.cg95.cvq.xml.request.social.HcarProfessionalType[professionals.size()];
            Iterator professionalsIt = professionals.iterator();
            while (professionalsIt.hasNext()) {
                HcarProfessional object = (HcarProfessional) professionalsIt.next();
                professionalsTypeTab[i] = (HcarProfessionalType) object.modelToXml();
                i = i + 1;
            }
            handicapCompensationAdultRequest.setProfessionalsArray(professionalsTypeTab);
        }
        if (this.healthFollowedByHospital != null)
            hcarHealthTypeHealth.setHealthFollowedByHospital(this.healthFollowedByHospital.booleanValue());
        hcarProfessionalStatusTypeProfessionalStatus.setProfessionalStatusEmployerName(this.professionalStatusEmployerName);
        if (this.projectRequestsInstitutionSupport != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsInstitutionSupport(this.projectRequestsInstitutionSupport.booleanValue());
        if (this.benefitsSocialWelfare != null)
            hcarBenefitsTypeBenefits.setBenefitsSocialWelfare(this.benefitsSocialWelfare.booleanValue());
        if (this.projectRequestsHandicapRecognition != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsHandicapRecognition(this.projectRequestsHandicapRecognition.booleanValue());
        i = 0;
        if (careServices != null) {
            fr.cg95.cvq.xml.request.social.HcarCareServiceType[] careServicesTypeTab = new fr.cg95.cvq.xml.request.social.HcarCareServiceType[careServices.size()];
            Iterator careServicesIt = careServices.iterator();
            while (careServicesIt.hasNext()) {
                HcarCareService object = (HcarCareService) careServicesIt.next();
                careServicesTypeTab[i] = (HcarCareServiceType) object.modelToXml();
                i = i + 1;
            }
            handicapCompensationAdultRequest.setCareServicesArray(careServicesTypeTab);
        }
        handicapCompensationAdultRequest.setProjectWish(this.projectWish);
        if (this.dwellingKind != null)
            hcarDwellingTypeDwelling.setDwellingKind(fr.cg95.cvq.xml.request.social.HcarDwellingKindType.Enum.forString(this.dwellingKind.toString()));
        hcarHealthTypeHealth.setHealthProfessionalLastName(this.healthProfessionalLastName);
        hcarFormationTypeFormation.setFormationStudiesLevel(this.formationStudiesLevel);
        if (this.projectRequestsProfessionalOrientation != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsProfessionalOrientation(this.projectRequestsProfessionalOrientation.booleanValue());
        hcarHealthTypeHealth.setHealthDoctorLastName(this.healthDoctorLastName);
        if (this.legalAccessKind != null)
            hcarLegalAccessTypeLegalAccess.setLegalAccessKind(fr.cg95.cvq.xml.request.social.HcarLegalAccessKindType.Enum.forString(this.legalAccessKind.toString()));
        hcarFacilitiesTypeFacilities.setFacilitiesHousingDetails(this.facilitiesHousingDetails);
        if (this.benefitsSupplementForSingleParents != null)
            hcarBenefitsTypeBenefits.setBenefitsSupplementForSingleParents(this.benefitsSupplementForSingleParents.booleanValue());
        if (this.projectRequestsIncreaseForIndependentLiving != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsIncreaseForIndependentLiving(this.projectRequestsIncreaseForIndependentLiving.booleanValue());
        hcarBenefitsTypeBenefits.setBenefitsDisabilityPensionCategory(this.benefitsDisabilityPensionCategory);
        if (this.benefitsThirdPartySupplement != null)
            hcarBenefitsTypeBenefits.setBenefitsThirdPartySupplement(this.benefitsThirdPartySupplement.booleanValue());
        HcarStudiesType hcarStudiesTypeStudies = handicapCompensationAdultRequest.addNewStudies();
        hcarStudiesTypeStudies.setStudiesHighSchoolGrade(this.studiesHighSchoolGrade);
        hcarSubjectTypeHcarSubject.setSubjectBirthCity(this.subjectBirthCity);
        hcarLegalAccessTypeLegalAccess.setLegalAccessRepresentativeName(this.legalAccessRepresentativeName);
        if (this.projectRequestsAssistance != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsAssistance(this.projectRequestsAssistance.booleanValue());
        if (this.professionalStatusEnvironment != null)
            hcarProfessionalStatusTypeProfessionalStatus.setProfessionalStatusEnvironment(fr.cg95.cvq.xml.request.social.HcarProfessionalStatusEnvironmentType.Enum.forString(this.professionalStatusEnvironment.toString()));
        if (this.benefitsSupportedByAnInstitution != null)
            hcarBenefitsTypeBenefits.setBenefitsSupportedByAnInstitution(this.benefitsSupportedByAnInstitution.booleanValue());
        if (this.projectRequestsThirdPartyHelp != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsThirdPartyHelp(this.projectRequestsThirdPartyHelp.booleanValue());
        if (this.projectRequestsDisabledAdultAllowance != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsDisabledAdultAllowance(this.projectRequestsDisabledAdultAllowance.booleanValue());
        if (this.paymentAgencyBeneficiary != null)
            hcarPaymentAgencyTypePaymentAgency.setPaymentAgencyBeneficiary(fr.cg95.cvq.xml.request.social.HcarPaymentAgencyBeneficiaryType.Enum.forString(this.paymentAgencyBeneficiary.toString()));
        if (this.foldersOtherFolders != null)
            hcarFoldersTypeFolders.setFoldersOtherFolders(this.foldersOtherFolders.booleanValue());
        hcarFacilitiesTypeFacilities.setFacilitiesAnimalAidDetails(this.facilitiesAnimalAidDetails);
        hcarStudiesTypeStudies.setStudiesAssistanceUnderDisabilityDetails(this.studiesAssistanceUnderDisabilityDetails);
        i = 0;
        if (otherBenefits != null) {
            fr.cg95.cvq.xml.request.social.HcarOtherBenefitType[] otherBenefitsTypeTab = new fr.cg95.cvq.xml.request.social.HcarOtherBenefitType[otherBenefits.size()];
            Iterator otherBenefitsIt = otherBenefits.iterator();
            while (otherBenefitsIt.hasNext()) {
                HcarOtherBenefit object = (HcarOtherBenefit) otherBenefitsIt.next();
                otherBenefitsTypeTab[i] = (HcarOtherBenefitType) object.modelToXml();
                i = i + 1;
            }
            handicapCompensationAdultRequest.setOtherBenefitsArray(otherBenefitsTypeTab);
        }
        if (this.paymentAgencyAddress != null)
            hcarPaymentAgencyTypePaymentAgency.setPaymentAgencyAddress(Address.modelToXml(this.paymentAgencyAddress));
        if (this.projectRequestsOther != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsOther(this.projectRequestsOther.booleanValue());
        if (this.benefitsThirdPersonCompensatoryAllowance != null)
            hcarBenefitsTypeBenefits.setBenefitsThirdPersonCompensatoryAllowance(this.benefitsThirdPersonCompensatoryAllowance.booleanValue());
        if (this.projectRequestsDisabilityCostAllocation != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsDisabilityCostAllocation(this.projectRequestsDisabilityCostAllocation.booleanValue());
        if (this.socialSecurityAgencyAddress != null)
            hcarSocialSecurityTypeSocialSecurity.setSocialSecurityAgencyAddress(Address.modelToXml(this.socialSecurityAgencyAddress));
        if (this.dwellingReceptionAddress != null)
            hcarDwellingTypeDwelling.setDwellingReceptionAddress(Address.modelToXml(this.dwellingReceptionAddress));
        hcarProfessionalStatusTypeProfessionalStatus.setProfessionalStatusProfession(this.professionalStatusProfession);
        if (this.professionalStatusAddress != null)
            hcarProfessionalStatusTypeProfessionalStatus.setProfessionalStatusAddress(Address.modelToXml(this.professionalStatusAddress));
        hcarFormationTypeFormation.setFormationDiploma(this.formationDiploma);
        if (this.subjectTitle != null)
            hcarSubjectTypeHcarSubject.setSubjectTitle(fr.cg95.cvq.xml.common.TitleType.Enum.forString(this.subjectTitle.toString()));
        if (this.professionalStatusElectiveFunction != null)
            hcarProfessionalStatusTypeProfessionalStatus.setProfessionalStatusElectiveFunction(this.professionalStatusElectiveFunction.booleanValue());
        if (this.foldersCotorep != null)
            hcarFoldersTypeFolders.setFoldersCotorep(this.foldersCotorep.booleanValue());
        if (this.benefitsIncreaseForIndependentLiving != null)
            hcarBenefitsTypeBenefits.setBenefitsIncreaseForIndependentLiving(this.benefitsIncreaseForIndependentLiving.booleanValue());
        hcarSubjectTypeHcarSubject.setSubjectBirthCountry(this.subjectBirthCountry);
        if (this.projectRequestsDisabilityCard != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsDisabilityCard(this.projectRequestsDisabilityCard.booleanValue());
        hcarStudiesTypeStudies.setStudiesHighSchoolName(this.studiesHighSchoolName);
        if (this.dwellingReceptionType != null)
            hcarDwellingTypeDwelling.setDwellingReceptionType(fr.cg95.cvq.xml.request.social.HcarDwellingReceptionKindType.Enum.forString(this.dwellingReceptionType.toString()));
        date = this.professionalStatusRegisterAsUnemployedDate;
        if (date != null) {
            calendar.setTime(date);
            hcarProfessionalStatusTypeProfessionalStatus.setProfessionalStatusRegisterAsUnemployedDate(calendar);
        }
        hcarPaymentAgencyTypePaymentAgency.setPaymentAgencyName(this.paymentAgencyName);
        hcarDwellingTypeDwelling.setDwellingReceptionNaming(this.dwellingReceptionNaming);
        hcarSocialSecurityTypeSocialSecurity.setSocialSecurityAgencyName(this.socialSecurityAgencyName);
        if (this.benefitsEducationOfDisabledChildren != null)
            hcarBenefitsTypeBenefits.setBenefitsEducationOfDisabledChildren(this.benefitsEducationOfDisabledChildren.booleanValue());
        hcarFacilitiesTypeFacilities.setFacilitiesTechnicalAssistanceDetails(this.facilitiesTechnicalAssistanceDetails);
        if (this.benefitsOtherBenefits != null)
            hcarBenefitsTypeBenefits.setBenefitsOtherBenefits(this.benefitsOtherBenefits.booleanValue());
        hcarFoldersTypeFolders.setFoldersCdesNumber(this.foldersCdesNumber);
        if (this.benefitsDisabilityCompensation != null)
            hcarBenefitsTypeBenefits.setBenefitsDisabilityCompensation(this.benefitsDisabilityCompensation.booleanValue());
        hcarHealthTypeHealth.setHealthDoctorFirstName(this.healthDoctorFirstName);
        if (this.projectRequestsTechnicalHelp != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsTechnicalHelp(this.projectRequestsTechnicalHelp.booleanValue());
        if (this.facilitiesTechnicalAssistance != null)
            hcarFacilitiesTypeFacilities.setFacilitiesTechnicalAssistance(this.facilitiesTechnicalAssistance.booleanValue());
        if (this.benefitsCompensatoryAllowanceForExpenses != null)
            hcarBenefitsTypeBenefits.setBenefitsCompensatoryAllowanceForExpenses(this.benefitsCompensatoryAllowanceForExpenses.booleanValue());
        if (this.facilitiesHousing != null)
            hcarFacilitiesTypeFacilities.setFacilitiesHousing(this.facilitiesHousing.booleanValue());
        hcarHealthTypeHealth.setHealthHospitalName(this.healthHospitalName);
        if (this.projectRequestsDisabledPriorityCard != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsDisabledPriorityCard(this.projectRequestsDisabledPriorityCard.booleanValue());
        if (this.projectRequestsEducationAllocationOfDisabledChildren != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsEducationAllocationOfDisabledChildren(this.projectRequestsEducationAllocationOfDisabledChildren.booleanValue());
        hcarProjectRequestsTypeProjectRequests.setProjectRequestsOtherDetails(this.projectRequestsOtherDetails);
        if (this.legalAccessRepresentativeKind != null)
            hcarLegalAccessTypeLegalAccess.setLegalAccessRepresentativeKind(fr.cg95.cvq.xml.request.social.HcarLegalAccessRepresentativeKindType.Enum.forString(this.legalAccessRepresentativeKind.toString()));
        if (this.projectRequestsShelteredWork != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsShelteredWork(this.projectRequestsShelteredWork.booleanValue());
        hcarFormationTypeFormation.setFormationCurrentFormation(this.formationCurrentFormation);
        if (this.studiesAssistanceUnderDisability != null)
            hcarStudiesTypeStudies.setStudiesAssistanceUnderDisability(this.studiesAssistanceUnderDisability.booleanValue());
        if (this.professionalSupportSocialServiceAddress != null)
            hcarSocialServiceTypeSocialService.setProfessionalSupportSocialServiceAddress(Address.modelToXml(this.professionalSupportSocialServiceAddress));
        if (this.studiesHighSchool != null)
            hcarStudiesTypeStudies.setStudiesHighSchool(this.studiesHighSchool.booleanValue());
        hcarHealthTypeHealth.setHealthProfessionalFirstName(this.healthProfessionalFirstName);
        hcarSocialServiceTypeSocialService.setProfessionalSupportSocialServiceName(this.professionalSupportSocialServiceName);
        hcarFacilitiesTypeFacilities.setFacilitiesCustomCarDetails(this.facilitiesCustomCarDetails);
        hcarDwellingTypeDwelling.setDwellingPrecision(this.dwellingPrecision);
        if (this.benefitsDisabilityCard != null)
            hcarBenefitsTypeBenefits.setBenefitsDisabilityCard(this.benefitsDisabilityCard.booleanValue());
        if (this.socialSecurityMemberShipKind != null)
            hcarSocialSecurityTypeSocialSecurity.setSocialSecurityMemberShipKind(fr.cg95.cvq.xml.request.social.HcarSocialSecurityMemberShipKindType.Enum.forString(this.socialSecurityMemberShipKind.toString()));
        hcarProfessionalStatusTypeProfessionalStatus.setProfessionalStatusElectiveFunctionDetails(this.professionalStatusElectiveFunctionDetails);
        if (this.facilitiesAnimalAid != null)
            hcarFacilitiesTypeFacilities.setFacilitiesAnimalAid(this.facilitiesAnimalAid.booleanValue());
        if (this.studiesHighSchoolAddress != null)
            hcarStudiesTypeStudies.setStudiesHighSchoolAddress(Address.modelToXml(this.studiesHighSchoolAddress));
        return handicapCompensationAdultRequestDoc;
    }

    @Override
    public RequestType modelToXmlRequest() {
        HandicapCompensationAdultRequestDocument handicapCompensationAdultRequestDoc =
            (HandicapCompensationAdultRequestDocument) modelToXml();
        return handicapCompensationAdultRequestDoc.getHandicapCompensationAdultRequest();
    }

    public static HandicapCompensationAdultRequest xmlToModel(HandicapCompensationAdultRequestDocument handicapCompensationAdultRequestDoc) {

        HandicapCompensationAdultRequestDocument.HandicapCompensationAdultRequest handicapCompensationAdultRequestXml = handicapCompensationAdultRequestDoc.getHandicapCompensationAdultRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HandicapCompensationAdultRequest handicapCompensationAdultRequest = new HandicapCompensationAdultRequest();
        handicapCompensationAdultRequest.fillCommonModelInfo(handicapCompensationAdultRequest,handicapCompensationAdultRequestXml);
        handicapCompensationAdultRequest.setHealthFollowedByProfessional(Boolean.valueOf(handicapCompensationAdultRequestXml.getHealth().getHealthFollowedByProfessional()));
        handicapCompensationAdultRequest.setProfessionalSupportProfessionals(Boolean.valueOf(handicapCompensationAdultRequestXml.getProfessionalSupport().getProfessionalSupportProfessionals()));
        List<fr.cg95.cvq.business.request.social.HcarFamilyDependent> familyDependentsList = new ArrayList<fr.cg95.cvq.business.request.social.HcarFamilyDependent> ();
        if ( handicapCompensationAdultRequestXml.sizeOfFamilyDependentsArray() > 0) {
            for (int i = 0; i < handicapCompensationAdultRequestXml.getFamilyDependentsArray().length; i++) {
                familyDependentsList.add(HcarFamilyDependent.xmlToModel(handicapCompensationAdultRequestXml.getFamilyDependentsArray(i)));
            }
        }
        handicapCompensationAdultRequest.setFamilyDependents(familyDependentsList);
        handicapCompensationAdultRequest.setIsFamilyAssistance(Boolean.valueOf(handicapCompensationAdultRequestXml.getFamilyAssistance().getIsFamilyAssistance()));
        handicapCompensationAdultRequest.setProjectComments(handicapCompensationAdultRequestXml.getProjectComments());
        handicapCompensationAdultRequest.setFoldersMdphDepartment(handicapCompensationAdultRequestXml.getFolders().getFoldersMdphDepartment());
        handicapCompensationAdultRequest.setFoldersCdes(Boolean.valueOf(handicapCompensationAdultRequestXml.getFolders().getFoldersCdes()));
        handicapCompensationAdultRequest.setProjectNeeds(handicapCompensationAdultRequestXml.getProjectNeeds());
        handicapCompensationAdultRequest.setBenefitsEducationAllocationOfDisabledChildren(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsEducationAllocationOfDisabledChildren()));
        handicapCompensationAdultRequest.setHomeInterventionHomeIntervenant(Boolean.valueOf(handicapCompensationAdultRequestXml.getHomeIntervention().getHomeInterventionHomeIntervenant()));
        List<fr.cg95.cvq.business.request.social.HcarOtherFolder> otherFoldersList = new ArrayList<fr.cg95.cvq.business.request.social.HcarOtherFolder> ();
        if ( handicapCompensationAdultRequestXml.sizeOfOtherFoldersArray() > 0) {
            for (int i = 0; i < handicapCompensationAdultRequestXml.getOtherFoldersArray().length; i++) {
                otherFoldersList.add(HcarOtherFolder.xmlToModel(handicapCompensationAdultRequestXml.getOtherFoldersArray(i)));
            }
        }
        handicapCompensationAdultRequest.setOtherFolders(otherFoldersList);
        handicapCompensationAdultRequest.setFoldersMdphNumber(handicapCompensationAdultRequestXml.getFolders().getFoldersMdphNumber());
        handicapCompensationAdultRequest.setProjectRequestsHousingFacilities(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsHousingFacilities()));
        calendar = handicapCompensationAdultRequestXml.getHcarSubject().getSubjectBirthDate();
        if (calendar != null) {
            handicapCompensationAdultRequest.setSubjectBirthDate(calendar.getTime());
        }
        handicapCompensationAdultRequest.setBenefitsDisabilityPension(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsDisabilityPension()));
        handicapCompensationAdultRequest.setLegalAccessPresence(Boolean.valueOf(handicapCompensationAdultRequestXml.getLegalAccess().getLegalAccessPresence()));
        handicapCompensationAdultRequest.setSubjectMaidenName(handicapCompensationAdultRequestXml.getHcarSubject().getSubjectMaidenName());
        handicapCompensationAdultRequest.setProjectRequestsDisabledWorkerRecognition(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsDisabledWorkerRecognition()));
        handicapCompensationAdultRequest.setBenefitsUnemploymentBenefits(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsUnemploymentBenefits()));
        List<fr.cg95.cvq.business.request.social.HcarHomeIntervenant> homeIntervenantsList = new ArrayList<fr.cg95.cvq.business.request.social.HcarHomeIntervenant> ();
        if ( handicapCompensationAdultRequestXml.sizeOfHomeIntervenantsArray() > 0) {
            for (int i = 0; i < handicapCompensationAdultRequestXml.getHomeIntervenantsArray().length; i++) {
                homeIntervenantsList.add(HcarHomeIntervenant.xmlToModel(handicapCompensationAdultRequestXml.getHomeIntervenantsArray(i)));
            }
        }
        handicapCompensationAdultRequest.setHomeIntervenants(homeIntervenantsList);
        if (handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusKind() != null)
            handicapCompensationAdultRequest.setProfessionalStatusKind(fr.cg95.cvq.business.request.social.HcarProfessionalStatusKindType.forString(handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusKind().toString()));
        else
            handicapCompensationAdultRequest.setProfessionalStatusKind(fr.cg95.cvq.business.request.social.HcarProfessionalStatusKindType.getDefaultHcarProfessionalStatusKindType());
        handicapCompensationAdultRequest.setFamilyFamilyDependents(Boolean.valueOf(handicapCompensationAdultRequestXml.getFamily().getFamilyFamilyDependents()));
        handicapCompensationAdultRequest.setFormationPreviousFormation(handicapCompensationAdultRequestXml.getFormation().getFormationPreviousFormation());
        handicapCompensationAdultRequest.setBenefitsEducationOfDisabledChildrenDetails(handicapCompensationAdultRequestXml.getBenefits().getBenefitsEducationOfDisabledChildrenDetails());
        handicapCompensationAdultRequest.setProjectRequestsVocationalTraining(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsVocationalTraining()));
        handicapCompensationAdultRequest.setFacilitiesCustomCar(Boolean.valueOf(handicapCompensationAdultRequestXml.getFacilities().getFacilitiesCustomCar()));
        handicapCompensationAdultRequest.setLegalAccessRepresentativeKindDetail(handicapCompensationAdultRequestXml.getLegalAccess().getLegalAccessRepresentativeKindDetail());
        handicapCompensationAdultRequest.setProfessionalStatusIndemnified(Boolean.valueOf(handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusIndemnified()));
        handicapCompensationAdultRequest.setBenefitsDisabledAdultAllocation(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsDisabledAdultAllocation()));
        handicapCompensationAdultRequest.setBenefitsThirdPartyCompensatoryAllowance(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsThirdPartyCompensatoryAllowance()));
        calendar = handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusDate();
        if (calendar != null) {
            handicapCompensationAdultRequest.setProfessionalStatusDate(calendar.getTime());
        }
        handicapCompensationAdultRequest.setProjectRequestsTransportCostAllocation(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsTransportCostAllocation()));
        handicapCompensationAdultRequest.setBenefitsProfessionalOrientation(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsProfessionalOrientation()));
        handicapCompensationAdultRequest.setBenefitsDisabilityRecognition(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsDisabilityRecognition()));
        handicapCompensationAdultRequest.setProfessionalStatusRegisterAsUnemployed(Boolean.valueOf(handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusRegisterAsUnemployed()));
        handicapCompensationAdultRequest.setDwellingSocialReceptionNaming(handicapCompensationAdultRequestXml.getDwelling().getDwellingSocialReceptionNaming());
        calendar = handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusIndemnifiedDate();
        if (calendar != null) {
            handicapCompensationAdultRequest.setProfessionalStatusIndemnifiedDate(calendar.getTime());
        }
        if (handicapCompensationAdultRequestXml.getFamily().getFamilyStatus() != null)
            handicapCompensationAdultRequest.setFamilyStatus(fr.cg95.cvq.business.users.FamilyStatusType.forString(handicapCompensationAdultRequestXml.getFamily().getFamilyStatus().toString()));
        else
            handicapCompensationAdultRequest.setFamilyStatus(fr.cg95.cvq.business.users.FamilyStatusType.getDefaultFamilyStatusType());
        handicapCompensationAdultRequest.setBenefitsPainfulStandingCard(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsPainfulStandingCard()));
        handicapCompensationAdultRequest.setBenefitsProfessionalOrientationDetails(handicapCompensationAdultRequestXml.getBenefits().getBenefitsProfessionalOrientationDetails());
        handicapCompensationAdultRequest.setFoldersCdesDepartment(handicapCompensationAdultRequestXml.getFolders().getFoldersCdesDepartment());
        handicapCompensationAdultRequest.setFacilitiesSpecializedTransport(Boolean.valueOf(handicapCompensationAdultRequestXml.getFacilities().getFacilitiesSpecializedTransport()));
        handicapCompensationAdultRequest.setBenefitsParkingCard(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsParkingCard()));
        handicapCompensationAdultRequest.setFacilitiesSpecializedTransportDetails(handicapCompensationAdultRequestXml.getFacilities().getFacilitiesSpecializedTransportDetails());
        handicapCompensationAdultRequest.setProfessionalSupportSocialServiceSupport(Boolean.valueOf(handicapCompensationAdultRequestXml.getSocialService().getProfessionalSupportSocialServiceSupport()));
        handicapCompensationAdultRequest.setSocialSecurityNumber(handicapCompensationAdultRequestXml.getSocialSecurity().getSocialSecurityNumber());
        handicapCompensationAdultRequest.setBenefitsWorkAccidentAnnuityRatio(handicapCompensationAdultRequestXml.getBenefits().getBenefitsWorkAccidentAnnuityRatio());
        handicapCompensationAdultRequest.setBenefitsWorkAccidentAnnuity(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsWorkAccidentAnnuity()));
        handicapCompensationAdultRequest.setCareCareServices(Boolean.valueOf(handicapCompensationAdultRequestXml.getCare().getCareCareServices()));
        handicapCompensationAdultRequest.setBenefitsDisabilityRatio(handicapCompensationAdultRequestXml.getBenefits().getBenefitsDisabilityRatio());
        handicapCompensationAdultRequest.setBenefitsDailyAllowances(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsDailyAllowances()));
        handicapCompensationAdultRequest.setProjectRequestsCustomCar(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsCustomCar()));
        handicapCompensationAdultRequest.setPaymentAgencyBeneficiaryNumber(handicapCompensationAdultRequestXml.getPaymentAgency().getPaymentAgencyBeneficiaryNumber());
        handicapCompensationAdultRequest.setFoldersCotorepNumber(handicapCompensationAdultRequestXml.getFolders().getFoldersCotorepNumber());
        handicapCompensationAdultRequest.setProjectRequestsACTPRenewal(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsACTPRenewal()));
        if (handicapCompensationAdultRequestXml.getDwelling().getDwellingSocialReceptionAddress() != null)
            handicapCompensationAdultRequest.setDwellingSocialReceptionAddress(Address.xmlToModel(handicapCompensationAdultRequestXml.getDwelling().getDwellingSocialReceptionAddress()));
        handicapCompensationAdultRequest.setFoldersMdph(Boolean.valueOf(handicapCompensationAdultRequestXml.getFolders().getFoldersMdph()));
        handicapCompensationAdultRequest.setBenefitsSupportedByAnInstitutionDetails(handicapCompensationAdultRequestXml.getBenefits().getBenefitsSupportedByAnInstitutionDetails());
        handicapCompensationAdultRequest.setProfessionalSupportDealsWithSameProfessional(Boolean.valueOf(handicapCompensationAdultRequestXml.getProfessionalSupport().getProfessionalSupportDealsWithSameProfessional()));
        handicapCompensationAdultRequest.setDwellingEstablishmentReception(Boolean.valueOf(handicapCompensationAdultRequestXml.getDwelling().getDwellingEstablishmentReception()));
        handicapCompensationAdultRequest.setFoldersCotorepDepartment(handicapCompensationAdultRequestXml.getFolders().getFoldersCotorepDepartment());
        List<fr.cg95.cvq.business.request.social.HcarAdditionalFee> additionalFeeList = new ArrayList<fr.cg95.cvq.business.request.social.HcarAdditionalFee> ();
        if ( handicapCompensationAdultRequestXml.sizeOfAdditionalFeeArray() > 0) {
            for (int i = 0; i < handicapCompensationAdultRequestXml.getAdditionalFeeArray().length; i++) {
                additionalFeeList.add(HcarAdditionalFee.xmlToModel(handicapCompensationAdultRequestXml.getAdditionalFeeArray(i)));
            }
        }
        handicapCompensationAdultRequest.setAdditionalFee(additionalFeeList);
        handicapCompensationAdultRequest.setProjectRequestsOrdinaryWorking(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsOrdinaryWorking()));
        handicapCompensationAdultRequest.setLegalAccessRepresentativeFirstName(handicapCompensationAdultRequestXml.getLegalAccess().getLegalAccessRepresentativeFirstName());
        handicapCompensationAdultRequest.setDwellingSocialReception(Boolean.valueOf(handicapCompensationAdultRequestXml.getDwelling().getDwellingSocialReception()));
        handicapCompensationAdultRequest.setBenefitsDisabledWorkerRecognition(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsDisabledWorkerRecognition()));
        handicapCompensationAdultRequest.setProjectRequestsEuropeanParkingCard(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsEuropeanParkingCard()));
        handicapCompensationAdultRequest.setHealthFollowedByDoctor(Boolean.valueOf(handicapCompensationAdultRequestXml.getHealth().getHealthFollowedByDoctor()));
        List<fr.cg95.cvq.business.request.social.HcarFamilyAssistanceMember> familyAssistanceMembersList = new ArrayList<fr.cg95.cvq.business.request.social.HcarFamilyAssistanceMember> ();
        if ( handicapCompensationAdultRequestXml.sizeOfFamilyAssistanceMembersArray() > 0) {
            for (int i = 0; i < handicapCompensationAdultRequestXml.getFamilyAssistanceMembersArray().length; i++) {
                familyAssistanceMembersList.add(HcarFamilyAssistanceMember.xmlToModel(handicapCompensationAdultRequestXml.getFamilyAssistanceMembersArray(i)));
            }
        }
        handicapCompensationAdultRequest.setFamilyAssistanceMembers(familyAssistanceMembersList);
        handicapCompensationAdultRequest.setProjectRequestsFreePensionMembership(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsFreePensionMembership()));
        List<fr.cg95.cvq.business.request.social.HcarProfessional> professionalsList = new ArrayList<fr.cg95.cvq.business.request.social.HcarProfessional> ();
        if ( handicapCompensationAdultRequestXml.sizeOfProfessionalsArray() > 0) {
            for (int i = 0; i < handicapCompensationAdultRequestXml.getProfessionalsArray().length; i++) {
                professionalsList.add(HcarProfessional.xmlToModel(handicapCompensationAdultRequestXml.getProfessionalsArray(i)));
            }
        }
        handicapCompensationAdultRequest.setProfessionals(professionalsList);
        handicapCompensationAdultRequest.setHealthFollowedByHospital(Boolean.valueOf(handicapCompensationAdultRequestXml.getHealth().getHealthFollowedByHospital()));
        handicapCompensationAdultRequest.setProfessionalStatusEmployerName(handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusEmployerName());
        handicapCompensationAdultRequest.setProjectRequestsInstitutionSupport(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsInstitutionSupport()));
        handicapCompensationAdultRequest.setBenefitsSocialWelfare(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsSocialWelfare()));
        handicapCompensationAdultRequest.setProjectRequestsHandicapRecognition(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsHandicapRecognition()));
        List<fr.cg95.cvq.business.request.social.HcarCareService> careServicesList = new ArrayList<fr.cg95.cvq.business.request.social.HcarCareService> ();
        if ( handicapCompensationAdultRequestXml.sizeOfCareServicesArray() > 0) {
            for (int i = 0; i < handicapCompensationAdultRequestXml.getCareServicesArray().length; i++) {
                careServicesList.add(HcarCareService.xmlToModel(handicapCompensationAdultRequestXml.getCareServicesArray(i)));
            }
        }
        handicapCompensationAdultRequest.setCareServices(careServicesList);
        handicapCompensationAdultRequest.setProjectWish(handicapCompensationAdultRequestXml.getProjectWish());
        if (handicapCompensationAdultRequestXml.getDwelling().getDwellingKind() != null)
            handicapCompensationAdultRequest.setDwellingKind(fr.cg95.cvq.business.request.social.HcarDwellingKindType.forString(handicapCompensationAdultRequestXml.getDwelling().getDwellingKind().toString()));
        else
            handicapCompensationAdultRequest.setDwellingKind(fr.cg95.cvq.business.request.social.HcarDwellingKindType.getDefaultHcarDwellingKindType());
        handicapCompensationAdultRequest.setHealthProfessionalLastName(handicapCompensationAdultRequestXml.getHealth().getHealthProfessionalLastName());
        handicapCompensationAdultRequest.setFormationStudiesLevel(handicapCompensationAdultRequestXml.getFormation().getFormationStudiesLevel());
        handicapCompensationAdultRequest.setProjectRequestsProfessionalOrientation(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsProfessionalOrientation()));
        handicapCompensationAdultRequest.setHealthDoctorLastName(handicapCompensationAdultRequestXml.getHealth().getHealthDoctorLastName());
        if (handicapCompensationAdultRequestXml.getLegalAccess().getLegalAccessKind() != null)
            handicapCompensationAdultRequest.setLegalAccessKind(fr.cg95.cvq.business.request.social.HcarLegalAccessKindType.forString(handicapCompensationAdultRequestXml.getLegalAccess().getLegalAccessKind().toString()));
        else
            handicapCompensationAdultRequest.setLegalAccessKind(fr.cg95.cvq.business.request.social.HcarLegalAccessKindType.getDefaultHcarLegalAccessKindType());
        handicapCompensationAdultRequest.setFacilitiesHousingDetails(handicapCompensationAdultRequestXml.getFacilities().getFacilitiesHousingDetails());
        handicapCompensationAdultRequest.setBenefitsSupplementForSingleParents(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsSupplementForSingleParents()));
        handicapCompensationAdultRequest.setProjectRequestsIncreaseForIndependentLiving(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsIncreaseForIndependentLiving()));
        handicapCompensationAdultRequest.setBenefitsDisabilityPensionCategory(handicapCompensationAdultRequestXml.getBenefits().getBenefitsDisabilityPensionCategory());
        handicapCompensationAdultRequest.setBenefitsThirdPartySupplement(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsThirdPartySupplement()));
        handicapCompensationAdultRequest.setStudiesHighSchoolGrade(handicapCompensationAdultRequestXml.getStudies().getStudiesHighSchoolGrade());
        handicapCompensationAdultRequest.setSubjectBirthCity(handicapCompensationAdultRequestXml.getHcarSubject().getSubjectBirthCity());
        handicapCompensationAdultRequest.setLegalAccessRepresentativeName(handicapCompensationAdultRequestXml.getLegalAccess().getLegalAccessRepresentativeName());
        handicapCompensationAdultRequest.setProjectRequestsAssistance(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsAssistance()));
        if (handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusEnvironment() != null)
            handicapCompensationAdultRequest.setProfessionalStatusEnvironment(fr.cg95.cvq.business.request.social.HcarProfessionalStatusEnvironmentType.forString(handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusEnvironment().toString()));
        else
            handicapCompensationAdultRequest.setProfessionalStatusEnvironment(fr.cg95.cvq.business.request.social.HcarProfessionalStatusEnvironmentType.getDefaultHcarProfessionalStatusEnvironmentType());
        handicapCompensationAdultRequest.setBenefitsSupportedByAnInstitution(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsSupportedByAnInstitution()));
        handicapCompensationAdultRequest.setProjectRequestsThirdPartyHelp(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsThirdPartyHelp()));
        handicapCompensationAdultRequest.setProjectRequestsDisabledAdultAllowance(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsDisabledAdultAllowance()));
        if (handicapCompensationAdultRequestXml.getPaymentAgency().getPaymentAgencyBeneficiary() != null)
            handicapCompensationAdultRequest.setPaymentAgencyBeneficiary(fr.cg95.cvq.business.request.social.HcarPaymentAgencyBeneficiaryType.forString(handicapCompensationAdultRequestXml.getPaymentAgency().getPaymentAgencyBeneficiary().toString()));
        else
            handicapCompensationAdultRequest.setPaymentAgencyBeneficiary(fr.cg95.cvq.business.request.social.HcarPaymentAgencyBeneficiaryType.getDefaultHcarPaymentAgencyBeneficiaryType());
        handicapCompensationAdultRequest.setFoldersOtherFolders(Boolean.valueOf(handicapCompensationAdultRequestXml.getFolders().getFoldersOtherFolders()));
        handicapCompensationAdultRequest.setFacilitiesAnimalAidDetails(handicapCompensationAdultRequestXml.getFacilities().getFacilitiesAnimalAidDetails());
        handicapCompensationAdultRequest.setStudiesAssistanceUnderDisabilityDetails(handicapCompensationAdultRequestXml.getStudies().getStudiesAssistanceUnderDisabilityDetails());
        List<fr.cg95.cvq.business.request.social.HcarOtherBenefit> otherBenefitsList = new ArrayList<fr.cg95.cvq.business.request.social.HcarOtherBenefit> ();
        if ( handicapCompensationAdultRequestXml.sizeOfOtherBenefitsArray() > 0) {
            for (int i = 0; i < handicapCompensationAdultRequestXml.getOtherBenefitsArray().length; i++) {
                otherBenefitsList.add(HcarOtherBenefit.xmlToModel(handicapCompensationAdultRequestXml.getOtherBenefitsArray(i)));
            }
        }
        handicapCompensationAdultRequest.setOtherBenefits(otherBenefitsList);
        if (handicapCompensationAdultRequestXml.getPaymentAgency().getPaymentAgencyAddress() != null)
            handicapCompensationAdultRequest.setPaymentAgencyAddress(Address.xmlToModel(handicapCompensationAdultRequestXml.getPaymentAgency().getPaymentAgencyAddress()));
        handicapCompensationAdultRequest.setProjectRequestsOther(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsOther()));
        handicapCompensationAdultRequest.setBenefitsThirdPersonCompensatoryAllowance(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsThirdPersonCompensatoryAllowance()));
        handicapCompensationAdultRequest.setProjectRequestsDisabilityCostAllocation(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsDisabilityCostAllocation()));
        if (handicapCompensationAdultRequestXml.getSocialSecurity().getSocialSecurityAgencyAddress() != null)
            handicapCompensationAdultRequest.setSocialSecurityAgencyAddress(Address.xmlToModel(handicapCompensationAdultRequestXml.getSocialSecurity().getSocialSecurityAgencyAddress()));
        if (handicapCompensationAdultRequestXml.getDwelling().getDwellingReceptionAddress() != null)
            handicapCompensationAdultRequest.setDwellingReceptionAddress(Address.xmlToModel(handicapCompensationAdultRequestXml.getDwelling().getDwellingReceptionAddress()));
        handicapCompensationAdultRequest.setProfessionalStatusProfession(handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusProfession());
        if (handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusAddress() != null)
            handicapCompensationAdultRequest.setProfessionalStatusAddress(Address.xmlToModel(handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusAddress()));
        handicapCompensationAdultRequest.setFormationDiploma(handicapCompensationAdultRequestXml.getFormation().getFormationDiploma());
        if (handicapCompensationAdultRequestXml.getHcarSubject().getSubjectTitle() != null)
            handicapCompensationAdultRequest.setSubjectTitle(fr.cg95.cvq.business.users.TitleType.forString(handicapCompensationAdultRequestXml.getHcarSubject().getSubjectTitle().toString()));
        else
            handicapCompensationAdultRequest.setSubjectTitle(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
        handicapCompensationAdultRequest.setProfessionalStatusElectiveFunction(Boolean.valueOf(handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusElectiveFunction()));
        handicapCompensationAdultRequest.setFoldersCotorep(Boolean.valueOf(handicapCompensationAdultRequestXml.getFolders().getFoldersCotorep()));
        handicapCompensationAdultRequest.setBenefitsIncreaseForIndependentLiving(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsIncreaseForIndependentLiving()));
        handicapCompensationAdultRequest.setSubjectBirthCountry(handicapCompensationAdultRequestXml.getHcarSubject().getSubjectBirthCountry());
        handicapCompensationAdultRequest.setProjectRequestsDisabilityCard(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsDisabilityCard()));
        handicapCompensationAdultRequest.setStudiesHighSchoolName(handicapCompensationAdultRequestXml.getStudies().getStudiesHighSchoolName());
        if (handicapCompensationAdultRequestXml.getDwelling().getDwellingReceptionType() != null)
            handicapCompensationAdultRequest.setDwellingReceptionType(fr.cg95.cvq.business.request.social.HcarDwellingReceptionKindType.forString(handicapCompensationAdultRequestXml.getDwelling().getDwellingReceptionType().toString()));
        else
            handicapCompensationAdultRequest.setDwellingReceptionType(fr.cg95.cvq.business.request.social.HcarDwellingReceptionKindType.getDefaultHcarDwellingReceptionKindType());
        calendar = handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusRegisterAsUnemployedDate();
        if (calendar != null) {
            handicapCompensationAdultRequest.setProfessionalStatusRegisterAsUnemployedDate(calendar.getTime());
        }
        handicapCompensationAdultRequest.setPaymentAgencyName(handicapCompensationAdultRequestXml.getPaymentAgency().getPaymentAgencyName());
        handicapCompensationAdultRequest.setDwellingReceptionNaming(handicapCompensationAdultRequestXml.getDwelling().getDwellingReceptionNaming());
        handicapCompensationAdultRequest.setSocialSecurityAgencyName(handicapCompensationAdultRequestXml.getSocialSecurity().getSocialSecurityAgencyName());
        handicapCompensationAdultRequest.setBenefitsEducationOfDisabledChildren(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsEducationOfDisabledChildren()));
        handicapCompensationAdultRequest.setFacilitiesTechnicalAssistanceDetails(handicapCompensationAdultRequestXml.getFacilities().getFacilitiesTechnicalAssistanceDetails());
        handicapCompensationAdultRequest.setBenefitsOtherBenefits(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsOtherBenefits()));
        handicapCompensationAdultRequest.setFoldersCdesNumber(handicapCompensationAdultRequestXml.getFolders().getFoldersCdesNumber());
        handicapCompensationAdultRequest.setBenefitsDisabilityCompensation(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsDisabilityCompensation()));
        handicapCompensationAdultRequest.setHealthDoctorFirstName(handicapCompensationAdultRequestXml.getHealth().getHealthDoctorFirstName());
        handicapCompensationAdultRequest.setProjectRequestsTechnicalHelp(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsTechnicalHelp()));
        handicapCompensationAdultRequest.setFacilitiesTechnicalAssistance(Boolean.valueOf(handicapCompensationAdultRequestXml.getFacilities().getFacilitiesTechnicalAssistance()));
        handicapCompensationAdultRequest.setBenefitsCompensatoryAllowanceForExpenses(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsCompensatoryAllowanceForExpenses()));
        handicapCompensationAdultRequest.setFacilitiesHousing(Boolean.valueOf(handicapCompensationAdultRequestXml.getFacilities().getFacilitiesHousing()));
        handicapCompensationAdultRequest.setHealthHospitalName(handicapCompensationAdultRequestXml.getHealth().getHealthHospitalName());
        handicapCompensationAdultRequest.setProjectRequestsDisabledPriorityCard(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsDisabledPriorityCard()));
        handicapCompensationAdultRequest.setProjectRequestsEducationAllocationOfDisabledChildren(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsEducationAllocationOfDisabledChildren()));
        handicapCompensationAdultRequest.setProjectRequestsOtherDetails(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsOtherDetails());
        if (handicapCompensationAdultRequestXml.getLegalAccess().getLegalAccessRepresentativeKind() != null)
            handicapCompensationAdultRequest.setLegalAccessRepresentativeKind(fr.cg95.cvq.business.request.social.HcarLegalAccessRepresentativeKindType.forString(handicapCompensationAdultRequestXml.getLegalAccess().getLegalAccessRepresentativeKind().toString()));
        else
            handicapCompensationAdultRequest.setLegalAccessRepresentativeKind(fr.cg95.cvq.business.request.social.HcarLegalAccessRepresentativeKindType.getDefaultHcarLegalAccessRepresentativeKindType());
        handicapCompensationAdultRequest.setProjectRequestsShelteredWork(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsShelteredWork()));
        handicapCompensationAdultRequest.setFormationCurrentFormation(handicapCompensationAdultRequestXml.getFormation().getFormationCurrentFormation());
        handicapCompensationAdultRequest.setStudiesAssistanceUnderDisability(Boolean.valueOf(handicapCompensationAdultRequestXml.getStudies().getStudiesAssistanceUnderDisability()));
        if (handicapCompensationAdultRequestXml.getSocialService().getProfessionalSupportSocialServiceAddress() != null)
            handicapCompensationAdultRequest.setProfessionalSupportSocialServiceAddress(Address.xmlToModel(handicapCompensationAdultRequestXml.getSocialService().getProfessionalSupportSocialServiceAddress()));
        handicapCompensationAdultRequest.setStudiesHighSchool(Boolean.valueOf(handicapCompensationAdultRequestXml.getStudies().getStudiesHighSchool()));
        handicapCompensationAdultRequest.setHealthProfessionalFirstName(handicapCompensationAdultRequestXml.getHealth().getHealthProfessionalFirstName());
        handicapCompensationAdultRequest.setProfessionalSupportSocialServiceName(handicapCompensationAdultRequestXml.getSocialService().getProfessionalSupportSocialServiceName());
        handicapCompensationAdultRequest.setFacilitiesCustomCarDetails(handicapCompensationAdultRequestXml.getFacilities().getFacilitiesCustomCarDetails());
        handicapCompensationAdultRequest.setDwellingPrecision(handicapCompensationAdultRequestXml.getDwelling().getDwellingPrecision());
        handicapCompensationAdultRequest.setBenefitsDisabilityCard(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsDisabilityCard()));
        if (handicapCompensationAdultRequestXml.getSocialSecurity().getSocialSecurityMemberShipKind() != null)
            handicapCompensationAdultRequest.setSocialSecurityMemberShipKind(fr.cg95.cvq.business.request.social.HcarSocialSecurityMemberShipKindType.forString(handicapCompensationAdultRequestXml.getSocialSecurity().getSocialSecurityMemberShipKind().toString()));
        else
            handicapCompensationAdultRequest.setSocialSecurityMemberShipKind(fr.cg95.cvq.business.request.social.HcarSocialSecurityMemberShipKindType.getDefaultHcarSocialSecurityMemberShipKindType());
        handicapCompensationAdultRequest.setProfessionalStatusElectiveFunctionDetails(handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusElectiveFunctionDetails());
        handicapCompensationAdultRequest.setFacilitiesAnimalAid(Boolean.valueOf(handicapCompensationAdultRequestXml.getFacilities().getFacilitiesAnimalAid()));
        if (handicapCompensationAdultRequestXml.getStudies().getStudiesHighSchoolAddress() != null)
            handicapCompensationAdultRequest.setStudiesHighSchoolAddress(Address.xmlToModel(handicapCompensationAdultRequestXml.getStudies().getStudiesHighSchoolAddress()));
        return handicapCompensationAdultRequest;
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
