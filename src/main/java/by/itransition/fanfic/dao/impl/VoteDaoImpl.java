package by.itransition.fanfic.dao.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.itransition.fanfic.dao.VoteDao;
import by.itransition.fanfic.domain.Vote;

@Repository
public class VoteDaoImpl implements VoteDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void save(Vote vote) {
		entityManager.getTransaction().begin();
		entityManager.persist(vote);
		entityManager.getTransaction().commit();
	}
	
	@Override
	public void remove(Vote vote) {
		entityManager.getTransaction().begin();
		entityManager.remove(vote);
		entityManager.getTransaction().commit();
	}

}
