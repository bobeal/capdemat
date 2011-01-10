package fr.cg95.cvq.service.request.reservation.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.CapDematEvent;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.reservation.TbrTicket;
import fr.cg95.cvq.business.request.reservation.TicketBookingRequest;
import fr.cg95.cvq.business.request.ticket.Event;
import fr.cg95.cvq.business.request.ticket.Fare;
import fr.cg95.cvq.business.request.ticket.FareType;
import fr.cg95.cvq.business.request.ticket.PlaceCategory;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.exception.CvqTicketBookingException;
import fr.cg95.cvq.service.request.ITicketBookingService;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.reservation.ITicketBookingRequestService;


public class TicketBookingRequestService extends RequestService implements ITicketBookingRequestService {

    private static Logger logger = Logger.getLogger(TicketBookingRequestService.class);

    private ITicketBookingService ticketBookingService;

    @Override
    public boolean accept(Request request) {
        return request instanceof TicketBookingRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new TicketBookingRequest();
    }

    @Override
    public void init() {
        super.init();
        TicketBookingRequest.conditions.put("isSubscriber", new EqualityChecker("true"));
    }

    @Override
    public void reserve(TicketBookingRequest request, String placeNumber, Long fareId,
            Long placeCategoryId, Long eventId) throws CvqTicketBookingException {
        try {
            int placeNumberAsInt = Integer.valueOf(placeNumber);

            // Test maximum cart size
            if (getCartSize(request) + placeNumberAsInt > ticketBookingService.getMaxCartSize())
                throw new CvqTicketBookingException("tbr.error.maxCartSizeExceeded");

            // Test category remaining place
            PlaceCategory placeCategory = ticketBookingService.getPlaceCategoryById(placeCategoryId);
            int remainingPlaceNumber = placeCategory.getPlaceNumber() - placeCategory.getBookedPlaceNumber();
            if ( remainingPlaceNumber < placeNumberAsInt)
                throw new CvqTicketBookingException("tbr.error.notEnoughRemainingPlace");
            placeCategory.setBookedPlaceNumber(placeCategory.getBookedPlaceNumber() + placeNumberAsInt);

            // Create or update a ticket
            TbrTicket ticket = createTicket(placeNumberAsInt, fareId, placeCategoryId, eventId);

            testSubscriberLimit(request, ticket);

            if (existTicket(request, ticket) == -1) {
                if (request.getTbrTicket() == null)
                    request.setTbrTicket(new ArrayList<TbrTicket>());
                request.getTbrTicket().add(ticket);
            } else {
                TbrTicket currentTicket = request.getTbrTicket().get(existTicket(request, ticket));
                currentTicket.setPlaceNumber(
                        currentTicket.getPlaceNumber().add(ticket.getPlaceNumber()));
                currentTicket.setPrice(currentTicket.getPrice().add(ticket.getPrice()));
            }
            if (request.getTotalPrice() == null)
                request.setTotalPrice(BigDecimal.valueOf(0));
            request.setTotalPrice(request.getTotalPrice().add(ticket.getPrice()));

        } catch (CvqObjectNotFoundException e) {
            throw new CvqTicketBookingException(e.getMessage(), "tbr.error.objectNotFound");
        } catch (NumberFormatException e) {
            throw new CvqTicketBookingException(e.getMessage(), "tbr.error.placeNumberMustBeANumber");
        }
    }

    private void testSubscriberLimit(TicketBookingRequest request, TbrTicket ticket) 
            throws CvqTicketBookingException {
        FareType fareType = FareType.forLabel(ticket.getFareType());
        Integer limit = ticketBookingService.getSubscriberLimit(request.getSubscriberNumber(), fareType);
        if (fareType == null || limit == null)
            return;

        int placeNumber = 0;
        if (request.getTbrTicket() != null)
            for (TbrTicket t : request.getTbrTicket())
                if (fareType.getLabel().equals(t.getFareType()))
                    placeNumber += t.getPlaceNumber().intValue();

        if (placeNumber + ticket.getPlaceNumber().intValue() > limit)
            throw new CvqTicketBookingException("tbr.error.subscriberLimitOutOfRange", 
                    new String[]{fareType.getLabel(), limit.toString()});
    }

    @Override
    public void free(TicketBookingRequest request, int ticketIndex) throws CvqObjectNotFoundException {
        TbrTicket ticket = request.getTbrTicket().remove(ticketIndex);
        PlaceCategory placeCategory = ticketBookingService.getPlaceCategoryById(ticket.getPlaceCategoryId());
        placeCategory.setBookedPlaceNumber(placeCategory.getBookedPlaceNumber() - ticket.getPlaceNumber().intValue());
        request.setTotalPrice(request.getTotalPrice().add(ticket.getPrice().negate()));
    }

    @Override
    public void switchSubscriberMode(TicketBookingRequest request, boolean isSubscriber, String number, 
            String firstName, String lastName) throws CvqTicketBookingException, CvqObjectNotFoundException {
        if (isSubscriber)
            if (!ticketBookingService.isSubscriber(number, firstName, lastName))
                throw new CvqTicketBookingException("tbr.error.badSubscriberInformations");
        request.setIsSubscriber(isSubscriber);
        request.setSubscriberNumber(number);
        request.setSubscriberFirstName(firstName);
        request.setSubscriberLastName(lastName);
        if (request.getTbrTicket() != null) {
            PlaceCategory placeCategory;
            for (TbrTicket ticket : request.getTbrTicket()) {
                placeCategory = ticketBookingService.getPlaceCategoryById(ticket.getPlaceCategoryId());
                placeCategory.setBookedPlaceNumber(placeCategory.getBookedPlaceNumber() - ticket.getPlaceNumber().intValue());
            }
            request.getTbrTicket().clear();
        }
        request.setTotalPrice(null);

    }

    private TbrTicket createTicket(int placeNumber, Long fareId, Long placeCategoryId, Long eventId) 
            throws CvqObjectNotFoundException {
        TbrTicket ticket = new TbrTicket();
        Event event = ticketBookingService.getEventById(eventId);
        ticket.setEventName(event.getEntertainment().getName());
        ticket.setEventPlace(event.getPlace());
        ticket.setEventDate(event.getDate());
        PlaceCategory placeCategory = ticketBookingService.getPlaceCategoryById(placeCategoryId);
        ticket.setPlaceCategory(placeCategory.getName());
        ticket.setPlaceCategoryId(placeCategoryId);
        Fare fare = ticketBookingService.getFareById(fareId);
        ticket.setPlaceNumber(BigInteger.valueOf(placeNumber));
        ticket.setFareType(fare.getName());
        ticket.setPrice(BigDecimal.valueOf(placeNumber).multiply(BigDecimal.valueOf(fare.getPrice())));
        return ticket;
    }

    // return index of ticket if it already exist 
    private int existTicket(TicketBookingRequest request, TbrTicket ticket) {
        if (request.getTbrTicket() == null)
            return -1;
        for (TbrTicket t : request.getTbrTicket()) {
            if (t.getEventDate().equals(ticket.getEventDate())
                    && t.getEventName().equals(ticket.getEventName())
                    && t.getEventPlace().equals(ticket.getEventPlace())
                    && t.getPlaceCategory().equals(ticket.getPlaceCategory())
                    && t.getFareType().equals(ticket.getFareType()))
                return request.getTbrTicket().indexOf(t);
        }
        return -1;
    }

    private int getCartSize(TicketBookingRequest request) {
        int cartSize = 0;
        if (request.getTbrTicket() != null)
            for (TbrTicket t : request.getTbrTicket())
                cartSize += t.getPlaceNumber().intValue();
        return cartSize;
    }

    /* TODO: Very dirty implementation
     * placeCategoriesAndBookedPlaces = "id1,bookedPlaceNumber1,id2,bookedPlaceNumber2 ..."
     *  - refactor callBack policy
     *  - migrate after request creation full state less implementation
     */
    @Override
    public void freeAllBookedPlaces(String placeCategoriesAndBookedPlaces) throws CvqObjectNotFoundException {
            Map<Long,Integer> toFreePlaces = new HashMap<Long, Integer>();
            String[] array = placeCategoriesAndBookedPlaces.split(",");
            for(int i = 0; i < array.length; i=i+2)
                toFreePlaces.put(Long.valueOf(array[i]), Integer.valueOf(array[i+1]));

            PlaceCategory placeCategory;
            for (Entry<Long, Integer> toFreePlace : toFreePlaces.entrySet()) {
                placeCategory = ticketBookingService.getPlaceCategoryById(toFreePlace.getKey());
                placeCategory.setBookedPlaceNumber(placeCategory.getBookedPlaceNumber() - toFreePlace.getValue());
            }
    }

    private void freeAllBookedPlaces(TicketBookingRequest request) throws CvqObjectNotFoundException  {
        if (request.getTbrTicket() != null) {
            PlaceCategory placeCategory;
            for (TbrTicket ticket : request.getTbrTicket()) {
                placeCategory = ticketBookingService.getPlaceCategoryById(ticket.getPlaceCategoryId());
                placeCategory.setBookedPlaceNumber(placeCategory.getBookedPlaceNumber() - ticket.getPlaceNumber().intValue());
            }
        }
    }

    @Override
    public boolean onPaymentValidated(Request request, String paymentReference)
        throws CvqException {
        ((TicketBookingRequest)request).setPaymentReference(paymentReference);
        return true;
    }

    @Override
    public boolean onPaymentRefused(Request request)
        throws CvqException {
        try {
            freeAllBookedPlaces((TicketBookingRequest)request);
        } catch (CvqObjectNotFoundException e) {
            logger.warn(e.getMessage());
        }
            return true;
    }

    @Override
    public boolean onPaymentCancelled(Request request)
        throws CvqException {
        try {
            freeAllBookedPlaces((TicketBookingRequest)request);
        } catch (CvqObjectNotFoundException e) {
            logger.warn(e.getMessage());
        }
        return true;
    }

    @Override
    public void onApplicationEvent(CapDematEvent e) {}

    public void setTicketBookingService(ITicketBookingService ticketBookingService) {
        this.ticketBookingService = ticketBookingService;
    }

}
