package fr.capwebct.capdemat.plugins.paymentproviders.payboxsystem.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.payment.Payment;
import fr.cg95.cvq.business.payment.PaymentMode;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.payment.IPaymentProviderService;
import fr.cg95.cvq.service.payment.PaymentResultBean;
import fr.cg95.cvq.service.payment.PaymentResultStatus;
import fr.cg95.cvq.service.payment.PaymentServiceBean;

public class PayBoxPaymentService implements IPaymentProviderService {

    private static Logger logger = Logger.getLogger(PayBoxPaymentService.class);

    private static String PBX_MODE = "pbxMode";
    private static String PBX_SITE = "pbxSite";
    private static String PBX_RANG = "pbxRang";
    private static String PBX_RETOUR = "pbxRetour";
    private static String PBX_IDENTIFIANT = "pbxIdentifiant";
    private static String PBX_TYPEPAIEMENT = "pbxTypePaiement";
    private static String PBX_TYPECARTE = "pbxTypeCarte";
    private static String PBX_EFFECTUE = "pbxEffectue";
    private static String PBX_REFUSE = "pbxRefuse";
    private static String PBX_ANNULE = "pbxAnnule";

    private String label;
    private String paymentUrl;

    private static final Random random = new Random();
    private NumberFormat numberFormat = new DecimalFormat("###000");

    public void init() throws CvqException {

        if (paymentUrl == null)
            throw new CvqException("No payment URL provided !");
    }

    public void checkConfiguration(PaymentServiceBean paymentServiceBean)
            throws CvqConfigurationException {
        String pbxSite = (String) paymentServiceBean.getProperty(PBX_SITE);
        String pbxRang = (String) paymentServiceBean.getProperty(PBX_RANG);
        String pbxMode = (String) paymentServiceBean.getProperty(PBX_MODE);
        String pbxIdentifiant = (String) paymentServiceBean.getProperty(PBX_IDENTIFIANT);

        if (pbxSite == null ||
                pbxRang == null ||
                pbxIdentifiant == null ||
                pbxMode == null)
            throw new CvqConfigurationException("Missing some important informations");
    }

    public PaymentResultBean doCommitPayment(Map<String, String> parameters,
            PaymentServiceBean paymentServiceBean) throws CvqException {
        // write check test ok
        // Faure Sébastien 17/03/08
        SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT);

        PaymentResultStatus returnStatus = getStateFromParameters(parameters, paymentServiceBean);
        return new PaymentResultBean(returnStatus, parameters.get("ref"),
                parameters.get("transNum"));
    }

    public URL doInitPayment(Payment payment, PaymentServiceBean paymentServiceBean)
            throws CvqException {


            String pbxMode = (String) paymentServiceBean.getProperty(PBX_MODE);
            String pbxSite = (String) paymentServiceBean.getProperty(PBX_SITE);
            String pbxRang = (String) paymentServiceBean.getProperty(PBX_RANG);
            String pbxIdentifiant = (String) paymentServiceBean.getProperty(PBX_IDENTIFIANT);
            String pbxRetour = (String) paymentServiceBean.getProperty(PBX_RETOUR);
            String pbxTypePaiement = (String) paymentServiceBean.getProperty(PBX_TYPEPAIEMENT);
            String pbxTypeCarte = (String) paymentServiceBean.getProperty(PBX_TYPECARTE);
            String pbxEffectue = (String) paymentServiceBean.getProperty(PBX_EFFECTUE);
            String pbxRefuse = (String) paymentServiceBean.getProperty(PBX_REFUSE);
            String pbxAnnule = (String) paymentServiceBean.getProperty(PBX_ANNULE);

            StringBuffer urlParameters = new StringBuffer();
            StringBuffer parameters = new StringBuffer();

            urlParameters.append("PBX_MODE=").append(pbxMode);
            parameters.append(pbxMode);
            urlParameters.append("&PBX_SITE=").append(pbxSite);
            parameters.append(pbxSite);
            urlParameters.append("&PBX_RANG=").append(pbxRang);
            parameters.append(pbxRang);
            urlParameters.append("&PBX_IDENTIFIANT=").append(pbxIdentifiant);
            parameters.append(pbxIdentifiant);

            String montantTotal = numberFormat.format((double)payment.getAmount().doubleValue());
            urlParameters.append("&PBX_TOTAL=").append(montantTotal);
            parameters.append(montantTotal);

            urlParameters.append("&PBX_DEVISE=978");
            parameters.append("978");

            String reference = payment.getHomeFolderId() + "S" + random.nextInt();
            urlParameters.append("&PBX_CMD=").append(reference);
            parameters.append(reference);
            payment.setCvqReference(reference);

            String homeFolderEmail = payment.getPaymentSpecificDataByKey(Payment.SPECIFIC_DATA_EMAIL);
            urlParameters.append("&PBX_PORTEUR=").append(homeFolderEmail);
            parameters.append(homeFolderEmail);

            urlParameters.append("&PBX_TYPEPAIEMENT=").append(pbxTypePaiement);
            parameters.append(pbxTypePaiement);
            urlParameters.append("&PBX_TYPECARTE=").append(pbxTypeCarte);
            parameters.append(pbxTypeCarte);

            urlParameters.append("&PBX_RETOUR=").append(pbxRetour);
            parameters.append(pbxRetour);
            urlParameters.append("&PBX_EFFECTUE=").append(pbxEffectue);
            parameters.append(pbxEffectue);
            urlParameters.append("&PBX_REFUSE=").append(pbxRefuse);
            parameters.append(pbxRefuse);
            urlParameters.append("&PBX_ANNULE=").append(pbxAnnule);
            parameters.append(pbxAnnule);

            String url2 = paymentUrl + urlParameters;

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

    public PaymentMode getPaymentMode() {
        return PaymentMode.INTERNET;
    }

    public PaymentResultStatus getStateFromParameters(Map<String, String> parameters,
            PaymentServiceBean paymentServiceBean) throws CvqException {

        if (!handleParameters(parameters))
            return PaymentResultStatus.UNKNOWN;

        String bankTransactionStatus = parameters.get("erreur");

        logger.debug("getStateFromParameters() Dealing with status : " + bankTransactionStatus);

        // compute return status according to bank transaction status
        if (bankTransactionStatus.equals("5") ||
                bankTransactionStatus.equals("00001") ||
                bankTransactionStatus.equals("00003") ||
                bankTransactionStatus.equals("00010") ||
                bankTransactionStatus.equals("00011") ||
                bankTransactionStatus.equals("00100")) {
            return PaymentResultStatus.REFUSED;
        } else if (bankTransactionStatus.equals("00000")) {
            return PaymentResultStatus.OK;
        } else {
            logger.warn("getStateFromParameters() Received unknown return status " + bankTransactionStatus);
            return PaymentResultStatus.UNKNOWN;
        }

    }

    public boolean handleParameters(Map<String, String> parameters) {
        if (parameters.get("transNum") != null)
            return true;
        else
            return false;
    }

    public final void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
