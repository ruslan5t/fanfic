package by.itransition.fanfic.controller.serviceController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.service.UserService;

/**
 * Controller that remove user.
 */
@Controller
@RequestMapping("/removeUser")
public class RemoveUserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/{userId}", method = RequestMethod.POST)
	public String user(@PathVariable("userId") int userId, Model model){
		userService.removeUserById(userId);
		return "redirect:/allUsers";
	}
}
