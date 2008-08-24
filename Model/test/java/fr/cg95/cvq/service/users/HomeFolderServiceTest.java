package fr.cg95.cvq.service.users;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import junit.framework.Assert;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.users.ActorState;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Card;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.exception.CvqDisabledAccountException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqUnknownUserException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.testtool.ServiceTestCase;
import fr.cg95.cvq.util.Critere;

/**
 * The tests for the home folder service.
 *
 * @author bor@zenexity.fr
 */
public class HomeFolderServiceTest extends ServiceTestCase {

    public void testDisabledHomeFolder()
        throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        CreationBean cb = gimmeAnHomeFolder();

        SecurityContext.setCurrentEcitizen(cb.getLogin());

        // get the home folder id
        HomeFolder homeFolder = iHomeFolderService.getByRequestId(voCardRequestId);
        Long homeFolderId = homeFolder.getId();
        Assert.assertNotNull(homeFolderId);
        String responsibleLogin = homeFolder.getHomeFolderResponsible().getLogin();
        
        continueWithNewTransaction();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        homeFolder.setEnabled(Boolean.FALSE);
        iHomeFolderService.modify(homeFolder);
        
        continueWithNewTransaction();
        
        try {
            iAuthenticationService.authenticate(responsibleLogin, "toto");
            fail("should have thrown an exception");
        } catch (CvqDisabledAccountException cdae) {
            // that was expected
        }
        
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        homeFolder = iHomeFolderService.getByRequestId(voCardRequestId);
        homeFolder.setEnabled(Boolean.TRUE);
        iHomeFolderService.modify(homeFolder);
        
        continueWithNewTransaction();
        
        try {
            iAuthenticationService.authenticate(responsibleLogin, "toto");
        } catch (CvqDisabledAccountException cdae) {
            fail("should not have thrown an exception");
        }
    }
    
    public void testArchivedHomeFolder()
        throws CvqException {
    
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        CreationBean cb = gimmeAnHomeFolder();

        SecurityContext.setCurrentEcitizen(cb.getLogin());
        
        // get all home folders
        Set fetchHomeFolders = iHomeFolderService.getAll();
        Assert.assertEquals(fetchHomeFolders.size(), 1);
        
        // get the home folder id
        HomeFolder homeFolder = iHomeFolderService.getByRequestId(voCardRequestId);
        Long homeFolderId = homeFolder.getId();
        Assert.assertNotNull(homeFolderId);

        continueWithNewTransaction();

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        Set initialResults = iIndividualService.get(new HashSet(), null, true, false);
        int initialResultsSize = initialResults.size();
        
        iHomeFolderService.archive(homeFolder);

        continueWithNewTransaction();

        // individuals from home folder should no longer appear in search results
        initialResults = iIndividualService.get(new HashSet(), null, true, false);
        Assert.assertEquals(initialResultsSize, initialResults.size() + homeFolder.getIndividuals().size());
        
        try {
            iAuthenticationService.authenticate(homeFolder.getHomeFolderResponsible().getLogin(), "toto");
            fail("should have thrown an exception");
        } catch (CvqUnknownUserException cuue) {
            // that was expected
        }

        homeFolder = iHomeFolderService.getByRequestId(voCardRequestId);
        Assert.assertEquals(homeFolder.getState(), ActorState.ARCHIVED);
        
        Iterator individualsIt = homeFolder.getIndividuals().iterator();
        while (individualsIt.hasNext()) {
            Individual individual = (Individual) individualsIt.next();
            Assert.assertEquals(individual.getState(), ActorState.ARCHIVED);
        }

        Iterator it = homeFolder.getRequests().iterator();
        while (it.hasNext()) {
            Request request = (Request) it.next();
            Assert.assertEquals(request.getState(), RequestState.ARCHIVED);
        }
    }

    public void testAll()
        throws CvqException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        Critere crit = new Critere();
        Set<Critere> criteriaSet = new HashSet<Critere>();

        Set individualSet = 
            performIndividualSearch(Individual.SEARCH_BY_LASTNAME, "LASTNAME", 
                    Critere.EQUALS, Individual.SEARCH_BY_FIRSTNAME, "responsible", 
                    Critere.EQUALS, true);
        int lastAndFirstNameSearchSize = (individualSet == null ? 0 : individualSet.size());
        
        individualSet = 
            performIndividualSearch(Individual.SEARCH_BY_LASTNAME, "LASTNAME", 
                    Critere.NEQUALS, null, null, null, false);
        int notLastNameSearchSize = (individualSet == null ? 0 : individualSet.size());

        individualSet = 
            performIndividualSearch(Individual.SEARCH_BY_LASTNAME, "laSTN", 
                    Critere.STARTSWITH, null, null, null, false);
        int startsWithLastNameSearchSize = (individualSet == null ? 0 : individualSet.size());
        
        individualSet = 
            performIndividualSearch(Individual.SEARCH_BY_LASTNAME, "LOST", 
                    Critere.STARTSWITH, null, null, null, false);
        int badLastNameSearchSize = (individualSet == null ? 0 : individualSet.size());
        
        individualSet = 
            performIndividualSearch(Individual.SEARCH_BY_LASTNAME, "STNAME", 
                    Critere.LIKE, null, null, null, false);
        int ilikeLastNameSearchSize = (individualSet == null ? 0 : individualSet.size());
        
        individualSet = 
            performIndividualSearch(Individual.SEARCH_BY_FIRSTNAME, "OSTNAM", 
                    Critere.LIKE, null, null, null, false);
        int badFirstNameSearchSize = (individualSet == null ? 0 : individualSet.size());

        CreationBean cb = gimmeAnHomeFolder();

        SecurityContext.setCurrentEcitizen(cb.getLogin());

        // get the home folder id
        HomeFolder homeFolder = iHomeFolderService.getByRequestId(voCardRequestId);
        Long homeFolderId = homeFolder.getId();
        Assert.assertNotNull(homeFolderId);

        continueWithNewTransaction();
        
        // and validate it
        iHomeFolderService.validate(homeFolderId);

        continueWithNewTransaction();
        
        // do some tests on home folder's individuals
        homeFolder = iHomeFolderService.getById(homeFolderId);
        Assert.assertEquals(homeFolder.getIndividuals().size(), 5);

        Adult homeFolderResponsibleDb = homeFolder.getHomeFolderResponsible();
        Assert.assertEquals(homeFolderResponsibleDb.getFirstName(),
                homeFolderResponsible.getFirstName());

        individualSet = 
            performIndividualSearch(Individual.SEARCH_BY_LASTNAME, "LASTNAME", 
                    Critere.EQUALS, Individual.SEARCH_BY_FIRSTNAME, "responsible", 
                    Critere.EQUALS, true);
        Assert.assertEquals(individualSet.size(), 1);
        Assert.assertTrue(individualSet.iterator().next() instanceof Long);

        individualSet = 
            performIndividualSearch(Individual.SEARCH_BY_LASTNAME, "LASTNAME", 
                    Critere.NEQUALS, null, null, null, false);
        Assert.assertEquals(individualSet.size(), notLastNameSearchSize);

        individualSet = 
            performIndividualSearch(Individual.SEARCH_BY_LASTNAME, "laSTN", 
                    Critere.STARTSWITH, null, null, null, false);
        Assert.assertEquals(individualSet.size(), startsWithLastNameSearchSize + 5);

        individualSet = 
            performIndividualSearch(Individual.SEARCH_BY_LASTNAME, "LOST", 
                    Critere.STARTSWITH, null, null, null, false);
        Assert.assertEquals(individualSet.size(), badLastNameSearchSize);

        individualSet = 
            performIndividualSearch(Individual.SEARCH_BY_LASTNAME, "STNAME", 
                    Critere.LIKE, null, null, null, false);
        Assert.assertEquals(individualSet.size(), ilikeLastNameSearchSize + 5);
        Individual firstIndividualFound = (Individual)individualSet.iterator().next();
  
        individualSet = 
            performIndividualSearch(Individual.SEARCH_BY_FIRSTNAME, "OSTNAM", 
                    Critere.LIKE, null, null, null, false);
        Assert.assertEquals(individualSet.size(), badFirstNameSearchSize);
        
        individualSet = performIndividualSearch(Individual.SEARCH_BY_BIRTHDATE, new Date(), 
                Critere.GT, null, null, null, false);
        Assert.assertEquals(individualSet.size(), 2);
        
        Card card = new Card();
        card.setCardType("Carte d'abonné du Parc des Princes");
        card.setIdentifier("111-333-CVDSRGSDFSER");
        String certificate = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        card.setCertificate(certificate);
        card.setPin("12345678");
        iCardService.create(card, firstIndividualFound.getId());

        Individual individualByCertificate =
            iIndividualService.getByCertificate(certificate);
        Assert.assertNotNull(individualByCertificate);
    }
    
    private Set performIndividualSearch(final String attribut, final Object value,
            final String comparatif, final String attribut2, final Object value2,
            final String comparatif2, final boolean onlyIds) 
        throws CvqException {

        Set<Critere> criteriaSet = new HashSet<Critere>();

        Critere crit = new Critere();
        crit.setAttribut(attribut);
        crit.setValue(value);
        crit.setComparatif(comparatif);
        criteriaSet.add(crit);

        if (attribut2 != null) {
            Critere crit2 = new Critere();
            crit2.setAttribut(attribut2);
            crit2.setValue(value2);
            crit2.setComparatif(comparatif2);
            criteriaSet.add(crit2);
        }
        
        return iIndividualService.get(criteriaSet, null, onlyIds, false);
    }
}
