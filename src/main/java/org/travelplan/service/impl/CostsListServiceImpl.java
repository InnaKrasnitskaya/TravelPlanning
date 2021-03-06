package org.travelplan.service.impl;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.travelplan.dao.CostsListDAO;
import org.travelplan.entity.CostsList;
import org.travelplan.service.CostsListService;

@Service
public class CostsListServiceImpl implements CostsListService{
	
	@Inject
	private CostsListDAO costsListDAO;
	
	public void add(CostsList costsList) {
		costsListDAO.add(costsList);
	}
	
	public Integer getId(String name) {
		return costsListDAO.getId(name);
	}

	public List<CostsList> getList() {
		return costsListDAO.getList();
	}

	public void remove(Integer id) {
		costsListDAO.remove(id);		
	}

	public void update(CostsList obj) {
		costsListDAO.update(obj);		
	}

	public CostsList findById(Integer id) {
		return costsListDAO.findById(id);
	}
}
