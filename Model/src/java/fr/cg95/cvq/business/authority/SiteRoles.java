package fr.cg95.cvq.business.authority;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;


/** 
 * @author bor@zenexity.fr
 */
public class SiteRoles implements Serializable {

	private static final long serialVersionUID = 1L;

	private SiteProfile profile;
    private Agent agent;

    /** full constructor */
    public SiteRoles(SiteProfile profile, Agent agent) {
        this.profile = profile;
        this.agent = agent;
    }

    /** default constructor */
    public SiteRoles() {
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
    public SiteProfile getProfile() {
        return this.profile;
    }

    public void setProfile(SiteProfile profile) {
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
        if (!(other instanceof SiteRoles)) return false;

        final SiteRoles sr = (SiteRoles) other;

        if (!getAgent().equals(sr.getAgent())) 
	    return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = getAgent().hashCode();
        return 29 * result + getProfile().hashCode();
    }
}
