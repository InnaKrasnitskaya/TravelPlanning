package org.travelplan.dao;

import java.util.List;
import org.travelplan.entity.Users;

public interface UserDAO {
	public void addUser(Users user);
    public List<Users> listUser();
    public void removeUser(Integer id);
    public Users findByName(String name);
}
