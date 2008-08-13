package fr.capwebct.modules.payment.service;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.ExternalFamilyAccount;
import fr.capwebct.modules.payment.business.Invoice;
import fr.capwebct.modules.payment.exception.CpmBusinessException;
import fr.capwebct.modules.payment.testtool.BusinessObjectsFactory;
import fr.capwebct.modules.payment.testtool.ServiceTestCase;

public class InvoiceServiceTest extends ServiceTestCase {

	public void testSaveAndLoadInvoiceList() {
        ExternalFamilyAccount externalFamilyAccount = 
            familyAccountService.createExternalFamilyAccount("FAMILY_1", externalApplication.getId());
		List<Invoice> invoiceList = 
            BusinessObjectsFactory.gimmeTenInvoices("invoice", externalFamilyAccount);
		try {
			invoiceService.saveInvoices(invoiceList);
			Invoice invoice = invoiceService.getInvoiceDetails(invoiceList.get(1).getId());
			assertEquals(invoice, invoiceList.get(1));
			assertEquals(invoice.getInvoiceDetailList().size(), 10);
			assertEquals(invoice.getInvoiceLabel(), "invoice");
            ExternalFamilyAccount efa = invoice.getExternalFamilyAccount();
            assertNotNull(efa);
			assertEquals("FAMILY_1", efa.getExternalFamilyAccountId());
			assertEquals(invoice.isInvoicePayed(), false);

			List fetchList = invoiceService.getAllInvoices();
			assertEquals(fetchList.size(), 10);
			
		} catch (DataAccessException e) {
			assertNull(e);
        } catch (CpmBusinessException cpe) {
            cpe.printStackTrace();
            assertNull(cpe);
		} finally {
			// Delete localy testing data
			invoiceService.deleteInvoices(invoiceList);
		}
	}

	public void testSearchInvoice() {
        ExternalFamilyAccount externalFamilyAccount = 
            familyAccountService.createExternalFamilyAccount("FAMILY_1", externalApplication.getId());
        List<Invoice> invoiceList = 
            BusinessObjectsFactory.gimmeTenInvoices("invoice", externalFamilyAccount);
		try {
			invoiceService.saveInvoices(invoiceList);
			List fetchList = invoiceService.search(null, "invoice", null, null, null, 0);
			assertEquals(fetchList.size(), 10);
			fetchList = invoiceService.search("invoice_3", null, null, null, null, 0);
			assertEquals(fetchList.size(), 1);
			fetchList = invoiceService.search(null, "in", null, new Date(), null, 0);
			assertEquals(fetchList.size(), 10);

		} catch (DataAccessException e) {
			assertNull(e);
        } catch (CpmBusinessException cpe) {
            cpe.printStackTrace();
            assertNull(cpe);
		} finally {
			// Delete localy testing data
			invoiceService.deleteInvoices(invoiceList);
		}
	}

	public void testFindByExternalId() {
        ExternalFamilyAccount externalFamilyAccount = 
            familyAccountService.createExternalFamilyAccount("FAMILY_1", externalApplication.getId());
        List<Invoice> invoiceList = 
            BusinessObjectsFactory.gimmeTenInvoices("invoice", externalFamilyAccount);
		try {
			invoiceService.saveInvoices(invoiceList);
			List fetchList = 
                invoiceService.getByExternalId("FAMILY_1", externalApplication.getId());
			assertEquals(10, fetchList.size());
			fetchList = invoiceService.getByExternalId("Blop", 0);
			assertEquals(0, fetchList.size());
			
		} catch (DataAccessException e) {
			assertNull(e);
        } catch (CpmBusinessException cpe) {
            cpe.printStackTrace();
            assertNull(cpe);
		} finally {
			// Delete localy testing data
			invoiceService.deleteInvoices(invoiceList);
		}
	}
	
	public void testFindByExternalAndInvoiceId() {
        ExternalFamilyAccount externalFamilyAccount = 
            familyAccountService.createExternalFamilyAccount("FAMILY_1", externalApplication.getId());
        List<Invoice> invoiceList = 
            BusinessObjectsFactory.gimmeTenInvoices("invoice", externalFamilyAccount);
		try {
			invoiceService.saveInvoices(invoiceList);
			Invoice invoice = 
                invoiceService.getByExternalAndInvoiceId("FAMILY_1", 
                        externalApplication.getId(), "invoice_1");
			assertEquals(invoice, invoiceService.getInvoice(invoiceList.get(1).getId(),false));
			invoice = invoiceService.getByExternalAndInvoiceId("",0,"");
			assertEquals(null, invoice);
			
		} catch (DataAccessException e) {
			assertNull(e);
        } catch (CpmBusinessException cpe) {
            cpe.printStackTrace();
            assertNull(cpe);
		} finally {
			// Delete localy testing data
			invoiceService.deleteInvoices(invoiceList);
		}
	}
	
	public void testImportInvoices() {
        ExternalFamilyAccount externalFamilyAccount = 
            familyAccountService.createExternalFamilyAccount("FAMILY_1", externalApplication.getId());
        List<Invoice> invoiceList = 
            BusinessObjectsFactory.gimmeTenInvoices("invoice", externalFamilyAccount);
		try {
			invoiceService.importInvoices(invoiceList, externalApplication.getId());
			
			List fetchList = invoiceService.getAllInvoices();
			assertEquals(fetchList.size(), 10);
			
		} catch (DataAccessException e) {
			assertNull(e);
        } catch (CpmBusinessException cpe) {
            cpe.printStackTrace();
            assertNull(cpe);
		} finally {
			// Delete localy testing data
			invoiceService.deleteInvoices(invoiceList);
		}
	}
	
	public void testDeleteInvoice() {
        ExternalFamilyAccount externalFamilyAccount = 
            familyAccountService.createExternalFamilyAccount("FAMILY_1", externalApplication.getId());
	    List<Invoice> invoiceList = 
            BusinessObjectsFactory.gimmeTenInvoices("invoice_delete", externalFamilyAccount);
		try {
			invoiceService.saveInvoices(invoiceList);
            List fetchList = invoiceService.getAllInvoices();
            assertEquals(10, fetchList.size());
			
			invoiceService.deleteInvoices(invoiceList);			
			fetchList = invoiceService.getAllInvoices();
			assertEquals(0, fetchList.size());
			
		} catch (DataAccessException e) {
			assertNull(e);
        } catch (CpmBusinessException cpe) {
            cpe.printStackTrace();
            assertNull(cpe);
		}
	}
}
