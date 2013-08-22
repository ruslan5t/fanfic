package by.itransition.fanfic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.service.FanficService;

@Controller
@RequestMapping("/find")
public class FindController extends VisitPageController {

	@Autowired
	private FanficService fanficService;
	
	@RequestMapping(method = RequestMethod.POST)
	public String setFanficRating(Model model, HttpServletRequest request) {
		settingModel(model, request);
		model.addAttribute("foundedFanfics", fanficService.search(request.getParameter("searchRequest")));
		return "find";
	}
}
