package org.travelplan.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.travelplan.constant.Constant;
import org.travelplan.entity.Currency;
import org.travelplan.entity.Profile;
import org.travelplan.service.CurrencyService;
import org.travelplan.service.ProfileService;
import org.travelplan.service.UserService;

@Named
@Scope("session")
public class ProfileBean  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//dataTable for getting row number in JSF
	private HtmlDataTable dataTable;
	private Profile profile;
	//public static final Logger log = Logger.getLogger(ProfileBean.class);
	
	@Inject
	private CurrencyService currencyService;
	
	@Inject
	private ProfileService profileService;
	
	@Inject
	private UserService userService;
	
	public Profile getProfile() {
		if (profile == null){
			profile = new Profile();
			profile.setCurrency(new Currency());
			profile.setCurrency(currencyService.findByValue("USD"));
		}	
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	public String add() {
    	try {
    		profile.setUser(userService.findById(Constant.getIdCurrentUser()));
    		profile.setCurrency(currencyService.findByValue(profile.getCurrency().getValue()));
    		profile.setCreationDate(new Date());
    		profileService.add(profile);
    	}
    	catch (DataAccessException e) {
    		e.printStackTrace();    	
    	}
    	return "profile?faces-redirect=true";
	}
	
	public void update() {
		profile.setCurrency(currencyService.findByValue(profile.getCurrency().getValue()));
		profileService.update(profile);		
	}
	
	public String getTravelPage(Integer idProfile) {
		profile = profileService.findById(idProfile);		
		return "travel?faces-redirect=true"; //&id=#{profile.idProfile}
	}
	
	public String clearData() {
		return "profile?faces-redirect=true";
	}
	
	public HtmlDataTable getDataTable() {  
		 return dataTable;  
	}  
		  
	public void setDataTable(HtmlDataTable dataTable){  
		this.dataTable = dataTable;  
	} 
		
	public List<Profile> getList() {
		//log.debug("GETTING PROFILE LIST");
		return profileService.getList();
	}
}
