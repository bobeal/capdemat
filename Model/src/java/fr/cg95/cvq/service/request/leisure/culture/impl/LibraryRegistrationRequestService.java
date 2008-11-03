package fr.cg95.cvq.service.request.leisure.culture.impl;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Node;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.leisure.culture.LibraryRegistrationRequest;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.leisure.culture.ILibraryRegistrationRequestService;
import fr.cg95.cvq.xml.request.leisure.culture.LibraryRegistrationRequestDocument;

/**
 * Implementation of the library registration request service.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class LibraryRegistrationRequestService extends RequestService 
    implements ILibraryRegistrationRequestService {

    static Logger logger = Logger.getLogger(LibraryRegistrationRequestService.class);

    public Long create(Node node) throws CvqException {

        LibraryRegistrationRequestDocument requestDocument = null;
        try {
            requestDocument = LibraryRegistrationRequestDocument.Factory.parse(node);
        } catch (XmlException xe) {
            logger.error("create() Error while parsing received data");
            xe.printStackTrace();
        }

        LibraryRegistrationRequest request = LibraryRegistrationRequest.xmlToModel(requestDocument);
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
        return request instanceof LibraryRegistrationRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new LibraryRegistrationRequest();
    }
}
