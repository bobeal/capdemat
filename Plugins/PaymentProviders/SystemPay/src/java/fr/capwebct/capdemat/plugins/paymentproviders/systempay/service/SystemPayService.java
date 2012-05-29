package fr.capwebct.capdemat.plugins.paymentproviders.systempay.service;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.payment.Payment;
import fr.cg95.cvq.business.payment.PaymentMode;
import fr.cg95.cvq.dao.jpa.GenericDAO;
import fr.cg95.cvq.dao.jpa.IGenericDAO;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqSignatureException;
import fr.cg95.cvq.service.payment.IPaymentProviderService;
import fr.cg95.cvq.service.payment.PaymentResultBean;
import fr.cg95.cvq.service.payment.PaymentResultStatus;
import fr.cg95.cvq.service.payment.PaymentServiceBean;

public class SystemPayService implements IPaymentProviderService{

    private static Logger logger = Logger.getLogger(SystemPayService.class);
    private String label;
    private String paymentUrl;
    private GenericDAO genericDAO;

    private static final String SYSTEMPAY_VADS_SITE_ID = "systempayVadsSiteId";
    private static final String SYSTEMPAY_USER_CALLBACK_URL = "systempayUserCallbackUrl";
    private static final String SYSTEMPAY_VERSION = "systempayVersion";
    private static final String SYSTEMPAY_CERTIFICAT_VALUE = "systempayCertificatValue";
    private static final String SYSTEMPAY_MODE = "systempayMode";

    private DecimalFormat decimalFormat = new DecimalFormat("000000");
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    public void init() throws CvqException {
        if (paymentUrl == null)
            throw new CvqException("No payment URL provided !");
    }

    @Override
    public URL doInitPayment(Payment payment, PaymentServiceBean paymentServiceBean)
            throws CvqException {
        StringBuffer urlParameters = new StringBuffer();
        Map<String,String> parameters = new TreeMap<String, String>();

        if (paymentServiceBean.getProperty(SYSTEMPAY_VERSION) != null) {
            urlParameters.append("?vads_version=").append(paymentServiceBean.getProperty(SYSTEMPAY_VERSION));
            parameters.put("vads_version",paymentServiceBean.getProperty(SYSTEMPAY_VERSION).toString());
        }

        if (paymentServiceBean.getProperty(SYSTEMPAY_VADS_SITE_ID) != null) {
            urlParameters.append("&vads_site_id=").append(paymentServiceBean.getProperty(SYSTEMPAY_VADS_SITE_ID));
            parameters.put("vads_site_id",paymentServiceBean.getProperty(SYSTEMPAY_VADS_SITE_ID).toString());
        }

        urlParameters.append("&vads_amount=").append(payment.getAmount().intValue());
        parameters.put("vads_amount",String.valueOf(payment.getAmount().intValue()));

        urlParameters.append("&vads_currency=").append("978");
        parameters.put("vads_currency", "978");

        urlParameters.append("&vads_language=").append("fr");
        parameters.put("vads_language", "fr");

        Object vads_trans_id = genericDAO.getEntityManager().createNativeQuery(
                "select nextval ('systempay_trans_id_seq')").getSingleResult();
        urlParameters.append("&vads_trans_id=").append(decimalFormat.format(vads_trans_id));
        parameters.put("vads_trans_id", decimalFormat.format(vads_trans_id));
        payment.setCvqReference(Integer.valueOf(decimalFormat.format(vads_trans_id)).toString());

        urlParameters.append("&vads_payment_card=").append("VIDE");
        parameters.put("vads_payment_card", "VIDE");

        urlParameters.append("&vads_payment_config=").append("SINGLE");
        parameters.put("vads_payment_config", "SINGLE");

        String homeFolderEmail="";
        try {
            homeFolderEmail = URLEncoder.encode(payment.getPaymentSpecificDataByKey(Payment.SPECIFIC_DATA_EMAIL),"UTF-8");
        } catch (UnsupportedEncodingException uee) {
            logger.error("initPayment() Error while encode email ");
            uee.printStackTrace();
            throw new CvqException();
        }
        if (homeFolderEmail != null && !homeFolderEmail.equals("")) {
            urlParameters.append("&vads_cust_email=").append(homeFolderEmail);
            parameters.put("vads_cust_email",payment.getPaymentSpecificDataByKey(Payment.SPECIFIC_DATA_EMAIL).toString());
        }

        String urlEncode = "";
        if (paymentServiceBean.getProperty(SYSTEMPAY_USER_CALLBACK_URL) != null) {
        try {
            urlEncode = URLEncoder.encode(paymentServiceBean.getProperty(SYSTEMPAY_USER_CALLBACK_URL).toString(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("initPayment() Error while encode URL ");
            e.printStackTrace();
            throw new CvqException();
        }
        urlParameters.append("&vads_url_return=").append(urlEncode);
        parameters.put("vads_url_return",paymentServiceBean.getProperty(SYSTEMPAY_USER_CALLBACK_URL).toString());
        }

        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date now = new Date();
        urlParameters.append("&vads_trans_date=").append(dateFormat.format(now));
        parameters.put("vads_trans_date", dateFormat.format(now));

        urlParameters.append("&vads_page_action=").append("PAYMENT");
        parameters.put("vads_page_action", "PAYMENT");

        urlParameters.append("&vads_action_mode=").append("INTERACTIVE");
        parameters.put("vads_action_mode", "INTERACTIVE");

        // TEST ou PRODUCTION
        if (paymentServiceBean.getProperty(SYSTEMPAY_MODE) != null) {
        urlParameters.append("&vads_ctx_mode=").append(paymentServiceBean.getProperty(SYSTEMPAY_MODE));
        parameters.put("vads_ctx_mode",paymentServiceBean.getProperty(SYSTEMPAY_MODE).toString());
        }

        String certificatValue = null;
        if (paymentServiceBean.getProperty(SYSTEMPAY_CERTIFICAT_VALUE) != null) {
            certificatValue = paymentServiceBean.getProperty(SYSTEMPAY_CERTIFICAT_VALUE).toString();
        }
        if(certificatValue == null){
            logger.error("initPayment() Error while retrieve certificat value");
            throw new CvqException();
        }

        StringBuffer parametersForHash = new StringBuffer();
        for(String key : parameters.keySet()){
            parametersForHash.append(parameters.get(key) + "+");
        }
        parametersForHash.append(certificatValue);
        URL url = null;
        try {
        MessageDigest sha1 = MessageDigest.getInstance("SHA1");
        sha1.update(parametersForHash.toString().getBytes("UTF-8"));
        byte[] hash = sha1.digest();
        String hmac = byteArray2Hex(hash);
        urlParameters.append("&signature=").append(hmac);

        String url2 = paymentUrl + urlParameters.toString();
        url = new URL(url2);

        } catch (NoSuchAlgorithmException nsae){
            logger.error("initPayment() Error while creating SHA1 object");
            nsae.printStackTrace();
            throw new CvqException();
        } catch (MalformedURLException mue) {
            logger.error("initPayment() Error while creating URL object");
            mue.printStackTrace();
            throw new CvqException();
        } catch (UnsupportedEncodingException uee) {
            logger.error("initPayment() Error while encoding parameters in UTF-8");
            uee.printStackTrace();
            throw new CvqException();
        }
        
        logger.debug("initPayment() Returning URL : " + url.toString());
        return url;
    }

    @Override
    public PaymentResultBean doCommitPayment(Map<String, String> parameters,
            PaymentServiceBean paymentServiceBean) throws CvqException {

        StringBuffer parametersForHash = new StringBuffer();
        Map<String,String> parametersSorted = new TreeMap<String, String>();
        for(String key : parameters.keySet()){
            if(key.startsWith("vads_")){
                parametersSorted.put(key, parameters.get(key));
            }
        }
        String certificatValue = null;
        if (paymentServiceBean.getProperty(SYSTEMPAY_CERTIFICAT_VALUE) != null) {
            certificatValue = paymentServiceBean.getProperty(SYSTEMPAY_CERTIFICAT_VALUE).toString();
        }
        if(certificatValue == null){
            logger.error("commitPayment() Error while retrieve certificat value");
            throw new CvqException();
        }

        for(String key : parametersSorted.keySet()){
            parametersForHash.append(parametersSorted.get(key) + "+");
        }
        parametersForHash.append(certificatValue);
        try{
            MessageDigest sha1 = MessageDigest.getInstance("SHA1");
            sha1.update(parametersForHash.toString().getBytes("UTF-8"));
            byte[] hash = sha1.digest();
            String hmac = byteArray2Hex(hash);
            if(!hmac.equals(parameters.get("signature"))){
                logger.error("commitPayment() Error signature doesn't match to hash");
                throw new CvqSignatureException("commitPayment() Error signature doesn't match to hash");
            }
        } catch (NoSuchAlgorithmException nsae){
            logger.error("commitPayment() Error while creating SHA1 object");
            nsae.printStackTrace();
            throw new CvqException();
        } catch (UnsupportedEncodingException uee) {
            logger.error("commitPayment() Error while encoding parameters in UTF-8");
            uee.printStackTrace();
            throw new CvqException();
        }
        PaymentResultStatus returnStatus = getStateFromParameters(parameters, paymentServiceBean);
        return new PaymentResultBean(returnStatus, Integer.valueOf(parameters.get("vads_trans_id")).toString(),
                parameters.get("vads_trans_id"));
    }

    @Override
    public void checkConfiguration(PaymentServiceBean paymentServiceBean)
            throws CvqConfigurationException {
        String systemPayVersion = (String) paymentServiceBean.getProperty(SYSTEMPAY_VERSION);
        String systemPaySiret = (String) paymentServiceBean.getProperty(SYSTEMPAY_VADS_SITE_ID);
        String systemPayUrlCallback = (String) paymentServiceBean.getProperty(SYSTEMPAY_USER_CALLBACK_URL);
        String systemPayCertificatValue = (String) paymentServiceBean.getProperty(SYSTEMPAY_CERTIFICAT_VALUE);
        String systemPayMode = (String) paymentServiceBean.getProperty(SYSTEMPAY_MODE);
        if (systemPayVersion == null || systemPaySiret == null || systemPayUrlCallback == null
                || systemPayCertificatValue == null || systemPayMode == null)
            throw new CvqConfigurationException(
                    "Missing SystemPay version, callback URL, certifcat value, mode or vads_site_id");
    }

    @Override
    public PaymentMode getPaymentMode() {
        return PaymentMode.INTERNET;
    }

    @Override
    public boolean handleParameters(Map<String, String> parameters) {
        if (parameters.get("signature") != null)
            return true;

        return false;
    }

    @Override
    public PaymentResultStatus getStateFromParameters(Map<String, String> parameters,
            PaymentServiceBean paymentServiceBean) throws CvqException {
        if (!handleParameters(parameters))
            return PaymentResultStatus.UNKNOWN;

        String bankTransactionStatus = parameters.get("etat");
        
        logger.warn("getStateFromParameters() Dealing with status : " + bankTransactionStatus
                + " for payment " + parameters.get("vads_trans_id"));
        if (bankTransactionStatus.equals("00")) {
            return PaymentResultStatus.OK;
        } else if (bankTransactionStatus.equals("17")) {
            return PaymentResultStatus.CANCELLED;
        } else {
            return PaymentResultStatus.REFUSED;
        }

    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }

    public void setGenericDAO(GenericDAO genericDAO) {
        this.genericDAO = genericDAO;
    }

    private static String byteArray2Hex(byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }

}
