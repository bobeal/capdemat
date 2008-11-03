package fr.cg95.cvq.service.request.social;

import fr.cg95.cvq.business.request.social.HandicapAllowanceRequest;
import fr.cg95.cvq.business.users.HomeFolder;

public class HandicapAllowanceRequestFeeder {

    public static void feed(HandicapAllowanceRequest request) {
    }
    
    public static void setSubject(HandicapAllowanceRequest request,
            HomeFolder homeFolder) {
        request.setSubject(homeFolder.getHomeFolderResponsible());
    }
}
