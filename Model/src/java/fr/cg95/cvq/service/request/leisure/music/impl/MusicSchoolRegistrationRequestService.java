package fr.cg95.cvq.service.request.leisure.music.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.leisure.music.MusicSchoolRegistrationRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.leisure.music.IMusicSchoolRegistrationRequestService;

/**
 * Implementation of the music school registration request service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class MusicSchoolRegistrationRequestService
    extends RequestService implements IMusicSchoolRegistrationRequestService {

    public boolean accept(Request request) {
        return request instanceof MusicSchoolRegistrationRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new MusicSchoolRegistrationRequest();
    }
}
