package by.itransition.fanfic.service;

import java.util.List;

import by.itransition.fanfic.domain.Category;

/**
 * Class that represent interface of CategoryService. 
 */
public interface CategoryService {
	
	List<Category> getAllCategories();
	
	Category getCategoryByName(String name);
	
	Category getCategoryById(int id);
	
}
