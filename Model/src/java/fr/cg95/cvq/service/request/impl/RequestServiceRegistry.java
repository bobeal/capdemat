package fr.cg95.cvq.service.request.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.ListableBeanFactory;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestForm;
import fr.cg95.cvq.business.request.RequestFormType;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.dao.request.IRequestFormDAO;
import fr.cg95.cvq.dao.request.IRequestTypeDAO;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityLifecycleAware;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.request.IRequestServiceRegistry;
import fr.cg95.cvq.service.request.IRequestTypeLifecycleAware;

/**
 * Implementation of the request service registry interface.
 * 
 * @see IRequestServiceRegistry
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class RequestServiceRegistry 
    implements IRequestServiceRegistry, ILocalAuthorityLifecycleAware, BeanFactoryAware {

    private static Logger logger = Logger.getLogger(RequestServiceRegistry.class);

    private ILocalAuthorityRegistry localAuthorityRegistry;
    
    private IRequestFormDAO requestFormDAO;
    private IRequestTypeDAO requestTypeDAO;
    
    private Boolean performDbUpdates;
    
    /** a list of all known local authorities */
    private Set<String> localAuthoritiesNamesSet = new HashSet<String>();
    
    /** a map of all known request services keyed by service label */
    private Map<String, IRequestService> servicesMap = new HashMap<String, IRequestService>();

    /** a list of all services interested in request types lifecycle */
    protected Collection<IRequestTypeLifecycleAware> allListenerServices;

    private ListableBeanFactory beanFactory;

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ListableBeanFactory) beanFactory;
    }

    public void init() {
        Map<String, IRequestTypeLifecycleAware> services = 
            beanFactory.getBeansOfType(IRequestTypeLifecycleAware.class, true, true);
        if (services != null && !services.isEmpty()) {
            allListenerServices = services.values();
        }
    }

    public IRequestService getRequestService(Request request) {
        for (IRequestService requestService : servicesMap.values()) {
            if (requestService.accept(request))
                return requestService;
        }

        return null;
    }

    public IRequestService getRequestService(String requestLabel) {
        for (IRequestService requestService : servicesMap.values()) {
            if (requestService.getLabel().equals(requestLabel))
                return requestService;
        }

        return null;
    }

    public IRequestService getRequestService(Long requestTypeId)
        throws CvqObjectNotFoundException {
        RequestType requestType = 
            (RequestType) requestTypeDAO.findById(RequestType.class, requestTypeId);
        return getRequestService(requestType.getLabel());
    }

    public void registerService(IRequestService service, String label)
        throws CvqConfigurationException {

        logger.debug("registerService() registering service " + service + " with label " + label);
        if (label == null || service == null)
            throw new CvqConfigurationException("null label or service for registering service");

        servicesMap.put(label, service);

        // inform authorities service it has a new local referential file to deal with
//         if (service.getLocalReferentialFilename() != null) {
//             try {
//                 authoritiesService.addLocalReferentialDataReference(service.getLabel(),
//                                                                     service.getLocalReferentialFilename());
//             } catch (CvqException e) {
//                 logger.error("Error while parsing local referential file for request type : "
//                              + service.getLabel());
//                 throw new CvqConfigurationException("Error while parsing local referential file for request type : " + service.getLabel());
//             }
//         }

        // notify listener services of the new request type
        if (allListenerServices != null) {
            for (IRequestTypeLifecycleAware tempService : allListenerServices) {
                tempService.addRequestTypeService(service);
            }
        }

        // add this new request type to all known local authorities
        if (performDbUpdates) {
            for (String localAuthorityName : localAuthoritiesNamesSet) {
                Object[] args = new Object[1];
                args[0] = label;
                logger.debug("registerService() adding service to " + localAuthorityName);
                localAuthorityRegistry.callback(localAuthorityName, this, "initRequestData", args);
            }
        }
    }

    public void addLocalAuthority(String localAuthorityName) {
        
        if (performDbUpdates) {
            logger.debug("addLocalAuthority() adding " + localAuthorityName);
            for (String serviceLabel : servicesMap.keySet()) {
                Object[] args = new Object[1];
                args[0] = serviceLabel;
                logger.debug("addLocalAuthority() registering service " + serviceLabel);
                localAuthorityRegistry.callback(localAuthorityName, this, "initRequestData", args);
            }
        }

        localAuthoritiesNamesSet.add(localAuthorityName);
    }

    public void removeLocalAuthority(String localAuthorityName) {
        // nothing to do
    }

    public void initRequestData(String serviceLabel) 
        throws CvqException {
        
        if (serviceLabel == null || serviceLabel.trim().length() == 0) {
            logger.info("initRequestData() ignoring empty service label");
            return;
        }
        
        logger.debug("initRequestData() initializing " + serviceLabel 
                + " for local authority " 
                + SecurityContext.getCurrentSite().getName());
        
        RequestType requestType = requestTypeDAO.findByLabel(serviceLabel);
        if (requestType != null) {
            logger.debug("initRequestData() request type " + serviceLabel + " already registered");
            return;
        } 

        IRequestService service = servicesMap.get(serviceLabel);

        RequestForm requestForm = 
            requestFormDAO.findByTypeAndRequest(RequestFormType.REQUEST_CERTIFICAT, serviceLabel);
        if (requestForm == null) {
            requestForm = new RequestForm();
            requestForm.setType(RequestFormType.REQUEST_CERTIFICAT);
            requestForm.setXslFoFilename(service.getXslFoFilename());
            requestFormDAO.create(requestForm);
        }
        
        requestType = new RequestType();
        requestType.setLabel(serviceLabel);
        requestType.setActive(Boolean.FALSE);
        requestType.setAuthorizeMultipleRegistrationsPerSeason(Boolean.FALSE);
        if (service.isOfRegistrationKind())
            requestType.setHasAutomaticActivation(Boolean.TRUE);
        else 
            requestType.setHasAutomaticActivation(Boolean.FALSE);
        Set<RequestForm> formsSet = new HashSet<RequestForm>();
        formsSet.add(requestForm);
        requestType.setForms(formsSet);
        requestTypeDAO.create(requestType);
        
        if (requestForm.getRequestTypes() == null) {
            Set<RequestType> requestTypesSet = new HashSet<RequestType>();
            requestTypesSet.add(requestType);
            requestForm.setRequestTypes(requestTypesSet);
        } else {
            requestForm.getRequestTypes().add(requestType);
        }
        requestFormDAO.update(requestForm);
    }
    
    public List<IRequestService> getServicesSupportingUnregisteredCreation() {
        List<IRequestService> result = new ArrayList<IRequestService>();
        for (IRequestService requestService : servicesMap.values()) {
            if (requestService.supportUnregisteredCreation())
                result.add(requestService);
        }

        return result;
    }
    

    public List<IRequestService> getServicesSupportingSeasons() {
        List<IRequestService> result = new ArrayList<IRequestService>();
        for (IRequestService requestService : servicesMap.values()) {
            if (requestService.isOfRegistrationKind())
                result.add(requestService);
        }

        return result;
    }

    public IRequestService getDefaultRequestService() {
        // default request service has an empty label
        // FIXME : make this a property of the service
        return (IRequestService) servicesMap.get("");
    }

    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }

    public void setRequestFormDAO(IRequestFormDAO requestFormDAO) {
        this.requestFormDAO = requestFormDAO;
    }

    public void setRequestTypeDAO(IRequestTypeDAO requestTypeDAO) {
        this.requestTypeDAO = requestTypeDAO;
    }

    public void setPerformDbUpdates(Boolean performDbUpdates) {
        if (performDbUpdates != null)
            this.performDbUpdates = performDbUpdates;
        else
            this.performDbUpdates = Boolean.FALSE;
    }
}
