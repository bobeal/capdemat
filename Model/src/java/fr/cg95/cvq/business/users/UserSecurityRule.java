package fr.cg95.cvq.business.users;

import java.io.Serializable;


/**
 * @hibernate.class
 *  table="user_security_rule"
 *  lazy="false"
 *
 */
public class UserSecurityRule implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private UserSecurityProfile profile;
    private Long agentId;

    public UserSecurityRule(Long agentId, UserSecurityProfile profile) {
        this.profile = profile;
        this.agentId = agentId;
    }

    public UserSecurityRule() {
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
    public UserSecurityProfile getProfile() {
        return this.profile;
    }

    public void setProfile(UserSecurityProfile profile) {
        this.profile = profile;
    }
}
