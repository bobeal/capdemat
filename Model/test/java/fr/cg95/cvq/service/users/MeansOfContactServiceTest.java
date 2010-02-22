package fr.cg95.cvq.service.users;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

import fr.cg95.cvq.business.request.MeansOfContact;
import fr.cg95.cvq.business.request.MeansOfContactEnum;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.RequestTestCase;

public class MeansOfContactServiceTest extends RequestTestCase {
    
    @Test
    public void testAll() throws CvqException {
        // Available Means of Contact are initialized during Spring Container bootstrap
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);

        // Simple get by type
        MeansOfContact mocMail = 
            meansOfContactService.getMeansOfContactByType(MeansOfContactEnum.MAIL);
        MeansOfContact mocEmail = 
            meansOfContactService.getMeansOfContactByType(MeansOfContactEnum.EMAIL);
        MeansOfContact mocSms = 
            meansOfContactService.getMeansOfContactByType(MeansOfContactEnum.SMS);
        assertEquals(mocMail.getType(), MeansOfContactEnum.MAIL);
        assertEquals(mocEmail.getType(), MeansOfContactEnum.EMAIL);
        assertEquals(mocSms.getType(), MeansOfContactEnum.SMS);
        
        // Get all available
        List<MeansOfContact> fetchMoc = meansOfContactService.getAvailableMeansOfContact();
        assertEquals(fetchMoc.size(), MeansOfContactEnum.allMeansOfContactEnums.length);
        
        // Get all enabled
        fetchMoc = meansOfContactService.getEnabledMeansOfContact();
        assertEquals(1, fetchMoc.size());
        
        meansOfContactService.enableMeansOfContact(mocMail);
        meansOfContactService.enableMeansOfContact(mocEmail);
        meansOfContactService.enableMeansOfContact(mocSms);
        
        continueWithNewTransaction();
        
        fetchMoc = meansOfContactService.getEnabledMeansOfContact();
        assertEquals(3, fetchMoc.size());

        // Get by current ecitizen
        CreationBean cb = gimmeAnHomeFolder();
        
        SecurityContext.setCurrentContext(SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(cb.getLogin());
        
        /* In this case:
         *  - MeansOfContactEnum.EMAIL,MAIL,SMS are enabled
         *  - Adult has filled Address and Email fields
         *  
         * nb:
         *  - if MeansOfContactEnum.LOCAL_AUTHORITY_OFFICE is enable
         *     then it is enable for Adult
         */        
        fetchMoc = meansOfContactService.getCurrentEcitizenEnabledMeansOfContact();
        assertEquals(3, fetchMoc.size());
        
        // Enable MeansOfContactEnum.LOCAL_AUTHORITY_OFFICE
        MeansOfContact mocLAO = meansOfContactService.getMeansOfContactByType(
                MeansOfContactEnum.LOCAL_AUTHORITY_OFFICE);
        meansOfContactService.enableMeansOfContact(mocLAO);
        
        continueWithNewTransaction();
        
        fetchMoc = meansOfContactService.getCurrentEcitizenEnabledMeansOfContact();
        assertEquals(4, fetchMoc.size());
        
        // Disable (keep 1 enabled)
        meansOfContactService.disableMeansOfContact(mocMail.getId());
        meansOfContactService.disableMeansOfContact(mocSms.getId());
        meansOfContactService.disableMeansOfContact(mocLAO.getId());
        
        continueWithNewTransaction();
        
        fetchMoc = meansOfContactService.getEnabledMeansOfContact();
        assertEquals(1, fetchMoc.size());
    }
    
    @Test
    public void testBusinessError() {
        // Test default MeansOfContact initialization 
        MeansOfContact moc = meansOfContactService.getMeansOfContactByType(MeansOfContactEnum.EMAIL);
        assertEquals(true, moc.isEnabled());
        
        // Test MeansOfContact disable policy
        try {
            meansOfContactService.disableMeansOfContact(moc);
            fail("should have thrown an exception");
        } catch (CvqModelException cme) {
            assertEquals("request.meansOfContact.message.mustHaveOneEnabled", cme.getMessage());
        }        
    }
}
