package by.itransition.fanfic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.itransition.fanfic.dao.UserDao;
import by.itransition.fanfic.domain.User;
import by.itransition.fanfic.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Transactional
	public User login(String username, String password) {
		return userDao.login(username, password);
	}

	@Transactional
	public void register(User user) {
		userDao.register(user);
	}

	@Transactional
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Transactional
	public void save(User user) {
		userDao.save(user);
	}

	@Transactional
	public void remove(User user) {
		userDao.remove(user);
	}

	@Transactional
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

}
