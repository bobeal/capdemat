package fr.cg95.cvq.business.request.external;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;


/**
 * @hibernate.class
 *  table="request_external_action"
 *
 * @author vba@zenexity.fr
 */
public class RequestExternalAction implements Serializable {

    public final static class Status extends PersistentStringEnum {
        private static final long serialVersionUID = 1L;
        public static final Status SENT = new Status("Sent");
        public static final Status IN_PROGRESS = new Status("InProgress");
        public static final Status NOT_SENT = new Status("NotSent");
        public static final Status ACKNOWLEDGED = new Status("Acknowledged");
        public static final Status ERROR = new Status("Error");
        public static final Status ACCEPTED = new Status("Accepted");
        public static final Status REJECTED = new Status("Rejected");
        private Status(final String state) { super(state); }
        public Status() { /* empty constructor for Hibernate */ }
        public static final Status[] all = {
            IN_PROGRESS,
            NOT_SENT,
            SENT,
            ACKNOWLEDGED,
            ACCEPTED,
            REJECTED,
            ERROR
        };
        public static Status forString(final String enumAsString) {
            for (Status t : all)
                if (t.name.equals(enumAsString)) return t;
            return null;
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

    private Long id;

    /**
     * Identifier used by the key owner to retrieve data.
     */
    private String key;

    /**
     * Owner of the key, typically an application, eg CapDemat.
     */
    private String keyOwner;

    /**
     * Name of the external service label.
     * 
     * TODO : rename to make it more explicit.
     */
    private String name;

    /**
     * An eventual message received from an external service, eg in case of an error.
     */
    private String message;

    private Date date;

    private Status status;

    private Map<String, Serializable> complementaryData;

    public RequestExternalAction() {
        this(null, null, null, null, null, null);
    }

    public RequestExternalAction(Date date, String key, String keyOwner, String message,
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

    public RequestExternalAction(Date date, String key, String keyOwner, String message,
        String name, Status status) {
        this(date, key, keyOwner, message, name, status,
            Collections.<String, Serializable>emptyMap());
    }

    /**
     * @hibernate.property
     *  column="date"
     */
    public Date getDate() {
        return date;
    }

    /**
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
     */
    public Long getId() {
        return id;
    }

    /**
     * @hibernate.property
     *  column="key"
     */
    public String getKey() {
        return key;
    }

    /**
     * @hibernate.property
     *  column="key_owner"
     */
    public String getKeyOwner() {
        return keyOwner;
    }

    /**
     * @hibernate.property
     *  column="message"
     */
    public String getMessage() {
        return message;
    }

    /**
     * @hibernate.property
     *  column="name"
     */
    public String getName() {
        return name;
    }

    /**
     * @hibernate.property
     *  column="status"
     */
    public Status getStatus() {
        return status;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setKey(String key) {
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

    /**
     * @hibernate.map
     *  lazy="false"
     *  cascade="all"
     *  table="request_external_action_complementary_data"
     * @hibernate.key
     *  column="id"
     * @hibernate.index
     *  column="key"
     *  type="string"
     * @hibernate.element
     *  column="value"
     *  type="serializable"
     */
    public Map<String, Serializable> getComplementaryData() {
        return complementaryData;
    }

    public void setComplementaryData(Map<String, Serializable> complementaryData) {
        this.complementaryData = complementaryData;
    }
}
