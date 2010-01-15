package fr.cg95.cvq.dao.external.hibernate;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.type.Type;

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

    @Override
    @SuppressWarnings("unchecked")
    public List<ExternalServiceTrace> get(Set<Critere> criteriaSet, String sort,
        String dir, int count, int offset, boolean lastOnly) {
        StringBuffer sb = new StringBuffer();
        sb.append("select * from external_service_traces");
        if (lastOnly) {
            List<String> keys = HibernateUtil.getSession().createQuery("select distinct key from ExternalServiceTrace").list();
            List<String> ids = new ArrayList<String>(keys.size());
            Query query;
            for (String key : keys) {
                query = HibernateUtil.getSession().createQuery("select id from ExternalServiceTrace where key = :key order by date desc");
                query.setString("key", key);
                query.setMaxResults(1);
                ids.add(((Long)query.uniqueResult()).toString());
            }
            sb.append(" where id in (");
            sb.append(StringUtils.join(ids.toArray(), ", "));
            sb.append(')');
        } else {
            sb.append(" where 1 = 1 ");
        }
        List<Object> parametersValues = new ArrayList<Object>();
        List<Type> parametersTypes = new ArrayList<Type>();
        for (Critere searchCrit : criteriaSet) {
            sb.append(" and ").append(searchCrit.getAttribut()).append(searchCrit.getSqlComparatif()).append(" ?");
            if (ExternalServiceTrace.SEARCH_BY_DATE.equals(searchCrit.getAttribut())) {
                parametersValues.add(searchCrit.getDateValue());
                parametersTypes.add(Hibernate.TIMESTAMP);
            } else if (ExternalServiceTrace.SEARCH_BY_ID.equals(searchCrit.getAttribut())) {
                parametersValues.add(searchCrit.getLongValue());
                parametersTypes.add(Hibernate.LONG);
            } else if (ExternalServiceTrace.SEARCH_BY_KEY.equals(searchCrit.getAttribut())) {
                parametersValues.add(searchCrit.getSqlStringValue());
                parametersTypes.add(Hibernate.STRING);
            } else if (ExternalServiceTrace.SEARCH_BY_KEY_OWNER.equals(searchCrit.getAttribut())) {
                parametersValues.add(searchCrit.getSqlStringValue());
                parametersTypes.add(Hibernate.STRING);
            } else if (ExternalServiceTrace.SEARCH_BY_MESSAGE.equals(searchCrit.getAttribut())) {
                parametersValues.add(searchCrit.getSqlStringValue());
                parametersTypes.add(Hibernate.STRING);
            } else if (ExternalServiceTrace.SEARCH_BY_NAME.equals(searchCrit.getAttribut())) {
                parametersValues.add(searchCrit.getSqlStringValue());
                parametersTypes.add(Hibernate.STRING);
            } else if (ExternalServiceTrace.SEARCH_BY_STATUS.equals(searchCrit.getAttribut())) {
                parametersValues.add(searchCrit.getValue().toString());
                parametersTypes.add(Hibernate.STRING);
            } else if (ExternalServiceTrace.SEARCH_BY_SUBKEY.equals(searchCrit.getAttribut())) {
                parametersValues.add(searchCrit.getSqlStringValue());
                parametersTypes.add(Hibernate.STRING);
            }
        }
        sb.append(" order by ");
        if (sort != null) {
            sb.append(sort);
        } else {
            sb.append(ExternalServiceTrace.SEARCH_BY_DATE);
        }
        if (dir != null && dir.equals("desc"))
            sb.append(" desc");
        else sb.append(" asc");
        Query query = HibernateUtil.getSession().createSQLQuery(sb.toString()).addEntity(ExternalServiceTrace.class);
        query.setParameters(parametersValues.toArray(), parametersTypes.toArray(new Type[0]));
        if (count > 0)
            query.setMaxResults(count);
        query.setFirstResult(offset);
        return (List<ExternalServiceTrace>)query.list();
    }

    @Override
    public Long getCount(Set<Critere> criteriaSet, boolean lastOnly) {
        StringBuffer sb = new StringBuffer();
        sb.append("select count(*) from external_service_traces");
        if (lastOnly) {
            List<String> keys = HibernateUtil.getSession().createQuery("select distinct key from ExternalServiceTrace").list();
            List<String> ids = new ArrayList<String>(keys.size());
            Query query;
            for (String key : keys) {
                query = HibernateUtil.getSession().createQuery("select id from ExternalServiceTrace where key = :key order by date desc");
                query.setString("key", key);
                query.setMaxResults(1);
                ids.add(((Long)query.uniqueResult()).toString());
            }
            sb.append(" where id in (");
            sb.append(StringUtils.join(ids.toArray(), ", "));
            sb.append(')');
        } else {
            sb.append(" where 1 = 1 ");
        }
        List<Object> parametersValues = new ArrayList<Object>();
        List<Type> parametersTypes = new ArrayList<Type>();
        for (Critere searchCrit : criteriaSet) {
            sb.append(" and ").append(searchCrit.getAttribut()).append(searchCrit.getSqlComparatif()).append(" ?");
            if (ExternalServiceTrace.SEARCH_BY_DATE.equals(searchCrit.getAttribut())) {
                parametersValues.add(searchCrit.getDateValue());
                parametersTypes.add(Hibernate.TIMESTAMP);
            } else if (ExternalServiceTrace.SEARCH_BY_ID.equals(searchCrit.getAttribut())) {
                parametersValues.add(searchCrit.getLongValue());
                parametersTypes.add(Hibernate.LONG);
            } else if (ExternalServiceTrace.SEARCH_BY_KEY.equals(searchCrit.getAttribut())) {
                parametersValues.add(searchCrit.getSqlStringValue());
                parametersTypes.add(Hibernate.STRING);
            } else if (ExternalServiceTrace.SEARCH_BY_KEY_OWNER.equals(searchCrit.getAttribut())) {
                parametersValues.add(searchCrit.getSqlStringValue());
                parametersTypes.add(Hibernate.STRING);
            } else if (ExternalServiceTrace.SEARCH_BY_MESSAGE.equals(searchCrit.getAttribut())) {
                parametersValues.add(searchCrit.getSqlStringValue());
                parametersTypes.add(Hibernate.STRING);
            } else if (ExternalServiceTrace.SEARCH_BY_NAME.equals(searchCrit.getAttribut())) {
                parametersValues.add(searchCrit.getSqlStringValue());
                parametersTypes.add(Hibernate.STRING);
            } else if (ExternalServiceTrace.SEARCH_BY_STATUS.equals(searchCrit.getAttribut())) {
                parametersValues.add(searchCrit.getValue().toString());
                parametersTypes.add(Hibernate.STRING);
            } else if (ExternalServiceTrace.SEARCH_BY_SUBKEY.equals(searchCrit.getAttribut())) {
                parametersValues.add(searchCrit.getSqlStringValue());
                parametersTypes.add(Hibernate.STRING);
            }
        }
        Query query = HibernateUtil.getSession().createSQLQuery(sb.toString());
        query.setParameters(parametersValues.toArray(), parametersTypes.toArray(new Type[0]));
        return ((BigInteger)query.uniqueResult()).longValue();
    }
}
