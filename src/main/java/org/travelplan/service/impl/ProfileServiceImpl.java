package org.travelplan.service.impl;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.travelplan.dao.ProfileDAO;
import org.travelplan.entity.Profile;
import org.travelplan.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService{
	
	@Inject
    private ProfileDAO profileDAO;

    public List<Profile> getList() {
        return profileDAO.getList(false, "creationDate");
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
