package by.itransition.fanfic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.itransition.fanfic.model.FanficModel;
import by.itransition.fanfic.model.bean.User;

@Controller
@RequestMapping("/signIn")
public class SignInController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getSigninForm() {
		return new ModelAndView("signIn", "user", new User());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String signInUser(@ModelAttribute("user") User user,
			BindingResult bindingResult, Model model, HttpServletRequest request) {
		boolean isUserRegistered = 
				FanficModel.getInstance().isRegistered(user.getUsername(),
						user.getPassword());
		if (isUserRegistered == true) {
			request.getSession().setAttribute("userId", user.getId());
			return "redirect:/";
		}
		model.addAttribute("error", true);
		return "signIn";
	}
}
