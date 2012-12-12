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
    
    private TravelRoute findByOrder(Integer idProfile, Integer routeOrder) {
        return (TravelRoute) getSession().createCriteria(TravelRoute.class).
        		createAlias("profile", "pr").
        		add(Restrictions.eq("pr.idProfile", idProfile)).
        		add(Restrictions.eq("routeOrder", routeOrder)).uniqueResult();
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
