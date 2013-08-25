package by.itransition.fanfic.web.controller.visitPageController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/about")
public class AboutController  extends VisitPageController {

	@RequestMapping(method = RequestMethod.GET)
	public String getAbout(Model model, HttpServletRequest request) {
		settingModel(model);
		return "about";
	}
}
