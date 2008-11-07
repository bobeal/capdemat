package fr.cg95.cvq.service.request.school;

import fr.cg95.cvq.business.request.school.SchoolCanteenRegistrationRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.testtool.TestUtils;

public class SchoolCanteenRegistrationRequestFeeder {

    public static void feed(SchoolCanteenRegistrationRequest request) {
    }
    
    public static void setSubject(SchoolCanteenRegistrationRequest request,
            String subjectPolicy, Adult requester, HomeFolder homeFolder) {
        TestUtils.feedRequestSubject(request, subjectPolicy, requester, homeFolder);
    }
}
