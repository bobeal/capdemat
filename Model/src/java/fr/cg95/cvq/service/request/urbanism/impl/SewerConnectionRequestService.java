package fr.cg95.cvq.service.request.urbanism.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.urbanism.ScrRequesterQualityType;
import fr.cg95.cvq.business.request.urbanism.SewerConnectionRequest;
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
        SewerConnectionRequest.conditions.put("requesterQuality", new EqualityChecker(ScrRequesterQualityType.TENANT.name()));
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof SewerConnectionRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new SewerConnectionRequest();
    }
}
