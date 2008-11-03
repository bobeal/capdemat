package fr.cg95.cvq.service.request.election;

import java.util.Set;

import fr.cg95.cvq.business.request.election.ElectoralRollRegistrationRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;

public class ElectoralRollRegistrationRequestFeeder {

    public static void feed(ElectoralRollRegistrationRequest request) {
    }
    
    public static void setSubject(ElectoralRollRegistrationRequest request,
            HomeFolder homeFolder) {
        if (homeFolder != null) {
            Set<Individual> individuals = homeFolder.getIndividuals();
            for (Individual individual : individuals) {
                if (individual instanceof Adult) {
                    request.setSubject(individual);
                    break;
                }
            }
        } else {
            request.setSubject(request.getRequester());
        }
    }
}
