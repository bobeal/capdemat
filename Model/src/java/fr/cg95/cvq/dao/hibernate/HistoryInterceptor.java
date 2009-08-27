package fr.cg95.cvq.dao.hibernate;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.HibernateException;
import org.hibernate.Interceptor;
import org.hibernate.Session;
import org.hibernate.collection.PersistentCollection;
import org.hibernate.type.Type;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.Historizable;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.users.HistoryEntry;

/**
 * Implementation of an Interceptor recording all changes on objects implementing the
 * {@link Historizable} interface in a separate table.
 * 
 * @author Wolfgang Jung (w.jung@micromata.de)
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class HistoryInterceptor extends EmptyInterceptor {

    private static Logger logger = Logger.getLogger(HistoryInterceptor.class);
    
    private ThreadLocal<Map<Object, Set<HistoryEntry>>> currentContextHistories = 
        new ThreadLocal<Map<Object, Set<HistoryEntry>>>();
    private ThreadLocal<Request> currentContextRequest = new ThreadLocal<Request>();
    private ThreadLocal<String> currentContextUser = new ThreadLocal<String>();
    private ThreadLocal<Session> currentContextSession = new ThreadLocal<Session>();
    private ThreadLocal<Boolean> currentContextStatus = new ThreadLocal<Boolean>();
    
    /**
     * Object formatter, should use something like
     * org.apache.log4j.spi.RendererSupport
     */
    private String format(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public HistoryInterceptor() {
    }

    public void setCurrentRequest(final Request request) {
        logger.debug("setCurrentRequest() setting current request : " + request);
        currentContextRequest.set(request);
        currentContextStatus.set(Boolean.TRUE);
    }

    public void resetCurrentRequest() {
        logger.debug("resetCurrentRequest() resetting current request");
        currentContextRequest.set(null);
    }
    
    public void setCurrentUser(final String userLogin) {
        logger.debug("setCurrentUser() setting current user login : " + userLogin);
        currentContextUser.set(userLogin);
    }
    
    public void resetCurrentUser() {
        logger.debug("resetCurrentUser() resetting current user login");
        currentContextUser.set(null);
    }

    public void setCurrentSession(Session session) {
        logger.debug("setCurrentSession() setting current session : " + session);
        currentContextSession.set(session);
    }
    
    public void resetCurrentSession() {
        logger.debug("resetCurrentSession() resetting current session");
        currentContextSession.set(null);
    }
    
    public void releaseInterceptor() {
        logger.debug("releaseInterceptor()");
        currentContextStatus.set(null);
    }
    
    private Set<HistoryEntry> getCurrentEntries(Object key) {
        if (currentContextHistories.get() == null) {
            Map<Object, Set<HistoryEntry>> histories = 
                new HashMap<Object, Set<HistoryEntry>>();
            currentContextHistories.set(histories);
        }
        
        Map<Object, Set<HistoryEntry>> histories = currentContextHistories.get();
        if (histories.get(key) == null) {
            Set<HistoryEntry> entries = new HashSet<HistoryEntry>();
            histories.put(key, entries);
        }
        
        return histories.get(key);
    }
    
    private void resetCurrentEntries() {
        currentContextHistories.set(null);
    }
    
    /**
     * Returns whether we have to log history changes for the given object. True
     * if :
     * <li>
     * <ul>
     * HistoryInterceptor service is enabled
     * <ul>
     * The current request (if there is one) asked for history logging
     * <ul>
     * The given object implements the Historizable interface </li>
     */
    public boolean doObjectHistorization(Object obj) {

        if (currentContextRequest.get() == null)
            return false;

        if (!(obj instanceof Historizable)) {
            return false;
        }

        return true;
    }

    /**
     * @see Interceptor#onLoad(java.lang.Object, java.io.Serializable,
     *      java.lang.Object[], java.lang.String[],
     *      org.hibernate.type.Type[])
     */
    @Override
    public boolean onLoad(Object obj, Serializable id, Object[] values, String[] properties,
            Type[] types) throws CallbackException {
        return false;
    }

    /**
     * Record the changes in the HashMap. Unfortunately, these changes can't be
     * done immediately (TransientObjectException), so they are recorded in a
     * seperate Set.
     * 
     * @see Interceptor#onFlushDirty(java.lang.Object, java.io.Serializable,
     *      java.lang.Object[], java.lang.Object[], java.lang.String[],
     *      org.hibernate.type.Type[])
     */
    @Override
    public boolean onFlushDirty(Object obj, Serializable id, Object[] newValues,
            Object[] oldValues, String[] properties, Type[] types) throws CallbackException {

        // logger.debug("onFlushDirty()");

        if (!doObjectHistorization(obj))
            return false;

//        logger.debug("Updating " + obj + " with id " + id + " new=" 
//                + Arrays.asList(newValues) + " old=" + Arrays.asList(oldValues) 
//                + "props=" + Arrays.asList(properties));

        // Won't work:
        // org.hibernate.TransientObjectException: object references an
        // unsaved
        // transient instance - save the transient instance before flushing:
        // de.micromata.hibernate.HistoryEntry
        // Set entries = h.getHistoryEntries();
        //
        // get the copy from the map
        
        Set<HistoryEntry> entries = getCurrentEntries(obj);
        for (int i = 0; i < properties.length; i++) {
            // Skip the historyEntries
            if (properties[i].equals("historyEntries") == true) {
                continue;
            }
            Object oldOne = oldValues[i];
            Object newOne = newValues[i];
            // Check for changes
            // Also check for newOne.equals("") because FrontOffice transforms
            // null values to empty strings !
            if (oldOne == null && (newOne == null || newOne.equals(""))) {
                continue;
            }
            if (newOne instanceof PersistentCollection) {
                // Collections must be compared against the snapshot
                PersistentCollection collection = (PersistentCollection) newValues[i];
                if (collection.isDirectlyAccessible() == false) {
                    continue;
                }
                // retrieve Snapshot
                oldOne = collection.getStoredSnapshot();
                if (oldOne instanceof Map && newOne instanceof Set) {
                    // a Set is internally stored as Map
                    oldOne = ((Map) oldOne).values();
                }

                // not interested in collections updates
                // continue;
            }
            if (oldOne != null && oldOne.equals(newOne) == true) {
                continue;
            }

            // Generate a new entry
            HistoryEntry entry = new HistoryEntry();
            entry.setUserName(currentContextUser.get());
            entry.setRequestId(currentContextRequest.get().getId());
            entry.setOperation("update");
            entry.setClazz(obj.getClass().getName());
            entry.setObjectId(((Historizable) obj).getId());
            entry.setProperty(properties[i]);
            entry.setOldValue(format(oldOne));
            entry.setNewValue(format(newOne));
            // logger.debug("Changed " + properties[i] + " from " + oldOne + "
            // to " + newOne);

            // and store it.
            entries.add(entry);
        }

        return false;
    }

    /**
     * Record the creation of the object.
     * 
     * @see org.hibernate.Interceptor#onSave(java.lang.Object,
     *      java.io.Serializable, java.lang.Object[], java.lang.String[],
     *      org.hibernate.type.Type[])
     * 
     */
    @Override
    public boolean onSave(Object obj, Serializable id, Object[] newValues, String[] properties,
            Type[] types) throws CallbackException {

        if (!doObjectHistorization(obj))
            return false;

        Historizable h = (Historizable) obj;
//        logger.debug("onSave() Inserting " + obj + " with id " + id + " new=" 
//                + Arrays.asList(newValues) + " props=" + Arrays.asList(properties));

        HistoryEntry entry = new HistoryEntry();
        entry.setUserName(currentContextUser.get());
        entry.setRequestId((currentContextRequest.get()).getId());
        entry.setOperation("created");
        entry.setClazz(obj.getClass().getName());
        entry.setObjectId(h.getId());

        getCurrentEntries(h).add(entry);
        logger.debug("onSave() Added history entry " + entry);
        return false;
    }

    @Override
    public void onDelete(Object obj, Serializable id, Object[] newValues, String[] properties,
            Type[] types) throws CallbackException {
    }

    @Override
    public void preFlush(Iterator it) throws CallbackException {
    }

    @Override
    public void postFlush(Iterator it) throws CallbackException {

        if (currentContextRequest.get() == null) {
//            logger.debug("postFlush() not in the context of an historizable action, returning");
            return;
        }
        
        Set<HistoryEntry> historyEntriesToCreate = new HashSet<HistoryEntry>();
        synchronized (it) {
            while (it.hasNext()) {
                Object obj = it.next();

                if (!doObjectHistorization(obj))
                    continue;
                
                Historizable h = (Historizable) obj;
                Set<HistoryEntry> newEntries = getCurrentEntries(h);
                if (newEntries == null) {
                    logger.debug("postFlush() no history entry for object");
                    continue;
                }
                logger.debug("postFlush() Dealing with " + obj + " (" 
                        + newEntries.size() + " entries)");
                historyEntriesToCreate.addAll(newEntries);
            }
        }

        if (historyEntriesToCreate.size() > 0) {
            Session tempSession = null;
            try {
                Session currentSession = HibernateUtil.getSession();
                tempSession = HibernateUtil.getSessionFactory().openSession(currentSession.connection());
                for (HistoryEntry object : historyEntriesToCreate) {
                    logger.debug("postFlush() saving " + object);
                    tempSession.save(object);
                    tempSession.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Unable to persist history entries !");
            } finally {
                try {
                    if (tempSession != null)
                        tempSession.close();
                } catch (HibernateException he) {
                    throw new RuntimeException("Error while closing session !");
                }
            }
        }

        if (currentContextStatus.get() == null) {
            logger.debug("postFlush() interception release has been ordered");
            resetCurrentEntries();
            resetCurrentRequest();
            resetCurrentUser();
            resetCurrentSession();
        }
    }

    public Boolean isUnsaved(Object arg0) {
        return null;
    }

    @Override
    public int[] findDirty(Object obj, Serializable id, Object[] newValues, Object[] oldValues,
            String[] properties, Type[] types) {
        // if (doObjectHistorization(obj))
        // logger.debug("find dirty for " + obj + " with id " + id + " new=" +
        // Arrays.asList(newValues) + " old=" + Arrays.asList(oldValues) + "
        // props=" + Arrays.asList(properties));
        return null;
    }

    public Object instantiate(Class arg0, Serializable arg1) throws CallbackException {
        return null;
    }
}
