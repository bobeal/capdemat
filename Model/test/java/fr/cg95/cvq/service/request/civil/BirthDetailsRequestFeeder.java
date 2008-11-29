package fr.cg95.cvq.service.request.civil;

import fr.cg95.cvq.business.request.civil.BirthDetailsRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.testtool.TestUtils;

public class BirthDetailsRequestFeeder {

    public static void feed(BirthDetailsRequest request) {
    }
    
    public static void setSubject(BirthDetailsRequest request,
            String subjectPolicy, Adult requester, HomeFolder homeFolder) {
        TestUtils.feedRequestSubject(request, subjectPolicy, requester, homeFolder);
    }
}
