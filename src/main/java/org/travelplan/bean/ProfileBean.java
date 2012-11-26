package org.travelplan.bean;

import java.util.Date;

import javax.faces.component.html.HtmlDataTable;
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
	private HtmlDataTable dataTable;
	private Date startDate;
	private Date endDate;
	
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
	
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}	
	
	public String addProfile() {
    	try {
    		Profile profile = new Profile();
    		profile.setName(name);
    		profile.setUser(userService.findById(Constant.getIdCurrentUser()));
    		profile.setCreationDate(new Date());
    		profile.setStartDate(startDate);
    		profile.setEndDate(endDate);
    		profileService.addProfile(profile);
    	}
    	catch (DataAccessException e) {
    		e.printStackTrace();    	
    	}
    	return "profile?faces-redirect=true";
	}
	
	public HtmlDataTable getDataTable() {  
		 return dataTable;  
	}  
		  
	public void setDataTable(HtmlDataTable dataTable){  
		this.dataTable = dataTable;  
	} 
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
		   
}
