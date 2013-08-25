package by.itransition.fanfic.web.controller.visitPageController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import by.itransition.fanfic.domain.Role;
import by.itransition.fanfic.domain.User;
import by.itransition.fanfic.service.CategoryService;
import by.itransition.fanfic.service.UserService;

@Controller
public class VisitPageController {
	
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private UserService userService;
	
	protected void settingModel(Model model) {
		model.addAttribute("allCategories", categoryService.getAllCategories());
		Authentication authentication = SecurityContextHolder
				.getContext().getAuthentication();
		if(hasAuthority(authentication, Role.ROLE_USER)) {
			model.addAttribute("isLogged", true);
			User currentUser = userService.getUserByName(authentication.getName());
			model.addAttribute("currentUserId", currentUser.getId());
			model.addAttribute("currentUsername", currentUser.getUsername());
		}
	}
	
	private boolean hasAuthority(Authentication authentication, String authority) {
		for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
			if (grantedAuthority.getAuthority().equals(authority)) {
				return true;
			}
		}
		return false;
	}
}