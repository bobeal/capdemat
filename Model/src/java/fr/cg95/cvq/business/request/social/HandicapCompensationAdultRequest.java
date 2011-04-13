
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
public class HandicapCompensationAdultRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = HandicapCompensationAdultRequestData.conditions;

    @AssertValid(message = "")
    private HandicapCompensationAdultRequestData handicapCompensationAdultRequestData;

    public HandicapCompensationAdultRequest(RequestData requestData, HandicapCompensationAdultRequestData handicapCompensationAdultRequestData) {
        super(requestData);
        this.handicapCompensationAdultRequestData = handicapCompensationAdultRequestData;
    }

    public HandicapCompensationAdultRequest() {
        super();
        this.handicapCompensationAdultRequestData = new HandicapCompensationAdultRequestData();
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
    public HandicapCompensationAdultRequestData getSpecificData() {
        return handicapCompensationAdultRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(HandicapCompensationAdultRequestData handicapCompensationAdultRequestData) {
        this.handicapCompensationAdultRequestData = handicapCompensationAdultRequestData;
    }

    @Override
    public final String modelToXmlString() {
        HandicapCompensationAdultRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final HandicapCompensationAdultRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        HandicapCompensationAdultRequestDocument handicapCompensationAdultRequestDoc = HandicapCompensationAdultRequestDocument.Factory.newInstance();
        HandicapCompensationAdultRequestDocument.HandicapCompensationAdultRequest handicapCompensationAdultRequest = handicapCompensationAdultRequestDoc.addNewHandicapCompensationAdultRequest();
        super.fillCommonXmlInfo(handicapCompensationAdultRequest);
        int i = 0;
        
        i = 0;
        if (getAdditionalFee() != null) {
            fr.cg95.cvq.xml.request.social.HcarAdditionalFeeType[] additionalFeeTypeTab = new fr.cg95.cvq.xml.request.social.HcarAdditionalFeeType[getAdditionalFee().size()];
            for (HcarAdditionalFee object : getAdditionalFee()) {
              additionalFeeTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationAdultRequest.setAdditionalFeeArray(additionalFeeTypeTab);
        }
        HcarBenefitsType hcarBenefitsTypeBenefits = handicapCompensationAdultRequest.addNewBenefits();
        if (getBenefitsCompensatoryAllowanceForExpenses() != null)
            hcarBenefitsTypeBenefits.setBenefitsCompensatoryAllowanceForExpenses(getBenefitsCompensatoryAllowanceForExpenses().booleanValue());
      
        if (getBenefitsDailyAllowances() != null)
            hcarBenefitsTypeBenefits.setBenefitsDailyAllowances(getBenefitsDailyAllowances().booleanValue());
      
        if (getBenefitsDisabilityCard() != null)
            hcarBenefitsTypeBenefits.setBenefitsDisabilityCard(getBenefitsDisabilityCard().booleanValue());
      
        if (getBenefitsDisabilityCompensation() != null)
            hcarBenefitsTypeBenefits.setBenefitsDisabilityCompensation(getBenefitsDisabilityCompensation().booleanValue());
      
        if (getBenefitsDisabilityPension() != null)
            hcarBenefitsTypeBenefits.setBenefitsDisabilityPension(getBenefitsDisabilityPension().booleanValue());
      
        hcarBenefitsTypeBenefits.setBenefitsDisabilityPensionCategory(getBenefitsDisabilityPensionCategory());
      
        hcarBenefitsTypeBenefits.setBenefitsDisabilityRatio(getBenefitsDisabilityRatio());
      
        if (getBenefitsDisabilityRecognition() != null)
            hcarBenefitsTypeBenefits.setBenefitsDisabilityRecognition(getBenefitsDisabilityRecognition().booleanValue());
      
        if (getBenefitsDisabledAdultAllocation() != null)
            hcarBenefitsTypeBenefits.setBenefitsDisabledAdultAllocation(getBenefitsDisabledAdultAllocation().booleanValue());
      
        if (getBenefitsDisabledWorkerRecognition() != null)
            hcarBenefitsTypeBenefits.setBenefitsDisabledWorkerRecognition(getBenefitsDisabledWorkerRecognition().booleanValue());
      
        if (getBenefitsEducationAllocationOfDisabledChildren() != null)
            hcarBenefitsTypeBenefits.setBenefitsEducationAllocationOfDisabledChildren(getBenefitsEducationAllocationOfDisabledChildren().booleanValue());
      
        if (getBenefitsEducationOfDisabledChildren() != null)
            hcarBenefitsTypeBenefits.setBenefitsEducationOfDisabledChildren(getBenefitsEducationOfDisabledChildren().booleanValue());
      
        hcarBenefitsTypeBenefits.setBenefitsEducationOfDisabledChildrenDetails(getBenefitsEducationOfDisabledChildrenDetails());
      
        if (getBenefitsIncreaseForIndependentLiving() != null)
            hcarBenefitsTypeBenefits.setBenefitsIncreaseForIndependentLiving(getBenefitsIncreaseForIndependentLiving().booleanValue());
      
        if (getBenefitsOtherBenefits() != null)
            hcarBenefitsTypeBenefits.setBenefitsOtherBenefits(getBenefitsOtherBenefits().booleanValue());
      
        if (getBenefitsPainfulStandingCard() != null)
            hcarBenefitsTypeBenefits.setBenefitsPainfulStandingCard(getBenefitsPainfulStandingCard().booleanValue());
      
        if (getBenefitsParkingCard() != null)
            hcarBenefitsTypeBenefits.setBenefitsParkingCard(getBenefitsParkingCard().booleanValue());
      
        if (getBenefitsProfessionalOrientation() != null)
            hcarBenefitsTypeBenefits.setBenefitsProfessionalOrientation(getBenefitsProfessionalOrientation().booleanValue());
      
        hcarBenefitsTypeBenefits.setBenefitsProfessionalOrientationDetails(getBenefitsProfessionalOrientationDetails());
      
        if (getBenefitsSocialWelfare() != null)
            hcarBenefitsTypeBenefits.setBenefitsSocialWelfare(getBenefitsSocialWelfare().booleanValue());
      
        if (getBenefitsSupplementForSingleParents() != null)
            hcarBenefitsTypeBenefits.setBenefitsSupplementForSingleParents(getBenefitsSupplementForSingleParents().booleanValue());
      
        if (getBenefitsSupportedByAnInstitution() != null)
            hcarBenefitsTypeBenefits.setBenefitsSupportedByAnInstitution(getBenefitsSupportedByAnInstitution().booleanValue());
      
        hcarBenefitsTypeBenefits.setBenefitsSupportedByAnInstitutionDetails(getBenefitsSupportedByAnInstitutionDetails());
      
        if (getBenefitsThirdPartyCompensatoryAllowance() != null)
            hcarBenefitsTypeBenefits.setBenefitsThirdPartyCompensatoryAllowance(getBenefitsThirdPartyCompensatoryAllowance().booleanValue());
      
        if (getBenefitsThirdPartySupplement() != null)
            hcarBenefitsTypeBenefits.setBenefitsThirdPartySupplement(getBenefitsThirdPartySupplement().booleanValue());
      
        if (getBenefitsThirdPersonCompensatoryAllowance() != null)
            hcarBenefitsTypeBenefits.setBenefitsThirdPersonCompensatoryAllowance(getBenefitsThirdPersonCompensatoryAllowance().booleanValue());
      
        if (getBenefitsUnemploymentBenefits() != null)
            hcarBenefitsTypeBenefits.setBenefitsUnemploymentBenefits(getBenefitsUnemploymentBenefits().booleanValue());
      
        if (getBenefitsWorkAccidentAnnuity() != null)
            hcarBenefitsTypeBenefits.setBenefitsWorkAccidentAnnuity(getBenefitsWorkAccidentAnnuity().booleanValue());
      
        hcarBenefitsTypeBenefits.setBenefitsWorkAccidentAnnuityRatio(getBenefitsWorkAccidentAnnuityRatio());
        HcarCareType hcarCareTypeCare = handicapCompensationAdultRequest.addNewCare();
        if (getCareCareServices() != null)
            hcarCareTypeCare.setCareCareServices(getCareCareServices().booleanValue());
      
        i = 0;
        if (getCareServices() != null) {
            fr.cg95.cvq.xml.request.social.HcarCareServiceType[] careServicesTypeTab = new fr.cg95.cvq.xml.request.social.HcarCareServiceType[getCareServices().size()];
            for (HcarCareService object : getCareServices()) {
              careServicesTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationAdultRequest.setCareServicesArray(careServicesTypeTab);
        }
        HcarDwellingType hcarDwellingTypeDwelling = handicapCompensationAdultRequest.addNewDwelling();
        if (getDwellingEstablishmentReception() != null)
            hcarDwellingTypeDwelling.setDwellingEstablishmentReception(getDwellingEstablishmentReception().booleanValue());
      
        if (getDwellingKind() != null)
            hcarDwellingTypeDwelling.setDwellingKind(fr.cg95.cvq.xml.request.social.HcarDwellingKindType.Enum.forString(getDwellingKind().getLegacyLabel()));
      
        hcarDwellingTypeDwelling.setDwellingPrecision(getDwellingPrecision());
      
        if (getDwellingReceptionAddress() != null)
            hcarDwellingTypeDwelling.setDwellingReceptionAddress(Address.modelToXml(getDwellingReceptionAddress()));
      
        hcarDwellingTypeDwelling.setDwellingReceptionNaming(getDwellingReceptionNaming());
      
        if (getDwellingReceptionType() != null)
            hcarDwellingTypeDwelling.setDwellingReceptionType(fr.cg95.cvq.xml.request.social.HcarDwellingReceptionKindType.Enum.forString(getDwellingReceptionType().getLegacyLabel()));
      
        if (getDwellingSocialReception() != null)
            hcarDwellingTypeDwelling.setDwellingSocialReception(getDwellingSocialReception().booleanValue());
      
        if (getDwellingSocialReceptionAddress() != null)
            hcarDwellingTypeDwelling.setDwellingSocialReceptionAddress(Address.modelToXml(getDwellingSocialReceptionAddress()));
      
        hcarDwellingTypeDwelling.setDwellingSocialReceptionNaming(getDwellingSocialReceptionNaming());
        HcarFacilitiesType hcarFacilitiesTypeFacilities = handicapCompensationAdultRequest.addNewFacilities();
        if (getFacilitiesAnimalAid() != null)
            hcarFacilitiesTypeFacilities.setFacilitiesAnimalAid(getFacilitiesAnimalAid().booleanValue());
      
        hcarFacilitiesTypeFacilities.setFacilitiesAnimalAidDetails(getFacilitiesAnimalAidDetails());
      
        if (getFacilitiesCustomCar() != null)
            hcarFacilitiesTypeFacilities.setFacilitiesCustomCar(getFacilitiesCustomCar().booleanValue());
      
        hcarFacilitiesTypeFacilities.setFacilitiesCustomCarDetails(getFacilitiesCustomCarDetails());
      
        if (getFacilitiesHousing() != null)
            hcarFacilitiesTypeFacilities.setFacilitiesHousing(getFacilitiesHousing().booleanValue());
      
        hcarFacilitiesTypeFacilities.setFacilitiesHousingDetails(getFacilitiesHousingDetails());
      
        if (getFacilitiesSpecializedTransport() != null)
            hcarFacilitiesTypeFacilities.setFacilitiesSpecializedTransport(getFacilitiesSpecializedTransport().booleanValue());
      
        hcarFacilitiesTypeFacilities.setFacilitiesSpecializedTransportDetails(getFacilitiesSpecializedTransportDetails());
      
        if (getFacilitiesTechnicalAssistance() != null)
            hcarFacilitiesTypeFacilities.setFacilitiesTechnicalAssistance(getFacilitiesTechnicalAssistance().booleanValue());
      
        hcarFacilitiesTypeFacilities.setFacilitiesTechnicalAssistanceDetails(getFacilitiesTechnicalAssistanceDetails());
      
        i = 0;
        if (getFamilyAssistanceMembers() != null) {
            fr.cg95.cvq.xml.request.social.HcarFamilyAssistanceMemberType[] familyAssistanceMembersTypeTab = new fr.cg95.cvq.xml.request.social.HcarFamilyAssistanceMemberType[getFamilyAssistanceMembers().size()];
            for (HcarFamilyAssistanceMember object : getFamilyAssistanceMembers()) {
              familyAssistanceMembersTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationAdultRequest.setFamilyAssistanceMembersArray(familyAssistanceMembersTypeTab);
        }
      
        i = 0;
        if (getFamilyDependents() != null) {
            fr.cg95.cvq.xml.request.social.HcarFamilyDependentType[] familyDependentsTypeTab = new fr.cg95.cvq.xml.request.social.HcarFamilyDependentType[getFamilyDependents().size()];
            for (HcarFamilyDependent object : getFamilyDependents()) {
              familyDependentsTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationAdultRequest.setFamilyDependentsArray(familyDependentsTypeTab);
        }
        HcarFamilyType hcarFamilyTypeFamily = handicapCompensationAdultRequest.addNewFamily();
        if (getFamilyFamilyDependents() != null)
            hcarFamilyTypeFamily.setFamilyFamilyDependents(getFamilyFamilyDependents().booleanValue());
      
        if (getFamilyStatus() != null)
            hcarFamilyTypeFamily.setFamilyStatus(fr.cg95.cvq.xml.common.FamilyStatusType.Enum.forString(getFamilyStatus().getLegacyLabel()));
        HcarFoldersType hcarFoldersTypeFolders = handicapCompensationAdultRequest.addNewFolders();
        if (getFoldersCdes() != null)
            hcarFoldersTypeFolders.setFoldersCdes(getFoldersCdes().booleanValue());
      
        hcarFoldersTypeFolders.setFoldersCdesDepartment(getFoldersCdesDepartment());
      
        hcarFoldersTypeFolders.setFoldersCdesNumber(getFoldersCdesNumber());
      
        if (getFoldersCotorep() != null)
            hcarFoldersTypeFolders.setFoldersCotorep(getFoldersCotorep().booleanValue());
      
        hcarFoldersTypeFolders.setFoldersCotorepDepartment(getFoldersCotorepDepartment());
      
        hcarFoldersTypeFolders.setFoldersCotorepNumber(getFoldersCotorepNumber());
      
        if (getFoldersMdph() != null)
            hcarFoldersTypeFolders.setFoldersMdph(getFoldersMdph().booleanValue());
      
        hcarFoldersTypeFolders.setFoldersMdphDepartment(getFoldersMdphDepartment());
      
        hcarFoldersTypeFolders.setFoldersMdphNumber(getFoldersMdphNumber());
      
        if (getFoldersOtherFolders() != null)
            hcarFoldersTypeFolders.setFoldersOtherFolders(getFoldersOtherFolders().booleanValue());
        HcarFormationType hcarFormationTypeFormation = handicapCompensationAdultRequest.addNewFormation();
        hcarFormationTypeFormation.setFormationCurrentFormation(getFormationCurrentFormation());
      
        hcarFormationTypeFormation.setFormationDiploma(getFormationDiploma());
      
        hcarFormationTypeFormation.setFormationPreviousFormation(getFormationPreviousFormation());
      
        hcarFormationTypeFormation.setFormationStudiesLevel(getFormationStudiesLevel());
        HcarHealthType hcarHealthTypeHealth = handicapCompensationAdultRequest.addNewHealth();
        hcarHealthTypeHealth.setHealthDoctorFirstName(getHealthDoctorFirstName());
      
        hcarHealthTypeHealth.setHealthDoctorLastName(getHealthDoctorLastName());
      
        if (getHealthFollowedByDoctor() != null)
            hcarHealthTypeHealth.setHealthFollowedByDoctor(getHealthFollowedByDoctor().booleanValue());
      
        if (getHealthFollowedByHospital() != null)
            hcarHealthTypeHealth.setHealthFollowedByHospital(getHealthFollowedByHospital().booleanValue());
      
        if (getHealthFollowedByProfessional() != null)
            hcarHealthTypeHealth.setHealthFollowedByProfessional(getHealthFollowedByProfessional().booleanValue());
      
        hcarHealthTypeHealth.setHealthHospitalName(getHealthHospitalName());
      
        hcarHealthTypeHealth.setHealthProfessionalFirstName(getHealthProfessionalFirstName());
      
        hcarHealthTypeHealth.setHealthProfessionalLastName(getHealthProfessionalLastName());
      
        i = 0;
        if (getHomeIntervenants() != null) {
            fr.cg95.cvq.xml.request.social.HcarHomeIntervenantType[] homeIntervenantsTypeTab = new fr.cg95.cvq.xml.request.social.HcarHomeIntervenantType[getHomeIntervenants().size()];
            for (HcarHomeIntervenant object : getHomeIntervenants()) {
              homeIntervenantsTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationAdultRequest.setHomeIntervenantsArray(homeIntervenantsTypeTab);
        }
        HcarHomeInterventionType hcarHomeInterventionTypeHomeIntervention = handicapCompensationAdultRequest.addNewHomeIntervention();
        if (getHomeInterventionHomeIntervenant() != null)
            hcarHomeInterventionTypeHomeIntervention.setHomeInterventionHomeIntervenant(getHomeInterventionHomeIntervenant().booleanValue());
        HcarFamilyAssistanceType hcarFamilyAssistanceTypeFamilyAssistance = handicapCompensationAdultRequest.addNewFamilyAssistance();
        if (getIsFamilyAssistance() != null)
            hcarFamilyAssistanceTypeFamilyAssistance.setIsFamilyAssistance(getIsFamilyAssistance().booleanValue());
        HcarLegalAccessType hcarLegalAccessTypeLegalAccess = handicapCompensationAdultRequest.addNewLegalAccess();
        if (getLegalAccessKind() != null)
            hcarLegalAccessTypeLegalAccess.setLegalAccessKind(fr.cg95.cvq.xml.request.social.HcarLegalAccessKindType.Enum.forString(getLegalAccessKind().getLegacyLabel()));
      
        if (getLegalAccessPresence() != null)
            hcarLegalAccessTypeLegalAccess.setLegalAccessPresence(getLegalAccessPresence().booleanValue());
      
        hcarLegalAccessTypeLegalAccess.setLegalAccessRepresentativeFirstName(getLegalAccessRepresentativeFirstName());
      
        if (getLegalAccessRepresentativeKind() != null)
            hcarLegalAccessTypeLegalAccess.setLegalAccessRepresentativeKind(fr.cg95.cvq.xml.request.social.HcarLegalAccessRepresentativeKindType.Enum.forString(getLegalAccessRepresentativeKind().getLegacyLabel()));
      
        hcarLegalAccessTypeLegalAccess.setLegalAccessRepresentativeKindDetail(getLegalAccessRepresentativeKindDetail());
      
        hcarLegalAccessTypeLegalAccess.setLegalAccessRepresentativeName(getLegalAccessRepresentativeName());
      
        i = 0;
        if (getOtherBenefits() != null) {
            fr.cg95.cvq.xml.request.social.HcarOtherBenefitType[] otherBenefitsTypeTab = new fr.cg95.cvq.xml.request.social.HcarOtherBenefitType[getOtherBenefits().size()];
            for (HcarOtherBenefit object : getOtherBenefits()) {
              otherBenefitsTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationAdultRequest.setOtherBenefitsArray(otherBenefitsTypeTab);
        }
      
        i = 0;
        if (getOtherFolders() != null) {
            fr.cg95.cvq.xml.request.social.HcarOtherFolderType[] otherFoldersTypeTab = new fr.cg95.cvq.xml.request.social.HcarOtherFolderType[getOtherFolders().size()];
            for (HcarOtherFolder object : getOtherFolders()) {
              otherFoldersTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationAdultRequest.setOtherFoldersArray(otherFoldersTypeTab);
        }
        HcarPaymentAgencyType hcarPaymentAgencyTypePaymentAgency = handicapCompensationAdultRequest.addNewPaymentAgency();
        if (getPaymentAgencyAddress() != null)
            hcarPaymentAgencyTypePaymentAgency.setPaymentAgencyAddress(Address.modelToXml(getPaymentAgencyAddress()));
      
        if (getPaymentAgencyBeneficiary() != null)
            hcarPaymentAgencyTypePaymentAgency.setPaymentAgencyBeneficiary(fr.cg95.cvq.xml.request.social.HcarPaymentAgencyBeneficiaryType.Enum.forString(getPaymentAgencyBeneficiary().getLegacyLabel()));
      
        hcarPaymentAgencyTypePaymentAgency.setPaymentAgencyBeneficiaryNumber(getPaymentAgencyBeneficiaryNumber());
      
        hcarPaymentAgencyTypePaymentAgency.setPaymentAgencyName(getPaymentAgencyName());
        HcarProfessionalStatusType hcarProfessionalStatusTypeProfessionalStatus = handicapCompensationAdultRequest.addNewProfessionalStatus();
        if (getProfessionalStatusAddress() != null)
            hcarProfessionalStatusTypeProfessionalStatus.setProfessionalStatusAddress(Address.modelToXml(getProfessionalStatusAddress()));
      
        date = getProfessionalStatusDate();
        if (date != null) {
            calendar.setTime(date);
            hcarProfessionalStatusTypeProfessionalStatus.setProfessionalStatusDate(calendar);
        }
      
        if (getProfessionalStatusElectiveFunction() != null)
            hcarProfessionalStatusTypeProfessionalStatus.setProfessionalStatusElectiveFunction(getProfessionalStatusElectiveFunction().booleanValue());
      
        hcarProfessionalStatusTypeProfessionalStatus.setProfessionalStatusElectiveFunctionDetails(getProfessionalStatusElectiveFunctionDetails());
      
        hcarProfessionalStatusTypeProfessionalStatus.setProfessionalStatusEmployerName(getProfessionalStatusEmployerName());
      
        if (getProfessionalStatusEnvironment() != null)
            hcarProfessionalStatusTypeProfessionalStatus.setProfessionalStatusEnvironment(fr.cg95.cvq.xml.request.social.HcarProfessionalStatusEnvironmentType.Enum.forString(getProfessionalStatusEnvironment().getLegacyLabel()));
      
        if (getProfessionalStatusIndemnified() != null)
            hcarProfessionalStatusTypeProfessionalStatus.setProfessionalStatusIndemnified(getProfessionalStatusIndemnified().booleanValue());
      
        date = getProfessionalStatusIndemnifiedDate();
        if (date != null) {
            calendar.setTime(date);
            hcarProfessionalStatusTypeProfessionalStatus.setProfessionalStatusIndemnifiedDate(calendar);
        }
      
        if (getProfessionalStatusKind() != null)
            hcarProfessionalStatusTypeProfessionalStatus.setProfessionalStatusKind(fr.cg95.cvq.xml.request.social.HcarProfessionalStatusKindType.Enum.forString(getProfessionalStatusKind().getLegacyLabel()));
      
        hcarProfessionalStatusTypeProfessionalStatus.setProfessionalStatusProfession(getProfessionalStatusProfession());
      
        if (getProfessionalStatusRegisterAsUnemployed() != null)
            hcarProfessionalStatusTypeProfessionalStatus.setProfessionalStatusRegisterAsUnemployed(getProfessionalStatusRegisterAsUnemployed().booleanValue());
      
        date = getProfessionalStatusRegisterAsUnemployedDate();
        if (date != null) {
            calendar.setTime(date);
            hcarProfessionalStatusTypeProfessionalStatus.setProfessionalStatusRegisterAsUnemployedDate(calendar);
        }
        HcarProfessionalSupportType hcarProfessionalSupportTypeProfessionalSupport = handicapCompensationAdultRequest.addNewProfessionalSupport();
        if (getProfessionalSupportDealsWithSameProfessional() != null)
            hcarProfessionalSupportTypeProfessionalSupport.setProfessionalSupportDealsWithSameProfessional(getProfessionalSupportDealsWithSameProfessional().booleanValue());
      
        if (getProfessionalSupportProfessionals() != null)
            hcarProfessionalSupportTypeProfessionalSupport.setProfessionalSupportProfessionals(getProfessionalSupportProfessionals().booleanValue());
        HcarSocialServiceType hcarSocialServiceTypeSocialService = handicapCompensationAdultRequest.addNewSocialService();
        if (getProfessionalSupportSocialServiceAddress() != null)
            hcarSocialServiceTypeSocialService.setProfessionalSupportSocialServiceAddress(Address.modelToXml(getProfessionalSupportSocialServiceAddress()));
      
        hcarSocialServiceTypeSocialService.setProfessionalSupportSocialServiceName(getProfessionalSupportSocialServiceName());
      
        if (getProfessionalSupportSocialServiceSupport() != null)
            hcarSocialServiceTypeSocialService.setProfessionalSupportSocialServiceSupport(getProfessionalSupportSocialServiceSupport().booleanValue());
      
        i = 0;
        if (getProfessionals() != null) {
            fr.cg95.cvq.xml.request.social.HcarProfessionalType[] professionalsTypeTab = new fr.cg95.cvq.xml.request.social.HcarProfessionalType[getProfessionals().size()];
            for (HcarProfessional object : getProfessionals()) {
              professionalsTypeTab[i++] = object.modelToXml();
            }
            handicapCompensationAdultRequest.setProfessionalsArray(professionalsTypeTab);
        }
      
        handicapCompensationAdultRequest.setProjectComments(getProjectComments());
      
        handicapCompensationAdultRequest.setProjectNeeds(getProjectNeeds());
        HcarProjectRequestsType hcarProjectRequestsTypeProjectRequests = handicapCompensationAdultRequest.addNewProjectRequests();
        if (getProjectRequestsACTPRenewal() != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsACTPRenewal(getProjectRequestsACTPRenewal().booleanValue());
      
        if (getProjectRequestsAssistance() != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsAssistance(getProjectRequestsAssistance().booleanValue());
      
        if (getProjectRequestsCustomCar() != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsCustomCar(getProjectRequestsCustomCar().booleanValue());
      
        if (getProjectRequestsDisabilityCard() != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsDisabilityCard(getProjectRequestsDisabilityCard().booleanValue());
      
        if (getProjectRequestsDisabilityCostAllocation() != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsDisabilityCostAllocation(getProjectRequestsDisabilityCostAllocation().booleanValue());
      
        if (getProjectRequestsDisabledAdultAllowance() != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsDisabledAdultAllowance(getProjectRequestsDisabledAdultAllowance().booleanValue());
      
        if (getProjectRequestsDisabledPriorityCard() != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsDisabledPriorityCard(getProjectRequestsDisabledPriorityCard().booleanValue());
      
        if (getProjectRequestsDisabledWorkerRecognition() != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsDisabledWorkerRecognition(getProjectRequestsDisabledWorkerRecognition().booleanValue());
      
        if (getProjectRequestsEducationAllocationOfDisabledChildren() != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsEducationAllocationOfDisabledChildren(getProjectRequestsEducationAllocationOfDisabledChildren().booleanValue());
      
        if (getProjectRequestsEuropeanParkingCard() != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsEuropeanParkingCard(getProjectRequestsEuropeanParkingCard().booleanValue());
      
        if (getProjectRequestsFreePensionMembership() != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsFreePensionMembership(getProjectRequestsFreePensionMembership().booleanValue());
      
        if (getProjectRequestsHandicapRecognition() != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsHandicapRecognition(getProjectRequestsHandicapRecognition().booleanValue());
      
        if (getProjectRequestsHousingFacilities() != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsHousingFacilities(getProjectRequestsHousingFacilities().booleanValue());
      
        if (getProjectRequestsIncreaseForIndependentLiving() != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsIncreaseForIndependentLiving(getProjectRequestsIncreaseForIndependentLiving().booleanValue());
      
        if (getProjectRequestsInstitutionSupport() != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsInstitutionSupport(getProjectRequestsInstitutionSupport().booleanValue());
      
        if (getProjectRequestsOrdinaryWorking() != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsOrdinaryWorking(getProjectRequestsOrdinaryWorking().booleanValue());
      
        if (getProjectRequestsOther() != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsOther(getProjectRequestsOther().booleanValue());
      
        hcarProjectRequestsTypeProjectRequests.setProjectRequestsOtherDetails(getProjectRequestsOtherDetails());
      
        if (getProjectRequestsProfessionalOrientation() != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsProfessionalOrientation(getProjectRequestsProfessionalOrientation().booleanValue());
      
        if (getProjectRequestsShelteredWork() != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsShelteredWork(getProjectRequestsShelteredWork().booleanValue());
      
        if (getProjectRequestsTechnicalHelp() != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsTechnicalHelp(getProjectRequestsTechnicalHelp().booleanValue());
      
        if (getProjectRequestsThirdPartyHelp() != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsThirdPartyHelp(getProjectRequestsThirdPartyHelp().booleanValue());
      
        if (getProjectRequestsTransportCostAllocation() != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsTransportCostAllocation(getProjectRequestsTransportCostAllocation().booleanValue());
      
        if (getProjectRequestsVocationalTraining() != null)
            hcarProjectRequestsTypeProjectRequests.setProjectRequestsVocationalTraining(getProjectRequestsVocationalTraining().booleanValue());
      
        handicapCompensationAdultRequest.setProjectWish(getProjectWish());
        HcarSocialSecurityType hcarSocialSecurityTypeSocialSecurity = handicapCompensationAdultRequest.addNewSocialSecurity();
        if (getSocialSecurityAgencyAddress() != null)
            hcarSocialSecurityTypeSocialSecurity.setSocialSecurityAgencyAddress(Address.modelToXml(getSocialSecurityAgencyAddress()));
      
        hcarSocialSecurityTypeSocialSecurity.setSocialSecurityAgencyName(getSocialSecurityAgencyName());
      
        if (getSocialSecurityMemberShipKind() != null)
            hcarSocialSecurityTypeSocialSecurity.setSocialSecurityMemberShipKind(fr.cg95.cvq.xml.request.social.HcarSocialSecurityMemberShipKindType.Enum.forString(getSocialSecurityMemberShipKind().getLegacyLabel()));
      
        hcarSocialSecurityTypeSocialSecurity.setSocialSecurityNumber(getSocialSecurityNumber());
        HcarStudiesType hcarStudiesTypeStudies = handicapCompensationAdultRequest.addNewStudies();
        if (getStudiesAssistanceUnderDisability() != null)
            hcarStudiesTypeStudies.setStudiesAssistanceUnderDisability(getStudiesAssistanceUnderDisability().booleanValue());
      
        hcarStudiesTypeStudies.setStudiesAssistanceUnderDisabilityDetails(getStudiesAssistanceUnderDisabilityDetails());
      
        if (getStudiesHighSchool() != null)
            hcarStudiesTypeStudies.setStudiesHighSchool(getStudiesHighSchool().booleanValue());
      
        if (getStudiesHighSchoolAddress() != null)
            hcarStudiesTypeStudies.setStudiesHighSchoolAddress(Address.modelToXml(getStudiesHighSchoolAddress()));
      
        hcarStudiesTypeStudies.setStudiesHighSchoolGrade(getStudiesHighSchoolGrade());
      
        hcarStudiesTypeStudies.setStudiesHighSchoolName(getStudiesHighSchoolName());
        HcarSubjectType hcarSubjectTypeHcarSubject = handicapCompensationAdultRequest.addNewHcarSubject();
        hcarSubjectTypeHcarSubject.setSubjectBirthCity(getSubjectBirthCity());
      
        hcarSubjectTypeHcarSubject.setSubjectBirthCountry(getSubjectBirthCountry());
      
        date = getSubjectBirthDate();
        if (date != null) {
            calendar.setTime(date);
            hcarSubjectTypeHcarSubject.setSubjectBirthDate(calendar);
        }
      
        hcarSubjectTypeHcarSubject.setSubjectMaidenName(getSubjectMaidenName());
      
        if (getSubjectTitle() != null)
            hcarSubjectTypeHcarSubject.setSubjectTitle(fr.cg95.cvq.xml.common.TitleType.Enum.forString(getSubjectTitle().getLegacyLabel()));
      
        return handicapCompensationAdultRequestDoc;
    }

    @Override
    public final HandicapCompensationAdultRequestDocument.HandicapCompensationAdultRequest modelToXmlRequest() {
        return modelToXml().getHandicapCompensationAdultRequest();
    }

    public static HandicapCompensationAdultRequest xmlToModel(HandicapCompensationAdultRequestDocument handicapCompensationAdultRequestDoc) {
        HandicapCompensationAdultRequestDocument.HandicapCompensationAdultRequest handicapCompensationAdultRequestXml = handicapCompensationAdultRequestDoc.getHandicapCompensationAdultRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        HandicapCompensationAdultRequest handicapCompensationAdultRequest = new HandicapCompensationAdultRequest();
        handicapCompensationAdultRequest.fillCommonModelInfo(handicapCompensationAdultRequest, handicapCompensationAdultRequestXml);
        
        List<fr.cg95.cvq.business.request.social.HcarAdditionalFee> additionalFeeList = new ArrayList<fr.cg95.cvq.business.request.social.HcarAdditionalFee>(handicapCompensationAdultRequestXml.sizeOfAdditionalFeeArray());
        for (HcarAdditionalFeeType object : handicapCompensationAdultRequestXml.getAdditionalFeeArray()) {
            additionalFeeList.add(fr.cg95.cvq.business.request.social.HcarAdditionalFee.xmlToModel(object));
        }
        handicapCompensationAdultRequest.setAdditionalFee(additionalFeeList);
      
        handicapCompensationAdultRequest.setBenefitsCompensatoryAllowanceForExpenses(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsCompensatoryAllowanceForExpenses()));
      
        handicapCompensationAdultRequest.setBenefitsDailyAllowances(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsDailyAllowances()));
      
        handicapCompensationAdultRequest.setBenefitsDisabilityCard(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsDisabilityCard()));
      
        handicapCompensationAdultRequest.setBenefitsDisabilityCompensation(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsDisabilityCompensation()));
      
        handicapCompensationAdultRequest.setBenefitsDisabilityPension(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsDisabilityPension()));
      
        handicapCompensationAdultRequest.setBenefitsDisabilityPensionCategory(handicapCompensationAdultRequestXml.getBenefits().getBenefitsDisabilityPensionCategory());
      
        handicapCompensationAdultRequest.setBenefitsDisabilityRatio(handicapCompensationAdultRequestXml.getBenefits().getBenefitsDisabilityRatio());
      
        handicapCompensationAdultRequest.setBenefitsDisabilityRecognition(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsDisabilityRecognition()));
      
        handicapCompensationAdultRequest.setBenefitsDisabledAdultAllocation(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsDisabledAdultAllocation()));
      
        handicapCompensationAdultRequest.setBenefitsDisabledWorkerRecognition(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsDisabledWorkerRecognition()));
      
        handicapCompensationAdultRequest.setBenefitsEducationAllocationOfDisabledChildren(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsEducationAllocationOfDisabledChildren()));
      
        handicapCompensationAdultRequest.setBenefitsEducationOfDisabledChildren(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsEducationOfDisabledChildren()));
      
        handicapCompensationAdultRequest.setBenefitsEducationOfDisabledChildrenDetails(handicapCompensationAdultRequestXml.getBenefits().getBenefitsEducationOfDisabledChildrenDetails());
      
        handicapCompensationAdultRequest.setBenefitsIncreaseForIndependentLiving(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsIncreaseForIndependentLiving()));
      
        handicapCompensationAdultRequest.setBenefitsOtherBenefits(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsOtherBenefits()));
      
        handicapCompensationAdultRequest.setBenefitsPainfulStandingCard(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsPainfulStandingCard()));
      
        handicapCompensationAdultRequest.setBenefitsParkingCard(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsParkingCard()));
      
        handicapCompensationAdultRequest.setBenefitsProfessionalOrientation(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsProfessionalOrientation()));
      
        handicapCompensationAdultRequest.setBenefitsProfessionalOrientationDetails(handicapCompensationAdultRequestXml.getBenefits().getBenefitsProfessionalOrientationDetails());
      
        handicapCompensationAdultRequest.setBenefitsSocialWelfare(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsSocialWelfare()));
      
        handicapCompensationAdultRequest.setBenefitsSupplementForSingleParents(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsSupplementForSingleParents()));
      
        handicapCompensationAdultRequest.setBenefitsSupportedByAnInstitution(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsSupportedByAnInstitution()));
      
        handicapCompensationAdultRequest.setBenefitsSupportedByAnInstitutionDetails(handicapCompensationAdultRequestXml.getBenefits().getBenefitsSupportedByAnInstitutionDetails());
      
        handicapCompensationAdultRequest.setBenefitsThirdPartyCompensatoryAllowance(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsThirdPartyCompensatoryAllowance()));
      
        handicapCompensationAdultRequest.setBenefitsThirdPartySupplement(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsThirdPartySupplement()));
      
        handicapCompensationAdultRequest.setBenefitsThirdPersonCompensatoryAllowance(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsThirdPersonCompensatoryAllowance()));
      
        handicapCompensationAdultRequest.setBenefitsUnemploymentBenefits(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsUnemploymentBenefits()));
      
        handicapCompensationAdultRequest.setBenefitsWorkAccidentAnnuity(Boolean.valueOf(handicapCompensationAdultRequestXml.getBenefits().getBenefitsWorkAccidentAnnuity()));
      
        handicapCompensationAdultRequest.setBenefitsWorkAccidentAnnuityRatio(handicapCompensationAdultRequestXml.getBenefits().getBenefitsWorkAccidentAnnuityRatio());
      
        handicapCompensationAdultRequest.setCareCareServices(Boolean.valueOf(handicapCompensationAdultRequestXml.getCare().getCareCareServices()));
      
        List<fr.cg95.cvq.business.request.social.HcarCareService> careServicesList = new ArrayList<fr.cg95.cvq.business.request.social.HcarCareService>(handicapCompensationAdultRequestXml.sizeOfCareServicesArray());
        for (HcarCareServiceType object : handicapCompensationAdultRequestXml.getCareServicesArray()) {
            careServicesList.add(fr.cg95.cvq.business.request.social.HcarCareService.xmlToModel(object));
        }
        handicapCompensationAdultRequest.setCareServices(careServicesList);
      
        handicapCompensationAdultRequest.setDwellingEstablishmentReception(Boolean.valueOf(handicapCompensationAdultRequestXml.getDwelling().getDwellingEstablishmentReception()));
      
        if (handicapCompensationAdultRequestXml.getDwelling().getDwellingKind() != null)
            handicapCompensationAdultRequest.setDwellingKind(fr.cg95.cvq.business.request.social.HcarDwellingKindType.forString(handicapCompensationAdultRequestXml.getDwelling().getDwellingKind().toString()));
        else
            handicapCompensationAdultRequest.setDwellingKind(fr.cg95.cvq.business.request.social.HcarDwellingKindType.getDefaultHcarDwellingKindType());
      
        handicapCompensationAdultRequest.setDwellingPrecision(handicapCompensationAdultRequestXml.getDwelling().getDwellingPrecision());
      
        if (handicapCompensationAdultRequestXml.getDwelling().getDwellingReceptionAddress() != null)
            handicapCompensationAdultRequest.setDwellingReceptionAddress(Address.xmlToModel(handicapCompensationAdultRequestXml.getDwelling().getDwellingReceptionAddress()));
      
        handicapCompensationAdultRequest.setDwellingReceptionNaming(handicapCompensationAdultRequestXml.getDwelling().getDwellingReceptionNaming());
      
        if (handicapCompensationAdultRequestXml.getDwelling().getDwellingReceptionType() != null)
            handicapCompensationAdultRequest.setDwellingReceptionType(fr.cg95.cvq.business.request.social.HcarDwellingReceptionKindType.forString(handicapCompensationAdultRequestXml.getDwelling().getDwellingReceptionType().toString()));
        else
            handicapCompensationAdultRequest.setDwellingReceptionType(fr.cg95.cvq.business.request.social.HcarDwellingReceptionKindType.getDefaultHcarDwellingReceptionKindType());
      
        handicapCompensationAdultRequest.setDwellingSocialReception(Boolean.valueOf(handicapCompensationAdultRequestXml.getDwelling().getDwellingSocialReception()));
      
        if (handicapCompensationAdultRequestXml.getDwelling().getDwellingSocialReceptionAddress() != null)
            handicapCompensationAdultRequest.setDwellingSocialReceptionAddress(Address.xmlToModel(handicapCompensationAdultRequestXml.getDwelling().getDwellingSocialReceptionAddress()));
      
        handicapCompensationAdultRequest.setDwellingSocialReceptionNaming(handicapCompensationAdultRequestXml.getDwelling().getDwellingSocialReceptionNaming());
      
        handicapCompensationAdultRequest.setFacilitiesAnimalAid(Boolean.valueOf(handicapCompensationAdultRequestXml.getFacilities().getFacilitiesAnimalAid()));
      
        handicapCompensationAdultRequest.setFacilitiesAnimalAidDetails(handicapCompensationAdultRequestXml.getFacilities().getFacilitiesAnimalAidDetails());
      
        handicapCompensationAdultRequest.setFacilitiesCustomCar(Boolean.valueOf(handicapCompensationAdultRequestXml.getFacilities().getFacilitiesCustomCar()));
      
        handicapCompensationAdultRequest.setFacilitiesCustomCarDetails(handicapCompensationAdultRequestXml.getFacilities().getFacilitiesCustomCarDetails());
      
        handicapCompensationAdultRequest.setFacilitiesHousing(Boolean.valueOf(handicapCompensationAdultRequestXml.getFacilities().getFacilitiesHousing()));
      
        handicapCompensationAdultRequest.setFacilitiesHousingDetails(handicapCompensationAdultRequestXml.getFacilities().getFacilitiesHousingDetails());
      
        handicapCompensationAdultRequest.setFacilitiesSpecializedTransport(Boolean.valueOf(handicapCompensationAdultRequestXml.getFacilities().getFacilitiesSpecializedTransport()));
      
        handicapCompensationAdultRequest.setFacilitiesSpecializedTransportDetails(handicapCompensationAdultRequestXml.getFacilities().getFacilitiesSpecializedTransportDetails());
      
        handicapCompensationAdultRequest.setFacilitiesTechnicalAssistance(Boolean.valueOf(handicapCompensationAdultRequestXml.getFacilities().getFacilitiesTechnicalAssistance()));
      
        handicapCompensationAdultRequest.setFacilitiesTechnicalAssistanceDetails(handicapCompensationAdultRequestXml.getFacilities().getFacilitiesTechnicalAssistanceDetails());
      
        List<fr.cg95.cvq.business.request.social.HcarFamilyAssistanceMember> familyAssistanceMembersList = new ArrayList<fr.cg95.cvq.business.request.social.HcarFamilyAssistanceMember>(handicapCompensationAdultRequestXml.sizeOfFamilyAssistanceMembersArray());
        for (HcarFamilyAssistanceMemberType object : handicapCompensationAdultRequestXml.getFamilyAssistanceMembersArray()) {
            familyAssistanceMembersList.add(fr.cg95.cvq.business.request.social.HcarFamilyAssistanceMember.xmlToModel(object));
        }
        handicapCompensationAdultRequest.setFamilyAssistanceMembers(familyAssistanceMembersList);
      
        List<fr.cg95.cvq.business.request.social.HcarFamilyDependent> familyDependentsList = new ArrayList<fr.cg95.cvq.business.request.social.HcarFamilyDependent>(handicapCompensationAdultRequestXml.sizeOfFamilyDependentsArray());
        for (HcarFamilyDependentType object : handicapCompensationAdultRequestXml.getFamilyDependentsArray()) {
            familyDependentsList.add(fr.cg95.cvq.business.request.social.HcarFamilyDependent.xmlToModel(object));
        }
        handicapCompensationAdultRequest.setFamilyDependents(familyDependentsList);
      
        handicapCompensationAdultRequest.setFamilyFamilyDependents(Boolean.valueOf(handicapCompensationAdultRequestXml.getFamily().getFamilyFamilyDependents()));
      
        if (handicapCompensationAdultRequestXml.getFamily().getFamilyStatus() != null)
            handicapCompensationAdultRequest.setFamilyStatus(fr.cg95.cvq.business.users.FamilyStatusType.forString(handicapCompensationAdultRequestXml.getFamily().getFamilyStatus().toString()));
        else
            handicapCompensationAdultRequest.setFamilyStatus(fr.cg95.cvq.business.users.FamilyStatusType.getDefaultFamilyStatusType());
      
        handicapCompensationAdultRequest.setFoldersCdes(Boolean.valueOf(handicapCompensationAdultRequestXml.getFolders().getFoldersCdes()));
      
        handicapCompensationAdultRequest.setFoldersCdesDepartment(handicapCompensationAdultRequestXml.getFolders().getFoldersCdesDepartment());
      
        handicapCompensationAdultRequest.setFoldersCdesNumber(handicapCompensationAdultRequestXml.getFolders().getFoldersCdesNumber());
      
        handicapCompensationAdultRequest.setFoldersCotorep(Boolean.valueOf(handicapCompensationAdultRequestXml.getFolders().getFoldersCotorep()));
      
        handicapCompensationAdultRequest.setFoldersCotorepDepartment(handicapCompensationAdultRequestXml.getFolders().getFoldersCotorepDepartment());
      
        handicapCompensationAdultRequest.setFoldersCotorepNumber(handicapCompensationAdultRequestXml.getFolders().getFoldersCotorepNumber());
      
        handicapCompensationAdultRequest.setFoldersMdph(Boolean.valueOf(handicapCompensationAdultRequestXml.getFolders().getFoldersMdph()));
      
        handicapCompensationAdultRequest.setFoldersMdphDepartment(handicapCompensationAdultRequestXml.getFolders().getFoldersMdphDepartment());
      
        handicapCompensationAdultRequest.setFoldersMdphNumber(handicapCompensationAdultRequestXml.getFolders().getFoldersMdphNumber());
      
        handicapCompensationAdultRequest.setFoldersOtherFolders(Boolean.valueOf(handicapCompensationAdultRequestXml.getFolders().getFoldersOtherFolders()));
      
        handicapCompensationAdultRequest.setFormationCurrentFormation(handicapCompensationAdultRequestXml.getFormation().getFormationCurrentFormation());
      
        handicapCompensationAdultRequest.setFormationDiploma(handicapCompensationAdultRequestXml.getFormation().getFormationDiploma());
      
        handicapCompensationAdultRequest.setFormationPreviousFormation(handicapCompensationAdultRequestXml.getFormation().getFormationPreviousFormation());
      
        handicapCompensationAdultRequest.setFormationStudiesLevel(handicapCompensationAdultRequestXml.getFormation().getFormationStudiesLevel());
      
        handicapCompensationAdultRequest.setHealthDoctorFirstName(handicapCompensationAdultRequestXml.getHealth().getHealthDoctorFirstName());
      
        handicapCompensationAdultRequest.setHealthDoctorLastName(handicapCompensationAdultRequestXml.getHealth().getHealthDoctorLastName());
      
        handicapCompensationAdultRequest.setHealthFollowedByDoctor(Boolean.valueOf(handicapCompensationAdultRequestXml.getHealth().getHealthFollowedByDoctor()));
      
        handicapCompensationAdultRequest.setHealthFollowedByHospital(Boolean.valueOf(handicapCompensationAdultRequestXml.getHealth().getHealthFollowedByHospital()));
      
        handicapCompensationAdultRequest.setHealthFollowedByProfessional(Boolean.valueOf(handicapCompensationAdultRequestXml.getHealth().getHealthFollowedByProfessional()));
      
        handicapCompensationAdultRequest.setHealthHospitalName(handicapCompensationAdultRequestXml.getHealth().getHealthHospitalName());
      
        handicapCompensationAdultRequest.setHealthProfessionalFirstName(handicapCompensationAdultRequestXml.getHealth().getHealthProfessionalFirstName());
      
        handicapCompensationAdultRequest.setHealthProfessionalLastName(handicapCompensationAdultRequestXml.getHealth().getHealthProfessionalLastName());
      
        List<fr.cg95.cvq.business.request.social.HcarHomeIntervenant> homeIntervenantsList = new ArrayList<fr.cg95.cvq.business.request.social.HcarHomeIntervenant>(handicapCompensationAdultRequestXml.sizeOfHomeIntervenantsArray());
        for (HcarHomeIntervenantType object : handicapCompensationAdultRequestXml.getHomeIntervenantsArray()) {
            homeIntervenantsList.add(fr.cg95.cvq.business.request.social.HcarHomeIntervenant.xmlToModel(object));
        }
        handicapCompensationAdultRequest.setHomeIntervenants(homeIntervenantsList);
      
        handicapCompensationAdultRequest.setHomeInterventionHomeIntervenant(Boolean.valueOf(handicapCompensationAdultRequestXml.getHomeIntervention().getHomeInterventionHomeIntervenant()));
      
        handicapCompensationAdultRequest.setIsFamilyAssistance(Boolean.valueOf(handicapCompensationAdultRequestXml.getFamilyAssistance().getIsFamilyAssistance()));
      
        if (handicapCompensationAdultRequestXml.getLegalAccess().getLegalAccessKind() != null)
            handicapCompensationAdultRequest.setLegalAccessKind(fr.cg95.cvq.business.request.social.HcarLegalAccessKindType.forString(handicapCompensationAdultRequestXml.getLegalAccess().getLegalAccessKind().toString()));
        else
            handicapCompensationAdultRequest.setLegalAccessKind(fr.cg95.cvq.business.request.social.HcarLegalAccessKindType.getDefaultHcarLegalAccessKindType());
      
        handicapCompensationAdultRequest.setLegalAccessPresence(Boolean.valueOf(handicapCompensationAdultRequestXml.getLegalAccess().getLegalAccessPresence()));
      
        handicapCompensationAdultRequest.setLegalAccessRepresentativeFirstName(handicapCompensationAdultRequestXml.getLegalAccess().getLegalAccessRepresentativeFirstName());
      
        if (handicapCompensationAdultRequestXml.getLegalAccess().getLegalAccessRepresentativeKind() != null)
            handicapCompensationAdultRequest.setLegalAccessRepresentativeKind(fr.cg95.cvq.business.request.social.HcarLegalAccessRepresentativeKindType.forString(handicapCompensationAdultRequestXml.getLegalAccess().getLegalAccessRepresentativeKind().toString()));
        else
            handicapCompensationAdultRequest.setLegalAccessRepresentativeKind(fr.cg95.cvq.business.request.social.HcarLegalAccessRepresentativeKindType.getDefaultHcarLegalAccessRepresentativeKindType());
      
        handicapCompensationAdultRequest.setLegalAccessRepresentativeKindDetail(handicapCompensationAdultRequestXml.getLegalAccess().getLegalAccessRepresentativeKindDetail());
      
        handicapCompensationAdultRequest.setLegalAccessRepresentativeName(handicapCompensationAdultRequestXml.getLegalAccess().getLegalAccessRepresentativeName());
      
        List<fr.cg95.cvq.business.request.social.HcarOtherBenefit> otherBenefitsList = new ArrayList<fr.cg95.cvq.business.request.social.HcarOtherBenefit>(handicapCompensationAdultRequestXml.sizeOfOtherBenefitsArray());
        for (HcarOtherBenefitType object : handicapCompensationAdultRequestXml.getOtherBenefitsArray()) {
            otherBenefitsList.add(fr.cg95.cvq.business.request.social.HcarOtherBenefit.xmlToModel(object));
        }
        handicapCompensationAdultRequest.setOtherBenefits(otherBenefitsList);
      
        List<fr.cg95.cvq.business.request.social.HcarOtherFolder> otherFoldersList = new ArrayList<fr.cg95.cvq.business.request.social.HcarOtherFolder>(handicapCompensationAdultRequestXml.sizeOfOtherFoldersArray());
        for (HcarOtherFolderType object : handicapCompensationAdultRequestXml.getOtherFoldersArray()) {
            otherFoldersList.add(fr.cg95.cvq.business.request.social.HcarOtherFolder.xmlToModel(object));
        }
        handicapCompensationAdultRequest.setOtherFolders(otherFoldersList);
      
        if (handicapCompensationAdultRequestXml.getPaymentAgency().getPaymentAgencyAddress() != null)
            handicapCompensationAdultRequest.setPaymentAgencyAddress(Address.xmlToModel(handicapCompensationAdultRequestXml.getPaymentAgency().getPaymentAgencyAddress()));
      
        if (handicapCompensationAdultRequestXml.getPaymentAgency().getPaymentAgencyBeneficiary() != null)
            handicapCompensationAdultRequest.setPaymentAgencyBeneficiary(fr.cg95.cvq.business.request.social.HcarPaymentAgencyBeneficiaryType.forString(handicapCompensationAdultRequestXml.getPaymentAgency().getPaymentAgencyBeneficiary().toString()));
        else
            handicapCompensationAdultRequest.setPaymentAgencyBeneficiary(fr.cg95.cvq.business.request.social.HcarPaymentAgencyBeneficiaryType.getDefaultHcarPaymentAgencyBeneficiaryType());
      
        handicapCompensationAdultRequest.setPaymentAgencyBeneficiaryNumber(handicapCompensationAdultRequestXml.getPaymentAgency().getPaymentAgencyBeneficiaryNumber());
      
        handicapCompensationAdultRequest.setPaymentAgencyName(handicapCompensationAdultRequestXml.getPaymentAgency().getPaymentAgencyName());
      
        if (handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusAddress() != null)
            handicapCompensationAdultRequest.setProfessionalStatusAddress(Address.xmlToModel(handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusAddress()));
      
        calendar = handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusDate();
        if (calendar != null) {
            handicapCompensationAdultRequest.setProfessionalStatusDate(calendar.getTime());
        }
      
        handicapCompensationAdultRequest.setProfessionalStatusElectiveFunction(Boolean.valueOf(handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusElectiveFunction()));
      
        handicapCompensationAdultRequest.setProfessionalStatusElectiveFunctionDetails(handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusElectiveFunctionDetails());
      
        handicapCompensationAdultRequest.setProfessionalStatusEmployerName(handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusEmployerName());
      
        if (handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusEnvironment() != null)
            handicapCompensationAdultRequest.setProfessionalStatusEnvironment(fr.cg95.cvq.business.request.social.HcarProfessionalStatusEnvironmentType.forString(handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusEnvironment().toString()));
        else
            handicapCompensationAdultRequest.setProfessionalStatusEnvironment(fr.cg95.cvq.business.request.social.HcarProfessionalStatusEnvironmentType.getDefaultHcarProfessionalStatusEnvironmentType());
      
        handicapCompensationAdultRequest.setProfessionalStatusIndemnified(Boolean.valueOf(handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusIndemnified()));
      
        calendar = handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusIndemnifiedDate();
        if (calendar != null) {
            handicapCompensationAdultRequest.setProfessionalStatusIndemnifiedDate(calendar.getTime());
        }
      
        if (handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusKind() != null)
            handicapCompensationAdultRequest.setProfessionalStatusKind(fr.cg95.cvq.business.request.social.HcarProfessionalStatusKindType.forString(handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusKind().toString()));
        else
            handicapCompensationAdultRequest.setProfessionalStatusKind(fr.cg95.cvq.business.request.social.HcarProfessionalStatusKindType.getDefaultHcarProfessionalStatusKindType());
      
        handicapCompensationAdultRequest.setProfessionalStatusProfession(handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusProfession());
      
        handicapCompensationAdultRequest.setProfessionalStatusRegisterAsUnemployed(Boolean.valueOf(handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusRegisterAsUnemployed()));
      
        calendar = handicapCompensationAdultRequestXml.getProfessionalStatus().getProfessionalStatusRegisterAsUnemployedDate();
        if (calendar != null) {
            handicapCompensationAdultRequest.setProfessionalStatusRegisterAsUnemployedDate(calendar.getTime());
        }
      
        handicapCompensationAdultRequest.setProfessionalSupportDealsWithSameProfessional(Boolean.valueOf(handicapCompensationAdultRequestXml.getProfessionalSupport().getProfessionalSupportDealsWithSameProfessional()));
      
        handicapCompensationAdultRequest.setProfessionalSupportProfessionals(Boolean.valueOf(handicapCompensationAdultRequestXml.getProfessionalSupport().getProfessionalSupportProfessionals()));
      
        if (handicapCompensationAdultRequestXml.getSocialService().getProfessionalSupportSocialServiceAddress() != null)
            handicapCompensationAdultRequest.setProfessionalSupportSocialServiceAddress(Address.xmlToModel(handicapCompensationAdultRequestXml.getSocialService().getProfessionalSupportSocialServiceAddress()));
      
        handicapCompensationAdultRequest.setProfessionalSupportSocialServiceName(handicapCompensationAdultRequestXml.getSocialService().getProfessionalSupportSocialServiceName());
      
        handicapCompensationAdultRequest.setProfessionalSupportSocialServiceSupport(Boolean.valueOf(handicapCompensationAdultRequestXml.getSocialService().getProfessionalSupportSocialServiceSupport()));
      
        List<fr.cg95.cvq.business.request.social.HcarProfessional> professionalsList = new ArrayList<fr.cg95.cvq.business.request.social.HcarProfessional>(handicapCompensationAdultRequestXml.sizeOfProfessionalsArray());
        for (HcarProfessionalType object : handicapCompensationAdultRequestXml.getProfessionalsArray()) {
            professionalsList.add(fr.cg95.cvq.business.request.social.HcarProfessional.xmlToModel(object));
        }
        handicapCompensationAdultRequest.setProfessionals(professionalsList);
      
        handicapCompensationAdultRequest.setProjectComments(handicapCompensationAdultRequestXml.getProjectComments());
      
        handicapCompensationAdultRequest.setProjectNeeds(handicapCompensationAdultRequestXml.getProjectNeeds());
      
        handicapCompensationAdultRequest.setProjectRequestsACTPRenewal(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsACTPRenewal()));
      
        handicapCompensationAdultRequest.setProjectRequestsAssistance(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsAssistance()));
      
        handicapCompensationAdultRequest.setProjectRequestsCustomCar(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsCustomCar()));
      
        handicapCompensationAdultRequest.setProjectRequestsDisabilityCard(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsDisabilityCard()));
      
        handicapCompensationAdultRequest.setProjectRequestsDisabilityCostAllocation(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsDisabilityCostAllocation()));
      
        handicapCompensationAdultRequest.setProjectRequestsDisabledAdultAllowance(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsDisabledAdultAllowance()));
      
        handicapCompensationAdultRequest.setProjectRequestsDisabledPriorityCard(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsDisabledPriorityCard()));
      
        handicapCompensationAdultRequest.setProjectRequestsDisabledWorkerRecognition(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsDisabledWorkerRecognition()));
      
        handicapCompensationAdultRequest.setProjectRequestsEducationAllocationOfDisabledChildren(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsEducationAllocationOfDisabledChildren()));
      
        handicapCompensationAdultRequest.setProjectRequestsEuropeanParkingCard(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsEuropeanParkingCard()));
      
        handicapCompensationAdultRequest.setProjectRequestsFreePensionMembership(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsFreePensionMembership()));
      
        handicapCompensationAdultRequest.setProjectRequestsHandicapRecognition(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsHandicapRecognition()));
      
        handicapCompensationAdultRequest.setProjectRequestsHousingFacilities(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsHousingFacilities()));
      
        handicapCompensationAdultRequest.setProjectRequestsIncreaseForIndependentLiving(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsIncreaseForIndependentLiving()));
      
        handicapCompensationAdultRequest.setProjectRequestsInstitutionSupport(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsInstitutionSupport()));
      
        handicapCompensationAdultRequest.setProjectRequestsOrdinaryWorking(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsOrdinaryWorking()));
      
        handicapCompensationAdultRequest.setProjectRequestsOther(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsOther()));
      
        handicapCompensationAdultRequest.setProjectRequestsOtherDetails(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsOtherDetails());
      
        handicapCompensationAdultRequest.setProjectRequestsProfessionalOrientation(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsProfessionalOrientation()));
      
        handicapCompensationAdultRequest.setProjectRequestsShelteredWork(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsShelteredWork()));
      
        handicapCompensationAdultRequest.setProjectRequestsTechnicalHelp(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsTechnicalHelp()));
      
        handicapCompensationAdultRequest.setProjectRequestsThirdPartyHelp(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsThirdPartyHelp()));
      
        handicapCompensationAdultRequest.setProjectRequestsTransportCostAllocation(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsTransportCostAllocation()));
      
        handicapCompensationAdultRequest.setProjectRequestsVocationalTraining(Boolean.valueOf(handicapCompensationAdultRequestXml.getProjectRequests().getProjectRequestsVocationalTraining()));
      
        handicapCompensationAdultRequest.setProjectWish(handicapCompensationAdultRequestXml.getProjectWish());
      
        if (handicapCompensationAdultRequestXml.getSocialSecurity().getSocialSecurityAgencyAddress() != null)
            handicapCompensationAdultRequest.setSocialSecurityAgencyAddress(Address.xmlToModel(handicapCompensationAdultRequestXml.getSocialSecurity().getSocialSecurityAgencyAddress()));
      
        handicapCompensationAdultRequest.setSocialSecurityAgencyName(handicapCompensationAdultRequestXml.getSocialSecurity().getSocialSecurityAgencyName());
      
        if (handicapCompensationAdultRequestXml.getSocialSecurity().getSocialSecurityMemberShipKind() != null)
            handicapCompensationAdultRequest.setSocialSecurityMemberShipKind(fr.cg95.cvq.business.request.social.HcarSocialSecurityMemberShipKindType.forString(handicapCompensationAdultRequestXml.getSocialSecurity().getSocialSecurityMemberShipKind().toString()));
        else
            handicapCompensationAdultRequest.setSocialSecurityMemberShipKind(fr.cg95.cvq.business.request.social.HcarSocialSecurityMemberShipKindType.getDefaultHcarSocialSecurityMemberShipKindType());
      
        handicapCompensationAdultRequest.setSocialSecurityNumber(handicapCompensationAdultRequestXml.getSocialSecurity().getSocialSecurityNumber());
      
        handicapCompensationAdultRequest.setStudiesAssistanceUnderDisability(Boolean.valueOf(handicapCompensationAdultRequestXml.getStudies().getStudiesAssistanceUnderDisability()));
      
        handicapCompensationAdultRequest.setStudiesAssistanceUnderDisabilityDetails(handicapCompensationAdultRequestXml.getStudies().getStudiesAssistanceUnderDisabilityDetails());
      
        handicapCompensationAdultRequest.setStudiesHighSchool(Boolean.valueOf(handicapCompensationAdultRequestXml.getStudies().getStudiesHighSchool()));
      
        if (handicapCompensationAdultRequestXml.getStudies().getStudiesHighSchoolAddress() != null)
            handicapCompensationAdultRequest.setStudiesHighSchoolAddress(Address.xmlToModel(handicapCompensationAdultRequestXml.getStudies().getStudiesHighSchoolAddress()));
      
        handicapCompensationAdultRequest.setStudiesHighSchoolGrade(handicapCompensationAdultRequestXml.getStudies().getStudiesHighSchoolGrade());
      
        handicapCompensationAdultRequest.setStudiesHighSchoolName(handicapCompensationAdultRequestXml.getStudies().getStudiesHighSchoolName());
      
        handicapCompensationAdultRequest.setSubjectBirthCity(handicapCompensationAdultRequestXml.getHcarSubject().getSubjectBirthCity());
      
        handicapCompensationAdultRequest.setSubjectBirthCountry(handicapCompensationAdultRequestXml.getHcarSubject().getSubjectBirthCountry());
      
        calendar = handicapCompensationAdultRequestXml.getHcarSubject().getSubjectBirthDate();
        if (calendar != null) {
            handicapCompensationAdultRequest.setSubjectBirthDate(calendar.getTime());
        }
      
        handicapCompensationAdultRequest.setSubjectMaidenName(handicapCompensationAdultRequestXml.getHcarSubject().getSubjectMaidenName());
      
        if (handicapCompensationAdultRequestXml.getHcarSubject().getSubjectTitle() != null)
            handicapCompensationAdultRequest.setSubjectTitle(fr.cg95.cvq.business.users.TitleType.forString(handicapCompensationAdultRequestXml.getHcarSubject().getSubjectTitle().toString()));
        else
            handicapCompensationAdultRequest.setSubjectTitle(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
      
        return handicapCompensationAdultRequest;
    }

    @Override
    public HandicapCompensationAdultRequest clone() {
        HandicapCompensationAdultRequest clone = new HandicapCompensationAdultRequest(getRequestData().clone(), handicapCompensationAdultRequestData.clone());
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

  
    public final void setAdditionalFee(final List<fr.cg95.cvq.business.request.social.HcarAdditionalFee> additionalFee) {
        handicapCompensationAdultRequestData.setAdditionalFee(additionalFee);
    }

    
    public final List<fr.cg95.cvq.business.request.social.HcarAdditionalFee> getAdditionalFee() {
        return handicapCompensationAdultRequestData.getAdditionalFee();
    }
  
    public final void setBenefitsCompensatoryAllowanceForExpenses(final Boolean benefitsCompensatoryAllowanceForExpenses) {
        handicapCompensationAdultRequestData.setBenefitsCompensatoryAllowanceForExpenses(benefitsCompensatoryAllowanceForExpenses);
    }

    
    public final Boolean getBenefitsCompensatoryAllowanceForExpenses() {
        return handicapCompensationAdultRequestData.getBenefitsCompensatoryAllowanceForExpenses();
    }
  
    public final void setBenefitsDailyAllowances(final Boolean benefitsDailyAllowances) {
        handicapCompensationAdultRequestData.setBenefitsDailyAllowances(benefitsDailyAllowances);
    }

    
    public final Boolean getBenefitsDailyAllowances() {
        return handicapCompensationAdultRequestData.getBenefitsDailyAllowances();
    }
  
    public final void setBenefitsDisabilityCard(final Boolean benefitsDisabilityCard) {
        handicapCompensationAdultRequestData.setBenefitsDisabilityCard(benefitsDisabilityCard);
    }

    
    public final Boolean getBenefitsDisabilityCard() {
        return handicapCompensationAdultRequestData.getBenefitsDisabilityCard();
    }
  
    public final void setBenefitsDisabilityCompensation(final Boolean benefitsDisabilityCompensation) {
        handicapCompensationAdultRequestData.setBenefitsDisabilityCompensation(benefitsDisabilityCompensation);
    }

    
    public final Boolean getBenefitsDisabilityCompensation() {
        return handicapCompensationAdultRequestData.getBenefitsDisabilityCompensation();
    }
  
    public final void setBenefitsDisabilityPension(final Boolean benefitsDisabilityPension) {
        handicapCompensationAdultRequestData.setBenefitsDisabilityPension(benefitsDisabilityPension);
    }

    
    public final Boolean getBenefitsDisabilityPension() {
        return handicapCompensationAdultRequestData.getBenefitsDisabilityPension();
    }
  
    public final void setBenefitsDisabilityPensionCategory(final String benefitsDisabilityPensionCategory) {
        handicapCompensationAdultRequestData.setBenefitsDisabilityPensionCategory(benefitsDisabilityPensionCategory);
    }

    
    public final String getBenefitsDisabilityPensionCategory() {
        return handicapCompensationAdultRequestData.getBenefitsDisabilityPensionCategory();
    }
  
    public final void setBenefitsDisabilityRatio(final String benefitsDisabilityRatio) {
        handicapCompensationAdultRequestData.setBenefitsDisabilityRatio(benefitsDisabilityRatio);
    }

    
    public final String getBenefitsDisabilityRatio() {
        return handicapCompensationAdultRequestData.getBenefitsDisabilityRatio();
    }
  
    public final void setBenefitsDisabilityRecognition(final Boolean benefitsDisabilityRecognition) {
        handicapCompensationAdultRequestData.setBenefitsDisabilityRecognition(benefitsDisabilityRecognition);
    }

    
    public final Boolean getBenefitsDisabilityRecognition() {
        return handicapCompensationAdultRequestData.getBenefitsDisabilityRecognition();
    }
  
    public final void setBenefitsDisabledAdultAllocation(final Boolean benefitsDisabledAdultAllocation) {
        handicapCompensationAdultRequestData.setBenefitsDisabledAdultAllocation(benefitsDisabledAdultAllocation);
    }

    
    public final Boolean getBenefitsDisabledAdultAllocation() {
        return handicapCompensationAdultRequestData.getBenefitsDisabledAdultAllocation();
    }
  
    public final void setBenefitsDisabledWorkerRecognition(final Boolean benefitsDisabledWorkerRecognition) {
        handicapCompensationAdultRequestData.setBenefitsDisabledWorkerRecognition(benefitsDisabledWorkerRecognition);
    }

    
    public final Boolean getBenefitsDisabledWorkerRecognition() {
        return handicapCompensationAdultRequestData.getBenefitsDisabledWorkerRecognition();
    }
  
    public final void setBenefitsEducationAllocationOfDisabledChildren(final Boolean benefitsEducationAllocationOfDisabledChildren) {
        handicapCompensationAdultRequestData.setBenefitsEducationAllocationOfDisabledChildren(benefitsEducationAllocationOfDisabledChildren);
    }

    
    public final Boolean getBenefitsEducationAllocationOfDisabledChildren() {
        return handicapCompensationAdultRequestData.getBenefitsEducationAllocationOfDisabledChildren();
    }
  
    public final void setBenefitsEducationOfDisabledChildren(final Boolean benefitsEducationOfDisabledChildren) {
        handicapCompensationAdultRequestData.setBenefitsEducationOfDisabledChildren(benefitsEducationOfDisabledChildren);
    }

    
    public final Boolean getBenefitsEducationOfDisabledChildren() {
        return handicapCompensationAdultRequestData.getBenefitsEducationOfDisabledChildren();
    }
  
    public final void setBenefitsEducationOfDisabledChildrenDetails(final String benefitsEducationOfDisabledChildrenDetails) {
        handicapCompensationAdultRequestData.setBenefitsEducationOfDisabledChildrenDetails(benefitsEducationOfDisabledChildrenDetails);
    }

    
    public final String getBenefitsEducationOfDisabledChildrenDetails() {
        return handicapCompensationAdultRequestData.getBenefitsEducationOfDisabledChildrenDetails();
    }
  
    public final void setBenefitsIncreaseForIndependentLiving(final Boolean benefitsIncreaseForIndependentLiving) {
        handicapCompensationAdultRequestData.setBenefitsIncreaseForIndependentLiving(benefitsIncreaseForIndependentLiving);
    }

    
    public final Boolean getBenefitsIncreaseForIndependentLiving() {
        return handicapCompensationAdultRequestData.getBenefitsIncreaseForIndependentLiving();
    }
  
    public final void setBenefitsOtherBenefits(final Boolean benefitsOtherBenefits) {
        handicapCompensationAdultRequestData.setBenefitsOtherBenefits(benefitsOtherBenefits);
    }

    
    public final Boolean getBenefitsOtherBenefits() {
        return handicapCompensationAdultRequestData.getBenefitsOtherBenefits();
    }
  
    public final void setBenefitsPainfulStandingCard(final Boolean benefitsPainfulStandingCard) {
        handicapCompensationAdultRequestData.setBenefitsPainfulStandingCard(benefitsPainfulStandingCard);
    }

    
    public final Boolean getBenefitsPainfulStandingCard() {
        return handicapCompensationAdultRequestData.getBenefitsPainfulStandingCard();
    }
  
    public final void setBenefitsParkingCard(final Boolean benefitsParkingCard) {
        handicapCompensationAdultRequestData.setBenefitsParkingCard(benefitsParkingCard);
    }

    
    public final Boolean getBenefitsParkingCard() {
        return handicapCompensationAdultRequestData.getBenefitsParkingCard();
    }
  
    public final void setBenefitsProfessionalOrientation(final Boolean benefitsProfessionalOrientation) {
        handicapCompensationAdultRequestData.setBenefitsProfessionalOrientation(benefitsProfessionalOrientation);
    }

    
    public final Boolean getBenefitsProfessionalOrientation() {
        return handicapCompensationAdultRequestData.getBenefitsProfessionalOrientation();
    }
  
    public final void setBenefitsProfessionalOrientationDetails(final String benefitsProfessionalOrientationDetails) {
        handicapCompensationAdultRequestData.setBenefitsProfessionalOrientationDetails(benefitsProfessionalOrientationDetails);
    }

    
    public final String getBenefitsProfessionalOrientationDetails() {
        return handicapCompensationAdultRequestData.getBenefitsProfessionalOrientationDetails();
    }
  
    public final void setBenefitsSocialWelfare(final Boolean benefitsSocialWelfare) {
        handicapCompensationAdultRequestData.setBenefitsSocialWelfare(benefitsSocialWelfare);
    }

    
    public final Boolean getBenefitsSocialWelfare() {
        return handicapCompensationAdultRequestData.getBenefitsSocialWelfare();
    }
  
    public final void setBenefitsSupplementForSingleParents(final Boolean benefitsSupplementForSingleParents) {
        handicapCompensationAdultRequestData.setBenefitsSupplementForSingleParents(benefitsSupplementForSingleParents);
    }

    
    public final Boolean getBenefitsSupplementForSingleParents() {
        return handicapCompensationAdultRequestData.getBenefitsSupplementForSingleParents();
    }
  
    public final void setBenefitsSupportedByAnInstitution(final Boolean benefitsSupportedByAnInstitution) {
        handicapCompensationAdultRequestData.setBenefitsSupportedByAnInstitution(benefitsSupportedByAnInstitution);
    }

    
    public final Boolean getBenefitsSupportedByAnInstitution() {
        return handicapCompensationAdultRequestData.getBenefitsSupportedByAnInstitution();
    }
  
    public final void setBenefitsSupportedByAnInstitutionDetails(final String benefitsSupportedByAnInstitutionDetails) {
        handicapCompensationAdultRequestData.setBenefitsSupportedByAnInstitutionDetails(benefitsSupportedByAnInstitutionDetails);
    }

    
    public final String getBenefitsSupportedByAnInstitutionDetails() {
        return handicapCompensationAdultRequestData.getBenefitsSupportedByAnInstitutionDetails();
    }
  
    public final void setBenefitsThirdPartyCompensatoryAllowance(final Boolean benefitsThirdPartyCompensatoryAllowance) {
        handicapCompensationAdultRequestData.setBenefitsThirdPartyCompensatoryAllowance(benefitsThirdPartyCompensatoryAllowance);
    }

    
    public final Boolean getBenefitsThirdPartyCompensatoryAllowance() {
        return handicapCompensationAdultRequestData.getBenefitsThirdPartyCompensatoryAllowance();
    }
  
    public final void setBenefitsThirdPartySupplement(final Boolean benefitsThirdPartySupplement) {
        handicapCompensationAdultRequestData.setBenefitsThirdPartySupplement(benefitsThirdPartySupplement);
    }

    
    public final Boolean getBenefitsThirdPartySupplement() {
        return handicapCompensationAdultRequestData.getBenefitsThirdPartySupplement();
    }
  
    public final void setBenefitsThirdPersonCompensatoryAllowance(final Boolean benefitsThirdPersonCompensatoryAllowance) {
        handicapCompensationAdultRequestData.setBenefitsThirdPersonCompensatoryAllowance(benefitsThirdPersonCompensatoryAllowance);
    }

    
    public final Boolean getBenefitsThirdPersonCompensatoryAllowance() {
        return handicapCompensationAdultRequestData.getBenefitsThirdPersonCompensatoryAllowance();
    }
  
    public final void setBenefitsUnemploymentBenefits(final Boolean benefitsUnemploymentBenefits) {
        handicapCompensationAdultRequestData.setBenefitsUnemploymentBenefits(benefitsUnemploymentBenefits);
    }

    
    public final Boolean getBenefitsUnemploymentBenefits() {
        return handicapCompensationAdultRequestData.getBenefitsUnemploymentBenefits();
    }
  
    public final void setBenefitsWorkAccidentAnnuity(final Boolean benefitsWorkAccidentAnnuity) {
        handicapCompensationAdultRequestData.setBenefitsWorkAccidentAnnuity(benefitsWorkAccidentAnnuity);
    }

    
    public final Boolean getBenefitsWorkAccidentAnnuity() {
        return handicapCompensationAdultRequestData.getBenefitsWorkAccidentAnnuity();
    }
  
    public final void setBenefitsWorkAccidentAnnuityRatio(final String benefitsWorkAccidentAnnuityRatio) {
        handicapCompensationAdultRequestData.setBenefitsWorkAccidentAnnuityRatio(benefitsWorkAccidentAnnuityRatio);
    }

    
    public final String getBenefitsWorkAccidentAnnuityRatio() {
        return handicapCompensationAdultRequestData.getBenefitsWorkAccidentAnnuityRatio();
    }
  
    public final void setCareCareServices(final Boolean careCareServices) {
        handicapCompensationAdultRequestData.setCareCareServices(careCareServices);
    }

    
    public final Boolean getCareCareServices() {
        return handicapCompensationAdultRequestData.getCareCareServices();
    }
  
    public final void setCareServices(final List<fr.cg95.cvq.business.request.social.HcarCareService> careServices) {
        handicapCompensationAdultRequestData.setCareServices(careServices);
    }

    
    public final List<fr.cg95.cvq.business.request.social.HcarCareService> getCareServices() {
        return handicapCompensationAdultRequestData.getCareServices();
    }
  
    public final void setDwellingEstablishmentReception(final Boolean dwellingEstablishmentReception) {
        handicapCompensationAdultRequestData.setDwellingEstablishmentReception(dwellingEstablishmentReception);
    }

    
    public final Boolean getDwellingEstablishmentReception() {
        return handicapCompensationAdultRequestData.getDwellingEstablishmentReception();
    }
  
    public final void setDwellingKind(final fr.cg95.cvq.business.request.social.HcarDwellingKindType dwellingKind) {
        handicapCompensationAdultRequestData.setDwellingKind(dwellingKind);
    }

    
    public final fr.cg95.cvq.business.request.social.HcarDwellingKindType getDwellingKind() {
        return handicapCompensationAdultRequestData.getDwellingKind();
    }
  
    public final void setDwellingPrecision(final String dwellingPrecision) {
        handicapCompensationAdultRequestData.setDwellingPrecision(dwellingPrecision);
    }

    
    public final String getDwellingPrecision() {
        return handicapCompensationAdultRequestData.getDwellingPrecision();
    }
  
    public final void setDwellingReceptionAddress(final fr.cg95.cvq.business.users.Address dwellingReceptionAddress) {
        handicapCompensationAdultRequestData.setDwellingReceptionAddress(dwellingReceptionAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getDwellingReceptionAddress() {
        return handicapCompensationAdultRequestData.getDwellingReceptionAddress();
    }
  
    public final void setDwellingReceptionNaming(final String dwellingReceptionNaming) {
        handicapCompensationAdultRequestData.setDwellingReceptionNaming(dwellingReceptionNaming);
    }

    
    public final String getDwellingReceptionNaming() {
        return handicapCompensationAdultRequestData.getDwellingReceptionNaming();
    }
  
    public final void setDwellingReceptionType(final fr.cg95.cvq.business.request.social.HcarDwellingReceptionKindType dwellingReceptionType) {
        handicapCompensationAdultRequestData.setDwellingReceptionType(dwellingReceptionType);
    }

    
    public final fr.cg95.cvq.business.request.social.HcarDwellingReceptionKindType getDwellingReceptionType() {
        return handicapCompensationAdultRequestData.getDwellingReceptionType();
    }
  
    public final void setDwellingSocialReception(final Boolean dwellingSocialReception) {
        handicapCompensationAdultRequestData.setDwellingSocialReception(dwellingSocialReception);
    }

    
    public final Boolean getDwellingSocialReception() {
        return handicapCompensationAdultRequestData.getDwellingSocialReception();
    }
  
    public final void setDwellingSocialReceptionAddress(final fr.cg95.cvq.business.users.Address dwellingSocialReceptionAddress) {
        handicapCompensationAdultRequestData.setDwellingSocialReceptionAddress(dwellingSocialReceptionAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getDwellingSocialReceptionAddress() {
        return handicapCompensationAdultRequestData.getDwellingSocialReceptionAddress();
    }
  
    public final void setDwellingSocialReceptionNaming(final String dwellingSocialReceptionNaming) {
        handicapCompensationAdultRequestData.setDwellingSocialReceptionNaming(dwellingSocialReceptionNaming);
    }

    
    public final String getDwellingSocialReceptionNaming() {
        return handicapCompensationAdultRequestData.getDwellingSocialReceptionNaming();
    }
  
    public final void setFacilitiesAnimalAid(final Boolean facilitiesAnimalAid) {
        handicapCompensationAdultRequestData.setFacilitiesAnimalAid(facilitiesAnimalAid);
    }

    
    public final Boolean getFacilitiesAnimalAid() {
        return handicapCompensationAdultRequestData.getFacilitiesAnimalAid();
    }
  
    public final void setFacilitiesAnimalAidDetails(final String facilitiesAnimalAidDetails) {
        handicapCompensationAdultRequestData.setFacilitiesAnimalAidDetails(facilitiesAnimalAidDetails);
    }

    
    public final String getFacilitiesAnimalAidDetails() {
        return handicapCompensationAdultRequestData.getFacilitiesAnimalAidDetails();
    }
  
    public final void setFacilitiesCustomCar(final Boolean facilitiesCustomCar) {
        handicapCompensationAdultRequestData.setFacilitiesCustomCar(facilitiesCustomCar);
    }

    
    public final Boolean getFacilitiesCustomCar() {
        return handicapCompensationAdultRequestData.getFacilitiesCustomCar();
    }
  
    public final void setFacilitiesCustomCarDetails(final String facilitiesCustomCarDetails) {
        handicapCompensationAdultRequestData.setFacilitiesCustomCarDetails(facilitiesCustomCarDetails);
    }

    
    public final String getFacilitiesCustomCarDetails() {
        return handicapCompensationAdultRequestData.getFacilitiesCustomCarDetails();
    }
  
    public final void setFacilitiesHousing(final Boolean facilitiesHousing) {
        handicapCompensationAdultRequestData.setFacilitiesHousing(facilitiesHousing);
    }

    
    public final Boolean getFacilitiesHousing() {
        return handicapCompensationAdultRequestData.getFacilitiesHousing();
    }
  
    public final void setFacilitiesHousingDetails(final String facilitiesHousingDetails) {
        handicapCompensationAdultRequestData.setFacilitiesHousingDetails(facilitiesHousingDetails);
    }

    
    public final String getFacilitiesHousingDetails() {
        return handicapCompensationAdultRequestData.getFacilitiesHousingDetails();
    }
  
    public final void setFacilitiesSpecializedTransport(final Boolean facilitiesSpecializedTransport) {
        handicapCompensationAdultRequestData.setFacilitiesSpecializedTransport(facilitiesSpecializedTransport);
    }

    
    public final Boolean getFacilitiesSpecializedTransport() {
        return handicapCompensationAdultRequestData.getFacilitiesSpecializedTransport();
    }
  
    public final void setFacilitiesSpecializedTransportDetails(final String facilitiesSpecializedTransportDetails) {
        handicapCompensationAdultRequestData.setFacilitiesSpecializedTransportDetails(facilitiesSpecializedTransportDetails);
    }

    
    public final String getFacilitiesSpecializedTransportDetails() {
        return handicapCompensationAdultRequestData.getFacilitiesSpecializedTransportDetails();
    }
  
    public final void setFacilitiesTechnicalAssistance(final Boolean facilitiesTechnicalAssistance) {
        handicapCompensationAdultRequestData.setFacilitiesTechnicalAssistance(facilitiesTechnicalAssistance);
    }

    
    public final Boolean getFacilitiesTechnicalAssistance() {
        return handicapCompensationAdultRequestData.getFacilitiesTechnicalAssistance();
    }
  
    public final void setFacilitiesTechnicalAssistanceDetails(final String facilitiesTechnicalAssistanceDetails) {
        handicapCompensationAdultRequestData.setFacilitiesTechnicalAssistanceDetails(facilitiesTechnicalAssistanceDetails);
    }

    
    public final String getFacilitiesTechnicalAssistanceDetails() {
        return handicapCompensationAdultRequestData.getFacilitiesTechnicalAssistanceDetails();
    }
  
    public final void setFamilyAssistanceMembers(final List<fr.cg95.cvq.business.request.social.HcarFamilyAssistanceMember> familyAssistanceMembers) {
        handicapCompensationAdultRequestData.setFamilyAssistanceMembers(familyAssistanceMembers);
    }

    
    public final List<fr.cg95.cvq.business.request.social.HcarFamilyAssistanceMember> getFamilyAssistanceMembers() {
        return handicapCompensationAdultRequestData.getFamilyAssistanceMembers();
    }
  
    public final void setFamilyDependents(final List<fr.cg95.cvq.business.request.social.HcarFamilyDependent> familyDependents) {
        handicapCompensationAdultRequestData.setFamilyDependents(familyDependents);
    }

    
    public final List<fr.cg95.cvq.business.request.social.HcarFamilyDependent> getFamilyDependents() {
        return handicapCompensationAdultRequestData.getFamilyDependents();
    }
  
    public final void setFamilyFamilyDependents(final Boolean familyFamilyDependents) {
        handicapCompensationAdultRequestData.setFamilyFamilyDependents(familyFamilyDependents);
    }

    
    public final Boolean getFamilyFamilyDependents() {
        return handicapCompensationAdultRequestData.getFamilyFamilyDependents();
    }
  
    public final void setFamilyStatus(final fr.cg95.cvq.business.users.FamilyStatusType familyStatus) {
        handicapCompensationAdultRequestData.setFamilyStatus(familyStatus);
    }

    
    public final fr.cg95.cvq.business.users.FamilyStatusType getFamilyStatus() {
        return handicapCompensationAdultRequestData.getFamilyStatus();
    }
  
    public final void setFoldersCdes(final Boolean foldersCdes) {
        handicapCompensationAdultRequestData.setFoldersCdes(foldersCdes);
    }

    
    public final Boolean getFoldersCdes() {
        return handicapCompensationAdultRequestData.getFoldersCdes();
    }
  
    public final void setFoldersCdesDepartment(final String foldersCdesDepartment) {
        handicapCompensationAdultRequestData.setFoldersCdesDepartment(foldersCdesDepartment);
    }

    
    public final String getFoldersCdesDepartment() {
        return handicapCompensationAdultRequestData.getFoldersCdesDepartment();
    }
  
    public final void setFoldersCdesNumber(final String foldersCdesNumber) {
        handicapCompensationAdultRequestData.setFoldersCdesNumber(foldersCdesNumber);
    }

    
    public final String getFoldersCdesNumber() {
        return handicapCompensationAdultRequestData.getFoldersCdesNumber();
    }
  
    public final void setFoldersCotorep(final Boolean foldersCotorep) {
        handicapCompensationAdultRequestData.setFoldersCotorep(foldersCotorep);
    }

    
    public final Boolean getFoldersCotorep() {
        return handicapCompensationAdultRequestData.getFoldersCotorep();
    }
  
    public final void setFoldersCotorepDepartment(final String foldersCotorepDepartment) {
        handicapCompensationAdultRequestData.setFoldersCotorepDepartment(foldersCotorepDepartment);
    }

    
    public final String getFoldersCotorepDepartment() {
        return handicapCompensationAdultRequestData.getFoldersCotorepDepartment();
    }
  
    public final void setFoldersCotorepNumber(final String foldersCotorepNumber) {
        handicapCompensationAdultRequestData.setFoldersCotorepNumber(foldersCotorepNumber);
    }

    
    public final String getFoldersCotorepNumber() {
        return handicapCompensationAdultRequestData.getFoldersCotorepNumber();
    }
  
    public final void setFoldersMdph(final Boolean foldersMdph) {
        handicapCompensationAdultRequestData.setFoldersMdph(foldersMdph);
    }

    
    public final Boolean getFoldersMdph() {
        return handicapCompensationAdultRequestData.getFoldersMdph();
    }
  
    public final void setFoldersMdphDepartment(final String foldersMdphDepartment) {
        handicapCompensationAdultRequestData.setFoldersMdphDepartment(foldersMdphDepartment);
    }

    
    public final String getFoldersMdphDepartment() {
        return handicapCompensationAdultRequestData.getFoldersMdphDepartment();
    }
  
    public final void setFoldersMdphNumber(final String foldersMdphNumber) {
        handicapCompensationAdultRequestData.setFoldersMdphNumber(foldersMdphNumber);
    }

    
    public final String getFoldersMdphNumber() {
        return handicapCompensationAdultRequestData.getFoldersMdphNumber();
    }
  
    public final void setFoldersOtherFolders(final Boolean foldersOtherFolders) {
        handicapCompensationAdultRequestData.setFoldersOtherFolders(foldersOtherFolders);
    }

    
    public final Boolean getFoldersOtherFolders() {
        return handicapCompensationAdultRequestData.getFoldersOtherFolders();
    }
  
    public final void setFormationCurrentFormation(final String formationCurrentFormation) {
        handicapCompensationAdultRequestData.setFormationCurrentFormation(formationCurrentFormation);
    }

    
    public final String getFormationCurrentFormation() {
        return handicapCompensationAdultRequestData.getFormationCurrentFormation();
    }
  
    public final void setFormationDiploma(final String formationDiploma) {
        handicapCompensationAdultRequestData.setFormationDiploma(formationDiploma);
    }

    
    public final String getFormationDiploma() {
        return handicapCompensationAdultRequestData.getFormationDiploma();
    }
  
    public final void setFormationPreviousFormation(final String formationPreviousFormation) {
        handicapCompensationAdultRequestData.setFormationPreviousFormation(formationPreviousFormation);
    }

    
    public final String getFormationPreviousFormation() {
        return handicapCompensationAdultRequestData.getFormationPreviousFormation();
    }
  
    public final void setFormationStudiesLevel(final String formationStudiesLevel) {
        handicapCompensationAdultRequestData.setFormationStudiesLevel(formationStudiesLevel);
    }

    
    public final String getFormationStudiesLevel() {
        return handicapCompensationAdultRequestData.getFormationStudiesLevel();
    }
  
    public final void setHealthDoctorFirstName(final String healthDoctorFirstName) {
        handicapCompensationAdultRequestData.setHealthDoctorFirstName(healthDoctorFirstName);
    }

    
    public final String getHealthDoctorFirstName() {
        return handicapCompensationAdultRequestData.getHealthDoctorFirstName();
    }
  
    public final void setHealthDoctorLastName(final String healthDoctorLastName) {
        handicapCompensationAdultRequestData.setHealthDoctorLastName(healthDoctorLastName);
    }

    
    public final String getHealthDoctorLastName() {
        return handicapCompensationAdultRequestData.getHealthDoctorLastName();
    }
  
    public final void setHealthFollowedByDoctor(final Boolean healthFollowedByDoctor) {
        handicapCompensationAdultRequestData.setHealthFollowedByDoctor(healthFollowedByDoctor);
    }

    
    public final Boolean getHealthFollowedByDoctor() {
        return handicapCompensationAdultRequestData.getHealthFollowedByDoctor();
    }
  
    public final void setHealthFollowedByHospital(final Boolean healthFollowedByHospital) {
        handicapCompensationAdultRequestData.setHealthFollowedByHospital(healthFollowedByHospital);
    }

    
    public final Boolean getHealthFollowedByHospital() {
        return handicapCompensationAdultRequestData.getHealthFollowedByHospital();
    }
  
    public final void setHealthFollowedByProfessional(final Boolean healthFollowedByProfessional) {
        handicapCompensationAdultRequestData.setHealthFollowedByProfessional(healthFollowedByProfessional);
    }

    
    public final Boolean getHealthFollowedByProfessional() {
        return handicapCompensationAdultRequestData.getHealthFollowedByProfessional();
    }
  
    public final void setHealthHospitalName(final String healthHospitalName) {
        handicapCompensationAdultRequestData.setHealthHospitalName(healthHospitalName);
    }

    
    public final String getHealthHospitalName() {
        return handicapCompensationAdultRequestData.getHealthHospitalName();
    }
  
    public final void setHealthProfessionalFirstName(final String healthProfessionalFirstName) {
        handicapCompensationAdultRequestData.setHealthProfessionalFirstName(healthProfessionalFirstName);
    }

    
    public final String getHealthProfessionalFirstName() {
        return handicapCompensationAdultRequestData.getHealthProfessionalFirstName();
    }
  
    public final void setHealthProfessionalLastName(final String healthProfessionalLastName) {
        handicapCompensationAdultRequestData.setHealthProfessionalLastName(healthProfessionalLastName);
    }

    
    public final String getHealthProfessionalLastName() {
        return handicapCompensationAdultRequestData.getHealthProfessionalLastName();
    }
  
    public final void setHomeIntervenants(final List<fr.cg95.cvq.business.request.social.HcarHomeIntervenant> homeIntervenants) {
        handicapCompensationAdultRequestData.setHomeIntervenants(homeIntervenants);
    }

    
    public final List<fr.cg95.cvq.business.request.social.HcarHomeIntervenant> getHomeIntervenants() {
        return handicapCompensationAdultRequestData.getHomeIntervenants();
    }
  
    public final void setHomeInterventionHomeIntervenant(final Boolean homeInterventionHomeIntervenant) {
        handicapCompensationAdultRequestData.setHomeInterventionHomeIntervenant(homeInterventionHomeIntervenant);
    }

    
    public final Boolean getHomeInterventionHomeIntervenant() {
        return handicapCompensationAdultRequestData.getHomeInterventionHomeIntervenant();
    }
  
    public final void setIsFamilyAssistance(final Boolean isFamilyAssistance) {
        handicapCompensationAdultRequestData.setIsFamilyAssistance(isFamilyAssistance);
    }

    
    public final Boolean getIsFamilyAssistance() {
        return handicapCompensationAdultRequestData.getIsFamilyAssistance();
    }
  
    public final void setLegalAccessKind(final fr.cg95.cvq.business.request.social.HcarLegalAccessKindType legalAccessKind) {
        handicapCompensationAdultRequestData.setLegalAccessKind(legalAccessKind);
    }

    
    public final fr.cg95.cvq.business.request.social.HcarLegalAccessKindType getLegalAccessKind() {
        return handicapCompensationAdultRequestData.getLegalAccessKind();
    }
  
    public final void setLegalAccessPresence(final Boolean legalAccessPresence) {
        handicapCompensationAdultRequestData.setLegalAccessPresence(legalAccessPresence);
    }

    
    public final Boolean getLegalAccessPresence() {
        return handicapCompensationAdultRequestData.getLegalAccessPresence();
    }
  
    public final void setLegalAccessRepresentativeFirstName(final String legalAccessRepresentativeFirstName) {
        handicapCompensationAdultRequestData.setLegalAccessRepresentativeFirstName(legalAccessRepresentativeFirstName);
    }

    
    public final String getLegalAccessRepresentativeFirstName() {
        return handicapCompensationAdultRequestData.getLegalAccessRepresentativeFirstName();
    }
  
    public final void setLegalAccessRepresentativeKind(final fr.cg95.cvq.business.request.social.HcarLegalAccessRepresentativeKindType legalAccessRepresentativeKind) {
        handicapCompensationAdultRequestData.setLegalAccessRepresentativeKind(legalAccessRepresentativeKind);
    }

    
    public final fr.cg95.cvq.business.request.social.HcarLegalAccessRepresentativeKindType getLegalAccessRepresentativeKind() {
        return handicapCompensationAdultRequestData.getLegalAccessRepresentativeKind();
    }
  
    public final void setLegalAccessRepresentativeKindDetail(final String legalAccessRepresentativeKindDetail) {
        handicapCompensationAdultRequestData.setLegalAccessRepresentativeKindDetail(legalAccessRepresentativeKindDetail);
    }

    
    public final String getLegalAccessRepresentativeKindDetail() {
        return handicapCompensationAdultRequestData.getLegalAccessRepresentativeKindDetail();
    }
  
    public final void setLegalAccessRepresentativeName(final String legalAccessRepresentativeName) {
        handicapCompensationAdultRequestData.setLegalAccessRepresentativeName(legalAccessRepresentativeName);
    }

    
    public final String getLegalAccessRepresentativeName() {
        return handicapCompensationAdultRequestData.getLegalAccessRepresentativeName();
    }
  
    public final void setOtherBenefits(final List<fr.cg95.cvq.business.request.social.HcarOtherBenefit> otherBenefits) {
        handicapCompensationAdultRequestData.setOtherBenefits(otherBenefits);
    }

    
    public final List<fr.cg95.cvq.business.request.social.HcarOtherBenefit> getOtherBenefits() {
        return handicapCompensationAdultRequestData.getOtherBenefits();
    }
  
    public final void setOtherFolders(final List<fr.cg95.cvq.business.request.social.HcarOtherFolder> otherFolders) {
        handicapCompensationAdultRequestData.setOtherFolders(otherFolders);
    }

    
    public final List<fr.cg95.cvq.business.request.social.HcarOtherFolder> getOtherFolders() {
        return handicapCompensationAdultRequestData.getOtherFolders();
    }
  
    public final void setPaymentAgencyAddress(final fr.cg95.cvq.business.users.Address paymentAgencyAddress) {
        handicapCompensationAdultRequestData.setPaymentAgencyAddress(paymentAgencyAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getPaymentAgencyAddress() {
        return handicapCompensationAdultRequestData.getPaymentAgencyAddress();
    }
  
    public final void setPaymentAgencyBeneficiary(final fr.cg95.cvq.business.request.social.HcarPaymentAgencyBeneficiaryType paymentAgencyBeneficiary) {
        handicapCompensationAdultRequestData.setPaymentAgencyBeneficiary(paymentAgencyBeneficiary);
    }

    
    public final fr.cg95.cvq.business.request.social.HcarPaymentAgencyBeneficiaryType getPaymentAgencyBeneficiary() {
        return handicapCompensationAdultRequestData.getPaymentAgencyBeneficiary();
    }
  
    public final void setPaymentAgencyBeneficiaryNumber(final String paymentAgencyBeneficiaryNumber) {
        handicapCompensationAdultRequestData.setPaymentAgencyBeneficiaryNumber(paymentAgencyBeneficiaryNumber);
    }

    
    public final String getPaymentAgencyBeneficiaryNumber() {
        return handicapCompensationAdultRequestData.getPaymentAgencyBeneficiaryNumber();
    }
  
    public final void setPaymentAgencyName(final String paymentAgencyName) {
        handicapCompensationAdultRequestData.setPaymentAgencyName(paymentAgencyName);
    }

    
    public final String getPaymentAgencyName() {
        return handicapCompensationAdultRequestData.getPaymentAgencyName();
    }
  
    public final void setProfessionalStatusAddress(final fr.cg95.cvq.business.users.Address professionalStatusAddress) {
        handicapCompensationAdultRequestData.setProfessionalStatusAddress(professionalStatusAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getProfessionalStatusAddress() {
        return handicapCompensationAdultRequestData.getProfessionalStatusAddress();
    }
  
    public final void setProfessionalStatusDate(final java.util.Date professionalStatusDate) {
        handicapCompensationAdultRequestData.setProfessionalStatusDate(professionalStatusDate);
    }

    
    public final java.util.Date getProfessionalStatusDate() {
        return handicapCompensationAdultRequestData.getProfessionalStatusDate();
    }
  
    public final void setProfessionalStatusElectiveFunction(final Boolean professionalStatusElectiveFunction) {
        handicapCompensationAdultRequestData.setProfessionalStatusElectiveFunction(professionalStatusElectiveFunction);
    }

    
    public final Boolean getProfessionalStatusElectiveFunction() {
        return handicapCompensationAdultRequestData.getProfessionalStatusElectiveFunction();
    }
  
    public final void setProfessionalStatusElectiveFunctionDetails(final String professionalStatusElectiveFunctionDetails) {
        handicapCompensationAdultRequestData.setProfessionalStatusElectiveFunctionDetails(professionalStatusElectiveFunctionDetails);
    }

    
    public final String getProfessionalStatusElectiveFunctionDetails() {
        return handicapCompensationAdultRequestData.getProfessionalStatusElectiveFunctionDetails();
    }
  
    public final void setProfessionalStatusEmployerName(final String professionalStatusEmployerName) {
        handicapCompensationAdultRequestData.setProfessionalStatusEmployerName(professionalStatusEmployerName);
    }

    
    public final String getProfessionalStatusEmployerName() {
        return handicapCompensationAdultRequestData.getProfessionalStatusEmployerName();
    }
  
    public final void setProfessionalStatusEnvironment(final fr.cg95.cvq.business.request.social.HcarProfessionalStatusEnvironmentType professionalStatusEnvironment) {
        handicapCompensationAdultRequestData.setProfessionalStatusEnvironment(professionalStatusEnvironment);
    }

    
    public final fr.cg95.cvq.business.request.social.HcarProfessionalStatusEnvironmentType getProfessionalStatusEnvironment() {
        return handicapCompensationAdultRequestData.getProfessionalStatusEnvironment();
    }
  
    public final void setProfessionalStatusIndemnified(final Boolean professionalStatusIndemnified) {
        handicapCompensationAdultRequestData.setProfessionalStatusIndemnified(professionalStatusIndemnified);
    }

    
    public final Boolean getProfessionalStatusIndemnified() {
        return handicapCompensationAdultRequestData.getProfessionalStatusIndemnified();
    }
  
    public final void setProfessionalStatusIndemnifiedDate(final java.util.Date professionalStatusIndemnifiedDate) {
        handicapCompensationAdultRequestData.setProfessionalStatusIndemnifiedDate(professionalStatusIndemnifiedDate);
    }

    
    public final java.util.Date getProfessionalStatusIndemnifiedDate() {
        return handicapCompensationAdultRequestData.getProfessionalStatusIndemnifiedDate();
    }
  
    public final void setProfessionalStatusKind(final fr.cg95.cvq.business.request.social.HcarProfessionalStatusKindType professionalStatusKind) {
        handicapCompensationAdultRequestData.setProfessionalStatusKind(professionalStatusKind);
    }

    
    public final fr.cg95.cvq.business.request.social.HcarProfessionalStatusKindType getProfessionalStatusKind() {
        return handicapCompensationAdultRequestData.getProfessionalStatusKind();
    }
  
    public final void setProfessionalStatusProfession(final String professionalStatusProfession) {
        handicapCompensationAdultRequestData.setProfessionalStatusProfession(professionalStatusProfession);
    }

    
    public final String getProfessionalStatusProfession() {
        return handicapCompensationAdultRequestData.getProfessionalStatusProfession();
    }
  
    public final void setProfessionalStatusRegisterAsUnemployed(final Boolean professionalStatusRegisterAsUnemployed) {
        handicapCompensationAdultRequestData.setProfessionalStatusRegisterAsUnemployed(professionalStatusRegisterAsUnemployed);
    }

    
    public final Boolean getProfessionalStatusRegisterAsUnemployed() {
        return handicapCompensationAdultRequestData.getProfessionalStatusRegisterAsUnemployed();
    }
  
    public final void setProfessionalStatusRegisterAsUnemployedDate(final java.util.Date professionalStatusRegisterAsUnemployedDate) {
        handicapCompensationAdultRequestData.setProfessionalStatusRegisterAsUnemployedDate(professionalStatusRegisterAsUnemployedDate);
    }

    
    public final java.util.Date getProfessionalStatusRegisterAsUnemployedDate() {
        return handicapCompensationAdultRequestData.getProfessionalStatusRegisterAsUnemployedDate();
    }
  
    public final void setProfessionalSupportDealsWithSameProfessional(final Boolean professionalSupportDealsWithSameProfessional) {
        handicapCompensationAdultRequestData.setProfessionalSupportDealsWithSameProfessional(professionalSupportDealsWithSameProfessional);
    }

    
    public final Boolean getProfessionalSupportDealsWithSameProfessional() {
        return handicapCompensationAdultRequestData.getProfessionalSupportDealsWithSameProfessional();
    }
  
    public final void setProfessionalSupportProfessionals(final Boolean professionalSupportProfessionals) {
        handicapCompensationAdultRequestData.setProfessionalSupportProfessionals(professionalSupportProfessionals);
    }

    
    public final Boolean getProfessionalSupportProfessionals() {
        return handicapCompensationAdultRequestData.getProfessionalSupportProfessionals();
    }
  
    public final void setProfessionalSupportSocialServiceAddress(final fr.cg95.cvq.business.users.Address professionalSupportSocialServiceAddress) {
        handicapCompensationAdultRequestData.setProfessionalSupportSocialServiceAddress(professionalSupportSocialServiceAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getProfessionalSupportSocialServiceAddress() {
        return handicapCompensationAdultRequestData.getProfessionalSupportSocialServiceAddress();
    }
  
    public final void setProfessionalSupportSocialServiceName(final String professionalSupportSocialServiceName) {
        handicapCompensationAdultRequestData.setProfessionalSupportSocialServiceName(professionalSupportSocialServiceName);
    }

    
    public final String getProfessionalSupportSocialServiceName() {
        return handicapCompensationAdultRequestData.getProfessionalSupportSocialServiceName();
    }
  
    public final void setProfessionalSupportSocialServiceSupport(final Boolean professionalSupportSocialServiceSupport) {
        handicapCompensationAdultRequestData.setProfessionalSupportSocialServiceSupport(professionalSupportSocialServiceSupport);
    }

    
    public final Boolean getProfessionalSupportSocialServiceSupport() {
        return handicapCompensationAdultRequestData.getProfessionalSupportSocialServiceSupport();
    }
  
    public final void setProfessionals(final List<fr.cg95.cvq.business.request.social.HcarProfessional> professionals) {
        handicapCompensationAdultRequestData.setProfessionals(professionals);
    }

    
    public final List<fr.cg95.cvq.business.request.social.HcarProfessional> getProfessionals() {
        return handicapCompensationAdultRequestData.getProfessionals();
    }
  
    public final void setProjectComments(final String projectComments) {
        handicapCompensationAdultRequestData.setProjectComments(projectComments);
    }

    
    public final String getProjectComments() {
        return handicapCompensationAdultRequestData.getProjectComments();
    }
  
    public final void setProjectNeeds(final String projectNeeds) {
        handicapCompensationAdultRequestData.setProjectNeeds(projectNeeds);
    }

    
    public final String getProjectNeeds() {
        return handicapCompensationAdultRequestData.getProjectNeeds();
    }
  
    public final void setProjectRequestsACTPRenewal(final Boolean projectRequestsACTPRenewal) {
        handicapCompensationAdultRequestData.setProjectRequestsACTPRenewal(projectRequestsACTPRenewal);
    }

    
    public final Boolean getProjectRequestsACTPRenewal() {
        return handicapCompensationAdultRequestData.getProjectRequestsACTPRenewal();
    }
  
    public final void setProjectRequestsAssistance(final Boolean projectRequestsAssistance) {
        handicapCompensationAdultRequestData.setProjectRequestsAssistance(projectRequestsAssistance);
    }

    
    public final Boolean getProjectRequestsAssistance() {
        return handicapCompensationAdultRequestData.getProjectRequestsAssistance();
    }
  
    public final void setProjectRequestsCustomCar(final Boolean projectRequestsCustomCar) {
        handicapCompensationAdultRequestData.setProjectRequestsCustomCar(projectRequestsCustomCar);
    }

    
    public final Boolean getProjectRequestsCustomCar() {
        return handicapCompensationAdultRequestData.getProjectRequestsCustomCar();
    }
  
    public final void setProjectRequestsDisabilityCard(final Boolean projectRequestsDisabilityCard) {
        handicapCompensationAdultRequestData.setProjectRequestsDisabilityCard(projectRequestsDisabilityCard);
    }

    
    public final Boolean getProjectRequestsDisabilityCard() {
        return handicapCompensationAdultRequestData.getProjectRequestsDisabilityCard();
    }
  
    public final void setProjectRequestsDisabilityCostAllocation(final Boolean projectRequestsDisabilityCostAllocation) {
        handicapCompensationAdultRequestData.setProjectRequestsDisabilityCostAllocation(projectRequestsDisabilityCostAllocation);
    }

    
    public final Boolean getProjectRequestsDisabilityCostAllocation() {
        return handicapCompensationAdultRequestData.getProjectRequestsDisabilityCostAllocation();
    }
  
    public final void setProjectRequestsDisabledAdultAllowance(final Boolean projectRequestsDisabledAdultAllowance) {
        handicapCompensationAdultRequestData.setProjectRequestsDisabledAdultAllowance(projectRequestsDisabledAdultAllowance);
    }

    
    public final Boolean getProjectRequestsDisabledAdultAllowance() {
        return handicapCompensationAdultRequestData.getProjectRequestsDisabledAdultAllowance();
    }
  
    public final void setProjectRequestsDisabledPriorityCard(final Boolean projectRequestsDisabledPriorityCard) {
        handicapCompensationAdultRequestData.setProjectRequestsDisabledPriorityCard(projectRequestsDisabledPriorityCard);
    }

    
    public final Boolean getProjectRequestsDisabledPriorityCard() {
        return handicapCompensationAdultRequestData.getProjectRequestsDisabledPriorityCard();
    }
  
    public final void setProjectRequestsDisabledWorkerRecognition(final Boolean projectRequestsDisabledWorkerRecognition) {
        handicapCompensationAdultRequestData.setProjectRequestsDisabledWorkerRecognition(projectRequestsDisabledWorkerRecognition);
    }

    
    public final Boolean getProjectRequestsDisabledWorkerRecognition() {
        return handicapCompensationAdultRequestData.getProjectRequestsDisabledWorkerRecognition();
    }
  
    public final void setProjectRequestsEducationAllocationOfDisabledChildren(final Boolean projectRequestsEducationAllocationOfDisabledChildren) {
        handicapCompensationAdultRequestData.setProjectRequestsEducationAllocationOfDisabledChildren(projectRequestsEducationAllocationOfDisabledChildren);
    }

    
    public final Boolean getProjectRequestsEducationAllocationOfDisabledChildren() {
        return handicapCompensationAdultRequestData.getProjectRequestsEducationAllocationOfDisabledChildren();
    }
  
    public final void setProjectRequestsEuropeanParkingCard(final Boolean projectRequestsEuropeanParkingCard) {
        handicapCompensationAdultRequestData.setProjectRequestsEuropeanParkingCard(projectRequestsEuropeanParkingCard);
    }

    
    public final Boolean getProjectRequestsEuropeanParkingCard() {
        return handicapCompensationAdultRequestData.getProjectRequestsEuropeanParkingCard();
    }
  
    public final void setProjectRequestsFreePensionMembership(final Boolean projectRequestsFreePensionMembership) {
        handicapCompensationAdultRequestData.setProjectRequestsFreePensionMembership(projectRequestsFreePensionMembership);
    }

    
    public final Boolean getProjectRequestsFreePensionMembership() {
        return handicapCompensationAdultRequestData.getProjectRequestsFreePensionMembership();
    }
  
    public final void setProjectRequestsHandicapRecognition(final Boolean projectRequestsHandicapRecognition) {
        handicapCompensationAdultRequestData.setProjectRequestsHandicapRecognition(projectRequestsHandicapRecognition);
    }

    
    public final Boolean getProjectRequestsHandicapRecognition() {
        return handicapCompensationAdultRequestData.getProjectRequestsHandicapRecognition();
    }
  
    public final void setProjectRequestsHousingFacilities(final Boolean projectRequestsHousingFacilities) {
        handicapCompensationAdultRequestData.setProjectRequestsHousingFacilities(projectRequestsHousingFacilities);
    }

    
    public final Boolean getProjectRequestsHousingFacilities() {
        return handicapCompensationAdultRequestData.getProjectRequestsHousingFacilities();
    }
  
    public final void setProjectRequestsIncreaseForIndependentLiving(final Boolean projectRequestsIncreaseForIndependentLiving) {
        handicapCompensationAdultRequestData.setProjectRequestsIncreaseForIndependentLiving(projectRequestsIncreaseForIndependentLiving);
    }

    
    public final Boolean getProjectRequestsIncreaseForIndependentLiving() {
        return handicapCompensationAdultRequestData.getProjectRequestsIncreaseForIndependentLiving();
    }
  
    public final void setProjectRequestsInstitutionSupport(final Boolean projectRequestsInstitutionSupport) {
        handicapCompensationAdultRequestData.setProjectRequestsInstitutionSupport(projectRequestsInstitutionSupport);
    }

    
    public final Boolean getProjectRequestsInstitutionSupport() {
        return handicapCompensationAdultRequestData.getProjectRequestsInstitutionSupport();
    }
  
    public final void setProjectRequestsOrdinaryWorking(final Boolean projectRequestsOrdinaryWorking) {
        handicapCompensationAdultRequestData.setProjectRequestsOrdinaryWorking(projectRequestsOrdinaryWorking);
    }

    
    public final Boolean getProjectRequestsOrdinaryWorking() {
        return handicapCompensationAdultRequestData.getProjectRequestsOrdinaryWorking();
    }
  
    public final void setProjectRequestsOther(final Boolean projectRequestsOther) {
        handicapCompensationAdultRequestData.setProjectRequestsOther(projectRequestsOther);
    }

    
    public final Boolean getProjectRequestsOther() {
        return handicapCompensationAdultRequestData.getProjectRequestsOther();
    }
  
    public final void setProjectRequestsOtherDetails(final String projectRequestsOtherDetails) {
        handicapCompensationAdultRequestData.setProjectRequestsOtherDetails(projectRequestsOtherDetails);
    }

    
    public final String getProjectRequestsOtherDetails() {
        return handicapCompensationAdultRequestData.getProjectRequestsOtherDetails();
    }
  
    public final void setProjectRequestsProfessionalOrientation(final Boolean projectRequestsProfessionalOrientation) {
        handicapCompensationAdultRequestData.setProjectRequestsProfessionalOrientation(projectRequestsProfessionalOrientation);
    }

    
    public final Boolean getProjectRequestsProfessionalOrientation() {
        return handicapCompensationAdultRequestData.getProjectRequestsProfessionalOrientation();
    }
  
    public final void setProjectRequestsShelteredWork(final Boolean projectRequestsShelteredWork) {
        handicapCompensationAdultRequestData.setProjectRequestsShelteredWork(projectRequestsShelteredWork);
    }

    
    public final Boolean getProjectRequestsShelteredWork() {
        return handicapCompensationAdultRequestData.getProjectRequestsShelteredWork();
    }
  
    public final void setProjectRequestsTechnicalHelp(final Boolean projectRequestsTechnicalHelp) {
        handicapCompensationAdultRequestData.setProjectRequestsTechnicalHelp(projectRequestsTechnicalHelp);
    }

    
    public final Boolean getProjectRequestsTechnicalHelp() {
        return handicapCompensationAdultRequestData.getProjectRequestsTechnicalHelp();
    }
  
    public final void setProjectRequestsThirdPartyHelp(final Boolean projectRequestsThirdPartyHelp) {
        handicapCompensationAdultRequestData.setProjectRequestsThirdPartyHelp(projectRequestsThirdPartyHelp);
    }

    
    public final Boolean getProjectRequestsThirdPartyHelp() {
        return handicapCompensationAdultRequestData.getProjectRequestsThirdPartyHelp();
    }
  
    public final void setProjectRequestsTransportCostAllocation(final Boolean projectRequestsTransportCostAllocation) {
        handicapCompensationAdultRequestData.setProjectRequestsTransportCostAllocation(projectRequestsTransportCostAllocation);
    }

    
    public final Boolean getProjectRequestsTransportCostAllocation() {
        return handicapCompensationAdultRequestData.getProjectRequestsTransportCostAllocation();
    }
  
    public final void setProjectRequestsVocationalTraining(final Boolean projectRequestsVocationalTraining) {
        handicapCompensationAdultRequestData.setProjectRequestsVocationalTraining(projectRequestsVocationalTraining);
    }

    
    public final Boolean getProjectRequestsVocationalTraining() {
        return handicapCompensationAdultRequestData.getProjectRequestsVocationalTraining();
    }
  
    public final void setProjectWish(final String projectWish) {
        handicapCompensationAdultRequestData.setProjectWish(projectWish);
    }

    
    public final String getProjectWish() {
        return handicapCompensationAdultRequestData.getProjectWish();
    }
  
    public final void setSocialSecurityAgencyAddress(final fr.cg95.cvq.business.users.Address socialSecurityAgencyAddress) {
        handicapCompensationAdultRequestData.setSocialSecurityAgencyAddress(socialSecurityAgencyAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getSocialSecurityAgencyAddress() {
        return handicapCompensationAdultRequestData.getSocialSecurityAgencyAddress();
    }
  
    public final void setSocialSecurityAgencyName(final String socialSecurityAgencyName) {
        handicapCompensationAdultRequestData.setSocialSecurityAgencyName(socialSecurityAgencyName);
    }

    
    public final String getSocialSecurityAgencyName() {
        return handicapCompensationAdultRequestData.getSocialSecurityAgencyName();
    }
  
    public final void setSocialSecurityMemberShipKind(final fr.cg95.cvq.business.request.social.HcarSocialSecurityMemberShipKindType socialSecurityMemberShipKind) {
        handicapCompensationAdultRequestData.setSocialSecurityMemberShipKind(socialSecurityMemberShipKind);
    }

    
    public final fr.cg95.cvq.business.request.social.HcarSocialSecurityMemberShipKindType getSocialSecurityMemberShipKind() {
        return handicapCompensationAdultRequestData.getSocialSecurityMemberShipKind();
    }
  
    public final void setSocialSecurityNumber(final String socialSecurityNumber) {
        handicapCompensationAdultRequestData.setSocialSecurityNumber(socialSecurityNumber);
    }

    
    public final String getSocialSecurityNumber() {
        return handicapCompensationAdultRequestData.getSocialSecurityNumber();
    }
  
    public final void setStudiesAssistanceUnderDisability(final Boolean studiesAssistanceUnderDisability) {
        handicapCompensationAdultRequestData.setStudiesAssistanceUnderDisability(studiesAssistanceUnderDisability);
    }

    
    public final Boolean getStudiesAssistanceUnderDisability() {
        return handicapCompensationAdultRequestData.getStudiesAssistanceUnderDisability();
    }
  
    public final void setStudiesAssistanceUnderDisabilityDetails(final String studiesAssistanceUnderDisabilityDetails) {
        handicapCompensationAdultRequestData.setStudiesAssistanceUnderDisabilityDetails(studiesAssistanceUnderDisabilityDetails);
    }

    
    public final String getStudiesAssistanceUnderDisabilityDetails() {
        return handicapCompensationAdultRequestData.getStudiesAssistanceUnderDisabilityDetails();
    }
  
    public final void setStudiesHighSchool(final Boolean studiesHighSchool) {
        handicapCompensationAdultRequestData.setStudiesHighSchool(studiesHighSchool);
    }

    
    public final Boolean getStudiesHighSchool() {
        return handicapCompensationAdultRequestData.getStudiesHighSchool();
    }
  
    public final void setStudiesHighSchoolAddress(final fr.cg95.cvq.business.users.Address studiesHighSchoolAddress) {
        handicapCompensationAdultRequestData.setStudiesHighSchoolAddress(studiesHighSchoolAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getStudiesHighSchoolAddress() {
        return handicapCompensationAdultRequestData.getStudiesHighSchoolAddress();
    }
  
    public final void setStudiesHighSchoolGrade(final String studiesHighSchoolGrade) {
        handicapCompensationAdultRequestData.setStudiesHighSchoolGrade(studiesHighSchoolGrade);
    }

    
    public final String getStudiesHighSchoolGrade() {
        return handicapCompensationAdultRequestData.getStudiesHighSchoolGrade();
    }
  
    public final void setStudiesHighSchoolName(final String studiesHighSchoolName) {
        handicapCompensationAdultRequestData.setStudiesHighSchoolName(studiesHighSchoolName);
    }

    
    public final String getStudiesHighSchoolName() {
        return handicapCompensationAdultRequestData.getStudiesHighSchoolName();
    }
  
    public final void setSubjectBirthCity(final String subjectBirthCity) {
        handicapCompensationAdultRequestData.setSubjectBirthCity(subjectBirthCity);
    }

    
    public final String getSubjectBirthCity() {
        return handicapCompensationAdultRequestData.getSubjectBirthCity();
    }
  
    public final void setSubjectBirthCountry(final String subjectBirthCountry) {
        handicapCompensationAdultRequestData.setSubjectBirthCountry(subjectBirthCountry);
    }

    
    public final String getSubjectBirthCountry() {
        return handicapCompensationAdultRequestData.getSubjectBirthCountry();
    }
  
    public final void setSubjectBirthDate(final java.util.Date subjectBirthDate) {
        handicapCompensationAdultRequestData.setSubjectBirthDate(subjectBirthDate);
    }

    
    public final java.util.Date getSubjectBirthDate() {
        return handicapCompensationAdultRequestData.getSubjectBirthDate();
    }
  
    public final void setSubjectMaidenName(final String subjectMaidenName) {
        handicapCompensationAdultRequestData.setSubjectMaidenName(subjectMaidenName);
    }

    
    public final String getSubjectMaidenName() {
        return handicapCompensationAdultRequestData.getSubjectMaidenName();
    }
  
    public final void setSubjectTitle(final fr.cg95.cvq.business.users.TitleType subjectTitle) {
        handicapCompensationAdultRequestData.setSubjectTitle(subjectTitle);
    }

    
    public final fr.cg95.cvq.business.users.TitleType getSubjectTitle() {
        return handicapCompensationAdultRequestData.getSubjectTitle();
    }
  
}
