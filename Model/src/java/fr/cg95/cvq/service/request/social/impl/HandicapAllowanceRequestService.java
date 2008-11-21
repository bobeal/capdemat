package fr.cg95.cvq.service.request.social.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.social.HandicapAllowanceRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.social.IHandicapAllowanceRequestService;


/**
 * Implementation of the handicap allowance request service.
 * 
 * @author Rafik Djedjig (rdj@zenexity.fr)
 */
public class HandicapAllowanceRequestService extends RequestService 
    implements IHandicapAllowanceRequestService {
    
    public boolean accept(Request request) {
        return request instanceof HandicapAllowanceRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new HandicapAllowanceRequest();
    }
}
