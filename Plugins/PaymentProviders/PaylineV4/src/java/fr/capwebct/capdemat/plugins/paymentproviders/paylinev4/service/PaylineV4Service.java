package fr.capwebct.capdemat.plugins.paymentproviders.paylinev4.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;

import com.experian.payline.ws.impl.DoWebPaymentRequestDocument;
import com.experian.payline.ws.impl.DoWebPaymentResponseDocument;
import com.experian.payline.ws.impl.GetWebPaymentDetailsRequestDocument;
import com.experian.payline.ws.impl.GetWebPaymentDetailsResponseDocument;
import com.experian.payline.ws.impl.DoWebPaymentRequestDocument.DoWebPaymentRequest;
import com.experian.payline.ws.impl.DoWebPaymentResponseDocument.DoWebPaymentResponse;
import com.experian.payline.ws.impl.GetWebPaymentDetailsRequestDocument.GetWebPaymentDetailsRequest;
import com.experian.payline.ws.impl.GetWebPaymentDetailsResponseDocument.GetWebPaymentDetailsResponse;
import com.experian.payline.ws.obj.Buyer;
import com.experian.payline.ws.obj.Order;
import com.experian.payline.ws.obj.SelectedContractList;

import fr.capwebct.capdemat.plugins.paymentproviders.paylinev4.webservice.client.PaylineV4Client;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.business.users.payment.PaymentMode;
import fr.cg95.cvq.dao.users.IPaymentDAO;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.payment.IPaymentProviderService;
import fr.cg95.cvq.payment.PaymentResultBean;
import fr.cg95.cvq.payment.PaymentResultStatus;
import fr.cg95.cvq.payment.PaymentServiceBean;

public class PaylineV4Service implements IPaymentProviderService {

    private static Logger logger = Logger.getLogger(PaylineV4Service.class);

    private PaylineV4Client paylineV4Client;
    private IPaymentDAO paymentDAO;

    private String returnUrl;
    private String cancelUrl;

    private static final String CONTRACT_NUMBER = "contractNumber";
    private static final String MERCHANT_ID = "merchantID";
    private static final String MERCHANT_ACCESS_KEY = "merchantAccesskey";

    public void checkConfiguration(PaymentServiceBean paymentServiceBean)
            throws CvqConfigurationException {
        if (paymentServiceBean.getProperty(CONTRACT_NUMBER) == null
                || paymentServiceBean.getProperty(MERCHANT_ACCESS_KEY) == null
                || paymentServiceBean.getProperty(MERCHANT_ID) == null)
            throw new CvqConfigurationException("payment.provider.paylinev4.missingRequiredProperty");
    }

    public URL doInitPayment(Payment payment, PaymentServiceBean paymentServiceBean)
            throws CvqException {

        DoWebPaymentRequestDocument doWebPaymentRequestDocument =
            DoWebPaymentRequestDocument.Factory.newInstance();
        DoWebPaymentRequest doWebPaymentRequest =
            doWebPaymentRequestDocument.addNewDoWebPaymentRequest();
        String domainName = payment.getPaymentSpecificData().get("domainName");
        String fullCancelUrl = "https://" + domainName + cancelUrl;
        String fullReturnUrl = "https://" + domainName + returnUrl;
        doWebPaymentRequest.setCancelURL(fullCancelUrl);
        doWebPaymentRequest.setReturnURL(fullReturnUrl);
        doWebPaymentRequest.setSecurityMode("SSL");
        doWebPaymentRequest.setLanguageCode("fr");

        com.experian.payline.ws.obj.Payment paylinePayment = doWebPaymentRequest.addNewPayment();
        paylinePayment.setAmount(String.valueOf(payment.getAmount().intValue()));
        paylinePayment.setContractNumber((String) paymentServiceBean.getProperty(CONTRACT_NUMBER));
        paylinePayment.setCurrency("978");
        paylinePayment.setAction("101");
        paylinePayment.setMode("CPT");

        Order paylineOrder = doWebPaymentRequest.addNewOrder();
        String reference = "P4_" + payment.getHomeFolder().getId() + "_" + System.currentTimeMillis();
        paylineOrder.setRef(reference);
        paylineOrder.setAmount(String.valueOf(payment.getAmount().intValue()));
        paylineOrder.setCurrency("978");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        paylineOrder.setDate(sdf.format(new Date()));
        paylineOrder.setCountry("FR");
        paylineOrder.setTaxes("196");

        SelectedContractList selectedContractList = doWebPaymentRequest.addNewSelectedContractList();
        selectedContractList.addSelectedContract((String) paymentServiceBean.getProperty(CONTRACT_NUMBER));

        Buyer paylineBuyer = doWebPaymentRequest.addNewBuyer();
        String homeFolderEmail = payment.getRequester().getEmail();
        if (homeFolderEmail != null && !homeFolderEmail.equals("")) {
            paylineBuyer.setEmail(homeFolderEmail);
            paylineBuyer.setFirstName(payment.getRequester().getFirstName());
            paylineBuyer.setLastName(payment.getRequester().getLastName());
        }

        paylineV4Client.setCredentials((String) paymentServiceBean.getProperty(MERCHANT_ID),
                (String) paymentServiceBean.getProperty(MERCHANT_ACCESS_KEY));
        DoWebPaymentResponseDocument doWebPaymentResponseDocument =
            paylineV4Client.doWebPayment(doWebPaymentRequestDocument);
        DoWebPaymentResponse doWebPaymentResponse =
            doWebPaymentResponseDocument.getDoWebPaymentResponse();
        URL redirectUrl = null;
        if (doWebPaymentResponse.getResult().getCode().equals("00000")) {
            String token = doWebPaymentResponse.getToken();
            payment.setBankReference(token);
            payment.setCvqReference(reference);
            try {
                redirectUrl = new URL(doWebPaymentResponse.getRedirectURL());
            } catch (MalformedURLException mue) {
                // we can trust Payline for that
            }
        } else {
            throw new CvqException(doWebPaymentResponse.getResult().getLongMessage());
        }

        return redirectUrl;
    }

    public PaymentResultBean doCommitPayment(Map<String, String> parameters,
            PaymentServiceBean paymentServiceBean) throws CvqException {

        String token = parameters.get("token");
        GetWebPaymentDetailsResponse getWebPaymentDetailsResponse =
            getPaymentDetails(paymentServiceBean, token);
        String resultCode = getWebPaymentDetailsResponse.getResult().getCode();

        PaymentResultBean paymentResultBean = new PaymentResultBean();
        Payment payment = paymentDAO.findByBankReference(token);
        if (payment != null)
            paymentResultBean.setCvqReference(payment.getCvqReference());
        else
	    logger.warn("doCommitPayment() could not find payment with bank refererce : " + token);
        if (resultCode.equals("00000")) {
            paymentResultBean.setStatus(PaymentResultStatus.OK);
            paymentResultBean.setBankReference(getWebPaymentDetailsResponse.getTransaction().getId());
        } else if (resultCode.startsWith("01")) {
            paymentResultBean.setStatus(PaymentResultStatus.REFUSED);
        } else if (resultCode.startsWith("023") || resultCode.startsWith("021")) {
            // FIXME : maybe we need a FAILED status for such a case ?
            paymentResultBean.setStatus(PaymentResultStatus.REFUSED);
        } else {
            paymentResultBean.setStatus(PaymentResultStatus.OTHER);
        }

        return paymentResultBean;
    }

    public PaymentResultStatus getStateFromParameters(Map<String, String> parameters,
            PaymentServiceBean paymentServiceBean) throws CvqException {

        String token = parameters.get("token");
        GetWebPaymentDetailsResponse getWebPaymentDetailsResponse =
            getPaymentDetails(paymentServiceBean, token);
        String resultCode = getWebPaymentDetailsResponse.getResult().getCode();

        if (resultCode.equals("00000")) {
            return PaymentResultStatus.OK;
        } else if (resultCode.startsWith("01")) {
            return PaymentResultStatus.REFUSED;
        } else if (resultCode.startsWith("023") || resultCode.startsWith("021")) {
            // FIXME : maybe we need a FAILED status for such a case ?
            return PaymentResultStatus.REFUSED;
        } else {
            return PaymentResultStatus.OTHER;
        }
    }

    private GetWebPaymentDetailsResponse getPaymentDetails(PaymentServiceBean psb,
            final String token) {

        GetWebPaymentDetailsRequestDocument getWebPaymentDetailsRequestDocument =
            GetWebPaymentDetailsRequestDocument.Factory.newInstance();
        GetWebPaymentDetailsRequest getWebPaymentDetailsRequest =
            getWebPaymentDetailsRequestDocument.addNewGetWebPaymentDetailsRequest();
        getWebPaymentDetailsRequest.setToken(token);

        paylineV4Client.setCredentials((String) psb.getProperty(MERCHANT_ID),
                (String) psb.getProperty(MERCHANT_ACCESS_KEY));
        GetWebPaymentDetailsResponseDocument getWebPaymentDetailsResponseDocument =
            paylineV4Client.getWebPaymentDetails(getWebPaymentDetailsRequestDocument);
        GetWebPaymentDetailsResponse getWebPaymentDetailsResponse =
            getWebPaymentDetailsResponseDocument.getGetWebPaymentDetailsResponse();

        return getWebPaymentDetailsResponse;
    }

    public boolean handleParameters(Map<String, String> parameters) {
        if (parameters.get("token") != null)
            return true;
        return false;
    }

    public PaymentMode getPaymentMode() {
        return PaymentMode.INTERNET;
    }

    public void setPaylineV4Client(PaylineV4Client paylineV4Client) {
        this.paylineV4Client = paylineV4Client;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public void setCancelUrl(String cancelUrl) {
        this.cancelUrl = cancelUrl;
    }

    public void setPaymentDAO(IPaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }
}
