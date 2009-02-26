package fr.cg95.cvq.service.request.social.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.social.RemoteSupportRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.social.IRemoteSupportRequestService;


/**
 * Implementation of the remote support request service.
 * 
 * @author Rafik Djedjig (rdj@zenexity.fr)
 */
public class RemoteSupportRequestService extends RequestService 
    implements IRemoteSupportRequestService {
    
    public Long create(final Request request) throws CvqException, CvqObjectNotFoundException {

        RemoteSupportRequest rsr = (RemoteSupportRequest) request;
        performBusinessChecks(rsr);

        return finalizeAndPersist(rsr);
    }
    
    public boolean accept(Request request) {
        return request instanceof RemoteSupportRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new RemoteSupportRequest();
    }
    
    public final Map<String,IConditionChecker> filledConditions = new HashMap<String,IConditionChecker>();
    private void initFilledConditions() {
        filledConditions.put("requestInformationRequestKind", new EqualityChecker("Couple"));
        filledConditions.put("requestInformationEmergency", new EqualityChecker("true"));
        filledConditions.put("contactKind", new EqualityChecker("Other"));
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
    
}
