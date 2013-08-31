package by.itransition.fanfic.controller.visitPageController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.domain.Role;
import by.itransition.fanfic.domain.User;
import by.itransition.fanfic.service.UserService;

/**
 * Handles requests for the application user page.
 */
@Controller
@RequestMapping("/user")
public class UserController extends VisitPageController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public String user(@PathVariable("userId") int userId, Model model,
			HttpServletRequest request) {
		settingModel(model);
		User user = userService.getUserById(userId);
		model.addAttribute("showedUser", user);
		model.addAttribute("noFanfics", user.getFanfics().size() == 0);
		if (request.isUserInRole(Role.ROLE_ADMIN) || 
				user.getUsername().equals(request.getRemoteUser())) {
			model.addAttribute("canRemoveFanfics", true);
		} else {
			model.addAttribute("canRemoveFanfics", false);
		}
		return "user";
	}
}
