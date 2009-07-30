package fr.capwebct.modules.payment.webservice.client;

import java.util.List;

import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.Account;
import fr.capwebct.modules.payment.business.CapwebctFamilyAccount;
import fr.capwebct.modules.payment.business.CapwebctIndividual;
import fr.capwebct.modules.payment.business.Contract;
import fr.capwebct.modules.payment.business.ExternalFamilyAccount;
import fr.capwebct.modules.payment.business.ExternalIndividual;
import fr.capwebct.modules.payment.business.Invoice;
import fr.capwebct.modules.payment.business.Payment;
import fr.capwebct.modules.payment.business.ws.AccountUpdate;
import fr.capwebct.modules.payment.business.ws.ContractUpdate;
import fr.capwebct.modules.payment.business.ws.FamilyAccount;
import fr.capwebct.modules.payment.business.ws.InvoiceUpdate;
import fr.capwebct.modules.payment.business.ws.PaymentTransaction;
import fr.capwebct.modules.payment.exception.CpmBusinessException;
import fr.capwebct.modules.payment.schema.acc.AccountDetailType;
import fr.capwebct.modules.payment.schema.acc.AccountDetailsDocument;
import fr.capwebct.modules.payment.schema.acc.AccountDetailsRequestDocument;
import fr.capwebct.modules.payment.schema.acc.AccountDetailsDocument.AccountDetails;
import fr.capwebct.modules.payment.schema.acc.AccountDetailsRequestDocument.AccountDetailsRequest;
import fr.capwebct.modules.payment.schema.fam.FamilyDocument;
import fr.capwebct.modules.payment.schema.inv.InvoiceDetailType;
import fr.capwebct.modules.payment.schema.inv.InvoiceDetailsDocument;
import fr.capwebct.modules.payment.schema.inv.InvoiceDetailsRequestDocument;
import fr.capwebct.modules.payment.schema.inv.InvoiceDetailsDocument.InvoiceDetails;
import fr.capwebct.modules.payment.schema.inv.InvoiceDetailsRequestDocument.InvoiceDetailsRequest;
import fr.capwebct.modules.payment.testtool.BusinessObjectsFactory;
import fr.capwebct.modules.payment.testtool.ServiceTestCase;

/*
 * This class tests a Spring WS Client. It needs for running, that Server Application is started
 * See 'spring-ws-servlet.xml' for Client's configuration.
 */
public class WebServiceClientTest extends ServiceTestCase {

    public void testInvoiceSendAndRecieve() {
        ExternalFamilyAccount externalFamilyAccount =
            familyAccountService.createExternalFamilyAccount(
            BusinessObjectsFactory.gimmeExternalFamilyAccount("FAMILY_1"));
        List<Invoice> invoiceList = 
            BusinessObjectsFactory.gimmeTenInvoices("invoice", externalFamilyAccount);
        try {
            invoiceService.saveInvoices(invoiceList);
            Invoice sourceInvoice = invoiceList.get(0);
            
            InvoiceDetailsRequestDocument invoiceDetailsRequestDocument = 
                InvoiceDetailsRequestDocument.Factory.newInstance();
            InvoiceDetailsRequest invoiceDetailsRequest =
                invoiceDetailsRequestDocument.addNewInvoiceDetailsRequest();
            invoiceDetailsRequest.setInvoiceId(sourceInvoice.getInvoiceId());
            ExternalFamilyAccount efa = sourceInvoice.getExternalFamilyAccount();
            invoiceDetailsRequest.setExternalApplicationId(efa.getExternalApplication().getId());
            invoiceDetailsRequest.setExternalApplicationId(efa.getExternalApplication().getId());
            invoiceDetailsRequest.setExternalFamilyAccountId(efa.getExternalFamilyAccountId());
            
            InvoiceDetailsDocument invoiceDetailsDocument = 
                (InvoiceDetailsDocument) 
                    webServiceClient.invoiceDetailsSendAndRecieve(invoiceDetailsRequestDocument);

            InvoiceDetails invoiceDetails = invoiceDetailsDocument.getInvoiceDetails();
            assertEquals(invoiceDetails.getInvoiceId(), sourceInvoice.getInvoiceId());
            assertEquals(efa.getExternalApplication().getId(), 
                    invoiceDetails.getExternalApplicationId());
            assertEquals(efa.getExternalApplication().getId(), 
                    invoiceDetails.getExternalApplicationId());
            assertEquals(efa.getExternalFamilyAccountId(),
                    invoiceDetails.getExternalFamilyAccountId());
            InvoiceDetailType[] invoiceDetailArray = invoiceDetails.getInvoiceDetailArray();
            assertEquals(10, invoiceDetailArray.length);
            
        } catch (Exception e) {
            e.printStackTrace();
            assertNull(e);
        } finally {
            // Delete localy testing data
            invoiceService.deleteInvoices(invoiceList);
        }
    }
    
    public void testAccountSendAndRecieve() {
        ExternalFamilyAccount externalFamilyAccount =
            familyAccountService.createExternalFamilyAccount(
            BusinessObjectsFactory.gimmeExternalFamilyAccount("FAMILY_1"));
        List<Account> accountList = 
            BusinessObjectsFactory.gimmeTenAccounts("account", externalFamilyAccount);
        try {
            accountService.saveAccounts(accountList);
            Account sourceAccount = accountList.get(0);
            
            AccountDetailsRequestDocument accountDetailsRequestDocument = 
                AccountDetailsRequestDocument.Factory.newInstance();
            AccountDetailsRequest accountDetailsRequest = 
                accountDetailsRequestDocument.addNewAccountDetailsRequest();
            accountDetailsRequest.setAccountId(sourceAccount.getAccountId());
            ExternalFamilyAccount efa = sourceAccount.getExternalFamilyAccount();
            accountDetailsRequest.setExternalApplicationId(efa.getExternalApplication().getId());
            accountDetailsRequest.setExternalApplicationId(efa.getExternalApplication().getId());
            accountDetailsRequest.setExternalFamilyAccountId(efa.getExternalFamilyAccountId());
            
            AccountDetailsDocument accountDetailsDocument = 
                (AccountDetailsDocument) 
                    webServiceClient.accountDetailsSendAndRecieve(accountDetailsRequestDocument);

            AccountDetails accountDetails = accountDetailsDocument.getAccountDetails();
            assertEquals(sourceAccount.getAccountId(), accountDetails.getAccountId());
            assertEquals(efa.getExternalApplication().getId(), 
                    accountDetails.getExternalApplicationId());
            assertEquals(efa.getExternalApplication().getId(), 
                    accountDetails.getExternalApplicationId());
            assertEquals(efa.getExternalFamilyAccountId(),
                    accountDetails.getExternalFamilyAccountId());
            AccountDetailType[] accountDetailArray = accountDetails.getAccountDetailArray();
            assertEquals(10, accountDetailArray.length);
            
        } catch (Exception e) {
            e.printStackTrace();
            assertNull(e);
        } finally {
            // Delete localy testing data
            accountService.deleteAccounts(accountList);
        }
    }
    
    public void testFamilyAccountSendAndRecieve() {
        ExternalFamilyAccount externalFamilyAccount =
            familyAccountService.createExternalFamilyAccount(
            BusinessObjectsFactory.gimmeExternalFamilyAccount("FAMILY_1"));
        ExternalIndividual externalIndividual = new ExternalIndividual();
        externalIndividual.setExternalIndividualId("IND_FAMILY_1");
        externalIndividual.setFirstName("John");
        externalIndividual.setLastName("DOE");
        familyAccountService.addExternalIndividual(externalFamilyAccount, externalIndividual);
        ExternalIndividual externalIndividual2 = new ExternalIndividual();
        externalIndividual2.setExternalIndividualId("IND_FAMILY_1");
        externalIndividual2.setFirstName("John");
        externalIndividual2.setLastName("DOE");
        familyAccountService.addExternalIndividual(externalFamilyAccount, externalIndividual2);

        List<Invoice> invoiceList = 
            BusinessObjectsFactory.gimmeTenInvoices("family", externalFamilyAccount);
        List<Account> accoutList = 
            BusinessObjectsFactory.gimmeTenAccounts("family", externalFamilyAccount);
        List<Contract> contractList = 
            BusinessObjectsFactory.gimmeTenContracts("family", externalFamilyAccount);
        
        CapwebctFamilyAccount capwebctFamilyAccount = 
            BusinessObjectsFactory.gimmeCapwebctFamilyAccount(10);
        CapwebctIndividual capwebctIndividual = 
            BusinessObjectsFactory.gimmeCapwebctIndividual("capwebct_ind_1",101);
        CapwebctIndividual capwebctIndividual2 = 
            BusinessObjectsFactory.gimmeCapwebctIndividual("capwebct_ind_2",102);
        
        try {
            familyAccountService.addCapwebctIndividual(capwebctFamilyAccount, capwebctIndividual);
            familyAccountService.addCapwebctIndividual(capwebctFamilyAccount, capwebctIndividual2);
        
            // Bindings 
            familyAccountService.bindFamilyAccounts(
                externalFamilyAccount.getExternalFamilyAccountId(),
                externalApplication.getId(),
                capwebctFamilyAccount.getCapwebctFamilyAccountId());
            familyAccountService.bindIndividuals(
                externalFamilyAccount, externalIndividual.getExternalIndividualId(),
                capwebctFamilyAccount, capwebctIndividual.getCapwebctIndividualId());
            familyAccountService.bindIndividuals(
                externalFamilyAccount, externalIndividual2.getExternalIndividualId(),
                capwebctFamilyAccount, capwebctIndividual2.getCapwebctIndividualId());
        
            // Persist Invoices and Account
            invoiceService.saveInvoices(invoiceList);
            accountService.saveAccounts(accoutList);
            contractService.saveContracts(contractList);
            
            // Construct XmlObject (cf Xmlbean) to Marshal it in request Payload
            FamilyAccount sourceFamilyAccount = new FamilyAccount();
            sourceFamilyAccount.setCapwebctFamilyAccountId(10);
            FamilyDocument familyDocument = FamilyAccount.modelToXml(sourceFamilyAccount);
            
            FamilyDocument familyDocumentResult = 
                (FamilyDocument) webServiceClient.familyAccountsSendAndRecieve(familyDocument);
            
            assertEquals(10, familyDocumentResult.getFamily().getAccounts().sizeOfAccountArray());
            assertEquals(10, familyDocumentResult.getFamily().getInvoices().sizeOfInvoiceArray());
            assertEquals(10, familyDocumentResult.getFamily().getContracts().sizeOfContractArray());
            
        } catch (Exception e) {
            e.printStackTrace();
            assertNull(e);
        } finally {
            // Delete localy testing data
            deleteData(true,true,true);
        }
    }
    
    public void testCreditAccountSendAndRecieve() {
        ExternalFamilyAccount externalFamilyAccount =
            familyAccountService.createExternalFamilyAccount(
            BusinessObjectsFactory.gimmeExternalFamilyAccount("FAMILY_1"));
        ExternalIndividual externalIndividual = new ExternalIndividual();
        externalIndividual.setExternalIndividualId("IND_FAMILY_1");
        externalIndividual.setFirstName("John");
        externalIndividual.setLastName("DOE");
        familyAccountService.addExternalIndividual(externalFamilyAccount, externalIndividual);

        Payment payment = BusinessObjectsFactory.gimmePayment("payment", 10);

        List<Invoice> invoices = 
            BusinessObjectsFactory.gimmeTenInvoices("invoice", externalFamilyAccount);
        Invoice invoice = invoices.get(1);
        InvoiceUpdate invoiceUpdate = BusinessObjectsFactory.gimmeInvoiceUpdate(invoice);

        List<Account> accounts = 
            BusinessObjectsFactory.gimmeTenAccounts("accounts", externalFamilyAccount);
        Account account = accounts.get(1);
        AccountUpdate accountUpdate = BusinessObjectsFactory.gimmeAccountUpdate(accounts.get(1));
        accountUpdate.setAccountNewValue(accounts.get(1).getAccountValue() + 100);

        List<Contract> contracts = 
            BusinessObjectsFactory.gimmeTenContracts("child_account", externalFamilyAccount);
        Contract contract = contracts.get(1);
        ContractUpdate contractUpdate = BusinessObjectsFactory.gimmeContractUpdate(contract);
        contractUpdate.setContractId(contract.getContractId());

        PaymentTransaction paymentTransaction = 
            BusinessObjectsFactory.gimmePaymentTransaction(accountUpdate, contractUpdate, 
                    invoiceUpdate, payment);
        try {
            invoiceService.saveInvoices(invoices);
            accountService.saveAccounts(accounts);
            contractService.saveContracts(contracts);
            
            webServiceClient.creditAccountSendAndRecieve(PaymentTransaction.modelToXml(paymentTransaction));
            
            // Reference to Payùent is lost in marshalling step => we load payments
            List<Payment> payments = paymentService.getAllPayments();
            
            assertEquals(payments.size(), 1);
            
            invoice = invoiceService.getInvoice(invoice.getId(), true);
            assertEquals(invoice.getPayment(), payments.get(0));
            assertEquals(invoice.isInvoicePayed(), true);
            
            Account updatedAccount = accountService.getAccount(account.getId(), true);
            assertEquals(account.getAccountDetailList().size(), 
                    updatedAccount.getAccountDetailList().size() - 1);
            
            Contract updatedContract = contractService.getContract(contract.getId(), true);
            assertEquals(updatedContract.getContractDetailList().size(), 1);
        } catch (DataAccessException e) {
            assertNull(e);
        } catch (CpmBusinessException cpe) {
            assertNull(cpe);
        } finally {
            accountService.deleteAllAccounts();
            contractService.deleteAllContracts();
            invoiceService.deleteAllInvoices();
            paymentService.deleteAllPayments();
        }
    }
}
