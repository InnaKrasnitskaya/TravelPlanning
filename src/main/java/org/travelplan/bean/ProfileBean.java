package org.travelplan.bean;

import java.util.Date;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.travelplan.constant.Constant;
import org.travelplan.entity.Profile;
import org.travelplan.service.CurrencyService;
import org.travelplan.service.ProfileService;
import org.travelplan.service.UserService;

@Named
@Scope("session")
public class ProfileBean {
	
	private String name;
	private HtmlDataTable dataTable;
	private Date startDate;
	private Date endDate;
	private Integer idProfile;
	private Profile updatedProfile;
	private Integer peopleCount;
	private float price;
	private String currencyValue;

	@Inject
	private CurrencyService currencyService;
	
	@Inject
	private ProfileService profileService;
	
	@Inject
	private UserService userService;
	
	public ProfileBean() {
		currencyValue = "USD";
	}
	
	public Integer getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(Integer idProfile) {
		this.idProfile = idProfile;
	}	

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
	
	private void setData(Profile profile, Boolean isAdd) {
		profile.setName(name);
		profile.setUser(userService.findById(Constant.getIdCurrentUser()));
		profile.setPeopleCount(peopleCount);
		profile.setPrice(price);
		profile.setCurrency(currencyService.findByValue(currencyValue));
		if (isAdd)
			profile.setCreationDate(new Date());
		profile.setStartDate(startDate);
		profile.setEndDate(endDate);		
	}
	
	public String add() {
    	try {
    		Profile profile = new Profile();
    		setData(profile, true);
    		profileService.add(profile);
    	}
    	catch (DataAccessException e) {
    		e.printStackTrace();    	
    	}
    	return "profile?faces-redirect=true";
	}
	
	public void update() {
		setData(updatedProfile, false);
		profileService.update(updatedProfile);		
	}
	
	public String getTravelPage(Integer idProfile) {
		this.idProfile = idProfile; 
		updatedProfile = profileService.findById(idProfile);		
		name = updatedProfile.getName();
		peopleCount = updatedProfile.getPeopleCount();
		price = updatedProfile.getPrice();
	    currencyValue = updatedProfile.getCurrency().getValue();
		startDate = updatedProfile.getStartDate();
		endDate = updatedProfile.getEndDate();
		return "travel?faces-redirect=true"; //&id=#{profile.idProfile}
	}
	
	public String clearData() {
		/*name = "";
		startDate = null;
		endDate = null;	*/	
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

	public Integer getPeopleCount() {
		return peopleCount;
	}

	public void setPeopleCount(Integer peopleCount) {
		this.peopleCount = peopleCount;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCurrencyValue() {
		return currencyValue;
	}

	public void setCurrencyValue(String currencyValue) {
		this.currencyValue = currencyValue;
	}	
		   
}
