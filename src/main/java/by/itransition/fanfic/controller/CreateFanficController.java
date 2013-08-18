package by.itransition.fanfic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.model.FanficModel;
import by.itransition.fanfic.model.bean.Fanfic;
import by.itransition.fanfic.model.bean.User;

@Controller
@RequestMapping("/createFanfic")
public class CreateFanficController extends AbstractController {

	@RequestMapping(method = RequestMethod.GET)
	public String getFanficCreationForm(
			Model model, HttpServletRequest request){
		settingModel(model, request);
		model.addAttribute("newFanfic", new Fanfic());
		return "createFanfic";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String createFanfic(@ModelAttribute("newFanfic") Fanfic fanfic,
			BindingResult bindingResult, HttpServletRequest request) {
		User user = FanficModel.getInstance().getUser(
				(String)request.getSession().getAttribute("username"));
		user.addFanfic(fanfic);
		return "redirect:/user/" + user.getUsername();
	}
}