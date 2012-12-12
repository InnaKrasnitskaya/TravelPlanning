package org.travelplan.dao;

import org.travelplan.constant.Constant;
import org.travelplan.entity.Role;


public interface RoleDAO extends CommonDAO<Role> {
	public Role getRole(Constant.UserRoles userRoles);
}
