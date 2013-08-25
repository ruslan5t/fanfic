package by.itransition.fanfic.controller.visitPageController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.service.UserService;

@Controller
@RequestMapping("/allUsers")
public class AllUsersController extends VisitPageController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String getAllUsers(Model model) {
		settingModel(model);
		model.addAttribute("allUsers", userService.getAllUsers());
		return "allUsers";
	}
}
