package fr.cg95.cvq.service.request.school.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.RecreationActivityRegistrationRequest;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.impl.RequestService;

/**
 * Implementation of the recreation activity registration request service.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class RecreationActivityRegistrationRequestService extends RequestService {

    @Override
    public void onRequestValidated(final Request request)
        throws CvqModelException {

        // check recreation center association has been done before validating request
        RecreationActivityRegistrationRequest rarr = (RecreationActivityRegistrationRequest) request;
        if (rarr.getRecreationCenter() == null)
            throw new CvqModelException("rarr.property.recreationCenter.validationError");
    }

    @Override
    public boolean accept(final Request request) {
        return request instanceof RecreationActivityRegistrationRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        RecreationActivityRegistrationRequest request =
            new RecreationActivityRegistrationRequest();
        if (SecurityContext.getCurrentEcitizen() != null)
            request.setUrgencyPhone(SecurityContext.getCurrentEcitizen().getOfficePhone());
        return request;
    }
}
