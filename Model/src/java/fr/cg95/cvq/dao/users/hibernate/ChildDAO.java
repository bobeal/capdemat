package fr.cg95.cvq.dao.users.hibernate;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.ChildLegalResponsible;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.users.IChildDAO;
import fr.cg95.cvq.util.Critere;

/**
 * The "Child" service Hibernate implementation. This class is responsible for
 * data access logic functions
 * 
 * @author bor@zenexity.fr
 */
public class ChildDAO extends IndividualDAO implements IChildDAO {

    static Logger logger = Logger.getLogger(ChildDAO.class);

    public ChildDAO() {
        super();
    }

    public Child findByBadgeNumber(String number) {
        return (Child) HibernateUtil.getSession()
            .createQuery("from Child child where child.badgeNumber = :number")
            .setString("number", number)
            .uniqueResult();
    }

    public List listByHomeFolder(final Long homeFolderId) {
        Criteria crit = HibernateUtil.getSession().createCriteria(Child.class);
        crit.createCriteria("homeFolder").add(
                Critere.compose("id", homeFolderId, Critere.EQUALS));
        crit.addOrder(Order.asc("id"));
        return crit.list();
    }
    
    public List<ChildLegalResponsible> listChildLegalResponsibles(final Long id) {
        return HibernateUtil.getSession()
                .createQuery("from ChildLegalResponsible clr where clr.child.id = :childId")
                .setLong("childId", id)
                .list();
    }
}
