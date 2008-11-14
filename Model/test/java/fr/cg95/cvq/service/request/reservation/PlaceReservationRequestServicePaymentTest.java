package fr.cg95.cvq.service.request.reservation;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.reservation.PlaceReservationRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.payment.InternalRequestItem;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.business.users.payment.PaymentMode;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.payment.PaymentResultStatus;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.xml.request.reservation.PlaceReservationRequestDocument;

public class PlaceReservationRequestServicePaymentTest extends PlaceReservationRequestServiceTest {

    public void testPaymentCommited() throws CvqException,
        CvqObjectNotFoundException, java.io.FileNotFoundException,
        java.io.IOException {

        SecurityContext.setCurrentSite(localAuthorityName,
                SecurityContext.FRONT_OFFICE_CONTEXT);

        // create a vo card request (to create home folder and associates)
        CreationBean cb = gimmeAnHomeFolder();

        String proposedLogin = cb.getLogin();

        SecurityContext.setCurrentEcitizen(proposedLogin);

        // get the home folder id
        HomeFolder homeFolder = iHomeFolderService.getById(cb.getHomeFolderId());
        Assert.assertNotNull(homeFolder);
        Long homeFolderId = homeFolder.getId();
        Assert.assertNotNull(homeFolderId);

        // fill and create the request
        // ////////////////////////////

        PlaceReservationRequest request = fillMeARequest();
        request.setRequesterId(iHomeFolderService.getHomeFolderResponsible(homeFolderId).getId());

        PlaceReservationRequestDocument requestDoc =
            (PlaceReservationRequestDocument) request.modelToXml();
        Long requestId = iPlaceReservationRequestService.create(requestDoc.getDomNode());
        PlaceReservationRequest requestFromDb = 
            (PlaceReservationRequest) iPlaceReservationRequestService.getById(requestId);
        
        Assert.assertEquals(requestId, requestFromDb.getId());
        Adult requester = iAdultService.getById(requestFromDb.getRequesterId());
        Assert.assertNotNull(requester);

        // simulate a payment on this request
        /////////////////////////////////////
        
        InternalRequestItem iri = new InternalRequestItem("PLACE_RESERVATION",
                Double.valueOf("1234"), requestFromDb,
                "Régie de la ville de Dummy", 1, Double.valueOf("1234"));
        Payment payment = iPaymentService.createPaymentContainer(iri, PaymentMode.INTERNET);
        iPaymentService.initPayment(payment);
        
        URL url = iPaymentService.initPayment(payment);
        Assert.assertNotNull(url);
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
        Assert.assertEquals(returnStatus, PaymentResultStatus.OK);

        requestFromDb = 
            (PlaceReservationRequest) iPlaceReservationRequestService.getById(requestId);
        Assert.assertEquals(requestFromDb.getState(), RequestState.VALIDATED);
        Assert.assertNotNull(requestFromDb.getPaymentReference());

        List<Payment> bills = iPaymentService.getByHomeFolder(homeFolder);
        Assert.assertNotNull(bills);
        Assert.assertEquals(bills.size(), 1);

        byte[] generatedCertificate = 
            iRequestService.getCertificate(requestId, RequestState.VALIDATED);

        if (generatedCertificate == null)
            fail("No certificate found");

        File file = File.createTempFile("tmp" + requestId, ".pdf");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(generatedCertificate);

        commitTransaction();
    }
}
