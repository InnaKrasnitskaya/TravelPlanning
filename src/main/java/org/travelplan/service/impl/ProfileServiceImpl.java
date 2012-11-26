package org.travelplan.service.impl;

import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.travelplan.dao.ProfileDAO;
import org.travelplan.entity.Profile;
import org.travelplan.service.ProfileService;

@Named
@Scope("session")
public class ProfileServiceImpl implements ProfileService{
	
	//dataTable for getting row number in JSF
	private HtmlDataTable dataTable;

    public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	@Autowired
    private ProfileDAO profileDAO;
    
    public List<Profile> getList() {
        return profileDAO.getList();
    }  
    
    public void add(Profile profile) {
    	profileDAO.add(profile);
    }
    
    public void remove(Integer id) {
    	profileDAO.remove(id);
    }
    
    public void update(Profile profile) {
    	profileDAO.update(profile);
    }
    
    public Profile findById(Integer id) {
    	return profileDAO.findById(id);
    }
    
    //http://www.mkyong.com/jsf2/jsf-2-0-spring-hibernate-integration-example/
}
