package fr.cg95.cvq.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;

public class SimpleQuery {

    private Criteria criteria;
    public SimpleQuery(final Class<?> clazz) {
        criteria = HibernateUtil.getSession().createCriteria(clazz);
    }

    public SimpleQuery and(String name, Object value) {
        criteria.add(Expression.eq(name, value));
        return this;
    }

    public <T> List<T> list() {
        return (List<T>) criteria.list();
    }

    public <T> T unique() {
        return (T) criteria.uniqueResult();
    }

    public SimpleQuery max(Integer max) {
        if (max != null)
            criteria.setMaxResults(max);
        return this;
    }

    public SimpleQuery offset(Integer offset) {
        if (offset != null)
            criteria.setFirstResult(offset);
        return this;
    }
 }
