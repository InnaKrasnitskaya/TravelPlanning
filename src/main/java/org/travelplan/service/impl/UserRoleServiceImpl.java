package org.travelplan.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.travelplan.dao.UserRoleDAO;
import org.travelplan.entity.UserRole;
import org.travelplan.service.UserRoleService;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {
	
	@Inject
	private UserRoleDAO userRoleDAO; 
	
	public List<UserRole> getList() {
		return userRoleDAO.getList();
	}
	
	public List<UserRole> getUserRoles(String userName) {
		return userRoleDAO.getUserRoles(userName);
	}
	
	public void add(UserRole userRole) {
		userRoleDAO.add(userRole);
	}
}
