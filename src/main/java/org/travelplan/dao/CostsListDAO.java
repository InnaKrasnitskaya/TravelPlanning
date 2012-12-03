package org.travelplan.dao;

import org.travelplan.entity.CostsList;

public interface CostsListDAO {
	public void add(CostsList costsList);
	public Integer findByName(String name);
}
