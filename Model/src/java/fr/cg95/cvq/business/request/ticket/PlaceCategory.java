package fr.cg95.cvq.business.request.ticket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @hibernate.class
 *  table="ticket_place_category"
 *  lazy="false"
 */
public class PlaceCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String externalId;
    private String name;
    private int placeNumber;
    private int bookedPlaceNumber;
    private List<Fare> fares = new ArrayList<Fare>();

    public PlaceCategory() {
    }

    public PlaceCategory(String externalId, String name, String placeNumber) {
        this.externalId = externalId;
        this.name = name;
        this.placeNumber = Integer.valueOf(placeNumber);
    }

    public PlaceCategory(String name) {
        this.name = name;
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
     *  column="name"
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @hibernate.property
     *  column="place_number"
     */
    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    /**
     * @hibernate.property
     *  column="booked_place_number"
     */
    public int getBookedPlaceNumber() {
        return bookedPlaceNumber;
    }

    public void setBookedPlaceNumber(int bookedPlaceNumber) {
        this.bookedPlaceNumber = bookedPlaceNumber;
    }

    /**
     * @hibernate.list
     *  inverse="false"
     *  lazy="false"
     *  cascade="all"
     * @hibernate.key
     *  column="ticket_place_category_id"
     * @hibernate.list-index
     *  column="fares_index"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.request.ticket.Fare"
     */
    public List<Fare> getFares() {
        return fares;
    }

    public void setFares(List<Fare> fares) {
        this.fares = fares;
    }
}

