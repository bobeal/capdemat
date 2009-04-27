package fr.cg95.cvq.service.request.civil.impl;

import java.util.Arrays;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.civil.MarriageDetailsRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.civil.IMarriageDetailsRequestService;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.condition.EqualityListChecker;
import fr.cg95.cvq.service.request.impl.RequestService;

/**
 * Implementation of the {@link IMarriageDetailsRequestService marriage details request service}.
 * 
 * @author bor@zenexity.fr
 */
public final class MarriageDetailsRequestService extends RequestService 
    implements IMarriageDetailsRequestService {
    
    @Override
    public boolean accept(Request request) {
        return request instanceof MarriageDetailsRequest;
    }

    @Override
    public Request getSkeletonRequest() throws CvqException {
        return new MarriageDetailsRequest();
    }
    
    protected void initFilledConditions() {
        super.initFilledConditions();
        filledConditions.put("requesterQuality", new EqualityChecker("Other"));
        filledConditions.put("format",
            new EqualityListChecker(Arrays.asList("FullCopy", "ExtractWithRelationship")));
    }
}
