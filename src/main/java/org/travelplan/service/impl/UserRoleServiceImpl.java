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
	
	public List<UserRole> listUserRole() {
		return userRoleDAO.listUserRole();
	}
	
	public List<UserRole> getUserRoles(String userName) {
		return userRoleDAO.getUserRoles(userName);
	}
	
	public void addUserRole(UserRole userRole) {
		userRoleDAO.addUserRole(userRole);
	}
}
