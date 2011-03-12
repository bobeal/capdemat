package fr.cg95.cvq.service.request.school.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.HolidayCampRegistrationRequest;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.service.request.external.IRequestExternalService;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.school.IHolidayCampRegistrationRequestService;
import fr.cg95.cvq.service.request.school.external.IScholarBusinessProviderService;
import fr.cg95.cvq.service.users.IUserSearchService;

public final class HolidayCampRegistrationRequestService extends RequestService implements IHolidayCampRegistrationRequestService {

    @Autowired
    private IRequestExternalService requestExternalService;
    @Autowired
    private IUserSearchService userSearchService;

    @Override
    public boolean accept(Request request) {
        return request instanceof HolidayCampRegistrationRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new HolidayCampRegistrationRequest();
    }

    @Override
    public Map<String, String> getHolidayCamps(Long childId) throws CvqObjectNotFoundException {
        IExternalProviderService service = requestExternalService.getExternalServiceByRequestType(getLabel());
        if (service instanceof IScholarBusinessProviderService) {
            return ((IScholarBusinessProviderService) service).getHolidayCamps(userSearchService.getChildById(childId));
        } else {
            return new HashMap<String,String>();
        }
    }
}
