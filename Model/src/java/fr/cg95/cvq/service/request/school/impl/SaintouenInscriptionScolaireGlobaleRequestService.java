package fr.cg95.cvq.service.request.school.impl;

import java.util.HashMap;
import java.util.Map;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.SaintouenInscriptionScolaireGlobaleRequest;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.service.request.external.IRequestExternalService;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.school.ISaintouenInscriptionScolaireGlobaleRequestService;
import fr.cg95.cvq.service.request.school.external.IScholarBusinessProviderService;
import fr.cg95.cvq.service.users.IUserSearchService;

public class SaintouenInscriptionScolaireGlobaleRequestService extends RequestService implements ISaintouenInscriptionScolaireGlobaleRequestService{

    private IUserSearchService userSearchService;
    private IRequestExternalService requestExternalService;

    @Override
    public boolean accept(final Request request) {
        return request instanceof SaintouenInscriptionScolaireGlobaleRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new SaintouenInscriptionScolaireGlobaleRequest();
    }

    @Override
    public Map<String, Map<String, String>> getSchools(Long childId) throws CvqObjectNotFoundException {
        IExternalProviderService service = requestExternalService.getExternalServiceByRequestType(getLabel());
        if (service instanceof IScholarBusinessProviderService) {
            return ((IScholarBusinessProviderService) service).getSchools(userSearchService.getChildById(childId));
        } else {
            return new HashMap<String, Map<String,String>>();
        }
    }

    public void setRequestExternalService(IRequestExternalService requestExternalService) {
        this.requestExternalService = requestExternalService;
    }

    public void setUserSearchService(IUserSearchService userSearchService) {
        this.userSearchService = userSearchService;
    }
}
