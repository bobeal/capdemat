package fr.cg95.cvq.service.request.urbanism.impl;

import java.util.Arrays;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.urbanism.LimogesParkingSpaceReservationRequest;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.condition.EqualityListChecker;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.impl.RequestService;

public final class LimogesParkingSpaceReservationRequestService extends RequestService {

    @Override
    public void init() {
		LimogesParkingSpaceReservationRequest.conditions.put("requesterType",
                new EqualityListChecker(
					Arrays.asList("isLandlord=landlord", 
								  "isContractor=contractor",
								  "forAll=landlord",
								  "forAll=contractor")));
        LimogesParkingSpaceReservationRequest.conditions.put("footWay", new EqualityChecker("true"));
		LimogesParkingSpaceReservationRequest.conditions.put("requesterFirstAddressKind", 
				new EqualityListChecker(
					Arrays.asList("current","future")));
		LimogesParkingSpaceReservationRequest.conditions.put("requesterOtherAddressKind", 
				new EqualityListChecker(
					Arrays.asList("current","future")));
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof LimogesParkingSpaceReservationRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new LimogesParkingSpaceReservationRequest();
    }
}
