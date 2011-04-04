package fr.cg95.cvq.external.endpoint;

import org.junit.Test;
import org.springframework.oxm.xmlbeans.XmlBeansMarshaller;

import fr.cg95.cvq.external.endpoint.HomeFolderServiceEndpoint;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.testtool.ServiceTestCase;

public class HomeFolderServiceEndpointTest extends ServiceTestCase {

    @Test
    public void testHomeFolderServiceEndpoint() throws Exception {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        XmlBeansMarshaller xmlBeansMarshaller = new XmlBeansMarshaller();
        HomeFolderServiceEndpoint hfsEndpoint = new HomeFolderServiceEndpoint(xmlBeansMarshaller);
        hfsEndpoint.setUserService(userService);
        hfsEndpoint.setUserSearchService(userSearchService);
        hfsEndpoint.invokeInternal(null);
        SecurityContext.resetCurrentSite();
    }
}
