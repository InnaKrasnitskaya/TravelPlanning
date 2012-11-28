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
	
	private int pageNumber = 1;
	
	/*private Integer idProfile;

	public Integer getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(Integer idProfile) {
		this.idProfile = idProfile;
	}*/
	
	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	public List<TravelRoute> findByIdProfile(Integer id) {
		return travelRouteService.findByIdProfile(id);
	}	
	
	public void click() {
		pageNumber = 2;
	}
	
}
