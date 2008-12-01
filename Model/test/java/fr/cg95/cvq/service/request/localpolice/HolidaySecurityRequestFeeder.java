package fr.cg95.cvq.service.request.localpolice;

import fr.cg95.cvq.business.request.localpolice.*;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.testtool.TestUtils;

public class HolidaySecurityRequestFeeder {

    public static void feed(HolidaySecurityRequest request) {
    }
    
    public static void setSubject(HolidaySecurityRequest request,
            String subjectPolicy, Adult requester, HomeFolder homeFolder) {
        TestUtils.feedRequestSubject(request, subjectPolicy, requester, homeFolder);
    }
}
