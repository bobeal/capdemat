package fr.cg95.cvq.service.request.school.impl;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.PerischoolActivityRegistrationRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqInvalidTransitionException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.school.IPerischoolActivityRegistrationRequestService;

/**
 * Implementation of the perischool activity registration request service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class PerischoolActivityRegistrationRequestService
    extends RequestService implements IPerischoolActivityRegistrationRequestService {

    private static Logger logger =
        Logger.getLogger(PerischoolActivityRegistrationRequestService.class);

    public void validate(final Request request) 
        throws CvqException, CvqInvalidTransitionException, CvqObjectNotFoundException {
    
        if (!(request instanceof PerischoolActivityRegistrationRequest)) { 
            super.validate(request);
            return;
        }
    
        PerischoolActivityRegistrationRequest parr = (PerischoolActivityRegistrationRequest) request;
    
        // ensure school information has been filled
        if (parr.getSchool() == null) {
            logger.error("validate() registration has not been associated to a school !");
            throw new CvqModelException("request.perischool_activity_registration.school_required");
        }
    
        super.validate(parr, true); 
    }

   public boolean accept(final Request request) {
        return request instanceof PerischoolActivityRegistrationRequest;
    }

    public String getConsumptionsField()
        throws CvqException {
        return "PerischoolActivity";
    }

    public Request getSkeletonRequest() throws CvqException {
        return new PerischoolActivityRegistrationRequest();
    }
}
