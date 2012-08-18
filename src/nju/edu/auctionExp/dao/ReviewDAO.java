package nju.edu.auctionExp.dao;

import java.util.List;

import nju.edu.auctionExp.dao.common.CommonDAOImpl;
import nju.edu.auctionExp.dao.common.ICommonDAO;
import nju.edu.auctionExp.model.ConditionGroup;
import nju.edu.auctionExp.model.Review;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Review entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see nju.edu.auctionExp.model.Review
 * @author MyEclipse Persistence Tools
 */

public class ReviewDAO extends CommonDAOImpl<Review> implements ICommonDAO<Review> {
	private static final Logger log = LoggerFactory.getLogger(ReviewDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Review transientInstance) {
		log.debug("saving Review instance");
		try {
			getHibernateTemplate().saveOrUpdate(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Review persistentInstance) {
		log.debug("deleting Review instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Review findById(java.lang.String id) {
		log.debug("getting Review instance with id: " + id);
		try {
			Review instance = (Review) getHibernateTemplate().get(
					"nju.edu.auctionExp.model.Review", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Review instance) {
		log.debug("finding Review instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Review instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Review as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Review instances");
		try {
			String queryString = "from Review";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Review merge(Review detachedInstance) {
		log.debug("merging Review instance");
		try {
			Review result = (Review) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Review instance) {
		log.debug("attaching dirty Review instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Review instance) {
		log.debug("attaching clean Review instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ReviewDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ReviewDAO) ctx.getBean("ReviewDAO");
	}
}