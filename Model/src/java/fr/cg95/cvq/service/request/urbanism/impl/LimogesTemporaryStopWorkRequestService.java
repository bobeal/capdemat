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
					Arrays.asList("isLandlord=LANDLORD", 
								  "isContractor=CONTRACTOR", 
								  "isCollectivity=COLLECTIVITY",
								  "forAll=LANDLORD",
								  "forAll=CONTRACTOR",
								  "forAll=COLLECTIVITY",
								  "forContractorCollectivity=CONTRACTOR",
								  "forContractorCollectivity=COLLECTIVITY")));
        LimogesTemporaryStopWorkRequest.conditions.put("selectedRequestType", new EqualityChecker("EXTENSION"));
        LimogesTemporaryStopWorkRequest.conditions.put("noParking", 
				new EqualityListChecker(
					Arrays.asList("RIGHT", "FRONT"))); 
        LimogesTemporaryStopWorkRequest.conditions.put("alternateTraffic", 
				new EqualityListChecker(
					Arrays.asList("direction=INFO", 
								  "alternate=INFO", 
								  "alternate=MANUAL", 
								  "alternate=AUTO")));
        LimogesTemporaryStopWorkRequest.conditions.put("drivingBan", 
				new EqualityListChecker(
					Arrays.asList("deviation=ALLWAY", 
								  "deviation=PARTWAY",
								  "ban=ONEWAY", 
								  "banBetween=PARTWAY"))); 
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
