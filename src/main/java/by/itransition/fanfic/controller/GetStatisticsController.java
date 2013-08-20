package by.itransition.fanfic.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import by.itransition.fanfic.model.FanficModel;

@Controller
@RequestMapping("/getStatistics")
public class GetStatisticsController {

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	String getStatistics(Model model, HttpServletRequest request) {
		List<Integer> statistics = FanficModel.getInstance().getStatistic();
		JSONArray statisticsJSON = new JSONArray();
		for (int statisticsByTimeIndex = 0;
				statisticsByTimeIndex < statistics.size();
				++statisticsByTimeIndex) {
			JSONObject statisticsByTimeJSON = new JSONObject();
			statisticsByTimeJSON.put("day", statisticsByTimeIndex + 1);
			statisticsByTimeJSON.put("orange",
					statistics.get(statisticsByTimeIndex));
			statisticsJSON.add(statisticsByTimeJSON);
		}
		return statisticsJSON.toJSONString();
	}
}