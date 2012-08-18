package nju.edu.auctionExp.dao.common;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



public abstract class CommonDAOImpl<T> extends HibernateDaoSupport {

	@SuppressWarnings("unchecked")
	public List<T> findByHQL(String hql,
			int firstResult, int maxResults) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query q = session.createQuery(hql);
		q.setFirstResult(firstResult);
		q.setMaxResults(maxResults);
		List<T> results = q.list();
		try{
			return results;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
	}
	
	/**
	 * @param hql
	 */
	public void excuteHql(String hql){
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query q = session.createQuery(hql);
		try{
			q.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	public int getCount(String hql) {
		// TODO Auto-generated method stub
		return 0;
	}
}
