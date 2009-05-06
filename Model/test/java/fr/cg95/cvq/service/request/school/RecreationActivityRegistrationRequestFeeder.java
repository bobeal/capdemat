package fr.cg95.cvq.service.request.school;

import java.util.ArrayList;
import java.util.List;

import fr.cg95.cvq.business.request.school.RecreationAuthorizedIndividual;
import fr.cg95.cvq.business.request.school.RecreationContactIndividual;
import fr.cg95.cvq.business.request.school.RecreationActivityRegistrationRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.LocalReferentialData;
import fr.cg95.cvq.testtool.BusinessObjectsFactory;
import fr.cg95.cvq.testtool.TestUtils;

public class RecreationActivityRegistrationRequestFeeder {

    public static void feed(RecreationActivityRegistrationRequest request) {
        LocalReferentialData lrd = new LocalReferentialData();
        lrd.setName("ANewEntry");
        List<LocalReferentialData> recreationActivities = new ArrayList<LocalReferentialData>();
        recreationActivities.add(lrd);
        request.setRecreationActivity(recreationActivities);
        
        RecreationContactIndividual contactIndividual = new RecreationContactIndividual();
        contactIndividual.setFirstName("John");
        contactIndividual.setLastName("Doe");
        contactIndividual.setHomePhone("0404040404");
        contactIndividual.setOfficePhone("0404040404");
        contactIndividual.setAddress(BusinessObjectsFactory.gimmeAdress("12", "Rue d'Aligre", "Paris", "75012"));
        List<RecreationContactIndividual> contactIndividuals = new ArrayList<RecreationContactIndividual>();
        contactIndividuals.add(contactIndividual);
        request.setContactIndividuals(contactIndividuals);
        
        RecreationAuthorizedIndividual authorizedIndividual = new RecreationAuthorizedIndividual();
        authorizedIndividual.setFirstName("Jane");
        authorizedIndividual.setLastName("Doe");
        authorizedIndividual.setHomePhone("0404040404");
        authorizedIndividual.setOfficePhone("0404040404");
        authorizedIndividual.setAddress(BusinessObjectsFactory.gimmeAdress("12", "Rue d'Aligre", "Paris", "75012"));
        List<RecreationAuthorizedIndividual> authorizedIndividuals = new ArrayList<RecreationAuthorizedIndividual>();
        authorizedIndividuals.add(authorizedIndividual);
        request.setAuthorizedIndividuals(authorizedIndividuals);
    }
    
    public static void setSubject(RecreationActivityRegistrationRequest request,
            String subjectPolicy, Adult requester, HomeFolder homeFolder) {
        TestUtils.feedRequestSubject(request, subjectPolicy, requester, homeFolder);
    }
}
