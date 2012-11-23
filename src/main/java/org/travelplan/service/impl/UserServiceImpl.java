package org.travelplan.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.travelplan.entity.User;
import org.travelplan.dao.UserDAO;
import org.travelplan.service.UserService;
 
@Service("userService")
public class UserServiceImpl implements UserService {
 
    @Autowired
    private UserDAO userDAO;
 
    public void addUser(User user) {
        userDAO.addUser(user);
    }
 
    public List<User> listUser() { 
        return userDAO.listUser();
    }
 
    public void removeUser(Integer id) {
        userDAO.removeUser(id);
    } 
    
    public User findByName(String name) {
    	return userDAO.findByName(name);
    }
    
    public User findById(Integer id) {
    	return userDAO.findById(id);
    }
}