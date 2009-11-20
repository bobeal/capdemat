package fr.cg95.cvq.dao.external.hibernate;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import fr.cg95.cvq.business.external.ExternalServiceTrace;
import fr.cg95.cvq.dao.external.IExternalServiceTraceDAO;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.util.Critere;

/**
 * @author jsb@zenexity.fr
 *
 */
public final class ExternalServiceTraceDAO extends GenericDAO implements IExternalServiceTraceDAO {

    @SuppressWarnings("unchecked")
    public List<ExternalServiceTrace> get(Set<Critere> criteriaSet, String sort,
        String dir, int count, int offset) {
        Criteria criteria = HibernateUtil.getSession().createCriteria(ExternalServiceTrace.class);
        for (Critere critere : criteriaSet) {
            criteria.add(critere.compose());
        }
        if (sort == null || sort.trim().isEmpty())
            sort = ExternalServiceTrace.SEARCH_BY_DATE;
        if ("desc".equals(dir)) criteria.addOrder(Order.desc(sort));
        else criteria.addOrder(Order.asc(sort));
        if (count > 0)
            criteria.setMaxResults(count);
        criteria.setFirstResult(offset);
        return (List<ExternalServiceTrace>)criteria.list();
    }

    public Long getCount(Set<Critere> criteriaSet) {
        Criteria criteria = HibernateUtil.getSession().createCriteria(ExternalServiceTrace.class);
        for (Critere critere : criteriaSet) {
            criteria.add(critere.compose());
        }
        criteria.setProjection(Projections.rowCount());
        return new Long((Integer)criteria.list().get(0));
    }
}
