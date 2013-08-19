package by.itransition.fanfic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.model.FanficModel;
import by.itransition.fanfic.model.bean.Fanfic;

@Controller
@RequestMapping("/editFanfic")
public class EditFanficController extends AbstractController {

	@RequestMapping(value = "/{fanficId}", method = RequestMethod.GET)
	public String getFanficEditForm(@PathVariable("fanficId") int fanficId,
			Model model, HttpServletRequest request) {
		settingModel(model, request);
		Fanfic editingFanfic = FanficModel.getInstance().getFanficById(fanficId);
		Fanfic newFanfic = new Fanfic();
		copyFanfic(newFanfic, editingFanfic);
		model.addAttribute("newFanfic", newFanfic);
		model.addAttribute("editingFanficId", editingFanfic.getId());
		return "editFanfic";
	}

	@RequestMapping(value="/{editingFanficId}", method = RequestMethod.POST)
	public String editFanfic(
			@PathVariable("editingFanficId") int editingFanficId,
			@ModelAttribute("newFanfic") Fanfic newFanfic,
			HttpServletRequest request) {
		Fanfic editingFanfic = FanficModel.getInstance()
				.getFanficById(editingFanficId);
		copyFanfic(editingFanfic, newFanfic);
		return "redirect:/fanfic/" + editingFanficId;
	}
	
	private void copyFanfic(Fanfic copyInto, Fanfic copyFrom) {
		copyInto.setName(copyFrom.getName());
		copyInto.setDescription(copyFrom.getDescription());
		copyInto.setTags(copyFrom.getTags());
		copyInto.setCategories(copyFrom.getCategories());
	}
}
