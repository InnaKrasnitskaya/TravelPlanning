package org.travelplan.service.impl;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.travelplan.dao.ProfileDAO;
import org.travelplan.entity.Profile;
import org.travelplan.service.ProfileService;

//@Service("profileService")
@Component
@ManagedBean
@SessionScoped
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private ProfileDAO profileDAO;
    
    @Transactional
    public List<Profile> getListProfile() {
        return profileDAO.listProfile();
    }  
    
    public void addProfile(Profile profile) {
    	profileDAO.addProfile(profile);
    }
    
    //http://www.mkyong.com/jsf2/jsf-2-0-spring-hibernate-integration-example/
}
