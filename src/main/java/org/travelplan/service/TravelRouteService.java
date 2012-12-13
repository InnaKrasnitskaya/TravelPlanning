package org.travelplan.service;

import java.util.List;

import org.travelplan.entity.TravelRoute;

public interface TravelRouteService extends CommonService<TravelRoute>{
    public List<TravelRoute> findByIdProfile(Integer id);
    public Integer getNextOrderNumber(Integer idProfile);
    public void moveUp(Integer idTravelRoute);
    public void moveDown(Integer idTravelRoute);
}
