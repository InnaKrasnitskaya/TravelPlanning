package org.travelplan.service;

import org.travelplan.entity.User;

public interface UserService extends CommonService<User> {
    public User findByName(String name);   
}

