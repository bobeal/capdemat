package fr.capwebct.modules.payment.dao;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.Invoice;

public interface IInvoiceDAO extends IGenericDAO<Invoice, Long> {

	List<Invoice> search(String invoiceId, String invoiceLabel,
			Date invoicePaymentDateStart, Date invoicePaymentDateEnd,
            String efaId, long externalApplicationId, String broker, 
            final int results, final int startIndex, final String sort, final String dir) 
        throws DataAccessException;

    Long countForSearch(String invoiceId, String invoiceLabel,
            Date invoicePaymentDateStart, Date invoicePaymentDateEnd,
            String efaId, long externalApplicationId, String broker)
        throws DataAccessException;

	List<Invoice> findByExternalId(String externalFamilyAccountId,
			long externalApplicationId) throws DataAccessException;

    Invoice findByExternalAndInvoiceId(String externalFamilyAccountId,
            long externalApplicationId, String invoiceId) throws DataAccessException;

    List<Invoice> findByPaymentId(long paymentId) throws DataAccessException;
    
    List<Invoice> findByExternalApplicationAndBroker(final long externalApplicationId,
            final String broker) throws DataAccessException;
}
