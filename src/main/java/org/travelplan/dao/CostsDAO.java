package org.travelplan.dao;

import java.util.List;
import org.travelplan.entity.Costs;

public interface CostsDAO extends CommonDAO<Costs> {
    public List<Costs> findByTravelRoute(Integer idTravelRoute);    
	public Float getSumTravelRoute(String currency, Integer idTravelRoute);
	public Float getSum(String currency, Integer idProfile);
}
