package by.itransition.fanfic.web.controller.visitPageController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/messageSent")
public class MessageSent extends VisitPageController {

	@RequestMapping(method = RequestMethod.GET)
	public String getMessageSent(Model model) {
		settingModel(model);
		return "messageSent";
	}
}
