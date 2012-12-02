package org.travelplan.service;

import java.util.List;

import org.travelplan.entity.TravelRoute;

public interface TravelRouteService {
	public void add(TravelRoute travelRoute);
    public List<TravelRoute> getList();
    public void remove(Integer id);
    public void update(TravelRoute travelRoute);
    public List<TravelRoute> findByIdProfile(Integer id);
    public TravelRoute findById(Integer id);
}
