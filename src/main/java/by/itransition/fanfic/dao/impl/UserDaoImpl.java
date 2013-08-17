package by.itransition.fanfic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import by.itransition.fanfic.dao.UserDao;
import by.itransition.fanfic.model.bean.User;

public class UserDaoImpl implements UserDao {

	private List<User> users = new ArrayList<User>();

	@Override
	public User login(String username, String password) {
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public void register(User user) {
		users.add(user);
	}

	@Override
	public List<User> getUsers() {
		return users;
	}
}
