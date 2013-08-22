package by.itransition.fanfic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.domain.Chapter;
import by.itransition.fanfic.domain.Fanfic;
import by.itransition.fanfic.service.FanficService;

@Controller
@RequestMapping("/addChapter")
public class AddChapterController extends VisitPageController {
	
	private Fanfic fanfic;
	
	@Autowired
	private FanficService fanficService;
	
	@RequestMapping(value = "/{fanficId}", method = RequestMethod.GET)
	public String getAddChapterForm(
			@PathVariable("fanficId") int fanficId,
			Model model, HttpServletRequest request) {
		settingModel(model, request);
		fanfic = fanficService.getFanficById(fanficId);
		model.addAttribute("chapter", new Chapter());
		return "addChapter";
	}

	@RequestMapping(value = "/{fanficId}", method = RequestMethod.POST)
	public String createChapter(@ModelAttribute("chapter") Chapter chapter,
			BindingResult bindingResult, HttpServletRequest request) {
		chapter.setContent(chapter.getContent());
		fanfic.addChapter(chapter);
		fanficService.save(fanfic);
		return "redirect:/fanfic/" + fanfic.getId();
	}
}
