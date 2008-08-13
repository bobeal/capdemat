package fr.cg95.cvq.dao.authority.hibernate;

import java.util.List;

import org.hibernate.Query;
import fr.cg95.cvq.business.authority.LocalAuthority;
import fr.cg95.cvq.dao.authority.ILocalAuthorityDAO;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;

/**
 * The "LocalAuthority" service Hibernate implementation. This class is
 * responsible for data access logic functions
 * 
 * @author bor@zenexity.fr
 */
public class LocalAuthorityDAO extends GenericDAO implements ILocalAuthorityDAO {

    public LocalAuthorityDAO() {
        super();
    }

    public LocalAuthority findByName(final String name) {
        Query query = HibernateUtil.getSession()
            .createQuery("from LocalAuthority la where la.name like lower(:name) ")
            .setString("name", name);
        // .setCacheable(true)
        // .setCacheRegion("query.LocalAuthority");
        return (LocalAuthority) query.uniqueResult();
    }
}
