package by.itransition.fanfic.service;

import java.util.List;

import by.itransition.fanfic.domain.User;

public interface UserService {

	User login(String username, String password);

	void register(User user);

	List<User> getAllUsers();

	void save(User user);

	void remove(User user);

	User getUserById(int id);
	
	User getUserByName(String name);
	
	void removeUserById(int id);

}
