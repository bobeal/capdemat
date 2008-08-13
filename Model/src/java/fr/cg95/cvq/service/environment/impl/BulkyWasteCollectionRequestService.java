package fr.cg95.cvq.service.environment.impl;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Node;

import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.business.environment.BulkyWasteCollectionRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.environment.IBulkyWasteCollectionRequestService;
import fr.cg95.cvq.service.users.impl.RequestService;
import fr.cg95.cvq.xml.environment.BulkyWasteCollectionRequestDocument;

public class BulkyWasteCollectionRequestService extends RequestService implements
        IBulkyWasteCollectionRequestService {

    static Logger logger = Logger.getLogger(BulkyWasteCollectionRequestService.class);

    public Long create(Node node) throws CvqException {
        
        BulkyWasteCollectionRequestDocument requestDocument = null;
        try {
            requestDocument = BulkyWasteCollectionRequestDocument.Factory.parse(node);
        } catch (XmlException xe) {
            logger.error("create() Error while parsing received data");
            xe.printStackTrace();
        }

        BulkyWasteCollectionRequest request = 
            BulkyWasteCollectionRequest.xmlToModel(requestDocument);
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
        return request instanceof BulkyWasteCollectionRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new BulkyWasteCollectionRequest();
    }

}
