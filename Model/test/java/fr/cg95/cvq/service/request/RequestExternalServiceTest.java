package fr.cg95.cvq.service.request;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;

public class RequestExternalServiceTest extends RequestTestCase {

    private static IRequestExternalService requestExternalService;
    private static IExternalProviderService fakeExternalService;
    
    @Override
    public void onSetUp() throws Exception {
        super.onSetUp();
        fakeExternalService = getApplicationBean("fakeExternalService");
    }

    public void testHasMatchingExternalService() throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.ADMIN_CONTEXT);

        ExternalServiceBean esb = new ExternalServiceBean();
        List<String> requestTypes = new ArrayList<String>();
        requestTypes.add("School Registration");
        esb.setRequestTypes(requestTypes);
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        lacb.registerExternalService(fakeExternalService, esb);

        boolean matched = requestExternalService.hasMatchingExternalService("School Registration");
        if (!matched)
            fail("should have matched");
        
        matched = requestExternalService.hasMatchingExternalService("VO Card");
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

        Collection<String> requestTypesFromService =
            requestExternalService.getRequestTypesForExternalService(fakeExternalService.getLabel());
        assertNotNull(requestTypesFromService);
        assertEquals(1, requestTypesFromService.size());
        assertEquals("School Registration", requestTypesFromService.iterator().next());

        lacb.unregisterExternalService(fakeExternalService);
    }

    public void setRequestExternalService(IRequestExternalService requestExternalService) {
        RequestExternalServiceTest.requestExternalService = requestExternalService;
    }
}
