
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
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 * Generated class file, do not edit !
 */
public class HandicapCompensationChildRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    private HandicapCompensationChildRequestData handicapCompensationChildRequestData;

    public HandicapCompensationChildRequest(RequestData requestData, HandicapCompensationChildRequestData handicapCompensationChildRequestData) {
        super(requestData);
        this.handicapCompensationChildRequestData = handicapCompensationChildRequestData;
    }

    public HandicapCompensationChildRequest() {
        super();
        this.handicapCompensationChildRequestData = new HandicapCompensationChildRequestData();
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public HandicapCompensationChildRequestData getSpecificData() {
        return handicapCompensationChildRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(HandicapCompensationChildRequestData handicapCompensationChildRequestData) {
        this.handicapCompensationChildRequestData = handicapCompensationChildRequestData;
    }

    @Override
    public final String modelToXmlString() {
        HandicapCompensationChildRequestDocument object = this.modelToXml();
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
        if (getHealthFollowedByProfessional() != null)
            hccrHealthTypeHealth.setHealthFollowedByProfessional(getHealthFollowedByProfessional().booleanValue());
        HccrProfessionalSupportType hccrProfessionalSupportTypeProfessionalSupport = handicapCompensationChildRequest.addNewProfessionalSupport();
        if (getProfessionalSupportProfessionals() != null)
            hccrProfessionalSupportTypeProfessionalSupport.setProfessionalSupportProfessionals(getProfessionalSupportProfessionals().booleanValue());
        HccrReferent hccrReferentReferent = handicapCompensationChildRequest.addNewReferent();
        if (getReferentFamilyDependents() != null)
            hccrReferentReferent.setReferentFamilyDependents(getReferentFamilyDependents().booleanValue());
        HccrFamilyAssistanceType hccrFamilyAssistanceTypeFamilyAssistance = handicapCompensationChildRequest.addNewFamilyAssistance();
        if (getIsFamilyAssistance() != null)
            hccrFamilyAssistanceTypeFamilyAssistance.setIsFamilyAssistance(getIsFamilyAssistance().booleanValue());
        HccrSchoolingType hccrSchoolingTypeSchooling = handicapCompensationChildRequest.addNewSchooling();
        if (getSchoolingAttendedGrade() != null)
            hccrSchoolingTypeSchooling.setSchoolingAttendedGrade(fr.cg95.cvq.xml.common.SectionType.Enum.forString(getSchoolingAttendedGrade().toString()));
      
        i = 0;
        if (getFamilyDependents() != null) {
            fr.cg95.cvq.xml.request.social.HccrFamilyDependentType[] familyDependentsTypeTab = new fr.cg95.cvq.xml.request.social.HccrFamilyDependentType[getFamilyDependents().size()];
            for (HccrFamilyDependent object : getFamilyDependents()) {
              familyDependentsTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationChildRequest.setFamilyDependentsArray(familyDependentsTypeTab);
        }
      
        if (getReferentTitle() != null)
            hccrReferentReferent.setReferentTitle(fr.cg95.cvq.xml.common.TitleType.Enum.forString(getReferentTitle().toString()));
      
        handicapCompensationChildRequest.setProjectComments(getProjectComments());
        HccrFoldersType hccrFoldersTypeFolders = handicapCompensationChildRequest.addNewFolders();
        if (getFoldersCdes() != null)
            hccrFoldersTypeFolders.setFoldersCdes(getFoldersCdes().booleanValue());
      
        hccrFoldersTypeFolders.setFoldersMdphDepartment(getFoldersMdphDepartment());
      
        handicapCompensationChildRequest.setProjectNeeds(getProjectNeeds());
        HccrHomeInterventionType hccrHomeInterventionTypeHomeIntervention = handicapCompensationChildRequest.addNewHomeIntervention();
        if (getHomeInterventionHomeIntervenant() != null)
            hccrHomeInterventionTypeHomeIntervention.setHomeInterventionHomeIntervenant(getHomeInterventionHomeIntervenant().booleanValue());
        HccrBenefitsType hccrBenefitsTypeBenefits = handicapCompensationChildRequest.addNewBenefits();
        if (getBenefitsEducationAllocationOfDisabledChildren() != null)
            hccrBenefitsTypeBenefits.setBenefitsEducationAllocationOfDisabledChildren(getBenefitsEducationAllocationOfDisabledChildren().booleanValue());
      
        i = 0;
        if (getOtherFolders() != null) {
            fr.cg95.cvq.xml.request.social.HccrOtherFolderType[] otherFoldersTypeTab = new fr.cg95.cvq.xml.request.social.HccrOtherFolderType[getOtherFolders().size()];
            for (HccrOtherFolder object : getOtherFolders()) {
              otherFoldersTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationChildRequest.setOtherFoldersArray(otherFoldersTypeTab);
        }
      
        hccrFoldersTypeFolders.setFoldersMdphNumber(getFoldersMdphNumber());
        HccrSubjectType hccrSubjectTypeHccrSubject = handicapCompensationChildRequest.addNewHccrSubject();
        if (getSubjectParentalAuthorityHolder() != null)
            hccrSubjectTypeHccrSubject.setSubjectParentalAuthorityHolder(fr.cg95.cvq.xml.request.social.HccrSubjectParentalAuthorityHolderType.Enum.forString(getSubjectParentalAuthorityHolder().toString()));
        HccrProjectRequestsType hccrProjectRequestsTypeProjectRequests = handicapCompensationChildRequest.addNewProjectRequests();
        if (getProjectRequestsHousingFacilities() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsHousingFacilities(getProjectRequestsHousingFacilities().booleanValue());
      
        if (getSchoolingHomeSchooling() != null)
            hccrSchoolingTypeSchooling.setSchoolingHomeSchooling(getSchoolingHomeSchooling().booleanValue());
        HccrFather hccrFatherFather = handicapCompensationChildRequest.addNewFather();
        if (getFatherActivityReductionRatio() != null)
            hccrFatherFather.setFatherActivityReductionRatio(new BigInteger(getFatherActivityReductionRatio().toString()));
      
        date = getSubjectBirthDate();
        if (date != null) {
            calendar.setTime(date);
            hccrSubjectTypeHccrSubject.setSubjectBirthDate(calendar);
        }
      
        hccrSchoolingTypeSchooling.setSchoolingExtraCurricularDetails(getSchoolingExtraCurricularDetails());
      
        if (getSchoolingSpecializedGrade() != null)
            hccrSchoolingTypeSchooling.setSchoolingSpecializedGrade(getSchoolingSpecializedGrade().booleanValue());
      
        if (getBenefitsDisabilityPension() != null)
            hccrBenefitsTypeBenefits.setBenefitsDisabilityPension(getBenefitsDisabilityPension().booleanValue());
      
        hccrReferentReferent.setReferentMaidenName(getReferentMaidenName());
      
        if (getProjectRequestsDisabledWorkerRecognition() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsDisabledWorkerRecognition(getProjectRequestsDisabledWorkerRecognition().booleanValue());
      
        if (getBenefitsUnemploymentBenefits() != null)
            hccrBenefitsTypeBenefits.setBenefitsUnemploymentBenefits(getBenefitsUnemploymentBenefits().booleanValue());
      
        i = 0;
        if (getHomeIntervenants() != null) {
            fr.cg95.cvq.xml.request.social.HccrHomeIntervenantType[] homeIntervenantsTypeTab = new fr.cg95.cvq.xml.request.social.HccrHomeIntervenantType[getHomeIntervenants().size()];
            for (HccrHomeIntervenant object : getHomeIntervenants()) {
              homeIntervenantsTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationChildRequest.setHomeIntervenantsArray(homeIntervenantsTypeTab);
        }
        HccrProfessionalStatusType hccrProfessionalStatusTypeProfessionalStatus = handicapCompensationChildRequest.addNewProfessionalStatus();
        if (getProfessionalStatusKind() != null)
            hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusKind(fr.cg95.cvq.xml.request.social.HccrProfessionalStatusKindType.Enum.forString(getProfessionalStatusKind().toString()));
      
        if (getSchoolingHomeSchoolingKind() != null)
            hccrSchoolingTypeSchooling.setSchoolingHomeSchoolingKind(fr.cg95.cvq.xml.request.social.HccrHomeSchoolingKindType.Enum.forString(getSchoolingHomeSchoolingKind().toString()));
      
        hccrBenefitsTypeBenefits.setBenefitsEducationOfDisabledChildrenDetails(getBenefitsEducationOfDisabledChildrenDetails());
        HccrFormationType hccrFormationTypeFormation = handicapCompensationChildRequest.addNewFormation();
        hccrFormationTypeFormation.setFormationPreviousFormation(getFormationPreviousFormation());
      
        if (getProjectRequestsVocationalTraining() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsVocationalTraining(getProjectRequestsVocationalTraining().booleanValue());
        HccrFacilitiesType hccrFacilitiesTypeFacilities = handicapCompensationChildRequest.addNewFacilities();
        if (getFacilitiesCustomCar() != null)
            hccrFacilitiesTypeFacilities.setFacilitiesCustomCar(getFacilitiesCustomCar().booleanValue());
      
        if (getBenefitsDisabledAdultAllocation() != null)
            hccrBenefitsTypeBenefits.setBenefitsDisabledAdultAllocation(getBenefitsDisabledAdultAllocation().booleanValue());
      
        if (getProfessionalStatusIndemnified() != null)
            hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusIndemnified(getProfessionalStatusIndemnified().booleanValue());
      
        if (getSchoolingEnrolment() != null)
            hccrSchoolingTypeSchooling.setSchoolingEnrolment(getSchoolingEnrolment().booleanValue());
      
        if (getBenefitsThirdPartyCompensatoryAllowance() != null)
            hccrBenefitsTypeBenefits.setBenefitsThirdPartyCompensatoryAllowance(getBenefitsThirdPartyCompensatoryAllowance().booleanValue());
      
        date = getReferentBirthDate();
        if (date != null) {
            calendar.setTime(date);
            hccrReferentReferent.setReferentBirthDate(calendar);
        }
      
        date = getProfessionalStatusDate();
        if (date != null) {
            calendar.setTime(date);
            hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusDate(calendar);
        }
      
        if (getProjectRequestsTransportCostAllocation() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsTransportCostAllocation(getProjectRequestsTransportCostAllocation().booleanValue());
      
        if (getBenefitsProfessionalOrientation() != null)
            hccrBenefitsTypeBenefits.setBenefitsProfessionalOrientation(getBenefitsProfessionalOrientation().booleanValue());
      
        hccrSchoolingTypeSchooling.setSchoolingHomeSchoolingAccompanistLastName(getSchoolingHomeSchoolingAccompanistLastName());
      
        if (getBenefitsDisabilityRecognition() != null)
            hccrBenefitsTypeBenefits.setBenefitsDisabilityRecognition(getBenefitsDisabilityRecognition().booleanValue());
      
        if (getProfessionalStatusRegisterAsUnemployed() != null)
            hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusRegisterAsUnemployed(getProfessionalStatusRegisterAsUnemployed().booleanValue());
      
        date = getProfessionalStatusIndemnifiedDate();
        if (date != null) {
            calendar.setTime(date);
            hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusIndemnifiedDate(calendar);
        }
        HccrDwellingType hccrDwellingTypeDwelling = handicapCompensationChildRequest.addNewDwelling();
        hccrDwellingTypeDwelling.setDwellingSocialReceptionNaming(getDwellingSocialReceptionNaming());
      
        hccrBenefitsTypeBenefits.setBenefitsProfessionalOrientationDetails(getBenefitsProfessionalOrientationDetails());
      
        if (getBenefitsPainfulStandingCard() != null)
            hccrBenefitsTypeBenefits.setBenefitsPainfulStandingCard(getBenefitsPainfulStandingCard().booleanValue());
      
        hccrFoldersTypeFolders.setFoldersCdesDepartment(getFoldersCdesDepartment());
      
        if (getFacilitiesSpecializedTransport() != null)
            hccrFacilitiesTypeFacilities.setFacilitiesSpecializedTransport(getFacilitiesSpecializedTransport().booleanValue());
      
        if (getBenefitsParkingCard() != null)
            hccrBenefitsTypeBenefits.setBenefitsParkingCard(getBenefitsParkingCard().booleanValue());
      
        hccrFacilitiesTypeFacilities.setFacilitiesSpecializedTransportDetails(getFacilitiesSpecializedTransportDetails());
      
        hccrBenefitsTypeBenefits.setBenefitsWorkAccidentAnnuityRatio(getBenefitsWorkAccidentAnnuityRatio());
        HccrSocialSecurityType hccrSocialSecurityTypeSocialSecurity = handicapCompensationChildRequest.addNewSocialSecurity();
        hccrSocialSecurityTypeSocialSecurity.setSocialSecurityNumber(getSocialSecurityNumber());
      
        if (getBenefitsWorkAccidentAnnuity() != null)
            hccrBenefitsTypeBenefits.setBenefitsWorkAccidentAnnuity(getBenefitsWorkAccidentAnnuity().booleanValue());
        HccrCareType hccrCareTypeCare = handicapCompensationChildRequest.addNewCare();
        if (getCareCareServices() != null)
            hccrCareTypeCare.setCareCareServices(getCareCareServices().booleanValue());
      
        if (getBenefitsDailyAllowances() != null)
            hccrBenefitsTypeBenefits.setBenefitsDailyAllowances(getBenefitsDailyAllowances().booleanValue());
      
        hccrBenefitsTypeBenefits.setBenefitsDisabilityRatio(getBenefitsDisabilityRatio());
      
        hccrFatherFather.setFatherFirstName(getFatherFirstName());
      
        if (getSchoolingHomeSchoolingAccompanistAddress() != null)
            hccrSchoolingTypeSchooling.setSchoolingHomeSchoolingAccompanistAddress(Address.modelToXml(getSchoolingHomeSchoolingAccompanistAddress()));
      
        if (getProjectRequestsCustomCar() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsCustomCar(getProjectRequestsCustomCar().booleanValue());
        HccrPaymentAgencyType hccrPaymentAgencyTypePaymentAgency = handicapCompensationChildRequest.addNewPaymentAgency();
        hccrPaymentAgencyTypePaymentAgency.setPaymentAgencyBeneficiaryNumber(getPaymentAgencyBeneficiaryNumber());
      
        hccrFoldersTypeFolders.setFoldersCotorepNumber(getFoldersCotorepNumber());
      
        if (getProjectRequestsACTPRenewal() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsACTPRenewal(getProjectRequestsACTPRenewal().booleanValue());
      
        if (getReferentFamilyStatus() != null)
            hccrReferentReferent.setReferentFamilyStatus(fr.cg95.cvq.xml.common.FamilyStatusType.Enum.forString(getReferentFamilyStatus().toString()));
      
        hccrSchoolingTypeSchooling.setSchoolingSchoolName(getSchoolingSchoolName());
      
        if (getDwellingSocialReceptionAddress() != null)
            hccrDwellingTypeDwelling.setDwellingSocialReceptionAddress(Address.modelToXml(getDwellingSocialReceptionAddress()));
      
        hccrBenefitsTypeBenefits.setBenefitsSupportedByAnInstitutionDetails(getBenefitsSupportedByAnInstitutionDetails());
      
        if (getFoldersMdph() != null)
            hccrFoldersTypeFolders.setFoldersMdph(getFoldersMdph().booleanValue());
        HccrMother hccrMotherMother = handicapCompensationChildRequest.addNewMother();
        hccrMotherMother.setMotherJob(getMotherJob());
      
        if (getSchoolingSchoolAddress() != null)
            hccrSchoolingTypeSchooling.setSchoolingSchoolAddress(Address.modelToXml(getSchoolingSchoolAddress()));
      
        hccrSchoolingTypeSchooling.setSchoolingTime(getSchoolingTime());
      
        if (getProfessionalSupportDealsWithSameProfessional() != null)
            hccrProfessionalSupportTypeProfessionalSupport.setProfessionalSupportDealsWithSameProfessional(getProfessionalSupportDealsWithSameProfessional().booleanValue());
        HccrAseReferent hccrAseReferentAseReferent = handicapCompensationChildRequest.addNewAseReferent();
        hccrAseReferentAseReferent.setAseReferentDepartment(getAseReferentDepartment());
      
        hccrFoldersTypeFolders.setFoldersCotorepDepartment(getFoldersCotorepDepartment());
      
        if (getDwellingEstablishmentReception() != null)
            hccrDwellingTypeDwelling.setDwellingEstablishmentReception(getDwellingEstablishmentReception().booleanValue());
      
        hccrMotherMother.setMotherFirstName(getMotherFirstName());
      
        i = 0;
        if (getAdditionalFee() != null) {
            fr.cg95.cvq.xml.request.social.HccrAdditionalFeeType[] additionalFeeTypeTab = new fr.cg95.cvq.xml.request.social.HccrAdditionalFeeType[getAdditionalFee().size()];
            for (HccrAdditionalFee object : getAdditionalFee()) {
              additionalFeeTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationChildRequest.setAdditionalFeeArray(additionalFeeTypeTab);
        }
      
        if (getProjectRequestsOrdinaryWorking() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsOrdinaryWorking(getProjectRequestsOrdinaryWorking().booleanValue());
      
        if (getBenefitsDisabledWorkerRecognition() != null)
            hccrBenefitsTypeBenefits.setBenefitsDisabledWorkerRecognition(getBenefitsDisabledWorkerRecognition().booleanValue());
      
        if (getDwellingSocialReception() != null)
            hccrDwellingTypeDwelling.setDwellingSocialReception(getDwellingSocialReception().booleanValue());
      
        if (getProjectRequestsEuropeanParkingCard() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsEuropeanParkingCard(getProjectRequestsEuropeanParkingCard().booleanValue());
      
        if (getHealthFollowedByDoctor() != null)
            hccrHealthTypeHealth.setHealthFollowedByDoctor(getHealthFollowedByDoctor().booleanValue());
      
        i = 0;
        if (getFamilyAssistanceMembers() != null) {
            fr.cg95.cvq.xml.request.social.HccrFamilyAssistanceMemberType[] familyAssistanceMembersTypeTab = new fr.cg95.cvq.xml.request.social.HccrFamilyAssistanceMemberType[getFamilyAssistanceMembers().size()];
            for (HccrFamilyAssistanceMember object : getFamilyAssistanceMembers()) {
              familyAssistanceMembersTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationChildRequest.setFamilyAssistanceMembersArray(familyAssistanceMembersTypeTab);
        }
      
        hccrSchoolingTypeSchooling.setSchoolingHomeSchoolingAccompanistFirstName(getSchoolingHomeSchoolingAccompanistFirstName());
      
        hccrReferentReferent.setReferentBirthCity(getReferentBirthCity());
      
        if (getProjectRequestsFreePensionMembership() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsFreePensionMembership(getProjectRequestsFreePensionMembership().booleanValue());
      
        hccrSchoolingTypeSchooling.setSchoolingSpecializedGradeDetails(getSchoolingSpecializedGradeDetails());
      
        hccrReferentReferent.setReferentBirthCountry(getReferentBirthCountry());
      
        i = 0;
        if (getProfessionals() != null) {
            fr.cg95.cvq.xml.request.social.HccrProfessionalType[] professionalsTypeTab = new fr.cg95.cvq.xml.request.social.HccrProfessionalType[getProfessionals().size()];
            for (HccrProfessional object : getProfessionals()) {
              professionalsTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationChildRequest.setProfessionalsArray(professionalsTypeTab);
        }
      
        if (getHealthFollowedByHospital() != null)
            hccrHealthTypeHealth.setHealthFollowedByHospital(getHealthFollowedByHospital().booleanValue());
      
        hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusEmployerName(getProfessionalStatusEmployerName());
      
        if (getProjectRequestsInstitutionSupport() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsInstitutionSupport(getProjectRequestsInstitutionSupport().booleanValue());
      
        if (getBenefitsSocialWelfare() != null)
            hccrBenefitsTypeBenefits.setBenefitsSocialWelfare(getBenefitsSocialWelfare().booleanValue());
      
        if (getProjectRequestsHandicapRecognition() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsHandicapRecognition(getProjectRequestsHandicapRecognition().booleanValue());
      
        i = 0;
        if (getCareServices() != null) {
            fr.cg95.cvq.xml.request.social.HccrCareServiceType[] careServicesTypeTab = new fr.cg95.cvq.xml.request.social.HccrCareServiceType[getCareServices().size()];
            for (HccrCareService object : getCareServices()) {
              careServicesTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationChildRequest.setCareServicesArray(careServicesTypeTab);
        }
      
        if (getSchoolingExtraCurricular() != null)
            hccrSchoolingTypeSchooling.setSchoolingExtraCurricular(getSchoolingExtraCurricular().booleanValue());
      
        handicapCompensationChildRequest.setProjectWish(getProjectWish());
      
        if (getDwellingKind() != null)
            hccrDwellingTypeDwelling.setDwellingKind(fr.cg95.cvq.xml.request.social.HccrDwellingKindType.Enum.forString(getDwellingKind().toString()));
      
        hccrHealthTypeHealth.setHealthProfessionalLastName(getHealthProfessionalLastName());
      
        hccrFormationTypeFormation.setFormationStudiesLevel(getFormationStudiesLevel());
      
        if (getProjectRequestsProfessionalOrientation() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsProfessionalOrientation(getProjectRequestsProfessionalOrientation().booleanValue());
      
        hccrHealthTypeHealth.setHealthDoctorLastName(getHealthDoctorLastName());
        HccrSocialServiceType hccrSocialServiceTypeSocialService = handicapCompensationChildRequest.addNewSocialService();
        if (getSocialServiceAddress() != null)
            hccrSocialServiceTypeSocialService.setSocialServiceAddress(Address.modelToXml(getSocialServiceAddress()));
      
        hccrFacilitiesTypeFacilities.setFacilitiesHousingDetails(getFacilitiesHousingDetails());
      
        if (getBenefitsSupplementForSingleParents() != null)
            hccrBenefitsTypeBenefits.setBenefitsSupplementForSingleParents(getBenefitsSupplementForSingleParents().booleanValue());
      
        if (getProjectRequestsIncreaseForIndependentLiving() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsIncreaseForIndependentLiving(getProjectRequestsIncreaseForIndependentLiving().booleanValue());
      
        if (getBenefitsThirdPartySupplement() != null)
            hccrBenefitsTypeBenefits.setBenefitsThirdPartySupplement(getBenefitsThirdPartySupplement().booleanValue());
      
        hccrBenefitsTypeBenefits.setBenefitsDisabilityPensionCategory(getBenefitsDisabilityPensionCategory());
        HccrStudiesType hccrStudiesTypeStudies = handicapCompensationChildRequest.addNewStudies();
        hccrStudiesTypeStudies.setStudiesHighSchoolGrade(getStudiesHighSchoolGrade());
      
        hccrReferentReferent.setReferentLastName(getReferentLastName());
      
        hccrSubjectTypeHccrSubject.setSubjectBirthCity(getSubjectBirthCity());
      
        if (getProjectRequestsAssistance() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsAssistance(getProjectRequestsAssistance().booleanValue());
      
        if (getBenefitsSupportedByAnInstitution() != null)
            hccrBenefitsTypeBenefits.setBenefitsSupportedByAnInstitution(getBenefitsSupportedByAnInstitution().booleanValue());
      
        if (getProfessionalStatusEnvironment() != null)
            hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusEnvironment(fr.cg95.cvq.xml.request.social.HccrProfessionalStatusEnvironmentType.Enum.forString(getProfessionalStatusEnvironment().toString()));
      
        if (getProjectRequestsThirdPartyHelp() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsThirdPartyHelp(getProjectRequestsThirdPartyHelp().booleanValue());
      
        if (getProjectRequestsDisabledAdultAllowance() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsDisabledAdultAllowance(getProjectRequestsDisabledAdultAllowance().booleanValue());
      
        if (getFoldersOtherFolders() != null)
            hccrFoldersTypeFolders.setFoldersOtherFolders(getFoldersOtherFolders().booleanValue());
      
        if (getPaymentAgencyBeneficiary() != null)
            hccrPaymentAgencyTypePaymentAgency.setPaymentAgencyBeneficiary(fr.cg95.cvq.xml.request.social.HccrPaymentAgencyBeneficiaryType.Enum.forString(getPaymentAgencyBeneficiary().toString()));
      
        hccrFatherFather.setFatherJob(getFatherJob());
      
        hccrFacilitiesTypeFacilities.setFacilitiesAnimalAidDetails(getFacilitiesAnimalAidDetails());
      
        i = 0;
        if (getOtherBenefits() != null) {
            fr.cg95.cvq.xml.request.social.HccrOtherBenefitType[] otherBenefitsTypeTab = new fr.cg95.cvq.xml.request.social.HccrOtherBenefitType[getOtherBenefits().size()];
            for (HccrOtherBenefit object : getOtherBenefits()) {
              otherBenefitsTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationChildRequest.setOtherBenefitsArray(otherBenefitsTypeTab);
        }
      
        hccrStudiesTypeStudies.setStudiesAssistanceUnderDisabilityDetails(getStudiesAssistanceUnderDisabilityDetails());
      
        if (getPaymentAgencyAddress() != null)
            hccrPaymentAgencyTypePaymentAgency.setPaymentAgencyAddress(Address.modelToXml(getPaymentAgencyAddress()));
      
        if (getProjectRequestsOther() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsOther(getProjectRequestsOther().booleanValue());
      
        if (getBenefitsThirdPersonCompensatoryAllowance() != null)
            hccrBenefitsTypeBenefits.setBenefitsThirdPersonCompensatoryAllowance(getBenefitsThirdPersonCompensatoryAllowance().booleanValue());
      
        if (getProjectRequestsDisabilityCostAllocation() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsDisabilityCostAllocation(getProjectRequestsDisabilityCostAllocation().booleanValue());
      
        if (getSocialSecurityAgencyAddress() != null)
            hccrSocialSecurityTypeSocialSecurity.setSocialSecurityAgencyAddress(Address.modelToXml(getSocialSecurityAgencyAddress()));
      
        if (getProfessionalStatusAddress() != null)
            hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusAddress(Address.modelToXml(getProfessionalStatusAddress()));
      
        hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusProfession(getProfessionalStatusProfession());
      
        if (getDwellingReceptionAddress() != null)
            hccrDwellingTypeDwelling.setDwellingReceptionAddress(Address.modelToXml(getDwellingReceptionAddress()));
      
        hccrFormationTypeFormation.setFormationDiploma(getFormationDiploma());
      
        hccrMotherMother.setMotherLastName(getMotherLastName());
      
        if (getFoldersCotorep() != null)
            hccrFoldersTypeFolders.setFoldersCotorep(getFoldersCotorep().booleanValue());
      
        if (getProfessionalStatusElectiveFunction() != null)
            hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusElectiveFunction(getProfessionalStatusElectiveFunction().booleanValue());
      
        if (getBenefitsIncreaseForIndependentLiving() != null)
            hccrBenefitsTypeBenefits.setBenefitsIncreaseForIndependentLiving(getBenefitsIncreaseForIndependentLiving().booleanValue());
      
        hccrSubjectTypeHccrSubject.setSubjectBirthCountry(getSubjectBirthCountry());
      
        if (getFatherActivityReduction() != null)
            hccrFatherFather.setFatherActivityReduction(getFatherActivityReduction().booleanValue());
      
        if (getProjectRequestsDisabilityCard() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsDisabilityCard(getProjectRequestsDisabilityCard().booleanValue());
      
        hccrStudiesTypeStudies.setStudiesHighSchoolName(getStudiesHighSchoolName());
      
        if (getDwellingReceptionType() != null)
            hccrDwellingTypeDwelling.setDwellingReceptionType(fr.cg95.cvq.xml.request.social.HccrDwellingReceptionKindType.Enum.forString(getDwellingReceptionType().toString()));
      
        hccrFatherFather.setFatherLastName(getFatherLastName());
      
        if (getMotherActivityReductionRatio() != null)
            hccrMotherMother.setMotherActivityReductionRatio(new BigInteger(getMotherActivityReductionRatio().toString()));
      
        date = getProfessionalStatusRegisterAsUnemployedDate();
        if (date != null) {
            calendar.setTime(date);
            hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusRegisterAsUnemployedDate(calendar);
        }
      
        hccrPaymentAgencyTypePaymentAgency.setPaymentAgencyName(getPaymentAgencyName());
      
        hccrSocialSecurityTypeSocialSecurity.setSocialSecurityAgencyName(getSocialSecurityAgencyName());
      
        hccrDwellingTypeDwelling.setDwellingReceptionNaming(getDwellingReceptionNaming());
      
        if (getSchoolingSendToSchool() != null)
            hccrSchoolingTypeSchooling.setSchoolingSendToSchool(getSchoolingSendToSchool().booleanValue());
      
        if (getBenefitsEducationOfDisabledChildren() != null)
            hccrBenefitsTypeBenefits.setBenefitsEducationOfDisabledChildren(getBenefitsEducationOfDisabledChildren().booleanValue());
      
        hccrReferentReferent.setReferentFirstName(getReferentFirstName());
      
        hccrFacilitiesTypeFacilities.setFacilitiesTechnicalAssistanceDetails(getFacilitiesTechnicalAssistanceDetails());
      
        if (getBenefitsOtherBenefits() != null)
            hccrBenefitsTypeBenefits.setBenefitsOtherBenefits(getBenefitsOtherBenefits().booleanValue());
      
        hccrFoldersTypeFolders.setFoldersCdesNumber(getFoldersCdesNumber());
      
        hccrSocialServiceTypeSocialService.setSocialServiceName(getSocialServiceName());
      
        if (getBenefitsDisabilityCompensation() != null)
            hccrBenefitsTypeBenefits.setBenefitsDisabilityCompensation(getBenefitsDisabilityCompensation().booleanValue());
      
        hccrHealthTypeHealth.setHealthDoctorFirstName(getHealthDoctorFirstName());
      
        if (getProjectRequestsTechnicalHelp() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsTechnicalHelp(getProjectRequestsTechnicalHelp().booleanValue());
      
        if (getFacilitiesTechnicalAssistance() != null)
            hccrFacilitiesTypeFacilities.setFacilitiesTechnicalAssistance(getFacilitiesTechnicalAssistance().booleanValue());
      
        if (getBenefitsCompensatoryAllowanceForExpenses() != null)
            hccrBenefitsTypeBenefits.setBenefitsCompensatoryAllowanceForExpenses(getBenefitsCompensatoryAllowanceForExpenses().booleanValue());
      
        if (getFacilitiesHousing() != null)
            hccrFacilitiesTypeFacilities.setFacilitiesHousing(getFacilitiesHousing().booleanValue());
      
        hccrHealthTypeHealth.setHealthHospitalName(getHealthHospitalName());
      
        if (getProjectRequestsDisabledPriorityCard() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsDisabledPriorityCard(getProjectRequestsDisabledPriorityCard().booleanValue());
      
        if (getProjectRequestsEducationAllocationOfDisabledChildren() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsEducationAllocationOfDisabledChildren(getProjectRequestsEducationAllocationOfDisabledChildren().booleanValue());
      
        hccrProjectRequestsTypeProjectRequests.setProjectRequestsOtherDetails(getProjectRequestsOtherDetails());
      
        if (getSocialServiceSupport() != null)
            hccrSocialServiceTypeSocialService.setSocialServiceSupport(getSocialServiceSupport().booleanValue());
      
        if (getProjectRequestsShelteredWork() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsShelteredWork(getProjectRequestsShelteredWork().booleanValue());
      
        hccrFormationTypeFormation.setFormationCurrentFormation(getFormationCurrentFormation());
      
        if (getSchoolingSchoolingKind() != null)
            hccrSchoolingTypeSchooling.setSchoolingSchoolingKind(fr.cg95.cvq.xml.request.social.HccrSchoolingKindType.Enum.forString(getSchoolingSchoolingKind().toString()));
      
        if (getStudiesAssistanceUnderDisability() != null)
            hccrStudiesTypeStudies.setStudiesAssistanceUnderDisability(getStudiesAssistanceUnderDisability().booleanValue());
      
        if (getStudiesHighSchool() != null)
            hccrStudiesTypeStudies.setStudiesHighSchool(getStudiesHighSchool().booleanValue());
      
        hccrHealthTypeHealth.setHealthProfessionalFirstName(getHealthProfessionalFirstName());
      
        if (getMotherActivityReduction() != null)
            hccrMotherMother.setMotherActivityReduction(getMotherActivityReduction().booleanValue());
      
        hccrFacilitiesTypeFacilities.setFacilitiesCustomCarDetails(getFacilitiesCustomCarDetails());
      
        if (getSchoolingPersonalizedSchoolingPlan() != null)
            hccrSchoolingTypeSchooling.setSchoolingPersonalizedSchoolingPlan(getSchoolingPersonalizedSchoolingPlan().booleanValue());
      
        hccrDwellingTypeDwelling.setDwellingPrecision(getDwellingPrecision());
      
        if (getBenefitsDisabilityCard() != null)
            hccrBenefitsTypeBenefits.setBenefitsDisabilityCard(getBenefitsDisabilityCard().booleanValue());
      
        if (getSocialSecurityMemberShipKind() != null)
            hccrSocialSecurityTypeSocialSecurity.setSocialSecurityMemberShipKind(fr.cg95.cvq.xml.request.social.HccrSocialSecurityMemberShipKindType.Enum.forString(getSocialSecurityMemberShipKind().toString()));
      
        hccrAseReferentAseReferent.setAseReferentLastName(getAseReferentLastName());
      
        hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusElectiveFunctionDetails(getProfessionalStatusElectiveFunctionDetails());
      
        if (getFacilitiesAnimalAid() != null)
            hccrFacilitiesTypeFacilities.setFacilitiesAnimalAid(getFacilitiesAnimalAid().booleanValue());
      
        if (getStudiesHighSchoolAddress() != null)
            hccrStudiesTypeStudies.setStudiesHighSchoolAddress(Address.modelToXml(getStudiesHighSchoolAddress()));
      
        return handicapCompensationChildRequestDoc;
    }

    @Override
    public final HandicapCompensationChildRequestDocument.HandicapCompensationChildRequest modelToXmlRequest() {
        return modelToXml().getHandicapCompensationChildRequest();
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

  
    public final void setHealthFollowedByProfessional(final Boolean healthFollowedByProfessional) {
        handicapCompensationChildRequestData.setHealthFollowedByProfessional(healthFollowedByProfessional);
    }

    public final Boolean getHealthFollowedByProfessional() {
        return handicapCompensationChildRequestData.getHealthFollowedByProfessional();
    }
  
    public final void setProfessionalSupportProfessionals(final Boolean professionalSupportProfessionals) {
        handicapCompensationChildRequestData.setProfessionalSupportProfessionals(professionalSupportProfessionals);
    }

    public final Boolean getProfessionalSupportProfessionals() {
        return handicapCompensationChildRequestData.getProfessionalSupportProfessionals();
    }
  
    public final void setReferentFamilyDependents(final Boolean referentFamilyDependents) {
        handicapCompensationChildRequestData.setReferentFamilyDependents(referentFamilyDependents);
    }

    public final Boolean getReferentFamilyDependents() {
        return handicapCompensationChildRequestData.getReferentFamilyDependents();
    }
  
    public final void setIsFamilyAssistance(final Boolean isFamilyAssistance) {
        handicapCompensationChildRequestData.setIsFamilyAssistance(isFamilyAssistance);
    }

    public final Boolean getIsFamilyAssistance() {
        return handicapCompensationChildRequestData.getIsFamilyAssistance();
    }
  
    public final void setSchoolingAttendedGrade(final fr.cg95.cvq.business.users.SectionType schoolingAttendedGrade) {
        handicapCompensationChildRequestData.setSchoolingAttendedGrade(schoolingAttendedGrade);
    }

    public final fr.cg95.cvq.business.users.SectionType getSchoolingAttendedGrade() {
        return handicapCompensationChildRequestData.getSchoolingAttendedGrade();
    }
  
    public final void setFamilyDependents(final List<fr.cg95.cvq.business.request.social.HccrFamilyDependent> familyDependents) {
        handicapCompensationChildRequestData.setFamilyDependents(familyDependents);
    }

    public final List<fr.cg95.cvq.business.request.social.HccrFamilyDependent> getFamilyDependents() {
        return handicapCompensationChildRequestData.getFamilyDependents();
    }
  
    public final void setReferentTitle(final fr.cg95.cvq.business.users.TitleType referentTitle) {
        handicapCompensationChildRequestData.setReferentTitle(referentTitle);
    }

    public final fr.cg95.cvq.business.users.TitleType getReferentTitle() {
        return handicapCompensationChildRequestData.getReferentTitle();
    }
  
    public final void setProjectComments(final String projectComments) {
        handicapCompensationChildRequestData.setProjectComments(projectComments);
    }

    public final String getProjectComments() {
        return handicapCompensationChildRequestData.getProjectComments();
    }
  
    public final void setFoldersCdes(final Boolean foldersCdes) {
        handicapCompensationChildRequestData.setFoldersCdes(foldersCdes);
    }

    public final Boolean getFoldersCdes() {
        return handicapCompensationChildRequestData.getFoldersCdes();
    }
  
    public final void setFoldersMdphDepartment(final String foldersMdphDepartment) {
        handicapCompensationChildRequestData.setFoldersMdphDepartment(foldersMdphDepartment);
    }

    public final String getFoldersMdphDepartment() {
        return handicapCompensationChildRequestData.getFoldersMdphDepartment();
    }
  
    public final void setProjectNeeds(final String projectNeeds) {
        handicapCompensationChildRequestData.setProjectNeeds(projectNeeds);
    }

    public final String getProjectNeeds() {
        return handicapCompensationChildRequestData.getProjectNeeds();
    }
  
    public final void setHomeInterventionHomeIntervenant(final Boolean homeInterventionHomeIntervenant) {
        handicapCompensationChildRequestData.setHomeInterventionHomeIntervenant(homeInterventionHomeIntervenant);
    }

    public final Boolean getHomeInterventionHomeIntervenant() {
        return handicapCompensationChildRequestData.getHomeInterventionHomeIntervenant();
    }
  
    public final void setBenefitsEducationAllocationOfDisabledChildren(final Boolean benefitsEducationAllocationOfDisabledChildren) {
        handicapCompensationChildRequestData.setBenefitsEducationAllocationOfDisabledChildren(benefitsEducationAllocationOfDisabledChildren);
    }

    public final Boolean getBenefitsEducationAllocationOfDisabledChildren() {
        return handicapCompensationChildRequestData.getBenefitsEducationAllocationOfDisabledChildren();
    }
  
    public final void setOtherFolders(final List<fr.cg95.cvq.business.request.social.HccrOtherFolder> otherFolders) {
        handicapCompensationChildRequestData.setOtherFolders(otherFolders);
    }

    public final List<fr.cg95.cvq.business.request.social.HccrOtherFolder> getOtherFolders() {
        return handicapCompensationChildRequestData.getOtherFolders();
    }
  
    public final void setFoldersMdphNumber(final String foldersMdphNumber) {
        handicapCompensationChildRequestData.setFoldersMdphNumber(foldersMdphNumber);
    }

    public final String getFoldersMdphNumber() {
        return handicapCompensationChildRequestData.getFoldersMdphNumber();
    }
  
    public final void setSubjectParentalAuthorityHolder(final fr.cg95.cvq.business.request.social.HccrSubjectParentalAuthorityHolderType subjectParentalAuthorityHolder) {
        handicapCompensationChildRequestData.setSubjectParentalAuthorityHolder(subjectParentalAuthorityHolder);
    }

    public final fr.cg95.cvq.business.request.social.HccrSubjectParentalAuthorityHolderType getSubjectParentalAuthorityHolder() {
        return handicapCompensationChildRequestData.getSubjectParentalAuthorityHolder();
    }
  
    public final void setProjectRequestsHousingFacilities(final Boolean projectRequestsHousingFacilities) {
        handicapCompensationChildRequestData.setProjectRequestsHousingFacilities(projectRequestsHousingFacilities);
    }

    public final Boolean getProjectRequestsHousingFacilities() {
        return handicapCompensationChildRequestData.getProjectRequestsHousingFacilities();
    }
  
    public final void setSchoolingHomeSchooling(final Boolean schoolingHomeSchooling) {
        handicapCompensationChildRequestData.setSchoolingHomeSchooling(schoolingHomeSchooling);
    }

    public final Boolean getSchoolingHomeSchooling() {
        return handicapCompensationChildRequestData.getSchoolingHomeSchooling();
    }
  
    public final void setFatherActivityReductionRatio(final java.math.BigInteger fatherActivityReductionRatio) {
        handicapCompensationChildRequestData.setFatherActivityReductionRatio(fatherActivityReductionRatio);
    }

    public final java.math.BigInteger getFatherActivityReductionRatio() {
        return handicapCompensationChildRequestData.getFatherActivityReductionRatio();
    }
  
    public final void setSubjectBirthDate(final java.util.Date subjectBirthDate) {
        handicapCompensationChildRequestData.setSubjectBirthDate(subjectBirthDate);
    }

    public final java.util.Date getSubjectBirthDate() {
        return handicapCompensationChildRequestData.getSubjectBirthDate();
    }
  
    public final void setSchoolingExtraCurricularDetails(final String schoolingExtraCurricularDetails) {
        handicapCompensationChildRequestData.setSchoolingExtraCurricularDetails(schoolingExtraCurricularDetails);
    }

    public final String getSchoolingExtraCurricularDetails() {
        return handicapCompensationChildRequestData.getSchoolingExtraCurricularDetails();
    }
  
    public final void setSchoolingSpecializedGrade(final Boolean schoolingSpecializedGrade) {
        handicapCompensationChildRequestData.setSchoolingSpecializedGrade(schoolingSpecializedGrade);
    }

    public final Boolean getSchoolingSpecializedGrade() {
        return handicapCompensationChildRequestData.getSchoolingSpecializedGrade();
    }
  
    public final void setBenefitsDisabilityPension(final Boolean benefitsDisabilityPension) {
        handicapCompensationChildRequestData.setBenefitsDisabilityPension(benefitsDisabilityPension);
    }

    public final Boolean getBenefitsDisabilityPension() {
        return handicapCompensationChildRequestData.getBenefitsDisabilityPension();
    }
  
    public final void setReferentMaidenName(final String referentMaidenName) {
        handicapCompensationChildRequestData.setReferentMaidenName(referentMaidenName);
    }

    public final String getReferentMaidenName() {
        return handicapCompensationChildRequestData.getReferentMaidenName();
    }
  
    public final void setProjectRequestsDisabledWorkerRecognition(final Boolean projectRequestsDisabledWorkerRecognition) {
        handicapCompensationChildRequestData.setProjectRequestsDisabledWorkerRecognition(projectRequestsDisabledWorkerRecognition);
    }

    public final Boolean getProjectRequestsDisabledWorkerRecognition() {
        return handicapCompensationChildRequestData.getProjectRequestsDisabledWorkerRecognition();
    }
  
    public final void setBenefitsUnemploymentBenefits(final Boolean benefitsUnemploymentBenefits) {
        handicapCompensationChildRequestData.setBenefitsUnemploymentBenefits(benefitsUnemploymentBenefits);
    }

    public final Boolean getBenefitsUnemploymentBenefits() {
        return handicapCompensationChildRequestData.getBenefitsUnemploymentBenefits();
    }
  
    public final void setHomeIntervenants(final List<fr.cg95.cvq.business.request.social.HccrHomeIntervenant> homeIntervenants) {
        handicapCompensationChildRequestData.setHomeIntervenants(homeIntervenants);
    }

    public final List<fr.cg95.cvq.business.request.social.HccrHomeIntervenant> getHomeIntervenants() {
        return handicapCompensationChildRequestData.getHomeIntervenants();
    }
  
    public final void setProfessionalStatusKind(final fr.cg95.cvq.business.request.social.HccrProfessionalStatusKindType professionalStatusKind) {
        handicapCompensationChildRequestData.setProfessionalStatusKind(professionalStatusKind);
    }

    public final fr.cg95.cvq.business.request.social.HccrProfessionalStatusKindType getProfessionalStatusKind() {
        return handicapCompensationChildRequestData.getProfessionalStatusKind();
    }
  
    public final void setSchoolingHomeSchoolingKind(final fr.cg95.cvq.business.request.social.HccrHomeSchoolingKindType schoolingHomeSchoolingKind) {
        handicapCompensationChildRequestData.setSchoolingHomeSchoolingKind(schoolingHomeSchoolingKind);
    }

    public final fr.cg95.cvq.business.request.social.HccrHomeSchoolingKindType getSchoolingHomeSchoolingKind() {
        return handicapCompensationChildRequestData.getSchoolingHomeSchoolingKind();
    }
  
    public final void setBenefitsEducationOfDisabledChildrenDetails(final String benefitsEducationOfDisabledChildrenDetails) {
        handicapCompensationChildRequestData.setBenefitsEducationOfDisabledChildrenDetails(benefitsEducationOfDisabledChildrenDetails);
    }

    public final String getBenefitsEducationOfDisabledChildrenDetails() {
        return handicapCompensationChildRequestData.getBenefitsEducationOfDisabledChildrenDetails();
    }
  
    public final void setFormationPreviousFormation(final String formationPreviousFormation) {
        handicapCompensationChildRequestData.setFormationPreviousFormation(formationPreviousFormation);
    }

    public final String getFormationPreviousFormation() {
        return handicapCompensationChildRequestData.getFormationPreviousFormation();
    }
  
    public final void setProjectRequestsVocationalTraining(final Boolean projectRequestsVocationalTraining) {
        handicapCompensationChildRequestData.setProjectRequestsVocationalTraining(projectRequestsVocationalTraining);
    }

    public final Boolean getProjectRequestsVocationalTraining() {
        return handicapCompensationChildRequestData.getProjectRequestsVocationalTraining();
    }
  
    public final void setFacilitiesCustomCar(final Boolean facilitiesCustomCar) {
        handicapCompensationChildRequestData.setFacilitiesCustomCar(facilitiesCustomCar);
    }

    public final Boolean getFacilitiesCustomCar() {
        return handicapCompensationChildRequestData.getFacilitiesCustomCar();
    }
  
    public final void setBenefitsDisabledAdultAllocation(final Boolean benefitsDisabledAdultAllocation) {
        handicapCompensationChildRequestData.setBenefitsDisabledAdultAllocation(benefitsDisabledAdultAllocation);
    }

    public final Boolean getBenefitsDisabledAdultAllocation() {
        return handicapCompensationChildRequestData.getBenefitsDisabledAdultAllocation();
    }
  
    public final void setProfessionalStatusIndemnified(final Boolean professionalStatusIndemnified) {
        handicapCompensationChildRequestData.setProfessionalStatusIndemnified(professionalStatusIndemnified);
    }

    public final Boolean getProfessionalStatusIndemnified() {
        return handicapCompensationChildRequestData.getProfessionalStatusIndemnified();
    }
  
    public final void setSchoolingEnrolment(final Boolean schoolingEnrolment) {
        handicapCompensationChildRequestData.setSchoolingEnrolment(schoolingEnrolment);
    }

    public final Boolean getSchoolingEnrolment() {
        return handicapCompensationChildRequestData.getSchoolingEnrolment();
    }
  
    public final void setBenefitsThirdPartyCompensatoryAllowance(final Boolean benefitsThirdPartyCompensatoryAllowance) {
        handicapCompensationChildRequestData.setBenefitsThirdPartyCompensatoryAllowance(benefitsThirdPartyCompensatoryAllowance);
    }

    public final Boolean getBenefitsThirdPartyCompensatoryAllowance() {
        return handicapCompensationChildRequestData.getBenefitsThirdPartyCompensatoryAllowance();
    }
  
    public final void setReferentBirthDate(final java.util.Date referentBirthDate) {
        handicapCompensationChildRequestData.setReferentBirthDate(referentBirthDate);
    }

    public final java.util.Date getReferentBirthDate() {
        return handicapCompensationChildRequestData.getReferentBirthDate();
    }
  
    public final void setProfessionalStatusDate(final java.util.Date professionalStatusDate) {
        handicapCompensationChildRequestData.setProfessionalStatusDate(professionalStatusDate);
    }

    public final java.util.Date getProfessionalStatusDate() {
        return handicapCompensationChildRequestData.getProfessionalStatusDate();
    }
  
    public final void setProjectRequestsTransportCostAllocation(final Boolean projectRequestsTransportCostAllocation) {
        handicapCompensationChildRequestData.setProjectRequestsTransportCostAllocation(projectRequestsTransportCostAllocation);
    }

    public final Boolean getProjectRequestsTransportCostAllocation() {
        return handicapCompensationChildRequestData.getProjectRequestsTransportCostAllocation();
    }
  
    public final void setBenefitsProfessionalOrientation(final Boolean benefitsProfessionalOrientation) {
        handicapCompensationChildRequestData.setBenefitsProfessionalOrientation(benefitsProfessionalOrientation);
    }

    public final Boolean getBenefitsProfessionalOrientation() {
        return handicapCompensationChildRequestData.getBenefitsProfessionalOrientation();
    }
  
    public final void setSchoolingHomeSchoolingAccompanistLastName(final String schoolingHomeSchoolingAccompanistLastName) {
        handicapCompensationChildRequestData.setSchoolingHomeSchoolingAccompanistLastName(schoolingHomeSchoolingAccompanistLastName);
    }

    public final String getSchoolingHomeSchoolingAccompanistLastName() {
        return handicapCompensationChildRequestData.getSchoolingHomeSchoolingAccompanistLastName();
    }
  
    public final void setBenefitsDisabilityRecognition(final Boolean benefitsDisabilityRecognition) {
        handicapCompensationChildRequestData.setBenefitsDisabilityRecognition(benefitsDisabilityRecognition);
    }

    public final Boolean getBenefitsDisabilityRecognition() {
        return handicapCompensationChildRequestData.getBenefitsDisabilityRecognition();
    }
  
    public final void setProfessionalStatusRegisterAsUnemployed(final Boolean professionalStatusRegisterAsUnemployed) {
        handicapCompensationChildRequestData.setProfessionalStatusRegisterAsUnemployed(professionalStatusRegisterAsUnemployed);
    }

    public final Boolean getProfessionalStatusRegisterAsUnemployed() {
        return handicapCompensationChildRequestData.getProfessionalStatusRegisterAsUnemployed();
    }
  
    public final void setProfessionalStatusIndemnifiedDate(final java.util.Date professionalStatusIndemnifiedDate) {
        handicapCompensationChildRequestData.setProfessionalStatusIndemnifiedDate(professionalStatusIndemnifiedDate);
    }

    public final java.util.Date getProfessionalStatusIndemnifiedDate() {
        return handicapCompensationChildRequestData.getProfessionalStatusIndemnifiedDate();
    }
  
    public final void setDwellingSocialReceptionNaming(final String dwellingSocialReceptionNaming) {
        handicapCompensationChildRequestData.setDwellingSocialReceptionNaming(dwellingSocialReceptionNaming);
    }

    public final String getDwellingSocialReceptionNaming() {
        return handicapCompensationChildRequestData.getDwellingSocialReceptionNaming();
    }
  
    public final void setBenefitsProfessionalOrientationDetails(final String benefitsProfessionalOrientationDetails) {
        handicapCompensationChildRequestData.setBenefitsProfessionalOrientationDetails(benefitsProfessionalOrientationDetails);
    }

    public final String getBenefitsProfessionalOrientationDetails() {
        return handicapCompensationChildRequestData.getBenefitsProfessionalOrientationDetails();
    }
  
    public final void setBenefitsPainfulStandingCard(final Boolean benefitsPainfulStandingCard) {
        handicapCompensationChildRequestData.setBenefitsPainfulStandingCard(benefitsPainfulStandingCard);
    }

    public final Boolean getBenefitsPainfulStandingCard() {
        return handicapCompensationChildRequestData.getBenefitsPainfulStandingCard();
    }
  
    public final void setFoldersCdesDepartment(final String foldersCdesDepartment) {
        handicapCompensationChildRequestData.setFoldersCdesDepartment(foldersCdesDepartment);
    }

    public final String getFoldersCdesDepartment() {
        return handicapCompensationChildRequestData.getFoldersCdesDepartment();
    }
  
    public final void setFacilitiesSpecializedTransport(final Boolean facilitiesSpecializedTransport) {
        handicapCompensationChildRequestData.setFacilitiesSpecializedTransport(facilitiesSpecializedTransport);
    }

    public final Boolean getFacilitiesSpecializedTransport() {
        return handicapCompensationChildRequestData.getFacilitiesSpecializedTransport();
    }
  
    public final void setBenefitsParkingCard(final Boolean benefitsParkingCard) {
        handicapCompensationChildRequestData.setBenefitsParkingCard(benefitsParkingCard);
    }

    public final Boolean getBenefitsParkingCard() {
        return handicapCompensationChildRequestData.getBenefitsParkingCard();
    }
  
    public final void setFacilitiesSpecializedTransportDetails(final String facilitiesSpecializedTransportDetails) {
        handicapCompensationChildRequestData.setFacilitiesSpecializedTransportDetails(facilitiesSpecializedTransportDetails);
    }

    public final String getFacilitiesSpecializedTransportDetails() {
        return handicapCompensationChildRequestData.getFacilitiesSpecializedTransportDetails();
    }
  
    public final void setBenefitsWorkAccidentAnnuityRatio(final String benefitsWorkAccidentAnnuityRatio) {
        handicapCompensationChildRequestData.setBenefitsWorkAccidentAnnuityRatio(benefitsWorkAccidentAnnuityRatio);
    }

    public final String getBenefitsWorkAccidentAnnuityRatio() {
        return handicapCompensationChildRequestData.getBenefitsWorkAccidentAnnuityRatio();
    }
  
    public final void setSocialSecurityNumber(final String socialSecurityNumber) {
        handicapCompensationChildRequestData.setSocialSecurityNumber(socialSecurityNumber);
    }

    public final String getSocialSecurityNumber() {
        return handicapCompensationChildRequestData.getSocialSecurityNumber();
    }
  
    public final void setBenefitsWorkAccidentAnnuity(final Boolean benefitsWorkAccidentAnnuity) {
        handicapCompensationChildRequestData.setBenefitsWorkAccidentAnnuity(benefitsWorkAccidentAnnuity);
    }

    public final Boolean getBenefitsWorkAccidentAnnuity() {
        return handicapCompensationChildRequestData.getBenefitsWorkAccidentAnnuity();
    }
  
    public final void setCareCareServices(final Boolean careCareServices) {
        handicapCompensationChildRequestData.setCareCareServices(careCareServices);
    }

    public final Boolean getCareCareServices() {
        return handicapCompensationChildRequestData.getCareCareServices();
    }
  
    public final void setBenefitsDailyAllowances(final Boolean benefitsDailyAllowances) {
        handicapCompensationChildRequestData.setBenefitsDailyAllowances(benefitsDailyAllowances);
    }

    public final Boolean getBenefitsDailyAllowances() {
        return handicapCompensationChildRequestData.getBenefitsDailyAllowances();
    }
  
    public final void setBenefitsDisabilityRatio(final String benefitsDisabilityRatio) {
        handicapCompensationChildRequestData.setBenefitsDisabilityRatio(benefitsDisabilityRatio);
    }

    public final String getBenefitsDisabilityRatio() {
        return handicapCompensationChildRequestData.getBenefitsDisabilityRatio();
    }
  
    public final void setFatherFirstName(final String fatherFirstName) {
        handicapCompensationChildRequestData.setFatherFirstName(fatherFirstName);
    }

    public final String getFatherFirstName() {
        return handicapCompensationChildRequestData.getFatherFirstName();
    }
  
    public final void setSchoolingHomeSchoolingAccompanistAddress(final fr.cg95.cvq.business.users.Address schoolingHomeSchoolingAccompanistAddress) {
        handicapCompensationChildRequestData.setSchoolingHomeSchoolingAccompanistAddress(schoolingHomeSchoolingAccompanistAddress);
    }

    public final fr.cg95.cvq.business.users.Address getSchoolingHomeSchoolingAccompanistAddress() {
        return handicapCompensationChildRequestData.getSchoolingHomeSchoolingAccompanistAddress();
    }
  
    public final void setProjectRequestsCustomCar(final Boolean projectRequestsCustomCar) {
        handicapCompensationChildRequestData.setProjectRequestsCustomCar(projectRequestsCustomCar);
    }

    public final Boolean getProjectRequestsCustomCar() {
        return handicapCompensationChildRequestData.getProjectRequestsCustomCar();
    }
  
    public final void setPaymentAgencyBeneficiaryNumber(final String paymentAgencyBeneficiaryNumber) {
        handicapCompensationChildRequestData.setPaymentAgencyBeneficiaryNumber(paymentAgencyBeneficiaryNumber);
    }

    public final String getPaymentAgencyBeneficiaryNumber() {
        return handicapCompensationChildRequestData.getPaymentAgencyBeneficiaryNumber();
    }
  
    public final void setFoldersCotorepNumber(final String foldersCotorepNumber) {
        handicapCompensationChildRequestData.setFoldersCotorepNumber(foldersCotorepNumber);
    }

    public final String getFoldersCotorepNumber() {
        return handicapCompensationChildRequestData.getFoldersCotorepNumber();
    }
  
    public final void setProjectRequestsACTPRenewal(final Boolean projectRequestsACTPRenewal) {
        handicapCompensationChildRequestData.setProjectRequestsACTPRenewal(projectRequestsACTPRenewal);
    }

    public final Boolean getProjectRequestsACTPRenewal() {
        return handicapCompensationChildRequestData.getProjectRequestsACTPRenewal();
    }
  
    public final void setReferentFamilyStatus(final fr.cg95.cvq.business.users.FamilyStatusType referentFamilyStatus) {
        handicapCompensationChildRequestData.setReferentFamilyStatus(referentFamilyStatus);
    }

    public final fr.cg95.cvq.business.users.FamilyStatusType getReferentFamilyStatus() {
        return handicapCompensationChildRequestData.getReferentFamilyStatus();
    }
  
    public final void setSchoolingSchoolName(final String schoolingSchoolName) {
        handicapCompensationChildRequestData.setSchoolingSchoolName(schoolingSchoolName);
    }

    public final String getSchoolingSchoolName() {
        return handicapCompensationChildRequestData.getSchoolingSchoolName();
    }
  
    public final void setDwellingSocialReceptionAddress(final fr.cg95.cvq.business.users.Address dwellingSocialReceptionAddress) {
        handicapCompensationChildRequestData.setDwellingSocialReceptionAddress(dwellingSocialReceptionAddress);
    }

    public final fr.cg95.cvq.business.users.Address getDwellingSocialReceptionAddress() {
        return handicapCompensationChildRequestData.getDwellingSocialReceptionAddress();
    }
  
    public final void setBenefitsSupportedByAnInstitutionDetails(final String benefitsSupportedByAnInstitutionDetails) {
        handicapCompensationChildRequestData.setBenefitsSupportedByAnInstitutionDetails(benefitsSupportedByAnInstitutionDetails);
    }

    public final String getBenefitsSupportedByAnInstitutionDetails() {
        return handicapCompensationChildRequestData.getBenefitsSupportedByAnInstitutionDetails();
    }
  
    public final void setFoldersMdph(final Boolean foldersMdph) {
        handicapCompensationChildRequestData.setFoldersMdph(foldersMdph);
    }

    public final Boolean getFoldersMdph() {
        return handicapCompensationChildRequestData.getFoldersMdph();
    }
  
    public final void setMotherJob(final String motherJob) {
        handicapCompensationChildRequestData.setMotherJob(motherJob);
    }

    public final String getMotherJob() {
        return handicapCompensationChildRequestData.getMotherJob();
    }
  
    public final void setSchoolingSchoolAddress(final fr.cg95.cvq.business.users.Address schoolingSchoolAddress) {
        handicapCompensationChildRequestData.setSchoolingSchoolAddress(schoolingSchoolAddress);
    }

    public final fr.cg95.cvq.business.users.Address getSchoolingSchoolAddress() {
        return handicapCompensationChildRequestData.getSchoolingSchoolAddress();
    }
  
    public final void setSchoolingTime(final String schoolingTime) {
        handicapCompensationChildRequestData.setSchoolingTime(schoolingTime);
    }

    public final String getSchoolingTime() {
        return handicapCompensationChildRequestData.getSchoolingTime();
    }
  
    public final void setProfessionalSupportDealsWithSameProfessional(final Boolean professionalSupportDealsWithSameProfessional) {
        handicapCompensationChildRequestData.setProfessionalSupportDealsWithSameProfessional(professionalSupportDealsWithSameProfessional);
    }

    public final Boolean getProfessionalSupportDealsWithSameProfessional() {
        return handicapCompensationChildRequestData.getProfessionalSupportDealsWithSameProfessional();
    }
  
    public final void setAseReferentDepartment(final String aseReferentDepartment) {
        handicapCompensationChildRequestData.setAseReferentDepartment(aseReferentDepartment);
    }

    public final String getAseReferentDepartment() {
        return handicapCompensationChildRequestData.getAseReferentDepartment();
    }
  
    public final void setFoldersCotorepDepartment(final String foldersCotorepDepartment) {
        handicapCompensationChildRequestData.setFoldersCotorepDepartment(foldersCotorepDepartment);
    }

    public final String getFoldersCotorepDepartment() {
        return handicapCompensationChildRequestData.getFoldersCotorepDepartment();
    }
  
    public final void setDwellingEstablishmentReception(final Boolean dwellingEstablishmentReception) {
        handicapCompensationChildRequestData.setDwellingEstablishmentReception(dwellingEstablishmentReception);
    }

    public final Boolean getDwellingEstablishmentReception() {
        return handicapCompensationChildRequestData.getDwellingEstablishmentReception();
    }
  
    public final void setMotherFirstName(final String motherFirstName) {
        handicapCompensationChildRequestData.setMotherFirstName(motherFirstName);
    }

    public final String getMotherFirstName() {
        return handicapCompensationChildRequestData.getMotherFirstName();
    }
  
    public final void setAdditionalFee(final List<fr.cg95.cvq.business.request.social.HccrAdditionalFee> additionalFee) {
        handicapCompensationChildRequestData.setAdditionalFee(additionalFee);
    }

    public final List<fr.cg95.cvq.business.request.social.HccrAdditionalFee> getAdditionalFee() {
        return handicapCompensationChildRequestData.getAdditionalFee();
    }
  
    public final void setProjectRequestsOrdinaryWorking(final Boolean projectRequestsOrdinaryWorking) {
        handicapCompensationChildRequestData.setProjectRequestsOrdinaryWorking(projectRequestsOrdinaryWorking);
    }

    public final Boolean getProjectRequestsOrdinaryWorking() {
        return handicapCompensationChildRequestData.getProjectRequestsOrdinaryWorking();
    }
  
    public final void setBenefitsDisabledWorkerRecognition(final Boolean benefitsDisabledWorkerRecognition) {
        handicapCompensationChildRequestData.setBenefitsDisabledWorkerRecognition(benefitsDisabledWorkerRecognition);
    }

    public final Boolean getBenefitsDisabledWorkerRecognition() {
        return handicapCompensationChildRequestData.getBenefitsDisabledWorkerRecognition();
    }
  
    public final void setDwellingSocialReception(final Boolean dwellingSocialReception) {
        handicapCompensationChildRequestData.setDwellingSocialReception(dwellingSocialReception);
    }

    public final Boolean getDwellingSocialReception() {
        return handicapCompensationChildRequestData.getDwellingSocialReception();
    }
  
    public final void setProjectRequestsEuropeanParkingCard(final Boolean projectRequestsEuropeanParkingCard) {
        handicapCompensationChildRequestData.setProjectRequestsEuropeanParkingCard(projectRequestsEuropeanParkingCard);
    }

    public final Boolean getProjectRequestsEuropeanParkingCard() {
        return handicapCompensationChildRequestData.getProjectRequestsEuropeanParkingCard();
    }
  
    public final void setHealthFollowedByDoctor(final Boolean healthFollowedByDoctor) {
        handicapCompensationChildRequestData.setHealthFollowedByDoctor(healthFollowedByDoctor);
    }

    public final Boolean getHealthFollowedByDoctor() {
        return handicapCompensationChildRequestData.getHealthFollowedByDoctor();
    }
  
    public final void setFamilyAssistanceMembers(final List<fr.cg95.cvq.business.request.social.HccrFamilyAssistanceMember> familyAssistanceMembers) {
        handicapCompensationChildRequestData.setFamilyAssistanceMembers(familyAssistanceMembers);
    }

    public final List<fr.cg95.cvq.business.request.social.HccrFamilyAssistanceMember> getFamilyAssistanceMembers() {
        return handicapCompensationChildRequestData.getFamilyAssistanceMembers();
    }
  
    public final void setSchoolingHomeSchoolingAccompanistFirstName(final String schoolingHomeSchoolingAccompanistFirstName) {
        handicapCompensationChildRequestData.setSchoolingHomeSchoolingAccompanistFirstName(schoolingHomeSchoolingAccompanistFirstName);
    }

    public final String getSchoolingHomeSchoolingAccompanistFirstName() {
        return handicapCompensationChildRequestData.getSchoolingHomeSchoolingAccompanistFirstName();
    }
  
    public final void setReferentBirthCity(final String referentBirthCity) {
        handicapCompensationChildRequestData.setReferentBirthCity(referentBirthCity);
    }

    public final String getReferentBirthCity() {
        return handicapCompensationChildRequestData.getReferentBirthCity();
    }
  
    public final void setProjectRequestsFreePensionMembership(final Boolean projectRequestsFreePensionMembership) {
        handicapCompensationChildRequestData.setProjectRequestsFreePensionMembership(projectRequestsFreePensionMembership);
    }

    public final Boolean getProjectRequestsFreePensionMembership() {
        return handicapCompensationChildRequestData.getProjectRequestsFreePensionMembership();
    }
  
    public final void setSchoolingSpecializedGradeDetails(final String schoolingSpecializedGradeDetails) {
        handicapCompensationChildRequestData.setSchoolingSpecializedGradeDetails(schoolingSpecializedGradeDetails);
    }

    public final String getSchoolingSpecializedGradeDetails() {
        return handicapCompensationChildRequestData.getSchoolingSpecializedGradeDetails();
    }
  
    public final void setReferentBirthCountry(final String referentBirthCountry) {
        handicapCompensationChildRequestData.setReferentBirthCountry(referentBirthCountry);
    }

    public final String getReferentBirthCountry() {
        return handicapCompensationChildRequestData.getReferentBirthCountry();
    }
  
    public final void setProfessionals(final List<fr.cg95.cvq.business.request.social.HccrProfessional> professionals) {
        handicapCompensationChildRequestData.setProfessionals(professionals);
    }

    public final List<fr.cg95.cvq.business.request.social.HccrProfessional> getProfessionals() {
        return handicapCompensationChildRequestData.getProfessionals();
    }
  
    public final void setHealthFollowedByHospital(final Boolean healthFollowedByHospital) {
        handicapCompensationChildRequestData.setHealthFollowedByHospital(healthFollowedByHospital);
    }

    public final Boolean getHealthFollowedByHospital() {
        return handicapCompensationChildRequestData.getHealthFollowedByHospital();
    }
  
    public final void setProfessionalStatusEmployerName(final String professionalStatusEmployerName) {
        handicapCompensationChildRequestData.setProfessionalStatusEmployerName(professionalStatusEmployerName);
    }

    public final String getProfessionalStatusEmployerName() {
        return handicapCompensationChildRequestData.getProfessionalStatusEmployerName();
    }
  
    public final void setProjectRequestsInstitutionSupport(final Boolean projectRequestsInstitutionSupport) {
        handicapCompensationChildRequestData.setProjectRequestsInstitutionSupport(projectRequestsInstitutionSupport);
    }

    public final Boolean getProjectRequestsInstitutionSupport() {
        return handicapCompensationChildRequestData.getProjectRequestsInstitutionSupport();
    }
  
    public final void setBenefitsSocialWelfare(final Boolean benefitsSocialWelfare) {
        handicapCompensationChildRequestData.setBenefitsSocialWelfare(benefitsSocialWelfare);
    }

    public final Boolean getBenefitsSocialWelfare() {
        return handicapCompensationChildRequestData.getBenefitsSocialWelfare();
    }
  
    public final void setProjectRequestsHandicapRecognition(final Boolean projectRequestsHandicapRecognition) {
        handicapCompensationChildRequestData.setProjectRequestsHandicapRecognition(projectRequestsHandicapRecognition);
    }

    public final Boolean getProjectRequestsHandicapRecognition() {
        return handicapCompensationChildRequestData.getProjectRequestsHandicapRecognition();
    }
  
    public final void setCareServices(final List<fr.cg95.cvq.business.request.social.HccrCareService> careServices) {
        handicapCompensationChildRequestData.setCareServices(careServices);
    }

    public final List<fr.cg95.cvq.business.request.social.HccrCareService> getCareServices() {
        return handicapCompensationChildRequestData.getCareServices();
    }
  
    public final void setSchoolingExtraCurricular(final Boolean schoolingExtraCurricular) {
        handicapCompensationChildRequestData.setSchoolingExtraCurricular(schoolingExtraCurricular);
    }

    public final Boolean getSchoolingExtraCurricular() {
        return handicapCompensationChildRequestData.getSchoolingExtraCurricular();
    }
  
    public final void setProjectWish(final String projectWish) {
        handicapCompensationChildRequestData.setProjectWish(projectWish);
    }

    public final String getProjectWish() {
        return handicapCompensationChildRequestData.getProjectWish();
    }
  
    public final void setDwellingKind(final fr.cg95.cvq.business.request.social.HccrDwellingKindType dwellingKind) {
        handicapCompensationChildRequestData.setDwellingKind(dwellingKind);
    }

    public final fr.cg95.cvq.business.request.social.HccrDwellingKindType getDwellingKind() {
        return handicapCompensationChildRequestData.getDwellingKind();
    }
  
    public final void setHealthProfessionalLastName(final String healthProfessionalLastName) {
        handicapCompensationChildRequestData.setHealthProfessionalLastName(healthProfessionalLastName);
    }

    public final String getHealthProfessionalLastName() {
        return handicapCompensationChildRequestData.getHealthProfessionalLastName();
    }
  
    public final void setFormationStudiesLevel(final String formationStudiesLevel) {
        handicapCompensationChildRequestData.setFormationStudiesLevel(formationStudiesLevel);
    }

    public final String getFormationStudiesLevel() {
        return handicapCompensationChildRequestData.getFormationStudiesLevel();
    }
  
    public final void setProjectRequestsProfessionalOrientation(final Boolean projectRequestsProfessionalOrientation) {
        handicapCompensationChildRequestData.setProjectRequestsProfessionalOrientation(projectRequestsProfessionalOrientation);
    }

    public final Boolean getProjectRequestsProfessionalOrientation() {
        return handicapCompensationChildRequestData.getProjectRequestsProfessionalOrientation();
    }
  
    public final void setHealthDoctorLastName(final String healthDoctorLastName) {
        handicapCompensationChildRequestData.setHealthDoctorLastName(healthDoctorLastName);
    }

    public final String getHealthDoctorLastName() {
        return handicapCompensationChildRequestData.getHealthDoctorLastName();
    }
  
    public final void setSocialServiceAddress(final fr.cg95.cvq.business.users.Address socialServiceAddress) {
        handicapCompensationChildRequestData.setSocialServiceAddress(socialServiceAddress);
    }

    public final fr.cg95.cvq.business.users.Address getSocialServiceAddress() {
        return handicapCompensationChildRequestData.getSocialServiceAddress();
    }
  
    public final void setFacilitiesHousingDetails(final String facilitiesHousingDetails) {
        handicapCompensationChildRequestData.setFacilitiesHousingDetails(facilitiesHousingDetails);
    }

    public final String getFacilitiesHousingDetails() {
        return handicapCompensationChildRequestData.getFacilitiesHousingDetails();
    }
  
    public final void setBenefitsSupplementForSingleParents(final Boolean benefitsSupplementForSingleParents) {
        handicapCompensationChildRequestData.setBenefitsSupplementForSingleParents(benefitsSupplementForSingleParents);
    }

    public final Boolean getBenefitsSupplementForSingleParents() {
        return handicapCompensationChildRequestData.getBenefitsSupplementForSingleParents();
    }
  
    public final void setProjectRequestsIncreaseForIndependentLiving(final Boolean projectRequestsIncreaseForIndependentLiving) {
        handicapCompensationChildRequestData.setProjectRequestsIncreaseForIndependentLiving(projectRequestsIncreaseForIndependentLiving);
    }

    public final Boolean getProjectRequestsIncreaseForIndependentLiving() {
        return handicapCompensationChildRequestData.getProjectRequestsIncreaseForIndependentLiving();
    }
  
    public final void setBenefitsThirdPartySupplement(final Boolean benefitsThirdPartySupplement) {
        handicapCompensationChildRequestData.setBenefitsThirdPartySupplement(benefitsThirdPartySupplement);
    }

    public final Boolean getBenefitsThirdPartySupplement() {
        return handicapCompensationChildRequestData.getBenefitsThirdPartySupplement();
    }
  
    public final void setBenefitsDisabilityPensionCategory(final String benefitsDisabilityPensionCategory) {
        handicapCompensationChildRequestData.setBenefitsDisabilityPensionCategory(benefitsDisabilityPensionCategory);
    }

    public final String getBenefitsDisabilityPensionCategory() {
        return handicapCompensationChildRequestData.getBenefitsDisabilityPensionCategory();
    }
  
    public final void setStudiesHighSchoolGrade(final String studiesHighSchoolGrade) {
        handicapCompensationChildRequestData.setStudiesHighSchoolGrade(studiesHighSchoolGrade);
    }

    public final String getStudiesHighSchoolGrade() {
        return handicapCompensationChildRequestData.getStudiesHighSchoolGrade();
    }
  
    public final void setReferentLastName(final String referentLastName) {
        handicapCompensationChildRequestData.setReferentLastName(referentLastName);
    }

    public final String getReferentLastName() {
        return handicapCompensationChildRequestData.getReferentLastName();
    }
  
    public final void setSubjectBirthCity(final String subjectBirthCity) {
        handicapCompensationChildRequestData.setSubjectBirthCity(subjectBirthCity);
    }

    public final String getSubjectBirthCity() {
        return handicapCompensationChildRequestData.getSubjectBirthCity();
    }
  
    public final void setProjectRequestsAssistance(final Boolean projectRequestsAssistance) {
        handicapCompensationChildRequestData.setProjectRequestsAssistance(projectRequestsAssistance);
    }

    public final Boolean getProjectRequestsAssistance() {
        return handicapCompensationChildRequestData.getProjectRequestsAssistance();
    }
  
    public final void setBenefitsSupportedByAnInstitution(final Boolean benefitsSupportedByAnInstitution) {
        handicapCompensationChildRequestData.setBenefitsSupportedByAnInstitution(benefitsSupportedByAnInstitution);
    }

    public final Boolean getBenefitsSupportedByAnInstitution() {
        return handicapCompensationChildRequestData.getBenefitsSupportedByAnInstitution();
    }
  
    public final void setProfessionalStatusEnvironment(final fr.cg95.cvq.business.request.social.HccrProfessionalStatusEnvironmentType professionalStatusEnvironment) {
        handicapCompensationChildRequestData.setProfessionalStatusEnvironment(professionalStatusEnvironment);
    }

    public final fr.cg95.cvq.business.request.social.HccrProfessionalStatusEnvironmentType getProfessionalStatusEnvironment() {
        return handicapCompensationChildRequestData.getProfessionalStatusEnvironment();
    }
  
    public final void setProjectRequestsThirdPartyHelp(final Boolean projectRequestsThirdPartyHelp) {
        handicapCompensationChildRequestData.setProjectRequestsThirdPartyHelp(projectRequestsThirdPartyHelp);
    }

    public final Boolean getProjectRequestsThirdPartyHelp() {
        return handicapCompensationChildRequestData.getProjectRequestsThirdPartyHelp();
    }
  
    public final void setProjectRequestsDisabledAdultAllowance(final Boolean projectRequestsDisabledAdultAllowance) {
        handicapCompensationChildRequestData.setProjectRequestsDisabledAdultAllowance(projectRequestsDisabledAdultAllowance);
    }

    public final Boolean getProjectRequestsDisabledAdultAllowance() {
        return handicapCompensationChildRequestData.getProjectRequestsDisabledAdultAllowance();
    }
  
    public final void setFoldersOtherFolders(final Boolean foldersOtherFolders) {
        handicapCompensationChildRequestData.setFoldersOtherFolders(foldersOtherFolders);
    }

    public final Boolean getFoldersOtherFolders() {
        return handicapCompensationChildRequestData.getFoldersOtherFolders();
    }
  
    public final void setPaymentAgencyBeneficiary(final fr.cg95.cvq.business.request.social.HccrPaymentAgencyBeneficiaryType paymentAgencyBeneficiary) {
        handicapCompensationChildRequestData.setPaymentAgencyBeneficiary(paymentAgencyBeneficiary);
    }

    public final fr.cg95.cvq.business.request.social.HccrPaymentAgencyBeneficiaryType getPaymentAgencyBeneficiary() {
        return handicapCompensationChildRequestData.getPaymentAgencyBeneficiary();
    }
  
    public final void setFatherJob(final String fatherJob) {
        handicapCompensationChildRequestData.setFatherJob(fatherJob);
    }

    public final String getFatherJob() {
        return handicapCompensationChildRequestData.getFatherJob();
    }
  
    public final void setFacilitiesAnimalAidDetails(final String facilitiesAnimalAidDetails) {
        handicapCompensationChildRequestData.setFacilitiesAnimalAidDetails(facilitiesAnimalAidDetails);
    }

    public final String getFacilitiesAnimalAidDetails() {
        return handicapCompensationChildRequestData.getFacilitiesAnimalAidDetails();
    }
  
    public final void setOtherBenefits(final List<fr.cg95.cvq.business.request.social.HccrOtherBenefit> otherBenefits) {
        handicapCompensationChildRequestData.setOtherBenefits(otherBenefits);
    }

    public final List<fr.cg95.cvq.business.request.social.HccrOtherBenefit> getOtherBenefits() {
        return handicapCompensationChildRequestData.getOtherBenefits();
    }
  
    public final void setStudiesAssistanceUnderDisabilityDetails(final String studiesAssistanceUnderDisabilityDetails) {
        handicapCompensationChildRequestData.setStudiesAssistanceUnderDisabilityDetails(studiesAssistanceUnderDisabilityDetails);
    }

    public final String getStudiesAssistanceUnderDisabilityDetails() {
        return handicapCompensationChildRequestData.getStudiesAssistanceUnderDisabilityDetails();
    }
  
    public final void setPaymentAgencyAddress(final fr.cg95.cvq.business.users.Address paymentAgencyAddress) {
        handicapCompensationChildRequestData.setPaymentAgencyAddress(paymentAgencyAddress);
    }

    public final fr.cg95.cvq.business.users.Address getPaymentAgencyAddress() {
        return handicapCompensationChildRequestData.getPaymentAgencyAddress();
    }
  
    public final void setProjectRequestsOther(final Boolean projectRequestsOther) {
        handicapCompensationChildRequestData.setProjectRequestsOther(projectRequestsOther);
    }

    public final Boolean getProjectRequestsOther() {
        return handicapCompensationChildRequestData.getProjectRequestsOther();
    }
  
    public final void setBenefitsThirdPersonCompensatoryAllowance(final Boolean benefitsThirdPersonCompensatoryAllowance) {
        handicapCompensationChildRequestData.setBenefitsThirdPersonCompensatoryAllowance(benefitsThirdPersonCompensatoryAllowance);
    }

    public final Boolean getBenefitsThirdPersonCompensatoryAllowance() {
        return handicapCompensationChildRequestData.getBenefitsThirdPersonCompensatoryAllowance();
    }
  
    public final void setProjectRequestsDisabilityCostAllocation(final Boolean projectRequestsDisabilityCostAllocation) {
        handicapCompensationChildRequestData.setProjectRequestsDisabilityCostAllocation(projectRequestsDisabilityCostAllocation);
    }

    public final Boolean getProjectRequestsDisabilityCostAllocation() {
        return handicapCompensationChildRequestData.getProjectRequestsDisabilityCostAllocation();
    }
  
    public final void setSocialSecurityAgencyAddress(final fr.cg95.cvq.business.users.Address socialSecurityAgencyAddress) {
        handicapCompensationChildRequestData.setSocialSecurityAgencyAddress(socialSecurityAgencyAddress);
    }

    public final fr.cg95.cvq.business.users.Address getSocialSecurityAgencyAddress() {
        return handicapCompensationChildRequestData.getSocialSecurityAgencyAddress();
    }
  
    public final void setProfessionalStatusAddress(final fr.cg95.cvq.business.users.Address professionalStatusAddress) {
        handicapCompensationChildRequestData.setProfessionalStatusAddress(professionalStatusAddress);
    }

    public final fr.cg95.cvq.business.users.Address getProfessionalStatusAddress() {
        return handicapCompensationChildRequestData.getProfessionalStatusAddress();
    }
  
    public final void setProfessionalStatusProfession(final String professionalStatusProfession) {
        handicapCompensationChildRequestData.setProfessionalStatusProfession(professionalStatusProfession);
    }

    public final String getProfessionalStatusProfession() {
        return handicapCompensationChildRequestData.getProfessionalStatusProfession();
    }
  
    public final void setDwellingReceptionAddress(final fr.cg95.cvq.business.users.Address dwellingReceptionAddress) {
        handicapCompensationChildRequestData.setDwellingReceptionAddress(dwellingReceptionAddress);
    }

    public final fr.cg95.cvq.business.users.Address getDwellingReceptionAddress() {
        return handicapCompensationChildRequestData.getDwellingReceptionAddress();
    }
  
    public final void setFormationDiploma(final String formationDiploma) {
        handicapCompensationChildRequestData.setFormationDiploma(formationDiploma);
    }

    public final String getFormationDiploma() {
        return handicapCompensationChildRequestData.getFormationDiploma();
    }
  
    public final void setMotherLastName(final String motherLastName) {
        handicapCompensationChildRequestData.setMotherLastName(motherLastName);
    }

    public final String getMotherLastName() {
        return handicapCompensationChildRequestData.getMotherLastName();
    }
  
    public final void setFoldersCotorep(final Boolean foldersCotorep) {
        handicapCompensationChildRequestData.setFoldersCotorep(foldersCotorep);
    }

    public final Boolean getFoldersCotorep() {
        return handicapCompensationChildRequestData.getFoldersCotorep();
    }
  
    public final void setProfessionalStatusElectiveFunction(final Boolean professionalStatusElectiveFunction) {
        handicapCompensationChildRequestData.setProfessionalStatusElectiveFunction(professionalStatusElectiveFunction);
    }

    public final Boolean getProfessionalStatusElectiveFunction() {
        return handicapCompensationChildRequestData.getProfessionalStatusElectiveFunction();
    }
  
    public final void setBenefitsIncreaseForIndependentLiving(final Boolean benefitsIncreaseForIndependentLiving) {
        handicapCompensationChildRequestData.setBenefitsIncreaseForIndependentLiving(benefitsIncreaseForIndependentLiving);
    }

    public final Boolean getBenefitsIncreaseForIndependentLiving() {
        return handicapCompensationChildRequestData.getBenefitsIncreaseForIndependentLiving();
    }
  
    public final void setSubjectBirthCountry(final String subjectBirthCountry) {
        handicapCompensationChildRequestData.setSubjectBirthCountry(subjectBirthCountry);
    }

    public final String getSubjectBirthCountry() {
        return handicapCompensationChildRequestData.getSubjectBirthCountry();
    }
  
    public final void setFatherActivityReduction(final Boolean fatherActivityReduction) {
        handicapCompensationChildRequestData.setFatherActivityReduction(fatherActivityReduction);
    }

    public final Boolean getFatherActivityReduction() {
        return handicapCompensationChildRequestData.getFatherActivityReduction();
    }
  
    public final void setProjectRequestsDisabilityCard(final Boolean projectRequestsDisabilityCard) {
        handicapCompensationChildRequestData.setProjectRequestsDisabilityCard(projectRequestsDisabilityCard);
    }

    public final Boolean getProjectRequestsDisabilityCard() {
        return handicapCompensationChildRequestData.getProjectRequestsDisabilityCard();
    }
  
    public final void setStudiesHighSchoolName(final String studiesHighSchoolName) {
        handicapCompensationChildRequestData.setStudiesHighSchoolName(studiesHighSchoolName);
    }

    public final String getStudiesHighSchoolName() {
        return handicapCompensationChildRequestData.getStudiesHighSchoolName();
    }
  
    public final void setDwellingReceptionType(final fr.cg95.cvq.business.request.social.HccrDwellingReceptionKindType dwellingReceptionType) {
        handicapCompensationChildRequestData.setDwellingReceptionType(dwellingReceptionType);
    }

    public final fr.cg95.cvq.business.request.social.HccrDwellingReceptionKindType getDwellingReceptionType() {
        return handicapCompensationChildRequestData.getDwellingReceptionType();
    }
  
    public final void setFatherLastName(final String fatherLastName) {
        handicapCompensationChildRequestData.setFatherLastName(fatherLastName);
    }

    public final String getFatherLastName() {
        return handicapCompensationChildRequestData.getFatherLastName();
    }
  
    public final void setMotherActivityReductionRatio(final java.math.BigInteger motherActivityReductionRatio) {
        handicapCompensationChildRequestData.setMotherActivityReductionRatio(motherActivityReductionRatio);
    }

    public final java.math.BigInteger getMotherActivityReductionRatio() {
        return handicapCompensationChildRequestData.getMotherActivityReductionRatio();
    }
  
    public final void setProfessionalStatusRegisterAsUnemployedDate(final java.util.Date professionalStatusRegisterAsUnemployedDate) {
        handicapCompensationChildRequestData.setProfessionalStatusRegisterAsUnemployedDate(professionalStatusRegisterAsUnemployedDate);
    }

    public final java.util.Date getProfessionalStatusRegisterAsUnemployedDate() {
        return handicapCompensationChildRequestData.getProfessionalStatusRegisterAsUnemployedDate();
    }
  
    public final void setPaymentAgencyName(final String paymentAgencyName) {
        handicapCompensationChildRequestData.setPaymentAgencyName(paymentAgencyName);
    }

    public final String getPaymentAgencyName() {
        return handicapCompensationChildRequestData.getPaymentAgencyName();
    }
  
    public final void setSocialSecurityAgencyName(final String socialSecurityAgencyName) {
        handicapCompensationChildRequestData.setSocialSecurityAgencyName(socialSecurityAgencyName);
    }

    public final String getSocialSecurityAgencyName() {
        return handicapCompensationChildRequestData.getSocialSecurityAgencyName();
    }
  
    public final void setDwellingReceptionNaming(final String dwellingReceptionNaming) {
        handicapCompensationChildRequestData.setDwellingReceptionNaming(dwellingReceptionNaming);
    }

    public final String getDwellingReceptionNaming() {
        return handicapCompensationChildRequestData.getDwellingReceptionNaming();
    }
  
    public final void setSchoolingSendToSchool(final Boolean schoolingSendToSchool) {
        handicapCompensationChildRequestData.setSchoolingSendToSchool(schoolingSendToSchool);
    }

    public final Boolean getSchoolingSendToSchool() {
        return handicapCompensationChildRequestData.getSchoolingSendToSchool();
    }
  
    public final void setBenefitsEducationOfDisabledChildren(final Boolean benefitsEducationOfDisabledChildren) {
        handicapCompensationChildRequestData.setBenefitsEducationOfDisabledChildren(benefitsEducationOfDisabledChildren);
    }

    public final Boolean getBenefitsEducationOfDisabledChildren() {
        return handicapCompensationChildRequestData.getBenefitsEducationOfDisabledChildren();
    }
  
    public final void setReferentFirstName(final String referentFirstName) {
        handicapCompensationChildRequestData.setReferentFirstName(referentFirstName);
    }

    public final String getReferentFirstName() {
        return handicapCompensationChildRequestData.getReferentFirstName();
    }
  
    public final void setFacilitiesTechnicalAssistanceDetails(final String facilitiesTechnicalAssistanceDetails) {
        handicapCompensationChildRequestData.setFacilitiesTechnicalAssistanceDetails(facilitiesTechnicalAssistanceDetails);
    }

    public final String getFacilitiesTechnicalAssistanceDetails() {
        return handicapCompensationChildRequestData.getFacilitiesTechnicalAssistanceDetails();
    }
  
    public final void setBenefitsOtherBenefits(final Boolean benefitsOtherBenefits) {
        handicapCompensationChildRequestData.setBenefitsOtherBenefits(benefitsOtherBenefits);
    }

    public final Boolean getBenefitsOtherBenefits() {
        return handicapCompensationChildRequestData.getBenefitsOtherBenefits();
    }
  
    public final void setFoldersCdesNumber(final String foldersCdesNumber) {
        handicapCompensationChildRequestData.setFoldersCdesNumber(foldersCdesNumber);
    }

    public final String getFoldersCdesNumber() {
        return handicapCompensationChildRequestData.getFoldersCdesNumber();
    }
  
    public final void setSocialServiceName(final String socialServiceName) {
        handicapCompensationChildRequestData.setSocialServiceName(socialServiceName);
    }

    public final String getSocialServiceName() {
        return handicapCompensationChildRequestData.getSocialServiceName();
    }
  
    public final void setBenefitsDisabilityCompensation(final Boolean benefitsDisabilityCompensation) {
        handicapCompensationChildRequestData.setBenefitsDisabilityCompensation(benefitsDisabilityCompensation);
    }

    public final Boolean getBenefitsDisabilityCompensation() {
        return handicapCompensationChildRequestData.getBenefitsDisabilityCompensation();
    }
  
    public final void setHealthDoctorFirstName(final String healthDoctorFirstName) {
        handicapCompensationChildRequestData.setHealthDoctorFirstName(healthDoctorFirstName);
    }

    public final String getHealthDoctorFirstName() {
        return handicapCompensationChildRequestData.getHealthDoctorFirstName();
    }
  
    public final void setProjectRequestsTechnicalHelp(final Boolean projectRequestsTechnicalHelp) {
        handicapCompensationChildRequestData.setProjectRequestsTechnicalHelp(projectRequestsTechnicalHelp);
    }

    public final Boolean getProjectRequestsTechnicalHelp() {
        return handicapCompensationChildRequestData.getProjectRequestsTechnicalHelp();
    }
  
    public final void setFacilitiesTechnicalAssistance(final Boolean facilitiesTechnicalAssistance) {
        handicapCompensationChildRequestData.setFacilitiesTechnicalAssistance(facilitiesTechnicalAssistance);
    }

    public final Boolean getFacilitiesTechnicalAssistance() {
        return handicapCompensationChildRequestData.getFacilitiesTechnicalAssistance();
    }
  
    public final void setBenefitsCompensatoryAllowanceForExpenses(final Boolean benefitsCompensatoryAllowanceForExpenses) {
        handicapCompensationChildRequestData.setBenefitsCompensatoryAllowanceForExpenses(benefitsCompensatoryAllowanceForExpenses);
    }

    public final Boolean getBenefitsCompensatoryAllowanceForExpenses() {
        return handicapCompensationChildRequestData.getBenefitsCompensatoryAllowanceForExpenses();
    }
  
    public final void setFacilitiesHousing(final Boolean facilitiesHousing) {
        handicapCompensationChildRequestData.setFacilitiesHousing(facilitiesHousing);
    }

    public final Boolean getFacilitiesHousing() {
        return handicapCompensationChildRequestData.getFacilitiesHousing();
    }
  
    public final void setHealthHospitalName(final String healthHospitalName) {
        handicapCompensationChildRequestData.setHealthHospitalName(healthHospitalName);
    }

    public final String getHealthHospitalName() {
        return handicapCompensationChildRequestData.getHealthHospitalName();
    }
  
    public final void setProjectRequestsDisabledPriorityCard(final Boolean projectRequestsDisabledPriorityCard) {
        handicapCompensationChildRequestData.setProjectRequestsDisabledPriorityCard(projectRequestsDisabledPriorityCard);
    }

    public final Boolean getProjectRequestsDisabledPriorityCard() {
        return handicapCompensationChildRequestData.getProjectRequestsDisabledPriorityCard();
    }
  
    public final void setProjectRequestsEducationAllocationOfDisabledChildren(final Boolean projectRequestsEducationAllocationOfDisabledChildren) {
        handicapCompensationChildRequestData.setProjectRequestsEducationAllocationOfDisabledChildren(projectRequestsEducationAllocationOfDisabledChildren);
    }

    public final Boolean getProjectRequestsEducationAllocationOfDisabledChildren() {
        return handicapCompensationChildRequestData.getProjectRequestsEducationAllocationOfDisabledChildren();
    }
  
    public final void setProjectRequestsOtherDetails(final String projectRequestsOtherDetails) {
        handicapCompensationChildRequestData.setProjectRequestsOtherDetails(projectRequestsOtherDetails);
    }

    public final String getProjectRequestsOtherDetails() {
        return handicapCompensationChildRequestData.getProjectRequestsOtherDetails();
    }
  
    public final void setSocialServiceSupport(final Boolean socialServiceSupport) {
        handicapCompensationChildRequestData.setSocialServiceSupport(socialServiceSupport);
    }

    public final Boolean getSocialServiceSupport() {
        return handicapCompensationChildRequestData.getSocialServiceSupport();
    }
  
    public final void setProjectRequestsShelteredWork(final Boolean projectRequestsShelteredWork) {
        handicapCompensationChildRequestData.setProjectRequestsShelteredWork(projectRequestsShelteredWork);
    }

    public final Boolean getProjectRequestsShelteredWork() {
        return handicapCompensationChildRequestData.getProjectRequestsShelteredWork();
    }
  
    public final void setFormationCurrentFormation(final String formationCurrentFormation) {
        handicapCompensationChildRequestData.setFormationCurrentFormation(formationCurrentFormation);
    }

    public final String getFormationCurrentFormation() {
        return handicapCompensationChildRequestData.getFormationCurrentFormation();
    }
  
    public final void setSchoolingSchoolingKind(final fr.cg95.cvq.business.request.social.HccrSchoolingKindType schoolingSchoolingKind) {
        handicapCompensationChildRequestData.setSchoolingSchoolingKind(schoolingSchoolingKind);
    }

    public final fr.cg95.cvq.business.request.social.HccrSchoolingKindType getSchoolingSchoolingKind() {
        return handicapCompensationChildRequestData.getSchoolingSchoolingKind();
    }
  
    public final void setStudiesAssistanceUnderDisability(final Boolean studiesAssistanceUnderDisability) {
        handicapCompensationChildRequestData.setStudiesAssistanceUnderDisability(studiesAssistanceUnderDisability);
    }

    public final Boolean getStudiesAssistanceUnderDisability() {
        return handicapCompensationChildRequestData.getStudiesAssistanceUnderDisability();
    }
  
    public final void setStudiesHighSchool(final Boolean studiesHighSchool) {
        handicapCompensationChildRequestData.setStudiesHighSchool(studiesHighSchool);
    }

    public final Boolean getStudiesHighSchool() {
        return handicapCompensationChildRequestData.getStudiesHighSchool();
    }
  
    public final void setHealthProfessionalFirstName(final String healthProfessionalFirstName) {
        handicapCompensationChildRequestData.setHealthProfessionalFirstName(healthProfessionalFirstName);
    }

    public final String getHealthProfessionalFirstName() {
        return handicapCompensationChildRequestData.getHealthProfessionalFirstName();
    }
  
    public final void setMotherActivityReduction(final Boolean motherActivityReduction) {
        handicapCompensationChildRequestData.setMotherActivityReduction(motherActivityReduction);
    }

    public final Boolean getMotherActivityReduction() {
        return handicapCompensationChildRequestData.getMotherActivityReduction();
    }
  
    public final void setFacilitiesCustomCarDetails(final String facilitiesCustomCarDetails) {
        handicapCompensationChildRequestData.setFacilitiesCustomCarDetails(facilitiesCustomCarDetails);
    }

    public final String getFacilitiesCustomCarDetails() {
        return handicapCompensationChildRequestData.getFacilitiesCustomCarDetails();
    }
  
    public final void setSchoolingPersonalizedSchoolingPlan(final Boolean schoolingPersonalizedSchoolingPlan) {
        handicapCompensationChildRequestData.setSchoolingPersonalizedSchoolingPlan(schoolingPersonalizedSchoolingPlan);
    }

    public final Boolean getSchoolingPersonalizedSchoolingPlan() {
        return handicapCompensationChildRequestData.getSchoolingPersonalizedSchoolingPlan();
    }
  
    public final void setDwellingPrecision(final String dwellingPrecision) {
        handicapCompensationChildRequestData.setDwellingPrecision(dwellingPrecision);
    }

    public final String getDwellingPrecision() {
        return handicapCompensationChildRequestData.getDwellingPrecision();
    }
  
    public final void setBenefitsDisabilityCard(final Boolean benefitsDisabilityCard) {
        handicapCompensationChildRequestData.setBenefitsDisabilityCard(benefitsDisabilityCard);
    }

    public final Boolean getBenefitsDisabilityCard() {
        return handicapCompensationChildRequestData.getBenefitsDisabilityCard();
    }
  
    public final void setSocialSecurityMemberShipKind(final fr.cg95.cvq.business.request.social.HccrSocialSecurityMemberShipKindType socialSecurityMemberShipKind) {
        handicapCompensationChildRequestData.setSocialSecurityMemberShipKind(socialSecurityMemberShipKind);
    }

    public final fr.cg95.cvq.business.request.social.HccrSocialSecurityMemberShipKindType getSocialSecurityMemberShipKind() {
        return handicapCompensationChildRequestData.getSocialSecurityMemberShipKind();
    }
  
    public final void setAseReferentLastName(final String aseReferentLastName) {
        handicapCompensationChildRequestData.setAseReferentLastName(aseReferentLastName);
    }

    public final String getAseReferentLastName() {
        return handicapCompensationChildRequestData.getAseReferentLastName();
    }
  
    public final void setProfessionalStatusElectiveFunctionDetails(final String professionalStatusElectiveFunctionDetails) {
        handicapCompensationChildRequestData.setProfessionalStatusElectiveFunctionDetails(professionalStatusElectiveFunctionDetails);
    }

    public final String getProfessionalStatusElectiveFunctionDetails() {
        return handicapCompensationChildRequestData.getProfessionalStatusElectiveFunctionDetails();
    }
  
    public final void setFacilitiesAnimalAid(final Boolean facilitiesAnimalAid) {
        handicapCompensationChildRequestData.setFacilitiesAnimalAid(facilitiesAnimalAid);
    }

    public final Boolean getFacilitiesAnimalAid() {
        return handicapCompensationChildRequestData.getFacilitiesAnimalAid();
    }
  
    public final void setStudiesHighSchoolAddress(final fr.cg95.cvq.business.users.Address studiesHighSchoolAddress) {
        handicapCompensationChildRequestData.setStudiesHighSchoolAddress(studiesHighSchoolAddress);
    }

    public final fr.cg95.cvq.business.users.Address getStudiesHighSchoolAddress() {
        return handicapCompensationChildRequestData.getStudiesHighSchoolAddress();
    }
  
}
