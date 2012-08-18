package nju.edu.auctionExp.dao;

import java.util.List;

import nju.edu.auctionExp.model.ParticipantAction;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * ParticipantAction entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see nju.edu.auctionExp.model.ParticipantAction
 * @author MyEclipse Persistence Tools
 */

public class ParticipantActionDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ParticipantActionDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(ParticipantAction transientInstance) {
		log.debug("saving ParticipantAction instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ParticipantAction persistentInstance) {
		log.debug("deleting ParticipantAction instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ParticipantAction findById(java.lang.String id) {
		log.debug("getting ParticipantAction instance with id: " + id);
		try {
			ParticipantAction instance = (ParticipantAction) getHibernateTemplate()
					.get("nju.edu.auctionExp.model.ParticipantAction", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ParticipantAction instance) {
		log.debug("finding ParticipantAction instance by example");
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
		log.debug("finding ParticipantAction instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ParticipantAction as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all ParticipantAction instances");
		try {
			String queryString = "from ParticipantAction";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ParticipantAction merge(ParticipantAction detachedInstance) {
		log.debug("merging ParticipantAction instance");
		try {
			ParticipantAction result = (ParticipantAction) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ParticipantAction instance) {
		log.debug("attaching dirty ParticipantAction instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ParticipantAction instance) {
		log.debug("attaching clean ParticipantAction instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ParticipantActionDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ParticipantActionDAO) ctx.getBean("ParticipantActionDAO");
	}
}