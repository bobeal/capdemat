package fr.cg95.cvq.business.request.ticket;

import java.io.Serializable;

/**
 *
 * @hibernate.class
 *  table="ticket_fare"
 *  lazy="false"
 */
public class Fare implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String externalId;
    private String name;

    private float price;
    private boolean withSubscribtion;

    public Fare() {
    }

    public Fare(String externalId, String name, String price, String withSubscribtion) {
        this.externalId = externalId;
        this.name = name;
        this.price = Float.valueOf(price);
        this.withSubscribtion = Boolean.valueOf(withSubscribtion.toLowerCase());
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

    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @hibernate.property
     *  column="price"
     */
    public float getPrice() {
        return price;
    }

    public void setPrice(final float price) {
        this.price = price;
    }

    /**
     * @hibernate.property
     *  column="with_subscriber"
     */
    public boolean isWithSubscribtion() {
        return withSubscribtion;
    }

    public void setWithSubscribtion(boolean withSubscribtion) {
        this.withSubscribtion = withSubscribtion;
    }

}
