package by.itransition.fanfic.controller.visitPageController;

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
	public String changeFindRequest(Model model, HttpServletRequest request) {
		String searchRequest = request.getParameter("searchRequest");
		if (!searchRequest.isEmpty()) {
			StringBuilder searchCharacterCodes = new StringBuilder();
			for (char charOfRequest : searchRequest.toCharArray()) {
				searchCharacterCodes.append((int)charOfRequest + "_");
			}
			return "redirect:/find/getFindPage/" + searchCharacterCodes;
		} else {
			return "redirect:/find/emptySearchRequest";
		}
	}

	@RequestMapping(value = "/getFindPage/{searchRequest}", method = RequestMethod.GET)
	public String findFanfics(@PathVariable("searchRequest") String searchRequestCodes,
			Model model) {
		StringBuilder searchRequest = new StringBuilder();
		for (String charCode : searchRequestCodes.split("_")) {
			searchRequest.append((char)(int)Integer.valueOf(charCode));
		}
		settingModel(model);
		List <Fanfic> foundedFanfics = fanficService.search(searchRequest.toString());
		settingResultSearchOnModel(model, searchRequest.toString(),
				foundedFanfics, foundedFanfics.size() == 0);
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
