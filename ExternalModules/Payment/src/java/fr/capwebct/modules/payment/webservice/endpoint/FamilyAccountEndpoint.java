package fr.capwebct.modules.payment.webservice.endpoint;

import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.oxm.Marshaller;
import org.springframework.ws.server.endpoint.AbstractMarshallingPayloadEndpoint;

import fr.capwebct.modules.payment.business.Account;
import fr.capwebct.modules.payment.business.Contract;
import fr.capwebct.modules.payment.business.ExternalFamilyAccount;
import fr.capwebct.modules.payment.business.Invoice;
import fr.capwebct.modules.payment.business.ws.FamilyAccount;
import fr.capwebct.modules.payment.schema.fam.FamilyAccountsRequestDocument;
import fr.capwebct.modules.payment.schema.fam.FamilyDocument;
import fr.capwebct.modules.payment.service.IAccountService;
import fr.capwebct.modules.payment.service.IContractService;
import fr.capwebct.modules.payment.service.IFamilyAccountService;
import fr.capwebct.modules.payment.service.IInvoiceService;

/**
 * WS endpoint for retrieval of family accounts data.
 */
public class FamilyAccountEndpoint extends AbstractMarshallingPayloadEndpoint {

    private final IFamilyAccountService familyAccountService;
    private final IInvoiceService invoiceService;
    private final IAccountService accountService;
    private final IContractService contractService;

    public FamilyAccountEndpoint(Marshaller marshaller, 
            IFamilyAccountService familyAccountService, IInvoiceService invoiceService,
            IAccountService accountService, IContractService contractService) {
        super(marshaller);
        this.familyAccountService = familyAccountService;
        this.invoiceService = invoiceService;
        this.accountService = accountService;
        this.contractService = contractService;
    }

    @Override
    protected Object invokeInternal(Object requestObject) throws Exception {
        FamilyAccountsRequestDocument farDocument =
            (FamilyAccountsRequestDocument) requestObject;
        
        long homeFolderId = farDocument.getFamilyAccountsRequest().getHomeFolderId();
        FamilyAccount familyAccount = new FamilyAccount();
        familyAccount.setCapwebctFamilyAccountId(homeFolderId);
        List<ExternalFamilyAccount> efaList = 
            familyAccountService.getByCapWebctFamilyAccountId(homeFolderId);
        for (ExternalFamilyAccount efa : efaList) {
            String efaId = efa.getExternalFamilyAccountId();
            long externalApplicationId = efa.getExternalApplication().getId();
            List<Account> accounts = accountService.getByExternalId(efaId, externalApplicationId);
            familyAccount.addAccounts(new LinkedHashSet<Account>(accounts));
            List<Contract> contracts = 
                contractService.getByExternalId(efaId, externalApplicationId, null);
            familyAccount.addContracts(new LinkedHashSet<Contract>(contracts));
            List<Invoice> invoices = invoiceService.getByExternalId(efaId, externalApplicationId);
            familyAccount.addInvoices(new LinkedHashSet<Invoice>(invoices));
        }
        
        FamilyDocument familyDocument = FamilyAccount.modelToXml(familyAccount);
        
        return familyDocument;
    }
}
