package fr.cg95.cvq.service.request.school.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.SchoolTransportRegistrationRequest;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.condition.EqualityListChecker;
import fr.cg95.cvq.service.request.external.IRequestExternalService;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.school.ISchoolTransportRegistrationRequestService;
import fr.cg95.cvq.service.request.school.external.IScholarBusinessProviderService;
import fr.cg95.cvq.service.users.IUserSearchService;

public class SchoolTransportRegistrationRequestService extends RequestService implements ISchoolTransportRegistrationRequestService {

    private IRequestExternalService requestExternalService;
    private IUserSearchService userSearchService;

    @Override
    public void init() {
        SchoolTransportRegistrationRequest.conditions.put("estMaternelleElementaireAutorisations", new EqualityChecker("true"));
        SchoolTransportRegistrationRequest.conditions.put("autorisation",
                new EqualityListChecker(Arrays.asList("autoriseTiers=AvecTiers", "autoriseFrereOuSoeur=AvecFrereSoeur")));
    }

    @Override
    public boolean accept(final Request request) {
        return request instanceof SchoolTransportRegistrationRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new SchoolTransportRegistrationRequest();
    }

    @Override
    public Map<String, String> transportLines(Long childId) throws CvqObjectNotFoundException {
        IExternalProviderService service = requestExternalService.getExternalServiceByRequestType(getLabel());
        if (service instanceof IScholarBusinessProviderService) {
            return ((IScholarBusinessProviderService) service).getTransportLines(userSearchService.getChildById(childId));
        } else {
            return new HashMap<String,String>();
        }
    }

    @Override
    public Map<String, String> stops(Long childId, String lineId) throws CvqObjectNotFoundException {
        IExternalProviderService service = requestExternalService.getExternalServiceByRequestType(getLabel());
        if (service instanceof IScholarBusinessProviderService) {
            return ((IScholarBusinessProviderService) service).getTransportStops(userSearchService.getChildById(childId), lineId);
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
}
