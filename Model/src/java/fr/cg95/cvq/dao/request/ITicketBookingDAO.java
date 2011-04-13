package fr.cg95.cvq.dao.request;

import java.util.List;
import java.util.Set;

import fr.cg95.cvq.business.request.ticket.Entertainment;
import fr.cg95.cvq.business.request.ticket.Event;
import fr.cg95.cvq.business.request.ticket.Fare;
import fr.cg95.cvq.business.request.ticket.PlaceCategory;
import fr.cg95.cvq.business.request.ticket.Subscriber;
import fr.cg95.cvq.util.Critere;

public interface ITicketBookingDAO {

    List<Entertainment> searchEntertainment(final Set<Critere> criteria, final String sort, String dir, 
            int recordsReturned, int startIndex);

    List<Event> searchEvent(final Set<Critere> criteria, final String sort, String dir, 
            int recordsReturned, int startIndex);

    Entertainment findEntertainmentByExternalId(String externalId);

    Event findEventByExternalId(String externalId);

    PlaceCategory findPlaceCategoryByExternalId(String externalId);

    Fare findFareByExternalId(String externalId);

    List<Subscriber> searchSubscriber(final Set<Critere> criteria, final String sort, String dir, 
            int recordsReturned, int startIndex);

    Subscriber findSubscriberByNumber(String number);
}
