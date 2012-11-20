package org.travelplan.managedBean;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.travelplan.entity.User;
import org.travelplan.service.UserService;

@Named
@Scope("session") //JSR-330 standart
public class UserManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;
	private String email;
	private String secondPassword;
	
	@Inject
    private UserService userService;
	   
    public String addUser() {
    	try {
    		User user = new User();
    		user.setName(name);
    		user.setPassword(password);		
    		user.setEmail(email);
    		userService.addUser(user);
    	}
    	catch (DataAccessException e) {
    		e.printStackTrace();    	
    	}
    	return "login?faces-redirect=true";
    }
    
    public void checkPassword (FacesContext context, UIComponent component, Object value)  
    		throws ValidatorException {
    	
    }
    
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
    
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}    
	
	public String getSecondPassword() {
		return secondPassword;
	}

	public void setSecondPassword(String secondPassword) {
		this.secondPassword = secondPassword;
	}	
}

//http://www.javacodegeeks.com/2012/04/jsf-2-primefaces-3-spring-3-hibernate-4.html