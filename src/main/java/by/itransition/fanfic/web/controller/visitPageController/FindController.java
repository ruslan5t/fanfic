package by.itransition.fanfic.web.controller.visitPageController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.domain.Fanfic;
import by.itransition.fanfic.service.FanficService;

@Controller
@RequestMapping("/find")
public class FindController extends VisitPageController {

	@Autowired
	private FanficService fanficService;
	
	@RequestMapping(value = "/sendSearchRequest", method = RequestMethod.GET)
	public String changeFindRequest(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		return "redirect:/find/getFindPage/" + 
			URLEncoder.encode(request.getParameter("searchRequest"), "utf-8");
	}
	
	@RequestMapping(value = "/getFindPage/{searchRequest}", method = RequestMethod.GET)
	public String findFanfics(@PathVariable("searchRequest") String searchRequest,
			Model model) {
		settingModel(model);
		List <Fanfic> foundedFanfics;
		if (!searchRequest.equals("")) {
			foundedFanfics = fanficService.search(searchRequest);
		}
		else {
			foundedFanfics = new ArrayList<Fanfic>();
		}
		model.addAttribute("searchRequest", searchRequest);
		model.addAttribute("foundedFanfics", foundedFanfics); 
		model.addAttribute("noFoundedFanfics", foundedFanfics.size() == 0);
		return "find";
	}
}
