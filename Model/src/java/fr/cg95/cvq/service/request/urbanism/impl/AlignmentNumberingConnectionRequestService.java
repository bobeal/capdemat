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

    public boolean accept(Request request) {
        return request instanceof AlignmentNumberingConnectionRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new AlignmentNumberingConnectionRequest();
    }

    protected void initFilledConditions() {
        super.initFilledConditions();
        filledConditions.put("isAccountAddress", new EqualityChecker("true"));
        filledConditions.put("requesterQuality", new EqualityChecker("Owner"));
    }
}
