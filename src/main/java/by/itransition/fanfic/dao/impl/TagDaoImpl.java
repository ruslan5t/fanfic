package by.itransition.fanfic.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.itransition.fanfic.dao.TagDao;
import by.itransition.fanfic.domain.Tag;
import by.itransition.fanfic.domain.User;

@Repository
public class TagDaoImpl implements TagDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Tag> getAllTags() {
		TypedQuery<Tag> query = entityManager.createQuery("SELECT t FROM Tag t", Tag.class);
		return query.getResultList();
	}

	@Override
	public Tag getTagByName(String name) {
		TypedQuery<Tag> query = entityManager.createQuery(
				"SELECT t FROM Tag t WHERE t.name = :name", Tag.class);
		query.setParameter("name", name);
		List<Tag> result = query.getResultList();
		if (0 < result.size()) {
			return result.get(0);
		} else {
			return null;
		}
	}
	
	@Override
	public void save(Tag tag) {
		entityManager.getTransaction().begin();
		entityManager.persist(tag);
		entityManager.getTransaction().commit();
	}
	
	@Override
	public Tag getTagById(int id) {
		return entityManager.find(Tag.class, id);
	}
	
}
