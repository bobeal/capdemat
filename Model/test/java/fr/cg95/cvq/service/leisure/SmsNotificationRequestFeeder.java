package fr.cg95.cvq.service.leisure;

import fr.cg95.cvq.business.leisure.*;
import fr.cg95.cvq.business.users.HomeFolder;

public class SmsNotificationRequestFeeder {

    public static void feed(SmsNotificationRequest request) {
    }
    
    public static void setSubject(SmsNotificationRequest request,
            HomeFolder homeFolder) {
       request.setSubject(homeFolder.getHomeFolderResponsible());
    }
}
