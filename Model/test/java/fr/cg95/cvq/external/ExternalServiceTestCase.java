package fr.cg95.cvq.external;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.payment.external.IPaymentExternalService;
import fr.cg95.cvq.service.request.RequestTestCase;
import fr.cg95.cvq.service.request.external.IRequestExternalActionService;
import fr.cg95.cvq.service.request.external.IRequestExternalService;
import fr.cg95.cvq.service.users.external.IExternalHomeFolderService;

/**
 * FIXME : dependency on request test case has to be fixed
 */
public class ExternalServiceTestCase extends RequestTestCase {

    @Autowired
    protected IExternalService externalService;
    @Autowired
    protected IRequestExternalService requestExternalService;
    @Autowired
    protected IRequestExternalActionService requestExternalActionService;
    @Autowired
    protected IPaymentExternalService paymentExternalService;
    @Autowired
    protected IExternalHomeFolderService externalHomeFolderService;
    
    @Resource(name="fakeExternalService")
    protected IExternalProviderService fakeExternalService;

    @Before
    public void registerFakeExternalService() throws CvqConfigurationException {
        ExternalServiceBean esb = new ExternalServiceBean();
        List<String> requestTypes = new ArrayList<String>();
        requestTypes.add(tirLabel);
        esb.setRequestTypes(requestTypes);
        esb.setPassword("12345678");
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        lacb.registerExternalService(fakeExternalService, esb);
    }

    @After
    public void unregisterFakeExternalService() {
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        lacb.unregisterExternalService(fakeExternalService);
    }    
}
