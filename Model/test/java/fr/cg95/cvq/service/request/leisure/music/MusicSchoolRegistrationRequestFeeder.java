package fr.cg95.cvq.service.request.leisure.music;

import fr.cg95.cvq.business.request.leisure.music.MusicSchoolRegistrationRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;

public class MusicSchoolRegistrationRequestFeeder {

    public static void feed(MusicSchoolRegistrationRequest request) {
    }
    
    public static void setSubject(MusicSchoolRegistrationRequest request,
            String subjectPolicy, Adult requester, HomeFolder homeFolder) {
        if (homeFolder != null)
            request.setSubjectId(homeFolder.getIndividuals().iterator().next().getId());
        else
            request.setSubjectId(request.getRequesterId());
    }
}
