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
    private CostsDAO CostsDAO;
    
    public List<Costs> getList() {
        return CostsDAO.getList();
    }  
    
    public void add(Costs costs) {
    	CostsDAO.add(costs);
    }
    
    public void remove(Integer id) {
    	CostsDAO.remove(id);
    }
    
    public void update(Costs Costs) {
    	CostsDAO.update(Costs);
    }
    
    public List<Costs> findByTravelRoute(Integer idTravelRoute) {
    	List<Costs> listCosts = CostsDAO.findByTravelRoute(idTravelRoute);
    	listCosts.add(new Costs()); //reserve place for add data
    	return listCosts;
    }
    
    public Costs findById(Integer id) {
    	return CostsDAO.findById(id);
    }
}
