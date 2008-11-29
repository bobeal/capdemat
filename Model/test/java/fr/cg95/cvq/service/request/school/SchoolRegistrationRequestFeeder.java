package fr.cg95.cvq.service.request.school;

import fr.cg95.cvq.business.request.school.SchoolRegistrationRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.testtool.TestUtils;

public class SchoolRegistrationRequestFeeder {

    public static void feed(SchoolRegistrationRequest request) {
    }
    
    public static void setSubject(SchoolRegistrationRequest request,
            String subjectPolicy, Adult requester, HomeFolder homeFolder) {
        TestUtils.feedRequestSubject(request, subjectPolicy, requester, homeFolder);
    }
}
