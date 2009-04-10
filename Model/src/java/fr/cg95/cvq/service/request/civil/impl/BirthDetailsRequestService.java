package fr.cg95.cvq.service.request.civil.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.civil.BirthDetailsRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.civil.IBirthDetailsRequestService;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.condition.EqualityListChecker;
import fr.cg95.cvq.service.request.condition.IConditionChecker;
import fr.cg95.cvq.service.request.impl.RequestService;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the {@link IBirthDetailsRequestService birth details request service}.
 * 
 * @author bor@zenexity.fr
 */
public final class BirthDetailsRequestService 
    extends RequestService implements IBirthDetailsRequestService {
    
    @Override
    public boolean accept(Request request) {
        return request instanceof BirthDetailsRequest;
    }

    @Override
    public Request getSkeletonRequest() throws CvqException {
        return new BirthDetailsRequest();
    }

    public final Map<String,IConditionChecker> filledConditions =
        new HashMap<String, IConditionChecker>();
    private void initFilledConditions() {
        filledConditions.put("requesterQuality", new EqualityChecker("Other"));
        filledConditions.put("format",
            new EqualityListChecker(Arrays.asList("FullCopy", "ExtractWithRelationship")));
    }

    /**
     * TODO - move to abstract RequestService
     */
    @Override
    public boolean isConditionFilled (Map<String, String> triggers) {
        initFilledConditions();
        boolean test = true;
        for (Map.Entry<String, String> trigger : triggers.entrySet()) {
            if (filledConditions.get(trigger.getKey()) != null
                && filledConditions.get(trigger.getKey()).test(trigger.getValue()))
                test = test && true;
            else
                return false;
        }
        return test;
    }

}
