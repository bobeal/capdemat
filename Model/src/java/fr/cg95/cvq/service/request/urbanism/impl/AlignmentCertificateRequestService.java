package fr.cg95.cvq.service.request.urbanism.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.urbanism.AlignmentCertificateRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.urbanism.IAlignmentCertificateRequestService;

/**
 * Implementation of the alignment certificate request service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class AlignmentCertificateRequestService
    extends RequestService implements IAlignmentCertificateRequestService {

    public boolean accept(Request request) {
        return request instanceof AlignmentCertificateRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new AlignmentCertificateRequest();
    }
}
