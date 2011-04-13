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

@Entity
@Table(name="user_security_rule")
public class UserSecurityRule implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name="profile",length=16)
    @Enumerated(EnumType.STRING)
    private UserSecurityProfile profile;

    @Column(name="agent_id")
    private Long agentId;

    public UserSecurityRule(Long agentId, UserSecurityProfile profile) {
        this.profile = profile;
        this.agentId = agentId;
    }

    public UserSecurityRule() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAgentId() {
        return this.agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public UserSecurityProfile getProfile() {
        return this.profile;
    }

    public void setProfile(UserSecurityProfile profile) {
        this.profile = profile;
    }
}
