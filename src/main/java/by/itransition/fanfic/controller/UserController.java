package by.itransition.fanfic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.model.FanficModel;
import by.itransition.fanfic.model.bean.User;

@Controller
@RequestMapping("/user")
public class UserController extends AbstractController {

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String user(@PathVariable("username") String username,
			Model model, HttpServletRequest request){
		settingModel(model, request);
		User user = FanficModel.getInstance().getUser(username);
		model.addAttribute("showedUser", user);
		return "user";
	}
}