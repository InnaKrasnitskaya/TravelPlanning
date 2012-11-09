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
	
    @Autowired
    private SessionFactory sessionFactory;		
	
	@SuppressWarnings("unchecked")
	public List<UserRole> listUserRole() {
        return sessionFactory.getCurrentSession().createQuery("SELECT " +
                "ur FROM UserRole ur").list();		
	}
	
	@SuppressWarnings("unchecked")
	public List<UserRole> getUserRoles(String userName) {
        return sessionFactory.getCurrentSession().createQuery("SELECT " +
                "ur FROM UserRole ur JOIN ur.user u WHERE u.name='" + userName + "'").list();			
	}
}
