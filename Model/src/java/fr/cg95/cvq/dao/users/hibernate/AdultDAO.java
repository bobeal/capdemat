package fr.cg95.cvq.dao.users.hibernate;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.UserState;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.users.IAdultDAO;
import fr.cg95.cvq.util.Critere;

/**
 * The "Adult" service Hibernate implementation. This class is responsible for
 * data access logic functions
 * 
 * @author bor@zenexity.fr
 */
public class AdultDAO extends IndividualDAO implements IAdultDAO {

    public AdultDAO() {
        super();
    }

    @Override
    public Adult findByLogin(String login) {
        Criteria crit = HibernateUtil.getSession().createCriteria(Adult.class);
        crit.add(Critere.compose("login", login, Critere.EQUALS));
        return (Adult)crit.uniqueResult();
    }

    public List<Adult> listAdultsByHomeFolder(final Long homeFolderId, UserState... states) {
        String hql = "from Adult as adult"
            + " where adult.homeFolder.id = :homeFolderId"
            + " and adult.state in (:states)";
        return HibernateUtil.getSession()
            .createQuery(hql)
            .setParameter("homeFolderId", homeFolderId.longValue())
            .setParameterList("states", states.length > 0 ? states : UserState.activeStates)
            .list();
    }

    @Override
    public List<Adult> matchAdults (Map<String,String> parameters) {
        Query q = HibernateUtil.getSession().createQuery(
                "from Adult a where" +
                    " (lower(a.firstName) = lower(:firstName) and lower(a.lastName) = lower(:lastName))" +
                    " or lower(a.email) = lower(:email) or lower(a.homePhone) = lower(:homePhone)" +
                    " or lower(:address) like '%'|| lower(a.address.streetName) || '%'"
        );
        return q.setProperties(parameters).list();
    }

    @Override
    public List<Adult> findDuplicates(Map<String,String> parameters) {
        Query q = HibernateUtil.getSession().createQuery(
                "from Adult a where" +
                    " (lower(a.firstName) = lower(:firstName) and lower(a.lastName) = lower(:lastName))" +
                    " and ( lower(a.email) = lower(:email) " +
                    " or lower(:address) like '%'|| lower(a.address.streetName) || '%' )"
        );

        return q.setProperties(parameters).list();
    }

    @Override
    public Long countDuplicates() {
        return (Long)HibernateUtil.getSession()
            .createQuery("select count(*) from Adult a where a.duplicateAlert is true and homeFolder != null")
            .iterate().next();
    }

    @Override
    public List<Adult> listDuplicates(int max) {
        Query query = HibernateUtil.getSession()
            .createQuery("from Adult a where a.duplicateAlert is true and homeFolder != null " + 
                    "and homeFolder.temporary is false order by a.lastModificationDate");
        if (max > 0)
            query.setMaxResults(max);
        return query.list();
    }
}
