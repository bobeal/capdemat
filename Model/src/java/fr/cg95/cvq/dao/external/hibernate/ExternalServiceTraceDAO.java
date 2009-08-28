package fr.cg95.cvq.dao.external.hibernate;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

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
        String dir) {
        Criteria criteria = HibernateUtil.getSession().createCriteria(ExternalServiceTrace.class);
        for (Critere critere : criteriaSet) {
            criteria.add(critere.compose());
        }
        if (sort == null || sort.trim().isEmpty())
            sort = ExternalServiceTrace.SEARCH_BY_DATE;
        if ("desc".equals(dir)) criteria.addOrder(Order.desc(sort));
        else criteria.addOrder(Order.asc(sort));
        return (List<ExternalServiceTrace>)criteria.list();
    }
}
