package fr.cg95.cvq.service.request.social.impl;

import java.util.Arrays;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.social.HandicapCompensationAdultRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.condition.EqualityListChecker;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.social.IHandicapCompensationAdultRequestService;

/**
 * Implementation of the adult handicap compensation request service.
 * 
 * @author maxence.veyret@bull.net
 */
public class HandicapCompensationAdultRequestService extends RequestService 
    implements IHandicapCompensationAdultRequestService {
    
    static Logger logger = Logger.getLogger(HandicapCompensationAdultRequestService.class);
    
    
    @Override
    public void init() {

        super.init();

        conditions.put("subjectTitle", new EqualityChecker("Madam"));
        conditions.put("legalAccessPresence", new EqualityChecker("true"));
        conditions.put("legalAccessRepresentativeKind", new EqualityChecker("Other"));
        conditions.put("familyFamilyDependents", new EqualityChecker("true"));
        conditions.put("dwellingKind", new EqualityListChecker(Arrays.asList("Other", "ThirdPartyPlaceOfResidence")));
        conditions.put("dwellingEstablishmentReception", new EqualityChecker("true"));
        conditions.put("dwellingSocialReception", new EqualityChecker("true"));
        conditions.put("socialSecurityMemberShipKind", new EqualityListChecker(Arrays.asList("Insured", "Claimant")));
        conditions.put("paymentAgencyBeneficiary", new EqualityListChecker(Arrays.asList("CAF", "MSA", "Other")));
        conditions.put("studiesHighSchool", new EqualityChecker("true"));
        conditions.put("studiesAssistanceUnderDisability", new EqualityChecker("true"));
        conditions.put("professionalStatusKind", new EqualityChecker("Employee"));
//        conditions.put("professionalStatusKind", new EqualityChecker("Unemployee"));//  isUnemployed" />
        conditions.put("professionalStatusRegisterAsUnemployed", new EqualityChecker("true"));
        conditions.put("professionalStatusIndemnified", new EqualityChecker("true"));
        conditions.put("professionalStatusElectiveFunction", new EqualityChecker("true"));
        conditions.put("foldersMdph", new EqualityChecker("true"));
        conditions.put("foldersCotorep", new EqualityChecker("true"));
        conditions.put("foldersCdes", new EqualityChecker("true"));
        conditions.put("foldersOtherFolders", new EqualityChecker("true"));
        conditions.put("benefitsDisabilityRecognition", new EqualityChecker("true"));
        conditions.put("benefitsProfessionalOrientation", new EqualityChecker("true"));
        conditions.put("benefitsEducationOfDisabledChildren", new EqualityChecker("true"));
        conditions.put("benefitsDisabilityPension", new EqualityChecker("true"));
        conditions.put("benefitsWorkAccidentAnnuity", new EqualityChecker("true"));
        conditions.put("benefitsSupportedByAnInstitution", new EqualityChecker("true"));
        conditions.put("benefitsOtherBenefits", new EqualityChecker("true"));
        conditions.put("isFamilyAssistance", new EqualityChecker("true"));
        conditions.put("homeInterventionHomeIntervenant", new EqualityChecker("true"));
        conditions.put("homeIntervenants[0].homeIntervenantKind", new EqualityChecker("Other"));
        conditions.put("careCareServices", new EqualityChecker("true"));
        conditions.put("careServices[0].careServiceCareServiceEmployer", new EqualityChecker("true"));
        conditions.put("facilitiesHousing", new EqualityChecker("true"));
        conditions.put("facilitiesTechnicalAssistance", new EqualityChecker("true"));
        conditions.put("facilitiesCustomCar", new EqualityChecker("true"));
        conditions.put("facilitiesAnimalAid", new EqualityChecker("true"));
        conditions.put("facilitiesSpecializedTransport", new EqualityChecker("true"));
        conditions.put("professionalSupportProfessionals", new EqualityChecker("true"));
        conditions.put("professionalSupportSocialServiceSupport", new EqualityChecker("true"));
        conditions.put("socialServiceSupport", new EqualityChecker("true"));
        conditions.put("healthFollowedByDoctor", new EqualityChecker("true"));
        conditions.put("healthFollowedByProfessional", new EqualityChecker("true"));
        conditions.put("healthFollowedByHospital", new EqualityChecker("true"));
        conditions.put("projectRequestsProfessionalOrientation", new EqualityChecker("true"));
        conditions.put("projectRequestsOther", new EqualityChecker("true"));
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof HandicapCompensationAdultRequest;
    }

    @Override
    public Request getSkeletonRequest() throws CvqException {
        return new HandicapCompensationAdultRequest();
    }
}