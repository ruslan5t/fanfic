package by.itransition.fanfic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.itransition.fanfic.dao.CategoryDao;
import by.itransition.fanfic.domain.Category;
import by.itransition.fanfic.domain.Tag;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Category getCategoryByName(String name) {
		TypedQuery<Category> query = entityManager.createQuery(
				"SELECT c FROM Category c WHERE c.name = :name", Category.class);
		query.setParameter("name", name);
		List<Category> result = query.getResultList();
		if (0 < result.size()) {
			return result.get(0);
		} else {
			return null;
		}
	}
	
	@Override
	public List<Category> getAllCategories() {
		if (null == getCategoryByName("detective")) {
			List<Category> categories = new ArrayList<Category>();
			categories.add(new Category("detective"));
			categories.add(new Category("novel"));
			categories.add(new Category("fantasy"));
			categories.add(new Category("scientific"));
			categories.add(new Category("prose"));
			categories.add(new Category("documentary"));
			entityManager.getTransaction().begin();
			for (Category category : categories) {
				entityManager.persist(category);
			}
			entityManager.getTransaction().commit();
		}
		TypedQuery<Category> query = entityManager.createQuery(
				"SELECT c FROM Category c", Category.class);
		return query.getResultList();
	}
	
	@Override
	public Category getCategoryById(int id) {
		return entityManager.find(Category.class, id);
	}
	
}
