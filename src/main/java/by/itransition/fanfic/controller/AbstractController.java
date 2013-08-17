package by.itransition.fanfic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class AbstractController {

	protected void settingModel(Model model, HttpServletRequest request) {
		String username = (String)request.getSession().getAttribute("username");
		if (username != null) {
			model.addAttribute("isLogged", true);
			model.addAttribute("currentUsername", username);
			//if (FanficModel.getInstance().getUser(username).isAdmin()) {
			if (username.equals("Admin")) {
				model.addAttribute("isAdmin", true);
			}
		}
		else {
			model.addAttribute("isLogged", false);
		}
	}
}
