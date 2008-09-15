package fr.cg95.cvq.service.social.impl;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Node;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.social.HandicapAllowanceRequest;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.social.IHandicapAllowanceRequestService;
import fr.cg95.cvq.xml.social.HandicapAllowanceRequestDocument;


/**
 * Implementation of the handicap allowance request service.
 * 
 * @author Rafik Djedjig (rdj@zenexity.fr)
 */
public class HandicapAllowanceRequestService extends RequestService 
    implements IHandicapAllowanceRequestService {
    
    static Logger logger = Logger.getLogger(HandicapAllowanceRequestService.class);

    public Long create(Node node) throws CvqException {
        HandicapAllowanceRequestDocument requestDocument = null;
        try {
            requestDocument = HandicapAllowanceRequestDocument.Factory.parse(node);
        } catch (XmlException xe) {
            logger.error("create() Error while parsing received data");
            xe.printStackTrace();
        }

        HandicapAllowanceRequest request = 
            HandicapAllowanceRequest.xmlToModel(requestDocument);
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
        return request instanceof HandicapAllowanceRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new HandicapAllowanceRequest();
    }
       
}
