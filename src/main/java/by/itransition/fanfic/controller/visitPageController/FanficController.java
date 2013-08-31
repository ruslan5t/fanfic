package by.itransition.fanfic.controller.visitPageController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.domain.Fanfic;
import by.itransition.fanfic.domain.Role;
import by.itransition.fanfic.service.FanficService;

/**
 * Controller that show fanfic.
 */
@Controller
@RequestMapping("/fanfic")
public class FanficController extends VisitPageController {

	@Autowired
	private FanficService fanficService;
	
	@RequestMapping(value = "/{fanficId}", method = RequestMethod.GET)
	public String getFanfic(@PathVariable("fanficId") int fanficId, Model model,
			HttpServletRequest request) {
		settingModel(model);
		Fanfic fanfic = fanficService.getFanficById(fanficId);
		model.addAttribute("fanfic", fanfic);
		model.addAttribute("noChapters", fanfic.getChapters().size() == 0);
		model.addAttribute("noComments", fanfic.getComments().size() == 0);
		if (request.isUserInRole(Role.ROLE_ADMIN) || 
				fanfic.getAuthor().getUsername().equals(request.getRemoteUser())) {
			model.addAttribute("canChangeFanfic", true);
		} else {
			model.addAttribute("canChangeFanfic", false);
		}
		return "fanfic";
	}
}
