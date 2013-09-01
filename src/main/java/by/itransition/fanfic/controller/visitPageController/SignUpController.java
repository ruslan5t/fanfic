package by.itransition.fanfic.controller.visitPageController;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.domain.User;
import by.itransition.fanfic.service.EmailService;
import by.itransition.fanfic.service.UserService;

/**
 * Handles requests for the application signUp page.
 */
@Controller
@RequestMapping("/signUp")
public class SignUpController extends VisitPageController {

	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;

	@RequestMapping(method = RequestMethod.GET)
	public String getUserCreationForm(Model model) {
		settingModel(model);
		model.addAttribute("user", new User());
		return "signUp";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String createUser(@ModelAttribute("user") User user,
			BindingResult bindingResult, Model model, HttpServletRequest request) {
		if (checkInputErrors(user, model)) {
			settingModel(model);
			return "signUp";
		}
		int registrationId = userService.register(user);
		ResourceBundle resourceBundle = ResourceBundle.getBundle("messages",
				LocaleContextHolder.getLocale());
		emailService.sendMessage(user.getEmail(), 
				resourceBundle.getString("ifYouRegisteredOnFanficLibraryWebsiteGoTo") +
				" http://" + request.getServerName() + ":" + request.getServerPort() +
				"/confirmRegistration/" + registrationId);
		return "redirect:/messageSent";
	}

	private boolean checkInputErrors(User user, Model model) {
		boolean isErrorInput = false;
		if (!user.getEmail().matches(".+@.+\\..+") || user.getEmail().length() > 75) {
			model.addAttribute("notCorrectEmail", true);
			isErrorInput = true;
		}
		if (!user.getUsername().matches("[a-zA-Zà-ÿÀ-ß0-9_]+") || user.getUsername().length() > 30) {
			model.addAttribute("notCorrectUsername", true);
			isErrorInput = true;
		}
		else {
			if (userService.isRegistered(user.getUsername())) {
				model.addAttribute("usernameAlreadyRegistered", true);
				isErrorInput = true;
			}
		}
		if (!user.getPassword().matches("[a-zA-Zà-ÿÀ-ß0-9_]+") || user.getPassword().length() > 30) {
			model.addAttribute("notCorrectPassword", true);
			isErrorInput = true;
		}
		return isErrorInput;
	}
}
