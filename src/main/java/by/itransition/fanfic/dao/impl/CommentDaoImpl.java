package by.itransition.fanfic.dao.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.itransition.fanfic.dao.CommentDao;
import by.itransition.fanfic.domain.Comment;

/**
 * Class that represent implementation of CommentDao. 
 */
@Repository
public class CommentDaoImpl implements CommentDao {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void save(Comment comment) {
		entityManager.getTransaction().begin();
		entityManager.persist(comment);
		entityManager.getTransaction().commit();
	}

	@Override
	public void remove(Comment comment) {
		entityManager.getTransaction().begin();
		entityManager.remove(comment);
		entityManager.getTransaction().commit();
	}
	
}
