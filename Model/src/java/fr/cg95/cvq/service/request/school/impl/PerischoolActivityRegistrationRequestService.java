package fr.cg95.cvq.service.request.school.impl;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.CapDematEvent;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestEvent;
import fr.cg95.cvq.business.request.school.PerischoolActivityRegistrationRequest;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.impl.RequestService;

/**
 * Implementation of the perischool activity registration request service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class PerischoolActivityRegistrationRequestService extends RequestService {

    private static Logger logger =
        Logger.getLogger(PerischoolActivityRegistrationRequestService.class);

    @Override
    public void onRequestCompleted(final Request request)
        throws CvqModelException {
    
        PerischoolActivityRegistrationRequest parr = (PerischoolActivityRegistrationRequest) request;
    
        // ensure school information has been filled
        if (parr.getSchool() == null) {
            logger.error("validate() registration has not been associated to a school !");
            throw new CvqModelException("parr.property.school.validationError");
        }
    }

    @Override
    public boolean accept(final Request request) {
        return request instanceof PerischoolActivityRegistrationRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        PerischoolActivityRegistrationRequest request =
            new PerischoolActivityRegistrationRequest();
        if (SecurityContext.getCurrentEcitizen() != null)
            request.setUrgencyPhone(SecurityContext.getCurrentEcitizen().getOfficePhone());
        return request;
    }

    @Override
    public void onApplicationEvent(CapDematEvent e) {
        if (e instanceof RequestEvent) {
            RequestEvent event = (RequestEvent)e;
            if (RequestEvent.EVENT_TYPE.REQUEST_CLONED.equals(event.getEvent())
                && accept(event.getRequest())) {
                ((PerischoolActivityRegistrationRequest)event.getRequest()).setSection(null);
            }
        }
    }
}
