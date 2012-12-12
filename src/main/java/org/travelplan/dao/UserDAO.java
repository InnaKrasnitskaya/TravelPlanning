package org.travelplan.dao;

import org.travelplan.entity.User;

public interface UserDAO extends CommonDAO<User> {
    public User findByName(String name);
}
