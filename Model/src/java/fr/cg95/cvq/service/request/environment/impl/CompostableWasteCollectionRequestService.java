package fr.cg95.cvq.service.request.environment.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.environment.CompostableWasteCollectionRequest;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.impl.RequestService;

public class CompostableWasteCollectionRequestService extends RequestService {

    public boolean accept(Request request) {
        return request instanceof CompostableWasteCollectionRequest;
    }

    public Request getSkeletonRequest() {
        CompostableWasteCollectionRequest request =
            new CompostableWasteCollectionRequest();
        if (SecurityContext.getCurrentEcitizen() != null) {
            request.setCollectionAddress(SecurityContext.getCurrentEcitizen()
                .getHomeFolder().getAdress().clone());
        }
        return request;
    }
}
