package fr.capwebct.modules.payment.webservice.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.oxm.Marshaller;
import org.springframework.ws.server.endpoint.AbstractMarshallingPayloadEndpoint;

import fr.capwebct.modules.payment.business.InvoiceDetail;
import fr.capwebct.modules.payment.schema.inv.InvoiceDetailType;
import fr.capwebct.modules.payment.schema.inv.InvoiceDetailsDocument;
import fr.capwebct.modules.payment.schema.inv.InvoiceDetailsRequestDocument;
import fr.capwebct.modules.payment.schema.inv.InvoiceDetailsDocument.InvoiceDetails;
import fr.capwebct.modules.payment.schema.inv.InvoiceDetailsRequestDocument.InvoiceDetailsRequest;
import fr.capwebct.modules.payment.service.IInvoiceService;

/**
 * WS endpoint for retrieval of an invoice details.
 */
public class InvoiceEndpoint extends AbstractMarshallingPayloadEndpoint {

    private final IInvoiceService invoiceService;

    public InvoiceEndpoint(Marshaller marshaller, IInvoiceService invoiceService) {
        super(marshaller);
        this.invoiceService = invoiceService;
    }

    @Override
    protected Object invokeInternal(Object requestObject) throws Exception {
        
        InvoiceDetailsRequestDocument invoiceDetailsRequestDocument =
            (InvoiceDetailsRequestDocument) requestObject;
        InvoiceDetailsRequest invoiceDetailsRequest = 
            invoiceDetailsRequestDocument.getInvoiceDetailsRequest();
        
        InvoiceDetailsDocument invoiceDetailsDocument =
            InvoiceDetailsDocument.Factory.newInstance();
        InvoiceDetails invoiceDetails = invoiceDetailsDocument.addNewInvoiceDetails();
        invoiceDetails.setExternalApplicationId(invoiceDetailsRequest.getExternalApplicationId());
        invoiceDetails.setExternalFamilyAccountId(invoiceDetailsRequest.getExternalFamilyAccountId());
        invoiceDetails.setInvoiceId(invoiceDetailsRequest.getInvoiceId());
        
        List<InvoiceDetail> invoiceDetailList = 
            invoiceService.getInvoiceDetails(invoiceDetailsRequest.getExternalFamilyAccountId(), 
                    invoiceDetailsRequest.getExternalApplicationId(), 
                    invoiceDetailsRequest.getInvoiceId());
        if (invoiceDetailList != null) {
            List<InvoiceDetailType> invoiceDetailTypes = new ArrayList<InvoiceDetailType>();
            for (InvoiceDetail invoiceDetail : invoiceDetailList) {
                invoiceDetailTypes.add(InvoiceDetail.modelToXml(invoiceDetail));
            }
            invoiceDetails.setInvoiceDetailArray(invoiceDetailTypes.toArray(new InvoiceDetailType[] {}));
        }
        
        return invoiceDetailsDocument;
    }
}
