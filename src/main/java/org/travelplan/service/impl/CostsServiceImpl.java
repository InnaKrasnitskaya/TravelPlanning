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
    
    public void add(Costs Costs) {
    	CostsDAO.add(Costs);
    }
    
    public void remove(Integer id) {
    	CostsDAO.remove(id);
    }
    
    public void update(Costs Costs) {
    	CostsDAO.update(Costs);
    }
    
    public List<Costs> findByTravelRoute(Integer idTravelRoute) {
    	List<Costs> var = CostsDAO.findByTravelRoute(idTravelRoute);
    	var.add(new Costs());
    	return var;
    }
}
