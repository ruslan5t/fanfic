package by.itransition.fanfic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.model.FanficModel;

@Controller
@RequestMapping("/removeUser")
public class RemoveUserController {

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String user(@PathVariable("username") String username,
			Model model, HttpServletRequest request){
		FanficModel.getInstance().removeUserByName(username);
		return "redirect:/allUsers";
	}
}
