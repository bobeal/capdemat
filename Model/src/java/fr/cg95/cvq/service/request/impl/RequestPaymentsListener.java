package fr.cg95.cvq.service.request.impl;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import fr.cg95.cvq.business.payment.InternalInvoiceItem;
import fr.cg95.cvq.business.payment.Payment;
import fr.cg95.cvq.business.payment.PaymentEvent;
import fr.cg95.cvq.business.payment.PaymentState;
import fr.cg95.cvq.business.payment.PurchaseItem;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.request.IRequestServiceRegistry;
import fr.cg95.cvq.service.request.IRequestWorkflowService;

public class RequestPaymentsListener implements ApplicationListener {

    private static Logger logger = Logger.getLogger(RequestPaymentsListener.class);
    
    private IRequestDAO requestDAO;

    private IRequestServiceRegistry requestServiceRegistry;
    private IRequestWorkflowService requestWorkflowService;

    /**
     * Called by payment service on the reception of a payment operation status.
     *
     * If payment is successful, performs the following :
     * <ul>
     *  <li>Notify service associated to request type</li>
     *  <li>Notify external services</li>
     * </ul>
     */
    private final void notifyPaymentResult(final Payment payment)
        throws CvqException {

        // for each different request found in purchased items list, notify the associated
        // service of payment result status
        Set<Long> requests = new HashSet<Long>();
        Set<PurchaseItem> purchaseItems = payment.getPurchaseItems();
        for (PurchaseItem purchaseItem : purchaseItems) {
            // if purchase item came from us, notify the corresponding service
            if (purchaseItem instanceof InternalInvoiceItem) {
                InternalInvoiceItem internalInvoiceItem = (InternalInvoiceItem) purchaseItem;
                if (internalInvoiceItem.getKeyOwner().equals("capdemat"))
                    requests.add(Long.valueOf(internalInvoiceItem.getKey()));
            }
        }

        if (!requests.isEmpty()) {
            for (Long requestId : requests) {
                Request request = getById(requestId);
                IRequestService requestService = 
                    requestServiceRegistry.getRequestService(request);
                if (payment.getState().equals(PaymentState.VALIDATED))
                    if (requestService.onPaymentValidated(request, payment.getBankReference())) {
                        if (request.getState().equals(RequestState.PENDING))
                            requestWorkflowService.updateRequestState(request.getId(), 
                                    RequestState.COMPLETE, null);
                        requestWorkflowService.updateRequestState(request.getId(), 
                                RequestState.VALIDATED, "request.message.paymentValidated");
                    }
                else if (payment.getState().equals(PaymentState.CANCELLED))
                    if (requestService.onPaymentCancelled(request)) {
                        requestWorkflowService.updateRequestState(request.getId(), 
                                RequestState.CANCELLED, "request.message.paymentCancelled");
                    }
                else if (payment.getState().equals(PaymentState.REFUSED))
                    if (requestService.onPaymentRefused(request)) {
                        requestWorkflowService.updateRequestState(request.getId(), 
                                RequestState.REJECTED, "request.message.paymentRefused");                        
                    }
            }
        }
    }

    protected Request getById(final Long id)
        throws CvqException, CvqObjectNotFoundException {
        return (Request) requestDAO.findById(Request.class, id);
    }


    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof PaymentEvent) {
            PaymentEvent paymentEvent = (PaymentEvent) applicationEvent;
            logger.debug("onApplicationEvent() got a payment event of type "
                    + paymentEvent.getEvent());
            try {
                notifyPaymentResult(paymentEvent.getPayment());
            } catch (CvqException e) {
                // TODO We have nothing to handle this
                logger.error("onApplicationEvent() got an error while notifying payment resutl");
                e.printStackTrace();
            }
        }
    }

    public void setRequestDAO(IRequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    public void setRequestServiceRegistry(IRequestServiceRegistry requestServiceRegistry) {
        this.requestServiceRegistry = requestServiceRegistry;
    }

    public void setRequestWorkflowService(IRequestWorkflowService requestWorkflowService) {
        this.requestWorkflowService = requestWorkflowService;
    }
}
