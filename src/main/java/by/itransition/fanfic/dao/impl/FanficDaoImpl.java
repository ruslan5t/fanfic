package by.itransition.fanfic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.itransition.fanfic.dao.FanficDao;
import by.itransition.fanfic.domain.Category;
import by.itransition.fanfic.domain.Fanfic;
import by.itransition.fanfic.domain.Tag;

/**
 * Class that represent implementation of FanficDao. 
 */
@Repository
public class FanficDaoImpl implements FanficDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void addFanfic(Fanfic fanfic) {
		entityManager.getTransaction().begin();
		entityManager.persist(fanfic);
		entityManager.getTransaction().commit();
	}

	@Override
	public List<Fanfic> getAllFanfics() {
		TypedQuery<Fanfic> query = entityManager.createQuery("SELECT f FROM Fanfic f", Fanfic.class);
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
		if (searchQuery.trim().isEmpty()) {
			return new ArrayList<Fanfic>();
		}
		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		QueryBuilder queryBuilder =
				fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Fanfic.class).get();
		org.apache.lucene.search.Query query = queryBuilder.keyword()
				.onFields("name", "description", "tags.name", "categories.name", "chapters.name", "chapters.content")
				.matching(searchQuery).createQuery();
		Query persistenceQuery = fullTextEntityManager.createFullTextQuery(query, Fanfic.class);
		return persistenceQuery.getResultList();
	}

	@Override
	public void removeFanficById(int id) {
		entityManager.getTransaction().begin();
		entityManager.remove(getFanficById(id));
		entityManager.getTransaction().commit();
	}

	@Override
	public Fanfic getFanficById(int id) {
		return entityManager.find(Fanfic.class, id);
	}

	@Override
	public List<Fanfic> getFanficsByCategory(Category category, int first, int count) {
		TypedQuery<Fanfic> query = entityManager.createQuery(
				"SELECT f FROM Fanfic f WHERE :category MEMBER OF f.categories ORDER BY f.id DESC",
				Fanfic.class);
		query.setParameter("category", category);
		query.setFirstResult(first);
		query.setMaxResults(count);
		return query.getResultList();
	}
	
	@Override
	public List<Fanfic> getFanficsByDate(int first, int count) {
		TypedQuery<Fanfic> query = entityManager.createQuery("SELECT f FROM Fanfic f ORDER BY f.id DESC", Fanfic.class);
		query.setFirstResult(first);
		query.setMaxResults(count);
		return query.getResultList();
	}
	
	@Override
	public List<Fanfic> getFanficsByRating(int first, int count) {
		TypedQuery<Fanfic> query = entityManager.createQuery("SELECT f FROM Fanfic f ORDER BY f.rating DESC, f.id DESC",
				Fanfic.class);
		query.setFirstResult(first);
		query.setMaxResults(count);
		return query.getResultList();
	}
	
	@Override
	public List<Fanfic> getFanficsByTag(Tag tag, int first, int count) {
		TypedQuery<Fanfic> query = entityManager.createQuery(
				"SELECT f FROM Fanfic f WHERE :tag MEMBER OF f.tags",
				Fanfic.class);
		query.setParameter("tag", tag);
		query.setFirstResult(first);
		query.setMaxResults(count);
		return query.getResultList();
	}

}
