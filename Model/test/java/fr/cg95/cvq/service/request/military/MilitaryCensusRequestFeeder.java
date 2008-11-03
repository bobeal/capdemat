package fr.cg95.cvq.service.request.military;

import java.util.Iterator;

import fr.cg95.cvq.business.request.military.*;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.testtool.BusinessObjectsFactory;

public class MilitaryCensusRequestFeeder {

    public static void feed(MilitaryCensusRequest request) {
    }
    
    public static void setSubject(MilitaryCensusRequest request, HomeFolder homeFolder) {
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
