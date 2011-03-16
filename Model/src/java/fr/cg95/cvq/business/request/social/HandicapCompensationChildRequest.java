
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
import org.joda.time.LocalTime;

import net.sf.oval.constraint.AssertValid;
import org.apache.xmlbeans.XmlOptions;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.request.annotation.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 */
public class HandicapCompensationChildRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = HandicapCompensationChildRequestData.conditions;

    @AssertValid(message = "")
    private HandicapCompensationChildRequestData handicapCompensationChildRequestData;

    public HandicapCompensationChildRequest(RequestData requestData, HandicapCompensationChildRequestData handicapCompensationChildRequestData) {
        super(requestData);
        this.handicapCompensationChildRequestData = handicapCompensationChildRequestData;
    }

    public HandicapCompensationChildRequest() {
        super();
        this.handicapCompensationChildRequestData = new HandicapCompensationChildRequestData();
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("subject", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("dwelling", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("socialSecurityAndPaymentAgency", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("occupationnalAndSchoolStatus", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("folders", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("benefits", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("aid", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("health", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("project", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", false);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("document", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("validation", stepState);
        
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
        LocalTime localTime = new LocalTime();
        Date date = null;
        HandicapCompensationChildRequestDocument handicapCompensationChildRequestDoc = HandicapCompensationChildRequestDocument.Factory.newInstance();
        HandicapCompensationChildRequestDocument.HandicapCompensationChildRequest handicapCompensationChildRequest = handicapCompensationChildRequestDoc.addNewHandicapCompensationChildRequest();
        super.fillCommonXmlInfo(handicapCompensationChildRequest);
        int i = 0;
        
        i = 0;
        if (getAdditionalFee() != null) {
            fr.cg95.cvq.xml.request.social.HccrAdditionalFeeType[] additionalFeeTypeTab = new fr.cg95.cvq.xml.request.social.HccrAdditionalFeeType[getAdditionalFee().size()];
            for (HccrAdditionalFee object : getAdditionalFee()) {
              additionalFeeTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationChildRequest.setAdditionalFeeArray(additionalFeeTypeTab);
        }
        HccrAseReferent hccrAseReferentAseReferent = handicapCompensationChildRequest.addNewAseReferent();
        hccrAseReferentAseReferent.setAseReferentDepartment(getAseReferentDepartment());
      
        hccrAseReferentAseReferent.setAseReferentLastName(getAseReferentLastName());
        HccrBenefitsType hccrBenefitsTypeBenefits = handicapCompensationChildRequest.addNewBenefits();
        if (getBenefitsCompensatoryAllowanceForExpenses() != null)
            hccrBenefitsTypeBenefits.setBenefitsCompensatoryAllowanceForExpenses(getBenefitsCompensatoryAllowanceForExpenses().booleanValue());
      
        if (getBenefitsDailyAllowances() != null)
            hccrBenefitsTypeBenefits.setBenefitsDailyAllowances(getBenefitsDailyAllowances().booleanValue());
      
        if (getBenefitsDisabilityCard() != null)
            hccrBenefitsTypeBenefits.setBenefitsDisabilityCard(getBenefitsDisabilityCard().booleanValue());
      
        if (getBenefitsDisabilityCompensation() != null)
            hccrBenefitsTypeBenefits.setBenefitsDisabilityCompensation(getBenefitsDisabilityCompensation().booleanValue());
      
        if (getBenefitsDisabilityPension() != null)
            hccrBenefitsTypeBenefits.setBenefitsDisabilityPension(getBenefitsDisabilityPension().booleanValue());
      
        hccrBenefitsTypeBenefits.setBenefitsDisabilityPensionCategory(getBenefitsDisabilityPensionCategory());
      
        hccrBenefitsTypeBenefits.setBenefitsDisabilityRatio(getBenefitsDisabilityRatio());
      
        if (getBenefitsDisabilityRecognition() != null)
            hccrBenefitsTypeBenefits.setBenefitsDisabilityRecognition(getBenefitsDisabilityRecognition().booleanValue());
      
        if (getBenefitsDisabledAdultAllocation() != null)
            hccrBenefitsTypeBenefits.setBenefitsDisabledAdultAllocation(getBenefitsDisabledAdultAllocation().booleanValue());
      
        if (getBenefitsDisabledWorkerRecognition() != null)
            hccrBenefitsTypeBenefits.setBenefitsDisabledWorkerRecognition(getBenefitsDisabledWorkerRecognition().booleanValue());
      
        if (getBenefitsEducationAllocationOfDisabledChildren() != null)
            hccrBenefitsTypeBenefits.setBenefitsEducationAllocationOfDisabledChildren(getBenefitsEducationAllocationOfDisabledChildren().booleanValue());
      
        if (getBenefitsEducationOfDisabledChildren() != null)
            hccrBenefitsTypeBenefits.setBenefitsEducationOfDisabledChildren(getBenefitsEducationOfDisabledChildren().booleanValue());
      
        hccrBenefitsTypeBenefits.setBenefitsEducationOfDisabledChildrenDetails(getBenefitsEducationOfDisabledChildrenDetails());
      
        if (getBenefitsIncreaseForIndependentLiving() != null)
            hccrBenefitsTypeBenefits.setBenefitsIncreaseForIndependentLiving(getBenefitsIncreaseForIndependentLiving().booleanValue());
      
        if (getBenefitsOtherBenefits() != null)
            hccrBenefitsTypeBenefits.setBenefitsOtherBenefits(getBenefitsOtherBenefits().booleanValue());
      
        if (getBenefitsPainfulStandingCard() != null)
            hccrBenefitsTypeBenefits.setBenefitsPainfulStandingCard(getBenefitsPainfulStandingCard().booleanValue());
      
        if (getBenefitsParkingCard() != null)
            hccrBenefitsTypeBenefits.setBenefitsParkingCard(getBenefitsParkingCard().booleanValue());
      
        if (getBenefitsProfessionalOrientation() != null)
            hccrBenefitsTypeBenefits.setBenefitsProfessionalOrientation(getBenefitsProfessionalOrientation().booleanValue());
      
        hccrBenefitsTypeBenefits.setBenefitsProfessionalOrientationDetails(getBenefitsProfessionalOrientationDetails());
      
        if (getBenefitsSocialWelfare() != null)
            hccrBenefitsTypeBenefits.setBenefitsSocialWelfare(getBenefitsSocialWelfare().booleanValue());
      
        if (getBenefitsSupplementForSingleParents() != null)
            hccrBenefitsTypeBenefits.setBenefitsSupplementForSingleParents(getBenefitsSupplementForSingleParents().booleanValue());
      
        if (getBenefitsSupportedByAnInstitution() != null)
            hccrBenefitsTypeBenefits.setBenefitsSupportedByAnInstitution(getBenefitsSupportedByAnInstitution().booleanValue());
      
        hccrBenefitsTypeBenefits.setBenefitsSupportedByAnInstitutionDetails(getBenefitsSupportedByAnInstitutionDetails());
      
        if (getBenefitsThirdPartyCompensatoryAllowance() != null)
            hccrBenefitsTypeBenefits.setBenefitsThirdPartyCompensatoryAllowance(getBenefitsThirdPartyCompensatoryAllowance().booleanValue());
      
        if (getBenefitsThirdPartySupplement() != null)
            hccrBenefitsTypeBenefits.setBenefitsThirdPartySupplement(getBenefitsThirdPartySupplement().booleanValue());
      
        if (getBenefitsThirdPersonCompensatoryAllowance() != null)
            hccrBenefitsTypeBenefits.setBenefitsThirdPersonCompensatoryAllowance(getBenefitsThirdPersonCompensatoryAllowance().booleanValue());
      
        if (getBenefitsUnemploymentBenefits() != null)
            hccrBenefitsTypeBenefits.setBenefitsUnemploymentBenefits(getBenefitsUnemploymentBenefits().booleanValue());
      
        if (getBenefitsWorkAccidentAnnuity() != null)
            hccrBenefitsTypeBenefits.setBenefitsWorkAccidentAnnuity(getBenefitsWorkAccidentAnnuity().booleanValue());
      
        hccrBenefitsTypeBenefits.setBenefitsWorkAccidentAnnuityRatio(getBenefitsWorkAccidentAnnuityRatio());
        HccrCareType hccrCareTypeCare = handicapCompensationChildRequest.addNewCare();
        if (getCareCareServices() != null)
            hccrCareTypeCare.setCareCareServices(getCareCareServices().booleanValue());
      
        i = 0;
        if (getCareServices() != null) {
            fr.cg95.cvq.xml.request.social.HccrCareServiceType[] careServicesTypeTab = new fr.cg95.cvq.xml.request.social.HccrCareServiceType[getCareServices().size()];
            for (HccrCareService object : getCareServices()) {
              careServicesTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationChildRequest.setCareServicesArray(careServicesTypeTab);
        }
        HccrDwellingType hccrDwellingTypeDwelling = handicapCompensationChildRequest.addNewDwelling();
        if (getDwellingEstablishmentReception() != null)
            hccrDwellingTypeDwelling.setDwellingEstablishmentReception(getDwellingEstablishmentReception().booleanValue());
      
        if (getDwellingKind() != null)
            hccrDwellingTypeDwelling.setDwellingKind(fr.cg95.cvq.xml.request.social.HccrDwellingKindType.Enum.forString(getDwellingKind().toString()));
      
        hccrDwellingTypeDwelling.setDwellingPrecision(getDwellingPrecision());
      
        if (getDwellingReceptionAddress() != null)
            hccrDwellingTypeDwelling.setDwellingReceptionAddress(Address.modelToXml(getDwellingReceptionAddress()));
      
        hccrDwellingTypeDwelling.setDwellingReceptionNaming(getDwellingReceptionNaming());
      
        if (getDwellingReceptionType() != null)
            hccrDwellingTypeDwelling.setDwellingReceptionType(fr.cg95.cvq.xml.request.social.HccrDwellingReceptionKindType.Enum.forString(getDwellingReceptionType().toString()));
      
        if (getDwellingSocialReception() != null)
            hccrDwellingTypeDwelling.setDwellingSocialReception(getDwellingSocialReception().booleanValue());
      
        if (getDwellingSocialReceptionAddress() != null)
            hccrDwellingTypeDwelling.setDwellingSocialReceptionAddress(Address.modelToXml(getDwellingSocialReceptionAddress()));
      
        hccrDwellingTypeDwelling.setDwellingSocialReceptionNaming(getDwellingSocialReceptionNaming());
        HccrFacilitiesType hccrFacilitiesTypeFacilities = handicapCompensationChildRequest.addNewFacilities();
        if (getFacilitiesAnimalAid() != null)
            hccrFacilitiesTypeFacilities.setFacilitiesAnimalAid(getFacilitiesAnimalAid().booleanValue());
      
        hccrFacilitiesTypeFacilities.setFacilitiesAnimalAidDetails(getFacilitiesAnimalAidDetails());
      
        if (getFacilitiesCustomCar() != null)
            hccrFacilitiesTypeFacilities.setFacilitiesCustomCar(getFacilitiesCustomCar().booleanValue());
      
        hccrFacilitiesTypeFacilities.setFacilitiesCustomCarDetails(getFacilitiesCustomCarDetails());
      
        if (getFacilitiesHousing() != null)
            hccrFacilitiesTypeFacilities.setFacilitiesHousing(getFacilitiesHousing().booleanValue());
      
        hccrFacilitiesTypeFacilities.setFacilitiesHousingDetails(getFacilitiesHousingDetails());
      
        if (getFacilitiesSpecializedTransport() != null)
            hccrFacilitiesTypeFacilities.setFacilitiesSpecializedTransport(getFacilitiesSpecializedTransport().booleanValue());
      
        hccrFacilitiesTypeFacilities.setFacilitiesSpecializedTransportDetails(getFacilitiesSpecializedTransportDetails());
      
        if (getFacilitiesTechnicalAssistance() != null)
            hccrFacilitiesTypeFacilities.setFacilitiesTechnicalAssistance(getFacilitiesTechnicalAssistance().booleanValue());
      
        hccrFacilitiesTypeFacilities.setFacilitiesTechnicalAssistanceDetails(getFacilitiesTechnicalAssistanceDetails());
      
        i = 0;
        if (getFamilyAssistanceMembers() != null) {
            fr.cg95.cvq.xml.request.social.HccrFamilyAssistanceMemberType[] familyAssistanceMembersTypeTab = new fr.cg95.cvq.xml.request.social.HccrFamilyAssistanceMemberType[getFamilyAssistanceMembers().size()];
            for (HccrFamilyAssistanceMember object : getFamilyAssistanceMembers()) {
              familyAssistanceMembersTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationChildRequest.setFamilyAssistanceMembersArray(familyAssistanceMembersTypeTab);
        }
      
        i = 0;
        if (getFamilyDependents() != null) {
            fr.cg95.cvq.xml.request.social.HccrFamilyDependentType[] familyDependentsTypeTab = new fr.cg95.cvq.xml.request.social.HccrFamilyDependentType[getFamilyDependents().size()];
            for (HccrFamilyDependent object : getFamilyDependents()) {
              familyDependentsTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationChildRequest.setFamilyDependentsArray(familyDependentsTypeTab);
        }
        HccrFather hccrFatherFather = handicapCompensationChildRequest.addNewFather();
        if (getFatherActivityReduction() != null)
            hccrFatherFather.setFatherActivityReduction(getFatherActivityReduction().booleanValue());
      
        if (getFatherActivityReductionRatio() != null)
            hccrFatherFather.setFatherActivityReductionRatio(new BigInteger(getFatherActivityReductionRatio().toString()));
      
        hccrFatherFather.setFatherFirstName(getFatherFirstName());
      
        hccrFatherFather.setFatherJob(getFatherJob());
      
        hccrFatherFather.setFatherLastName(getFatherLastName());
        HccrFoldersType hccrFoldersTypeFolders = handicapCompensationChildRequest.addNewFolders();
        if (getFoldersCdes() != null)
            hccrFoldersTypeFolders.setFoldersCdes(getFoldersCdes().booleanValue());
      
        hccrFoldersTypeFolders.setFoldersCdesDepartment(getFoldersCdesDepartment());
      
        hccrFoldersTypeFolders.setFoldersCdesNumber(getFoldersCdesNumber());
      
        if (getFoldersCotorep() != null)
            hccrFoldersTypeFolders.setFoldersCotorep(getFoldersCotorep().booleanValue());
      
        hccrFoldersTypeFolders.setFoldersCotorepDepartment(getFoldersCotorepDepartment());
      
        hccrFoldersTypeFolders.setFoldersCotorepNumber(getFoldersCotorepNumber());
      
        if (getFoldersMdph() != null)
            hccrFoldersTypeFolders.setFoldersMdph(getFoldersMdph().booleanValue());
      
        hccrFoldersTypeFolders.setFoldersMdphDepartment(getFoldersMdphDepartment());
      
        hccrFoldersTypeFolders.setFoldersMdphNumber(getFoldersMdphNumber());
      
        if (getFoldersOtherFolders() != null)
            hccrFoldersTypeFolders.setFoldersOtherFolders(getFoldersOtherFolders().booleanValue());
        HccrFormationType hccrFormationTypeFormation = handicapCompensationChildRequest.addNewFormation();
        hccrFormationTypeFormation.setFormationCurrentFormation(getFormationCurrentFormation());
      
        hccrFormationTypeFormation.setFormationDiploma(getFormationDiploma());
      
        hccrFormationTypeFormation.setFormationPreviousFormation(getFormationPreviousFormation());
      
        hccrFormationTypeFormation.setFormationStudiesLevel(getFormationStudiesLevel());
        HccrHealthType hccrHealthTypeHealth = handicapCompensationChildRequest.addNewHealth();
        hccrHealthTypeHealth.setHealthDoctorFirstName(getHealthDoctorFirstName());
      
        hccrHealthTypeHealth.setHealthDoctorLastName(getHealthDoctorLastName());
      
        if (getHealthFollowedByDoctor() != null)
            hccrHealthTypeHealth.setHealthFollowedByDoctor(getHealthFollowedByDoctor().booleanValue());
      
        if (getHealthFollowedByHospital() != null)
            hccrHealthTypeHealth.setHealthFollowedByHospital(getHealthFollowedByHospital().booleanValue());
      
        if (getHealthFollowedByProfessional() != null)
            hccrHealthTypeHealth.setHealthFollowedByProfessional(getHealthFollowedByProfessional().booleanValue());
      
        hccrHealthTypeHealth.setHealthHospitalName(getHealthHospitalName());
      
        hccrHealthTypeHealth.setHealthProfessionalFirstName(getHealthProfessionalFirstName());
      
        hccrHealthTypeHealth.setHealthProfessionalLastName(getHealthProfessionalLastName());
      
        i = 0;
        if (getHomeIntervenants() != null) {
            fr.cg95.cvq.xml.request.social.HccrHomeIntervenantType[] homeIntervenantsTypeTab = new fr.cg95.cvq.xml.request.social.HccrHomeIntervenantType[getHomeIntervenants().size()];
            for (HccrHomeIntervenant object : getHomeIntervenants()) {
              homeIntervenantsTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationChildRequest.setHomeIntervenantsArray(homeIntervenantsTypeTab);
        }
        HccrHomeInterventionType hccrHomeInterventionTypeHomeIntervention = handicapCompensationChildRequest.addNewHomeIntervention();
        if (getHomeInterventionHomeIntervenant() != null)
            hccrHomeInterventionTypeHomeIntervention.setHomeInterventionHomeIntervenant(getHomeInterventionHomeIntervenant().booleanValue());
        HccrFamilyAssistanceType hccrFamilyAssistanceTypeFamilyAssistance = handicapCompensationChildRequest.addNewFamilyAssistance();
        if (getIsFamilyAssistance() != null)
            hccrFamilyAssistanceTypeFamilyAssistance.setIsFamilyAssistance(getIsFamilyAssistance().booleanValue());
        HccrMother hccrMotherMother = handicapCompensationChildRequest.addNewMother();
        if (getMotherActivityReduction() != null)
            hccrMotherMother.setMotherActivityReduction(getMotherActivityReduction().booleanValue());
      
        if (getMotherActivityReductionRatio() != null)
            hccrMotherMother.setMotherActivityReductionRatio(new BigInteger(getMotherActivityReductionRatio().toString()));
      
        hccrMotherMother.setMotherFirstName(getMotherFirstName());
      
        hccrMotherMother.setMotherJob(getMotherJob());
      
        hccrMotherMother.setMotherLastName(getMotherLastName());
      
        i = 0;
        if (getOtherBenefits() != null) {
            fr.cg95.cvq.xml.request.social.HccrOtherBenefitType[] otherBenefitsTypeTab = new fr.cg95.cvq.xml.request.social.HccrOtherBenefitType[getOtherBenefits().size()];
            for (HccrOtherBenefit object : getOtherBenefits()) {
              otherBenefitsTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationChildRequest.setOtherBenefitsArray(otherBenefitsTypeTab);
        }
      
        i = 0;
        if (getOtherFolders() != null) {
            fr.cg95.cvq.xml.request.social.HccrOtherFolderType[] otherFoldersTypeTab = new fr.cg95.cvq.xml.request.social.HccrOtherFolderType[getOtherFolders().size()];
            for (HccrOtherFolder object : getOtherFolders()) {
              otherFoldersTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationChildRequest.setOtherFoldersArray(otherFoldersTypeTab);
        }
        HccrPaymentAgencyType hccrPaymentAgencyTypePaymentAgency = handicapCompensationChildRequest.addNewPaymentAgency();
        if (getPaymentAgencyAddress() != null)
            hccrPaymentAgencyTypePaymentAgency.setPaymentAgencyAddress(Address.modelToXml(getPaymentAgencyAddress()));
      
        if (getPaymentAgencyBeneficiary() != null)
            hccrPaymentAgencyTypePaymentAgency.setPaymentAgencyBeneficiary(fr.cg95.cvq.xml.request.social.HccrPaymentAgencyBeneficiaryType.Enum.forString(getPaymentAgencyBeneficiary().toString()));
      
        hccrPaymentAgencyTypePaymentAgency.setPaymentAgencyBeneficiaryNumber(getPaymentAgencyBeneficiaryNumber());
      
        hccrPaymentAgencyTypePaymentAgency.setPaymentAgencyName(getPaymentAgencyName());
        HccrProfessionalStatusType hccrProfessionalStatusTypeProfessionalStatus = handicapCompensationChildRequest.addNewProfessionalStatus();
        if (getProfessionalStatusAddress() != null)
            hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusAddress(Address.modelToXml(getProfessionalStatusAddress()));
      
        date = getProfessionalStatusDate();
        if (date != null) {
            calendar.setTime(date);
            hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusDate(calendar);
        }
      
        if (getProfessionalStatusElectiveFunction() != null)
            hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusElectiveFunction(getProfessionalStatusElectiveFunction().booleanValue());
      
        hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusElectiveFunctionDetails(getProfessionalStatusElectiveFunctionDetails());
      
        hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusEmployerName(getProfessionalStatusEmployerName());
      
        if (getProfessionalStatusEnvironment() != null)
            hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusEnvironment(fr.cg95.cvq.xml.request.social.HccrProfessionalStatusEnvironmentType.Enum.forString(getProfessionalStatusEnvironment().toString()));
      
        if (getProfessionalStatusIndemnified() != null)
            hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusIndemnified(getProfessionalStatusIndemnified().booleanValue());
      
        date = getProfessionalStatusIndemnifiedDate();
        if (date != null) {
            calendar.setTime(date);
            hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusIndemnifiedDate(calendar);
        }
      
        if (getProfessionalStatusKind() != null)
            hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusKind(fr.cg95.cvq.xml.request.social.HccrProfessionalStatusKindType.Enum.forString(getProfessionalStatusKind().toString()));
      
        hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusProfession(getProfessionalStatusProfession());
      
        if (getProfessionalStatusRegisterAsUnemployed() != null)
            hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusRegisterAsUnemployed(getProfessionalStatusRegisterAsUnemployed().booleanValue());
      
        date = getProfessionalStatusRegisterAsUnemployedDate();
        if (date != null) {
            calendar.setTime(date);
            hccrProfessionalStatusTypeProfessionalStatus.setProfessionalStatusRegisterAsUnemployedDate(calendar);
        }
        HccrProfessionalSupportType hccrProfessionalSupportTypeProfessionalSupport = handicapCompensationChildRequest.addNewProfessionalSupport();
        if (getProfessionalSupportDealsWithSameProfessional() != null)
            hccrProfessionalSupportTypeProfessionalSupport.setProfessionalSupportDealsWithSameProfessional(getProfessionalSupportDealsWithSameProfessional().booleanValue());
      
        if (getProfessionalSupportProfessionals() != null)
            hccrProfessionalSupportTypeProfessionalSupport.setProfessionalSupportProfessionals(getProfessionalSupportProfessionals().booleanValue());
      
        i = 0;
        if (getProfessionals() != null) {
            fr.cg95.cvq.xml.request.social.HccrProfessionalType[] professionalsTypeTab = new fr.cg95.cvq.xml.request.social.HccrProfessionalType[getProfessionals().size()];
            for (HccrProfessional object : getProfessionals()) {
              professionalsTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationChildRequest.setProfessionalsArray(professionalsTypeTab);
        }
      
        handicapCompensationChildRequest.setProjectComments(getProjectComments());
      
        handicapCompensationChildRequest.setProjectNeeds(getProjectNeeds());
        HccrProjectRequestsType hccrProjectRequestsTypeProjectRequests = handicapCompensationChildRequest.addNewProjectRequests();
        if (getProjectRequestsACTPRenewal() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsACTPRenewal(getProjectRequestsACTPRenewal().booleanValue());
      
        if (getProjectRequestsAssistance() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsAssistance(getProjectRequestsAssistance().booleanValue());
      
        if (getProjectRequestsCustomCar() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsCustomCar(getProjectRequestsCustomCar().booleanValue());
      
        if (getProjectRequestsDisabilityCard() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsDisabilityCard(getProjectRequestsDisabilityCard().booleanValue());
      
        if (getProjectRequestsDisabilityCostAllocation() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsDisabilityCostAllocation(getProjectRequestsDisabilityCostAllocation().booleanValue());
      
        if (getProjectRequestsDisabledAdultAllowance() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsDisabledAdultAllowance(getProjectRequestsDisabledAdultAllowance().booleanValue());
      
        if (getProjectRequestsDisabledPriorityCard() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsDisabledPriorityCard(getProjectRequestsDisabledPriorityCard().booleanValue());
      
        if (getProjectRequestsDisabledWorkerRecognition() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsDisabledWorkerRecognition(getProjectRequestsDisabledWorkerRecognition().booleanValue());
      
        if (getProjectRequestsEducationAllocationOfDisabledChildren() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsEducationAllocationOfDisabledChildren(getProjectRequestsEducationAllocationOfDisabledChildren().booleanValue());
      
        if (getProjectRequestsEuropeanParkingCard() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsEuropeanParkingCard(getProjectRequestsEuropeanParkingCard().booleanValue());
      
        if (getProjectRequestsFreePensionMembership() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsFreePensionMembership(getProjectRequestsFreePensionMembership().booleanValue());
      
        if (getProjectRequestsHandicapRecognition() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsHandicapRecognition(getProjectRequestsHandicapRecognition().booleanValue());
      
        if (getProjectRequestsHousingFacilities() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsHousingFacilities(getProjectRequestsHousingFacilities().booleanValue());
      
        if (getProjectRequestsIncreaseForIndependentLiving() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsIncreaseForIndependentLiving(getProjectRequestsIncreaseForIndependentLiving().booleanValue());
      
        if (getProjectRequestsInstitutionSupport() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsInstitutionSupport(getProjectRequestsInstitutionSupport().booleanValue());
      
        if (getProjectRequestsOrdinaryWorking() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsOrdinaryWorking(getProjectRequestsOrdinaryWorking().booleanValue());
      
        if (getProjectRequestsOther() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsOther(getProjectRequestsOther().booleanValue());
      
        hccrProjectRequestsTypeProjectRequests.setProjectRequestsOtherDetails(getProjectRequestsOtherDetails());
      
        if (getProjectRequestsProfessionalOrientation() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsProfessionalOrientation(getProjectRequestsProfessionalOrientation().booleanValue());
      
        if (getProjectRequestsShelteredWork() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsShelteredWork(getProjectRequestsShelteredWork().booleanValue());
      
        if (getProjectRequestsTechnicalHelp() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsTechnicalHelp(getProjectRequestsTechnicalHelp().booleanValue());
      
        if (getProjectRequestsThirdPartyHelp() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsThirdPartyHelp(getProjectRequestsThirdPartyHelp().booleanValue());
      
        if (getProjectRequestsTransportCostAllocation() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsTransportCostAllocation(getProjectRequestsTransportCostAllocation().booleanValue());
      
        if (getProjectRequestsVocationalTraining() != null)
            hccrProjectRequestsTypeProjectRequests.setProjectRequestsVocationalTraining(getProjectRequestsVocationalTraining().booleanValue());
      
        handicapCompensationChildRequest.setProjectWish(getProjectWish());
        HccrReferent hccrReferentReferent = handicapCompensationChildRequest.addNewReferent();
        hccrReferentReferent.setReferentBirthCity(getReferentBirthCity());
      
        hccrReferentReferent.setReferentBirthCountry(getReferentBirthCountry());
      
        date = getReferentBirthDate();
        if (date != null) {
            calendar.setTime(date);
            hccrReferentReferent.setReferentBirthDate(calendar);
        }
      
        if (getReferentFamilyDependents() != null)
            hccrReferentReferent.setReferentFamilyDependents(getReferentFamilyDependents().booleanValue());
      
        if (getReferentFamilyStatus() != null)
            hccrReferentReferent.setReferentFamilyStatus(fr.cg95.cvq.xml.common.FamilyStatusType.Enum.forString(getReferentFamilyStatus().toString()));
      
        hccrReferentReferent.setReferentFirstName(getReferentFirstName());
      
        hccrReferentReferent.setReferentLastName(getReferentLastName());
      
        hccrReferentReferent.setReferentMaidenName(getReferentMaidenName());
      
        if (getReferentTitle() != null)
            hccrReferentReferent.setReferentTitle(fr.cg95.cvq.xml.common.TitleType.Enum.forString(getReferentTitle().toString()));
        HccrSchoolingType hccrSchoolingTypeSchooling = handicapCompensationChildRequest.addNewSchooling();
        if (getSchoolingAttendedGrade() != null)
            hccrSchoolingTypeSchooling.setSchoolingAttendedGrade(fr.cg95.cvq.xml.common.SectionType.Enum.forString(getSchoolingAttendedGrade().toString()));
      
        if (getSchoolingEnrolment() != null)
            hccrSchoolingTypeSchooling.setSchoolingEnrolment(getSchoolingEnrolment().booleanValue());
      
        if (getSchoolingExtraCurricular() != null)
            hccrSchoolingTypeSchooling.setSchoolingExtraCurricular(getSchoolingExtraCurricular().booleanValue());
      
        hccrSchoolingTypeSchooling.setSchoolingExtraCurricularDetails(getSchoolingExtraCurricularDetails());
      
        if (getSchoolingHomeSchooling() != null)
            hccrSchoolingTypeSchooling.setSchoolingHomeSchooling(getSchoolingHomeSchooling().booleanValue());
      
        if (getSchoolingHomeSchoolingAccompanistAddress() != null)
            hccrSchoolingTypeSchooling.setSchoolingHomeSchoolingAccompanistAddress(Address.modelToXml(getSchoolingHomeSchoolingAccompanistAddress()));
      
        hccrSchoolingTypeSchooling.setSchoolingHomeSchoolingAccompanistFirstName(getSchoolingHomeSchoolingAccompanistFirstName());
      
        hccrSchoolingTypeSchooling.setSchoolingHomeSchoolingAccompanistLastName(getSchoolingHomeSchoolingAccompanistLastName());
      
        if (getSchoolingHomeSchoolingKind() != null)
            hccrSchoolingTypeSchooling.setSchoolingHomeSchoolingKind(fr.cg95.cvq.xml.request.social.HccrHomeSchoolingKindType.Enum.forString(getSchoolingHomeSchoolingKind().toString()));
      
        if (getSchoolingPersonalizedSchoolingPlan() != null)
            hccrSchoolingTypeSchooling.setSchoolingPersonalizedSchoolingPlan(getSchoolingPersonalizedSchoolingPlan().booleanValue());
      
        if (getSchoolingSchoolAddress() != null)
            hccrSchoolingTypeSchooling.setSchoolingSchoolAddress(Address.modelToXml(getSchoolingSchoolAddress()));
      
        hccrSchoolingTypeSchooling.setSchoolingSchoolName(getSchoolingSchoolName());
      
        if (getSchoolingSchoolingKind() != null)
            hccrSchoolingTypeSchooling.setSchoolingSchoolingKind(fr.cg95.cvq.xml.request.social.HccrSchoolingKindType.Enum.forString(getSchoolingSchoolingKind().toString()));
      
        if (getSchoolingSendToSchool() != null)
            hccrSchoolingTypeSchooling.setSchoolingSendToSchool(getSchoolingSendToSchool().booleanValue());
      
        if (getSchoolingSpecializedGrade() != null)
            hccrSchoolingTypeSchooling.setSchoolingSpecializedGrade(getSchoolingSpecializedGrade().booleanValue());
      
        hccrSchoolingTypeSchooling.setSchoolingSpecializedGradeDetails(getSchoolingSpecializedGradeDetails());
      
        hccrSchoolingTypeSchooling.setSchoolingTime(getSchoolingTime());
        HccrSocialSecurityType hccrSocialSecurityTypeSocialSecurity = handicapCompensationChildRequest.addNewSocialSecurity();
        if (getSocialSecurityAgencyAddress() != null)
            hccrSocialSecurityTypeSocialSecurity.setSocialSecurityAgencyAddress(Address.modelToXml(getSocialSecurityAgencyAddress()));
      
        hccrSocialSecurityTypeSocialSecurity.setSocialSecurityAgencyName(getSocialSecurityAgencyName());
      
        if (getSocialSecurityMemberShipKind() != null)
            hccrSocialSecurityTypeSocialSecurity.setSocialSecurityMemberShipKind(fr.cg95.cvq.xml.request.social.HccrSocialSecurityMemberShipKindType.Enum.forString(getSocialSecurityMemberShipKind().toString()));
      
        hccrSocialSecurityTypeSocialSecurity.setSocialSecurityNumber(getSocialSecurityNumber());
        HccrSocialServiceType hccrSocialServiceTypeSocialService = handicapCompensationChildRequest.addNewSocialService();
        if (getSocialServiceAddress() != null)
            hccrSocialServiceTypeSocialService.setSocialServiceAddress(Address.modelToXml(getSocialServiceAddress()));
      
        hccrSocialServiceTypeSocialService.setSocialServiceName(getSocialServiceName());
      
        if (getSocialServiceSupport() != null)
            hccrSocialServiceTypeSocialService.setSocialServiceSupport(getSocialServiceSupport().booleanValue());
        HccrStudiesType hccrStudiesTypeStudies = handicapCompensationChildRequest.addNewStudies();
        if (getStudiesAssistanceUnderDisability() != null)
            hccrStudiesTypeStudies.setStudiesAssistanceUnderDisability(getStudiesAssistanceUnderDisability().booleanValue());
      
        hccrStudiesTypeStudies.setStudiesAssistanceUnderDisabilityDetails(getStudiesAssistanceUnderDisabilityDetails());
      
        if (getStudiesHighSchool() != null)
            hccrStudiesTypeStudies.setStudiesHighSchool(getStudiesHighSchool().booleanValue());
      
        if (getStudiesHighSchoolAddress() != null)
            hccrStudiesTypeStudies.setStudiesHighSchoolAddress(Address.modelToXml(getStudiesHighSchoolAddress()));
      
        hccrStudiesTypeStudies.setStudiesHighSchoolGrade(getStudiesHighSchoolGrade());
      
        hccrStudiesTypeStudies.setStudiesHighSchoolName(getStudiesHighSchoolName());
        HccrSubjectType hccrSubjectTypeHccrSubject = handicapCompensationChildRequest.addNewHccrSubject();
        hccrSubjectTypeHccrSubject.setSubjectBirthCity(getSubjectBirthCity());
      
        hccrSubjectTypeHccrSubject.setSubjectBirthCountry(getSubjectBirthCountry());
      
        date = getSubjectBirthDate();
        if (date != null) {
            calendar.setTime(date);
            hccrSubjectTypeHccrSubject.setSubjectBirthDate(calendar);
        }
      
        if (getSubjectParentalAuthorityHolder() != null)
            hccrSubjectTypeHccrSubject.setSubjectParentalAuthorityHolder(fr.cg95.cvq.xml.request.social.HccrSubjectParentalAuthorityHolderType.Enum.forString(getSubjectParentalAuthorityHolder().toString()));
      
        return handicapCompensationChildRequestDoc;
    }

    @Override
    public final HandicapCompensationChildRequestDocument.HandicapCompensationChildRequest modelToXmlRequest() {
        return modelToXml().getHandicapCompensationChildRequest();
    }

    public static HandicapCompensationChildRequest xmlToModel(HandicapCompensationChildRequestDocument handicapCompensationChildRequestDoc) {
        HandicapCompensationChildRequestDocument.HandicapCompensationChildRequest handicapCompensationChildRequestXml = handicapCompensationChildRequestDoc.getHandicapCompensationChildRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        HandicapCompensationChildRequest handicapCompensationChildRequest = new HandicapCompensationChildRequest();
        handicapCompensationChildRequest.fillCommonModelInfo(handicapCompensationChildRequest, handicapCompensationChildRequestXml);
        
        List<fr.cg95.cvq.business.request.social.HccrAdditionalFee> additionalFeeList = new ArrayList<fr.cg95.cvq.business.request.social.HccrAdditionalFee>(handicapCompensationChildRequestXml.sizeOfAdditionalFeeArray());
        for (HccrAdditionalFeeType object : handicapCompensationChildRequestXml.getAdditionalFeeArray()) {
            additionalFeeList.add(fr.cg95.cvq.business.request.social.HccrAdditionalFee.xmlToModel(object));
        }
        handicapCompensationChildRequest.setAdditionalFee(additionalFeeList);
      
        handicapCompensationChildRequest.setAseReferentDepartment(handicapCompensationChildRequestXml.getAseReferent().getAseReferentDepartment());
      
        handicapCompensationChildRequest.setAseReferentLastName(handicapCompensationChildRequestXml.getAseReferent().getAseReferentLastName());
      
        handicapCompensationChildRequest.setBenefitsCompensatoryAllowanceForExpenses(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsCompensatoryAllowanceForExpenses()));
      
        handicapCompensationChildRequest.setBenefitsDailyAllowances(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsDailyAllowances()));
      
        handicapCompensationChildRequest.setBenefitsDisabilityCard(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsDisabilityCard()));
      
        handicapCompensationChildRequest.setBenefitsDisabilityCompensation(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsDisabilityCompensation()));
      
        handicapCompensationChildRequest.setBenefitsDisabilityPension(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsDisabilityPension()));
      
        handicapCompensationChildRequest.setBenefitsDisabilityPensionCategory(handicapCompensationChildRequestXml.getBenefits().getBenefitsDisabilityPensionCategory());
      
        handicapCompensationChildRequest.setBenefitsDisabilityRatio(handicapCompensationChildRequestXml.getBenefits().getBenefitsDisabilityRatio());
      
        handicapCompensationChildRequest.setBenefitsDisabilityRecognition(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsDisabilityRecognition()));
      
        handicapCompensationChildRequest.setBenefitsDisabledAdultAllocation(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsDisabledAdultAllocation()));
      
        handicapCompensationChildRequest.setBenefitsDisabledWorkerRecognition(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsDisabledWorkerRecognition()));
      
        handicapCompensationChildRequest.setBenefitsEducationAllocationOfDisabledChildren(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsEducationAllocationOfDisabledChildren()));
      
        handicapCompensationChildRequest.setBenefitsEducationOfDisabledChildren(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsEducationOfDisabledChildren()));
      
        handicapCompensationChildRequest.setBenefitsEducationOfDisabledChildrenDetails(handicapCompensationChildRequestXml.getBenefits().getBenefitsEducationOfDisabledChildrenDetails());
      
        handicapCompensationChildRequest.setBenefitsIncreaseForIndependentLiving(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsIncreaseForIndependentLiving()));
      
        handicapCompensationChildRequest.setBenefitsOtherBenefits(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsOtherBenefits()));
      
        handicapCompensationChildRequest.setBenefitsPainfulStandingCard(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsPainfulStandingCard()));
      
        handicapCompensationChildRequest.setBenefitsParkingCard(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsParkingCard()));
      
        handicapCompensationChildRequest.setBenefitsProfessionalOrientation(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsProfessionalOrientation()));
      
        handicapCompensationChildRequest.setBenefitsProfessionalOrientationDetails(handicapCompensationChildRequestXml.getBenefits().getBenefitsProfessionalOrientationDetails());
      
        handicapCompensationChildRequest.setBenefitsSocialWelfare(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsSocialWelfare()));
      
        handicapCompensationChildRequest.setBenefitsSupplementForSingleParents(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsSupplementForSingleParents()));
      
        handicapCompensationChildRequest.setBenefitsSupportedByAnInstitution(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsSupportedByAnInstitution()));
      
        handicapCompensationChildRequest.setBenefitsSupportedByAnInstitutionDetails(handicapCompensationChildRequestXml.getBenefits().getBenefitsSupportedByAnInstitutionDetails());
      
        handicapCompensationChildRequest.setBenefitsThirdPartyCompensatoryAllowance(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsThirdPartyCompensatoryAllowance()));
      
        handicapCompensationChildRequest.setBenefitsThirdPartySupplement(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsThirdPartySupplement()));
      
        handicapCompensationChildRequest.setBenefitsThirdPersonCompensatoryAllowance(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsThirdPersonCompensatoryAllowance()));
      
        handicapCompensationChildRequest.setBenefitsUnemploymentBenefits(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsUnemploymentBenefits()));
      
        handicapCompensationChildRequest.setBenefitsWorkAccidentAnnuity(Boolean.valueOf(handicapCompensationChildRequestXml.getBenefits().getBenefitsWorkAccidentAnnuity()));
      
        handicapCompensationChildRequest.setBenefitsWorkAccidentAnnuityRatio(handicapCompensationChildRequestXml.getBenefits().getBenefitsWorkAccidentAnnuityRatio());
      
        handicapCompensationChildRequest.setCareCareServices(Boolean.valueOf(handicapCompensationChildRequestXml.getCare().getCareCareServices()));
      
        List<fr.cg95.cvq.business.request.social.HccrCareService> careServicesList = new ArrayList<fr.cg95.cvq.business.request.social.HccrCareService>(handicapCompensationChildRequestXml.sizeOfCareServicesArray());
        for (HccrCareServiceType object : handicapCompensationChildRequestXml.getCareServicesArray()) {
            careServicesList.add(fr.cg95.cvq.business.request.social.HccrCareService.xmlToModel(object));
        }
        handicapCompensationChildRequest.setCareServices(careServicesList);
      
        handicapCompensationChildRequest.setDwellingEstablishmentReception(Boolean.valueOf(handicapCompensationChildRequestXml.getDwelling().getDwellingEstablishmentReception()));
      
        if (handicapCompensationChildRequestXml.getDwelling().getDwellingKind() != null)
            handicapCompensationChildRequest.setDwellingKind(fr.cg95.cvq.business.request.social.HccrDwellingKindType.forString(handicapCompensationChildRequestXml.getDwelling().getDwellingKind().toString()));
        else
            handicapCompensationChildRequest.setDwellingKind(fr.cg95.cvq.business.request.social.HccrDwellingKindType.getDefaultHccrDwellingKindType());
      
        handicapCompensationChildRequest.setDwellingPrecision(handicapCompensationChildRequestXml.getDwelling().getDwellingPrecision());
      
        if (handicapCompensationChildRequestXml.getDwelling().getDwellingReceptionAddress() != null)
            handicapCompensationChildRequest.setDwellingReceptionAddress(Address.xmlToModel(handicapCompensationChildRequestXml.getDwelling().getDwellingReceptionAddress()));
      
        handicapCompensationChildRequest.setDwellingReceptionNaming(handicapCompensationChildRequestXml.getDwelling().getDwellingReceptionNaming());
      
        if (handicapCompensationChildRequestXml.getDwelling().getDwellingReceptionType() != null)
            handicapCompensationChildRequest.setDwellingReceptionType(fr.cg95.cvq.business.request.social.HccrDwellingReceptionKindType.forString(handicapCompensationChildRequestXml.getDwelling().getDwellingReceptionType().toString()));
        else
            handicapCompensationChildRequest.setDwellingReceptionType(fr.cg95.cvq.business.request.social.HccrDwellingReceptionKindType.getDefaultHccrDwellingReceptionKindType());
      
        handicapCompensationChildRequest.setDwellingSocialReception(Boolean.valueOf(handicapCompensationChildRequestXml.getDwelling().getDwellingSocialReception()));
      
        if (handicapCompensationChildRequestXml.getDwelling().getDwellingSocialReceptionAddress() != null)
            handicapCompensationChildRequest.setDwellingSocialReceptionAddress(Address.xmlToModel(handicapCompensationChildRequestXml.getDwelling().getDwellingSocialReceptionAddress()));
      
        handicapCompensationChildRequest.setDwellingSocialReceptionNaming(handicapCompensationChildRequestXml.getDwelling().getDwellingSocialReceptionNaming());
      
        handicapCompensationChildRequest.setFacilitiesAnimalAid(Boolean.valueOf(handicapCompensationChildRequestXml.getFacilities().getFacilitiesAnimalAid()));
      
        handicapCompensationChildRequest.setFacilitiesAnimalAidDetails(handicapCompensationChildRequestXml.getFacilities().getFacilitiesAnimalAidDetails());
      
        handicapCompensationChildRequest.setFacilitiesCustomCar(Boolean.valueOf(handicapCompensationChildRequestXml.getFacilities().getFacilitiesCustomCar()));
      
        handicapCompensationChildRequest.setFacilitiesCustomCarDetails(handicapCompensationChildRequestXml.getFacilities().getFacilitiesCustomCarDetails());
      
        handicapCompensationChildRequest.setFacilitiesHousing(Boolean.valueOf(handicapCompensationChildRequestXml.getFacilities().getFacilitiesHousing()));
      
        handicapCompensationChildRequest.setFacilitiesHousingDetails(handicapCompensationChildRequestXml.getFacilities().getFacilitiesHousingDetails());
      
        handicapCompensationChildRequest.setFacilitiesSpecializedTransport(Boolean.valueOf(handicapCompensationChildRequestXml.getFacilities().getFacilitiesSpecializedTransport()));
      
        handicapCompensationChildRequest.setFacilitiesSpecializedTransportDetails(handicapCompensationChildRequestXml.getFacilities().getFacilitiesSpecializedTransportDetails());
      
        handicapCompensationChildRequest.setFacilitiesTechnicalAssistance(Boolean.valueOf(handicapCompensationChildRequestXml.getFacilities().getFacilitiesTechnicalAssistance()));
      
        handicapCompensationChildRequest.setFacilitiesTechnicalAssistanceDetails(handicapCompensationChildRequestXml.getFacilities().getFacilitiesTechnicalAssistanceDetails());
      
        List<fr.cg95.cvq.business.request.social.HccrFamilyAssistanceMember> familyAssistanceMembersList = new ArrayList<fr.cg95.cvq.business.request.social.HccrFamilyAssistanceMember>(handicapCompensationChildRequestXml.sizeOfFamilyAssistanceMembersArray());
        for (HccrFamilyAssistanceMemberType object : handicapCompensationChildRequestXml.getFamilyAssistanceMembersArray()) {
            familyAssistanceMembersList.add(fr.cg95.cvq.business.request.social.HccrFamilyAssistanceMember.xmlToModel(object));
        }
        handicapCompensationChildRequest.setFamilyAssistanceMembers(familyAssistanceMembersList);
      
        List<fr.cg95.cvq.business.request.social.HccrFamilyDependent> familyDependentsList = new ArrayList<fr.cg95.cvq.business.request.social.HccrFamilyDependent>(handicapCompensationChildRequestXml.sizeOfFamilyDependentsArray());
        for (HccrFamilyDependentType object : handicapCompensationChildRequestXml.getFamilyDependentsArray()) {
            familyDependentsList.add(fr.cg95.cvq.business.request.social.HccrFamilyDependent.xmlToModel(object));
        }
        handicapCompensationChildRequest.setFamilyDependents(familyDependentsList);
      
        handicapCompensationChildRequest.setFatherActivityReduction(Boolean.valueOf(handicapCompensationChildRequestXml.getFather().getFatherActivityReduction()));
      
        handicapCompensationChildRequest.setFatherActivityReductionRatio(handicapCompensationChildRequestXml.getFather().getFatherActivityReductionRatio());
      
        handicapCompensationChildRequest.setFatherFirstName(handicapCompensationChildRequestXml.getFather().getFatherFirstName());
      
        handicapCompensationChildRequest.setFatherJob(handicapCompensationChildRequestXml.getFather().getFatherJob());
      
        handicapCompensationChildRequest.setFatherLastName(handicapCompensationChildRequestXml.getFather().getFatherLastName());
      
        handicapCompensationChildRequest.setFoldersCdes(Boolean.valueOf(handicapCompensationChildRequestXml.getFolders().getFoldersCdes()));
      
        handicapCompensationChildRequest.setFoldersCdesDepartment(handicapCompensationChildRequestXml.getFolders().getFoldersCdesDepartment());
      
        handicapCompensationChildRequest.setFoldersCdesNumber(handicapCompensationChildRequestXml.getFolders().getFoldersCdesNumber());
      
        handicapCompensationChildRequest.setFoldersCotorep(Boolean.valueOf(handicapCompensationChildRequestXml.getFolders().getFoldersCotorep()));
      
        handicapCompensationChildRequest.setFoldersCotorepDepartment(handicapCompensationChildRequestXml.getFolders().getFoldersCotorepDepartment());
      
        handicapCompensationChildRequest.setFoldersCotorepNumber(handicapCompensationChildRequestXml.getFolders().getFoldersCotorepNumber());
      
        handicapCompensationChildRequest.setFoldersMdph(Boolean.valueOf(handicapCompensationChildRequestXml.getFolders().getFoldersMdph()));
      
        handicapCompensationChildRequest.setFoldersMdphDepartment(handicapCompensationChildRequestXml.getFolders().getFoldersMdphDepartment());
      
        handicapCompensationChildRequest.setFoldersMdphNumber(handicapCompensationChildRequestXml.getFolders().getFoldersMdphNumber());
      
        handicapCompensationChildRequest.setFoldersOtherFolders(Boolean.valueOf(handicapCompensationChildRequestXml.getFolders().getFoldersOtherFolders()));
      
        handicapCompensationChildRequest.setFormationCurrentFormation(handicapCompensationChildRequestXml.getFormation().getFormationCurrentFormation());
      
        handicapCompensationChildRequest.setFormationDiploma(handicapCompensationChildRequestXml.getFormation().getFormationDiploma());
      
        handicapCompensationChildRequest.setFormationPreviousFormation(handicapCompensationChildRequestXml.getFormation().getFormationPreviousFormation());
      
        handicapCompensationChildRequest.setFormationStudiesLevel(handicapCompensationChildRequestXml.getFormation().getFormationStudiesLevel());
      
        handicapCompensationChildRequest.setHealthDoctorFirstName(handicapCompensationChildRequestXml.getHealth().getHealthDoctorFirstName());
      
        handicapCompensationChildRequest.setHealthDoctorLastName(handicapCompensationChildRequestXml.getHealth().getHealthDoctorLastName());
      
        handicapCompensationChildRequest.setHealthFollowedByDoctor(Boolean.valueOf(handicapCompensationChildRequestXml.getHealth().getHealthFollowedByDoctor()));
      
        handicapCompensationChildRequest.setHealthFollowedByHospital(Boolean.valueOf(handicapCompensationChildRequestXml.getHealth().getHealthFollowedByHospital()));
      
        handicapCompensationChildRequest.setHealthFollowedByProfessional(Boolean.valueOf(handicapCompensationChildRequestXml.getHealth().getHealthFollowedByProfessional()));
      
        handicapCompensationChildRequest.setHealthHospitalName(handicapCompensationChildRequestXml.getHealth().getHealthHospitalName());
      
        handicapCompensationChildRequest.setHealthProfessionalFirstName(handicapCompensationChildRequestXml.getHealth().getHealthProfessionalFirstName());
      
        handicapCompensationChildRequest.setHealthProfessionalLastName(handicapCompensationChildRequestXml.getHealth().getHealthProfessionalLastName());
      
        List<fr.cg95.cvq.business.request.social.HccrHomeIntervenant> homeIntervenantsList = new ArrayList<fr.cg95.cvq.business.request.social.HccrHomeIntervenant>(handicapCompensationChildRequestXml.sizeOfHomeIntervenantsArray());
        for (HccrHomeIntervenantType object : handicapCompensationChildRequestXml.getHomeIntervenantsArray()) {
            homeIntervenantsList.add(fr.cg95.cvq.business.request.social.HccrHomeIntervenant.xmlToModel(object));
        }
        handicapCompensationChildRequest.setHomeIntervenants(homeIntervenantsList);
      
        handicapCompensationChildRequest.setHomeInterventionHomeIntervenant(Boolean.valueOf(handicapCompensationChildRequestXml.getHomeIntervention().getHomeInterventionHomeIntervenant()));
      
        handicapCompensationChildRequest.setIsFamilyAssistance(Boolean.valueOf(handicapCompensationChildRequestXml.getFamilyAssistance().getIsFamilyAssistance()));
      
        handicapCompensationChildRequest.setMotherActivityReduction(Boolean.valueOf(handicapCompensationChildRequestXml.getMother().getMotherActivityReduction()));
      
        handicapCompensationChildRequest.setMotherActivityReductionRatio(handicapCompensationChildRequestXml.getMother().getMotherActivityReductionRatio());
      
        handicapCompensationChildRequest.setMotherFirstName(handicapCompensationChildRequestXml.getMother().getMotherFirstName());
      
        handicapCompensationChildRequest.setMotherJob(handicapCompensationChildRequestXml.getMother().getMotherJob());
      
        handicapCompensationChildRequest.setMotherLastName(handicapCompensationChildRequestXml.getMother().getMotherLastName());
      
        List<fr.cg95.cvq.business.request.social.HccrOtherBenefit> otherBenefitsList = new ArrayList<fr.cg95.cvq.business.request.social.HccrOtherBenefit>(handicapCompensationChildRequestXml.sizeOfOtherBenefitsArray());
        for (HccrOtherBenefitType object : handicapCompensationChildRequestXml.getOtherBenefitsArray()) {
            otherBenefitsList.add(fr.cg95.cvq.business.request.social.HccrOtherBenefit.xmlToModel(object));
        }
        handicapCompensationChildRequest.setOtherBenefits(otherBenefitsList);
      
        List<fr.cg95.cvq.business.request.social.HccrOtherFolder> otherFoldersList = new ArrayList<fr.cg95.cvq.business.request.social.HccrOtherFolder>(handicapCompensationChildRequestXml.sizeOfOtherFoldersArray());
        for (HccrOtherFolderType object : handicapCompensationChildRequestXml.getOtherFoldersArray()) {
            otherFoldersList.add(fr.cg95.cvq.business.request.social.HccrOtherFolder.xmlToModel(object));
        }
        handicapCompensationChildRequest.setOtherFolders(otherFoldersList);
      
        if (handicapCompensationChildRequestXml.getPaymentAgency().getPaymentAgencyAddress() != null)
            handicapCompensationChildRequest.setPaymentAgencyAddress(Address.xmlToModel(handicapCompensationChildRequestXml.getPaymentAgency().getPaymentAgencyAddress()));
      
        if (handicapCompensationChildRequestXml.getPaymentAgency().getPaymentAgencyBeneficiary() != null)
            handicapCompensationChildRequest.setPaymentAgencyBeneficiary(fr.cg95.cvq.business.request.social.HccrPaymentAgencyBeneficiaryType.forString(handicapCompensationChildRequestXml.getPaymentAgency().getPaymentAgencyBeneficiary().toString()));
        else
            handicapCompensationChildRequest.setPaymentAgencyBeneficiary(fr.cg95.cvq.business.request.social.HccrPaymentAgencyBeneficiaryType.getDefaultHccrPaymentAgencyBeneficiaryType());
      
        handicapCompensationChildRequest.setPaymentAgencyBeneficiaryNumber(handicapCompensationChildRequestXml.getPaymentAgency().getPaymentAgencyBeneficiaryNumber());
      
        handicapCompensationChildRequest.setPaymentAgencyName(handicapCompensationChildRequestXml.getPaymentAgency().getPaymentAgencyName());
      
        if (handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusAddress() != null)
            handicapCompensationChildRequest.setProfessionalStatusAddress(Address.xmlToModel(handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusAddress()));
      
        calendar = handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusDate();
        if (calendar != null) {
            handicapCompensationChildRequest.setProfessionalStatusDate(calendar.getTime());
        }
      
        handicapCompensationChildRequest.setProfessionalStatusElectiveFunction(Boolean.valueOf(handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusElectiveFunction()));
      
        handicapCompensationChildRequest.setProfessionalStatusElectiveFunctionDetails(handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusElectiveFunctionDetails());
      
        handicapCompensationChildRequest.setProfessionalStatusEmployerName(handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusEmployerName());
      
        if (handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusEnvironment() != null)
            handicapCompensationChildRequest.setProfessionalStatusEnvironment(fr.cg95.cvq.business.request.social.HccrProfessionalStatusEnvironmentType.forString(handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusEnvironment().toString()));
        else
            handicapCompensationChildRequest.setProfessionalStatusEnvironment(fr.cg95.cvq.business.request.social.HccrProfessionalStatusEnvironmentType.getDefaultHccrProfessionalStatusEnvironmentType());
      
        handicapCompensationChildRequest.setProfessionalStatusIndemnified(Boolean.valueOf(handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusIndemnified()));
      
        calendar = handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusIndemnifiedDate();
        if (calendar != null) {
            handicapCompensationChildRequest.setProfessionalStatusIndemnifiedDate(calendar.getTime());
        }
      
        if (handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusKind() != null)
            handicapCompensationChildRequest.setProfessionalStatusKind(fr.cg95.cvq.business.request.social.HccrProfessionalStatusKindType.forString(handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusKind().toString()));
        else
            handicapCompensationChildRequest.setProfessionalStatusKind(fr.cg95.cvq.business.request.social.HccrProfessionalStatusKindType.getDefaultHccrProfessionalStatusKindType());
      
        handicapCompensationChildRequest.setProfessionalStatusProfession(handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusProfession());
      
        handicapCompensationChildRequest.setProfessionalStatusRegisterAsUnemployed(Boolean.valueOf(handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusRegisterAsUnemployed()));
      
        calendar = handicapCompensationChildRequestXml.getProfessionalStatus().getProfessionalStatusRegisterAsUnemployedDate();
        if (calendar != null) {
            handicapCompensationChildRequest.setProfessionalStatusRegisterAsUnemployedDate(calendar.getTime());
        }
      
        handicapCompensationChildRequest.setProfessionalSupportDealsWithSameProfessional(Boolean.valueOf(handicapCompensationChildRequestXml.getProfessionalSupport().getProfessionalSupportDealsWithSameProfessional()));
      
        handicapCompensationChildRequest.setProfessionalSupportProfessionals(Boolean.valueOf(handicapCompensationChildRequestXml.getProfessionalSupport().getProfessionalSupportProfessionals()));
      
        List<fr.cg95.cvq.business.request.social.HccrProfessional> professionalsList = new ArrayList<fr.cg95.cvq.business.request.social.HccrProfessional>(handicapCompensationChildRequestXml.sizeOfProfessionalsArray());
        for (HccrProfessionalType object : handicapCompensationChildRequestXml.getProfessionalsArray()) {
            professionalsList.add(fr.cg95.cvq.business.request.social.HccrProfessional.xmlToModel(object));
        }
        handicapCompensationChildRequest.setProfessionals(professionalsList);
      
        handicapCompensationChildRequest.setProjectComments(handicapCompensationChildRequestXml.getProjectComments());
      
        handicapCompensationChildRequest.setProjectNeeds(handicapCompensationChildRequestXml.getProjectNeeds());
      
        handicapCompensationChildRequest.setProjectRequestsACTPRenewal(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsACTPRenewal()));
      
        handicapCompensationChildRequest.setProjectRequestsAssistance(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsAssistance()));
      
        handicapCompensationChildRequest.setProjectRequestsCustomCar(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsCustomCar()));
      
        handicapCompensationChildRequest.setProjectRequestsDisabilityCard(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsDisabilityCard()));
      
        handicapCompensationChildRequest.setProjectRequestsDisabilityCostAllocation(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsDisabilityCostAllocation()));
      
        handicapCompensationChildRequest.setProjectRequestsDisabledAdultAllowance(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsDisabledAdultAllowance()));
      
        handicapCompensationChildRequest.setProjectRequestsDisabledPriorityCard(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsDisabledPriorityCard()));
      
        handicapCompensationChildRequest.setProjectRequestsDisabledWorkerRecognition(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsDisabledWorkerRecognition()));
      
        handicapCompensationChildRequest.setProjectRequestsEducationAllocationOfDisabledChildren(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsEducationAllocationOfDisabledChildren()));
      
        handicapCompensationChildRequest.setProjectRequestsEuropeanParkingCard(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsEuropeanParkingCard()));
      
        handicapCompensationChildRequest.setProjectRequestsFreePensionMembership(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsFreePensionMembership()));
      
        handicapCompensationChildRequest.setProjectRequestsHandicapRecognition(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsHandicapRecognition()));
      
        handicapCompensationChildRequest.setProjectRequestsHousingFacilities(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsHousingFacilities()));
      
        handicapCompensationChildRequest.setProjectRequestsIncreaseForIndependentLiving(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsIncreaseForIndependentLiving()));
      
        handicapCompensationChildRequest.setProjectRequestsInstitutionSupport(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsInstitutionSupport()));
      
        handicapCompensationChildRequest.setProjectRequestsOrdinaryWorking(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsOrdinaryWorking()));
      
        handicapCompensationChildRequest.setProjectRequestsOther(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsOther()));
      
        handicapCompensationChildRequest.setProjectRequestsOtherDetails(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsOtherDetails());
      
        handicapCompensationChildRequest.setProjectRequestsProfessionalOrientation(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsProfessionalOrientation()));
      
        handicapCompensationChildRequest.setProjectRequestsShelteredWork(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsShelteredWork()));
      
        handicapCompensationChildRequest.setProjectRequestsTechnicalHelp(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsTechnicalHelp()));
      
        handicapCompensationChildRequest.setProjectRequestsThirdPartyHelp(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsThirdPartyHelp()));
      
        handicapCompensationChildRequest.setProjectRequestsTransportCostAllocation(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsTransportCostAllocation()));
      
        handicapCompensationChildRequest.setProjectRequestsVocationalTraining(Boolean.valueOf(handicapCompensationChildRequestXml.getProjectRequests().getProjectRequestsVocationalTraining()));
      
        handicapCompensationChildRequest.setProjectWish(handicapCompensationChildRequestXml.getProjectWish());
      
        handicapCompensationChildRequest.setReferentBirthCity(handicapCompensationChildRequestXml.getReferent().getReferentBirthCity());
      
        handicapCompensationChildRequest.setReferentBirthCountry(handicapCompensationChildRequestXml.getReferent().getReferentBirthCountry());
      
        calendar = handicapCompensationChildRequestXml.getReferent().getReferentBirthDate();
        if (calendar != null) {
            handicapCompensationChildRequest.setReferentBirthDate(calendar.getTime());
        }
      
        handicapCompensationChildRequest.setReferentFamilyDependents(Boolean.valueOf(handicapCompensationChildRequestXml.getReferent().getReferentFamilyDependents()));
      
        if (handicapCompensationChildRequestXml.getReferent().getReferentFamilyStatus() != null)
            handicapCompensationChildRequest.setReferentFamilyStatus(fr.cg95.cvq.business.users.FamilyStatusType.forString(handicapCompensationChildRequestXml.getReferent().getReferentFamilyStatus().toString()));
        else
            handicapCompensationChildRequest.setReferentFamilyStatus(fr.cg95.cvq.business.users.FamilyStatusType.getDefaultFamilyStatusType());
      
        handicapCompensationChildRequest.setReferentFirstName(handicapCompensationChildRequestXml.getReferent().getReferentFirstName());
      
        handicapCompensationChildRequest.setReferentLastName(handicapCompensationChildRequestXml.getReferent().getReferentLastName());
      
        handicapCompensationChildRequest.setReferentMaidenName(handicapCompensationChildRequestXml.getReferent().getReferentMaidenName());
      
        if (handicapCompensationChildRequestXml.getReferent().getReferentTitle() != null)
            handicapCompensationChildRequest.setReferentTitle(fr.cg95.cvq.business.users.TitleType.forString(handicapCompensationChildRequestXml.getReferent().getReferentTitle().toString()));
        else
            handicapCompensationChildRequest.setReferentTitle(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
      
        if (handicapCompensationChildRequestXml.getSchooling().getSchoolingAttendedGrade() != null)
            handicapCompensationChildRequest.setSchoolingAttendedGrade(fr.cg95.cvq.business.users.SectionType.forString(handicapCompensationChildRequestXml.getSchooling().getSchoolingAttendedGrade().toString()));
        else
            handicapCompensationChildRequest.setSchoolingAttendedGrade(fr.cg95.cvq.business.users.SectionType.getDefaultSectionType());
      
        handicapCompensationChildRequest.setSchoolingEnrolment(Boolean.valueOf(handicapCompensationChildRequestXml.getSchooling().getSchoolingEnrolment()));
      
        handicapCompensationChildRequest.setSchoolingExtraCurricular(Boolean.valueOf(handicapCompensationChildRequestXml.getSchooling().getSchoolingExtraCurricular()));
      
        handicapCompensationChildRequest.setSchoolingExtraCurricularDetails(handicapCompensationChildRequestXml.getSchooling().getSchoolingExtraCurricularDetails());
      
        handicapCompensationChildRequest.setSchoolingHomeSchooling(Boolean.valueOf(handicapCompensationChildRequestXml.getSchooling().getSchoolingHomeSchooling()));
      
        if (handicapCompensationChildRequestXml.getSchooling().getSchoolingHomeSchoolingAccompanistAddress() != null)
            handicapCompensationChildRequest.setSchoolingHomeSchoolingAccompanistAddress(Address.xmlToModel(handicapCompensationChildRequestXml.getSchooling().getSchoolingHomeSchoolingAccompanistAddress()));
      
        handicapCompensationChildRequest.setSchoolingHomeSchoolingAccompanistFirstName(handicapCompensationChildRequestXml.getSchooling().getSchoolingHomeSchoolingAccompanistFirstName());
      
        handicapCompensationChildRequest.setSchoolingHomeSchoolingAccompanistLastName(handicapCompensationChildRequestXml.getSchooling().getSchoolingHomeSchoolingAccompanistLastName());
      
        if (handicapCompensationChildRequestXml.getSchooling().getSchoolingHomeSchoolingKind() != null)
            handicapCompensationChildRequest.setSchoolingHomeSchoolingKind(fr.cg95.cvq.business.request.social.HccrHomeSchoolingKindType.forString(handicapCompensationChildRequestXml.getSchooling().getSchoolingHomeSchoolingKind().toString()));
        else
            handicapCompensationChildRequest.setSchoolingHomeSchoolingKind(fr.cg95.cvq.business.request.social.HccrHomeSchoolingKindType.getDefaultHccrHomeSchoolingKindType());
      
        handicapCompensationChildRequest.setSchoolingPersonalizedSchoolingPlan(Boolean.valueOf(handicapCompensationChildRequestXml.getSchooling().getSchoolingPersonalizedSchoolingPlan()));
      
        if (handicapCompensationChildRequestXml.getSchooling().getSchoolingSchoolAddress() != null)
            handicapCompensationChildRequest.setSchoolingSchoolAddress(Address.xmlToModel(handicapCompensationChildRequestXml.getSchooling().getSchoolingSchoolAddress()));
      
        handicapCompensationChildRequest.setSchoolingSchoolName(handicapCompensationChildRequestXml.getSchooling().getSchoolingSchoolName());
      
        if (handicapCompensationChildRequestXml.getSchooling().getSchoolingSchoolingKind() != null)
            handicapCompensationChildRequest.setSchoolingSchoolingKind(fr.cg95.cvq.business.request.social.HccrSchoolingKindType.forString(handicapCompensationChildRequestXml.getSchooling().getSchoolingSchoolingKind().toString()));
        else
            handicapCompensationChildRequest.setSchoolingSchoolingKind(fr.cg95.cvq.business.request.social.HccrSchoolingKindType.getDefaultHccrSchoolingKindType());
      
        handicapCompensationChildRequest.setSchoolingSendToSchool(Boolean.valueOf(handicapCompensationChildRequestXml.getSchooling().getSchoolingSendToSchool()));
      
        handicapCompensationChildRequest.setSchoolingSpecializedGrade(Boolean.valueOf(handicapCompensationChildRequestXml.getSchooling().getSchoolingSpecializedGrade()));
      
        handicapCompensationChildRequest.setSchoolingSpecializedGradeDetails(handicapCompensationChildRequestXml.getSchooling().getSchoolingSpecializedGradeDetails());
      
        handicapCompensationChildRequest.setSchoolingTime(handicapCompensationChildRequestXml.getSchooling().getSchoolingTime());
      
        if (handicapCompensationChildRequestXml.getSocialSecurity().getSocialSecurityAgencyAddress() != null)
            handicapCompensationChildRequest.setSocialSecurityAgencyAddress(Address.xmlToModel(handicapCompensationChildRequestXml.getSocialSecurity().getSocialSecurityAgencyAddress()));
      
        handicapCompensationChildRequest.setSocialSecurityAgencyName(handicapCompensationChildRequestXml.getSocialSecurity().getSocialSecurityAgencyName());
      
        if (handicapCompensationChildRequestXml.getSocialSecurity().getSocialSecurityMemberShipKind() != null)
            handicapCompensationChildRequest.setSocialSecurityMemberShipKind(fr.cg95.cvq.business.request.social.HccrSocialSecurityMemberShipKindType.forString(handicapCompensationChildRequestXml.getSocialSecurity().getSocialSecurityMemberShipKind().toString()));
        else
            handicapCompensationChildRequest.setSocialSecurityMemberShipKind(fr.cg95.cvq.business.request.social.HccrSocialSecurityMemberShipKindType.getDefaultHccrSocialSecurityMemberShipKindType());
      
        handicapCompensationChildRequest.setSocialSecurityNumber(handicapCompensationChildRequestXml.getSocialSecurity().getSocialSecurityNumber());
      
        if (handicapCompensationChildRequestXml.getSocialService().getSocialServiceAddress() != null)
            handicapCompensationChildRequest.setSocialServiceAddress(Address.xmlToModel(handicapCompensationChildRequestXml.getSocialService().getSocialServiceAddress()));
      
        handicapCompensationChildRequest.setSocialServiceName(handicapCompensationChildRequestXml.getSocialService().getSocialServiceName());
      
        handicapCompensationChildRequest.setSocialServiceSupport(Boolean.valueOf(handicapCompensationChildRequestXml.getSocialService().getSocialServiceSupport()));
      
        handicapCompensationChildRequest.setStudiesAssistanceUnderDisability(Boolean.valueOf(handicapCompensationChildRequestXml.getStudies().getStudiesAssistanceUnderDisability()));
      
        handicapCompensationChildRequest.setStudiesAssistanceUnderDisabilityDetails(handicapCompensationChildRequestXml.getStudies().getStudiesAssistanceUnderDisabilityDetails());
      
        handicapCompensationChildRequest.setStudiesHighSchool(Boolean.valueOf(handicapCompensationChildRequestXml.getStudies().getStudiesHighSchool()));
      
        if (handicapCompensationChildRequestXml.getStudies().getStudiesHighSchoolAddress() != null)
            handicapCompensationChildRequest.setStudiesHighSchoolAddress(Address.xmlToModel(handicapCompensationChildRequestXml.getStudies().getStudiesHighSchoolAddress()));
      
        handicapCompensationChildRequest.setStudiesHighSchoolGrade(handicapCompensationChildRequestXml.getStudies().getStudiesHighSchoolGrade());
      
        handicapCompensationChildRequest.setStudiesHighSchoolName(handicapCompensationChildRequestXml.getStudies().getStudiesHighSchoolName());
      
        handicapCompensationChildRequest.setSubjectBirthCity(handicapCompensationChildRequestXml.getHccrSubject().getSubjectBirthCity());
      
        handicapCompensationChildRequest.setSubjectBirthCountry(handicapCompensationChildRequestXml.getHccrSubject().getSubjectBirthCountry());
      
        calendar = handicapCompensationChildRequestXml.getHccrSubject().getSubjectBirthDate();
        if (calendar != null) {
            handicapCompensationChildRequest.setSubjectBirthDate(calendar.getTime());
        }
      
        if (handicapCompensationChildRequestXml.getHccrSubject().getSubjectParentalAuthorityHolder() != null)
            handicapCompensationChildRequest.setSubjectParentalAuthorityHolder(fr.cg95.cvq.business.request.social.HccrSubjectParentalAuthorityHolderType.forString(handicapCompensationChildRequestXml.getHccrSubject().getSubjectParentalAuthorityHolder().toString()));
        else
            handicapCompensationChildRequest.setSubjectParentalAuthorityHolder(fr.cg95.cvq.business.request.social.HccrSubjectParentalAuthorityHolderType.getDefaultHccrSubjectParentalAuthorityHolderType());
      
        return handicapCompensationChildRequest;
    }

    @Override
    public HandicapCompensationChildRequest clone() {
        HandicapCompensationChildRequest clone = new HandicapCompensationChildRequest(getRequestData().clone(), handicapCompensationChildRequestData.clone());
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("subject", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("dwelling", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("socialSecurityAndPaymentAgency", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("occupationnalAndSchoolStatus", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("folders", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("benefits", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("aid", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("health", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("project", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", false);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("document", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("validation", stepState);
        
        return clone;
    }

  
    public final void setAdditionalFee(final List<fr.cg95.cvq.business.request.social.HccrAdditionalFee> additionalFee) {
        handicapCompensationChildRequestData.setAdditionalFee(additionalFee);
    }

    
    public final List<fr.cg95.cvq.business.request.social.HccrAdditionalFee> getAdditionalFee() {
        return handicapCompensationChildRequestData.getAdditionalFee();
    }
  
    public final void setAseReferentDepartment(final String aseReferentDepartment) {
        handicapCompensationChildRequestData.setAseReferentDepartment(aseReferentDepartment);
    }

    
    public final String getAseReferentDepartment() {
        return handicapCompensationChildRequestData.getAseReferentDepartment();
    }
  
    public final void setAseReferentLastName(final String aseReferentLastName) {
        handicapCompensationChildRequestData.setAseReferentLastName(aseReferentLastName);
    }

    
    public final String getAseReferentLastName() {
        return handicapCompensationChildRequestData.getAseReferentLastName();
    }
  
    public final void setBenefitsCompensatoryAllowanceForExpenses(final Boolean benefitsCompensatoryAllowanceForExpenses) {
        handicapCompensationChildRequestData.setBenefitsCompensatoryAllowanceForExpenses(benefitsCompensatoryAllowanceForExpenses);
    }

    
    public final Boolean getBenefitsCompensatoryAllowanceForExpenses() {
        return handicapCompensationChildRequestData.getBenefitsCompensatoryAllowanceForExpenses();
    }
  
    public final void setBenefitsDailyAllowances(final Boolean benefitsDailyAllowances) {
        handicapCompensationChildRequestData.setBenefitsDailyAllowances(benefitsDailyAllowances);
    }

    
    public final Boolean getBenefitsDailyAllowances() {
        return handicapCompensationChildRequestData.getBenefitsDailyAllowances();
    }
  
    public final void setBenefitsDisabilityCard(final Boolean benefitsDisabilityCard) {
        handicapCompensationChildRequestData.setBenefitsDisabilityCard(benefitsDisabilityCard);
    }

    
    public final Boolean getBenefitsDisabilityCard() {
        return handicapCompensationChildRequestData.getBenefitsDisabilityCard();
    }
  
    public final void setBenefitsDisabilityCompensation(final Boolean benefitsDisabilityCompensation) {
        handicapCompensationChildRequestData.setBenefitsDisabilityCompensation(benefitsDisabilityCompensation);
    }

    
    public final Boolean getBenefitsDisabilityCompensation() {
        return handicapCompensationChildRequestData.getBenefitsDisabilityCompensation();
    }
  
    public final void setBenefitsDisabilityPension(final Boolean benefitsDisabilityPension) {
        handicapCompensationChildRequestData.setBenefitsDisabilityPension(benefitsDisabilityPension);
    }

    
    public final Boolean getBenefitsDisabilityPension() {
        return handicapCompensationChildRequestData.getBenefitsDisabilityPension();
    }
  
    public final void setBenefitsDisabilityPensionCategory(final String benefitsDisabilityPensionCategory) {
        handicapCompensationChildRequestData.setBenefitsDisabilityPensionCategory(benefitsDisabilityPensionCategory);
    }

    
    public final String getBenefitsDisabilityPensionCategory() {
        return handicapCompensationChildRequestData.getBenefitsDisabilityPensionCategory();
    }
  
    public final void setBenefitsDisabilityRatio(final String benefitsDisabilityRatio) {
        handicapCompensationChildRequestData.setBenefitsDisabilityRatio(benefitsDisabilityRatio);
    }

    
    public final String getBenefitsDisabilityRatio() {
        return handicapCompensationChildRequestData.getBenefitsDisabilityRatio();
    }
  
    public final void setBenefitsDisabilityRecognition(final Boolean benefitsDisabilityRecognition) {
        handicapCompensationChildRequestData.setBenefitsDisabilityRecognition(benefitsDisabilityRecognition);
    }

    
    public final Boolean getBenefitsDisabilityRecognition() {
        return handicapCompensationChildRequestData.getBenefitsDisabilityRecognition();
    }
  
    public final void setBenefitsDisabledAdultAllocation(final Boolean benefitsDisabledAdultAllocation) {
        handicapCompensationChildRequestData.setBenefitsDisabledAdultAllocation(benefitsDisabledAdultAllocation);
    }

    
    public final Boolean getBenefitsDisabledAdultAllocation() {
        return handicapCompensationChildRequestData.getBenefitsDisabledAdultAllocation();
    }
  
    public final void setBenefitsDisabledWorkerRecognition(final Boolean benefitsDisabledWorkerRecognition) {
        handicapCompensationChildRequestData.setBenefitsDisabledWorkerRecognition(benefitsDisabledWorkerRecognition);
    }

    
    public final Boolean getBenefitsDisabledWorkerRecognition() {
        return handicapCompensationChildRequestData.getBenefitsDisabledWorkerRecognition();
    }
  
    public final void setBenefitsEducationAllocationOfDisabledChildren(final Boolean benefitsEducationAllocationOfDisabledChildren) {
        handicapCompensationChildRequestData.setBenefitsEducationAllocationOfDisabledChildren(benefitsEducationAllocationOfDisabledChildren);
    }

    
    public final Boolean getBenefitsEducationAllocationOfDisabledChildren() {
        return handicapCompensationChildRequestData.getBenefitsEducationAllocationOfDisabledChildren();
    }
  
    public final void setBenefitsEducationOfDisabledChildren(final Boolean benefitsEducationOfDisabledChildren) {
        handicapCompensationChildRequestData.setBenefitsEducationOfDisabledChildren(benefitsEducationOfDisabledChildren);
    }

    
    public final Boolean getBenefitsEducationOfDisabledChildren() {
        return handicapCompensationChildRequestData.getBenefitsEducationOfDisabledChildren();
    }
  
    public final void setBenefitsEducationOfDisabledChildrenDetails(final String benefitsEducationOfDisabledChildrenDetails) {
        handicapCompensationChildRequestData.setBenefitsEducationOfDisabledChildrenDetails(benefitsEducationOfDisabledChildrenDetails);
    }

    
    public final String getBenefitsEducationOfDisabledChildrenDetails() {
        return handicapCompensationChildRequestData.getBenefitsEducationOfDisabledChildrenDetails();
    }
  
    public final void setBenefitsIncreaseForIndependentLiving(final Boolean benefitsIncreaseForIndependentLiving) {
        handicapCompensationChildRequestData.setBenefitsIncreaseForIndependentLiving(benefitsIncreaseForIndependentLiving);
    }

    
    public final Boolean getBenefitsIncreaseForIndependentLiving() {
        return handicapCompensationChildRequestData.getBenefitsIncreaseForIndependentLiving();
    }
  
    public final void setBenefitsOtherBenefits(final Boolean benefitsOtherBenefits) {
        handicapCompensationChildRequestData.setBenefitsOtherBenefits(benefitsOtherBenefits);
    }

    
    public final Boolean getBenefitsOtherBenefits() {
        return handicapCompensationChildRequestData.getBenefitsOtherBenefits();
    }
  
    public final void setBenefitsPainfulStandingCard(final Boolean benefitsPainfulStandingCard) {
        handicapCompensationChildRequestData.setBenefitsPainfulStandingCard(benefitsPainfulStandingCard);
    }

    
    public final Boolean getBenefitsPainfulStandingCard() {
        return handicapCompensationChildRequestData.getBenefitsPainfulStandingCard();
    }
  
    public final void setBenefitsParkingCard(final Boolean benefitsParkingCard) {
        handicapCompensationChildRequestData.setBenefitsParkingCard(benefitsParkingCard);
    }

    
    public final Boolean getBenefitsParkingCard() {
        return handicapCompensationChildRequestData.getBenefitsParkingCard();
    }
  
    public final void setBenefitsProfessionalOrientation(final Boolean benefitsProfessionalOrientation) {
        handicapCompensationChildRequestData.setBenefitsProfessionalOrientation(benefitsProfessionalOrientation);
    }

    
    public final Boolean getBenefitsProfessionalOrientation() {
        return handicapCompensationChildRequestData.getBenefitsProfessionalOrientation();
    }
  
    public final void setBenefitsProfessionalOrientationDetails(final String benefitsProfessionalOrientationDetails) {
        handicapCompensationChildRequestData.setBenefitsProfessionalOrientationDetails(benefitsProfessionalOrientationDetails);
    }

    
    public final String getBenefitsProfessionalOrientationDetails() {
        return handicapCompensationChildRequestData.getBenefitsProfessionalOrientationDetails();
    }
  
    public final void setBenefitsSocialWelfare(final Boolean benefitsSocialWelfare) {
        handicapCompensationChildRequestData.setBenefitsSocialWelfare(benefitsSocialWelfare);
    }

    
    public final Boolean getBenefitsSocialWelfare() {
        return handicapCompensationChildRequestData.getBenefitsSocialWelfare();
    }
  
    public final void setBenefitsSupplementForSingleParents(final Boolean benefitsSupplementForSingleParents) {
        handicapCompensationChildRequestData.setBenefitsSupplementForSingleParents(benefitsSupplementForSingleParents);
    }

    
    public final Boolean getBenefitsSupplementForSingleParents() {
        return handicapCompensationChildRequestData.getBenefitsSupplementForSingleParents();
    }
  
    public final void setBenefitsSupportedByAnInstitution(final Boolean benefitsSupportedByAnInstitution) {
        handicapCompensationChildRequestData.setBenefitsSupportedByAnInstitution(benefitsSupportedByAnInstitution);
    }

    
    public final Boolean getBenefitsSupportedByAnInstitution() {
        return handicapCompensationChildRequestData.getBenefitsSupportedByAnInstitution();
    }
  
    public final void setBenefitsSupportedByAnInstitutionDetails(final String benefitsSupportedByAnInstitutionDetails) {
        handicapCompensationChildRequestData.setBenefitsSupportedByAnInstitutionDetails(benefitsSupportedByAnInstitutionDetails);
    }

    
    public final String getBenefitsSupportedByAnInstitutionDetails() {
        return handicapCompensationChildRequestData.getBenefitsSupportedByAnInstitutionDetails();
    }
  
    public final void setBenefitsThirdPartyCompensatoryAllowance(final Boolean benefitsThirdPartyCompensatoryAllowance) {
        handicapCompensationChildRequestData.setBenefitsThirdPartyCompensatoryAllowance(benefitsThirdPartyCompensatoryAllowance);
    }

    
    public final Boolean getBenefitsThirdPartyCompensatoryAllowance() {
        return handicapCompensationChildRequestData.getBenefitsThirdPartyCompensatoryAllowance();
    }
  
    public final void setBenefitsThirdPartySupplement(final Boolean benefitsThirdPartySupplement) {
        handicapCompensationChildRequestData.setBenefitsThirdPartySupplement(benefitsThirdPartySupplement);
    }

    
    public final Boolean getBenefitsThirdPartySupplement() {
        return handicapCompensationChildRequestData.getBenefitsThirdPartySupplement();
    }
  
    public final void setBenefitsThirdPersonCompensatoryAllowance(final Boolean benefitsThirdPersonCompensatoryAllowance) {
        handicapCompensationChildRequestData.setBenefitsThirdPersonCompensatoryAllowance(benefitsThirdPersonCompensatoryAllowance);
    }

    
    public final Boolean getBenefitsThirdPersonCompensatoryAllowance() {
        return handicapCompensationChildRequestData.getBenefitsThirdPersonCompensatoryAllowance();
    }
  
    public final void setBenefitsUnemploymentBenefits(final Boolean benefitsUnemploymentBenefits) {
        handicapCompensationChildRequestData.setBenefitsUnemploymentBenefits(benefitsUnemploymentBenefits);
    }

    
    public final Boolean getBenefitsUnemploymentBenefits() {
        return handicapCompensationChildRequestData.getBenefitsUnemploymentBenefits();
    }
  
    public final void setBenefitsWorkAccidentAnnuity(final Boolean benefitsWorkAccidentAnnuity) {
        handicapCompensationChildRequestData.setBenefitsWorkAccidentAnnuity(benefitsWorkAccidentAnnuity);
    }

    
    public final Boolean getBenefitsWorkAccidentAnnuity() {
        return handicapCompensationChildRequestData.getBenefitsWorkAccidentAnnuity();
    }
  
    public final void setBenefitsWorkAccidentAnnuityRatio(final String benefitsWorkAccidentAnnuityRatio) {
        handicapCompensationChildRequestData.setBenefitsWorkAccidentAnnuityRatio(benefitsWorkAccidentAnnuityRatio);
    }

    
    public final String getBenefitsWorkAccidentAnnuityRatio() {
        return handicapCompensationChildRequestData.getBenefitsWorkAccidentAnnuityRatio();
    }
  
    public final void setCareCareServices(final Boolean careCareServices) {
        handicapCompensationChildRequestData.setCareCareServices(careCareServices);
    }

    
    public final Boolean getCareCareServices() {
        return handicapCompensationChildRequestData.getCareCareServices();
    }
  
    public final void setCareServices(final List<fr.cg95.cvq.business.request.social.HccrCareService> careServices) {
        handicapCompensationChildRequestData.setCareServices(careServices);
    }

    
    public final List<fr.cg95.cvq.business.request.social.HccrCareService> getCareServices() {
        return handicapCompensationChildRequestData.getCareServices();
    }
  
    public final void setDwellingEstablishmentReception(final Boolean dwellingEstablishmentReception) {
        handicapCompensationChildRequestData.setDwellingEstablishmentReception(dwellingEstablishmentReception);
    }

    
    public final Boolean getDwellingEstablishmentReception() {
        return handicapCompensationChildRequestData.getDwellingEstablishmentReception();
    }
  
    public final void setDwellingKind(final fr.cg95.cvq.business.request.social.HccrDwellingKindType dwellingKind) {
        handicapCompensationChildRequestData.setDwellingKind(dwellingKind);
    }

    
    public final fr.cg95.cvq.business.request.social.HccrDwellingKindType getDwellingKind() {
        return handicapCompensationChildRequestData.getDwellingKind();
    }
  
    public final void setDwellingPrecision(final String dwellingPrecision) {
        handicapCompensationChildRequestData.setDwellingPrecision(dwellingPrecision);
    }

    
    public final String getDwellingPrecision() {
        return handicapCompensationChildRequestData.getDwellingPrecision();
    }
  
    public final void setDwellingReceptionAddress(final fr.cg95.cvq.business.users.Address dwellingReceptionAddress) {
        handicapCompensationChildRequestData.setDwellingReceptionAddress(dwellingReceptionAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getDwellingReceptionAddress() {
        return handicapCompensationChildRequestData.getDwellingReceptionAddress();
    }
  
    public final void setDwellingReceptionNaming(final String dwellingReceptionNaming) {
        handicapCompensationChildRequestData.setDwellingReceptionNaming(dwellingReceptionNaming);
    }

    
    public final String getDwellingReceptionNaming() {
        return handicapCompensationChildRequestData.getDwellingReceptionNaming();
    }
  
    public final void setDwellingReceptionType(final fr.cg95.cvq.business.request.social.HccrDwellingReceptionKindType dwellingReceptionType) {
        handicapCompensationChildRequestData.setDwellingReceptionType(dwellingReceptionType);
    }

    
    public final fr.cg95.cvq.business.request.social.HccrDwellingReceptionKindType getDwellingReceptionType() {
        return handicapCompensationChildRequestData.getDwellingReceptionType();
    }
  
    public final void setDwellingSocialReception(final Boolean dwellingSocialReception) {
        handicapCompensationChildRequestData.setDwellingSocialReception(dwellingSocialReception);
    }

    
    public final Boolean getDwellingSocialReception() {
        return handicapCompensationChildRequestData.getDwellingSocialReception();
    }
  
    public final void setDwellingSocialReceptionAddress(final fr.cg95.cvq.business.users.Address dwellingSocialReceptionAddress) {
        handicapCompensationChildRequestData.setDwellingSocialReceptionAddress(dwellingSocialReceptionAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getDwellingSocialReceptionAddress() {
        return handicapCompensationChildRequestData.getDwellingSocialReceptionAddress();
    }
  
    public final void setDwellingSocialReceptionNaming(final String dwellingSocialReceptionNaming) {
        handicapCompensationChildRequestData.setDwellingSocialReceptionNaming(dwellingSocialReceptionNaming);
    }

    
    public final String getDwellingSocialReceptionNaming() {
        return handicapCompensationChildRequestData.getDwellingSocialReceptionNaming();
    }
  
    public final void setFacilitiesAnimalAid(final Boolean facilitiesAnimalAid) {
        handicapCompensationChildRequestData.setFacilitiesAnimalAid(facilitiesAnimalAid);
    }

    
    public final Boolean getFacilitiesAnimalAid() {
        return handicapCompensationChildRequestData.getFacilitiesAnimalAid();
    }
  
    public final void setFacilitiesAnimalAidDetails(final String facilitiesAnimalAidDetails) {
        handicapCompensationChildRequestData.setFacilitiesAnimalAidDetails(facilitiesAnimalAidDetails);
    }

    
    public final String getFacilitiesAnimalAidDetails() {
        return handicapCompensationChildRequestData.getFacilitiesAnimalAidDetails();
    }
  
    public final void setFacilitiesCustomCar(final Boolean facilitiesCustomCar) {
        handicapCompensationChildRequestData.setFacilitiesCustomCar(facilitiesCustomCar);
    }

    
    public final Boolean getFacilitiesCustomCar() {
        return handicapCompensationChildRequestData.getFacilitiesCustomCar();
    }
  
    public final void setFacilitiesCustomCarDetails(final String facilitiesCustomCarDetails) {
        handicapCompensationChildRequestData.setFacilitiesCustomCarDetails(facilitiesCustomCarDetails);
    }

    
    public final String getFacilitiesCustomCarDetails() {
        return handicapCompensationChildRequestData.getFacilitiesCustomCarDetails();
    }
  
    public final void setFacilitiesHousing(final Boolean facilitiesHousing) {
        handicapCompensationChildRequestData.setFacilitiesHousing(facilitiesHousing);
    }

    
    public final Boolean getFacilitiesHousing() {
        return handicapCompensationChildRequestData.getFacilitiesHousing();
    }
  
    public final void setFacilitiesHousingDetails(final String facilitiesHousingDetails) {
        handicapCompensationChildRequestData.setFacilitiesHousingDetails(facilitiesHousingDetails);
    }

    
    public final String getFacilitiesHousingDetails() {
        return handicapCompensationChildRequestData.getFacilitiesHousingDetails();
    }
  
    public final void setFacilitiesSpecializedTransport(final Boolean facilitiesSpecializedTransport) {
        handicapCompensationChildRequestData.setFacilitiesSpecializedTransport(facilitiesSpecializedTransport);
    }

    
    public final Boolean getFacilitiesSpecializedTransport() {
        return handicapCompensationChildRequestData.getFacilitiesSpecializedTransport();
    }
  
    public final void setFacilitiesSpecializedTransportDetails(final String facilitiesSpecializedTransportDetails) {
        handicapCompensationChildRequestData.setFacilitiesSpecializedTransportDetails(facilitiesSpecializedTransportDetails);
    }

    
    public final String getFacilitiesSpecializedTransportDetails() {
        return handicapCompensationChildRequestData.getFacilitiesSpecializedTransportDetails();
    }
  
    public final void setFacilitiesTechnicalAssistance(final Boolean facilitiesTechnicalAssistance) {
        handicapCompensationChildRequestData.setFacilitiesTechnicalAssistance(facilitiesTechnicalAssistance);
    }

    
    public final Boolean getFacilitiesTechnicalAssistance() {
        return handicapCompensationChildRequestData.getFacilitiesTechnicalAssistance();
    }
  
    public final void setFacilitiesTechnicalAssistanceDetails(final String facilitiesTechnicalAssistanceDetails) {
        handicapCompensationChildRequestData.setFacilitiesTechnicalAssistanceDetails(facilitiesTechnicalAssistanceDetails);
    }

    
    public final String getFacilitiesTechnicalAssistanceDetails() {
        return handicapCompensationChildRequestData.getFacilitiesTechnicalAssistanceDetails();
    }
  
    public final void setFamilyAssistanceMembers(final List<fr.cg95.cvq.business.request.social.HccrFamilyAssistanceMember> familyAssistanceMembers) {
        handicapCompensationChildRequestData.setFamilyAssistanceMembers(familyAssistanceMembers);
    }

    
    public final List<fr.cg95.cvq.business.request.social.HccrFamilyAssistanceMember> getFamilyAssistanceMembers() {
        return handicapCompensationChildRequestData.getFamilyAssistanceMembers();
    }
  
    public final void setFamilyDependents(final List<fr.cg95.cvq.business.request.social.HccrFamilyDependent> familyDependents) {
        handicapCompensationChildRequestData.setFamilyDependents(familyDependents);
    }

    
    public final List<fr.cg95.cvq.business.request.social.HccrFamilyDependent> getFamilyDependents() {
        return handicapCompensationChildRequestData.getFamilyDependents();
    }
  
    public final void setFatherActivityReduction(final Boolean fatherActivityReduction) {
        handicapCompensationChildRequestData.setFatherActivityReduction(fatherActivityReduction);
    }

    
    public final Boolean getFatherActivityReduction() {
        return handicapCompensationChildRequestData.getFatherActivityReduction();
    }
  
    public final void setFatherActivityReductionRatio(final java.math.BigInteger fatherActivityReductionRatio) {
        handicapCompensationChildRequestData.setFatherActivityReductionRatio(fatherActivityReductionRatio);
    }

    
    public final java.math.BigInteger getFatherActivityReductionRatio() {
        return handicapCompensationChildRequestData.getFatherActivityReductionRatio();
    }
  
    public final void setFatherFirstName(final String fatherFirstName) {
        handicapCompensationChildRequestData.setFatherFirstName(fatherFirstName);
    }

    
    public final String getFatherFirstName() {
        return handicapCompensationChildRequestData.getFatherFirstName();
    }
  
    public final void setFatherJob(final String fatherJob) {
        handicapCompensationChildRequestData.setFatherJob(fatherJob);
    }

    
    public final String getFatherJob() {
        return handicapCompensationChildRequestData.getFatherJob();
    }
  
    public final void setFatherLastName(final String fatherLastName) {
        handicapCompensationChildRequestData.setFatherLastName(fatherLastName);
    }

    
    public final String getFatherLastName() {
        return handicapCompensationChildRequestData.getFatherLastName();
    }
  
    public final void setFoldersCdes(final Boolean foldersCdes) {
        handicapCompensationChildRequestData.setFoldersCdes(foldersCdes);
    }

    
    public final Boolean getFoldersCdes() {
        return handicapCompensationChildRequestData.getFoldersCdes();
    }
  
    public final void setFoldersCdesDepartment(final String foldersCdesDepartment) {
        handicapCompensationChildRequestData.setFoldersCdesDepartment(foldersCdesDepartment);
    }

    
    public final String getFoldersCdesDepartment() {
        return handicapCompensationChildRequestData.getFoldersCdesDepartment();
    }
  
    public final void setFoldersCdesNumber(final String foldersCdesNumber) {
        handicapCompensationChildRequestData.setFoldersCdesNumber(foldersCdesNumber);
    }

    
    public final String getFoldersCdesNumber() {
        return handicapCompensationChildRequestData.getFoldersCdesNumber();
    }
  
    public final void setFoldersCotorep(final Boolean foldersCotorep) {
        handicapCompensationChildRequestData.setFoldersCotorep(foldersCotorep);
    }

    
    public final Boolean getFoldersCotorep() {
        return handicapCompensationChildRequestData.getFoldersCotorep();
    }
  
    public final void setFoldersCotorepDepartment(final String foldersCotorepDepartment) {
        handicapCompensationChildRequestData.setFoldersCotorepDepartment(foldersCotorepDepartment);
    }

    
    public final String getFoldersCotorepDepartment() {
        return handicapCompensationChildRequestData.getFoldersCotorepDepartment();
    }
  
    public final void setFoldersCotorepNumber(final String foldersCotorepNumber) {
        handicapCompensationChildRequestData.setFoldersCotorepNumber(foldersCotorepNumber);
    }

    
    public final String getFoldersCotorepNumber() {
        return handicapCompensationChildRequestData.getFoldersCotorepNumber();
    }
  
    public final void setFoldersMdph(final Boolean foldersMdph) {
        handicapCompensationChildRequestData.setFoldersMdph(foldersMdph);
    }

    
    public final Boolean getFoldersMdph() {
        return handicapCompensationChildRequestData.getFoldersMdph();
    }
  
    public final void setFoldersMdphDepartment(final String foldersMdphDepartment) {
        handicapCompensationChildRequestData.setFoldersMdphDepartment(foldersMdphDepartment);
    }

    
    public final String getFoldersMdphDepartment() {
        return handicapCompensationChildRequestData.getFoldersMdphDepartment();
    }
  
    public final void setFoldersMdphNumber(final String foldersMdphNumber) {
        handicapCompensationChildRequestData.setFoldersMdphNumber(foldersMdphNumber);
    }

    
    public final String getFoldersMdphNumber() {
        return handicapCompensationChildRequestData.getFoldersMdphNumber();
    }
  
    public final void setFoldersOtherFolders(final Boolean foldersOtherFolders) {
        handicapCompensationChildRequestData.setFoldersOtherFolders(foldersOtherFolders);
    }

    
    public final Boolean getFoldersOtherFolders() {
        return handicapCompensationChildRequestData.getFoldersOtherFolders();
    }
  
    public final void setFormationCurrentFormation(final String formationCurrentFormation) {
        handicapCompensationChildRequestData.setFormationCurrentFormation(formationCurrentFormation);
    }

    
    public final String getFormationCurrentFormation() {
        return handicapCompensationChildRequestData.getFormationCurrentFormation();
    }
  
    public final void setFormationDiploma(final String formationDiploma) {
        handicapCompensationChildRequestData.setFormationDiploma(formationDiploma);
    }

    
    public final String getFormationDiploma() {
        return handicapCompensationChildRequestData.getFormationDiploma();
    }
  
    public final void setFormationPreviousFormation(final String formationPreviousFormation) {
        handicapCompensationChildRequestData.setFormationPreviousFormation(formationPreviousFormation);
    }

    
    public final String getFormationPreviousFormation() {
        return handicapCompensationChildRequestData.getFormationPreviousFormation();
    }
  
    public final void setFormationStudiesLevel(final String formationStudiesLevel) {
        handicapCompensationChildRequestData.setFormationStudiesLevel(formationStudiesLevel);
    }

    
    public final String getFormationStudiesLevel() {
        return handicapCompensationChildRequestData.getFormationStudiesLevel();
    }
  
    public final void setHealthDoctorFirstName(final String healthDoctorFirstName) {
        handicapCompensationChildRequestData.setHealthDoctorFirstName(healthDoctorFirstName);
    }

    
    public final String getHealthDoctorFirstName() {
        return handicapCompensationChildRequestData.getHealthDoctorFirstName();
    }
  
    public final void setHealthDoctorLastName(final String healthDoctorLastName) {
        handicapCompensationChildRequestData.setHealthDoctorLastName(healthDoctorLastName);
    }

    
    public final String getHealthDoctorLastName() {
        return handicapCompensationChildRequestData.getHealthDoctorLastName();
    }
  
    public final void setHealthFollowedByDoctor(final Boolean healthFollowedByDoctor) {
        handicapCompensationChildRequestData.setHealthFollowedByDoctor(healthFollowedByDoctor);
    }

    
    public final Boolean getHealthFollowedByDoctor() {
        return handicapCompensationChildRequestData.getHealthFollowedByDoctor();
    }
  
    public final void setHealthFollowedByHospital(final Boolean healthFollowedByHospital) {
        handicapCompensationChildRequestData.setHealthFollowedByHospital(healthFollowedByHospital);
    }

    
    public final Boolean getHealthFollowedByHospital() {
        return handicapCompensationChildRequestData.getHealthFollowedByHospital();
    }
  
    public final void setHealthFollowedByProfessional(final Boolean healthFollowedByProfessional) {
        handicapCompensationChildRequestData.setHealthFollowedByProfessional(healthFollowedByProfessional);
    }

    
    public final Boolean getHealthFollowedByProfessional() {
        return handicapCompensationChildRequestData.getHealthFollowedByProfessional();
    }
  
    public final void setHealthHospitalName(final String healthHospitalName) {
        handicapCompensationChildRequestData.setHealthHospitalName(healthHospitalName);
    }

    
    public final String getHealthHospitalName() {
        return handicapCompensationChildRequestData.getHealthHospitalName();
    }
  
    public final void setHealthProfessionalFirstName(final String healthProfessionalFirstName) {
        handicapCompensationChildRequestData.setHealthProfessionalFirstName(healthProfessionalFirstName);
    }

    
    public final String getHealthProfessionalFirstName() {
        return handicapCompensationChildRequestData.getHealthProfessionalFirstName();
    }
  
    public final void setHealthProfessionalLastName(final String healthProfessionalLastName) {
        handicapCompensationChildRequestData.setHealthProfessionalLastName(healthProfessionalLastName);
    }

    
    public final String getHealthProfessionalLastName() {
        return handicapCompensationChildRequestData.getHealthProfessionalLastName();
    }
  
    public final void setHomeIntervenants(final List<fr.cg95.cvq.business.request.social.HccrHomeIntervenant> homeIntervenants) {
        handicapCompensationChildRequestData.setHomeIntervenants(homeIntervenants);
    }

    
    public final List<fr.cg95.cvq.business.request.social.HccrHomeIntervenant> getHomeIntervenants() {
        return handicapCompensationChildRequestData.getHomeIntervenants();
    }
  
    public final void setHomeInterventionHomeIntervenant(final Boolean homeInterventionHomeIntervenant) {
        handicapCompensationChildRequestData.setHomeInterventionHomeIntervenant(homeInterventionHomeIntervenant);
    }

    
    public final Boolean getHomeInterventionHomeIntervenant() {
        return handicapCompensationChildRequestData.getHomeInterventionHomeIntervenant();
    }
  
    public final void setIsFamilyAssistance(final Boolean isFamilyAssistance) {
        handicapCompensationChildRequestData.setIsFamilyAssistance(isFamilyAssistance);
    }

    
    public final Boolean getIsFamilyAssistance() {
        return handicapCompensationChildRequestData.getIsFamilyAssistance();
    }
  
    public final void setMotherActivityReduction(final Boolean motherActivityReduction) {
        handicapCompensationChildRequestData.setMotherActivityReduction(motherActivityReduction);
    }

    
    public final Boolean getMotherActivityReduction() {
        return handicapCompensationChildRequestData.getMotherActivityReduction();
    }
  
    public final void setMotherActivityReductionRatio(final java.math.BigInteger motherActivityReductionRatio) {
        handicapCompensationChildRequestData.setMotherActivityReductionRatio(motherActivityReductionRatio);
    }

    
    public final java.math.BigInteger getMotherActivityReductionRatio() {
        return handicapCompensationChildRequestData.getMotherActivityReductionRatio();
    }
  
    public final void setMotherFirstName(final String motherFirstName) {
        handicapCompensationChildRequestData.setMotherFirstName(motherFirstName);
    }

    
    public final String getMotherFirstName() {
        return handicapCompensationChildRequestData.getMotherFirstName();
    }
  
    public final void setMotherJob(final String motherJob) {
        handicapCompensationChildRequestData.setMotherJob(motherJob);
    }

    
    public final String getMotherJob() {
        return handicapCompensationChildRequestData.getMotherJob();
    }
  
    public final void setMotherLastName(final String motherLastName) {
        handicapCompensationChildRequestData.setMotherLastName(motherLastName);
    }

    
    public final String getMotherLastName() {
        return handicapCompensationChildRequestData.getMotherLastName();
    }
  
    public final void setOtherBenefits(final List<fr.cg95.cvq.business.request.social.HccrOtherBenefit> otherBenefits) {
        handicapCompensationChildRequestData.setOtherBenefits(otherBenefits);
    }

    
    public final List<fr.cg95.cvq.business.request.social.HccrOtherBenefit> getOtherBenefits() {
        return handicapCompensationChildRequestData.getOtherBenefits();
    }
  
    public final void setOtherFolders(final List<fr.cg95.cvq.business.request.social.HccrOtherFolder> otherFolders) {
        handicapCompensationChildRequestData.setOtherFolders(otherFolders);
    }

    
    public final List<fr.cg95.cvq.business.request.social.HccrOtherFolder> getOtherFolders() {
        return handicapCompensationChildRequestData.getOtherFolders();
    }
  
    public final void setPaymentAgencyAddress(final fr.cg95.cvq.business.users.Address paymentAgencyAddress) {
        handicapCompensationChildRequestData.setPaymentAgencyAddress(paymentAgencyAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getPaymentAgencyAddress() {
        return handicapCompensationChildRequestData.getPaymentAgencyAddress();
    }
  
    public final void setPaymentAgencyBeneficiary(final fr.cg95.cvq.business.request.social.HccrPaymentAgencyBeneficiaryType paymentAgencyBeneficiary) {
        handicapCompensationChildRequestData.setPaymentAgencyBeneficiary(paymentAgencyBeneficiary);
    }

    
    public final fr.cg95.cvq.business.request.social.HccrPaymentAgencyBeneficiaryType getPaymentAgencyBeneficiary() {
        return handicapCompensationChildRequestData.getPaymentAgencyBeneficiary();
    }
  
    public final void setPaymentAgencyBeneficiaryNumber(final String paymentAgencyBeneficiaryNumber) {
        handicapCompensationChildRequestData.setPaymentAgencyBeneficiaryNumber(paymentAgencyBeneficiaryNumber);
    }

    
    public final String getPaymentAgencyBeneficiaryNumber() {
        return handicapCompensationChildRequestData.getPaymentAgencyBeneficiaryNumber();
    }
  
    public final void setPaymentAgencyName(final String paymentAgencyName) {
        handicapCompensationChildRequestData.setPaymentAgencyName(paymentAgencyName);
    }

    
    public final String getPaymentAgencyName() {
        return handicapCompensationChildRequestData.getPaymentAgencyName();
    }
  
    public final void setProfessionalStatusAddress(final fr.cg95.cvq.business.users.Address professionalStatusAddress) {
        handicapCompensationChildRequestData.setProfessionalStatusAddress(professionalStatusAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getProfessionalStatusAddress() {
        return handicapCompensationChildRequestData.getProfessionalStatusAddress();
    }
  
    public final void setProfessionalStatusDate(final java.util.Date professionalStatusDate) {
        handicapCompensationChildRequestData.setProfessionalStatusDate(professionalStatusDate);
    }

    
    public final java.util.Date getProfessionalStatusDate() {
        return handicapCompensationChildRequestData.getProfessionalStatusDate();
    }
  
    public final void setProfessionalStatusElectiveFunction(final Boolean professionalStatusElectiveFunction) {
        handicapCompensationChildRequestData.setProfessionalStatusElectiveFunction(professionalStatusElectiveFunction);
    }

    
    public final Boolean getProfessionalStatusElectiveFunction() {
        return handicapCompensationChildRequestData.getProfessionalStatusElectiveFunction();
    }
  
    public final void setProfessionalStatusElectiveFunctionDetails(final String professionalStatusElectiveFunctionDetails) {
        handicapCompensationChildRequestData.setProfessionalStatusElectiveFunctionDetails(professionalStatusElectiveFunctionDetails);
    }

    
    public final String getProfessionalStatusElectiveFunctionDetails() {
        return handicapCompensationChildRequestData.getProfessionalStatusElectiveFunctionDetails();
    }
  
    public final void setProfessionalStatusEmployerName(final String professionalStatusEmployerName) {
        handicapCompensationChildRequestData.setProfessionalStatusEmployerName(professionalStatusEmployerName);
    }

    
    public final String getProfessionalStatusEmployerName() {
        return handicapCompensationChildRequestData.getProfessionalStatusEmployerName();
    }
  
    public final void setProfessionalStatusEnvironment(final fr.cg95.cvq.business.request.social.HccrProfessionalStatusEnvironmentType professionalStatusEnvironment) {
        handicapCompensationChildRequestData.setProfessionalStatusEnvironment(professionalStatusEnvironment);
    }

    
    public final fr.cg95.cvq.business.request.social.HccrProfessionalStatusEnvironmentType getProfessionalStatusEnvironment() {
        return handicapCompensationChildRequestData.getProfessionalStatusEnvironment();
    }
  
    public final void setProfessionalStatusIndemnified(final Boolean professionalStatusIndemnified) {
        handicapCompensationChildRequestData.setProfessionalStatusIndemnified(professionalStatusIndemnified);
    }

    
    public final Boolean getProfessionalStatusIndemnified() {
        return handicapCompensationChildRequestData.getProfessionalStatusIndemnified();
    }
  
    public final void setProfessionalStatusIndemnifiedDate(final java.util.Date professionalStatusIndemnifiedDate) {
        handicapCompensationChildRequestData.setProfessionalStatusIndemnifiedDate(professionalStatusIndemnifiedDate);
    }

    
    public final java.util.Date getProfessionalStatusIndemnifiedDate() {
        return handicapCompensationChildRequestData.getProfessionalStatusIndemnifiedDate();
    }
  
    public final void setProfessionalStatusKind(final fr.cg95.cvq.business.request.social.HccrProfessionalStatusKindType professionalStatusKind) {
        handicapCompensationChildRequestData.setProfessionalStatusKind(professionalStatusKind);
    }

    
    public final fr.cg95.cvq.business.request.social.HccrProfessionalStatusKindType getProfessionalStatusKind() {
        return handicapCompensationChildRequestData.getProfessionalStatusKind();
    }
  
    public final void setProfessionalStatusProfession(final String professionalStatusProfession) {
        handicapCompensationChildRequestData.setProfessionalStatusProfession(professionalStatusProfession);
    }

    
    public final String getProfessionalStatusProfession() {
        return handicapCompensationChildRequestData.getProfessionalStatusProfession();
    }
  
    public final void setProfessionalStatusRegisterAsUnemployed(final Boolean professionalStatusRegisterAsUnemployed) {
        handicapCompensationChildRequestData.setProfessionalStatusRegisterAsUnemployed(professionalStatusRegisterAsUnemployed);
    }

    
    public final Boolean getProfessionalStatusRegisterAsUnemployed() {
        return handicapCompensationChildRequestData.getProfessionalStatusRegisterAsUnemployed();
    }
  
    public final void setProfessionalStatusRegisterAsUnemployedDate(final java.util.Date professionalStatusRegisterAsUnemployedDate) {
        handicapCompensationChildRequestData.setProfessionalStatusRegisterAsUnemployedDate(professionalStatusRegisterAsUnemployedDate);
    }

    
    public final java.util.Date getProfessionalStatusRegisterAsUnemployedDate() {
        return handicapCompensationChildRequestData.getProfessionalStatusRegisterAsUnemployedDate();
    }
  
    public final void setProfessionalSupportDealsWithSameProfessional(final Boolean professionalSupportDealsWithSameProfessional) {
        handicapCompensationChildRequestData.setProfessionalSupportDealsWithSameProfessional(professionalSupportDealsWithSameProfessional);
    }

    
    public final Boolean getProfessionalSupportDealsWithSameProfessional() {
        return handicapCompensationChildRequestData.getProfessionalSupportDealsWithSameProfessional();
    }
  
    public final void setProfessionalSupportProfessionals(final Boolean professionalSupportProfessionals) {
        handicapCompensationChildRequestData.setProfessionalSupportProfessionals(professionalSupportProfessionals);
    }

    
    public final Boolean getProfessionalSupportProfessionals() {
        return handicapCompensationChildRequestData.getProfessionalSupportProfessionals();
    }
  
    public final void setProfessionals(final List<fr.cg95.cvq.business.request.social.HccrProfessional> professionals) {
        handicapCompensationChildRequestData.setProfessionals(professionals);
    }

    
    public final List<fr.cg95.cvq.business.request.social.HccrProfessional> getProfessionals() {
        return handicapCompensationChildRequestData.getProfessionals();
    }
  
    public final void setProjectComments(final String projectComments) {
        handicapCompensationChildRequestData.setProjectComments(projectComments);
    }

    
    public final String getProjectComments() {
        return handicapCompensationChildRequestData.getProjectComments();
    }
  
    public final void setProjectNeeds(final String projectNeeds) {
        handicapCompensationChildRequestData.setProjectNeeds(projectNeeds);
    }

    
    public final String getProjectNeeds() {
        return handicapCompensationChildRequestData.getProjectNeeds();
    }
  
    public final void setProjectRequestsACTPRenewal(final Boolean projectRequestsACTPRenewal) {
        handicapCompensationChildRequestData.setProjectRequestsACTPRenewal(projectRequestsACTPRenewal);
    }

    
    public final Boolean getProjectRequestsACTPRenewal() {
        return handicapCompensationChildRequestData.getProjectRequestsACTPRenewal();
    }
  
    public final void setProjectRequestsAssistance(final Boolean projectRequestsAssistance) {
        handicapCompensationChildRequestData.setProjectRequestsAssistance(projectRequestsAssistance);
    }

    
    public final Boolean getProjectRequestsAssistance() {
        return handicapCompensationChildRequestData.getProjectRequestsAssistance();
    }
  
    public final void setProjectRequestsCustomCar(final Boolean projectRequestsCustomCar) {
        handicapCompensationChildRequestData.setProjectRequestsCustomCar(projectRequestsCustomCar);
    }

    
    public final Boolean getProjectRequestsCustomCar() {
        return handicapCompensationChildRequestData.getProjectRequestsCustomCar();
    }
  
    public final void setProjectRequestsDisabilityCard(final Boolean projectRequestsDisabilityCard) {
        handicapCompensationChildRequestData.setProjectRequestsDisabilityCard(projectRequestsDisabilityCard);
    }

    
    public final Boolean getProjectRequestsDisabilityCard() {
        return handicapCompensationChildRequestData.getProjectRequestsDisabilityCard();
    }
  
    public final void setProjectRequestsDisabilityCostAllocation(final Boolean projectRequestsDisabilityCostAllocation) {
        handicapCompensationChildRequestData.setProjectRequestsDisabilityCostAllocation(projectRequestsDisabilityCostAllocation);
    }

    
    public final Boolean getProjectRequestsDisabilityCostAllocation() {
        return handicapCompensationChildRequestData.getProjectRequestsDisabilityCostAllocation();
    }
  
    public final void setProjectRequestsDisabledAdultAllowance(final Boolean projectRequestsDisabledAdultAllowance) {
        handicapCompensationChildRequestData.setProjectRequestsDisabledAdultAllowance(projectRequestsDisabledAdultAllowance);
    }

    
    public final Boolean getProjectRequestsDisabledAdultAllowance() {
        return handicapCompensationChildRequestData.getProjectRequestsDisabledAdultAllowance();
    }
  
    public final void setProjectRequestsDisabledPriorityCard(final Boolean projectRequestsDisabledPriorityCard) {
        handicapCompensationChildRequestData.setProjectRequestsDisabledPriorityCard(projectRequestsDisabledPriorityCard);
    }

    
    public final Boolean getProjectRequestsDisabledPriorityCard() {
        return handicapCompensationChildRequestData.getProjectRequestsDisabledPriorityCard();
    }
  
    public final void setProjectRequestsDisabledWorkerRecognition(final Boolean projectRequestsDisabledWorkerRecognition) {
        handicapCompensationChildRequestData.setProjectRequestsDisabledWorkerRecognition(projectRequestsDisabledWorkerRecognition);
    }

    
    public final Boolean getProjectRequestsDisabledWorkerRecognition() {
        return handicapCompensationChildRequestData.getProjectRequestsDisabledWorkerRecognition();
    }
  
    public final void setProjectRequestsEducationAllocationOfDisabledChildren(final Boolean projectRequestsEducationAllocationOfDisabledChildren) {
        handicapCompensationChildRequestData.setProjectRequestsEducationAllocationOfDisabledChildren(projectRequestsEducationAllocationOfDisabledChildren);
    }

    
    public final Boolean getProjectRequestsEducationAllocationOfDisabledChildren() {
        return handicapCompensationChildRequestData.getProjectRequestsEducationAllocationOfDisabledChildren();
    }
  
    public final void setProjectRequestsEuropeanParkingCard(final Boolean projectRequestsEuropeanParkingCard) {
        handicapCompensationChildRequestData.setProjectRequestsEuropeanParkingCard(projectRequestsEuropeanParkingCard);
    }

    
    public final Boolean getProjectRequestsEuropeanParkingCard() {
        return handicapCompensationChildRequestData.getProjectRequestsEuropeanParkingCard();
    }
  
    public final void setProjectRequestsFreePensionMembership(final Boolean projectRequestsFreePensionMembership) {
        handicapCompensationChildRequestData.setProjectRequestsFreePensionMembership(projectRequestsFreePensionMembership);
    }

    
    public final Boolean getProjectRequestsFreePensionMembership() {
        return handicapCompensationChildRequestData.getProjectRequestsFreePensionMembership();
    }
  
    public final void setProjectRequestsHandicapRecognition(final Boolean projectRequestsHandicapRecognition) {
        handicapCompensationChildRequestData.setProjectRequestsHandicapRecognition(projectRequestsHandicapRecognition);
    }

    
    public final Boolean getProjectRequestsHandicapRecognition() {
        return handicapCompensationChildRequestData.getProjectRequestsHandicapRecognition();
    }
  
    public final void setProjectRequestsHousingFacilities(final Boolean projectRequestsHousingFacilities) {
        handicapCompensationChildRequestData.setProjectRequestsHousingFacilities(projectRequestsHousingFacilities);
    }

    
    public final Boolean getProjectRequestsHousingFacilities() {
        return handicapCompensationChildRequestData.getProjectRequestsHousingFacilities();
    }
  
    public final void setProjectRequestsIncreaseForIndependentLiving(final Boolean projectRequestsIncreaseForIndependentLiving) {
        handicapCompensationChildRequestData.setProjectRequestsIncreaseForIndependentLiving(projectRequestsIncreaseForIndependentLiving);
    }

    
    public final Boolean getProjectRequestsIncreaseForIndependentLiving() {
        return handicapCompensationChildRequestData.getProjectRequestsIncreaseForIndependentLiving();
    }
  
    public final void setProjectRequestsInstitutionSupport(final Boolean projectRequestsInstitutionSupport) {
        handicapCompensationChildRequestData.setProjectRequestsInstitutionSupport(projectRequestsInstitutionSupport);
    }

    
    public final Boolean getProjectRequestsInstitutionSupport() {
        return handicapCompensationChildRequestData.getProjectRequestsInstitutionSupport();
    }
  
    public final void setProjectRequestsOrdinaryWorking(final Boolean projectRequestsOrdinaryWorking) {
        handicapCompensationChildRequestData.setProjectRequestsOrdinaryWorking(projectRequestsOrdinaryWorking);
    }

    
    public final Boolean getProjectRequestsOrdinaryWorking() {
        return handicapCompensationChildRequestData.getProjectRequestsOrdinaryWorking();
    }
  
    public final void setProjectRequestsOther(final Boolean projectRequestsOther) {
        handicapCompensationChildRequestData.setProjectRequestsOther(projectRequestsOther);
    }

    
    public final Boolean getProjectRequestsOther() {
        return handicapCompensationChildRequestData.getProjectRequestsOther();
    }
  
    public final void setProjectRequestsOtherDetails(final String projectRequestsOtherDetails) {
        handicapCompensationChildRequestData.setProjectRequestsOtherDetails(projectRequestsOtherDetails);
    }

    
    public final String getProjectRequestsOtherDetails() {
        return handicapCompensationChildRequestData.getProjectRequestsOtherDetails();
    }
  
    public final void setProjectRequestsProfessionalOrientation(final Boolean projectRequestsProfessionalOrientation) {
        handicapCompensationChildRequestData.setProjectRequestsProfessionalOrientation(projectRequestsProfessionalOrientation);
    }

    
    public final Boolean getProjectRequestsProfessionalOrientation() {
        return handicapCompensationChildRequestData.getProjectRequestsProfessionalOrientation();
    }
  
    public final void setProjectRequestsShelteredWork(final Boolean projectRequestsShelteredWork) {
        handicapCompensationChildRequestData.setProjectRequestsShelteredWork(projectRequestsShelteredWork);
    }

    
    public final Boolean getProjectRequestsShelteredWork() {
        return handicapCompensationChildRequestData.getProjectRequestsShelteredWork();
    }
  
    public final void setProjectRequestsTechnicalHelp(final Boolean projectRequestsTechnicalHelp) {
        handicapCompensationChildRequestData.setProjectRequestsTechnicalHelp(projectRequestsTechnicalHelp);
    }

    
    public final Boolean getProjectRequestsTechnicalHelp() {
        return handicapCompensationChildRequestData.getProjectRequestsTechnicalHelp();
    }
  
    public final void setProjectRequestsThirdPartyHelp(final Boolean projectRequestsThirdPartyHelp) {
        handicapCompensationChildRequestData.setProjectRequestsThirdPartyHelp(projectRequestsThirdPartyHelp);
    }

    
    public final Boolean getProjectRequestsThirdPartyHelp() {
        return handicapCompensationChildRequestData.getProjectRequestsThirdPartyHelp();
    }
  
    public final void setProjectRequestsTransportCostAllocation(final Boolean projectRequestsTransportCostAllocation) {
        handicapCompensationChildRequestData.setProjectRequestsTransportCostAllocation(projectRequestsTransportCostAllocation);
    }

    
    public final Boolean getProjectRequestsTransportCostAllocation() {
        return handicapCompensationChildRequestData.getProjectRequestsTransportCostAllocation();
    }
  
    public final void setProjectRequestsVocationalTraining(final Boolean projectRequestsVocationalTraining) {
        handicapCompensationChildRequestData.setProjectRequestsVocationalTraining(projectRequestsVocationalTraining);
    }

    
    public final Boolean getProjectRequestsVocationalTraining() {
        return handicapCompensationChildRequestData.getProjectRequestsVocationalTraining();
    }
  
    public final void setProjectWish(final String projectWish) {
        handicapCompensationChildRequestData.setProjectWish(projectWish);
    }

    
    public final String getProjectWish() {
        return handicapCompensationChildRequestData.getProjectWish();
    }
  
    public final void setReferentBirthCity(final String referentBirthCity) {
        handicapCompensationChildRequestData.setReferentBirthCity(referentBirthCity);
    }

    
    public final String getReferentBirthCity() {
        return handicapCompensationChildRequestData.getReferentBirthCity();
    }
  
    public final void setReferentBirthCountry(final String referentBirthCountry) {
        handicapCompensationChildRequestData.setReferentBirthCountry(referentBirthCountry);
    }

    
    public final String getReferentBirthCountry() {
        return handicapCompensationChildRequestData.getReferentBirthCountry();
    }
  
    public final void setReferentBirthDate(final java.util.Date referentBirthDate) {
        handicapCompensationChildRequestData.setReferentBirthDate(referentBirthDate);
    }

    
    public final java.util.Date getReferentBirthDate() {
        return handicapCompensationChildRequestData.getReferentBirthDate();
    }
  
    public final void setReferentFamilyDependents(final Boolean referentFamilyDependents) {
        handicapCompensationChildRequestData.setReferentFamilyDependents(referentFamilyDependents);
    }

    
    public final Boolean getReferentFamilyDependents() {
        return handicapCompensationChildRequestData.getReferentFamilyDependents();
    }
  
    public final void setReferentFamilyStatus(final fr.cg95.cvq.business.users.FamilyStatusType referentFamilyStatus) {
        handicapCompensationChildRequestData.setReferentFamilyStatus(referentFamilyStatus);
    }

    
    public final fr.cg95.cvq.business.users.FamilyStatusType getReferentFamilyStatus() {
        return handicapCompensationChildRequestData.getReferentFamilyStatus();
    }
  
    public final void setReferentFirstName(final String referentFirstName) {
        handicapCompensationChildRequestData.setReferentFirstName(referentFirstName);
    }

    
    public final String getReferentFirstName() {
        return handicapCompensationChildRequestData.getReferentFirstName();
    }
  
    public final void setReferentLastName(final String referentLastName) {
        handicapCompensationChildRequestData.setReferentLastName(referentLastName);
    }

    
    public final String getReferentLastName() {
        return handicapCompensationChildRequestData.getReferentLastName();
    }
  
    public final void setReferentMaidenName(final String referentMaidenName) {
        handicapCompensationChildRequestData.setReferentMaidenName(referentMaidenName);
    }

    
    public final String getReferentMaidenName() {
        return handicapCompensationChildRequestData.getReferentMaidenName();
    }
  
    public final void setReferentTitle(final fr.cg95.cvq.business.users.TitleType referentTitle) {
        handicapCompensationChildRequestData.setReferentTitle(referentTitle);
    }

    
    public final fr.cg95.cvq.business.users.TitleType getReferentTitle() {
        return handicapCompensationChildRequestData.getReferentTitle();
    }
  
    public final void setSchoolingAttendedGrade(final fr.cg95.cvq.business.users.SectionType schoolingAttendedGrade) {
        handicapCompensationChildRequestData.setSchoolingAttendedGrade(schoolingAttendedGrade);
    }

    
    public final fr.cg95.cvq.business.users.SectionType getSchoolingAttendedGrade() {
        return handicapCompensationChildRequestData.getSchoolingAttendedGrade();
    }
  
    public final void setSchoolingEnrolment(final Boolean schoolingEnrolment) {
        handicapCompensationChildRequestData.setSchoolingEnrolment(schoolingEnrolment);
    }

    
    public final Boolean getSchoolingEnrolment() {
        return handicapCompensationChildRequestData.getSchoolingEnrolment();
    }
  
    public final void setSchoolingExtraCurricular(final Boolean schoolingExtraCurricular) {
        handicapCompensationChildRequestData.setSchoolingExtraCurricular(schoolingExtraCurricular);
    }

    
    public final Boolean getSchoolingExtraCurricular() {
        return handicapCompensationChildRequestData.getSchoolingExtraCurricular();
    }
  
    public final void setSchoolingExtraCurricularDetails(final String schoolingExtraCurricularDetails) {
        handicapCompensationChildRequestData.setSchoolingExtraCurricularDetails(schoolingExtraCurricularDetails);
    }

    
    public final String getSchoolingExtraCurricularDetails() {
        return handicapCompensationChildRequestData.getSchoolingExtraCurricularDetails();
    }
  
    public final void setSchoolingHomeSchooling(final Boolean schoolingHomeSchooling) {
        handicapCompensationChildRequestData.setSchoolingHomeSchooling(schoolingHomeSchooling);
    }

    
    public final Boolean getSchoolingHomeSchooling() {
        return handicapCompensationChildRequestData.getSchoolingHomeSchooling();
    }
  
    public final void setSchoolingHomeSchoolingAccompanistAddress(final fr.cg95.cvq.business.users.Address schoolingHomeSchoolingAccompanistAddress) {
        handicapCompensationChildRequestData.setSchoolingHomeSchoolingAccompanistAddress(schoolingHomeSchoolingAccompanistAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getSchoolingHomeSchoolingAccompanistAddress() {
        return handicapCompensationChildRequestData.getSchoolingHomeSchoolingAccompanistAddress();
    }
  
    public final void setSchoolingHomeSchoolingAccompanistFirstName(final String schoolingHomeSchoolingAccompanistFirstName) {
        handicapCompensationChildRequestData.setSchoolingHomeSchoolingAccompanistFirstName(schoolingHomeSchoolingAccompanistFirstName);
    }

    
    public final String getSchoolingHomeSchoolingAccompanistFirstName() {
        return handicapCompensationChildRequestData.getSchoolingHomeSchoolingAccompanistFirstName();
    }
  
    public final void setSchoolingHomeSchoolingAccompanistLastName(final String schoolingHomeSchoolingAccompanistLastName) {
        handicapCompensationChildRequestData.setSchoolingHomeSchoolingAccompanistLastName(schoolingHomeSchoolingAccompanistLastName);
    }

    
    public final String getSchoolingHomeSchoolingAccompanistLastName() {
        return handicapCompensationChildRequestData.getSchoolingHomeSchoolingAccompanistLastName();
    }
  
    public final void setSchoolingHomeSchoolingKind(final fr.cg95.cvq.business.request.social.HccrHomeSchoolingKindType schoolingHomeSchoolingKind) {
        handicapCompensationChildRequestData.setSchoolingHomeSchoolingKind(schoolingHomeSchoolingKind);
    }

    
    public final fr.cg95.cvq.business.request.social.HccrHomeSchoolingKindType getSchoolingHomeSchoolingKind() {
        return handicapCompensationChildRequestData.getSchoolingHomeSchoolingKind();
    }
  
    public final void setSchoolingPersonalizedSchoolingPlan(final Boolean schoolingPersonalizedSchoolingPlan) {
        handicapCompensationChildRequestData.setSchoolingPersonalizedSchoolingPlan(schoolingPersonalizedSchoolingPlan);
    }

    
    public final Boolean getSchoolingPersonalizedSchoolingPlan() {
        return handicapCompensationChildRequestData.getSchoolingPersonalizedSchoolingPlan();
    }
  
    public final void setSchoolingSchoolAddress(final fr.cg95.cvq.business.users.Address schoolingSchoolAddress) {
        handicapCompensationChildRequestData.setSchoolingSchoolAddress(schoolingSchoolAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getSchoolingSchoolAddress() {
        return handicapCompensationChildRequestData.getSchoolingSchoolAddress();
    }
  
    public final void setSchoolingSchoolName(final String schoolingSchoolName) {
        handicapCompensationChildRequestData.setSchoolingSchoolName(schoolingSchoolName);
    }

    
    public final String getSchoolingSchoolName() {
        return handicapCompensationChildRequestData.getSchoolingSchoolName();
    }
  
    public final void setSchoolingSchoolingKind(final fr.cg95.cvq.business.request.social.HccrSchoolingKindType schoolingSchoolingKind) {
        handicapCompensationChildRequestData.setSchoolingSchoolingKind(schoolingSchoolingKind);
    }

    
    public final fr.cg95.cvq.business.request.social.HccrSchoolingKindType getSchoolingSchoolingKind() {
        return handicapCompensationChildRequestData.getSchoolingSchoolingKind();
    }
  
    public final void setSchoolingSendToSchool(final Boolean schoolingSendToSchool) {
        handicapCompensationChildRequestData.setSchoolingSendToSchool(schoolingSendToSchool);
    }

    
    public final Boolean getSchoolingSendToSchool() {
        return handicapCompensationChildRequestData.getSchoolingSendToSchool();
    }
  
    public final void setSchoolingSpecializedGrade(final Boolean schoolingSpecializedGrade) {
        handicapCompensationChildRequestData.setSchoolingSpecializedGrade(schoolingSpecializedGrade);
    }

    
    public final Boolean getSchoolingSpecializedGrade() {
        return handicapCompensationChildRequestData.getSchoolingSpecializedGrade();
    }
  
    public final void setSchoolingSpecializedGradeDetails(final String schoolingSpecializedGradeDetails) {
        handicapCompensationChildRequestData.setSchoolingSpecializedGradeDetails(schoolingSpecializedGradeDetails);
    }

    
    public final String getSchoolingSpecializedGradeDetails() {
        return handicapCompensationChildRequestData.getSchoolingSpecializedGradeDetails();
    }
  
    public final void setSchoolingTime(final String schoolingTime) {
        handicapCompensationChildRequestData.setSchoolingTime(schoolingTime);
    }

    
    public final String getSchoolingTime() {
        return handicapCompensationChildRequestData.getSchoolingTime();
    }
  
    public final void setSocialSecurityAgencyAddress(final fr.cg95.cvq.business.users.Address socialSecurityAgencyAddress) {
        handicapCompensationChildRequestData.setSocialSecurityAgencyAddress(socialSecurityAgencyAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getSocialSecurityAgencyAddress() {
        return handicapCompensationChildRequestData.getSocialSecurityAgencyAddress();
    }
  
    public final void setSocialSecurityAgencyName(final String socialSecurityAgencyName) {
        handicapCompensationChildRequestData.setSocialSecurityAgencyName(socialSecurityAgencyName);
    }

    
    public final String getSocialSecurityAgencyName() {
        return handicapCompensationChildRequestData.getSocialSecurityAgencyName();
    }
  
    public final void setSocialSecurityMemberShipKind(final fr.cg95.cvq.business.request.social.HccrSocialSecurityMemberShipKindType socialSecurityMemberShipKind) {
        handicapCompensationChildRequestData.setSocialSecurityMemberShipKind(socialSecurityMemberShipKind);
    }

    
    public final fr.cg95.cvq.business.request.social.HccrSocialSecurityMemberShipKindType getSocialSecurityMemberShipKind() {
        return handicapCompensationChildRequestData.getSocialSecurityMemberShipKind();
    }
  
    public final void setSocialSecurityNumber(final String socialSecurityNumber) {
        handicapCompensationChildRequestData.setSocialSecurityNumber(socialSecurityNumber);
    }

    
    public final String getSocialSecurityNumber() {
        return handicapCompensationChildRequestData.getSocialSecurityNumber();
    }
  
    public final void setSocialServiceAddress(final fr.cg95.cvq.business.users.Address socialServiceAddress) {
        handicapCompensationChildRequestData.setSocialServiceAddress(socialServiceAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getSocialServiceAddress() {
        return handicapCompensationChildRequestData.getSocialServiceAddress();
    }
  
    public final void setSocialServiceName(final String socialServiceName) {
        handicapCompensationChildRequestData.setSocialServiceName(socialServiceName);
    }

    
    public final String getSocialServiceName() {
        return handicapCompensationChildRequestData.getSocialServiceName();
    }
  
    public final void setSocialServiceSupport(final Boolean socialServiceSupport) {
        handicapCompensationChildRequestData.setSocialServiceSupport(socialServiceSupport);
    }

    
    public final Boolean getSocialServiceSupport() {
        return handicapCompensationChildRequestData.getSocialServiceSupport();
    }
  
    public final void setStudiesAssistanceUnderDisability(final Boolean studiesAssistanceUnderDisability) {
        handicapCompensationChildRequestData.setStudiesAssistanceUnderDisability(studiesAssistanceUnderDisability);
    }

    
    public final Boolean getStudiesAssistanceUnderDisability() {
        return handicapCompensationChildRequestData.getStudiesAssistanceUnderDisability();
    }
  
    public final void setStudiesAssistanceUnderDisabilityDetails(final String studiesAssistanceUnderDisabilityDetails) {
        handicapCompensationChildRequestData.setStudiesAssistanceUnderDisabilityDetails(studiesAssistanceUnderDisabilityDetails);
    }

    
    public final String getStudiesAssistanceUnderDisabilityDetails() {
        return handicapCompensationChildRequestData.getStudiesAssistanceUnderDisabilityDetails();
    }
  
    public final void setStudiesHighSchool(final Boolean studiesHighSchool) {
        handicapCompensationChildRequestData.setStudiesHighSchool(studiesHighSchool);
    }

    
    public final Boolean getStudiesHighSchool() {
        return handicapCompensationChildRequestData.getStudiesHighSchool();
    }
  
    public final void setStudiesHighSchoolAddress(final fr.cg95.cvq.business.users.Address studiesHighSchoolAddress) {
        handicapCompensationChildRequestData.setStudiesHighSchoolAddress(studiesHighSchoolAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getStudiesHighSchoolAddress() {
        return handicapCompensationChildRequestData.getStudiesHighSchoolAddress();
    }
  
    public final void setStudiesHighSchoolGrade(final String studiesHighSchoolGrade) {
        handicapCompensationChildRequestData.setStudiesHighSchoolGrade(studiesHighSchoolGrade);
    }

    
    public final String getStudiesHighSchoolGrade() {
        return handicapCompensationChildRequestData.getStudiesHighSchoolGrade();
    }
  
    public final void setStudiesHighSchoolName(final String studiesHighSchoolName) {
        handicapCompensationChildRequestData.setStudiesHighSchoolName(studiesHighSchoolName);
    }

    
    public final String getStudiesHighSchoolName() {
        return handicapCompensationChildRequestData.getStudiesHighSchoolName();
    }
  
    public final void setSubjectBirthCity(final String subjectBirthCity) {
        handicapCompensationChildRequestData.setSubjectBirthCity(subjectBirthCity);
    }

    
    public final String getSubjectBirthCity() {
        return handicapCompensationChildRequestData.getSubjectBirthCity();
    }
  
    public final void setSubjectBirthCountry(final String subjectBirthCountry) {
        handicapCompensationChildRequestData.setSubjectBirthCountry(subjectBirthCountry);
    }

    
    public final String getSubjectBirthCountry() {
        return handicapCompensationChildRequestData.getSubjectBirthCountry();
    }
  
    public final void setSubjectBirthDate(final java.util.Date subjectBirthDate) {
        handicapCompensationChildRequestData.setSubjectBirthDate(subjectBirthDate);
    }

    
    public final java.util.Date getSubjectBirthDate() {
        return handicapCompensationChildRequestData.getSubjectBirthDate();
    }
  
    public final void setSubjectParentalAuthorityHolder(final fr.cg95.cvq.business.request.social.HccrSubjectParentalAuthorityHolderType subjectParentalAuthorityHolder) {
        handicapCompensationChildRequestData.setSubjectParentalAuthorityHolder(subjectParentalAuthorityHolder);
    }

    
    public final fr.cg95.cvq.business.request.social.HccrSubjectParentalAuthorityHolderType getSubjectParentalAuthorityHolder() {
        return handicapCompensationChildRequestData.getSubjectParentalAuthorityHolder();
    }
  
}
