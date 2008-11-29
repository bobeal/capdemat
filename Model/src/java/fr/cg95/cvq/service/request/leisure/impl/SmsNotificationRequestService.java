package fr.cg95.cvq.service.request.leisure.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.leisure.SmsNotificationRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.leisure.ISmsNotificationRequestService;


/**
 * Implementation of the sms notification request service.
 * 
 * @author Rafik Djedjig (rdj@zenexity.fr)
 */
public class SmsNotificationRequestService extends RequestService 
    implements ISmsNotificationRequestService {

    public Long create(Request request)
        throws CvqException, CvqObjectNotFoundException {
        
        // TODO RDJ : not sure of business logic here
        
        // get properties inherited from home folder
        Long subjectId = request.getSubjectId();
        Adult subject = (Adult) individualService.getById(subjectId);
        String mobilePhone = subject.getMobilePhone();

        performBusinessChecks(request, SecurityContext.getCurrentEcitizen(), null);
    
        // set properties inherited from home folder, after initializeCommonAttribute !
        subject.setMobilePhone(mobilePhone);

        return finalizeAndPersist(request);
    }

    // Call just after the 'sendRequest' (externalService) method.
    // Manage the binding between the request's subject and the CleverSms's contact.
    public void onExternalServiceSendRequest(Request request, String sendRequestResult)
        throws CvqException {
        
        SmsNotificationRequest snr = (SmsNotificationRequest)request;
        // Bind Clever SMS contact
        if (sendRequestResult != null)
            snr.setCleverSmsContactId(sendRequestResult);
        // Unbind Clever SMS contact
        else if (!snr.getSubscription())
            snr.setCleverSmsContactId(null);
        super.modify(snr);
    }

    public boolean accept(Request request) {
        return request instanceof SmsNotificationRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new SmsNotificationRequest();
    }
}
