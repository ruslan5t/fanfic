package by.itransition.fanfic.controller.visitPageController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.domain.User;
import by.itransition.fanfic.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends VisitPageController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public String user(@PathVariable("userId") int userId, Model model){
		settingModel(model);
		User user = userService.getUserById(userId);
		model.addAttribute("showedUser", user);
		return "user";
	}
}
