package by.itransition.fanfic.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import by.itransition.fanfic.domain.Chapter;
import by.itransition.fanfic.domain.Fanfic;
import by.itransition.fanfic.service.FanficService;

import com.petebevin.markdown.MarkdownProcessor;

@Controller
@RequestMapping("/convertFanficToPdf")
public class ConvertFanficToPdfController {

	@Autowired
	private FanficService fanficService;
	
	@RequestMapping(value = "/{fanficId}", method = RequestMethod.POST)
	public  @ResponseBody
	String convertFanficToPdf(@PathVariable("fanficId") int fanficId) {
		Fanfic convertingFanfic = fanficService.getFanficById(fanficId);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://do.convertapi.com/Web2Pdf/json";
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("curl", convertToBook(convertingFanfic));
		map.add("storefile", "true");
		map.add("OutputFileName", "Fanfic");
		map.add("PageNo", "true");
		String jsonStr = restTemplate.postForObject(url, map, String.class);
		JSONObject responseOfService = null;
		JSONParser parser = new JSONParser();
		try {
			responseOfService = (JSONObject) parser.parse(jsonStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return responseOfService.get("FileUrl").toString();
	}
	
	private String convertToBook(Fanfic convertingFanfic) {
		StringBuilder convertedBook = new StringBuilder();
		convertedBook.append("<center><h2>" + convertingFanfic.getName() +
				"</h2></center>");
		for (Chapter chapter : convertingFanfic.getChapters()) {
			convertedBook.append("<center><h4>" + chapter.getName() +
					"</h4></center>");
			convertedBook.append(chapter.getContent());
		}
		MarkdownProcessor markdownProcessor = new MarkdownProcessor();
		return markdownProcessor.markdown(convertedBook.toString());
	}
}
