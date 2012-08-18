package nju.edu.auctionExp.dao.common;

import java.util.List;

public interface ICommonDAO<T> {
	
	/**
	 * @param hql
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<T> findByHQL(String hql, int firstResult, int maxResults);
	
	/**
	 * @param hql
	 * @return
	 */
	public int getCount(String hql);
	
	/**
	 * @param object
	 */
	public void save(T object);
	
	/**
	 * @param object
	 */
	public void delete(T object);
	
	/**
	 * @param id
	 * @return
	 */
	public T findById(String id);
	
	/**
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public List<T> findByProperty(String propertyName, Object value);
}
