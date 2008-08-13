package fr.cg95.cvq.service.social;

import fr.cg95.cvq.business.social.HandicapAllowanceRequest;
import fr.cg95.cvq.business.users.HomeFolder;

public class HandicapAllowanceRequestFeeder {

    public static void feed(HandicapAllowanceRequest request) {
    }
    
    public static void setSubject(HandicapAllowanceRequest request,
            HomeFolder homeFolder) {
        request.setSubject(homeFolder.getHomeFolderResponsible());
    }
}
