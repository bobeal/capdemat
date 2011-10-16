package fr.cg95.cvq.service.request.school.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.IconitoPsSubscriptionRequest;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;

public final class IconitoPsSubscriptionRequestService extends RequestService {

    @Override
    public boolean accept(Request request) {
        return request instanceof IconitoPsSubscriptionRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new IconitoPsSubscriptionRequest();
    }
}
