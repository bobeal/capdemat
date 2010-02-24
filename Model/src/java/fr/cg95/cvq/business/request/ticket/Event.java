package fr.cg95.cvq.business.request.ticket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @hibernate.class
 *  table="ticket_event"
 *  lazy="false"
 */
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String SEARCH_BY_DATE = "date";
    public static final String SEARCH_BY_BOOKING_START = "bookingStart";
    public static final String SEARCH_BY_BOOKING_END = "bookingEnd";

    private Long id;
    private String externalId;
    private Date date;
    private Date bookingStart;
    private Date bookingEnd;
    private String place;
    private String link;
    private String address;
    private Entertainment entertainment;
    private List<PlaceCategory> placeCategories = new ArrayList<PlaceCategory>();

    public Event() {
    }

    public Event(String externalId, Date date, String place) {
        this.externalId = externalId;
        this.date = date;
        this.place = place;
    }

    /**
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
     */
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @hibernate.property
     *  column="external_id"
     */
    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    /**
     * @hibernate.property
     *  column="date"
     */
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @hibernate.property
     *  column="booking_start"
     */
    public Date getBookingStart() {
        return bookingStart;
    }

    public void setBookingStart(Date bookingStart) {
        this.bookingStart = bookingStart;
    }

    /**
     * @hibernate.property
     *  column="booking_end"
     */
    public Date getBookingEnd() {
        return bookingEnd;
    }

    public void setBookingEnd(Date bookingEnd) {
        this.bookingEnd = bookingEnd;
    }

    /**
     * @hibernate.property
     *  column="place"
     */
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * @hibernate.property
     *  column="link"
     */
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @hibernate.property
     *  column="address"
     */
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @hibernate.many-to-one
     *  column="ticket_entertainment_id"
     *  not-null="true"
     *  class="fr.cg95.cvq.business.request.ticket.Entertainment"
     */
    public Entertainment getEntertainment() {
        return entertainment;
    }

    public void setEntertainment(Entertainment entertainment) {
        this.entertainment = entertainment;
    }

    /**
     * @hibernate.list
     *  inverse="false"
     *  lazy="false"
     *  cascade="all"
     * @hibernate.key
     *  column="ticket_event_id"
     * @hibernate.list-index
     *  column="place_categories_index"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.request.ticket.PlaceCategory"
     */
    public List<PlaceCategory> getPlaceCategories() {
        return placeCategories;
    }

    public void setPlaceCategories(List<PlaceCategory> placeCategories) {
        this.placeCategories = placeCategories;
    }
}

