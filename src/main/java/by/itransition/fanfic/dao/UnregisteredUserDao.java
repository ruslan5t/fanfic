package by.itransition.fanfic.dao;

import by.itransition.fanfic.domain.UnregisteredUser;

/**
 * Class that represent interface for UnregisteredUserDao. 
 */
public interface UnregisteredUserDao {
	
	void save(UnregisteredUser unregisteredUser);
	
	UnregisteredUser getUnregisteredUserById(int id);
	
	void remove(UnregisteredUser unregisteredUser);
	
}
