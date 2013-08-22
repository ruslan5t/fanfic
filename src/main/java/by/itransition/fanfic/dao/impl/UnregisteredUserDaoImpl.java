package by.itransition.fanfic.dao.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.itransition.fanfic.dao.UnregisteredUserDao;
import by.itransition.fanfic.domain.UnregisteredUser;

@Repository
public class UnregisteredUserDaoImpl implements UnregisteredUserDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void save(UnregisteredUser unregisteredUser) {
		entityManager.getTransaction().begin();
		entityManager.persist(unregisteredUser);
		entityManager.getTransaction().commit();
	}

	@Override
	public UnregisteredUser getUnregisteredUserById(int id) {
		return entityManager.find(UnregisteredUser.class, id);

	}

	@Override
	public void remove(UnregisteredUser unregisteredUser) {
		entityManager.getTransaction().begin();
		entityManager.remove(unregisteredUser);
		entityManager.getTransaction().commit();
	}

}
