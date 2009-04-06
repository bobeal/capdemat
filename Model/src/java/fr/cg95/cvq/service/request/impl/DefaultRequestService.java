package fr.cg95.cvq.service.request.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.exception.CvqException;

/**
 * A default request service that can be used for generic operations on requests.
 *
 * @author bor@zenexity.fr
 */
public class DefaultRequestService extends RequestService {

    @Override
    public boolean accept(Request request) {
        return false;
    }

    @Override
    public Request getSkeletonRequest() throws CvqException {
        return null;
    }
}
