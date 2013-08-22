package by.itransition.fanfic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import by.itransition.fanfic.domain.Fanfic;
import by.itransition.fanfic.domain.User;
import by.itransition.fanfic.service.FanficService;
import by.itransition.fanfic.service.UserService;

@Controller
@RequestMapping("/setFanficRating")
public class SetFanficRatingController {

	@Autowired
	private FanficService fanficService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/{fanficId}/{userRating}",
			method = RequestMethod.POST)
	public @ResponseBody
	String setFanficRating(@PathVariable("fanficId") int fanficId,
			@PathVariable("userRating") int userRating,
			Model model, HttpServletRequest request) {
		User user = userService.getUserById((Integer)
				request.getSession().getAttribute("userId"));
		Fanfic fanfic = fanficService.getFanficById(fanficId);
		fanfic.makeVote(userRating, user);
		fanficService.save(fanfic);
		return Double.toString(fanfic.getRating());
	}
}
