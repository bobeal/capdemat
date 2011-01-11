package fr.cg95.cvq.external;


public interface IExternalService {

    /**
     * Authenticate an external service.
     */
    boolean authenticate(final String externalServiceLabel, final String password);
    
    IExternalProviderService getExternalServiceByLabel(String externalServiceLabel);
}