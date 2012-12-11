package org.travelplan.dao;

import org.travelplan.entity.Place;

public interface PlaceDAO extends CommonDAO<Place> {
    public Place findByCoordinates(Float latitude, Float longitude);
}
