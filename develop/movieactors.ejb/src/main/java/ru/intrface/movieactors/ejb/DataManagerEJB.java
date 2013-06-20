package ru.intrface.movieactors.ejb;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import ru.intrface.movieactors.ejb.exception.DataManagerException;

/**
 * EJB-бин работы с базой данных
 * 
 * @author rusanov
 * 
 */
@Stateless
public class DataManagerEJB  {
	@PersistenceContext(unitName = "movieactors")
	private EntityManager em;
	private static final Logger logger = Logger.getLogger(DataManagerEJB.class
			.getName());

	public DataManagerEJB() {
		logger.info("DataManager ejb created");
	}

//	@Override
//	public <T> void saveAll(List<T> objectsToSave) throws DataManagerException {
//		try {
//			for (T obj : objectsToSave) {
//				em.merge(obj);
//			}
//		} catch (Exception e) {
//			throw new DataManagerException(e);
//		}
//	}
//
//	@Override
//	public <T> void updateAll(List<T> objectsToUpdate)
//			throws DataManagerException {
//		try {
//			for (T objToUpdate : objectsToUpdate) {
//				em.merge(objToUpdate);
//			}
//		} catch (Exception e) {
//			throw new DataManagerException(e);
//		}
//	}
//
	public <T> T get(Class<T> clazz, Serializable key)
			throws DataManagerException {
		try {
			logger.info("Get object of class [ "+ clazz+" ] with id ["+key + " ]");
			return em.find(clazz, key);
		} catch (Exception e) {
			throw new DataManagerException(e);
		}
	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public <T> List<T> getAll(Class<T> clazz) throws DataManagerException {
//		try {
//			Query qry = em.createQuery("SELECT c FROM " + clazz.getSimpleName()
//					+ " c", clazz);
//			return qry.getResultList();
//		} catch (Exception e) {
//			throw new DataManagerException(e);
//		}
//	}
//
	public <T> T saveOrUpdate(T obj) throws DataManagerException {
		try {
			return em.merge(obj);
		} catch (Exception e) {
			throw new DataManagerException(e);
		}
	}

	public <T> void delete(T obj) throws DataManagerException {
		try {
			em.remove(obj);
		} catch (Exception e) {
			throw new DataManagerException(e);
		}
	}
//
	public <T> void delete(Class<T> clazz, Serializable key)
			throws DataManagerException {
		try {
			logger.info("Get object of class [ "+ clazz+" ] with id ["+key + " ]");
			Object entity = em.find(clazz, key);
			if (entity != null) {
				em.remove(entity);
			} else {
				throw new DataManagerException("Не найден объект класса ["
						+ clazz + "] с ПК [" + key + "]");
			}
		} catch (Exception e) {
			throw new DataManagerException(e);
		}
	}
//
//	@Override
//	public <T> void deleteAll(List<T> objects) throws DataManagerException {
//		try {
//			for (T object : objects) {
//				em.remove(object);
//			}
//		} catch (Exception e) {
//			throw new DataManagerException(e);
//		}
//	}
//
	@SuppressWarnings("unchecked")
	public <T> List<T> execQuery(Class<T> clazz, String queryString)
			throws DataManagerException {
		try {
			Query qry = em.createQuery(queryString, clazz);
			List<T> result = qry.getResultList();
			return (List<T>) result;
		} catch (Exception e) {
			throw new DataManagerException(e);
		}
	}
//
//	@Override
//	public <T> List<T> execParamsNamedQuery(Class<T> clazz,
//			Map<String, Object> params, String queryName)
//			throws DataManagerException {
//		try {
//			Query qry = em.createNamedQuery(queryName, clazz);
//			for (Entry<String, Object> qryParam : params.entrySet()) {
//				qry.setParameter(qryParam.getKey(), qryParam.getValue());
//			}
//			@SuppressWarnings("unchecked")
//			List<T> result = qry.getResultList();
//			return (List<T>) result;
//		} catch (Exception e) {
//			throw new DataManagerException(e);
//		}
//	}

	public <T> void save(T obj) throws DataManagerException {
		try {
			em.persist(obj);
		} catch (Exception e) {
			throw new DataManagerException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T execSingleResultQuery(Class<T> clazz, String queryString)
			throws DataManagerException {
		try {
			Query qry = em.createQuery(queryString, clazz);
			T result = (T) qry.getSingleResult();
			return result;
		} catch (Exception e) {
			throw new DataManagerException(e);
		}
	}

	public <T> void execUpdateQuery(Class<T> clazz, String queryString,
			Map<String, Object> params) throws DataManagerException {
		try {
			Query qry = em.createQuery(queryString, clazz);
			for (Entry<String, Object> qryParam : params.entrySet()) {
				qry.setParameter(qryParam.getKey(), qryParam.getValue());
			}
			qry.executeUpdate();
		} catch (Exception e) {
			throw new DataManagerException(e);
		}
	}

	public <T> T execSingleResultParamsQuery(Class<T> clazz,
			String queryString, Map<String, Object> params)
			throws DataManagerException {
		try {
			Query qry = em.createQuery(queryString, clazz);
			for (Entry<String, Object> qryParam : params.entrySet()) {
				qry.setParameter(qryParam.getKey(), qryParam.getValue());
			}
			@SuppressWarnings("unchecked")
			T result = (T) qry.getSingleResult();
			return result;
		} catch (Exception e) {
			throw new DataManagerException(e);
		}
	}

	public <T> List<T> execParamsQuery(Class<T> clazz, String queryString,
			Map<String, Object> params) throws DataManagerException {
		try {
			Query qry = em.createQuery(queryString, clazz);
			for (Entry<String, Object> qryParam : params.entrySet()) {
				qry.setParameter(qryParam.getKey(), qryParam.getValue());
			}
			@SuppressWarnings("unchecked")
			List<T> result = qry.getResultList();
			return result;
		} catch (Exception e) {
			throw new DataManagerException(e);
		}
	}
//
//	@Override
//	public <T> List<T> execParamsQuery(Class<T> clazz, String queryString,
//			Map<String, Object> params, Integer limitRows)
//			throws DataManagerException {
//		try {
//			Query qry = em.createQuery(queryString, clazz);
//			for (Entry<String, Object> qryParam : params.entrySet()) {
//				qry.setParameter(qryParam.getKey(), qryParam.getValue());
//			}
//			qry.setMaxResults(limitRows);
//			@SuppressWarnings("unchecked")
//			List<T> result = qry.getResultList();
//			return result;
//		} catch (Exception e) {
//			throw new DataManagerException(e);
//		}
//	}
//
//	@Override
//	public <T> T execSglRsltPrmsNamedQuery(Class<T> clazz,
//			Map<String, Object> params, String queryName)
//			throws DataManagerException {
//		try {
//			Query qry = em.createNamedQuery(queryName, clazz);
//			for (Entry<String, Object> qryParam : params.entrySet()) {
//				qry.setParameter(qryParam.getKey(), qryParam.getValue());
//			}
//			@SuppressWarnings("unchecked")
//			T result = (T) qry.getSingleResult();
//			return result;
//		} catch (Exception e) {
//			throw new DataManagerException(e);
//		}
//	}
//
	public void flush() {
		em.flush();
	}
}
