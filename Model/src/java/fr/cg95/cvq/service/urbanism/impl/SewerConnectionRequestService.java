package fr.cg95.cvq.service.urbanism.impl;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Node;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.urbanism.SewerConnectionRequest;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.urbanism.ISewerConnectionRequestService;
import fr.cg95.cvq.xml.urbanism.SewerConnectionRequestDocument;

/**
 * Implementation of the sewer connection request service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class SewerConnectionRequestService
    extends RequestService implements ISewerConnectionRequestService {

    static Logger logger = Logger.getLogger(SewerConnectionRequestService.class);

    public Long create(final Node scrNode) throws CvqException {

        SewerConnectionRequestDocument scrDocument = null;
        try {
            scrDocument = SewerConnectionRequestDocument.Factory.parse(scrNode);
        } catch (XmlException xe) {
            logger.error("create() Error while parsing received data");
            xe.printStackTrace();
        }

        SewerConnectionRequest scr = SewerConnectionRequest.xmlToModel(scrDocument);
        HomeFolder homeFolder = super.createOrSynchronizeHomeFolder(scr);

        initializeCommonAttributes(scr);

        Long requestId = super.create(scr);
        if (homeFolder != null) {
            homeFolder.setBoundToRequest(Boolean.valueOf(true));
            homeFolder.setOriginRequestId(requestId);
        }

        return requestId;
    }

    public boolean accept(Request request) {
        return request instanceof SewerConnectionRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new SewerConnectionRequest();
    }
}
