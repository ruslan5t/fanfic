package by.itransition.fanfic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.domain.Fanfic;
import by.itransition.fanfic.domain.User;
import by.itransition.fanfic.service.UserService;

@Controller
@RequestMapping("/createFanfic")
public class CreateFanficController extends VisitPageController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getFanficCreationForm(
			Model model, HttpServletRequest request){
		settingModel(model, request);
		model.addAttribute("newFanfic", new Fanfic());
		return "createFanfic";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String createFanfic(@ModelAttribute("newFanfic") Fanfic fanfic,
			BindingResult bindingResult, HttpServletRequest request) {
		User user = userService.getUserById(
				(Integer)request.getSession().getAttribute("userId"));
		user.addFanfic(fanfic);
		userService.save(user);
		return "redirect:/user/" + user.getId();
	}
}
