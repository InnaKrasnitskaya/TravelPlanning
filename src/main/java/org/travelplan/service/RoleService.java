package org.travelplan.service;

import java.util.List;

import org.travelplan.constant.Constant;
import org.travelplan.entity.Role;

public interface RoleService {
	public List<Role> listRole();
	public Role getRole(Constant.UserRoles userRoles);
}