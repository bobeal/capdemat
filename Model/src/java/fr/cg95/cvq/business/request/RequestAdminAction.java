package fr.cg95.cvq.business.request;

import java.io.Serializable;
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
import javax.persistence.MapKeyEnumerated;
import javax.persistence.Table;

import fr.cg95.cvq.security.SecurityContext;

@Entity
@Table(name="request_admin_action")
public class RequestAdminAction implements Serializable {

    private static final long serialVersionUID = 1L;

    public enum Type {

        ARCHIVES_DELETED("ArchivesDeleted"),
        ARCHIVES_DOWNLOADED("ArchivesDownloaded"),
        PASSWORD_RESET("PasswordReset"),
        REQUESTS_ARCHIVED("RequestsArchived"),
        ARCHIVES_MIGRATED("ArchivesMigrated");
        private String name;
        private Type(String type) { this.name = type; }
    }

    public enum Data {
        ARCHIVE_NAMES("ArchiveNames"),
        ARCHIVING_RESULT("ArchivingResult"),
        PASSWORD("Password");
        private String name;
        private Data(String name) { this.name = name; }
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name="type",nullable=false)
    private Type type;

    @Column(name="admin_id",nullable=false)
    private Long adminId;

    @Column(nullable=false)
    private Date date;

    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name="request_admin_action_complementary_data", joinColumns=@JoinColumn(name="id"))
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name="key")
    @Column(name="value")
    private Map<Data, Serializable> complementaryData;

    @SuppressWarnings("unused")
    private RequestAdminAction() {
        // empty constructor for Hibernate
    }

    public RequestAdminAction(Type type) {
        this.type = type;
        adminId = SecurityContext.getCurrentUserId();
        date = new Date();
        complementaryData = new HashMap<Data, Serializable>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<Data, Serializable> getComplementaryData() {
        return complementaryData;
    }

    public void setComplementaryData(Map<Data, Serializable> complementaryData) {
        this.complementaryData = complementaryData;
    }
}
