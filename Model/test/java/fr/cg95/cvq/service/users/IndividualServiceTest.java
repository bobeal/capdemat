package fr.cg95.cvq.service.users;

import org.junit.Test;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.testtool.ServiceTestCase;
import static org.junit.Assert.*;

/**
 * The tests for the individual service.
 *
 * @author vsi@zenexity.com
 */
public class IndividualServiceTest extends ServiceTestCase {

    @Test
    public void testAssignLogin() throws CvqException {
        SecurityContext.setCurrentContext(SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(fake.responsibleId);
        Adult responsible = SecurityContext.getCurrentEcitizen();
        HomeFolder homeFolder = homeFolderService.getById(fake.id);
        Adult emilie = new Adult();
        Adult jean = new Adult();
        Adult albert = new Adult();

        // Test with apostrophe
        String lnA = "L'ALBATROS";
        String fnA = "Emilie";
        String loginA = "emilie.lalbatros";

        emilie.setLastName(lnA);
        emilie.setFirstName(fnA);
        emilie.setEmail(responsible.getEmail());
        homeFolderService.addAdult(homeFolder, emilie, true);

        // Test with accent
        String lnB = "DUPÖÑT";
        String fnB = "Jean";
        String loginB = "jean.dupont";

        jean.setLastName(lnB);
        jean.setFirstName(fnB);
        jean.setEmail(responsible.getEmail());
        homeFolderService.addAdult(homeFolder, jean, true);
        
        // Test with space
        String lnC = "DE LA PORTE";
        String fnC = "Albert";
        String loginC = "albert.de-la-porte";

        albert.setLastName(lnC);
        albert.setFirstName(fnC);
        albert.setEmail(responsible.getEmail());
        homeFolderService.addAdult(homeFolder, albert, true);

        assertEquals(loginA, emilie.getLogin());
        assertEquals(loginB, jean.getLogin());
        assertEquals(loginC, albert.getLogin());
    }
}
