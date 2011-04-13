package fr.cg95.cvq.dao.hibernate;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernateEntityManager;
import org.hibernate.type.Type;

import fr.cg95.cvq.dao.jpa.JpaUtil;

/**
 * Only kept for backward compatibility, use JpaUtil instead.
 * @author aca
 */
public class HibernateUtil {
    /**
     * Returns the SessionFactory used for this static class.
     * 
     * @deprecated use JpaUtil instead
     * @return SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        return getSession().getSessionFactory();
    }

    /**
     * Retrieves the current Session local to the thread.
     * <p/>
     * If no Session is open, opens a new Session for the running thread.
     * 
     * @deprecated
     * @return Session
     */
    public static Session getSession() {
        HibernateEntityManager hem = (HibernateEntityManager) JpaUtil.getEntityManager();
        return hem.getSession();
    }

    /**
     * Closes the Session local to the thread.
     * @deprecated use JpaUtil instead
     */
    public static void closeSession() {
        JpaUtil.close();
    }

    /**
     * Start a new database transaction.
     * @deprecated use JpaUtil instead
     */
    public static void beginTransaction() {
        JpaUtil.beginTransaction();
    }

    /**
     * Commit the database transaction.
     * @deprecated use JpaUtil instead
     */
    public static void commitTransaction() {
        JpaUtil.commitTransaction();
    }

    /**
     * Rollback the database transaction.
     * @deprecated use JpaUtil instead
     */
    public static void rollbackTransaction() {
        JpaUtil.rollbackTransaction();
    }

    /**
     * Builds sort hql statement, must be called after main(select) statement created
     *
     * @param sortParams Parameters map where key is fileld name (ex: [Alias].[FiledName]) and value is order direction (DESC/ASC), default ASC
     * @param sb Buffer that contains first part of statement
     * @deprecated
     */
    @Deprecated
    public void buildSort(Map<String,String> sortParams, StringBuffer sb) {
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

    /**
     * @deprecated
     */
    @Deprecated
    public <T extends List> T execute(String hql, List<Type> typeList, List<Object> valueList,
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

    /**
     * @deprecated
     */
    @Deprecated
    public <T extends Number> T execute(String hql, List<Type> typeList, List<Object> valueList) {
        Type[] types = typeList.toArray(new Type[typeList.size()]);
        Object[] values = valueList.toArray(new Object[valueList.size()]);

        Query query = HibernateUtil.getSession().createQuery(hql).setParameters(values, types);

        //noinspection unchecked
        return (T)query.iterate().next();
    }
}
