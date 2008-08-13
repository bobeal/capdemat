package fr.cg95.cvq.dao.authority.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import fr.cg95.cvq.business.authority.School;
import fr.cg95.cvq.dao.authority.ISchoolDAO;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.util.Critere;

/**
 * The "School" service Hibernate implementation. This class is responsible for
 * data access logic functions
 * 
 * @author bor@zenexity.fr
 */
public class SchoolDAO extends GenericDAO implements ISchoolDAO {

    public SchoolDAO() {
        super();
    }

    public School findByName(final String name) {
        Criteria crit = HibernateUtil.getSession().createCriteria(School.class);
        crit.add(Critere.compose("name", name, Critere.EQUALS));
        return (School) crit.uniqueResult();
    }

    public List listAll() {
        StringBuffer sb = new StringBuffer();
        sb.append("from School as school");
        return HibernateUtil.getSession().createQuery(sb.toString()).list();
    }
}
