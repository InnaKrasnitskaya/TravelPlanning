package org.travelplan.bean;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.travelplan.entity.TravelRoute;
import org.travelplan.service.TravelRouteService;

@Named
@Scope("session")
public class TravelRouteBean {

	@Inject
	private TravelRouteService travelRouteService;
	
	@Inject
	private ProfileBean profileBean;
	
	private Integer idProfile;

	public Integer getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(Integer idProfile) {
		this.idProfile = idProfile;
	}
	
	public List<TravelRoute> findByIdProfile() {
		return travelRouteService.findByIdProfile(profileBean.getIdProfile());
	}	
	
	
}
