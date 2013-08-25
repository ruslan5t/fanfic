package by.itransition.fanfic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.domain.User;
import by.itransition.fanfic.service.FanficService;
import by.itransition.fanfic.service.UserService;

@Controller
@RequestMapping("/removeFanfic")
public class RemoveFanficController {

	@Autowired
	private FanficService fanficService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/{fanficId}", method = RequestMethod.POST)
	public String removeFanfic(@PathVariable("fanficId") int fanficId) {
		User author = fanficService.getFanficById(fanficId).getAuthor();
		author.removeFanficById(fanficId);
		userService.save(author);
		return "redirect:/user/" + author.getId();
	}
}
