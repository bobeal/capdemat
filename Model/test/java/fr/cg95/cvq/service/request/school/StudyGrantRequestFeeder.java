package fr.cg95.cvq.service.request.school;

import fr.cg95.cvq.business.request.school.*;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.testtool.TestUtils;

public class StudyGrantRequestFeeder {

    public static void feed(StudyGrantRequest request) {
    }
    
    public static void setSubject(StudyGrantRequest request,
            String subjectPolicy, Adult requester, HomeFolder homeFolder) {
        TestUtils.feedRequestSubject(request, subjectPolicy, requester, homeFolder);
    }
}
