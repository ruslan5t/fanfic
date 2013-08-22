package by.itransition.fanfic.service;

import java.util.List;

import by.itransition.fanfic.domain.Category;

public interface CategoryService {
	
	List<Category> getAllCategories();
	
	Category getCategoryByName(String name);
	
}
