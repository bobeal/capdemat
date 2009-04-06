package fr.cg95.cvq.service.authority;

import fr.cg95.cvq.business.authority.LocalReferentialEntry;
import fr.cg95.cvq.business.authority.LocalReferentialType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.testtool.ServiceTestCase;
import fr.cg95.cvq.testtool.TestUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

/**
 * The tests for the local referential data manipulation.
 * 
 * @author bor@zenexity.fr
 */
public class LocalReferentialServiceTest extends ServiceTestCase {

    public void testAgentManipulation() throws CvqException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        // play a little bit with local referential data
        // //////////////////////////////////////////////

        // check retrieving of whole tree of local referential data
        Set allLocalReferentialData = localReferentialService.getAllLocalReferentialData();
        TestUtils.printLocalRefData(allLocalReferentialData);
        
        // check retrieving of referential data summary information
        Map allLocalReferentialDataNames = 
            localReferentialService.getAllLocalReferentialDataNames();
        TestUtils.printLocalRefDataSummary(allLocalReferentialDataNames);
        
        Iterator keysIt = allLocalReferentialDataNames.keySet().iterator();
        String dataName = (String) keysIt.next();
        logger.debug("Asking information for : " + dataName);

        // check retrieving by data name
        LocalReferentialType lrt = localReferentialService.getLocalReferentialDataByName(dataName);
        Assert.assertNotNull(lrt);
        Assert.assertEquals(lrt.getDataName(), dataName);

        // check retrieving by request type
        Set commonLocalReferentialDataSet = 
            localReferentialService.getLocalReferentialDataByRequestType("All");
        Assert.assertNotNull(commonLocalReferentialDataSet);
        TestUtils.printLocalRefData(commonLocalReferentialDataSet);

        // check modifications on a local referential type :
        //    -> remove the first entry
        //    -> add another one
        LocalReferentialEntry backupLre = null;
        if (lrt.getEntries() != null) {
            backupLre = (LocalReferentialEntry) lrt.getEntries().iterator().next();
            lrt.getEntries().remove(backupLre);
        }
        LocalReferentialEntry lre = new LocalReferentialEntry();
        lre.setKey("ANewEntry");
        lre.addLabel("fr", "Une nouvelle entrée");
        lrt.addEntry(lre,null);
        lrt.setEntriesSupportMultiple(true);
        lrt.setEntriesSupportPriority(true);
        LocalReferentialEntry subLre = new LocalReferentialEntry();
        subLre.setKey("ANewSubEntry");
        subLre.addLabel("fr", "Une sous entrée de la nouvelle entrée");
        subLre.addMessage("fr", "Le référentiel parle au référentiel");
        Map<String, String> precisionLabelsMap = new HashMap<String, String>();
        precisionLabelsMap.put("fr", "Précise moi ça, fiston");
        subLre.addPrecision("Précision", precisionLabelsMap);
        lre.addEntry(subLre);
        lre.setEntriesSupportPrecision(true);
        localReferentialService.setLocalReferentialData(lrt);

        // check modifications have been effectively saved
        LocalReferentialType retrievedLrt = 
            localReferentialService.getLocalReferentialDataByName(dataName);
        Assert.assertNotNull(retrievedLrt);
        Assert.assertTrue(retrievedLrt.getEntriesSupportMultiple());
        Assert.assertTrue(retrievedLrt.getEntriesSupportPriority());
        LocalReferentialEntry retrievedLre = retrievedLrt.getEntryByKey("ANewEntry");
        Assert.assertNotNull(retrievedLre);
        Assert.assertEquals(retrievedLre.getEntries().size(), 1);

        retrievedLrt.getEntries().remove(retrievedLre);
        retrievedLrt.getEntries().add(backupLre);
        localReferentialService.setLocalReferentialData(retrievedLrt);
        
        // check modifications have been effectively saved
        retrievedLrt = localReferentialService.getLocalReferentialDataByName(dataName);
        Assert.assertNotNull(retrievedLrt);
        Assert.assertTrue(retrievedLrt.getEntriesSupportMultiple());
        Assert.assertTrue(retrievedLrt.getEntriesSupportPriority());
        retrievedLre = retrievedLrt.getEntryByKey("ANewEntry");
        Assert.assertNull(retrievedLre);
        retrievedLre = retrievedLrt.getEntryByKey(backupLre.getKey());
        Assert.assertNotNull(retrievedLre);
    }
}
