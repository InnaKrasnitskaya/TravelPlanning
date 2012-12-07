package org.travelplan.dao;

import java.util.List;
import org.travelplan.entity.TravelRoute;

public interface TravelRouteDAO {
	public void add(TravelRoute travelRoute);
    public List<TravelRoute> getList();
    public void remove(Integer id);
    public void update(TravelRoute travelRoute);
    public List<TravelRoute> findByIdProfile(Integer id);
    public TravelRoute findById(Integer id);
    public Integer getNextOrderNumber(Integer idProfile);
    public void moveUp(Integer idTravelRoute);
    public void moveDown(Integer idTravelRoute);
}
