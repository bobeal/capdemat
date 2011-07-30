package fr.cg95.cvq.service.request;

import fr.cg95.cvq.business.request.LocalReferentialEntry;
import fr.cg95.cvq.business.request.LocalReferentialEntryData;
import fr.cg95.cvq.business.request.LocalReferentialType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.testtool.TestUtils;

import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import junit.framework.Assert;

/**
 * The tests for the local referential data manipulation.
 * 
 * @author bor@zenexity.fr
 */
public class LocalReferentialServiceTest extends RequestTestCase {

    @Autowired
    private IRequestServiceRegistry requestServiceRegistry;
    
    @Test
    public void testAgentManipulation() throws CvqException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        // play a little bit with local referential data
        // //////////////////////////////////////////////

        String rtLabel = null;
        for (IRequestService service : requestServiceRegistry.getAllRequestServices())
            if (service.getLocalReferentialFilename() != null) {
                rtLabel = service.getLabel();
                break;
            }

        // lrt = local referential type
        String lrtName = localReferentialService.getLocalReferentialTypes(rtLabel).iterator().next().getName();
        Assert.assertNotNull(lrtName);
        logger.debug("Asking information for : " + rtLabel + "->" + lrtName);

        // check retrieving by data name
        String lreKey = localReferentialService.getLocalReferentialType(rtLabel, lrtName).getEntriesKeys().iterator().next();
        Assert.assertNotNull(lreKey);
        
        // check modifications on a local referential type :
        //    -> remove the first entry
        //    -> add another one
        LocalReferentialEntryData backupLre = localReferentialService.getLocalReferentialEntry(rtLabel, lrtName, lreKey);
        localReferentialService.removeLocalReferentialEntry(rtLabel, lrtName, lreKey);
        
        localReferentialService.setLocalReferentialTypeAllowingMultipleChoices(rtLabel, lrtName, true);
        String entryKey = localReferentialService.addLocalReferentialEntry(rtLabel, lrtName, null, "Une nouvelle entrée", null);
        localReferentialService.addLocalReferentialEntry(rtLabel, lrtName, entryKey, "Une sous entrée de la nouvelle entrée", "Le référentiel parle au référentiel");

        // check modifications have been effectively saved
        LocalReferentialType retrievedLrt = 
            localReferentialService.getLocalReferentialType(rtLabel, lrtName);
        Assert.assertNotNull(retrievedLrt);
        Assert.assertTrue(retrievedLrt.isMultiple());
        LocalReferentialEntry retrievedLre = retrievedLrt.getEntryByKey(entryKey);
        Assert.assertNotNull(retrievedLre);
        Assert.assertEquals(retrievedLre.getEntries().size(), 1);

        localReferentialService.removeLocalReferentialEntry(rtLabel, lrtName, entryKey);
        String backupKey = localReferentialService.addLocalReferentialEntry(rtLabel, lrtName, null, backupLre.getLabel(), backupLre.getMessage());
        
        // check modifications have been effectively saved
        retrievedLrt = localReferentialService.getLocalReferentialType(rtLabel, lrtName);
        Assert.assertNotNull(retrievedLrt);
        Assert.assertTrue(retrievedLrt.isMultiple());
        retrievedLre = retrievedLrt.getEntryByKey(entryKey);
        Assert.assertNull(retrievedLre);
        retrievedLre = retrievedLrt.getEntryByKey(backupKey);
        Assert.assertNotNull(retrievedLre);
    }
}
