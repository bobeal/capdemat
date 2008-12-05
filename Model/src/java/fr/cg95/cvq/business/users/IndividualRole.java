package fr.cg95.cvq.business.users;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.cg95.cvq.business.Historizable;

/**
 * @hibernate.class
 *  table="individual_role"
 *  lazy="false"
 *
 * @author bor@zenexity.fr
 */
public class IndividualRole implements Historizable, Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    
    /**
     * Role kind.
     */
    private RoleType role;

    /**
     * Eventual home folder that is the subject of the role.
     */
    private Long homeFolderId;

    /**
     * Eventual individual that is the subject of the role.
     */
    private Long individualId;

    /**
     * Transient field to keep track of the individual who is the subject of the role.
     * 
     * It is the concatenation of first and last names and is used when the individual 
     * is still transient and thus has no identifier yet.
     */
    private String individualName;
    
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
     *  column="role"
     */
    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    /**
     * @hibernate.property 
     *  column="home_folder_id"
     */
    public Long getHomeFolderId() {
        return homeFolderId;
    }

    public void setHomeFolderId(Long homeFolderId) {
        this.homeFolderId = homeFolderId;
    }

    /**
     * @hibernate.property 
     *  column="individual_id"
     */
    public Long getIndividualId() {
        return individualId;
    }

    public void setIndividualId(Long individualId) {
        this.individualId = individualId;
    }

    public void setIndividualId(String individualId) {
        try {
            this.individualId = Long.valueOf(individualId);
        } catch (NumberFormatException nfe) {
            // called by HFMR service while restoring properties after a cancel
            // so we can be pretty sure it is correct
        }
    }
    
    public void setIndividualName(String individualName) {
        this.individualName = individualName;
    }

    public String getIndividualName() {
        return individualName;
    }

    public boolean equals(Object other) {
        
        if (this == other)
            return true;
        if (!(other instanceof IndividualRole))
            return false;

        final IndividualRole ir = (IndividualRole) other;

        if (getId() != null
                && (ir.getId() == null || !getId().equals(ir.getId())))
            return false;
        if (getId() == null && ir.getId() != null)
            return false;

        if (getHomeFolderId() != null
                && (ir.getHomeFolderId() == null 
                        || !getHomeFolderId().equals(ir.getHomeFolderId())))
            return false;
        if (getIndividualId() != null
                && (ir.getIndividualId() == null 
                        || !getIndividualId().equals(ir.getIndividualId())))
            return false;
        if (getIndividualName() != null
                && (ir.getIndividualName() == null 
                        || !getIndividualName().equals(ir.getIndividualName())))
            return false;
        
        if (getRole() != null
                && (ir.getRole() == null
                        || !getRole().equals(ir.getRole())))
            return false;

        return true;
    }

    public int hashCode() {
        int result = 29 * getRole().hashCode();
        return result;
    }
    
    
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }
}
