package fr.cg95.cvq.business.users;

import java.io.Serializable;

public class IndividualRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Owner of the role.
     */
    private Individual owner;

    /**
     * Role kind.
     */
    private RoleEnum role;

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
     * @hibernate.parent
     */
    public Individual getOwner() {
        return owner;
    }

    public void setOwner(Individual owner) {
        this.owner = owner;
    }

    /**
     * @hibernate.property 
     *  column="role"
     */
    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
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

        if (!getOwner().equals(ir.getOwner()))
            return false;
        if (getHomeFolderId() != null
                && (ir.getHomeFolderId() == null 
                        || !getHomeFolderId().equals(ir.getHomeFolderId())))
            return false;
        if (getIndividualId() != null
                && (ir.getIndividualId() == null 
                        || !getIndividualId().equals(ir.getIndividualId())))
            return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        if (getOwner() != null)
            result = getOwner().hashCode();
        if (getHomeFolderId() != null)
            result = 29 * result + getHomeFolderId().hashCode();
        else if (getIndividualId() != null)
            result = 29 * result + getIndividualId().hashCode();
        else if (getIndividualName() != null)
            result = 29 * result + getIndividualName().hashCode();
        return result;
    }
}
