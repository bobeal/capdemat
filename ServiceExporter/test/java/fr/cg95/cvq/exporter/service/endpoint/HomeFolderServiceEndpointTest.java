package fr.cg95.cvq.exporter.service.endpoint;

import org.junit.Test;
import org.springframework.oxm.xmlbeans.XmlBeansMarshaller;

import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.users.IHomeFolderService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.testtool.ServiceTestCase;

public class HomeFolderServiceEndpointTest extends ServiceTestCase {

    @Test
    public void testHomeFolderServiceEndpoint() throws CvqException {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        try {
            XmlBeansMarshaller xmlBeansMarshaller = new XmlBeansMarshaller();
            HomeFolderServiceEndpoint hfsEndpoint = new HomeFolderServiceEndpoint(xmlBeansMarshaller);
            IHomeFolderService homeFolderService = getApplicationBean("homeFolderService");
            hfsEndpoint.setHomeFolderService(homeFolderService);
            
            hfsEndpoint.invokeInternal(null);
            
            SecurityContext.resetCurrentSite();
        } catch (Exception e) {
            throw new CvqException(e.getMessage());
        }
        
    }
}
