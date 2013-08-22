package by.itransition.fanfic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.model.FanficModel;

@Controller
@RequestMapping("/find")
public class FindController extends VisitPageController {

	@RequestMapping(method = RequestMethod.POST)
	public String setFanficRating(Model model, HttpServletRequest request) {
		settingModel(model, request);
		model.addAttribute("foundedFanfics", FanficModel.getInstance()
				.searchFanfics(request.getParameter("searchRequest")));
		return "find";
	}
}
