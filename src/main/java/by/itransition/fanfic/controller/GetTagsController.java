package by.itransition.fanfic.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import by.itransition.fanfic.domain.Tag;
import by.itransition.fanfic.model.FanficModel;
import by.itransition.fanfic.service.FanficService;
import by.itransition.fanfic.service.TagService;

@Controller
@RequestMapping("/getTags")
public class GetTagsController {
	
	@Autowired
	private TagService tagService;
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	String getTags(Model model, HttpServletRequest request) {
		List<Tag> tags = tagService.getAllTags();
		JSONArray tagNamesJSON = new JSONArray();
		for (Tag tag : tags) {
			tagNamesJSON.add(tag.getName());
		}
		return tagNamesJSON.toJSONString();
	}

}
