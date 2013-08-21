package by.itransition.fanfic.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.domain.User;
import by.itransition.fanfic.model.FanficModel;

@Controller
@RequestMapping("/about")
public class AboutController  extends VisitPageController {

	@RequestMapping(method = RequestMethod.GET)
	public String getAbout(Model model, HttpServletRequest request) {
		settingModel(model, request);
		//List<User> allUsers = FanficModel.getInstance().getAllUsers();
		//model.addAttribute("allUsers", allUsers);
		return "about";
	}
}
