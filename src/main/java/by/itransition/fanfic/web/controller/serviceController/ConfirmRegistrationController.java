package by.itransition.fanfic.web.controller.serviceController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.service.UserService;


@Controller
@RequestMapping("/confirmRegistration")
public class ConfirmRegistrationController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/{registrationId}", method = RequestMethod.GET)
	public String confirmRegistration(@PathVariable("registrationId") int registrationId) {
		userService.confirmRegistration(registrationId);
		return "redirect:/registrationIsConfirmed";
	}
}
