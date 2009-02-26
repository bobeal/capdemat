package fr.cg95.cvq.service.request.social.impl;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.social.HandicapCompensationChildRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
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

    public Long create(final Request request) throws CvqException, CvqObjectNotFoundException {

        HandicapCompensationChildRequest hccr = (HandicapCompensationChildRequest) request;
        performBusinessChecks(hccr);

        return finalizeAndPersist(hccr);
    }

    public boolean accept(Request request) {
        return request instanceof HandicapCompensationChildRequest;
    }

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
    
    /**
     * Implements IConditionChecker to describe custom business condition policy
     * Custom business implementation might be enclosed as inner class of related request service
     * TODO - move to service.request.condition package
     */
    interface IConditionChecker {
        boolean test(String value);
    }
    
    /**
     * Check if condition triggered value is equal to mark value
     * TODO - move to service.request.condition package
     */
    class EqualityChecker implements IConditionChecker {
        private String mark;
        
        public EqualityChecker(String mark) {
            this.mark = mark;
        }
        
        public boolean test(String value) {
            return mark.equals(value);
        }
    }
    
    /**
     * Check if condition triggered value is equal to one mark value of a list
     * TODO - move to service.request.condition package
     */
    class EqualityListChecker implements IConditionChecker {
        private List<String> marks;
        
        public EqualityListChecker(List<String> marks) {
            this.marks = marks;
        }
        
        public boolean test(String value) {
            for (String mark : marks)
                if (mark.equals(value)) return true;
            return false;
        }
        
    }
    
    /**
     * Check if condition triggered date value is after or before a reference date
     * TODO - move to service.request.condition package
     */
    class DateChecker implements IConditionChecker {
        private Date date;
        private String comparator;
        
        public DateChecker(String comparator, Date date) {
            this.comparator = comparator;
            this.date = date;
        }
        
        public boolean test(String value) {
            try {
                if (comparator.equals("<"))
                    return DateUtils.parseDate(value).after(date);
                else if (comparator.equals(">"))
                    return DateUtils.parseDate(value).before(date);
            } catch (ParseException pe) {
                return false;
            }
            return false;
        }
    }
           
}