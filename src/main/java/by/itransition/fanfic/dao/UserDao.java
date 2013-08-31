package by.itransition.fanfic.dao;

import java.util.List;

import by.itransition.fanfic.domain.User;

/**
 * Class that represent interface for UserDao. 
 */
public interface UserDao {
	
	List<User> getAllUsers();
	
	void save(User user);
	
	void remove(User user);
	
	User getUserById(int id);
	
	User getUserByName(String name);

}
