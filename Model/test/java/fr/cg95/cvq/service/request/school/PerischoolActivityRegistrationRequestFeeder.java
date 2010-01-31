package fr.cg95.cvq.service.request.school;

import java.util.ArrayList;
import java.util.List;

import fr.cg95.cvq.business.request.LocalReferentialData;
import fr.cg95.cvq.business.request.school.PerischoolAuthorizedIndividual;
import fr.cg95.cvq.business.request.school.PerischoolContactIndividual;
import fr.cg95.cvq.business.request.school.PerischoolActivityRegistrationRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.testtool.BusinessObjectsFactory;
import fr.cg95.cvq.testtool.TestUtils;

public class PerischoolActivityRegistrationRequestFeeder {

    public static void feed(PerischoolActivityRegistrationRequest request) {
        LocalReferentialData lrd = new LocalReferentialData();
        lrd.setName("EveningNursery");
        List<LocalReferentialData> perischoolActivities = new ArrayList<LocalReferentialData>();
        perischoolActivities.add(lrd);
        request.setPerischoolActivity(perischoolActivities);
        
        PerischoolContactIndividual contactIndividual = new PerischoolContactIndividual();
        contactIndividual.setFirstName("John");
        contactIndividual.setLastName("Doe");
        contactIndividual.setHomePhone("0404040404");
        contactIndividual.setOfficePhone("0404040404");
        contactIndividual.setAddress(BusinessObjectsFactory.gimmeAdress("12", "Rue d'Aligre", "Paris", "75012"));
        List<PerischoolContactIndividual> contactIndividuals = new ArrayList<PerischoolContactIndividual>();
        contactIndividuals.add(contactIndividual);
        request.setContactIndividuals(contactIndividuals);
        
        PerischoolAuthorizedIndividual authorizedIndividual = new PerischoolAuthorizedIndividual();
        authorizedIndividual.setFirstName("Jane");
        authorizedIndividual.setLastName("Doe");
        authorizedIndividual.setHomePhone("0404040404");
        authorizedIndividual.setOfficePhone("0404040404");        
        authorizedIndividual.setAddress(BusinessObjectsFactory.gimmeAdress("12", "Rue d'Aligre", "Paris", "75012"));
        List<PerischoolAuthorizedIndividual> authorizedIndividuals = new ArrayList<PerischoolAuthorizedIndividual>();
        authorizedIndividuals.add(authorizedIndividual);
        request.setAuthorizedIndividuals(authorizedIndividuals);
    }
    
    public static void setSubject(PerischoolActivityRegistrationRequest request,
            String subjectPolicy, Adult requester, HomeFolder homeFolder) {
        
        TestUtils.feedRequestSubject(request, subjectPolicy, requester, homeFolder);
    }
}
