package fr.cg95.cvq.service.request.leisure.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.leisure.SmsNotificationRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.leisure.ISmsNotificationRequestService;


/**
 * Implementation of the sms notification request service.
 * 
 * @author Rafik Djedjig (rdj@zenexity.fr)
 */
public class SmsNotificationRequestService extends RequestService 
    implements ISmsNotificationRequestService {

    // Manage the binding between the request's subject and the CleverSms's contact.
    @Override
    public void onExternalServiceSendRequest(Request request, String sendRequestResult)
        throws CvqException {
        
        SmsNotificationRequest snr = (SmsNotificationRequest)request;
        // Bind Clever SMS contact
        if (sendRequestResult != null)
            snr.setCleverSmsContactId(sendRequestResult);
        // Unbind Clever SMS contact
        else if (!snr.getSubscription())
            snr.setCleverSmsContactId(null);
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof SmsNotificationRequest;
    }

    @Override
    public Request getSkeletonRequest() throws CvqException {
        return new SmsNotificationRequest();
    }
}
