package by.itransition.fanfic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import by.itransition.fanfic.domain.User;
import by.itransition.fanfic.model.FanficModel;
import by.itransition.fanfic.service.CategoryService;

@Controller
public class VisitPageController {
	
	@Autowired
	private CategoryService categoryService;

	protected void settingModel(Model model, HttpServletRequest request) {
		model.addAttribute("allCategories", categoryService.getAllCategories());
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
