package by.itransition.fanfic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.itransition.fanfic.dao.CategoryDao;
import by.itransition.fanfic.domain.Category;
import by.itransition.fanfic.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	@Transactional
	public List<Category> getAllCategories() {
		return categoryDao.getAllCategories();
	}
	
	@Override
	@Transactional
	public Category getCategoryByName(String name) {
		return categoryDao.getCategoryByName(name);
	}

}
