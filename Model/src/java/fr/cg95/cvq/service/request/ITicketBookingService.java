package fr.cg95.cvq.service.request;

import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.cg95.cvq.business.request.ticket.Entertainment;
import fr.cg95.cvq.business.request.ticket.Event;
import fr.cg95.cvq.business.request.ticket.Fare;
import fr.cg95.cvq.business.request.ticket.FareType;
import fr.cg95.cvq.business.request.ticket.PlaceCategory;
import fr.cg95.cvq.business.request.ticket.Subscriber;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.exception.CvqTicketBookingException;
import fr.cg95.cvq.util.Critere;

public interface ITicketBookingService {

    Long createEntertainment(Entertainment entertainment) throws CvqException;

    void updateEntertainment(Entertainment entertainment);

    void deleteEntertainment(Long id) throws CvqObjectNotFoundException;

    Entertainment getEntertainmentById(final Long id) throws CvqObjectNotFoundException;

    List<Entertainment> getEntertainments(Set<Critere> criteriaSet, final String sort,
            final String dir, final int recordsReturned, final int startIndex) throws CvqException;

    List<Entertainment> getAllEntertainments() throws CvqException;

    Event getEventById(final Long id) throws CvqObjectNotFoundException;

    List<Event> getEvents(Set<Critere> criteriaSet, final String sort,
            final String dir, final int recordsReturned, final int startIndex) throws CvqException;

    void updateEvent(Event event);

    void deleteEvent(Long id) throws CvqObjectNotFoundException;

    PlaceCategory getPlaceCategoryById(final Long id) throws CvqObjectNotFoundException;

    void deletePlaceCategory(Long id, Long eventId) throws CvqObjectNotFoundException;

    Fare getFareById(final Long id) throws CvqObjectNotFoundException;

    void updateFare(Fare fare) throws CvqObjectNotFoundException;

    void deleteFare(Long id, Long eventId) throws CvqObjectNotFoundException;

    Subscriber getSubscriberById(final Long id) throws CvqObjectNotFoundException;

    List<Subscriber> getSubscribers(Set<Critere> criteriaSet, final String sort,
            final String dir, final int recordsReturned, final int startIndex) throws CvqException;

    void updateSubscriber(Subscriber subscriber);

    void deleteSubscriber(Long id) throws CvqObjectNotFoundException;

    Map<String,Integer> importEntertainments(byte[] entertainments) throws CvqTicketBookingException;

    Map<String,Integer> importSubscribers(byte[] subscribers) throws CvqTicketBookingException;

    boolean isSubscriber(String number, String firstName, String lastName) throws CvqTicketBookingException;

    Integer getSubscriberLimit(String subscriberNumber, FareType fareType);

    int getMaxCartSize();
}
