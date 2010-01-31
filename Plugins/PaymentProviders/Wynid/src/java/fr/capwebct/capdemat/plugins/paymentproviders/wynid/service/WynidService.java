package fr.capwebct.capdemat.plugins.paymentproviders.wynid.service;

import fr.cg95.cvq.business.payment.Payment;
import fr.cg95.cvq.business.payment.PaymentMode;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.service.payment.IPaymentProviderService;
import fr.cg95.cvq.service.payment.PaymentResultBean;
import fr.cg95.cvq.service.payment.PaymentResultStatus;
import fr.cg95.cvq.service.payment.PaymentServiceBean;

import org.apache.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

public final class WynidService implements IPaymentProviderService {

    private static Logger logger = Logger.getLogger(WynidService.class);

    private String label;
    
    private static final String WYNID_BASE_URL = "wynidBaseUrl";
    private static final String WYNID_CAISSES = "wynidCaisses";

    public void init() {
    }
    
    public URL doInitPayment(Payment payment, PaymentServiceBean paymentServiceBean) 
        throws CvqException {

        String reference = "W_" + payment.getHomeFolderId() 
            + "_" + System.currentTimeMillis();
        payment.setCvqReference(reference);
        
        String terminal = payment.getPaymentSpecificData().get("terminal");

        Properties props =
            (Properties) paymentServiceBean.getProperty(WYNID_CAISSES);
        String caisse = props.getProperty(terminal);
        if (caisse == null)
            throw new CvqException("payment.wynid.unknown_terminal");
        String baseUrl =
            (String) paymentServiceBean.getProperty(WYNID_BASE_URL);
        try {
            return new URL(baseUrl + "&transaction=" + reference 
                    + "&montant=" + payment.getAmount().intValue()
                    + "&caisse=" + caisse);
        } catch (MalformedURLException e) {
            // We can expect that our own URLs are well formed ...
            logger.error("doInitPayment() Malformed URL : " + e);
            throw new CvqException("payment.malformed_url");
        }
    }

    public PaymentResultBean doCommitPayment(final Map<String, String> parameters, 
            PaymentServiceBean paymentServiceBean) 
        throws CvqException {

        String wynidid = parameters.get("wynidid");
        logger.debug("doCommitPayment() Got Wynid id : " + wynidid);

        String reference = null;
        String state = null;
        if (wynidid.indexOf("/") > 0) {
            // transaction with state
            StringTokenizer stringTokenizer = new StringTokenizer(wynidid, "/");
            reference = stringTokenizer.nextToken();
            state = stringTokenizer.nextToken();
        } else {
            logger.warn("doCommitPayment() unable to parse wynidid : " + wynidid);
            reference = wynidid;
            state = "";
        }

        if (state.equals("ACCEPTED")) {
            return new PaymentResultBean(PaymentResultStatus.OK, reference, null);
        } else if (state.equals("REFUSED")) {
            return new PaymentResultBean(PaymentResultStatus.REFUSED, reference, null);
        } else if (state.equals("CANCELLED")) {
            return new PaymentResultBean(PaymentResultStatus.CANCELLED, reference, null);
        }

        return new PaymentResultBean(PaymentResultStatus.UNKNOWN, reference, null);
    }

    public PaymentResultStatus getStateFromParameters(Map<String, String> parameters, 
            PaymentServiceBean paymentServiceBean) throws CvqException {
        
        if (!handleParameters(parameters))
            return PaymentResultStatus.UNKNOWN;
        
        String wynidid = parameters.get("wynidid");
        String state = null;
        if (wynidid.indexOf("/") > 0) {
            // transaction with state
            StringTokenizer stringTokenizer = new StringTokenizer(wynidid, "/");
            state = stringTokenizer.nextToken();
        } else {
            logger.warn("doCommitPayment() unable to parse wynidid : " + wynidid);
            state = "";
        }

        if (state.equals("ACCEPTED")) {
            return PaymentResultStatus.OK;
        } else if (state.equals("REFUSED")) {
            return PaymentResultStatus.REFUSED;
        } else if (state.equals("CANCELLED")) {
            return PaymentResultStatus.CANCELLED;
        }
        
        return PaymentResultStatus.UNKNOWN;
    }

    public void checkConfiguration(final PaymentServiceBean paymentServiceBean)
        throws CvqConfigurationException {

        String baseUrl = (String) paymentServiceBean.getProperty(WYNID_BASE_URL);
        if (baseUrl == null || !baseUrl.startsWith("https://"))
            throw new CvqConfigurationException("Missing " + WYNID_BASE_URL + " configuration parameter");

        Object object = paymentServiceBean.getProperty(WYNID_CAISSES);
        if (object == null || !(object instanceof Properties))
            throw new CvqConfigurationException(WYNID_CAISSES + " must be a properties object !");
    }

    public PaymentMode getPaymentMode() {
        return PaymentMode.CARD;
    }

    public boolean handleParameters(Map<String, String> parameters) {
        if (parameters.get("wynidid") != null)
            return true;
        
        return false;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
