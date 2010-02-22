package fr.cg95.cvq.external;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;

public class ExternalServiceGeneralTest extends ExternalServiceTestCase {

    @Test
    public void testAuthenticate() throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.ADMIN_CONTEXT);
        
        ExternalServiceBean esb = new ExternalServiceBean();
        esb.setPassword("12345678");
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        lacb.registerExternalService(fakeExternalService, esb);
        
        boolean authenticated =
            externalService.authenticate(fakeExternalService.getLabel(), "12345678");
        if (!authenticated)
            fail("authentication failed for fake external service");
        
        authenticated = externalService.authenticate(fakeExternalService.getLabel(), "blop");
        if (authenticated)
            fail("authentication should have failed !");
        
        lacb.unregisterExternalService(fakeExternalService);
    }
}
