package fr.capwebct.modules.payment.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.capwebct.modules.payment.business.ExternalApplication;
import fr.capwebct.modules.payment.exception.CpmBusinessException;
import fr.capwebct.modules.payment.testtool.ServiceTestCase;

public class ExternalApplicationServiceTest extends ServiceTestCase {

    public void testCreate() {
        
        List<ExternalApplication> allExternalApplications = externalApplicationService.getAll();
        assertEquals(1, allExternalApplications.size());
        
        Set<String> brokers = new HashSet<String>();
        brokers.add("Régie 1");
        brokers.add("Régie 2");
        ExternalApplication externalApplication = null;
        try {
            externalApplication = 
                externalApplicationService.create("Appli Ext 1", "Gestion Cantine", brokers);
        } catch (CpmBusinessException e) {
            fail("external application creation failed");
        }
        assertNotNull(externalApplication.getId());
        assertEquals("Appli Ext 1", externalApplication.getLabel());
        assertEquals("Gestion Cantine", externalApplication.getDescription());
        assertNotNull(externalApplication.getBrokers());
        assertEquals(2, externalApplication.getBrokers().size());
        
        allExternalApplications = externalApplicationService.getAll();
        assertEquals(2, allExternalApplications.size());
        
        try {
            externalApplicationService.create("Appli Ext 1", "Gestion de la cantine", brokers);
            fail("should have thrown an exception");
        } catch (CpmBusinessException e) {
            // this is expected
        }
                
        long externalApplicationId = externalApplication.getId();
        externalApplicationService.addBroker(externalApplicationId, "Broker 1");
        externalApplicationService.addBroker(externalApplicationId, "Broker 2");
        
        externalApplication = externalApplicationService.getById(externalApplicationId);
        assertEquals(4, externalApplication.getBrokers().size());
        
        externalApplicationService.removeBroker(externalApplicationId, "Broker 1");
        externalApplication = externalApplicationService.getById(externalApplicationId);
        assertEquals(3, externalApplication.getBrokers().size());
        
        brokers.remove("Régie 1");
        try {
            externalApplicationService.update(externalApplicationId, "Nouvelle appli", 
                    "Gestion de tout", brokers);
        } catch (CpmBusinessException e) {
            fail("external application update failed");
        }
        externalApplication = externalApplicationService.getById(externalApplicationId);
        assertEquals("Nouvelle appli", externalApplication.getLabel());
        assertEquals("Gestion de tout", externalApplication.getDescription());
        assertNotNull(externalApplication.getBrokers());
        assertEquals(1, externalApplication.getBrokers().size());
        
        externalApplicationService.delete(externalApplicationId);
        allExternalApplications = externalApplicationService.getAll();
        assertEquals(1, allExternalApplications.size());        
    }
}
