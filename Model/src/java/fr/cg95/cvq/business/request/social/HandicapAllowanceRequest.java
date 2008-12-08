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
 *  table="handicap_allowance_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class HandicapAllowanceRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public HandicapAllowanceRequest() {
        super();
        harDisabilityRecognition = Boolean.valueOf(false);
        harAdditionalAllocationForEducationOfDisabledChildren = Boolean.valueOf(false);
        harDisabilityPension = Boolean.valueOf(false);
        harDisabilityCard = Boolean.valueOf(false);
        harFreePensionMembershipRequest = Boolean.valueOf(false);
        harFollowedByPhysician = Boolean.valueOf(false);
        harOtherRequest = Boolean.valueOf(false);
        harParkingCard = Boolean.valueOf(false);
        harCompensatoryAllowanceForExpenses = Boolean.valueOf(false);
        harDisabledWorkerRecognition = Boolean.valueOf(false);
        harTechnicalHelpRequest = Boolean.valueOf(false);
        harIsCareAssistant = Boolean.valueOf(false);
        harDailyAllowances = Boolean.valueOf(false);
        harPTCARenewalRequest = Boolean.valueOf(false);
        harSupportedByAnInstitution = Boolean.valueOf(false);
        harVocationalTrainingRequest = Boolean.valueOf(false);
        harDisabledWorkerRecognitionRequest = Boolean.valueOf(false);
        harTransportCostAllocationRequest = Boolean.valueOf(false);
        harDisabilityCompensation = Boolean.valueOf(false);
        harIsFamilyCarer = Boolean.valueOf(false);
        harIsCarer = Boolean.valueOf(false);
        harProfessionalOrientation = Boolean.valueOf(false);
        harOrdinaryworkingRequest = Boolean.valueOf(false);
        harIncreaseForIndependentLivingRequest = Boolean.valueOf(false);
        harDisabledPriorityCardRequest = Boolean.valueOf(false);
        familyHasFamilyDependents = Boolean.valueOf(false);
        harSupplementForSingleParents = Boolean.valueOf(false);
        harFollowedByProfessional = Boolean.valueOf(false);
        harShelteredWorkRequest = Boolean.valueOf(false);
        harDisabledAdultAllowanceRequest = Boolean.valueOf(false);
        harDisabledAdultAllocation = Boolean.valueOf(false);
        harThridPartySupplement = Boolean.valueOf(false);
        harDisabilityCardRequest = Boolean.valueOf(false);
        harProfessionalEvaluation = Boolean.valueOf(false);
        harEducationAllocationOfDisabledChildrenRequest = Boolean.valueOf(false);
        harLessThan20RequesterRepresentativeActivityReduction = Boolean.valueOf(false);
        harThridPartyCompensatoryAllowance = Boolean.valueOf(false);
        harEducationAllocationOfDisabledChildren = Boolean.valueOf(false);
        harThridPersonCompensatoryAllowance = Boolean.valueOf(false);
        harCustomCarRequest = Boolean.valueOf(false);
        harProfessionalOrientationRequest = Boolean.valueOf(false);
        harFollowedByHospital = Boolean.valueOf(false);
        harIncreaseForIndependentLiving = Boolean.valueOf(false);
        harDisabilityCostAllocationRequest = Boolean.valueOf(false);
        harEuropeanParkingCardRequest = Boolean.valueOf(false);
        harWorkAccidentAnnuity = Boolean.valueOf(false);
        harUnemploymentBenefits = Boolean.valueOf(false);
        harHousingFacilitiesRequest = Boolean.valueOf(false);
        harAssistanceRequest = Boolean.valueOf(false);
        harSocialWelfare = Boolean.valueOf(false);
        harInstitutionSupportRequest = Boolean.valueOf(false);
        harThirdPartyHelpRequest = Boolean.valueOf(false);
        harDisabilityRecognitionRequest = Boolean.valueOf(false);
        harRequestDealWithSameProfessional = Boolean.valueOf(false);
        harPainfulStandingCard = Boolean.valueOf(false);
    }


    public final String modelToXmlString() {

        HandicapAllowanceRequestDocument object = (HandicapAllowanceRequestDocument) this.modelToXml();
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
        HandicapAllowanceRequestDocument handicapAllowanceRequestDoc = HandicapAllowanceRequestDocument.Factory.newInstance();
        HandicapAllowanceRequestDocument.HandicapAllowanceRequest handicapAllowanceRequest = handicapAllowanceRequestDoc.addNewHandicapAllowanceRequest();
        super.fillCommonXmlInfo(handicapAllowanceRequest);
        HarLessThan20RequesterType harLessThan20RequesterTypeHarLessThan20Requester = handicapAllowanceRequest.addNewHarLessThan20Requester();
        if (this.harLessThan20RequesterGender != null)
            harLessThan20RequesterTypeHarLessThan20Requester.setHarLessThan20RequesterGender(fr.cg95.cvq.xml.request.social.HarGenderType.Enum.forString(this.harLessThan20RequesterGender.toString()));
        int i = 0;
        if (harDisabilityRelatedCost != null) {
            fr.cg95.cvq.xml.request.social.HarDisabilityRelatedCostType[] harDisabilityRelatedCostTypeTab = new fr.cg95.cvq.xml.request.social.HarDisabilityRelatedCostType[harDisabilityRelatedCost.size()];
            Iterator harDisabilityRelatedCostIt = harDisabilityRelatedCost.iterator();
            while (harDisabilityRelatedCostIt.hasNext()) {
                HarDisabilityRelatedCost object = (HarDisabilityRelatedCost) harDisabilityRelatedCostIt.next();
                harDisabilityRelatedCostTypeTab[i] = (HarDisabilityRelatedCostType) object.modelToXml();
                i = i + 1;
            }
            handicapAllowanceRequest.setHarDisabilityRelatedCostArray(harDisabilityRelatedCostTypeTab);
        }
        HarPaymentAgencyType harPaymentAgencyTypeHarPaymentAgency = handicapAllowanceRequest.addNewHarPaymentAgency();
        harPaymentAgencyTypeHarPaymentAgency.setHarPaymentAgencyBeneficiaryNumber(this.harPaymentAgencyBeneficiaryNumber);
        HarFormationType harFormationTypeHarFormation = handicapAllowanceRequest.addNewHarFormation();
        harFormationTypeHarFormation.setHarPreviousFormation(this.harPreviousFormation);
        HarDisabilityFollowUpType harDisabilityFollowUpTypeHarFollowUp = handicapAllowanceRequest.addNewHarFollowUp();
        if (this.harFollowUp != null)
            harDisabilityFollowUpTypeHarFollowUp.setHarFollowUp(this.harFollowUp.booleanValue());
        HarRequesterLegalAccessType harRequesterLegalAccessTypeHarRequesterLegalAccess = handicapAllowanceRequest.addNewHarRequesterLegalAccess();
        if (this.harLegalAccessPresence != null)
            harRequesterLegalAccessTypeHarRequesterLegalAccess.setHarLegalAccessPresence(this.harLegalAccessPresence.booleanValue());
        HarSocialSecurityType harSocialSecurityTypeHarSocialSecurity = handicapAllowanceRequest.addNewHarSocialSecurity();
        harSocialSecurityTypeHarSocialSecurity.setHarSocialSecurityAgencyName(this.harSocialSecurityAgencyName);
        HarRequesterType harRequesterTypeHarRequesterReferent = handicapAllowanceRequest.addNewHarRequesterReferent();
        harRequesterTypeHarRequesterReferent.setHarRequesterCity(this.harRequesterCity);
        i = 0;
        if (harProfessional != null) {
            fr.cg95.cvq.xml.request.social.HarProfessionalType[] harProfessionalTypeTab = new fr.cg95.cvq.xml.request.social.HarProfessionalType[harProfessional.size()];
            Iterator harProfessionalIt = harProfessional.iterator();
            while (harProfessionalIt.hasNext()) {
                HarProfessional object = (HarProfessional) harProfessionalIt.next();
                harProfessionalTypeTab[i] = (HarProfessionalType) object.modelToXml();
                i = i + 1;
            }
            handicapAllowanceRequest.setHarProfessionalArray(harProfessionalTypeTab);
        }
        HarBenefitsType harBenefitsTypeHarBenefits = handicapAllowanceRequest.addNewHarBenefits();
        if (this.harDisabilityRecognition != null)
            harBenefitsTypeHarBenefits.setHarDisabilityRecognition(this.harDisabilityRecognition.booleanValue());
        if (this.harAdditionalAllocationForEducationOfDisabledChildren != null)
            harBenefitsTypeHarBenefits.setHarAdditionalAllocationForEducationOfDisabledChildren(this.harAdditionalAllocationForEducationOfDisabledChildren.booleanValue());
        HarLessThan20RequesterRepresentativeType harLessThan20RequesterRepresentativeTypeHarLessThan20RequesterRepresentative = handicapAllowanceRequest.addNewHarLessThan20RequesterRepresentative();
        harLessThan20RequesterRepresentativeTypeHarLessThan20RequesterRepresentative.setHarLessThan20RequesterRepresentativeFirstName(this.harLessThan20RequesterRepresentativeFirstName);
        if (this.harDisabilityPension != null)
            harBenefitsTypeHarBenefits.setHarDisabilityPension(this.harDisabilityPension.booleanValue());
        if (this.harDisabilityCard != null)
            harBenefitsTypeHarBenefits.setHarDisabilityCard(this.harDisabilityCard.booleanValue());
        HarProjectRequestType harProjectRequestTypeHarProjectRequest = handicapAllowanceRequest.addNewHarProjectRequest();
        if (this.harFreePensionMembershipRequest != null)
            harProjectRequestTypeHarProjectRequest.setHarFreePensionMembershipRequest(this.harFreePensionMembershipRequest.booleanValue());
        if (this.harLessThan20RequesterAuthorityHolder != null)
            handicapAllowanceRequest.setHarLessThan20RequesterAuthorityHolder(fr.cg95.cvq.xml.request.social.HarLessThan20RequesterAuthorityHolderType.Enum.forString(this.harLessThan20RequesterAuthorityHolder.toString()));
        HarFacilitiesType harFacilitiesTypeHarFacilities = handicapAllowanceRequest.addNewHarFacilities();
        harFacilitiesTypeHarFacilities.setHarHousingFacilitiesDetails(this.harHousingFacilitiesDetails);
        if (this.harSpecializedTransport != null)
            harFacilitiesTypeHarFacilities.setHarSpecializedTransport(this.harSpecializedTransport.booleanValue());
        harSocialSecurityTypeHarSocialSecurity.setHarSocialSecurityAgencyPostalCode(this.harSocialSecurityAgencyPostalCode);
        HarSchoolingType harSchoolingTypeHarSchooling = handicapAllowanceRequest.addNewHarSchooling();
        harSchoolingTypeHarSchooling.setHarSchoolAddress(this.harSchoolAddress);
        harSchoolingTypeHarSchooling.setHarAttendedGrade(this.harAttendedGrade);
        if (this.harHousingFacilities != null)
            harFacilitiesTypeHarFacilities.setHarHousingFacilities(this.harHousingFacilities.booleanValue());
        if (this.harHomeSchooling != null)
            harSchoolingTypeHarSchooling.setHarHomeSchooling(this.harHomeSchooling.booleanValue());
        HarCareFollowUpType harCareFollowUpTypeHarCareFollowUp = handicapAllowanceRequest.addNewHarCareFollowUp();
        if (this.harFollowedByPhysician != null)
            harCareFollowUpTypeHarCareFollowUp.setHarFollowedByPhysician(this.harFollowedByPhysician.booleanValue());
        HarDwellingType harDwellingTypeHarDwelling = handicapAllowanceRequest.addNewHarDwelling();
        harDwellingTypeHarDwelling.setHarDwellingSocialReceptionCity(this.harDwellingSocialReceptionCity);
        if (this.harOtherRequest != null)
            harProjectRequestTypeHarProjectRequest.setHarOtherRequest(this.harOtherRequest.booleanValue());
        if (this.harParkingCard != null)
            harBenefitsTypeHarBenefits.setHarParkingCard(this.harParkingCard.booleanValue());
        HarFamilyType harFamilyTypeHarFamily = handicapAllowanceRequest.addNewHarFamily();
        if (this.familyStatus != null)
            harFamilyTypeHarFamily.setFamilyStatus(fr.cg95.cvq.xml.request.social.HarFamilyStatusType.Enum.forString(this.familyStatus.toString()));
        HarLessThan20RequesterWelfareReferentType harLessThan20RequesterWelfareReferentTypeHarLessThan20RequesterWelfareReferent = handicapAllowanceRequest.addNewHarLessThan20RequesterWelfareReferent();
        harLessThan20RequesterWelfareReferentTypeHarLessThan20RequesterWelfareReferent.setHarLessThan20RequesterRepresentativeDepartment(this.harLessThan20RequesterRepresentativeDepartment);
        harFacilitiesTypeHarFacilities.setHarSpecializedTransportDetails(this.harSpecializedTransportDetails);
        harLessThan20RequesterRepresentativeTypeHarLessThan20RequesterRepresentative.setHarLessThan20RequesterRepresentativeCity(this.harLessThan20RequesterRepresentativeCity);
        harRequesterTypeHarRequesterReferent.setHarRequesterBirthCity(this.harRequesterBirthCity);
        HarProfessionalStatusType harProfessionalStatusTypeHarProfessionalStatus = handicapAllowanceRequest.addNewHarProfessionalStatus();
        harProfessionalStatusTypeHarProfessionalStatus.setHarProfessionalStatusProfession(this.harProfessionalStatusProfession);
        HarCDESFilesType harCDESFilesTypeHarCDESFiles = handicapAllowanceRequest.addNewHarCDESFiles();
        harCDESFilesTypeHarCDESFiles.setHarCDESDepartment(this.harCDESDepartment);
        if (this.harCompensatoryAllowanceForExpenses != null)
            harBenefitsTypeHarBenefits.setHarCompensatoryAllowanceForExpenses(this.harCompensatoryAllowanceForExpenses.booleanValue());
        harPaymentAgencyTypeHarPaymentAgency.setHarPaymentAgencyAddress(this.harPaymentAgencyAddress);
        harLessThan20RequesterRepresentativeTypeHarLessThan20RequesterRepresentative.setHarLessThan20RequesterRepresentativeStreetName(this.harLessThan20RequesterRepresentativeStreetName);
        if (this.harCDESFile != null)
            harCDESFilesTypeHarCDESFiles.setHarCDESFile(this.harCDESFile.booleanValue());
        harCareFollowUpTypeHarCareFollowUp.setHarFollowedByPhysicianDetails(this.harFollowedByPhysicianDetails);
        harLessThan20RequesterTypeHarLessThan20Requester.setHarLessThan20RequesterCity(this.harLessThan20RequesterCity);
        harFormationTypeHarFormation.setHarCurrentFormation(this.harCurrentFormation);
        i = 0;
        if (harCareAssistant != null) {
            fr.cg95.cvq.xml.request.social.HarCareAssistantType[] harCareAssistantTypeTab = new fr.cg95.cvq.xml.request.social.HarCareAssistantType[harCareAssistant.size()];
            Iterator harCareAssistantIt = harCareAssistant.iterator();
            while (harCareAssistantIt.hasNext()) {
                HarCareAssistant object = (HarCareAssistant) harCareAssistantIt.next();
                harCareAssistantTypeTab[i] = (HarCareAssistantType) object.modelToXml();
                i = i + 1;
            }
            handicapAllowanceRequest.setHarCareAssistantArray(harCareAssistantTypeTab);
        }
        harLessThan20RequesterWelfareReferentTypeHarLessThan20RequesterWelfareReferent.setHarLessThan20RequesterRepresentativeName(this.harLessThan20RequesterRepresentativeName);
        HarLessThan20RequesterParentType harLessThan20RequesterParentTypeHarLessThan20RequesterMother = handicapAllowanceRequest.addNewHarLessThan20RequesterMother();
        harLessThan20RequesterParentTypeHarLessThan20RequesterMother.setHarLessThan20RequesterParentFirstName(this.harLessThan20RequesterParentFirstName);
        HarCOTOREPFilesType harCOTOREPFilesTypeHarCOTOREPFiles = handicapAllowanceRequest.addNewHarCOTOREPFiles();
        harCOTOREPFilesTypeHarCOTOREPFiles.setHarCOTOREPNumber(this.harCOTOREPNumber);
        if (this.harDisabledWorkerRecognition != null)
            harBenefitsTypeHarBenefits.setHarDisabledWorkerRecognition(this.harDisabledWorkerRecognition.booleanValue());
        HarStudiesType harStudiesTypeHarStudies = handicapAllowanceRequest.addNewHarStudies();
        harStudiesTypeHarStudies.setHarHighSchoolCity(this.harHighSchoolCity);
        if (this.harTechnicalHelpRequest != null)
            harProjectRequestTypeHarProjectRequest.setHarTechnicalHelpRequest(this.harTechnicalHelpRequest.booleanValue());
        harCareFollowUpTypeHarCareFollowUp.setHarFollowedByHospitalDetails(this.harFollowedByHospitalDetails);
        handicapAllowanceRequest.setHarProjectNeeds(this.harProjectNeeds);
        harFacilitiesTypeHarFacilities.setHarTechnicalAssistanceDetails(this.harTechnicalAssistanceDetails);
        harCDESFilesTypeHarCDESFiles.setHarCDESNumber(this.harCDESNumber);
        harStudiesTypeHarStudies.setHarHighSchoolGrade(this.harHighSchoolGrade);
        if (this.harHighSchool != null)
            harStudiesTypeHarStudies.setHarHighSchool(this.harHighSchool.booleanValue());
        harSchoolingTypeHarSchooling.setHarSchoolName(this.harSchoolName);
        harLessThan20RequesterTypeHarLessThan20Requester.setHarLessThan20RequesterName(this.harLessThan20RequesterName);
        harRequesterLegalAccessTypeHarRequesterLegalAccess.setHarLegalAccessRepresentativeKindDetail(this.harLegalAccessRepresentativeKindDetail);
        harSchoolingTypeHarSchooling.setHarHomeSchoolingAccompanistFirstName(this.harHomeSchoolingAccompanistFirstName);
        harStudiesTypeHarStudies.setHarHighSchoolPostalCode(this.harHighSchoolPostalCode);
        if (this.harRequestInformationProfile != null)
            handicapAllowanceRequest.setHarRequestInformationProfile(fr.cg95.cvq.xml.request.social.HarRequestInformationProfileType.Enum.forString(this.harRequestInformationProfile.toString()));
        if (this.harIndemnified != null)
            harProfessionalStatusTypeHarProfessionalStatus.setHarIndemnified(this.harIndemnified.booleanValue());
        harProjectRequestTypeHarProjectRequest.setHarOtherRequestDetails(this.harOtherRequestDetails);
        harStudiesTypeHarStudies.setHarHighSchoolAddress(this.harHighSchoolAddress);
        if (this.harIsCareAssistant != null)
            handicapAllowanceRequest.setHarIsCareAssistant(this.harIsCareAssistant.booleanValue());
        harRequesterLegalAccessTypeHarRequesterLegalAccess.setHarLegalAccessRepresentativePostalCode(this.harLegalAccessRepresentativePostalCode);
        if (this.harCOTOREPFile != null)
            harCOTOREPFilesTypeHarCOTOREPFiles.setHarCOTOREPFile(this.harCOTOREPFile.booleanValue());
        if (this.harDailyAllowances != null)
            harBenefitsTypeHarBenefits.setHarDailyAllowances(this.harDailyAllowances.booleanValue());
        harLessThan20RequesterTypeHarLessThan20Requester.setHarLessThan20RequesterBirthCity(this.harLessThan20RequesterBirthCity);
        if (this.harSocialSecurityMemberShipKind != null)
            harSocialSecurityTypeHarSocialSecurity.setHarSocialSecurityMemberShipKind(fr.cg95.cvq.xml.request.social.HarSocialSecurityMemberShipKindType.Enum.forString(this.harSocialSecurityMemberShipKind.toString()));
        harSocialSecurityTypeHarSocialSecurity.setHarSocialSecurityNumber(this.harSocialSecurityNumber);
        i = 0;
        if (harFamilyCarer != null) {
            fr.cg95.cvq.xml.request.social.HarFamilyCarerType[] harFamilyCarerTypeTab = new fr.cg95.cvq.xml.request.social.HarFamilyCarerType[harFamilyCarer.size()];
            Iterator harFamilyCarerIt = harFamilyCarer.iterator();
            while (harFamilyCarerIt.hasNext()) {
                HarFamilyCarer object = (HarFamilyCarer) harFamilyCarerIt.next();
                harFamilyCarerTypeTab[i] = (HarFamilyCarerType) object.modelToXml();
                i = i + 1;
            }
            handicapAllowanceRequest.setHarFamilyCarerArray(harFamilyCarerTypeTab);
        }
        i = 0;
        if (harFamilyDependent != null) {
            fr.cg95.cvq.xml.request.social.HarFamilyDependentType[] harFamilyDependentTypeTab = new fr.cg95.cvq.xml.request.social.HarFamilyDependentType[harFamilyDependent.size()];
            Iterator harFamilyDependentIt = harFamilyDependent.iterator();
            while (harFamilyDependentIt.hasNext()) {
                HarFamilyDependent object = (HarFamilyDependent) harFamilyDependentIt.next();
                harFamilyDependentTypeTab[i] = (HarFamilyDependentType) object.modelToXml();
                i = i + 1;
            }
            handicapAllowanceRequest.setHarFamilyDependentArray(harFamilyDependentTypeTab);
        }
        harRequesterLegalAccessTypeHarRequesterLegalAccess.setHarLegalAccessRepresentativeMobilePhone(this.harLegalAccessRepresentativeMobilePhone);
        if (this.harPTCARenewalRequest != null)
            harProjectRequestTypeHarProjectRequest.setHarPTCARenewalRequest(this.harPTCARenewalRequest.booleanValue());
        if (this.harSchoolingEnrolment != null)
            harSchoolingTypeHarSchooling.setHarSchoolingEnrolment(this.harSchoolingEnrolment.booleanValue());
        if (this.harSpecializedGrade != null)
            harSchoolingTypeHarSchooling.setHarSpecializedGrade(this.harSpecializedGrade.booleanValue());
        if (this.harDwellingSocialReception != null)
            harDwellingTypeHarDwelling.setHarDwellingSocialReception(this.harDwellingSocialReception.booleanValue());
        harRequesterTypeHarRequesterReferent.setHarRequesterStreetName(this.harRequesterStreetName);
        harLessThan20RequesterParentTypeHarLessThan20RequesterMother.setHarLessThan20RequesterParentCity(this.harLessThan20RequesterParentCity);
        if (this.harSupportedByAnInstitution != null)
            harBenefitsTypeHarBenefits.setHarSupportedByAnInstitution(this.harSupportedByAnInstitution.booleanValue());
        harFormationTypeHarFormation.setHarStudiesLevel(this.harStudiesLevel);
        if (this.harVocationalTrainingRequest != null)
            harProjectRequestTypeHarProjectRequest.setHarVocationalTrainingRequest(this.harVocationalTrainingRequest.booleanValue());
        if (this.harDisabledWorkerRecognitionRequest != null)
            harProjectRequestTypeHarProjectRequest.setHarDisabledWorkerRecognitionRequest(this.harDisabledWorkerRecognitionRequest.booleanValue());
        harRequesterLegalAccessTypeHarRequesterLegalAccess.setHarLegalAccessRepresentativeStreetName(this.harLegalAccessRepresentativeStreetName);
        if (this.harTransportCostAllocationRequest != null)
            harProjectRequestTypeHarProjectRequest.setHarTransportCostAllocationRequest(this.harTransportCostAllocationRequest.booleanValue());
        if (this.harDisabilityCompensation != null)
            harBenefitsTypeHarBenefits.setHarDisabilityCompensation(this.harDisabilityCompensation.booleanValue());
        if (this.harDwellingKind != null)
            harDwellingTypeHarDwelling.setHarDwellingKind(fr.cg95.cvq.xml.request.social.HarDwellingKindType.Enum.forString(this.harDwellingKind.toString()));
        if (this.harIsFamilyCarer != null)
            handicapAllowanceRequest.setHarIsFamilyCarer(this.harIsFamilyCarer.booleanValue());
        if (this.harCustomCar != null)
            harFacilitiesTypeHarFacilities.setHarCustomCar(this.harCustomCar.booleanValue());
        if (this.harIsCarer != null)
            handicapAllowanceRequest.setHarIsCarer(this.harIsCarer.booleanValue());
        harRequesterLegalAccessTypeHarRequesterLegalAccess.setHarLegalAccessRepresentativePhone(this.harLegalAccessRepresentativePhone);
        harStudiesTypeHarStudies.setHarAssistanceUnderDisabilityDetails(this.harAssistanceUnderDisabilityDetails);
        harLessThan20RequesterParentTypeHarLessThan20RequesterMother.setHarLessThan20RequesterParentMobilePhone(this.harLessThan20RequesterParentMobilePhone);
        harRequesterLegalAccessTypeHarRequesterLegalAccess.setHarLegalAccessRepresentativeName(this.harLegalAccessRepresentativeName);
        harDwellingTypeHarDwelling.setHarDwellingReceptionPostalCode(this.harDwellingReceptionPostalCode);
        harCOTOREPFilesTypeHarCOTOREPFiles.setHarCOTOREPDepartment(this.harCOTOREPDepartment);
        if (this.harProfessionalOrientation != null)
            harBenefitsTypeHarBenefits.setHarProfessionalOrientation(this.harProfessionalOrientation.booleanValue());
        harPaymentAgencyTypeHarPaymentAgency.setHarPaymentAgencyPostalCode(this.harPaymentAgencyPostalCode);
        if (this.harLegalAccessKind != null)
            harRequesterLegalAccessTypeHarRequesterLegalAccess.setHarLegalAccessKind(fr.cg95.cvq.xml.request.social.HarLegalAccessKindType.Enum.forString(this.harLegalAccessKind.toString()));
        if (this.harDwellingEstablishmentReception != null)
            harDwellingTypeHarDwelling.setHarDwellingEstablishmentReception(this.harDwellingEstablishmentReception.booleanValue());
        harLessThan20RequesterTypeHarLessThan20Requester.setHarLessThan20RequesterFirstName(this.harLessThan20RequesterFirstName);
        date = this.harRequesterBirthDate;
        if (date != null) {
            calendar.setTime(date);
            harRequesterTypeHarRequesterReferent.setHarRequesterBirthDate(calendar);
        }
        harRequesterTypeHarRequesterReferent.setHarRequesterFirstName(this.harRequesterFirstName);
        harSchoolingTypeHarSchooling.setHarExtraCurricular(this.harExtraCurricular);
        harRequesterLegalAccessTypeHarRequesterLegalAccess.setHarLegalAccessRepresentativeEmail(this.harLegalAccessRepresentativeEmail);
        if (this.harProfessionalStatusEnvironment != null)
            harProfessionalStatusTypeHarProfessionalStatus.setHarProfessionalStatusEnvironment(fr.cg95.cvq.xml.request.social.HarProfessionalStatusEnvironmentType.Enum.forString(this.harProfessionalStatusEnvironment.toString()));
        if (this.harElectiveFunctionDetails != null)
            harProfessionalStatusTypeHarProfessionalStatus.setHarElectiveFunctionDetails(this.harElectiveFunctionDetails.booleanValue());
        if (this.harOrdinaryworkingRequest != null)
            harProjectRequestTypeHarProjectRequest.setHarOrdinaryworkingRequest(this.harOrdinaryworkingRequest.booleanValue());
        if (this.harIncreaseForIndependentLivingRequest != null)
            harProjectRequestTypeHarProjectRequest.setHarIncreaseForIndependentLivingRequest(this.harIncreaseForIndependentLivingRequest.booleanValue());
        harDisabilityFollowUpTypeHarFollowUp.setHarSocialProfessionalPostalCode(this.harSocialProfessionalPostalCode);
        harRequesterLegalAccessTypeHarRequesterLegalAccess.setHarLegalAccessRepresentativeCity(this.harLegalAccessRepresentativeCity);
        harSchoolingTypeHarSchooling.setHarSchoolCity(this.harSchoolCity);
        if (this.harDisabledPriorityCardRequest != null)
            harProjectRequestTypeHarProjectRequest.setHarDisabledPriorityCardRequest(this.harDisabledPriorityCardRequest.booleanValue());
        harLessThan20RequesterRepresentativeTypeHarLessThan20RequesterRepresentative.setHarLessThan20RequesterRepresentativePostalCode(this.harLessThan20RequesterRepresentativePostalCode);
        if (this.harSchoolingKind != null)
            harSchoolingTypeHarSchooling.setHarSchoolingKind(fr.cg95.cvq.xml.request.social.HarSchoolingKindType.Enum.forString(this.harSchoolingKind.toString()));
        harProfessionalStatusTypeHarProfessionalStatus.setHarProfessionalStatusAddress(this.harProfessionalStatusAddress);
        if (this.familyHasFamilyDependents != null)
            harFamilyTypeHarFamily.setFamilyHasFamilyDependents(this.familyHasFamilyDependents.booleanValue());
        harLessThan20RequesterTypeHarLessThan20Requester.setHarLessThan20RequesterPhone(this.harLessThan20RequesterPhone);
        if (this.harSupplementForSingleParents != null)
            harBenefitsTypeHarBenefits.setHarSupplementForSingleParents(this.harSupplementForSingleParents.booleanValue());
        if (this.harLessThan20RequesterRepresentativeReductionRatio != null)
            harLessThan20RequesterParentTypeHarLessThan20RequesterMother.setHarLessThan20RequesterRepresentativeReductionRatio(new BigInteger(this.harLessThan20RequesterRepresentativeReductionRatio.toString()));
        harDwellingTypeHarDwelling.setHarDwellingSocialReceptionAddress(this.harDwellingSocialReceptionAddress);
        harDwellingTypeHarDwelling.setHarDwellingReceptionCity(this.harDwellingReceptionCity);
        if (this.harFollowedByProfessional != null)
            harCareFollowUpTypeHarCareFollowUp.setHarFollowedByProfessional(this.harFollowedByProfessional.booleanValue());
        if (this.harShelteredWorkRequest != null)
            harProjectRequestTypeHarProjectRequest.setHarShelteredWorkRequest(this.harShelteredWorkRequest.booleanValue());
        harLessThan20RequesterTypeHarLessThan20Requester.setHarLessThan20RequesterMobilePhone(this.harLessThan20RequesterMobilePhone);
        date = this.harIndemnifiedDate;
        if (date != null) {
            calendar.setTime(date);
            harProfessionalStatusTypeHarProfessionalStatus.setHarIndemnifiedDate(calendar);
        }
        harFacilitiesTypeHarFacilities.setHarAnimalAidDetails(this.harAnimalAidDetails);
        if (this.harElectiveFunction != null)
            harProfessionalStatusTypeHarProfessionalStatus.setHarElectiveFunction(this.harElectiveFunction.booleanValue());
        harSchoolingTypeHarSchooling.setHarHomeSchoolingAccompanistLastName(this.harHomeSchoolingAccompanistLastName);
        harBenefitsTypeHarBenefits.setHarDisabilityPensionCategory(this.harDisabilityPensionCategory);
        harRequesterTypeHarRequesterReferent.setHarRequesterName(this.harRequesterName);
        if (this.harProfessionalStatusKind != null)
            harProfessionalStatusTypeHarProfessionalStatus.setHarProfessionalStatusKind(fr.cg95.cvq.xml.request.social.HarProfessionalStatusKindType.Enum.forString(this.harProfessionalStatusKind.toString()));
        harSocialSecurityTypeHarSocialSecurity.setHarSocialSecurityAgencyAddress(this.harSocialSecurityAgencyAddress);
        harPaymentAgencyTypeHarPaymentAgency.setHarPaymentAgencyName(this.harPaymentAgencyName);
        harRequesterTypeHarRequesterReferent.setHarRequesterMaidenName(this.harRequesterMaidenName);
        harLessThan20RequesterParentTypeHarLessThan20RequesterMother.setHarLessThan20RequesterParentPhone(this.harLessThan20RequesterParentPhone);
        harDisabilityFollowUpTypeHarFollowUp.setHarSocialProfessionalCity(this.harSocialProfessionalCity);
        if (this.harTechnicalAssistance != null)
            harFacilitiesTypeHarFacilities.setHarTechnicalAssistance(this.harTechnicalAssistance.booleanValue());
        harLessThan20RequesterParentTypeHarLessThan20RequesterMother.setHarLessThan20RequesterParentJob(this.harLessThan20RequesterParentJob);
        date = this.harLessThan20RequesterBirthDate;
        if (date != null) {
            calendar.setTime(date);
            harLessThan20RequesterTypeHarLessThan20Requester.setHarLessThan20RequesterBirthDate(calendar);
        }
        HarMDPHFilesType harMDPHFilesTypeHarMDPHFiles = handicapAllowanceRequest.addNewHarMDPHFiles();
        harMDPHFilesTypeHarMDPHFiles.setHarMDPHNumber(this.harMDPHNumber);
        if (this.harDwellingReceptionType != null)
            harDwellingTypeHarDwelling.setHarDwellingReceptionType(fr.cg95.cvq.xml.request.social.HarDwellingReceptionKindType.Enum.forString(this.harDwellingReceptionType.toString()));
        if (this.harDisabledAdultAllowanceRequest != null)
            harProjectRequestTypeHarProjectRequest.setHarDisabledAdultAllowanceRequest(this.harDisabledAdultAllowanceRequest.booleanValue());
        harDwellingTypeHarDwelling.setHarDwellingSocialReceptionPostalCode(this.harDwellingSocialReceptionPostalCode);
        if (this.harDisabledAdultAllocation != null)
            harBenefitsTypeHarBenefits.setHarDisabledAdultAllocation(this.harDisabledAdultAllocation.booleanValue());
        harRequesterTypeHarRequesterReferent.setHarRequesterPhone(this.harRequesterPhone);
        if (this.harThridPartySupplement != null)
            harBenefitsTypeHarBenefits.setHarThridPartySupplement(this.harThridPartySupplement.booleanValue());
        if (this.harDisabilityCardRequest != null)
            harProjectRequestTypeHarProjectRequest.setHarDisabilityCardRequest(this.harDisabilityCardRequest.booleanValue());
        if (this.harLegalAccessRepresentativeKind != null)
            harRequesterLegalAccessTypeHarRequesterLegalAccess.setHarLegalAccessRepresentativeKind(fr.cg95.cvq.xml.request.social.HarLegalAccessRepresentativeKindType.Enum.forString(this.harLegalAccessRepresentativeKind.toString()));
        harProfessionalStatusTypeHarProfessionalStatus.setHarProfessionalStatusPostalCode(this.harProfessionalStatusPostalCode);
        if (this.harProfessionalEvaluation != null)
            handicapAllowanceRequest.setHarProfessionalEvaluation(this.harProfessionalEvaluation.booleanValue());
        if (this.harEducationAllocationOfDisabledChildrenRequest != null)
            harProjectRequestTypeHarProjectRequest.setHarEducationAllocationOfDisabledChildrenRequest(this.harEducationAllocationOfDisabledChildrenRequest.booleanValue());
        harSchoolingTypeHarSchooling.setHarSchoolPostalCode(this.harSchoolPostalCode);
        harDwellingTypeHarDwelling.setHarDwellingReceptionAddress(this.harDwellingReceptionAddress);
        harRequesterTypeHarRequesterReferent.setHarRequesterPostalCode(this.harRequesterPostalCode);
        harCareFollowUpTypeHarCareFollowUp.setHarFollowedByProfessionalDetails(this.harFollowedByProfessionalDetails);
        if (this.harSchoolingTime != null)
            harSchoolingTypeHarSchooling.setHarSchoolingTime(new BigInteger(this.harSchoolingTime.toString()));
        if (this.harPaymentAgencyBeneficiary != null)
            harPaymentAgencyTypeHarPaymentAgency.setHarPaymentAgencyBeneficiary(fr.cg95.cvq.xml.request.social.HarPaymentAgencyBeneficiaryType.Enum.forString(this.harPaymentAgencyBeneficiary.toString()));
        if (this.harSendToSchool != null)
            harSchoolingTypeHarSchooling.setHarSendToSchool(this.harSendToSchool.booleanValue());
        harSchoolingTypeHarSchooling.setHarSpecializedGradeDetails(this.harSpecializedGradeDetails);
        harDisabilityFollowUpTypeHarFollowUp.setHarSocialProfessionalLastName(this.harSocialProfessionalLastName);
        harPaymentAgencyTypeHarPaymentAgency.setHarPaymentAgencyCity(this.harPaymentAgencyCity);
        harBenefitsTypeHarBenefits.setHarSupportedByAnInstitutionDetails(this.harSupportedByAnInstitutionDetails);
        if (this.harHomeSchoolingKind != null)
            harSchoolingTypeHarSchooling.setHarHomeSchoolingKind(fr.cg95.cvq.xml.request.social.HarHomeSchoolingKindType.Enum.forString(this.harHomeSchoolingKind.toString()));
        if (this.harLessThan20RequesterRepresentativeActivityReduction != null)
            harLessThan20RequesterParentTypeHarLessThan20RequesterMother.setHarLessThan20RequesterRepresentativeActivityReduction(this.harLessThan20RequesterRepresentativeActivityReduction.booleanValue());
        harLessThan20RequesterRepresentativeTypeHarLessThan20RequesterRepresentative.setHarLessThan20RequesterRepresentativeMobilePhone(this.harLessThan20RequesterRepresentativeMobilePhone);
        i = 0;
        if (harCarer != null) {
            fr.cg95.cvq.xml.request.social.HarCarerType[] harCarerTypeTab = new fr.cg95.cvq.xml.request.social.HarCarerType[harCarer.size()];
            Iterator harCarerIt = harCarer.iterator();
            while (harCarerIt.hasNext()) {
                HarCarer object = (HarCarer) harCarerIt.next();
                harCarerTypeTab[i] = (HarCarerType) object.modelToXml();
                i = i + 1;
            }
            handicapAllowanceRequest.setHarCarerArray(harCarerTypeTab);
        }
        harDwellingTypeHarDwelling.setHarDwellingPrecision(this.harDwellingPrecision);
        if (this.harRegisterAsUnemployed != null)
            harProfessionalStatusTypeHarProfessionalStatus.setHarRegisterAsUnemployed(this.harRegisterAsUnemployed.booleanValue());
        handicapAllowanceRequest.setHarProjectComments(this.harProjectComments);
        harRequesterTypeHarRequesterReferent.setHarRequesterMobilePhone(this.harRequesterMobilePhone);
        if (this.harRequesterTitle != null)
            harRequesterTypeHarRequesterReferent.setHarRequesterTitle(fr.cg95.cvq.xml.request.social.HarTitleType.Enum.forString(this.harRequesterTitle.toString()));
        harLessThan20RequesterParentTypeHarLessThan20RequesterMother.setHarLessThan20RequesterParentStreetName(this.harLessThan20RequesterParentStreetName);
        harDisabilityFollowUpTypeHarFollowUp.setHarSocialProfessionalAddress(this.harSocialProfessionalAddress);
        harFacilitiesTypeHarFacilities.setHarCustomCarDetails(this.harCustomCarDetails);
        harLessThan20RequesterTypeHarLessThan20Requester.setHarLessThan20RequesterEmail(this.harLessThan20RequesterEmail);
        if (this.harThridPartyCompensatoryAllowance != null)
            harBenefitsTypeHarBenefits.setHarThridPartyCompensatoryAllowance(this.harThridPartyCompensatoryAllowance.booleanValue());
        if (this.harMDPHFile != null)
            harMDPHFilesTypeHarMDPHFiles.setHarMDPHFile(this.harMDPHFile.booleanValue());
        harBenefitsTypeHarBenefits.setHarAdditionalAllocationForEducationOfDisabledChildrenDetails(this.harAdditionalAllocationForEducationOfDisabledChildrenDetails);
        if (this.harEducationAllocationOfDisabledChildren != null)
            harBenefitsTypeHarBenefits.setHarEducationAllocationOfDisabledChildren(this.harEducationAllocationOfDisabledChildren.booleanValue());
        if (this.harThridPersonCompensatoryAllowance != null)
            harBenefitsTypeHarBenefits.setHarThridPersonCompensatoryAllowance(this.harThridPersonCompensatoryAllowance.booleanValue());
        if (this.harCustomCarRequest != null)
            harProjectRequestTypeHarProjectRequest.setHarCustomCarRequest(this.harCustomCarRequest.booleanValue());
        if (this.harAnimalAid != null)
            harFacilitiesTypeHarFacilities.setHarAnimalAid(this.harAnimalAid.booleanValue());
        date = this.harRegisterAsUnemployedDate;
        if (date != null) {
            calendar.setTime(date);
            harProfessionalStatusTypeHarProfessionalStatus.setHarRegisterAsUnemployedDate(calendar);
        }
        if (this.harProfessionalOrientationRequest != null)
            harProjectRequestTypeHarProjectRequest.setHarProfessionalOrientationRequest(this.harProfessionalOrientationRequest.booleanValue());
        harRequesterTypeHarRequesterReferent.setHarRequesterEmail(this.harRequesterEmail);
        if (this.harFollowedByHospital != null)
            harCareFollowUpTypeHarCareFollowUp.setHarFollowedByHospital(this.harFollowedByHospital.booleanValue());
        if (this.harIncreaseForIndependentLiving != null)
            harBenefitsTypeHarBenefits.setHarIncreaseForIndependentLiving(this.harIncreaseForIndependentLiving.booleanValue());
        harLessThan20RequesterParentTypeHarLessThan20RequesterMother.setHarLessThan20RequesterParentPostalCode(this.harLessThan20RequesterParentPostalCode);
        harRequesterLegalAccessTypeHarRequesterLegalAccess.setHarLegalAccessRepresentativeFirstName(this.harLegalAccessRepresentativeFirstName);
        if (this.harDisabilityCostAllocationRequest != null)
            harProjectRequestTypeHarProjectRequest.setHarDisabilityCostAllocationRequest(this.harDisabilityCostAllocationRequest.booleanValue());
        harDwellingTypeHarDwelling.setDwellingReceptionNaming(this.dwellingReceptionNaming);
        handicapAllowanceRequest.setHarProjectWish(this.harProjectWish);
        harSocialSecurityTypeHarSocialSecurity.setHarSocialSecurityAgencyCity(this.harSocialSecurityAgencyCity);
        harLessThan20RequesterParentTypeHarLessThan20RequesterMother.setHarLessThan20RequesterParentName(this.harLessThan20RequesterParentName);
        harLessThan20RequesterTypeHarLessThan20Requester.setHarLessThan20RequesterStreetName(this.harLessThan20RequesterStreetName);
        harFormationTypeHarFormation.setHarDiploma(this.harDiploma);
        if (this.harEuropeanParkingCardRequest != null)
            harProjectRequestTypeHarProjectRequest.setHarEuropeanParkingCardRequest(this.harEuropeanParkingCardRequest.booleanValue());
        if (this.harRequesterBirthCountry != null)
            harRequesterTypeHarRequesterReferent.setHarRequesterBirthCountry(fr.cg95.cvq.xml.common.CountryType.Enum.forString(this.harRequesterBirthCountry.toString()));
        harProfessionalStatusTypeHarProfessionalStatus.setHarProfessionalStatusCity(this.harProfessionalStatusCity);
        harLessThan20RequesterTypeHarLessThan20Requester.setHarLessThan20RequesterPostalCode(this.harLessThan20RequesterPostalCode);
        harMDPHFilesTypeHarMDPHFiles.setHarMDPHDepartment(this.harMDPHDepartment);
        harLessThan20RequesterRepresentativeTypeHarLessThan20RequesterRepresentative.setHarLessThan20RequesterRepresentativePhone(this.harLessThan20RequesterRepresentativePhone);
        if (this.harAssistanceUnderDisability != null)
            harStudiesTypeHarStudies.setHarAssistanceUnderDisability(this.harAssistanceUnderDisability.booleanValue());
        if (this.harWorkAccidentAnnuity != null)
            harBenefitsTypeHarBenefits.setHarWorkAccidentAnnuity(this.harWorkAccidentAnnuity.booleanValue());
        i = 0;
        if (harOtherFiles != null) {
            fr.cg95.cvq.xml.request.social.HarOtherFilesType[] harOtherFilesTypeTab = new fr.cg95.cvq.xml.request.social.HarOtherFilesType[harOtherFiles.size()];
            Iterator harOtherFilesIt = harOtherFiles.iterator();
            while (harOtherFilesIt.hasNext()) {
                HarOtherFiles object = (HarOtherFiles) harOtherFilesIt.next();
                harOtherFilesTypeTab[i] = (HarOtherFilesType) object.modelToXml();
                i = i + 1;
            }
            handicapAllowanceRequest.setHarOtherFilesArray(harOtherFilesTypeTab);
        }
        if (this.harUnemploymentBenefits != null)
            harBenefitsTypeHarBenefits.setHarUnemploymentBenefits(this.harUnemploymentBenefits.booleanValue());
        harBenefitsTypeHarBenefits.setHarProfessionalOrientationDetails(this.harProfessionalOrientationDetails);
        if (this.harHousingFacilitiesRequest != null)
            harProjectRequestTypeHarProjectRequest.setHarHousingFacilitiesRequest(this.harHousingFacilitiesRequest.booleanValue());
        harSchoolingTypeHarSchooling.setHarHomeSchoolingAccompanistCity(this.harHomeSchoolingAccompanistCity);
        harDwellingTypeHarDwelling.setHarDwellingSocialReceptionNaming(this.harDwellingSocialReceptionNaming);
        if (this.harPersonalizedSchoolingPlan != null)
            harSchoolingTypeHarSchooling.setHarPersonalizedSchoolingPlan(this.harPersonalizedSchoolingPlan.booleanValue());
        if (this.harAssistanceRequest != null)
            harProjectRequestTypeHarProjectRequest.setHarAssistanceRequest(this.harAssistanceRequest.booleanValue());
        if (this.harSocialWelfare != null)
            harBenefitsTypeHarBenefits.setHarSocialWelfare(this.harSocialWelfare.booleanValue());
        harSchoolingTypeHarSchooling.setHarHomeSchoolingAccompanistAddress(this.harHomeSchoolingAccompanistAddress);
        if (this.harInstitutionSupportRequest != null)
            harProjectRequestTypeHarProjectRequest.setHarInstitutionSupportRequest(this.harInstitutionSupportRequest.booleanValue());
        if (this.harThirdPartyHelpRequest != null)
            harProjectRequestTypeHarProjectRequest.setHarThirdPartyHelpRequest(this.harThirdPartyHelpRequest.booleanValue());
        harSchoolingTypeHarSchooling.setHarHomeSchoolingAccompanistPostalCode(this.harHomeSchoolingAccompanistPostalCode);
        date = this.harProfessionalStatusDate;
        if (date != null) {
            calendar.setTime(date);
            harProfessionalStatusTypeHarProfessionalStatus.setHarProfessionalStatusDate(calendar);
        }
        if (this.harDisabilityRecognitionRequest != null)
            harProjectRequestTypeHarProjectRequest.setHarDisabilityRecognitionRequest(this.harDisabilityRecognitionRequest.booleanValue());
        if (this.harRequestDealWithSameProfessional != null)
            handicapAllowanceRequest.setHarRequestDealWithSameProfessional(this.harRequestDealWithSameProfessional.booleanValue());
        if (this.harLessThan20RequesterBirthCountry != null)
            harLessThan20RequesterTypeHarLessThan20Requester.setHarLessThan20RequesterBirthCountry(fr.cg95.cvq.xml.common.CountryType.Enum.forString(this.harLessThan20RequesterBirthCountry.toString()));
        harStudiesTypeHarStudies.setHarHighSchoolName(this.harHighSchoolName);
        if (this.harPainfulStandingCard != null)
            harBenefitsTypeHarBenefits.setHarPainfulStandingCard(this.harPainfulStandingCard.booleanValue());
        return handicapAllowanceRequestDoc;
    }

    @Override
    public RequestType modelToXmlRequest() {
        HandicapAllowanceRequestDocument handicapAllowanceRequestDoc =
            (HandicapAllowanceRequestDocument) modelToXml();
        return handicapAllowanceRequestDoc.getHandicapAllowanceRequest();
    }

    public static HandicapAllowanceRequest xmlToModel(HandicapAllowanceRequestDocument handicapAllowanceRequestDoc) {

        HandicapAllowanceRequestDocument.HandicapAllowanceRequest handicapAllowanceRequestXml = handicapAllowanceRequestDoc.getHandicapAllowanceRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HandicapAllowanceRequest handicapAllowanceRequest = new HandicapAllowanceRequest();
        handicapAllowanceRequest.fillCommonModelInfo(handicapAllowanceRequest,handicapAllowanceRequestXml);
        if (handicapAllowanceRequestXml.getHarLessThan20Requester().getHarLessThan20RequesterGender() != null)
            handicapAllowanceRequest.setHarLessThan20RequesterGender(fr.cg95.cvq.business.request.social.HarGenderType.forString(handicapAllowanceRequestXml.getHarLessThan20Requester().getHarLessThan20RequesterGender().toString()));
        else
            handicapAllowanceRequest.setHarLessThan20RequesterGender(fr.cg95.cvq.business.request.social.HarGenderType.getDefaultHarGenderType());
        List<fr.cg95.cvq.business.request.social.HarDisabilityRelatedCost> harDisabilityRelatedCostList = new ArrayList<fr.cg95.cvq.business.request.social.HarDisabilityRelatedCost> ();
        if ( handicapAllowanceRequestXml.sizeOfHarDisabilityRelatedCostArray() > 0) {
            for (int i = 0; i < handicapAllowanceRequestXml.getHarDisabilityRelatedCostArray().length; i++) {
                harDisabilityRelatedCostList.add(HarDisabilityRelatedCost.xmlToModel(handicapAllowanceRequestXml.getHarDisabilityRelatedCostArray(i)));
            }
        }
        handicapAllowanceRequest.setHarDisabilityRelatedCost(harDisabilityRelatedCostList);
        handicapAllowanceRequest.setHarPaymentAgencyBeneficiaryNumber(handicapAllowanceRequestXml.getHarPaymentAgency().getHarPaymentAgencyBeneficiaryNumber());
        handicapAllowanceRequest.setHarPreviousFormation(handicapAllowanceRequestXml.getHarFormation().getHarPreviousFormation());
        handicapAllowanceRequest.setHarFollowUp(Boolean.valueOf(handicapAllowanceRequestXml.getHarFollowUp().getHarFollowUp()));
        handicapAllowanceRequest.setHarLegalAccessPresence(Boolean.valueOf(handicapAllowanceRequestXml.getHarRequesterLegalAccess().getHarLegalAccessPresence()));
        handicapAllowanceRequest.setHarSocialSecurityAgencyName(handicapAllowanceRequestXml.getHarSocialSecurity().getHarSocialSecurityAgencyName());
        handicapAllowanceRequest.setHarRequesterCity(handicapAllowanceRequestXml.getHarRequesterReferent().getHarRequesterCity());
        List<fr.cg95.cvq.business.request.social.HarProfessional> harProfessionalList = new ArrayList<fr.cg95.cvq.business.request.social.HarProfessional> ();
        if ( handicapAllowanceRequestXml.sizeOfHarProfessionalArray() > 0) {
            for (int i = 0; i < handicapAllowanceRequestXml.getHarProfessionalArray().length; i++) {
                harProfessionalList.add(HarProfessional.xmlToModel(handicapAllowanceRequestXml.getHarProfessionalArray(i)));
            }
        }
        handicapAllowanceRequest.setHarProfessional(harProfessionalList);
        handicapAllowanceRequest.setHarDisabilityRecognition(Boolean.valueOf(handicapAllowanceRequestXml.getHarBenefits().getHarDisabilityRecognition()));
        handicapAllowanceRequest.setHarAdditionalAllocationForEducationOfDisabledChildren(Boolean.valueOf(handicapAllowanceRequestXml.getHarBenefits().getHarAdditionalAllocationForEducationOfDisabledChildren()));
        handicapAllowanceRequest.setHarLessThan20RequesterRepresentativeFirstName(handicapAllowanceRequestXml.getHarLessThan20RequesterRepresentative().getHarLessThan20RequesterRepresentativeFirstName());
        handicapAllowanceRequest.setHarDisabilityPension(Boolean.valueOf(handicapAllowanceRequestXml.getHarBenefits().getHarDisabilityPension()));
        handicapAllowanceRequest.setHarDisabilityCard(Boolean.valueOf(handicapAllowanceRequestXml.getHarBenefits().getHarDisabilityCard()));
        handicapAllowanceRequest.setHarFreePensionMembershipRequest(Boolean.valueOf(handicapAllowanceRequestXml.getHarProjectRequest().getHarFreePensionMembershipRequest()));
        if (handicapAllowanceRequestXml.getHarLessThan20RequesterAuthorityHolder() != null)
            handicapAllowanceRequest.setHarLessThan20RequesterAuthorityHolder(fr.cg95.cvq.business.request.social.HarLessThan20RequesterAuthorityHolderType.forString(handicapAllowanceRequestXml.getHarLessThan20RequesterAuthorityHolder().toString()));
        else
            handicapAllowanceRequest.setHarLessThan20RequesterAuthorityHolder(fr.cg95.cvq.business.request.social.HarLessThan20RequesterAuthorityHolderType.getDefaultHarLessThan20RequesterAuthorityHolderType());
        handicapAllowanceRequest.setHarHousingFacilitiesDetails(handicapAllowanceRequestXml.getHarFacilities().getHarHousingFacilitiesDetails());
        handicapAllowanceRequest.setHarSpecializedTransport(Boolean.valueOf(handicapAllowanceRequestXml.getHarFacilities().getHarSpecializedTransport()));
        handicapAllowanceRequest.setHarSocialSecurityAgencyPostalCode(handicapAllowanceRequestXml.getHarSocialSecurity().getHarSocialSecurityAgencyPostalCode());
        handicapAllowanceRequest.setHarSchoolAddress(handicapAllowanceRequestXml.getHarSchooling().getHarSchoolAddress());
        handicapAllowanceRequest.setHarAttendedGrade(handicapAllowanceRequestXml.getHarSchooling().getHarAttendedGrade());
        handicapAllowanceRequest.setHarHousingFacilities(Boolean.valueOf(handicapAllowanceRequestXml.getHarFacilities().getHarHousingFacilities()));
        handicapAllowanceRequest.setHarHomeSchooling(Boolean.valueOf(handicapAllowanceRequestXml.getHarSchooling().getHarHomeSchooling()));
        handicapAllowanceRequest.setHarFollowedByPhysician(Boolean.valueOf(handicapAllowanceRequestXml.getHarCareFollowUp().getHarFollowedByPhysician()));
        handicapAllowanceRequest.setHarDwellingSocialReceptionCity(handicapAllowanceRequestXml.getHarDwelling().getHarDwellingSocialReceptionCity());
        handicapAllowanceRequest.setHarOtherRequest(Boolean.valueOf(handicapAllowanceRequestXml.getHarProjectRequest().getHarOtherRequest()));
        handicapAllowanceRequest.setHarParkingCard(Boolean.valueOf(handicapAllowanceRequestXml.getHarBenefits().getHarParkingCard()));
        if (handicapAllowanceRequestXml.getHarFamily().getFamilyStatus() != null)
            handicapAllowanceRequest.setFamilyStatus(fr.cg95.cvq.business.request.social.HarFamilyStatusType.forString(handicapAllowanceRequestXml.getHarFamily().getFamilyStatus().toString()));
        else
            handicapAllowanceRequest.setFamilyStatus(fr.cg95.cvq.business.request.social.HarFamilyStatusType.getDefaultHarFamilyStatusType());
        handicapAllowanceRequest.setHarLessThan20RequesterRepresentativeDepartment(handicapAllowanceRequestXml.getHarLessThan20RequesterWelfareReferent().getHarLessThan20RequesterRepresentativeDepartment());
        handicapAllowanceRequest.setHarSpecializedTransportDetails(handicapAllowanceRequestXml.getHarFacilities().getHarSpecializedTransportDetails());
        handicapAllowanceRequest.setHarLessThan20RequesterRepresentativeCity(handicapAllowanceRequestXml.getHarLessThan20RequesterRepresentative().getHarLessThan20RequesterRepresentativeCity());
        handicapAllowanceRequest.setHarRequesterBirthCity(handicapAllowanceRequestXml.getHarRequesterReferent().getHarRequesterBirthCity());
        handicapAllowanceRequest.setHarProfessionalStatusProfession(handicapAllowanceRequestXml.getHarProfessionalStatus().getHarProfessionalStatusProfession());
        handicapAllowanceRequest.setHarCDESDepartment(handicapAllowanceRequestXml.getHarCDESFiles().getHarCDESDepartment());
        handicapAllowanceRequest.setHarCompensatoryAllowanceForExpenses(Boolean.valueOf(handicapAllowanceRequestXml.getHarBenefits().getHarCompensatoryAllowanceForExpenses()));
        handicapAllowanceRequest.setHarPaymentAgencyAddress(handicapAllowanceRequestXml.getHarPaymentAgency().getHarPaymentAgencyAddress());
        handicapAllowanceRequest.setHarLessThan20RequesterRepresentativeStreetName(handicapAllowanceRequestXml.getHarLessThan20RequesterRepresentative().getHarLessThan20RequesterRepresentativeStreetName());
        handicapAllowanceRequest.setHarCDESFile(Boolean.valueOf(handicapAllowanceRequestXml.getHarCDESFiles().getHarCDESFile()));
        handicapAllowanceRequest.setHarFollowedByPhysicianDetails(handicapAllowanceRequestXml.getHarCareFollowUp().getHarFollowedByPhysicianDetails());
        handicapAllowanceRequest.setHarLessThan20RequesterCity(handicapAllowanceRequestXml.getHarLessThan20Requester().getHarLessThan20RequesterCity());
        handicapAllowanceRequest.setHarCurrentFormation(handicapAllowanceRequestXml.getHarFormation().getHarCurrentFormation());
        List<fr.cg95.cvq.business.request.social.HarCareAssistant> harCareAssistantList = new ArrayList<fr.cg95.cvq.business.request.social.HarCareAssistant> ();
        if ( handicapAllowanceRequestXml.sizeOfHarCareAssistantArray() > 0) {
            for (int i = 0; i < handicapAllowanceRequestXml.getHarCareAssistantArray().length; i++) {
                harCareAssistantList.add(HarCareAssistant.xmlToModel(handicapAllowanceRequestXml.getHarCareAssistantArray(i)));
            }
        }
        handicapAllowanceRequest.setHarCareAssistant(harCareAssistantList);
        handicapAllowanceRequest.setHarLessThan20RequesterRepresentativeName(handicapAllowanceRequestXml.getHarLessThan20RequesterWelfareReferent().getHarLessThan20RequesterRepresentativeName());
        handicapAllowanceRequest.setHarLessThan20RequesterParentFirstName(handicapAllowanceRequestXml.getHarLessThan20RequesterMother().getHarLessThan20RequesterParentFirstName());
        handicapAllowanceRequest.setHarCOTOREPNumber(handicapAllowanceRequestXml.getHarCOTOREPFiles().getHarCOTOREPNumber());
        handicapAllowanceRequest.setHarDisabledWorkerRecognition(Boolean.valueOf(handicapAllowanceRequestXml.getHarBenefits().getHarDisabledWorkerRecognition()));
        handicapAllowanceRequest.setHarHighSchoolCity(handicapAllowanceRequestXml.getHarStudies().getHarHighSchoolCity());
        handicapAllowanceRequest.setHarTechnicalHelpRequest(Boolean.valueOf(handicapAllowanceRequestXml.getHarProjectRequest().getHarTechnicalHelpRequest()));
        handicapAllowanceRequest.setHarFollowedByHospitalDetails(handicapAllowanceRequestXml.getHarCareFollowUp().getHarFollowedByHospitalDetails());
        handicapAllowanceRequest.setHarProjectNeeds(handicapAllowanceRequestXml.getHarProjectNeeds());
        handicapAllowanceRequest.setHarTechnicalAssistanceDetails(handicapAllowanceRequestXml.getHarFacilities().getHarTechnicalAssistanceDetails());
        handicapAllowanceRequest.setHarCDESNumber(handicapAllowanceRequestXml.getHarCDESFiles().getHarCDESNumber());
        handicapAllowanceRequest.setHarHighSchoolGrade(handicapAllowanceRequestXml.getHarStudies().getHarHighSchoolGrade());
        handicapAllowanceRequest.setHarHighSchool(Boolean.valueOf(handicapAllowanceRequestXml.getHarStudies().getHarHighSchool()));
        handicapAllowanceRequest.setHarSchoolName(handicapAllowanceRequestXml.getHarSchooling().getHarSchoolName());
        handicapAllowanceRequest.setHarLessThan20RequesterName(handicapAllowanceRequestXml.getHarLessThan20Requester().getHarLessThan20RequesterName());
        handicapAllowanceRequest.setHarLegalAccessRepresentativeKindDetail(handicapAllowanceRequestXml.getHarRequesterLegalAccess().getHarLegalAccessRepresentativeKindDetail());
        handicapAllowanceRequest.setHarHomeSchoolingAccompanistFirstName(handicapAllowanceRequestXml.getHarSchooling().getHarHomeSchoolingAccompanistFirstName());
        handicapAllowanceRequest.setHarHighSchoolPostalCode(handicapAllowanceRequestXml.getHarStudies().getHarHighSchoolPostalCode());
        if (handicapAllowanceRequestXml.getHarRequestInformationProfile() != null)
            handicapAllowanceRequest.setHarRequestInformationProfile(fr.cg95.cvq.business.request.social.HarRequestInformationProfileType.forString(handicapAllowanceRequestXml.getHarRequestInformationProfile().toString()));
        else
            handicapAllowanceRequest.setHarRequestInformationProfile(fr.cg95.cvq.business.request.social.HarRequestInformationProfileType.getDefaultHarRequestInformationProfileType());
        handicapAllowanceRequest.setHarIndemnified(Boolean.valueOf(handicapAllowanceRequestXml.getHarProfessionalStatus().getHarIndemnified()));
        handicapAllowanceRequest.setHarOtherRequestDetails(handicapAllowanceRequestXml.getHarProjectRequest().getHarOtherRequestDetails());
        handicapAllowanceRequest.setHarHighSchoolAddress(handicapAllowanceRequestXml.getHarStudies().getHarHighSchoolAddress());
        handicapAllowanceRequest.setHarIsCareAssistant(Boolean.valueOf(handicapAllowanceRequestXml.getHarIsCareAssistant()));
        handicapAllowanceRequest.setHarLegalAccessRepresentativePostalCode(handicapAllowanceRequestXml.getHarRequesterLegalAccess().getHarLegalAccessRepresentativePostalCode());
        handicapAllowanceRequest.setHarCOTOREPFile(Boolean.valueOf(handicapAllowanceRequestXml.getHarCOTOREPFiles().getHarCOTOREPFile()));
        handicapAllowanceRequest.setHarDailyAllowances(Boolean.valueOf(handicapAllowanceRequestXml.getHarBenefits().getHarDailyAllowances()));
        handicapAllowanceRequest.setHarLessThan20RequesterBirthCity(handicapAllowanceRequestXml.getHarLessThan20Requester().getHarLessThan20RequesterBirthCity());
        if (handicapAllowanceRequestXml.getHarSocialSecurity().getHarSocialSecurityMemberShipKind() != null)
            handicapAllowanceRequest.setHarSocialSecurityMemberShipKind(fr.cg95.cvq.business.request.social.HarSocialSecurityMemberShipKindType.forString(handicapAllowanceRequestXml.getHarSocialSecurity().getHarSocialSecurityMemberShipKind().toString()));
        else
            handicapAllowanceRequest.setHarSocialSecurityMemberShipKind(fr.cg95.cvq.business.request.social.HarSocialSecurityMemberShipKindType.getDefaultHarSocialSecurityMemberShipKindType());
        handicapAllowanceRequest.setHarSocialSecurityNumber(handicapAllowanceRequestXml.getHarSocialSecurity().getHarSocialSecurityNumber());
        List<fr.cg95.cvq.business.request.social.HarFamilyCarer> harFamilyCarerList = new ArrayList<fr.cg95.cvq.business.request.social.HarFamilyCarer> ();
        if ( handicapAllowanceRequestXml.sizeOfHarFamilyCarerArray() > 0) {
            for (int i = 0; i < handicapAllowanceRequestXml.getHarFamilyCarerArray().length; i++) {
                harFamilyCarerList.add(HarFamilyCarer.xmlToModel(handicapAllowanceRequestXml.getHarFamilyCarerArray(i)));
            }
        }
        handicapAllowanceRequest.setHarFamilyCarer(harFamilyCarerList);
        List<fr.cg95.cvq.business.request.social.HarFamilyDependent> harFamilyDependentList = new ArrayList<fr.cg95.cvq.business.request.social.HarFamilyDependent> ();
        if ( handicapAllowanceRequestXml.sizeOfHarFamilyDependentArray() > 0) {
            for (int i = 0; i < handicapAllowanceRequestXml.getHarFamilyDependentArray().length; i++) {
                harFamilyDependentList.add(HarFamilyDependent.xmlToModel(handicapAllowanceRequestXml.getHarFamilyDependentArray(i)));
            }
        }
        handicapAllowanceRequest.setHarFamilyDependent(harFamilyDependentList);
        handicapAllowanceRequest.setHarLegalAccessRepresentativeMobilePhone(handicapAllowanceRequestXml.getHarRequesterLegalAccess().getHarLegalAccessRepresentativeMobilePhone());
        handicapAllowanceRequest.setHarPTCARenewalRequest(Boolean.valueOf(handicapAllowanceRequestXml.getHarProjectRequest().getHarPTCARenewalRequest()));
        handicapAllowanceRequest.setHarSchoolingEnrolment(Boolean.valueOf(handicapAllowanceRequestXml.getHarSchooling().getHarSchoolingEnrolment()));
        handicapAllowanceRequest.setHarSpecializedGrade(Boolean.valueOf(handicapAllowanceRequestXml.getHarSchooling().getHarSpecializedGrade()));
        handicapAllowanceRequest.setHarDwellingSocialReception(Boolean.valueOf(handicapAllowanceRequestXml.getHarDwelling().getHarDwellingSocialReception()));
        handicapAllowanceRequest.setHarRequesterStreetName(handicapAllowanceRequestXml.getHarRequesterReferent().getHarRequesterStreetName());
        handicapAllowanceRequest.setHarLessThan20RequesterParentCity(handicapAllowanceRequestXml.getHarLessThan20RequesterMother().getHarLessThan20RequesterParentCity());
        handicapAllowanceRequest.setHarSupportedByAnInstitution(Boolean.valueOf(handicapAllowanceRequestXml.getHarBenefits().getHarSupportedByAnInstitution()));
        handicapAllowanceRequest.setHarStudiesLevel(handicapAllowanceRequestXml.getHarFormation().getHarStudiesLevel());
        handicapAllowanceRequest.setHarVocationalTrainingRequest(Boolean.valueOf(handicapAllowanceRequestXml.getHarProjectRequest().getHarVocationalTrainingRequest()));
        handicapAllowanceRequest.setHarDisabledWorkerRecognitionRequest(Boolean.valueOf(handicapAllowanceRequestXml.getHarProjectRequest().getHarDisabledWorkerRecognitionRequest()));
        handicapAllowanceRequest.setHarLegalAccessRepresentativeStreetName(handicapAllowanceRequestXml.getHarRequesterLegalAccess().getHarLegalAccessRepresentativeStreetName());
        handicapAllowanceRequest.setHarTransportCostAllocationRequest(Boolean.valueOf(handicapAllowanceRequestXml.getHarProjectRequest().getHarTransportCostAllocationRequest()));
        handicapAllowanceRequest.setHarDisabilityCompensation(Boolean.valueOf(handicapAllowanceRequestXml.getHarBenefits().getHarDisabilityCompensation()));
        if (handicapAllowanceRequestXml.getHarDwelling().getHarDwellingKind() != null)
            handicapAllowanceRequest.setHarDwellingKind(fr.cg95.cvq.business.request.social.HarDwellingKindType.forString(handicapAllowanceRequestXml.getHarDwelling().getHarDwellingKind().toString()));
        else
            handicapAllowanceRequest.setHarDwellingKind(fr.cg95.cvq.business.request.social.HarDwellingKindType.getDefaultHarDwellingKindType());
        handicapAllowanceRequest.setHarIsFamilyCarer(Boolean.valueOf(handicapAllowanceRequestXml.getHarIsFamilyCarer()));
        handicapAllowanceRequest.setHarCustomCar(Boolean.valueOf(handicapAllowanceRequestXml.getHarFacilities().getHarCustomCar()));
        handicapAllowanceRequest.setHarIsCarer(Boolean.valueOf(handicapAllowanceRequestXml.getHarIsCarer()));
        handicapAllowanceRequest.setHarLegalAccessRepresentativePhone(handicapAllowanceRequestXml.getHarRequesterLegalAccess().getHarLegalAccessRepresentativePhone());
        handicapAllowanceRequest.setHarAssistanceUnderDisabilityDetails(handicapAllowanceRequestXml.getHarStudies().getHarAssistanceUnderDisabilityDetails());
        handicapAllowanceRequest.setHarLessThan20RequesterParentMobilePhone(handicapAllowanceRequestXml.getHarLessThan20RequesterMother().getHarLessThan20RequesterParentMobilePhone());
        handicapAllowanceRequest.setHarLegalAccessRepresentativeName(handicapAllowanceRequestXml.getHarRequesterLegalAccess().getHarLegalAccessRepresentativeName());
        handicapAllowanceRequest.setHarDwellingReceptionPostalCode(handicapAllowanceRequestXml.getHarDwelling().getHarDwellingReceptionPostalCode());
        handicapAllowanceRequest.setHarCOTOREPDepartment(handicapAllowanceRequestXml.getHarCOTOREPFiles().getHarCOTOREPDepartment());
        handicapAllowanceRequest.setHarProfessionalOrientation(Boolean.valueOf(handicapAllowanceRequestXml.getHarBenefits().getHarProfessionalOrientation()));
        handicapAllowanceRequest.setHarPaymentAgencyPostalCode(handicapAllowanceRequestXml.getHarPaymentAgency().getHarPaymentAgencyPostalCode());
        if (handicapAllowanceRequestXml.getHarRequesterLegalAccess().getHarLegalAccessKind() != null)
            handicapAllowanceRequest.setHarLegalAccessKind(fr.cg95.cvq.business.request.social.HarLegalAccessKindType.forString(handicapAllowanceRequestXml.getHarRequesterLegalAccess().getHarLegalAccessKind().toString()));
        else
            handicapAllowanceRequest.setHarLegalAccessKind(fr.cg95.cvq.business.request.social.HarLegalAccessKindType.getDefaultHarLegalAccessKindType());
        handicapAllowanceRequest.setHarDwellingEstablishmentReception(Boolean.valueOf(handicapAllowanceRequestXml.getHarDwelling().getHarDwellingEstablishmentReception()));
        handicapAllowanceRequest.setHarLessThan20RequesterFirstName(handicapAllowanceRequestXml.getHarLessThan20Requester().getHarLessThan20RequesterFirstName());
        calendar = handicapAllowanceRequestXml.getHarRequesterReferent().getHarRequesterBirthDate();
        if (calendar != null) {
            handicapAllowanceRequest.setHarRequesterBirthDate(calendar.getTime());
        }
        handicapAllowanceRequest.setHarRequesterFirstName(handicapAllowanceRequestXml.getHarRequesterReferent().getHarRequesterFirstName());
        handicapAllowanceRequest.setHarExtraCurricular(handicapAllowanceRequestXml.getHarSchooling().getHarExtraCurricular());
        handicapAllowanceRequest.setHarLegalAccessRepresentativeEmail(handicapAllowanceRequestXml.getHarRequesterLegalAccess().getHarLegalAccessRepresentativeEmail());
        if (handicapAllowanceRequestXml.getHarProfessionalStatus().getHarProfessionalStatusEnvironment() != null)
            handicapAllowanceRequest.setHarProfessionalStatusEnvironment(fr.cg95.cvq.business.request.social.HarProfessionalStatusEnvironmentType.forString(handicapAllowanceRequestXml.getHarProfessionalStatus().getHarProfessionalStatusEnvironment().toString()));
        else
            handicapAllowanceRequest.setHarProfessionalStatusEnvironment(fr.cg95.cvq.business.request.social.HarProfessionalStatusEnvironmentType.getDefaultHarProfessionalStatusEnvironmentType());
        handicapAllowanceRequest.setHarElectiveFunctionDetails(Boolean.valueOf(handicapAllowanceRequestXml.getHarProfessionalStatus().getHarElectiveFunctionDetails()));
        handicapAllowanceRequest.setHarOrdinaryworkingRequest(Boolean.valueOf(handicapAllowanceRequestXml.getHarProjectRequest().getHarOrdinaryworkingRequest()));
        handicapAllowanceRequest.setHarIncreaseForIndependentLivingRequest(Boolean.valueOf(handicapAllowanceRequestXml.getHarProjectRequest().getHarIncreaseForIndependentLivingRequest()));
        handicapAllowanceRequest.setHarSocialProfessionalPostalCode(handicapAllowanceRequestXml.getHarFollowUp().getHarSocialProfessionalPostalCode());
        handicapAllowanceRequest.setHarLegalAccessRepresentativeCity(handicapAllowanceRequestXml.getHarRequesterLegalAccess().getHarLegalAccessRepresentativeCity());
        handicapAllowanceRequest.setHarSchoolCity(handicapAllowanceRequestXml.getHarSchooling().getHarSchoolCity());
        handicapAllowanceRequest.setHarDisabledPriorityCardRequest(Boolean.valueOf(handicapAllowanceRequestXml.getHarProjectRequest().getHarDisabledPriorityCardRequest()));
        handicapAllowanceRequest.setHarLessThan20RequesterRepresentativePostalCode(handicapAllowanceRequestXml.getHarLessThan20RequesterRepresentative().getHarLessThan20RequesterRepresentativePostalCode());
        if (handicapAllowanceRequestXml.getHarSchooling().getHarSchoolingKind() != null)
            handicapAllowanceRequest.setHarSchoolingKind(fr.cg95.cvq.business.request.social.HarSchoolingKindType.forString(handicapAllowanceRequestXml.getHarSchooling().getHarSchoolingKind().toString()));
        else
            handicapAllowanceRequest.setHarSchoolingKind(fr.cg95.cvq.business.request.social.HarSchoolingKindType.getDefaultHarSchoolingKindType());
        handicapAllowanceRequest.setHarProfessionalStatusAddress(handicapAllowanceRequestXml.getHarProfessionalStatus().getHarProfessionalStatusAddress());
        handicapAllowanceRequest.setFamilyHasFamilyDependents(Boolean.valueOf(handicapAllowanceRequestXml.getHarFamily().getFamilyHasFamilyDependents()));
        handicapAllowanceRequest.setHarLessThan20RequesterPhone(handicapAllowanceRequestXml.getHarLessThan20Requester().getHarLessThan20RequesterPhone());
        handicapAllowanceRequest.setHarSupplementForSingleParents(Boolean.valueOf(handicapAllowanceRequestXml.getHarBenefits().getHarSupplementForSingleParents()));
        handicapAllowanceRequest.setHarLessThan20RequesterRepresentativeReductionRatio(handicapAllowanceRequestXml.getHarLessThan20RequesterMother().getHarLessThan20RequesterRepresentativeReductionRatio());
        handicapAllowanceRequest.setHarDwellingSocialReceptionAddress(handicapAllowanceRequestXml.getHarDwelling().getHarDwellingSocialReceptionAddress());
        handicapAllowanceRequest.setHarDwellingReceptionCity(handicapAllowanceRequestXml.getHarDwelling().getHarDwellingReceptionCity());
        handicapAllowanceRequest.setHarFollowedByProfessional(Boolean.valueOf(handicapAllowanceRequestXml.getHarCareFollowUp().getHarFollowedByProfessional()));
        handicapAllowanceRequest.setHarShelteredWorkRequest(Boolean.valueOf(handicapAllowanceRequestXml.getHarProjectRequest().getHarShelteredWorkRequest()));
        handicapAllowanceRequest.setHarLessThan20RequesterMobilePhone(handicapAllowanceRequestXml.getHarLessThan20Requester().getHarLessThan20RequesterMobilePhone());
        calendar = handicapAllowanceRequestXml.getHarProfessionalStatus().getHarIndemnifiedDate();
        if (calendar != null) {
            handicapAllowanceRequest.setHarIndemnifiedDate(calendar.getTime());
        }
        handicapAllowanceRequest.setHarAnimalAidDetails(handicapAllowanceRequestXml.getHarFacilities().getHarAnimalAidDetails());
        handicapAllowanceRequest.setHarElectiveFunction(Boolean.valueOf(handicapAllowanceRequestXml.getHarProfessionalStatus().getHarElectiveFunction()));
        handicapAllowanceRequest.setHarHomeSchoolingAccompanistLastName(handicapAllowanceRequestXml.getHarSchooling().getHarHomeSchoolingAccompanistLastName());
        handicapAllowanceRequest.setHarDisabilityPensionCategory(handicapAllowanceRequestXml.getHarBenefits().getHarDisabilityPensionCategory());
        handicapAllowanceRequest.setHarRequesterName(handicapAllowanceRequestXml.getHarRequesterReferent().getHarRequesterName());
        if (handicapAllowanceRequestXml.getHarProfessionalStatus().getHarProfessionalStatusKind() != null)
            handicapAllowanceRequest.setHarProfessionalStatusKind(fr.cg95.cvq.business.request.social.HarProfessionalStatusKindType.forString(handicapAllowanceRequestXml.getHarProfessionalStatus().getHarProfessionalStatusKind().toString()));
        else
            handicapAllowanceRequest.setHarProfessionalStatusKind(fr.cg95.cvq.business.request.social.HarProfessionalStatusKindType.getDefaultHarProfessionalStatusKindType());
        handicapAllowanceRequest.setHarSocialSecurityAgencyAddress(handicapAllowanceRequestXml.getHarSocialSecurity().getHarSocialSecurityAgencyAddress());
        handicapAllowanceRequest.setHarPaymentAgencyName(handicapAllowanceRequestXml.getHarPaymentAgency().getHarPaymentAgencyName());
        handicapAllowanceRequest.setHarRequesterMaidenName(handicapAllowanceRequestXml.getHarRequesterReferent().getHarRequesterMaidenName());
        handicapAllowanceRequest.setHarLessThan20RequesterParentPhone(handicapAllowanceRequestXml.getHarLessThan20RequesterMother().getHarLessThan20RequesterParentPhone());
        handicapAllowanceRequest.setHarSocialProfessionalCity(handicapAllowanceRequestXml.getHarFollowUp().getHarSocialProfessionalCity());
        handicapAllowanceRequest.setHarTechnicalAssistance(Boolean.valueOf(handicapAllowanceRequestXml.getHarFacilities().getHarTechnicalAssistance()));
        handicapAllowanceRequest.setHarLessThan20RequesterParentJob(handicapAllowanceRequestXml.getHarLessThan20RequesterMother().getHarLessThan20RequesterParentJob());
        calendar = handicapAllowanceRequestXml.getHarLessThan20Requester().getHarLessThan20RequesterBirthDate();
        if (calendar != null) {
            handicapAllowanceRequest.setHarLessThan20RequesterBirthDate(calendar.getTime());
        }
        handicapAllowanceRequest.setHarMDPHNumber(handicapAllowanceRequestXml.getHarMDPHFiles().getHarMDPHNumber());
        if (handicapAllowanceRequestXml.getHarDwelling().getHarDwellingReceptionType() != null)
            handicapAllowanceRequest.setHarDwellingReceptionType(fr.cg95.cvq.business.request.social.HarDwellingReceptionKindType.forString(handicapAllowanceRequestXml.getHarDwelling().getHarDwellingReceptionType().toString()));
        else
            handicapAllowanceRequest.setHarDwellingReceptionType(fr.cg95.cvq.business.request.social.HarDwellingReceptionKindType.getDefaultHarDwellingReceptionKindType());
        handicapAllowanceRequest.setHarDisabledAdultAllowanceRequest(Boolean.valueOf(handicapAllowanceRequestXml.getHarProjectRequest().getHarDisabledAdultAllowanceRequest()));
        handicapAllowanceRequest.setHarDwellingSocialReceptionPostalCode(handicapAllowanceRequestXml.getHarDwelling().getHarDwellingSocialReceptionPostalCode());
        handicapAllowanceRequest.setHarDisabledAdultAllocation(Boolean.valueOf(handicapAllowanceRequestXml.getHarBenefits().getHarDisabledAdultAllocation()));
        handicapAllowanceRequest.setHarRequesterPhone(handicapAllowanceRequestXml.getHarRequesterReferent().getHarRequesterPhone());
        handicapAllowanceRequest.setHarThridPartySupplement(Boolean.valueOf(handicapAllowanceRequestXml.getHarBenefits().getHarThridPartySupplement()));
        handicapAllowanceRequest.setHarDisabilityCardRequest(Boolean.valueOf(handicapAllowanceRequestXml.getHarProjectRequest().getHarDisabilityCardRequest()));
        if (handicapAllowanceRequestXml.getHarRequesterLegalAccess().getHarLegalAccessRepresentativeKind() != null)
            handicapAllowanceRequest.setHarLegalAccessRepresentativeKind(fr.cg95.cvq.business.request.social.HarLegalAccessRepresentativeKindType.forString(handicapAllowanceRequestXml.getHarRequesterLegalAccess().getHarLegalAccessRepresentativeKind().toString()));
        else
            handicapAllowanceRequest.setHarLegalAccessRepresentativeKind(fr.cg95.cvq.business.request.social.HarLegalAccessRepresentativeKindType.getDefaultHarLegalAccessRepresentativeKindType());
        handicapAllowanceRequest.setHarProfessionalStatusPostalCode(handicapAllowanceRequestXml.getHarProfessionalStatus().getHarProfessionalStatusPostalCode());
        handicapAllowanceRequest.setHarProfessionalEvaluation(Boolean.valueOf(handicapAllowanceRequestXml.getHarProfessionalEvaluation()));
        handicapAllowanceRequest.setHarEducationAllocationOfDisabledChildrenRequest(Boolean.valueOf(handicapAllowanceRequestXml.getHarProjectRequest().getHarEducationAllocationOfDisabledChildrenRequest()));
        handicapAllowanceRequest.setHarSchoolPostalCode(handicapAllowanceRequestXml.getHarSchooling().getHarSchoolPostalCode());
        handicapAllowanceRequest.setHarDwellingReceptionAddress(handicapAllowanceRequestXml.getHarDwelling().getHarDwellingReceptionAddress());
        handicapAllowanceRequest.setHarRequesterPostalCode(handicapAllowanceRequestXml.getHarRequesterReferent().getHarRequesterPostalCode());
        handicapAllowanceRequest.setHarFollowedByProfessionalDetails(handicapAllowanceRequestXml.getHarCareFollowUp().getHarFollowedByProfessionalDetails());
        handicapAllowanceRequest.setHarSchoolingTime(handicapAllowanceRequestXml.getHarSchooling().getHarSchoolingTime());
        if (handicapAllowanceRequestXml.getHarPaymentAgency().getHarPaymentAgencyBeneficiary() != null)
            handicapAllowanceRequest.setHarPaymentAgencyBeneficiary(fr.cg95.cvq.business.request.social.HarPaymentAgencyBeneficiaryType.forString(handicapAllowanceRequestXml.getHarPaymentAgency().getHarPaymentAgencyBeneficiary().toString()));
        else
            handicapAllowanceRequest.setHarPaymentAgencyBeneficiary(fr.cg95.cvq.business.request.social.HarPaymentAgencyBeneficiaryType.getDefaultHarPaymentAgencyBeneficiaryType());
        handicapAllowanceRequest.setHarSendToSchool(Boolean.valueOf(handicapAllowanceRequestXml.getHarSchooling().getHarSendToSchool()));
        handicapAllowanceRequest.setHarSpecializedGradeDetails(handicapAllowanceRequestXml.getHarSchooling().getHarSpecializedGradeDetails());
        handicapAllowanceRequest.setHarSocialProfessionalLastName(handicapAllowanceRequestXml.getHarFollowUp().getHarSocialProfessionalLastName());
        handicapAllowanceRequest.setHarPaymentAgencyCity(handicapAllowanceRequestXml.getHarPaymentAgency().getHarPaymentAgencyCity());
        handicapAllowanceRequest.setHarSupportedByAnInstitutionDetails(handicapAllowanceRequestXml.getHarBenefits().getHarSupportedByAnInstitutionDetails());
        if (handicapAllowanceRequestXml.getHarSchooling().getHarHomeSchoolingKind() != null)
            handicapAllowanceRequest.setHarHomeSchoolingKind(fr.cg95.cvq.business.request.social.HarHomeSchoolingKindType.forString(handicapAllowanceRequestXml.getHarSchooling().getHarHomeSchoolingKind().toString()));
        else
            handicapAllowanceRequest.setHarHomeSchoolingKind(fr.cg95.cvq.business.request.social.HarHomeSchoolingKindType.getDefaultHarHomeSchoolingKindType());
        handicapAllowanceRequest.setHarLessThan20RequesterRepresentativeActivityReduction(Boolean.valueOf(handicapAllowanceRequestXml.getHarLessThan20RequesterMother().getHarLessThan20RequesterRepresentativeActivityReduction()));
        handicapAllowanceRequest.setHarLessThan20RequesterRepresentativeMobilePhone(handicapAllowanceRequestXml.getHarLessThan20RequesterRepresentative().getHarLessThan20RequesterRepresentativeMobilePhone());
        List<fr.cg95.cvq.business.request.social.HarCarer> harCarerList = new ArrayList<fr.cg95.cvq.business.request.social.HarCarer> ();
        if ( handicapAllowanceRequestXml.sizeOfHarCarerArray() > 0) {
            for (int i = 0; i < handicapAllowanceRequestXml.getHarCarerArray().length; i++) {
                harCarerList.add(HarCarer.xmlToModel(handicapAllowanceRequestXml.getHarCarerArray(i)));
            }
        }
        handicapAllowanceRequest.setHarCarer(harCarerList);
        handicapAllowanceRequest.setHarDwellingPrecision(handicapAllowanceRequestXml.getHarDwelling().getHarDwellingPrecision());
        handicapAllowanceRequest.setHarRegisterAsUnemployed(Boolean.valueOf(handicapAllowanceRequestXml.getHarProfessionalStatus().getHarRegisterAsUnemployed()));
        handicapAllowanceRequest.setHarProjectComments(handicapAllowanceRequestXml.getHarProjectComments());
        handicapAllowanceRequest.setHarRequesterMobilePhone(handicapAllowanceRequestXml.getHarRequesterReferent().getHarRequesterMobilePhone());
        if (handicapAllowanceRequestXml.getHarRequesterReferent().getHarRequesterTitle() != null)
            handicapAllowanceRequest.setHarRequesterTitle(fr.cg95.cvq.business.request.social.HarTitleType.forString(handicapAllowanceRequestXml.getHarRequesterReferent().getHarRequesterTitle().toString()));
        else
            handicapAllowanceRequest.setHarRequesterTitle(fr.cg95.cvq.business.request.social.HarTitleType.getDefaultHarTitleType());
        handicapAllowanceRequest.setHarLessThan20RequesterParentStreetName(handicapAllowanceRequestXml.getHarLessThan20RequesterMother().getHarLessThan20RequesterParentStreetName());
        handicapAllowanceRequest.setHarSocialProfessionalAddress(handicapAllowanceRequestXml.getHarFollowUp().getHarSocialProfessionalAddress());
        handicapAllowanceRequest.setHarCustomCarDetails(handicapAllowanceRequestXml.getHarFacilities().getHarCustomCarDetails());
        handicapAllowanceRequest.setHarLessThan20RequesterEmail(handicapAllowanceRequestXml.getHarLessThan20Requester().getHarLessThan20RequesterEmail());
        handicapAllowanceRequest.setHarThridPartyCompensatoryAllowance(Boolean.valueOf(handicapAllowanceRequestXml.getHarBenefits().getHarThridPartyCompensatoryAllowance()));
        handicapAllowanceRequest.setHarMDPHFile(Boolean.valueOf(handicapAllowanceRequestXml.getHarMDPHFiles().getHarMDPHFile()));
        handicapAllowanceRequest.setHarAdditionalAllocationForEducationOfDisabledChildrenDetails(handicapAllowanceRequestXml.getHarBenefits().getHarAdditionalAllocationForEducationOfDisabledChildrenDetails());
        handicapAllowanceRequest.setHarEducationAllocationOfDisabledChildren(Boolean.valueOf(handicapAllowanceRequestXml.getHarBenefits().getHarEducationAllocationOfDisabledChildren()));
        handicapAllowanceRequest.setHarThridPersonCompensatoryAllowance(Boolean.valueOf(handicapAllowanceRequestXml.getHarBenefits().getHarThridPersonCompensatoryAllowance()));
        handicapAllowanceRequest.setHarCustomCarRequest(Boolean.valueOf(handicapAllowanceRequestXml.getHarProjectRequest().getHarCustomCarRequest()));
        handicapAllowanceRequest.setHarAnimalAid(Boolean.valueOf(handicapAllowanceRequestXml.getHarFacilities().getHarAnimalAid()));
        calendar = handicapAllowanceRequestXml.getHarProfessionalStatus().getHarRegisterAsUnemployedDate();
        if (calendar != null) {
            handicapAllowanceRequest.setHarRegisterAsUnemployedDate(calendar.getTime());
        }
        handicapAllowanceRequest.setHarProfessionalOrientationRequest(Boolean.valueOf(handicapAllowanceRequestXml.getHarProjectRequest().getHarProfessionalOrientationRequest()));
        handicapAllowanceRequest.setHarRequesterEmail(handicapAllowanceRequestXml.getHarRequesterReferent().getHarRequesterEmail());
        handicapAllowanceRequest.setHarFollowedByHospital(Boolean.valueOf(handicapAllowanceRequestXml.getHarCareFollowUp().getHarFollowedByHospital()));
        handicapAllowanceRequest.setHarIncreaseForIndependentLiving(Boolean.valueOf(handicapAllowanceRequestXml.getHarBenefits().getHarIncreaseForIndependentLiving()));
        handicapAllowanceRequest.setHarLessThan20RequesterParentPostalCode(handicapAllowanceRequestXml.getHarLessThan20RequesterMother().getHarLessThan20RequesterParentPostalCode());
        handicapAllowanceRequest.setHarLegalAccessRepresentativeFirstName(handicapAllowanceRequestXml.getHarRequesterLegalAccess().getHarLegalAccessRepresentativeFirstName());
        handicapAllowanceRequest.setHarDisabilityCostAllocationRequest(Boolean.valueOf(handicapAllowanceRequestXml.getHarProjectRequest().getHarDisabilityCostAllocationRequest()));
        handicapAllowanceRequest.setDwellingReceptionNaming(handicapAllowanceRequestXml.getHarDwelling().getDwellingReceptionNaming());
        handicapAllowanceRequest.setHarProjectWish(handicapAllowanceRequestXml.getHarProjectWish());
        handicapAllowanceRequest.setHarSocialSecurityAgencyCity(handicapAllowanceRequestXml.getHarSocialSecurity().getHarSocialSecurityAgencyCity());
        handicapAllowanceRequest.setHarLessThan20RequesterParentName(handicapAllowanceRequestXml.getHarLessThan20RequesterMother().getHarLessThan20RequesterParentName());
        handicapAllowanceRequest.setHarLessThan20RequesterStreetName(handicapAllowanceRequestXml.getHarLessThan20Requester().getHarLessThan20RequesterStreetName());
        handicapAllowanceRequest.setHarDiploma(handicapAllowanceRequestXml.getHarFormation().getHarDiploma());
        handicapAllowanceRequest.setHarEuropeanParkingCardRequest(Boolean.valueOf(handicapAllowanceRequestXml.getHarProjectRequest().getHarEuropeanParkingCardRequest()));
        if (handicapAllowanceRequestXml.getHarRequesterReferent().getHarRequesterBirthCountry() != null)
            handicapAllowanceRequest.setHarRequesterBirthCountry(fr.cg95.cvq.business.users.CountryType.forString(handicapAllowanceRequestXml.getHarRequesterReferent().getHarRequesterBirthCountry().toString()));
        else
            handicapAllowanceRequest.setHarRequesterBirthCountry(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
        handicapAllowanceRequest.setHarProfessionalStatusCity(handicapAllowanceRequestXml.getHarProfessionalStatus().getHarProfessionalStatusCity());
        handicapAllowanceRequest.setHarLessThan20RequesterPostalCode(handicapAllowanceRequestXml.getHarLessThan20Requester().getHarLessThan20RequesterPostalCode());
        handicapAllowanceRequest.setHarMDPHDepartment(handicapAllowanceRequestXml.getHarMDPHFiles().getHarMDPHDepartment());
        handicapAllowanceRequest.setHarLessThan20RequesterRepresentativePhone(handicapAllowanceRequestXml.getHarLessThan20RequesterRepresentative().getHarLessThan20RequesterRepresentativePhone());
        handicapAllowanceRequest.setHarAssistanceUnderDisability(Boolean.valueOf(handicapAllowanceRequestXml.getHarStudies().getHarAssistanceUnderDisability()));
        handicapAllowanceRequest.setHarWorkAccidentAnnuity(Boolean.valueOf(handicapAllowanceRequestXml.getHarBenefits().getHarWorkAccidentAnnuity()));
        List<fr.cg95.cvq.business.request.social.HarOtherFiles> harOtherFilesList = new ArrayList<fr.cg95.cvq.business.request.social.HarOtherFiles> ();
        if ( handicapAllowanceRequestXml.sizeOfHarOtherFilesArray() > 0) {
            for (int i = 0; i < handicapAllowanceRequestXml.getHarOtherFilesArray().length; i++) {
                harOtherFilesList.add(HarOtherFiles.xmlToModel(handicapAllowanceRequestXml.getHarOtherFilesArray(i)));
            }
        }
        handicapAllowanceRequest.setHarOtherFiles(harOtherFilesList);
        handicapAllowanceRequest.setHarUnemploymentBenefits(Boolean.valueOf(handicapAllowanceRequestXml.getHarBenefits().getHarUnemploymentBenefits()));
        handicapAllowanceRequest.setHarProfessionalOrientationDetails(handicapAllowanceRequestXml.getHarBenefits().getHarProfessionalOrientationDetails());
        handicapAllowanceRequest.setHarHousingFacilitiesRequest(Boolean.valueOf(handicapAllowanceRequestXml.getHarProjectRequest().getHarHousingFacilitiesRequest()));
        handicapAllowanceRequest.setHarHomeSchoolingAccompanistCity(handicapAllowanceRequestXml.getHarSchooling().getHarHomeSchoolingAccompanistCity());
        handicapAllowanceRequest.setHarDwellingSocialReceptionNaming(handicapAllowanceRequestXml.getHarDwelling().getHarDwellingSocialReceptionNaming());
        handicapAllowanceRequest.setHarPersonalizedSchoolingPlan(Boolean.valueOf(handicapAllowanceRequestXml.getHarSchooling().getHarPersonalizedSchoolingPlan()));
        handicapAllowanceRequest.setHarAssistanceRequest(Boolean.valueOf(handicapAllowanceRequestXml.getHarProjectRequest().getHarAssistanceRequest()));
        handicapAllowanceRequest.setHarSocialWelfare(Boolean.valueOf(handicapAllowanceRequestXml.getHarBenefits().getHarSocialWelfare()));
        handicapAllowanceRequest.setHarHomeSchoolingAccompanistAddress(handicapAllowanceRequestXml.getHarSchooling().getHarHomeSchoolingAccompanistAddress());
        handicapAllowanceRequest.setHarInstitutionSupportRequest(Boolean.valueOf(handicapAllowanceRequestXml.getHarProjectRequest().getHarInstitutionSupportRequest()));
        handicapAllowanceRequest.setHarThirdPartyHelpRequest(Boolean.valueOf(handicapAllowanceRequestXml.getHarProjectRequest().getHarThirdPartyHelpRequest()));
        handicapAllowanceRequest.setHarHomeSchoolingAccompanistPostalCode(handicapAllowanceRequestXml.getHarSchooling().getHarHomeSchoolingAccompanistPostalCode());
        calendar = handicapAllowanceRequestXml.getHarProfessionalStatus().getHarProfessionalStatusDate();
        if (calendar != null) {
            handicapAllowanceRequest.setHarProfessionalStatusDate(calendar.getTime());
        }
        handicapAllowanceRequest.setHarDisabilityRecognitionRequest(Boolean.valueOf(handicapAllowanceRequestXml.getHarProjectRequest().getHarDisabilityRecognitionRequest()));
        handicapAllowanceRequest.setHarRequestDealWithSameProfessional(Boolean.valueOf(handicapAllowanceRequestXml.getHarRequestDealWithSameProfessional()));
        if (handicapAllowanceRequestXml.getHarLessThan20Requester().getHarLessThan20RequesterBirthCountry() != null)
            handicapAllowanceRequest.setHarLessThan20RequesterBirthCountry(fr.cg95.cvq.business.users.CountryType.forString(handicapAllowanceRequestXml.getHarLessThan20Requester().getHarLessThan20RequesterBirthCountry().toString()));
        else
            handicapAllowanceRequest.setHarLessThan20RequesterBirthCountry(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
        handicapAllowanceRequest.setHarHighSchoolName(handicapAllowanceRequestXml.getHarStudies().getHarHighSchoolName());
        handicapAllowanceRequest.setHarPainfulStandingCard(Boolean.valueOf(handicapAllowanceRequestXml.getHarBenefits().getHarPainfulStandingCard()));
        return handicapAllowanceRequest;
    }

    private fr.cg95.cvq.business.request.social.HarGenderType harLessThan20RequesterGender;

    public final void setHarLessThan20RequesterGender(final fr.cg95.cvq.business.request.social.HarGenderType harLessThan20RequesterGender) {
        this.harLessThan20RequesterGender = harLessThan20RequesterGender;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_gender"
     */
    public final fr.cg95.cvq.business.request.social.HarGenderType getHarLessThan20RequesterGender() {
        return this.harLessThan20RequesterGender;
    }

    private List<fr.cg95.cvq.business.request.social.HarDisabilityRelatedCost> harDisabilityRelatedCost;

    public final void setHarDisabilityRelatedCost(final List<fr.cg95.cvq.business.request.social.HarDisabilityRelatedCost> harDisabilityRelatedCost) {
        this.harDisabilityRelatedCost = harDisabilityRelatedCost;
    }


    /**
     * @hibernate.list
     *  inverse="false"
     *  lazy="false"
     *  cascade="all"
     * @hibernate.key
     *  column="handicap_allowance_request_id"
     * @hibernate.list-index
     *  column="har_disability_related_cost_index"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.request.social.HarDisabilityRelatedCost"
     */
    public final List<fr.cg95.cvq.business.request.social.HarDisabilityRelatedCost> getHarDisabilityRelatedCost() {
        return this.harDisabilityRelatedCost;
    }

    private String harPaymentAgencyBeneficiaryNumber;

    public final void setHarPaymentAgencyBeneficiaryNumber(final String harPaymentAgencyBeneficiaryNumber) {
        this.harPaymentAgencyBeneficiaryNumber = harPaymentAgencyBeneficiaryNumber;
    }


    /**
     * @hibernate.property
     *  column="har_payment_agency_beneficiary_number"
     */
    public final String getHarPaymentAgencyBeneficiaryNumber() {
        return this.harPaymentAgencyBeneficiaryNumber;
    }

    private String harPreviousFormation;

    public final void setHarPreviousFormation(final String harPreviousFormation) {
        this.harPreviousFormation = harPreviousFormation;
    }


    /**
     * @hibernate.property
     *  column="har_previous_formation"
     */
    public final String getHarPreviousFormation() {
        return this.harPreviousFormation;
    }

    private Boolean harFollowUp;

    public final void setHarFollowUp(final Boolean harFollowUp) {
        this.harFollowUp = harFollowUp;
    }


    /**
     * @hibernate.property
     *  column="har_follow_up"
     */
    public final Boolean getHarFollowUp() {
        return this.harFollowUp;
    }

    private Boolean harLegalAccessPresence;

    public final void setHarLegalAccessPresence(final Boolean harLegalAccessPresence) {
        this.harLegalAccessPresence = harLegalAccessPresence;
    }


    /**
     * @hibernate.property
     *  column="har_legal_access_presence"
     */
    public final Boolean getHarLegalAccessPresence() {
        return this.harLegalAccessPresence;
    }

    private String harSocialSecurityAgencyName;

    public final void setHarSocialSecurityAgencyName(final String harSocialSecurityAgencyName) {
        this.harSocialSecurityAgencyName = harSocialSecurityAgencyName;
    }


    /**
     * @hibernate.property
     *  column="har_social_security_agency_name"
     */
    public final String getHarSocialSecurityAgencyName() {
        return this.harSocialSecurityAgencyName;
    }

    private String harRequesterCity;

    public final void setHarRequesterCity(final String harRequesterCity) {
        this.harRequesterCity = harRequesterCity;
    }


    /**
     * @hibernate.property
     *  column="har_requester_city"
     *  length="32"
     */
    public final String getHarRequesterCity() {
        return this.harRequesterCity;
    }

    private List<fr.cg95.cvq.business.request.social.HarProfessional> harProfessional;

    public final void setHarProfessional(final List<fr.cg95.cvq.business.request.social.HarProfessional> harProfessional) {
        this.harProfessional = harProfessional;
    }


    /**
     * @hibernate.list
     *  inverse="false"
     *  lazy="false"
     *  cascade="all"
     * @hibernate.key
     *  column="handicap_allowance_request_id"
     * @hibernate.list-index
     *  column="har_professional_index"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.request.social.HarProfessional"
     */
    public final List<fr.cg95.cvq.business.request.social.HarProfessional> getHarProfessional() {
        return this.harProfessional;
    }

    private Boolean harDisabilityRecognition;

    public final void setHarDisabilityRecognition(final Boolean harDisabilityRecognition) {
        this.harDisabilityRecognition = harDisabilityRecognition;
    }


    /**
     * @hibernate.property
     *  column="har_disability_recognition"
     */
    public final Boolean getHarDisabilityRecognition() {
        return this.harDisabilityRecognition;
    }

    private Boolean harAdditionalAllocationForEducationOfDisabledChildren;

    public final void setHarAdditionalAllocationForEducationOfDisabledChildren(final Boolean harAdditionalAllocationForEducationOfDisabledChildren) {
        this.harAdditionalAllocationForEducationOfDisabledChildren = harAdditionalAllocationForEducationOfDisabledChildren;
    }


    /**
     * @hibernate.property
     *  column="har_additional_allocation_for_education_of_disabled_children"
     */
    public final Boolean getHarAdditionalAllocationForEducationOfDisabledChildren() {
        return this.harAdditionalAllocationForEducationOfDisabledChildren;
    }

    private String harLessThan20RequesterRepresentativeFirstName;

    public final void setHarLessThan20RequesterRepresentativeFirstName(final String harLessThan20RequesterRepresentativeFirstName) {
        this.harLessThan20RequesterRepresentativeFirstName = harLessThan20RequesterRepresentativeFirstName;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_representative_first_name"
     *  length="38"
     */
    public final String getHarLessThan20RequesterRepresentativeFirstName() {
        return this.harLessThan20RequesterRepresentativeFirstName;
    }

    private Boolean harDisabilityPension;

    public final void setHarDisabilityPension(final Boolean harDisabilityPension) {
        this.harDisabilityPension = harDisabilityPension;
    }


    /**
     * @hibernate.property
     *  column="har_disability_pension"
     */
    public final Boolean getHarDisabilityPension() {
        return this.harDisabilityPension;
    }

    private Boolean harDisabilityCard;

    public final void setHarDisabilityCard(final Boolean harDisabilityCard) {
        this.harDisabilityCard = harDisabilityCard;
    }


    /**
     * @hibernate.property
     *  column="har_disability_card"
     */
    public final Boolean getHarDisabilityCard() {
        return this.harDisabilityCard;
    }

    private Boolean harFreePensionMembershipRequest;

    public final void setHarFreePensionMembershipRequest(final Boolean harFreePensionMembershipRequest) {
        this.harFreePensionMembershipRequest = harFreePensionMembershipRequest;
    }


    /**
     * @hibernate.property
     *  column="har_free_pension_membership_request"
     */
    public final Boolean getHarFreePensionMembershipRequest() {
        return this.harFreePensionMembershipRequest;
    }

    private fr.cg95.cvq.business.request.social.HarLessThan20RequesterAuthorityHolderType harLessThan20RequesterAuthorityHolder;

    public final void setHarLessThan20RequesterAuthorityHolder(final fr.cg95.cvq.business.request.social.HarLessThan20RequesterAuthorityHolderType harLessThan20RequesterAuthorityHolder) {
        this.harLessThan20RequesterAuthorityHolder = harLessThan20RequesterAuthorityHolder;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_authority_holder"
     */
    public final fr.cg95.cvq.business.request.social.HarLessThan20RequesterAuthorityHolderType getHarLessThan20RequesterAuthorityHolder() {
        return this.harLessThan20RequesterAuthorityHolder;
    }

    private String harHousingFacilitiesDetails;

    public final void setHarHousingFacilitiesDetails(final String harHousingFacilitiesDetails) {
        this.harHousingFacilitiesDetails = harHousingFacilitiesDetails;
    }


    /**
     * @hibernate.property
     *  column="har_housing_facilities_details"
     */
    public final String getHarHousingFacilitiesDetails() {
        return this.harHousingFacilitiesDetails;
    }

    private Boolean harSpecializedTransport;

    public final void setHarSpecializedTransport(final Boolean harSpecializedTransport) {
        this.harSpecializedTransport = harSpecializedTransport;
    }


    /**
     * @hibernate.property
     *  column="har_specialized_transport"
     */
    public final Boolean getHarSpecializedTransport() {
        return this.harSpecializedTransport;
    }

    private String harSocialSecurityAgencyPostalCode;

    public final void setHarSocialSecurityAgencyPostalCode(final String harSocialSecurityAgencyPostalCode) {
        this.harSocialSecurityAgencyPostalCode = harSocialSecurityAgencyPostalCode;
    }


    /**
     * @hibernate.property
     *  column="har_social_security_agency_postal_code"
     *  length="5"
     */
    public final String getHarSocialSecurityAgencyPostalCode() {
        return this.harSocialSecurityAgencyPostalCode;
    }

    private String harSchoolAddress;

    public final void setHarSchoolAddress(final String harSchoolAddress) {
        this.harSchoolAddress = harSchoolAddress;
    }


    /**
     * @hibernate.property
     *  column="har_school_address"
     */
    public final String getHarSchoolAddress() {
        return this.harSchoolAddress;
    }

    private String harAttendedGrade;

    public final void setHarAttendedGrade(final String harAttendedGrade) {
        this.harAttendedGrade = harAttendedGrade;
    }


    /**
     * @hibernate.property
     *  column="har_attended_grade"
     */
    public final String getHarAttendedGrade() {
        return this.harAttendedGrade;
    }

    private Boolean harHousingFacilities;

    public final void setHarHousingFacilities(final Boolean harHousingFacilities) {
        this.harHousingFacilities = harHousingFacilities;
    }


    /**
     * @hibernate.property
     *  column="har_housing_facilities"
     */
    public final Boolean getHarHousingFacilities() {
        return this.harHousingFacilities;
    }

    private Boolean harHomeSchooling;

    public final void setHarHomeSchooling(final Boolean harHomeSchooling) {
        this.harHomeSchooling = harHomeSchooling;
    }


    /**
     * @hibernate.property
     *  column="har_home_schooling"
     */
    public final Boolean getHarHomeSchooling() {
        return this.harHomeSchooling;
    }

    private Boolean harFollowedByPhysician;

    public final void setHarFollowedByPhysician(final Boolean harFollowedByPhysician) {
        this.harFollowedByPhysician = harFollowedByPhysician;
    }


    /**
     * @hibernate.property
     *  column="har_followed_by_physician"
     */
    public final Boolean getHarFollowedByPhysician() {
        return this.harFollowedByPhysician;
    }

    private String harDwellingSocialReceptionCity;

    public final void setHarDwellingSocialReceptionCity(final String harDwellingSocialReceptionCity) {
        this.harDwellingSocialReceptionCity = harDwellingSocialReceptionCity;
    }


    /**
     * @hibernate.property
     *  column="har_dwelling_social_reception_city"
     *  length="32"
     */
    public final String getHarDwellingSocialReceptionCity() {
        return this.harDwellingSocialReceptionCity;
    }

    private Boolean harOtherRequest;

    public final void setHarOtherRequest(final Boolean harOtherRequest) {
        this.harOtherRequest = harOtherRequest;
    }


    /**
     * @hibernate.property
     *  column="har_other_request"
     */
    public final Boolean getHarOtherRequest() {
        return this.harOtherRequest;
    }

    private Boolean harParkingCard;

    public final void setHarParkingCard(final Boolean harParkingCard) {
        this.harParkingCard = harParkingCard;
    }


    /**
     * @hibernate.property
     *  column="har_parking_card"
     */
    public final Boolean getHarParkingCard() {
        return this.harParkingCard;
    }

    private fr.cg95.cvq.business.request.social.HarFamilyStatusType familyStatus;

    public final void setFamilyStatus(final fr.cg95.cvq.business.request.social.HarFamilyStatusType familyStatus) {
        this.familyStatus = familyStatus;
    }


    /**
     * @hibernate.property
     *  column="family_status"
     */
    public final fr.cg95.cvq.business.request.social.HarFamilyStatusType getFamilyStatus() {
        return this.familyStatus;
    }

    private String harLessThan20RequesterRepresentativeDepartment;

    public final void setHarLessThan20RequesterRepresentativeDepartment(final String harLessThan20RequesterRepresentativeDepartment) {
        this.harLessThan20RequesterRepresentativeDepartment = harLessThan20RequesterRepresentativeDepartment;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_representative_department"
     *  length="2"
     */
    public final String getHarLessThan20RequesterRepresentativeDepartment() {
        return this.harLessThan20RequesterRepresentativeDepartment;
    }

    private String harSpecializedTransportDetails;

    public final void setHarSpecializedTransportDetails(final String harSpecializedTransportDetails) {
        this.harSpecializedTransportDetails = harSpecializedTransportDetails;
    }


    /**
     * @hibernate.property
     *  column="har_specialized_transport_details"
     */
    public final String getHarSpecializedTransportDetails() {
        return this.harSpecializedTransportDetails;
    }

    private String harLessThan20RequesterRepresentativeCity;

    public final void setHarLessThan20RequesterRepresentativeCity(final String harLessThan20RequesterRepresentativeCity) {
        this.harLessThan20RequesterRepresentativeCity = harLessThan20RequesterRepresentativeCity;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_representative_city"
     *  length="32"
     */
    public final String getHarLessThan20RequesterRepresentativeCity() {
        return this.harLessThan20RequesterRepresentativeCity;
    }

    private String harRequesterBirthCity;

    public final void setHarRequesterBirthCity(final String harRequesterBirthCity) {
        this.harRequesterBirthCity = harRequesterBirthCity;
    }


    /**
     * @hibernate.property
     *  column="har_requester_birth_city"
     *  length="32"
     */
    public final String getHarRequesterBirthCity() {
        return this.harRequesterBirthCity;
    }

    private String harProfessionalStatusProfession;

    public final void setHarProfessionalStatusProfession(final String harProfessionalStatusProfession) {
        this.harProfessionalStatusProfession = harProfessionalStatusProfession;
    }


    /**
     * @hibernate.property
     *  column="har_professional_status_profession"
     */
    public final String getHarProfessionalStatusProfession() {
        return this.harProfessionalStatusProfession;
    }

    private String harCDESDepartment;

    public final void setHarCDESDepartment(final String harCDESDepartment) {
        this.harCDESDepartment = harCDESDepartment;
    }


    /**
     * @hibernate.property
     *  column="har_c_d_e_s_department"
     */
    public final String getHarCDESDepartment() {
        return this.harCDESDepartment;
    }

    private Boolean harCompensatoryAllowanceForExpenses;

    public final void setHarCompensatoryAllowanceForExpenses(final Boolean harCompensatoryAllowanceForExpenses) {
        this.harCompensatoryAllowanceForExpenses = harCompensatoryAllowanceForExpenses;
    }


    /**
     * @hibernate.property
     *  column="har_compensatory_allowance_for_expenses"
     */
    public final Boolean getHarCompensatoryAllowanceForExpenses() {
        return this.harCompensatoryAllowanceForExpenses;
    }

    private String harPaymentAgencyAddress;

    public final void setHarPaymentAgencyAddress(final String harPaymentAgencyAddress) {
        this.harPaymentAgencyAddress = harPaymentAgencyAddress;
    }


    /**
     * @hibernate.property
     *  column="har_payment_agency_address"
     */
    public final String getHarPaymentAgencyAddress() {
        return this.harPaymentAgencyAddress;
    }

    private String harLessThan20RequesterRepresentativeStreetName;

    public final void setHarLessThan20RequesterRepresentativeStreetName(final String harLessThan20RequesterRepresentativeStreetName) {
        this.harLessThan20RequesterRepresentativeStreetName = harLessThan20RequesterRepresentativeStreetName;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_representative_street_name"
     */
    public final String getHarLessThan20RequesterRepresentativeStreetName() {
        return this.harLessThan20RequesterRepresentativeStreetName;
    }

    private Boolean harCDESFile;

    public final void setHarCDESFile(final Boolean harCDESFile) {
        this.harCDESFile = harCDESFile;
    }


    /**
     * @hibernate.property
     *  column="har_c_d_e_s_file"
     */
    public final Boolean getHarCDESFile() {
        return this.harCDESFile;
    }

    private String harFollowedByPhysicianDetails;

    public final void setHarFollowedByPhysicianDetails(final String harFollowedByPhysicianDetails) {
        this.harFollowedByPhysicianDetails = harFollowedByPhysicianDetails;
    }


    /**
     * @hibernate.property
     *  column="har_followed_by_physician_details"
     */
    public final String getHarFollowedByPhysicianDetails() {
        return this.harFollowedByPhysicianDetails;
    }

    private String harLessThan20RequesterCity;

    public final void setHarLessThan20RequesterCity(final String harLessThan20RequesterCity) {
        this.harLessThan20RequesterCity = harLessThan20RequesterCity;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_city"
     *  length="32"
     */
    public final String getHarLessThan20RequesterCity() {
        return this.harLessThan20RequesterCity;
    }

    private String harCurrentFormation;

    public final void setHarCurrentFormation(final String harCurrentFormation) {
        this.harCurrentFormation = harCurrentFormation;
    }


    /**
     * @hibernate.property
     *  column="har_current_formation"
     */
    public final String getHarCurrentFormation() {
        return this.harCurrentFormation;
    }

    private List<fr.cg95.cvq.business.request.social.HarCareAssistant> harCareAssistant;

    public final void setHarCareAssistant(final List<fr.cg95.cvq.business.request.social.HarCareAssistant> harCareAssistant) {
        this.harCareAssistant = harCareAssistant;
    }


    /**
     * @hibernate.list
     *  inverse="false"
     *  lazy="false"
     *  cascade="all"
     * @hibernate.key
     *  column="handicap_allowance_request_id"
     * @hibernate.list-index
     *  column="har_care_assistant_index"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.request.social.HarCareAssistant"
     */
    public final List<fr.cg95.cvq.business.request.social.HarCareAssistant> getHarCareAssistant() {
        return this.harCareAssistant;
    }

    private String harLessThan20RequesterRepresentativeName;

    public final void setHarLessThan20RequesterRepresentativeName(final String harLessThan20RequesterRepresentativeName) {
        this.harLessThan20RequesterRepresentativeName = harLessThan20RequesterRepresentativeName;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_representative_name"
     *  length="38"
     */
    public final String getHarLessThan20RequesterRepresentativeName() {
        return this.harLessThan20RequesterRepresentativeName;
    }

    private String harLessThan20RequesterParentFirstName;

    public final void setHarLessThan20RequesterParentFirstName(final String harLessThan20RequesterParentFirstName) {
        this.harLessThan20RequesterParentFirstName = harLessThan20RequesterParentFirstName;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_parent_first_name"
     *  length="38"
     */
    public final String getHarLessThan20RequesterParentFirstName() {
        return this.harLessThan20RequesterParentFirstName;
    }

    private String harCOTOREPNumber;

    public final void setHarCOTOREPNumber(final String harCOTOREPNumber) {
        this.harCOTOREPNumber = harCOTOREPNumber;
    }


    /**
     * @hibernate.property
     *  column="har_c_o_t_o_r_e_p_number"
     */
    public final String getHarCOTOREPNumber() {
        return this.harCOTOREPNumber;
    }

    private Boolean harDisabledWorkerRecognition;

    public final void setHarDisabledWorkerRecognition(final Boolean harDisabledWorkerRecognition) {
        this.harDisabledWorkerRecognition = harDisabledWorkerRecognition;
    }


    /**
     * @hibernate.property
     *  column="har_disabled_worker_recognition"
     */
    public final Boolean getHarDisabledWorkerRecognition() {
        return this.harDisabledWorkerRecognition;
    }

    private String harHighSchoolCity;

    public final void setHarHighSchoolCity(final String harHighSchoolCity) {
        this.harHighSchoolCity = harHighSchoolCity;
    }


    /**
     * @hibernate.property
     *  column="har_high_school_city"
     *  length="32"
     */
    public final String getHarHighSchoolCity() {
        return this.harHighSchoolCity;
    }

    private Boolean harTechnicalHelpRequest;

    public final void setHarTechnicalHelpRequest(final Boolean harTechnicalHelpRequest) {
        this.harTechnicalHelpRequest = harTechnicalHelpRequest;
    }


    /**
     * @hibernate.property
     *  column="har_technical_help_request"
     */
    public final Boolean getHarTechnicalHelpRequest() {
        return this.harTechnicalHelpRequest;
    }

    private String harFollowedByHospitalDetails;

    public final void setHarFollowedByHospitalDetails(final String harFollowedByHospitalDetails) {
        this.harFollowedByHospitalDetails = harFollowedByHospitalDetails;
    }


    /**
     * @hibernate.property
     *  column="har_followed_by_hospital_details"
     */
    public final String getHarFollowedByHospitalDetails() {
        return this.harFollowedByHospitalDetails;
    }

    private String harProjectNeeds;

    public final void setHarProjectNeeds(final String harProjectNeeds) {
        this.harProjectNeeds = harProjectNeeds;
    }


    /**
     * @hibernate.property
     *  column="har_project_needs"
     */
    public final String getHarProjectNeeds() {
        return this.harProjectNeeds;
    }

    private String harTechnicalAssistanceDetails;

    public final void setHarTechnicalAssistanceDetails(final String harTechnicalAssistanceDetails) {
        this.harTechnicalAssistanceDetails = harTechnicalAssistanceDetails;
    }


    /**
     * @hibernate.property
     *  column="har_technical_assistance_details"
     */
    public final String getHarTechnicalAssistanceDetails() {
        return this.harTechnicalAssistanceDetails;
    }

    private String harCDESNumber;

    public final void setHarCDESNumber(final String harCDESNumber) {
        this.harCDESNumber = harCDESNumber;
    }


    /**
     * @hibernate.property
     *  column="har_c_d_e_s_number"
     */
    public final String getHarCDESNumber() {
        return this.harCDESNumber;
    }

    private String harHighSchoolGrade;

    public final void setHarHighSchoolGrade(final String harHighSchoolGrade) {
        this.harHighSchoolGrade = harHighSchoolGrade;
    }


    /**
     * @hibernate.property
     *  column="har_high_school_grade"
     */
    public final String getHarHighSchoolGrade() {
        return this.harHighSchoolGrade;
    }

    private Boolean harHighSchool;

    public final void setHarHighSchool(final Boolean harHighSchool) {
        this.harHighSchool = harHighSchool;
    }


    /**
     * @hibernate.property
     *  column="har_high_school"
     */
    public final Boolean getHarHighSchool() {
        return this.harHighSchool;
    }

    private String harSchoolName;

    public final void setHarSchoolName(final String harSchoolName) {
        this.harSchoolName = harSchoolName;
    }


    /**
     * @hibernate.property
     *  column="har_school_name"
     */
    public final String getHarSchoolName() {
        return this.harSchoolName;
    }

    private String harLessThan20RequesterName;

    public final void setHarLessThan20RequesterName(final String harLessThan20RequesterName) {
        this.harLessThan20RequesterName = harLessThan20RequesterName;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_name"
     *  length="38"
     */
    public final String getHarLessThan20RequesterName() {
        return this.harLessThan20RequesterName;
    }

    private String harLegalAccessRepresentativeKindDetail;

    public final void setHarLegalAccessRepresentativeKindDetail(final String harLegalAccessRepresentativeKindDetail) {
        this.harLegalAccessRepresentativeKindDetail = harLegalAccessRepresentativeKindDetail;
    }


    /**
     * @hibernate.property
     *  column="har_legal_access_representative_kind_detail"
     */
    public final String getHarLegalAccessRepresentativeKindDetail() {
        return this.harLegalAccessRepresentativeKindDetail;
    }

    private String harHomeSchoolingAccompanistFirstName;

    public final void setHarHomeSchoolingAccompanistFirstName(final String harHomeSchoolingAccompanistFirstName) {
        this.harHomeSchoolingAccompanistFirstName = harHomeSchoolingAccompanistFirstName;
    }


    /**
     * @hibernate.property
     *  column="har_home_schooling_accompanist_first_name"
     *  length="38"
     */
    public final String getHarHomeSchoolingAccompanistFirstName() {
        return this.harHomeSchoolingAccompanistFirstName;
    }

    private String harHighSchoolPostalCode;

    public final void setHarHighSchoolPostalCode(final String harHighSchoolPostalCode) {
        this.harHighSchoolPostalCode = harHighSchoolPostalCode;
    }


    /**
     * @hibernate.property
     *  column="har_high_school_postal_code"
     *  length="5"
     */
    public final String getHarHighSchoolPostalCode() {
        return this.harHighSchoolPostalCode;
    }

    private fr.cg95.cvq.business.request.social.HarRequestInformationProfileType harRequestInformationProfile;

    public final void setHarRequestInformationProfile(final fr.cg95.cvq.business.request.social.HarRequestInformationProfileType harRequestInformationProfile) {
        this.harRequestInformationProfile = harRequestInformationProfile;
    }


    /**
     * @hibernate.property
     *  column="har_request_information_profile"
     */
    public final fr.cg95.cvq.business.request.social.HarRequestInformationProfileType getHarRequestInformationProfile() {
        return this.harRequestInformationProfile;
    }

    private Boolean harIndemnified;

    public final void setHarIndemnified(final Boolean harIndemnified) {
        this.harIndemnified = harIndemnified;
    }


    /**
     * @hibernate.property
     *  column="har_indemnified"
     */
    public final Boolean getHarIndemnified() {
        return this.harIndemnified;
    }

    private String harOtherRequestDetails;

    public final void setHarOtherRequestDetails(final String harOtherRequestDetails) {
        this.harOtherRequestDetails = harOtherRequestDetails;
    }


    /**
     * @hibernate.property
     *  column="har_other_request_details"
     */
    public final String getHarOtherRequestDetails() {
        return this.harOtherRequestDetails;
    }

    private String harHighSchoolAddress;

    public final void setHarHighSchoolAddress(final String harHighSchoolAddress) {
        this.harHighSchoolAddress = harHighSchoolAddress;
    }


    /**
     * @hibernate.property
     *  column="har_high_school_address"
     */
    public final String getHarHighSchoolAddress() {
        return this.harHighSchoolAddress;
    }

    private Boolean harIsCareAssistant;

    public final void setHarIsCareAssistant(final Boolean harIsCareAssistant) {
        this.harIsCareAssistant = harIsCareAssistant;
    }


    /**
     * @hibernate.property
     *  column="har_is_care_assistant"
     */
    public final Boolean getHarIsCareAssistant() {
        return this.harIsCareAssistant;
    }

    private String harLegalAccessRepresentativePostalCode;

    public final void setHarLegalAccessRepresentativePostalCode(final String harLegalAccessRepresentativePostalCode) {
        this.harLegalAccessRepresentativePostalCode = harLegalAccessRepresentativePostalCode;
    }


    /**
     * @hibernate.property
     *  column="har_legal_access_representative_postal_code"
     *  length="5"
     */
    public final String getHarLegalAccessRepresentativePostalCode() {
        return this.harLegalAccessRepresentativePostalCode;
    }

    private Boolean harCOTOREPFile;

    public final void setHarCOTOREPFile(final Boolean harCOTOREPFile) {
        this.harCOTOREPFile = harCOTOREPFile;
    }


    /**
     * @hibernate.property
     *  column="har_c_o_t_o_r_e_p_file"
     */
    public final Boolean getHarCOTOREPFile() {
        return this.harCOTOREPFile;
    }

    private Boolean harDailyAllowances;

    public final void setHarDailyAllowances(final Boolean harDailyAllowances) {
        this.harDailyAllowances = harDailyAllowances;
    }


    /**
     * @hibernate.property
     *  column="har_daily_allowances"
     */
    public final Boolean getHarDailyAllowances() {
        return this.harDailyAllowances;
    }

    private String harLessThan20RequesterBirthCity;

    public final void setHarLessThan20RequesterBirthCity(final String harLessThan20RequesterBirthCity) {
        this.harLessThan20RequesterBirthCity = harLessThan20RequesterBirthCity;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_birth_city"
     *  length="32"
     */
    public final String getHarLessThan20RequesterBirthCity() {
        return this.harLessThan20RequesterBirthCity;
    }

    private fr.cg95.cvq.business.request.social.HarSocialSecurityMemberShipKindType harSocialSecurityMemberShipKind;

    public final void setHarSocialSecurityMemberShipKind(final fr.cg95.cvq.business.request.social.HarSocialSecurityMemberShipKindType harSocialSecurityMemberShipKind) {
        this.harSocialSecurityMemberShipKind = harSocialSecurityMemberShipKind;
    }


    /**
     * @hibernate.property
     *  column="har_social_security_member_ship_kind"
     */
    public final fr.cg95.cvq.business.request.social.HarSocialSecurityMemberShipKindType getHarSocialSecurityMemberShipKind() {
        return this.harSocialSecurityMemberShipKind;
    }

    private String harSocialSecurityNumber;

    public final void setHarSocialSecurityNumber(final String harSocialSecurityNumber) {
        this.harSocialSecurityNumber = harSocialSecurityNumber;
    }


    /**
     * @hibernate.property
     *  column="har_social_security_number"
     *  length="13"
     */
    public final String getHarSocialSecurityNumber() {
        return this.harSocialSecurityNumber;
    }

    private List<fr.cg95.cvq.business.request.social.HarFamilyCarer> harFamilyCarer;

    public final void setHarFamilyCarer(final List<fr.cg95.cvq.business.request.social.HarFamilyCarer> harFamilyCarer) {
        this.harFamilyCarer = harFamilyCarer;
    }


    /**
     * @hibernate.list
     *  inverse="false"
     *  lazy="false"
     *  cascade="all"
     * @hibernate.key
     *  column="handicap_allowance_request_id"
     * @hibernate.list-index
     *  column="har_family_carer_index"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.request.social.HarFamilyCarer"
     */
    public final List<fr.cg95.cvq.business.request.social.HarFamilyCarer> getHarFamilyCarer() {
        return this.harFamilyCarer;
    }

    private List<fr.cg95.cvq.business.request.social.HarFamilyDependent> harFamilyDependent;

    public final void setHarFamilyDependent(final List<fr.cg95.cvq.business.request.social.HarFamilyDependent> harFamilyDependent) {
        this.harFamilyDependent = harFamilyDependent;
    }


    /**
     * @hibernate.list
     *  inverse="false"
     *  lazy="false"
     *  cascade="all"
     * @hibernate.key
     *  column="handicap_allowance_request_id"
     * @hibernate.list-index
     *  column="har_family_dependent_index"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.request.social.HarFamilyDependent"
     */
    public final List<fr.cg95.cvq.business.request.social.HarFamilyDependent> getHarFamilyDependent() {
        return this.harFamilyDependent;
    }

    private String harLegalAccessRepresentativeMobilePhone;

    public final void setHarLegalAccessRepresentativeMobilePhone(final String harLegalAccessRepresentativeMobilePhone) {
        this.harLegalAccessRepresentativeMobilePhone = harLegalAccessRepresentativeMobilePhone;
    }


    /**
     * @hibernate.property
     *  column="har_legal_access_representative_mobile_phone"
     *  length="10"
     */
    public final String getHarLegalAccessRepresentativeMobilePhone() {
        return this.harLegalAccessRepresentativeMobilePhone;
    }

    private Boolean harPTCARenewalRequest;

    public final void setHarPTCARenewalRequest(final Boolean harPTCARenewalRequest) {
        this.harPTCARenewalRequest = harPTCARenewalRequest;
    }


    /**
     * @hibernate.property
     *  column="har_p_t_c_a_renewal_request"
     */
    public final Boolean getHarPTCARenewalRequest() {
        return this.harPTCARenewalRequest;
    }

    private Boolean harSchoolingEnrolment;

    public final void setHarSchoolingEnrolment(final Boolean harSchoolingEnrolment) {
        this.harSchoolingEnrolment = harSchoolingEnrolment;
    }


    /**
     * @hibernate.property
     *  column="har_schooling_enrolment"
     */
    public final Boolean getHarSchoolingEnrolment() {
        return this.harSchoolingEnrolment;
    }

    private Boolean harSpecializedGrade;

    public final void setHarSpecializedGrade(final Boolean harSpecializedGrade) {
        this.harSpecializedGrade = harSpecializedGrade;
    }


    /**
     * @hibernate.property
     *  column="har_specialized_grade"
     */
    public final Boolean getHarSpecializedGrade() {
        return this.harSpecializedGrade;
    }

    private Boolean harDwellingSocialReception;

    public final void setHarDwellingSocialReception(final Boolean harDwellingSocialReception) {
        this.harDwellingSocialReception = harDwellingSocialReception;
    }


    /**
     * @hibernate.property
     *  column="har_dwelling_social_reception"
     */
    public final Boolean getHarDwellingSocialReception() {
        return this.harDwellingSocialReception;
    }

    private String harRequesterStreetName;

    public final void setHarRequesterStreetName(final String harRequesterStreetName) {
        this.harRequesterStreetName = harRequesterStreetName;
    }


    /**
     * @hibernate.property
     *  column="har_requester_street_name"
     */
    public final String getHarRequesterStreetName() {
        return this.harRequesterStreetName;
    }

    private String harLessThan20RequesterParentCity;

    public final void setHarLessThan20RequesterParentCity(final String harLessThan20RequesterParentCity) {
        this.harLessThan20RequesterParentCity = harLessThan20RequesterParentCity;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_parent_city"
     *  length="32"
     */
    public final String getHarLessThan20RequesterParentCity() {
        return this.harLessThan20RequesterParentCity;
    }

    private Boolean harSupportedByAnInstitution;

    public final void setHarSupportedByAnInstitution(final Boolean harSupportedByAnInstitution) {
        this.harSupportedByAnInstitution = harSupportedByAnInstitution;
    }


    /**
     * @hibernate.property
     *  column="har_supported_by_an_institution"
     */
    public final Boolean getHarSupportedByAnInstitution() {
        return this.harSupportedByAnInstitution;
    }

    private String harStudiesLevel;

    public final void setHarStudiesLevel(final String harStudiesLevel) {
        this.harStudiesLevel = harStudiesLevel;
    }


    /**
     * @hibernate.property
     *  column="har_studies_level"
     */
    public final String getHarStudiesLevel() {
        return this.harStudiesLevel;
    }

    private Boolean harVocationalTrainingRequest;

    public final void setHarVocationalTrainingRequest(final Boolean harVocationalTrainingRequest) {
        this.harVocationalTrainingRequest = harVocationalTrainingRequest;
    }


    /**
     * @hibernate.property
     *  column="har_vocational_training_request"
     */
    public final Boolean getHarVocationalTrainingRequest() {
        return this.harVocationalTrainingRequest;
    }

    private Boolean harDisabledWorkerRecognitionRequest;

    public final void setHarDisabledWorkerRecognitionRequest(final Boolean harDisabledWorkerRecognitionRequest) {
        this.harDisabledWorkerRecognitionRequest = harDisabledWorkerRecognitionRequest;
    }


    /**
     * @hibernate.property
     *  column="har_disabled_worker_recognition_request"
     */
    public final Boolean getHarDisabledWorkerRecognitionRequest() {
        return this.harDisabledWorkerRecognitionRequest;
    }

    private String harLegalAccessRepresentativeStreetName;

    public final void setHarLegalAccessRepresentativeStreetName(final String harLegalAccessRepresentativeStreetName) {
        this.harLegalAccessRepresentativeStreetName = harLegalAccessRepresentativeStreetName;
    }


    /**
     * @hibernate.property
     *  column="har_legal_access_representative_street_name"
     */
    public final String getHarLegalAccessRepresentativeStreetName() {
        return this.harLegalAccessRepresentativeStreetName;
    }

    private Boolean harTransportCostAllocationRequest;

    public final void setHarTransportCostAllocationRequest(final Boolean harTransportCostAllocationRequest) {
        this.harTransportCostAllocationRequest = harTransportCostAllocationRequest;
    }


    /**
     * @hibernate.property
     *  column="har_transport_cost_allocation_request"
     */
    public final Boolean getHarTransportCostAllocationRequest() {
        return this.harTransportCostAllocationRequest;
    }

    private Boolean harDisabilityCompensation;

    public final void setHarDisabilityCompensation(final Boolean harDisabilityCompensation) {
        this.harDisabilityCompensation = harDisabilityCompensation;
    }


    /**
     * @hibernate.property
     *  column="har_disability_compensation"
     */
    public final Boolean getHarDisabilityCompensation() {
        return this.harDisabilityCompensation;
    }

    private fr.cg95.cvq.business.request.social.HarDwellingKindType harDwellingKind;

    public final void setHarDwellingKind(final fr.cg95.cvq.business.request.social.HarDwellingKindType harDwellingKind) {
        this.harDwellingKind = harDwellingKind;
    }


    /**
     * @hibernate.property
     *  column="har_dwelling_kind"
     */
    public final fr.cg95.cvq.business.request.social.HarDwellingKindType getHarDwellingKind() {
        return this.harDwellingKind;
    }

    private Boolean harIsFamilyCarer;

    public final void setHarIsFamilyCarer(final Boolean harIsFamilyCarer) {
        this.harIsFamilyCarer = harIsFamilyCarer;
    }


    /**
     * @hibernate.property
     *  column="har_is_family_carer"
     */
    public final Boolean getHarIsFamilyCarer() {
        return this.harIsFamilyCarer;
    }

    private Boolean harCustomCar;

    public final void setHarCustomCar(final Boolean harCustomCar) {
        this.harCustomCar = harCustomCar;
    }


    /**
     * @hibernate.property
     *  column="har_custom_car"
     */
    public final Boolean getHarCustomCar() {
        return this.harCustomCar;
    }

    private Boolean harIsCarer;

    public final void setHarIsCarer(final Boolean harIsCarer) {
        this.harIsCarer = harIsCarer;
    }


    /**
     * @hibernate.property
     *  column="har_is_carer"
     */
    public final Boolean getHarIsCarer() {
        return this.harIsCarer;
    }

    private String harLegalAccessRepresentativePhone;

    public final void setHarLegalAccessRepresentativePhone(final String harLegalAccessRepresentativePhone) {
        this.harLegalAccessRepresentativePhone = harLegalAccessRepresentativePhone;
    }


    /**
     * @hibernate.property
     *  column="har_legal_access_representative_phone"
     *  length="10"
     */
    public final String getHarLegalAccessRepresentativePhone() {
        return this.harLegalAccessRepresentativePhone;
    }

    private String harAssistanceUnderDisabilityDetails;

    public final void setHarAssistanceUnderDisabilityDetails(final String harAssistanceUnderDisabilityDetails) {
        this.harAssistanceUnderDisabilityDetails = harAssistanceUnderDisabilityDetails;
    }


    /**
     * @hibernate.property
     *  column="har_assistance_under_disability_details"
     */
    public final String getHarAssistanceUnderDisabilityDetails() {
        return this.harAssistanceUnderDisabilityDetails;
    }

    private String harLessThan20RequesterParentMobilePhone;

    public final void setHarLessThan20RequesterParentMobilePhone(final String harLessThan20RequesterParentMobilePhone) {
        this.harLessThan20RequesterParentMobilePhone = harLessThan20RequesterParentMobilePhone;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_parent_mobile_phone"
     *  length="10"
     */
    public final String getHarLessThan20RequesterParentMobilePhone() {
        return this.harLessThan20RequesterParentMobilePhone;
    }

    private String harLegalAccessRepresentativeName;

    public final void setHarLegalAccessRepresentativeName(final String harLegalAccessRepresentativeName) {
        this.harLegalAccessRepresentativeName = harLegalAccessRepresentativeName;
    }


    /**
     * @hibernate.property
     *  column="har_legal_access_representative_name"
     *  length="38"
     */
    public final String getHarLegalAccessRepresentativeName() {
        return this.harLegalAccessRepresentativeName;
    }

    private String harDwellingReceptionPostalCode;

    public final void setHarDwellingReceptionPostalCode(final String harDwellingReceptionPostalCode) {
        this.harDwellingReceptionPostalCode = harDwellingReceptionPostalCode;
    }


    /**
     * @hibernate.property
     *  column="har_dwelling_reception_postal_code"
     *  length="5"
     */
    public final String getHarDwellingReceptionPostalCode() {
        return this.harDwellingReceptionPostalCode;
    }

    private String harCOTOREPDepartment;

    public final void setHarCOTOREPDepartment(final String harCOTOREPDepartment) {
        this.harCOTOREPDepartment = harCOTOREPDepartment;
    }


    /**
     * @hibernate.property
     *  column="har_c_o_t_o_r_e_p_department"
     */
    public final String getHarCOTOREPDepartment() {
        return this.harCOTOREPDepartment;
    }

    private Boolean harProfessionalOrientation;

    public final void setHarProfessionalOrientation(final Boolean harProfessionalOrientation) {
        this.harProfessionalOrientation = harProfessionalOrientation;
    }


    /**
     * @hibernate.property
     *  column="har_professional_orientation"
     */
    public final Boolean getHarProfessionalOrientation() {
        return this.harProfessionalOrientation;
    }

    private String harPaymentAgencyPostalCode;

    public final void setHarPaymentAgencyPostalCode(final String harPaymentAgencyPostalCode) {
        this.harPaymentAgencyPostalCode = harPaymentAgencyPostalCode;
    }


    /**
     * @hibernate.property
     *  column="har_payment_agency_postal_code"
     *  length="5"
     */
    public final String getHarPaymentAgencyPostalCode() {
        return this.harPaymentAgencyPostalCode;
    }

    private fr.cg95.cvq.business.request.social.HarLegalAccessKindType harLegalAccessKind;

    public final void setHarLegalAccessKind(final fr.cg95.cvq.business.request.social.HarLegalAccessKindType harLegalAccessKind) {
        this.harLegalAccessKind = harLegalAccessKind;
    }


    /**
     * @hibernate.property
     *  column="har_legal_access_kind"
     */
    public final fr.cg95.cvq.business.request.social.HarLegalAccessKindType getHarLegalAccessKind() {
        return this.harLegalAccessKind;
    }

    private Boolean harDwellingEstablishmentReception;

    public final void setHarDwellingEstablishmentReception(final Boolean harDwellingEstablishmentReception) {
        this.harDwellingEstablishmentReception = harDwellingEstablishmentReception;
    }


    /**
     * @hibernate.property
     *  column="har_dwelling_establishment_reception"
     */
    public final Boolean getHarDwellingEstablishmentReception() {
        return this.harDwellingEstablishmentReception;
    }

    private String harLessThan20RequesterFirstName;

    public final void setHarLessThan20RequesterFirstName(final String harLessThan20RequesterFirstName) {
        this.harLessThan20RequesterFirstName = harLessThan20RequesterFirstName;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_first_name"
     *  length="38"
     */
    public final String getHarLessThan20RequesterFirstName() {
        return this.harLessThan20RequesterFirstName;
    }

    private java.util.Date harRequesterBirthDate;

    public final void setHarRequesterBirthDate(final java.util.Date harRequesterBirthDate) {
        this.harRequesterBirthDate = harRequesterBirthDate;
    }


    /**
     * @hibernate.property
     *  column="har_requester_birth_date"
     */
    public final java.util.Date getHarRequesterBirthDate() {
        return this.harRequesterBirthDate;
    }

    private String harRequesterFirstName;

    public final void setHarRequesterFirstName(final String harRequesterFirstName) {
        this.harRequesterFirstName = harRequesterFirstName;
    }


    /**
     * @hibernate.property
     *  column="har_requester_first_name"
     *  length="38"
     */
    public final String getHarRequesterFirstName() {
        return this.harRequesterFirstName;
    }

    private String harExtraCurricular;

    public final void setHarExtraCurricular(final String harExtraCurricular) {
        this.harExtraCurricular = harExtraCurricular;
    }


    /**
     * @hibernate.property
     *  column="har_extra_curricular"
     */
    public final String getHarExtraCurricular() {
        return this.harExtraCurricular;
    }

    private String harLegalAccessRepresentativeEmail;

    public final void setHarLegalAccessRepresentativeEmail(final String harLegalAccessRepresentativeEmail) {
        this.harLegalAccessRepresentativeEmail = harLegalAccessRepresentativeEmail;
    }


    /**
     * @hibernate.property
     *  column="har_legal_access_representative_email"
     */
    public final String getHarLegalAccessRepresentativeEmail() {
        return this.harLegalAccessRepresentativeEmail;
    }

    private fr.cg95.cvq.business.request.social.HarProfessionalStatusEnvironmentType harProfessionalStatusEnvironment;

    public final void setHarProfessionalStatusEnvironment(final fr.cg95.cvq.business.request.social.HarProfessionalStatusEnvironmentType harProfessionalStatusEnvironment) {
        this.harProfessionalStatusEnvironment = harProfessionalStatusEnvironment;
    }


    /**
     * @hibernate.property
     *  column="har_professional_status_environment"
     */
    public final fr.cg95.cvq.business.request.social.HarProfessionalStatusEnvironmentType getHarProfessionalStatusEnvironment() {
        return this.harProfessionalStatusEnvironment;
    }

    private Boolean harElectiveFunctionDetails;

    public final void setHarElectiveFunctionDetails(final Boolean harElectiveFunctionDetails) {
        this.harElectiveFunctionDetails = harElectiveFunctionDetails;
    }


    /**
     * @hibernate.property
     *  column="har_elective_function_details"
     */
    public final Boolean getHarElectiveFunctionDetails() {
        return this.harElectiveFunctionDetails;
    }

    private Boolean harOrdinaryworkingRequest;

    public final void setHarOrdinaryworkingRequest(final Boolean harOrdinaryworkingRequest) {
        this.harOrdinaryworkingRequest = harOrdinaryworkingRequest;
    }


    /**
     * @hibernate.property
     *  column="har_ordinaryworking_request"
     */
    public final Boolean getHarOrdinaryworkingRequest() {
        return this.harOrdinaryworkingRequest;
    }

    private Boolean harIncreaseForIndependentLivingRequest;

    public final void setHarIncreaseForIndependentLivingRequest(final Boolean harIncreaseForIndependentLivingRequest) {
        this.harIncreaseForIndependentLivingRequest = harIncreaseForIndependentLivingRequest;
    }


    /**
     * @hibernate.property
     *  column="har_increase_for_independent_living_request"
     */
    public final Boolean getHarIncreaseForIndependentLivingRequest() {
        return this.harIncreaseForIndependentLivingRequest;
    }

    private String harSocialProfessionalPostalCode;

    public final void setHarSocialProfessionalPostalCode(final String harSocialProfessionalPostalCode) {
        this.harSocialProfessionalPostalCode = harSocialProfessionalPostalCode;
    }


    /**
     * @hibernate.property
     *  column="har_social_professional_postal_code"
     *  length="5"
     */
    public final String getHarSocialProfessionalPostalCode() {
        return this.harSocialProfessionalPostalCode;
    }

    private String harLegalAccessRepresentativeCity;

    public final void setHarLegalAccessRepresentativeCity(final String harLegalAccessRepresentativeCity) {
        this.harLegalAccessRepresentativeCity = harLegalAccessRepresentativeCity;
    }


    /**
     * @hibernate.property
     *  column="har_legal_access_representative_city"
     *  length="32"
     */
    public final String getHarLegalAccessRepresentativeCity() {
        return this.harLegalAccessRepresentativeCity;
    }

    private String harSchoolCity;

    public final void setHarSchoolCity(final String harSchoolCity) {
        this.harSchoolCity = harSchoolCity;
    }


    /**
     * @hibernate.property
     *  column="har_school_city"
     *  length="32"
     */
    public final String getHarSchoolCity() {
        return this.harSchoolCity;
    }

    private Boolean harDisabledPriorityCardRequest;

    public final void setHarDisabledPriorityCardRequest(final Boolean harDisabledPriorityCardRequest) {
        this.harDisabledPriorityCardRequest = harDisabledPriorityCardRequest;
    }


    /**
     * @hibernate.property
     *  column="har_disabled_priority_card_request"
     */
    public final Boolean getHarDisabledPriorityCardRequest() {
        return this.harDisabledPriorityCardRequest;
    }

    private String harLessThan20RequesterRepresentativePostalCode;

    public final void setHarLessThan20RequesterRepresentativePostalCode(final String harLessThan20RequesterRepresentativePostalCode) {
        this.harLessThan20RequesterRepresentativePostalCode = harLessThan20RequesterRepresentativePostalCode;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_representative_postal_code"
     *  length="5"
     */
    public final String getHarLessThan20RequesterRepresentativePostalCode() {
        return this.harLessThan20RequesterRepresentativePostalCode;
    }

    private fr.cg95.cvq.business.request.social.HarSchoolingKindType harSchoolingKind;

    public final void setHarSchoolingKind(final fr.cg95.cvq.business.request.social.HarSchoolingKindType harSchoolingKind) {
        this.harSchoolingKind = harSchoolingKind;
    }


    /**
     * @hibernate.property
     *  column="har_schooling_kind"
     */
    public final fr.cg95.cvq.business.request.social.HarSchoolingKindType getHarSchoolingKind() {
        return this.harSchoolingKind;
    }

    private String harProfessionalStatusAddress;

    public final void setHarProfessionalStatusAddress(final String harProfessionalStatusAddress) {
        this.harProfessionalStatusAddress = harProfessionalStatusAddress;
    }


    /**
     * @hibernate.property
     *  column="har_professional_status_address"
     */
    public final String getHarProfessionalStatusAddress() {
        return this.harProfessionalStatusAddress;
    }

    private Boolean familyHasFamilyDependents;

    public final void setFamilyHasFamilyDependents(final Boolean familyHasFamilyDependents) {
        this.familyHasFamilyDependents = familyHasFamilyDependents;
    }


    /**
     * @hibernate.property
     *  column="family_has_family_dependents"
     */
    public final Boolean getFamilyHasFamilyDependents() {
        return this.familyHasFamilyDependents;
    }

    private String harLessThan20RequesterPhone;

    public final void setHarLessThan20RequesterPhone(final String harLessThan20RequesterPhone) {
        this.harLessThan20RequesterPhone = harLessThan20RequesterPhone;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_phone"
     *  length="10"
     */
    public final String getHarLessThan20RequesterPhone() {
        return this.harLessThan20RequesterPhone;
    }

    private Boolean harSupplementForSingleParents;

    public final void setHarSupplementForSingleParents(final Boolean harSupplementForSingleParents) {
        this.harSupplementForSingleParents = harSupplementForSingleParents;
    }


    /**
     * @hibernate.property
     *  column="har_supplement_for_single_parents"
     */
    public final Boolean getHarSupplementForSingleParents() {
        return this.harSupplementForSingleParents;
    }

    private java.math.BigInteger harLessThan20RequesterRepresentativeReductionRatio;

    public final void setHarLessThan20RequesterRepresentativeReductionRatio(final java.math.BigInteger harLessThan20RequesterRepresentativeReductionRatio) {
        this.harLessThan20RequesterRepresentativeReductionRatio = harLessThan20RequesterRepresentativeReductionRatio;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_representative_reduction_ratio"
     *  type="serializable"
     */
    public final java.math.BigInteger getHarLessThan20RequesterRepresentativeReductionRatio() {
        return this.harLessThan20RequesterRepresentativeReductionRatio;
    }

    private String harDwellingSocialReceptionAddress;

    public final void setHarDwellingSocialReceptionAddress(final String harDwellingSocialReceptionAddress) {
        this.harDwellingSocialReceptionAddress = harDwellingSocialReceptionAddress;
    }


    /**
     * @hibernate.property
     *  column="har_dwelling_social_reception_address"
     */
    public final String getHarDwellingSocialReceptionAddress() {
        return this.harDwellingSocialReceptionAddress;
    }

    private String harDwellingReceptionCity;

    public final void setHarDwellingReceptionCity(final String harDwellingReceptionCity) {
        this.harDwellingReceptionCity = harDwellingReceptionCity;
    }


    /**
     * @hibernate.property
     *  column="har_dwelling_reception_city"
     *  length="32"
     */
    public final String getHarDwellingReceptionCity() {
        return this.harDwellingReceptionCity;
    }

    private Boolean harFollowedByProfessional;

    public final void setHarFollowedByProfessional(final Boolean harFollowedByProfessional) {
        this.harFollowedByProfessional = harFollowedByProfessional;
    }


    /**
     * @hibernate.property
     *  column="har_followed_by_professional"
     */
    public final Boolean getHarFollowedByProfessional() {
        return this.harFollowedByProfessional;
    }

    private Boolean harShelteredWorkRequest;

    public final void setHarShelteredWorkRequest(final Boolean harShelteredWorkRequest) {
        this.harShelteredWorkRequest = harShelteredWorkRequest;
    }


    /**
     * @hibernate.property
     *  column="har_sheltered_work_request"
     */
    public final Boolean getHarShelteredWorkRequest() {
        return this.harShelteredWorkRequest;
    }

    private String harLessThan20RequesterMobilePhone;

    public final void setHarLessThan20RequesterMobilePhone(final String harLessThan20RequesterMobilePhone) {
        this.harLessThan20RequesterMobilePhone = harLessThan20RequesterMobilePhone;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_mobile_phone"
     *  length="10"
     */
    public final String getHarLessThan20RequesterMobilePhone() {
        return this.harLessThan20RequesterMobilePhone;
    }

    private java.util.Date harIndemnifiedDate;

    public final void setHarIndemnifiedDate(final java.util.Date harIndemnifiedDate) {
        this.harIndemnifiedDate = harIndemnifiedDate;
    }


    /**
     * @hibernate.property
     *  column="har_indemnified_date"
     */
    public final java.util.Date getHarIndemnifiedDate() {
        return this.harIndemnifiedDate;
    }

    private String harAnimalAidDetails;

    public final void setHarAnimalAidDetails(final String harAnimalAidDetails) {
        this.harAnimalAidDetails = harAnimalAidDetails;
    }


    /**
     * @hibernate.property
     *  column="har_animal_aid_details"
     */
    public final String getHarAnimalAidDetails() {
        return this.harAnimalAidDetails;
    }

    private Boolean harElectiveFunction;

    public final void setHarElectiveFunction(final Boolean harElectiveFunction) {
        this.harElectiveFunction = harElectiveFunction;
    }


    /**
     * @hibernate.property
     *  column="har_elective_function"
     */
    public final Boolean getHarElectiveFunction() {
        return this.harElectiveFunction;
    }

    private String harHomeSchoolingAccompanistLastName;

    public final void setHarHomeSchoolingAccompanistLastName(final String harHomeSchoolingAccompanistLastName) {
        this.harHomeSchoolingAccompanistLastName = harHomeSchoolingAccompanistLastName;
    }


    /**
     * @hibernate.property
     *  column="har_home_schooling_accompanist_last_name"
     *  length="38"
     */
    public final String getHarHomeSchoolingAccompanistLastName() {
        return this.harHomeSchoolingAccompanistLastName;
    }

    private String harDisabilityPensionCategory;

    public final void setHarDisabilityPensionCategory(final String harDisabilityPensionCategory) {
        this.harDisabilityPensionCategory = harDisabilityPensionCategory;
    }


    /**
     * @hibernate.property
     *  column="har_disability_pension_category"
     */
    public final String getHarDisabilityPensionCategory() {
        return this.harDisabilityPensionCategory;
    }

    private String harRequesterName;

    public final void setHarRequesterName(final String harRequesterName) {
        this.harRequesterName = harRequesterName;
    }


    /**
     * @hibernate.property
     *  column="har_requester_name"
     *  length="38"
     */
    public final String getHarRequesterName() {
        return this.harRequesterName;
    }

    private fr.cg95.cvq.business.request.social.HarProfessionalStatusKindType harProfessionalStatusKind;

    public final void setHarProfessionalStatusKind(final fr.cg95.cvq.business.request.social.HarProfessionalStatusKindType harProfessionalStatusKind) {
        this.harProfessionalStatusKind = harProfessionalStatusKind;
    }


    /**
     * @hibernate.property
     *  column="har_professional_status_kind"
     */
    public final fr.cg95.cvq.business.request.social.HarProfessionalStatusKindType getHarProfessionalStatusKind() {
        return this.harProfessionalStatusKind;
    }

    private String harSocialSecurityAgencyAddress;

    public final void setHarSocialSecurityAgencyAddress(final String harSocialSecurityAgencyAddress) {
        this.harSocialSecurityAgencyAddress = harSocialSecurityAgencyAddress;
    }


    /**
     * @hibernate.property
     *  column="har_social_security_agency_address"
     */
    public final String getHarSocialSecurityAgencyAddress() {
        return this.harSocialSecurityAgencyAddress;
    }

    private String harPaymentAgencyName;

    public final void setHarPaymentAgencyName(final String harPaymentAgencyName) {
        this.harPaymentAgencyName = harPaymentAgencyName;
    }


    /**
     * @hibernate.property
     *  column="har_payment_agency_name"
     */
    public final String getHarPaymentAgencyName() {
        return this.harPaymentAgencyName;
    }

    private String harRequesterMaidenName;

    public final void setHarRequesterMaidenName(final String harRequesterMaidenName) {
        this.harRequesterMaidenName = harRequesterMaidenName;
    }


    /**
     * @hibernate.property
     *  column="har_requester_maiden_name"
     *  length="38"
     */
    public final String getHarRequesterMaidenName() {
        return this.harRequesterMaidenName;
    }

    private String harLessThan20RequesterParentPhone;

    public final void setHarLessThan20RequesterParentPhone(final String harLessThan20RequesterParentPhone) {
        this.harLessThan20RequesterParentPhone = harLessThan20RequesterParentPhone;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_parent_phone"
     *  length="10"
     */
    public final String getHarLessThan20RequesterParentPhone() {
        return this.harLessThan20RequesterParentPhone;
    }

    private Short harWorkAccidentAnnuityRatio;

    public final void setHarWorkAccidentAnnuityRatio(final Short harWorkAccidentAnnuityRatio) {
        this.harWorkAccidentAnnuityRatio = harWorkAccidentAnnuityRatio;
    }


    /**
     * @hibernate.property
     *  column="har_work_accident_annuity_ratio"
     */
    public final Short getHarWorkAccidentAnnuityRatio() {
        return this.harWorkAccidentAnnuityRatio;
    }

    private String harSocialProfessionalCity;

    public final void setHarSocialProfessionalCity(final String harSocialProfessionalCity) {
        this.harSocialProfessionalCity = harSocialProfessionalCity;
    }


    /**
     * @hibernate.property
     *  column="har_social_professional_city"
     *  length="32"
     */
    public final String getHarSocialProfessionalCity() {
        return this.harSocialProfessionalCity;
    }

    private Boolean harTechnicalAssistance;

    public final void setHarTechnicalAssistance(final Boolean harTechnicalAssistance) {
        this.harTechnicalAssistance = harTechnicalAssistance;
    }


    /**
     * @hibernate.property
     *  column="har_technical_assistance"
     */
    public final Boolean getHarTechnicalAssistance() {
        return this.harTechnicalAssistance;
    }

    private String harLessThan20RequesterParentJob;

    public final void setHarLessThan20RequesterParentJob(final String harLessThan20RequesterParentJob) {
        this.harLessThan20RequesterParentJob = harLessThan20RequesterParentJob;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_parent_job"
     */
    public final String getHarLessThan20RequesterParentJob() {
        return this.harLessThan20RequesterParentJob;
    }

    private java.util.Date harLessThan20RequesterBirthDate;

    public final void setHarLessThan20RequesterBirthDate(final java.util.Date harLessThan20RequesterBirthDate) {
        this.harLessThan20RequesterBirthDate = harLessThan20RequesterBirthDate;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_birth_date"
     */
    public final java.util.Date getHarLessThan20RequesterBirthDate() {
        return this.harLessThan20RequesterBirthDate;
    }

    private String harMDPHNumber;

    public final void setHarMDPHNumber(final String harMDPHNumber) {
        this.harMDPHNumber = harMDPHNumber;
    }


    /**
     * @hibernate.property
     *  column="har_m_d_p_h_number"
     */
    public final String getHarMDPHNumber() {
        return this.harMDPHNumber;
    }

    private fr.cg95.cvq.business.request.social.HarDwellingReceptionKindType harDwellingReceptionType;

    public final void setHarDwellingReceptionType(final fr.cg95.cvq.business.request.social.HarDwellingReceptionKindType harDwellingReceptionType) {
        this.harDwellingReceptionType = harDwellingReceptionType;
    }


    /**
     * @hibernate.property
     *  column="har_dwelling_reception_type"
     */
    public final fr.cg95.cvq.business.request.social.HarDwellingReceptionKindType getHarDwellingReceptionType() {
        return this.harDwellingReceptionType;
    }

    private Boolean harDisabledAdultAllowanceRequest;

    public final void setHarDisabledAdultAllowanceRequest(final Boolean harDisabledAdultAllowanceRequest) {
        this.harDisabledAdultAllowanceRequest = harDisabledAdultAllowanceRequest;
    }


    /**
     * @hibernate.property
     *  column="har_disabled_adult_allowance_request"
     */
    public final Boolean getHarDisabledAdultAllowanceRequest() {
        return this.harDisabledAdultAllowanceRequest;
    }

    private String harDwellingSocialReceptionPostalCode;

    public final void setHarDwellingSocialReceptionPostalCode(final String harDwellingSocialReceptionPostalCode) {
        this.harDwellingSocialReceptionPostalCode = harDwellingSocialReceptionPostalCode;
    }


    /**
     * @hibernate.property
     *  column="har_dwelling_social_reception_postal_code"
     *  length="5"
     */
    public final String getHarDwellingSocialReceptionPostalCode() {
        return this.harDwellingSocialReceptionPostalCode;
    }

    private Boolean harDisabledAdultAllocation;

    public final void setHarDisabledAdultAllocation(final Boolean harDisabledAdultAllocation) {
        this.harDisabledAdultAllocation = harDisabledAdultAllocation;
    }


    /**
     * @hibernate.property
     *  column="har_disabled_adult_allocation"
     */
    public final Boolean getHarDisabledAdultAllocation() {
        return this.harDisabledAdultAllocation;
    }

    private Short harDisabilityRatio;

    public final void setHarDisabilityRatio(final Short harDisabilityRatio) {
        this.harDisabilityRatio = harDisabilityRatio;
    }


    /**
     * @hibernate.property
     *  column="har_disability_ratio"
     */
    public final Short getHarDisabilityRatio() {
        return this.harDisabilityRatio;
    }

    private String harRequesterPhone;

    public final void setHarRequesterPhone(final String harRequesterPhone) {
        this.harRequesterPhone = harRequesterPhone;
    }


    /**
     * @hibernate.property
     *  column="har_requester_phone"
     *  length="10"
     */
    public final String getHarRequesterPhone() {
        return this.harRequesterPhone;
    }

    private Boolean harThridPartySupplement;

    public final void setHarThridPartySupplement(final Boolean harThridPartySupplement) {
        this.harThridPartySupplement = harThridPartySupplement;
    }


    /**
     * @hibernate.property
     *  column="har_thrid_party_supplement"
     */
    public final Boolean getHarThridPartySupplement() {
        return this.harThridPartySupplement;
    }

    private Boolean harDisabilityCardRequest;

    public final void setHarDisabilityCardRequest(final Boolean harDisabilityCardRequest) {
        this.harDisabilityCardRequest = harDisabilityCardRequest;
    }


    /**
     * @hibernate.property
     *  column="har_disability_card_request"
     */
    public final Boolean getHarDisabilityCardRequest() {
        return this.harDisabilityCardRequest;
    }

    private fr.cg95.cvq.business.request.social.HarLegalAccessRepresentativeKindType harLegalAccessRepresentativeKind;

    public final void setHarLegalAccessRepresentativeKind(final fr.cg95.cvq.business.request.social.HarLegalAccessRepresentativeKindType harLegalAccessRepresentativeKind) {
        this.harLegalAccessRepresentativeKind = harLegalAccessRepresentativeKind;
    }


    /**
     * @hibernate.property
     *  column="har_legal_access_representative_kind"
     */
    public final fr.cg95.cvq.business.request.social.HarLegalAccessRepresentativeKindType getHarLegalAccessRepresentativeKind() {
        return this.harLegalAccessRepresentativeKind;
    }

    private String harProfessionalStatusPostalCode;

    public final void setHarProfessionalStatusPostalCode(final String harProfessionalStatusPostalCode) {
        this.harProfessionalStatusPostalCode = harProfessionalStatusPostalCode;
    }


    /**
     * @hibernate.property
     *  column="har_professional_status_postal_code"
     *  length="5"
     */
    public final String getHarProfessionalStatusPostalCode() {
        return this.harProfessionalStatusPostalCode;
    }

    private Boolean harProfessionalEvaluation;

    public final void setHarProfessionalEvaluation(final Boolean harProfessionalEvaluation) {
        this.harProfessionalEvaluation = harProfessionalEvaluation;
    }


    /**
     * @hibernate.property
     *  column="har_professional_evaluation"
     */
    public final Boolean getHarProfessionalEvaluation() {
        return this.harProfessionalEvaluation;
    }

    private Boolean harEducationAllocationOfDisabledChildrenRequest;

    public final void setHarEducationAllocationOfDisabledChildrenRequest(final Boolean harEducationAllocationOfDisabledChildrenRequest) {
        this.harEducationAllocationOfDisabledChildrenRequest = harEducationAllocationOfDisabledChildrenRequest;
    }


    /**
     * @hibernate.property
     *  column="har_education_allocation_of_disabled_children_request"
     */
    public final Boolean getHarEducationAllocationOfDisabledChildrenRequest() {
        return this.harEducationAllocationOfDisabledChildrenRequest;
    }

    private String harSchoolPostalCode;

    public final void setHarSchoolPostalCode(final String harSchoolPostalCode) {
        this.harSchoolPostalCode = harSchoolPostalCode;
    }


    /**
     * @hibernate.property
     *  column="har_school_postal_code"
     *  length="5"
     */
    public final String getHarSchoolPostalCode() {
        return this.harSchoolPostalCode;
    }

    private String harDwellingReceptionAddress;

    public final void setHarDwellingReceptionAddress(final String harDwellingReceptionAddress) {
        this.harDwellingReceptionAddress = harDwellingReceptionAddress;
    }


    /**
     * @hibernate.property
     *  column="har_dwelling_reception_address"
     */
    public final String getHarDwellingReceptionAddress() {
        return this.harDwellingReceptionAddress;
    }

    private String harRequesterPostalCode;

    public final void setHarRequesterPostalCode(final String harRequesterPostalCode) {
        this.harRequesterPostalCode = harRequesterPostalCode;
    }


    /**
     * @hibernate.property
     *  column="har_requester_postal_code"
     *  length="5"
     */
    public final String getHarRequesterPostalCode() {
        return this.harRequesterPostalCode;
    }

    private String harFollowedByProfessionalDetails;

    public final void setHarFollowedByProfessionalDetails(final String harFollowedByProfessionalDetails) {
        this.harFollowedByProfessionalDetails = harFollowedByProfessionalDetails;
    }


    /**
     * @hibernate.property
     *  column="har_followed_by_professional_details"
     */
    public final String getHarFollowedByProfessionalDetails() {
        return this.harFollowedByProfessionalDetails;
    }

    private java.math.BigInteger harSchoolingTime;

    public final void setHarSchoolingTime(final java.math.BigInteger harSchoolingTime) {
        this.harSchoolingTime = harSchoolingTime;
    }


    /**
     * @hibernate.property
     *  column="har_schooling_time"
     *  type="serializable"
     */
    public final java.math.BigInteger getHarSchoolingTime() {
        return this.harSchoolingTime;
    }

    private fr.cg95.cvq.business.request.social.HarPaymentAgencyBeneficiaryType harPaymentAgencyBeneficiary;

    public final void setHarPaymentAgencyBeneficiary(final fr.cg95.cvq.business.request.social.HarPaymentAgencyBeneficiaryType harPaymentAgencyBeneficiary) {
        this.harPaymentAgencyBeneficiary = harPaymentAgencyBeneficiary;
    }


    /**
     * @hibernate.property
     *  column="har_payment_agency_beneficiary"
     */
    public final fr.cg95.cvq.business.request.social.HarPaymentAgencyBeneficiaryType getHarPaymentAgencyBeneficiary() {
        return this.harPaymentAgencyBeneficiary;
    }

    private Boolean harSendToSchool;

    public final void setHarSendToSchool(final Boolean harSendToSchool) {
        this.harSendToSchool = harSendToSchool;
    }


    /**
     * @hibernate.property
     *  column="har_send_to_school"
     */
    public final Boolean getHarSendToSchool() {
        return this.harSendToSchool;
    }

    private String harSpecializedGradeDetails;

    public final void setHarSpecializedGradeDetails(final String harSpecializedGradeDetails) {
        this.harSpecializedGradeDetails = harSpecializedGradeDetails;
    }


    /**
     * @hibernate.property
     *  column="har_specialized_grade_details"
     */
    public final String getHarSpecializedGradeDetails() {
        return this.harSpecializedGradeDetails;
    }

    private String harSocialProfessionalLastName;

    public final void setHarSocialProfessionalLastName(final String harSocialProfessionalLastName) {
        this.harSocialProfessionalLastName = harSocialProfessionalLastName;
    }


    /**
     * @hibernate.property
     *  column="har_social_professional_last_name"
     */
    public final String getHarSocialProfessionalLastName() {
        return this.harSocialProfessionalLastName;
    }

    private String harPaymentAgencyCity;

    public final void setHarPaymentAgencyCity(final String harPaymentAgencyCity) {
        this.harPaymentAgencyCity = harPaymentAgencyCity;
    }


    /**
     * @hibernate.property
     *  column="har_payment_agency_city"
     *  length="32"
     */
    public final String getHarPaymentAgencyCity() {
        return this.harPaymentAgencyCity;
    }

    private String harSupportedByAnInstitutionDetails;

    public final void setHarSupportedByAnInstitutionDetails(final String harSupportedByAnInstitutionDetails) {
        this.harSupportedByAnInstitutionDetails = harSupportedByAnInstitutionDetails;
    }


    /**
     * @hibernate.property
     *  column="har_supported_by_an_institution_details"
     */
    public final String getHarSupportedByAnInstitutionDetails() {
        return this.harSupportedByAnInstitutionDetails;
    }

    private fr.cg95.cvq.business.request.social.HarHomeSchoolingKindType harHomeSchoolingKind;

    public final void setHarHomeSchoolingKind(final fr.cg95.cvq.business.request.social.HarHomeSchoolingKindType harHomeSchoolingKind) {
        this.harHomeSchoolingKind = harHomeSchoolingKind;
    }


    /**
     * @hibernate.property
     *  column="har_home_schooling_kind"
     */
    public final fr.cg95.cvq.business.request.social.HarHomeSchoolingKindType getHarHomeSchoolingKind() {
        return this.harHomeSchoolingKind;
    }

    private Boolean harLessThan20RequesterRepresentativeActivityReduction;

    public final void setHarLessThan20RequesterRepresentativeActivityReduction(final Boolean harLessThan20RequesterRepresentativeActivityReduction) {
        this.harLessThan20RequesterRepresentativeActivityReduction = harLessThan20RequesterRepresentativeActivityReduction;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_representative_activity_reduction"
     */
    public final Boolean getHarLessThan20RequesterRepresentativeActivityReduction() {
        return this.harLessThan20RequesterRepresentativeActivityReduction;
    }

    private String harLessThan20RequesterRepresentativeMobilePhone;

    public final void setHarLessThan20RequesterRepresentativeMobilePhone(final String harLessThan20RequesterRepresentativeMobilePhone) {
        this.harLessThan20RequesterRepresentativeMobilePhone = harLessThan20RequesterRepresentativeMobilePhone;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_representative_mobile_phone"
     *  length="10"
     */
    public final String getHarLessThan20RequesterRepresentativeMobilePhone() {
        return this.harLessThan20RequesterRepresentativeMobilePhone;
    }

    private List<fr.cg95.cvq.business.request.social.HarCarer> harCarer;

    public final void setHarCarer(final List<fr.cg95.cvq.business.request.social.HarCarer> harCarer) {
        this.harCarer = harCarer;
    }


    /**
     * @hibernate.list
     *  inverse="false"
     *  lazy="false"
     *  cascade="all"
     * @hibernate.key
     *  column="handicap_allowance_request_id"
     * @hibernate.list-index
     *  column="har_carer_index"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.request.social.HarCarer"
     */
    public final List<fr.cg95.cvq.business.request.social.HarCarer> getHarCarer() {
        return this.harCarer;
    }

    private String harDwellingPrecision;

    public final void setHarDwellingPrecision(final String harDwellingPrecision) {
        this.harDwellingPrecision = harDwellingPrecision;
    }


    /**
     * @hibernate.property
     *  column="har_dwelling_precision"
     */
    public final String getHarDwellingPrecision() {
        return this.harDwellingPrecision;
    }

    private Boolean harRegisterAsUnemployed;

    public final void setHarRegisterAsUnemployed(final Boolean harRegisterAsUnemployed) {
        this.harRegisterAsUnemployed = harRegisterAsUnemployed;
    }


    /**
     * @hibernate.property
     *  column="har_register_as_unemployed"
     */
    public final Boolean getHarRegisterAsUnemployed() {
        return this.harRegisterAsUnemployed;
    }

    private String harProjectComments;

    public final void setHarProjectComments(final String harProjectComments) {
        this.harProjectComments = harProjectComments;
    }


    /**
     * @hibernate.property
     *  column="har_project_comments"
     */
    public final String getHarProjectComments() {
        return this.harProjectComments;
    }

    private String harRequesterMobilePhone;

    public final void setHarRequesterMobilePhone(final String harRequesterMobilePhone) {
        this.harRequesterMobilePhone = harRequesterMobilePhone;
    }


    /**
     * @hibernate.property
     *  column="har_requester_mobile_phone"
     *  length="10"
     */
    public final String getHarRequesterMobilePhone() {
        return this.harRequesterMobilePhone;
    }

    private fr.cg95.cvq.business.request.social.HarTitleType harRequesterTitle;

    public final void setHarRequesterTitle(final fr.cg95.cvq.business.request.social.HarTitleType harRequesterTitle) {
        this.harRequesterTitle = harRequesterTitle;
    }


    /**
     * @hibernate.property
     *  column="har_requester_title"
     */
    public final fr.cg95.cvq.business.request.social.HarTitleType getHarRequesterTitle() {
        return this.harRequesterTitle;
    }

    private String harLessThan20RequesterParentStreetName;

    public final void setHarLessThan20RequesterParentStreetName(final String harLessThan20RequesterParentStreetName) {
        this.harLessThan20RequesterParentStreetName = harLessThan20RequesterParentStreetName;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_parent_street_name"
     */
    public final String getHarLessThan20RequesterParentStreetName() {
        return this.harLessThan20RequesterParentStreetName;
    }

    private String harSocialProfessionalAddress;

    public final void setHarSocialProfessionalAddress(final String harSocialProfessionalAddress) {
        this.harSocialProfessionalAddress = harSocialProfessionalAddress;
    }


    /**
     * @hibernate.property
     *  column="har_social_professional_address"
     */
    public final String getHarSocialProfessionalAddress() {
        return this.harSocialProfessionalAddress;
    }

    private String harCustomCarDetails;

    public final void setHarCustomCarDetails(final String harCustomCarDetails) {
        this.harCustomCarDetails = harCustomCarDetails;
    }


    /**
     * @hibernate.property
     *  column="har_custom_car_details"
     */
    public final String getHarCustomCarDetails() {
        return this.harCustomCarDetails;
    }

    private String harLessThan20RequesterEmail;

    public final void setHarLessThan20RequesterEmail(final String harLessThan20RequesterEmail) {
        this.harLessThan20RequesterEmail = harLessThan20RequesterEmail;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_email"
     */
    public final String getHarLessThan20RequesterEmail() {
        return this.harLessThan20RequesterEmail;
    }

    private Boolean harThridPartyCompensatoryAllowance;

    public final void setHarThridPartyCompensatoryAllowance(final Boolean harThridPartyCompensatoryAllowance) {
        this.harThridPartyCompensatoryAllowance = harThridPartyCompensatoryAllowance;
    }


    /**
     * @hibernate.property
     *  column="har_thrid_party_compensatory_allowance"
     */
    public final Boolean getHarThridPartyCompensatoryAllowance() {
        return this.harThridPartyCompensatoryAllowance;
    }

    private Boolean harMDPHFile;

    public final void setHarMDPHFile(final Boolean harMDPHFile) {
        this.harMDPHFile = harMDPHFile;
    }


    /**
     * @hibernate.property
     *  column="har_m_d_p_h_file"
     */
    public final Boolean getHarMDPHFile() {
        return this.harMDPHFile;
    }

    private String harAdditionalAllocationForEducationOfDisabledChildrenDetails;

    public final void setHarAdditionalAllocationForEducationOfDisabledChildrenDetails(final String harAdditionalAllocationForEducationOfDisabledChildrenDetails) {
        this.harAdditionalAllocationForEducationOfDisabledChildrenDetails = harAdditionalAllocationForEducationOfDisabledChildrenDetails;
    }


    /**
     * @hibernate.property
     *  column="har_additional_allocation_for_education_of_disabled_children_details"
     */
    public final String getHarAdditionalAllocationForEducationOfDisabledChildrenDetails() {
        return this.harAdditionalAllocationForEducationOfDisabledChildrenDetails;
    }

    private Boolean harEducationAllocationOfDisabledChildren;

    public final void setHarEducationAllocationOfDisabledChildren(final Boolean harEducationAllocationOfDisabledChildren) {
        this.harEducationAllocationOfDisabledChildren = harEducationAllocationOfDisabledChildren;
    }


    /**
     * @hibernate.property
     *  column="har_education_allocation_of_disabled_children"
     */
    public final Boolean getHarEducationAllocationOfDisabledChildren() {
        return this.harEducationAllocationOfDisabledChildren;
    }

    private Boolean harThridPersonCompensatoryAllowance;

    public final void setHarThridPersonCompensatoryAllowance(final Boolean harThridPersonCompensatoryAllowance) {
        this.harThridPersonCompensatoryAllowance = harThridPersonCompensatoryAllowance;
    }


    /**
     * @hibernate.property
     *  column="har_thrid_person_compensatory_allowance"
     */
    public final Boolean getHarThridPersonCompensatoryAllowance() {
        return this.harThridPersonCompensatoryAllowance;
    }

    private Boolean harCustomCarRequest;

    public final void setHarCustomCarRequest(final Boolean harCustomCarRequest) {
        this.harCustomCarRequest = harCustomCarRequest;
    }


    /**
     * @hibernate.property
     *  column="har_custom_car_request"
     */
    public final Boolean getHarCustomCarRequest() {
        return this.harCustomCarRequest;
    }

    private Boolean harAnimalAid;

    public final void setHarAnimalAid(final Boolean harAnimalAid) {
        this.harAnimalAid = harAnimalAid;
    }


    /**
     * @hibernate.property
     *  column="har_animal_aid"
     */
    public final Boolean getHarAnimalAid() {
        return this.harAnimalAid;
    }

    private java.util.Date harRegisterAsUnemployedDate;

    public final void setHarRegisterAsUnemployedDate(final java.util.Date harRegisterAsUnemployedDate) {
        this.harRegisterAsUnemployedDate = harRegisterAsUnemployedDate;
    }


    /**
     * @hibernate.property
     *  column="har_register_as_unemployed_date"
     */
    public final java.util.Date getHarRegisterAsUnemployedDate() {
        return this.harRegisterAsUnemployedDate;
    }

    private Boolean harProfessionalOrientationRequest;

    public final void setHarProfessionalOrientationRequest(final Boolean harProfessionalOrientationRequest) {
        this.harProfessionalOrientationRequest = harProfessionalOrientationRequest;
    }


    /**
     * @hibernate.property
     *  column="har_professional_orientation_request"
     */
    public final Boolean getHarProfessionalOrientationRequest() {
        return this.harProfessionalOrientationRequest;
    }

    private String harRequesterEmail;

    public final void setHarRequesterEmail(final String harRequesterEmail) {
        this.harRequesterEmail = harRequesterEmail;
    }


    /**
     * @hibernate.property
     *  column="har_requester_email"
     */
    public final String getHarRequesterEmail() {
        return this.harRequesterEmail;
    }

    private Boolean harFollowedByHospital;

    public final void setHarFollowedByHospital(final Boolean harFollowedByHospital) {
        this.harFollowedByHospital = harFollowedByHospital;
    }


    /**
     * @hibernate.property
     *  column="har_followed_by_hospital"
     */
    public final Boolean getHarFollowedByHospital() {
        return this.harFollowedByHospital;
    }

    private Boolean harIncreaseForIndependentLiving;

    public final void setHarIncreaseForIndependentLiving(final Boolean harIncreaseForIndependentLiving) {
        this.harIncreaseForIndependentLiving = harIncreaseForIndependentLiving;
    }


    /**
     * @hibernate.property
     *  column="har_increase_for_independent_living"
     */
    public final Boolean getHarIncreaseForIndependentLiving() {
        return this.harIncreaseForIndependentLiving;
    }

    private String harLessThan20RequesterParentPostalCode;

    public final void setHarLessThan20RequesterParentPostalCode(final String harLessThan20RequesterParentPostalCode) {
        this.harLessThan20RequesterParentPostalCode = harLessThan20RequesterParentPostalCode;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_parent_postal_code"
     *  length="5"
     */
    public final String getHarLessThan20RequesterParentPostalCode() {
        return this.harLessThan20RequesterParentPostalCode;
    }

    private String harLegalAccessRepresentativeFirstName;

    public final void setHarLegalAccessRepresentativeFirstName(final String harLegalAccessRepresentativeFirstName) {
        this.harLegalAccessRepresentativeFirstName = harLegalAccessRepresentativeFirstName;
    }


    /**
     * @hibernate.property
     *  column="har_legal_access_representative_first_name"
     *  length="38"
     */
    public final String getHarLegalAccessRepresentativeFirstName() {
        return this.harLegalAccessRepresentativeFirstName;
    }

    private Boolean harDisabilityCostAllocationRequest;

    public final void setHarDisabilityCostAllocationRequest(final Boolean harDisabilityCostAllocationRequest) {
        this.harDisabilityCostAllocationRequest = harDisabilityCostAllocationRequest;
    }


    /**
     * @hibernate.property
     *  column="har_disability_cost_allocation_request"
     */
    public final Boolean getHarDisabilityCostAllocationRequest() {
        return this.harDisabilityCostAllocationRequest;
    }

    private String dwellingReceptionNaming;

    public final void setDwellingReceptionNaming(final String dwellingReceptionNaming) {
        this.dwellingReceptionNaming = dwellingReceptionNaming;
    }


    /**
     * @hibernate.property
     *  column="dwelling_reception_naming"
     */
    public final String getDwellingReceptionNaming() {
        return this.dwellingReceptionNaming;
    }

    private String harProjectWish;

    public final void setHarProjectWish(final String harProjectWish) {
        this.harProjectWish = harProjectWish;
    }


    /**
     * @hibernate.property
     *  column="har_project_wish"
     */
    public final String getHarProjectWish() {
        return this.harProjectWish;
    }

    private String harSocialSecurityAgencyCity;

    public final void setHarSocialSecurityAgencyCity(final String harSocialSecurityAgencyCity) {
        this.harSocialSecurityAgencyCity = harSocialSecurityAgencyCity;
    }


    /**
     * @hibernate.property
     *  column="har_social_security_agency_city"
     *  length="32"
     */
    public final String getHarSocialSecurityAgencyCity() {
        return this.harSocialSecurityAgencyCity;
    }

    private String harLessThan20RequesterParentName;

    public final void setHarLessThan20RequesterParentName(final String harLessThan20RequesterParentName) {
        this.harLessThan20RequesterParentName = harLessThan20RequesterParentName;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_parent_name"
     *  length="38"
     */
    public final String getHarLessThan20RequesterParentName() {
        return this.harLessThan20RequesterParentName;
    }

    private String harLessThan20RequesterStreetName;

    public final void setHarLessThan20RequesterStreetName(final String harLessThan20RequesterStreetName) {
        this.harLessThan20RequesterStreetName = harLessThan20RequesterStreetName;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_street_name"
     */
    public final String getHarLessThan20RequesterStreetName() {
        return this.harLessThan20RequesterStreetName;
    }

    private String harDiploma;

    public final void setHarDiploma(final String harDiploma) {
        this.harDiploma = harDiploma;
    }


    /**
     * @hibernate.property
     *  column="har_diploma"
     */
    public final String getHarDiploma() {
        return this.harDiploma;
    }

    private Boolean harEuropeanParkingCardRequest;

    public final void setHarEuropeanParkingCardRequest(final Boolean harEuropeanParkingCardRequest) {
        this.harEuropeanParkingCardRequest = harEuropeanParkingCardRequest;
    }


    /**
     * @hibernate.property
     *  column="har_european_parking_card_request"
     */
    public final Boolean getHarEuropeanParkingCardRequest() {
        return this.harEuropeanParkingCardRequest;
    }

    private fr.cg95.cvq.business.users.CountryType harRequesterBirthCountry;

    public final void setHarRequesterBirthCountry(final fr.cg95.cvq.business.users.CountryType harRequesterBirthCountry) {
        this.harRequesterBirthCountry = harRequesterBirthCountry;
    }


    /**
     * @hibernate.property
     *  column="har_requester_birth_country"
     */
    public final fr.cg95.cvq.business.users.CountryType getHarRequesterBirthCountry() {
        return this.harRequesterBirthCountry;
    }

    private String harProfessionalStatusCity;

    public final void setHarProfessionalStatusCity(final String harProfessionalStatusCity) {
        this.harProfessionalStatusCity = harProfessionalStatusCity;
    }


    /**
     * @hibernate.property
     *  column="har_professional_status_city"
     *  length="32"
     */
    public final String getHarProfessionalStatusCity() {
        return this.harProfessionalStatusCity;
    }

    private String harLessThan20RequesterPostalCode;

    public final void setHarLessThan20RequesterPostalCode(final String harLessThan20RequesterPostalCode) {
        this.harLessThan20RequesterPostalCode = harLessThan20RequesterPostalCode;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_postal_code"
     *  length="5"
     */
    public final String getHarLessThan20RequesterPostalCode() {
        return this.harLessThan20RequesterPostalCode;
    }

    private String harMDPHDepartment;

    public final void setHarMDPHDepartment(final String harMDPHDepartment) {
        this.harMDPHDepartment = harMDPHDepartment;
    }


    /**
     * @hibernate.property
     *  column="har_m_d_p_h_department"
     */
    public final String getHarMDPHDepartment() {
        return this.harMDPHDepartment;
    }

    private String harLessThan20RequesterRepresentativePhone;

    public final void setHarLessThan20RequesterRepresentativePhone(final String harLessThan20RequesterRepresentativePhone) {
        this.harLessThan20RequesterRepresentativePhone = harLessThan20RequesterRepresentativePhone;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_representative_phone"
     *  length="10"
     */
    public final String getHarLessThan20RequesterRepresentativePhone() {
        return this.harLessThan20RequesterRepresentativePhone;
    }

    private Boolean harAssistanceUnderDisability;

    public final void setHarAssistanceUnderDisability(final Boolean harAssistanceUnderDisability) {
        this.harAssistanceUnderDisability = harAssistanceUnderDisability;
    }


    /**
     * @hibernate.property
     *  column="har_assistance_under_disability"
     */
    public final Boolean getHarAssistanceUnderDisability() {
        return this.harAssistanceUnderDisability;
    }

    private Boolean harWorkAccidentAnnuity;

    public final void setHarWorkAccidentAnnuity(final Boolean harWorkAccidentAnnuity) {
        this.harWorkAccidentAnnuity = harWorkAccidentAnnuity;
    }


    /**
     * @hibernate.property
     *  column="har_work_accident_annuity"
     */
    public final Boolean getHarWorkAccidentAnnuity() {
        return this.harWorkAccidentAnnuity;
    }

    private List<fr.cg95.cvq.business.request.social.HarOtherFiles> harOtherFiles;

    public final void setHarOtherFiles(final List<fr.cg95.cvq.business.request.social.HarOtherFiles> harOtherFiles) {
        this.harOtherFiles = harOtherFiles;
    }


    /**
     * @hibernate.list
     *  inverse="false"
     *  lazy="false"
     *  cascade="all"
     * @hibernate.key
     *  column="handicap_allowance_request_id"
     * @hibernate.list-index
     *  column="har_other_files_index"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.request.social.HarOtherFiles"
     */
    public final List<fr.cg95.cvq.business.request.social.HarOtherFiles> getHarOtherFiles() {
        return this.harOtherFiles;
    }

    private Boolean harUnemploymentBenefits;

    public final void setHarUnemploymentBenefits(final Boolean harUnemploymentBenefits) {
        this.harUnemploymentBenefits = harUnemploymentBenefits;
    }


    /**
     * @hibernate.property
     *  column="har_unemployment_benefits"
     */
    public final Boolean getHarUnemploymentBenefits() {
        return this.harUnemploymentBenefits;
    }

    private String harProfessionalOrientationDetails;

    public final void setHarProfessionalOrientationDetails(final String harProfessionalOrientationDetails) {
        this.harProfessionalOrientationDetails = harProfessionalOrientationDetails;
    }


    /**
     * @hibernate.property
     *  column="har_professional_orientation_details"
     */
    public final String getHarProfessionalOrientationDetails() {
        return this.harProfessionalOrientationDetails;
    }

    private Boolean harHousingFacilitiesRequest;

    public final void setHarHousingFacilitiesRequest(final Boolean harHousingFacilitiesRequest) {
        this.harHousingFacilitiesRequest = harHousingFacilitiesRequest;
    }


    /**
     * @hibernate.property
     *  column="har_housing_facilities_request"
     */
    public final Boolean getHarHousingFacilitiesRequest() {
        return this.harHousingFacilitiesRequest;
    }

    private String harHomeSchoolingAccompanistCity;

    public final void setHarHomeSchoolingAccompanistCity(final String harHomeSchoolingAccompanistCity) {
        this.harHomeSchoolingAccompanistCity = harHomeSchoolingAccompanistCity;
    }


    /**
     * @hibernate.property
     *  column="har_home_schooling_accompanist_city"
     *  length="32"
     */
    public final String getHarHomeSchoolingAccompanistCity() {
        return this.harHomeSchoolingAccompanistCity;
    }

    private String harDwellingSocialReceptionNaming;

    public final void setHarDwellingSocialReceptionNaming(final String harDwellingSocialReceptionNaming) {
        this.harDwellingSocialReceptionNaming = harDwellingSocialReceptionNaming;
    }


    /**
     * @hibernate.property
     *  column="har_dwelling_social_reception_naming"
     */
    public final String getHarDwellingSocialReceptionNaming() {
        return this.harDwellingSocialReceptionNaming;
    }

    private Boolean harPersonalizedSchoolingPlan;

    public final void setHarPersonalizedSchoolingPlan(final Boolean harPersonalizedSchoolingPlan) {
        this.harPersonalizedSchoolingPlan = harPersonalizedSchoolingPlan;
    }


    /**
     * @hibernate.property
     *  column="har_personalized_schooling_plan"
     */
    public final Boolean getHarPersonalizedSchoolingPlan() {
        return this.harPersonalizedSchoolingPlan;
    }

    private Boolean harAssistanceRequest;

    public final void setHarAssistanceRequest(final Boolean harAssistanceRequest) {
        this.harAssistanceRequest = harAssistanceRequest;
    }


    /**
     * @hibernate.property
     *  column="har_assistance_request"
     */
    public final Boolean getHarAssistanceRequest() {
        return this.harAssistanceRequest;
    }

    private Boolean harSocialWelfare;

    public final void setHarSocialWelfare(final Boolean harSocialWelfare) {
        this.harSocialWelfare = harSocialWelfare;
    }


    /**
     * @hibernate.property
     *  column="har_social_welfare"
     */
    public final Boolean getHarSocialWelfare() {
        return this.harSocialWelfare;
    }

    private String harHomeSchoolingAccompanistAddress;

    public final void setHarHomeSchoolingAccompanistAddress(final String harHomeSchoolingAccompanistAddress) {
        this.harHomeSchoolingAccompanistAddress = harHomeSchoolingAccompanistAddress;
    }


    /**
     * @hibernate.property
     *  column="har_home_schooling_accompanist_address"
     */
    public final String getHarHomeSchoolingAccompanistAddress() {
        return this.harHomeSchoolingAccompanistAddress;
    }

    private Boolean harInstitutionSupportRequest;

    public final void setHarInstitutionSupportRequest(final Boolean harInstitutionSupportRequest) {
        this.harInstitutionSupportRequest = harInstitutionSupportRequest;
    }


    /**
     * @hibernate.property
     *  column="har_institution_support_request"
     */
    public final Boolean getHarInstitutionSupportRequest() {
        return this.harInstitutionSupportRequest;
    }

    private Boolean harThirdPartyHelpRequest;

    public final void setHarThirdPartyHelpRequest(final Boolean harThirdPartyHelpRequest) {
        this.harThirdPartyHelpRequest = harThirdPartyHelpRequest;
    }


    /**
     * @hibernate.property
     *  column="har_third_party_help_request"
     */
    public final Boolean getHarThirdPartyHelpRequest() {
        return this.harThirdPartyHelpRequest;
    }

    private String harHomeSchoolingAccompanistPostalCode;

    public final void setHarHomeSchoolingAccompanistPostalCode(final String harHomeSchoolingAccompanistPostalCode) {
        this.harHomeSchoolingAccompanistPostalCode = harHomeSchoolingAccompanistPostalCode;
    }


    /**
     * @hibernate.property
     *  column="har_home_schooling_accompanist_postal_code"
     *  length="5"
     */
    public final String getHarHomeSchoolingAccompanistPostalCode() {
        return this.harHomeSchoolingAccompanistPostalCode;
    }

    private java.util.Date harProfessionalStatusDate;

    public final void setHarProfessionalStatusDate(final java.util.Date harProfessionalStatusDate) {
        this.harProfessionalStatusDate = harProfessionalStatusDate;
    }


    /**
     * @hibernate.property
     *  column="har_professional_status_date"
     */
    public final java.util.Date getHarProfessionalStatusDate() {
        return this.harProfessionalStatusDate;
    }

    private Boolean harDisabilityRecognitionRequest;

    public final void setHarDisabilityRecognitionRequest(final Boolean harDisabilityRecognitionRequest) {
        this.harDisabilityRecognitionRequest = harDisabilityRecognitionRequest;
    }


    /**
     * @hibernate.property
     *  column="har_disability_recognition_request"
     */
    public final Boolean getHarDisabilityRecognitionRequest() {
        return this.harDisabilityRecognitionRequest;
    }

    private Boolean harRequestDealWithSameProfessional;

    public final void setHarRequestDealWithSameProfessional(final Boolean harRequestDealWithSameProfessional) {
        this.harRequestDealWithSameProfessional = harRequestDealWithSameProfessional;
    }


    /**
     * @hibernate.property
     *  column="har_request_deal_with_same_professional"
     */
    public final Boolean getHarRequestDealWithSameProfessional() {
        return this.harRequestDealWithSameProfessional;
    }

    private fr.cg95.cvq.business.users.CountryType harLessThan20RequesterBirthCountry;

    public final void setHarLessThan20RequesterBirthCountry(final fr.cg95.cvq.business.users.CountryType harLessThan20RequesterBirthCountry) {
        this.harLessThan20RequesterBirthCountry = harLessThan20RequesterBirthCountry;
    }


    /**
     * @hibernate.property
     *  column="har_less_than20_requester_birth_country"
     */
    public final fr.cg95.cvq.business.users.CountryType getHarLessThan20RequesterBirthCountry() {
        return this.harLessThan20RequesterBirthCountry;
    }

    private String harHighSchoolName;

    public final void setHarHighSchoolName(final String harHighSchoolName) {
        this.harHighSchoolName = harHighSchoolName;
    }


    /**
     * @hibernate.property
     *  column="har_high_school_name"
     */
    public final String getHarHighSchoolName() {
        return this.harHighSchoolName;
    }

    private Boolean harPainfulStandingCard;

    public final void setHarPainfulStandingCard(final Boolean harPainfulStandingCard) {
        this.harPainfulStandingCard = harPainfulStandingCard;
    }


    /**
     * @hibernate.property
     *  column="har_painful_standing_card"
     */
    public final Boolean getHarPainfulStandingCard() {
        return this.harPainfulStandingCard;
    }

}
