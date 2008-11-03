package fr.cg95.cvq.service.request.election.impl;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Node;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.election.ElectoralRollRegistrationRequest;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.election.IElectoralRollRegistrationRequestService;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.xml.request.election.ElectoralRollRegistrationRequestDocument;

/**
 * Implementation of the electoral roll registration request service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class ElectoralRollRegistrationRequestService
    extends RequestService implements IElectoralRollRegistrationRequestService {

    static Logger logger = Logger.getLogger(ElectoralRollRegistrationRequestService.class);

    public Long create(final Node acrNode) throws CvqException {

        ElectoralRollRegistrationRequestDocument errrDocument = null;
        try {
            errrDocument = ElectoralRollRegistrationRequestDocument.Factory.parse(acrNode);
        } catch (XmlException xe) {
            logger.error("create() Error while parsing received data");
            xe.printStackTrace();
        }

        ElectoralRollRegistrationRequest errr = ElectoralRollRegistrationRequest.xmlToModel(errrDocument);
        HomeFolder homeFolder = super.createOrSynchronizeHomeFolder(errr);

        initializeCommonAttributes(errr);

        Long requestId = super.create(errr);
        if (homeFolder != null) {
            homeFolder.setBoundToRequest(Boolean.valueOf(true));
            homeFolder.setOriginRequestId(requestId);
        }
        
        return requestId;
    }

    public boolean accept(Request request) {
        return request instanceof ElectoralRollRegistrationRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new ElectoralRollRegistrationRequest();
    }
}
