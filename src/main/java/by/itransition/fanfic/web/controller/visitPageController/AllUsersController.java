package by.itransition.fanfic.web.controller.visitPageController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.domain.Role;
import by.itransition.fanfic.domain.User;
import by.itransition.fanfic.service.RoleService;
import by.itransition.fanfic.service.UserService;

@Controller
@RequestMapping("/allUsers")
public class AllUsersController extends VisitPageController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;

	@RequestMapping(method = RequestMethod.GET)
	public String getAllUsers(Model model) {
		settingModel(model);
		List <User> users = new ArrayList<User>();
		for (User user : userService.getAllUsers()) {
			if (!user.getRoles().contains(roleService.getRoleByName(Role.ROLE_ADMIN))) {
				System.out.println("**********");
				users.add(user);
			}
		}
		model.addAttribute("allUsers", users);
		return "allUsers";
	}
}
