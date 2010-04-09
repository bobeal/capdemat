package fr.cg95.cvq.service.request.environment.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.environment.BulkyWasteCollectionRequest;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.impl.RequestService;

public class BulkyWasteCollectionRequestService extends RequestService {

    @Override
    public boolean accept(Request request) {
        return request instanceof BulkyWasteCollectionRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        BulkyWasteCollectionRequest request = new BulkyWasteCollectionRequest();
        if (SecurityContext.getCurrentEcitizen() != null) {
            request.setCollectionAddress(SecurityContext.getCurrentEcitizen()
                .getHomeFolder().getAdress().clone());
        }
        return request;
    }

}
