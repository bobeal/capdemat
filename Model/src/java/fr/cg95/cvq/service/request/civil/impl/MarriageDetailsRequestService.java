package fr.cg95.cvq.service.request.civil.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.civil.MarriageDetailsRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.civil.IMarriageDetailsRequestService;
import fr.cg95.cvq.service.request.impl.RequestService;

/**
 * Implementation of the {@link IMarriageDetailsRequestService marriage details request service}.
 * 
 * @author bor@zenexity.fr
 */
public final class MarriageDetailsRequestService extends RequestService 
    implements IMarriageDetailsRequestService {
    
    public boolean accept(Request request) {
        return request instanceof MarriageDetailsRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new MarriageDetailsRequest();
    }
}
