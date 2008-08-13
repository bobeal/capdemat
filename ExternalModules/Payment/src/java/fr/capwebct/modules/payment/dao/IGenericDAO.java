package fr.capwebct.modules.payment.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;


public interface IGenericDAO<T, ID extends Serializable> {

	public void create(T exampleInstance) throws DataAccessException;

	public T read(ID id) throws DataAccessException;
	
	public T read(Class exampleClass, ID id) throws DataAccessException;
	
	public void update(T exampleInstance) throws DataAccessException;
	
	public void delete(T exampleInstance) throws DataAccessException;
	
	public void deleteAll() throws DataAccessException;

	public List<T> findAll() throws DataAccessException;
	
	public List<T> findAll(Class exampleClass) throws DataAccessException;
	
	public void initializeProxy(Object exampleInstance) throws DataAccessException ;
}
