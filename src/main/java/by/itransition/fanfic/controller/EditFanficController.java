package by.itransition.fanfic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.domain.Fanfic;
import by.itransition.fanfic.service.FanficService;

@Controller
@RequestMapping("/editFanfic")
public class EditFanficController extends InputFanficController {

	@Autowired
	private FanficService fanficService;
	
	@RequestMapping(value = "/{fanficId}", method = RequestMethod.GET)
	public String getFanficEditForm(@PathVariable("fanficId") int fanficId,
			Model model, HttpServletRequest request) {
		settingModel(model, request);
		Fanfic editingFanfic = fanficService.getFanficById(fanficId);
		Fanfic newFanfic = new Fanfic();
		copyFanfic(newFanfic, editingFanfic);
		model.addAttribute("newFanfic", newFanfic);
		model.addAttribute("newFanfic", newFanfic);
		model.addAttribute("editingFanficId", editingFanfic.getId());
		return "editFanfic";
	}

	@RequestMapping(value="/{editingFanficId}", method = RequestMethod.POST)
	public String editFanfic(
			@PathVariable("editingFanficId") int editingFanficId,
			@ModelAttribute("newFanfic") Fanfic newFanfic,
			HttpServletRequest request) {
		Fanfic editingFanfic = fanficService.getFanficById(editingFanficId);
		correctFanfic(newFanfic);
		copyFanfic(editingFanfic, newFanfic);
		fanficService.save(editingFanfic);
		return "redirect:/fanfic/" + editingFanficId;
	}
	
	private void copyFanfic(Fanfic copyInto, Fanfic copyFrom) {
		copyInto.setName(copyFrom.getName());
		copyInto.setDescription(copyFrom.getDescription());
		copyInto.setTags(copyFrom.getTags());
		copyInto.setCategories(copyFrom.getCategories());
	}
}
