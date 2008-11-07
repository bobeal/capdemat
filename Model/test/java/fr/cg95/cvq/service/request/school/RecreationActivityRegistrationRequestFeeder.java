package fr.cg95.cvq.service.request.school;

import fr.cg95.cvq.business.request.school.RecreationActivityRegistrationRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.testtool.TestUtils;

public class RecreationActivityRegistrationRequestFeeder {

    public static void feed(RecreationActivityRegistrationRequest request) {
    }
    
    public static void setSubject(RecreationActivityRegistrationRequest request,
            String subjectPolicy, Adult requester, HomeFolder homeFolder) {
        TestUtils.feedRequestSubject(request, subjectPolicy, requester, homeFolder);
    }
}
