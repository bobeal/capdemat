package fr.capwebct.modules.payment.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Property;
import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.Agent;
import fr.capwebct.modules.payment.dao.IAgentDAO;

public class AgentDAO extends GenericHibernateDAO<Agent, Long> implements IAgentDAO {

    public Agent findByLogin(String login) throws DataAccessException {
        
        if (login == null || login.equals(""))
            return null;
        
        List<Criterion> criterionList = new ArrayList<Criterion>();
        Property property = Property.forName("login");
        criterionList.add(property.eq(login));
        
        List<Agent> agents = findByCriteria(criterionList.toArray(new Criterion[] {}));
        if (agents == null || agents.isEmpty())
            return null;
        
        return agents.get(0);
    }
}
