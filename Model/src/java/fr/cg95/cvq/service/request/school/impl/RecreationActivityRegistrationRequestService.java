package fr.cg95.cvq.service.request.school.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.RecreationActivityRegistrationRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqInvalidTransitionException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.school.IRecreationActivityRegistrationRequestService;

/**
 * Implementation of the recreation activity registration request service.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class RecreationActivityRegistrationRequestService extends RequestService
		implements IRecreationActivityRegistrationRequestService {

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
