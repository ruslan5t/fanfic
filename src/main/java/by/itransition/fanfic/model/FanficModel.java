package by.itransition.fanfic.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import by.itransition.fanfic.dao.ChapterDao;
import by.itransition.fanfic.dao.FanficDao;
import by.itransition.fanfic.dao.UserDao;
import by.itransition.fanfic.dao.impl.ChapterDaoImpl;
import by.itransition.fanfic.dao.impl.FanficDaoImpl;
import by.itransition.fanfic.dao.impl.UserDaoImpl;
import by.itransition.fanfic.model.bean.Fanfic;
import by.itransition.fanfic.model.bean.User;

public class FanficModel {

	private static FanficModel fanficModel = new FanficModel();
	private UserDao userDao = new UserDaoImpl();
	private FanficDao fanficDao = new FanficDaoImpl();
	private ChapterDao chapterDao = new ChapterDaoImpl();
	
	private FanficModel() {
		
	}
	
	public void clear() {
		fanficModel = new FanficModel();
	}
	
	public static FanficModel getInstance() {
		return fanficModel;
	}
	
	public void registerUser(User user) {
		userDao.register(user);
		user.setFanficDao(fanficDao);
		user.setChapterDao(chapterDao);
	}
	
	public List<Fanfic> getAllFanfics() {
		return fanficDao.getFanfics();
	}
	
	public boolean isRegistered(String username, String password) {
		return null != userDao.login(username, password);
	}
	
	public User getUser(String username) {
		for (User user : userDao.getUsers()) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}
	
	public List<User> getAllUsers() {
		return userDao.getUsers();
	}
	
	public List<Fanfic> getBestFanfics(int count) {
		List<Fanfic> fanfics = fanficDao.getFanfics();
		Collections.sort(fanfics, new Comparator<Fanfic>() {
			@Override
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
	
	public Fanfic getFanficById(int id) {
		for (Fanfic fanfic : fanficDao.getFanfics()) {
			if (fanfic.getId() == id) {
				return fanfic;
			}
		}
		return null;
	}
	
}
