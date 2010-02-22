package fr.cg95.cvq.external;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.request.IRequestTypeService;
import fr.cg95.cvq.service.request.RequestTestCase;

/**
 * FIXME : dependency on request test case has to be fixed
 */
public class ExternalServiceTestCase extends RequestTestCase {

    @Autowired
    protected IExternalService externalService;
    @Resource(name="fakeExternalService")
    protected IExternalProviderService fakeExternalService;
    
    protected void registerFakeExternalService() throws CvqConfigurationException {
        ExternalServiceBean esb = new ExternalServiceBean();
        List<String> requestTypes = new ArrayList<String>();
        requestTypes.add(IRequestTypeService.VO_CARD_REGISTRATION_REQUEST);
        esb.setRequestTypes(requestTypes);
        esb.setSupportAccountsByHomeFolder(true);
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        lacb.registerExternalService(fakeExternalService, esb);
    }

    protected void unregisterFakeExternalService() {
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        lacb.unregisterExternalService(fakeExternalService);
    }    
}
