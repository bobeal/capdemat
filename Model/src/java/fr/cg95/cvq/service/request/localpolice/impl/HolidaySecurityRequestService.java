package fr.cg95.cvq.service.request.localpolice.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.localpolice.HolidaySecurityRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.localpolice.IHolidaySecurityRequestService;

public class HolidaySecurityRequestService extends RequestService 
    implements IHolidaySecurityRequestService {

    public Long create(Request request)
        throws CvqException, CvqObjectNotFoundException {

        Long subjectId = request.getSubjectId();
        Adult adult = individualService.getAdultById(subjectId);

        performBusinessChecks(request, SecurityContext.getCurrentEcitizen(), null);

        Adult adult2 = individualService.getAdultById(subjectId);
        adult2.setMobilePhone(adult.getMobilePhone());
        adult2.setEmail(adult.getEmail());

        return finalizeAndPersist(request);
    }

    public boolean accept(Request request) {
        return request instanceof HolidaySecurityRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new HolidaySecurityRequest();
    }
}
