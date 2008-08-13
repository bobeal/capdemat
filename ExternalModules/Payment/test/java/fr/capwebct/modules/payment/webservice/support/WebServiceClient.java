package fr.capwebct.modules.payment.webservice.support;

import java.io.IOException;

import javax.xml.transform.TransformerException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapMessage;

public class WebServiceClient implements IWebServiceClient {

    private static Log log = LogFactory.getLog(WebServiceClient.class);
	private WebServiceTemplate webServiceTemplate;
    	
	public Object sendAndRecieve(Object requestPayload) {
        log.debug("sendAndRecieve() - Start");
		return webServiceTemplate.marshalSendAndReceive(requestPayload);
	}

    public Object invoiceDetailsSendAndRecieve(Object requestPayload) {
        return webServiceTemplate.marshalSendAndReceive(
                requestPayload, 
                new WebServiceMessageCallback() {
                    public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
                       ((SoapMessage)message).setSoapAction("http://www.capwebct.fr/modules/payment/InvoiceEndpoint");
                    }
        });
    }

    public Object accountDetailsSendAndRecieve(Object requestPayload) {
        return webServiceTemplate.marshalSendAndReceive(
                requestPayload, 
                new WebServiceMessageCallback() {
                    public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
                       ((SoapMessage)message).setSoapAction("http://www.capwebct.fr/modules/payment/AccountEndpoint");
                    }
        });
    }

    public Object familyAccountsSendAndRecieve(Object requestPayload) {
        return webServiceTemplate.marshalSendAndReceive(
                requestPayload, 
                new WebServiceMessageCallback() {
                    public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
                       ((SoapMessage)message).setSoapAction("http://www.capwebct.fr/modules/payment/FamilyAccountEndpoint");
                    }
        });

    }
    
    public Object creditAccountSendAndRecieve(Object requestPayload) {
        return webServiceTemplate.marshalSendAndReceive(
                "http://localhost:8081/Payment-Module/webservice//",
                requestPayload, 
                new WebServiceMessageCallback() {
                    public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
                       ((SoapMessage)message).setSoapAction("http://www.capwebct.fr/modules/payment/CreditAccountEndpoint");
                    }
        });

    }
    
    public void setWebServiceTemplate(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }
}
