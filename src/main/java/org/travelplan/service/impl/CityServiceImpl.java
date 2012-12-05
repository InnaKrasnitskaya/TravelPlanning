package org.travelplan.service.impl;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import org.travelplan.dao.CityDAO;
import org.travelplan.entity.City;
import org.travelplan.service.CityService;

@Named
@Scope("session")
public class CityServiceImpl implements CityService {

	@Inject
    private CityDAO cityDAO;
    
    public List<City> getList() {
        return cityDAO.getList();
    }  
    
    public void add(City City) {
    	cityDAO.add(City);
    }
    
    public void remove(Integer id) {
    	cityDAO.remove(id);
    }
    
    public void update(City City) {
    	cityDAO.update(City);
    }
    
    public City findById(Integer id) {
    	return cityDAO.findById(id);
    }
}
