package org.travelplan.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.travelplan.dao.UserDAO;
import org.travelplan.entity.Users; 
 
@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	
    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(Users user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @SuppressWarnings("unchecked")
    public List<Users> listUser() {

        return sessionFactory.getCurrentSession().createQuery("FROM Users").list();
    }

    public void removeUser(Integer id) {
        Users user = (Users) sessionFactory.getCurrentSession().load(Users.class, id);
        if (null != user) {
            sessionFactory.getCurrentSession().delete(user);
        }

    }
    
    public Users findByName(String name) {
     // String query = ; //where Name='" + name + "'"; 	
     // return (Users) sessionFactory.getCurrentSession().
    //		  createQuery("SELECT u FROM Users u");
    	
    //	List<Users> list = sessionFactory.getCurrentSession().
    //			createQuery("select u from Users u").list();
    	//return (list.isEmpty() ? null : list.get(0));   	
    	Users u = new Users();
    	u = (Users)sessionFactory.getCurrentSession().
    		createQuery("select u from Users u").list().get(0); //uniqueResult
	
   /*  	u.setName("inna");
     	u.setPassword("123");*/
     	return u;
    }
}
