package org.travelplan.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.travelplan.dao.UserDAO;
import org.travelplan.entity.User; 
 
@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	
    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> listUser() {
        return sessionFactory.getCurrentSession().createQuery("SELECT " +
          "u FROM User u").list();
    }

    public void removeUser(Integer id) {
        User user = (User) sessionFactory.getCurrentSession().load(User.class, id);
        if (null != user) {
          sessionFactory.getCurrentSession().delete(user);
        }

    }
    
    public User findByName(String name) {
      return (User) sessionFactory.getCurrentSession().
        createQuery("SELECT u FROM User u where name='" + name + "'").uniqueResult();
    }
}
