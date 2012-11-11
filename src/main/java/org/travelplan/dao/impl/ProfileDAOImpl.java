package org.travelplan.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.travelplan.dao.ProfileDAO;
import org.travelplan.entity.Profile;

@Repository("profileDAO")
@Transactional
public class ProfileDAOImpl implements ProfileDAO {
	
    @Autowired
    private SessionFactory sessionFactory;	
	
    @SuppressWarnings("unchecked")
	public List<Profile> listProfile() {
        return sessionFactory.getCurrentSession().createQuery("SELECT " +
                "p FROM Profile p").list();		
	}
    
    public void addProfile(Profile profile) {
    	sessionFactory.getCurrentSession().save(profile);
    }
    
    public void removeProfile(Integer id) {
        Profile profile = (Profile) sessionFactory.
        		getCurrentSession().load(Profile.class, id);
        if (null != profile) {
          sessionFactory.getCurrentSession().delete(profile);
        }    	
    }
}
