package fr.cg95.cvq.service.request.leisure.culture.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.leisure.culture.LimogesLibraryRegistrationRequest;
import fr.cg95.cvq.service.request.impl.RequestService;

/**
 * Implementation of the library registration request service.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class LimogesLibraryRegistrationRequestService extends RequestService {

    @Override
    public boolean accept(Request request) {
        return request instanceof LimogesLibraryRegistrationRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new LimogesLibraryRegistrationRequest();
    }
}
