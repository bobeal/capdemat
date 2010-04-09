package fr.cg95.cvq.service.request.military.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.military.MilitaryCensusRequest;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;

public class MilitaryCensusRequestService extends RequestService {

    @Override
    public void init() {
        MilitaryCensusRequest.conditions.put("prefectPupil", new EqualityChecker("true"));
    }

    @Override
    public boolean accept(Request request) {
        return (request instanceof MilitaryCensusRequest);
    }

    @Override
    public Request getSkeletonRequest() {
        return new MilitaryCensusRequest();
    }
}
