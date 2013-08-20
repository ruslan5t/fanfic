package by.itransition.fanfic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/signOut")
public class SignOutController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String signOut( HttpServletRequest request ){
		request.getSession().setAttribute("userId", null);
		return "redirect:/";
	}
}
