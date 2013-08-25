package by.itransition.fanfic.web.controller.visitPageController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.service.UserService;

@Controller
@RequestMapping("/signIn")
public class SignInController extends VisitPageController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String getSignIn(Model model) {
		settingModel(model);
		return "signIn";
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String signInUser(Model model) {
		settingModel(model);
		model.addAttribute("wrongNameOrPasswordError", true);
		return "signIn";
	}
}
