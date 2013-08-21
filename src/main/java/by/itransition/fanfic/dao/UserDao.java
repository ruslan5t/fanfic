package by.itransition.fanfic.dao;

import java.util.List;

import by.itransition.fanfic.domain.User;

public interface UserDao {

	User login(String username, String password);

	void register(User user);
	
	List<User> getAllUsers();
	
	void save(User user);
	
	void remove(User user);
	
	User getUserById(int id);
	
	User getUserByName(String name);

}
