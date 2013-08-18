package by.itransition.fanfic.controller;

import javax.print.PrintService;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.model.FanficModel;
import by.itransition.fanfic.model.bean.User;

@Controller
@RequestMapping("/signUp")
public class SignUpController extends AbstractController {

	@RequestMapping(method = RequestMethod.GET)
	public String getUserCreationForm(
			Model model, HttpServletRequest request) {
		settingModel(model, request);
		model.addAttribute("user", new User());
		return "signUp";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String createUser(@ModelAttribute("user") User user,
			BindingResult bindingResult, HttpServletRequest request) {
		FanficModel.getInstance().registerUser(user);
		request.getSession().setAttribute("username", user.getUsername());		
		return "redirect:/";
	}
}
