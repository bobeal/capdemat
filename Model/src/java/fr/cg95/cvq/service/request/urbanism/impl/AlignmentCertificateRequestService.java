package fr.cg95.cvq.service.request.urbanism.impl;

import fr.cg95.cvq.business.CapDematEvent;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.urbanism.AlignmentCertificateRequest;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;

/**
 * Implementation of the alignment certificate request service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class AlignmentCertificateRequestService extends RequestService {

    @Override
    public void init() {
        AlignmentCertificateRequest.conditions.put("requesterQuality", new EqualityChecker("Tenant"));
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof AlignmentCertificateRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new AlignmentCertificateRequest();
    }

    @Override
    public void onApplicationEvent(CapDematEvent e) {}
}
