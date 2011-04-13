package fr.cg95.cvq.business.request;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="request_lock")
public class RequestLock {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name="request_id",nullable=false)
    private Long requestId;

    @Column(name="user_id",nullable=false)
    private Long userId;

    @Column(nullable=false)
    private Date date;

    // empty constructor for hibernate
    public RequestLock() {}

    public RequestLock(Long requestId, Long userId) {
        this.requestId = requestId;
        this.userId = userId;
        this.date = new Date();
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
