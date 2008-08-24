package fr.cg95.cvq.service.civil.impl;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Node;

import fr.cg95.cvq.business.civil.BirthDetailsRequest;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.civil.IBirthDetailsRequestService;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.xml.civil.BirthDetailsRequestDocument;

/**
 * Implementation of the birth details request service.
 * 
 * @author sanjay.goojrah@businessdecision.com
 */
public final class BirthDetailsRequestService 
    extends RequestService implements IBirthDetailsRequestService {
    
    static Logger logger = Logger.getLogger(BirthDetailsRequestService.class);

    public Long create(final Node pdrNode) throws CvqException {

        BirthDetailsRequestDocument bdrDocument = null;
        try {
            bdrDocument = BirthDetailsRequestDocument.Factory.parse(pdrNode);
        } catch (XmlException xe) {
            logger.error("create() Error while parsing received date");
            xe.printStackTrace();
        }

        BirthDetailsRequest bdr = BirthDetailsRequest.xmlToModel(bdrDocument);
        HomeFolder homeFolder = super.createOrSynchronizeHomeFolder(bdr);

        initializeCommonAttributes(bdr);

        Long requestId = super.create(bdr);
        if (homeFolder != null) {
            homeFolder.setBoundToRequest(Boolean.valueOf(true));
            homeFolder.setOriginRequestId(requestId);
        }

        return requestId;
    }

    public boolean accept(Request request) {
        return request instanceof BirthDetailsRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new BirthDetailsRequest();
    }
}
