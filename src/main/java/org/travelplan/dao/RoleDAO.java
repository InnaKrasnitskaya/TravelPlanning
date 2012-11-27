package org.travelplan.dao;

import java.util.List;

import org.travelplan.constant.Constant;
import org.travelplan.entity.Role;


public interface RoleDAO {
	public List<Role> getList();
	public Role getRole(Constant.UserRoles userRoles);
}
