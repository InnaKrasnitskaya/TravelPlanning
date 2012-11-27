package org.travelplan.service;

import java.util.List;
import org.travelplan.entity.User;

public interface UserService {
	public void add(User user);
    public List<User> getList();
    public void remove(Integer id);
    public User findByName(String name);   
    public User findById(Integer id);
}

