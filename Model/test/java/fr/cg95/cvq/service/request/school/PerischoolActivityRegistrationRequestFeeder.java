package fr.cg95.cvq.service.request.school;

import java.util.ArrayList;
import java.util.List;

import fr.cg95.cvq.business.request.school.OtherIndividual;
import fr.cg95.cvq.business.request.school.PerischoolActivityRegistrationRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.LocalReferentialData;
import fr.cg95.cvq.testtool.TestUtils;

public class PerischoolActivityRegistrationRequestFeeder {

    public static void feed(PerischoolActivityRegistrationRequest request) {
        LocalReferentialData lrd = new LocalReferentialData();
        lrd.setName("EveningNursery");
        List<LocalReferentialData> perischoolActivities = new ArrayList<LocalReferentialData>();
        perischoolActivities.add(lrd);
        request.setPerischoolActivity(perischoolActivities);
        
        OtherIndividual otherIndividual = new OtherIndividual();
        otherIndividual.setFirstName("John");
        otherIndividual.setLastName("Doe");
        List<OtherIndividual> otherIndividuals = new ArrayList<OtherIndividual>();
        otherIndividuals.add(otherIndividual);
        request.setOtherIndividual(otherIndividuals);
    }
    
    public static void setSubject(PerischoolActivityRegistrationRequest request,
            String subjectPolicy, Adult requester, HomeFolder homeFolder) {
        
        TestUtils.feedRequestSubject(request, subjectPolicy, requester, homeFolder);
    }
}
