package fr.cg95.cvq.business.request;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.security.SecurityContext;

/**
 * @hibernate.class
 *  table="request_admin_action"
 *  lazy="false"
 *
 * @author jsb@zenexity.fr
 */
public class RequestAdminAction implements Serializable {

    private static final long serialVersionUID = 1L;

    public static class Type extends PersistentStringEnum {
        private static final long serialVersionUID = 1L;
        public static final Type ARCHIVES_DELETED = new Type("ArchivesDeleted");
        public static final Type ARCHIVES_DOWNLOADED = new Type("ArchivesDownloaded");
        public static final Type PASSWORD_RESET = new Type("PasswordReset");
        public static final Type REQUESTS_ARCHIVED = new Type("RequestsArchived");
        public static final Type ARCHIVES_MIGRATED = new Type("ArchivesMigrated");
        public Type() { /* public constructor for Hibernate */ }
        private Type(String type) { super(type); }
    }

    public static class Data extends PersistentStringEnum {
        private static final long serialVersionUID = 1L;
        public static final Data ARCHIVE_NAMES = new Data("ArchiveNames");
        public static final Data ARCHIVING_RESULT = new Data("ArchivingResult");
        public static final Data PASSWORD = new Data("Password");
        public Data() { /* public constructor for Hibernate */ }
        private Data(String data) { super(data); }
    }

    private Long id;

    private Type type;

    private Long adminId;

    private Date date;

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

    /**
     * @hibernate.property
     *  column="type"
     *  not-null="true"
     */
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    /**
     * @hibernate.property
     *  column="admin_id"
     *  not-null="true"
     */
    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
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
     * @hibernate.map
     *  lazy="false"
     *  cascade="all"
     *  table="request_admin_action_complementary_data"
     * @hibernate.key
     *  column="id"
     * @hibernate.index
     *  column="key"
     *  type="fr.cg95.cvq.business.request.RequestAdminAction$Data"
     * @hibernate.element
     *  column="value"
     *  type="serializable"
     */
    public Map<Data, Serializable> getComplementaryData() {
        return complementaryData;
    }

    public void setComplementaryData(Map<Data, Serializable> complementaryData) {
        this.complementaryData = complementaryData;
    }
}
