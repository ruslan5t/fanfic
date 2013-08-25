package by.itransition.fanfic.controller;

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
	
	@Autowired
	private FanficService fanficService;
	
	@RequestMapping(value = "/{fanficId}", method = RequestMethod.GET)
	public String getAddChapterForm(@PathVariable("fanficId") int fanficId,	Model model) {
		settingModel(model);
		model.addAttribute("chapter", new Chapter());
		model.addAttribute("fanficId", fanficId);
		return "addChapter";
	}

	@RequestMapping(value = "/{fanficId}", method = RequestMethod.POST)
	public String createChapter(@PathVariable("fanficId") int fanficId,
			@ModelAttribute("chapter") Chapter chapter) {
		chapter.setContent(chapter.getContent());
		Fanfic fanfic = fanficService.getFanficById(fanficId);
		fanfic.addChapter(chapter);
		fanficService.save(fanfic);
		return "redirect:/fanfic/" + fanfic.getId();
	}
}
