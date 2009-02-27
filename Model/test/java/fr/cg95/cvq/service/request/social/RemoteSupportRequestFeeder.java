package fr.cg95.cvq.service.request.social;

import fr.cg95.cvq.business.request.social.*;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.testtool.TestUtils;

public class RemoteSupportRequestFeeder {

    public static void feed(RemoteSupportRequest request) {
    }
    
    public static void setSubject(RemoteSupportRequest request,
            HomeFolder homeFolder) {
    }
    
    public static void setSubject(RemoteSupportRequest request, 
            String subjectPolicy, Adult requester, HomeFolder homeFolder) {

        TestUtils.feedRequestSubject(request, subjectPolicy, requester, homeFolder);
    }
}
