package org.travelplan.dao;

import org.travelplan.entity.CostsList;

public interface CostsListDAO extends CommonDAO<CostsList> {
	public Integer getId(String name);
}
