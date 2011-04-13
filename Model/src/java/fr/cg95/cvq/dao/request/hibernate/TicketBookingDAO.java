package fr.cg95.cvq.dao.request.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.type.Type;

import fr.cg95.cvq.business.request.ticket.Entertainment;
import fr.cg95.cvq.business.request.ticket.Event;
import fr.cg95.cvq.business.request.ticket.Fare;
import fr.cg95.cvq.business.request.ticket.PlaceCategory;
import fr.cg95.cvq.business.request.ticket.Subscriber;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.request.ITicketBookingDAO;
import fr.cg95.cvq.util.Critere;

/**
 * As it isn't related to one particular type, doesn't extend JpaTemplate.
 */
public class TicketBookingDAO implements ITicketBookingDAO {

    public List<Entertainment> searchEntertainment(final Set<Critere> criteria, String sort, String dir, 
            int recordsReturned, int startIndex) {

        StringBuffer sb = new StringBuffer();
        sb.append("from Entertainment as entertainment").append(" where 1 = 1 ");

        List<Object> parametersValues = new ArrayList<Object>();
        List<Type> parametersTypes = new ArrayList<Type>();

        // go through all the criteria and create the query
        for (Critere searchCrit : criteria) {
            if (searchCrit.getAttribut().equals(Entertainment.SEARCH_BY_NAME)) {
                sb.append(" and entertainment.name " + searchCrit.getComparatif() + " ?");
                parametersValues.add(searchCrit.getStringValue());
                parametersTypes.add(Hibernate.STRING);
            } else if (searchCrit.getAttribut().equals(Entertainment.SEARCH_BY_CATEGORY)) {
                sb.append(" and entertainment.category " + searchCrit.getComparatif() + " ?");
                parametersValues.add(searchCrit.getStringValue());
                parametersTypes.add(Hibernate.STRING);
            }
        }

        if (dir != null && dir.equals("desc"))
            sb.append(" desc");

        if (sort != null) {
            if (sort.equals(Entertainment.SEARCH_BY_NAME))
                sb.append(" order by entertainment.name");
            else if (sort.equals(Entertainment.SEARCH_BY_CATEGORY))
                sb.append(" order by entertainment.category");
            else
                sb.append(" order by entertainmentid");
        } else {
            sb.append(" order by entertainment.id");
        }

        Query query = HibernateUtil.getSession().createQuery(sb.toString());
        query.setParameters(parametersValues.toArray(), parametersTypes.toArray(new Type[0]));

        if (recordsReturned > 0)
            query.setMaxResults(recordsReturned);
        query.setFirstResult(startIndex);

        return query.list(); 
    }

    @Override
    public List<Event> searchEvent(Set<Critere> criteria, String sort, String dir,
            int recordsReturned, int startIndex) {

        StringBuffer sb = new StringBuffer();
        sb.append("from Event as event").append(" where 1 = 1 ");

        List<Object> parametersValues = new ArrayList<Object>();
        List<Type> parametersTypes = new ArrayList<Type>();

        for (Critere searchCrit : criteria) {
            if (searchCrit.getAttribut().equals(Entertainment.SEARCH_BY_CATEGORY)) {
                sb.append(" and event.entertainment.category " + searchCrit.getComparatif() + " ?");
                parametersValues.add(searchCrit.getStringValue());
                parametersTypes.add(Hibernate.STRING);
            } else if (searchCrit.getAttribut().equals(Event.SEARCH_BY_BOOKING_START)) {
                sb.append(" and event.bookingStart " + searchCrit.getComparatif() + " ?");
                parametersValues.add(searchCrit.getDateValue());
                parametersTypes.add(Hibernate.TIMESTAMP);
            } else if (searchCrit.getAttribut().equals(Event.SEARCH_BY_BOOKING_END)) {
                sb.append(" and event.bookingEnd " + searchCrit.getComparatif() + " ?");
                parametersValues.add(searchCrit.getDateValue());
                parametersTypes.add(Hibernate.TIMESTAMP);
            }
        }

        if (dir != null && dir.equals("desc"))
            sb.append(" desc");

        if (sort != null) {
            if (sort.equals(Event.SEARCH_BY_DATE))
                sb.append(" order by event.date");
            else if (sort.equals(Entertainment.SEARCH_BY_NAME))
                sb.append(" order by event.entertainment.name");
            else
                sb.append(" order by event.date");
        } else {
            sb.append(" order by event.date");
        }

        Query query = HibernateUtil.getSession().createQuery(sb.toString());
        query.setParameters(parametersValues.toArray(), parametersTypes.toArray(new Type[0]));

        if (recordsReturned > 0)
            query.setMaxResults(recordsReturned);
        query.setFirstResult(startIndex);

        return query.list(); 
    }

    @Override
    public Entertainment findEntertainmentByExternalId(String externalId) {
        Query query = HibernateUtil.getSession()
        .createQuery("from Entertainment entertainment where entertainment.externalId = :externalId ")
        .setString("externalId", externalId);
        return (Entertainment) query.uniqueResult();
    }

    @Override
    public Event findEventByExternalId(String externalId) {
        Query query = HibernateUtil.getSession()
        .createQuery("from Event event where event.externalId = :externalId ")
        .setString("externalId", externalId);
        return (Event) query.uniqueResult();
    }

    @Override
    public PlaceCategory findPlaceCategoryByExternalId(String externalId) {
        Query query = HibernateUtil.getSession()
        .createQuery("from PlaceCategory placeCategory where placeCategory.externalId = :externalId ")
        .setString("externalId", externalId);
        return (PlaceCategory) query.uniqueResult();
    }

    @Override
    public Fare findFareByExternalId(String externalId) {
        Query query = HibernateUtil.getSession()
        .createQuery("from Fare fare where fare.externalId = :externalId ")
        .setString("externalId", externalId);
        return (Fare) query.uniqueResult();
    }

    @Override
    public List<Subscriber> searchSubscriber(Set<Critere> criteria, String sort, String dir,
            int recordsReturned, int startIndex) {

        StringBuffer sb = new StringBuffer();
        sb.append("from Subscriber as s").append(" where 1 = 1 ");

        List<Object> parametersValues = new ArrayList<Object>();
        List<Type> parametersTypes = new ArrayList<Type>();

        if (criteria != null)
            for (Critere searchCrit : criteria) {
                if (searchCrit.getAttribut().equals(Subscriber.SEARCH_BY_LAST_NAME)) {
                    sb.append(" and s.lastName " + searchCrit.getComparatif() + " ?");
                    parametersValues.add(searchCrit.getStringValue());
                    parametersTypes.add(Hibernate.STRING);
                }
            }

        if (dir != null && dir.equals("desc"))
            sb.append(" desc");

        if (sort != null) {
            if (sort.equals(Subscriber.SEARCH_BY_LAST_NAME))
                sb.append(" order by s.lastName");
            else if (sort.equals(Subscriber.SEARCH_BY_FIRST_NAME))
                sb.append(" order by s.firstName");
            else if (sort.equals(Subscriber.SEARCH_BY_NUMBER))
                sb.append(" order by s.number");
            else
                sb.append(" order by s.lastName");
        } else {
            sb.append(" order by s.lastName");
        }

        Query query = HibernateUtil.getSession().createQuery(sb.toString());
        query.setParameters(parametersValues.toArray(), parametersTypes.toArray(new Type[0]));

        if (recordsReturned > 0)
            query.setMaxResults(recordsReturned);
        query.setFirstResult(startIndex);

        return query.list(); 
    }

    @Override
    public Subscriber findSubscriberByNumber(String number) {
        Query query = HibernateUtil.getSession()
        .createQuery("from Subscriber s where s.number = :number ")
        .setString("number", number);
        return (Subscriber) query.uniqueResult();
    }

}
