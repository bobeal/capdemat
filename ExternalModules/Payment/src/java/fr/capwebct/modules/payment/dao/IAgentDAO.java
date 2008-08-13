package fr.capwebct.modules.payment.dao;

import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.Agent;

public interface IAgentDAO extends IGenericDAO<Agent, Long> {

    public Agent findByLogin(final String login) throws DataAccessException;
}