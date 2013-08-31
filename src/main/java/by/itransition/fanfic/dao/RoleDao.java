package by.itransition.fanfic.dao;

import by.itransition.fanfic.domain.Role;

/**
 * Class that represent interface for RoleDao. 
 */
public interface RoleDao {

	Role getRoleByName(String name);
	
	void save(Role role);
	
}
