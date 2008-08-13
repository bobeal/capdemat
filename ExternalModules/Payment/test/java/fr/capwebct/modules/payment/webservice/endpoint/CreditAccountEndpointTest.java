package fr.capwebct.modules.payment.webservice.endpoint;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.xmlbeans.XmlBoolean;

import fr.capwebct.modules.payment.schema.ban.BankTransactionDocument;
import fr.capwebct.modules.payment.schema.ban.FamilyType;
import fr.capwebct.modules.payment.schema.ban.InvoiceUpdateType;
import fr.capwebct.modules.payment.schema.ban.PaymentType;
import fr.capwebct.modules.payment.schema.ban.BankTransactionDocument.BankTransaction;
import fr.capwebct.modules.payment.schema.ban.BankTransactionDocument.BankTransaction.Invoices;
import fr.capwebct.modules.payment.schema.fam.FamilyAccountsRequestDocument;
import fr.capwebct.modules.payment.schema.fam.FamilyDocument;
import fr.capwebct.modules.payment.schema.fam.FamilyAccountsRequestDocument.FamilyAccountsRequest;
import fr.capwebct.modules.payment.schema.fam.FamilyDocument.Family;

public class CreditAccountEndpointTest extends EndpointServiceTestCase {

    private FamilyAccountEndpoint familyAccountEndpoint;
    private CreditAccountEndpoint creditAccountEndpoint;
    
    protected void onSetUp() throws Exception {
        super.onSetUp();
        
        familyAccountEndpoint = 
            new FamilyAccountEndpoint(marshaller, familyAccountService, invoiceService, 
                accountService, contractService);
        creditAccountEndpoint = new CreditAccountEndpoint(marshaller, paymentService);
    }
    
    public void testCreditAccount() throws Exception {
        createAccounts();
        
        // retrieve an account first
        FamilyAccountsRequestDocument farDocument = 
            FamilyAccountsRequestDocument.Factory.newInstance();
        FamilyAccountsRequest far = farDocument.addNewFamilyAccountsRequest();
        far.setHomeFolderId(22);
        far.setLocalAuthority("valdoise");
        
        FamilyDocument familyDocument = 
            (FamilyDocument) familyAccountEndpoint.invokeInternal(farDocument);
        Family family = familyDocument.getFamily();

        Date now = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(now);
        
        BankTransactionDocument bankTransactionDocument = 
            BankTransactionDocument.Factory.newInstance();
        BankTransaction bankTransaction = bankTransactionDocument.addNewBankTransaction();
        
        FamilyType familyType = bankTransaction.addNewFamily();
        familyType.setId(family.getId());
        familyType.setZip("75012");
        
        PaymentType paymentType = bankTransaction.addNewPayment();
        paymentType.setCvqAck("CVQ_ACK");
        paymentType.setPaymentAck("PAYMENT_ACK");
        paymentType.setPaymentAmount(10000);
        paymentType.setPaymentBroker("Broker 1");
        paymentType.setPaymentDate(calendar);
        paymentType.setPaymentType("CB");
        
        Invoices invoices = bankTransaction.addNewInvoices();
        InvoiceUpdateType invoiceUpdateType = invoices.addNewInvoice();
        invoiceUpdateType.setExternalApplicationId(externalApplication.getId());
        invoiceUpdateType.setExternalFamilyAccountId("FAMILY_1");
        invoiceUpdateType.setInvoiceId("FAMILY_1");
        invoiceUpdateType.setAmount(10000);
        
        XmlBoolean result = 
            (XmlBoolean) creditAccountEndpoint.invokeInternal(bankTransactionDocument);
        assertTrue(result.getBooleanValue());
    }
}
