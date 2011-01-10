package fr.cg95.cvq.service.request.ecitizen.impl;

import fr.cg95.cvq.business.CapDematEvent;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.ecitizen.VoCardRequest;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;

/**
 * Implementation of the account creation request service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class VoCardRequestService extends RequestService {

    @Override
    public void init() {
        VoCardRequest.conditions.put("title", new EqualityChecker("Madam"));
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof VoCardRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new VoCardRequest();
    }

    @Override
    public void onApplicationEvent(CapDematEvent e) {}
}
