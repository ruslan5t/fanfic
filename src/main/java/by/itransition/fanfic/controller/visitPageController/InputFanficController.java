package by.itransition.fanfic.controller.visitPageController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import by.itransition.fanfic.domain.Category;
import by.itransition.fanfic.domain.Fanfic;
import by.itransition.fanfic.domain.Tag;
import by.itransition.fanfic.service.CategoryService;
import by.itransition.fanfic.service.TagService;

/**
 * Abstract class that implements operations
 * which correct input of user.
 */
@Controller
public abstract class InputFanficController extends VisitPageController {
	
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
	
	protected boolean checkErrorsInput(Fanfic fanfic, Model model) {
		boolean isErrorInput = false;
		if (fanfic.getName().matches("\\s*")) {
			model.addAttribute("emptyTitle", true);
			isErrorInput = true;
		}
		if (fanfic.getDescription().matches("\\s*")) {
			model.addAttribute("emptyDescription", true);
			isErrorInput = true;
		}
		if (fanfic.getCategories() == null) {
			model.addAttribute("emptyCategories", true);
			isErrorInput = true;
		}
		return isErrorInput;
	}

}
