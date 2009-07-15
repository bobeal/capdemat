package fr.cg95.cvq.service.users;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.jsmtpd.domain.Email;
import org.jsmtpd.utils.junit.SmtpServer;

import junit.framework.Assert;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.users.ActorState;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
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

    public void testDisabledHomeFolder()
        throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        CreationBean cb = gimmeAnHomeFolder();

        SecurityContext.setCurrentEcitizen(cb.getLogin());

        // get the home folder id
        Assert.assertNotNull(cb.getHomeFolderId());
        HomeFolder homeFolder = iHomeFolderService.getById(cb.getHomeFolderId());
        String responsibleLogin = cb.getLogin();
        
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
        
        homeFolder = iHomeFolderService.getById(cb.getHomeFolderId());
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
    
        CreationBean cb = gimmeAnHomeFolder();

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        // get all home folders
        Set<HomeFolder> fetchHomeFolders = iHomeFolderService.getAll();
        Assert.assertEquals(fetchHomeFolders.size(), 1);
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(cb.getLogin());

        // get the home folder id
        HomeFolder homeFolder = iHomeFolderService.getById(cb.getHomeFolderId());
        Assert.assertNotNull(homeFolder.getId());

        continueWithNewTransaction();

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        List<Individual> initialResults = iIndividualService.get(new HashSet<Critere>(), null, false);
        int initialResultsSize = initialResults.size();
        
        iHomeFolderService.archive(homeFolder.getId());

        continueWithNewTransaction();

        // individuals from home folder should no longer appear in search results
        initialResults = iIndividualService.get(new HashSet<Critere>(), null, false);
        Assert.assertEquals(initialResultsSize, 
                initialResults.size() + homeFolder.getIndividuals().size());
        
        try {
            Adult homeFolderResponsible = 
                iHomeFolderService.getHomeFolderResponsible(homeFolder.getId());
            iAuthenticationService.authenticate(homeFolderResponsible.getLogin(), "toto");
            fail("should have thrown an exception");
        } catch (CvqUnknownUserException cuue) {
            // that was expected
        }

        homeFolder = iHomeFolderService.getById(cb.getHomeFolderId());
        Assert.assertEquals(homeFolder.getState(), ActorState.ARCHIVED);
        
        List<Individual> individuals = homeFolder.getIndividuals();
        for (Individual individual : individuals) {
            Assert.assertEquals(individual.getState(), ActorState.ARCHIVED);
        }

        List<Request> requests = iRequestService.getByHomeFolderId(homeFolder.getId());
        for (Request request : requests) {
            Assert.assertEquals(request.getState(), RequestState.ARCHIVED);
        }
    }

    public void testIndividualSearch() throws CvqException {
        Integer total1 = 0, total2 = 0; 
        List<CreationBean> beans = new ArrayList<CreationBean>();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        beans.add(gimmeAnHomeFolder());
        beans.add(gimmeAnHomeFolder());
        beans.add(gimmeAnHomeFolder());
        
        for(CreationBean bean: beans) {
            HomeFolder folder = iHomeFolderService.getById(bean.getHomeFolderId());
            total1 += folder.getIndividuals().size();
            total2 += iHomeFolderService.getHomeFolderResponsible(bean.getHomeFolderId()) != null ? 1 : 0;
        }
        continueWithNewTransaction();
        
        Integer result1 = iIndividualService.get(new HashSet<Critere>(),
            new HashMap<String,String>(),null,null).size();
        
        Integer count1 = iIndividualService.getCount(new HashSet<Critere>());
        
        assertEquals(total1,result1);
        assertEquals(count1,result1);
        
        Set<Critere> criterias = new HashSet<Critere>();
        Critere ct = new Critere();
        ct.setAttribut(Individual.SEARCH_IS_HOME_FOLDER_RESPONSIBLE);
        criterias.add(ct);
        
        Integer count2 = iIndividualService.getCount(criterias);
        Integer result2 = iIndividualService.get(criterias,
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
        ct.setValue(beans.get(1).getHomeFolderId());
        criterias.add(ct);
        
        Integer count3 = iIndividualService.getCount(criterias);
        Integer result3 = iIndividualService.get(criterias,
            new HashMap<String,String>(),null,null).size();
        
        assertTrue(result3 <= 1);
        assertEquals(count3,result3);
        
        Integer result4 = iIndividualService.get(new HashSet<Critere>(),
            new HashMap<String,String>(),5,null).size();
        
        assertTrue(result4 <= 5);
    }
    
    public void testAll()
        throws CvqException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        List<Individual> individuals = 
            performIndividualSearch(Individual.SEARCH_BY_LASTNAME, "LASTNAME", 
                    Critere.EQUALS, Individual.SEARCH_BY_FIRSTNAME, "responsible", 
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

        CreationBean cb = gimmeAnHomeFolder();

        SecurityContext.setCurrentEcitizen(cb.getLogin());

        // get the home folder id
        HomeFolder homeFolder = iHomeFolderService.getById(cb.getHomeFolderId());

        continueWithNewTransaction();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        // and validate it
        iHomeFolderService.validate(homeFolder.getId());

        continueWithNewTransaction();
        
        // do some tests on home folder's individuals
        homeFolder = iHomeFolderService.getById(homeFolder.getId());
        Assert.assertEquals(homeFolder.getIndividuals().size(), 5);

        Adult homeFolderResponsibleDb = 
            iHomeFolderService.getHomeFolderResponsible(homeFolder.getId());
        Assert.assertEquals(homeFolderResponsibleDb.getFirstName(),
                homeFolderResponsible.getFirstName());

        individuals = 
            performIndividualSearch(Individual.SEARCH_BY_LASTNAME, "LASTNAME", 
                    Critere.EQUALS, Individual.SEARCH_BY_FIRSTNAME, "responsible", 
                    Critere.EQUALS, true);
        Assert.assertEquals(individuals.size(), lastAndFirstNameSearchSize + 1);

        individuals = 
            performIndividualSearch(Individual.SEARCH_BY_LASTNAME, "LASTNAME", 
                    Critere.NEQUALS, null, null, null, false);
        Assert.assertEquals(individuals.size(), notLastNameSearchSize);

        individuals = 
            performIndividualSearch(Individual.SEARCH_BY_LASTNAME, "laSTN", 
                    Critere.STARTSWITH, null, null, null, false);
        Assert.assertEquals(individuals.size(), startsWithLastNameSearchSize + 5);

        individuals = 
            performIndividualSearch(Individual.SEARCH_BY_LASTNAME, "LOST", 
                    Critere.STARTSWITH, null, null, null, false);
        Assert.assertEquals(individuals.size(), badLastNameSearchSize);

        individuals = 
            performIndividualSearch(Individual.SEARCH_BY_LASTNAME, "STNAME", 
                    Critere.LIKE, null, null, null, false);
        Assert.assertEquals(individuals.size(), ilikeLastNameSearchSize + 5);
  
        individuals = 
            performIndividualSearch(Individual.SEARCH_BY_FIRSTNAME, "OSTNAM", 
                    Critere.LIKE, null, null, null, false);
        Assert.assertEquals(individuals.size(), badFirstNameSearchSize);
        
        individuals = performIndividualSearch(Individual.SEARCH_BY_BIRTHDATE, new Date(), 
                Critere.GT, null, null, null, false);
        Assert.assertEquals(individuals.size(), 2);
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
        
        return iIndividualService.get(criteriaSet, null, false);
    }

    public void testNotifyPasswordReset()
        throws CvqException {
        Adult adult = iHomeFolderService.getHomeFolderResponsible(gimmeAnHomeFolder().getHomeFolderId());
        adult.setEmail(null);
        Email email = null;
        SmtpServer server = null;
        try {
            server = ((JsmtpdMailService)getBean("jsmtpdMailService")).getServer();
        } catch (Exception e) {
            fail("couldn't get jsmtpdMailService bean");
        }

        server.getQueue().clear();
        PasswordResetNotificationType notificationType = iHomeFolderService.notifyPasswordReset(adult, adult.getPassword(), null);
        Assert.assertEquals(PasswordResetNotificationType.INLINE, notificationType);
        email = server.getMessage(1000);
        Assert.assertEquals(null, email);

        server.getQueue().clear();
        notificationType = iHomeFolderService.notifyPasswordReset(adult, adult.getPassword(), "example@example.com");
        Assert.assertEquals(PasswordResetNotificationType.CATEGORY_EMAIL, notificationType);
        email = server.getMessage(1000);
        Assert.assertEquals(email.getRecipients().size(), 1);
        Assert.assertEquals(email.getRecipients().get(0).toString(), "example@example.com");
        try {
            Assert.assertTrue(new MimeMessage(null, email.getDataStream().openInputStream()).getSubject().contains("Votre nouveau mot de passe pour vos démarches en ligne"));
        } catch (MessagingException e) {
            fail("could not instantiate a MimeMessage from email");
        } catch (IOException e) {
            fail("could not open email datastream");
        }

        adult.setEmail("example2@example.com");

        server.getQueue().clear();
        notificationType = iHomeFolderService.notifyPasswordReset(adult, adult.getPassword(), null);
        Assert.assertEquals(PasswordResetNotificationType.ADULT_EMAIL, notificationType);
        email = server.getMessage(1000);
        Assert.assertEquals(email.getRecipients().size(), 1);
        Assert.assertEquals(email.getRecipients().get(0).toString(), adult.getEmail());
        try {
            Assert.assertTrue(new MimeMessage(null, email.getDataStream().openInputStream()).getSubject().contains("Votre nouveau mot de passe pour vos démarches en ligne"));
        } catch (MessagingException e) {
            fail("could not instantiate a MimeMessage from email");
        } catch (IOException e) {
            fail("could not open email datastream");
        }

        server.getQueue().clear();
        notificationType = iHomeFolderService.notifyPasswordReset(adult, adult.getPassword(), "example@example.com");
        Assert.assertEquals(PasswordResetNotificationType.ADULT_EMAIL, notificationType);
        email = server.getMessage(1000);
        Assert.assertEquals(email.getRecipients().size(), 1);
        Assert.assertEquals(email.getRecipients().get(0).toString(), adult.getEmail());
        try {
            Assert.assertTrue(new MimeMessage(null, email.getDataStream().openInputStream()).getSubject().contains("Votre nouveau mot de passe pour vos démarches en ligne"));
        } catch (MessagingException e) {
            fail("could not instantiate a MimeMessage from email");
        } catch (IOException e) {
            fail("could not open email datastream");
        }
    }

}
