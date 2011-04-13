package fr.cg95.cvq.business.request.ticket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name="ticket_place_category")
public class PlaceCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name="external_id")
    private String externalId;

    @Column(name="name")
    private String name;

    @Column(name="place_number")
    private int placeNumber;

    @Column(name="booked_place_number")
    private int bookedPlaceNumber;

    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="ticket_place_category_id")
    @OrderColumn(name="fares_index")
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public int getBookedPlaceNumber() {
        return bookedPlaceNumber;
    }

    public void setBookedPlaceNumber(int bookedPlaceNumber) {
        this.bookedPlaceNumber = bookedPlaceNumber;
    }

    public List<Fare> getFares() {
        return fares;
    }

    public void setFares(List<Fare> fares) {
        this.fares = fares;
    }
}

