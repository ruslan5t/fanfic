package by.itransition.fanfic;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.controller.AbstractController;
import by.itransition.fanfic.model.FanficModel;
import by.itransition.fanfic.model.bean.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends AbstractController {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		settingModel(model, request);
		model.addAttribute("bestFanfics",
				FanficModel.getInstance().getBestFanfics(10));
		return "home";
	}
	
}
