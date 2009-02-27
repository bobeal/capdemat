package fr.cg95.cvq.service.request.social;

import fr.cg95.cvq.business.request.social.*;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.testtool.TestUtils;

public class HandicapCompensationChildRequestFeeder {

    public static void feed(HandicapCompensationChildRequest request) {
    }
    
    public static void setSubject(HandicapCompensationChildRequest request,
            HomeFolder homeFolder) {
    }
    
    public static void setSubject(HandicapCompensationChildRequest request, 
            String subjectPolicy, Adult requester, HomeFolder homeFolder) {

        TestUtils.feedRequestSubject(request, subjectPolicy, requester, homeFolder);
    }
}
