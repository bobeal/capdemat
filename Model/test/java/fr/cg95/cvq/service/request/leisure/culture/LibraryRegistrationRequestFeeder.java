package fr.cg95.cvq.service.request.leisure.culture;

import fr.cg95.cvq.business.request.leisure.culture.LibraryRegistrationRequest;
import fr.cg95.cvq.business.users.HomeFolder;

public class LibraryRegistrationRequestFeeder {

    public static void feed(LibraryRegistrationRequest request) {
    }
    
    public static void setSubject(LibraryRegistrationRequest request,
            HomeFolder homeFolder) {
        if (homeFolder != null)
            request.setSubject(homeFolder.getIndividuals().iterator().next());
        else
            request.setSubject(request.getRequester());
    }
}
