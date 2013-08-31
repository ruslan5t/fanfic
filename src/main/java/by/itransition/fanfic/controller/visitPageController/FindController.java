package by.itransition.fanfic.controller.visitPageController;

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

/**
 * Controller that find fanfics.
 */
@Controller
@RequestMapping("/find")
public class FindController extends VisitPageController {

	@Autowired
	private FanficService fanficService;

	@RequestMapping(value = "/sendSearchRequest", method = RequestMethod.GET)
	public String changeFindRequest(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		if (!request.getParameter("searchRequest").isEmpty()) {
			return "redirect:/find/getFindPage/" + 
					URLEncoder.encode(request.getParameter("searchRequest"), "utf-8");
		} else {
			return "redirect:/find/emptySearchRequest";
		}
	}

	@RequestMapping(value = "/getFindPage/{searchRequest}", method = RequestMethod.GET)
	public String findFanfics(@PathVariable("searchRequest") String searchRequest,
			Model model) {
		settingModel(model);
		List <Fanfic> foundedFanfics = fanficService.search(searchRequest);
		settingResultSearchOnModel(model, searchRequest, foundedFanfics, foundedFanfics.size() == 0);
		return "find";
	}
	
	@RequestMapping(value = "/emptySearchRequest", method = RequestMethod.GET)
	public String findFanfics(Model model) {
		settingModel(model);
		settingResultSearchOnModel(model, "", new ArrayList<Fanfic>(), true);
		return "find";
	}
	
	private void settingResultSearchOnModel(Model model, String searchRequest,
			List <Fanfic> foundedFanfics, boolean noFoundedFanfics) {
		model.addAttribute("searchRequest", searchRequest);
		model.addAttribute("foundedFanfics", foundedFanfics); 
		model.addAttribute("noFoundedFanfics", noFoundedFanfics);
	}
}
