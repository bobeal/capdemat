package fr.cg95.cvq.service.request.localpolice;

import fr.cg95.cvq.business.request.localpolice.*;
import fr.cg95.cvq.business.users.HomeFolder;

public class HolidaySecurityRequestFeeder {

    public static void feed(HolidaySecurityRequest request) {
    }
    
    public static void setSubject(HolidaySecurityRequest request,
            HomeFolder homeFolder) {
        request.setSubject(homeFolder.getHomeFolderResponsible());
    }
}
