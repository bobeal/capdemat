package fr.cg95.cvq.service.request.school.impl;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Node;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.RecreationActivityRegistrationRequest;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqInvalidTransitionException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.school.IRecreationActivityRegistrationRequestService;
import fr.cg95.cvq.xml.request.school.RecreationActivityRegistrationRequestDocument;

/**
 * Implementation of the recreation activity registration request service.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class RecreationActivityRegistrationRequestService extends RequestService
		implements IRecreationActivityRegistrationRequestService {

	private static Logger logger = 
        Logger.getLogger(RecreationActivityRegistrationRequestService.class);

    public Long create(Node node) throws CvqException {

        RecreationActivityRegistrationRequestDocument requestDocument = null;
        try {
            requestDocument = RecreationActivityRegistrationRequestDocument.Factory.parse(node);
        } catch (XmlException xe) {
            logger.error("create() Error while parsing received data");
            xe.printStackTrace();
        }

        RecreationActivityRegistrationRequest request = 
            RecreationActivityRegistrationRequest.xmlToModel(requestDocument);
        HomeFolder homeFolder = super.createOrSynchronizeHomeFolder(request);

        initializeCommonAttributes(request);

        Long requestId = super.create(request);
        if (homeFolder != null) {
            homeFolder.setBoundToRequest(Boolean.valueOf(true));
            homeFolder.setOriginRequestId(requestId);
        }
        
        return requestId;
    }

    public void validate(final Request request)
        throws CvqException, CvqInvalidTransitionException, CvqObjectNotFoundException {

        // check recreation center association has been done before validating request
        RecreationActivityRegistrationRequest rarr = (RecreationActivityRegistrationRequest) request;
        if (rarr.getRecreationCenter() == null)
            throw new CvqModelException("Recreation activity registration is not associated " 
                    + "to a recreation center");

        // validate the request
        super.validate(request);
    }

	public String getConsumptionsField() throws CvqException {
		return "RecreationActivity";
	}

    public boolean accept(final Request request) {
        return request instanceof RecreationActivityRegistrationRequest;
    }

	public Request getSkeletonRequest() throws CvqException {
        return new RecreationActivityRegistrationRequest();
    }
}
