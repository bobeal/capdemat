package fr.cg95.cvq.service.request.technical;

import fr.cg95.cvq.business.request.technical.*;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.testtool.TestUtils;

public class TechnicalInterventionRequestFeeder {

    public static void feed(TechnicalInterventionRequest request) {
    }
    
    public static void setSubject(TechnicalInterventionRequest request,
            String subjectPolicy, Adult requester, HomeFolder homeFolder) {
        TestUtils.feedRequestSubject(request, subjectPolicy, requester, homeFolder);
    }
}
