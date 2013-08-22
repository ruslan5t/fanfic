package by.itransition.fanfic.dao;

import java.util.List;

import by.itransition.fanfic.domain.Category;

public interface CategoryDao {

	Category getCategoryByName(String name);
	
	List<Category> getAllCategories();
	
}
