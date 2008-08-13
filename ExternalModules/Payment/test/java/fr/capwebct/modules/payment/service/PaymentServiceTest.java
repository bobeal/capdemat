package fr.capwebct.modules.payment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.Account;
import fr.capwebct.modules.payment.business.AccountDetail;
import fr.capwebct.modules.payment.business.CapwebctFamilyAccount;
import fr.capwebct.modules.payment.business.CapwebctIndividual;
import fr.capwebct.modules.payment.business.Contract;
import fr.capwebct.modules.payment.business.ContractDetail;
import fr.capwebct.modules.payment.business.ExternalFamilyAccount;
import fr.capwebct.modules.payment.business.ExternalIndividual;
import fr.capwebct.modules.payment.business.Invoice;
import fr.capwebct.modules.payment.business.Payment;
import fr.capwebct.modules.payment.business.ws.AccountUpdate;
import fr.capwebct.modules.payment.business.ws.ContractUpdate;
import fr.capwebct.modules.payment.business.ws.InvoiceUpdate;
import fr.capwebct.modules.payment.business.ws.PaymentTransaction;
import fr.capwebct.modules.payment.exception.CpmBusinessException;
import fr.capwebct.modules.payment.testtool.BusinessObjectsFactory;
import fr.capwebct.modules.payment.testtool.ServiceTestCase;

public class PaymentServiceTest extends ServiceTestCase {

    public void testSaveAndLoadPayment() {
        List<Payment> payments = BusinessObjectsFactory.gimmeTenPayments("payment");
        try {
            for (Payment payment : payments)
                paymentService.savePayment(payment);

            Payment payment1 = paymentService.getByPaymentAck(payments.get(1).getPaymentAck());
            assertEquals(payment1, payments.get(1));

            List fetchList = paymentService.getAllPayments();
            assertEquals(fetchList.size(), payments.size());

        } catch (DataAccessException e) {
            assertNull(e);
        } finally {
            paymentService.deleteAllPayments();
        }
    }

    public void testPayInvoice() {
        ExternalFamilyAccount externalFamilyAccount = 
            familyAccountService.createExternalFamilyAccount("FAMILY_1", externalApplication.getId());
        List<Invoice> invoices = 
            BusinessObjectsFactory.gimmeTenInvoices("invoice", externalFamilyAccount);
        Invoice invoice = invoices.get(1);
        Payment payment = BusinessObjectsFactory.gimmePayment("payment", 10);
        InvoiceUpdate invoiceUpdate = BusinessObjectsFactory.gimmeInvoiceUpdate(invoice);
        PaymentTransaction paymentTransaction = new PaymentTransaction();
        paymentTransaction.setPayment(payment);
        List<InvoiceUpdate> invoiceUpdates = new ArrayList<InvoiceUpdate>();
        invoiceUpdates.add(invoiceUpdate);
        paymentTransaction.setInvoiceUpdates(invoiceUpdates);
        try {
            invoiceService.saveInvoices(invoices);
            paymentService.creditFamilyAccount(paymentTransaction);
            invoice = invoiceService.getInvoice(invoice.getId(), true);
            assertEquals(invoice.getPayment(), payment);
            assertEquals(invoice.isInvoicePayed(), true);
            assertEquals(paymentService.getAllPayments().size(), 1);
        } catch (DataAccessException e) {
            assertNull(e);
        } catch (CpmBusinessException cpe) {
            cpe.printStackTrace();
            assertNull(cpe);
        } finally {
            invoiceService.deleteAllInvoices();
            paymentService.deleteAllPayments();
        }
    }

    public void testCreditAccount() {
        ExternalFamilyAccount externalFamilyAccount = 
            familyAccountService.createExternalFamilyAccount("FAMILY_1", externalApplication.getId());
        List<Account> accounts = 
            BusinessObjectsFactory.gimmeTenAccounts("accounts", externalFamilyAccount);
        Account account = accounts.get(1);
        Payment payment = BusinessObjectsFactory.gimmePayment("payment", 10);
        PaymentTransaction paymentTransaction = new PaymentTransaction();
        paymentTransaction.setPayment(payment);
        AccountUpdate accountUpdate = BusinessObjectsFactory.gimmeAccountUpdate(account);
        accountUpdate.setAccountNewValue(account.getAccountValue() + 100);
        List<AccountUpdate> accountUpdates = new ArrayList<AccountUpdate>();
        accountUpdates.add(accountUpdate);
        paymentTransaction.setAccountUpdates(accountUpdates);
        try {
            accountService.saveAccounts(accounts);
            paymentService.creditFamilyAccount(paymentTransaction);
            Account updatedAccount = accountService.getAccount(account.getId(), true);
            assertEquals(account.getAccountDetailList().size(), 
                    updatedAccount.getAccountDetailList().size() - 1);
            AccountDetail accountDetail = 
                updatedAccount.getAccountDetailList()
                    .get(updatedAccount.getAccountDetailList().size() - 1);
            assertEquals(accountDetail.getPayment(), payment);
        } catch (DataAccessException e) {
            assertNull(e);
        } catch (CpmBusinessException cpe) {
            cpe.printStackTrace();
            assertNull(cpe);
        } finally {
            accountService.deleteAllAccounts();
            paymentService.deleteAllPayments();
        }
    }

    public void testCreditContract() {
        ExternalFamilyAccount externalFamilyAccount = 
            familyAccountService.createExternalFamilyAccount("FAMILY_1", externalApplication.getId());
        ExternalIndividual externalIndividual = new ExternalIndividual();
        externalIndividual.setExternalIndividualId("IND_FAMILY_1");
        externalIndividual.setFirstName("John");
        externalIndividual.setLastName("DOE");
        familyAccountService.addExternalIndividual(externalFamilyAccount, externalIndividual);
        
        List<Contract> contracts = 
            BusinessObjectsFactory.gimmeTenContracts("contract", externalFamilyAccount);
        Contract contract = contracts.get(1);
        Payment payment = BusinessObjectsFactory.gimmePayment("payment", 10);
        PaymentTransaction paymentTransaction = new PaymentTransaction();
        paymentTransaction.setPayment(payment);
        ContractUpdate contractUpdate = BusinessObjectsFactory.gimmeContractUpdate(contract);
        contractUpdate.setContractId(contract.getContractId());
        List<ContractUpdate> contractUpdates = new ArrayList<ContractUpdate>();
        contractUpdates.add(contractUpdate);
        paymentTransaction.setContractUpdates(contractUpdates);
        try {
            contractService.saveContracts(contracts);
            paymentService.creditFamilyAccount(paymentTransaction);
            
            Contract updatedContract = contractService.getContract(contract.getId(), true);
            assertEquals(updatedContract.getContractDetailList().size(), 1);
            ContractDetail contractDetail = updatedContract.getContractDetailList().get(0);
            assertEquals(contractDetail.getPayment(), payment);
            assertEquals(contractDetail.getQuantity(), contractUpdate.getQuantity());
        } catch (DataAccessException e) {
            e.printStackTrace();
            assertNull(e);
        } catch (CpmBusinessException cpe) {
            cpe.printStackTrace();
            assertNull(cpe);
        } finally {
            contractService.deleteAllContracts();
            paymentService.deleteAllPayments();
        }
    }

    public void testCreditFamilyAccount() {

        ExternalFamilyAccount externalFamilyAccount = 
            familyAccountService.createExternalFamilyAccount("FAMILY_1", externalApplication.getId());
        ExternalIndividual externalIndividual = new ExternalIndividual();
        externalIndividual.setExternalIndividualId("IND_FAMILY_1");
        externalIndividual.setFirstName("John");
        externalIndividual.setLastName("DOE");
        familyAccountService.addExternalIndividual(externalFamilyAccount, externalIndividual);
        ExternalIndividual externalIndividual2 = new ExternalIndividual();
        externalIndividual2.setExternalIndividualId("IND_FAMILY_1");
        externalIndividual2.setFirstName("Jane");
        externalIndividual2.setLastName("DOE");
        familyAccountService.addExternalIndividual(externalFamilyAccount, externalIndividual2);

        // Make context business layer
        List<Invoice> invoices = 
            BusinessObjectsFactory.gimmeTenInvoices("family", externalFamilyAccount);
        List<Account> accounts = 
            BusinessObjectsFactory.gimmeTenAccounts("family", externalFamilyAccount);
        List<Contract> contracts = 
            BusinessObjectsFactory.gimmeTenContracts("family", externalFamilyAccount);
        
        CapwebctFamilyAccount capwebctFamilyAccount = 
            BusinessObjectsFactory.gimmeCapwebctFamilyAccount(10);
        
        CapwebctIndividual capwebctIndividual = 
            BusinessObjectsFactory.gimmeCapwebctIndividual("capwebct_ind_1",101);
        CapwebctIndividual capwebctIndividual2 = 
            BusinessObjectsFactory.gimmeCapwebctIndividual("capwebct_ind_2",102);

        // Make  Payment Transaction objects
        Payment payment = BusinessObjectsFactory.gimmePayment("payment", 10);

        Invoice invoice = invoices.get(1);
        InvoiceUpdate invoiceUpdate = BusinessObjectsFactory.gimmeInvoiceUpdate(invoice);
        
        Account account = accounts.get(1);
        AccountUpdate accountUpdate = BusinessObjectsFactory.gimmeAccountUpdate(accounts.get(1));
        accountUpdate.setAccountNewValue(accounts.get(1).getAccountValue() + 100);
        
        Contract contract = contracts.get(1);
        ContractUpdate contractUpdate = BusinessObjectsFactory.gimmeContractUpdate(contract);
        contractUpdate.setContractId(contract.getContractId());
        contractUpdate.setCapwebctIndividualId(capwebctIndividual.getCapwebctIndividualId());
        
        PaymentTransaction paymentTransaction = 
            BusinessObjectsFactory.gimmePaymentTransaction(
                accountUpdate, contractUpdate, invoiceUpdate, payment);
        paymentTransaction.setCapwebctFamilyAccountId(capwebctFamilyAccount.getCapwebctFamilyAccountId());
        try {

            // Persist Invoices and Account
            invoiceService.saveInvoices(invoices);
            accountService.saveAccounts(accounts);
            contractService.saveContracts(contracts);
            
            assertEquals(0, paymentService.getAllPayments().size());

            // Adding Individual to (External/Capwebct)Account
            familyAccountService.addCapwebctIndividual(capwebctFamilyAccount, capwebctIndividual);
            familyAccountService.addCapwebctIndividual(capwebctFamilyAccount, capwebctIndividual2);
            
            // Bindings
            familyAccountService.bindFamilyAccounts(externalFamilyAccount,capwebctFamilyAccount);
            familyAccountService.bindIndividuals(externalIndividual, capwebctIndividual);
            familyAccountService.bindIndividuals(externalIndividual2, capwebctIndividual2);
            
            assertEquals(0, paymentService.getAllPayments().size());

            // Main tested method => CreditFamilyAccount
            paymentService.creditFamilyAccount(paymentTransaction);
            
            assertEquals(1, paymentService.getAllPayments().size());
            
            invoice = invoiceService.getInvoice(invoice.getId(), true);
            assertEquals(invoice.getPayment(), payment);
            assertEquals(invoice.isInvoicePayed(), true);
            
            Account updatedAccount = accountService.getAccount(account.getId(), true);
            assertEquals(account.getAccountDetailList().size(), 
                    updatedAccount.getAccountDetailList().size() - 1);
            
            Contract updatedContract = contractService.getContract(contract.getId(), true);
            assertEquals(updatedContract.getContractDetailList().size(), 1);
            
        } catch (DataAccessException e) {
            assertNull(e);
        } catch (CpmBusinessException cpe) {
            cpe.printStackTrace();
            assertNull(cpe);
        } finally {
            accountService.deleteAllAccounts();
            contractService.deleteAllContracts();
            invoiceService.deleteAllInvoices();
            paymentService.deleteAllPayments();
        }
    }

}
