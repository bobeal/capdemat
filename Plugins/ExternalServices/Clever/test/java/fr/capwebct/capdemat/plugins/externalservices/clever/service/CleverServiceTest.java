package fr.capwebct.capdemat.plugins.externalservices.clever.service;

import java.util.ArrayList;
import java.util.List;

import fr.cg95.cvq.business.request.LocalReferentialData;
import fr.cg95.cvq.business.request.leisure.SmsNotificationRequest;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.IRequestExportService;
import fr.cg95.cvq.service.request.RequestTestCase;

/**
 * Unit/integration test for Clever external service.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class CleverServiceTest extends RequestTestCase {

    protected IExternalProviderService externalProviderService;
    protected IRequestExportService requestExportService;

    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
    }

    protected SmsNotificationRequest gimmeRequest() throws CvqException {

        SecurityContext.setCurrentAgent(this.agentNameWithCategoriesRoles);
        SmsNotificationRequest request = new SmsNotificationRequest();
        request.setRequestType(requestTypeService.getRequestTypeByLabel("Sms Notification"));
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
        String sendRequestResult = 
            externalProviderService.sendRequest(requestExportService.fillRequestXml(snr));
        assertNotNull(sendRequestResult);
        
        // Update Clever SMS Contact
        snr.setCleverSmsContactId(sendRequestResult);
        sendRequestResult = 
            externalProviderService.sendRequest(requestExportService.fillRequestXml(snr));
        assertNotNull(sendRequestResult);
        
        // Remove Clever SMS Contact
        snr.setSubscription(false);
        sendRequestResult = 
            externalProviderService.sendRequest(requestExportService.fillRequestXml(snr));
        assertNull(sendRequestResult);
    }

    public void setExternalProviderService(IExternalProviderService externalProviderService) {
        this.externalProviderService = externalProviderService;
    }

    public void setRequestExportService(IRequestExportService requestExportService) {
        this.requestExportService = requestExportService;
    }
}
