package by.itransition.fanfic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.domain.User;
import by.itransition.fanfic.service.UserService;

@Controller
@RequestMapping("/signUp")
public class SignUpController extends VisitPageController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String getUserCreationForm(
			Model model, HttpServletRequest request) {
		settingModel(model, request);
		model.addAttribute("user", new User());
		return "signUp";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String createUser(@ModelAttribute("user") User user,
			BindingResult bindingResult, HttpServletRequest request) {
		int registrationId = userService.register(user);
		userService.confirmRegistration(registrationId);
//		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//		mailSender.setHost("smtp.mail.ru");
//		mailSender.setPort(587);
//		mailSender.setUsername("roman-v1@mail.ru");
//		mailSender.setPassword("4991vrv298");
//		mailSender.getJavaMailProperties().setProperty("mail.transport.protocol", "smtp");
//		mailSender.getJavaMailProperties().setProperty("mail.smtp.auth", "true");
//		mailSender.getJavaMailProperties().setProperty("mail.smtp.starttls.enable", "true");
//		SimpleMailMessage confirmRegistrationMessage = new SimpleMailMessage();
//		confirmRegistrationMessage.setTo(user.getEmail());
//		confirmRegistrationMessage.setFrom("roman-v1@mail.ru");
//		confirmRegistrationMessage.setText(
//				"If you registered on fanfic website go to " +
//						"http://localhost:8080/fanfic/confirmRegistration/" + registrationId);
//		mailSender.send(confirmRegistrationMessage);	
		return "redirect:/";
	}
}
