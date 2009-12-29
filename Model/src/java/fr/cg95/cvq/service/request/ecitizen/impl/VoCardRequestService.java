package fr.cg95.cvq.service.request.ecitizen.impl;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.ecitizen.VoCardRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.ecitizen.IVoCardRequestService;
import fr.cg95.cvq.service.request.impl.RequestService;

/**
 * Implementation of the account creation request service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class VoCardRequestService
    extends RequestService implements IVoCardRequestService {

    static Logger logger = Logger.getLogger(VoCardRequestService.class);

    @Override
    public void init() {
        super.init();

        conditions.put("title", new EqualityChecker("Madam"));
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof VoCardRequest;
    }

    @Override
    public Request getSkeletonRequest() throws CvqException {
        return new VoCardRequest();
    }
}
