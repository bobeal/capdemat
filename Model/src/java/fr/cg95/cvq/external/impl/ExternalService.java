package fr.cg95.cvq.external.impl;

import java.util.Map;

import org.apache.log4j.Logger;

import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.external.IExternalService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;

public class ExternalService implements IExternalService {

    private static Logger logger = Logger.getLogger(ExternalService.class);

    @Override
    public boolean authenticate(String externalServiceLabel, String password) {
        IExternalProviderService externalProviderService =
            getExternalServiceByLabel(externalServiceLabel);
        if (externalProviderService == null) {
            logger.warn("authenticate() unable to find a matching service for " + externalServiceLabel);
            return false;
        }

        ExternalServiceBean esb = getBeanForExternalService(externalProviderService);
        if (esb.getPassword().equals(password))
            return true;

        logger.warn("authenticate() authentication failed for service " + externalServiceLabel);
        return false;
    }

    /**
     * Get the external provider service that has the given label.
     */
    @Override
    public IExternalProviderService getExternalServiceByLabel(final String externalServiceLabel) {
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        Map<IExternalProviderService, ExternalServiceBean> externalProviderServices = 
            lacb.getExternalServices();
        if (externalProviderServices == null || externalProviderServices.isEmpty())
            return null;

        for (IExternalProviderService service : externalProviderServices.keySet()) {
            if (service.getLabel().equals(externalServiceLabel))
                return service;
        }

        return null;
    }

    /**
     * Get the configuration bean associated to the given external provider service.
     */
    @Override
    public ExternalServiceBean getBeanForExternalService(IExternalProviderService externalProviderService) {
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        return lacb.getExternalServices().get(externalProviderService);
    }
}
