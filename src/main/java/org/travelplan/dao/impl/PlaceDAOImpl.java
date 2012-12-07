package org.travelplan.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.travelplan.dao.PlaceDAO;
import org.travelplan.entity.Place;

@Repository("PlaceDAO")
@Transactional
public class PlaceDAOImpl implements PlaceDAO {
	
	private static final String PlaceSelect = "SELECT p FROM Place p ";
	private static final String PlaceOrder = "ORDER BY name DESC";
	private static final String PlaceIdCondition = " WHERE idPlace=%d";
	
    @Autowired
    private SessionFactory sessionFactory;	
	
    @SuppressWarnings("unchecked")
	public List<Place> getList() {
        return sessionFactory.getCurrentSession().
        		createQuery(PlaceSelect.concat(PlaceOrder)).list();		
	}
    
    public void add(Place Place) {
    	sessionFactory.getCurrentSession().save(Place);
    }
    
    public void update(Place Place) {
    	sessionFactory.getCurrentSession().update(Place);
    }    
    
    public void remove(Integer id) {
        Place Place = (Place) sessionFactory.
        		getCurrentSession().load(Place.class, id);
        if (null !=Place) {
          sessionFactory.getCurrentSession().delete(Place);
        }    	
    }
    
    public Place findById(Integer id) {
        return (Place) sessionFactory.getCurrentSession().createQuery(
        		PlaceSelect.concat(String.format(PlaceIdCondition, id))).uniqueResult();    	
    }
}
