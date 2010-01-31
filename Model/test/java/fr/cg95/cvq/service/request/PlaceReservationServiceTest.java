package fr.cg95.cvq.service.request;

import java.util.Date;
import java.util.Set;

import junit.framework.Assert;
import fr.cg95.cvq.business.request.PlaceReservationType;
import fr.cg95.cvq.business.request.PlaceReservationType.TicketSelection;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqPlaceReservationReferentialException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.testtool.ServiceTestCase;

public class PlaceReservationServiceTest extends ServiceTestCase {

    private static final String SERVICE_TEST = "Place Reservation";
    
    public void testAll() throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        Set<PlaceReservationType> placeReservationSet = 
            placeReservationService.getPlaceReservationForRequestType(SERVICE_TEST, false);
        int initialPlaceSize = placeReservationSet.size();

        // add a new entry
        PlaceReservationType placeReservationType = new PlaceReservationType();
        String placeReservationKey = "CypressHill-" + System.currentTimeMillis();
        placeReservationType.setKey(placeReservationKey);
        placeReservationType.addLabel("fr", "Concert de Cypress Hill");
        // quota = 150 / remaining = 150
        placeReservationType.setQuota(Integer.valueOf("150"));
        placeReservationType.setEventDate(new Date());
        TicketSelection ticketSelection = 
            placeReservationType.new TicketSelection("TarifJeune", Float.valueOf("50.5"));
        ticketSelection.addLabel("fr", "Tarif Jeune");
        ticketSelection.addLabel("en", "Youth price");
        placeReservationType.addTicketSelection(ticketSelection);
        placeReservationSet.add(placeReservationType);
        TicketSelection ticketSelection2 = 
            placeReservationType.new TicketSelection("TarifVieux", Float.valueOf("70.5"));
        ticketSelection2.addLabel("fr", "Tarif Vieux");
        ticketSelection2.addLabel("en", "Older price");
        ticketSelection2.setName("TarifVieuxVieux");
        ticketSelection2.setPrice(Float.valueOf("60"));
        placeReservationType.addTicketSelection(ticketSelection2);
        placeReservationSet.add(placeReservationType);
        placeReservationService.setPlaceReservationForRequestType(SERVICE_TEST,
                placeReservationType);

        // check new entry has been added
        placeReservationSet = 
            placeReservationService.getPlaceReservationForRequestType(SERVICE_TEST, false);
        Assert.assertEquals(initialPlaceSize + 1, placeReservationSet.size());

        // retrieve the newly created place reservation entry and do some checks on it
        PlaceReservationType placeReservationTypeTemp =
            placeReservationService.getPlaceReservationForRequestType(SERVICE_TEST, 
                    placeReservationKey, false);
        Assert.assertNotNull(placeReservationTypeTemp);

        // test that reservation general information is correctly stored
        Assert.assertNotNull(placeReservationTypeTemp.getLabelsMap());
        Assert.assertEquals(placeReservationTypeTemp.getLabelsMap().size(), 1);
        String lang = 
            (String) placeReservationTypeTemp.getLabelsMap().keySet().iterator().next();
        Assert.assertEquals(lang, "fr");
        Assert.assertEquals(placeReservationTypeTemp.getLabelsMap().get(lang),
        "Concert de Cypress Hill");

        // test that ticket entries are correctly stored
        Assert.assertNotNull(placeReservationTypeTemp.getTicketsSelection());
        Assert.assertEquals(placeReservationTypeTemp.getTicketsSelection().size(), 2);
        TicketSelection ticketSelectionTemp =
            placeReservationTypeTemp.getTicketSelection("TarifVieuxVieux");
        Assert.assertNotNull(ticketSelectionTemp);
        Assert.assertEquals(ticketSelectionTemp.getPrice().toString(), "60.0");

        // test update of quota information
        int currentRemainingPlaces = placeReservationTypeTemp.getQuota().intValue();
        int newQuota = placeReservationTypeTemp.getQuota().intValue() + 10;
        // quota = 160 / remaining = 160
        placeReservationTypeTemp.setQuota(new Integer(newQuota));
        placeReservationService.setPlaceReservationForRequestType(SERVICE_TEST, 
                placeReservationTypeTemp);

        // ensure entry has been updated and not added
        Assert.assertEquals(placeReservationService.getPlaceReservationForRequestType(SERVICE_TEST, false).size(),
                initialPlaceSize + 1);
        placeReservationTypeTemp = 
            placeReservationService.getPlaceReservationForRequestType(SERVICE_TEST, placeReservationKey, false);
        Assert.assertEquals(placeReservationTypeTemp.getQuota().intValue(), newQuota);
        Assert.assertEquals(placeReservationTypeTemp.getRemainingPlaces().intValue(), 
                currentRemainingPlaces + 10);

        currentRemainingPlaces = placeReservationTypeTemp.getQuota().intValue();
        newQuota = placeReservationTypeTemp.getQuota().intValue() - currentRemainingPlaces - 1;
        placeReservationTypeTemp.setQuota(new Integer(newQuota));
        try {
            placeReservationService.setPlaceReservationForRequestType(SERVICE_TEST, 
                    placeReservationTypeTemp);
            fail("should have throw an exception");
        } catch (CvqPlaceReservationReferentialException cprre) {
            // that was expected
        }


        placeReservationTypeTemp = 
            placeReservationService.getPlaceReservationForRequestType(SERVICE_TEST, placeReservationKey, false);
        currentRemainingPlaces = placeReservationTypeTemp.getQuota().intValue();
        newQuota = placeReservationTypeTemp.getQuota().intValue() - 10;
        // quota = 150 / remaining = 150
        placeReservationTypeTemp.setQuota(new Integer(newQuota));
        placeReservationService.setPlaceReservationForRequestType(SERVICE_TEST,
                placeReservationTypeTemp);
        placeReservationTypeTemp = 
            placeReservationService.getPlaceReservationForRequestType(SERVICE_TEST, placeReservationKey, false);
        Assert.assertEquals(placeReservationTypeTemp.getQuota().intValue(), newQuota);
        Assert.assertEquals(placeReservationTypeTemp.getRemainingPlaces().intValue(), 
                currentRemainingPlaces - 10);

        newQuota = 0;
        // quota = 0 / remaining = 0
        placeReservationTypeTemp.setQuota(new Integer(newQuota));
        placeReservationService.setPlaceReservationForRequestType(SERVICE_TEST, 
                placeReservationTypeTemp);
        placeReservationTypeTemp = 
            placeReservationService.getPlaceReservationForRequestType(SERVICE_TEST, placeReservationKey, false);
        Assert.assertEquals(placeReservationTypeTemp.getQuota().intValue(), 0);
        Assert.assertEquals(placeReservationTypeTemp.getRemainingPlaces().intValue(), 0);

        newQuota = 150;
        // quota = 150 / remaining = 150
        placeReservationTypeTemp.setQuota(new Integer(newQuota));
        placeReservationService.setPlaceReservationForRequestType(SERVICE_TEST, 
                placeReservationTypeTemp);
        placeReservationTypeTemp = 
            placeReservationService.getPlaceReservationForRequestType(SERVICE_TEST, placeReservationKey, false);
        Assert.assertEquals(placeReservationTypeTemp.getQuota().intValue(), 150);
        Assert.assertEquals(placeReservationTypeTemp.getRemainingPlaces().intValue(), 150);

        currentRemainingPlaces = placeReservationTypeTemp.getRemainingPlaces().intValue();  
        currentRemainingPlaces = placeReservationService.updateRemainingPlacesForReservation(SERVICE_TEST, 
                placeReservationKey, - (currentRemainingPlaces - 5));
        Assert.assertEquals(currentRemainingPlaces, 5);
        try {
            placeReservationService.updateRemainingPlacesForReservation(SERVICE_TEST,
                    placeReservationKey, - (currentRemainingPlaces + 1));
            fail("Should have thrown an exception");
        } catch (CvqPlaceReservationReferentialException cprre) {
            // that was expected
        }

        // reload and check nothing has changed
        placeReservationTypeTemp = 
            placeReservationService.getPlaceReservationForRequestType(SERVICE_TEST, placeReservationKey, false);
        Assert.assertEquals(currentRemainingPlaces, 5);

        try {
            placeReservationService.updateRemainingPlacesForReservation(SERVICE_TEST,
                    placeReservationKey, placeReservationTypeTemp.getQuota().intValue());
            fail("Should have thrown an exception");
        } catch (CvqPlaceReservationReferentialException cprre) {
            // that was expected
        }

        placeReservationService.removePlaceReservationForRequestType(SERVICE_TEST, 
                placeReservationKey);
        placeReservationTypeTemp = 
            placeReservationService.getPlaceReservationForRequestType(SERVICE_TEST, placeReservationKey, false);
        Assert.assertNull(placeReservationTypeTemp);
    }
}
