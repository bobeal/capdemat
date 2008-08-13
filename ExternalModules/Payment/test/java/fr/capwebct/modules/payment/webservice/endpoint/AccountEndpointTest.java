package fr.capwebct.modules.payment.webservice.endpoint;

import fr.capwebct.modules.payment.schema.acc.AccountDetailsDocument;
import fr.capwebct.modules.payment.schema.acc.AccountDetailsRequestDocument;
import fr.capwebct.modules.payment.schema.acc.AccountDetailsDocument.AccountDetails;
import fr.capwebct.modules.payment.schema.acc.AccountDetailsRequestDocument.AccountDetailsRequest;
import fr.capwebct.modules.payment.schema.fam.AccountType;
import fr.capwebct.modules.payment.schema.fam.FamilyAccountsRequestDocument;
import fr.capwebct.modules.payment.schema.fam.FamilyDocument;
import fr.capwebct.modules.payment.schema.fam.FamilyAccountsRequestDocument.FamilyAccountsRequest;
import fr.capwebct.modules.payment.schema.fam.FamilyDocument.Family;

public class AccountEndpointTest extends EndpointServiceTestCase {

    private FamilyAccountEndpoint familyAccountEndpoint;
    private AccountEndpoint accountEndpoint;
    
    protected void onSetUp() throws Exception {
        super.onSetUp();
        
        familyAccountEndpoint = 
            new FamilyAccountEndpoint(marshaller, familyAccountService, invoiceService, 
                    accountService, contractService);
        accountEndpoint = new AccountEndpoint(marshaller, accountService);
    }
    
    public void testNonExistingAccount() throws Exception {
        
        AccountDetailsRequestDocument accountDetailsRequestDocument =
            AccountDetailsRequestDocument.Factory.newInstance();
        AccountDetailsRequest accountDetailsRequest = 
            accountDetailsRequestDocument.addNewAccountDetailsRequest();
        accountDetailsRequest.setAccountId("BLOP");
        accountDetailsRequest.setExternalFamilyAccountId("BLIP");
        accountDetailsRequest.setExternalApplicationId(0);
        
        AccountDetailsDocument accountDetailsDocument =
            (AccountDetailsDocument) accountEndpoint.invokeInternal(accountDetailsRequestDocument);
        AccountDetails accountDetails = accountDetailsDocument.getAccountDetails();
        assertEquals(0, accountDetails.getAccountDetailArray().length);
    }

    public void testExistingAccount() throws Exception {
        
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
        AccountType accountType = family.getAccounts().getAccountArray(0);

        // then ask for its details
        AccountDetailsRequestDocument accountDetailsRequestDocument =
            AccountDetailsRequestDocument.Factory.newInstance();
        AccountDetailsRequest accountDetailsRequest = 
            accountDetailsRequestDocument.addNewAccountDetailsRequest();
        accountDetailsRequest.setAccountId(accountType.getAccountId());
        accountDetailsRequest.setExternalFamilyAccountId("FAMILY_1");
        accountDetailsRequest.setExternalApplicationId(externalApplication.getId());
        
        AccountDetailsDocument accountDetailsDocument =
            (AccountDetailsDocument) accountEndpoint.invokeInternal(accountDetailsRequestDocument);
        AccountDetails accountDetails = accountDetailsDocument.getAccountDetails();
        assertEquals(externalApplication.getId(), accountDetails.getExternalApplicationId());
        assertEquals("FAMILY_1", accountDetails.getExternalFamilyAccountId());
        assertEquals(accountType.getAccountId(), accountDetails.getAccountId());
        assertEquals(10, accountDetails.getAccountDetailArray().length);

    }
}
