package by.itransition.fanfic.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.itransition.fanfic.dao.TagDao;
import by.itransition.fanfic.domain.Tag;

@Repository
public class TagDaoImpl implements TagDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Tag> getAllTags() {
		TypedQuery<Tag> query = entityManager.createQuery("SELECT t FROM Tag t", Tag.class);
		return query.getResultList();
	}

}
