package fr.cg95.cvq.service.request.reservation.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Node;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.reservation.PlaceReservationRequest;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.PlaceReservationData;
import fr.cg95.cvq.business.users.TicketTypeSelection;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.authority.IPlaceReservationService;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.reservation.IPlaceReservationRequestService;
import fr.cg95.cvq.xml.request.reservation.PlaceReservationRequestDocument;

/**
 * Implementation of the place reservation request service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class PlaceReservationRequestService 
    extends RequestService implements IPlaceReservationRequestService {

    static Logger logger = Logger.getLogger(PlaceReservationRequestService.class);

    private IPlaceReservationService placeReservationService;
    
    public Long create(Request request, Long requesterId) 
        throws CvqException, CvqObjectNotFoundException {

        PlaceReservationRequest prr = (PlaceReservationRequest) request;
        
        // if valid subscriber, check place reservation validity
        if (prr.getSubscriberNumber() != null && !prr.getSubscriberNumber().equals("")) {
            if (!isValidSubscriberNumber(prr.getSubscriberNumber()))
                throw new CvqObjectNotFoundException("Unknown subscriber number");
            if (checkPlaceReservationData(prr.getPlaceReservation(), 
                    prr.getSubscriberNumber()) != null)
                throw new CvqModelException("Error in choosen number of places "
                        + " for subscriber " + prr.getSubscriberNumber());
        }
        
        initializeCommonAttributes(prr, requesterId);

        return create(prr);
    }

    public Long create(Node prrNode) throws CvqException {

        PlaceReservationRequestDocument prrDocument = null;
        try {
            prrDocument = PlaceReservationRequestDocument.Factory.parse(prrNode);
        } catch (XmlException xe) {
            logger.error("create() Error while parsing received data");
            xe.printStackTrace();
        }
        
        PlaceReservationRequest prr = PlaceReservationRequest.xmlToModel(prrDocument);

        // if valid subscriber, check place reservation validity
        if (prr.getSubscriberNumber() != null && !prr.getSubscriberNumber().equals("")) {
            if (!isValidSubscriberNumber(prr.getSubscriberNumber()))
                throw new CvqObjectNotFoundException("Unknown subscriber number");
            if (checkPlaceReservationData(prr.getPlaceReservation(), 
                    prr.getSubscriberNumber()) != null)
                throw new CvqModelException("Error in choosen number of places "
                        + " for subscriber " + prr.getSubscriberNumber());
        }
        
        HomeFolder homeFolder = super.createOrSynchronizeHomeFolder(prr);
        
        initializeCommonAttributes(prr);

        Long requestId = super.create(prr);
        if (homeFolder != null) {
            homeFolder.setBoundToRequest(Boolean.valueOf(true));
            homeFolder.setOriginRequestId(requestId);
        }
    
        return requestId;
    }
    
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

    public boolean isValidSubscriberNumber(final String subscriberNumber) throws CvqException {

        String subscriberLine = getSubscriberLine(subscriberNumber);
        if (subscriberLine != null)
            return true;
        else
            return false;
    }

    private String getSubscriberLine(final String subscriberNumber) throws CvqException {

        if (subscriberNumber == null || subscriberNumber.equals(""))
            return null;
        
        String filename = getExternalReferentialFilename();
        File file = localAuthorityRegistry.getCurrentLocalAuthorityResource(
                ILocalAuthorityRegistry.EXTERNAL_REFERENTIAL_RESOURCE_TYPE, 
                filename, false);
        if (!file.exists()) {
            return null;
        }

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            while (true) {
                line = reader.readLine();
                if (line == null) {
                    logger.debug("getSubscriberLine() reached the end of subscribers file");
                    return null;
                }
                String currentSubscriberNumber = line.trim().substring(0, line.indexOf(','));
                if (currentSubscriberNumber.equals(subscriberNumber.trim())) {
                    logger.debug("getSubscriberLine() found a matching subscriber number");
                    return line;
                }
            }
        } catch (FileNotFoundException e) {
            // impossible since checked just before
        } catch (IOException ioe) {
            logger.error("getSubscriberLine() error while reading contents of subscribers file");
            return null;
        }

        logger.debug("getSubscriberLine() did not find subscriber number : " + subscriberNumber);
        return null;
    }
    
    public Set<String> checkPlaceReservationData(final Set placeReservationDataSet, 
            final String subscriberNumber) 
        throws CvqException {
    
        Map<String, Integer> placesPerPrice = getAuthorizedNumberOfPlaces(subscriberNumber);
        Set<String> errorReservationSet = new HashSet<String>();
        
        Iterator placeReservationDataIt = placeReservationDataSet.iterator();
        while (placeReservationDataIt.hasNext()) {
            PlaceReservationData placeReservationData =
                (PlaceReservationData) placeReservationDataIt.next();
            logger.debug("checkPlaceReservationData() looking at "
                    + placeReservationData.getName());
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
            Set tickets = placeReservationData.getTickets();
            if (tickets == null || tickets.size() == 0) {
                logger.debug("checkPlaceReservationData() no tickets found for current entry");
                continue;
            }
            Iterator ticketsIt = tickets.iterator();
            while (ticketsIt.hasNext()) {
                TicketTypeSelection ticketTypeSelection = (TicketTypeSelection) ticketsIt.next();
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
        
        if (errorReservationSet.size() > 0)
            return errorReservationSet;
        else
            return null;
    }

    public void onPaymentValidated(Request request, String paymentReference)
        throws CvqException {
        
        logger.debug("onPaymentValidated() got payment ack for request " + request.getId());
        logger.debug("onPaymentValidated() with reference : " + paymentReference);
        
        PlaceReservationRequest placeReservationRequest = 
            (PlaceReservationRequest) request;
        placeReservationRequest.setPaymentReference(paymentReference);
        if (placeReservationRequest.getState().equals(RequestState.PENDING))
            placeReservationRequest.setState(RequestState.COMPLETE);
        validate(request);
    }
    
    public void onPaymentCancelled(Request request)
        throws CvqException {
        
        logger.debug("onPaymentCancelled() got payment refusal for request " + request.getId());
        if (!(request instanceof PlaceReservationRequest)) {
            logger.warn("onPaymentCancelled() received an un-managed request type");
            return;
        }

        cancelReservations((PlaceReservationRequest) request);
        cancel(request);
    }
    
    public void onPaymentRefused(Request request)
        throws CvqException {

        logger.debug("onPaymentRefused() got payment refusal for request " + request.getId());
        if (!(request instanceof PlaceReservationRequest)) {
            logger.warn("onPaymentRefused() received an un-managed request type");
            return;
        }
        
        cancelReservations((PlaceReservationRequest) request);
        reject(request, "PAYMENT_REFUSED");
    }

    private void cancelReservations(PlaceReservationRequest placeReservationRequest) 
        throws CvqException {
        
        Set reservationSet = placeReservationRequest.getPlaceReservation();
        if (reservationSet == null || reservationSet.size() == 0) {
            logger.warn("onPaymentRefused() no reservation to cancel");
            return;
        }

        Iterator reservationSetIt = reservationSet.iterator();
        while (reservationSetIt.hasNext()) {
            PlaceReservationData placeReservationData =
                (PlaceReservationData) reservationSetIt.next();
            String placeReservationKey = placeReservationData.getName();
            Set tickets = placeReservationData.getTickets();
            if (tickets == null || tickets.size() == 0) {
                logger.debug("cancelReservations() no tickets associated to " + placeReservationKey);
                continue;
            }
            int numberOfTickets = 0;
            Iterator ticketsIt = tickets.iterator();
            while (ticketsIt.hasNext()) {
                numberOfTickets += ((TicketTypeSelection) ticketsIt.next()).getNumber().intValue();
            }
            placeReservationService.updateRemainingPlacesForReservation(getLabel(), 
                    placeReservationKey, numberOfTickets);
        }
    }
    
    public boolean accept(Request request) {
        return (request instanceof PlaceReservationRequest);
    }

    public Request getSkeletonRequest() throws CvqException {
        return new PlaceReservationRequest();
    }

    public void setPlaceReservationService(IPlaceReservationService placeReservationService) {
        this.placeReservationService = placeReservationService;
    }
}