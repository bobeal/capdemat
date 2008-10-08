package fr.capwebct.capdemat.plugins.paymentproviders.payline.service;

import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.business.users.payment.PaymentMode;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.payment.IPaymentProviderService;
import fr.cg95.cvq.payment.PaymentResultBean;
import fr.cg95.cvq.payment.PaymentResultStatus;
import fr.cg95.cvq.payment.PaymentServiceBean;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public final class PaylineService implements IPaymentProviderService {

    private static Logger logger = Logger.getLogger(PaylineService.class);

    private String label;
    
    private static final String PAYLINE_IP = "paylineIp";
    private static final String PAYLINE_PORT = "paylinePort";
    private static final String PAYLINE_CALLBACK_URL = "paylineCallbackUrl";
    private static final String PAYLINE_SESSIONS_PATH = "paylineSessionsPath";
    private static final String PAYLINE_PERSONNALISATION = "paylinePersonnalisation";

    public void init() {
    }
    
    public URL doInitPayment(Payment payment, PaymentServiceBean paymentServiceBean)
        throws CvqException {

        try {
            String reference = "P_" + payment.getHomeFolder().getId() + "_" + System.currentTimeMillis();
            payment.setCvqReference(reference);
            
            String paylineIp = (String) paymentServiceBean.getProperty(PAYLINE_IP);
            String paylinePort = (String) paymentServiceBean.getProperty(PAYLINE_PORT); 
            PLPASSAPI passapi = new PLPASSAPI(paylineIp, Integer.parseInt(paylinePort));
            // transaction
            String valueS = String.valueOf(payment.getAmount().intValue());
            passapi.setmontant((valueS.substring(0, valueS.length() - 2))
                               + "." + (valueS.substring(valueS.length() - 2)));
            passapi.setcard_type("CB");
            passapi.setdevise_montant("EUR");
	    
	    String domainName = payment.getPaymentSpecificData().get("domainName");
	    String callbackUrl = "https://" + domainName + ((String) paymentServiceBean.getProperty(PAYLINE_CALLBACK_URL));
            passapi.seturlretour(callbackUrl);

            passapi.setreference(reference);
            passapi.setpersonnalisation((String) paymentServiceBean.getProperty(PAYLINE_PERSONNALISATION));
            passapi.setlangue("FR");
            
            // demande
            int ok = passapi.Demande_Paiement();

            if (ok != 0)
                throw new CvqException(passapi.geterreurlabel(ok));

            return new URL(passapi.geturlPayline());

        } catch (Exception e) {
            throw new CvqException(e.getMessage());
        }
    }

    public PaymentResultBean doCommitPayment(final Map<String, String> parameters, 
            PaymentServiceBean paymentServiceBean) 
        throws CvqException {

        try {
            String sessionid = parameters.get("sessionid");
            String sessionsPath = 
                (String) paymentServiceBean.getProperty(PAYLINE_SESSIONS_PATH);
            Map data = extractTransactionData(sessionsPath, sessionid);
            String etat = data.get("etat").toString();
            String cvqReference = data.get("reference").toString();
            String bankReference = "";
            if (data.get("gt_ntrans") != null)
                bankReference = data.get("gt_ntrans").toString();
            else if (data.get("gt_ntran") != null)
                bankReference = data.get("gt_ntran").toString();
                
            if (etat.equals("4")) {

                if (!deleteTransactionFile(sessionsPath , sessionid)) {
                    logger.error("commitPayment() Error while deleting transaction file");
                    // TODO : what can we do ??
                }

                return new PaymentResultBean(PaymentResultStatus.OK, cvqReference,
                        bankReference);
            } else if (etat.equals("2") || etat.equals("3") || etat.equals("5")) {
                if (!deleteTransactionFile(sessionsPath, sessionid)) {
                    logger.error("commitPayment() Error while deleting transaction file");
                    // TODO : what can we do ??
                }

                return new PaymentResultBean(PaymentResultStatus.REFUSED, cvqReference,
                        bankReference);
            } 

            return new PaymentResultBean(PaymentResultStatus.UNKNOWN, cvqReference,
                    bankReference);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CvqException(e.getMessage());
        }
    }

    private boolean deleteTransactionFile(String sessionsPath, final String transactionIdentifier) {

        File file = new File(sessionsPath, transactionIdentifier);
        return file.delete();
    }

    private Map extractTransactionData(String sessionsPath, final String transactionIdentifier) 
        throws Exception {
        
        FileReader fileReader = new FileReader(new File(sessionsPath, transactionIdentifier));
        BufferedReader reader = new BufferedReader(fileReader);
        String content = reader.readLine();
        reader.close();
        fileReader.close();

        Map<String, String> result = new HashMap<String, String>();
        StringTokenizer st = new StringTokenizer(content, "&");
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            StringTokenizer st2 = new StringTokenizer(token, "=");
            String param = st2.nextToken();
            String valeur = "";
            if (st2.hasMoreTokens()) {
                valeur = st2.nextToken();
                valeur = URLDecoder.decode(valeur, "UTF-8");
            }
            result.put(param, valeur);
        }

        return result;
    }

    public void checkConfiguration(final PaymentServiceBean paymentServiceBean)
        throws CvqConfigurationException {

        String paylineIp = (String) paymentServiceBean.getProperty(PAYLINE_IP);
        String paylinePort = (String) paymentServiceBean.getProperty(PAYLINE_PORT);
        if (paylineIp == null || paylinePort == null)
            throw new CvqConfigurationException("Missing payline IP or port");
        try {
            Integer.parseInt(paylinePort);
        } catch (NumberFormatException nfe) {
            throw new CvqConfigurationException("Payline port must be an integer");
        }
    		
	//        String callbackUrl = (String) paymentServiceBean.getProperty(PAYLINE_CALLBACK_URL);
        //if (callbackUrl == null || !callbackUrl.startsWith("https://"))
        //    throw new CvqConfigurationException("Missing " + PAYLINE_CALLBACK_URL
        //            + " configuration parameter");

        String sessionsPath = (String) paymentServiceBean.getProperty(PAYLINE_SESSIONS_PATH);
        if (sessionsPath == null)
            throw new CvqConfigurationException("Missing " + PAYLINE_SESSIONS_PATH
                    + " configuration parameter");
    }

    public PaymentMode getPaymentMode() {
        return PaymentMode.INTERNET;
    }

    public boolean handleParameters(Map<String, String> parameters) {
        if (parameters.get("sessionid") != null)
            return true;
        
        return false;
    }

    public PaymentResultStatus getStateFromParameters(Map<String, String> parameters, 
            PaymentServiceBean paymentServiceBean) throws CvqException {
        
        if (!handleParameters(parameters))
            return PaymentResultStatus.UNKNOWN;
        
        String sessionid = parameters.get("sessionid");
        String sessionsPath = 
            (String) paymentServiceBean.getProperty(PAYLINE_SESSIONS_PATH);
        try {
            Map data = extractTransactionData(sessionsPath, sessionid);
            String etat = data.get("etat").toString();
            if (etat.equals("4")) {
                return PaymentResultStatus.OK;
            } else if (etat.equals("2") || etat.equals("3") || etat.equals("5")) {
                return PaymentResultStatus.REFUSED;
            } 
        } catch (Exception e) {
            e.printStackTrace();
            throw new CvqException(e.getMessage());           
        }
        
        return PaymentResultStatus.UNKNOWN;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
