package by.itransition.fanfic.model.bean;

import java.util.ArrayList;
import java.util.List;

import by.itransition.fanfic.dao.ChapterDao;
import by.itransition.fanfic.dao.FanficDao;
import by.itransition.fanfic.dao.UserDao;

public class User {

	private String username;

	private String password;

	private String email;

	private List<Fanfic> fanfics = new ArrayList<Fanfic>();

	private UserDao userDao;

	private FanficDao fanficDao;
	
	private ChapterDao chapterDao;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Fanfic> getFanfics() {
		return fanfics;
	}

	public void addFanfic(Fanfic fanfic) {
		fanfics.add(fanfic);
		fanficDao.addFanfic(fanfic);
		fanfic.setAuthor(this);
		fanfic.setChapterDao(chapterDao);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public FanficDao getFanficDao() {
		return fanficDao;
	}

	public void setFanficDao(FanficDao fanficDao) {
		this.fanficDao = fanficDao;
	}

	public ChapterDao getChapterDao() {
		return chapterDao;
	}

	public void setChapterDao(ChapterDao chapterDao) {
		this.chapterDao = chapterDao;
	}

}
