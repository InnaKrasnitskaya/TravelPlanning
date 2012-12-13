package org.travelplan.service;

import org.travelplan.entity.CostsList;

public interface CostsListService extends CommonService<CostsList>  {
	public Integer getId(String name);
}
