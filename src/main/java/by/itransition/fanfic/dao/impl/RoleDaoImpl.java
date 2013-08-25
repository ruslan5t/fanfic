package by.itransition.fanfic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.itransition.fanfic.dao.RoleDao;
import by.itransition.fanfic.domain.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Role getRoleByName(String name) {
		if (0 == entityManager.createQuery(
				"SELECT r FROM Role r WHERE r.name = 'ROLE_USER'", Role.class).getResultList().size()) {
			List<Role> roles = new ArrayList<Role>();
			roles.add(new Role("ROLE_ADMIN"));
			roles.add(new Role("ROLE_USER"));
			roles.add(new Role("ROLE_ANONYMOUS"));
			entityManager.getTransaction().begin();
			for (Role role : roles) {
				entityManager.persist(role);
			}
			entityManager.getTransaction().commit();
		}
		TypedQuery<Role> query = entityManager.createQuery(
				"SELECT r FROM Role r WHERE r.name = :name", Role.class);
		query.setParameter("name", name);
		List<Role> result = query.getResultList();
		if (0 < result.size()) {
			return result.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void save(Role role) {
		entityManager.getTransaction().begin();
		entityManager.persist(role);
		entityManager.getTransaction().commit();
	}

	
	
}
