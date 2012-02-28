package fr.cg95.cvq.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnitUtil;

import org.apache.log4j.Logger;

public class JpaUtil {

    private static Logger logger = Logger.getLogger(JpaUtil.class);

    private static final ThreadLocal<EntityManager> threadEntityManager = 
            new ThreadLocal<EntityManager>();

    public static EntityManager getEntityManager() {
        EntityManager entityManager = threadEntityManager.get();
        if (entityManager == null) {
            Throwable t = new Throwable();
            t.fillInStackTrace();
            logger.error("no entity manager in current thread, refusing to create a new one", t);
            throw new RuntimeException("no entity manager in current thread, refusing to create a new one");
        }
        return entityManager;
    }

    public static boolean eventualInit(EntityManagerFactory entityManagerFactory) {
        if (threadEntityManager.get() != null) {
            logger.debug("eventualInit() reusing existing entity manager " + threadEntityManager.get());
            return false;
        }

        init(entityManagerFactory);
        return true;
    }

    public static void init(EntityManagerFactory entityManagerFactory) {
        if (entityManagerFactory == null) {
            logger.error("no entity manager factory");
            throw new RuntimeException("no entity manager factory");
        }
        
        if (threadEntityManager.get() != null) {
            logger.warn("init() rollbacking " + threadEntityManager.get());
            // FIXME : this a hack added to handle session closing problem
            // TODO : identify the real cause and fix it properly
            // « Cherry-picked » from defunct HibernateUtil
            close(true);
        }
        
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        threadEntityManager.set(em);
        logger.debug("init() initialized entity manager " + em);
    }

    public static void close(boolean rollback) {
        if (threadEntityManager.get() == null) {
            logger.debug("close() no entity manager found (was asking for rollback ? " + rollback + ")");
            return;
        }

        try {
            if (rollback) {
                logger.debug("close() rollbacking on " + threadEntityManager.get());
                threadEntityManager.get().getTransaction().rollback();
            } else {
                try {
                    logger.debug("close() commiting on " + threadEntityManager.get());
                    threadEntityManager.get().getTransaction().commit();
                } catch (Throwable t) {
                    logger.error("close() can't commit", t);
                    throw new RuntimeException("close() can't commit", t);
                }
            }
        } finally {
            EntityManager em = threadEntityManager.get();
            threadEntityManager.get().close();
            threadEntityManager.remove();
            logger.debug("close() closed " + em);
        }
    }
    
    public static void closeAndReOpen(boolean rollback) {
        if (threadEntityManager.get() == null) {
            logger.error("closeAndReOpen() no entity manager found");
            throw new RuntimeException("no entity manager found");
        }

        EntityManagerFactory emf = threadEntityManager.get().getEntityManagerFactory();
        close(rollback);
        init(emf);
    }

    public static PersistenceUnitUtil getPersistenceUnitUtil(){
        EntityManagerFactory emf = threadEntityManager.get().getEntityManagerFactory();
        // if threadEntityManagerFactory dont have an emf
        if (emf != null){
            return emf.getPersistenceUnitUtil();
        }else{
            throw new RuntimeException("you can't use getPersistenceUnitUtil() when no EntityManagerFactory is set");
        }
    }
}
