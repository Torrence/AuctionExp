package nju.edu.auctionExp.dao;

import java.util.List;

import nju.edu.auctionExp.dao.common.CommonDAOImpl;
import nju.edu.auctionExp.dao.common.ICommonDAO;
import nju.edu.auctionExp.model.ConditionGroup;
import nju.edu.auctionExp.model.Participant;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Participant entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see nju.edu.auctionExp.model.Participant
 * @author MyEclipse Persistence Tools
 */

public class ParticipantDAO extends CommonDAOImpl<Participant> implements ICommonDAO<Participant>{
	private static final Logger log = LoggerFactory
			.getLogger(ParticipantDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Participant transientInstance) {
		log.debug("saving Participant instance");
		try {
			getHibernateTemplate().saveOrUpdate(transientInstance);
			//getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Participant persistentInstance) {
		log.debug("deleting Participant instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Participant findById(java.lang.String id) {
		log.debug("getting Participant instance with id: " + id);
		try {
			Participant instance = (Participant) getHibernateTemplate().get(
					"nju.edu.auctionExp.model.Participant", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Participant instance) {
		log.debug("finding Participant instance by example");
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
		log.debug("finding Participant instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Participant as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Participant instances");
		try {
			String queryString = "from Participant";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Participant merge(Participant detachedInstance) {
		log.debug("merging Participant instance");
		try {
			Participant result = (Participant) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Participant instance) {
		log.debug("attaching dirty Participant instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Participant instance) {
		log.debug("attaching clean Participant instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ParticipantDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ParticipantDAO) ctx.getBean("ParticipantDAO");
	}
}