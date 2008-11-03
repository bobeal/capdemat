package fr.capwebct.capdemat.plugins.externalservices.clever.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ConfigurableApplicationContext;

import fr.cg95.cvq.business.request.leisure.SmsNotificationRequest;
import fr.cg95.cvq.business.users.FamilyStatusType;
import fr.cg95.cvq.business.users.LocalReferentialData;
import fr.cg95.cvq.business.users.TitleType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.testtool.BusinessObjectsFactory;
import fr.cg95.cvq.testtool.ServiceTestCase;

/**
 * Unit/integration test for Clever external service.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class CleverServiceTest extends ServiceTestCase {

    private IExternalProviderService externalProviderService;

    protected void onSetUp() throws Exception {
        super.onSetUp();
        ConfigurableApplicationContext cac = getContext(getConfigLocations());
        externalProviderService = (IExternalProviderService) cac.getBean("cleverExternalService");
    }

    protected SmsNotificationRequest gimmeRequest() throws CvqException {

        SmsNotificationRequest request = new SmsNotificationRequest();
        
        address = BusinessObjectsFactory.gimmeAdress("101/103", "bd Mac Donald", "Paris", "75019");
        request.setSubject(BusinessObjectsFactory.gimmeAdult(TitleType.MISTER, "DJEDJIG", "Rafik", address,
                FamilyStatusType.SINGLE));
        
        // Subscription
        request.setSubscription(Boolean.valueOf(true));
        // Interest
        LocalReferentialData lrd = new LocalReferentialData();
        lrd.setName("Interest-1");
        Set<LocalReferentialData> interestsSet = new HashSet<LocalReferentialData>();
        interestsSet.add(lrd);
        request.setInterests(interestsSet);
        // CleverSmsContact ID

        return request;
    }

    public void testSendRequest() throws CvqException {
        SmsNotificationRequest snr = gimmeRequest();
        
        // Create Clever SMS Contact
        String sendRequestResult = externalProviderService.sendRequest(snr);
        assertNotNull(sendRequestResult);
        
        // Update Clever SMS Contact
        snr.setCleverSmsContactId(sendRequestResult);
        String sendRequestResult2 = externalProviderService.sendRequest(snr);
        assertNotNull(sendRequestResult2);
        
        // Remove Clever SMS Contact
        snr.setSubscription(false);
        String sendRequestResult3 = externalProviderService.sendRequest(snr);
        assertNull(sendRequestResult3);
        
    }

}
