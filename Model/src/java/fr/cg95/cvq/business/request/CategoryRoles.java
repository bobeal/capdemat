package fr.cg95.cvq.business.request;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Parent;


/**
 * @author bor@zenexity.fr
 */
@Embeddable
public class CategoryRoles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    @Column(name="profile",length=16)
    private CategoryProfile profile;

    @Parent
    private Category category;

    @Column(name="agent_id")
    private Long agentId;

    /** full constructor */
    public CategoryRoles(CategoryProfile profile, Category category, Long agentId) {
        this.profile = profile;
        this.category = category;
        this.agentId = agentId;
    }

    /** default constructor */
    public CategoryRoles() {
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getAgentId() {
        return this.agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public CategoryProfile getProfile() {
        return this.profile;
    }

    public void setProfile(CategoryProfile profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .toString();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof CategoryRoles)) return false;

        final CategoryRoles sr = (CategoryRoles) other;

        if (!getAgentId().equals(sr.getAgentId()))
            return false;
        if (!getCategory().equals(sr.getCategory()))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = getAgentId().hashCode();
        result = 29 * result + getCategory().hashCode();
        return result;
    }
}
