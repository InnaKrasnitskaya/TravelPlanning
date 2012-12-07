package org.travelplan.service;

import java.util.List;

import org.travelplan.entity.Place;

public interface PlaceService {
	public void add(Place profile);
    public List<Place> getList();
    public void remove(Integer id);
    public void update(Place Place);
    public Place findById(Integer id);
}
