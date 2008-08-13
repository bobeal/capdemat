package fr.capwebct.modules.payment.testtool;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.capwebct.modules.payment.business.Account;
import fr.capwebct.modules.payment.business.AccountDetail;
import fr.capwebct.modules.payment.business.CapwebctFamilyAccount;
import fr.capwebct.modules.payment.business.CapwebctIndividual;
import fr.capwebct.modules.payment.business.Contract;
import fr.capwebct.modules.payment.business.ExternalApplication;
import fr.capwebct.modules.payment.business.ExternalFamilyAccount;
import fr.capwebct.modules.payment.business.ExternalIndividual;
import fr.capwebct.modules.payment.business.Invoice;
import fr.capwebct.modules.payment.business.InvoiceDetail;
import fr.capwebct.modules.payment.business.Payment;
import fr.capwebct.modules.payment.business.ws.AccountUpdate;
import fr.capwebct.modules.payment.business.ws.ContractUpdate;
import fr.capwebct.modules.payment.business.ws.InvoiceUpdate;
import fr.capwebct.modules.payment.business.ws.PaymentTransaction;

/**
 * A factory to create necessary referential objects.
 */
public class BusinessObjectsFactory {

    public static ExternalApplication gimmeExternalApplication(String label) {
        ExternalApplication externalApplication = new ExternalApplication();
        externalApplication.setLabel(label);
        externalApplication.setDescription(label);
        Set<String> brokers = new HashSet<String>();
        brokers.add("Broker 1");
        brokers.add("Broker 2");
        externalApplication.setBrokers(brokers);
        
        return externalApplication;
    }
    
    private static InvoiceDetail gimmeInvoiceDetail(String label, int id) {
        InvoiceDetail invoiceDetail = new InvoiceDetail();
        invoiceDetail.setChildName(label + "ChildName");
        invoiceDetail.setChildSurname(label + "ChildSurname");
        invoiceDetail.setLabel(label + "Label");
        invoiceDetail.setQuantity(id + 10);
        invoiceDetail.setUnitPrice(id + 100);
        invoiceDetail.setValue(id + 1000);
        return invoiceDetail;
    }

    private static List<InvoiceDetail> gimmeTenInvoiceDetails() {
        List<InvoiceDetail> invoiceDetailsList = new ArrayList<InvoiceDetail>();
        for (int i = 0; i < 10; i++) {
            InvoiceDetail invoiceDetail = gimmeInvoiceDetail("invoiceDetail" + i, i);
            invoiceDetailsList.add(invoiceDetail);
        }
        return invoiceDetailsList;
    }

    public static Invoice gimmeInvoice(String label, int id) {
        
        Date now = new Date();
        Invoice invoice = new Invoice();
        invoice.setInvoiceDate(now);
        invoice.setInvoiceExpirationDate(now);
        invoice.setInvoiceId(label + "_" + id);
        invoice.setInvoiceLabel(label);
        invoice.setInvoicePayed(false);
        invoice.setInvoicePaymentDate(now);
        invoice.setInvoiceValue(id + 1000);
        invoice.setInvoiceDetailList(gimmeTenInvoiceDetails());
        return invoice;
    }

    public static List<Invoice> gimmeTenInvoices(String label,
            ExternalFamilyAccount externalFamilyAccount) {

        List<Invoice> invoiceList = new ArrayList<Invoice>();
        for (int i = 0; i < 10; i++) {
            Invoice invoice = gimmeInvoice(label, i);
            invoice.setExternalFamilyAccount(externalFamilyAccount);
            invoiceList.add(invoice);
        }
        
        return invoiceList;
    }

    private static AccountDetail gimmeAccountDetail(String label, int id) {
        AccountDetail accountDetail = new AccountDetail();
        accountDetail.setHolderName(label + "_holderName");
        accountDetail.setHolderSurname(label + "_holderSurname");
        accountDetail.setValue(id);

        return accountDetail;
    }

    private static List<AccountDetail> gimmeTenAccountDetails() {
        List<AccountDetail> accountDetailsList = new ArrayList<AccountDetail>();
        for (int i = 0; i < 10; i++) {
            AccountDetail accountDetail = gimmeAccountDetail("accountDetail" + i, i);
            accountDetailsList.add(accountDetail);
        }
        return accountDetailsList;
    }

    private static Account gimmeAccount(String label, int id) {
        
        Account account = new Account();
        account.setAccountDate(new Date());
        account.setAccountId(label + "_" + (new Integer(id)).toString());
        account.setAccountLabel(label);
        account.setAccountValue(id + 1000);
        account.setAccountDetailList(gimmeTenAccountDetails());
        return account;
    }

    public static List<Account> gimmeTenAccounts(String label,
            ExternalFamilyAccount externalFamilyAccount) {
        
        List<Account> accountList = new ArrayList<Account>();
        for (int i = 0; i < 10; i++) {
            Account account = gimmeAccount(label, i);
            account.setExternalFamilyAccount(externalFamilyAccount);
            accountList.add(account);
        }
        
        return accountList;
    }

    private static Contract gimmeContract(String label, int id) {
        
        Contract contract = new Contract();
        contract.setBuyMax(id + 10);
        contract.setBuyMin(id);
        contract.setBuyPrice(id + 5);
        contract.setContractDate(new Date());
        contract.setContractId(label + "_" +  (new Integer(id)).toString());
        contract.setContractLabel(label);
        contract.setContractValue(id + 100);

        return contract;
    }

    public static List<Contract> gimmeTenContracts(String label,
            ExternalFamilyAccount externalFamilyAccount) {
        
        List<Contract> contractList = new ArrayList<Contract>();
        for (int i = 0; i < 10; i++) {
            Contract contract = gimmeContract(label, i);
            contract.setExternalFamilyAccount(externalFamilyAccount);
            if (externalFamilyAccount.getIndividuals() != null)
                contract.setExternalIndividual(externalFamilyAccount.getIndividuals().iterator().next());
            contractList.add(contract);
        }
        
        return contractList;
    }

    public static CapwebctIndividual gimmeCapwebctIndividual(String label, int id) {
        CapwebctIndividual individual = new CapwebctIndividual();
        individual.setChild(true);
        individual.setResponsible(false);
        individual.setFirstName(label + "_first_name");
        individual.setLastName(label + "_last_name");
        individual.setCapwebctIndividualId(id);
        return individual;
    }

    public static CapwebctFamilyAccount gimmeCapwebctFamilyAccount(int id) {
        CapwebctFamilyAccount capwebctFamilyAccount = new CapwebctFamilyAccount();
        capwebctFamilyAccount.setCapwebctFamilyAccountId(id);
        return capwebctFamilyAccount;
    }

    public static ExternalIndividual gimmeExternalIndividual(String id, String label) {
        ExternalIndividual individual = new ExternalIndividual();
        individual.setExternalIndividualId(id + "_individuall_id");
        individual.setFirstName(label + "_first_name");
        individual.setLastName(label + "_last_name");
        return individual;
    }

    public static ExternalFamilyAccount gimmeExternalFamilyAccount(String id, String label) {
        ExternalFamilyAccount externalFamilyAccount = new ExternalFamilyAccount();
        externalFamilyAccount.setExternalFamilyAccountId(id);
        externalFamilyAccount.setExternalApplication(gimmeExternalApplication(label + "_application_label"));
        return externalFamilyAccount;
    }

    public static Payment gimmePayment(String label, int value) {
        Payment payment = new Payment();
        payment.setCvqAck(label + "_cvq_ack_" + value);
        payment.setPaymentAck(label + "_payment_ack_" + value);
        payment.setPaymentAmount(value);
        payment.setPaymentDate(new Date());
        return payment;
    }

    public static List<Payment> gimmeTenPayments(String label) {
        List<Payment> payments = new ArrayList<Payment>();
        for (int i = 0; i < 10; i++)
            payments.add(gimmePayment(label, i + 100));
        return payments;
    }

    public static AccountUpdate gimmeAccountUpdate(Account account) {
        AccountUpdate accountUpdate = new AccountUpdate();
        accountUpdate.setExternalFamilyAccountId(account.getExternalFamilyAccount().getExternalFamilyAccountId());
        long externalApplicationId = 
            account.getExternalFamilyAccount().getExternalApplication().getId();
        accountUpdate.setExternalApplicationId(externalApplicationId);
        accountUpdate.setAccountId(account.getAccountId());
        accountUpdate.setAccountOldValue(account.getAccountValue());
        accountUpdate.setAccountOldValueDate(account.getAccountDate());
        return accountUpdate;
    }

    public static ContractUpdate gimmeContractUpdate(Contract contract) {
        ContractUpdate contractUpdate = new ContractUpdate();
        ExternalFamilyAccount efa = contract.getExternalFamilyAccount();
        contractUpdate.setExternalFamilyAccountId(efa.getExternalFamilyAccountId());
        contractUpdate.setExternalApplicationId(efa.getExternalApplication().getId());
        ExternalIndividual externalIndividual = contract.getExternalIndividual();
        contractUpdate.setExternalIndividualId(externalIndividual.getExternalIndividualId());
        contractUpdate.setAmount(110);
        contractUpdate.setPrice(111);
        contractUpdate.setQuantity(112);
        return contractUpdate;
    }

    public static InvoiceUpdate gimmeInvoiceUpdate(Invoice invoice) {
        InvoiceUpdate invoiceUpdate = new InvoiceUpdate();
        ExternalFamilyAccount efa = invoice.getExternalFamilyAccount();
        invoiceUpdate.setExternalFamilyAccountId(efa.getExternalFamilyAccountId());
        invoiceUpdate.setExternalApplicationId(efa.getExternalApplication().getId());
        invoiceUpdate.setInvoiceId(invoice.getInvoiceId());
        invoiceUpdate.setAmount(invoice.getInvoiceValue());
        return invoiceUpdate;
    }

    public static PaymentTransaction gimmePaymentTransaction(AccountUpdate accountUpdate,
            ContractUpdate contractUpdate, InvoiceUpdate invoiceUpdate, Payment payment) {
        
        PaymentTransaction paymentTransaction = new PaymentTransaction();
        List<AccountUpdate> accountUpdates = new ArrayList<AccountUpdate>();
        if (accountUpdate != null)
            accountUpdates.add(accountUpdate);
        List<ContractUpdate> contractUpdates = new ArrayList<ContractUpdate>();
        if (contractUpdate != null)
            contractUpdates.add(contractUpdate);
        List<InvoiceUpdate> invoiceUpdates = new ArrayList<InvoiceUpdate>();
        if (invoiceUpdate != null)
            invoiceUpdates.add(invoiceUpdate);
        paymentTransaction.setVersion("version");
        paymentTransaction.setCapwebctFamilyAccountId(1);
        paymentTransaction.setCapwebctFamilyAccountZipcode("zipcode");
        paymentTransaction.setPayment(payment);
        paymentTransaction.setAccountUpdates(accountUpdates);
        paymentTransaction.setContractUpdates(contractUpdates);
        paymentTransaction.setInvoiceUpdates(invoiceUpdates);
        return paymentTransaction;
    }
}
