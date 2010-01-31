package fr.cg95.cvq.business.authority;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

/**
 * Represents a access profile at the site level.
 * 
 * @author bor@zenexity.fr
 */
public final class SiteProfile extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;

    /** An user that can access the site but has no specific right */
    public static final SiteProfile AGENT = new SiteProfile("Agent");
    /** A site administrator, can manage agents, categories, ... */
    public static final SiteProfile ADMIN = new SiteProfile("Admin");

    public SiteProfile() {}

    private SiteProfile(String name) {
        super(name);
    }

    /**
     * A vector of all possible {@link SiteProfile site profiles}.
     */
    public static final SiteProfile[] allSiteProfiles = {
        AGENT,
        ADMIN
    };
}
