package fr.cg95.cvq.dao.request.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import fr.cg95.cvq.business.request.GlobalRequestTypeConfiguration;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.business.request.DisplayGroup;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.request.IRequestTypeDAO;
import fr.cg95.cvq.util.Critere;

/**
 * Hibernate implementation of the {@link IRequestTypeDAO} interface.
 * 
 * @author bor@zenexity.fr
 */
public class RequestTypeDAO extends GenericDAO implements IRequestTypeDAO {

    public List<RequestType> listAll() {
        StringBuffer sb = new StringBuffer()
            .append("from RequestType as requestType");
        return HibernateUtil.getSession().createQuery(sb.toString()).list();
    }
    
    public List<DisplayGroup> listAllDisplayGroup() {
        StringBuffer sb = new StringBuffer().append("from DisplayGroup as displayGroup");
        
        //noinspection unchecked
        return (List<DisplayGroup>)HibernateUtil.getSession().createQuery(sb.toString()).list();
    }
    
    public List<RequestType> listByCategoryAndState(Set<Critere> criteriaSet) {
        Criteria crit = HibernateUtil.getSession().createCriteria(RequestType.class);
        Criteria categoryCriteria = null;
        for (Critere critere : criteriaSet) {
            if (RequestType.SEARCH_BY_CATEGORY_ID.equals(critere.getAttribut())) {
                if (categoryCriteria == null) {
                    categoryCriteria = crit.createCriteria("category");
                }
                categoryCriteria.add(Critere.compose("id", critere.getValue(), Critere.EQUALS));
            } else if ("belongsToCategory".equals(critere.getAttribut())) {
                if (categoryCriteria == null) {
                    categoryCriteria = crit.createCriteria("category");
                }
                List<Long> categoryIds = new ArrayList<Long>();
                for (String categoryId : ((String)critere.getValue()).split(",")) {
                    categoryIds.add(Long.valueOf(categoryId.substring(1, categoryId.length() - 1)));
                }
                categoryCriteria.add(Restrictions.in("id", categoryIds));
            } else if (RequestType.SEARCH_BY_STATE.equals(critere.getAttribut())) {
                crit.add(Critere.compose("active", critere.getValue(), Critere.EQUALS));
            }
        }
        return crit.list();
    }

    public RequestType findByLabel(final String requestTypeLabel) {
        Criteria crit = HibernateUtil.getSession().createCriteria(RequestType.class);
        crit.add(Critere.compose("label", requestTypeLabel, Critere.EQUALS));
        return (RequestType) crit.uniqueResult();
    }

    public GlobalRequestTypeConfiguration getGlobalRequestTypeConfiguration() {
        return (GlobalRequestTypeConfiguration)HibernateUtil.getSession()
            .createCriteria(GlobalRequestTypeConfiguration.class).uniqueResult();
    }
}
