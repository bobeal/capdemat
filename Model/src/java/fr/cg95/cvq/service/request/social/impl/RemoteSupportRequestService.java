package fr.cg95.cvq.service.request.social.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.social.RemoteSupportRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.social.IRemoteSupportRequestService;


/**
 * Implementation of the remote support request service.
 * 
 * @author Rafik Djedjig (rdj@zenexity.fr)
 */
public class RemoteSupportRequestService extends RequestService 
    implements IRemoteSupportRequestService {
    
    public boolean accept(Request request) {
        return request instanceof RemoteSupportRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new RemoteSupportRequest();
    }
       
}
