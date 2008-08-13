package fr.cg95.cvq.service.school;

import java.util.Iterator;

import fr.cg95.cvq.business.school.RecreationActivityRegistrationRequest;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.testtool.BusinessObjectsFactory;

public class RecreationActivityRegistrationRequestFeeder {

    public static void feed(RecreationActivityRegistrationRequest request) {
    }
    
    public static void setSubject(RecreationActivityRegistrationRequest request,
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
