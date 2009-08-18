package fr.cg95.cvq.business.request;

import java.util.Date;

/**
 * Represents a lock on a request.
 *
 * @hibernate.class
 *  table="request_lock"
 *  lazy="false"
 *
 * @author jsb@zenexity.fr
 */
public class RequestLock {

    private Long id;

    private Long requestId;

    private Long userId;

    private Date date;

    // empty constructor for hibernate
    public RequestLock() {}

    public RequestLock(Long requestId, Long userId) {
        this.requestId = requestId;
        this.userId = userId;
        this.date = new Date();
    }

    /**
     * @hibernate.property
     *  column="request_id"
     *  not-null="true"
     */
    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    /**
     * @hibernate.property
     *  column="user_id"
     *  not-null="true"
     */
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @hibernate.property
     *  column="date"
     *  not-null="true"
     */
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
