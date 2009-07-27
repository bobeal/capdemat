package fr.capwebct.modules.payment.service.impl;

import java.util.List;

import fr.capwebct.modules.payment.business.Agent;
import fr.capwebct.modules.payment.dao.IAgentDAO;
import fr.capwebct.modules.payment.security.SecurityContext;
import fr.capwebct.modules.payment.service.IAgentService;

public class AgentService implements IAgentService {

    private IAgentDAO agentDAO;
    private String logoutUrl;
    
    public Agent getAgentByLogin(String login) {
        return agentDAO.findByLogin(login);
    }

    public void modifyAgent(Agent agent) {
        agentDAO.update(agent);
    }

    public void saveAgent(Agent agent) {
        agentDAO.create(agent);
    }

    public void updateProfile(Agent agent, List<String> newGroups) {
        for (String newGroup : newGroups) {
            if (SecurityContext.getAdministratorGroups().contains(newGroup)) {
                agent.setIsAdmin(true);
                agentDAO.update(agent);
            }
        }
    }

    public void setAgentDAO(IAgentDAO agentDAO) {
        this.agentDAO = agentDAO;
    }

    public void setLogoutUrl(String logoutUrl) {
        this.logoutUrl = logoutUrl;
    }

    public String getLogoutUrl() {
        return logoutUrl;
    }
}
