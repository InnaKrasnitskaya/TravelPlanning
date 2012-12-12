package org.travelplan.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.travelplan.dao.UserDAO;
import org.travelplan.entity.User; 
 
@Repository("userDAO")
@Transactional
public class UserDAOImpl extends CommonDAOImpl<User> implements UserDAO {
	
	public UserDAOImpl() {
		super(User.class);
	}
   
    public User findByName(String name) {
      return (User) getSession().
    		  createCriteria(User.class).
    		  add(Restrictions.eq("name", name)).
    		  uniqueResult();
    }
}
