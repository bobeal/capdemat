package fr.cg95.cvq.service.request.social.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.social.RemoteSupportRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
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
    public Long create(final Request request) throws CvqException, CvqObjectNotFoundException {

        RemoteSupportRequest rsr = (RemoteSupportRequest) request;
        performBusinessChecks(rsr);

        return finalizeAndPersist(rsr);
    }
    
    @Override
    public boolean accept(Request request) {
        return request instanceof RemoteSupportRequest;
    }

    @Override
    public Request getSkeletonRequest() throws CvqException {
        return new RemoteSupportRequest();
    }
    
    @Override
    protected void initFilledConditions() {
        super.initFilledConditions();
        filledConditions.put("requestInformationRequestKind", new EqualityChecker("Couple"));
        filledConditions.put("requestInformationEmergency", new EqualityChecker("true"));
        filledConditions.put("contactKind", new EqualityChecker("Other"));
    }
    
}
