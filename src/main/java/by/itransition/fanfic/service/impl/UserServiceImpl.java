package by.itransition.fanfic.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public User login(String name, String password) {
		User user = userDao.getUserByName(name);
		if (null != user && user.getPassword().equals(password)) {
			return user;
		} else {
			return null;
		}
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

	@Override
	@Transactional
	public boolean isRegistered(String name, String password) {
		User user = userDao.getUserByName(name);
		return null != user && user.getPassword().equals(password);
	}

	@Override
	@Transactional
	public boolean isRegistered(String name) {
		return null != userDao.getUserByName(name);
	}
	
	@Override
	@Transactional
	public List<Integer> getStatistics() {
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

}
