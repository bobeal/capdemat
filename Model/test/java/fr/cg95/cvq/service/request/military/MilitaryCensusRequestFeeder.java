package fr.cg95.cvq.service.request.military;

import fr.cg95.cvq.business.request.military.*;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.testtool.TestUtils;

public class MilitaryCensusRequestFeeder {

    public static void feed(MilitaryCensusRequest request) {
    }
    
    public static void setSubject(MilitaryCensusRequest request, 
            String subjectPolicy, Adult requester, HomeFolder homeFolder) {
        TestUtils.feedRequestSubject(request, subjectPolicy, requester, homeFolder);
    }
}
