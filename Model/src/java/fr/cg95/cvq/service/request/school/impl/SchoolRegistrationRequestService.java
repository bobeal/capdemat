package fr.cg95.cvq.service.request.school.impl;

import fr.cg95.cvq.business.authority.SectionType;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.SchoolRegistrationRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqInvalidTransitionException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.school.ISchoolRegistrationRequestService;

/**
 * Implementation of the school registration request service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class SchoolRegistrationRequestService
    extends RequestService implements ISchoolRegistrationRequestService {

    public void validate(final Long id)
        throws CvqException, CvqInvalidTransitionException, CvqObjectNotFoundException {

        // check school association has been done before validating request
        SchoolRegistrationRequest srr = 
            (SchoolRegistrationRequest) requestDAO.findById(SchoolRegistrationRequest.class, id);
        if (srr.getSchool() == null)
            throw new CvqModelException("School registration is not associated to a school");
        if (srr.getSection().equals(SectionType.UNKNOWN))
            throw new CvqModelException("School registration is not associated to a school section");

        // validate the request
        super.validate(id);
    }

    public boolean accept(final Request request) {
        return request instanceof SchoolRegistrationRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new SchoolRegistrationRequest();
    }
}
