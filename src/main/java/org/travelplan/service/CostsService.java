package org.travelplan.service;

import java.util.List;
import org.travelplan.entity.Costs;

public interface CostsService extends CommonService<Costs> {
	public List<Costs> findByTravelRoute(Integer idTravelRoute);
	public Float getSumTravelRoute(String currency, Integer idTravelRoute);
	public Float getSum(String currency, Integer idProfile);	
}
