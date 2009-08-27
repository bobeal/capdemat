package fr.cg95.cvq.dao.authority.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.type.Type;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.dao.authority.IAgentDAO;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.util.Critere;

/**
 * Implementation of the {@link IAgentDAO} interface.
 *
 * @author bor@zenexity.fr
 */
public class AgentDAO extends GenericDAO implements IAgentDAO {

    private static Logger logger = Logger.getLogger(AgentDAO.class);

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

    @SuppressWarnings("unchecked")
    public List<Agent> search(final Set<Critere> criteria) {

        if (criteria.isEmpty())
            return listAll();

        StringBuffer sb = new StringBuffer();
        sb.append("from Agent as agent");

        List<Type> typeList = new ArrayList<Type>();
        List<Object> objectList = new ArrayList<Object>();

        // go through all the criteria and create the query
        for (Critere searchCrit : criteria) {
            if (searchCrit.getAttribut().equals(Agent.SEARCH_BY_CATEGORY_ID)) {
                sb.append(" join agent.categoriesRoles categoriesRoles where categoriesRoles.category " 
                        + searchCrit.getComparatif() + " ?");
                objectList.add(searchCrit.getValue());
                typeList.add(Hibernate.LONG);
            } else {
                logger.warn("Unknown search criteria for Agent object");
                return listAll();
            }
        }

        sb.append(" order by agent.login asc");

        Type[] typeTab = typeList.toArray(new Type[0]);
        Object[] objectTab = objectList.toArray(new Object[0]);

        return (List<Agent>)HibernateUtil.getSession().createQuery(sb.toString())
            .setParameters(objectTab, typeTab).list();
    }

    @SuppressWarnings("unchecked")
    public List<Agent> listAll() {
        return (List<Agent>)HibernateUtil.getSession()
            .createQuery("from Agent as agent order by agent.lastName asc")
            .list();
    }
}
