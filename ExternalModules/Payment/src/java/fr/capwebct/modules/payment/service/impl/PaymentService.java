package fr.capwebct.modules.payment.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.Account;
import fr.capwebct.modules.payment.business.AccountDetail;
import fr.capwebct.modules.payment.business.Contract;
import fr.capwebct.modules.payment.business.ContractDetail;
import fr.capwebct.modules.payment.business.Invoice;
import fr.capwebct.modules.payment.business.Payment;
import fr.capwebct.modules.payment.business.ws.AccountUpdate;
import fr.capwebct.modules.payment.business.ws.ContractUpdate;
import fr.capwebct.modules.payment.business.ws.InvoiceUpdate;
import fr.capwebct.modules.payment.business.ws.PaymentTransaction;
import fr.capwebct.modules.payment.dao.IPaymentDAO;
import fr.capwebct.modules.payment.exception.CpmBusinessException;
import fr.capwebct.modules.payment.service.IAccountService;
import fr.capwebct.modules.payment.service.IContractService;
import fr.capwebct.modules.payment.service.IInvoiceService;
import fr.capwebct.modules.payment.service.IPaymentService;

public class PaymentService implements IPaymentService {

    private static Log log = LogFactory.getLog(PaymentService.class);

    private IPaymentDAO paymentDAO;

    private IAccountService accountService;
    private IInvoiceService invoiceService;
    private IContractService contractService;

    public Payment getByPaymentAck(final String paymentAck) throws DataAccessException {
        return paymentDAO.findByPaymentAck(paymentAck);
    }

    public List<Payment> getAllPayments() throws DataAccessException {
        return paymentDAO.findAll();
    }

    public List<Payment> search(final Date paymentDateStart, final Date paymentDateEnd, 
            final String paymentAck, final String cvqAck, final long externalApplicationId, 
            final String broker, boolean filterExported) 
        throws DataAccessException {
        
        return paymentDAO.search(paymentDateStart, paymentDateEnd, paymentAck, cvqAck, 
                externalApplicationId, broker, filterExported);
    }
    
    public void savePayment(Payment payment) throws DataAccessException {
        // TODO : add business checks (unicity of acks, ...)
        paymentDAO.create(payment);
    }

    public void deletePayment(Payment payment) throws DataAccessException {
        paymentDAO.delete(payment);
    }

    public void deleteAllPayments() throws DataAccessException {
        paymentDAO.deleteAll();
    }

    private void creditAccount(AccountUpdate accountUpdate, Payment payment)
            throws DataAccessException {
        
        Account account = 
            accountService.getByExternalAndAccountId(
                    accountUpdate.getExternalFamilyAccountId(), 
                    accountUpdate.getExternalApplicationId(),
                    accountUpdate.getAccountId());

        AccountDetail accountDetail = new AccountDetail();
        accountDetail.setPayment(payment);
        int updateAmount = accountUpdate.getAccountNewValue() - accountUpdate.getAccountOldValue();
        accountDetail.setValue(updateAmount);

        account.setAccountValue(account.getAccountValue() + updateAmount);
        // update account date to payment's date
        account.setAccountDate(payment.getPaymentDate());
        account.addAccountDetail(accountDetail);
        try {
            accountService.saveAccount(account);
        } catch (CpmBusinessException e) {
            // can't happen since we are only modifying an already persisted instance
        }
    }

    private void creditContract(ContractUpdate contractUpdate, Payment payment)
            throws DataAccessException {

        Contract contract = 
            contractService.getByExternalAndAccountId(contractUpdate.getExternalFamilyAccountId(), 
                    contractUpdate.getExternalApplicationId(), 
                    contractUpdate.getExternalIndividualId(), 
                    contractUpdate.getContractId());

        ContractDetail contractDetail = new ContractDetail();
        contractDetail.setAmount(contractUpdate.getAmount());
        contractDetail.setPrice(contractUpdate.getPrice());
        contractDetail.setQuantity(contractUpdate.getQuantity());
        contractDetail.setPayment(payment);
        contract.setContractValue(contract.getContractValue() + contractUpdate.getQuantity());
        // update contract date to payment's date
        contract.setContractDate(payment.getPaymentDate());
        contract.addContractDetail(contractDetail);

        try {
            contractService.saveContract(contract);
        } catch (CpmBusinessException e) {
            // can't happen since we are only modifying an already persisted instance
        }
    }

    private void payInvoice(InvoiceUpdate invoiceUpdate, Payment payment) 
        throws DataAccessException {
        
        Invoice invoice = 
            invoiceService.getByExternalAndInvoiceId(invoiceUpdate.getExternalFamilyAccountId(), 
                    invoiceUpdate.getExternalApplicationId(),
                    invoiceUpdate.getInvoiceId());
        invoice.setInvoicePayed(true);
        invoice.setInvoicePaymentDate(payment.getPaymentDate());
        invoice.setPayment(payment);
        try {
            invoiceService.saveInvoice(invoice);
        } catch (CpmBusinessException e) {
            // can't happen since we are only modifying an already persisted instance
        }
    }

    public void creditFamilyAccount(PaymentTransaction paymentTransaction)
            throws DataAccessException {

        log.debug("creditFamilyAccount() received a payment transaction");

        Payment payment = paymentTransaction.getPayment();
        payment.setPaymentType("CB");
        payment.setExported(false);
        
        if (paymentTransaction.getAccountUpdates() != null) {
            for (AccountUpdate accountUpdate : paymentTransaction.getAccountUpdates()) {
                log.debug("creditFamilyAccount() updating account " 
                        + accountUpdate.getAccountId());                
                creditAccount(accountUpdate, payment);
            }
        }
        
        if (paymentTransaction.getInvoiceUpdates() != null) {
            for (InvoiceUpdate invoiceUpdate : paymentTransaction.getInvoiceUpdates()) {
                log.debug("creditFamilyAccount() updating invoice " 
                        + invoiceUpdate.getInvoiceId());                
                payInvoice(invoiceUpdate, payment);
            }
        }
        
        if (paymentTransaction.getContractUpdates() != null) {
            for (ContractUpdate contractUpdate : paymentTransaction.getContractUpdates()) { 
                log.debug("creditFamilyAccount() updating contract " 
                        + contractUpdate.getContractId());                
                creditContract(contractUpdate, payment);
            }
        }
    }


    public void exportPayments() throws DataAccessException {
        log.debug("exportPayments() running ...");
    }

    public void setPaymentDAO(IPaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void setContractService(IContractService contractService) {
        this.contractService = contractService;
    }

    public void setInvoiceService(IInvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }
}
