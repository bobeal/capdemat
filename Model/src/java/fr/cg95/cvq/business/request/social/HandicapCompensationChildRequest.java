
package fr.cg95.cvq.business.request.social;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.xmlbeans.XmlOptions;

import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.joined-subclass
 *  table="handicap_compensation_child_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class HandicapCompensationChildRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public HandicapCompensationChildRequest() {
        super();
      
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
    public final String modelToXmlString() {
        HandicapCompensationChildRequestDocument object = (HandicapCompensationChildRequestDocument) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final HandicapCompensationChildRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        HandicapCompensationChildRequestDocument handicapCompensationChildRequestDoc = HandicapCompensationChildRequestDocument.Factory.newInstance();
        HandicapCompensationChildRequestDocument.HandicapCompensationChildRequest handicapCompensationChildRequest = handicapCompensationChildRequestDoc.addNewHandicapCompensationChildRequest();
        super.fillCommonXmlInfo(handicapCompensationChildRequest);
        int i = 0;
      HccrHealthType hccrHealthTypeHealth = handicapCompensationChildRequest.addNewHealth();
        if (this.healthFollowedByProfessional != null)
            hccrHealthTypeHealth.setHealthFollowedByProfessional(this.healthFollowedByProfessional.booleanValue());
        HccrProfessionalSupportType hccrProfessionalSupportTypeProfessionalSupport = handicapCompensationChildRequest.addNewProfessionalSupport();
        if (this.professionalSupportProfessionals != null)
            hccrProfessionalSupportTypeProfessionalSupport.setProfessionalSupportProfessionals(this.professionalSupportProfessionals.booleanValue());
        HccrReferent hccrReferentReferent = handicapCompensationChildRequest.addNewReferent();
        if (this.referentFamilyDependents != null)
            hccrReferentReferent.setReferentFamilyDependents(this.referentFamilyDependents.booleanValue());
        HccrFamilyAssistanceType hccrFamilyAssistanceTypeFamilyAssistance = handicapCompensationChildRequest.addNewFamilyAssistance();
        if (this.isFamilyAssistance != null)
            hccrFamilyAssistanceTypeFamilyAssistance.setIsFamilyAssistance(this.isFamilyAssistance.booleanValue());
        HccrSchoolingType hccrSchoolingTypeSchooling = handicapCompensationChildRequest.addNewSchooling();
        if (this.schoolingAttendedGrade != null)
            hccrSchoolingTypeSchooling.setSchoolingAttendedGrade(fr.cg95.cvq.xml.common.SectionType.Enum.forString(this.schoolingAttendedGrade.toString()));
      
        i = 0;
        if (familyDependents != null) {
            fr.cg95.cvq.xml.request.social.HccrFamilyDependentType[] familyDependentsTypeTab = new fr.cg95.cvq.xml.request.social.HccrFamilyDependentType[familyDependents.size()];
            for (HccrFamilyDependent object : familyDependents) {
              familyDependentsTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationChildRequest.setFamilyDependentsArray(familyDependentsTypeTab);
        }
      
        if (this.referentTitle != null)
            hccrReferentReferent.setReferentTitle(fr.cg95.cvq.xml.common.TitleType.Enum.forString(this.referentTitle.toString()));
      
        handicapCompensationChildRequest.setProjectComments(this.projectComments);
        HccrFoldersType hccrFoldersTypeFolders = handicapCompensationChildRequest.addNewFolders();
        if (this.foldersCdes != null)
            hccrFoldersTypeFolders.setFoldersCdes(this.foldersCdes.booleanValue());
      
        hccrFoldersTypeFolders.setFoldersMdphDepartment(this.foldersMdphDepartment);
      
        handicapCompensationChildRequest.setProjectNeeds(this.projectNeeds);
        HccrHomeInterventionType hccrHomeInterventionTypeHomeIntervention = handicapCompensationChildRequest.addNewHomeIntervention();
        if (this.homeInterventionHomeIntervenant != null)
            hccrHomeInterventionTypeHomeIntervention.setHomeInterventionHomeIntervenant(this.homeInterventionHomeIntervenant.booleanValue());
        HccrBenefitsType hccrBenefitsTypeBenefits = handicapCompensationChildRequest.addNewBenefits();
        if (this.benefitsEducationAllocationOfDisabledChildren != null)
            hccrBenefitsTypeBenefits.setBenefitsEducationAllocationOfDisabledChildren(this.benefitsEducationAllocationOfDisabledChildren.booleanValue());
      
        i = 0;
        if (otherFolders != null) {
            fr.cg95.cvq.xml.request.social.HccrOtherFolderType[] otherFoldersTypeTab = new fr.cg95.cvq.xml.request.social.HccrOtherFolderType[otherFolders.size()];
            for (HccrOtherFolder object : otherFolders) {
              otherFoldersTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationChildRequest.setOtherFoldersArray(otherFoldersTypeTab);
        }
      
        hccrFoldersTypeFolders.setFoldersMdphNumber(this.foldersMdphNumber);
        HccrSubjectType hccrSubjectTypeHccrSubject = handicapCompensationChildRequest.addNewHccrSubject();
        if (this.subjectParentalAuthorityHolder != null)
            hccrSubjectTypeHccrSubject.setSubjectParentalAuthorityHolder(fr.cg95.cvq.xml.request.social.HccrSubjectParentalAuthorityHolderType.Enum.forString(this.subjectParentalAuthorityHolder.toString()));
        HccrProjectRequestsType hccrProjectRequestsTypeProjectRequests = handicapCompensationChildRequest.addNewProjectRequests();
        if (this.projectRequestsHousingFacilities != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsHousingFacilities(this.projectRequestsHousingFacilities.booleanValue());
      
        if (this.schoolingHomeSchooling != null)
            hccrSchoolingTypeSchooling.setSchoolingHomeSchooling(this.schoolingHomeSchooling.booleanValue());
        HccrFather hccrFatherFather = handicapCompensationChildRequest.addNewFather();
        if (this.fatherActivityReductionRatio != null)
            hccrFatherFather.setFatherActivityReductionRatio(new BigInteger(this.fatherActivityReductionRatio.toString()));
      
        date = this.subjectBirthDate;
        if (date != null) {
            calendar.setTime(date);
            hccrSubjectTypeHccrSubject.setSubjectBirthDate(calendar);
        }
      
        hccrSchoolingTypeSchooling.setSchoolingExtraCurricularDetails(this.schoolingExtraCurricularDetails);
      
        if (this.schoolingSpecializedGrade != null)
            hccrSchoolingTypeSchooling.setSchoolingSpecializedGrade(this.schoolingSpecializedGrade.booleanValue());
      
        if (this.benefitsDisabilityPension != null)
            hccrBenefitsTypeBenefits.setBenefitsDisabilityPension(this.benefitsDisabilityPension.booleanValue());
      
        hccrReferentReferent.setReferentMaidenName(this.referentMaidenName);
      
        if (this.projectRequestsDisabledWorkerRecognition != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsDisabledWorkerRecognition(this.projectRequestsDisabledWorkerRecognition.booleanValue());
      
        if (this.benefitsUnemploymentBenefits != null)
            hccrBenefitsTypeBenefits.setBenefitsUnemploymentBenefits(this.benefitsUnemploymentBenefits.booleanValue());
      
        i = 0;
        if (homeIntervenants != null) {
            fr.cg95.cvq.xml.request.social.HccrHomeIntervenantType[] homeIntervenantsTypeTab = new fr.cg95.cvq.xml.request.social.HccrHomeIntervenantType[homeIntervenants.size()];
            for (HccrHomeIntervenant object : homeIntervenants) {
              homeIntervenantsTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationChildRequest.setHomeIntervenantsArray(homeIntervenantsTypeTab);
        }
        HccrProfessionalStatusType hccrProfessionalStatusTypeProfessionalStatus = handicapCompensationChildRequest.addNewProfessionalStatus();
        if (this.professionalStatusKind != null)
            hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusKind(fr.cg95.cvq.xml.request.social.HccrProfessionalStatusKindType.Enum.forString(this.professionalStatusKind.toString()));
      
        if (this.schoolingHomeSchoolingKind != null)
            hccrSchoolingTypeSchooling.setSchoolingHomeSchoolingKind(fr.cg95.cvq.xml.request.social.HccrHomeSchoolingKindType.Enum.forString(this.schoolingHomeSchoolingKind.toString()));
      
        hccrBenefitsTypeBenefits.setBenefitsEducationOfDisabledChildrenDetails(this.benefitsEducationOfDisabledChildrenDetails);
        HccrFormationType hccrFormationTypeFormation = handicapCompensationChildRequest.addNewFormation();
        hccrFormationTypeFormation.setFormationPreviousFormation(this.formationPreviousFormation);
      
        if (this.projectRequestsVocationalTraining != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsVocationalTraining(this.projectRequestsVocationalTraining.booleanValue());
        HccrFacilitiesType hccrFacilitiesTypeFacilities = handicapCompensationChildRequest.addNewFacilities();
        if (this.facilitiesCustomCar != null)
            hccrFacilitiesTypeFacilities.setFacilitiesCustomCar(this.facilitiesCustomCar.booleanValue());
      
        if (this.benefitsDisabledAdultAllocation != null)
            hccrBenefitsTypeBenefits.setBenefitsDisabledAdultAllocation(this.benefitsDisabledAdultAllocation.booleanValue());
      
        if (this.professionalStatusIndemnified != null)
            hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusIndemnified(this.professionalStatusIndemnified.booleanValue());
      
        if (this.schoolingEnrolment != null)
            hccrSchoolingTypeSchooling.setSchoolingEnrolment(this.schoolingEnrolment.booleanValue());
      
        if (this.benefitsThirdPartyCompensatoryAllowance != null)
            hccrBenefitsTypeBenefits.setBenefitsThirdPartyCompensatoryAllowance(this.benefitsThirdPartyCompensatoryAllowance.booleanValue());
      
        date = this.referentBirthDate;
        if (date != null) {
            calendar.setTime(date);
            hccrReferentReferent.setReferentBirthDate(calendar);
        }
      
        date = this.professionalStatusDate;
        if (date != null) {
            calendar.setTime(date);
            hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusDate(calendar);
        }
      
        if (this.projectRequestsTransportCostAllocation != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsTransportCostAllocation(this.projectRequestsTransportCostAllocation.booleanValue());
      
        if (this.benefitsProfessionalOrientation != null)
            hccrBenefitsTypeBenefits.setBenefitsProfessionalOrientation(this.benefitsProfessionalOrientation.booleanValue());
      
        hccrSchoolingTypeSchooling.setSchoolingHomeSchoolingAccompanistLastName(this.schoolingHomeSchoolingAccompanistLastName);
      
        if (this.benefitsDisabilityRecognition != null)
            hccrBenefitsTypeBenefits.setBenefitsDisabilityRecognition(this.benefitsDisabilityRecognition.booleanValue());
      
        if (this.professionalStatusRegisterAsUnemployed != null)
            hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusRegisterAsUnemployed(this.professionalStatusRegisterAsUnemployed.booleanValue());
      
        date = this.professionalStatusIndemnifiedDate;
        if (date != null) {
            calendar.setTime(date);
            hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusIndemnifiedDate(calendar);
        }
        HccrDwellingType hccrDwellingTypeDwelling = handicapCompensationChildRequest.addNewDwelling();
        hccrDwellingTypeDwelling.setDwellingSocialReceptionNaming(this.dwellingSocialReceptionNaming);
      
        hccrBenefitsTypeBenefits.setBenefitsProfessionalOrientationDetails(this.benefitsProfessionalOrientationDetails);
      
        if (this.benefitsPainfulStandingCard != null)
            hccrBenefitsTypeBenefits.setBenefitsPainfulStandingCard(this.benefitsPainfulStandingCard.booleanValue());
      
        hccrFoldersTypeFolders.setFoldersCdesDepartment(this.foldersCdesDepartment);
      
        if (this.facilitiesSpecializedTransport != null)
            hccrFacilitiesTypeFacilities.setFacilitiesSpecializedTransport(this.facilitiesSpecializedTransport.booleanValue());
      
        if (this.benefitsParkingCard != null)
            hccrBenefitsTypeBenefits.setBenefitsParkingCard(this.benefitsParkingCard.booleanValue());
      
        hccrFacilitiesTypeFacilities.setFacilitiesSpecializedTransportDetails(this.facilitiesSpecializedTransportDetails);
      
        hccrBenefitsTypeBenefits.setBenefitsWorkAccidentAnnuityRatio(this.benefitsWorkAccidentAnnuityRatio);
        HccrSocialSecurityType hccrSocialSecurityTypeSocialSecurity = handicapCompensationChildRequest.addNewSocialSecurity();
        hccrSocialSecurityTypeSocialSecurity.setSocialSecurityNumber(this.socialSecurityNumber);
      
        if (this.benefitsWorkAccidentAnnuity != null)
            hccrBenefitsTypeBenefits.setBenefitsWorkAccidentAnnuity(this.benefitsWorkAccidentAnnuity.booleanValue());
        HccrCareType hccrCareTypeCare = handicapCompensationChildRequest.addNewCare();
        if (this.careCareServices != null)
            hccrCareTypeCare.setCareCareServices(this.careCareServices.booleanValue());
      
        if (this.benefitsDailyAllowances != null)
            hccrBenefitsTypeBenefits.setBenefitsDailyAllowances(this.benefitsDailyAllowances.booleanValue());
      
        hccrBenefitsTypeBenefits.setBenefitsDisabilityRatio(this.benefitsDisabilityRatio);
      
        hccrFatherFather.setFatherFirstName(this.fatherFirstName);
      
        if (this.schoolingHomeSchoolingAccompanistAddress != null)
            hccrSchoolingTypeSchooling.setSchoolingHomeSchoolingAccompanistAddress(Address.modelToXml(this.schoolingHomeSchoolingAccompanistAddress));
      
        if (this.projectRequestsCustomCar != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsCustomCar(this.projectRequestsCustomCar.booleanValue());
        HccrPaymentAgencyType hccrPaymentAgencyTypePaymentAgency = handicapCompensationChildRequest.addNewPaymentAgency();
        hccrPaymentAgencyTypePaymentAgency.setPaymentAgencyBeneficiaryNumber(this.paymentAgencyBeneficiaryNumber);
      
        hccrFoldersTypeFolders.setFoldersCotorepNumber(this.foldersCotorepNumber);
      
        if (this.projectRequestsACTPRenewal != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsACTPRenewal(this.projectRequestsACTPRenewal.booleanValue());
      
        if (this.referentFamilyStatus != null)
            hccrReferentReferent.setReferentFamilyStatus(fr.cg95.cvq.xml.common.FamilyStatusType.Enum.forString(this.referentFamilyStatus.toString()));
      
        hccrSchoolingTypeSchooling.setSchoolingSchoolName(this.schoolingSchoolName);
      
        if (this.dwellingSocialReceptionAddress != null)
            hccrDwellingTypeDwelling.setDwellingSocialReceptionAddress(Address.modelToXml(this.dwellingSocialReceptionAddress));
      
        hccrBenefitsTypeBenefits.setBenefitsSupportedByAnInstitutionDetails(this.benefitsSupportedByAnInstitutionDetails);
      
        if (this.foldersMdph != null)
            hccrFoldersTypeFolders.setFoldersMdph(this.foldersMdph.booleanValue());
        HccrMother hccrMotherMother = handicapCompensationChildRequest.addNewMother();
        hccrMotherMother.setMotherJob(this.motherJob);
      
        if (this.schoolingSchoolAddress != null)
            hccrSchoolingTypeSchooling.setSchoolingSchoolAddress(Address.modelToXml(this.schoolingSchoolAddress));
      
        hccrSchoolingTypeSchooling.setSchoolingTime(this.schoolingTime);
      
        if (this.professionalSupportDealsWithSameProfessional != null)
            hccrProfessionalSupportTypeProfessionalSupport.setProfessionalSupportDealsWithSameProfessional(this.professionalSupportDealsWithSameProfessional.booleanValue());
        HccrAseReferent hccrAseReferentAseReferent = handicapCompensationChildRequest.addNewAseReferent();
        hccrAseReferentAseReferent.setAseReferentDepartment(this.aseReferentDepartment);
      
        hccrFoldersTypeFolders.setFoldersCotorepDepartment(this.foldersCotorepDepartment);
      
        if (this.dwellingEstablishmentReception != null)
            hccrDwellingTypeDwelling.setDwellingEstablishmentReception(this.dwellingEstablishmentReception.booleanValue());
      
        hccrMotherMother.setMotherFirstName(this.motherFirstName);
      
        i = 0;
        if (additionalFee != null) {
            fr.cg95.cvq.xml.request.social.HccrAdditionalFeeType[] additionalFeeTypeTab = new fr.cg95.cvq.xml.request.social.HccrAdditionalFeeType[additionalFee.size()];
            for (HccrAdditionalFee object : additionalFee) {
              additionalFeeTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationChildRequest.setAdditionalFeeArray(additionalFeeTypeTab);
        }
      
        if (this.projectRequestsOrdinaryWorking != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsOrdinaryWorking(this.projectRequestsOrdinaryWorking.booleanValue());
      
        if (this.benefitsDisabledWorkerRecognition != null)
            hccrBenefitsTypeBenefits.setBenefitsDisabledWorkerRecognition(this.benefitsDisabledWorkerRecognition.booleanValue());
      
        if (this.dwellingSocialReception != null)
            hccrDwellingTypeDwelling.setDwellingSocialReception(this.dwellingSocialReception.booleanValue());
      
        if (this.projectRequestsEuropeanParkingCard != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsEuropeanParkingCard(this.projectRequestsEuropeanParkingCard.booleanValue());
      
        if (this.healthFollowedByDoctor != null)
            hccrHealthTypeHealth.setHealthFollowedByDoctor(this.healthFollowedByDoctor.booleanValue());
      
        i = 0;
        if (familyAssistanceMembers != null) {
            fr.cg95.cvq.xml.request.social.HccrFamilyAssistanceMemberType[] familyAssistanceMembersTypeTab = new fr.cg95.cvq.xml.request.social.HccrFamilyAssistanceMemberType[familyAssistanceMembers.size()];
            for (HccrFamilyAssistanceMember object : familyAssistanceMembers) {
              familyAssistanceMembersTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationChildRequest.setFamilyAssistanceMembersArray(familyAssistanceMembersTypeTab);
        }
      
        hccrSchoolingTypeSchooling.setSchoolingHomeSchoolingAccompanistFirstName(this.schoolingHomeSchoolingAccompanistFirstName);
      
        hccrReferentReferent.setReferentBirthCity(this.referentBirthCity);
      
        if (this.projectRequestsFreePensionMembership != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsFreePensionMembership(this.projectRequestsFreePensionMembership.booleanValue());
      
        hccrSchoolingTypeSchooling.setSchoolingSpecializedGradeDetails(this.schoolingSpecializedGradeDetails);
      
        hccrReferentReferent.setReferentBirthCountry(this.referentBirthCountry);
      
        i = 0;
        if (professionals != null) {
            fr.cg95.cvq.xml.request.social.HccrProfessionalType[] professionalsTypeTab = new fr.cg95.cvq.xml.request.social.HccrProfessionalType[professionals.size()];
            for (HccrProfessional object : professionals) {
              professionalsTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationChildRequest.setProfessionalsArray(professionalsTypeTab);
        }
      
        if (this.healthFollowedByHospital != null)
            hccrHealthTypeHealth.setHealthFollowedByHospital(this.healthFollowedByHospital.booleanValue());
      
        hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusEmployerName(this.professionalStatusEmployerName);
      
        if (this.projectRequestsInstitutionSupport != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsInstitutionSupport(this.projectRequestsInstitutionSupport.booleanValue());
      
        if (this.benefitsSocialWelfare != null)
            hccrBenefitsTypeBenefits.setBenefitsSocialWelfare(this.benefitsSocialWelfare.booleanValue());
      
        if (this.projectRequestsHandicapRecognition != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsHandicapRecognition(this.projectRequestsHandicapRecognition.booleanValue());
      
        i = 0;
        if (careServices != null) {
            fr.cg95.cvq.xml.request.social.HccrCareServiceType[] careServicesTypeTab = new fr.cg95.cvq.xml.request.social.HccrCareServiceType[careServices.size()];
            for (HccrCareService object : careServices) {
              careServicesTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationChildRequest.setCareServicesArray(careServicesTypeTab);
        }
      
        if (this.schoolingExtraCurricular != null)
            hccrSchoolingTypeSchooling.setSchoolingExtraCurricular(this.schoolingExtraCurricular.booleanValue());
      
        handicapCompensationChildRequest.setProjectWish(this.projectWish);
      
        if (this.dwellingKind != null)
            hccrDwellingTypeDwelling.setDwellingKind(fr.cg95.cvq.xml.request.social.HccrDwellingKindType.Enum.forString(this.dwellingKind.toString()));
      
        hccrHealthTypeHealth.setHealthProfessionalLastName(this.healthProfessionalLastName);
      
        hccrFormationTypeFormation.setFormationStudiesLevel(this.formationStudiesLevel);
      
        if (this.projectRequestsProfessionalOrientation != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsProfessionalOrientation(this.projectRequestsProfessionalOrientation.booleanValue());
      
        hccrHealthTypeHealth.setHealthDoctorLastName(this.healthDoctorLastName);
        HccrSocialServiceType hccrSocialServiceTypeSocialService = handicapCompensationChildRequest.addNewSocialService();
        if (this.socialServiceAddress != null)
            hccrSocialServiceTypeSocialService.setSocialServiceAddress(Address.modelToXml(this.socialServiceAddress));
      
        hccrFacilitiesTypeFacilities.setFacilitiesHousingDetails(this.facilitiesHousingDetails);
      
        if (this.benefitsSupplementForSingleParents != null)
            hccrBenefitsTypeBenefits.setBenefitsSupplementForSingleParents(this.benefitsSupplementForSingleParents.booleanValue());
      
        if (this.projectRequestsIncreaseForIndependentLiving != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsIncreaseForIndependentLiving(this.projectRequestsIncreaseForIndependentLiving.booleanValue());
      
        if (this.benefitsThirdPartySupplement != null)
            hccrBenefitsTypeBenefits.setBenefitsThirdPartySupplement(this.benefitsThirdPartySupplement.booleanValue());
      
        hccrBenefitsTypeBenefits.setBenefitsDisabilityPensionCategory(this.benefitsDisabilityPensionCategory);
        HccrStudiesType hccrStudiesTypeStudies = handicapCompensationChildRequest.addNewStudies();
        hccrStudiesTypeStudies.setStudiesHighSchoolGrade(this.studiesHighSchoolGrade);
      
        hccrReferentReferent.setReferentLastName(this.referentLastName);
      
        hccrSubjectTypeHccrSubject.setSubjectBirthCity(this.subjectBirthCity);
      
        if (this.projectRequestsAssistance != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsAssistance(this.projectRequestsAssistance.booleanValue());
      
        if (this.benefitsSupportedByAnInstitution != null)
            hccrBenefitsTypeBenefits.setBenefitsSupportedByAnInstitution(this.benefitsSupportedByAnInstitution.booleanValue());
      
        if (this.professionalStatusEnvironment != null)
            hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusEnvironment(fr.cg95.cvq.xml.request.social.HccrProfessionalStatusEnvironmentType.Enum.forString(this.professionalStatusEnvironment.toString()));
      
        if (this.projectRequestsThirdPartyHelp != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsThirdPartyHelp(this.projectRequestsThirdPartyHelp.booleanValue());
      
        if (this.projectRequestsDisabledAdultAllowance != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsDisabledAdultAllowance(this.projectRequestsDisabledAdultAllowance.booleanValue());
      
        if (this.foldersOtherFolders != null)
            hccrFoldersTypeFolders.setFoldersOtherFolders(this.foldersOtherFolders.booleanValue());
      
        if (this.paymentAgencyBeneficiary != null)
            hccrPaymentAgencyTypePaymentAgency.setPaymentAgencyBeneficiary(fr.cg95.cvq.xml.request.social.HccrPaymentAgencyBeneficiaryType.Enum.forString(this.paymentAgencyBeneficiary.toString()));
      
        hccrFatherFather.setFatherJob(this.fatherJob);
      
        hccrFacilitiesTypeFacilities.setFacilitiesAnimalAidDetails(this.facilitiesAnimalAidDetails);
      
        i = 0;
        if (otherBenefits != null) {
            fr.cg95.cvq.xml.request.social.HccrOtherBenefitType[] otherBenefitsTypeTab = new fr.cg95.cvq.xml.request.social.HccrOtherBenefitType[otherBenefits.size()];
            for (HccrOtherBenefit object : otherBenefits) {
              otherBenefitsTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationChildRequest.setOtherBenefitsArray(otherBenefitsTypeTab);
        }
      
        hccrStudiesTypeStudies.setStudiesAssistanceUnderDisabilityDetails(this.studiesAssistanceUnderDisabilityDetails);
      
        if (this.paymentAgencyAddress != null)
            hccrPaymentAgencyTypePaymentAgency.setPaymentAgencyAddress(Address.modelToXml(this.paymentAgencyAddress));
      
        if (this.projectRequestsOther != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsOther(this.projectRequestsOther.booleanValue());
      
        if (this.benefitsThirdPersonCompensatoryAllowance != null)
            hccrBenefitsTypeBenefits.setBenefitsThirdPersonCompensatoryAllowance(this.benefitsThirdPersonCompensatoryAllowance.booleanValue());
      
        if (this.projectRequestsDisabilityCostAllocation != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsDisabilityCostAllocation(this.projectRequestsDisabilityCostAllocation.booleanValue());
      
        if (this.socialSecurityAgencyAddress != null)
            hccrSocialSecurityTypeSocialSecurity.setSocialSecurityAgencyAddress(Address.modelToXml(this.socialSecurityAgencyAddress));
      
        if (this.professionalStatusAddress != null)
            hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusAddress(Address.modelToXml(this.professionalStatusAddress));
      
        hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusProfession(this.professionalStatusProfession);
      
        if (this.dwellingReceptionAddress != null)
            hccrDwellingTypeDwelling.setDwellingReceptionAddress(Address.modelToXml(this.dwellingReceptionAddress));
      
        hccrFormationTypeFormation.setFormationDiploma(this.formationDiploma);
      
        hccrMotherMother.setMotherLastName(this.motherLastName);
      
        if (this.foldersCotorep != null)
            hccrFoldersTypeFolders.setFoldersCotorep(this.foldersCotorep.booleanValue());
      
        if (this.professionalStatusElectiveFunction != null)
            hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusElectiveFunction(this.professionalStatusElectiveFunction.booleanValue());
      
        if (this.benefitsIncreaseForIndependentLiving != null)
            hccrBenefitsTypeBenefits.setBenefitsIncreaseForIndependentLiving(this.benefitsIncreaseForIndependentLiving.booleanValue());
      
        hccrSubjectTypeHccrSubject.setSubjectBirthCountry(this.subjectBirthCountry);
      
        if (this.fatherActivityReduction != null)
            hccrFatherFather.setFatherActivityReduction(this.fatherActivityReduction.booleanValue());
      
        if (this.projectRequestsDisabilityCard != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsDisabilityCard(this.projectRequestsDisabilityCard.booleanValue());
      
        hccrStudiesTypeStudies.setStudiesHighSchoolName(this.studiesHighSchoolName);
      
        if (this.dwellingReceptionType != null)
            hccrDwellingTypeDwelling.setDwellingReceptionType(fr.cg95.cvq.xml.request.social.HccrDwellingReceptionKindType.Enum.forString(this.dwellingReceptionType.toString()));
      
        hccrFatherFather.setFatherLastName(this.fatherLastName);
      
        if (this.motherActivityReductionRatio != null)
            hccrMotherMother.setMotherActivityReductionRatio(new BigInteger(this.motherActivityReductionRatio.toString()));
      
        date = this.professionalStatusRegisterAsUnemployedDate;
        if (date != null) {
            calendar.setTime(date);
            hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusRegisterAsUnemployedDate(calendar);
        }
      
        hccrPaymentAgencyTypePaymentAgency.setPaymentAgencyName(this.paymentAgencyName);
      
        hccrSocialSecurityTypeSocialSecurity.setSocialSecurityAgencyName(this.socialSecurityAgencyName);
      
        hccrDwellingTypeDwelling.setDwellingReceptionNaming(this.dwellingReceptionNaming);
      
        if (this.schoolingSendToSchool != null)
            hccrSchoolingTypeSchooling.setSchoolingSendToSchool(this.schoolingSendToSchool.booleanValue());
      
        if (this.benefitsEducationOfDisabledChildren != null)
            hccrBenefitsTypeBenefits.setBenefitsEducationOfDisabledChildren(this.benefitsEducationOfDisabledChildren.booleanValue());
      
        hccrReferentReferent.setReferentFirstName(this.referentFirstName);
      
        hccrFacilitiesTypeFacilities.setFacilitiesTechnicalAssistanceDetails(this.facilitiesTechnicalAssistanceDetails);
      
        if (this.benefitsOtherBenefits != null)
            hccrBenefitsTypeBenefits.setBenefitsOtherBenefits(this.benefitsOtherBenefits.booleanValue());
      
        hccrFoldersTypeFolders.setFoldersCdesNumber(this.foldersCdesNumber);
      
        hccrSocialServiceTypeSocialService.setSocialServiceName(this.socialServiceName);
      
        if (this.benefitsDisabilityCompensation != null)
            hccrBenefitsTypeBenefits.setBenefitsDisabilityCompensation(this.benefitsDisabilityCompensation.booleanValue());
      
        hccrHealthTypeHealth.setHealthDoctorFirstName(this.healthDoctorFirstName);
      
        if (this.projectRequestsTechnicalHelp != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsTechnicalHelp(this.projectRequestsTechnicalHelp.booleanValue());
      
        if (this.facilitiesTechnicalAssistance != null)
            hccrFacilitiesTypeFacilities.setFacilitiesTechnicalAssistance(this.facilitiesTechnicalAssistance.booleanValue());
      
        if (this.benefitsCompensatoryAllowanceForExpenses != null)
            hccrBenefitsTypeBenefits.setBenefitsCompensatoryAllowanceForExpenses(this.benefitsCompensatoryAllowanceForExpenses.booleanValue());
      
        if (this.facilitiesHousing != null)
            hccrFacilitiesTypeFacilities.setFacilitiesHousing(this.facilitiesHousing.booleanValue());
      
        hccrHealthTypeHealth.setHealthHospitalName(this.healthHospitalName);
      
        if (this.projectRequestsDisabledPriorityCard != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsDisabledPriorityCard(this.projectRequestsDisabledPriorityCard.booleanValue());
      
        if (this.projectRequestsEducationAllocationOfDisabledChildren != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsEducationAllocationOfDisabledChildren(this.projectRequestsEducationAllocationOfDisabledChildren.booleanValue());
      
        hccrProjectRequestsTypeProjectRequests.setProjectRequestsOtherDetails(this.projectRequestsOtherDetails);
      
        if (this.socialServiceSupport != null)
            hccrSocialServiceTypeSocialService.setSocialServiceSupport(this.socialServiceSupport.booleanValue());
      
        if (this.projectRequestsShelteredWork != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsShelteredWork(this.projectRequestsShelteredWork.booleanValue());
      
        hccrFormationTypeFormation.setFormationCurrentFormation(this.formationCurrentFormation);
      
        if (this.schoolingSchoolingKind != null)
            hccrSchoolingTypeSchooling.setSchoolingSchoolingKind(fr.cg95.cvq.xml.request.social.HccrSchoolingKindType.Enum.forString(this.schoolingSchoolingKind.toString()));
      
        if (this.studiesAssistanceUnderDisability != null)
            hccrStudiesTypeStudies.setStudiesAssistanceUnderDisability(this.studiesAssistanceUnderDisability.booleanValue());
      
        if (this.studiesHighSchool != null)
            hccrStudiesTypeStudies.setStudiesHighSchool(this.studiesHighSchool.booleanValue());
      
        hccrHealthTypeHealth.setHealthProfessionalFirstName(this.healthProfessionalFirstName);
      
        if (this.motherActivityReduction != null)
            hccrMotherMother.setMotherActivityReduction(this.motherActivityReduction.booleanValue());
      
        hccrFacilitiesTypeFacilities.setFacilitiesCustomCarDetails(this.facilitiesCustomCarDetails);
      
        if (this.schoolingPersonalizedSchoolingPlan != null)
            hccrSchoolingTypeSchooling.setSchoolingPersonalizedSchoolingPlan(this.schoolingPersonalizedSchoolingPlan.booleanValue());
      
        hccrDwellingTypeDwelling.setDwellingPrecision(this.dwellingPrecision);
      
        if (this.benefitsDisabilityCard != null)
            hccrBenefitsTypeBenefits.setBenefitsDisabilityCard(this.benefitsDisabilityCard.booleanValue());
      
        if (this.socialSecurityMemberShipKind != null)
            hccrSocialSecurityTypeSocialSecurity.setSocialSecurityMemberShipKind(fr.cg95.cvq.xml.request.social.HccrSocialSecurityMemberShipKindType.Enum.forString(this.socialSecurityMemberShipKind.toString()));
      
        hccrAseReferentAseReferent.setAseReferentLastName(this.aseReferentLastName);
      
        hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusElectiveFunctionDetails(this.professionalStatusElectiveFunctionDetails);
      
        if (this.facilitiesAnimalAid != null)
            hccrFacilitiesTypeFacilities.setFacilitiesAnimalAid(this.facilitiesAnimalAid.booleanValue());
      
        if (this.studiesHighSchoolAddress != null)
            hccrStudiesTypeStudies.setStudiesHighSchoolAddress(Address.modelToXml(this.studiesHighSchoolAddress));
      
        return handicapCompensationChildRequestDoc;
    }

    @Override
    public RequestType modelToXmlRequest() {
        HandicapCompensationChildRequestDocument handicapCompensationChildRequestDoc =
            (HandicapCompensationChildRequestDocument) modelToXml();
        return handicapCompensationChildRequestDoc.getHandicapCompensationChildRequest();
    }

    public static HandicapCompensationChildRequest xmlToModel(HandicapCompensationChildRequestDocument handicapCompensationChildRequestDoc) {
        HandicapCompensationChildRequestDocument.HandicapCompensationChildRequest handicapCompensationChildRequestXml = handicapCompensationChildRequestDoc.getHandicapCompensationChildRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HandicapCompensationChildRequest handicapCompensationChildRequest = new HandicapCompensationChildRequest();
        handicapCompensationChildRequest.fillCommonModelInfo(handicapCompensationChildRequest, handicapCompensationChildRequestXml);
    
        handicapCompensationChildRequest.setHealthFollowedByProfessional(Boolean.valueOf(handicapCompensationChildRequestXml.getHealth().getHealthFollowedByProfessional()));
      
        handicapCompensationChildRequest.setProfessionalSupportProfessionals(Boolean.valueOf(handicapCompensationChildRequestXml.getProfessionalSupport().getProfessionalSupportProfessionals()));
      
        handicapCompensationChildRequest.setReferentFamilyDependents(Boolean.valueOf(handicapCompensationChildRequestXml.getReferent().getReferentFamilyDependents()));
      
        handicapCompensationChildRequest.setIsFamilyAssistance(Boolean.valueOf(handicapCompensationChildRequestXml.getFamilyAssistance().getIsFamilyAssistance()));
      
        if (handicapCompensationChildRequestXml.getSchooling().getSchoolingAttendedGrade() != null)
            handicapCompensationChildRequest.setSchoolingAttendedGrade(fr.cg95.cvq.business.users.SectionType.forString(handicapCompensationChildRequestXml.getSchooling().getSchoolingAttendedGrade().toString()));
        else
            handicapCompensationChildRequest.setSchoolingAttendedGrade(fr.cg95.cvq.business.users.SectionType.getDefaultSectionType());
      
        List<fr.cg95.cvq.business.request.social.HccrFamilyDependent> familyDependentsList = new ArrayList<fr.cg95.cvq.business.request.social.HccrFamilyDependent>(handicapCompensationChildRequestXml.sizeOfFamilyDependentsArray());
        for (HccrFamilyDependentType object : handicapCompensationChildRequestXml.getFamilyDependentsArray()) {
            familyDependentsList.add(fr.cg95.cvq.business.request.social.HccrFamilyDependent.xmlToModel(object));
        }
        handicapCompensationChildRequest.setFamilyDependents(familyDependentsList);
      
        if (handicapCompensationChildRequestXml.getReferent().getReferentTitle() != null)
            handicapCompensationChildRequest.setReferentTitle(fr.cg95.cvq.business.users.TitleType.forString(handicapCompensationChildRequestXml.getReferent().getReferentTitle().toString()));
        else
            handicapCompensationChildRequest.setReferentTitle(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
      
        handicapCompensationChildRequest.setProjectComments(handicapCompensationChildRequestXml.getProjectComments());
      
        handicapCompensationChildRequest.setFoldersCdes(Boolean.valueOf(handicapCompensationChildRequestXml.getFolders().getFoldersCdes()));
      
        handicapCompensationChildRequest.setFoldersMdphDepartment(handicapCompensationChildRequestXml.getFolders().getFoldersMdphDepartment());
      
        handicapCompensationChildRequest.setProjectNeeds(handicapCompensationChildRequestXml.getProjectNeeds());
      
        handicapCompensationChildRequest.setHomeInterventionHomeIntervenant(Boolean.valueOf(handicapCompensationChildRequestXml.getHomeIntervention().getHomeInterventionHomeIntervenant()));
      
        handicapCompensationChildRequest.setBenefitsEducationAllocationOfDisabledChildren(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsEducationAllocationOfDisabledChildren()));
      
        List<fr.cg95.cvq.business.request.social.HccrOtherFolder> otherFoldersList = new ArrayList<fr.cg95.cvq.business.request.social.HccrOtherFolder>(handicapCompensationChildRequestXml.sizeOfOtherFoldersArray());
        for (HccrOtherFolderType object : handicapCompensationChildRequestXml.getOtherFoldersArray()) {
            otherFoldersList.add(fr.cg95.cvq.business.request.social.HccrOtherFolder.xmlToModel(object));
        }
        handicapCompensationChildRequest.setOtherFolders(otherFoldersList);
      
        handicapCompensationChildRequest.setFoldersMdphNumber(handicapCompensationChildRequestXml.getFolders().getFoldersMdphNumber());
      
        if (handicapCompensationChildRequestXml.getHccrSubject().getSubjectParentalAuthorityHolder() != null)
            handicapCompensationChildRequest.setSubjectParentalAuthorityHolder(fr.cg95.cvq.business.request.social.HccrSubjectParentalAuthorityHolderType.forString(handicapCompensationChildRequestXml.getHccrSubject().getSubjectParentalAuthorityHolder().toString()));
        else
            handicapCompensationChildRequest.setSubjectParentalAuthorityHolder(fr.cg95.cvq.business.request.social.HccrSubjectParentalAuthorityHolderType.getDefaultHccrSubjectParentalAuthorityHolderType());
      
        handicapCompensationChildRequest.setProjectRequestsHousingFacilities(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsHousingFacilities()));
      
        handicapCompensationChildRequest.setSchoolingHomeSchooling(Boolean.valueOf(handicapCompensationChildRequestXml.getSchooling().getSchoolingHomeSchooling()));
      
        handicapCompensationChildRequest.setFatherActivityReductionRatio(handicapCompensationChildRequestXml.getFather().getFatherActivityReductionRatio());
      
        calendar = handicapCompensationChildRequestXml.getHccrSubject().getSubjectBirthDate();
        if (calendar != null) {
            handicapCompensationChildRequest.setSubjectBirthDate(calendar.getTime());
        }
      
        handicapCompensationChildRequest.setSchoolingExtraCurricularDetails(handicapCompensationChildRequestXml.getSchooling().getSchoolingExtraCurricularDetails());
      
        handicapCompensationChildRequest.setSchoolingSpecializedGrade(Boolean.valueOf(handicapCompensationChildRequestXml.getSchooling().getSchoolingSpecializedGrade()));
      
        handicapCompensationChildRequest.setBenefitsDisabilityPension(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsDisabilityPension()));
      
        handicapCompensationChildRequest.setReferentMaidenName(handicapCompensationChildRequestXml.getReferent().getReferentMaidenName());
      
        handicapCompensationChildRequest.setProjectRequestsDisabledWorkerRecognition(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsDisabledWorkerRecognition()));
      
        handicapCompensationChildRequest.setBenefitsUnemploymentBenefits(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsUnemploymentBenefits()));
      
        List<fr.cg95.cvq.business.request.social.HccrHomeIntervenant> homeIntervenantsList = new ArrayList<fr.cg95.cvq.business.request.social.HccrHomeIntervenant>(handicapCompensationChildRequestXml.sizeOfHomeIntervenantsArray());
        for (HccrHomeIntervenantType object : handicapCompensationChildRequestXml.getHomeIntervenantsArray()) {
            homeIntervenantsList.add(fr.cg95.cvq.business.request.social.HccrHomeIntervenant.xmlToModel(object));
        }
        handicapCompensationChildRequest.setHomeIntervenants(homeIntervenantsList);
      
        if (handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusKind() != null)
            handicapCompensationChildRequest.setProfessionalStatusKind(fr.cg95.cvq.business.request.social.HccrProfessionalStatusKindType.forString(handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusKind().toString()));
        else
            handicapCompensationChildRequest.setProfessionalStatusKind(fr.cg95.cvq.business.request.social.HccrProfessionalStatusKindType.getDefaultHccrProfessionalStatusKindType());
      
        if (handicapCompensationChildRequestXml.getSchooling().getSchoolingHomeSchoolingKind() != null)
            handicapCompensationChildRequest.setSchoolingHomeSchoolingKind(fr.cg95.cvq.business.request.social.HccrHomeSchoolingKindType.forString(handicapCompensationChildRequestXml.getSchooling().getSchoolingHomeSchoolingKind().toString()));
        else
            handicapCompensationChildRequest.setSchoolingHomeSchoolingKind(fr.cg95.cvq.business.request.social.HccrHomeSchoolingKindType.getDefaultHccrHomeSchoolingKindType());
      
        handicapCompensationChildRequest.setBenefitsEducationOfDisabledChildrenDetails(handicapCompensationChildRequestXml.getBenefits().getBenefitsEducationOfDisabledChildrenDetails());
      
        handicapCompensationChildRequest.setFormationPreviousFormation(handicapCompensationChildRequestXml.getFormation().getFormationPreviousFormation());
      
        handicapCompensationChildRequest.setProjectRequestsVocationalTraining(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsVocationalTraining()));
      
        handicapCompensationChildRequest.setFacilitiesCustomCar(Boolean.valueOf(handicapCompensationChildRequestXml.getFacilities().getFacilitiesCustomCar()));
      
        handicapCompensationChildRequest.setBenefitsDisabledAdultAllocation(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsDisabledAdultAllocation()));
      
        handicapCompensationChildRequest.setProfessionalStatusIndemnified(Boolean.valueOf(handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusIndemnified()));
      
        handicapCompensationChildRequest.setSchoolingEnrolment(Boolean.valueOf(handicapCompensationChildRequestXml.getSchooling().getSchoolingEnrolment()));
      
        handicapCompensationChildRequest.setBenefitsThirdPartyCompensatoryAllowance(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsThirdPartyCompensatoryAllowance()));
      
        calendar = handicapCompensationChildRequestXml.getReferent().getReferentBirthDate();
        if (calendar != null) {
            handicapCompensationChildRequest.setReferentBirthDate(calendar.getTime());
        }
      
        calendar = handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusDate();
        if (calendar != null) {
            handicapCompensationChildRequest.setProfessionalStatusDate(calendar.getTime());
        }
      
        handicapCompensationChildRequest.setProjectRequestsTransportCostAllocation(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsTransportCostAllocation()));
      
        handicapCompensationChildRequest.setBenefitsProfessionalOrientation(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsProfessionalOrientation()));
      
        handicapCompensationChildRequest.setSchoolingHomeSchoolingAccompanistLastName(handicapCompensationChildRequestXml.getSchooling().getSchoolingHomeSchoolingAccompanistLastName());
      
        handicapCompensationChildRequest.setBenefitsDisabilityRecognition(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsDisabilityRecognition()));
      
        handicapCompensationChildRequest.setProfessionalStatusRegisterAsUnemployed(Boolean.valueOf(handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusRegisterAsUnemployed()));
      
        calendar = handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusIndemnifiedDate();
        if (calendar != null) {
            handicapCompensationChildRequest.setProfessionalStatusIndemnifiedDate(calendar.getTime());
        }
      
        handicapCompensationChildRequest.setDwellingSocialReceptionNaming(handicapCompensationChildRequestXml.getDwelling().getDwellingSocialReceptionNaming());
      
        handicapCompensationChildRequest.setBenefitsProfessionalOrientationDetails(handicapCompensationChildRequestXml.getBenefits().getBenefitsProfessionalOrientationDetails());
      
        handicapCompensationChildRequest.setBenefitsPainfulStandingCard(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsPainfulStandingCard()));
      
        handicapCompensationChildRequest.setFoldersCdesDepartment(handicapCompensationChildRequestXml.getFolders().getFoldersCdesDepartment());
      
        handicapCompensationChildRequest.setFacilitiesSpecializedTransport(Boolean.valueOf(handicapCompensationChildRequestXml.getFacilities().getFacilitiesSpecializedTransport()));
      
        handicapCompensationChildRequest.setBenefitsParkingCard(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsParkingCard()));
      
        handicapCompensationChildRequest.setFacilitiesSpecializedTransportDetails(handicapCompensationChildRequestXml.getFacilities().getFacilitiesSpecializedTransportDetails());
      
        handicapCompensationChildRequest.setBenefitsWorkAccidentAnnuityRatio(handicapCompensationChildRequestXml.getBenefits().getBenefitsWorkAccidentAnnuityRatio());
      
        handicapCompensationChildRequest.setSocialSecurityNumber(handicapCompensationChildRequestXml.getSocialSecurity().getSocialSecurityNumber());
      
        handicapCompensationChildRequest.setBenefitsWorkAccidentAnnuity(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsWorkAccidentAnnuity()));
      
        handicapCompensationChildRequest.setCareCareServices(Boolean.valueOf(handicapCompensationChildRequestXml.getCare().getCareCareServices()));
      
        handicapCompensationChildRequest.setBenefitsDailyAllowances(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsDailyAllowances()));
      
        handicapCompensationChildRequest.setBenefitsDisabilityRatio(handicapCompensationChildRequestXml.getBenefits().getBenefitsDisabilityRatio());
      
        handicapCompensationChildRequest.setFatherFirstName(handicapCompensationChildRequestXml.getFather().getFatherFirstName());
      
        if (handicapCompensationChildRequestXml.getSchooling().getSchoolingHomeSchoolingAccompanistAddress() != null)
            handicapCompensationChildRequest.setSchoolingHomeSchoolingAccompanistAddress(Address.xmlToModel(handicapCompensationChildRequestXml.getSchooling().getSchoolingHomeSchoolingAccompanistAddress()));
      
        handicapCompensationChildRequest.setProjectRequestsCustomCar(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsCustomCar()));
      
        handicapCompensationChildRequest.setPaymentAgencyBeneficiaryNumber(handicapCompensationChildRequestXml.getPaymentAgency().getPaymentAgencyBeneficiaryNumber());
      
        handicapCompensationChildRequest.setFoldersCotorepNumber(handicapCompensationChildRequestXml.getFolders().getFoldersCotorepNumber());
      
        handicapCompensationChildRequest.setProjectRequestsACTPRenewal(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsACTPRenewal()));
      
        if (handicapCompensationChildRequestXml.getReferent().getReferentFamilyStatus() != null)
            handicapCompensationChildRequest.setReferentFamilyStatus(fr.cg95.cvq.business.users.FamilyStatusType.forString(handicapCompensationChildRequestXml.getReferent().getReferentFamilyStatus().toString()));
        else
            handicapCompensationChildRequest.setReferentFamilyStatus(fr.cg95.cvq.business.users.FamilyStatusType.getDefaultFamilyStatusType());
      
        handicapCompensationChildRequest.setSchoolingSchoolName(handicapCompensationChildRequestXml.getSchooling().getSchoolingSchoolName());
      
        if (handicapCompensationChildRequestXml.getDwelling().getDwellingSocialReceptionAddress() != null)
            handicapCompensationChildRequest.setDwellingSocialReceptionAddress(Address.xmlToModel(handicapCompensationChildRequestXml.getDwelling().getDwellingSocialReceptionAddress()));
      
        handicapCompensationChildRequest.setBenefitsSupportedByAnInstitutionDetails(handicapCompensationChildRequestXml.getBenefits().getBenefitsSupportedByAnInstitutionDetails());
      
        handicapCompensationChildRequest.setFoldersMdph(Boolean.valueOf(handicapCompensationChildRequestXml.getFolders().getFoldersMdph()));
      
        handicapCompensationChildRequest.setMotherJob(handicapCompensationChildRequestXml.getMother().getMotherJob());
      
        if (handicapCompensationChildRequestXml.getSchooling().getSchoolingSchoolAddress() != null)
            handicapCompensationChildRequest.setSchoolingSchoolAddress(Address.xmlToModel(handicapCompensationChildRequestXml.getSchooling().getSchoolingSchoolAddress()));
      
        handicapCompensationChildRequest.setSchoolingTime(handicapCompensationChildRequestXml.getSchooling().getSchoolingTime());
      
        handicapCompensationChildRequest.setProfessionalSupportDealsWithSameProfessional(Boolean.valueOf(handicapCompensationChildRequestXml.getProfessionalSupport().getProfessionalSupportDealsWithSameProfessional()));
      
        handicapCompensationChildRequest.setAseReferentDepartment(handicapCompensationChildRequestXml.getAseReferent().getAseReferentDepartment());
      
        handicapCompensationChildRequest.setFoldersCotorepDepartment(handicapCompensationChildRequestXml.getFolders().getFoldersCotorepDepartment());
      
        handicapCompensationChildRequest.setDwellingEstablishmentReception(Boolean.valueOf(handicapCompensationChildRequestXml.getDwelling().getDwellingEstablishmentReception()));
      
        handicapCompensationChildRequest.setMotherFirstName(handicapCompensationChildRequestXml.getMother().getMotherFirstName());
      
        List<fr.cg95.cvq.business.request.social.HccrAdditionalFee> additionalFeeList = new ArrayList<fr.cg95.cvq.business.request.social.HccrAdditionalFee>(handicapCompensationChildRequestXml.sizeOfAdditionalFeeArray());
        for (HccrAdditionalFeeType object : handicapCompensationChildRequestXml.getAdditionalFeeArray()) {
            additionalFeeList.add(fr.cg95.cvq.business.request.social.HccrAdditionalFee.xmlToModel(object));
        }
        handicapCompensationChildRequest.setAdditionalFee(additionalFeeList);
      
        handicapCompensationChildRequest.setProjectRequestsOrdinaryWorking(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsOrdinaryWorking()));
      
        handicapCompensationChildRequest.setBenefitsDisabledWorkerRecognition(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsDisabledWorkerRecognition()));
      
        handicapCompensationChildRequest.setDwellingSocialReception(Boolean.valueOf(handicapCompensationChildRequestXml.getDwelling().getDwellingSocialReception()));
      
        handicapCompensationChildRequest.setProjectRequestsEuropeanParkingCard(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsEuropeanParkingCard()));
      
        handicapCompensationChildRequest.setHealthFollowedByDoctor(Boolean.valueOf(handicapCompensationChildRequestXml.getHealth().getHealthFollowedByDoctor()));
      
        List<fr.cg95.cvq.business.request.social.HccrFamilyAssistanceMember> familyAssistanceMembersList = new ArrayList<fr.cg95.cvq.business.request.social.HccrFamilyAssistanceMember>(handicapCompensationChildRequestXml.sizeOfFamilyAssistanceMembersArray());
        for (HccrFamilyAssistanceMemberType object : handicapCompensationChildRequestXml.getFamilyAssistanceMembersArray()) {
            familyAssistanceMembersList.add(fr.cg95.cvq.business.request.social.HccrFamilyAssistanceMember.xmlToModel(object));
        }
        handicapCompensationChildRequest.setFamilyAssistanceMembers(familyAssistanceMembersList);
      
        handicapCompensationChildRequest.setSchoolingHomeSchoolingAccompanistFirstName(handicapCompensationChildRequestXml.getSchooling().getSchoolingHomeSchoolingAccompanistFirstName());
      
        handicapCompensationChildRequest.setReferentBirthCity(handicapCompensationChildRequestXml.getReferent().getReferentBirthCity());
      
        handicapCompensationChildRequest.setProjectRequestsFreePensionMembership(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsFreePensionMembership()));
      
        handicapCompensationChildRequest.setSchoolingSpecializedGradeDetails(handicapCompensationChildRequestXml.getSchooling().getSchoolingSpecializedGradeDetails());
      
        handicapCompensationChildRequest.setReferentBirthCountry(handicapCompensationChildRequestXml.getReferent().getReferentBirthCountry());
      
        List<fr.cg95.cvq.business.request.social.HccrProfessional> professionalsList = new ArrayList<fr.cg95.cvq.business.request.social.HccrProfessional>(handicapCompensationChildRequestXml.sizeOfProfessionalsArray());
        for (HccrProfessionalType object : handicapCompensationChildRequestXml.getProfessionalsArray()) {
            professionalsList.add(fr.cg95.cvq.business.request.social.HccrProfessional.xmlToModel(object));
        }
        handicapCompensationChildRequest.setProfessionals(professionalsList);
      
        handicapCompensationChildRequest.setHealthFollowedByHospital(Boolean.valueOf(handicapCompensationChildRequestXml.getHealth().getHealthFollowedByHospital()));
      
        handicapCompensationChildRequest.setProfessionalStatusEmployerName(handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusEmployerName());
      
        handicapCompensationChildRequest.setProjectRequestsInstitutionSupport(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsInstitutionSupport()));
      
        handicapCompensationChildRequest.setBenefitsSocialWelfare(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsSocialWelfare()));
      
        handicapCompensationChildRequest.setProjectRequestsHandicapRecognition(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsHandicapRecognition()));
      
        List<fr.cg95.cvq.business.request.social.HccrCareService> careServicesList = new ArrayList<fr.cg95.cvq.business.request.social.HccrCareService>(handicapCompensationChildRequestXml.sizeOfCareServicesArray());
        for (HccrCareServiceType object : handicapCompensationChildRequestXml.getCareServicesArray()) {
            careServicesList.add(fr.cg95.cvq.business.request.social.HccrCareService.xmlToModel(object));
        }
        handicapCompensationChildRequest.setCareServices(careServicesList);
      
        handicapCompensationChildRequest.setSchoolingExtraCurricular(Boolean.valueOf(handicapCompensationChildRequestXml.getSchooling().getSchoolingExtraCurricular()));
      
        handicapCompensationChildRequest.setProjectWish(handicapCompensationChildRequestXml.getProjectWish());
      
        if (handicapCompensationChildRequestXml.getDwelling().getDwellingKind() != null)
            handicapCompensationChildRequest.setDwellingKind(fr.cg95.cvq.business.request.social.HccrDwellingKindType.forString(handicapCompensationChildRequestXml.getDwelling().getDwellingKind().toString()));
        else
            handicapCompensationChildRequest.setDwellingKind(fr.cg95.cvq.business.request.social.HccrDwellingKindType.getDefaultHccrDwellingKindType());
      
        handicapCompensationChildRequest.setHealthProfessionalLastName(handicapCompensationChildRequestXml.getHealth().getHealthProfessionalLastName());
      
        handicapCompensationChildRequest.setFormationStudiesLevel(handicapCompensationChildRequestXml.getFormation().getFormationStudiesLevel());
      
        handicapCompensationChildRequest.setProjectRequestsProfessionalOrientation(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsProfessionalOrientation()));
      
        handicapCompensationChildRequest.setHealthDoctorLastName(handicapCompensationChildRequestXml.getHealth().getHealthDoctorLastName());
      
        if (handicapCompensationChildRequestXml.getSocialService().getSocialServiceAddress() != null)
            handicapCompensationChildRequest.setSocialServiceAddress(Address.xmlToModel(handicapCompensationChildRequestXml.getSocialService().getSocialServiceAddress()));
      
        handicapCompensationChildRequest.setFacilitiesHousingDetails(handicapCompensationChildRequestXml.getFacilities().getFacilitiesHousingDetails());
      
        handicapCompensationChildRequest.setBenefitsSupplementForSingleParents(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsSupplementForSingleParents()));
      
        handicapCompensationChildRequest.setProjectRequestsIncreaseForIndependentLiving(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsIncreaseForIndependentLiving()));
      
        handicapCompensationChildRequest.setBenefitsThirdPartySupplement(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsThirdPartySupplement()));
      
        handicapCompensationChildRequest.setBenefitsDisabilityPensionCategory(handicapCompensationChildRequestXml.getBenefits().getBenefitsDisabilityPensionCategory());
      
        handicapCompensationChildRequest.setStudiesHighSchoolGrade(handicapCompensationChildRequestXml.getStudies().getStudiesHighSchoolGrade());
      
        handicapCompensationChildRequest.setReferentLastName(handicapCompensationChildRequestXml.getReferent().getReferentLastName());
      
        handicapCompensationChildRequest.setSubjectBirthCity(handicapCompensationChildRequestXml.getHccrSubject().getSubjectBirthCity());
      
        handicapCompensationChildRequest.setProjectRequestsAssistance(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsAssistance()));
      
        handicapCompensationChildRequest.setBenefitsSupportedByAnInstitution(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsSupportedByAnInstitution()));
      
        if (handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusEnvironment() != null)
            handicapCompensationChildRequest.setProfessionalStatusEnvironment(fr.cg95.cvq.business.request.social.HccrProfessionalStatusEnvironmentType.forString(handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusEnvironment().toString()));
        else
            handicapCompensationChildRequest.setProfessionalStatusEnvironment(fr.cg95.cvq.business.request.social.HccrProfessionalStatusEnvironmentType.getDefaultHccrProfessionalStatusEnvironmentType());
      
        handicapCompensationChildRequest.setProjectRequestsThirdPartyHelp(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsThirdPartyHelp()));
      
        handicapCompensationChildRequest.setProjectRequestsDisabledAdultAllowance(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsDisabledAdultAllowance()));
      
        handicapCompensationChildRequest.setFoldersOtherFolders(Boolean.valueOf(handicapCompensationChildRequestXml.getFolders().getFoldersOtherFolders()));
      
        if (handicapCompensationChildRequestXml.getPaymentAgency().getPaymentAgencyBeneficiary() != null)
            handicapCompensationChildRequest.setPaymentAgencyBeneficiary(fr.cg95.cvq.business.request.social.HccrPaymentAgencyBeneficiaryType.forString(handicapCompensationChildRequestXml.getPaymentAgency().getPaymentAgencyBeneficiary().toString()));
        else
            handicapCompensationChildRequest.setPaymentAgencyBeneficiary(fr.cg95.cvq.business.request.social.HccrPaymentAgencyBeneficiaryType.getDefaultHccrPaymentAgencyBeneficiaryType());
      
        handicapCompensationChildRequest.setFatherJob(handicapCompensationChildRequestXml.getFather().getFatherJob());
      
        handicapCompensationChildRequest.setFacilitiesAnimalAidDetails(handicapCompensationChildRequestXml.getFacilities().getFacilitiesAnimalAidDetails());
      
        List<fr.cg95.cvq.business.request.social.HccrOtherBenefit> otherBenefitsList = new ArrayList<fr.cg95.cvq.business.request.social.HccrOtherBenefit>(handicapCompensationChildRequestXml.sizeOfOtherBenefitsArray());
        for (HccrOtherBenefitType object : handicapCompensationChildRequestXml.getOtherBenefitsArray()) {
            otherBenefitsList.add(fr.cg95.cvq.business.request.social.HccrOtherBenefit.xmlToModel(object));
        }
        handicapCompensationChildRequest.setOtherBenefits(otherBenefitsList);
      
        handicapCompensationChildRequest.setStudiesAssistanceUnderDisabilityDetails(handicapCompensationChildRequestXml.getStudies().getStudiesAssistanceUnderDisabilityDetails());
      
        if (handicapCompensationChildRequestXml.getPaymentAgency().getPaymentAgencyAddress() != null)
            handicapCompensationChildRequest.setPaymentAgencyAddress(Address.xmlToModel(handicapCompensationChildRequestXml.getPaymentAgency().getPaymentAgencyAddress()));
      
        handicapCompensationChildRequest.setProjectRequestsOther(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsOther()));
      
        handicapCompensationChildRequest.setBenefitsThirdPersonCompensatoryAllowance(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsThirdPersonCompensatoryAllowance()));
      
        handicapCompensationChildRequest.setProjectRequestsDisabilityCostAllocation(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsDisabilityCostAllocation()));
      
        if (handicapCompensationChildRequestXml.getSocialSecurity().getSocialSecurityAgencyAddress() != null)
            handicapCompensationChildRequest.setSocialSecurityAgencyAddress(Address.xmlToModel(handicapCompensationChildRequestXml.getSocialSecurity().getSocialSecurityAgencyAddress()));
      
        if (handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusAddress() != null)
            handicapCompensationChildRequest.setProfessionalStatusAddress(Address.xmlToModel(handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusAddress()));
      
        handicapCompensationChildRequest.setProfessionalStatusProfession(handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusProfession());
      
        if (handicapCompensationChildRequestXml.getDwelling().getDwellingReceptionAddress() != null)
            handicapCompensationChildRequest.setDwellingReceptionAddress(Address.xmlToModel(handicapCompensationChildRequestXml.getDwelling().getDwellingReceptionAddress()));
      
        handicapCompensationChildRequest.setFormationDiploma(handicapCompensationChildRequestXml.getFormation().getFormationDiploma());
      
        handicapCompensationChildRequest.setMotherLastName(handicapCompensationChildRequestXml.getMother().getMotherLastName());
      
        handicapCompensationChildRequest.setFoldersCotorep(Boolean.valueOf(handicapCompensationChildRequestXml.getFolders().getFoldersCotorep()));
      
        handicapCompensationChildRequest.setProfessionalStatusElectiveFunction(Boolean.valueOf(handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusElectiveFunction()));
      
        handicapCompensationChildRequest.setBenefitsIncreaseForIndependentLiving(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsIncreaseForIndependentLiving()));
      
        handicapCompensationChildRequest.setSubjectBirthCountry(handicapCompensationChildRequestXml.getHccrSubject().getSubjectBirthCountry());
      
        handicapCompensationChildRequest.setFatherActivityReduction(Boolean.valueOf(handicapCompensationChildRequestXml.getFather().getFatherActivityReduction()));
      
        handicapCompensationChildRequest.setProjectRequestsDisabilityCard(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsDisabilityCard()));
      
        handicapCompensationChildRequest.setStudiesHighSchoolName(handicapCompensationChildRequestXml.getStudies().getStudiesHighSchoolName());
      
        if (handicapCompensationChildRequestXml.getDwelling().getDwellingReceptionType() != null)
            handicapCompensationChildRequest.setDwellingReceptionType(fr.cg95.cvq.business.request.social.HccrDwellingReceptionKindType.forString(handicapCompensationChildRequestXml.getDwelling().getDwellingReceptionType().toString()));
        else
            handicapCompensationChildRequest.setDwellingReceptionType(fr.cg95.cvq.business.request.social.HccrDwellingReceptionKindType.getDefaultHccrDwellingReceptionKindType());
      
        handicapCompensationChildRequest.setFatherLastName(handicapCompensationChildRequestXml.getFather().getFatherLastName());
      
        handicapCompensationChildRequest.setMotherActivityReductionRatio(handicapCompensationChildRequestXml.getMother().getMotherActivityReductionRatio());
      
        calendar = handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusRegisterAsUnemployedDate();
        if (calendar != null) {
            handicapCompensationChildRequest.setProfessionalStatusRegisterAsUnemployedDate(calendar.getTime());
        }
      
        handicapCompensationChildRequest.setPaymentAgencyName(handicapCompensationChildRequestXml.getPaymentAgency().getPaymentAgencyName());
      
        handicapCompensationChildRequest.setSocialSecurityAgencyName(handicapCompensationChildRequestXml.getSocialSecurity().getSocialSecurityAgencyName());
      
        handicapCompensationChildRequest.setDwellingReceptionNaming(handicapCompensationChildRequestXml.getDwelling().getDwellingReceptionNaming());
      
        handicapCompensationChildRequest.setSchoolingSendToSchool(Boolean.valueOf(handicapCompensationChildRequestXml.getSchooling().getSchoolingSendToSchool()));
      
        handicapCompensationChildRequest.setBenefitsEducationOfDisabledChildren(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsEducationOfDisabledChildren()));
      
        handicapCompensationChildRequest.setReferentFirstName(handicapCompensationChildRequestXml.getReferent().getReferentFirstName());
      
        handicapCompensationChildRequest.setFacilitiesTechnicalAssistanceDetails(handicapCompensationChildRequestXml.getFacilities().getFacilitiesTechnicalAssistanceDetails());
      
        handicapCompensationChildRequest.setBenefitsOtherBenefits(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsOtherBenefits()));
      
        handicapCompensationChildRequest.setFoldersCdesNumber(handicapCompensationChildRequestXml.getFolders().getFoldersCdesNumber());
      
        handicapCompensationChildRequest.setSocialServiceName(handicapCompensationChildRequestXml.getSocialService().getSocialServiceName());
      
        handicapCompensationChildRequest.setBenefitsDisabilityCompensation(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsDisabilityCompensation()));
      
        handicapCompensationChildRequest.setHealthDoctorFirstName(handicapCompensationChildRequestXml.getHealth().getHealthDoctorFirstName());
      
        handicapCompensationChildRequest.setProjectRequestsTechnicalHelp(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsTechnicalHelp()));
      
        handicapCompensationChildRequest.setFacilitiesTechnicalAssistance(Boolean.valueOf(handicapCompensationChildRequestXml.getFacilities().getFacilitiesTechnicalAssistance()));
      
        handicapCompensationChildRequest.setBenefitsCompensatoryAllowanceForExpenses(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsCompensatoryAllowanceForExpenses()));
      
        handicapCompensationChildRequest.setFacilitiesHousing(Boolean.valueOf(handicapCompensationChildRequestXml.getFacilities().getFacilitiesHousing()));
      
        handicapCompensationChildRequest.setHealthHospitalName(handicapCompensationChildRequestXml.getHealth().getHealthHospitalName());
      
        handicapCompensationChildRequest.setProjectRequestsDisabledPriorityCard(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsDisabledPriorityCard()));
      
        handicapCompensationChildRequest.setProjectRequestsEducationAllocationOfDisabledChildren(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsEducationAllocationOfDisabledChildren()));
      
        handicapCompensationChildRequest.setProjectRequestsOtherDetails(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsOtherDetails());
      
        handicapCompensationChildRequest.setSocialServiceSupport(Boolean.valueOf(handicapCompensationChildRequestXml.getSocialService().getSocialServiceSupport()));
      
        handicapCompensationChildRequest.setProjectRequestsShelteredWork(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsShelteredWork()));
      
        handicapCompensationChildRequest.setFormationCurrentFormation(handicapCompensationChildRequestXml.getFormation().getFormationCurrentFormation());
      
        if (handicapCompensationChildRequestXml.getSchooling().getSchoolingSchoolingKind() != null)
            handicapCompensationChildRequest.setSchoolingSchoolingKind(fr.cg95.cvq.business.request.social.HccrSchoolingKindType.forString(handicapCompensationChildRequestXml.getSchooling().getSchoolingSchoolingKind().toString()));
        else
            handicapCompensationChildRequest.setSchoolingSchoolingKind(fr.cg95.cvq.business.request.social.HccrSchoolingKindType.getDefaultHccrSchoolingKindType());
      
        handicapCompensationChildRequest.setStudiesAssistanceUnderDisability(Boolean.valueOf(handicapCompensationChildRequestXml.getStudies().getStudiesAssistanceUnderDisability()));
      
        handicapCompensationChildRequest.setStudiesHighSchool(Boolean.valueOf(handicapCompensationChildRequestXml.getStudies().getStudiesHighSchool()));
      
        handicapCompensationChildRequest.setHealthProfessionalFirstName(handicapCompensationChildRequestXml.getHealth().getHealthProfessionalFirstName());
      
        handicapCompensationChildRequest.setMotherActivityReduction(Boolean.valueOf(handicapCompensationChildRequestXml.getMother().getMotherActivityReduction()));
      
        handicapCompensationChildRequest.setFacilitiesCustomCarDetails(handicapCompensationChildRequestXml.getFacilities().getFacilitiesCustomCarDetails());
      
        handicapCompensationChildRequest.setSchoolingPersonalizedSchoolingPlan(Boolean.valueOf(handicapCompensationChildRequestXml.getSchooling().getSchoolingPersonalizedSchoolingPlan()));
      
        handicapCompensationChildRequest.setDwellingPrecision(handicapCompensationChildRequestXml.getDwelling().getDwellingPrecision());
      
        handicapCompensationChildRequest.setBenefitsDisabilityCard(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsDisabilityCard()));
      
        if (handicapCompensationChildRequestXml.getSocialSecurity().getSocialSecurityMemberShipKind() != null)
            handicapCompensationChildRequest.setSocialSecurityMemberShipKind(fr.cg95.cvq.business.request.social.HccrSocialSecurityMemberShipKindType.forString(handicapCompensationChildRequestXml.getSocialSecurity().getSocialSecurityMemberShipKind().toString()));
        else
            handicapCompensationChildRequest.setSocialSecurityMemberShipKind(fr.cg95.cvq.business.request.social.HccrSocialSecurityMemberShipKindType.getDefaultHccrSocialSecurityMemberShipKindType());
      
        handicapCompensationChildRequest.setAseReferentLastName(handicapCompensationChildRequestXml.getAseReferent().getAseReferentLastName());
      
        handicapCompensationChildRequest.setProfessionalStatusElectiveFunctionDetails(handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusElectiveFunctionDetails());
      
        handicapCompensationChildRequest.setFacilitiesAnimalAid(Boolean.valueOf(handicapCompensationChildRequestXml.getFacilities().getFacilitiesAnimalAid()));
      
        if (handicapCompensationChildRequestXml.getStudies().getStudiesHighSchoolAddress() != null)
            handicapCompensationChildRequest.setStudiesHighSchoolAddress(Address.xmlToModel(handicapCompensationChildRequestXml.getStudies().getStudiesHighSchoolAddress()));
      
        return handicapCompensationChildRequest;
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
