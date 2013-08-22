package by.itransition.fanfic.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.itransition.fanfic.dao.UserDao;
import by.itransition.fanfic.domain.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private EntityManager entityManager = HibernateUtil.getEntityManager();

	@Override
	public List<User> getAllUsers() {
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
	public void remove(User user) {
		entityManager.getTransaction().begin();
		entityManager.remove(user);
		entityManager.getTransaction().commit();
	}
	
	@Override
	public User getUserById(int id) {
		return entityManager.find(User.class, id);
	}
	
	@Override
	public User getUserByName(String name) {
		TypedQuery<User> query = entityManager.createQuery(
				"SELECT u FROM User u WHERE u.name = :name", User.class);
		query.setParameter("name", name);
		List<User> result = query.getResultList();
		if (0 < result.size()) {
			return result.get(0);
		} else {
			return null;
		}
	}

}
