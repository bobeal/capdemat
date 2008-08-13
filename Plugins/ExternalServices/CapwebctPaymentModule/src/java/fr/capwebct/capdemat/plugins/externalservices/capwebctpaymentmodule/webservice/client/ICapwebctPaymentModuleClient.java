package fr.capwebct.capdemat.plugins.externalservices.capwebctpaymentmodule.webservice.client;

public interface ICapwebctPaymentModuleClient {

    Object loadInvoiceDetails(Object requestPayload);

    Object loadAccountDetails(Object requestPayload);

    Object getFamilyAccounts(Object requestPayload);

    Object creditAccount(Object requestPayload);
}
