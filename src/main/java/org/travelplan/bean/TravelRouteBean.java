package org.travelplan.bean;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import org.travelplan.entity.Place;
import org.travelplan.entity.TravelRoute;
import org.travelplan.service.PlaceService;
import org.travelplan.service.ProfileService;
import org.travelplan.service.TravelRouteService;

@Named
@Scope("session")
public class TravelRouteBean {

	@Inject
	private TravelRouteService travelRouteService;
	
	@Inject
	private ProfileBean profileBean;
	
	@Inject
	private ProfileService profileService;
	
	@Inject
	private PlaceService placeService;
	
	private float latitude;
	private float longitude;
	private String placeName;
	
	public TravelRouteBean() {
		latitude = 53.9f;
		longitude = 27.566667f;
	}
	
	private Integer getIdProfile() {
		return profileBean.getIdProfile();
	}	
	
	public List<TravelRoute> findByIdProfile() {
		return travelRouteService.findByIdProfile(getIdProfile());
	}	
	
	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	
	private Place getPlace() {
		Place place = placeService.findByCoordinates(latitude, longitude);
		if (place == null) {			
			place = new Place();
			place.setLatitude(latitude);
			place.setLongitude(longitude);
			place.setName(placeName);
			placeService.add(place);
		}
		return place;
	}

	public void add() {
		TravelRoute travelRoute = new TravelRoute();
		travelRoute.setProfile(profileService.findById(getIdProfile()));
		travelRoute.setPlace(getPlace());
		travelRoute.setRouteOrder(travelRouteService.getNextOrderNumber(getIdProfile()));
		travelRouteService.add(travelRoute);
	}
	
	public void moveUp(Integer idTravelRoute) {
		travelRouteService.moveUp(idTravelRoute);
	}
	
	public void moveDown(Integer idTravelRoute) {
		travelRouteService.moveDown(idTravelRoute);
	}	
}
