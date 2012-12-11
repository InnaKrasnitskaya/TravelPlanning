package org.travelplan.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.travelplan.dao.TravelRouteDAO;
import org.travelplan.entity.TravelRoute;

@Repository("travelRouteDAO")
@Transactional
public class TravelRouteDAOImpl implements TravelRouteDAO {
	private static final String TravelRouteSelect = "SELECT tr FROM TravelRoute tr";
	private static final String IdProfileOrder = " ORDER BY idProfile";
	private static final String IdTravelRouteCondition = " WHERE idTravelRoute=%d";
	private static final String IdProfileCondition = " JOIN tr.profile p WHERE p.idProfile=%d ORDER BY tr.routeOrder";
	private static final String IdOrderCondition = " JOIN tr.profile p WHERE p.idProfile=%d AND tr.routeOrder=%d";
	private static final String MaxOrderSelect = "SELECT MAX(tr.routeOrder) FROM TravelRoute tr JOIN tr.profile p" +
		" WHERE p.idProfile=%d";	
	
    @Autowired
    private SessionFactory sessionFactory;	
	
    @SuppressWarnings("unchecked")
	public List<TravelRoute> getList() {
        return sessionFactory.getCurrentSession().
        		createQuery(TravelRouteSelect.concat(IdProfileOrder)).list();		
	}
    
    public void add(TravelRoute travelRoute) {
    	sessionFactory.getCurrentSession().save(travelRoute);
    }
    
    public void update(TravelRoute travelRoute) {
    	sessionFactory.getCurrentSession().update(travelRoute);
    }    
    
    public void remove(Integer id) {
    	TravelRoute travelRoute = (TravelRoute) sessionFactory.
        	getCurrentSession().load(TravelRoute.class, id);
        if (null != travelRoute) {
          sessionFactory.getCurrentSession().delete(travelRoute);
        }    	
    }
    
    @SuppressWarnings("unchecked")
    public List<TravelRoute> findByIdProfile(Integer id) {
        return sessionFactory.getCurrentSession().createQuery(
        		TravelRouteSelect.concat(String.format(IdProfileCondition, id))).list();   
    }
    
    public TravelRoute findById(Integer id) {
        return (TravelRoute)sessionFactory.getCurrentSession().createQuery(
        		TravelRouteSelect.concat(String.format(IdTravelRouteCondition, id))).uniqueResult();       	
    }
    
    public Integer getNextOrderNumber(Integer idProfile) {
    	Integer nextOrder = (Integer)sessionFactory.getCurrentSession().createQuery(
    		String.format(MaxOrderSelect, idProfile)).uniqueResult();
    	if (nextOrder == null)
    		nextOrder = new Integer(0);
        return nextOrder + 1; 
    }
    
    private TravelRoute findByOrder(Integer idProfile, Integer routeOrder) {
        return (TravelRoute)sessionFactory.getCurrentSession().createQuery(
        		TravelRouteSelect.concat(String.format(IdOrderCondition, idProfile, routeOrder))).uniqueResult();      	
    }
    
    public void moveUp(Integer idTravelRoute) {
    	TravelRoute travelRouteUp = findById(idTravelRoute);
    	if (travelRouteUp.getRouteOrder() != 1) {
        	TravelRoute travelRouteDown = findByOrder(travelRouteUp.getProfile().getIdProfile(),
        		travelRouteUp.getRouteOrder() - 1);   	    	
            travelRouteUp.setRouteOrder(travelRouteUp.getRouteOrder() - 1);
            travelRouteDown.setRouteOrder(travelRouteDown.getRouteOrder() + 1);   	
            update(travelRouteUp);
            update(travelRouteDown);    		
    	}
    }
    
    public void moveDown(Integer idTravelRoute) {
    	TravelRoute travelRouteDown = findById(idTravelRoute);
    	if (travelRouteDown.getRouteOrder() != getNextOrderNumber(travelRouteDown.getProfile().getIdProfile()) - 1) {
        	TravelRoute travelRouteUp = findByOrder(travelRouteDown.getProfile().getIdProfile(),
        		travelRouteDown.getRouteOrder() + 1);   	    	
            travelRouteDown.setRouteOrder(travelRouteDown.getRouteOrder() + 1);
            travelRouteUp.setRouteOrder(travelRouteUp.getRouteOrder() - 1);   	
            update(travelRouteUp);
            update(travelRouteDown);    		
    	}
    }    
}
