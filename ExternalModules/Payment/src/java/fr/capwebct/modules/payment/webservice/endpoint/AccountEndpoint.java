package fr.capwebct.modules.payment.webservice.endpoint;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.oxm.Marshaller;
import org.springframework.ws.server.endpoint.AbstractMarshallingPayloadEndpoint;

import fr.capwebct.modules.payment.business.AccountDetail;
import fr.capwebct.modules.payment.schema.acc.AccountDetailType;
import fr.capwebct.modules.payment.schema.acc.AccountDetailsDocument;
import fr.capwebct.modules.payment.schema.acc.AccountDetailsRequestDocument;
import fr.capwebct.modules.payment.schema.acc.AccountDetailsDocument.AccountDetails;
import fr.capwebct.modules.payment.schema.acc.AccountDetailsRequestDocument.AccountDetailsRequest;
import fr.capwebct.modules.payment.service.IAccountService;

/**
 * WS endpoint for retrieval of an account details.
 */
public class AccountEndpoint  extends AbstractMarshallingPayloadEndpoint {

    private final IAccountService accountService;

    public AccountEndpoint(Marshaller marshaller, IAccountService accountService) {
        super(marshaller);
        this.accountService = accountService;
    }

    @Override
    protected Object invokeInternal(Object requestObject) throws Exception {
        AccountDetailsRequestDocument accountDetailsRequestDocument =
            (AccountDetailsRequestDocument) requestObject;
        AccountDetailsRequest accountDetailsRequest = 
            accountDetailsRequestDocument.getAccountDetailsRequest();
       
        Date detailStartDate = null;
        if (accountDetailsRequest.getStartSearch() != null) {
            detailStartDate = accountDetailsRequest.getStartSearch().getTime();
        }
        Date detailEndDate = null;
        if (accountDetailsRequest.getEndSearch() != null) {
            detailEndDate = accountDetailsRequest.getEndSearch().getTime();
        }
        
        AccountDetailsDocument accountDetailsDocument =
            AccountDetailsDocument.Factory.newInstance();
        AccountDetails accountDetailsXml = accountDetailsDocument.addNewAccountDetails();
        accountDetailsXml.setAccountId(accountDetailsRequest.getAccountId());
        accountDetailsXml.setExternalApplicationId(accountDetailsRequest.getExternalApplicationId());
        accountDetailsXml.setExternalFamilyAccountId(accountDetailsRequest.getExternalFamilyAccountId());
        
        List<AccountDetail> accountDetails =
            accountService.getAccountDetails(accountDetailsRequest.getExternalFamilyAccountId(), 
                    accountDetailsRequest.getExternalApplicationId(), 
                    accountDetailsRequest.getAccountId(), 
                    detailStartDate, detailEndDate);
        
        if (accountDetails != null) {
            List<AccountDetailType> accountDetailTypes = new ArrayList<AccountDetailType>();
            for (AccountDetail accountDetail : accountDetails) {
                accountDetailTypes.add(AccountDetail.modelToXml(accountDetail));
            }
            accountDetailsXml.setAccountDetailArray(accountDetailTypes.toArray(new AccountDetailType[] {}));
        }
        
       return accountDetailsDocument;
    }
}
