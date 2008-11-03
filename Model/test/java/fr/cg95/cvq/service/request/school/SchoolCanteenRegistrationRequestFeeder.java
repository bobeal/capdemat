package fr.cg95.cvq.service.request.school;

import java.util.Iterator;

import fr.cg95.cvq.business.request.school.SchoolCanteenRegistrationRequest;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.testtool.BusinessObjectsFactory;

public class SchoolCanteenRegistrationRequestFeeder {

    public static void feed(SchoolCanteenRegistrationRequest request) {
    }
    
    public static void setSubject(SchoolCanteenRegistrationRequest request,
            HomeFolder homeFolder) {
        if (homeFolder != null) {
            // search for a child in home folder
            Iterator individualsIt = homeFolder.getIndividuals().iterator();
            while (individualsIt.hasNext()) {
                Object object = individualsIt.next();
                if (object instanceof Child) {
                    request.setSubject((Child) object);
                    return;
                }
            }
        } else {
            Child child = BusinessObjectsFactory.gimmeChild("LASTNAME", "Firstname", 
                    request.getRequester(), null, null);
            request.setSubject(child);
        }
    }
}
