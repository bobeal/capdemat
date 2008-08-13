package fr.capwebct.modules.payment.business.ws;

import java.util.ArrayList;
import java.util.List;

import fr.capwebct.modules.payment.business.Payment;
import fr.capwebct.modules.payment.schema.ban.AccountUpdateType;
import fr.capwebct.modules.payment.schema.ban.BankTransactionDocument;
import fr.capwebct.modules.payment.schema.ban.ContractUpdateType;
import fr.capwebct.modules.payment.schema.ban.InvoiceUpdateType;
import fr.capwebct.modules.payment.schema.ban.BankTransactionDocument.BankTransaction;

/**
 * Data tranfert object used to store data received for credit account operations.
 */
public class PaymentTransaction {

    private String version;
    private Payment payment;
    private long capwebctFamilyAccountId;
    private String capwebctFamilyAccountZipcode;
    private List<ContractUpdate> contractUpdates;
    private List<AccountUpdate> accountUpdates;
    private List<InvoiceUpdate> invoiceUpdates;

    public PaymentTransaction() {
    }    
    
    public static BankTransactionDocument modelToXml(PaymentTransaction paymentTransaction) {
        if (paymentTransaction == null)
            return null;
        BankTransactionDocument bankTransactionDocument = BankTransactionDocument.Factory.newInstance();
        BankTransaction bankTransaction = bankTransactionDocument.addNewBankTransaction();
       
        if (paymentTransaction.getVersion() != null)
            bankTransaction.setVersion(paymentTransaction.getVersion());
        if (paymentTransaction.getPayment() != null)
            bankTransaction.setPayment(Payment.modelToXml(paymentTransaction.getPayment()));
       
        bankTransaction.addNewFamily();
        bankTransaction.getFamily().setId(paymentTransaction.getCapwebctFamilyAccountId());
        if (paymentTransaction.getCapwebctFamilyAccountZipcode() != null)
            bankTransaction.getFamily().setZip(paymentTransaction.getCapwebctFamilyAccountZipcode());
        
        if (paymentTransaction.getContractUpdates() != null) {
            List<ContractUpdateType> contractUpdateTypes = new ArrayList<ContractUpdateType>();
            for (ContractUpdate contractUpdate : paymentTransaction.getContractUpdates())
                contractUpdateTypes.add(ContractUpdate.modelToXml(contractUpdate));
            bankTransaction.addNewContracts().setContractArray(contractUpdateTypes.toArray(new ContractUpdateType[]{}));
        }
        if (paymentTransaction.getAccountUpdates() != null) {
            List<AccountUpdateType> accountUpdateTypes = new ArrayList<AccountUpdateType>();
            for (AccountUpdate accountUpdate : paymentTransaction.getAccountUpdates())
                accountUpdateTypes.add(AccountUpdate.modelToXml(accountUpdate));
            bankTransaction.addNewAccounts().setAccountArray(accountUpdateTypes.toArray(new AccountUpdateType[]{}));
        }
        if (paymentTransaction.getInvoiceUpdates() != null) {
            List<InvoiceUpdateType> invoiceUpdateTypes = new ArrayList<InvoiceUpdateType>();
            for (InvoiceUpdate invoiceUpdate : paymentTransaction.getInvoiceUpdates())
                invoiceUpdateTypes.add(InvoiceUpdate.modelToXml(invoiceUpdate));
            bankTransaction.addNewInvoices().setInvoiceArray(invoiceUpdateTypes.toArray(new InvoiceUpdateType[]{}));
        }
        
        return bankTransactionDocument;
    }

    public static PaymentTransaction xmlToModel(BankTransactionDocument bankTransactionDocument) {
        if (bankTransactionDocument == null)
            return null;
        BankTransaction bankTransaction = bankTransactionDocument.getBankTransaction();
        if (bankTransaction == null)
            return null;
        
       PaymentTransaction paymentTransaction = new PaymentTransaction();
       if (bankTransaction.getVersion() != null)
           paymentTransaction.setVersion(bankTransaction.getVersion());
       if (bankTransaction.getPayment() != null) {
           Payment payment =
               Payment.xmlToModel(bankTransaction.getPayment(), 
                       bankTransaction.getFamily().getId());
           paymentTransaction.setPayment(payment);
       }
       
       if (bankTransaction.getFamily() != null) {
           paymentTransaction.setCapwebctFamilyAccountId(bankTransaction.getFamily().getId());
           if (bankTransaction.getFamily().getZip() != null)
               paymentTransaction.setCapwebctFamilyAccountZipcode(bankTransaction.getFamily().getZip());
       }
       
       if (bankTransaction.getContracts() != null)
           if (bankTransaction.getContracts().getContractArray() != null) {
               List<ContractUpdate> contractUpdates = new ArrayList<ContractUpdate>();
               for (int i = 0; i < bankTransaction.getContracts().getContractArray().length; i++) {
                   ContractUpdateType contractUpdateType = bankTransaction.getContracts().getContractArray()[i];
                   contractUpdates.add(ContractUpdate.xmlToModel(contractUpdateType));
               }
               paymentTransaction.setContractUpdates(contractUpdates);
           }
       if (bankTransaction.getAccounts() != null)
           if (bankTransaction.getAccounts().getAccountArray() != null) {
               List<AccountUpdate> accountUpdates = new ArrayList<AccountUpdate>();
               for (int i = 0; i < bankTransaction.getAccounts().getAccountArray().length; i++) {
                   AccountUpdateType accountUpdateType = bankTransaction.getAccounts().getAccountArray()[i];
                   accountUpdates.add(AccountUpdate.xmlToModel(accountUpdateType));
               }
               paymentTransaction.setAccountUpdates(accountUpdates);
           }
       if (bankTransaction.getInvoices() != null)
           if (bankTransaction.getInvoices().getInvoiceArray() != null) {
               List<InvoiceUpdate> invoiceUpdates = new ArrayList<InvoiceUpdate>();
               for (int i = 0; i < bankTransaction.getInvoices().getInvoiceArray().length; i++) {
                   InvoiceUpdateType invoiceUpdateType = bankTransaction.getInvoices().getInvoiceArray()[i];
                   invoiceUpdates.add(InvoiceUpdate.xmlToModel(invoiceUpdateType));
               }
               paymentTransaction.setInvoiceUpdates(invoiceUpdates);
           }
       return paymentTransaction;
    }
    
    public List<AccountUpdate> getAccountUpdates() {
        return accountUpdates;
    }

    public void setAccountUpdates(List<AccountUpdate> accountUpdates) {
        this.accountUpdates = accountUpdates;
    }

    public long getCapwebctFamilyAccountId() {
        return capwebctFamilyAccountId;
    }

    public void setCapwebctFamilyAccountId(long capwebctFamilyAccountId) {
        this.capwebctFamilyAccountId = capwebctFamilyAccountId;
    }

    public String getCapwebctFamilyAccountZipcode() {
        return capwebctFamilyAccountZipcode;
    }

    public void setCapwebctFamilyAccountZipcode(String capwebctFamilyAccountZipcode) {
        this.capwebctFamilyAccountZipcode = capwebctFamilyAccountZipcode;
    }

    public List<ContractUpdate> getContractUpdates() {
        return contractUpdates;
    }

    public void setContractUpdates(List<ContractUpdate> contractUpdates) {
        this.contractUpdates = contractUpdates;
    }

    public List<InvoiceUpdate> getInvoiceUpdates() {
        return invoiceUpdates;
    }

    public void setInvoiceUpdates(List<InvoiceUpdate> invoiceUpdates) {
        this.invoiceUpdates = invoiceUpdates;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
