package fr.cg95.cvq.service.request.civil;

import fr.cg95.cvq.business.request.civil.DeathDetailsRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.testtool.TestUtils;

public class DeathDetailsRequestFeeder {

    public static void feed(DeathDetailsRequest request) {
    }
    
    public static void setSubject(DeathDetailsRequest request,
            String subjectPolicy, Adult requester, HomeFolder homeFolder) {
        TestUtils.feedRequestSubject(request, subjectPolicy, requester, homeFolder);
    }
}
