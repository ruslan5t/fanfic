package by.itransition.fanfic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.service.UserService;

@Controller
@RequestMapping("/signIn")
public class SignInController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getSignIn() {
		return "signIn";
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String getSignInError(Model model) {
		model.addAttribute("error", true);
		return "signIn";
	}
}
