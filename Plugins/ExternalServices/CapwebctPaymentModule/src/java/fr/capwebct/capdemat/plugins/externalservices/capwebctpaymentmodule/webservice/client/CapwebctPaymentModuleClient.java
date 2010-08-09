package fr.capwebct.capdemat.plugins.externalservices.capwebctpaymentmodule.webservice.client;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.ws.client.core.WebServiceTemplate;

import fr.capwebct.modules.payment.schema.cer.CheckExternalReferentialRequestDocument;
import fr.capwebct.modules.payment.schema.cer.CheckExternalReferentialResponseDocument;
import fr.capwebct.modules.payment.schema.cer.CheckExternalReferentialResponseDocument.CheckExternalReferentialResponse;
import fr.capwebct.modules.payment.schema.cns.ConsumptionType;
import fr.capwebct.modules.payment.schema.cns.GetConsumptionsResponseDocument;
import fr.capwebct.modules.payment.schema.cns.GetConsumptionsResponseDocument.GetConsumptionsResponse;
import fr.capwebct.modules.payment.schema.rei.ExternalInformationType;
import fr.capwebct.modules.payment.schema.rei.GetExternalInformationResponseDocument;
import fr.capwebct.modules.payment.schema.rei.GetExternalInformationResponseDocument.GetExternalInformationResponse;
import fr.cg95.cvq.xml.common.RequestType;

public class CapwebctPaymentModuleClient implements ICapwebctPaymentModuleClient {

    private static Logger logger = Logger.getLogger(CapwebctPaymentModuleClient.class);
    
    private WebServiceTemplate webServiceTemplate;
    private boolean isFake = false;

    private Map<String, String> urls;

    @Override
    public Object loadInvoiceDetails(Object requestPayload) {
        return makeCall("loadInvoiceDetails", requestPayload);
    }

    @Override
    public Object loadAccountDetails(Object requestPayload) {
        return makeCall("loadAccountDetails", requestPayload);
    }

    @Override
    public Object getFamilyAccounts(Object requestPayload) {
        return makeCall("getFamilyAccounts", requestPayload);
    }

    @Override
    public Object creditAccount(Object requestPayload) {
        return makeCall("creditAccount", requestPayload);
    }

    @Override
    public Object sendRequest(Object requestPayload) {
        return makeCall("sendRequest", requestPayload);
    }

    @Override
    public Object checkExternalReferential(Object requestPayload) {
        return makeCall("checkExternalReferential", requestPayload);
    }

    @Override
    public Object getConsumptions(Object requestPayload) {
        return makeCall("getConsumptions", requestPayload);
    }

    @Override
    public Object loadExternalInformation(Object requestPayload) {
        return makeCall("loadExternalInformation", requestPayload);
    }

    private Object makeCall(String mapping, Object requestPayload) {
        if (!isFake) {
            return webServiceTemplate.marshalSendAndReceive(
                    urls.get(mapping), requestPayload);
        } else {
            logger.debug("makeCall() got request payload : " + requestPayload);
            
            if (mapping.equals("checkExternalReferential")) {
                CheckExternalReferentialResponseDocument checkExternalReferentialResponseDocument =
                    CheckExternalReferentialResponseDocument.Factory.newInstance();
                CheckExternalReferentialResponse checkExternalReferentialResponse =
                    checkExternalReferentialResponseDocument.addNewCheckExternalReferentialResponse();
                
                // return an empty list if request is not validated, else it won't be (validated)
                CheckExternalReferentialRequestDocument checkExternalReferentialRequestDocument =
                    (CheckExternalReferentialRequestDocument) requestPayload;
                RequestType requestType = 
                    checkExternalReferentialRequestDocument.getCheckExternalReferentialRequest().getRequest();
                logger.debug("got state : " + requestType.getState().toString());
                if (!requestType.getState().toString().equals("Complete")) {
                    checkExternalReferentialResponse.addMessage("The field A is correct");
                    checkExternalReferentialResponse.addMessage("The field B is wrong");
                }
                return checkExternalReferentialResponseDocument;
            } else if (mapping.equals("loadExternalInformation")) {
                GetExternalInformationResponseDocument getExternalInformationResponseDocument =
                    GetExternalInformationResponseDocument.Factory.newInstance();
                GetExternalInformationResponse getExternalInformationResponse =
                    getExternalInformationResponseDocument.addNewGetExternalInformationResponse();
                ExternalInformationType externalInformation = getExternalInformationResponse.addNewExternalInformation();
                externalInformation.setKey("Key A");
                externalInformation.setValue("Value A");
                externalInformation = getExternalInformationResponse.addNewExternalInformation();
                externalInformation.setKey("Key B");
                externalInformation.setValue("Value B");
                return getExternalInformationResponseDocument;
            } else if (mapping.equals("getConsumptions")) {
                GetConsumptionsResponseDocument getConsumptionsResponseDocument =
                    GetConsumptionsResponseDocument.Factory.newInstance();
                GetConsumptionsResponse getConsumptionsResponse = 
                    getConsumptionsResponseDocument.addNewGetConsumptionsResponse();
                ConsumptionType consumption = getConsumptionsResponse.addNewConsumption();
                Date now = new Date();
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(now);
                consumption.setDate(calendar);
                consumption.setLabel("Canteen");
                consumption = getConsumptionsResponse.addNewConsumption();
                calendar.add(Calendar.DAY_OF_MONTH, 3);
                consumption.setDate(calendar);
                consumption.setLabel("Perischool");
                return getConsumptionsResponseDocument;
            } else {
                return null;
            }
        }
    }

    public void setWebServiceTemplate(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public void setUrls(Map<String, String> urls) {
        this.urls = urls;
    }

    public void setFake(boolean isFake) {
        this.isFake = isFake;
    }
    
}
