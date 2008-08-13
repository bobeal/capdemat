package fr.capwebct.modules.payment.service.impl;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.capwebct.modules.payment.business.ExternalApplication;
import fr.capwebct.modules.payment.business.Invoice;
import fr.capwebct.modules.payment.business.Payment;
import fr.capwebct.modules.payment.exception.CpmBusinessException;
import fr.capwebct.modules.payment.service.IExportService;
import fr.capwebct.modules.payment.service.IExternalApplicationService;
import fr.capwebct.modules.payment.service.IFtpService;
import fr.capwebct.modules.payment.service.IInvoiceService;
import fr.capwebct.modules.payment.service.IPaymentService;

/**
 * Implementation of the {@link IExportService} that handles Axel-compatible export of payments.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class AxelExportService implements IExportService {

    private static Log log = LogFactory.getLog(AxelExportService.class);
    
    private boolean enabled;
    
    private IFtpService ftpService;
    private IExternalApplicationService externalApplicationService;
    private IPaymentService paymentService;
    private IInvoiceService invoiceService;
    
    public void exportPayments() throws CpmBusinessException {
        
        if (!enabled) {
            log.info("exportPayments() AXEL export service is not enabled, returning");
            return;
        }
        
        Date now = new Date();
        Calendar calendarEndSearch = new GregorianCalendar();
        calendarEndSearch.setTime(now);
        calendarEndSearch.set(Calendar.HOUR_OF_DAY, 0);
        calendarEndSearch.set(Calendar.MINUTE, 0);
        calendarEndSearch.set(Calendar.SECOND, 0);
        
        Calendar calendarStartSearch = new GregorianCalendar();
        calendarStartSearch.setTime(calendarEndSearch.getTime());
        
        List<ExternalApplication> externalApplications = externalApplicationService.getAll();
        for (ExternalApplication externalApplication : externalApplications) {
            for (String broker : externalApplication.getBrokers()) {
                List<Payment> payments =
                    paymentService.search(calendarStartSearch.getTime(), 
                            calendarEndSearch.getTime(), null, null, 0, broker);
                createAndExportPaymentsFile(payments);
            }
        }
    }

    private void createAndExportPaymentsFile(List<Payment> payments) throws CpmBusinessException {
        
        // create the export file
        Date now = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(now);
        
        NumberFormat invoiceIdFormatter = new DecimalFormat("#####");
        NumberFormat paymentIdFormatter = new DecimalFormat("0000");
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.FRANCE);
        NumberFormat invoiceValueFormatter = new DecimalFormat("######.00", decimalFormatSymbols);
        invoiceValueFormatter.setGroupingUsed(false);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        StringBuffer sb = new StringBuffer();
        for (Payment payment : payments) {
            List<Invoice> invoices = invoiceService.getByPaymentId(payment.getId());
            for (Invoice invoice : invoices) {
                // payment id formatted as a 4-digit number
                sb.append(paymentIdFormatter.format(payment.getId()))
                    .append("\t");
                    
                    // version number - removed (temporarily ?)
                    // .append("240")
                    // .append("\t");
                
                String truncatedInvoiceId = invoice.getInvoiceId().substring(1);
                String formattedInvoiceId = null;
                try {
                    formattedInvoiceId = invoiceIdFormatter.format(Long.valueOf(truncatedInvoiceId));
                } catch (NumberFormatException nfe) {
                    log.error("exportPayments() error parsing invoice id : " + invoice.getInvoiceId());
                    throw new CpmBusinessException();
                } catch (IllegalArgumentException iae) {
                    log.error("exportPayments() error parsing invoice id : " + invoice.getInvoiceId());
                    throw new CpmBusinessException();
                }
                // AXEL invoice id without the first character
                sb.append(formattedInvoiceId)
                    .append("xx")
                    // AXEL family account id
                    .append(invoice.getExternalFamilyAccount().getExternalFamilyAccountId())
                    // current year
                    .append(calendar.get(Calendar.YEAR))
                    .append("x")
                    // FIXME : wait for SP-PLUS to have the real value of this one
                    //              should be "arg1" in SP-PLUS data
                    .append("SPPL")
                    .append("\t")
                    // the number "1" concatenated with SP-PLUS payment reference
                    .append("1").append(payment.getPaymentAck().substring(0, 5))
                    .append("\t")
                    // AXEL family account id
                    .append(invoice.getExternalFamilyAccount().getExternalFamilyAccountId())
                    .append("\t")
                    // AXEL invoice id
                    .append(invoice.getInvoiceId())
                    .append("\t")
                    // Payment's broker
                    .append(invoice.getBroker())
                    .append("\t");
                
                double invoiceValueInEuros = 
                    Integer.valueOf(invoice.getInvoiceValue()).floatValue() / 100.00;
                sb.append(invoiceValueFormatter.format(invoiceValueInEuros))
                    .append("\t")
                    .append(dateFormat.format(payment.getPaymentDate()))
                    .append("\n");
            }
        }
        log.debug("exportPayments() " + sb.toString());
        
        // put it on the configured FTP/HTTP server
        // TODO : filename ?
        String filename = "export_paiement_capdemat_" + now.toString();
        ftpService.uploadData(sb.toString().getBytes(), filename);
    }
    
    public void setPaymentService(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void setInvoiceService(IInvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public void setFtpService(IFtpService ftpService) {
        this.ftpService = ftpService;
    }

    public void setExternalApplicationService(
            IExternalApplicationService externalApplicationService) {
        this.externalApplicationService = externalApplicationService;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
