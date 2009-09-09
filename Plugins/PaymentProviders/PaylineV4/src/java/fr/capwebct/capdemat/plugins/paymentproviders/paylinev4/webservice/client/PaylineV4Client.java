package fr.capwebct.capdemat.plugins.paymentproviders.paylinev4.webservice.client;

import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.http.CommonsHttpMessageSender;

import com.experian.payline.ws.impl.DoWebPaymentRequestDocument;
import com.experian.payline.ws.impl.DoWebPaymentResponseDocument;
import com.experian.payline.ws.impl.GetWebPaymentDetailsRequestDocument;
import com.experian.payline.ws.impl.GetWebPaymentDetailsResponseDocument;

public class PaylineV4Client {

    private WebServiceTemplate paylineWebPaymentService;

    public void setCredentials(String username, String password) {
        CommonsHttpMessageSender commonsHttpMessageSender =
            (CommonsHttpMessageSender) paylineWebPaymentService.getMessageSenders()[0];
        UsernamePasswordCredentials usernamePasswordCredentials =
            new UsernamePasswordCredentials(username, password);
        commonsHttpMessageSender.setCredentials(usernamePasswordCredentials);
        commonsHttpMessageSender.getHttpClient().getState()
            .setCredentials(commonsHttpMessageSender.getAuthScope(), usernamePasswordCredentials);
        paylineWebPaymentService.setMessageSender(commonsHttpMessageSender);
    }

    public DoWebPaymentResponseDocument doWebPayment(DoWebPaymentRequestDocument doWebPaymentRequestDocument) {
        return (DoWebPaymentResponseDocument)
            paylineWebPaymentService.marshalSendAndReceive(doWebPaymentRequestDocument);
    }

    public GetWebPaymentDetailsResponseDocument getWebPaymentDetails(GetWebPaymentDetailsRequestDocument getWebPaymentDetailsRequestDocument) {
        return (GetWebPaymentDetailsResponseDocument)
            paylineWebPaymentService.marshalSendAndReceive(getWebPaymentDetailsRequestDocument);
    }

    public void setPaylineWebPaymentService(WebServiceTemplate paylineWebPaymentService) {
        this.paylineWebPaymentService = paylineWebPaymentService;
    }
}
