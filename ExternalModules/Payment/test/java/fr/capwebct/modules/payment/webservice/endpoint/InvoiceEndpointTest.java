package fr.capwebct.modules.payment.webservice.endpoint;

import fr.capwebct.modules.payment.schema.fam.FamilyAccountsRequestDocument;
import fr.capwebct.modules.payment.schema.fam.FamilyDocument;
import fr.capwebct.modules.payment.schema.fam.InvoiceType;
import fr.capwebct.modules.payment.schema.fam.FamilyAccountsRequestDocument.FamilyAccountsRequest;
import fr.capwebct.modules.payment.schema.fam.FamilyDocument.Family;
import fr.capwebct.modules.payment.schema.inv.InvoiceDetailsDocument;
import fr.capwebct.modules.payment.schema.inv.InvoiceDetailsRequestDocument;
import fr.capwebct.modules.payment.schema.inv.InvoiceDetailsDocument.InvoiceDetails;
import fr.capwebct.modules.payment.schema.inv.InvoiceDetailsRequestDocument.InvoiceDetailsRequest;

public class InvoiceEndpointTest extends EndpointServiceTestCase {
    
    private FamilyAccountEndpoint familyAccountEndpoint;
    private InvoiceEndpoint invoiceEndpoint;
    
    protected void onSetUp() throws Exception {
        super.onSetUp();
        
        familyAccountEndpoint = 
            new FamilyAccountEndpoint(marshaller, familyAccountService, invoiceService, 
                accountService, contractService);
        invoiceEndpoint = new InvoiceEndpoint(marshaller, invoiceService);
    }
    
    public void testNonExistingInvoice() throws Exception {
        
        InvoiceDetailsRequestDocument invoiceDetailsRequestDocument =
            InvoiceDetailsRequestDocument.Factory.newInstance();
        InvoiceDetailsRequest invoiceDetailsRequest = 
            invoiceDetailsRequestDocument.addNewInvoiceDetailsRequest();
        invoiceDetailsRequest.setInvoiceId("BLOP");
        invoiceDetailsRequest.setExternalFamilyAccountId("BLIP");
        invoiceDetailsRequest.setExternalApplicationId(0);
        
        InvoiceDetailsDocument invoiceDetailsDocument =
            (InvoiceDetailsDocument) invoiceEndpoint.invokeInternal(invoiceDetailsRequestDocument);
        InvoiceDetails invoiceDetails = invoiceDetailsDocument.getInvoiceDetails();
        assertEquals(0, invoiceDetails.getInvoiceDetailArray().length);
    }

    public void testExistingInvoice() throws Exception {
        
        createAccounts();

        // retrieve an account first
        FamilyAccountsRequestDocument farDocument = 
            FamilyAccountsRequestDocument.Factory.newInstance();
        FamilyAccountsRequest far = farDocument.addNewFamilyAccountsRequest();
        far.setHomeFolderId(22);
        far.setLocalAuthority("valdoise");
        
        FamilyDocument familyDocument = 
            (FamilyDocument) familyAccountEndpoint.invokeInternal(farDocument);
        Family family = familyDocument.getFamily();
        InvoiceType invoiceType = family.getInvoices().getInvoiceArray(0);

        // then ask for its details
        InvoiceDetailsRequestDocument invoiceDetailsRequestDocument =
            InvoiceDetailsRequestDocument.Factory.newInstance();
        InvoiceDetailsRequest invoiceDetailsRequest = 
            invoiceDetailsRequestDocument.addNewInvoiceDetailsRequest();
        invoiceDetailsRequest.setInvoiceId(invoiceType.getInvoiceId());
        invoiceDetailsRequest.setExternalFamilyAccountId("FAMILY_1");
        invoiceDetailsRequest.setExternalApplicationId(externalApplication.getId());
        
        InvoiceDetailsDocument invoiceDetailsDocument =
            (InvoiceDetailsDocument) invoiceEndpoint.invokeInternal(invoiceDetailsRequestDocument);
        InvoiceDetails invoiceDetails = invoiceDetailsDocument.getInvoiceDetails();
        assertEquals(externalApplication.getId(), invoiceDetails.getExternalApplicationId());
        assertEquals("FAMILY_1", invoiceDetails.getExternalFamilyAccountId());
        assertEquals(invoiceType.getInvoiceId(), invoiceDetails.getInvoiceId());
        assertEquals(10, invoiceDetails.getInvoiceDetailArray().length);
    }
}
