package fr.cg95.cvq.dao.users.hibernate;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;

import fr.cg95.cvq.business.users.Adult;
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

    public List listAdultsByHomeFolder(final Long homeFolderId) {
        StringBuffer sb = new StringBuffer(100);
        sb.append("select adult from Adult as adult")
            .append(" join adult.homeFolder homeFolder")
            .append(" where homeFolder.id = ?");
        return HibernateUtil.getSession()
            .createQuery(sb.toString())
            .setLong(0, homeFolderId.longValue())
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
}
