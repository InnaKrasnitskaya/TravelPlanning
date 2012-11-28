package org.travelplan.service.impl;

import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import org.travelplan.dao.CostsDAO;
import org.travelplan.entity.Costs;
import org.travelplan.service.CostsService;

@Named
@Scope("session")
public class CostsServiceImpl implements CostsService {
	
	//dataTable for getting row number in JSF
	private HtmlDataTable dataTable;

    public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

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
    
    public List<Costs> findByTravelRoute(int idTravelRoute) {
    	return CostsDAO.findByTravelRoute(idTravelRoute);
    }
}
