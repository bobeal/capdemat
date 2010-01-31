package fr.cg95.cvq.service.request.urbanism.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.urbanism.SewerConnectionRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;

/**
 * Implementation of the sewer connection request service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class SewerConnectionRequestService extends RequestService {

    @Override
    public void init() {
        super.init();

        conditions.put("requesterQuality", new EqualityChecker("Tenant"));
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof SewerConnectionRequest;
    }

    @Override
    public Request getSkeletonRequest() throws CvqException {
        return new SewerConnectionRequest();
    }
}
