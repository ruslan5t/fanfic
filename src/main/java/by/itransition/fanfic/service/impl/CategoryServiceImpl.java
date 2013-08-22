package by.itransition.fanfic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itransition.fanfic.dao.CategoryDao;
import by.itransition.fanfic.domain.Category;
import by.itransition.fanfic.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public List<Category> getAllCategories() {
		return categoryDao.getAllCategories();
	}

}
