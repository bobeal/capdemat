package fr.cg95.cvq.business.users.external;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_external_action")
public class UserExternalAction {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable=false)
    private Date date;

    @Column(nullable=false)
    private String key;

    @Column(name="key_owner",nullable=false)
    private String keyOwner;

    @Column(nullable=false)
    private String label;

    @Column(nullable=false)
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

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getKey() {
        return key;
    }

    public String getKeyOwner() {
        return keyOwner;
    }

    public String getLabel() {
        return label;
    }

    public String getStatus() {
        return status;
    }

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
