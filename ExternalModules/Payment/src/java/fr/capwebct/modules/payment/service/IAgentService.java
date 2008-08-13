package fr.capwebct.modules.payment.service;

import java.util.List;

import fr.capwebct.modules.payment.business.Agent;

public interface IAgentService {

    Agent getAgentByLogin(final String login);
    
    void saveAgent(Agent agent);
    
    void modifyAgent(Agent agent);
    
    void updateProfile(Agent agent, List<String> newGroups);
}
