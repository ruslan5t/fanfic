package by.itransition.fanfic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.domain.Chapter;
import by.itransition.fanfic.domain.Fanfic;
import by.itransition.fanfic.service.ChapterService;
import by.itransition.fanfic.service.FanficService;

@Controller
@RequestMapping("/editChapter")
public class EditChapterController extends VisitPageController {

	@Autowired
	private FanficService fanficService;
	
	@Autowired
	private ChapterService chapterService;

	@RequestMapping(value = "/{fanficId}/{chapterId}", method = RequestMethod.GET)
	public String getChapterEditForm(@PathVariable("fanficId") int fanficId,
			@PathVariable("chapterId") int chapterId,
			Model model, HttpServletRequest request) {
		settingModel(model, request);
		Chapter newChapter = new Chapter();
		copyChapter(newChapter, fanficService.getFanficById(fanficId).getChapterById(chapterId));
		model.addAttribute("newChapter", newChapter);
		model.addAttribute("editingFanficId", fanficId);
		model.addAttribute("editingChapterId", chapterId);
		return "editChapter";
	}

	@RequestMapping(value="/{editingFanficId}/{editingChapterId}",
			method = RequestMethod.POST)
	public String createFanfic(
			@PathVariable("editingFanficId") int editingFanficId,
			@PathVariable("editingChapterId") int editingChapterId,
			@ModelAttribute("newChapter") Chapter newChapter,
			HttpServletRequest request) {
		Fanfic editingFanfic = fanficService.getFanficById(editingFanficId);
		Chapter editingChapter = editingFanfic.getChapterById(editingChapterId);
		copyChapter(editingChapter, newChapter);
		chapterService.save(editingChapter);
		return "redirect:/chapter/" + editingFanficId + "/" + editingChapterId;
	}

	private void copyChapter(Chapter copyInto, Chapter copyFrom) {
		copyInto.setName(copyFrom.getName());
		copyInto.setContent(copyFrom.getContent());
	}

}
