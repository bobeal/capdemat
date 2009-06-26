package fr.cg95.cvq.business.external;

import java.io.Serializable;
import java.util.Date;

/**
 * @hibernate.class
 *  table="external_service_traces"
 *
 * @author vba@zenexity.fr
 */
public class ExternalServiceTrace implements Serializable {
    private static final long serialVersionUID = 1L;
    
    Long id;
    /**
     * Identifier used by the key owner to retrieve data.
     */
    String key;
    /**
     * Additionnal information to distinguish between traces related to
     * different parts of the communication with the external service.
     */
    String subkey;
    /**
     * Owner of the key, typically an application, eg CapDemat.
     */
    String keyOwner;
    /**
     * Name of the external service label.
     * 
     * TODO : rename to make it more explicit.
     */
    String name;
    /**
     * An eventual message received from an external service, eg in case of an error.
     */
    String message;
    Date date;
    TraceStatusEnum status;
    
    public ExternalServiceTrace() {
    }
    
    public ExternalServiceTrace(Date date, String key, String subkey, String keyOwner, String message,
            String name, TraceStatusEnum status) {
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
    public TraceStatusEnum getStatus() {
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
    
    public void setStatus(TraceStatusEnum status) {
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
