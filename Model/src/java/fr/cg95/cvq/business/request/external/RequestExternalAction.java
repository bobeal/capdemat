package fr.cg95.cvq.business.request.external;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name="request_external_action")
public class RequestExternalAction implements Serializable {

    public enum Status {
        SENT("Sent"),
        IN_PROGRESS("InProgress"),
        NOT_SENT("NotSent"),
        ACKNOWLEDGED("Acknowledged"),
        ERROR("Error"),
        ACCEPTED("Accepted"),
        REJECTED("Rejected"),
        RETURNED("Returned");

        private String legacyLabel;

        private Status(final String state) { this.legacyLabel = state; }

        /**
         * @depreacated for backward only, use values() instead
         */
        public static final Status[] all = Status.values();

        public static Status forString(final String enumAsString) {
            for (Status t : values())
                if (t.legacyLabel.equals(enumAsString)) return t;
            return null;
        }

        @Override
        public String toString() {
            return legacyLabel;
        }
    }

    private static final long serialVersionUID = 1L;

    public static String SEARCH_BY_DATE = "date";
    public static String SEARCH_BY_ID = "id";
    public static String SEARCH_BY_KEY = "key";
    public static String SEARCH_BY_KEY_OWNER = "keyOwner";
    public static String SEARCH_BY_MESSAGE = "message";
    public static String SEARCH_BY_NAME = "name";
    public static String SEARCH_BY_STATUS = "status";
    public static String SEARCH_BY_REQUEST_TYPE = "request_type_id";
    public static String SEARCH_BY_REQUEST_STATE = "state";
    public static String SEARCH_BY_COMPLEMENTARY_DATA = "SEARCH_BY_COMPLEMENTARY_DATA";

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    /**
     * Identifier used by the key owner to retrieve data.
     */
    @Column(name="key")
    private Long key;

    /**
     * Owner of the key, typically an application, eg CapDemat.
     */
    @Column(name="key_owner")
    private String keyOwner;

    /**
     * Name of the external service label.
     * 
     * TODO : rename to make it more explicit.
     */
    @Column(name="name")
    private String name;

    /**
     * An eventual message received from an external service, eg in case of an error.
     */
    @Column(name="message")
    private String message;

    @Column
    private Date date;

    @Enumerated(EnumType.STRING)
    @Column
    private Status status;

    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name="request_external_action_complementary_data", joinColumns=@JoinColumn(name="id"))
    @MapKeyColumn(name="key")
    @Column(name="value")
    @OrderColumn(name="key")
    private Map<String, Serializable> complementaryData;

    public RequestExternalAction() {
        this(null, null, null, null, null, null);
    }

    public RequestExternalAction(Date date, Long key, String keyOwner, String message,
        String name, Status status,
        Map<String, Serializable> complementaryData) {
        super();
        this.date = date;
        this.key = key;
        this.keyOwner = keyOwner;
        this.message = message;
        this.name = name;
        this.status = status;
        this.complementaryData = new HashMap<String, Serializable>(complementaryData);
    }

    public RequestExternalAction(Date date, Long key, String keyOwner, String message,
        String name, Status status) {
        this(date, key, keyOwner, message, name, status,
            Collections.<String, Serializable>emptyMap());
    }

    public Date getDate() {
        return date;
    }

    public Long getId() {
        return id;
    }

    public Long getKey() {
        return key;
    }

    public String getKeyOwner() {
        return keyOwner;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public void setKeyOwner(String keyOwner) {
        this.keyOwner = keyOwner;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Map<String, Serializable> getComplementaryData() {
        return complementaryData;
    }

    public void setComplementaryData(Map<String, Serializable> complementaryData) {
        this.complementaryData = complementaryData;
    }
}
