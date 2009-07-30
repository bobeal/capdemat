package fr.capwebct.modules.payment.webservice.endpoint;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.oxm.Marshaller;

import fr.capwebct.modules.payment.business.CapwebctFamilyAccount;
import fr.capwebct.modules.payment.business.CapwebctIndividual;
import fr.capwebct.modules.payment.business.ExternalFamilyAccount;
import fr.capwebct.modules.payment.business.ExternalIndividual;
import fr.capwebct.modules.payment.testtool.BusinessObjectsFactory;
import fr.capwebct.modules.payment.testtool.ServiceTestCase;

public class EndpointServiceTestCase extends ServiceTestCase {

    protected Marshaller marshaller;
    
    protected void onSetUp() throws Exception {
        super.onSetUp();
        
        ConfigurableApplicationContext cac = getContext(getConfigLocations());
        marshaller = (Marshaller) cac.getBean("xmlBeanMarshaller");
    }
    
    protected void createAccounts() throws Exception {
        ExternalFamilyAccount externalFamilyAccount =
            familyAccountService.createExternalFamilyAccount(
            BusinessObjectsFactory.gimmeExternalFamilyAccount("FAMILY_1"));
        ExternalIndividual externalIndividual = 
            BusinessObjectsFactory.gimmeExternalIndividual("IND_1", "External Individual");
        familyAccountService.addExternalIndividual(externalFamilyAccount, externalIndividual);
        invoiceService.saveInvoices(BusinessObjectsFactory.gimmeTenInvoices("FAMILY", 
                externalFamilyAccount));
        accountService.saveAccounts(BusinessObjectsFactory.gimmeTenAccounts("FAMILY", 
                externalFamilyAccount));
        contractService.saveContracts(BusinessObjectsFactory.gimmeTenContracts("FAMILY", 
                externalFamilyAccount));
        CapwebctFamilyAccount capwebctFamilyAccount = 
            BusinessObjectsFactory.gimmeCapwebctFamilyAccount(22);
        CapwebctIndividual capwebctIndividual = 
            BusinessObjectsFactory.gimmeCapwebctIndividual("CAP_IND_1", 23);
        capwebctFamilyAccount.addIndividual(capwebctIndividual);
        familyAccountService.bindFamilyAccounts("FAMILY_1", externalApplication.getId(), 
                capwebctFamilyAccount.getCapwebctFamilyAccountId());
        familyAccountService.bindIndividuals(
            externalFamilyAccount, externalIndividual.getExternalIndividualId(),
            capwebctFamilyAccount, capwebctIndividual.getCapwebctIndividualId());
    }
}
