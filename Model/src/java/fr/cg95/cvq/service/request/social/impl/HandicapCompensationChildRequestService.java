package fr.cg95.cvq.service.request.social.impl;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.social.HandicapCompensationChildRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.request.condition.DateChecker;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.condition.EqualityListChecker;
import fr.cg95.cvq.service.request.condition.IConditionChecker;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.social.IHandicapCompensationChildRequestService;
import fr.cg95.cvq.util.DateUtils;


/**
 * Implementation of the child handicap allowance request service.
 * 
 * @author maxence.veyret@bull.net
 */
public class HandicapCompensationChildRequestService extends RequestService 
    implements IHandicapCompensationChildRequestService {
    
    static Logger logger = Logger.getLogger(HandicapCompensationChildRequestService.class);

    @Override
    public Long create(final Request request) throws CvqException, CvqObjectNotFoundException {

        HandicapCompensationChildRequest hccr = (HandicapCompensationChildRequest) request;
        performBusinessChecks(hccr);

        return finalizeAndPersist(hccr);
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof HandicapCompensationChildRequest;
    }

    @Override
    public Request getSkeletonRequest() throws CvqException {
        return new HandicapCompensationChildRequest();
    }
    
    public final Map<String,IConditionChecker> filledConditions = new HashMap<String,IConditionChecker>();
    private void initFilledConditions() {
        filledConditions.put("referentTitle", new EqualityChecker("Madam"));
        filledConditions.put("fatherActivityReduction", new EqualityChecker("true"));
        filledConditions.put("motherActivityReduction", new EqualityChecker("true"));
        filledConditions.put("referentFamilyDependents", new EqualityChecker("true"));
        filledConditions.put("dwellingKind", new EqualityListChecker(Arrays.asList("Other", "ThirdPartyPlaceOfResidence")));
        filledConditions.put("dwellingEstablishmentReception", new EqualityChecker("true"));
        filledConditions.put("dwellingSocialReception", new EqualityChecker("true"));
        filledConditions.put("socialSecurityMemberShipKind", new EqualityListChecker(Arrays.asList("Insured", "Claimant")));
        filledConditions.put("paymentAgencyBeneficiary", new EqualityListChecker(Arrays.asList("CAF", "MSA", "Other")));
        filledConditions.put("studiesHighSchool", new EqualityChecker("true"));
        filledConditions.put("studiesAssistanceUnderDisability", new EqualityChecker("true"));
        filledConditions.put("professionalStatusKind", new EqualityChecker("Employee"));
//        filledConditions.put("StudiesAssistanceUnderDisability", new EqualityChecker("Unemployee"));//  isUnemployed" />
        filledConditions.put("professionalStatusRegisterAsUnemployed", new EqualityChecker("true"));
        filledConditions.put("professionalStatusIndemnified", new EqualityChecker("true"));
        filledConditions.put("professionalStatusElectiveFunction", new EqualityChecker("true"));
        filledConditions.put("foldersMdph", new EqualityChecker("true"));
        filledConditions.put("foldersCotorep", new EqualityChecker("true"));
        filledConditions.put("foldersCdes", new EqualityChecker("true"));
        filledConditions.put("foldersOtherFolders", new EqualityChecker("true"));
        filledConditions.put("benefitsDisabilityRecognition", new EqualityChecker("true"));
        filledConditions.put("benefitsProfessionalOrientation", new EqualityChecker("true"));
        filledConditions.put("benefitsEducationOfDisabledChildren", new EqualityChecker("true"));
        filledConditions.put("benefitsDisabilityPension", new EqualityChecker("true"));
        filledConditions.put("benefitsWorkAccidentAnnuity", new EqualityChecker("true"));
        filledConditions.put("benefitsSupportedByAnInstitution", new EqualityChecker("true"));
        filledConditions.put("benefitsOtherBenefits", new EqualityChecker("true"));
        filledConditions.put("isFamilyAssistance", new EqualityChecker("true"));
        filledConditions.put("homeInterventionHomeIntervenant", new EqualityChecker("true"));
        filledConditions.put("homeIntervenants[0].homeIntervenantKind", new EqualityChecker("Other"));
        filledConditions.put("careCareServices", new EqualityChecker("true"));
        filledConditions.put("careServices[0].careServiceCareServiceEmployer", new EqualityChecker("true"));
        filledConditions.put("facilitiesHousing", new EqualityChecker("true"));
        filledConditions.put("facilitiesTechnicalAssistance", new EqualityChecker("true"));
        filledConditions.put("facilitiesCustomCar", new EqualityChecker("true"));
        filledConditions.put("facilitiesAnimalAid", new EqualityChecker("true"));
        filledConditions.put("facilitiesSpecializedTransport", new EqualityChecker("true"));
        filledConditions.put("professionalSupportProfessionals", new EqualityChecker("true"));
        filledConditions.put("professionalSupportSocialServiceSupport", new EqualityChecker("true"));
        filledConditions.put("socialServiceSupport", new EqualityChecker("true"));
        filledConditions.put("healthFollowedByDoctor", new EqualityChecker("true"));
        filledConditions.put("healthFollowedByProfessional", new EqualityChecker("true"));
        filledConditions.put("healthFollowedByHospital", new EqualityChecker("true"));
        filledConditions.put("projectRequestsProfessionalOrientation", new EqualityChecker("true"));
        filledConditions.put("projectRequestsOther", new EqualityChecker("true"));
        filledConditions.put("subjectBirthDate", new DateChecker("<", DateUtils.getShiftedDate(Calendar.YEAR, - 18)));
    }
   
    /**
     * TODO - move to abstract RequestService
     */
    @Override
    public boolean isConditionFilled (Map<String, String> triggers) {
        initFilledConditions();
        boolean test = true;
        for (Entry<String, String> trigger : triggers.entrySet()) {
            if (filledConditions.get(trigger.getKey()) != null 
                && filledConditions.get(trigger.getKey()).test(trigger.getValue()))
                test = test && true;
            else
                return false;
        }
        return test;
    }
           
}