package fr.cg95.cvq.service.localpolice;

import fr.cg95.cvq.business.localpolice.*;
import fr.cg95.cvq.business.users.HomeFolder;

public class HolidaySecurityRequestFeeder {

    public static void feed(HolidaySecurityRequest request) {
    }
    
    public static void setSubject(HolidaySecurityRequest request,
            HomeFolder homeFolder) {
        request.setSubject(homeFolder.getHomeFolderResponsible());
    }
}
