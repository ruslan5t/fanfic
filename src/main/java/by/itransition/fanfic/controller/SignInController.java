package by.itransition.fanfic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.itransition.fanfic.domain.User;
import by.itransition.fanfic.service.UserService;

@Controller
@RequestMapping("/signIn")
public class SignInController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getSigninForm() {
		return new ModelAndView("signIn", "user", new User());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String signInUser(@ModelAttribute("user") User user,
			BindingResult bindingResult, Model model, HttpServletRequest request) {
		boolean isUserRegistered = userService.isRegistered(user.getUsername(), user.getPassword());
		if (isUserRegistered) {
			request.getSession().setAttribute("userId",
					userService.getUserByName(user.getUsername()).getId());
			return "redirect:/";
		}
		model.addAttribute("error", true);
		return "signIn";
	}
}
