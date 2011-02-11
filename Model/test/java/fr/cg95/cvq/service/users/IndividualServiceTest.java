package fr.cg95.cvq.service.users;

import org.junit.Test;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.exception.CvqException;
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
        HomeFolder homeFolder = homeFolderService.getById(gimmeAnHomeFolder().getHomeFolderId());
        Adult emilie = new Adult();
        Adult jean = new Adult();
        Adult albert = new Adult();

        // Test with apostrophe
        String lnA = "L'ALBATROS";
        String fnA = "Emilie";
        String loginA = "emilie.lalbatros";

        emilie.setLastName(lnA);
        emilie.setFirstName(fnA);
        homeFolderService.addAdult(homeFolder, emilie);

        // Test with accent
        String lnB = "DUPÖÑT";
        String fnB = "Jean";
        String loginB = "jean.dupont";

        jean.setLastName(lnB);
        jean.setFirstName(fnB);
        homeFolderService.addAdult(homeFolder, jean);
        
        // Test with space
        String lnC = "DE LA PORTE";
        String fnC = "Albert";
        String loginC = "albert.de-la-porte";

        albert.setLastName(lnC);
        albert.setFirstName(fnC);
        homeFolderService.addAdult(homeFolder, albert);

        assertEquals(loginA, emilie.getLogin());
        assertEquals(loginB, jean.getLogin());
        assertEquals(loginC, albert.getLogin());
    }
}
