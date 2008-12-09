package fr.cg95.cvq.service.request.social.impl;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Node;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.social.HandicapAllowanceRequest;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.social.IHandicapAllowanceRequestService;
import fr.cg95.cvq.xml.request.social.HandicapAllowanceRequestDocument;


/**
 * Implementation of the handicap allowance request service.
 * 
 * @author Rafik Djedjig (rdj@zenexity.fr)
 */
public class HandicapAllowanceRequestService extends RequestService 
    implements IHandicapAllowanceRequestService {
    
    static Logger logger = Logger.getLogger(HandicapAllowanceRequestService.class);

    public Long create(Node node) throws CvqException {
        HandicapAllowanceRequestDocument requestDocument = null;
        try {
            requestDocument = HandicapAllowanceRequestDocument.Factory.parse(node);
        } catch (XmlException xe) {
            logger.error("create() Error while parsing received data");
            xe.printStackTrace();
        }

        HandicapAllowanceRequest request = 
            HandicapAllowanceRequest.xmlToModel(requestDocument);
        HomeFolder homeFolder = super.createOrSynchronizeHomeFolder(request);

        initializeCommonAttributes(request);

        Long requestId = super.create(request);
        if (homeFolder != null) {
            homeFolder.setBoundToRequest(Boolean.valueOf(true));
            homeFolder.setOriginRequestId(requestId);
        }
        
        return requestId;
    }

    public boolean accept(Request request) {
        return request instanceof HandicapAllowanceRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new HandicapAllowanceRequest();
    }
    
    public boolean checkIsAdult(final Map<String,String> inputs){
        if (inputs.get("harRequestInformationProfile").equals("fr.cg95.cvq.business.request.social.HarRequestInformationProfileType_Adult"))
            return true;
        return false;
    }
    
    public boolean checkIsLessThan20(final Map<String,String> inputs){
        if (inputs.get("harRequestInformationProfile").equals("fr.cg95.cvq.business.request.social.HarRequestInformationProfileType_LessThan20"))
            return true;
        return false;
    }
    
    public boolean checkIsLessThan18(final Map<String,String> inputs){
        /*
        if (inputs.get("harLessThan20RequesterBirthDate").equals("fr.cg95.cvq.business.request.social.HarRequestInformationProfileType_LessThan20"))
            return true;
        */
        // Comparaison avec un type date par rapport à la date du jour ?
        return false;
    }
    
    public boolean checkIsRequesterMadam(final Map<String,String> inputs){
        if (inputs.get("harRequesterTitle").equals("fr.cg95.cvq.business.request.social.HarTitleType_Madam"))
            return true;
        return false;
    }
    
    public boolean checkIsReferentMadam(final Map<String,String> inputs){
        // Pas de trigger, à completer
        return false;
    }
    
    public boolean checkHaveLegalAccessPresence(final Map<String,String> inputs){
        if (inputs.get("harLegalAccessPresence").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsOtherLegalAccessRepresentative(final Map<String,String> inputs){
        if (inputs.get("harLegalAccessRepresentativeKind").equals("fr.cg95.cvq.business.request.social.HarLegalAccessRepresentativeKindType_Other"))
            return true;
        return false;
    }
    
    public boolean checkHaveActivityReduction(final Map<String,String> inputs){
        if (inputs.get("harLessThan20RequesterRepresentativeActivityReduction").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkHaveFamilyDependent(final Map<String,String> inputs){
        if (inputs.get("harFamilyDependent").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsDwellingPlaceOfResidence(final Map<String,String> inputs){
        if (inputs.get("harDwellingKind").equals("fr.cg95.cvq.business.request.social.HarDwellingKindType_PlaceOfResidence"))
            return true;
        return false;
    }
    
    public boolean checkIsInEstablishmentReception(final Map<String,String> inputs){
        if (inputs.get("harDwellingEstablishmentReception").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsInSocialReception(final Map<String,String> inputs){
        if (inputs.get("harDwellingSocialReception").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkHaveSocialSecurityMemberShip(final Map<String,String> inputs){
        if (inputs.get("harSocialSecurityMemberShipKind").equals("fr.cg95.cvq.business.request.social.HarSocialSecurityMemberShipKindType_Insured") ||
                inputs.get("harSocialSecurityMemberShipKind").equals("fr.cg95.cvq.business.request.social.HarSocialSecurityMemberShipKindType_Claimant"))
            return true;
        return false;
    }
    
    public boolean checkHavePaymentAgencyBeneficiary(final Map<String,String> inputs){
        if (inputs.get("harPaymentAgencyBeneficiary").equals("fr.cg95.cvq.business.request.social.HarPaymentAgencyBeneficiaryType_CAF") ||
                inputs.get("harPaymentAgencyBeneficiary").equals("fr.cg95.cvq.business.request.social.HarPaymentAgencyBeneficiaryType_MSA") ||
                inputs.get("harPaymentAgencyBeneficiary").equals("fr.cg95.cvq.business.request.social.HarPaymentAgencyBeneficiaryType_Other"))
            return true;
        return false;
    }
    
    public boolean checkIsSchoolingEnrolment(final Map<String,String> inputs){
        if (inputs.get("harSchoolingEnrolment").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsSentToSchool(final Map<String,String> inputs){
        if (inputs.get("harSendToSchool").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsSpecializedGrade(final Map<String,String> inputs){
        if (inputs.get("harSpecializedGrade").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsPartTimeSchooling(final Map<String,String> inputs){
        if (inputs.get("harSchoolingKind").equals("fr.cg95.cvq.business.request.social.HarSchoolingKindType_PartTime"))
            return true;
        return false;
    }
    
    public boolean checkIsAccompaniedHomeSchooling(final Map<String,String> inputs){
        if (inputs.get("harHomeSchoolingKind").equals("fr.cg95.cvq.business.request.social.HarHomeSchoolingKindType_Accompanied"))
            return true;
        return false;
    }
    
    public boolean checkIsHighSchool(final Map<String,String> inputs){
        if (inputs.get("harHighSchool").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsAssistanceUnderDisability(final Map<String,String> inputs){
        if (inputs.get("harAssistanceUnderDisability").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsEmployed(final Map<String,String> inputs){
        if (inputs.get("harProfessionalStatusKind").equals("fr.cg95.cvq.business.request.social.HarProfessionalStatusKindType_employee"))
            return true;
        return false;
    }
    
    public boolean checkIsUnemployed(final Map<String,String> inputs){
        if (inputs.get("harProfessionalStatusKind").equals("fr.cg95.cvq.business.request.social.HarProfessionalStatusKindType_unemployed"))
            return true;
        return false;
    }
    
    public boolean checkIsRegisteredAsUnemployed(final Map<String,String> inputs){
        if (inputs.get("harRegisterAsUnemployed").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsIndemnified(final Map<String,String> inputs){
        if (inputs.get("harIndemnified").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsElectiveFunction(final Map<String,String> inputs){
        if (inputs.get("harElectiveFunction").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsMDPH(final Map<String,String> inputs){
        if (inputs.get("harMDPHFile").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsCOTOREP(final Map<String,String> inputs){
        if (inputs.get("harCOTOREPFile").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsCDES(final Map<String,String> inputs){
        if (inputs.get("harCDESFile").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsDisabilityRecognition(final Map<String,String> inputs){
        if (inputs.get("harDisabilityRecognition").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsProfessionalOrientation(final Map<String,String> inputs){
        if (inputs.get("harProfessionalOrientation").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsAdditionalAllocationForEducationOfDisabledChildren(final Map<String,String> inputs){
        if (inputs.get("harAdditionalAllocationForEducationOfDisabledChildren").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsDisabilityPension(final Map<String,String> inputs){
        if (inputs.get("HarDisabilityPension").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsWorkAccidentAnnuity(final Map<String,String> inputs){
        if (inputs.get("harWorkAccidentAnnuity").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsSupportedByAnInstitution(final Map<String,String> inputs){
        if (inputs.get("harSupportedByAnInstitution").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsOtherCarer(final Map<String,String> inputs){
        if (inputs.get("harCarerKind").equals("fr.cg95.cvq.business.request.social.HarCarerKindType_Other"))
            return true;
        return false;
    }
    
    public boolean checkIsEmployer(final Map<String,String> inputs){
        if (inputs.get("HarEmployer").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsHousingFacilities(final Map<String,String> inputs){
        if (inputs.get("harHousingFacilities").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsTechnicalAssistance(final Map<String,String> inputs){
        if (inputs.get("harTechnicalAssistance").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsCustomCar(final Map<String,String> inputs){
        if (inputs.get("harCustomCar").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsAnimalAid(final Map<String,String> inputs){
        if (inputs.get("harAnimalAid").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsSpecializedTransport(final Map<String,String> inputs){
        if (inputs.get("harSpecializedTransport").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsFollowUp(final Map<String,String> inputs){
        if (inputs.get("harFollowUp").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsFamilyCarer(final Map<String,String> inputs){
        if (inputs.get("harIsFamilyCarer").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsCarer(final Map<String,String> inputs){
        if (inputs.get("harIsCarer").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsCareAssistant(final Map<String,String> inputs){
        if (inputs.get("harIsCareAssistant").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsProfessionalEvaluation(final Map<String,String> inputs){
        if (inputs.get("harProfessionalEvaluation").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsFollowedByPhysician(final Map<String,String> inputs){
        if (inputs.get("harFollowedByPhysician").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsFollowedByProfessional(final Map<String,String> inputs){
        if (inputs.get("harFollowedByProfessional").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsFollowedByHospital(final Map<String,String> inputs){
        if (inputs.get("harFollowedByHospital").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsProfessionalOrientationRequest(final Map<String,String> inputs){
        if (inputs.get("harProfessionalOrientationRequest").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsOtherRequest(final Map<String,String> inputs){
        if (inputs.get("harOtherRequest").equals("true"))
            return true;
        return false;
    }
           
}