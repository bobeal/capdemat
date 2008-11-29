package fr.cg95.cvq.service.request.environment.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.environment.CompostableWasteCollectionRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.environment.ICompostableWasteCollectionRequestService;
import fr.cg95.cvq.service.request.impl.RequestService;

public class CompostableWasteCollectionRequestService extends RequestService 
    implements ICompostableWasteCollectionRequestService {

    public boolean accept(Request request) {
        return request instanceof CompostableWasteCollectionRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new CompostableWasteCollectionRequest();
    }
}
