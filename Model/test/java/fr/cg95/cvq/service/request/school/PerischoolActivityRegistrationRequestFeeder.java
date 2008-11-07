package fr.cg95.cvq.service.request.school;

import java.util.HashSet;
import java.util.Set;

import fr.cg95.cvq.business.request.school.*;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.LocalReferentialData;
import fr.cg95.cvq.testtool.TestUtils;

public class PerischoolActivityRegistrationRequestFeeder {

    public static void feed(PerischoolActivityRegistrationRequest request) {
        LocalReferentialData lrd = new LocalReferentialData();
        lrd.setName("EveningNursery");
        Set<LocalReferentialData> perischoolActivities = new HashSet<LocalReferentialData>();
        perischoolActivities.add(lrd);
        request.setPerischoolActivity(perischoolActivities);
        
        OtherIndividual otherIndividual = new OtherIndividual();
        otherIndividual.setFirstName("John");
        otherIndividual.setLastName("Doe");
        Set<OtherIndividual> otherIndividuals = new HashSet<OtherIndividual>();
        otherIndividuals.add(otherIndividual);
        request.setOtherIndividual(otherIndividuals);
    }
    
    public static void setSubject(PerischoolActivityRegistrationRequest request,
            String subjectPolicy, Adult requester, HomeFolder homeFolder) {
        
        TestUtils.feedRequestSubject(request, subjectPolicy, requester, homeFolder);
    }
}
