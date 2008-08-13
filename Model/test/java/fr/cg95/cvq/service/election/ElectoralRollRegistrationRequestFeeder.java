package fr.cg95.cvq.service.election;

import fr.cg95.cvq.business.election.ElectoralRollRegistrationRequest;
import fr.cg95.cvq.business.users.HomeFolder;

public class ElectoralRollRegistrationRequestFeeder {

    public static void feed(ElectoralRollRegistrationRequest request) {
    }
    
    public static void setSubject(ElectoralRollRegistrationRequest request,
            HomeFolder homeFolder) {
        if (homeFolder != null)
            request.setSubject(homeFolder.getIndividuals().iterator().next());
        else
            request.setSubject(request.getRequester());
    }
}
