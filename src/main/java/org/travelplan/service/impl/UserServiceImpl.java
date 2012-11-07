package org.travelplan.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.travelplan.entity.Users;
import org.travelplan.dao.UserDAO;
import org.travelplan.service.UserService;
 
@Service("userService")
public class UserServiceImpl implements UserService {
 
    @Autowired
    private UserDAO userDAO;
 
    @Transactional
    public void addUser(Users user) {
        userDAO.addUser(user);
    }
 
    @Transactional
    public List<Users> listUser() {
 
        return userDAO.listUser();
    }
 
    @Transactional
    public void removeUser(Integer id) {
        userDAO.removeUser(id);
    } 
}