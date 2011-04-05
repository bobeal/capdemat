package fr.cg95.cvq.service.users.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.users.UserSecurityProfile;
import fr.cg95.cvq.business.users.UserSecurityRule;
import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.service.authority.IAgentService;
import fr.cg95.cvq.service.users.IUserSecurityService;

public class UserSecurityService implements IUserSecurityService {

    private IGenericDAO genericDAO;
    private IAgentService agentService;

    @Override
    public List<Agent> listAgents(boolean withWriteProfile) {
        List<Agent> agents = agentService.getAll();
        if (!withWriteProfile)
            return agents;
        Map<Long, UserSecurityProfile> rules = mapRules();
        Iterator<Agent> it = agents.iterator();
        while (it.hasNext()) {
            Agent agent = (Agent) it.next();
            if (!UserSecurityProfile.writer.contains(rules.get(agent.getId())))
                it.remove();
        }
        return agents;
    }

    @Override
    public Map<Long, UserSecurityProfile> mapRules() {
        List<UserSecurityRule> rules = genericDAO.all(UserSecurityRule.class);
        Map<Long, UserSecurityProfile> mapRules = new HashMap<Long, UserSecurityProfile>();
        for (UserSecurityRule rule : rules) {
            mapRules.put(rule.getAgentId(), rule.getProfile());
        }
        return mapRules;
    }

    @Override
    public UserSecurityRule getRule(Long agentId) {
        return genericDAO.simpleSelect(UserSecurityRule.class).and("agentId", agentId).unique();
    }

    @Override
    public void allow(Long agentId, UserSecurityProfile profile) {
        UserSecurityRule rule = getRule(agentId);
        if (rule == null) {
            rule = new UserSecurityRule(agentId, profile);
            genericDAO.create(rule);
        } else {
            rule.setProfile(profile);
            genericDAO.update(rule);
        }
    }

    @Override
    public void disallow(Long agentId) {
        UserSecurityRule rule = getRule(agentId);
        if (rule != null)
            genericDAO.delete(rule);
    }

    @Override
    @Context(types = {ContextType.AGENT}, privilege = ContextPrivilege.NONE)
    public boolean canWrite(Long agentId) {
        UserSecurityRule rule = getRule(agentId);
        if (rule == null)
            return false;
        return UserSecurityProfile.writer.contains(rule.getProfile());
    }

    public void setGenericDAO(IGenericDAO genericDAO) {
        this.genericDAO = genericDAO;
    }

    public void setAgentService(IAgentService agentService) {
        this.agentService = agentService;
    }

}
