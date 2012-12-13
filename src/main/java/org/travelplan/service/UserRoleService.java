package org.travelplan.service;

import java.util.List;
import org.travelplan.entity.UserRole;

public interface UserRoleService extends CommonService<UserRole> {
	public List<UserRole> getUserRoles(String userName);
}
