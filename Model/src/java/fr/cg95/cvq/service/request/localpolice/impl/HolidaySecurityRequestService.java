package fr.cg95.cvq.service.request.localpolice.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.localpolice.HolidaySecurityRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.localpolice.IHolidaySecurityRequestService;

public class HolidaySecurityRequestService extends RequestService 
    implements IHolidaySecurityRequestService {

    @Override
    public boolean accept(Request request) {
        return request instanceof HolidaySecurityRequest;
    }

    @Override
    public Request getSkeletonRequest() throws CvqException {
        return new HolidaySecurityRequest();
    }
}
