package fr.cg95.cvq.business.users;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.util.UserUtils;

/**
 * @hibernate.class
 *  table="user_action"
 *  lazy="false"
 */
public class UserAction {

    public static final class Type extends PersistentStringEnum {
        private static final long serialVersionUID = 1L;
        public static final Type CREATION = new Type("Creation");
        public static final Type MODIFICATION = new Type("Modification");
        public static final Type STATE_CHANGE = new Type("StateChange");
        public static final Type QoS = new Type("QoS");
        public static final Type DELETION = new Type("Deletion");
        public Type() { /* empty constructor for Hibernate */ }
        private Type(String type) { super(type); }
    }

    private Long id;
    private Date date;
    private Type type;
    private Long userId;
    private Long targetId;
    private String note;
    private String data;

    protected UserAction() { /* empty constructor for Hibernate */ }

    public UserAction(Type type, Long targetId) {
        this(type, targetId, new JsonObject());
    }

    public UserAction(Type type, Long targetId, JsonObject payload) {
        date = new Date();
        this.type = type;
        userId = SecurityContext.getCurrentUserId();
        JsonObject user = new JsonObject();
        user.addProperty("id", userId);
        user.addProperty("name", UserUtils.getDisplayName(userId));
        payload.add("user", user);
        this.targetId = targetId;
        user = new JsonObject();
        user.addProperty("id", targetId);
        user.addProperty("name", UserUtils.getDisplayName(targetId));
        payload.add("target", user);
        data = new Gson().toJson(payload);
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
     *  column="target_id"
     *  not-null="true"
     */
    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
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
     *  column="note"
     */
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @hibernate.property
     *  column="data"
     *  type="text"
     */
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
