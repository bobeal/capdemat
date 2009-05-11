package fr.cg95.cvq.service.request.civil.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.civil.BirthDetailsRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
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
        BirthDetailsRequest request = new BirthDetailsRequest();
        request.setBirthCity(SecurityContext.getCurrentSite().getDisplayTitle());
        request.setBirthPostalCode(SecurityContext.getCurrentSite().getPostalCode());
        return request;
    }

    protected void initFilledConditions() {
        super.initFilledConditions();
        filledConditions.put("requesterQuality", new EqualityChecker("Other"));
        filledConditions.put("format",
            new EqualityListChecker(Arrays.asList("FullCopy", "ExtractWithRelationship")));
    }
}
