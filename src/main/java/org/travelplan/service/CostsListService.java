package org.travelplan.service;

import org.travelplan.entity.CostsList;

public interface CostsListService {
	public void add(CostsList costsList);
	public Integer getId(String name);
}
