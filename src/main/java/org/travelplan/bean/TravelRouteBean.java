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
	//view-source:http://gmaps-samples.googlecode.com/svn/trunk/streetview/streetview_directions.html	
	private TravelRoute travelRoute;
	
	@Inject
	private TravelRouteService travelRouteService;
	
	@Inject
	private ProfileBean profileBean;
	
	@Inject
	private ProfileService profileService;
	
	@Inject
	private PlaceService placeService;
	
	private boolean routeView; //route view mode
	
	public TravelRouteBean() {
		getTravelRoute().getPlace().setLatitude(53.9f);
		getTravelRoute().getPlace().setLongitude(27.566667f);
	}
	
	public TravelRoute getTravelRoute() {
		if (travelRoute == null) {
		  travelRoute = new TravelRoute();	
		  travelRoute.setPlace(new Place());		
		}
		return travelRoute;
	}

	public void setTravelRoute(TravelRoute travelRoute) {
		this.travelRoute = travelRoute;
	}

	private Integer getIdProfile() {
		return profileBean.getIdProfile();
	}	
	
	public List<TravelRoute> findByIdProfile() {
		return travelRouteService.findByIdProfile(getIdProfile());
	}	
	
	public boolean isRouteView() {
		return routeView;
	}

	public void setRouteView(boolean routeView) {
		  if (findByIdProfile().size() == 0)
			  this.routeView = false;
		  else
			  this.routeView = routeView;
	}	

	public void add() {
		travelRoute.setProfile(profileService.findById(getIdProfile()));
		if (placeService.findByCoordinates(travelRoute.getPlace().getLatitude(), 
				travelRoute.getPlace().getLongitude()) == null) {			
			placeService.add(travelRoute.getPlace());
		}
		travelRoute.setRouteOrder(travelRouteService.getNextOrderNumber(getIdProfile()));
		travelRouteService.add(travelRoute);
	}
	
	public void moveUp(Integer idTravelRoute) {
		travelRouteService.moveUp(idTravelRoute);
	}
	
	public void moveDown(Integer idTravelRoute) {
		travelRouteService.moveDown(idTravelRoute);
	}	
	
	public String getOrigin() {
		if (findByIdProfile().size() > 0)
		  return findByIdProfile().get(0).getPlace().getName();
		else
		  return "";
	}
	
	public String getDestination() {
		if (findByIdProfile().size() > 0)
		  return findByIdProfile().get(findByIdProfile().size() - 1).getPlace().getName();
			else
		  return "";		
	}
	
	public void remove(Integer id) {
		travelRouteService.remove(id);
	}
	
	/*public DirectionsWaypoint getWaypoint() {
		DirectionsWaypoint waypoint = DirectionsWaypoint.create();
		waypoint.setLocation("Vitebsk");
		return waypoint;
	}*/
	
}
