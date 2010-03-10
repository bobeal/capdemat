package fr.cg95.cvq.dao.hibernate;

import java.util.List;
import java.util.Map;

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
