package by.itransition.fanfic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.petebevin.markdown.MarkdownProcessor;

import by.itransition.fanfic.model.FanficModel;
import by.itransition.fanfic.model.bean.Chapter;
import by.itransition.fanfic.model.bean.Fanfic;

@Controller
@RequestMapping("/addChapter")
public class AddChapterController extends VisitPageController {
	
	private Fanfic fanfic;
	
	@RequestMapping(value = "/{fanficId}", method = RequestMethod.GET)
	public String getAddChapterForm(
			@PathVariable("fanficId") int fanficId,
			Model model, HttpServletRequest request) {
		settingModel(model, request);
		fanfic = FanficModel.getInstance().getFanficById(fanficId);
		model.addAttribute("chapter", new Chapter());
		return "addChapter";
	}

	@RequestMapping(value = "/{fanficId}", method = RequestMethod.POST)
	public String createChapter(@ModelAttribute("chapter") Chapter chapter,
			BindingResult bindingResult, HttpServletRequest request) {
		chapter.setContent(chapter.getContent());
		fanfic.addChapter(chapter);
		FanficModel.getInstance().save(fanfic);
		return "redirect:/fanfic/" + fanfic.getId();
	}
}
