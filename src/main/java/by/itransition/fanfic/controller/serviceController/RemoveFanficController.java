package by.itransition.fanfic.controller.serviceController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.domain.Fanfic;
import by.itransition.fanfic.domain.Role;
import by.itransition.fanfic.domain.User;
import by.itransition.fanfic.service.FanficService;
import by.itransition.fanfic.service.UserService;

/**
 * Controller that remove fanfic.
 */
@Controller
@RequestMapping("/removeFanfic")
public class RemoveFanficController {

	@Autowired
	private FanficService fanficService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/{fanficId}", method = RequestMethod.POST)
	public String removeFanfic(@PathVariable("fanficId") int fanficId,
			HttpServletRequest request) {
		if (!(request.isUserInRole(Role.ROLE_ADMIN) || 
				fanficService.getFanficById(fanficId).getAuthor()
				.getUsername().equals(request.getRemoteUser()))) {
			return "redirect:/";
		}
		User author = fanficService.getFanficById(fanficId).getAuthor();
		fanficService.removeFanficById(author, fanficId);
		return "redirect:/user/" + author.getId();
	}
}
