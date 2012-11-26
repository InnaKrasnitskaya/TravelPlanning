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
	
	private static final String ProfileSelect = "SELECT p FROM Profile p ";
	private static final String ProfileOrder = "ORDER BY creationDate DESC";
	private static final String ProfileIdCondition = " where idProfile=%d";
	
    @Autowired
    private SessionFactory sessionFactory;	
	
    @SuppressWarnings("unchecked")
	public List<Profile> getList() {
        return sessionFactory.getCurrentSession().
        		createQuery(ProfileSelect.concat(ProfileOrder)).list();		
	}
    
    public void add(Profile profile) {
    	sessionFactory.getCurrentSession().save(profile);
    }
    
    public void update(Profile profile) {
    	sessionFactory.getCurrentSession().update(profile);
    }    
    
    public void remove(Integer id) {
        Profile profile = (Profile) sessionFactory.
        		getCurrentSession().load(Profile.class, id);
        if (null != profile) {
          sessionFactory.getCurrentSession().delete(profile);
        }    	
    }
    
    public Profile findById(Integer id) {
        return (Profile) sessionFactory.getCurrentSession().createQuery(
        		ProfileSelect.concat(String.format(ProfileIdCondition, id))).uniqueResult();    	
    }
    
}
