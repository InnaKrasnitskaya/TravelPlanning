package org.travelplan.service;

import org.travelplan.constant.Constant;
import org.travelplan.entity.Role;

public interface RoleService extends CommonService<Role> {
	public Role getRole(Constant.UserRoles userRoles);
}
