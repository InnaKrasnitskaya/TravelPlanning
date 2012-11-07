package org.travelplan.service;

import java.util.List;
import org.travelplan.entity.Users;

public interface UserService {
	public void addUser(Users user);
    public List<Users> listUser();
    public void removeUser(Integer id);
}

