package fr.cg95.cvq.dao.authority.hibernate;

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

    public LocalAuthority findByName(final String name) {
        Query query = HibernateUtil.getSession()
            .createQuery("from LocalAuthority la where la.name like lower(:name)")
            .setString("name", name);
        return (LocalAuthority) query.uniqueResult();
    }
}
