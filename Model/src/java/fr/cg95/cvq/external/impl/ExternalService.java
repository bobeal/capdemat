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
    public boolean authenticate(String login, String password) {
        ExternalServiceConfigurationBean escb = 
            SecurityContext.getCurrentConfigurationBean().getExternalServiceConfigurationBean();

        ExternalServiceBean esb = escb.getExternalServiceBeanByLogin(login);
        if (esb == null){
            logger.warn("authenticate() unable to find a matching service for with login " + login);
            return false;
        }

        if (esb.getPassword().equals(password))
            return true;

        logger.warn("authenticate() authentication failed for service with login " + login);
        return false;
    }
    
    @Override
    public IExternalProviderService getExternalServiceByLabel(String externalServiceLabel) {
        return SecurityContext.getCurrentConfigurationBean().getExternalServiceConfigurationBean().getExternalServiceByLabel(externalServiceLabel);
    }

    @Override
    public IExternalProviderService getExternalServiceByLogin(String login) {
        return SecurityContext.getCurrentConfigurationBean().getExternalServiceConfigurationBean().getExternalServiceByLogin(login);
    }
}
