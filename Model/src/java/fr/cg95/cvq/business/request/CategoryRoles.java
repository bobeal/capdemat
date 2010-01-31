package fr.cg95.cvq.business.request;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * @author bor@zenexity.fr
 */
public class CategoryRoles implements Serializable {

    private static final long serialVersionUID = 1L;

    private CategoryProfile profile;
    private Category category;
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

    /**
     * @hibernate.parent
     */
    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @hibernate.property
     *  column="agent_id"
     */
    public Long getAgentId() {
        return this.agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    /**
     * @hibernate.property
     *  column="profile"
     *  length="16"
     */
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
