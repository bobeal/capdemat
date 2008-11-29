package fr.cg95.cvq.service.request.leisure.culture;

import fr.cg95.cvq.business.request.leisure.culture.LibraryRegistrationRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;

public class LibraryRegistrationRequestFeeder {

    public static void feed(LibraryRegistrationRequest request) {
    }
    
    public static void setSubject(LibraryRegistrationRequest request,
            String subjectPolicy, Adult requester, HomeFolder homeFolder) {
        if (homeFolder != null)
            request.setSubjectId(homeFolder.getIndividuals().iterator().next().getId());
        else
            request.setSubjectId(request.getRequesterId());
    }
}
