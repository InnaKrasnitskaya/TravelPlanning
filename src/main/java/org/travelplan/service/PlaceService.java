package org.travelplan.service;

import org.travelplan.entity.Place;

public interface PlaceService extends CommonService<Place> {
    public Place findByCoordinates(Float latitude, Float longitude);
}
