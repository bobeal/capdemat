package fr.cg95.cvq.service.request.election.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.election.ElectoralMotiveType;
import fr.cg95.cvq.business.request.election.ElectoralRollRegistrationRequest;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;

/**
 * Implementation of the electoral roll registration request service.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class ElectoralRollRegistrationRequestService extends RequestService {

    @Override
    public void init() {
        ElectoralRollRegistrationRequest.conditions.put("motive",
            new EqualityChecker(ElectoralMotiveType.DIRECT_CITY_CONTRIBUTION.name()));
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof ElectoralRollRegistrationRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new ElectoralRollRegistrationRequest();
    }
}
