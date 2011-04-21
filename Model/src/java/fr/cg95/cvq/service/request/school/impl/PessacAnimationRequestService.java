package fr.cg95.cvq.service.request.school.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.PessacAnimationRequest;
import fr.cg95.cvq.service.request.impl.RequestService;

public class PessacAnimationRequestService extends RequestService {

    @Override
    public boolean accept(final Request request) {
        return request instanceof PessacAnimationRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new PessacAnimationRequest();
    }
}
