package fr.cg95.cvq.service.request.school.impl;

import java.util.Arrays;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.AutorisationType;
import fr.cg95.cvq.business.request.school.SchoolTransportRegistrationRequest;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.condition.EqualityListChecker;
import fr.cg95.cvq.service.request.impl.RequestService;

public class SchoolTransportRegistrationRequestService extends RequestService{

    @Override
    public void init() {
        SchoolTransportRegistrationRequest.conditions.put("estMaternelleElementaireAutorisations", new EqualityChecker("true"));
        SchoolTransportRegistrationRequest.conditions.put("autorisation", new EqualityListChecker(Arrays.asList(
            "autoriseTiers=" + AutorisationType.AVEC_TIERS.name(),
            "autoriseFrereOuSoeur=" + AutorisationType.AVEC_FRERE_SOEUR)));
    }

    @Override
    public boolean accept(final Request request) {
        return request instanceof SchoolTransportRegistrationRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new SchoolTransportRegistrationRequest();
    }

}
