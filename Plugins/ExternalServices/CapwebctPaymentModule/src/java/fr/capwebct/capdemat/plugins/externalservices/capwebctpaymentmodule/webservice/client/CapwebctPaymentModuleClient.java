package fr.capwebct.capdemat.plugins.externalservices.capwebctpaymentmodule.webservice.client;

import org.springframework.ws.client.core.WebServiceTemplate;

public class CapwebctPaymentModuleClient implements ICapwebctPaymentModuleClient {

    private WebServiceTemplate webServiceTemplate;

    public Object loadInvoiceDetails(Object requestPayload) {
        return webServiceTemplate.marshalSendAndReceive(requestPayload);
    }

    public Object loadAccountDetails(Object requestPayload) {
        return webServiceTemplate.marshalSendAndReceive(requestPayload);
    }

    public Object getFamilyAccounts(Object requestPayload) {
        return webServiceTemplate.marshalSendAndReceive(requestPayload);
    }

    public Object creditAccount(Object requestPayload) {
        return webServiceTemplate.marshalSendAndReceive(requestPayload);
    }

    public void setWebServiceTemplate(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }
}
