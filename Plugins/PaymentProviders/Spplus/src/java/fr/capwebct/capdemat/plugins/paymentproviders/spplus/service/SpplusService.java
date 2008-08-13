package fr.capwebct.capdemat.plugins.paymentproviders.spplus.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;

import fr.capwebct.capdemat.plugins.paymentproviders.spplus.crypto.sha;
import fr.capwebct.capdemat.plugins.paymentproviders.spplus.utils.URLEncryption;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.business.users.payment.PaymentMode;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.payment.IPaymentProviderService;
import fr.cg95.cvq.payment.PaymentResultBean;
import fr.cg95.cvq.payment.PaymentResultStatus;
import fr.cg95.cvq.payment.PaymentServiceBean;

public class SpplusService implements IPaymentProviderService {

    private static Logger logger = Logger.getLogger(SpplusService.class);

    private String label;
    
    private static final String SPPLUS_MERCHKEY = "spplusMerchkey";
    private static final String SPPLUS_SIRET = "spplusSiret";
    private static final String SPPLUS_USER_CALLBACK_URL = "spplusUserCallbackUrl";
    private static final String SPPLUS_VERSION = "spplusVersion";
    
    private static final Random random = new Random();
    
    private String paymentUrl;
    
    private NumberFormat numberFormat = new DecimalFormat("###0.00", new DecimalFormatSymbols(Locale.US));
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public void init() throws CvqException {
        if (paymentUrl == null)
            throw new CvqException("No payment URL provided !");
    }
    
    public URL doInitPayment(Payment payment, PaymentServiceBean paymentServiceBean)
        throws CvqException {
        
        StringBuffer urlParameters = new StringBuffer();
        StringBuffer parameters = new StringBuffer();

        String spplusSiret = (String) paymentServiceBean.getProperty(SPPLUS_SIRET);
        urlParameters.append("siret=").append(spplusSiret);
        parameters.append(spplusSiret);
        
        String reference = payment.getHomeFolder().getId() + "S" + random.nextInt();
        urlParameters.append("&reference=").append(reference);
        parameters.append(reference);
        payment.setCvqReference(reference);
        
        urlParameters.append("&langue=FR")
            .append("&devise=978");
        parameters.append("FR")
            .append("978");
        
        String formattedTotal = numberFormat.format((double) payment.getAmount().doubleValue()/100);
        urlParameters.append("&montant=").append(formattedTotal);
        parameters.append(formattedTotal);
        
        urlParameters.append("&taxe=0.00");
        parameters.append("0.00");
        
        Date date = new Date();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        urlParameters.append("&validite=").append(dateFormat.format(date));
        parameters.append(dateFormat.format(date));
        
        // TODO : moyen de paiement : CBS/SIG, comment les différencie-t-on ??
        urlParameters.append("&moyen=CBS");
        parameters.append("CBS");
        
        urlParameters.append("&modalite=1x");
        parameters.append("1x");
        
        String homeFolderEmail = payment.getRequester().getEmail();
        if (homeFolderEmail != null && !homeFolderEmail.equals("")) {
            urlParameters.append("&email=").append(homeFolderEmail);
            parameters.append(homeFolderEmail);
        }
        
        urlParameters.append("&urlretour=")
            .append(paymentServiceBean.getProperty(SPPLUS_USER_CALLBACK_URL));
        parameters.append(paymentServiceBean.getProperty(SPPLUS_USER_CALLBACK_URL));
        
        if (paymentServiceBean.getProperty(SPPLUS_VERSION) != null) {
            urlParameters.append("&version=").append(paymentServiceBean.getProperty(SPPLUS_VERSION));
            parameters.append(paymentServiceBean.getProperty(SPPLUS_VERSION));
        }
        
        String spplusMerchkey = (String) paymentServiceBean.getProperty(SPPLUS_MERCHKEY);
        sha sh1 = new sha();
        // decrypt Cipher Bloc Chaining
        String hmac = sh1.calculHmac(spplusMerchkey, 20, parameters.toString());
        urlParameters.append("&hmac=").append(hmac);
        
        String httpEncodedParams = URLEncryption.encode(urlParameters.toString());
        String encryptedParams = URLEncryption.encode_base64(httpEncodedParams);
        String url2 = paymentUrl + "!" + encryptedParams;

        URL url = null;
        try {
            url = new URL(url2);
        } catch (MalformedURLException mue) {
            logger.error("initPayment() Error while creating URL object");
            mue.printStackTrace();
            throw new CvqException();
        }
        
        logger.debug("initPayment() Returning URL : " + url.toString());
        return url;
    }

    public PaymentResultBean doCommitPayment(final Map<String, String> parameters, 
            PaymentServiceBean paymentServiceBean) throws CvqException {
        
        PaymentResultStatus returnStatus = getStateFromParameters(parameters, paymentServiceBean);
        return new PaymentResultBean(returnStatus, parameters.get("cvqReference"),
                parameters.get("bankReference"));
    }
    
    public PaymentResultStatus getStateFromParameters(Map<String, String> parameters, 
            PaymentServiceBean paymentServiceBean) throws CvqException {
        
        if (!handleParameters(parameters))
            return PaymentResultStatus.UNKNOWN;
        
        String bankTransactionStatus = parameters.get("etat");
        
        logger.debug("getStateFromParameters() Dealing with status : " + bankTransactionStatus);

        // compute return status according to bank transaction status
        if (bankTransactionStatus.equals("2")) {
            return PaymentResultStatus.OTHER;
        } else if (bankTransactionStatus.equals("5")) {
            return PaymentResultStatus.REFUSED;
        } else if (bankTransactionStatus.equals("12")) {
            return PaymentResultStatus.CANCELLED;
        } else if (bankTransactionStatus.equals("1")) {
            return PaymentResultStatus.OTHER;
        } else if (bankTransactionStatus.equals("4")) {
            return PaymentResultStatus.OTHER;
        } else if (bankTransactionStatus.equals("10")) {
            return PaymentResultStatus.OK;
        } else if (bankTransactionStatus.equals("99")) {
            return PaymentResultStatus.OK;
        } else {
            logger.warn("getStateFromParameters() Received unknown return status " + bankTransactionStatus);
            return PaymentResultStatus.UNKNOWN;
        }
    }

    public void checkConfiguration(PaymentServiceBean paymentServiceBean)
            throws CvqConfigurationException {

        String spplusMerchkey = (String) paymentServiceBean.getProperty(SPPLUS_MERCHKEY);
        String spplusSiret = (String) paymentServiceBean.getProperty(SPPLUS_SIRET);
        if (spplusMerchkey == null || spplusSiret == null)
            throw new CvqConfigurationException("Missing SP-PLUS merchkey or siret number");

    }

    public PaymentMode getPaymentMode() {
        return PaymentMode.INTERNET;
    }

    public boolean handleParameters(Map<String, String> parameters) {
        if (parameters.get("refsfp") != null)
            return true;
        
        return false;
    }

    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
