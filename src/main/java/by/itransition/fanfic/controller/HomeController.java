package by.itransition.fanfic.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.service.FanficService;
import by.itransition.fanfic.service.TagService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends VisitPageController {

	@Autowired
	private FanficService fanficService;

	@Autowired
	private TagService tagService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		settingModel(model);
		model.addAttribute("allTags", tagService.getAllTags());
		model.addAttribute("bestFanfics", fanficService.getFanficsByRating(0, 10));
		return "home";
	}

}
