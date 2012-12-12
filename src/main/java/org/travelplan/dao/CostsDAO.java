package org.travelplan.dao;

import java.util.List;
import org.travelplan.entity.Costs;

public interface CostsDAO extends CommonDAO<Costs> {
    public List<Costs> findByTravelRoute(Integer idTravelRoute);    
}
