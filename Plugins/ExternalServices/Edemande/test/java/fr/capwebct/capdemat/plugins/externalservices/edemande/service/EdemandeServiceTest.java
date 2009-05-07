package fr.capwebct.capdemat.plugins.externalservices.edemande.service;

import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.testtool.ServiceTestCase;

public class EdemandeServiceTest extends ServiceTestCase {

    private IExternalProviderService externalProviderService;

    protected void onSetUp() throws Exception {
        super.onSetUp();
        externalProviderService = getApplicationBean("edemandeExternalService");
    }
    
    public void testChargerTypeDemande() throws Exception {
        externalProviderService.sendRequest(null);
    }
}

