package fr.cg95.cvq.service.request.social;

import fr.cg95.cvq.business.request.social.*;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.testtool.TestUtils;

public class HandicapCompensationAdultRequestFeeder {

    public static void feed(HandicapCompensationAdultRequest request) {
    }
    
    public static void setSubject(HandicapCompensationAdultRequest request,
            HomeFolder homeFolder) {
    }
    
    public static void setSubject(HandicapCompensationAdultRequest request, 
            String subjectPolicy, Adult requester, HomeFolder homeFolder) {

        TestUtils.feedRequestSubject(request, subjectPolicy, requester, homeFolder);
    }
}
