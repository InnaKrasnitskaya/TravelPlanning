package org.travelplan.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import org.travelplan.dao.CostsDAO;
import org.travelplan.entity.Costs;
import org.travelplan.service.CostsService;

@Named
@Scope("session")
public class CostsServiceImpl implements CostsService {	
	
	@Inject
    private CostsDAO costsDAO;
    
	 public List<Costs> getList() {
        return costsDAO.getList();
    }  
    
    public void add(Costs costs) {
    	costsDAO.add(costs);
    }
    
    public void remove(Integer id) {
    	costsDAO.remove(id);
    }
    
    public void update(Costs Costs) {
    	costsDAO.update(Costs);
    }
    
   
    public Costs findById(Integer id) {
    	return costsDAO.findById(id);
    }

	public List<Costs> findByTravelRoute(Integer idTravelRoute) {
		return costsDAO.findByTravelRoute(idTravelRoute); 	
    }	
	
	public Float getSumTravelRoute(String currency, Integer idTravelRoute) {
		return costsDAO.getSumTravelRoute(currency, idTravelRoute);
	}
	
	public Float getSum(String currency, Integer idProfile) {
		return costsDAO.getSum(currency, idProfile);
	}

}
