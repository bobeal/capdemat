package fr.cg95.cvq.service.request.leisure.music.impl;

import fr.cg95.cvq.business.CapDematEvent;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.leisure.music.MusicSchoolRegistrationRequest;
import fr.cg95.cvq.service.request.impl.RequestService;

/**
 * Implementation of the music school registration request service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class MusicSchoolRegistrationRequestService extends RequestService {

    @Override
    public boolean accept(Request request) {
        return request instanceof MusicSchoolRegistrationRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new MusicSchoolRegistrationRequest();
    }

    @Override
    public void onApplicationEvent(CapDematEvent e) {}
}
