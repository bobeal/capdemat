package fr.cg95.cvq.service.request.leisure.culture.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.leisure.culture.LibraryRegistrationRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.leisure.culture.ILibraryRegistrationRequestService;

/**
 * Implementation of the library registration request service.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class LibraryRegistrationRequestService extends RequestService 
    implements ILibraryRegistrationRequestService {

    @Override
    public boolean accept(Request request) {
        return request instanceof LibraryRegistrationRequest;
    }

    @Override
    public Request getSkeletonRequest() throws CvqException {
        return new LibraryRegistrationRequest();
    }
}
