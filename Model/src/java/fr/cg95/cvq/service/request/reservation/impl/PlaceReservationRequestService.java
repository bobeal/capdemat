package fr.cg95.cvq.service.request.reservation.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.request.PlaceReservationData;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.TicketTypeSelection;
import fr.cg95.cvq.business.request.reservation.PlaceReservationRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.request.IPlaceReservationService;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.reservation.IPlaceReservationRequestService;

/**
 * Implementation of the place reservation request service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class PlaceReservationRequestService 
    extends RequestService implements IPlaceReservationRequestService {

    static Logger logger = Logger.getLogger(PlaceReservationRequestService.class);

    private IPlaceReservationService placeReservationService;
    
    
    @Override
    public void init() {
        super.init();

        conditions.put("isSubscriber", new EqualityChecker("true"));
    }

    @Override
    public void onRequestCreated(Request request)
        throws CvqException, CvqObjectNotFoundException {

        PlaceReservationRequest prr = (PlaceReservationRequest) request;
        performSpecificChecks(prr);
    }

    private void performSpecificChecks(PlaceReservationRequest prr) 
        throws CvqException {
        
        // if valid subscriber, check place reservation validity
        if (prr.getSubscriberNumber() != null && !prr.getSubscriberNumber().equals("")) {
            if (!isValidSubscriberNumber(prr.getSubscriberNumber()))
                throw new CvqObjectNotFoundException("Unknown subscriber number");
            if (checkPlaceReservationData(prr.getPlaceReservation(), 
                    prr.getSubscriberNumber()) != null)
                throw new CvqModelException("Error in choosen number of places "
                        + " for subscriber " + prr.getSubscriberNumber());
        }
    }
    
    @Override
    public Map<String, Integer> getAuthorizedNumberOfPlaces(final String subscriberNumber) 
        throws CvqException, CvqObjectNotFoundException {

        if (subscriberNumber == null || subscriberNumber.equals(""))
            throw new CvqException("No subscriber number provided");
        
        String subscriberLine = getSubscriberLine(subscriberNumber);
        if (subscriberLine == null) {
            throw new CvqObjectNotFoundException();
        } else {
            Map<String, Integer> resultMap = new HashMap<String, Integer>();
            String[] splittedLine = subscriberLine.split(",");
            resultMap.put(IPlaceReservationService.FULL_PRICE_SUBSCRIBER, Integer.valueOf(splittedLine[1]));
            resultMap.put(IPlaceReservationService.REDUCED_PRICE_SUBSCRIBER, Integer.valueOf(splittedLine[2]));
            
            return resultMap;
        }
    }

    @Override
    public boolean isValidSubscriberNumber(final String subscriberNumber) throws CvqException {

        String subscriberLine = getSubscriberLine(subscriberNumber);
        if (subscriberLine != null)
            return true;
        else
            return false;
    }

    private String getSubscriberLine(final String subscriberNumber) {

//        if (subscriberNumber == null || subscriberNumber.equals(""))
//            return null;
//        
//        String filename = getExternalReferentialFilename();
//        File file = localAuthorityRegistry.getLocalAuthorityResourceFile(
//            Type.EXTERNAL_REFERENTIAL, filename, false);
//        if (!file.exists()) {
//            return null;
//        }
//
//        BufferedReader reader;
//        try {
//            reader = new BufferedReader(new FileReader(file));
//            String line = null;
//            while (true) {
//                line = reader.readLine();
//                if (line == null) {
//                    logger.debug("getSubscriberLine() reached the end of subscribers file");
//                    return null;
//                }
//                String currentSubscriberNumber = line.trim().substring(0, line.indexOf(','));
//                if (currentSubscriberNumber.equals(subscriberNumber.trim())) {
//                    logger.debug("getSubscriberLine() found a matching subscriber number");
//                    return line;
//                }
//            }
//        } catch (FileNotFoundException e) {
//            // impossible since checked just before
//        } catch (IOException ioe) {
//            logger.error("getSubscriberLine() error while reading contents of subscribers file");
//            return null;
//        }
//
//        logger.debug("getSubscriberLine() did not find subscriber number : " + subscriberNumber);
        return null;
    }
    
    @Override
    public Set<String> checkPlaceReservationData(final List<PlaceReservationData> placeReservationDatas, 
            final String subscriberNumber) 
        throws CvqException {
    
        if (placeReservationDatas == null) {
            logger.info("checkPlaceReservationData() no data in reservation, returning");
            return null;
        }
        
        Map<String, Integer> placesPerPrice = getAuthorizedNumberOfPlaces(subscriberNumber);
        Set<String> errorReservationSet = new HashSet<String>();
        
        for (PlaceReservationData placeReservationData : placeReservationDatas) {
            logger.debug("checkPlaceReservationData() looking at "+ placeReservationData.getName());
            
            // check if this reservation has subscriber prices defined
            Set<String> subscriberTickets = 
                placeReservationService.getSubscriberTickets(getLabel(), 
                        placeReservationData.getName());
            if (subscriberTickets == null || subscriberTickets.isEmpty()) {
                logger.debug("checkPlaceReservationData() no subscriber price for "
                        + placeReservationData.getName());
                continue;
            }
            // get tickets choosen by user
            Set<TicketTypeSelection> tickets = placeReservationData.getTickets();
            if (tickets == null || tickets.isEmpty()) {
                logger.warn("checkPlaceReservationData() no tickets found for current entry");
                continue;
            }
            for (TicketTypeSelection ticketTypeSelection : tickets) {
                logger.debug("checkPlaceReservationData() looking at " 
                        + ticketTypeSelection.getName());
                if (subscriberTickets.contains(ticketTypeSelection.getName())) {
                    logger.debug("checkPlaceReservationData() got a subscriber ticket "
                            + "with key : " + ticketTypeSelection.getName());
                    if (ticketTypeSelection.getName().equals(IPlaceReservationService.FULL_PRICE_SUBSCRIBER)
                            && ticketTypeSelection.getNumber().longValue() > placesPerPrice.get(IPlaceReservationService.FULL_PRICE_SUBSCRIBER)) {
                        logger.debug("checkPlaceReservationData() too many tickets for "
                                + ticketTypeSelection.getName() + " (expected at most "
                                + placesPerPrice.get(IPlaceReservationService.FULL_PRICE_SUBSCRIBER) + ")");
                        // add to list of error tickets
                        errorReservationSet.add(placeReservationData.getName());
                    } else if (subscriberTickets.contains(ticketTypeSelection.getName())) {
                        logger.debug("checkPlaceReservationData() got a subscriber ticket "
                                + "with key : " + ticketTypeSelection.getName());
                        if (ticketTypeSelection.getName().equals(IPlaceReservationService.REDUCED_PRICE_SUBSCRIBER)
                                && ticketTypeSelection.getNumber().longValue() > placesPerPrice.get(IPlaceReservationService.REDUCED_PRICE_SUBSCRIBER)) {
                            logger.debug("checkPlaceReservationData() too many tickets for "
                                    + ticketTypeSelection.getName() + " (expected at most "
                                    + placesPerPrice.get(IPlaceReservationService.REDUCED_PRICE_SUBSCRIBER) + ")");
                            // add to list of error tickets
                            errorReservationSet.add(placeReservationData.getName());
                        }
                    }
                }
            }
        }
        
        if (!errorReservationSet.isEmpty())
            return errorReservationSet;
        else
            return null;
    }

    @Override
    public boolean onPaymentValidated(Request request, String paymentReference)
        throws CvqException {
        
        logger.debug("onPaymentValidated() got payment ack for request " + request.getId());
        logger.debug("onPaymentValidated() with reference : " + paymentReference);
        
        PlaceReservationRequest placeReservationRequest = 
            (PlaceReservationRequest) request;
        placeReservationRequest.setPaymentReference(paymentReference);
        
        return true;
    }
    
    @Override
    public boolean onPaymentCancelled(Request request)
        throws CvqException {
        
        logger.debug("onPaymentCancelled() got payment refusal for request " + request.getId());

        cancelReservations((PlaceReservationRequest) request);
        
        return true;
    }
    
    @Override
    public boolean onPaymentRefused(Request request)
        throws CvqException {

        logger.debug("onPaymentRefused() got payment refusal for request " + request.getId());
        
        cancelReservations((PlaceReservationRequest) request);
        
        return true;
    }

    private void cancelReservations(PlaceReservationRequest placeReservationRequest) 
        throws CvqException {
        
        List<PlaceReservationData> reservationList = placeReservationRequest.getPlaceReservation();
        if (reservationList == null || reservationList.isEmpty()) {
            logger.warn("onPaymentRefused() no reservation to cancel");
            return;
        }

        for (PlaceReservationData placeReservationData : reservationList) {
            String placeReservationKey = placeReservationData.getName();
            Set<TicketTypeSelection> tickets = placeReservationData.getTickets();
            if (tickets == null || tickets.isEmpty()) {
                logger.warn("cancelReservations() no tickets associated to " + placeReservationKey);
                continue;
            }
            int numberOfTickets = 0;
            for (TicketTypeSelection ticket : tickets) {
                numberOfTickets += ticket.getNumber();
            }
            placeReservationService.updateRemainingPlacesForReservation(getLabel(), 
                    placeReservationKey, numberOfTickets);
        }
    }
    
    @Override
    public boolean accept(Request request) {
        return (request instanceof PlaceReservationRequest);
    }

    @Override
    public Request getSkeletonRequest() throws CvqException {
        return new PlaceReservationRequest();
    }

    public void setPlaceReservationService(IPlaceReservationService placeReservationService) {
        this.placeReservationService = placeReservationService;
    }
}
