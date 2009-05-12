package fr.cg95.cvq.service.request.ecitizen;

import java.util.List;

import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.ecitizen.VoCardRequest;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.annotation.IsRequester;
import fr.cg95.cvq.security.annotation.IsSubject;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.request.annotation.IsRequest;

/**
 * Service in charge of the accounts creation requests.
 * 
 * @author bor@zenexity.fr
 */
public interface IVoCardRequestService extends IRequestService {

    /** service name used by Spring's application context */
    String SERVICE_NAME = "voCardRequestService";

    /**
     * Create an account creation request.
     */
    void create(VoCardRequest vocd, List<Adult> adults, List<Child> children, 
            final Address adress)
        throws CvqException;
    
    void create(VoCardRequest vocd, List<Adult> adults, List<Child> children, 
            final Address adress, List<Document> documents)
        throws CvqException;
    
}
