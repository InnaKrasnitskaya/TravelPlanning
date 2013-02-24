package org.travelplan.bean;

//http://www.javacodegeeks.com/2012/04/jsf-2-primefaces-3-spring-3-hibernate-4.html

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.travelplan.constant.Constant;
import org.travelplan.entity.User;
import org.travelplan.entity.UserRole;
import org.travelplan.messagesource.MessagesSource;
import org.travelplan.service.RoleService;
import org.travelplan.service.UserRoleService;
import org.travelplan.service.UserService;

@Named
@Scope("session") //JSR-330 standart
public class UserBean  implements Serializable {

	private static final long serialVersionUID = 1L;
	private User user;
	private String secondPassword;
		
	@Inject
    private UserService userService;
	
	@Inject
	private RoleService roleService;
	
	@Inject
	private UserRoleService userRoleService;	
	
	@Inject
	private MessagesSource messagesSource;
	
	public User getUser() {
		if (user == null)
			user = new User();
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String addUser() {
    	try {
    		userService.add(user);
    		addUserRole(user, Constant.UserRoles.USER);
    	}
    	catch (DataAccessException e) {
    		e.printStackTrace();    	
    	}
    	return "login?faces-redirect=true";
	}
	
	private void addUserRole(User user, Constant.UserRoles userRoles) {
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(roleService.getRole(userRoles));
		userRoleService.add(userRole);		
	}	
    
    public void setPassword (FacesContext context, UIComponent component, Object value)  
    		throws ValidatorException {
    	secondPassword = value.toString(); //For checkPassword method
    }
    
    public void checkPassword (FacesContext context, UIComponent component, Object value)  
    		throws ValidatorException {
    	if (!value.toString().equals(secondPassword)) {
    		FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);           
            message.setDetail(messagesSource.getLocaleValue("registration.differentPassword", null));
            context.addMessage(component.getClientId(), message);
            throw new ValidatorException(message);
    	}    		
    }
    
    public void checkLogin(FacesContext context, UIComponent component, Object value)
    		throws ValidatorException {
    	if (userService.findByName(value.toString()) != null) {
       		FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);           
            message.setDetail(messagesSource.getLocaleValue("registration.exist.user", null));
            context.addMessage(component.getClientId(), message);    	
        	throw new ValidatorException(message);
    	}
    }
    
	public String getSecondPassword() {
		return secondPassword;
	}

	public void setSecondPassword(String secondPassword) {
		this.secondPassword = secondPassword;
	}	
}