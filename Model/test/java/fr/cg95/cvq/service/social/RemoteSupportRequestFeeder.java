package fr.cg95.cvq.service.social;

import fr.cg95.cvq.business.social.RemoteSupportRequest;
import fr.cg95.cvq.business.users.HomeFolder;

public class RemoteSupportRequestFeeder {

    public static void feed(RemoteSupportRequest request) {
    }
    
    public static void setSubject(RemoteSupportRequest request,
            HomeFolder homeFolder) {
        
        request.setSubject(homeFolder.getHomeFolderResponsible());
    }
}
