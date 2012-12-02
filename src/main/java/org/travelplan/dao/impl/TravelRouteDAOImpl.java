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
    
}
