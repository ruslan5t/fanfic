package by.itransition.fanfic.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HibernateUtil {

	private static EntityManager entityManager = 
			Persistence.createEntityManagerFactory("PersistenceUnit").createEntityManager();
	
	public static EntityManager getEntityManager() {
		return entityManager;
	}
	
}
