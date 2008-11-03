package fr.cg95.cvq.service.request.environment.impl;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Node;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.environment.CompostableWasteCollectionRequest;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.environment.ICompostableWasteCollectionRequestService;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.xml.request.environment.CompostableWasteCollectionRequestDocument;

public class CompostableWasteCollectionRequestService extends RequestService implements
        ICompostableWasteCollectionRequestService {

    static Logger logger = Logger.getLogger(CompostableWasteCollectionRequestService.class);

    public Long create(Node node) throws CvqException {
        
        CompostableWasteCollectionRequestDocument requestDocument = null;
        try {
            requestDocument = CompostableWasteCollectionRequestDocument.Factory.parse(node);
        } catch (XmlException xe) {
            logger.error("create() Error while parsing received data");
            xe.printStackTrace();
        }

        CompostableWasteCollectionRequest request = 
            CompostableWasteCollectionRequest.xmlToModel(requestDocument);
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
        return request instanceof CompostableWasteCollectionRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new CompostableWasteCollectionRequest();
    }

}
