package fr.capwebct.modules.payment.service;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.Invoice;
import fr.capwebct.modules.payment.business.InvoiceDetail;
import fr.capwebct.modules.payment.exception.CpmBusinessException;

public interface IInvoiceService {

    /**
     * Save an invoice. Detail list will also be saved.
     * 
     * @throws CpmBusinessException if an invoice has no external family account associated
     */
    void saveInvoice(Invoice invoice) 
        throws DataAccessException, CpmBusinessException;
    
    /**
     * Save a list of invoices. Detail list will also be saved.
     * 
     * @throws CpmBusinessException if an invoice has no external family account associated
     */
    void saveInvoices(List<Invoice> invoiceList) 
        throws DataAccessException, CpmBusinessException;
    
    /**
     * Import a list of invoices for the given external application. Existing invoices
     * for this external application will first be deleted.
     * 
     * @throws CpmBusinessException if an invoice has no external family account associated
     */
    void importInvoices(List<Invoice> invoiceList, long externalApplicationId, String broker) 
        throws DataAccessException, CpmBusinessException;

    Invoice getInvoice(long id, boolean loadCollection) throws DataAccessException;

	Invoice getInvoiceDetails(long id) throws DataAccessException;

	List<Invoice> getAllInvoices() throws DataAccessException;

	List<Invoice> search(String invoiceId, String invoiceLabel,
	        Date invoicePaymentDateStart, Date invoicePaymentDateEnd,
	        String efaId, long externalApplicationId, String broker,
	        final int results, final int startIndex, final String sort, final String dir) 
        throws DataAccessException;

    Long getCountForSearch(String invoiceId, String invoiceLabel,
            Date invoicePaymentDateStart, Date invoicePaymentDateEnd,
            String efaId, long externalApplicationId, String broker)
        throws DataAccessException;

	List<Invoice> getByExternalId(String externalFamilyAccountId, long externalApplicationId)
			throws DataAccessException;
	
    List<Invoice> getByPaymentId(long paymentId)
        throws DataAccessException;
    
    Invoice getByExternalAndInvoiceId(String externalFamilyAccountId, 
            long externalApplicationId, String invoiceId)
        throws DataAccessException;
    
    List<InvoiceDetail> getInvoiceDetails(String externalFamilyAccountId, 
            long externalApplicationId, String invoiceId)
        throws DataAccessException;
    
    /**
     * Delete detail list for the given invoice.
     */
    void deleteInvoiceDetails(Invoice invoice) throws DataAccessException;

    void deleteInvoice(Invoice invoice) throws DataAccessException;
	
	void deleteInvoices(List<Invoice> invoieList) throws DataAccessException;
	
	void deleteAllInvoices() throws DataAccessException;
}
