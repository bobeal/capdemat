package fr.capwebct.capdemat.plugins.externalservices.clever.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;

import fr.cg95.cvq.business.request.LocalReferentialData;
import fr.cg95.cvq.business.request.leisure.SmsNotificationRequest;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.testtool.ServiceTestCase;

/**
 * Unit/integration test for Clever external service.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class CleverServiceTest extends ServiceTestCase {

    private IExternalProviderService externalProviderService;

    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
        ConfigurableApplicationContext cac = getContext(getConfigLocations());
        externalProviderService = (IExternalProviderService) cac.getBean("cleverExternalService");
    }

    protected SmsNotificationRequest gimmeRequest() throws CvqException {

        SecurityContext.setCurrentAgent(this.agentNameWithCategoriesRoles);
        SmsNotificationRequest request = new SmsNotificationRequest();
        request.setRequestType(iRequestTypeService.getRequestTypeByLabel("Sms Notification"));
        CreationBean creationBean = gimmeAnHomeFolder();
        request.setSubjectId(iHomeFolderService.getHomeFolderResponsible(creationBean.getHomeFolderId()).getId());
        request.setHomeFolderId(creationBean.getHomeFolderId());
        // Subscription
        request.setSubscription(Boolean.valueOf(true));
        // Interest
        LocalReferentialData lrd = new LocalReferentialData();
        lrd.setName("Interest-1");
        List<LocalReferentialData> interestsList = new ArrayList<LocalReferentialData>();
        interestsList.add(lrd);
        request.setInterests(interestsList);
        // CleverSmsContact ID

        return request;
    }

    public void testSendRequest() throws CvqException {
        SmsNotificationRequest snr = gimmeRequest();
        
        // Create Clever SMS Contact
        String sendRequestResult = externalProviderService.sendRequest(iRequestService.fillRequestXml(snr));
        assertNotNull(sendRequestResult);
        
        // Update Clever SMS Contact
        snr.setCleverSmsContactId(sendRequestResult);
        String sendRequestResult2 = externalProviderService.sendRequest(iRequestService.fillRequestXml(snr));
        assertNotNull(sendRequestResult2);
        
        // Remove Clever SMS Contact
        snr.setSubscription(false);
        String sendRequestResult3 = externalProviderService.sendRequest(iRequestService.fillRequestXml(snr));
        assertNull(sendRequestResult3);
        
    }

}
