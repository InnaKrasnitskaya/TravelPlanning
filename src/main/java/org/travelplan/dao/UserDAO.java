package org.travelplan.dao;

import java.util.List;
import org.travelplan.entity.User;

public interface UserDAO {
	public void addUser(User user);
    public List<User> listUser();
    public void removeUser(Integer id);
    public User findByName(String name);
}
