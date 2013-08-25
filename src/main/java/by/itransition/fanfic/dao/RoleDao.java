package by.itransition.fanfic.dao;

import by.itransition.fanfic.domain.Role;

public interface RoleDao {

	Role getRoleByName(String name);
	
	void save(Role role);
	
}
