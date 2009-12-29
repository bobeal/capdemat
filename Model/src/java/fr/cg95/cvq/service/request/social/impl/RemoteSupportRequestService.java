package fr.cg95.cvq.service.request.social.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.social.RemoteSupportRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.social.IRemoteSupportRequestService;


/**
 * Implementation of the remote support request service.
 * 
 * @author Rafik Djedjig (rdj@zenexity.fr)
 */
public class RemoteSupportRequestService extends RequestService 
    implements IRemoteSupportRequestService {

    
    @Override
    public void init() {

        super.init();

        conditions.put("requestInformationRequestKind", new EqualityChecker("Couple"));
        conditions.put("requestInformationEmergency", new EqualityChecker("true"));
        conditions.put("contactKind", new EqualityChecker("Other"));
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof RemoteSupportRequest;
    }

    @Override
    public Request getSkeletonRequest() throws CvqException {
        return new RemoteSupportRequest();
    }
}
