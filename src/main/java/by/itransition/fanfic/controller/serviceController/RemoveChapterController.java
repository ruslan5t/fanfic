package by.itransition.fanfic.controller.serviceController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.domain.Fanfic;
import by.itransition.fanfic.service.FanficService;

/**
 * Controller that remove chapter.
 */
@Controller
@RequestMapping("/removeChapter")
public class RemoveChapterController {

	@Autowired
	private FanficService fanficService;

	@RequestMapping(value = "/{fanficId}/{chapterId}", method = RequestMethod.POST)
	public String removeChapter(@PathVariable("fanficId") int fanficId,
			@PathVariable("chapterId") int chapterId) {
		Fanfic fanfic = fanficService.getFanficById(fanficId);
		fanfic.removeChapterById(chapterId);
		fanficService.save(fanfic);
		return "redirect:/fanfic/" + fanficId;
	}
}
