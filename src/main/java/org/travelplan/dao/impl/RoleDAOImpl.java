package org.travelplan.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.travelplan.constant.Constant;
import org.travelplan.dao.RoleDAO;
import org.travelplan.entity.Role;

@Repository("roleDAO")
@Transactional
public class RoleDAOImpl implements RoleDAO {
	private static final String RoleSelect = "SELECT r FROM Role r";
	private static final String RoleNameCondition = " where name='%s'";
	
    @Autowired
    private SessionFactory sessionFactory;	
	
    @SuppressWarnings("unchecked")
	public List<Role> getList() {
        return sessionFactory.getCurrentSession().createQuery(RoleSelect).list();		
	}
    
    public Role getRole(Constant.UserRoles userRoles) {
    	return (Role)sessionFactory.getCurrentSession().createQuery(RoleSelect + 
    			String.format(RoleNameCondition, Constant.getUserRole(userRoles))).list().get(0);		
    }
}
