package fr.cg95.cvq.business.users;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.cg95.cvq.xml.common.IndividualRoleType;

/**
 * @author bor@zenexity.fr
 */
@Entity
@Table(name="individual_role")
public class IndividualRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    
    /**
     * Role kind.
     */
    @Enumerated(EnumType.STRING)
    private RoleType role;

    /**
     * Eventual home folder that is the subject of the role.
     */
    @Column(name="home_folder_id")
    private Long homeFolderId;

    /**
     * Eventual individual that is the subject of the role.
     */
    @Column(name="individual_id")
    private Long individualId;

    /**
     * Usefull to keep track of the individual who is the subject of the role.
     * 
     * It is the concatenation of first and last names and is used when the individual 
     * is still transient and thus has no identifier yet.
     * 
     * It is peristent field, just to enable field's value consistent merge.
     */
    @Column(name="individual_name")
    private String individualName;

    public static IndividualRoleType modelToXml(IndividualRole individualRole) {
        IndividualRoleType individualRoleType = IndividualRoleType.Factory.newInstance();
        if (individualRole.getHomeFolderId() != null)
            individualRoleType.setHomeFolderId(individualRole.getHomeFolderId());
        if (individualRole.getIndividualId() != null)
            individualRoleType.setIndividualId(individualRole.getIndividualId());
        individualRoleType.setRoleName(
            fr.cg95.cvq.xml.common.RoleType.Enum.forString(
            individualRole.getRole().toString()));
        return individualRoleType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public Long getHomeFolderId() {
        return homeFolderId;
    }

    public void setHomeFolderId(Long homeFolderId) {
        this.homeFolderId = homeFolderId;
    }

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

    @Override
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

    @Override
    public int hashCode() {
        if (getRole() == null)
            return super.hashCode();
        int result = 29 * getRole().hashCode();
        return result;
    }
    
    
    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }
}
