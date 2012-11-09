package org.travelplan.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.travelplan.dao.RoleDAO;
import org.travelplan.entity.Role;

@Repository("roleDAO")
@Transactional
public class RoleDAOImpl implements RoleDAO {
	
    @Autowired
    private SessionFactory sessionFactory;	
	
    @SuppressWarnings("unchecked")
	public List<Role> listRole() {
        return sessionFactory.getCurrentSession().createQuery("SELECT " +
                "r FROM Role r").list();		
	}

}
