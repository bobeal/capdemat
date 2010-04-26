package fr.capwebct.capdemat.plugins.externalservices.cirilnetenfance.ws;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.payment.ExternalTicketingContractItem;
import fr.cg95.cvq.business.payment.PurchaseItem;

public class CreditAccount {
    
    private static Logger logger = Logger.getLogger(CreditAccount.class);
    private String endPoint;
    private Collection<PurchaseItem> purchaseItems;
    private String cvqReference;
    private String bankReference;
    private Long homeFolderId;
    private String externalHomeFolderId;
    private String externalId;
    private Date validationDate;
    private String zipCode;
    
    
    public CreditAccount() {}

    public CreditAccount(String endPoint, Collection<PurchaseItem> purchaseItems,
            String cvqReference, String bankReference, Long homeFolderId,
            String externalHomeFolderId, String externalId, Date validationDate, String zipCode) {
        super();
        this.endPoint = endPoint;
        this.purchaseItems = purchaseItems;
        this.cvqReference = cvqReference;
        this.bankReference = bankReference;
        this.homeFolderId = homeFolderId;
        this.externalHomeFolderId = externalHomeFolderId;
        this.externalId = externalId;
        this.validationDate = validationDate;
        this.zipCode = zipCode;
    }

    public void paid() {
        try {
            
            
            int total = 0;
            for (PurchaseItem purchaseItem : purchaseItems) {
                total = total + purchaseItem.getAmount().intValue();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            
            logger.debug("CreditAccount() enter on payment side");
            URL url = new URL(endPoint);
            
            // creating connection object
            SOAPConnectionFactory scFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection con = scFactory.createConnection();
            
            // creating soap message
            MessageFactory factory = MessageFactory.newInstance();
            SOAPMessage message = factory.createMessage();
            
            SOAPPart soapPart = message.getSOAPPart();
            SOAPEnvelope enveloppe = soapPart.getEnvelope();
            
            SOAPHeader header = enveloppe.getHeader();
            header.detachNode();
            // creating body of soap message
            SOAPBody body = enveloppe.getBody();
            Name bodyName = enveloppe.createName("CreditAccount","tns", "Ciril:Enfance:ServicesEnfance");
            SOAPBodyElement gtl = body.addBodyElement(bodyName);
            Name rootElement = enveloppe.createName("bank-transaction");
            Name attVersion = enveloppe.createName("version");
            Name paymentElement = enveloppe.createName("payment");
            Name attCvqAck = enveloppe.createName("cvq-ack");
            Name attPaymentAck = enveloppe.createName("payment-ack");
            Name attPaymentamount = enveloppe.createName("payment-amount");
            Name attPaymentbroker = enveloppe.createName("payment-broker");
            Name attPaymentdate = enveloppe.createName("payment-date");
            Name attPaymenttype = enveloppe.createName("payment-type");
            Name familyElement = enveloppe.createName("family");
            Name attExternalCapDematId = enveloppe.createName("externalCapDematId");
            Name attExternalId = enveloppe.createName("externalId");
            Name attId = enveloppe.createName("id");
            Name attZip = enveloppe.createName("zip");
            Name accountsElement = enveloppe.createName("accounts");
            Name invoicesElement = enveloppe.createName("invoices");
            Name contractsElement = enveloppe.createName("contracts");
            SOAPElement rt = gtl.addChildElement(rootElement);
            rt.addAttribute(attVersion, "1.0");
            SOAPElement paymentPart = rt.addChildElement(paymentElement);
            paymentPart.addAttribute(attCvqAck, cvqReference);
            paymentPart.addAttribute(attPaymentAck, bankReference);
            paymentPart.addAttribute(attPaymentamount, String.valueOf(total));
            paymentPart.addAttribute(attPaymentbroker, "");
            paymentPart.addAttribute(attPaymentdate, String.valueOf(validationDate));
            paymentPart.addAttribute(attPaymenttype, "internet");
            SOAPElement familyPart = rt.addChildElement(familyElement);
            familyPart.addAttribute(attExternalCapDematId, externalHomeFolderId);
            familyPart.addAttribute(attExternalId, externalId);
            familyPart.addAttribute(attId, String.valueOf(homeFolderId));
            familyPart.addAttribute(attZip, zipCode);
            SOAPElement accountsPart = rt.addChildElement(accountsElement);            
            SOAPElement invoicesPart = rt.addChildElement(invoicesElement);
            SOAPElement contractsPart = rt.addChildElement(contractsElement);
            
            for(PurchaseItem item : purchaseItems){
                if(item instanceof ExternalDepositAccountItem){
                    ExternalDepositAccountItem depotItem = (ExternalDepositAccountItem) item;
                    Name depositAccount = enveloppe.createName("account");
                    Name attAccountId = enveloppe.createName("account-id");
                    Name attNewValue = enveloppe.createName("account-new-value");
                    Name attOldValue = enveloppe.createName("account-old-value");
                    Name attOldValueDate = enveloppe.createName("account-old-value-dat");
                    Name attExternalApplicationId = enveloppe.createName("external-application-id");
                    Name attExternalFamilyAccount = enveloppe.createName("external-family-account-id");
                    SOAPElement depot = accountsPart.addChildElement(depositAccount);
                    depot.addAttribute(attAccountId, depotItem.getExternalItemId());
                    depot.addAttribute(attNewValue, String.valueOf(depotItem.getAmount().intValue()));
                    depot.addAttribute(attOldValue, String.valueOf(depotItem.getOldValue()));
                    depot.addAttribute(attOldValueDate, simpleDateFormat.format(depotItem.getOldValueDate()));
                    depot.addAttribute(attExternalCapDematId, "0");
                    depot.addAttribute(attExternalFamilyAccount, externalId);
                }
                if(item instanceof ExternalInvoiceItem ){
                    ExternalInvoiceItem invoiceItem = (ExternalInvoiceItem) item;
                    Name invoiceElement = enveloppe.createName("invoice");
                    Name attInvoiceAmount = enveloppe.createName("amount");
                    Name attInvoiceExternalApplicationId = enveloppe.createName("external-application-id");
                    Name attInvoiceExternalFamilyAccountId = enveloppe.createName("external-family-account-id");
                    Name attInvoiceId = enveloppe.createName("invoice-id");
                    SOAPElement invoice = invoicesPart.addChildElement(invoiceElement);
                    invoice.addAttribute(attInvoiceAmount, String.valueOf(invoiceItem.getAmount().intValue()));
                    invoice.addAttribute(attInvoiceExternalApplicationId, "0");
                    invoice.addAttribute(attInvoiceExternalFamilyAccountId, externalId);
                    invoice.addAttribute(attInvoiceId, invoiceItem.getExternalItemId());
                }
                if(item instanceof ExternalTicketingContractItem){
                    ExternalTicketingContractItem contractItem = (ExternalTicketingContractItem)item;
                    Name ticketElement = enveloppe.createName("contract");
                    Name attTicketAmount = enveloppe.createName("amount");
                    Name attTicketCapwebctExternalindividualId = enveloppe.createName("capwebct-external-individual-id");
                    Name attTicketCapwebctIndividualId = enveloppe.createName("capwebct-individual-id");
                    Name attTicketContractId = enveloppe.createName("contract-id");
                    Name attTicketExternalApplicationId = enveloppe.createName("external-application-id");
                    Name attTicketExternalFamilyAccountId = enveloppe.createName("external-family-account-id");
                    Name attTicketExternalIndividualId = enveloppe.createName("external-individual-id");
                    Name attTicketPrice = enveloppe.createName("price");
                    Name attTicketQuantity = enveloppe.createName("quantity");
                    SOAPElement contract = contractsPart.addChildElement(ticketElement);
                    contract.addAttribute(attTicketAmount, String.valueOf(contractItem.getAmount().intValue()));
                    contract.addAttribute(attTicketCapwebctExternalindividualId, "");
                    contract.addAttribute(attTicketCapwebctIndividualId, String.valueOf(contractItem.getSubjectId()));
                    contract.addAttribute(attTicketContractId, contractItem.getExternalItemId());
                    contract.addAttribute(attTicketExternalApplicationId, "0");
                    contract.addAttribute(attTicketExternalFamilyAccountId, externalId);
                    contract.addAttribute(attTicketExternalIndividualId, "");
                    contract.addAttribute(attTicketPrice, String.valueOf(contractItem.getUnitPrice().intValue()));
                    contract.addAttribute(attTicketQuantity, String.valueOf(contractItem.getQuantity()));
                }
            }
            
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            message.writeTo(outStream);
            String envoi = outStream.toString("UTF-8");
            logger.debug("CreditAccount() Bank-Transaction enveloppe : " + envoi);
            
            con.call(message, url);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final String getEndPoint() {
        return endPoint;
    }

    public final void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public final Collection<PurchaseItem> getPurchaseItems() {
        return purchaseItems;
    }

    public final void setPurchaseItems(Collection<PurchaseItem> purchaseItems) {
        this.purchaseItems = purchaseItems;
    }

    public final String getCvqReference() {
        return cvqReference;
    }

    public final void setCvqReference(String cvqReference) {
        this.cvqReference = cvqReference;
    }

    public final String getBankReference() {
        return bankReference;
    }

    public final void setBankReference(String bankReference) {
        this.bankReference = bankReference;
    }

    public final Long getHomeFolderId() {
        return homeFolderId;
    }

    public final void setHomeFolderId(Long homeFolderId) {
        this.homeFolderId = homeFolderId;
    }

    public final String getExternalHomeFolderId() {
        return externalHomeFolderId;
    }

    public final void setExternalHomeFolderId(String externalHomeFolderId) {
        this.externalHomeFolderId = externalHomeFolderId;
    }

    public final String getExternalId() {
        return externalId;
    }

    public final void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public final Date getValidationDate() {
        return validationDate;
    }

    public final void setValidationDate(Date validationDate) {
        this.validationDate = validationDate;
    }

    
}
