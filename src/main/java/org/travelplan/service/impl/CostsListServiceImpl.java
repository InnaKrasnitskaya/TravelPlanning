package org.travelplan.service.impl;

import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import org.travelplan.dao.CostsListDAO;
import org.travelplan.entity.CostsList;
import org.travelplan.service.CostsListService;

@Named
@Scope("session")
public class CostsListServiceImpl implements CostsListService{
	
	@Inject
	private CostsListDAO costsListDAO;
	
	public void add(CostsList costsList) {
		costsListDAO.add(costsList);
	}
	
	public Integer getId(String name) {
		return costsListDAO.getId(name);
	}
}
