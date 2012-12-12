package org.travelplan.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.travelplan.constant.Constant;
import org.travelplan.dao.RoleDAO;
import org.travelplan.entity.Role;

@Repository("roleDAO")
@Transactional
public class RoleDAOImpl extends CommonDAOImpl<Role> implements RoleDAO {
	
	public RoleDAOImpl() {
		super(Role.class);
	}
    
    public Role getRole(Constant.UserRoles userRoles) {
    	return (Role) getSession().createCriteria(Role.class).
    			add(Restrictions.eq("name", Constant.getUserRole(userRoles))).
    			list().get(0);		
    }
}
