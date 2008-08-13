package fr.capwebct.modules.payment.webservice.endpoint;

import fr.capwebct.modules.payment.schema.fam.AccountType;
import fr.capwebct.modules.payment.schema.fam.ContractType;
import fr.capwebct.modules.payment.schema.fam.FamilyAccountsRequestDocument;
import fr.capwebct.modules.payment.schema.fam.FamilyDocument;
import fr.capwebct.modules.payment.schema.fam.IndividualContractType;
import fr.capwebct.modules.payment.schema.fam.InvoiceType;
import fr.capwebct.modules.payment.schema.fam.FamilyAccountsRequestDocument.FamilyAccountsRequest;
import fr.capwebct.modules.payment.schema.fam.FamilyDocument.Family;

public class FamilyAccountEndpointTest extends EndpointServiceTestCase {

    private FamilyAccountEndpoint familyAccountEndpoint;
    
    protected void onSetUp() throws Exception {
        super.onSetUp();
        
        familyAccountEndpoint = 
            new FamilyAccountEndpoint(marshaller, familyAccountService, invoiceService, 
                accountService, contractService);
    }
    
    public void testNonExistingFamilyAccount() throws Exception {
        
        FamilyAccountsRequestDocument farDocument = 
            FamilyAccountsRequestDocument.Factory.newInstance();
        FamilyAccountsRequest far = farDocument.addNewFamilyAccountsRequest();
        far.setHomeFolderId(10);
        far.setLocalAuthority("valdoise");
        
        FamilyDocument familyDocument = 
            (FamilyDocument) familyAccountEndpoint.invokeInternal(farDocument);
        Family family = familyDocument.getFamily();
        assertEquals(10, family.getId());
        assertEquals(null, family.getAccounts());
        assertEquals(null, family.getContracts());
        assertEquals(null, family.getInvoices());
    }
    
    public void testExistingFamilyAccount() throws Exception {

        createAccounts();
        
        FamilyAccountsRequestDocument farDocument = 
            FamilyAccountsRequestDocument.Factory.newInstance();
        FamilyAccountsRequest far = farDocument.addNewFamilyAccountsRequest();
        far.setHomeFolderId(22);
        far.setLocalAuthority("valdoise");
        
        FamilyDocument familyDocument = 
            (FamilyDocument) familyAccountEndpoint.invokeInternal(farDocument);
        Family family = familyDocument.getFamily();
        assertEquals(22, family.getId());
        
        assertEquals(10, family.getAccounts().sizeOfAccountArray());
        AccountType accountType = family.getAccounts().getAccountArray(0);
        assertEquals(externalApplication.getId(), accountType.getExternalApplicationId());
        assertEquals(externalApplication.getLabel(), accountType.getExternalApplicationLabel());
        assertEquals("FAMILY_1", accountType.getExternalFamilyAccountId());
        assertEquals("FAMILY", accountType.getAccountLabel());
        assertNotNull(accountType.getAccountDate());
        assertNotNull(accountType.getAccountId());
        assertNotSame(0, accountType.getAccountValue());
        
        assertEquals(1, family.getContracts().sizeOfContractArray());
        IndividualContractType indContractType = family.getContracts().getContractArray(0);
        assertEquals(23, indContractType.getCapwebctIndividualId());
        assertEquals(10, indContractType.getContractArray().length);
        ContractType contractType = indContractType.getContractArray(0);
        assertEquals(externalApplication.getId(), contractType.getExternalApplicationId());
        assertEquals(externalApplication.getLabel(), contractType.getExternalApplicationLabel());
        assertEquals("FAMILY_1", contractType.getExternalFamilyAccountId());
        assertEquals("FAMILY", contractType.getContractLabel());
        assertNotNull(contractType.getContractDate());
        assertNotNull(contractType.getContractId());
        assertNotSame(0, contractType.getContractValue());
        assertEquals("IND_1_individuall_id", contractType.getExternalIndividualId());
        
        assertEquals(10, family.getInvoices().sizeOfInvoiceArray());
        InvoiceType invoiceType = family.getInvoices().getInvoiceArray(0);
        assertEquals(externalApplication.getId(), invoiceType.getExternalApplicationId());
        assertEquals(externalApplication.getLabel(), invoiceType.getExternalApplicationLabel());
        assertEquals("FAMILY_1", invoiceType.getExternalFamilyAccountId());
        assertEquals("FAMILY", invoiceType.getInvoiceLabel());
        assertNotNull(invoiceType.getInvoiceDate());
        assertNotNull(invoiceType.getInvoiceId());
        assertNotSame(0, invoiceType.getInvoiceValue());
        
    }
}
