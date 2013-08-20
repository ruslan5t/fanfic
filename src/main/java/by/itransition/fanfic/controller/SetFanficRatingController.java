package by.itransition.fanfic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import by.itransition.fanfic.model.FanficModel;
import by.itransition.fanfic.model.bean.Fanfic;
import by.itransition.fanfic.model.bean.User;

@Controller
@RequestMapping("/setFanficRating")
public class SetFanficRatingController {

	@RequestMapping(value = "/{fanficId}/{userRating}",
			method = RequestMethod.POST)
	public @ResponseBody
	String setFanficRating(@PathVariable("fanficId") int fanficId,
			@PathVariable("userRating") int userRating,
			Model model, HttpServletRequest request) {
		User user = FanficModel.getInstance().getUserById((Integer)
				request.getSession().getAttribute("userId"));
		Fanfic fanfic = FanficModel.getInstance().getFanficById(fanficId);
		fanfic.makeVote(userRating, user);
		FanficModel.getInstance().save(fanfic);
		return Double.toString(fanfic.getRating());
	}
}
