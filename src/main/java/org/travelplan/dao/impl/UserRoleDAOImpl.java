package org.travelplan.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.travelplan.dao.UserRoleDAO;
import org.travelplan.entity.UserRole;


@Repository("userRoleDAO")
@Transactional
public class UserRoleDAOImpl implements UserRoleDAO {
	
	private static final String UserRoleSelect = "SELECT ur FROM UserRole ur";
	private static final String UserRoleSelByUserName = "SELECT " +
            "ur FROM UserRole ur JOIN ur.user u WHERE u.name='%s'";
	
    @Autowired
    private SessionFactory sessionFactory;		
	
	@SuppressWarnings("unchecked")
	public List<UserRole> getList() {
        return sessionFactory.getCurrentSession().createQuery(UserRoleSelect).list();		
	}
	
	@SuppressWarnings("unchecked")
	public List<UserRole> getUserRoles(String userName) {
        return sessionFactory.getCurrentSession().createQuery(String.
        		format(UserRoleSelByUserName, userName)).list();			
	}
	
	public void add(UserRole userRole) {
		sessionFactory.getCurrentSession().save(userRole);
	}
}
