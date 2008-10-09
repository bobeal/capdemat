package fr.cg95.cvq.payment.impl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.business.users.payment.PaymentMode;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.payment.IPaymentProviderService;
import fr.cg95.cvq.payment.PaymentResultBean;
import fr.cg95.cvq.payment.PaymentResultStatus;
import fr.cg95.cvq.payment.PaymentServiceBean;

public final class FakePaymentProviderService implements IPaymentProviderService {

    private String paymentUrl;
    
    public void checkConfiguration(PaymentServiceBean paymentServiceBean)
            throws CvqConfigurationException {
    }

    public URL doInitPayment(Payment payment, PaymentServiceBean paymentServiceBean) 
        throws CvqException {
        
        try {
            String cvqReference = "FPS_" + payment.getHomeFolder().getId() 
                + "_" + System.currentTimeMillis();
            payment.setCvqReference(cvqReference);
            
            String domainName = payment.getPaymentSpecificData().get("domainName");
            String callbackUrl = "https://" + domainName + ((String) paymentServiceBean.getProperty("callbackUrl"));

            StringBuffer urlBuffer = new StringBuffer().append(paymentUrl)
                .append("?cvqReference=").append(cvqReference)
                .append("&amount=").append(payment.getEuroAmount())
                .append("&callbackUrl=").append(callbackUrl)
                .append("&capDematFake=true");
            
            String email = payment.getRequester().getEmail();
            if (email != null && !email.equals(""))
                urlBuffer.append("&email=").append(email);
            
            return new URL(urlBuffer.toString());

        } catch (MalformedURLException mue) {
            throw new CvqException(mue.getMessage());
        }
    }
    
    public PaymentResultBean doCommitPayment(Map<String, String> parameters, 
            PaymentServiceBean paymentServiceBean) throws CvqException {

        PaymentResultStatus returnStatus = getStateFromParameters(parameters, paymentServiceBean);
        
        String bankReference = parameters.get("bankReference");
        return new PaymentResultBean(returnStatus, parameters.get("cvqReference"),
                bankReference == null ? parameters.get("cvqReference") : bankReference);
    }

    public PaymentMode getPaymentMode() {
        return PaymentMode.INTERNET;
    }

    public boolean handleParameters(Map<String, String> parameters) {
        if (parameters.get("capDematFake") != null)
            return true;
        else
            return false;
    }

    public final void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }

    public PaymentResultStatus getStateFromParameters(Map<String, String> parameters, 
            PaymentServiceBean paymentServiceBean) throws CvqException {
        
        if (!handleParameters(parameters))
            return PaymentResultStatus.UNKNOWN;
        
        String bankTransactionStatus = (String) parameters.get("status");
        if (bankTransactionStatus.equals("OK"))
            return PaymentResultStatus.OK;
        else if (bankTransactionStatus.equals("CANCELLED"))
            return PaymentResultStatus.CANCELLED;
        else if (bankTransactionStatus.equals("REFUSED"))
            return PaymentResultStatus.REFUSED;
        
        return PaymentResultStatus.UNKNOWN;
    }
}
