package by.itransition.fanfic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.model.FanficModel;
import by.itransition.fanfic.model.bean.Fanfic;

@Controller
@RequestMapping("/fanfic")
public class FanficController extends VisitPageController {

	@RequestMapping(value = "/{fanficId}", method = RequestMethod.GET)
	public String getFanfic(@PathVariable("fanficId") int fanficId,
			Model model, HttpServletRequest request) {
		settingModel(model, request);
		Fanfic fanfic = FanficModel.getInstance().getFanficById(fanficId);
		model.addAttribute("fanfic", fanfic);
		return "fanfic";
	}
}
