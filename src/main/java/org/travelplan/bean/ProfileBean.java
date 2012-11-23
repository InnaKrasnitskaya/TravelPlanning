package org.travelplan.bean;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.travelplan.constant.Constant;
import org.travelplan.entity.Profile;
import org.travelplan.service.ProfileService;
import org.travelplan.service.UserService;

@Named
@Scope("session")
public class ProfileBean {
	
	private String name;
	
	@Inject
	private ProfileService profileService;
	
	@Inject
	private UserService userService;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String addProfile() {
    	try {
    		Profile profile = new Profile();
    		profile.setName(name);
    		profile.setUser(userService.findById(Constant.getIdCurrentUser()));
    		
    		profileService.addProfile(profile);
    	}
    	catch (DataAccessException e) {
    		e.printStackTrace();    	
    	}
    	return "profile?faces-redirect=true";
	}
}
