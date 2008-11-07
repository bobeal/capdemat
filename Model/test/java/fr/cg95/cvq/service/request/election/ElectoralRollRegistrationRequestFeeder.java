package fr.cg95.cvq.service.request.election;

import fr.cg95.cvq.business.request.election.ElectoralRollRegistrationRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.testtool.TestUtils;

public class ElectoralRollRegistrationRequestFeeder {

    public static void feed(ElectoralRollRegistrationRequest request) {
    }
    
    public static void setSubject(ElectoralRollRegistrationRequest request,
            String subjectPolicy, Adult requester, HomeFolder homeFolder) {
        TestUtils.feedRequestSubject(request, subjectPolicy, requester, homeFolder);
    }
}
