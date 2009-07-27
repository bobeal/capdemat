package fr.capwebct.modules.payment.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.ExternalFamilyAccount;
import fr.capwebct.modules.payment.business.Invoice;
import fr.capwebct.modules.payment.business.InvoiceDetail;
import fr.capwebct.modules.payment.dao.IInvoiceDAO;
import fr.capwebct.modules.payment.dao.IObjectDAO;
import fr.capwebct.modules.payment.exception.CpmBusinessException;
import fr.capwebct.modules.payment.service.IInvoiceService;

public class InvoiceService implements IInvoiceService {

	private IInvoiceDAO invoiceDAO;
    private IObjectDAO objectDAO;

	private static Log log = LogFactory.getLog(InvoiceService.class);
	
    public InvoiceService() {
        super();
    }

    public void saveInvoice(Invoice invoice) 
        throws DataAccessException, CpmBusinessException {
        
        ExternalFamilyAccount externalFamilyAccount = invoice.getExternalFamilyAccount();
        if (externalFamilyAccount == null)
            throw new CpmBusinessException("invoice.external_family_account_required");
        externalFamilyAccount.addInvoice(invoice);
        objectDAO.update(externalFamilyAccount);
    }
    
	public void saveInvoices(List<Invoice> invoiceList) 
        throws DataAccessException, CpmBusinessException {
        
		for (Invoice invoice : invoiceList) {
            saveInvoice(invoice);
		}
	}

	public void importInvoices(List<Invoice> invoiceList, long externalApplicationId, String broker) 
	    throws DataAccessException, CpmBusinessException {

	    if (externalApplicationId == 0) {
	        log.warn("importInvoices() no external application label provided !");
	        return;
	    }

        List<Invoice> invoices =
            invoiceDAO.findByExternalApplicationAndBroker(externalApplicationId, broker);
        deleteInvoices(invoices);

	    saveInvoices(invoiceList);      
	}

	public Invoice getInvoice(long id, boolean loadCollection) throws DataAccessException {

		Invoice invoice = (Invoice) invoiceDAO.read(Invoice.class, id);
		if (loadCollection)
			invoiceDAO.initializeProxy(invoice.getInvoiceDetailList());
		return invoice;
	}

	public Invoice getInvoiceDetails(long id) throws DataAccessException {
		return getInvoice(id, true);
	}

	public List<Invoice> getAllInvoices() throws DataAccessException {
		return invoiceDAO.findAll(Invoice.class);
	}

	public List<Invoice> search(String invoiceId, String invoiceLabel,
			Date invoicePaymentDateStart, Date invoicePaymentDateEnd,
            String efaId, long externalApplicationId, String broker, 
            final int results, final int startIndex, final String sort, final String dir) 
        throws DataAccessException {
		
		return invoiceDAO.search(invoiceId, invoiceLabel, invoicePaymentDateStart,
				invoicePaymentDateEnd, efaId, externalApplicationId, broker, results, startIndex,
                sort, dir);
	}

    public Long getCountForSearch(String invoiceId, String invoiceLabel,
            Date invoicePaymentDateStart, Date invoicePaymentDateEnd,
            String efaId, long externalApplicationId, String broker)
        throws DataAccessException {
        return invoiceDAO.countForSearch(invoiceId, invoiceLabel, invoicePaymentDateStart,
                invoicePaymentDateEnd, efaId, externalApplicationId, broker);
    }

	public List<Invoice> getByExternalId(String externalFamilyAccountId, long externalApplicationId)
			throws DataAccessException {
		return invoiceDAO.findByExternalId(externalFamilyAccountId, externalApplicationId);
	}

    public List<Invoice> getByPaymentId(long paymentId) throws DataAccessException {
        return invoiceDAO.findByPaymentId(paymentId);
    }

    public Invoice getByExternalAndInvoiceId(String externalFamilyAccountId, 
            long externalApplicationId, String invoiceId)
        throws DataAccessException {

        Invoice invoice = invoiceDAO.findByExternalAndInvoiceId(externalFamilyAccountId, 
                externalApplicationId, invoiceId);
        if (invoice != null)
            invoiceDAO.initializeProxy(invoice.getInvoiceDetailList());
        return invoice;
    }

    public List<InvoiceDetail> getInvoiceDetails(String externalFamilyAccountId, 
            long externalApplicationId, String invoiceId) throws DataAccessException {
        
        Invoice invoice = 
            getByExternalAndInvoiceId(externalFamilyAccountId, externalApplicationId, invoiceId);
        if (invoice == null)
            return null;
        else
            return invoice.getInvoiceDetailList();
    }

    public void deleteInvoiceDetails(Invoice invoice) throws DataAccessException {
        List<InvoiceDetail> invoiceDetails = invoice.getInvoiceDetailList();
        if (invoiceDetails != null) {
            invoice.setInvoiceDetailList(null);
            for (InvoiceDetail invoiceDetail : invoiceDetails) {
                objectDAO.delete(invoiceDetail);
            }
        }
    }
        
    public void deleteInvoice(Invoice invoice) throws DataAccessException {
        invoice.getExternalFamilyAccount().removeInvoice(invoice);
        invoiceDAO.delete(invoice);
    }

    public void deleteInvoices(List<Invoice> invoiceList) throws DataAccessException {
    	if (invoiceList == null)
    		return;
    	
		for (Invoice invoice : invoiceList) {
		    deleteInvoice(invoice);
        }
	}
	
	public void deleteAllInvoices() throws DataAccessException {
        deleteInvoices(getAllInvoices());
	}
	
	public void setInvoiceDAO(IInvoiceDAO invoiceDAO) {
		this.invoiceDAO = invoiceDAO;
	}

    public void setObjectDAO(IObjectDAO objectDAO) {
        this.objectDAO = objectDAO;
    }
}
