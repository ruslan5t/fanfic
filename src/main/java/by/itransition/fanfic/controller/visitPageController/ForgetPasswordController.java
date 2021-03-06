package by.itransition.fanfic.controller.visitPageController;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.domain.User;
import by.itransition.fanfic.service.EmailService;
import by.itransition.fanfic.service.UserService;

/**
 * Controller that represent interaction of user and forgetPasswordService.
 */
@Controller
@RequestMapping("/forgetPassword")
public class ForgetPasswordController extends VisitPageController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getForgetPasswordForm(Model model) {
		settingModel(model);
		return "forgetPassword";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String sendPasswordToUser(Model model, HttpServletRequest request) {
		User user = userService.getUserByName(request.getParameter("username"));
		if (user == null) {
			settingModel(model);
			model.addAttribute("notExistUser", true);
			return "forgetPassword";
		}
		ResourceBundle resourceBundle = ResourceBundle.getBundle("messages",
				LocaleContextHolder.getLocale());
		emailService.sendMessage(user.getEmail(),
				user.getUsername() + ", " + resourceBundle.getString("yourPasswordIs") + 
				" " + user.getPassword());
		return "redirect:/messageSent";
	}
}
