package fr.capwebct.capdemat.plugins.externalservices.capwebctpaymentmodule.webservice.client;

import java.util.Map;

import org.springframework.ws.client.core.WebServiceTemplate;

public class CapwebctPaymentModuleClient implements ICapwebctPaymentModuleClient {

    private WebServiceTemplate webServiceTemplate;

    private Map<String, String> urls;

    public Object loadInvoiceDetails(Object requestPayload) {
        return webServiceTemplate.marshalSendAndReceive(
            urls.get("loadInvoiceDetails"), requestPayload);
    }

    public Object loadAccountDetails(Object requestPayload) {
        return webServiceTemplate.marshalSendAndReceive(
            urls.get("loadAccountDetails"), requestPayload);
    }

    public Object getFamilyAccounts(Object requestPayload) {
        return webServiceTemplate.marshalSendAndReceive(
            urls.get("getFamilyAccounts"), requestPayload);
    }

    public Object creditAccount(Object requestPayload) {
        return webServiceTemplate.marshalSendAndReceive(
            urls.get("creditAccount"), requestPayload);
    }

    public Object sendRequest(Object requestPayload) {
        return webServiceTemplate.marshalSendAndReceive(
            urls.get("sendRequest"), requestPayload);
    }

    public void setWebServiceTemplate(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public void setUrls(Map<String, String> urls) {
        this.urls = urls;
    }
}
