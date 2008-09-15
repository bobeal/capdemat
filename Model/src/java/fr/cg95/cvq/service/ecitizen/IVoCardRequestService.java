package fr.cg95.cvq.service.ecitizen;

import java.util.Set;

import fr.cg95.cvq.business.ecitizen.VoCardRequest;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.IRequestService;

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
    void create(final VoCardRequest vocd, final Set<Adult> adults, final Set<Child> children, 
            final Address adress)
        throws CvqException;
}
