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
import fr.capwebct.modules.payment.business.ExternalDataType;
import fr.capwebct.modules.payment.business.Invoice;
import fr.capwebct.modules.payment.business.Payment;
import fr.capwebct.modules.payment.exception.CpmBusinessException;
import fr.capwebct.modules.payment.security.SecurityContext;
import fr.capwebct.modules.payment.service.IExportService;
import fr.capwebct.modules.payment.service.IExternalApplicationService;
import fr.capwebct.modules.payment.service.IFtpService;
import fr.capwebct.modules.payment.service.IImportService;
import fr.capwebct.modules.payment.service.IInvoiceService;
import fr.capwebct.modules.payment.service.IPaymentService;
import fr.capwebct.modules.payment.service.ImportResultBean;

/**
 * Implementation of the {@link IExportService} that handles Axel-compatible export of payments.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class AxelConnectorService implements IExportService {

    private static Log log = LogFactory.getLog(AxelConnectorService.class);
    
    private boolean enabled;
    
    private IFtpService ftpService;
    private IExternalApplicationService externalApplicationService;
    private IPaymentService paymentService;
    private IInvoiceService invoiceService;
    
    private IImportService importService;
    
    /**
     * Date format used in files names.
     */
    private DateFormat fileDateFormat = new SimpleDateFormat("yyyyMMdd");
    
    public void exportPayments() throws CpmBusinessException {
        
        if (!enabled) {
            log.info("exportPayments() AXEL service is not enabled, returning");
            return;
        }
                
        List<ExternalApplication> externalApplications = externalApplicationService.getAll();
        for (ExternalApplication externalApplication : externalApplications) {
            for (String broker : externalApplication.getBrokers()) {
                List<Payment> payments =
                    paymentService.search(null, null, null, null, 0, broker, true);
                createAndExportPaymentsFile(payments, broker);
            }
        }
    }

    private void createAndExportPaymentsFile(List<Payment> payments, String broker) 
    	throws CpmBusinessException {
        
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
        String filename = "paiement_" 
        	+ broker + "_" + fileDateFormat.format(now) + ".txt";
        boolean result = ftpService.uploadData(sb.toString().getBytes(), filename);
        
        // if upload is successful on FTP, flag payments as exported
        if (result) {
        	for (Payment payment : payments) {
        		payment.setExported(true);
        		paymentService.savePayment(payment);        	
        	}
        }
    }
    
    public void importData() throws CpmBusinessException {
        
        if (!enabled) {
            log.info("importData() AXEL service is not enabled, returning");
            return;
        }
        
        StringBuffer errorReportBuffer = new StringBuffer();
        
        SecurityContext.setSpecialAdminContext();
        
        ExternalApplication externalApplication = null;
        for (ExternalApplication tempApp : externalApplicationService.getAll()) {
        	if (tempApp.getLabel().toLowerCase().indexOf("axel") != -1)
        		externalApplication = tempApp;
        }
        log.debug("importData() using external application : " + externalApplication.getLabel());
        
        boolean succeeded = true;
        Date now = new Date();
        
        String familleFilename = "Famille.txt";
        byte[] data = ftpService.getData(familleFilename);
        if (data != null) {
        	try {
        		ImportResultBean irb = importService.importExternalData("CSV",
        				externalApplication.getId(), null, ExternalDataType.EXTERNAL_FAMILY_ACCOUNT, 
        				data, null);
        		log.debug("importData() imported " + irb.getImportedLines() 
        				+ " lines for family accounts");
        	} catch (CpmBusinessException cbe) {
        		log.error("importData() could not import external family accounts : " 
        				+ cbe.getMessage());
        		errorReportBuffer.append("Erreur lors de l'import des comptes : ")
        			.append(cbe.getMessage()).append("\n");
        		succeeded = false;
        	}
        	
        	String destFamilleFilename = "Famille_" + fileDateFormat.format(now);
        	if (succeeded)
        		destFamilleFilename += "_succes.txt";
        	else
        		destFamilleFilename += "_erreur.txt";
    		ftpService.renameFile(familleFilename, destFamilleFilename);        		
        }
        
        for (String broker : externalApplication.getBrokers()) {
        	String invoicesFilename = "Facture_" + broker + ".txt";
        	String invoicesDetailsFilename = "LigneFacture_" + broker + ".txt";
        	
        	byte[] invoicesData = ftpService.getData(invoicesFilename);
        	byte[] invoicesDetailsData = ftpService.getData(invoicesDetailsFilename);
        	if (invoicesData != null) {
        		try {
        			ImportResultBean irb = importService.importExternalData("CSV",
        					externalApplication.getId(), broker, ExternalDataType.INVOICE, 
        					invoicesData, invoicesDetailsData);
        			log.debug("importData() imported " + irb.getImportedLines() + " lines for invoices");
        		} catch (CpmBusinessException cbe) {
        			log.error("importData() could not import invoices : " + cbe.getMessage());
        			cbe.printStackTrace();
        			errorReportBuffer.append("Erreur lors de l'import des factures pour la régie ")
        				.append(broker).append(" : ")
        				.append(cbe.getMessage()).append("\n");
        			succeeded = false;
        		}
        	}
        	
        	String destFamilleFilenameSuffix = broker + "_" + fileDateFormat.format(now);
        	if (succeeded)
        		destFamilleFilenameSuffix += "_succes.txt";
        	else
        		destFamilleFilenameSuffix += "_erreur.txt";
    		ftpService.renameFile(invoicesFilename, "Facture_" + destFamilleFilenameSuffix);        		
    		ftpService.renameFile(invoicesDetailsFilename, "LigneFacture_" + destFamilleFilenameSuffix);        		
        }
        
        // put the eventual errors report on the configured FTP/HTTP server
        String filename = "rapport_import_" + fileDateFormat.format(now) + ".txt";
        ftpService.uploadData(errorReportBuffer.toString().getBytes(), filename);

        SecurityContext.resetCurrentAgent();
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

	public void setImportService(IImportService importService) {
		this.importService = importService;
	}

	public void setExternalApplicationService(
            IExternalApplicationService externalApplicationService) {
        this.externalApplicationService = externalApplicationService;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
