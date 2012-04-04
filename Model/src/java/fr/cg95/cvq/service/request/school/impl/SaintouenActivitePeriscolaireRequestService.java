package fr.cg95.cvq.service.request.school.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.SaintouenActivitePeriscolaireRequest;
import fr.cg95.cvq.service.request.impl.RequestService;


public class SaintouenActivitePeriscolaireRequestService extends RequestService {

    @Override
    public boolean accept(Request request) {
        return request instanceof SaintouenActivitePeriscolaireRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new SaintouenActivitePeriscolaireRequest();
    }

}