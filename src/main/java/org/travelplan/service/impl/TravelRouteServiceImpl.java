package org.travelplan.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import org.travelplan.dao.TravelRouteDAO;
import org.travelplan.entity.TravelRoute;
import org.travelplan.service.TravelRouteService;

@Named
@Scope("session")
public class TravelRouteServiceImpl implements TravelRouteService {
	
	@Inject
	private TravelRouteDAO travelRouteDAO;
	
	public void add(TravelRoute travelRoute) {
		travelRouteDAO.add(travelRoute);
	}
	
    public List<TravelRoute> getList() {
    	return travelRouteDAO.getList();
    }
    
    public void remove(Integer id) {
    	travelRouteDAO.remove(id);
    }
    
    public void update(TravelRoute travelRoute) {
    	travelRouteDAO.update(travelRoute);
    }
    
    public List<TravelRoute> findByIdProfile(Integer id) {
    	return travelRouteDAO.findByIdProfile(id);
    }
    
    public TravelRoute findById(Integer id) {
    	return travelRouteDAO.findById(id);
    }
    
    public Integer getNextOrderNumber(Integer idProfile) {
    	return travelRouteDAO.getNextOrderNumber(idProfile);
    }
    
    public void moveUp(Integer idTravelRoute) {
    	travelRouteDAO.moveUp(idTravelRoute);
    }
    
    public void moveDown(Integer idTravelRoute) {
    	travelRouteDAO.moveDown(idTravelRoute);
    }
}
