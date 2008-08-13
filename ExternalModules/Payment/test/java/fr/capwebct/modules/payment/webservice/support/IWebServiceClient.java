package fr.capwebct.modules.payment.webservice.support;

public interface IWebServiceClient {

    Object sendAndRecieve(Object RequestPayload);
    
    Object invoiceDetailsSendAndRecieve(Object requestPayload);
    
    Object accountDetailsSendAndRecieve(Object requestPayload);
    
    Object familyAccountsSendAndRecieve(Object requestPayload);
    
    Object creditAccountSendAndRecieve(Object requestPayload);
}
