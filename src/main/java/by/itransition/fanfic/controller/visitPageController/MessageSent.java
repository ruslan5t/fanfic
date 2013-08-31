package by.itransition.fanfic.controller.visitPageController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application messageSent page.
 */
@Controller
@RequestMapping("/messageSent")
public class MessageSent extends VisitPageController {

	@RequestMapping(method = RequestMethod.GET)
	public String getMessageSent(Model model) {
		settingModel(model);
		return "messageSent";
	}
}
