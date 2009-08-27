package fr.cg95.cvq.business.authority;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * @author bor@zenexity.fr
 */
public class CategoryRoles implements Serializable {

	private static final long serialVersionUID = 1L;

	private CategoryProfile profile;
    private Category category;
    private Agent agent;

    /** full constructor */
    public CategoryRoles(CategoryProfile profile, Category category, Agent agent) {
        this.profile = profile;
        this.category = category;
        this.agent = agent;
    }

    /** default constructor */
    public CategoryRoles() {
    }

    /**
     * @hibernate.parent
     */
    public Agent getAgent() {
        return this.agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
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

    /**
     * @hibernate.many-to-one
     *  class="fr.cg95.cvq.business.authority.Category"
     *  column="category_id"
     */
    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

        if (!getAgent().equals(sr.getAgent()))
            return false;
        if (!getCategory().equals(sr.getCategory()))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = getAgent().hashCode();
        result = 29 * result + getCategory().hashCode();
        return result;
    }
}
