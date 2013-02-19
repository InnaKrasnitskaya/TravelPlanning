package org.travelplan.service.impl;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.travelplan.dao.PlaceDAO;
import org.travelplan.entity.Place;
import org.travelplan.service.PlaceService;

@Service
public class PlaceServiceImpl implements PlaceService {

	@Inject
    private PlaceDAO PlaceDAO;
    
    public List<Place> getList() {
        return PlaceDAO.getList();
    }  
    
    public void add(Place Place) {
    	PlaceDAO.add(Place);
    }
    
    public void remove(Integer id) {
    	PlaceDAO.remove(id);
    }
    
    public void update(Place Place) {
    	PlaceDAO.update(Place);
    }
    
    public Place findById(Integer id) {
    	return PlaceDAO.findById(id);
    }
  
    public Place findByCoordinates(Float latitude, Float longitude) {
    	return PlaceDAO.findByCoordinates(latitude, longitude);
    }
}
