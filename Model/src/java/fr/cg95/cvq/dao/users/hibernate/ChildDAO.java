package fr.cg95.cvq.dao.users.hibernate;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.TemporalType;

import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.UserState;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.jpa.JpaUtil;
import fr.cg95.cvq.dao.users.IChildDAO;

/**
 * The "Child" service Hibernate implementation. This class is responsible for
 * data access logic functions
 * 
 * @author bor@zenexity.fr
 */
public class ChildDAO extends IndividualDAO implements IChildDAO {

    @Override
    public List<Child> findDuplicates(Map<String,Object> parameters) {
        return JpaUtil.getEntityManager().createQuery("from Child c where" +
                    " lower(c.firstName) = lower(:firstName) and lower(c.lastName) = lower(:lastName)" +
                    " and c.birthDate = :birthDate " +
                    " and c.homeFolder.id = :homeFolderId", Child.class)
                    .setParameter("firstName", parameters.get("firstName"))
                    .setParameter("lastName", parameters.get("lastName"))
                    .setParameter("birthDate", (Date) parameters.get("birthDate"), TemporalType.DATE)
                    .setParameter("homeFolderId", parameters.get("homeFolderId"))
                    .getResultList();
    }
    
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
