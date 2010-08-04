package fr.cg95.cvq.business.request.ticket;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 *
 * @hibernate.class
 *  table="ticket_entertainment"
 *  lazy="false"
 */
public class Entertainment implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String SEARCH_BY_NAME = "name";
    public static final String SEARCH_BY_CATEGORY = "category";

    private Long id;
    private String externalId;
    private String information;
    private String name;
    private String link;
    private String category;
    private byte[] logo;
    private Set<Event> events = new LinkedHashSet<Event>();

    public Entertainment() {
    }

    public Entertainment(String externalId, String name, String link, String category) {
        this.externalId = externalId;
        this.name = name;
        this.link = link;
        this.category = category;
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
     *  column="information"
     */
    public String getInformation() {
        return this.information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    /**
     * @hibernate.property
     *  column="name"
     */
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @hibernate.property
     *  column="link"
     */
    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @hibernate.property
     *  column="category"
     */
    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @hibernate.property
     *  column="logo"
     */
    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    /**
     * @hibernate.set
     *  lazy="false"
     *  cascade="all"
     *  inverse="true"
     * @hibernate.key
     *  column="ticket_entertainment_id"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.request.ticket.Event"
     */
    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}

