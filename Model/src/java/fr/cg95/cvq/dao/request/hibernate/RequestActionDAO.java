package fr.cg95.cvq.dao.request.hibernate;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import fr.cg95.cvq.business.request.RequestAction;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.request.IRequestActionDAO;
import fr.cg95.cvq.util.Critere;

/**
 * Implementation of the {@link IRequestActionDAO} interface.
 * 
 * @author jsb@zenexity.fr
 */
public class RequestActionDAO extends GenericDAO implements IRequestActionDAO {

    @Override
    @SuppressWarnings("unchecked")
    public List<RequestAction> get(Set<Critere> criteriaSet, String sort,
        String dir, int count, int offset) {
        Criteria criteria = HibernateUtil.getSession().createCriteria(RequestAction.class);
        for (Critere critere : criteriaSet) {
            criteria.add(critere.compose());
        }
        if (sort == null || sort.trim().isEmpty())
            sort = RequestAction.SEARCH_BY_DATE;
        if ("desc".equals(dir))
            criteria.addOrder(Order.desc(sort));
        else
            criteria.addOrder(Order.asc(sort));
        if (count > 0)
            criteria.setFetchSize(count);
        criteria.setFirstResult(offset);
        return (List<RequestAction>)criteria.list();
    }

    public Long getCount(Set<Critere> criteriaSet) {
        Criteria criteria = HibernateUtil.getSession().createCriteria(RequestAction.class);
        for (Critere critere : criteriaSet) {
            criteria.add(critere.compose());
        }
        criteria.setProjection(Projections.rowCount());
        return ((Integer)criteria.list().get(0)).longValue();
    }
}
