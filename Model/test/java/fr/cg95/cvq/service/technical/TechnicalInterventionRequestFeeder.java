package fr.cg95.cvq.service.technical;

import fr.cg95.cvq.business.technical.*;
import fr.cg95.cvq.business.users.HomeFolder;

public class TechnicalInterventionRequestFeeder {

    public static void feed(TechnicalInterventionRequest request) {
    }
    
    public static void setSubject(TechnicalInterventionRequest request,
            HomeFolder homeFolder) {
        request.setSubject(homeFolder.getHomeFolderResponsible());
    }
}
