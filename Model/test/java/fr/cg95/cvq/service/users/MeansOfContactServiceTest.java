package fr.cg95.cvq.service.users;

import java.util.List;

import junit.framework.Assert;
import fr.cg95.cvq.business.request.MeansOfContact;
import fr.cg95.cvq.business.request.MeansOfContactEnum;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.testtool.ServiceTestCase;

public class MeansOfContactServiceTest extends ServiceTestCase {
    
    public void testAll() throws CvqException {
        // Available Means of Contact are initialized during Spring Container bootstrap
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);

        // Simple get by type
        MeansOfContact mocMail = iMeansOfContactService.getMeansOfContactByType(
                MeansOfContactEnum.MAIL);
        MeansOfContact mocEmail = iMeansOfContactService.getMeansOfContactByType(
                MeansOfContactEnum.EMAIL);
        MeansOfContact mocSms = iMeansOfContactService.getMeansOfContactByType(
                MeansOfContactEnum.SMS);
        Assert.assertEquals(mocMail.getType(), MeansOfContactEnum.MAIL);
        Assert.assertEquals(mocEmail.getType(), MeansOfContactEnum.EMAIL);
        Assert.assertEquals(mocSms.getType(), MeansOfContactEnum.SMS);
        
        // Get all availabled
        List<MeansOfContact> fetchMoc = iMeansOfContactService.getAvailableMeansOfContact();
        Assert.assertEquals(fetchMoc.size(), MeansOfContactEnum.allMeansOfContactEnums.length);
        
        // Get all enabled
        fetchMoc = iMeansOfContactService.getEnabledMeansOfContact();
        Assert.assertEquals(1, fetchMoc.size());
        
        iMeansOfContactService.enableMeansOfContact(mocMail);
        iMeansOfContactService.enableMeansOfContact(mocEmail);
        iMeansOfContactService.enableMeansOfContact(mocSms);
        fetchMoc = iMeansOfContactService.getEnabledMeansOfContact();
        Assert.assertEquals(3, fetchMoc.size());

        // Get by current ecitizen
        Adult adult = new Adult();
        adult.setLastName("mocLASTNAME");
        adult.setLastName("mocFIRSTNAME");
        adult.setAdress(new Address("1","rue de MeansOfContact", "99999","CAPDEMAT"));
        adult.setEmail("rdj@zenexity.fr");
        
        SecurityContext.setCurrentContext(SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(adult);
        
        /* In this case:
         *  - MeansOfContactEnum.EMAIL,MAIL,SMS are enabled
         *  - Adult has filled Address and Email fields
         *  
         * nb:
         *  - if MeansOfContactEnum.LOCAL_AUTHORITY_OFFICE is enable
         *     then it is enable for Adult
         */        
        fetchMoc = iMeansOfContactService.getCurrentEcitizenEnabledMeansOfContact();
        Assert.assertEquals(2, fetchMoc.size());
        
        // Enable MeansOfContactEnum.LOCAL_AUTHORITY_OFFICE
        MeansOfContact mocLAO = iMeansOfContactService.getMeansOfContactByType(
                MeansOfContactEnum.LOCAL_AUTHORITY_OFFICE);
        iMeansOfContactService.enableMeansOfContact(mocLAO);
        fetchMoc = iMeansOfContactService.getCurrentEcitizenEnabledMeansOfContact();
        Assert.assertEquals(3, fetchMoc.size());
        
        // Disable (keep 1 enabled)
        iMeansOfContactService.disableMeansOfContact(mocMail);
        iMeansOfContactService.disableMeansOfContact(mocSms);
        iMeansOfContactService.disableMeansOfContact(mocLAO);
        fetchMoc = iMeansOfContactService.getEnabledMeansOfContact();
        Assert.assertEquals(1, fetchMoc.size());
    }
    
    public void testBusinessError() throws CvqException {
        // Test default MeansOfContact initialisation 
        List<MeansOfContact> fetchMoc = iMeansOfContactService.getAvailableMeansOfContact();
        MeansOfContact moc = iMeansOfContactService.getMeansOfContactByType(MeansOfContactEnum.EMAIL);
        Assert.assertEquals(true, moc.isEnabled());
        
        // Test MeansOfContact disable policy
        try {
            iMeansOfContactService.disableMeansOfContact(moc);
            fail("should have thrown an exception");
        } catch (CvqModelException cme) {
            Assert.assertEquals("unique_meansofcontact_enabled", cme.getMessage());
        }
        
    }
    
//    // To be implemented
//    public void testNotify() throws CvqException {
//    }
    
}
