package fr.cg95.cvq.external;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.testtool.ServiceTestCase;

public class ExternalServiceGeneralTest extends ServiceTestCase {

    private IExternalService externalService;
    private IExternalProviderService fakeExternalService;
    
    public void onSetUp() throws Exception {
        super.onSetUp();
        externalService = (IExternalService) getBean("externalService");
        fakeExternalService = (IExternalProviderService) getBean("fakeExternalService");
    }
    
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

    public void testHasMatchingExternalService() throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.ADMIN_CONTEXT);

        ExternalServiceBean esb = new ExternalServiceBean();
        List<String> requestTypes = new ArrayList<String>();
        requestTypes.add("School Registration");
        esb.setRequestTypes(requestTypes);
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        lacb.registerExternalService(fakeExternalService, esb);

        boolean matched = externalService.hasMatchingExternalService("School Registration");
        if (!matched)
            fail("should have matched");
        
        matched = externalService.hasMatchingExternalService("VO Card Request");
        if (matched)
            fail("should have not matched");

        lacb.unregisterExternalService(fakeExternalService);
    }
    
    public void testGetRequestTypesForExternalService() throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.ADMIN_CONTEXT);

        ExternalServiceBean esb = new ExternalServiceBean();
        List<String> requestTypes = new ArrayList<String>();
        requestTypes.add("School Registration");
        esb.setRequestTypes(requestTypes);
        
        // register the mock external provider service with the LACB
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        lacb.registerExternalService(fakeExternalService, esb);

        Set<String> requestTypesFromService =
            externalService.getRequestTypesForExternalService(fakeExternalService.getLabel());
        assertNotNull(requestTypesFromService);
        assertEquals(1, requestTypesFromService.size());
        assertEquals("School Registration", requestTypesFromService.iterator().next());

        lacb.unregisterExternalService(fakeExternalService);
    }
}
