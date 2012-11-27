package org.travelplan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "\"TravelRoute\"")
public class TravelRoute {

    @Id
    @Column(name = "\"IdTravelRoute\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer idTravelRoute;
    
    @ManyToOne
	@JoinColumn(name="\"IdProfile\"")
    private Profile profile; 
    
    @ManyToOne
	@JoinColumn(name="\"IdCity\"")
    private City city;
    
    @Column(name = "\"RouteOrder\"")
    private Integer routeOrder;

	public Integer getIdTravelRoute() {
		return idTravelRoute;
	}

	public void setIdTravelRoute(Integer idTravelRoute) {
		this.idTravelRoute = idTravelRoute;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Integer getRouteOrder() {
		return routeOrder;
	}

	public void setRouteOrder(Integer routeOrder) {
		this.routeOrder = routeOrder;
	}
    
    
}
