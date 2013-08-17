package by.itransition.fanfic.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.model.FanficModel;
import by.itransition.fanfic.model.bean.Fanfic;

@Controller
@RequestMapping("/catalog")
public class CatalogController extends AbstractController {

	@RequestMapping(method = RequestMethod.GET)
	public String getCatalog(Model model, HttpServletRequest request) {
		settingModel(model, request);
		List<Fanfic> fanfics = FanficModel.getInstance().getAllFanfics();
		model.addAttribute("allFanfics", fanfics);
		return "catalog";
	}
}
