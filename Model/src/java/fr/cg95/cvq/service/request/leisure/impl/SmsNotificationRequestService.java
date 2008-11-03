package fr.cg95.cvq.service.request.leisure.impl;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Node;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.leisure.SmsNotificationRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.leisure.ISmsNotificationRequestService;
import fr.cg95.cvq.xml.request.leisure.SmsNotificationRequestDocument;


/**
 * Implementation of the sms notification request service.
 * 
 * @author Rafik Djedjig (rdj@zenexity.fr)
 */
public class SmsNotificationRequestService extends RequestService 
    implements ISmsNotificationRequestService {

    static Logger logger = Logger.getLogger(SmsNotificationRequestService.class);

    public Long create(Node node) throws CvqException {
        SmsNotificationRequestDocument requestDocument = null;
        try {
            requestDocument = SmsNotificationRequestDocument.Factory.parse(node);
        } catch (XmlException xe) {
            logger.error("create() Error while parsing received data");
            xe.printStackTrace();
        }

        SmsNotificationRequest request = 
            SmsNotificationRequest.xmlToModel(requestDocument);
        HomeFolder homeFolder = super.createOrSynchronizeHomeFolder(request);

        // Gets properties inherited from homefolder
        String mobilePhone = ((Adult)request.getSubject()).getMobilePhone();
        
        initializeCommonAttributes(request);
        
        // Set properties inherited from homefolder, after initializeCommonAttribute !
        ((Adult)request.getSubject()).setMobilePhone(mobilePhone);
        
        Long requestId = super.create(request);
        if (homeFolder != null) {
            homeFolder.setBoundToRequest(Boolean.valueOf(true));
            homeFolder.setOriginRequestId(requestId);
        }
        
        return requestId;
    }
    
    // Call just after the 'sendResuest' (externalService) method.
    // Manage the binding between the request's subject and the CleverSms's contact.
    public void onExternalServiceSendRequest(Request request, String sendRequestResult) throws CvqException {
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
