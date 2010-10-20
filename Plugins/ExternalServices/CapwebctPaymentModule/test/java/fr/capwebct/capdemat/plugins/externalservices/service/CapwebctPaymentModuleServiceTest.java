package fr.capwebct.capdemat.plugins.externalservices.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.capwebct.capdemat.plugins.externalservices.capwebctpaymentmodule.webservice.client.ICapwebctPaymentModuleClient;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.ExternalServiceTestCase;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.request.IRequestTypeService;
import fr.cg95.cvq.service.request.external.IRequestExternalService;

public class CapwebctPaymentModuleServiceTest extends ExternalServiceTestCase {

    @Resource(name="capwebctPaymentModuleExternalService")
    private IExternalProviderService capwebctPaymentModuleService;
    @Autowired
    private IRequestExternalService requestExternalService;
    @Autowired
    private ICapwebctPaymentModuleClient capwebctPaymentModuleClient;
    
    @Test
    public void testInteractions() throws CvqException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.ADMIN_CONTEXT);

        ExternalServiceBean esb = new ExternalServiceBean();
        esb.setPassword("12345678");
        List<String> requestTypes = new ArrayList<String>();
        requestTypes.add(IRequestTypeService.VO_CARD_REGISTRATION_REQUEST);
        esb.setRequestTypes(requestTypes);
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        lacb.registerExternalService(capwebctPaymentModuleService, esb);
        capwebctPaymentModuleClient.setFake(true);
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        
        CreationBean cb = gimmeAnHomeFolderWithRequest();
        continueWithNewTransaction();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
        
        Request request = requestSearchService.getById(cb.getRequestId(), true);
        List<String> messages = requestExternalService.checkExternalReferential(request);
        Assert.assertEquals(2, messages.size());
        
        requestWorkflowService.updateRequestState(cb.getRequestId(), RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(cb.getRequestId(), RequestState.VALIDATED, null);
        
        continueWithNewTransaction();
        
        Map<String, Object> externalInformations = requestExternalService.loadExternalInformations(request);
        Assert.assertEquals(2, externalInformations.size());

        Map<Date, String> consumptions = 
            requestExternalService.getConsumptions(cb.getRequestId(), new Date(), new Date());
        Assert.assertEquals(2, consumptions.size());

        lacb.unregisterExternalService(capwebctPaymentModuleService);
    }
}
