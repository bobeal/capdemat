package fr.cg95.cvq.external;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.xmlbeans.XmlObject;

import fr.capwebct.modules.payment.schema.fam.AccountType;
import fr.capwebct.modules.payment.schema.fam.ContractType;
import fr.capwebct.modules.payment.schema.fam.FamilyDocument;
import fr.capwebct.modules.payment.schema.fam.IndividualContractType;
import fr.capwebct.modules.payment.schema.fam.InvoiceType;
import fr.capwebct.modules.payment.schema.fam.FamilyDocument.Family;
import fr.cg95.cvq.business.payment.ExternalAccountItem;
import fr.cg95.cvq.business.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.payment.ExternalTicketingContractItem;
import fr.cg95.cvq.service.payment.IPaymentService;
import fr.cg95.cvq.xml.common.RequestType;

public class ExternalServiceUtils {

    public static final String EXTERNAL_APPLICATION_ID_KEY = "externalApplicationId";
    public static final String EXTERNAL_FAMILY_ACCOUNT_ID_KEY = "externalFamilyAccountId";
    public static final String EXTERNAL_INDIVIDUAL_ID_KEY = "externalIndividualId";

    public static Map<String, List<ExternalAccountItem>> parseFamilyDocument(FamilyDocument familyDocument,
            final String externalServiceLabel) {
        Family family = familyDocument.getFamily();

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
                eai.addExternalServiceSpecificData(EXTERNAL_FAMILY_ACCOUNT_ID_KEY,
                        accountType.getExternalFamilyAccountId());
                eai.addExternalServiceSpecificData(EXTERNAL_APPLICATION_ID_KEY, 
                        String.valueOf(accountType.getExternalApplicationId()));

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

                eii.addExternalServiceSpecificData(ExternalServiceUtils.EXTERNAL_FAMILY_ACCOUNT_ID_KEY,
                        invoiceType.getExternalFamilyAccountId());
                eii.addExternalServiceSpecificData(ExternalServiceUtils.EXTERNAL_APPLICATION_ID_KEY, 
                        String.valueOf(invoiceType.getExternalApplicationId()));

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

                        etci.addExternalServiceSpecificData(ExternalServiceUtils.EXTERNAL_FAMILY_ACCOUNT_ID_KEY,
                                contractType.getExternalFamilyAccountId());
                        etci.addExternalServiceSpecificData(ExternalServiceUtils.EXTERNAL_APPLICATION_ID_KEY, 
                                String.valueOf(contractType.getExternalApplicationId()));
                        etci.addExternalServiceSpecificData(ExternalServiceUtils.EXTERNAL_INDIVIDUAL_ID_KEY, 
                                contractType.getExternalIndividualId());

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
}
