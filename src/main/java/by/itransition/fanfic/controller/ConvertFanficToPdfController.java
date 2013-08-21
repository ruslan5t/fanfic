package by.itransition.fanfic.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import by.itransition.fanfic.domain.Chapter;
import by.itransition.fanfic.domain.Fanfic;
import by.itransition.fanfic.model.FanficModel;

import com.petebevin.markdown.MarkdownProcessor;

@Controller
@RequestMapping("/convertFanficToPdf")
public class ConvertFanficToPdfController {

	@RequestMapping(value = "/{fanficId}", method = RequestMethod.POST)
	public  @ResponseBody
	String convertFanficToPdf(@PathVariable("fanficId") int fanficId) {
		Fanfic convertingFanfic = FanficModel.getInstance()
				.getFanficById(fanficId);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://do.convertapi.com/Web2Pdf/json?" +
				"storefile=true&OutputFileName=Fanfic&PageNo=true" +
				"&curl=" + convertToBook(convertingFanfic);
		String jsonStr = restTemplate.postForObject(url, null, String.class);
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
