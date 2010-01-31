package fr.capwebct.capdemat.plugins.externalservices.capwebctpaymentmodule.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlObject;

import fr.capwebct.capdemat.plugins.externalservices.capwebctpaymentmodule.webservice.client.ICapwebctPaymentModuleClient;
import fr.capwebct.modules.payment.schema.acc.AccountDetailType;
import fr.capwebct.modules.payment.schema.acc.AccountDetailsDocument;
import fr.capwebct.modules.payment.schema.acc.AccountDetailsRequestDocument;
import fr.capwebct.modules.payment.schema.acc.AccountDetailsRequestDocument.AccountDetailsRequest;
import fr.capwebct.modules.payment.schema.ban.AccountUpdateType;
import fr.capwebct.modules.payment.schema.ban.BankTransactionDocument;
import fr.capwebct.modules.payment.schema.ban.ContractUpdateType;
import fr.capwebct.modules.payment.schema.ban.FamilyType;
import fr.capwebct.modules.payment.schema.ban.InvoiceUpdateType;
import fr.capwebct.modules.payment.schema.ban.PaymentType;
import fr.capwebct.modules.payment.schema.ban.BankTransactionDocument.BankTransaction;
import fr.capwebct.modules.payment.schema.fam.FamilyAccountsRequestDocument;
import fr.capwebct.modules.payment.schema.fam.FamilyDocument;
import fr.capwebct.modules.payment.schema.fam.FamilyAccountsRequestDocument.FamilyAccountsRequest;
import fr.capwebct.modules.payment.schema.inv.InvoiceDetailType;
import fr.capwebct.modules.payment.schema.inv.InvoiceDetailsDocument;
import fr.capwebct.modules.payment.schema.inv.InvoiceDetailsRequestDocument;
import fr.capwebct.modules.payment.schema.inv.InvoiceDetailsRequestDocument.InvoiceDetailsRequest;
import fr.capwebct.modules.payment.schema.sre.SendRequestRequestDocument;
import fr.capwebct.modules.payment.schema.sre.SendRequestRequestDocument.SendRequestRequest;
import fr.cg95.cvq.business.payment.ExternalAccountItem;
import fr.cg95.cvq.business.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.payment.ExternalDepositAccountItemDetail;
import fr.cg95.cvq.business.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.payment.ExternalInvoiceItemDetail;
import fr.cg95.cvq.business.payment.ExternalTicketingContractItem;
import fr.cg95.cvq.business.payment.PurchaseItem;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.ExternalServiceUtils;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.xml.common.RequestType;

public class CapwebctPaymentModuleService implements IExternalProviderService {

    private static Logger logger = Logger.getLogger(CapwebctPaymentModuleService.class);
    
    private String label;

    private ICapwebctPaymentModuleClient capwebctPaymentModuleClient;

    public void init() {
    }
    
    public Map<String, List<ExternalAccountItem>> getAccountsByHomeFolder(Long homeFolderId, 
            String externalHomeFolderId, String externalId)
        throws CvqException {
        
        FamilyAccountsRequestDocument farDocument = 
            FamilyAccountsRequestDocument.Factory.newInstance();
        FamilyAccountsRequest far = farDocument.addNewFamilyAccountsRequest();
        far.setLocalAuthority(SecurityContext.getCurrentSite().getName());
        far.setHomeFolderId(homeFolderId);

        FamilyDocument familyDocument = 
            (FamilyDocument) capwebctPaymentModuleClient.getFamilyAccounts(farDocument);

        return ExternalServiceUtils.parseFamilyDocument(familyDocument, getLabel());
    }

    public void loadDepositAccountDetails(ExternalDepositAccountItem edai) throws CvqException {
        if (edai.getExternalItemId() == null
                || edai.getExternalServiceSpecificDataByKey(ExternalServiceUtils.EXTERNAL_APPLICATION_ID_KEY) == null
                || edai.getExternalServiceSpecificDataByKey(ExternalServiceUtils.EXTERNAL_FAMILY_ACCOUNT_ID_KEY) == null) {
            edai = null;
            logger.debug("loadDepositAccountDetails() Received un-handled deposit account, returning");
            return;
        }
        
        AccountDetailsRequestDocument accountDetailsRequestDocument =
            AccountDetailsRequestDocument.Factory.newInstance();
        AccountDetailsRequest accountDetailsRequest = 
            accountDetailsRequestDocument.addNewAccountDetailsRequest();
        accountDetailsRequest.setAccountId(edai.getExternalItemId());
        accountDetailsRequest.setExternalApplicationId(
                Long.valueOf(edai.getExternalServiceSpecificDataByKey(ExternalServiceUtils.EXTERNAL_APPLICATION_ID_KEY)));
        accountDetailsRequest.setExternalFamilyAccountId(
                edai.getExternalServiceSpecificDataByKey(ExternalServiceUtils.EXTERNAL_FAMILY_ACCOUNT_ID_KEY));

        // FIXME : hard-coded 3 months range
        Date dateTo = new Date();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(dateTo);
        accountDetailsRequest.setEndSearch(calendar);
        calendar.add(Calendar.MONTH, -3);
        accountDetailsRequest.setStartSearch(calendar);
        
        // Calls webservice
        AccountDetailsDocument accountDetailsDocument = (AccountDetailsDocument) 
            capwebctPaymentModuleClient.loadAccountDetails(accountDetailsRequestDocument);

        AccountDetailType[] accountDetailTypes = 
            accountDetailsDocument.getAccountDetails().getAccountDetailArray();
        for (int i = 0; i < accountDetailTypes.length; i++) {
            AccountDetailType accountDetailType = accountDetailTypes[i];
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

    public void loadInvoiceDetails(ExternalInvoiceItem eii) throws CvqException {
        if (eii.getExternalItemId() == null
                || eii.getExternalServiceSpecificDataByKey(ExternalServiceUtils.EXTERNAL_APPLICATION_ID_KEY) == null
                || eii.getExternalServiceSpecificDataByKey(ExternalServiceUtils.EXTERNAL_FAMILY_ACCOUNT_ID_KEY) == null) {
            eii = null;
            return;
        }
        
        InvoiceDetailsRequestDocument invoiceDetailsRequestDocument =
            InvoiceDetailsRequestDocument.Factory.newInstance();
        InvoiceDetailsRequest invoiceDetailsRequest =
            invoiceDetailsRequestDocument.addNewInvoiceDetailsRequest();
        invoiceDetailsRequest.setInvoiceId(eii.getExternalItemId());
        invoiceDetailsRequest.setExternalApplicationId(
                Long.valueOf(eii.getExternalServiceSpecificDataByKey(ExternalServiceUtils.EXTERNAL_APPLICATION_ID_KEY)));
        invoiceDetailsRequest.setExternalFamilyAccountId(
                eii.getExternalServiceSpecificDataByKey(ExternalServiceUtils.EXTERNAL_FAMILY_ACCOUNT_ID_KEY));

        // Calls webservice
        InvoiceDetailsDocument invoiceDetailsDocument = (InvoiceDetailsDocument) 
            capwebctPaymentModuleClient.loadInvoiceDetails(invoiceDetailsRequestDocument);

        InvoiceDetailType[] invoiceDetailTypes = 
            invoiceDetailsDocument.getInvoiceDetails().getInvoiceDetailArray();
        for (int i = 0; i < invoiceDetailTypes.length; i++) {
            ExternalInvoiceItemDetail eiiDetail = new ExternalInvoiceItemDetail();
            InvoiceDetailType invoiceDetailType = invoiceDetailTypes[i];
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

    public void creditHomeFolderAccounts(Collection<PurchaseItem> purchaseItems, String cvqReference,
            String bankReference, Long homeFolderId, String externalHomeFolderId, String externalId, 
            Date validationDate) throws CvqException {
        
        BankTransactionDocument bankTransactionDocument = 
            BankTransactionDocument.Factory.newInstance();
        BankTransaction bankTransaction = bankTransactionDocument.addNewBankTransaction();

        FamilyType familyType = bankTransaction.addNewFamily();
        familyType.setId(homeFolderId);
        familyType.setZip(SecurityContext.getCurrentSite().getPostalCode());

        Calendar calendar = Calendar.getInstance();
        int totalAmount = 0;
        String broker = null;
        for (PurchaseItem purchaseItem : purchaseItems) {
            // purchase items in a payment transaction can not belong to more than one broker
            // so take the first we meet
            if (broker == null)
                broker = purchaseItem.getSupportedBroker();
            totalAmount += purchaseItem.getAmount().intValue();
        }
        PaymentType paymentType = bankTransaction.addNewPayment();
        paymentType.setPaymentBroker(broker);
        paymentType.setCvqAck(cvqReference);
        paymentType.setPaymentAck(bankReference);
        paymentType.setPaymentAmount(totalAmount);
        paymentType.setPaymentType("CB");
        calendar.setTime(validationDate);
        paymentType.setPaymentDate(calendar);

        List<AccountUpdateType> accountUpdateTypes = new ArrayList<AccountUpdateType>();
        List<ContractUpdateType> contractUpdateTypes = new ArrayList<ContractUpdateType>();
        List<InvoiceUpdateType> invoiceUpdateTypes = new ArrayList<InvoiceUpdateType>();
        for (PurchaseItem purchaseItem : purchaseItems) {

            if (purchaseItem instanceof ExternalDepositAccountItem) {
                ExternalDepositAccountItem edai = (ExternalDepositAccountItem) purchaseItem;
                AccountUpdateType updateType = AccountUpdateType.Factory.newInstance();
                updateType.setAccountId(edai.getExternalItemId());
                updateType.setExternalApplicationId(
                        Long.valueOf(edai.getExternalServiceSpecificDataByKey(ExternalServiceUtils.EXTERNAL_APPLICATION_ID_KEY)));
                updateType.setExternalFamilyAccountId(
                        edai.getExternalServiceSpecificDataByKey(ExternalServiceUtils.EXTERNAL_FAMILY_ACCOUNT_ID_KEY));
                updateType.setAccountNewValue(edai.getOldValue().intValue() + edai.getAmount().intValue());
                updateType.setAccountOldValue(edai.getOldValue().intValue());
                calendar.setTime(edai.getOldValueDate());
                updateType.setAccountOldValueDate(calendar);
                accountUpdateTypes.add(updateType);
            }

            if (purchaseItem instanceof ExternalInvoiceItem) {
                ExternalInvoiceItem eii = (ExternalInvoiceItem) purchaseItem;
                InvoiceUpdateType updateType = InvoiceUpdateType.Factory.newInstance();
                updateType.setInvoiceId(eii.getExternalItemId());
                updateType.setExternalApplicationId(
                        Long.valueOf(eii.getExternalServiceSpecificDataByKey(ExternalServiceUtils.EXTERNAL_APPLICATION_ID_KEY)));
                updateType.setExternalFamilyAccountId(
                        eii.getExternalServiceSpecificDataByKey(ExternalServiceUtils.EXTERNAL_FAMILY_ACCOUNT_ID_KEY));
                updateType.setAmount(eii.getAmount().intValue());
                invoiceUpdateTypes.add(updateType);
            }

            if (purchaseItem instanceof ExternalTicketingContractItem) {
                ExternalTicketingContractItem etci = (ExternalTicketingContractItem) purchaseItem;
                ContractUpdateType updateType = ContractUpdateType.Factory.newInstance();
                updateType.setContractId(etci.getExternalItemId());
                updateType.setExternalApplicationId(
                        Long.valueOf(etci.getExternalServiceSpecificDataByKey(ExternalServiceUtils.EXTERNAL_APPLICATION_ID_KEY)));
                updateType.setExternalFamilyAccountId(
                        etci.getExternalServiceSpecificDataByKey(ExternalServiceUtils.EXTERNAL_FAMILY_ACCOUNT_ID_KEY));
                updateType.setExternalIndividualId(
                        etci.getExternalServiceSpecificDataByKey(ExternalServiceUtils.EXTERNAL_INDIVIDUAL_ID_KEY));
                updateType.setCapwebctIndividualId(etci.getSubjectId());
                updateType.setPrice(etci.getUnitPrice().intValue());
                updateType.setQuantity(etci.getQuantity());
                updateType.setAmount(etci.getAmount().intValue());
                contractUpdateTypes.add(updateType);
            }
        }
        if (accountUpdateTypes.size() > 0)
            bankTransaction.addNewAccounts().setAccountArray(
                    accountUpdateTypes.toArray(new AccountUpdateType[]{}));
        if (contractUpdateTypes.size() > 0)
            bankTransaction.addNewContracts().setContractArray(
                    contractUpdateTypes.toArray(new ContractUpdateType[]{}));
        if (invoiceUpdateTypes.size() > 0)
            bankTransaction.addNewInvoices().setInvoiceArray(
                    invoiceUpdateTypes.toArray(new InvoiceUpdateType[]{}));
        
        capwebctPaymentModuleClient.creditAccount(bankTransactionDocument);
    }

    public String sendRequest(XmlObject requestXml) throws CvqException {
        SendRequestRequestDocument sendRequestRequestDocument =
            SendRequestRequestDocument.Factory.newInstance();
        SendRequestRequest sendRequestRequest =
            sendRequestRequestDocument.addNewSendRequestRequest();
        RequestType request = null;
        try {
            request = (RequestType)requestXml.getClass()
                .getMethod("get" + requestXml.getClass().getSimpleName()
                .replace("DocumentImpl", "")).invoke(requestXml);
        } catch (IllegalAccessException e) {
            logger.error("fillXmlObject() Illegal access exception while filling request xml");
            throw new CvqException("Illegal access exception while filling request xml");
        } catch (InvocationTargetException e) {
            logger.error("fillXmlObject() Invocation target exception while filling request xml");
            throw new CvqException("Invocation target exception while filling request xml");
        } catch (NoSuchMethodException e) {
            logger.error("fillXmlObject() No such method exception while filling request xml");
            throw new CvqException("No such method exception while filling request xml");
        }
        sendRequestRequest.setRequest(request);
        sendRequestRequest.setRequestTypeLabel(request.getRequestTypeLabel());
        capwebctPaymentModuleClient.sendRequest(sendRequestRequestDocument);
        return "";
    }

    /** ***** Not Implemented methods ****** */
    /** *********************************** */

    public Map<Date, String> getConsumptionsByRequest(Request request, Date dateFrom, Date dateTo)
            throws CvqException {
        return null;
    }

    public void checkConfiguration(ExternalServiceBean externalServiceBean)
            throws CvqConfigurationException {
        logger.debug("checkConfiguration() nothing special to do");
    }

    public String helloWorld() throws CvqException {
        return null;
    }

    /** ******************************* */

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setCapwebctPaymentModuleClient(ICapwebctPaymentModuleClient capwebctPaymentModuleClient) {
        this.capwebctPaymentModuleClient = capwebctPaymentModuleClient;
    }

    public boolean supportsConsumptions() {
        return false;
    }

    public boolean handlesTraces() {
        return false;
    }

    public List<String> checkExternalReferential(final XmlObject requestXml) {
        return new ArrayList<String>(0);
    }

    public Map<String, Object> loadExternalInformations(XmlObject requestXml)
        throws CvqException {
        return Collections.emptyMap();
    }
}
