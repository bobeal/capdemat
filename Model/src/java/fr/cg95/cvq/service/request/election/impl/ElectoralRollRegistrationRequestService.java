package fr.cg95.cvq.service.request.election.impl;


//import org.springframework.stereotype.Service;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.election.ElectoralRollRegistrationRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.election.IElectoralRollRegistrationRequestService;
import fr.cg95.cvq.service.request.impl.RequestService;

/**
 * Implementation of the electoral roll registration request service.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 * @Service
 */
public final class ElectoralRollRegistrationRequestService extends RequestService 
    implements IElectoralRollRegistrationRequestService {

    public boolean accept(Request request) {
        return request instanceof ElectoralRollRegistrationRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new ElectoralRollRegistrationRequest();
    }
    
    // TODO PACKAGING
    // a test of auto-injection of service, using the @Service annnotation
    // problem : injected properties of parent service are not inherited (cf parent=... in bean definition)
    
    /*
    public String getLabel() {
        return "Electoral Roll Registration";
    }
    
    public String getXslFoFilename() {
        return "electoralRollRegistrationRequest.xsl";
    }
    
    public String getSubjectPolicy() {
        return SUBJECT_POLICY_ADULT;
    }
    
    public boolean isOfRegistrationKind() {
        return true;
    }
    */
}
