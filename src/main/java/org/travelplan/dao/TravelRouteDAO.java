package org.travelplan.dao;

import java.util.List;
import org.travelplan.entity.TravelRoute;

public interface TravelRouteDAO extends CommonDAO<TravelRoute> {
    public List<TravelRoute> findByIdProfile(Integer id);
    public Integer getNextOrderNumber(Integer idProfile);
    public void moveUp(Integer idTravelRoute);
    public void moveDown(Integer idTravelRoute);
}
