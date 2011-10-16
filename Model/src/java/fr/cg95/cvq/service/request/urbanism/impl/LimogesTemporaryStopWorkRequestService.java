package fr.cg95.cvq.service.request.urbanism.impl;

import java.util.Arrays;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.urbanism.LimogesTemporaryStopWorkRequest;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.condition.EqualityListChecker;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.impl.RequestService;

public final class LimogesTemporaryStopWorkRequestService extends RequestService {

    @Override
    public void init() {
		LimogesTemporaryStopWorkRequest.conditions.put("requesterType",
                new EqualityListChecker(
					Arrays.asList("isLandlord=landlord", 
								  "isContractor=contractor", 
								  "isCollectivity=collectivity",
								  "forAll=landlord",
								  "forAll=contractor",
								  "forAll=collectivity",
								  "forContractorCollectivity=contractor",
								  "forContractorCollectivity=collectivity")));
        LimogesTemporaryStopWorkRequest.conditions.put("selectedRequestType", new EqualityChecker("extension"));
        LimogesTemporaryStopWorkRequest.conditions.put("noParking", 
				new EqualityListChecker(
					Arrays.asList("right", "front"))); 
        LimogesTemporaryStopWorkRequest.conditions.put("alternateTraffic", 
				new EqualityListChecker(
					Arrays.asList("direction=info", 
								  "alternate=info", 
								  "alternate=manual", 
								  "alternate=auto")));
        LimogesTemporaryStopWorkRequest.conditions.put("drivingBan", 
				new EqualityListChecker(
					Arrays.asList("deviation=allway", 
								  "deviation=partway",
								  "ban=oneway", 
								  "banBetween=partway"))); 
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof LimogesTemporaryStopWorkRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new LimogesTemporaryStopWorkRequest();
    }
}
