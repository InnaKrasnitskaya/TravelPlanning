package org.travelplan.managedBean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.travelplan.entity.User;
import org.travelplan.service.UserService;

@Component
@ManagedBean
@SessionScoped
public class UserManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;
	
	@Autowired
    private UserService userService;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    public String addUser() {
    	try {
    		User user = new User();
    		user.setName(name);
    		user.setPassword(password);		
    		userService.addUser(user);
    	}
    	catch (DataAccessException e) {
    		e.printStackTrace();    	
    	}
    	return "addProfile";
    }
}


//http://www.javacodegeeks.com/2012/04/jsf-2-primefaces-3-spring-3-hibernate-4.html