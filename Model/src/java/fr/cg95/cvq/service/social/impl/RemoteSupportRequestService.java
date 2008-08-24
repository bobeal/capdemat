package fr.cg95.cvq.service.social.impl;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Node;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.social.RemoteSupportRequest;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.social.IRemoteSupportRequestService;
import fr.cg95.cvq.xml.social.RemoteSupportRequestDocument;


/**
 * Implementation of the remote support request service.
 * 
 * @author Rafik Djedjig (rdj@zenexity.fr)
 */
public class RemoteSupportRequestService extends RequestService 
    implements IRemoteSupportRequestService {
    
    static Logger logger = Logger.getLogger(RemoteSupportRequestService.class);

    public Long create(Node node) throws CvqException {
        RemoteSupportRequestDocument requestDocument = null;
        try {
            requestDocument = RemoteSupportRequestDocument.Factory.parse(node);
        } catch (XmlException xe) {
            logger.error("create() Error while parsing received data");
            xe.printStackTrace();
        }

        RemoteSupportRequest request = 
            RemoteSupportRequest.xmlToModel(requestDocument);
        HomeFolder homeFolder = super.createOrSynchronizeHomeFolder(request);

        initializeCommonAttributes(request);

        Long requestId = super.create(request);
        if (homeFolder != null) {
            homeFolder.setBoundToRequest(Boolean.valueOf(true));
            homeFolder.setOriginRequestId(requestId);
        }
        
        return requestId;
    }

    public boolean accept(Request request) {
        return request instanceof RemoteSupportRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new RemoteSupportRequest();
    }
       
}
