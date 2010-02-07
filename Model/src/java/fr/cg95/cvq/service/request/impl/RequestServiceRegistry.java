package fr.cg95.cvq.service.request.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.request.IRequestServiceRegistry;

/**
 * Implementation of the request service registry interface.
 * 
 * @see IRequestServiceRegistry
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class RequestServiceRegistry implements IRequestServiceRegistry {

    private static Logger logger = Logger.getLogger(RequestServiceRegistry.class);
    
    private IRequestDAO requestDAO;

    /** a map of all known request services keyed by service label */
    private Map<String, IRequestService> servicesMap = new HashMap<String, IRequestService>();

    public Collection<IRequestService> getAllRequestServices() {
        return servicesMap.values();
    }
    
    @Override
    public IRequestService getRequestService(Request request) {
        for (IRequestService requestService : servicesMap.values()) {
            if (requestService.accept(request))
                return requestService;
        }

        return null;
    }

    @Override
    public IRequestService getRequestService(String requestLabel) {
        return servicesMap.get(requestLabel);
    }

    @Override
    public IRequestService getRequestService(Long requestId)
        throws CvqObjectNotFoundException {
        Request request =
            (Request) requestDAO.findById(Request.class, requestId);
        return getRequestService(request);
    }

    @Override
    public List<IRequestService> getServicesSupportingUnregisteredCreation() {
        List<IRequestService> result = new ArrayList<IRequestService>();
        for (IRequestService requestService : servicesMap.values()) {
            if (requestService.supportUnregisteredCreation())
                result.add(requestService);
        }

        return result;
    }
    

    @Override
    public List<IRequestService> getServicesSupportingSeasons() {
        List<IRequestService> result = new ArrayList<IRequestService>();
        for (IRequestService requestService : servicesMap.values()) {
            if (requestService.isOfRegistrationKind())
                result.add(requestService);
        }

        return result;
    }

    @Override
    public void registerService(IRequestService requestService) {
        logger.debug("registerService() registering service " + requestService.getLabel());
        servicesMap.put(requestService.getLabel(), requestService);
    }

    public void setRequestDAO(IRequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }
}
