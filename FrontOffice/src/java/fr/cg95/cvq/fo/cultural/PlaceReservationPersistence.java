package fr.cg95.cvq.fo.cultural;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.users.payment.InternalRequestItem;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.business.users.payment.PaymentMode;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.IPersistence;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.cultural.reservation.form.Abonnee;
import fr.cg95.cvq.fo.referential.PlaceReservationAction;
import fr.cg95.cvq.payment.IPaymentService;
import fr.cg95.cvq.service.reservation.IPlaceReservationRequestService;
import fr.cg95.cvq.wizard.IStageForm;
import fr.cg95.cvq.wizard.ReservationNode;
import fr.cg95.cvq.wizard.WizardListener;
import fr.cg95.cvq.wizard.process.ProcessWizardState;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.reservation.PlaceReservationRequestDocument;
import fr.cg95.cvq.xml.reservation.PlaceReservationRequestDocument.PlaceReservationRequest;

public class PlaceReservationPersistence extends IPersistence implements WizardListener {

    private static Logger logger = Logger.getLogger(PlaceReservationPersistence.class);

    public String getServiceName(String definitionName) {
        return IPlaceReservationRequestService.SERVICE_NAME;
    }

    public RequestType createRequest(HttpServletRequest request, Request cvqRequest) {
        cvqRequest.setDbRequest(new fr.cg95.cvq.business.reservation.PlaceReservationRequest());

        request.setAttribute("requiredEmail",new Boolean(true));

        PlaceReservationRequest rr = PlaceReservationRequest.Factory.newInstance();
        
        return rr;
    }

    public Long validateRequest(HttpServletRequest request, Request cvqRequest, Object xmlRequestData)
            throws Exception {
        PlaceReservationRequest xmlRequest = (PlaceReservationRequest) xmlRequestData;

        PlaceReservationRequestDocument document = PlaceReservationRequestDocument.Factory.newInstance();
        document.setPlaceReservationRequest(xmlRequest);

        IPlaceReservationRequestService service = (IPlaceReservationRequestService) BusinessManager.getAc()
                .getBean(IPlaceReservationRequestService.SERVICE_NAME);

        return service.create(document.getDomNode());
    }

    public void terminateRequest(HttpServletRequest request, ProcessWizardState wizardState,
            Request cvqRequest) {

        ReservationNode reservations = (ReservationNode) request.getSession().getAttribute(
                "Place Reservation");

        // The request has been validated so we follow on with the payment
        if (cvqRequest.isAlreadyExecuted()) {
            // If the wizardstate is NULL and request has been validate we arrive here with the next stage
            // button, so we do nothing
            if (wizardState != null) {
                int totalPrice = new Float(reservations.getTotalPrice() * 100).intValue();

                // FIXME : temporary fix in order to have the request object when initiating
                //         the payment objects
                fr.cg95.cvq.business.request.Request modelRequest = null;
                try {
                    modelRequest = 
                        BusinessManager.getInstance().getDefaultRequestService().getById(cvqRequest.getId());
                } catch (CvqException e) {
                    logger.error("TerminateRequest: getRequestById", e);
                }
                
                InternalRequestItem iri = 
                    new InternalRequestItem("Billetterie",
                            Double.valueOf(totalPrice), modelRequest, 
                            null, Integer.valueOf("1"), Double.valueOf(totalPrice));

                IPaymentService paymentService = BusinessManager.getInstance().getPaymentService();
                if (paymentService != null) {
                    try {
                        // FIXME hard coded PaymentMode
                        Payment payment = paymentService.createPaymentContainer(iri, PaymentMode.INTERNET);
                        URL url = paymentService.initPayment(payment);
                        logger.debug("TerminateRequest: paymentURL: " + url.toString());
                        
                        // int returnStatus = iPaylinePaymentService.commitPayment(url.toString());
                        // Assert.assertEquals(returnStatus, IPaymentService.OK_RETURN);

                        wizardState.setTransition("pay");
                        request.getSession().setAttribute("paymentUrl", url.toString());

                    } catch (CvqException e) {
                        logger.error("TerminateRequest: paymentService", e);
                    }
                } else {
                    logger.error("TerminateRequest: No payment service!!");
                    
                }
            }
        } else if (reservations != null) { // The request has been cancelled so we have to reset the
                                            // counters.
            ArrayList spectacles = reservations.getChildren();
            for (int i = 0; i < spectacles.size(); i++) {
                ReservationNode spectacle = (ReservationNode) spectacles.get(i);
                BusinessManager.updateReservationData("Place Reservation", spectacle.getKey(), 
                                                                            -1 * spectacle.getAllReserved());
            }
        }
    }

    public String onStateChange(HttpServletRequest request, IStageForm stageForm, String state, String newState) {
        String correctedState = newState;
        // Check subscriber number if it has been submitted (POST)
        if ((stageForm instanceof Abonnee) && (request.getMethod().equals("POST"))) {
            request.getSession().removeAttribute(PlaceReservationAction.MAX_SUBSCRIBER_PLACES);
            request.getSession().removeAttribute("Place Reservation");

            Abonnee abonnee = (Abonnee)stageForm;
            if (abonnee.getSubscriberNumber().trim().length() > 0) {
                IPlaceReservationRequestService service = 
                    (IPlaceReservationRequestService) BusinessManager.getAc().getBean(IPlaceReservationRequestService.SERVICE_NAME);
                try {
                    if (service.isValidSubscriberNumber(abonnee.getSubscriberNumber())) {
                        Map<String, Integer> authorizedPlaces = service.getAuthorizedNumberOfPlaces(abonnee.getSubscriberNumber());
                        request.getSession().setAttribute(PlaceReservationAction.MAX_SUBSCRIBER_PLACES, authorizedPlaces);
                    } else {
                        ProcessWizardState wizardState = ProcessWizardState.getWizardState(request);
                        wizardState.setMessage("Numéro d'abonné inconnu: " + abonnee.getSubscriberNumber());
                        wizardState.setEndStage(false);
                        correctedState = "abonnee";
                    }
                } catch (CvqObjectNotFoundException e) {
                    logger.error(e);
                } catch (CvqException e) {
                    logger.error(e);
                }
            }
        }
        return correctedState;
    }

    public String onStageChange(HttpServletRequest request, IStageForm stageForm, String stageName) {
        return null;
    }

}
