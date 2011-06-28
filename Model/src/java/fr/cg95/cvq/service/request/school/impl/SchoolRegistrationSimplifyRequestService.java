package fr.cg95.cvq.service.request.school.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.SchoolRegistrationSimplifyRequest;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;


public class SchoolRegistrationSimplifyRequestService extends RequestService {

    @Override
    public boolean accept(Request request) {
        return request instanceof SchoolRegistrationSimplifyRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new SchoolRegistrationSimplifyRequest();
    }
    
    @Override
    public void init() {        
        SchoolRegistrationSimplifyRequest.conditions.put("existRegistration", new EqualityChecker("true"));
    }

}
