package by.itransition.fanfic.web.controller.visitPageController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.service.CategoryService;
import by.itransition.fanfic.service.FanficService;
import by.itransition.fanfic.service.TagService;

@Controller
@RequestMapping("/catalog")
public class CatalogController extends VisitPageController {
	
	private final static int COUNT_ON_PAGE = 5;

	@Autowired
	private FanficService fanficService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private TagService tagService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getCatalogFirstPage() {
		return "redirect:/catalog/1";
	}
	
	@RequestMapping(value = "/{pageNumber}", method = RequestMethod.GET)
	public String getCatalog(@PathVariable("pageNumber") int pageNumber, Model model) {
		settingModel(model);
		model.addAttribute("allFanfics", 
				fanficService.getFanficsByDate((pageNumber - 1) * COUNT_ON_PAGE, COUNT_ON_PAGE));
		settingPagination(model, pageNumber, fanficService.getAllFanfics().size(), "");
		model.addAttribute("categoryName", "all");
		return "catalog";
	}
	
	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
	public String getFanficsByCategoryFirstPage(@PathVariable("categoryId") int categoryId) {
		return "redirect:/catalog/category/" + categoryId + "/1";
	}
	
	@RequestMapping(value = "/category/{categoryId}/{pageNumber}", method = RequestMethod.GET)
	public String getFanficsByCategory(@PathVariable("categoryId") int categoryId,
			@PathVariable("pageNumber") int pageNumber, Model model) {
		settingModel(model);
		model.addAttribute("allFanfics", 
				fanficService.getFanficsByCategoryId(
						categoryId, (pageNumber - 1) * COUNT_ON_PAGE, COUNT_ON_PAGE));
		settingPagination(model, pageNumber,
				fanficService.getFanficsByCategoryId(categoryId).size(),
				"/category/" + categoryId);
		model.addAttribute("categoryName",
				categoryService.getCategoryById(categoryId).getName());
		return "catalog";
	}
	
	@RequestMapping(value = "/tag/{tagId}", method = RequestMethod.GET)
	public String getFanficsByTagFirstPage(@PathVariable("tagId") int tagId) {
		return "redirect:/catalog/tag/" + tagId + "/1";
	}
	
	@RequestMapping(value = "/tag/{tagId}/{pageNumber}", method = RequestMethod.GET)
	public String getFanficsByTag(@PathVariable("tagId") int tagId,
			@PathVariable("pageNumber") int pageNumber,
			Model model) {
		settingModel(model);
		model.addAttribute("allFanfics", 
				fanficService.getFanficsByTagId(
						tagId, (pageNumber - 1) * COUNT_ON_PAGE, COUNT_ON_PAGE));
		settingPagination(model, pageNumber, fanficService.getFanficsByTagId(tagId).size(),
				"/tag/" + tagId);
		model.addAttribute("tagName", tagService.getTagById(tagId).getName());
		return "catalogTags";
	}
	
	private void settingPagination(Model model, int pageNumber, int countItems,
			String addressPastCatalog) {
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("countItems", countItems);
		model.addAttribute("addressPastCatalog", addressPastCatalog);
		model.addAttribute("countOnPage", COUNT_ON_PAGE);
	}
}
