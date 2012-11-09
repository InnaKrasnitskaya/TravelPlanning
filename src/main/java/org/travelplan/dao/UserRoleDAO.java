package org.travelplan.dao;

import java.util.List;

import org.travelplan.entity.UserRole;

public interface UserRoleDAO {
	public List<UserRole> listUserRole();
	public List<UserRole> getUserRoles(String userName);
}
