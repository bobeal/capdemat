package fr.cg95.cvq.dao.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.apache.log4j.Logger;

/**
 * Basic Hibernate helper class, handles SessionFactory, Session and Transaction.
 * <p>
 * Uses a static initializer for the initial SessionFactory creation
 * and holds Session and Transactions in thread local variables. All
 * exceptions are wrapped in an unchecked InfrastructureException.
 *
 * @author christian@hibernate.org
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class HibernateUtil {

	private static Logger logger = Logger.getLogger(HibernateUtil.class);

	private static final ThreadLocal threadSessionFactory = new ThreadLocal();
    private static final ThreadLocal threadSession = new ThreadLocal();
	private static final ThreadLocal threadTransaction = new ThreadLocal();

	/**
	 * Returns the SessionFactory used for this static class.
	 *
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
	    return (SessionFactory) threadSessionFactory.get();
	}

    public static void setSessionFactory(SessionFactory sessionFactory) {
        threadSessionFactory.set(sessionFactory);
    }
    
	/**
	 * Retrieves the current Session local to the thread.
	 * <p/>
	 * If no Session is open, opens a new Session for the running thread.
	 *
	 * @return Session
	 */
	public static Session getSession() {

		Session s = (Session) threadSession.get();
	    if (s == null) {
			logger.debug("Opening new Session for this thread.");
			s = getSessionFactory().openSession();
			threadSession.set(s);
		}
		return s;
	}

	/**
	 * Closes the Session local to the thread.
	 */
	public static void closeSession() {
		Session s = (Session) threadSession.get();
		threadSession.set(null);
		if (s != null && s.isOpen()) {
			logger.debug("Closing Session of this thread.");
			s.close();
		}
	}

	/**
	 * Start a new database transaction.
	 */
	public static void beginTransaction() {
	Transaction tx = (Transaction) threadTransaction.get();
		if (tx == null) {
			logger.debug("Starting new database transaction in this thread.");
			tx = getSession().beginTransaction();
			threadTransaction.set(tx);
		}
	}

	/**
	 * Commit the database transaction.
	 */
	public static void commitTransaction() {

		Transaction tx = (Transaction) threadTransaction.get();
		try {
			if ( tx != null && !tx.wasCommitted()
							&& !tx.wasRolledBack() ) {
				logger.debug("Committing database transaction of this thread.");
				tx.commit();
			}
			threadTransaction.set(null);
		} catch (HibernateException ex) {
			rollbackTransaction();
			throw ex;
		}
	}

	/**
	 * Rollback the database transaction.
	 */
	public static void rollbackTransaction() {

		Transaction tx = (Transaction) threadTransaction.get();
		try {
			threadTransaction.set(null);
			if ( tx != null && !tx.wasCommitted() && !tx.wasRolledBack() ) {
				logger.debug("Tyring to rollback database transaction of this thread.");
				tx.rollback();
			}
		} catch (HibernateException ex) {
		    throw ex;
		} finally {
			closeSession();
		}
	}

	/**
	 * Reconnects a Hibernate Session to the current Thread.
	 *
	 * @param session The Hibernate Session to be reconnected.
	 */
	public static void reconnect(Session session) {
		session.reconnect();
		threadSession.set(session);
	}

	/**
	 * Disconnect and return Session from current Thread.
	 *
	 * @return Session the disconnected Session
	 */
	public static Session disconnectSession() {
		Session session = getSession();
		threadSession.set(null);
		if (session.isConnected() && session.isOpen())
			session.disconnect();
		return session;
	}
}

