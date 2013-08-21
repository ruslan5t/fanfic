package by.itransition.fanfic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.itransition.fanfic.dao.UnregisteredUserDao;
import by.itransition.fanfic.dao.UserDao;
import by.itransition.fanfic.domain.UnregisteredUser;
import by.itransition.fanfic.domain.User;
import by.itransition.fanfic.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UnregisteredUserDao unregisteredUserDao;

	@Override
	@Transactional
	public User login(String username, String password) {
		return userDao.login(username, password);
	}

	@Override
	@Transactional
	public int register(User user) {
		UnregisteredUser unregisteredUser = new UnregisteredUser();
		unregisteredUser.setEmail(user.getEmail());
		unregisteredUser.setPassword(user.getPassword());
		unregisteredUser.setName(user.getUsername());
		unregisteredUserDao.save(unregisteredUser);
		return unregisteredUser.getId();
	}

	@Override
	@Transactional
	public void confirmRegistration(int id) {
		UnregisteredUser unregisteredUser = unregisteredUserDao.getUnregisteredUserById(id);
		if (null != unregisteredUser) {
			unregisteredUserDao.remove(unregisteredUser);
			User user = new User();
			user.setUsername(unregisteredUser.getName());
			user.setEmail(unregisteredUser.getEmail());
			user.setPassword(unregisteredUser.getPassword());
			userDao.save(user);
		}
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
