package by.itransition.fanfic.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.search.jpa.Search;

public class HibernateUtil {

	private static EntityManager entityManager;

	public static EntityManager getEntityManager() {
		if (null == entityManager) {
			entityManager = Persistence.createEntityManagerFactory("PersistenceUnit").createEntityManager();
			try {
				Search.getFullTextEntityManager(entityManager).createIndexer().startAndWait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return entityManager;
	}

}
