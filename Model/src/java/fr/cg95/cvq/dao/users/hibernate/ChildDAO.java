package fr.cg95.cvq.dao.users.hibernate;

import java.util.List;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.UserState;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.users.IChildDAO;

/**
 * The "Child" service Hibernate implementation. This class is responsible for
 * data access logic functions
 * 
 * @author bor@zenexity.fr
 */
public class ChildDAO extends IndividualDAO implements IChildDAO {

    static Logger logger = Logger.getLogger(ChildDAO.class);

    public List<Child> listChildrenByHomeFolder(final Long homeFolderId, UserState... states) {
        String hql = "from Child as child"
            + " where child.homeFolder.id = :homeFolderId"
            + " and child.state in (:states)";
        return HibernateUtil.getSession()
            .createQuery(hql)
            .setParameter("homeFolderId", homeFolderId.longValue())
            .setParameterList("states", states.length > 0 ? states : UserState.activeStates)
            .list();
    }
}
