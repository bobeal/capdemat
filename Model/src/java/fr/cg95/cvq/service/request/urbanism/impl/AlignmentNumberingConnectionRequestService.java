package fr.cg95.cvq.service.request.urbanism.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.urbanism.AlignmentNumberingConnectionRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.urbanism.IAlignmentNumberingConnectionRequestService;

/**
 * @author jsb@zenexity.fr
 */
public class AlignmentNumberingConnectionRequestService extends RequestService implements
        IAlignmentNumberingConnectionRequestService {

    @Override
    public void init() {
        super.init();

        conditions.put("isAccountAddress", new EqualityChecker("true"));
        conditions.put("requesterQuality", new EqualityChecker("Owner"));
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof AlignmentNumberingConnectionRequest;
    }

    @Override
    public Request getSkeletonRequest() throws CvqException {
        return new AlignmentNumberingConnectionRequest();
    }
}
