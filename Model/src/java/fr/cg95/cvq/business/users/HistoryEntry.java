package fr.cg95.cvq.business.users;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;


/** 
 * @hibernate.class
 *  table="history_entry"
 *  lazy="false"
 *
 * @author bor@zenexity.fr
 */
public class HistoryEntry implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
    private Long id;
    /** user who issued change */
    private String userName;
    /** id of the request that triggered this change */ 
    private Long requestId;
    /** type of change : update or creation */
    private String operation;
    /** class of the object who changed */
    private String clazz;
    /** id of the object who changed */
    private Long objectId;
    /** object's property that has changed */
    private String property;
    /** old value that this object holds */
    private String oldValue;
    /** new value that this object holds */
    private String newValue;

    /** full constructor */
    public HistoryEntry(String userName, Long requestId, String operation, String clazz, 
            String property, String oldValue, String newValue) {
        this.userName = userName;
        this.requestId = requestId;
        this.operation = operation;
        this.clazz = clazz;
        this.property = property;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    /** default constructor */
    public HistoryEntry() {
    }

    /**
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
     */
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @hibernate.property
     *  column="user_name"
     */
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @hibernate.property
     *  column="request_id"
     */
    public Long getRequestId() {
        return this.requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    /**
     * @hibernate.property
     *  column="operation"
     */
    public String getOperation() {
        return this.operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * @hibernate.property
     *  column="clazz"
     */
    public String getClazz() {
        return this.clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    /**
     * @hibernate.property
     *  column="property"
     */
    public String getProperty() {
        return this.property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    /**
     * @hibernate.property
     *  column="old_value"
     *  length="1024"
     */
    public String getOldValue() {
        return this.oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    /**
     * @hibernate.property
     *  column="new_value"
     *  length="1024"
     */
    public String getNewValue() {
        return this.newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    /**
     * @hibernate.property
     *  column="object_id"
     */
    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    @Override
    public boolean equals(Object other) {
        
//        logger.debug("equals() got object : " + other);
        if (this == other) return true;
        if (!(other instanceof HistoryEntry))
            return false;
        
        HistoryEntry anotherEntry = (HistoryEntry) other; 
        if (anotherEntry.getId() != null && getId() != null) {
            return (getId().longValue() == anotherEntry.getId().longValue());
        }
        
        if (!getClazz().equals(anotherEntry.getClazz()))
            return false;

        if (getOldValue() == null) {
            if (anotherEntry.getOldValue() != null)
                return false;
        } else {
            if (anotherEntry.getOldValue() == null)
                return false;
            else if (!getOldValue().equals(anotherEntry.getOldValue()))
                return false;
        }

        if (getNewValue() == null) {
            if (anotherEntry.getNewValue() != null)
                return false;
        } else {
            if (anotherEntry.getNewValue() == null)
                return false;
            else if (!getNewValue().equals(anotherEntry.getNewValue()))
                return false;
        }
        
        if (getOperation() == null) {
            if (anotherEntry.getOperation() != null)
                return false;
        } else {
            if (anotherEntry.getOperation() == null)
                return false;
            else if (!getOperation().equals(anotherEntry.getOperation()))
                return false;
        }
        
        if (getProperty() == null) {
            if (anotherEntry.getProperty() != null)
                return false;
        } else {
            if (anotherEntry.getProperty() == null)
                return false;
            else if (!getProperty().equals(anotherEntry.getProperty()))
                return false;
        }

        if (getObjectId().equals(anotherEntry.getObjectId()))
            return true;
        else
            return false;
    }
    
    @Override
    public int hashCode() {
        
        int result = 29 * clazz.hashCode();
        if (newValue != null)
            result += newValue.hashCode();
        if (oldValue != null)
            result += oldValue.hashCode();
        if (property != null)
            result += property.hashCode();
        if (requestId != null)
            result += 13 * requestId.hashCode();
        
        return result;
    }
}
