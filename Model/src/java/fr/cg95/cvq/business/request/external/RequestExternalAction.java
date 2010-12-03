package fr.cg95.cvq.business.request.external;

import java.io.Serializable;
import java.util.Date;


/**
 * @hibernate.class
 *  table="request_external_action"
 *
 * @author vba@zenexity.fr
 */
public class RequestExternalAction implements Serializable {

    private static final long serialVersionUID = 1L;

    public static String SEARCH_BY_DATE = "date";
    public static String SEARCH_BY_ID = "id";
    public static String SEARCH_BY_KEY = "key";
    public static String SEARCH_BY_KEY_OWNER = "keyOwner";
    public static String SEARCH_BY_MESSAGE = "message";
    public static String SEARCH_BY_NAME = "name";
    public static String SEARCH_BY_STATUS = "status";
    public static String SEARCH_BY_SUBKEY = "subkey";
    public static String SEARCH_BY_REQUEST_TYPE = "request_type_id";
    public static String SEARCH_BY_REQUEST_STATE = "state";

    private Long id;

    /**
     * Identifier used by the key owner to retrieve data.
     */
    private String key;

    /**
     * Additional information to distinguish between traces related to
     * different parts of the communication with the external service.
     */
    private String subkey;

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

    private RequestExternalActionState status;

    public RequestExternalAction() {
        // empty constructor for Hibernate
    }

    public RequestExternalAction(Date date, String key, String subkey,
        String keyOwner, String message, String name, RequestExternalActionState status) {
        super();
        this.date = date;
        this.key = key;
        this.subkey = subkey;
        this.keyOwner = keyOwner;
        this.message = message;
        this.name = name;
        this.status = status;
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
    public RequestExternalActionState getStatus() {
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

    public void setStatus(RequestExternalActionState status) {
        this.status = status;
    }

    /**
     * @hibernate.property
     *  column="subkey"
     */
    public String getSubkey() {
        return subkey;
    }

    public void setSubkey(String subkey) {
        this.subkey = subkey;
    }
}
