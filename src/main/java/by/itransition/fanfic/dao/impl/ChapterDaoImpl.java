package by.itransition.fanfic.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import by.itransition.fanfic.dao.ChapterDao;
import by.itransition.fanfic.model.bean.Chapter;

public class ChapterDaoImpl implements ChapterDao {

	private EntityManager entityManager = HibernateUtil.getEntityManager();
	
	@Override
	public void addChapter(Chapter chapter) {
		entityManager.getTransaction().begin();
		entityManager.persist(chapter);
		entityManager.getTransaction().commit();
	}

	@Override
	public List<Chapter> getChapters() {
		TypedQuery<Chapter> query = entityManager.createQuery("SELECT u FROM Chapter u", Chapter.class);
		return query.getResultList();
	}

}
