package org.travelplan.dao;

import java.util.List;
import org.travelplan.entity.Costs;

public interface CostsDAO {
	public void add(Costs costs);
    public List<Costs> getList();
    public void remove(Integer id);
    public void update(Costs costs);
    public List<Costs> findByTravelRoute(Integer idTravelRoute);
    public Costs findById(Integer id);
}
