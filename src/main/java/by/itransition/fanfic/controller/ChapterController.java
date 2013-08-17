package by.itransition.fanfic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.model.FanficModel;
import by.itransition.fanfic.model.bean.Chapter;
import by.itransition.fanfic.model.bean.Fanfic;

@Controller
@RequestMapping("/chapter")
public class ChapterController extends AbstractController {

	@RequestMapping(value = "/{fanficId}/{chapterName}",
			method = RequestMethod.GET)
	public String getChapter(@PathVariable("fanficId") int fanficId,
			@PathVariable("chapterName") String chapterName,
			Model model, HttpServletRequest request) {
		settingModel(model, request);
		Fanfic fanfic = FanficModel.getInstance().getFanficById(fanficId);
		for (Chapter chapter : fanfic.getChapters()) {
			if (chapter.getName().equals(chapterName)) {
				model.addAttribute("chapter", chapter);
				break;
			}
		}
		return "chapter";
	}
}
