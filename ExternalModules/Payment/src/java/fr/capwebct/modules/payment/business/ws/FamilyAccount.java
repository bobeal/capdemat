package fr.capwebct.modules.payment.business.ws;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.capwebct.modules.payment.business.Account;
import fr.capwebct.modules.payment.business.CapwebctIndividual;
import fr.capwebct.modules.payment.business.Contract;
import fr.capwebct.modules.payment.business.ExternalFamilyAccount;
import fr.capwebct.modules.payment.business.ExternalIndividual;
import fr.capwebct.modules.payment.business.Invoice;
import fr.capwebct.modules.payment.schema.fam.AccountType;
import fr.capwebct.modules.payment.schema.fam.ContractType;
import fr.capwebct.modules.payment.schema.fam.FamilyDocument;
import fr.capwebct.modules.payment.schema.fam.IndividualContractType;
import fr.capwebct.modules.payment.schema.fam.InvoiceType;
import fr.capwebct.modules.payment.schema.fam.FamilyDocument.Family;
import fr.capwebct.modules.payment.schema.fam.FamilyDocument.Family.Accounts;
import fr.capwebct.modules.payment.schema.fam.FamilyDocument.Family.Contracts;
import fr.capwebct.modules.payment.schema.fam.FamilyDocument.Family.Invoices;

public class FamilyAccount {

    private static Log log = LogFactory.getLog(FamilyAccount.class);
    
    private long capwebctFamilyAccountId;

    private Set<Account> accountList;
    private Set<Invoice> invoiceList;
    private Set<Contract> contractList;

    public FamilyAccount() {
    }

    public static FamilyDocument modelToXml(FamilyAccount familyAccount) {
        if (familyAccount == null)
            return null;

        Calendar calendar = Calendar.getInstance();
        FamilyDocument familyDocument = FamilyDocument.Factory.newInstance();
        Family family = familyDocument.addNewFamily();

        family.setId(familyAccount.getCapwebctFamilyAccountId());

        // Accounts
        if (familyAccount.getAccountList() != null) {
            Set<AccountType> famAccounts = new HashSet<AccountType>();
            for (Account account : familyAccount.getAccountList()) {
                AccountType famAccount = AccountType.Factory.newInstance();
                if (account.getAccountId() != null)
                    famAccount.setAccountId(account.getAccountId());
                if (account.getAccountLabel() != null)
                    famAccount.setAccountLabel(account.getAccountLabel());
                if (account.getAccountDate() != null) {
                    calendar.setTime(account.getAccountDate());
                    famAccount.setAccountDate(calendar);
                }
                famAccount.setAccountValue(account.getAccountValue());
                ExternalFamilyAccount efa = account.getExternalFamilyAccount();
                famAccount.setExternalApplicationLabel(efa.getExternalApplication().getLabel());
                famAccount.setExternalApplicationId(efa.getExternalApplication().getId());
                famAccount.setExternalFamilyAccountId(efa.getExternalFamilyAccountId());
                famAccount.setBroker(account.getBroker());
                famAccounts.add(famAccount);
            }
            Accounts accounts = Accounts.Factory.newInstance();
            accounts.setAccountArray(famAccounts.toArray(new AccountType[] {}));
            family.setAccounts(accounts);
        }

        // Invoices
        if (familyAccount.getInvoiceList() != null) {
            Set<InvoiceType> famInvoices = new HashSet<InvoiceType>();
            for (Invoice invoice : familyAccount.getInvoiceList()) {
                InvoiceType famInvoice = InvoiceType.Factory.newInstance();
                famInvoice.setInvoiceId(invoice.getInvoiceId());
                famInvoice.setInvoiceValue(invoice.getInvoiceValue());
                if (invoice.getInvoiceLabel() != null)
                    famInvoice.setInvoiceLabel(invoice.getInvoiceLabel());
                if (invoice.getInvoiceDate() != null) {
                    calendar.setTime(invoice.getInvoiceDate());
                    famInvoice.setInvoiceDate(calendar);
                }
                if (invoice.getInvoicePaymentDate() != null) {
                    calendar.setTime(invoice.getInvoicePaymentDate());
                    famInvoice.setInvoicePaymentDate(calendar);
                }
                if (invoice.getInvoiceExpirationDate() != null) {
                    calendar.setTime(invoice.getInvoiceExpirationDate());
                    famInvoice.setInvoiceExpirationDate(calendar);
                }
                famInvoice.setInvoicePaid(invoice.isInvoicePayed());
                ExternalFamilyAccount efa = invoice.getExternalFamilyAccount();
                famInvoice.setExternalApplicationLabel(efa.getExternalApplication().getLabel());
                famInvoice.setExternalApplicationId(efa.getExternalApplication().getId());
                famInvoice.setExternalFamilyAccountId(efa.getExternalFamilyAccountId());
                famInvoice.setBroker(invoice.getBroker());
                famInvoices.add(famInvoice);
            }
            Invoices invoices = Invoices.Factory.newInstance();
            invoices.setInvoiceArray(famInvoices.toArray(new InvoiceType[] {}));
            family.setInvoices(invoices);
        }

        // Individual Contracts
        if (familyAccount.getContractList() != null) {
            Map<IndividualContractType, Set<ContractType>> indContractTypes =
                new HashMap<IndividualContractType, Set<ContractType>>();
            for (Contract contract : familyAccount.getContractList()) {
                // first check that this contract can be tied to a CapWebCT individual
                // either, ignore it
                ExternalIndividual externalIndividual = contract.getExternalIndividual();
                if (externalIndividual.getCapwebctIndividual() == null) {
                    log.warn("contract " + contract.getId() + " from efa "
                            + contract.getExternalFamilyAccount().getExternalFamilyAccountId()
                            + " is not tied to CapWebCT individual");
                    continue;
                }
                ContractType famContract = ContractType.Factory.newInstance();
                famContract.setContractId(contract.getContractId());
                famContract.setContractLabel(contract.getContractLabel());
                if (contract.getContractDate() != null) {
                    calendar.setTime(contract.getContractDate());
                    famContract.setContractDate(calendar);
                }
                famContract.setContractValue(contract.getContractValue());
                famContract.setBuyPrice(contract.getBuyPrice());
                famContract.setMinBuy(contract.getBuyMin());
                famContract.setMaxBuy(contract.getBuyMax());
                ExternalFamilyAccount efa = contract.getExternalFamilyAccount();
                famContract.setExternalApplicationLabel(efa.getExternalApplication().getLabel());
                famContract.setExternalApplicationId(efa.getExternalApplication().getId());
                famContract.setExternalFamilyAccountId(efa.getExternalFamilyAccountId());
                famContract.setExternalIndividualId(externalIndividual.getExternalIndividualId());
                famContract.setBroker(contract.getBroker());
                
                // group contracts by CapWebCT individual
                CapwebctIndividual capwebctIndividual = externalIndividual.getCapwebctIndividual();
                boolean foundIndContractType = false;
                for (IndividualContractType ict : indContractTypes.keySet()) {
                    if (ict.getCapwebctIndividualId() == capwebctIndividual.getCapwebctIndividualId()) {
                        Set<ContractType> contracts = indContractTypes.get(ict);
                        contracts.add(famContract);
                        foundIndContractType = true;
                        break;
                    }
                }
                if (!foundIndContractType) {
                    IndividualContractType individualContractType =
                        IndividualContractType.Factory.newInstance();
                    individualContractType.setCapwebctIndividualId(capwebctIndividual.getCapwebctIndividualId());
                    Set<ContractType> contracts = new HashSet<ContractType>();
                    contracts.add(famContract);
                    indContractTypes.put(individualContractType, contracts);
                }
            }

            // finished parsing of contracts, set the contract array
            for (IndividualContractType ict : indContractTypes.keySet()) {
                Set<ContractType> contracts = indContractTypes.get(ict);
                ict.setContractArray(contracts.toArray(new ContractType[] {}));
            }
            
            Contracts contracts = Contracts.Factory.newInstance();
            contracts.setContractArray(indContractTypes.keySet().toArray(new IndividualContractType[] {}));
            family.setContracts(contracts);
        }
        return familyDocument;
    }

    public Set<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(Set<Account> accountList) {
        this.accountList = accountList;
    }

    public void addAccounts(Set<Account> accountList) {
        if (accountList == null)
            return;
        if (this.accountList == null)
            this.accountList = new HashSet<Account>();
        this.accountList.addAll(accountList);
    }
    
    public Set<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(Set<Contract> contractList) {
        this.contractList = contractList;
    }

    public void addContracts(Set<Contract> contractList) {
        if (contractList == null)
            return;
        if (this.contractList == null)
            this.contractList = new HashSet<Contract>();
        this.contractList.addAll(contractList);
    }
    
    public Set<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(Set<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public void addInvoices(Set<Invoice> invoiceList) {
        if (invoiceList == null)
            return;
        if (this.invoiceList == null)
            this.invoiceList = new HashSet<Invoice>();
        this.invoiceList.addAll(invoiceList);
    }
    
    public long getCapwebctFamilyAccountId() {
        return capwebctFamilyAccountId;
    }

    public void setCapwebctFamilyAccountId(long capwebctFamilyAccountId) {
        this.capwebctFamilyAccountId = capwebctFamilyAccountId;
    }
}
