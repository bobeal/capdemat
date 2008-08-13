package fr.capwebct.modules.payment.webservice.endpoint;

import org.apache.xmlbeans.XmlBoolean;
import org.springframework.oxm.Marshaller;
import org.springframework.ws.server.endpoint.AbstractMarshallingPayloadEndpoint;

import fr.capwebct.modules.payment.business.ws.PaymentTransaction;
import fr.capwebct.modules.payment.schema.ban.BankTransactionDocument;
import fr.capwebct.modules.payment.service.IPaymentService;

/**
 * WS endpoint for credit account operations.
 */
public class CreditAccountEndpoint extends AbstractMarshallingPayloadEndpoint {

    private final IPaymentService paymentService;

    public CreditAccountEndpoint(Marshaller marshaller, IPaymentService paymentService) {
        super(marshaller);
        this.paymentService = paymentService;
    }

    @Override
    protected Object invokeInternal(Object requestObject) throws Exception {
        BankTransactionDocument bankTransactionDocument = (BankTransactionDocument) requestObject;
        PaymentTransaction paymentTransaction = PaymentTransaction.xmlToModel(bankTransactionDocument);
        paymentService.creditFamilyAccount(paymentTransaction);
        
        XmlBoolean xmlBoolean = XmlBoolean.Factory.newInstance();
        xmlBoolean.setBooleanValue(true);
        return xmlBoolean;
    }   
} 