package by.itransition.fanfic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.service.FanficService;

@Controller
@RequestMapping("/fanfic")
public class FanficController extends VisitPageController {

	@Autowired
	private FanficService fanficService;
	
	@RequestMapping(value = "/{fanficId}", method = RequestMethod.GET)
	public String getFanfic(@PathVariable("fanficId") int fanficId,
			Model model, HttpServletRequest request) {
		settingModel(model, request);
		model.addAttribute("fanfic", fanficService.getFanficById(fanficId));
		return "fanfic";
	}
}
