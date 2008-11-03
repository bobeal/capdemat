package fr.cg95.cvq.service.request.civil.impl;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Node;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.civil.MarriageDetailsRequest;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.civil.IMarriageDetailsRequestService;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.xml.request.civil.MarriageDetailsRequestDocument;

/**
 * Implementation of the marriage details request service.
 * 
 * @author sanjay.goojrah@businessdecision.com
 */
public final class MarriageDetailsRequestService extends RequestService 
    implements IMarriageDetailsRequestService {
    
    static Logger logger = Logger.getLogger(MarriageDetailsRequestService.class);

    public Long create(final Node pdrNode) throws CvqException {

        MarriageDetailsRequestDocument mdrDocument = null;
        try {
            mdrDocument = MarriageDetailsRequestDocument.Factory.parse(pdrNode);
        } catch (XmlException xe) {
            logger.error("create() Error while parsing received date");
            xe.printStackTrace();
        }

        MarriageDetailsRequest mdr = MarriageDetailsRequest.xmlToModel(mdrDocument);
        HomeFolder homeFolder = super.createOrSynchronizeHomeFolder(mdr);

        initializeCommonAttributes(mdr);

        Long requestId = super.create(mdr);
        if (homeFolder != null) {
            homeFolder.setBoundToRequest(Boolean.valueOf(true));
            homeFolder.setOriginRequestId(requestId);
        }

        return requestId;
    }

    public boolean accept(Request request) {
        return request instanceof MarriageDetailsRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new MarriageDetailsRequest();
    }
}
