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
public class FindController {

	@RequestMapping(method = RequestMethod.GET)
	public String setFanficRating(Model model, HttpServletRequest request) {
		throw new RuntimeException();
	}
}
