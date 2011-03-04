package fr.cg95.cvq.business.users.external;

import java.util.Date;

/**
 * @hibernate.class
 *  table="user_external_action"
 */
public class UserExternalAction {

    private Long id;

    private Date date;

    private String key;

    private String keyOwner;

    private String label;

    private String status;

    private String message;

    public UserExternalAction() { /* empty constructor for Hibernate */ }

    public UserExternalAction(String key, String label, String status) {
        date = new Date();
        this.key = key;
        keyOwner = "capdemat";
        this.label = label;
        this.status = status;
    }

    public UserExternalAction(String key, String label, String status, String message) {
        this(key, label, status);
        this.message = message;
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
     *  column="date"
     *  not-null="true"
     */
    public Date getDate() {
        return date;
    }

    /**
     * @hibernate.property
     *  column="key"
     *  not-null="true"
     */
    public String getKey() {
        return key;
    }

    /**
     * @hibernate.property
     *  column="key_owner"
     *  not-null="true"
     */
    public String getKeyOwner() {
        return keyOwner;
    }

    /**
     * @hibernate.property
     *  column="label"
     *  not-null="true"
     */
    public String getLabel() {
        return label;
    }

    /**
     * @hibernate.property
     *  column="status"
     *  not-null="true"
     */
    public String getStatus() {
        return status;
    }

    /**
     * @hibernate.property
     *  column="message"
     */
    public String getMessage() {
        return message;
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

    public void setLabel(String label) {
        this.label = label;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
