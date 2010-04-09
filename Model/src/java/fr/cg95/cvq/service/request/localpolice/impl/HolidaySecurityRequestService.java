package fr.cg95.cvq.service.request.localpolice.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.localpolice.HolidaySecurityRequest;
import fr.cg95.cvq.service.request.impl.RequestService;

public class HolidaySecurityRequestService extends RequestService {

    @Override
    public boolean accept(Request request) {
        return request instanceof HolidaySecurityRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new HolidaySecurityRequest();
    }
}
