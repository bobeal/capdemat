package fr.cg95.cvq.service.request.election.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.election.ElectoralRollRegistrationRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.election.IElectoralRollRegistrationRequestService;
import fr.cg95.cvq.service.request.impl.RequestService;

/**
 * Implementation of the electoral roll registration request service.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class ElectoralRollRegistrationRequestService extends RequestService 
    implements IElectoralRollRegistrationRequestService {

    public boolean accept(Request request) {
        return request instanceof ElectoralRollRegistrationRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new ElectoralRollRegistrationRequest();
    }
}
