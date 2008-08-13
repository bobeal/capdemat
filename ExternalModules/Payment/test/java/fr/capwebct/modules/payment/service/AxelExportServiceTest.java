package fr.capwebct.modules.payment.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.context.ConfigurableApplicationContext;

import fr.capwebct.modules.payment.business.ExternalApplication;
import fr.capwebct.modules.payment.business.ExternalFamilyAccount;
import fr.capwebct.modules.payment.business.Invoice;
import fr.capwebct.modules.payment.business.Payment;
import fr.capwebct.modules.payment.testtool.BusinessObjectsFactory;
import fr.capwebct.modules.payment.testtool.ServiceTestCase;

public class AxelExportServiceTest extends ServiceTestCase {

    private IExportService exportService;
    
    protected void onSetUp() throws Exception {
        super.onSetUp();
        
        ConfigurableApplicationContext cac = getContext(getConfigLocations());
        exportService = (IExportService) cac.getBean("axelExportService");
    }
    
    public void testAxelExport() throws Exception {
        
        // set our payment in the past (either it won't be exported)
        Date now = new Date();
        Calendar paymentCalendar = new GregorianCalendar();
        paymentCalendar.setTime(now);
        paymentCalendar.add(Calendar.DAY_OF_YEAR, -1);

        ExternalApplication externalApplication = new ExternalApplication();
        externalApplication.setLabel("Axel");
        externalApplication.addBroker("RégieSPPLU");
        externalApplicationService.create(externalApplication);
        ExternalFamilyAccount externalFamilyAccount = 
            familyAccountService.createExternalFamilyAccount("1234", 
                    externalApplication.getId());
        Payment payment = BusinessObjectsFactory.gimmePayment("PAYMENT", 100);
        payment.setPaymentDate(paymentCalendar.getTime());
        Invoice invoice = BusinessObjectsFactory.gimmeInvoice("INVOICE", 100);
        invoice.setInvoiceId("123456");
        invoice.setPayment(payment);
        invoice.setBroker("RégieSPPLU");
        invoice.setExternalFamilyAccount(externalFamilyAccount);
        invoiceService.saveInvoice(invoice);

        exportService.exportPayments();
    }
}
