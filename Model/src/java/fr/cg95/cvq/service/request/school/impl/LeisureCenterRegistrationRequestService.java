package fr.cg95.cvq.service.request.school.impl;

import java.util.HashMap;
import java.util.Map;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.LeisureCenterRegistrationRequest;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.service.request.IRequestSearchService;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.external.IRequestExternalService;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.school.ILeisureCenterRegistrationRequestService;
import fr.cg95.cvq.service.request.school.external.IScholarBusinessProviderService;
import fr.cg95.cvq.service.users.IUserSearchService;

/**
 * Implementation of the leisure center registration request service.
 * 
 * @author vsi@zenexity.com
 */
public class LeisureCenterRegistrationRequestService extends RequestService implements ILeisureCenterRegistrationRequestService {

    private IRequestExternalService requestExternalService;
    private IUserSearchService userSearchService;
    private IRequestSearchService requestSearchService;
   
    @Override
    public void init() {
        LeisureCenterRegistrationRequest.conditions.put("estDerogation", new EqualityChecker("true"));
        LeisureCenterRegistrationRequest.conditions.put("estTransport", new EqualityChecker("true"));
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof LeisureCenterRegistrationRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new LeisureCenterRegistrationRequest();
    }

    @Override
    public Map<String, String> getLeisureCenters(Long requestId, Long childId) throws CvqObjectNotFoundException {
        IExternalProviderService service = requestExternalService.getExternalServiceByRequestType(getLabel());
        Request request = requestSearchService.getById(requestId, false);
        Child child = userSearchService.getChildById(childId);
        if (service instanceof IScholarBusinessProviderService) {
            return ((IScholarBusinessProviderService) service).getLeisureCenters(request, child);
        } else {
            return new HashMap<String,String>();
        }
    }

    @Override
    public Map<String, String> getTransportLines(Long requestId, Long childId) throws CvqObjectNotFoundException {
        IExternalProviderService service = requestExternalService.getExternalServiceByRequestType(getLabel());
        Request request = requestSearchService.getById(requestId, false);
        Child child = userSearchService.getChildById(childId);
        if (service instanceof IScholarBusinessProviderService) {
            return ((IScholarBusinessProviderService) service).getTransportLines(request, child);
        } else {
            return new HashMap<String,String>();
        }
    }

    @Override
    public Map<String, String> getTransportStops(Long requestId, Long childId, String lineId) throws CvqObjectNotFoundException {
        IExternalProviderService service = requestExternalService.getExternalServiceByRequestType(getLabel());
        Request request = requestSearchService.getById(requestId, false);
        Child child = userSearchService.getChildById(childId);
        if (service instanceof IScholarBusinessProviderService) {
            return ((IScholarBusinessProviderService) service).getTransportStops(request, child, lineId);
        } else {
            return new HashMap<String,String>();
        }
    }

    public void setRequestExternalService(IRequestExternalService requestExternalService) {
        this.requestExternalService = requestExternalService;
    }


    public void setUserSearchService(IUserSearchService userSearchService) {
        this.userSearchService = userSearchService;
    }

    public void setRequestSearchService(IRequestSearchService requestSearchService) {
        this.requestSearchService = requestSearchService;
    }
}
