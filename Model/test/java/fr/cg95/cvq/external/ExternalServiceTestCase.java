package fr.cg95.cvq.external;

import java.util.ArrayList;
import java.util.List;

import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.request.IRequestTypeService;
import fr.cg95.cvq.service.request.RequestTestCase;

public class ExternalServiceTestCase extends RequestTestCase {

    protected IExternalService externalService;
    protected IExternalProviderService fakeExternalService;
    
    @Override
    public void onSetUp() throws Exception {
        super.onSetUp();
        fakeExternalService = getApplicationBean("fakeExternalService");
    }

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
    
    public void setExternalService(IExternalService externalService) {
        this.externalService = externalService;
    }
}
