package fr.cg95.cvq.service.request.leisure.music;

import fr.cg95.cvq.business.request.leisure.music.MusicSchoolRegistrationRequest;
import fr.cg95.cvq.business.users.HomeFolder;

public class MusicSchoolRegistrationRequestFeeder {

    public static void feed(MusicSchoolRegistrationRequest request) {
    }
    
    public static void setSubject(MusicSchoolRegistrationRequest request,
            HomeFolder homeFolder) {
        if (homeFolder != null)
            request.setSubject(homeFolder.getIndividuals().iterator().next());
        else
            request.setSubject(request.getRequester());
    }
}
