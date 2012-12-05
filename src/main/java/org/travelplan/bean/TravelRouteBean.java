package org.travelplan.bean;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.travelplan.entity.TravelRoute;
import org.travelplan.service.CityService;
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
	private CityService cityService;
	
	private Integer idProfile;
	private Integer idAddedCity;

	public Integer getIdAddedCity() {
		return idAddedCity;
	}

	public void setIdAddedCity(Integer idAddedCity) {
		this.idAddedCity = idAddedCity;
	}

	public Integer getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(Integer idProfile) {
		this.idProfile = idProfile;
	}
	
	public List<TravelRoute> findByIdProfile() {
		return travelRouteService.findByIdProfile(profileBean.getIdProfile());
	}	
	
	public void add() {
		TravelRoute travelRoute = new TravelRoute();
		travelRoute.setProfile(profileService.findById(idProfile));
		travelRoute.setCity(cityService.findById(idAddedCity));
		travelRouteService.add(travelRoute);
	}
}
