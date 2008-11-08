package fr.cg95.cvq.service.request.reservation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;
import fr.cg95.cvq.business.authority.PlaceReservationType;
import fr.cg95.cvq.business.request.reservation.PlaceReservationRequest;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.PlaceReservationData;
import fr.cg95.cvq.business.users.TicketTypeSelection;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.IPlaceReservationService;
import fr.cg95.cvq.xml.request.reservation.PlaceReservationRequestDocument;

public class PlaceReservationRequestServiceSubscriberTest 
    extends PlaceReservationRequestServiceTest {

    public void testSubscribersMechanisms() throws CvqException, CvqObjectNotFoundException,
            java.io.FileNotFoundException, java.io.IOException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

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
        request.setRequesterId(homeFolder.getHomeFolderResponsible().getId());

        try {
            iPlaceReservationRequestService.getAuthorizedNumberOfPlaces("123");
            fail("should have thrown an exception");
        } catch (CvqObjectNotFoundException confe) {
            // that was expected
        }

        Map<String, Integer> authNbOfPlaces = 
            iPlaceReservationRequestService.getAuthorizedNumberOfPlaces("SubscriberNumber");
        Assert.assertEquals(authNbOfPlaces.size(), 2);
        Assert.assertEquals(authNbOfPlaces.get(IPlaceReservationService.FULL_PRICE_SUBSCRIBER), 
                Integer.valueOf(2));
        Assert.assertEquals(authNbOfPlaces.get(IPlaceReservationService.REDUCED_PRICE_SUBSCRIBER), 
                Integer.valueOf(1));
        request.setSubscriberNumber("SubscriberNumber");
        
        PlaceReservationType placeReservationType = 
            placeReservationService.getPlaceReservationForRequestType("Place Reservation", "Vac", true);
        Assert.assertEquals(placeReservationType.getTicketsSelection().size(), 2);
        
        PlaceReservationData placeReservationData = new PlaceReservationData();
        placeReservationData.setName(placeReservationType.getKey());
        List<PlaceReservationData> placeReservationDatas = new ArrayList<PlaceReservationData>();
        placeReservationDatas.add(placeReservationData);
        request.setPlaceReservation(placeReservationDatas);
        
        TicketTypeSelection ticketTypeSelection = new TicketTypeSelection();
        Set<TicketTypeSelection> ticketTypeSelectionSet = new HashSet<TicketTypeSelection>();
        ticketTypeSelectionSet.add(ticketTypeSelection);
        placeReservationData.setTickets(ticketTypeSelectionSet);
        
        Collection availableTickets = placeReservationType.getTicketsSelection();
        Iterator ticketsIt = availableTickets.iterator();
        while (ticketsIt.hasNext()) {
            PlaceReservationType.TicketSelection ticketSelection =
                (PlaceReservationType.TicketSelection) ticketsIt.next();
            if (ticketSelection.isSubscriberPrice()) {
                ticketTypeSelection.setName(ticketSelection.getName());
                
                // do some tests with place reservation checking ...
                Set errorTicketsSet = null;
                // ... this one should succeed
                ticketTypeSelection.setNumber(authNbOfPlaces.get(ticketSelection.getName()).longValue());
                errorTicketsSet = 
                    iPlaceReservationRequestService.checkPlaceReservationData(placeReservationDatas, "SubscriberNumber");
                Assert.assertNull(errorTicketsSet);
                // ... and this one should fail
                ticketTypeSelection.setNumber(authNbOfPlaces.get(ticketSelection.getName()).longValue() + 1);
                errorTicketsSet = 
                    iPlaceReservationRequestService.checkPlaceReservationData(placeReservationDatas, "SubscriberNumber");
                Assert.assertEquals(errorTicketsSet.size(), 1);
                // let's go back to a correct one before creation request
                ticketTypeSelection.setNumber(authNbOfPlaces.get(ticketSelection.getName()).longValue());
            }
        }
        
        PlaceReservationRequestDocument requestDoc =
            (PlaceReservationRequestDocument) request.modelToXml();
        Long requestId = iPlaceReservationRequestService.create(requestDoc.getDomNode());
        PlaceReservationRequest requestFromDb = 
            (PlaceReservationRequest) iPlaceReservationRequestService.getById(requestId);
        completeValidateAndDelete(requestFromDb);

        commitTransaction();
    }
}
