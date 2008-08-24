package fr.cg95.cvq.service.request.impl;

import org.w3c.dom.Node;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.exception.CvqException;

/**
 * A default request service that can be used for generic operations on requests.
 *
 * @author bor@zenexity.fr
 */
public class DefaultRequestService extends RequestService {

    public boolean accept(Request request) {
        return false;
    }

    public Long create(Node node) throws CvqException {
        throw new CvqException("Not yet implemented !");
    }

    public Request getSkeletonRequest() throws CvqException {
        return null;
    }
}
