package by.itransition.fanfic.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import by.itransition.fanfic.dao.FanficDao;
import by.itransition.fanfic.model.bean.Fanfic;

public class FanficDaoImpl implements FanficDao {
	
	private EntityManager entityManager = HibernateUtil.getEntityManager();
	
	@Override
	public void addFanfic(Fanfic fanfic) {
		entityManager.getTransaction().begin();
		entityManager.persist(fanfic);
		entityManager.getTransaction().commit();
	}
	
	@Override
	public List<Fanfic> getFanfics() {
		TypedQuery<Fanfic> query = entityManager.createQuery("SELECT u FROM Fanfic u", Fanfic.class);
		return query.getResultList();
	}

	@Override
	public void save(Fanfic fanfic) {
		entityManager.getTransaction().begin();
		entityManager.persist(fanfic);
		entityManager.getTransaction().commit();
	}
	
}
