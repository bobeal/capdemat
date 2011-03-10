package fr.cg95.cvq.dao.hibernate;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.ObjectDeletedException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.criterion.Expression;
import org.hibernate.type.Type;

import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;

/**
 *
 * @author bor@zenexity.fr
 */
public class GenericDAO implements IGenericDAO {

    @Override
    public Object findById(final Class<?> clazz, final Long id)
        throws CvqObjectNotFoundException {
        Object object = null;
        try {
            object = HibernateUtil.getSession().load(clazz, id);
        } catch (ObjectNotFoundException onfe) {
            throw new CvqObjectNotFoundException("Object of class "
                + clazz.getName() + " with id " + id + " not found");
        } catch (ObjectDeletedException ode) {
            // happens during unit tests
            throw new CvqObjectNotFoundException("Object of class "
                + clazz.getName() + " with id " + id + " has been deleted");
        }
        if (!clazz.isAssignableFrom(object.getClass())) {
            // why does session.load() returns the object if it doesn't match desired class ??
            throw new CvqObjectNotFoundException("Object of class "
                + clazz.getName() + " with id " + id + " not found");
        }
        return object;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T findUniqueBySimpleProperty(final Class<T> clazz, final String propertyName, 
            final Object propertyValue) {
        return (T) HibernateUtil.getSession().createCriteria(clazz)
            .add(Expression.eq(propertyName, propertyValue)).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> findBySimpleProperty(Class<T> clazz, String propertyName,
            Object propertyValue) {
        return (List<T>) HibernateUtil.getSession().createCriteria(clazz)
            .add(Expression.eq(propertyName, propertyValue)).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> findByProperties(final Class<T> clazz, final Map<String,Object> properties) {
        Criteria criteria = HibernateUtil.getSession().createCriteria(clazz);
        for (Iterator i = properties.keySet().iterator() ; i.hasNext() ;) {
            String propertyName = (String) i.next();
            criteria.add(Expression.eq(propertyName, properties.get(propertyName)));
        }
        return (List<T>) criteria.list();
    }

    @Override
     public SimpleQuery simpleSelect(final Class<?> clazz) {
         return new SimpleQuery(clazz);
     }

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

    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> all(Class<T> clazz) {
        return (List<T>) HibernateUtil.getSession().createCriteria(clazz).list();
    }

    @Override
    public Long create(final Object object) {
        return (Long) HibernateUtil.getSession().save(object);
    }

    @Override
    public <T> T saveOrUpdate(final T object) {
        HibernateUtil.getSession().saveOrUpdate(object);
        return object;
    }

    @Override
    public void update(final Object object) {
        HibernateUtil.getSession().update(object);
    }

    @Override
    public void delete(final Object object) {
        HibernateUtil.getSession().delete(object);
    }

    /**
     * Builds sort hql statement, must be called after main(select) statement created
     * 
     * @param sortParams Parameters map where key is fileld name (ex: [Alias].[FiledName]) and value is order direction (DESC/ASC), default ASC
     * @param sb Buffer that contains first part of statement
     */
    protected void buildSort(Map<String,String> sortParams, StringBuffer sb) {
        String query = "";
        if(sortParams == null) return;
        for(String key : sortParams.keySet()) {
            query += String.format(" %1$s %2$s ,",key,
                sortParams.get(key)!=null ? sortParams.get(key) : "asc");
        }
        if(query.length()>0) { 
            query = "order by "+query;
            sb.append(query.substring(0,query.length()-2));
        }
    }

    protected <T extends List> T execute(String hql, List<Type> typeList, List<Object> valueList, 
                                         Integer max, Integer offset) {
        Type[] types = typeList.toArray(new Type[typeList.size()]);
        Object[] values = valueList.toArray(new Object[valueList.size()]);
        
        Query query = HibernateUtil.getSession().createQuery(hql);
        if(max != null) {
            query.setMaxResults(max);
            query.setFirstResult(offset != null ? offset : 0);
        }
        
        //noinspection unchecked
        return (T) query.setParameters(values, types).list();
    }

    protected <T extends Number> T execute(String hql, List<Type> typeList, List<Object> valueList) {
        Type[] types = typeList.toArray(new Type[typeList.size()]);
        Object[] values = valueList.toArray(new Object[valueList.size()]);
        
        Query query = HibernateUtil.getSession().createQuery(hql).setParameters(values, types);
        
        //noinspection unchecked
        return (T)query.iterate().next();
    }
}
