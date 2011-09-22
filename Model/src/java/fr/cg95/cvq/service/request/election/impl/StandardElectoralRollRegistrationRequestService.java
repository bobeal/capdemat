package fr.cg95.cvq.service.request.election.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.election.SerrrNationaliteType;
import fr.cg95.cvq.business.request.election.SerrrSituationType;
import fr.cg95.cvq.business.request.election.StandardElectoralRollRegistrationRequest;
import fr.cg95.cvq.business.request.election.SerrrTypeElectionType;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;

public class StandardElectoralRollRegistrationRequestService extends RequestService {

    @Override
    public void init() {
        StandardElectoralRollRegistrationRequest.conditions.put("nationalite",
            new EqualityChecker(SerrrNationaliteType.RESSORTISSANT_U_E.name()));

        StandardElectoralRollRegistrationRequest.conditions.put("typeElection",
                new EqualityChecker(SerrrTypeElectionType.ELECTION_EUROPEENNE.name()));

        StandardElectoralRollRegistrationRequest.conditions.put("situation",
                new EqualityChecker(SerrrSituationType.CHANGEMENT_COMMUNE.name()));
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof StandardElectoralRollRegistrationRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new StandardElectoralRollRegistrationRequest();
    }

}
