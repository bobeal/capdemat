package fr.cg95.cvq.service.civil.impl;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Node;

import fr.cg95.cvq.business.civil.PersonalDetailsRequest;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.civil.IPersonalDetailsRequestService;
import fr.cg95.cvq.service.users.impl.RequestService;
import fr.cg95.cvq.xml.civil.PersonalDetailsRequestDocument;


/**
 * Implementation of the personal details request service.
 * 
 * @author bor@zenexity.fr
 */
public final class PersonalDetailsRequestService extends RequestService 
    implements IPersonalDetailsRequestService {

    static Logger logger = Logger.getLogger(PersonalDetailsRequestService.class);

    public Long create(final Node pdrNode) throws CvqException {

        PersonalDetailsRequestDocument pdrDocument = null;
        try {
            pdrDocument = PersonalDetailsRequestDocument.Factory.parse(pdrNode);
        } catch (XmlException xe) {
            logger.error("create() Error while parsing received date");
            xe.printStackTrace();
        }

        PersonalDetailsRequest pdr = PersonalDetailsRequest.xmlToModel(pdrDocument);
        HomeFolder homeFolder = super.createOrSynchronizeHomeFolder(pdr);

        initializeCommonAttributes(pdr);

        Long requestId = super.create(pdr);
        if (homeFolder != null) {
            homeFolder.setBoundToRequest(Boolean.valueOf(true));
            homeFolder.setOriginRequestId(requestId);
        }

        return requestId;
    }

    public boolean accept(Request request) {
        return request instanceof PersonalDetailsRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new PersonalDetailsRequest();
    }
}
