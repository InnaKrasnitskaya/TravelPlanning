package org.travelplan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.travelplan.constant.Constant;
import org.travelplan.dao.RoleDAO;
import org.travelplan.entity.Role;
import org.travelplan.service.RoleService;

@Service("RoleService")
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDAO roleDAO;
	
	public List<Role> getList() {
		return roleDAO.getList();
	}
	
	public Role getRole(Constant.UserRoles userRoles) {
		return roleDAO.getRole(userRoles);
	}
}
