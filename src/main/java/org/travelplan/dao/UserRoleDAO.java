package org.travelplan.dao;

import java.util.List;

import org.travelplan.entity.UserRole;

public interface UserRoleDAO extends CommonDAO<UserRole> {
	public List<UserRole> getUserRoles(String userName);
}
