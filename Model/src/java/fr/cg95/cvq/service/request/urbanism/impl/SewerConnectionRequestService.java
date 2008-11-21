package fr.cg95.cvq.service.request.urbanism.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.urbanism.SewerConnectionRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.urbanism.ISewerConnectionRequestService;

/**
 * Implementation of the sewer connection request service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class SewerConnectionRequestService
    extends RequestService implements ISewerConnectionRequestService {

    public boolean accept(Request request) {
        return request instanceof SewerConnectionRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new SewerConnectionRequest();
    }
}
