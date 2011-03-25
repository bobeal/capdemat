package fr.cg95.cvq.service.users;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.HashMap;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.jsmtpd.domain.Email;
import org.jsmtpd.utils.junit.SmtpServer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.UserState;
import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.exception.CvqAuthenticationFailedException;
import fr.cg95.cvq.exception.CvqDisabledAccountException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqUnknownUserException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.users.IHomeFolderService.PasswordResetNotificationType;
import fr.cg95.cvq.testtool.JsmtpdMailService;
import fr.cg95.cvq.testtool.ServiceTestCase;
import fr.cg95.cvq.util.Critere;

/**
 * The tests for the home folder service.
 *
 * @author bor@zenexity.fr
 */
public class HomeFolderServiceTest extends ServiceTestCase {

    @Autowired
    private IGenericDAO genericDAO;

    @Test
    public void testDisabledHomeFolder()
        throws CvqException {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        HomeFolder homeFolder = homeFolderService.getById(fake.id);
        homeFolder.setEnabled(Boolean.FALSE);
        homeFolderService.modify(homeFolder);
        
        continueWithNewTransaction();
        
        try {
            authenticationService.authenticate(individualService.getAdultById(fake.responsibleId).getLogin(), "toto");
            fail("should have thrown an exception");
        } catch (CvqDisabledAccountException cdae) {
            // that was expected
        }
        
        homeFolder = homeFolderService.getById(fake.id);
        homeFolder.setEnabled(Boolean.TRUE);
        homeFolderService.modify(homeFolder);
        
        continueWithNewTransaction();
        
        try {
            authenticationService.authenticate(individualService.getAdultById(fake.responsibleId).getLogin(), "toto");
        } catch (CvqDisabledAccountException cdae) {
            fail("should not have thrown this exception");
        } catch (CvqAuthenticationFailedException cafe) {
            // that was expected
        }
    }
    
    @Test
    public void testArchivedHomeFolder()
        throws CvqException {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        // get all home folders
        List<HomeFolder> fetchHomeFolders = homeFolderService.getAll(true, true);
        assertEquals(fetchHomeFolders.size(), 1);
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(fake.responsibleId);
        continueWithNewTransaction();

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        List<Individual> initialResults = individualService.get(new HashSet<Critere>(), null, false);
        int initialResultsSize = initialResults.size();
        int homeFoldersCountBeforeArchive = homeFolderService.getAll(true, false).size();
        continueWithNewTransaction();
        userWorkflowService.changeState(individualService.getById(fake.childId), UserState.ARCHIVED);
        userWorkflowService.changeState(individualService.getById(fake.uncleId), UserState.ARCHIVED);
        userWorkflowService.changeState(individualService.getById(fake.womanId), UserState.ARCHIVED);
        userWorkflowService.changeState(individualService.getById(fake.responsibleId), UserState.ARCHIVED);

        continueWithNewTransaction();

        assertEquals(homeFoldersCountBeforeArchive - 1, homeFolderService.getAll(true, false).size());
        assertEquals(homeFoldersCountBeforeArchive - 1, homeFolderService.getAll(true, true).size());

        // individuals from home folder should no longer appear in search results
        initialResults = individualService.get(new HashSet<Critere>(), null, false);
        assertEquals(initialResultsSize, 
                initialResults.size() + homeFolderService.getById(fake.id).getIndividuals().size());
        
        try {
            authenticationService.authenticate(individualService.getAdultById(fake.responsibleId).getLogin(), "toto");
            fail("should have thrown an exception");
        } catch (CvqUnknownUserException cuue) {
            // that was expected
        }

        HomeFolder homeFolder = homeFolderService.getById(fake.id);
        assertEquals(homeFolder.getState(), UserState.ARCHIVED);
        
        List<Individual> individuals = homeFolder.getIndividuals();
        for (Individual individual : individuals) {
            assertEquals(individual.getState(), UserState.ARCHIVED);
        }
        homeFolder.setState(UserState.VALID);
        for (Individual i : homeFolder.getIndividuals()) i.setState(UserState.VALID);
        genericDAO.update(homeFolder);
    }

    @Test
    public void testIndividualSearch() throws CvqException {
        Integer total1 = 4, total2 = 1;
        List<FakeHomeFolder> homeFolders = new ArrayList<FakeHomeFolder>();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        homeFolders.add(new FakeHomeFolder());
        homeFolders.add(new FakeHomeFolder());
        homeFolders.add(new FakeHomeFolder());
        
        for (FakeHomeFolder fake : homeFolders) {
            HomeFolder folder = homeFolderService.getById(fake.id);
            total1 += folder.getIndividuals().size();
            total2 += homeFolderService.getHomeFolderResponsible(fake.id) != null ? 1 : 0;
        }
        continueWithNewTransaction();
        
        Integer result1 = individualService.get(new HashSet<Critere>(),
            new HashMap<String,String>(),null,null).size();
        
        Integer count1 = individualService.getCount(new HashSet<Critere>());
        
        assertEquals(total1,result1);
        assertEquals(count1,result1);
        
        Set<Critere> criterias = new HashSet<Critere>();
        Critere ct = new Critere();
        ct.setAttribut(Individual.SEARCH_IS_HOME_FOLDER_RESPONSIBLE);
        criterias.add(ct);
        
        Integer count2 = individualService.getCount(criterias);
        Integer result2 = individualService.get(criterias,
            new HashMap<String,String>(),null,null).size();
        
        assertEquals(total2,result2);
        assertEquals(count2,result2);
        assertNotSame(total1,result2);
        
        criterias = new HashSet<Critere>();
        ct = new Critere();
        ct.setAttribut(Individual.SEARCH_IS_HOME_FOLDER_RESPONSIBLE);
        criterias.add(ct);
        ct = new Critere();
        ct.setAttribut(Individual.SEARCH_BY_HOME_FOLDER_ID);
        ct.setComparatif(Critere.EQUALS);
        ct.setValue(fake.id);
        criterias.add(ct);
        
        Integer count3 = individualService.getCount(criterias);
        Integer result3 = individualService.get(criterias,
            new HashMap<String,String>(),null,null).size();
        
        assertTrue(result3 <= 1);
        assertEquals(count3,result3);
        
        Integer result4 = individualService.get(new HashSet<Critere>(),
            new HashMap<String,String>(),5,null).size();
        
        assertTrue(result4 <= 5);
        for (FakeHomeFolder fake : homeFolders) {
            homeFolderService.delete(fake.id);
        }
    }
    
    @Test
    public void testAll()
        throws CvqException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        List<Individual> individuals = 
            performIndividualSearch(Individual.SEARCH_BY_LASTNAME, "LASTNAME", 
                    Critere.EQUALS, Individual.SEARCH_BY_FIRSTNAME, "firstname", 
                    Critere.EQUALS, true);
        int lastAndFirstNameSearchSize = (individuals == null ? 0 : individuals.size());
        
        individuals = 
            performIndividualSearch(Individual.SEARCH_BY_LASTNAME, "LASTNAME",
                    Critere.NEQUALS, null, null, null, false);
        int notLastNameSearchSize = (individuals == null ? 0 : individuals.size());

        individuals = 
            performIndividualSearch(Individual.SEARCH_BY_LASTNAME, "laSTN", 
                    Critere.STARTSWITH, null, null, null, false);
        int startsWithLastNameSearchSize = (individuals == null ? 0 : individuals.size());
        
        individuals = 
            performIndividualSearch(Individual.SEARCH_BY_LASTNAME, "LOST", 
                    Critere.STARTSWITH, null, null, null, false);
        int badLastNameSearchSize = (individuals == null ? 0 : individuals.size());
        
        individuals = 
            performIndividualSearch(Individual.SEARCH_BY_LASTNAME, "STNAME", 
                    Critere.LIKE, null, null, null, false);
        int ilikeLastNameSearchSize = (individuals == null ? 0 : individuals.size());
        
        individuals = 
            performIndividualSearch(Individual.SEARCH_BY_FIRSTNAME, "OSTNAM", 
                    Critere.LIKE, null, null, null, false);
        int badFirstNameSearchSize = (individuals == null ? 0 : individuals.size());

        FakeHomeFolder fake = new FakeHomeFolder(false);

        continueWithNewTransaction();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        // and validate it
        userWorkflowService.changeState(individualService.getById(fake.responsibleId), UserState.VALID);

        continueWithNewTransaction();
        
        // do some tests on home folder's individuals
        HomeFolder homeFolder = homeFolderService.getById(fake.id);
        assertEquals(2, homeFolder.getIndividuals().size());

        Adult homeFolderResponsible = homeFolderService.getHomeFolderResponsible(homeFolder.getId());

        individuals = 
            performIndividualSearch(Individual.SEARCH_BY_LASTNAME, homeFolderResponsible.getLastName(), 
                    Critere.EQUALS, Individual.SEARCH_BY_FIRSTNAME, homeFolderResponsible.getFirstName(), 
                    Critere.EQUALS, true);
        assertEquals(individuals.size(), lastAndFirstNameSearchSize + 1);

        individuals = 
            performIndividualSearch(Individual.SEARCH_BY_LASTNAME, homeFolderResponsible.getLastName(), 
                    Critere.NEQUALS, null, null, null, false);
        assertEquals(individuals.size(), notLastNameSearchSize);

        individuals = 
            performIndividualSearch(Individual.SEARCH_BY_LASTNAME, "laSTN", 
                    Critere.STARTSWITH, null, null, null, false);
        assertEquals(individuals.size(), startsWithLastNameSearchSize + 2);

        individuals = 
            performIndividualSearch(Individual.SEARCH_BY_LASTNAME, "LOST", 
                    Critere.STARTSWITH, null, null, null, false);
        assertEquals(individuals.size(), badLastNameSearchSize);

        individuals = 
            performIndividualSearch(Individual.SEARCH_BY_LASTNAME, "STNAME", 
                    Critere.LIKE, null, null, null, false);
        assertEquals(individuals.size(), ilikeLastNameSearchSize + 2);
  
        individuals = 
            performIndividualSearch(Individual.SEARCH_BY_FIRSTNAME, "OSTNAM", 
                    Critere.LIKE, null, null, null, false);
        assertEquals(individuals.size(), badFirstNameSearchSize);
        homeFolderService.delete(fake.id);
    }
    
    private List<Individual> performIndividualSearch(final String attribut, final Object value,
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
        
        return individualService.get(criteriaSet, null, false);
    }

    @Test
    public void testNotifyPasswordReset() throws CvqException {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(fake.responsibleId);
        Adult adult = SecurityContext.getCurrentEcitizen();
        
        adult.setEmail(null);
        Email email = null;
        SmtpServer server = null;
        try {
            server = ((JsmtpdMailService)getApplicationBean("jsmtpdMailService")).getServer();
        } catch (Exception e) {
            fail("couldn't get jsmtpdMailService bean");
        }

        server.getQueue().clear();
        PasswordResetNotificationType notificationType = 
            homeFolderService.notifyPasswordReset(adult, adult.getPassword(), null);
        assertEquals(PasswordResetNotificationType.INLINE, notificationType);
        email = server.getMessage(1000);
        assertNull(email);

        server.getQueue().clear();
        notificationType = 
            homeFolderService.notifyPasswordReset(adult, adult.getPassword(), "example@example.com");
        assertEquals(PasswordResetNotificationType.CATEGORY_EMAIL, notificationType);
        email = server.getMessage(1000);
        assertEquals(email.getRecipients().size(), 1);
        assertEquals(email.getRecipients().get(0).toString(), "example@example.com");
        try {
            assertTrue(new MimeMessage(null, email.getDataStream().openInputStream()).getSubject().contains("Votre nouveau mot de passe pour vos démarches en ligne"));
        } catch (MessagingException e) {
            fail("could not instantiate a MimeMessage from email");
        } catch (IOException e) {
            fail("could not open email datastream");
        }

        adult.setEmail("example2@example.com");

        server.getQueue().clear();
        notificationType = homeFolderService.notifyPasswordReset(adult, adult.getPassword(), null);
        assertEquals(PasswordResetNotificationType.ADULT_EMAIL, notificationType);
        email = server.getMessage(1000);
        assertEquals(email.getRecipients().size(), 1);
        assertEquals(email.getRecipients().get(0).toString(), adult.getEmail());
        try {
            assertTrue(new MimeMessage(null, email.getDataStream().openInputStream()).getSubject().contains("Votre nouveau mot de passe pour vos démarches en ligne"));
        } catch (MessagingException e) {
            fail("could not instantiate a MimeMessage from email");
        } catch (IOException e) {
            fail("could not open email datastream");
        }

        server.getQueue().clear();
        notificationType = 
            homeFolderService.notifyPasswordReset(adult, adult.getPassword(), "example@example.com");
        assertEquals(PasswordResetNotificationType.ADULT_EMAIL, notificationType);
        email = server.getMessage(1000);
        assertEquals(email.getRecipients().size(), 1);
        assertEquals(email.getRecipients().get(0).toString(), adult.getEmail());
        try {
            assertTrue(new MimeMessage(null, email.getDataStream().openInputStream()).getSubject().contains("Votre nouveau mot de passe pour vos démarches en ligne"));
        } catch (MessagingException e) {
            fail("could not instantiate a MimeMessage from email");
        } catch (IOException e) {
            fail("could not open email datastream");
        }
    }
}
