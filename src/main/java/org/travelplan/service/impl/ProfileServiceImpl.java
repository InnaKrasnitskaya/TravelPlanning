package org.travelplan.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.travelplan.dao.ProfileDAO;
import org.travelplan.entity.Profile;
import org.travelplan.service.ProfileService;

@Service("profileService")
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private ProfileDAO profileDAO;
    
    @Transactional
    public List<Profile> listProfile() {
        return profileDAO.listProfile();
    }  
    
    public void addProfile(Profile profile) {
    	profileDAO.addProfile(profile);
    }
    
    //http://www.mkyong.com/jsf2/jsf-2-0-spring-hibernate-integration-example/
}
