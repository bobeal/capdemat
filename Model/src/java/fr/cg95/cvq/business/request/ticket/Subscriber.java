package fr.cg95.cvq.business.request.ticket;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name="ticket_subscriber")
public class Subscriber implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String SEARCH_BY_LAST_NAME = "lastName";
    public static final String SEARCH_BY_FIRST_NAME = "firstName";
    public static final String SEARCH_BY_NUMBER = "number";

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name="number")
    private String number;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name="ticket_subscriber_limits", joinColumns=@JoinColumn(name="id"))
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name="key")
    @Column(name="value")
    @OrderColumn(name="key")
    private Map<FareType, Integer> limits = new HashMap<FareType, Integer>();

    public Subscriber(){
    }

    public Subscriber(String number, String firstName, String lastName, String reducePriceLimit,
            String fullPriceLimit) {
        super();
        this.number = number;
        this.lastName = lastName;
        this.firstName = firstName;
        this.limits.put(FareType.REDUIT, Integer.valueOf(reducePriceLimit));
        this.limits.put(FareType.PLEIN, Integer.valueOf(fullPriceLimit));
    }

    public Integer limitByString(String key) {
        return limits.get(FareType.forString(key));
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Map<FareType, Integer> getLimits() {
        return limits;
    }

    public void setLimits(Map<FareType, Integer> limits) {
        this.limits = limits;
    }

}
