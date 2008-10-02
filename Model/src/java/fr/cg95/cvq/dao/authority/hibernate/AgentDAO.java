package fr.cg95.cvq.dao.authority.hibernate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.type.Type;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.dao.authority.IAgentDAO;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.permission.CvqPermissionException;
import fr.cg95.cvq.permission.PrivilegeDescriptor;
import fr.cg95.cvq.util.Critere;


/**
 * The "Agent" service Hibernate implementation.
 * This class is responsible for data access logic functions
 *
 * @author bor@zenexity.fr
 */
public class AgentDAO extends GenericDAO implements IAgentDAO {

    private static Logger logger = Logger.getLogger(AgentDAO.class);

    public AgentDAO() {
        super();
    }

    public boolean exists(Long id) {
        Query query = HibernateUtil.getSession()
            .createQuery("from Agent agent where agent.id = :id ")
            .setLong("id", id.longValue());
        if (query.uniqueResult() == null)
            return false;
        else
            return true;
    }

    public Agent findByLogin(final String login) {
        // Since this function is used before an agent logs in
        // we can't do an access control check here

        Query query = HibernateUtil.getSession()
            .createQuery("from Agent agent where agent.login = :login ")
            .setString("login", login);
//          .setCacheable(true)
//          .setCacheRegion("query.AgentByLogin");
        
        return (Agent) query.uniqueResult(); 
    }
    
    public List search(final Set criteria) throws CvqPermissionException {

		cvqPolicy.check(new Agent(), PrivilegeDescriptor.READ);

        if (criteria.isEmpty())
            return listAll();

        StringBuffer sb = new StringBuffer();
        sb.append("from Agent as agent");

        Iterator critIt = criteria.iterator();
        List typeList = new ArrayList();
        List objectList = new ArrayList();

        // go through all the criteria and create the query
        while (critIt.hasNext()) {
            Critere searchCrit = (Critere) critIt.next();
            if (searchCrit.getAttribut().equals("categoryId")) {
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

        Type[] typeTab = (Type[]) typeList.toArray(new Type[0]);
        Object[] objectTab = (Object[]) objectList.toArray(new Object[0]);
        
        return HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setParameters(objectTab, typeTab)
            .list(); 
    }

    public List listAll()  throws CvqPermissionException {

		cvqPolicy.check(new Agent(), PrivilegeDescriptor.READ);

        StringBuffer sb = new StringBuffer(100);
        sb.append("from Agent as agent order by agent.lastName asc");

        return HibernateUtil.getSession()
                .createQuery(sb.toString())
                .list();
    }

    public Long create(final Object object) throws CvqPermissionException {
        if (object instanceof Agent)
            cvqPolicy.check((Agent) object, PrivilegeDescriptor.ADMIN);

        return super.create(object);
    }

    public void update(final Object object) throws CvqPermissionException {
        if (object instanceof Agent)
            cvqPolicy.check((Agent) object, PrivilegeDescriptor.ADMIN);

        super.update(object);
    }

    public void delete(final Object object) throws CvqPermissionException {
        if (object instanceof Agent)
            cvqPolicy.check((Agent) object, PrivilegeDescriptor.ADMIN);

        super.delete(object);
    }
}
