package by.itransition.fanfic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itransition.fanfic.dao.RoleDao;
import by.itransition.fanfic.domain.Role;
import by.itransition.fanfic.service.RoleService;

/**
 * Class that represent implementation of RoleService. 
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public Role getRoleByName(String name) {
		return roleDao.getRoleByName(name);
	}
	
}
