package fr.capwebct.capdemat.plugins.paymentproviders.tipi.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.payment.ExternalAccountItem;
import fr.cg95.cvq.business.payment.Payment;
import fr.cg95.cvq.business.payment.PaymentMode;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.payment.IPaymentProviderService;
import fr.cg95.cvq.service.payment.PaymentResultBean;
import fr.cg95.cvq.service.payment.PaymentResultStatus;
import fr.cg95.cvq.service.payment.PaymentServiceBean;



public class TipiService implements IPaymentProviderService {
    
    private String paymentUrl;
    private String callbackUrl;
    
    private String label;
    private static Logger logger = Logger.getLogger(TipiService.class);
    private static final String TIPI_NUMCLI = "numcli";

    private static final Random random = new Random();

    public void init() throws CvqException {
        if(paymentUrl == null || callbackUrl == null)
            throw new CvqException("No payment URL provided!");
    }

    @Override
    public URL doInitPayment(Payment payment, PaymentServiceBean paymentServiceBean)
            throws CvqException {
        
        StringBuffer urlParameters = new StringBuffer();
        
        String tipiNumCli = (String) paymentServiceBean.getProperty(TIPI_NUMCLI);
        urlParameters.append("&numcli="+tipiNumCli);
        
        String tipiExer = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        urlParameters.append("&exer="+tipiExer);
        
        if(!(payment.getPurchaseItems().iterator().next() instanceof ExternalAccountItem))
            throw new CvqException("PurchaseItem is not an ExternalAccountItem and cannot be paid with Tipi");
        String reference = ((ExternalAccountItem) payment.getPurchaseItems().iterator().next()).getExternalItemId();
        urlParameters.append("&refdet="+reference);
        payment.setCvqReference(reference);

        String tipiObjet = "Paiement CapDemat";

        urlParameters.append("&objet="+tipiObjet);
        
        String tipiMontant = String.valueOf(payment.getAmount().intValue());
        urlParameters.append("&montant="+tipiMontant);
        
        String homeFolderResponsibleEmail = payment.getPaymentSpecificDataByKey(Payment.SPECIFIC_DATA_EMAIL);
        if (homeFolderResponsibleEmail != null && !homeFolderResponsibleEmail.equals("")) {
            urlParameters.append("&mel=").append(homeFolderResponsibleEmail);
        }

        String tipiUrlCl = "https://"+SecurityContext.getCurrentConfigurationBean().getDefaultServerName()+this.callbackUrl;
        urlParameters.append("&urlcl="+tipiUrlCl);
        
        urlParameters.append("&openInPopUp=true");
        urlParameters.append("&saisie=T");
        
        String url2 = paymentUrl + urlParameters;
        
        URL url = null;
        try {
            url = new URL(url2);
        } catch (MalformedURLException mue) {
            logger.error("initPayment() Error while creating URL object");
            mue.printStackTrace();
            throw new CvqException();
        }
        
        logger.debug("initPayment() Returning URL : "+ url.toString());
        return url;
    }

    @Override
    public PaymentResultBean doCommitPayment(Map<String, String> parameters,
            PaymentServiceBean paymentServiceBean) throws CvqException {
        PaymentResultStatus returnStatus = getStateFromParameters(parameters, paymentServiceBean);
        return new PaymentResultBean(returnStatus, parameters.get("refdet"), parameters.get("bankReference"));
    }

    @Override
    public void checkConfiguration(PaymentServiceBean paymentServiceBean)
            throws CvqConfigurationException {
        String tipiCli = (String) paymentServiceBean.getProperty(TIPI_NUMCLI);
        if(tipiCli == null)
            throw new CvqConfigurationException("Missing Tipi client number");
        
    }

    @Override
    public PaymentMode getPaymentMode() {
        return PaymentMode.INTERNET;
    }

    @Override
    public boolean handleParameters(Map<String, String> parameters) {
        return parameters.containsKey("resultrans");
    }

    @Override
    public PaymentResultStatus getStateFromParameters(Map<String, String> parameters,
            PaymentServiceBean paymentServiceBean) throws CvqException {
        if(!handleParameters(parameters))
            return PaymentResultStatus.UNKNOWN;
        
        String bankTransactionStatus = parameters.get("resultrans");
        
        if (bankTransactionStatus.equals("P")) {
            return PaymentResultStatus.OK;
        } else if (bankTransactionStatus.equals("R")) {
            return PaymentResultStatus.REFUSED;
        } else {
            return PaymentResultStatus.UNKNOWN;
        }
    }
    public void setPaymentUrl(String pu) { this.paymentUrl = pu; }
    public void setCallbackUrl(String cu) { this.callbackUrl = cu; }
    public void setLabel(String label) { this.label = label; }
}