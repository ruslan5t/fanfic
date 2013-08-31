package by.itransition.fanfic.service;

import java.util.List;

import by.itransition.fanfic.domain.User;

/**
 * Class that represent interface of UserService. 
 */
public interface UserService {

	User login(String username, String password);

	int register(User user);

	List<User> getAllUsers();

	void save(User user);

	void remove(User user);

	User getUserById(int id);
	
	User getUserByName(String name);
	
	void removeUserById(int id);
	
	void confirmRegistration(int id);
	
	boolean isRegistered(String name, String password);
	
	boolean isRegistered(String name);
	
	List<Integer> getStatistics();

}
