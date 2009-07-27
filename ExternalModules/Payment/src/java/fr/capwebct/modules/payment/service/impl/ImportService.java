package fr.capwebct.modules.payment.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.Account;
import fr.capwebct.modules.payment.business.AccountDetail;
import fr.capwebct.modules.payment.business.Contract;
import fr.capwebct.modules.payment.business.ExternalApplication;
import fr.capwebct.modules.payment.business.ExternalDataType;
import fr.capwebct.modules.payment.business.ExternalFamilyAccount;
import fr.capwebct.modules.payment.business.ExternalIndividual;
import fr.capwebct.modules.payment.business.Invoice;
import fr.capwebct.modules.payment.business.InvoiceDetail;
import fr.capwebct.modules.payment.business.Payment;
import fr.capwebct.modules.payment.business.csv.AccountDetailWrapper;
import fr.capwebct.modules.payment.business.csv.AccountWrapper;
import fr.capwebct.modules.payment.business.csv.ContractWrapper;
import fr.capwebct.modules.payment.business.csv.ExternalFamilyAccountWrapper;
import fr.capwebct.modules.payment.business.csv.InvoiceDetailWrapper;
import fr.capwebct.modules.payment.business.csv.InvoiceWrapper;
import fr.capwebct.modules.payment.exception.CpmBusinessException;
import fr.capwebct.modules.payment.exception.CpmParsingException;
import fr.capwebct.modules.payment.security.CpmSecurityException;
import fr.capwebct.modules.payment.service.IAccountService;
import fr.capwebct.modules.payment.service.IAuditService;
import fr.capwebct.modules.payment.service.IContractService;
import fr.capwebct.modules.payment.service.ICsvImportService;
import fr.capwebct.modules.payment.service.IExternalApplicationService;
import fr.capwebct.modules.payment.service.IFamilyAccountService;
import fr.capwebct.modules.payment.service.IImportService;
import fr.capwebct.modules.payment.service.IInvoiceService;
import fr.capwebct.modules.payment.service.IPaymentService;
import fr.capwebct.modules.payment.service.ImportResultBean;

public class ImportService implements IImportService {

    private static Log log = LogFactory.getLog(ImportService.class);
    
    private ICsvImportService csvImportService;
    
    private IInvoiceService invoiceService;
    private IAccountService accountService;
    private IContractService contractService;
    private IFamilyAccountService familyAccountService;
    private IPaymentService paymentService;
    private IExternalApplicationService externalApplicationService;

    private IAuditService auditService;
    
    public ImportResultBean importExternalData(final String importType,
            final long externalApplicationId, final String broker, 
            final ExternalDataType externalDataType, final byte[] data, final byte[] detailsData) 
        throws CpmBusinessException {

        List<Object> parsedData = null;
        try {
            parsedData = csvImportService.parseData("generic", externalDataType, data);
        } catch (CpmParsingException cpe) {
            cpe.printStackTrace();
            throw new CpmBusinessException();
        }
        
        List<Object> parsedDetailsData = null;
        if (detailsData != null) {
            ExternalDataType externalDetailsDataType = 
                (externalDataType == ExternalDataType.INVOICE) ? 
                        ExternalDataType.INVOICE_DETAIL : ExternalDataType.ACCOUNT_DETAIL;
            try {
                parsedDetailsData = 
                    csvImportService.parseData("generic", externalDetailsDataType, detailsData);
            } catch (CpmParsingException cpe) {
                cpe.printStackTrace();
                throw new CpmBusinessException();
            }            
        }
        
        ExternalApplication externalApplication = 
            externalApplicationService.getById(externalApplicationId);
        ImportResultBean importResultBean = null;
        if (externalDataType.equals(ExternalDataType.INVOICE)) {
            importResultBean = importInvoices(parsedData, externalApplication, broker);
            if (importResultBean.isSuccessful() && parsedDetailsData != null)
                importInvoiceDetails(parsedDetailsData, externalApplication, importResultBean);
        } else if (externalDataType.equals(ExternalDataType.ACCOUNT)) {
            importResultBean = importAccounts(parsedData, externalApplication, broker);
            if (importResultBean.isSuccessful() && parsedDetailsData != null)
                importAccountDetails(parsedDetailsData, externalApplication, importResultBean);
        } else if (externalDataType.equals(ExternalDataType.CONTRACT)) {
            importResultBean = importContracts(parsedData,  externalApplication, broker);
        } else if (externalDataType.equals(ExternalDataType.EXTERNAL_FAMILY_ACCOUNT)) {
            importResultBean = importExternalFamilyAccounts(parsedData, externalApplication);
        }
        
        if (!importResultBean.isSuccessful())
            return importResultBean;
        
        try {
            auditService.addAuditTrace("CSV", externalDataType, 
                    externalApplication.getLabel(), broker);
        } catch (CpmSecurityException cse) {
            cse.printStackTrace();
            log.error("importExternalData() no agent in current security context !?");
            throw new CpmBusinessException();
        }
        
        importResultBean.setImportedLines(Long.valueOf(parsedData.size()));
        return importResultBean;
    }

    private ImportResultBean importInvoices(List<Object> parsedData, 
            ExternalApplication externalApplication, String broker) {
        ImportResultBean importResultBean = new ImportResultBean();
        
        List<Invoice> invoices = new ArrayList<Invoice>();
        for (Object object : parsedData) {
            InvoiceWrapper invoiceWrapper = (InvoiceWrapper) object;
            ExternalFamilyAccount efa =
                familyAccountService.getExternalFamilyAccount(invoiceWrapper.getExternalFamilyAccountId(),
                        externalApplication.getId());
            // create external family account if it does not already exist
            if (efa == null) {
                // but, first, search within accounts being imported
                for (Invoice invoice : invoices) {
                    ExternalFamilyAccount tempEfa = invoice.getExternalFamilyAccount();
                    if (tempEfa.getExternalFamilyAccountId().equals(invoiceWrapper.getExternalFamilyAccountId())
                            && tempEfa.getExternalApplication().getLabel().equals(externalApplication.getLabel())) {
                        efa = tempEfa;
                        break;
                    }
                }
                // if still not found, then create it
                if (efa == null) {
                    importResultBean.addCreatedEfa(invoiceWrapper.getExternalFamilyAccountId());
                    efa = familyAccountService.createExternalFamilyAccount(
                            invoiceWrapper.getExternalFamilyAccountId(), externalApplication.getId());
                }
            }
            Invoice invoice = invoiceWrapper.getInvoice();
            invoice.setExternalFamilyAccount(efa);
            invoice.setBroker(broker);
            invoices.add(invoice);
        }
        
        try {
            invoiceService.importInvoices(invoices, externalApplication.getId(), broker);        
        } catch (DataAccessException dae) {
            dae.printStackTrace();
            importResultBean.setSuccessful(false);
            importResultBean.setFailMessage(dae.getMessage());
            return importResultBean;
        } catch (CpmBusinessException cpe) {
            cpe.printStackTrace();
            importResultBean.setSuccessful(false);
            importResultBean.setFailMessage(cpe.getMessage());
            return importResultBean;            
        }

        importResultBean.setSuccessful(true);
        return importResultBean;
    }
    
    private ImportResultBean importAccounts(List<Object> parsedData, 
            ExternalApplication externalApplication, String broker) {
        ImportResultBean importResultBean = new ImportResultBean();

        List<Account> accounts = new ArrayList<Account>();
        for (Object object : parsedData) {
            AccountWrapper accountWrapper = (AccountWrapper) object;
            ExternalFamilyAccount efa =
                    familyAccountService.getExternalFamilyAccount(accountWrapper.getExternalFamilyAccountId(),
                            externalApplication.getId());
            // create external family account if it does not already exist
            if (efa == null) {
                // but, first, search within accounts being imported
                for (Account account : accounts) {
                    ExternalFamilyAccount tempEfa = account.getExternalFamilyAccount();
                    if (tempEfa.getExternalFamilyAccountId().equals(accountWrapper.getExternalFamilyAccountId())
                            && tempEfa.getExternalApplication().getLabel().equals(externalApplication.getLabel())) {
                        efa = tempEfa;
                        break;
                    }
                }
                // if still not found, then create it
                if (efa == null) {
                    efa = familyAccountService.createExternalFamilyAccount(
                            accountWrapper.getExternalFamilyAccountId(), externalApplication.getId());
                    importResultBean.addCreatedEfa(accountWrapper.getExternalFamilyAccountId());
                }
            }
            Account account = accountWrapper.getAccount();
            account.setExternalFamilyAccount(efa);
            account.setBroker(broker);
            accounts.add(account);
        }
        
        try {
            accountService.importAccounts(accounts, externalApplication.getId(), broker);
        } catch (DataAccessException dae) {
            dae.printStackTrace();
            importResultBean.setSuccessful(false);
            importResultBean.setFailMessage(dae.getMessage());
            return importResultBean;
        } catch (CpmBusinessException cpe) {
            cpe.printStackTrace();
            importResultBean.setSuccessful(false);
            importResultBean.setFailMessage(cpe.getMessage());
            return importResultBean;            
        }
        
        importResultBean.setSuccessful(true);
        return importResultBean;
    }
    
    private ImportResultBean importContracts(List<Object> parsedData, 
            ExternalApplication externalApplication, String broker) {
        ImportResultBean importResultBean = new ImportResultBean();

        List<Contract> contracts = new ArrayList<Contract>();
        for (Object object : parsedData) {
            ContractWrapper contractWrapper = (ContractWrapper) object;
            ExternalFamilyAccount efa =
                familyAccountService.getExternalFamilyAccount(contractWrapper.getExternalFamilyAccountId(),
                        externalApplication.getId());
            ExternalIndividual externalIndividual = null;
            // create external family account if it does not already exist
            if (efa == null) {
                // but, first, search within contracts being imported
                for (Contract contract : contracts) {
                    ExternalFamilyAccount tempEfa = contract.getExternalFamilyAccount();
                    if (tempEfa.getExternalFamilyAccountId().equals(contractWrapper.getExternalFamilyAccountId())
                            && tempEfa.getExternalApplication().getLabel().equals(externalApplication.getLabel())) {
                        efa = tempEfa;
                        for (ExternalIndividual tempEi : tempEfa.getIndividuals()) {
                            if (tempEi.getExternalIndividualId().equals(contractWrapper.getExternalIndividualId())) {
                                externalIndividual = tempEi;
                                break;
                            }
                        }
                        // found external family account but not the external individual
                        // create and add it to the account
                        if (externalIndividual == null) {
                            externalIndividual = new ExternalIndividual();
                            externalIndividual.setExternalIndividualId(contractWrapper.getExternalIndividualId());
                            efa.addIndividual(externalIndividual);
                        }
                        break;
                    }
                }
                // if still not found, then create the external family account and individual
                if (efa == null) {
                    efa = familyAccountService.createExternalFamilyAccount(
                            contractWrapper.getExternalFamilyAccountId(), externalApplication.getId());
                    externalIndividual = new ExternalIndividual();
                    externalIndividual.setExternalIndividualId(contractWrapper.getExternalIndividualId());
                    familyAccountService.addExternalIndividual(efa, externalIndividual);
                    importResultBean.addCreatedEfa(contractWrapper.getExternalFamilyAccountId());
                }
            } else {
                // found the external family account
                // now, look for the external individual
                for (ExternalIndividual tempEi : efa.getIndividuals()) {
                    if (tempEi.getExternalIndividualId().equals(contractWrapper.getExternalIndividualId())) {
                        externalIndividual = tempEi;
                        break;
                    }
                }

                // did not find the external individual, create and add it to the account
                if (externalIndividual == null) {
                    externalIndividual = new ExternalIndividual();
                    externalIndividual.setExternalIndividualId(contractWrapper.getExternalIndividualId());
                    efa.addIndividual(externalIndividual);
                }
            }

            Contract contract = contractWrapper.getContract();
            contract.setExternalFamilyAccount(efa);
            contract.setExternalIndividual(externalIndividual);
            contract.setBroker(broker);
            contracts.add(contract);            
        }

        try {
            contractService.importContracts(contracts, externalApplication.getId(), broker);
        } catch (DataAccessException dae) {
            dae.printStackTrace();
            importResultBean.setSuccessful(false);
            importResultBean.setFailMessage(dae.getMessage());
            return importResultBean;
        } catch (CpmBusinessException cpe) {
            cpe.printStackTrace();
            importResultBean.setSuccessful(false);
            importResultBean.setFailMessage(cpe.getMessage());
            return importResultBean;            
        }
        
        importResultBean.setSuccessful(true);
        return importResultBean;
    }
    
    private ImportResultBean importInvoiceDetails(List<Object> parsedData, 
            ExternalApplication externalApplication, ImportResultBean importResultBean) {

        Map<Invoice, List<InvoiceDetail>> stackedInvoices = 
            new HashMap<Invoice, List<InvoiceDetail>>();
        for (Object object : parsedData) {
            InvoiceDetailWrapper invoiceDetailWrapper = (InvoiceDetailWrapper) object;
            Invoice invoice = null;
            boolean alreadyAddedInvoice = false;
            for (Invoice tempInvoice : stackedInvoices.keySet()) {
                ExternalFamilyAccount efa = tempInvoice.getExternalFamilyAccount();
                if (tempInvoice.getInvoiceId().equals(invoiceDetailWrapper.getInvoiceId())
                        && efa.getExternalFamilyAccountId().equals(invoiceDetailWrapper.getExternalFamilyAccountId())
                        && efa.getExternalApplication().getLabel().equals(externalApplication.getLabel())) {
                    invoice = tempInvoice;
                    alreadyAddedInvoice = true;
                    break;
                }
            }
            if (invoice == null) {
                invoice = 
                    invoiceService.getByExternalAndInvoiceId(invoiceDetailWrapper.getExternalFamilyAccountId(),
                            externalApplication.getId(),
                            invoiceDetailWrapper.getInvoiceId());
            }
            if (invoice == null) {
                log.error("importInvoiceDetails() parent invoice with id " 
                        +invoiceDetailWrapper.getInvoiceId() + " for application " 
                        + externalApplication.getLabel() + " has not been found");
                importResultBean.addFailedImport("admin.import_export.parent_element_not_found",
                        invoiceDetailWrapper.getInvoiceId());
                importResultBean.setSuccessful(false);
            } else {
                if (!alreadyAddedInvoice)
                    stackedInvoices.put(invoice, new ArrayList<InvoiceDetail>());
                stackedInvoices.get(invoice).add(invoiceDetailWrapper.getInvoiceDetail());
            }
        }
        
        if (!importResultBean.isSuccessful())
            return importResultBean;
        
        for (Invoice invoice : stackedInvoices.keySet()) {
            invoiceService.deleteInvoiceDetails(invoice);
            invoice.setInvoiceDetailList(stackedInvoices.get(invoice));
        }
        
        try {
            invoiceService.saveInvoices(new ArrayList<Invoice>(stackedInvoices.keySet()));
        } catch (DataAccessException dae) {
            importResultBean.setSuccessful(false);
            importResultBean.setFailMessage(dae.getMessage());
            return importResultBean;
        } catch (CpmBusinessException cpe) {
            importResultBean.setSuccessful(false);
            importResultBean.setFailMessage(cpe.getMessage());
            return importResultBean;
        }
        
        importResultBean.setSuccessful(true);
        return importResultBean;
    }
    
    private ImportResultBean importAccountDetails(List<Object> parsedData, 
            ExternalApplication externalApplication, ImportResultBean importResultBean) {

        Map<Account, List<AccountDetail>> stackedAccounts = 
            new HashMap<Account, List<AccountDetail>>();
        List<Account> accountsToSave = new ArrayList<Account>();
        List<Payment> payments = new ArrayList<Payment>(); 
        for (Object object : parsedData) {
            AccountDetailWrapper accountDetailWrapper = (AccountDetailWrapper) object;
            Account account = null;
            boolean alreadyAddedAccount = false;
            // search if we already have dealt with this account ...
            for (Account tempAccount : accountsToSave) {
                String tempAccountEfa = tempAccount.getExternalFamilyAccount().getExternalFamilyAccountId();
                String tempAccountEal = tempAccount.getExternalFamilyAccount().getExternalApplication().getLabel();
                if (tempAccount.getAccountId().equals(accountDetailWrapper.getAccountId())
                        && tempAccountEfa.equals(accountDetailWrapper.getExternalFamilyAccountId())
                        && tempAccountEal.equals(externalApplication.getLabel())) {
                    account = tempAccount;
                    alreadyAddedAccount = true;
                    break;
                }
            }
            // ... if not, load it from DB
            if (account == null) {
                account = accountService.getByExternalAndAccountId(
                        accountDetailWrapper.getExternalFamilyAccountId(), 
                        externalApplication.getId(),
                        accountDetailWrapper.getAccountId());
            }
            if (account == null) {
                log.warn("importAccountDetails() parent account with id " 
                        + accountDetailWrapper.getAccountId() + " for application " 
                        + externalApplication.getLabel() + " has not been found");
                importResultBean.addFailedImport("admin.import_export.parent_element_not_found",
                        accountDetailWrapper.getAccountId());
                importResultBean.setSuccessful(false);
            } else {
                if (!alreadyAddedAccount)
                    stackedAccounts.put(account, new ArrayList<AccountDetail>());
                stackedAccounts.get(account).add(accountDetailWrapper.getAccountDetail());
            }
            
            Payment payment = accountDetailWrapper.getAccountDetail().getPayment();
            // only deposits have a payment ack ...
            // ... and only deposits have to be consolidated
            if (payment != null && payment.getPaymentAck() != null 
                    && !payment.getPaymentAck().equals("")) {
                // first check if we have already met this payment
                if (payments.contains(payment)) {
                    Payment cumulatedPayment = payments.get(payments.indexOf(payment));
                    accountDetailWrapper.getAccountDetail().setPayment(cumulatedPayment);
                } else {
                    // then check if we have an existing payment with this ack
                    Payment paymentFromDb = 
                        paymentService.getByPaymentAck(payment.getPaymentAck());
                    if (paymentFromDb != null) {
                        accountDetailWrapper.getAccountDetail().setPayment(paymentFromDb);
                        payments.add(paymentFromDb);
                    } else {
                        // it does not exist anywhere, add it to the list
                        payments.add(payment);
                    }
                }
            }
        }
        
        if (!importResultBean.isSuccessful())
            return importResultBean;

        for (Account account : stackedAccounts.keySet()) {
            accountService.deleteAccountDetails(account);
            account.setAccountDetailList(stackedAccounts.get(account));
        }
        
        try {
            accountService.saveAccounts(new ArrayList<Account>(stackedAccounts.keySet()));
        } catch (DataAccessException dae) {
            importResultBean.setSuccessful(false);
            importResultBean.setFailMessage(dae.getMessage());
            return importResultBean;
        } catch (CpmBusinessException cpe) {
            cpe.printStackTrace();
            importResultBean.setSuccessful(false);
            importResultBean.setFailMessage(cpe.getMessage());
            return importResultBean;            
        }
        
        importResultBean.setSuccessful(true);
        return importResultBean;
    }
    
    private ImportResultBean importExternalFamilyAccounts(List<Object> parsedData, 
            ExternalApplication externalApplication) {
        
        ImportResultBean importResultBean = new ImportResultBean();

        List<ExternalFamilyAccount> efaToSave = new ArrayList<ExternalFamilyAccount>();
        for (Object object : parsedData) {
            ExternalFamilyAccountWrapper efaWrapper = (ExternalFamilyAccountWrapper) object;
            ExternalFamilyAccount efa = null;
            for (ExternalFamilyAccount tempEfa : efaToSave) {
                if (tempEfa.getExternalFamilyAccountId().equals(efaWrapper.getExternalFamilyAccountId())
                        && tempEfa.getExternalApplication().getLabel().equals(externalApplication.getLabel())) {
                    efa = tempEfa;
                    break;
                }
            }
            if (efa == null) {
                efa = familyAccountService.getExternalFamilyAccount(efaWrapper.getExternalFamilyAccountId(), 
                        externalApplication.getId());
                if (efa == null) {
                    try {
                        efa = familyAccountService.createExternalFamilyAccount(efaWrapper.getExternalFamilyAccountId(), 
                                externalApplication.getId());
                        importResultBean.addCreatedEfa(efaWrapper.getExternalFamilyAccountId());
                        efa.setAddress(efaWrapper.getAddress());
                    } catch (DataAccessException dae) {
                        dae.printStackTrace();
                        importResultBean.setSuccessful(false);
                        importResultBean.setFailMessage(dae.getMessage());
                        return importResultBean;
                    }
                    efa.setIndividuals(new HashSet<ExternalIndividual>());
                } else {
                    // efa existed already, just update address
                    efa.setAddress(efaWrapper.getAddress());
                } 
            } 
            
            ExternalIndividual newExternalIndividual = efaWrapper.getExternalIndividual();
            boolean foundExternalIndividual = false;
            for (ExternalIndividual externalIndividual : efa.getIndividuals()) {
                if (newExternalIndividual.getExternalIndividualId().equals(externalIndividual.getExternalIndividualId())) {
                    log.debug("importExternalFamilyAccounts() external individual already exists");
                    externalIndividual.setFirstName(newExternalIndividual.getFirstName());
                    externalIndividual.setLastName(newExternalIndividual.getLastName());
                    foundExternalIndividual = true;
                    break;
                }
            }
            if (!foundExternalIndividual)
                familyAccountService.addExternalIndividual(efa, efaWrapper.getExternalIndividual());
                
            // TODO : deal with removed external individuals
            
            efaToSave.add(efa);
        }

        importResultBean.setSuccessful(true);
        return importResultBean;
    }

    public void setInvoiceService(IInvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void setContractService(IContractService contractService) {
        this.contractService = contractService;
    }

    public void setFamilyAccountService(IFamilyAccountService familyAccountService) {
        this.familyAccountService = familyAccountService;
    }

    public void setCsvImportService(ICsvImportService csvImportService) {
        this.csvImportService = csvImportService;
    }

    public void setAuditService(IAuditService auditService) {
        this.auditService = auditService;
    }

    public void setPaymentService(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void setExternalApplicationService(
            IExternalApplicationService externalApplicationService) {
        this.externalApplicationService = externalApplicationService;
    }
}
