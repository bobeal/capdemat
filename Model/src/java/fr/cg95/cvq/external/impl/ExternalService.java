package fr.cg95.cvq.external.impl;

import org.apache.log4j.Logger;

import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.ExternalServiceConfigurationBean;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.external.IExternalService;
import fr.cg95.cvq.security.SecurityContext;

public class ExternalService implements IExternalService {

    private static Logger logger = Logger.getLogger(ExternalService.class);

    @Override
    public boolean authenticate(String externalServiceLabel, String password) {
        ExternalServiceConfigurationBean escb = 
            SecurityContext.getCurrentConfigurationBean().getExternalServiceConfigurationBean();
        IExternalProviderService externalProviderService =
            escb.getExternalServiceByLabel(externalServiceLabel);
        if (externalProviderService == null) {
            logger.warn("authenticate() unable to find a matching service for " + externalServiceLabel);
            return false;
        }

        ExternalServiceBean esb = escb.getBeanForExternalService(externalProviderService.getLabel());
        if (esb.getPassword().equals(password))
            return true;

        logger.warn("authenticate() authentication failed for service " + externalServiceLabel);
        return false;
    }
    
    @Override
    public IExternalProviderService getExternalServiceByLabel(String externalServiceLabel) {
        return SecurityContext.getCurrentConfigurationBean().getExternalServiceConfigurationBean().getExternalServiceByLabel(externalServiceLabel);
    }
}
