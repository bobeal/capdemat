package fr.cg95.cvq.service.request.reservation;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.reservation.PlaceReservationRequest;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.payment.InternalRequestItem;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.business.users.payment.PaymentMode;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.payment.PaymentResultStatus;
import fr.cg95.cvq.security.SecurityContext;

public class PlaceReservationRequestServicePaymentTest extends PlaceReservationRequestServiceTest {

    public void testPaymentCommited() throws CvqException,
        CvqObjectNotFoundException, java.io.FileNotFoundException,
        java.io.IOException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        // create a vo card request (to create home folder and associates)
        CreationBean cb = gimmeAnHomeFolder();
        String proposedLogin = cb.getLogin();
        SecurityContext.setCurrentEcitizen(proposedLogin);

        // get the home folder id
        HomeFolder homeFolder = iHomeFolderService.getById(cb.getHomeFolderId());

        // fill and create the request
        // ////////////////////////////

        PlaceReservationRequest request = fillMeARequest();
        request.setRequesterId(iHomeFolderService.getHomeFolderResponsible(homeFolder.getId()).getId());

        Long requestId = iPlaceReservationRequestService.create(request);
        PlaceReservationRequest requestFromDb = 
            (PlaceReservationRequest) iPlaceReservationRequestService.getById(requestId);
        
        // simulate a payment on this request
        /////////////////////////////////////
        
        InternalRequestItem iri = new InternalRequestItem("PLACE_RESERVATION",
                Double.valueOf("1234"), requestFromDb,
                "Régie de la ville de Dummy", 1, Double.valueOf("1234"));
        Payment payment = iPaymentService.createPaymentContainer(iri, PaymentMode.INTERNET);
        iPaymentService.initPayment(payment);
        
        URL url = iPaymentService.initPayment(payment);
        Assert.assertNotNull(url);
        
        // prepare the payment's commit
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        String urlAsString = url.toString();
        logger.debug("URL : " + urlAsString);
        int referenceIndex = urlAsString.indexOf("cvqReference=");
        String reference = null;
        if (urlAsString.indexOf("&", referenceIndex) != -1)
            reference = urlAsString.substring(referenceIndex + "cvqReference=".length(), 
                    urlAsString.indexOf("&", referenceIndex));
        else
            reference = urlAsString.substring(referenceIndex + "cvqReference=".length());

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("cvqReference", reference);
        parameters.put("status", "OK");
        parameters.put("capDematFake", "true");
        PaymentResultStatus returnStatus = iPaymentService.commitPayment(parameters);
        assertEquals(returnStatus, PaymentResultStatus.OK);

        // check that request has been validated and payment reference is correctly set
        requestFromDb = 
            (PlaceReservationRequest) iPlaceReservationRequestService.getById(requestId);
        assertEquals(requestFromDb.getState(), RequestState.VALIDATED);
        assertNotNull(requestFromDb.getPaymentReference());

        List<Payment> bills = iPaymentService.getByHomeFolder(homeFolder);
        assertNotNull(bills);
        assertEquals(bills.size(), 1);

        iPlaceReservationRequestService.delete(requestId);
        
        commitTransaction();
    }
}
