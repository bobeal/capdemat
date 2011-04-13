package fr.cg95.cvq.business.request.ticket;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ticket_fare")
public class Fare implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name="external_id")
    private String externalId;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private float price;

    @Column(name="with_subscriber")
    private boolean withSubscribtion;

    public Fare() {
    }

    public Fare(String externalId, String name, String price, String withSubscribtion) {
        this.externalId = externalId;
        this.name = name;
        this.price = Float.valueOf(price);
        this.withSubscribtion = Boolean.valueOf(withSubscribtion.toLowerCase());
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

    public void setName(final String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(final float price) {
        this.price = price;
    }

    public boolean isWithSubscribtion() {
        return withSubscribtion;
    }

    public void setWithSubscribtion(boolean withSubscribtion) {
        this.withSubscribtion = withSubscribtion;
    }

}
