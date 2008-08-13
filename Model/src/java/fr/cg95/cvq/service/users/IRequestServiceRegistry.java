package fr.cg95.cvq.service.users;

import java.util.List;

import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.exception.CvqConfigurationException;

/**
 * Registry for registered request services.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr) bor@zenexity.fr
 */
public interface IRequestServiceRegistry {

    String SERVICE_NAME = "requestServiceRegistry";

    /**
     * Get the service responsible for the management of the given request
     * object.
     */
    IRequestService getRequestService(Request request);

    /**
     * Get the service responsible for the management of the request
     * with the given label.
     */
    IRequestService getRequestService(String requestLabel);
    
    IRequestService getDefaultRequestService();

    /**
     * Get a list of request services supporting creation by un-registered
     * users.
     */
    List getServicesSupportingUnregisteredCreation();

    /**
     * Get a list of request services supporting the notion of seasons 
     * (aka "registration services")
     */
    List getServicesSupportingSeasons();
    
    /**
     * Registration method for request services.
     */
    void registerService(IRequestService service, String label) throws CvqConfigurationException;
}
