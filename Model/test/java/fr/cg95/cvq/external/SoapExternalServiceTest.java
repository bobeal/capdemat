package fr.cg95.cvq.external;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.external.impl.SoapExternalServiceClient;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;

public class SoapExternalServiceTest extends ExternalServiceTestCase {

    @Resource(name="soapExternalService")
    private IExternalProviderService soapExternalService;
    @Autowired
    private SoapExternalServiceClient soapExternalServiceClient;
    
    @Test
    public void testInteractions() throws CvqException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.ADMIN_CONTEXT);
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        lacb.unregisterExternalService(fakeExternalService);
        ExternalServiceBean esb = new ExternalServiceBean();
        esb.setPassword("12345678");
        List<String> requestTypes = new ArrayList<String>();
        requestTypes.add(tirLabel);
        esb.setRequestTypes(requestTypes);
        lacb.registerExternalService(soapExternalService, esb);
        soapExternalServiceClient.setFake(true);
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
        
        List<String> messages = requestExternalService.checkExternalReferential(request);
        Assert.assertEquals(2, messages.size());
        
        requestWorkflowService.updateRequestState(request.getId(), RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(request.getId(), RequestState.VALIDATED, null);
        
        continueWithNewTransaction();
        
        Map<String, Object> externalInformations = requestExternalService.loadExternalInformations(request);
        Assert.assertEquals(2, externalInformations.size());

        Map<Date, String> consumptions = 
            requestExternalService.getConsumptions(request.getId(), new Date(), new Date());
        Assert.assertEquals(2, consumptions.size());

        lacb.unregisterExternalService(soapExternalService);
        lacb.registerExternalService(fakeExternalService, esb);
    }
}
