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

import by.itransition.fanfic.dao.ChapterDao;
import by.itransition.fanfic.domain.Chapter;

@Repository
public class ChapterDaoImpl implements ChapterDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void addChapter(Chapter chapter) {
		entityManager.getTransaction().begin();
		entityManager.persist(chapter);
		entityManager.getTransaction().commit();
	}

	@Override
	public List<Chapter> getAllChapters() {
		TypedQuery<Chapter> query = entityManager.createQuery("SELECT u FROM Chapter u", Chapter.class);
		return query.getResultList();
	}

	@Override
	public List<Chapter> search(String searchQuery) {
		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		QueryBuilder queryBuilder =
				fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Chapter.class).get();
		org.apache.lucene.search.Query query = queryBuilder
				.keyword().onFields("name", "content").matching(searchQuery).createQuery();
		Query persistenceQuery = fullTextEntityManager.createFullTextQuery(query, Chapter.class);
		return persistenceQuery.getResultList();
	}

	@Override
	public void save(Chapter chapter) {
		entityManager.getTransaction().begin();
		entityManager.persist(chapter);
		entityManager.getTransaction().commit();
	}

}
