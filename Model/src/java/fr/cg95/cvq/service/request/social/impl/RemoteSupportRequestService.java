package fr.cg95.cvq.service.request.social.impl;

import java.util.Map;

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
    
    public boolean checkIsEmergency(final Map<String,String> inputs){
        if (inputs.get("rsrIsEmergency").equals("true"))
            return true;
        return false;
    }
    
    public boolean checkIsFlat(final Map<String,String> inputs){
        if (inputs.get("rsrRequesterResidenceKind").equals("fr.cg95.cvq.business.request.social.RsrResidenceKindType_flat"))
            return true;
        return false;
    }
    
    public boolean checkIsCoupleRequest(final Map<String,String> inputs){
        if (inputs.get("rsrRequestKind").equals("fr.cg95.cvq.business.request.social.RsrRequestKindType_Couple"))
            return true;
        return false;
    }
    
    public boolean checkIsOtherContact(final Map<String,String> inputs){
        if (inputs.get("rsrContactKind").equals("fr.cg95.cvq.business.request.social.RsrContactKindType_other"))
            return true;
        return false;
    }
}
