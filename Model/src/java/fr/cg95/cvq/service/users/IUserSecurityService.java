package fr.cg95.cvq.service.users;

import java.util.List;
import java.util.Map;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.users.UserSecurityProfile;
import fr.cg95.cvq.business.users.UserSecurityRule;

public interface IUserSecurityService {

    List<Agent> listAgents(boolean withWriteProfile);

    Map<Long,UserSecurityProfile> mapRules();

    UserSecurityRule getRule(Long agentId);

    void allow(Long agentId, UserSecurityProfile profile);

    void disallow(Long agentId);

}
