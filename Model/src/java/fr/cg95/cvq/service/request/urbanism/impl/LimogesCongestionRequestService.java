package fr.cg95.cvq.service.request.urbanism.impl;

import java.util.Arrays;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.urbanism.LimogesCongestionRequest;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.condition.EqualityListChecker;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.exception.CvqException;

public final class LimogesCongestionRequestService extends RequestService {

    @Override
    public void init() {
        LimogesCongestionRequest.conditions.put("requesterType",
                new EqualityListChecker(
                    Arrays.asList("isLandlord=LANDLORD",
                                  "isContractor=CONTRACTOR",
                                  "isCollectivity=COLLECTIVITY",
                                  "forAll=LANDLORD",
                                  "forAll=CONTRACTOR",
                                  "forAll=COLLECTIVITY",
                                  "forContractorCollectivity=CONTRACTOR",
                                  "forContractorCollectivity=COLLECTIVITY")));
        LimogesCongestionRequest.conditions.put("selectedRequestType", new EqualityChecker("EXTENSION"));
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof LimogesCongestionRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new LimogesCongestionRequest();
    }
}
