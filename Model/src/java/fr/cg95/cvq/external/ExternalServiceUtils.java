package fr.cg95.cvq.external;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.xmlbeans.XmlObject;
import org.w3c.dom.DocumentFragment;

import fr.capwebct.modules.payment.schema.acc.AccountDetailType;
import fr.capwebct.modules.payment.schema.acc.AccountDetailsResponseDocument;
import fr.capwebct.modules.payment.schema.cns.ConsumptionType;
import fr.capwebct.modules.payment.schema.cns.GetConsumptionsResponseDocument;
import fr.capwebct.modules.payment.schema.fam.AccountType;
import fr.capwebct.modules.payment.schema.fam.ContractType;
import fr.capwebct.modules.payment.schema.fam.FamilyAccountsResponseDocument;
import fr.capwebct.modules.payment.schema.fam.FamilyAccountsResponseDocument.FamilyAccountsResponse;
import fr.capwebct.modules.payment.schema.fam.IndividualContractType;
import fr.capwebct.modules.payment.schema.fam.InvoiceType;
import fr.capwebct.modules.payment.schema.inv.InvoiceDetailType;
import fr.capwebct.modules.payment.schema.inv.InvoiceDetailsResponseDocument;
import fr.cg95.cvq.business.payment.ExternalAccountItem;
import fr.cg95.cvq.business.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.payment.ExternalDepositAccountItemDetail;
import fr.cg95.cvq.business.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.payment.ExternalInvoiceItemDetail;
import fr.cg95.cvq.business.payment.ExternalTicketingContractItem;
import fr.cg95.cvq.service.payment.IPaymentService;
import fr.cg95.cvq.xml.common.RequestType;

public class ExternalServiceUtils {

    public static Map<String, List<ExternalAccountItem>> parseFamilyDocument(
            FamilyAccountsResponseDocument familyDocument, final String externalServiceLabel) {
        FamilyAccountsResponse family = familyDocument.getFamilyAccountsResponse();

        Map<String, List<ExternalAccountItem>> resultMap = 
            new HashMap<String, List<ExternalAccountItem>>();

        if (family.getAccounts() != null) {
            List<ExternalAccountItem> resultEaiList = new ArrayList<ExternalAccountItem>();
            AccountType[] accountTypes = family.getAccounts().getAccountArray();
            for (AccountType accountType : accountTypes) {
                ExternalDepositAccountItem eai = new ExternalDepositAccountItem();
                eai.setSupportedBroker(accountType.getBroker());
                eai.setExternalServiceLabel(externalServiceLabel);
                eai.setExternalItemId(accountType.getAccountId());
                eai.setLabel(accountType.getAccountLabel());
                eai.setOldValue(new Double(accountType.getAccountValue()));
                Calendar oldValueDate = accountType.getAccountDate();
                eai.setOldValueDate(oldValueDate.getTime());
                eai.setAmount(new Double(accountType.getAccountValue()));
                eai.setExternalHomeFolderId(accountType.getExternalFamilyAccountId());
                eai.setExternalApplicationId(String.valueOf(accountType.getExternalApplicationId()));

                resultEaiList.add(eai);
            }
            resultMap.put(IPaymentService.EXTERNAL_DEPOSIT_ACCOUNTS, resultEaiList);
        }

        if (family.getInvoices() != null) {
            List<ExternalAccountItem> resultEaiList = new ArrayList<ExternalAccountItem>();
            InvoiceType[] invoiceTypes = family.getInvoices().getInvoiceArray();
            for (InvoiceType invoiceType : invoiceTypes) {
                ExternalInvoiceItem eii = new ExternalInvoiceItem();
                eii.setSupportedBroker(invoiceType.getBroker());
                eii.setExternalServiceLabel(externalServiceLabel);
                eii.setExternalItemId(invoiceType.getInvoiceId());
                eii.setLabel(invoiceType.getInvoiceLabel());
                eii.setAmount(new Double(invoiceType.getInvoiceValue()));
                Calendar calendar = invoiceType.getInvoiceExpirationDate();
                eii.setExpirationDate(calendar.getTime());
                calendar = invoiceType.getInvoiceDate();
                eii.setIssueDate(calendar.getTime());
                if (invoiceType.getInvoicePaymentDate() != null) {
                    calendar = invoiceType.getInvoicePaymentDate();
                    eii.setPaymentDate(calendar.getTime());
                }
                eii.setIsPaid(invoiceType.getInvoicePaid());
                eii.setExternalHomeFolderId(invoiceType.getExternalFamilyAccountId());
                eii.setExternalApplicationId(String.valueOf(invoiceType.getExternalApplicationId()));

                resultEaiList.add(eii);
            }
            resultMap.put(IPaymentService.EXTERNAL_INVOICES, resultEaiList);
        }

        if (family.getContracts() != null) {
            List<ExternalAccountItem> resultEaiList = new ArrayList<ExternalAccountItem>();
            IndividualContractType[] individualContractTypes = 
                family.getContracts().getIndividualContractArray();
            for (IndividualContractType individualContractType : individualContractTypes) {
                if (individualContractType.getContractArray() != null) {
                    ContractType[] contractTypes = individualContractType.getContractArray();
                    for (ContractType contractType : contractTypes) {
                        ExternalTicketingContractItem etci = new ExternalTicketingContractItem();
                        etci.setSupportedBroker(contractType.getBroker());
                        etci.setExternalServiceLabel(externalServiceLabel);
                        etci.setExternalItemId(contractType.getContractId());
                        etci.setAmount(new Double(contractType.getContractValue()));
                        etci.setOldQuantity(contractType.getContractValue() / contractType.getBuyPrice());
                        etci.setCreationDate(contractType.getContractDate().getTime());
                        etci.setLabel(contractType.getContractLabel());
                        etci.setMaxBuy(contractType.getMaxBuy());
                        etci.setMinBuy(contractType.getMinBuy());
                        etci.setUnitPrice(new Double(contractType.getBuyPrice()));
                        etci.setSubjectId(individualContractType.getCapwebctIndividualId());

                        etci.setExternalHomeFolderId(contractType.getExternalFamilyAccountId());
                        etci.setExternalApplicationId(String.valueOf(contractType.getExternalApplicationId()));
                        etci.setExternalIndividualId(contractType.getExternalIndividualId());

                        resultEaiList.add(etci);
                    }
                    resultMap.put(IPaymentService.EXTERNAL_TICKETING_ACCOUNTS, resultEaiList);
                }
            }
        }
        return resultMap;
    }
    
    public static RequestType getRequestTypeFromXmlObject(XmlObject xmlObject) {
        String classSimpleName = xmlObject.getClass().getSimpleName();
        String methodNameToInvoke = 
            "get" + classSimpleName.substring(0, classSimpleName.lastIndexOf("Document"));
        RequestType requestType = null;
        try {
            requestType = (RequestType) 
                xmlObject.getClass().getMethod(methodNameToInvoke).invoke(xmlObject);
        } catch (Exception e) {
            // unlikely to happen but ...
            e.printStackTrace();
        }
        
        return requestType;
    }
    
    public static String getRequestFromFragment(XmlObject xmlRequest) {
        String requestAsString = null;
        try {
            DocumentFragment documentFragment = (DocumentFragment) xmlRequest.newDomNode();
            Source source = new DOMSource(documentFragment);
            StringWriter stringWriter = new StringWriter();
            Result result = new StreamResult(stringWriter);
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            transformer.transform(source, result);
            requestAsString = stringWriter.getBuffer().toString();
            requestAsString = requestAsString.substring(requestAsString.indexOf('>') + 1);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
            return null;
        } catch (TransformerException e) {
            e.printStackTrace();
            return null;
        }

        return requestAsString;
    }

    public static Map<Date, String> parseConsumptions(GetConsumptionsResponseDocument doc) {
        ConsumptionType[] consumptions = doc.getGetConsumptionsResponse().getConsumptionArray();
        Map<Date, String> result = new HashMap<Date, String>();
        for (int i = 0; i < consumptions.length; i++) {
            result.put(consumptions[i].getDate().getTime(), consumptions[i].getLabel());
        }
        return result;
    }

    public static void fillDepositAccountItem(ExternalDepositAccountItem edai,
        AccountDetailsResponseDocument doc) {
        for (AccountDetailType accountDetailType :
            doc.getAccountDetailsResponse().getAccountDetailArray()) {
            ExternalDepositAccountItemDetail edaiDetail = new ExternalDepositAccountItemDetail();
            edaiDetail.setDate(accountDetailType.getDate().getTime());
            edaiDetail.setHolderName(accountDetailType.getHolderName());
            edaiDetail.setHolderSurname(accountDetailType.getHolderSurname());
            edaiDetail.setPaymentId(accountDetailType.getPaymentAck());
            edaiDetail.setPaymentType(accountDetailType.getPaymentType());
            edaiDetail.setValue(accountDetailType.getValue());
            if (edai.getAccountDetails() == null)
                edai.setAccountDetails(new HashSet<ExternalDepositAccountItemDetail>());
            edai.addAccountDetail(edaiDetail);
        }
    }

    public static void fillInvoiceItem(ExternalInvoiceItem eii, InvoiceDetailsResponseDocument doc) {
        for (InvoiceDetailType invoiceDetailType :
            doc.getInvoiceDetailsResponse().getInvoiceDetailArray()) {
            ExternalInvoiceItemDetail eiiDetail = new ExternalInvoiceItemDetail();
            eiiDetail.setSubjectName(invoiceDetailType.getChildName());
            eiiDetail.setSubjectSurname(invoiceDetailType.getChildSurname());
            eiiDetail.setLabel(invoiceDetailType.getLabel());
            eiiDetail.setQuantity(invoiceDetailType.getQuantity());
            eiiDetail.setUnitPrice(invoiceDetailType.getUnitPrice());
            eiiDetail.setValue(invoiceDetailType.getValue());
            if (eii.getInvoiceDetails() == null)
                eii.setInvoiceDetails(new HashSet<ExternalInvoiceItemDetail>());
            eii.getInvoiceDetails().add(eiiDetail);
        }
    }
}
