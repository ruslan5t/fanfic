package by.itransition.fanfic.dao;

import java.util.List;

import by.itransition.fanfic.model.bean.User;

public interface UserDao {

	User login(String username, String password);

	void register(User user);
	
	List<User> getUsers();
	
	void save(User user);
	
	void deleteAll();
	
	void remove(User user);
}
