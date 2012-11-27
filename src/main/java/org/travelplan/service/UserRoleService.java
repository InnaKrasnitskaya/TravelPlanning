package org.travelplan.service;

import java.util.List;
import org.travelplan.entity.UserRole;

public interface UserRoleService {
	public List<UserRole> getList();
	public List<UserRole> getUserRoles(String userName);
	public void add(UserRole userRole);
}
