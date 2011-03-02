package fr.cg95.cvq.service.request.school.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.RenewalPerischoolActivitiesRequest;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;

public class RenewalPerischoolActivitiesRequestService extends RequestService {

    @Override
    public void init() {
        RenewalPerischoolActivitiesRequest.conditions.put("estRestauration", new EqualityChecker("true"));
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof RenewalPerischoolActivitiesRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new RenewalPerischoolActivitiesRequest();
    }

}
