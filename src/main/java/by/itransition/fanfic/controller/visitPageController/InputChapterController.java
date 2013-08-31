package by.itransition.fanfic.controller.visitPageController;

import org.springframework.ui.Model;

import by.itransition.fanfic.domain.Chapter;

/**
 * Abstract class that ckeck errors input.
 */
public abstract class InputChapterController extends VisitPageController {

	protected boolean checkErrorsInput(Chapter chapter, Model model) {
		boolean isErrorInput = false;
		if (chapter.getName().matches("\\s*")) {
			model.addAttribute("emptyTitle", true);
			isErrorInput = true;
		}
		if (chapter.getContent().matches("\\s*")) {
			model.addAttribute("emptyContent", true);
			isErrorInput = true;
		}
		return isErrorInput;
	}
}
