package fr.cg95.cvq.service.request.school.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.GlobalSchoolRegistrationRequest;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;

public final class GlobalSchoolRegistrationRequestService extends RequestService {

    @Override
    public void init() {
        GlobalSchoolRegistrationRequest.conditions.put("estDerogation", new EqualityChecker("true"));
    }

    @Override
    public boolean accept(final Request request) {
        return request instanceof GlobalSchoolRegistrationRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new GlobalSchoolRegistrationRequest();
    }
}
