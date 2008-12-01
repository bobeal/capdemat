package fr.cg95.cvq.service.request.social;

import fr.cg95.cvq.business.request.social.HandicapAllowanceRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.testtool.TestUtils;

public class HandicapAllowanceRequestFeeder {

    public static void feed(HandicapAllowanceRequest request) {
    }
    
    public static void setSubject(HandicapAllowanceRequest request,
            String subjectPolicy, Adult requester, HomeFolder homeFolder) {
        TestUtils.feedRequestSubject(request, subjectPolicy, requester, homeFolder);
    }
}
