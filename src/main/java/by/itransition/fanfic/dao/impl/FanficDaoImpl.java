package by.itransition.fanfic.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;

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
	
	@Override
	public List<Fanfic> search(String searchQuery) {
		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		QueryBuilder queryBuilder =
				fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Fanfic.class).get();
		org.apache.lucene.search.Query query = queryBuilder
				.keyword().onFields("name", "description").matching(searchQuery).createQuery();
		Query persistenceQuery = fullTextEntityManager.createFullTextQuery(query, Fanfic.class);
		return persistenceQuery.getResultList();
	}
	
}
