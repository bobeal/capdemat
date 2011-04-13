package fr.cg95.cvq.dao.authority.hibernate;

import java.util.List;

import org.hibernate.Query;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.dao.authority.IAgentDAO;
import fr.cg95.cvq.dao.jpa.JpaTemplate;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;


/**
 * Implementation of the {@link IAgentDAO} interface.
 *
 * @author bor@zenexity.fr
 */
public class AgentDAO extends JpaTemplate<Agent,Long> implements IAgentDAO {

    public boolean exists(Long id) {
        Query query = HibernateUtil.getSession()
            .createQuery("from Agent agent where agent.id = :id ")
            .setLong("id", id.longValue());
        return query.uniqueResult() != null;
    }

    public Agent findByLogin(final String login) {
        Query query = HibernateUtil.getSession()
            .createQuery("from Agent agent where agent.login = :login ")
            .setString("login", login);
        return (Agent) query.uniqueResult(); 
    }
    
    public List listAll() {

        StringBuffer sb = new StringBuffer();
        sb.append("from Agent as agent order by agent.lastName asc");

        return HibernateUtil.getSession().createQuery(sb.toString()).list();
    }
}
