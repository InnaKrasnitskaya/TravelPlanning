package org.travelplan.dao;

import java.util.List;
import org.travelplan.entity.Place;

public interface PlaceDAO {
	public void add(Place Place);
    public List<Place> getList();
    public void remove(Integer id);
    public void update(Place Place);
    public Place findById(Integer id);
    public Place findByCoordinates(Float latitude, Float longitude);
}
