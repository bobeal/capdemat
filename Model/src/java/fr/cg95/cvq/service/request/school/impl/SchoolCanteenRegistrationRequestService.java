package fr.cg95.cvq.service.request.school.impl;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.authority.School;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.SchoolCanteenRegistrationRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqInvalidTransitionException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.school.ISchoolCanteenRegistrationRequestService;

/**
 * Implementation of the school canteen registration request service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class SchoolCanteenRegistrationRequestService 
    extends RequestService implements ISchoolCanteenRegistrationRequestService {

    private static Logger logger = Logger.getLogger(SchoolCanteenRegistrationRequestService.class);

    public Long create(final Request request)
        throws CvqException, CvqObjectNotFoundException {

        performBusinessChecks(request);

        SchoolCanteenRegistrationRequest scrr = (SchoolCanteenRegistrationRequest) request;
        School school = scrr.getSchool();
        if (school != null) {
            School syncSchool = (School) genericDAO.findById(School.class, school.getId());
            scrr.setSchool(syncSchool);
        }
        
        return finalizeAndPersist(scrr);
    }

    public void validate(final Request request) 
        throws CvqException, CvqInvalidTransitionException, CvqObjectNotFoundException {
        
        if (!(request instanceof SchoolCanteenRegistrationRequest)) { 
            super.validate(request);
            return;
        }
        
        SchoolCanteenRegistrationRequest scrr = (SchoolCanteenRegistrationRequest) request;
        
        // ensure school information has been filled
        if (scrr.getSchool() == null) {
            logger.error("validate() registration has not been associated to a school !");
            throw new CvqModelException("request.school_canteen_registration.school_required");
        }
        
        super.validate(scrr, true); 
    }
    
    public boolean accept(final Request request) {
        return request instanceof SchoolCanteenRegistrationRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new SchoolCanteenRegistrationRequest();
    }
}
