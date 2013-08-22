package by.itransition.fanfic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import by.itransition.fanfic.domain.Category;
import by.itransition.fanfic.domain.Fanfic;
import by.itransition.fanfic.domain.Tag;
import by.itransition.fanfic.service.CategoryService;
import by.itransition.fanfic.service.TagService;

@Controller
public class InputFanficController extends VisitPageController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private TagService tagService;
	
	protected void correctFanfic(Fanfic fanfic) {
		List <Tag> newTags = new ArrayList <Tag>(fanfic.getTags().size());
		for (Tag tag : fanfic.getTags()) {
			newTags.add(tagService.getTagByName(tag.getName()));
		}
		fanfic.setTags(newTags);
		List <Category> newCategories = new ArrayList <Category>(
				fanfic.getCategories().size());
		for (Category category : fanfic.getCategories()) {
			newCategories.add(categoryService.getCategoryByName(category.getName()));
		}
		fanfic.setCategories(newCategories);
	}

}
