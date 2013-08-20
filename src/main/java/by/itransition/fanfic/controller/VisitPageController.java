package by.itransition.fanfic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import by.itransition.fanfic.model.FanficModel;
import by.itransition.fanfic.model.bean.User;

public class VisitPageController {

	protected void settingModel(Model model, HttpServletRequest request) {
		Integer userId = (Integer)request.getSession().getAttribute("userId");
		if (userId != null) {
			model.addAttribute("isLogged", true);
			User currentUser = FanficModel.getInstance().getUserById(userId);
			model.addAttribute("currentUserId", userId);
			model.addAttribute("currentUsername", currentUser.getUsername());
			//if (FanficModel.getInstance().getUser(username).isAdmin()) {
			if (currentUser.getUsername().equals("Admin")) {
				model.addAttribute("isAdmin", true);
			}
		}
		else {
			model.addAttribute("isLogged", false);
		}
	}
}