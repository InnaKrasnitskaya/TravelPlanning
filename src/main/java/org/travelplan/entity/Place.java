package org.travelplan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"Place\"")
public class Place {

    @Id
    @Column(name = "\"IdPlace\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer idPlace;
    
	@Column(name = "\"Name\"")
    private String name;
	
	@Column(name = "\"CityName\"")
    private String cityName;
	
	@Column(name = "\"Latitude\"")
	private Float latitude;
	
	@Column(name = "\"Longitude\"")
	private Float longitude; 
	
	public Place() {}
	
	public Integer getIdPlace() {
		return idPlace;
	}

	public void setIdPlace(Integer idPlace) {
		this.idPlace = idPlace;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
		
}
