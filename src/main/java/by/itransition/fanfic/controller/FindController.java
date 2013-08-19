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
@RequestMapping("/find")
public class FindController {

	@RequestMapping(method = RequestMethod.GET)
	public void setFanficRating(Model model, HttpServletRequest request) {
		System.out.println("Start");
		for (Fanfic fanfic : FanficModel.getInstance()
				.searchFanfics(request.getParameter("searchRequest"))) {
			System.out.println(fanfic.getName());
		}
		System.out.println("End");
	}
}
