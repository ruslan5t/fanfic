package by.itransition.fanfic.web.controller.visitPageController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.domain.Fanfic;
import by.itransition.fanfic.service.FanficService;

@Controller
@RequestMapping("/find")
public class FindController extends VisitPageController {

	@Autowired
	private FanficService fanficService;
	
	@RequestMapping(method = RequestMethod.POST)
	public String setFanficRating(Model model, HttpServletRequest request) {
		settingModel(model);
		List <Fanfic> foundedFanfics;
		if (!request.getParameter("searchRequest").equals("")) {
			foundedFanfics = fanficService.search(request.getParameter("searchRequest"));
		}
		else {
			foundedFanfics = new ArrayList<Fanfic>();
		}
		model.addAttribute("searchRequest", request.getParameter("searchRequest"));
		model.addAttribute("foundedFanfics", foundedFanfics); 
		return "find";
	}
}
