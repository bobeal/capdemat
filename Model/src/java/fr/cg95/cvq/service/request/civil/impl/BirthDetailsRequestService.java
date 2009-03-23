package fr.cg95.cvq.service.request.civil.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.civil.BirthDetailsRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.civil.IBirthDetailsRequestService;
import fr.cg95.cvq.service.request.impl.RequestService;

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
}
