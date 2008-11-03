package fr.cg95.cvq.service.request.school;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import fr.cg95.cvq.business.request.school.*;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.LocalReferentialData;
import fr.cg95.cvq.testtool.BusinessObjectsFactory;

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
            HomeFolder homeFolder) {
        if (homeFolder != null) {
            // search for a child in home folder
            Iterator individualsIt = homeFolder.getIndividuals().iterator();
            while (individualsIt.hasNext()) {
                Object object = individualsIt.next();
                if (object instanceof Child) {
                    request.setSubject((Child) object);
                    break;
                }
            }
        } else {
            Child child = BusinessObjectsFactory.gimmeChild("LASTNAME", "Firstname", 
                    request.getRequester(), null, null);
            request.setSubject(child);
        }
    }
}
