package by.itransition.fanfic.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.domain.Category;
import by.itransition.fanfic.domain.Fanfic;
import by.itransition.fanfic.service.FanficService;

@Controller
@RequestMapping("/catalog")
public class CatalogController extends VisitPageController {

	@Autowired
	private FanficService fanficService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getCatalog(Model model, HttpServletRequest request) {
		settingModel(model, request);
		model.addAttribute("allFanfics", fanficService.getAllFanfics());
		return "catalog";
	}
	
	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
	public String getFanficsByCategory(@PathVariable("categoryId") int categoryId,
			Model model, HttpServletRequest request) {
		settingModel(model, request);
		model.addAttribute("allFanfics", fanficService.getFanficsByCategoryId(categoryId));
		return "catalog";
	}
	
	@RequestMapping(value = "/tag/{tagId}", method = RequestMethod.GET)
	public String getFanficsByTag(@PathVariable("tagId") int tagId,
			Model model, HttpServletRequest request) {
		settingModel(model, request);
		model.addAttribute("allFanfics", fanficService.getFanficsByTagId(tagId));
		return "catalog";
	}
}
