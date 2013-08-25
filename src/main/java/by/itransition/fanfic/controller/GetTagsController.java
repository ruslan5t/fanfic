package by.itransition.fanfic.controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.domain.Tag;
import by.itransition.fanfic.service.TagService;

@Controller
@RequestMapping("/getTags")
public class GetTagsController {

	@Autowired
	private TagService tagService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> getTags(Model model) {
		List<Tag> tags = tagService.getAllTags();
		JSONArray tagNamesJSON = new JSONArray();
		for (Tag tag : tags) {
			tagNamesJSON.add(tag.getName());
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("content-type", "text/plain;charset=UTF-8");;
		return new ResponseEntity<String>(tagNamesJSON.toJSONString(),
				responseHeaders, HttpStatus.CREATED);
	}

}
