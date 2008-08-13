package fr.capwebct.modules.payment.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import fr.capwebct.modules.payment.dao.IGenericDAO;

public class GenericHibernateDAO<T, ID extends Serializable> extends HibernateDaoSupport
		implements IGenericDAO<T, ID> {

	private Class<T> persistentClass;

	public GenericHibernateDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}

	public void create(T exampleInstance) throws DataAccessException {
		try {
			Session session = getSession();
			session.saveOrUpdate(exampleInstance);
		} catch (HibernateException exception) {
			throw SessionFactoryUtils.convertHibernateAccessException(exception);
		}
	}

	public T read(ID id) throws DataAccessException {
		try {
			Session session = getSession();
			T exampleInstance = (T) session.load(getPersistentClass(), id);
			return exampleInstance;
		} catch (HibernateException exception) {
			throw SessionFactoryUtils.convertHibernateAccessException(exception);
		}
	}
	
	public T read(Class exampleClass, ID id) throws DataAccessException {
		try {
			Session session = getSession();
			T persistentInstance = (T) session.load(exampleClass, id);
			return persistentInstance;
		} catch (HibernateException exception) {
			throw SessionFactoryUtils.convertHibernateAccessException(exception);
		}
	}

	public void update(T exampleInstance) throws DataAccessException {
		try {
			Session session = getSession();
			session.update(exampleInstance);
		} catch (HibernateException exception) {
			throw SessionFactoryUtils.convertHibernateAccessException(exception);
		}
	}

	public void delete(T exampleInstance) throws DataAccessException {
		try {
			Session session = getSession();
			session.delete(exampleInstance);
		} catch (HibernateException exception) {
			throw SessionFactoryUtils.convertHibernateAccessException(exception);
		}
	}
	
	public void deleteAll() throws DataAccessException {
		try {
			List<T> exampleInstanceList = findAll();
			for (T exampleInstance : exampleInstanceList)
				delete(exampleInstance);
		} catch (HibernateException exception) {
			throw SessionFactoryUtils.convertHibernateAccessException(exception);
		}
	}

	public List<T> findAll() throws DataAccessException{
		return findByCriteria();
	}

	/**
	 * Use this inside subclasses as a convenience method.
	 */
	protected List<T> findByCriteria(Criterion... criterion) throws DataAccessException{
		try {
			Criteria crit = getSession().createCriteria(getPersistentClass());
			for (Criterion c : criterion) {
				crit.add(c);
			}
			return crit.list();
		} catch (HibernateException exception) {
			throw SessionFactoryUtils.convertHibernateAccessException(exception);
		}
	}
	
	public List<T> findAll(Class exampleClass) throws DataAccessException{
		return findByCriteria(exampleClass);
	}

	/**
	 * Use this inside subclasses as a convenience method.
	 */
	protected List<T> findByCriteria(Class exampleClass,Criterion... criterion) throws DataAccessException{
		try {
			Criteria crit = getSession().createCriteria(exampleClass);
			for (Criterion c : criterion) {
				crit.add(c);
			}
			return crit.list();
		} catch (HibernateException exception) {
			throw SessionFactoryUtils.convertHibernateAccessException(exception);
		}
	}
	
	/** 
	 * Initialize lazy lading object
	 */
	public void initializeProxy(Object exampleInstance) throws DataAccessException{
		try {
			Hibernate.initialize(exampleInstance);
		} catch (HibernateException exception) {
			throw SessionFactoryUtils.convertHibernateAccessException(exception);
		}
	}
}
