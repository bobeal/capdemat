package fr.cg95.cvq.service.request.environment.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.environment.BulkyWasteCollectionRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.environment.IBulkyWasteCollectionRequestService;
import fr.cg95.cvq.service.request.impl.RequestService;

public class BulkyWasteCollectionRequestService extends RequestService 
    implements IBulkyWasteCollectionRequestService {

    @Override
    public boolean accept(Request request) {
        return request instanceof BulkyWasteCollectionRequest;
    }

    @Override
    public Request getSkeletonRequest() throws CvqException {
        return new BulkyWasteCollectionRequest();
    }

}
