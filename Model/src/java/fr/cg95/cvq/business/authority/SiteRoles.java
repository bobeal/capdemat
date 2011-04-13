package fr.cg95.cvq.business.authority;

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
public class SiteRoles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    @Column(name="profile", length=16)
    private SiteProfile profile;

    @Parent
    private Agent agent;

    /** full constructor */
    public SiteRoles(SiteProfile profile, Agent agent) {
        this.profile = profile;
        this.agent = agent;
    }

    /** default constructor */
    public SiteRoles() {
    }


    public Agent getAgent() {
        return this.agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public SiteProfile getProfile() {
        return this.profile;
    }

    public void setProfile(SiteProfile profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).toString();
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
