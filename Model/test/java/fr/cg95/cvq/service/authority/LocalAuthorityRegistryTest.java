package fr.cg95.cvq.service.authority;

import java.util.TreeSet;

import fr.cg95.cvq.business.authority.LocalAuthority;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.testtool.ServiceTestCase;

/**
 * The tests for the local authority registry
 * 
 * @author jsb@zenexity.fr
 */
public class LocalAuthorityRegistryTest extends ServiceTestCase {

    public void testGetLocalAuthorityByServerName()
        throws CvqException {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        LocalAuthority la = SecurityContext.getCurrentSite();
        assertEquals(la.getServerNames().size(), 1);

        String oldServerName = la.getServerNames().first();
        TreeSet<String> serverNames = new TreeSet<String>();
        serverNames.add(oldServerName + "new");

        iLocalAuthorityRegistry.setLocalAuthorityServerNames(serverNames);
        continueWithNewTransaction();
        assertEquals(la.getServerNames().size(), 1);
        assertEquals(iLocalAuthorityRegistry.getLocalAuthorityByServerName(oldServerName + "new").getId().longValue(), SecurityContext.getCurrentSite().getId().longValue());
        assertNull(iLocalAuthorityRegistry.getLocalAuthorityByServerName(oldServerName));
        iLocalAuthorityRegistry.addLocalAuthorityServerName(oldServerName);
        iLocalAuthorityRegistry.removeLocalAuthorityServerName(oldServerName + "new");
    }

    public void testAddLocalAuthorityServerName()
        throws CvqException {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        LocalAuthority la = SecurityContext.getCurrentSite();
        assertEquals(la.getServerNames().size(), 1);

        iLocalAuthorityRegistry.addLocalAuthorityServerName("sn2");
        continueWithNewTransaction();
        assertEquals(la.getServerNames().size(), 2);
        assertEquals(iLocalAuthorityRegistry.getLocalAuthorityByServerName("sn2").getId().longValue(), SecurityContext.getCurrentSite().getId().longValue());
        iLocalAuthorityRegistry.removeLocalAuthorityServerName("sn2");
    }

    public void testRegisterLocalAuthorityServerName()
        throws CvqException {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        LocalAuthority la = SecurityContext.getCurrentSite();
        assertEquals(la.getServerNames().size(), 1);

        iLocalAuthorityRegistry.registerLocalAuthorityServerName("sn3");
        continueWithNewTransaction();
        assertEquals(la.getServerNames().size(), 1);
        assertEquals(iLocalAuthorityRegistry.getLocalAuthorityByServerName("sn3").getId().longValue(), SecurityContext.getCurrentSite().getId().longValue());
        iLocalAuthorityRegistry.unregisterLocalAuthorityServerName("sn3");
    }

    public void testRemoveLocalAuthorityServerName()
        throws CvqException {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        LocalAuthority la = SecurityContext.getCurrentSite();
        assertEquals(la.getServerNames().size(), 1);

        String oldServerName = la.getServerNames().first();
        iLocalAuthorityRegistry.removeLocalAuthorityServerName(oldServerName);
        continueWithNewTransaction();
        assertEquals(la.getServerNames().size(), 0);
        assertNull(iLocalAuthorityRegistry.getLocalAuthorityByServerName(oldServerName));
        iLocalAuthorityRegistry.addLocalAuthorityServerName(oldServerName);
    }

    public void testUnregisterLocalAuthorityServerName()
        throws CvqException {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        LocalAuthority la = SecurityContext.getCurrentSite();
        assertEquals(la.getServerNames().size(), 1);

        iLocalAuthorityRegistry.unregisterLocalAuthorityServerName(la.getServerNames().first());
        continueWithNewTransaction();
        assertEquals(la.getServerNames().size(), 1);
        assertNull(iLocalAuthorityRegistry.getLocalAuthorityByServerName(la.getServerNames().first()));
        iLocalAuthorityRegistry.registerLocalAuthorityServerName(la.getServerNames().first());
    }

    public void testIsAvailableLocalAuthorityServerName()
        throws CvqException{
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        LocalAuthority la = SecurityContext.getCurrentSite();
        assertEquals(la.getServerNames().size(), 1);

        String serverName = la.getServerNames().first();
        assertTrue(iLocalAuthorityRegistry.isAvailableLocalAuthorityServerName(serverName));
        assertTrue(iLocalAuthorityRegistry.isAvailableLocalAuthorityServerName(serverName + "inexistent"));
        SecurityContext.setCurrentSite(localAuthorityName + "2", SecurityContext.BACK_OFFICE_CONTEXT);
        iLocalAuthorityRegistry.registerLocalAuthorityServerName(serverName + "existent");
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        continueWithNewTransaction();
        assertFalse(iLocalAuthorityRegistry.isAvailableLocalAuthorityServerName(serverName + "existent"));
        SecurityContext.setCurrentSite(localAuthorityName + "2", SecurityContext.BACK_OFFICE_CONTEXT);
        iLocalAuthorityRegistry.unregisterLocalAuthorityServerName(serverName + "existent");
    }

    public void testSetLocalAuthorityServerNames()
        throws CvqException{
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        LocalAuthority la = SecurityContext.getCurrentSite();
        assertEquals(la.getServerNames().size(), 1);

        String oldServerName = la.getServerNames().first();
        TreeSet<String> newServerNames = new TreeSet<String>();
        newServerNames.add(oldServerName + "bis");
        newServerNames.add(oldServerName + "ter");
        iLocalAuthorityRegistry.setLocalAuthorityServerNames(newServerNames);
        continueWithNewTransaction();
        assertEquals(la.getServerNames().size(), 2);
        for (String serverName : newServerNames) {
            assertEquals(iLocalAuthorityRegistry.getLocalAuthorityByServerName(serverName).getId().longValue(), SecurityContext.getCurrentSite().getId().longValue());
        }
        assertNull(iLocalAuthorityRegistry.getLocalAuthorityByServerName(oldServerName));
        newServerNames = new TreeSet<String>();
        newServerNames.add(oldServerName);
        iLocalAuthorityRegistry.setLocalAuthorityServerNames(newServerNames);
    }
}
