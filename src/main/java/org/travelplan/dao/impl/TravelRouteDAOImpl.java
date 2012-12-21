package org.travelplan.dao.impl;

import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.travelplan.dao.TravelRouteDAO;
import org.travelplan.entity.TravelRoute;

@Repository("travelRouteDAO")
@Transactional
public class TravelRouteDAOImpl extends CommonDAOImpl<TravelRoute> implements TravelRouteDAO {
	
	public TravelRouteDAOImpl() {
		super(TravelRoute.class);
	}
    
    @SuppressWarnings("unchecked")
    public List<TravelRoute> findByIdProfile(Integer id) {
    	return getSession().createCriteria(TravelRoute.class).
    			createAlias("profile", "pr").
    			add(Restrictions.eq("pr.idProfile", id)).
    			addOrder(Order.asc("routeOrder")).
    			list();
    }   
 
    public Integer getNextOrderNumber(Integer idProfile) {
    	Integer nextOrder = (Integer) getSession().createCriteria(TravelRoute.class).
    			createAlias("profile", "pr").
    			setProjection(Projections.max("routeOrder")).
    			add(Restrictions.eq("pr.idProfile", idProfile)).
    			uniqueResult();
    	if (nextOrder == null)
    		nextOrder = new Integer(0);
        return nextOrder + 1; 
    }
    
 /*   private TravelRoute findByOrder(Integer idProfile, Integer routeOrder) {
        return (TravelRoute) getSession().createCriteria(TravelRoute.class).
        		createAlias("profile", "pr").
        		add(Restrictions.eq("pr.idProfile", idProfile)).
        		add(Restrictions.eq("routeOrder", routeOrder)).uniqueResult();
    }*/
    
    private TravelRoute findByNextOrder(Integer idProfile, Integer routeOrder) {
        return (TravelRoute) getSession().createCriteria(TravelRoute.class).
        		createAlias("profile", "pr").
        		add(Restrictions.eq("pr.idProfile", idProfile)).
        		add(Restrictions.gt("routeOrder", routeOrder)).
        		addOrder(Order.asc("routeOrder")).
        		list().get(0);
    }    
    
    private TravelRoute findByPrevOrder(Integer idProfile, Integer routeOrder) {
        return (TravelRoute) getSession().createCriteria(TravelRoute.class).
        		createAlias("profile", "pr").
        		add(Restrictions.eq("pr.idProfile", idProfile)).
        		add(Restrictions.lt("routeOrder", routeOrder)).
        		addOrder(Order.desc("routeOrder")).
        		list().get(0);
    }        
    
    public void moveUp(Integer idTravelRoute) {
    	TravelRoute travelRouteUp = findById(idTravelRoute);
    	int upOrder = travelRouteUp.getRouteOrder();
    			
    	if (travelRouteUp.getRouteOrder() != 1) {
        	TravelRoute travelRouteDown = findByPrevOrder(travelRouteUp.getProfile().getIdProfile(),
        	  upOrder);   	    	
            travelRouteUp.setRouteOrder(travelRouteDown.getRouteOrder());
            travelRouteDown.setRouteOrder(upOrder);   	
            update(travelRouteUp);
            update(travelRouteDown);    		
    	}
    }
    
    public void moveDown(Integer idTravelRoute) {    	
    	TravelRoute travelRouteDown = findById(idTravelRoute);
    	int downOrder = travelRouteDown.getRouteOrder();
    	
    	if (downOrder != getNextOrderNumber(travelRouteDown.getProfile().getIdProfile()) - 1) {
        	TravelRoute travelRouteUp = findByNextOrder(travelRouteDown.getProfile().getIdProfile(),
        		downOrder);         	
            travelRouteDown.setRouteOrder(travelRouteUp.getRouteOrder());
            travelRouteUp.setRouteOrder(downOrder);   	
            update(travelRouteUp);
            update(travelRouteDown);    		
    	}
    }   
    
}
