package by.itransition.fanfic.dao.impl;

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

@Repository
public class FanficDaoImpl implements FanficDao {

	@Autowired
	private EntityManager entityManager = HibernateUtil.getEntityManager();

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
		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		QueryBuilder queryBuilder =
				fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Fanfic.class).get();
		org.apache.lucene.search.Query query = queryBuilder
				.keyword().onFields("name", "description").matching(searchQuery).createQuery();
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
	public List<Fanfic> getFanficsByCategory(Category category) {
		TypedQuery<Fanfic> query = entityManager.createQuery(
				"SELECT f FROM Fanfic f WHERE :category MEMBER OF f.categories",
				Fanfic.class);
		query.setParameter("category", category);
		return query.getResultList();
	}

}
