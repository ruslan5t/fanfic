package by.itransition.fanfic.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.itransition.fanfic.dao.FanficDao;
import by.itransition.fanfic.dao.UserDao;
import by.itransition.fanfic.dao.impl.FanficDaoImpl;
import by.itransition.fanfic.dao.impl.UserDaoImpl;
import by.itransition.fanfic.domain.Fanfic;
import by.itransition.fanfic.domain.User;

public class FanficModel {

	private static FanficModel fanficModel = new FanficModel();

	private UserDao userDao = new UserDaoImpl();

	private FanficDao fanficDao = new FanficDaoImpl();

	public static FanficModel getInstance() {
		return fanficModel;
	}
	
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}
	
	public List<Integer> getStatistic() {
		List<Integer> answer = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Calendar calendar = Calendar.getInstance();
		calendar.clear(Calendar.SECOND);
		calendar.clear(Calendar.MILLISECOND);
		for (int minutesBeforeNow = 0; minutesBeforeNow < 10; ++minutesBeforeNow) {
			for (User user : userDao.getAllUsers()) {
				Date userDate = user.getDateOfRegistration();
				Calendar userCalendar = Calendar.getInstance();
				userCalendar.setTime(userDate);
				userCalendar.clear(Calendar.SECOND);
				userCalendar.clear(Calendar.MILLISECOND);
				if (userCalendar.getTime().equals(calendar.getTime())) {
					if (null == map.get(minutesBeforeNow)) {
						map.put(minutesBeforeNow, 1);
					} else {
						map.put(minutesBeforeNow, map.get(minutesBeforeNow) + 1);
					}
				}
			}
			calendar.add(Calendar.MINUTE, -1);
		}
		for (int minutesBeforeNow = 0; minutesBeforeNow < 10; ++minutesBeforeNow) {
			if (null != map.get(minutesBeforeNow)) {
				answer.add(map.get(minutesBeforeNow));
			} else {
				answer.add(0);
			}
		}
		return answer;
	}

	public List<Fanfic> getBestFanfics(int count) {
		List<Fanfic> fanfics = fanficDao.getAllFanfics();
		Collections.sort(fanfics, new Comparator<Fanfic>() {
 			public int compare(Fanfic first, Fanfic second) {
				if (first.getRating() > second.getRating()) {
					return 1;
				} else {
					if (first.getRating() < second.getRating()) {
						return -1;
					} else {
						return 0;
					}
				}
			}
		});
		if (count > fanfics.size()) {
			return fanfics;
		} else {
			return fanfics.subList(0, count);
		}
	}

}
