package org.travelplan.dao.impl;

import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.travelplan.dao.UserRoleDAO;
import org.travelplan.entity.UserRole;

@Repository("userRoleDAO")
@Transactional
public class UserRoleDAOImpl extends CommonDAOImpl<UserRole> implements UserRoleDAO {
	
	public UserRoleDAOImpl() {
		super(UserRole.class);
	}
		
	@SuppressWarnings("unchecked")
	public List<UserRole> getUserRoles(String userName) {
        return getSession().createCriteria(UserRole.class).
        		createAlias("user", "u").
        		add(Restrictions.eq("u.name", userName)).list();	
	}
}
