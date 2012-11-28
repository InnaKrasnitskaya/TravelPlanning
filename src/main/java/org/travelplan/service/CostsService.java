package org.travelplan.service;

import java.util.List;
import org.travelplan.entity.Costs;

public interface CostsService {
	public void add(Costs costs);
    public List<Costs> getList();
    public void remove(Integer id);
    public void update(Costs costs);
    public List<Costs> findByTravelRoute(int idTravelRoute);
}
