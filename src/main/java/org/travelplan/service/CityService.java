package org.travelplan.service;

import java.util.List;

import org.travelplan.entity.City;

public interface CityService {
	public void add(City profile);
    public List<City> getList();
    public void remove(Integer id);
    public void update(City city);
    public City findById(Integer id);
}
