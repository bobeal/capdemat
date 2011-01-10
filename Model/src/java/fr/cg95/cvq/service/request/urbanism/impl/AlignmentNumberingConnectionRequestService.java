package fr.cg95.cvq.service.request.urbanism.impl;

import fr.cg95.cvq.business.CapDematEvent;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.urbanism.AlignmentNumberingConnectionRequest;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;

/**
 * @author jsb@zenexity.fr
 */
public class AlignmentNumberingConnectionRequestService extends RequestService {

    @Override
    public void init() {
        AlignmentNumberingConnectionRequest.conditions.put("isAccountAddress",
            new EqualityChecker("true"));
        AlignmentNumberingConnectionRequest.conditions.put("requesterQuality",
            new EqualityChecker("Owner"));
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof AlignmentNumberingConnectionRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new AlignmentNumberingConnectionRequest();
    }

    @Override
    public void onApplicationEvent(CapDematEvent e) {}
}
