package by.itransition.fanfic.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import by.itransition.fanfic.dao.UserDao;
import by.itransition.fanfic.model.bean.User;

public class UserDaoImpl implements UserDao {

	private EntityManager entityManager = HibernateUtil.getEntityManager();

	@Override
	public User login(String username, String password) {
		User user = entityManager.find(User.class, username);
		if (null != user && user.getPassword().equals(password)) {
			return user;
		} else {
			return null;
		}
	}

	@Override
	public void register(User user) {
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
	}

	@Override
	public List<User> getUsers() {
		TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
		return query.getResultList();
	}

	@Override
	public void save(User user) {
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
	}

	@Override
	public void deleteAll() {
		entityManager.getTransaction().begin();
		for (User user : getUsers()) {
			entityManager.remove(user);
		}
		entityManager.getTransaction().commit();
	}
	
	@Override
	public void remove(User user) {
		entityManager.getTransaction().begin();
		entityManager.remove(user);
		entityManager.getTransaction().commit();
	}
}
