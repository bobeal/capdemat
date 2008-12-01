package fr.cg95.cvq.service.request.leisure;

import fr.cg95.cvq.business.request.leisure.*;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.testtool.TestUtils;

public class SmsNotificationRequestFeeder {

    public static void feed(SmsNotificationRequest request) {
    }
    
    public static void setSubject(SmsNotificationRequest request,
            String subjectPolicy, Adult requester, HomeFolder homeFolder) {
        TestUtils.feedRequestSubject(request, subjectPolicy, requester, homeFolder);
    }
}
