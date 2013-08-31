package by.itransition.fanfic.controller.visitPageController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.domain.Chapter;
import by.itransition.fanfic.domain.Fanfic;
import by.itransition.fanfic.service.FanficService;

import com.petebevin.markdown.MarkdownProcessor;

/**
 * Controller that show chapter.
 */
@Controller
@RequestMapping("/chapter")
public class ChapterController extends VisitPageController {

	@Autowired
	private FanficService fanficService;

	@RequestMapping(value = "/{fanficId}/{chapterId}",
			method = RequestMethod.GET)
	public String getChapter(@PathVariable("fanficId") int fanficId,
			@PathVariable("chapterId") int chapterId, Model model) {
		settingModel(model);
		Fanfic fanfic = fanficService.getFanficById(fanficId);
		model.addAttribute("fanfic", fanfic);
		Chapter chapter = fanfic.getChapterById(chapterId);
		model.addAttribute("chapter", chapter);
		MarkdownProcessor markdownProcessor = new MarkdownProcessor();
		model.addAttribute("chapterParsedContent", 
				markdownProcessor.markdown(chapter.getContent()));
		if (!fanfic.isFirstChapter(chapter)) {
			model.addAttribute("prevChapterName", fanfic.getPrevChapter(chapter).getName());
		}
		if (!fanfic.isLastChapter(chapter)) {
			model.addAttribute("nextChapterName", fanfic.getNextChapter(chapter).getName());
		}
		model.addAttribute("isFirstChapter",
				fanfic.isFirstChapter(chapter));
		model.addAttribute("isLastChapter",
				fanfic.isLastChapter(chapter));
		return "chapter";
	}

	@RequestMapping(value = "/prev/{fanficId}/{chapterId}",
			method = RequestMethod.GET)
	public String getPrevChapter(@PathVariable("fanficId") int fanficId,
			@PathVariable("chapterId") int chapterId, Model model) {
		Fanfic fanfic = fanficService.getFanficById(fanficId);
		return "redirect:/chapter/" + fanfic.getId() + "/"
		+ fanfic.getPrevChapter(fanfic.getChapterById(chapterId)).getId();
	}

	@RequestMapping(value = "/next/{fanficId}/{chapterId}",
			method = RequestMethod.GET)
	public String getNextChapter(@PathVariable("fanficId") int fanficId,
			@PathVariable("chapterId") int chapterId, Model model) {
		Fanfic fanfic = fanficService.getFanficById(fanficId);
		return "redirect:/chapter/" + fanfic.getId() + "/" 
		+ fanfic.getNextChapter(fanfic.getChapterById(chapterId)).getId();
	}


}
