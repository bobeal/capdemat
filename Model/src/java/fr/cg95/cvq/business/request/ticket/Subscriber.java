package fr.cg95.cvq.business.request.ticket;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
*
* @hibernate.class
*  table="ticket_subscriber"
*  lazy="false"
*/
public class Subscriber implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String SEARCH_BY_LAST_NAME = "lastName";
    public static final String SEARCH_BY_FIRST_NAME = "firstName";
    public static final String SEARCH_BY_NUMBER = "number";

    private Long id;
    private String number;
    private String firstName;
    private String lastName;
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
     *  column="number"
     */
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @hibernate.property
     *  column="first_name"
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @hibernate.property
     *  column="last_name"
     */
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @hibernate.map
     *  lazy="false"
     *  cascade="all"
     *  table="ticket_subscriber_limits"
     * @hibernate.key
     *  column="id"
     * @hibernate.index
     *  column="key"
     *  type="fr.cg95.cvq.business.request.ticket.FareType"
     * @hibernate.element
     *  column="value"
     *  type="integer"
     */
    public Map<FareType, Integer> getLimits() {
        return limits;
    }

    public void setLimits(Map<FareType, Integer> limits) {
        this.limits = limits;
    }

}
