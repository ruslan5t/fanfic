package by.itransition.fanfic.dao;

import java.util.List;

import by.itransition.fanfic.domain.Category;

/**
 * Class that represent interface for CategoryDao. 
 */
public interface CategoryDao {

	Category getCategoryByName(String name);
	
	Category getCategoryById(int id);
	
	List<Category> getAllCategories();
	
}
