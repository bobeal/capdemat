package fr.cg95.cvq.business.request.ticket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name="ticket_event")
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String SEARCH_BY_DATE = "date";
    public static final String SEARCH_BY_BOOKING_START = "bookingStart";
    public static final String SEARCH_BY_BOOKING_END = "bookingEnd";

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name="external_id")
    private String externalId;

    @Column(name="date")
    private Date date;

    @Column(name="booking_start")
    private Date bookingStart;

    @Column(name="booking_end")
    private Date bookingEnd;

    @Column(name="place")
    private String place;

    @Column(name="link")
    private String link;

    @Column(name="address")
    private String address;

    @ManyToOne(optional=false, fetch=FetchType.EAGER)
    @JoinColumn(name="ticket_entertainment_id")
    private Entertainment entertainment;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="ticket_event_id")
    @OrderColumn(name="place_categories_index")
    private List<PlaceCategory> placeCategories = new ArrayList<PlaceCategory>();

    public Event() {
    }

    public Event(String externalId, Date date, String place) {
        this.externalId = externalId;
        this.date = date;
        this.place = place;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getBookingStart() {
        return bookingStart;
    }

    public void setBookingStart(Date bookingStart) {
        this.bookingStart = bookingStart;
    }

    public Date getBookingEnd() {
        return bookingEnd;
    }

    public void setBookingEnd(Date bookingEnd) {
        this.bookingEnd = bookingEnd;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Entertainment getEntertainment() {
        return entertainment;
    }

    public void setEntertainment(Entertainment entertainment) {
        this.entertainment = entertainment;
    }

    public List<PlaceCategory> getPlaceCategories() {
        return placeCategories;
    }

    public void setPlaceCategories(List<PlaceCategory> placeCategories) {
        this.placeCategories = placeCategories;
    }
}