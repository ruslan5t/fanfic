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

	@Override
	@Transactional
	public User login(String username, String password) {
		return userDao.login(username, password);
	}

	@Override
	@Transactional
	public void register(User user) {
		userDao.register(user);
	}

	@Override
	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	@Transactional
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	@Transactional
	public void remove(User user) {
		userDao.remove(user);
	}

	@Override
	@Transactional
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	@Override
	@Transactional
	public User getUserByName(String name) {
		return userDao.getUserByName(name);
	}
	
	@Override
	@Transactional
	public void removeUserById(int id) {
		userDao.remove(getUserById(id));
	}

}
