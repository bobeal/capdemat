package fr.cg95.cvq.service.request.civil.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.civil.PersonalDetailsRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.civil.IPersonalDetailsRequestService;
import fr.cg95.cvq.service.request.impl.RequestService;


/**
 * Implementation of the personal details request service.
 * 
 * @author bor@zenexity.fr
 */
public final class PersonalDetailsRequestService extends RequestService 
    implements IPersonalDetailsRequestService {

    @Override
    public boolean accept(Request request) {
        return request instanceof PersonalDetailsRequest;
    }

    @Override
    public Request getSkeletonRequest() throws CvqException {
        return new PersonalDetailsRequest();
    }
}
