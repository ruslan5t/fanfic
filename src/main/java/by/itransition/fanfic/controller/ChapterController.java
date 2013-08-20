package by.itransition.fanfic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.petebevin.markdown.MarkdownProcessor;

import by.itransition.fanfic.model.FanficModel;
import by.itransition.fanfic.model.bean.Chapter;
import by.itransition.fanfic.model.bean.Fanfic;

@Controller
@RequestMapping("/chapter")
public class ChapterController extends VisitPageController {

	@RequestMapping(value = "/{fanficId}/{chapterId}",
			method = RequestMethod.GET)
	public String getChapter(@PathVariable("fanficId") int fanficId,
			@PathVariable("chapterId") int chapterId,
			Model model, HttpServletRequest request) {
		settingModel(model, request);
		Fanfic fanfic = FanficModel.getInstance().getFanficById(fanficId);
		model.addAttribute("fanfic", fanfic);
		Chapter chapter = fanfic.getChapterById(chapterId);
		model.addAttribute("chapter", chapter);
		MarkdownProcessor markdownProcessor = new MarkdownProcessor();
		model.addAttribute("chapterParsedContent", 
				markdownProcessor.markdown(chapter.getContent()));
		return "chapter";
	}
}
