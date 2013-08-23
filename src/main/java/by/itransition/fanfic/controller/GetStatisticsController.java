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

import by.itransition.fanfic.service.UserService;

@Controller
@RequestMapping("/getStatistics")
public class GetStatisticsController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	String getStatistics(Model model, HttpServletRequest request) {
		List<Integer> statistics = userService.getStatistics();
		JSONArray statisticsJSON = new JSONArray();
		for (int statisticsByTimeIndex = 0;
				statisticsByTimeIndex < statistics.size();
				++statisticsByTimeIndex) {
			JSONArray statisticsByTimeJSON = new JSONArray();
			statisticsByTimeJSON.add( 
					String.valueOf(statisticsByTimeIndex + 1));
			statisticsByTimeJSON.add(
					statistics.get(statisticsByTimeIndex));
			statisticsJSON.add(statisticsByTimeJSON);
		}
		return statisticsJSON.toJSONString();
	}
}
